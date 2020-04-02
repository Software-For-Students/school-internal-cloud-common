package com.github.softwareforstudents.schoolinternalcloud.common.id;

import java.time.Instant;

public class Identifier {
    
    // custom epoch starting at 2020/01/01-00:00:00
    public final static long CUSTOM_EPOCH = 1577836800000L;
    
    // identifier layout (64bit long):
    //
    //  unused  |          custom epoch timestamp      |        | worker id | increment per id 
    // sign bit |                                      | service id |       | in same millisecond
    //      | 0 | 00000000000000000000000000000000000000000 | 00000 | 00000 | 000000000000 |
    //
    //      1 bit                  41 bits                   5 bits  5 bits     12 bits
    // max. value                (~69 years)                  (32)    (32)      (4096)

    final static int TIMESTAMP_BITS = 41;
    final static int SERVICE_ID_BITS = 5;
    final static int WORKER_ID_BITS = 5;
    final static int INCREMENT_BITS = 12;

    final static long MAX_INCREMENT = (1L << INCREMENT_BITS) - 1;

    private final long timestamp;
    private final int serviceId;
    private final int workerId;
    private final long increment;

    protected Identifier(final long timestamp, final int serviceId, final int workerId, final long increment) {
        this.timestamp = timestamp;
        this.serviceId = serviceId;
        this.workerId = workerId;
        this.increment = increment;
    }

    private Identifier(final long customEpochTimestamp, final long serviceId, final long workerId, final long increment) {
        this(customEpochTimestamp + CUSTOM_EPOCH, (int) serviceId, (int) workerId, increment);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Instant getTimestampAsInstant() {
        return Instant.ofEpochMilli(timestamp);
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public long getIncrement() {
        return increment;
    }

    public long getIdentifier() {
        return (timestamp - Identifier.CUSTOM_EPOCH) << (Identifier.SERVICE_ID_BITS + Identifier.WORKER_ID_BITS + Identifier.INCREMENT_BITS)
            | (serviceId << (Identifier.WORKER_ID_BITS + Identifier.INCREMENT_BITS)) 
            | (workerId << (Identifier.INCREMENT_BITS)) 
            | increment;
    }

    public long getId() {
        return getIdentifier();
    }

    @Override
    public String toString() {
        return new StringBuffer("SIC-Identifier[timestamp=").append(timestamp)
            .append("|serviceId=").append(serviceId)
            .append("|workerId=").append(workerId)
            .append("|increment=").append(increment)
            .append("]").toString();
    }

    public static Identifier parseIdentifier(long id) {
        return new Identifier(
            ((1L << TIMESTAMP_BITS) - 1) & (id >> INCREMENT_BITS + WORKER_ID_BITS + SERVICE_ID_BITS),
            ((1L << SERVICE_ID_BITS) - 1) & (id >> INCREMENT_BITS + WORKER_ID_BITS),
            ((1L << WORKER_ID_BITS) - 1) & (id >> INCREMENT_BITS),
            ((1L << INCREMENT_BITS) - 1) & id);
    }
}