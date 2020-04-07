package com.github.softwareforstudents.schoolinternalcloud.common.config;

import java.util.HashMap;
import java.util.Map;

public class CommandlineConfigurationParser implements ConfigurationParser<String[]> {

    // commandline format:
    // SERVICE_NAME.jar option1=value option2=value option3
    // option3 is equal to option3=true

    @Override
    public Configuration parse(String[] parsingValue) {
        Map<String, Object> configuration = new HashMap<>();

        for (String option : parsingValue) {
            int signIndex = option.indexOf("=");

            if (signIndex == -1) {
                configuration.put(option, true);
                continue;
            }

            String key = option.substring(0, signIndex);
            String valueString = option.substring(signIndex + 1);

            configuration.put(key, ConfigurationParser.getOptimalObject(valueString));
        }

        return new Configuration(configuration);
    }
}