package com.dp.blackhole.consumer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dianping.lion.EnvZooKeeperConfig;
import com.dianping.lion.client.ConfigCache;
import com.dianping.lion.client.LionException;
import com.dp.blackhole.common.PBwrap;
import com.dp.blackhole.common.gen.AssignConsumerPB.AssignConsumer;
import com.dp.blackhole.common.gen.AssignConsumerPB.AssignConsumer.PartitionOffset;
import com.dp.blackhole.common.gen.MessagePB.Message;
import com.dp.blackhole.common.gen.MessagePB.Message.MessageType;
import com.dp.blackhole.network.EntityProcessor;
import com.dp.blackhole.network.GenClient;
import com.dp.blackhole.network.HeartBeat;
import com.dp.blackhole.network.SimpleConnection;
import com.google.protobuf.InvalidProtocolBufferException;

public class ConsumerConnector implements Runnable {
    private final Log LOG = LogFactory.getLog(ConsumerConnector.class);
    
    private static ConsumerConnector instance = new ConsumerConnector();
    
    public static ConsumerConnector getInstance() {
        return instance;
    }
    
    public volatile boolean initialized = false;
    
    // consumerIdString->[fetcherrunable1, fetcherrunable2]
    private Map<String, List<FetcherRunnable>> consumerThreadsMap;
    // registered consumers
    private ConcurrentHashMap<String, Consumer> consumers;   
    private final ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);

    private GenClient<ByteBuffer, SimpleConnection, ConsumerProcessor> client;
    private ConsumerProcessor processor;
	private SimpleConnection supervisor;
    private String supervisorHost;
    private int supervisorPort;
    private boolean autoCommit;
    private int autoCommitIntervalMs;
    
    private Map<String, ConsumerConfig> configMap = Collections.synchronizedMap(new HashMap<String, ConsumerConfig>());
    
    private ConsumerConnector() {
    }
    
    public synchronized void init() throws LionException {
        ConfigCache configCache = ConfigCache.getInstance(EnvZooKeeperConfig.getZKAddress());
        String host = configCache.getProperty("blackhole.supervisor.host");
        int port = configCache.getIntProperty("blackhole.supervisor.port");
        init(host, port, true, 3000);
    }

    public synchronized void init(String supervisorHost, int supervisorPort, boolean autoCommit, int autoCommitIntervalMs) {
        if (!instance.initialized) {
            instance.initialized = true;
            instance.supervisorHost = supervisorHost;
            instance.supervisorPort = supervisorPort;
            instance.autoCommit = autoCommit;
            instance.autoCommitIntervalMs = autoCommitIntervalMs;
            
            Thread thread = new Thread(instance);
            thread.setDaemon(true);
            thread.start();
        } 
    }

    public void commitOffsets() {
        for (Entry<String, List<FetcherRunnable>> e : consumerThreadsMap.entrySet()) {
            String id = e.getKey();
            List<FetcherRunnable> fetches = e.getValue();

            for (FetcherRunnable f : fetches) {
                for (PartitionTopicInfo info : f.getpartitionInfos()) {
                    long lastChanged = info.getConsumedOffsetChanged().get();
                    if (lastChanged == 0) {
                        continue;
                    }
                    long newOffset = info.getConsumedOffset();
                    updateOffset(id , info.topic, info.partition, newOffset);
                    info.updateComsumedOffsetChanged(lastChanged);
                    LOG.debug("Committed " + info.partition + " for topic " + info.topic);
                }
            }
        }
    }
    
    @Override
    public void run() {
        consumerThreadsMap = new ConcurrentHashMap<String, List<FetcherRunnable>>();
        consumers = new ConcurrentHashMap<String, Consumer>();
        if (autoCommit) {
            LOG.info("starting auto committer every " + autoCommitIntervalMs + " ms");
            scheduler.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduler.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            scheduler.scheduleAtFixedRate(new AutoCommitTask(), autoCommitIntervalMs, 
                    autoCommitIntervalMs, TimeUnit.MILLISECONDS);
        }
        
        processor = new ConsumerProcessor();
        client = new GenClient(
                processor,
                new SimpleConnection.SimpleConnectionFactory(),
                null);
        
        Properties prop = new Properties();
        prop.setProperty("supervisor.host", supervisorHost);
        prop.setProperty("supervisor.port", Integer.toString(supervisorPort));
        try {
            client.init(prop, "consumer", "supervisor.host", "supervisor.port");
        } catch (ClosedChannelException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }


    /**
     * register consumer data to supervisor
     * @param consumer 
     */
    void registerConsumer(String topic, String group, String consumerId, Consumer consumer) {
        configMap.put(consumerId, consumer.getConf());
        consumers.put(consumerId, consumer);
        sendRegConsumer(topic, group, consumerId);
    }
    
    public void stop() throws InterruptedException {
        client.shutdown();
        scheduler.shutdown();
        for (List<FetcherRunnable> fetchers : consumerThreadsMap.values()) {
            for (FetcherRunnable f : fetchers) {
                f.shutdown();
            }
        }
        consumerThreadsMap.clear();
        configMap.clear();
        for (Consumer c : consumers.values()) {
            c.shutdown();
        }
        consumers.clear();
    }
    
    public static void shutdownNow() throws InterruptedException {
        instance.stop();
    }
    
    private void sendRegConsumer(String topic, String group, String consumerId) {
        Message message = PBwrap.wrapConsumerReg(group, consumerId, topic);
        LOG.info("register consumer to supervisor " + group + "-" + consumerId + " => " + topic);
        send(message);
    }
    
    void updateOffset(String consumerId, String topic, String partitionName, long offset) {
        Message message = PBwrap.wrapOffsetCommit(consumerId, topic, partitionName, offset);
        send(message);
    }
    
    private void send(Message message) {
    	LOG.debug("send message: " + message);
    	if (supervisor != null) {
    		supervisor.send(PBwrap.PB2Buf(message));
    	}
    }
    
    public class ConsumerProcessor implements EntityProcessor<ByteBuffer, SimpleConnection> {
    	private HeartBeat heartbeat = null;
    	
		@Override
		public void OnConnected(SimpleConnection connection) {
			supervisor = connection;
			heartbeat = new HeartBeat(supervisor);
            heartbeat.start();
		}

		@Override
		public void OnDisconnected(SimpleConnection connection) {
			LOG.info("ConsumerConnector disconnected");
			supervisor.close();
			supervisor = null;
            heartbeat.shutdown();
            heartbeat = null;
		}

		@Override
		public void process(ByteBuffer reply, SimpleConnection from) {
			Message msg = null;
            try {
                msg = PBwrap.Buf2PB(reply);
            } catch (InvalidProtocolBufferException e) {
                LOG.error("received a message can not be deserialized", e);
            }

            LOG.debug("consumer received: " + msg);         
            processInternal(msg);
		}
		
	    protected boolean processInternal(Message msg) {
	        MessageType type = msg.getType();
	        switch (type) {
	        case ASSIGN_CONSUMER:
	            AssignConsumer assign = msg.getAssignConsumer();
	            
	            if (assign.getPartitionOffsetsList().isEmpty()) {
	                LOG.info("received no PartitionOffsetsList, retry atfer 5 seconds");
	                try {
	                    Thread.sleep(5000);
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	                sendRegConsumer(assign.getTopic(), assign.getGroup(), assign.getConsumerIdString());
	                return false;
	            }
	            
	            String consumerId = assign.getConsumerIdString();
	            //First, shutdown thread and clear consumer queue.
	            List<FetcherRunnable> fetches = consumerThreadsMap.get(consumerId);
	            if (fetches != null) {
	                for (FetcherRunnable fetcherThread : fetches) {
	                    fetcherThread.shutdown();
	                }
	                consumerThreadsMap.remove(consumerId);
	            }
	            Consumer c = consumers.get(consumerId);
	            if (c != null) {
	                c.clearQueue();
	            } else {
	                LOG.fatal("unkown consumerId: " + consumerId);
	                return false;
	            }

	            //create PartitionTopicInfos and group them by broker and comsumerId
	            Map<String, List<PartitionTopicInfo>> brokerPartitionInfoMap = new HashMap<String, List<PartitionTopicInfo>>();     
	            for (PartitionOffset partitionOffset : assign.getPartitionOffsetsList()) {
	                String topic = assign.getTopic();
	                String brokerString = partitionOffset.getBrokerString();
	                String partitionName = partitionOffset.getPartitionName();
	                long offset = partitionOffset.getOffset();
	                PartitionTopicInfo info = 
	                        new PartitionTopicInfo(topic, partitionName, brokerString, offset, offset);

	                List<PartitionTopicInfo> partitionList = brokerPartitionInfoMap.get(brokerString);
	                if (partitionList == null) {
	                    partitionList = new ArrayList<PartitionTopicInfo>();
	                    brokerPartitionInfoMap.put(brokerString, partitionList);
	                }
	                partitionList.add(info);
	            }

	            //start a fetcher thread for every broker, fetcher thread contains a NIO client
	            fetches = Collections.synchronizedList(new ArrayList<FetcherRunnable>());
	            for (Map.Entry<String, List<PartitionTopicInfo>> entry : brokerPartitionInfoMap.entrySet()) {
	                String brokerString = entry.getKey();
	                List<PartitionTopicInfo> pInfoList = entry.getValue();
	                FetcherRunnable fetcherThread = new FetcherRunnable(consumerId, brokerString, pInfoList, c.getDataQueue(), configMap.get(consumerId));
	                fetches.add(fetcherThread);
	                fetcherThread.start();
	            }
	            consumerThreadsMap.put(consumerId, fetches);
	            break;
	        default:
	            LOG.error("Illegal message type " + msg.getType());
	        }
	        return true;
	    }
    }
    
    class AutoCommitTask implements Runnable {

        public void run() {
            try {
                commitOffsets();
            } catch (Throwable e) {
                LOG.error("exception during autoCommit: ", e);
            }
        }
    }
}
