// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecoveryRoll.proto

package com.dp.blackhole.protocol.control;

public final class RecoveryRollPB {
  private RecoveryRollPB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface RecoveryRollOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string topic = 1;
    /**
     * <code>required string topic = 1;</code>
     */
    boolean hasTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    java.lang.String getTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    com.google.protobuf.ByteString
        getTopicBytes();

    // required string broker_server = 2;
    /**
     * <code>required string broker_server = 2;</code>
     */
    boolean hasBrokerServer();
    /**
     * <code>required string broker_server = 2;</code>
     */
    java.lang.String getBrokerServer();
    /**
     * <code>required string broker_server = 2;</code>
     */
    com.google.protobuf.ByteString
        getBrokerServerBytes();

    // required int64 roll_ts = 3;
    /**
     * <code>required int64 roll_ts = 3;</code>
     */
    boolean hasRollTs();
    /**
     * <code>required int64 roll_ts = 3;</code>
     */
    long getRollTs();

    // required int32 recovery_port = 4;
    /**
     * <code>required int32 recovery_port = 4;</code>
     */
    boolean hasRecoveryPort();
    /**
     * <code>required int32 recovery_port = 4;</code>
     */
    int getRecoveryPort();

    // optional string instance_id = 5;
    /**
     * <code>optional string instance_id = 5;</code>
     */
    boolean hasInstanceId();
    /**
     * <code>optional string instance_id = 5;</code>
     */
    java.lang.String getInstanceId();
    /**
     * <code>optional string instance_id = 5;</code>
     */
    com.google.protobuf.ByteString
        getInstanceIdBytes();

    // optional bool is_final = 6;
    /**
     * <code>optional bool is_final = 6;</code>
     */
    boolean hasIsFinal();
    /**
     * <code>optional bool is_final = 6;</code>
     */
    boolean getIsFinal();

    // optional bool is_persist = 7 [default = true];
    /**
     * <code>optional bool is_persist = 7 [default = true];</code>
     */
    boolean hasIsPersist();
    /**
     * <code>optional bool is_persist = 7 [default = true];</code>
     */
    boolean getIsPersist();
  }
  /**
   * Protobuf type {@code blackhole.RecoveryRoll}
   */
  public static final class RecoveryRoll extends
      com.google.protobuf.GeneratedMessage
      implements RecoveryRollOrBuilder {
    // Use RecoveryRoll.newBuilder() to construct.
    private RecoveryRoll(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private RecoveryRoll(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final RecoveryRoll defaultInstance;
    public static RecoveryRoll getDefaultInstance() {
      return defaultInstance;
    }

    public RecoveryRoll getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private RecoveryRoll(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              topic_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              brokerServer_ = input.readBytes();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              rollTs_ = input.readInt64();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              recoveryPort_ = input.readInt32();
              break;
            }
            case 42: {
              bitField0_ |= 0x00000010;
              instanceId_ = input.readBytes();
              break;
            }
            case 48: {
              bitField0_ |= 0x00000020;
              isFinal_ = input.readBool();
              break;
            }
            case 56: {
              bitField0_ |= 0x00000040;
              isPersist_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dp.blackhole.protocol.control.RecoveryRollPB.internal_static_blackhole_RecoveryRoll_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dp.blackhole.protocol.control.RecoveryRollPB.internal_static_blackhole_RecoveryRoll_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll.class, com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll.Builder.class);
    }

    public static com.google.protobuf.Parser<RecoveryRoll> PARSER =
        new com.google.protobuf.AbstractParser<RecoveryRoll>() {
      public RecoveryRoll parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RecoveryRoll(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<RecoveryRoll> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string topic = 1;
    public static final int TOPIC_FIELD_NUMBER = 1;
    private java.lang.Object topic_;
    /**
     * <code>required string topic = 1;</code>
     */
    public boolean hasTopic() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          topic_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string broker_server = 2;
    public static final int BROKER_SERVER_FIELD_NUMBER = 2;
    private java.lang.Object brokerServer_;
    /**
     * <code>required string broker_server = 2;</code>
     */
    public boolean hasBrokerServer() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string broker_server = 2;</code>
     */
    public java.lang.String getBrokerServer() {
      java.lang.Object ref = brokerServer_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          brokerServer_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string broker_server = 2;</code>
     */
    public com.google.protobuf.ByteString
        getBrokerServerBytes() {
      java.lang.Object ref = brokerServer_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        brokerServer_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required int64 roll_ts = 3;
    public static final int ROLL_TS_FIELD_NUMBER = 3;
    private long rollTs_;
    /**
     * <code>required int64 roll_ts = 3;</code>
     */
    public boolean hasRollTs() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required int64 roll_ts = 3;</code>
     */
    public long getRollTs() {
      return rollTs_;
    }

    // required int32 recovery_port = 4;
    public static final int RECOVERY_PORT_FIELD_NUMBER = 4;
    private int recoveryPort_;
    /**
     * <code>required int32 recovery_port = 4;</code>
     */
    public boolean hasRecoveryPort() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required int32 recovery_port = 4;</code>
     */
    public int getRecoveryPort() {
      return recoveryPort_;
    }

    // optional string instance_id = 5;
    public static final int INSTANCE_ID_FIELD_NUMBER = 5;
    private java.lang.Object instanceId_;
    /**
     * <code>optional string instance_id = 5;</code>
     */
    public boolean hasInstanceId() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional string instance_id = 5;</code>
     */
    public java.lang.String getInstanceId() {
      java.lang.Object ref = instanceId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          instanceId_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string instance_id = 5;</code>
     */
    public com.google.protobuf.ByteString
        getInstanceIdBytes() {
      java.lang.Object ref = instanceId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        instanceId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional bool is_final = 6;
    public static final int IS_FINAL_FIELD_NUMBER = 6;
    private boolean isFinal_;
    /**
     * <code>optional bool is_final = 6;</code>
     */
    public boolean hasIsFinal() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional bool is_final = 6;</code>
     */
    public boolean getIsFinal() {
      return isFinal_;
    }

    // optional bool is_persist = 7 [default = true];
    public static final int IS_PERSIST_FIELD_NUMBER = 7;
    private boolean isPersist_;
    /**
     * <code>optional bool is_persist = 7 [default = true];</code>
     */
    public boolean hasIsPersist() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>optional bool is_persist = 7 [default = true];</code>
     */
    public boolean getIsPersist() {
      return isPersist_;
    }

    private void initFields() {
      topic_ = "";
      brokerServer_ = "";
      rollTs_ = 0L;
      recoveryPort_ = 0;
      instanceId_ = "";
      isFinal_ = false;
      isPersist_ = true;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasTopic()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasBrokerServer()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasRollTs()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasRecoveryPort()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getTopicBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getBrokerServerBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt64(3, rollTs_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(4, recoveryPort_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, getInstanceIdBytes());
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeBool(6, isFinal_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        output.writeBool(7, isPersist_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getTopicBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getBrokerServerBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, rollTs_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, recoveryPort_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, getInstanceIdBytes());
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(6, isFinal_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(7, isPersist_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code blackhole.RecoveryRoll}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRollOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.dp.blackhole.protocol.control.RecoveryRollPB.internal_static_blackhole_RecoveryRoll_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.dp.blackhole.protocol.control.RecoveryRollPB.internal_static_blackhole_RecoveryRoll_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll.class, com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll.Builder.class);
      }

      // Construct using com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        topic_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        brokerServer_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        rollTs_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        recoveryPort_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        instanceId_ = "";
        bitField0_ = (bitField0_ & ~0x00000010);
        isFinal_ = false;
        bitField0_ = (bitField0_ & ~0x00000020);
        isPersist_ = true;
        bitField0_ = (bitField0_ & ~0x00000040);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dp.blackhole.protocol.control.RecoveryRollPB.internal_static_blackhole_RecoveryRoll_descriptor;
      }

      public com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll getDefaultInstanceForType() {
        return com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll.getDefaultInstance();
      }

      public com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll build() {
        com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll buildPartial() {
        com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll result = new com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.topic_ = topic_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.brokerServer_ = brokerServer_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.rollTs_ = rollTs_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.recoveryPort_ = recoveryPort_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.instanceId_ = instanceId_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000020;
        }
        result.isFinal_ = isFinal_;
        if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
          to_bitField0_ |= 0x00000040;
        }
        result.isPersist_ = isPersist_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll) {
          return mergeFrom((com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll other) {
        if (other == com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll.getDefaultInstance()) return this;
        if (other.hasTopic()) {
          bitField0_ |= 0x00000001;
          topic_ = other.topic_;
          onChanged();
        }
        if (other.hasBrokerServer()) {
          bitField0_ |= 0x00000002;
          brokerServer_ = other.brokerServer_;
          onChanged();
        }
        if (other.hasRollTs()) {
          setRollTs(other.getRollTs());
        }
        if (other.hasRecoveryPort()) {
          setRecoveryPort(other.getRecoveryPort());
        }
        if (other.hasInstanceId()) {
          bitField0_ |= 0x00000010;
          instanceId_ = other.instanceId_;
          onChanged();
        }
        if (other.hasIsFinal()) {
          setIsFinal(other.getIsFinal());
        }
        if (other.hasIsPersist()) {
          setIsPersist(other.getIsPersist());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasTopic()) {
          
          return false;
        }
        if (!hasBrokerServer()) {
          
          return false;
        }
        if (!hasRollTs()) {
          
          return false;
        }
        if (!hasRecoveryPort()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.dp.blackhole.protocol.control.RecoveryRollPB.RecoveryRoll) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string topic = 1;
      private java.lang.Object topic_ = "";
      /**
       * <code>required string topic = 1;</code>
       */
      public boolean hasTopic() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public java.lang.String getTopic() {
        java.lang.Object ref = topic_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          topic_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTopicBytes() {
        java.lang.Object ref = topic_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          topic_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopic(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder clearTopic() {
        bitField0_ = (bitField0_ & ~0x00000001);
        topic_ = getDefaultInstance().getTopic();
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopicBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }

      // required string broker_server = 2;
      private java.lang.Object brokerServer_ = "";
      /**
       * <code>required string broker_server = 2;</code>
       */
      public boolean hasBrokerServer() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string broker_server = 2;</code>
       */
      public java.lang.String getBrokerServer() {
        java.lang.Object ref = brokerServer_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          brokerServer_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string broker_server = 2;</code>
       */
      public com.google.protobuf.ByteString
          getBrokerServerBytes() {
        java.lang.Object ref = brokerServer_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          brokerServer_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string broker_server = 2;</code>
       */
      public Builder setBrokerServer(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        brokerServer_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string broker_server = 2;</code>
       */
      public Builder clearBrokerServer() {
        bitField0_ = (bitField0_ & ~0x00000002);
        brokerServer_ = getDefaultInstance().getBrokerServer();
        onChanged();
        return this;
      }
      /**
       * <code>required string broker_server = 2;</code>
       */
      public Builder setBrokerServerBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        brokerServer_ = value;
        onChanged();
        return this;
      }

      // required int64 roll_ts = 3;
      private long rollTs_ ;
      /**
       * <code>required int64 roll_ts = 3;</code>
       */
      public boolean hasRollTs() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required int64 roll_ts = 3;</code>
       */
      public long getRollTs() {
        return rollTs_;
      }
      /**
       * <code>required int64 roll_ts = 3;</code>
       */
      public Builder setRollTs(long value) {
        bitField0_ |= 0x00000004;
        rollTs_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 roll_ts = 3;</code>
       */
      public Builder clearRollTs() {
        bitField0_ = (bitField0_ & ~0x00000004);
        rollTs_ = 0L;
        onChanged();
        return this;
      }

      // required int32 recovery_port = 4;
      private int recoveryPort_ ;
      /**
       * <code>required int32 recovery_port = 4;</code>
       */
      public boolean hasRecoveryPort() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required int32 recovery_port = 4;</code>
       */
      public int getRecoveryPort() {
        return recoveryPort_;
      }
      /**
       * <code>required int32 recovery_port = 4;</code>
       */
      public Builder setRecoveryPort(int value) {
        bitField0_ |= 0x00000008;
        recoveryPort_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 recovery_port = 4;</code>
       */
      public Builder clearRecoveryPort() {
        bitField0_ = (bitField0_ & ~0x00000008);
        recoveryPort_ = 0;
        onChanged();
        return this;
      }

      // optional string instance_id = 5;
      private java.lang.Object instanceId_ = "";
      /**
       * <code>optional string instance_id = 5;</code>
       */
      public boolean hasInstanceId() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional string instance_id = 5;</code>
       */
      public java.lang.String getInstanceId() {
        java.lang.Object ref = instanceId_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          instanceId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string instance_id = 5;</code>
       */
      public com.google.protobuf.ByteString
          getInstanceIdBytes() {
        java.lang.Object ref = instanceId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          instanceId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string instance_id = 5;</code>
       */
      public Builder setInstanceId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        instanceId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string instance_id = 5;</code>
       */
      public Builder clearInstanceId() {
        bitField0_ = (bitField0_ & ~0x00000010);
        instanceId_ = getDefaultInstance().getInstanceId();
        onChanged();
        return this;
      }
      /**
       * <code>optional string instance_id = 5;</code>
       */
      public Builder setInstanceIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        instanceId_ = value;
        onChanged();
        return this;
      }

      // optional bool is_final = 6;
      private boolean isFinal_ ;
      /**
       * <code>optional bool is_final = 6;</code>
       */
      public boolean hasIsFinal() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>optional bool is_final = 6;</code>
       */
      public boolean getIsFinal() {
        return isFinal_;
      }
      /**
       * <code>optional bool is_final = 6;</code>
       */
      public Builder setIsFinal(boolean value) {
        bitField0_ |= 0x00000020;
        isFinal_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool is_final = 6;</code>
       */
      public Builder clearIsFinal() {
        bitField0_ = (bitField0_ & ~0x00000020);
        isFinal_ = false;
        onChanged();
        return this;
      }

      // optional bool is_persist = 7 [default = true];
      private boolean isPersist_ = true;
      /**
       * <code>optional bool is_persist = 7 [default = true];</code>
       */
      public boolean hasIsPersist() {
        return ((bitField0_ & 0x00000040) == 0x00000040);
      }
      /**
       * <code>optional bool is_persist = 7 [default = true];</code>
       */
      public boolean getIsPersist() {
        return isPersist_;
      }
      /**
       * <code>optional bool is_persist = 7 [default = true];</code>
       */
      public Builder setIsPersist(boolean value) {
        bitField0_ |= 0x00000040;
        isPersist_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool is_persist = 7 [default = true];</code>
       */
      public Builder clearIsPersist() {
        bitField0_ = (bitField0_ & ~0x00000040);
        isPersist_ = true;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:blackhole.RecoveryRoll)
    }

    static {
      defaultInstance = new RecoveryRoll(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:blackhole.RecoveryRoll)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_blackhole_RecoveryRoll_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_blackhole_RecoveryRoll_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022RecoveryRoll.proto\022\tblackhole\"\235\001\n\014Reco" +
      "veryRoll\022\r\n\005topic\030\001 \002(\t\022\025\n\rbroker_server" +
      "\030\002 \002(\t\022\017\n\007roll_ts\030\003 \002(\003\022\025\n\rrecovery_port" +
      "\030\004 \002(\005\022\023\n\013instance_id\030\005 \001(\t\022\020\n\010is_final\030" +
      "\006 \001(\010\022\030\n\nis_persist\030\007 \001(\010:\004trueB3\n!com.d" +
      "p.blackhole.protocol.controlB\016RecoveryRo" +
      "llPB"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_blackhole_RecoveryRoll_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_blackhole_RecoveryRoll_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_blackhole_RecoveryRoll_descriptor,
              new java.lang.String[] { "Topic", "BrokerServer", "RollTs", "RecoveryPort", "InstanceId", "IsFinal", "IsPersist", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
