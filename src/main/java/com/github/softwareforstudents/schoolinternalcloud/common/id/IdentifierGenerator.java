package com.github.softwareforstudents.schoolinternalcloud.common.id;

import java.time.Instant;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;
import com.github.softwareforstudents.schoolinternalcloud.common.service.ServiceIdentifier;

public class IdentifierGenerator {

    private final int serviceId;
    private final int workerId;

    private volatile int increment;
    private volatile long lastIncrementResetTime;

    public IdentifierGenerator(@NotNull final ServiceIdentifier serviceIdentifier) {
        this.serviceId = serviceIdentifier.getServiceId();
        this.workerId = serviceIdentifier.getWorkerId();
        this.increment = 0;
        this.lastIncrementResetTime = getTimestamp();
    }

    public synchronized long generateIdentifier() {
        long currentTime = getTimestamp();
        if (lastIncrementResetTime != currentTime) {
            increment = 0;
            lastIncrementResetTime = currentTime;
        } else {
            if (increment >= Identifier.MAX_INCREMENT) {
                lastIncrementResetTime = waitUntilNextMillisecond(currentTime);
                increment = 0;
            }
        }

        long id = new Identifier(currentTime, serviceId, workerId, increment).getIdentifier();

        increment++;
        return id;
    }

    private long getTimestamp() {
        return Instant.now().toEpochMilli();
    }

    private long waitUntilNextMillisecond(long currentTime) {
        while (currentTime == lastIncrementResetTime) {
            currentTime = getTimestamp();
        }
        return currentTime;
    }
}