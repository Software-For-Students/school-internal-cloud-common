package com.github.softwareforstudents.schoolinternalcloud.common.service;

import java.util.stream.Stream;

public enum Service {

    DEFAULT(0),
    USER(1);

    private final int id;

    private Service(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Service getServiceById(final int id) {
        return Stream.of(Service.values()).filter(service -> service.getId() == id).findAny().orElse(DEFAULT);
    }
}