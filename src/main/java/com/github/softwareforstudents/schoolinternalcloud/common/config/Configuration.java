package com.github.softwareforstudents.schoolinternalcloud.common.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.Immutable;
import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;

public class Configuration {

    private Map<String, Object> configuration;

    public Configuration() {
        this(new HashMap<>());
    }

    public Configuration(final Map<String, Object> configuration) {
        this.configuration = configuration;
    }

    @Immutable
    public Map<String, Object> getAllEntries() {
        return Map.copyOf(configuration);
    }

    public Optional<Object> getConfigurationValue(@NotNull final String key) {
        return Optional.ofNullable(configuration.get(key));
    }

    public void setConfigurationValue(@NotNull final String key, @NotNull final Object value) {
        if (value instanceof String && ((String) value).isEmpty()) {
            return;
        }

        configuration.put(key, value);
    }

    public void join(@NotNull final Configuration other) {
        configuration.putAll(other.getAllEntries());
    }

}