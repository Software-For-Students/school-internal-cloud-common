package com.github.softwareforstudents.schoolinternalcloud.common.web.shared;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.Immutable;
import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;

public final class ServiceIdentifier {

    private String serviceName;
    private int serviceId;
    private int workerId;

    public ServiceIdentifier(@NotNull String serviceName, int serviceId, int workerId) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.workerId = workerId;
    }

    @Immutable
    public String getServiceName() {
        return String.valueOf(serviceName);
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String toJsonString() {
        return new StringBuffer("{\"serviceName\":\"").append(getServiceName())
            .append("\",\"serviceId\":\"").append(getServiceId())
            .append("\",\"workerId\":\"").append(getWorkerId())
            .append("\"}").toString();
    }

    @Override
    public String toString() {
        return new StringBuffer("[ServiceName]: ").append(getServiceName()).append(System.lineSeparator())
                .append("[ServiceId]: ").append(getServiceId()).append(System.lineSeparator())
                .append("[WorkerId]: ").append(getWorkerId()).toString();
    }

}