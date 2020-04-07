package com.github.softwareforstudents.schoolinternalcloud.common.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class FileConfigurationParser implements ConfigurationParser<Path> {

    private final static String CONFIG_PACKAGE = "/config";
    private final static String[] DEFAULT_CONFIGFILE_NAMES = new String[] { "/database_config.jsonc",
            "/service_config.jsonc" };

    @Override
    public Configuration parse(Path parsingValue) {
        File configDirectory = parsingValue.toFile();

        if (!configDirectory.exists()) {
            configDirectory.mkdirs();
        }

        if (configDirectory.listFiles(new ConfigurationFileFilter()).length == 0) {
            copyDefaultConfig(parsingValue);
        }

        File[] configFiles = configDirectory.listFiles(new ConfigurationFileFilter());

        Configuration configuration = new Configuration();
        Gson gson = new GsonBuilder().create();

        for (File configFile : configFiles) {
            configuration.join(parseFile(configFile, gson));
        }

        return configuration;
    }

    private void copyDefaultConfig(Path path) {
        for (String filename : DEFAULT_CONFIGFILE_NAMES) {
            try {
                Path targetFile = Path.of(path.toAbsolutePath().toString(), filename);

                Files.createFile(targetFile);
                Files.copy(getClass().getResourceAsStream(new StringBuffer(CONFIG_PACKAGE).append(filename).toString()),
                        targetFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private Configuration parseFile(File file, Gson gson) {
        Configuration configuration = new Configuration();

        try {
            String json = Files.readAllLines(file.toPath()).stream()
                    .collect(Collectors.joining(System.lineSeparator()));
            json = json.replace("\"", "'");
            JsonObject object = gson.fromJson(json, JsonObject.class);

            for (String key : object.keySet()) {
                configuration.setConfigurationValue(key,
                        ConfigurationParser.getOptimalObject(object.get(key).getAsString()));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return configuration;
    }

}