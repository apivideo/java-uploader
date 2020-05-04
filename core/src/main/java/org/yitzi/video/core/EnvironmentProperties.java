package org.yitzi.video.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentProperties {

    private static EnvironmentProperties instance;
    private Properties properties;

    private EnvironmentProperties() {
        loadProperties();
    }

    public static String getProperty(String key) {
        if (instance == null) {
            instance = new EnvironmentProperties();
        }
        return instance.properties.getProperty(key);
    }

    private void loadProperties() {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
