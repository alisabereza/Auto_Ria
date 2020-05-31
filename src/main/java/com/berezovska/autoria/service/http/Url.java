package com.berezovska.autoria.service.http;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Url {
    private static final Logger LOG = LogManager.getLogger(Url.class);
    private Properties properties;
    ClassLoader classLoader;
    InputStream resourceAsStream;

    public Url() {
        this.properties = new Properties();
        this.classLoader = Thread.currentThread().getContextClassLoader();
        this.resourceAsStream = classLoader.getResourceAsStream("application.properties");
        if (resourceAsStream != null) {
            try {
                properties.load(resourceAsStream);
            } catch (IOException e) {
                LOG.error("Error loading application.properties", e);
                throw new RuntimeException("Error loading application.properties", e);
            }
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
