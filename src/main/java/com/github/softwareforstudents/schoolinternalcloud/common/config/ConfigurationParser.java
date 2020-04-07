package com.github.softwareforstudents.schoolinternalcloud.common.config;

public interface ConfigurationParser<T> {

    final static String BOOLEAN_TRUE = "true";
    final static String BOOLEAN_FALSE = "false";

    public Configuration parse(T parsingValue);

    static Object getOptimalObject(String valueString) {
        try {
            return Integer.parseInt(valueString);
        } catch (NumberFormatException ex) {
            try {
                return Float.parseFloat(valueString);
            } catch (NumberFormatException ex2) {
                if (valueString.equalsIgnoreCase(BOOLEAN_TRUE) || valueString.equalsIgnoreCase(BOOLEAN_FALSE)) {
                    return Boolean.parseBoolean(valueString);
                }
                return valueString;
            }
        }
    }

}