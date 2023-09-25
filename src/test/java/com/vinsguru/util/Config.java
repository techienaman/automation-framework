package com.vinsguru.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Logger log= LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTIES="config/default.properties";
   private static  Properties properties;



    public static void initialize() {
        properties = Config.loadProperties();
        for (String key : properties.stringPropertyNames()) {
            if (System.getProperties().containsKey(key)) {
                System.setProperty(key, System.getProperty(key));
            }
        }
    }

    public static String get(String key){
            return properties.getProperty(key);

        }
    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }



}
