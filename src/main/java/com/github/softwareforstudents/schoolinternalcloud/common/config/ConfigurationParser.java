package com.github.softwareforstudents.schoolinternalcloud.common.config;

public interface ConfigurationParser<T> {

    public Configuration parse(T parsingValue);

    static Object getOptimalObject(String valueString) {
        try {
            return Integer.parseInt(valueString);
        } catch (NumberFormatException ex) {
            try {
                return Float.parseFloat(valueString);
            } catch (NumberFormatException ex2) {
                if (valueString.equalsIgnoreCase("true") || valueString.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(valueString);
                }
                return valueString;
            }
        }
    }

}