package com.github.softwareforstudents.schoolinternalcloud.common.config;

import java.io.File;
import java.io.FileFilter;

public class ConfigurationFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return (pathname.getName().endsWith(".jsonc") || pathname.getName().endsWith(".json"));
    }

}