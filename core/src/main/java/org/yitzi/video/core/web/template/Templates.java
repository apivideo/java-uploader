package org.yitzi.video.core.web.template;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

import java.io.InputStream;
import java.util.Properties;

class Templates {

    private static final Templates INSTANCE = new Templates();

    private final Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

    private Templates() {
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(new ClassTemplateLoader(getClass().getClassLoader(), "templates"));
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
            configuration.setSharedVariable("config", properties);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Templates get() {
        return INSTANCE;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
