package com.dp.blackhole.consumer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

import com.dianping.lion.client.LionException;

public class Consumer {
    public static final FetchedDataChunk SHUTDOWN_COMMAND = new FetchedDataChunk(null, null, -1);
    
    private LinkedBlockingQueue<FetchedDataChunk> queue;
    
    private String topic;
    private String group;
    private String consumerId;
    private ConsumerConfig config;
    
    public Consumer(String topic, String group, ConsumerConfig config) throws LionException {
        ConsumerConnector connector = ConsumerConnector.getInstance();
        if (!connector.initialized) {
            connector.init();
        }
        this.topic = topic;
        this.group = group;
        this.config = config;
        consumerId = generateConsumerId(this.group);
        queue = new LinkedBlockingQueue<FetchedDataChunk>(this.config.getMaxQueuedChunks());
        connector.registerConsumer(topic, group, consumerId ,this);
    }
    
    LinkedBlockingQueue<FetchedDataChunk> getDataQueue() {
        return queue;
    }
    
    public void clearQueue() {
        queue.clear();   
    }
    
    public void shutdown() throws InterruptedException {
        queue.put(SHUTDOWN_COMMAND);
    }
    
    public String getTopic() {
		return topic;
	}

	public String getGroup() {
		return group;
	}

	public String getConsumerId() {
		return consumerId;
	}
    
    public ConsumerConfig getConf() {
        return config;
    }

    public MessageStream getStream() {
        return new MessageStream(topic, queue, config.getConsumerTimeoutMs());
    }

    /**
     * generate random consumerid ( hostname-currenttime-uuid.sub(8) )
     *
     * @return random consumerid
     */
    private String generateConsumerId(String group) {
        UUID uuid = UUID.randomUUID();
        try {
            return group + "-" + InetAddress.getLocalHost().getHostName() + "-"
                    + System.currentTimeMillis() + "-"
                    + Long.toHexString(uuid.getMostSignificantBits()).substring(0, 8);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(
                    "can not generate consume id by auto, set the 'consumerid' parameter to fix this");
        }
    }
}