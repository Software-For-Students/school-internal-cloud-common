package com.github.softwareforstudents.schoolinternalcloud.common.service;

import java.nio.file.Paths;

import com.github.softwareforstudents.schoolinternalcloud.common.config.CommandlineConfigurationParser;
import com.github.softwareforstudents.schoolinternalcloud.common.config.Configuration;
import com.github.softwareforstudents.schoolinternalcloud.common.config.FileConfigurationParser;

public class SicService {

    private final static String CONFIG_PATH = "/config/";

    private final static String SERVICE_NAME_CONFIG_KEY = "serviceName";
    private final static String SERVICE_NAME_DEFAULT = "Default Service";

    private final static String SERVICE_ID_CONFIG_KEY = "serviceId";
    private final static int SERVICE_ID_DEFAULT = 0;

    private final static String WORKER_ID_CONFIG_KEY = "workerId";
    private final static int WORKER_ID_DEFAULT = 0;

    private final ServiceIdentifier serviceIdentifier;
    private final Configuration configuration;

    public SicService(final String[] cmdArgs) {
        this.configuration = new FileConfigurationParser().parse(Paths.get(".", CONFIG_PATH));
        this.configuration.join(new CommandlineConfigurationParser().parse(cmdArgs));

        this.serviceIdentifier = new ServiceIdentifier(
                (String) configuration.getConfigurationValue(SERVICE_NAME_CONFIG_KEY).orElse(SERVICE_NAME_DEFAULT),
                (int) configuration.getConfigurationValue(SERVICE_ID_CONFIG_KEY).orElse(SERVICE_ID_DEFAULT),
                (int) configuration.getConfigurationValue(WORKER_ID_CONFIG_KEY).orElse(WORKER_ID_DEFAULT));
    }

    public ServiceIdentifier getServiceIdentifier() {
        return serviceIdentifier;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}