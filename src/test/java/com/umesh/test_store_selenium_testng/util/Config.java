package com.umesh.test_store_selenium_testng.util;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Config is a utility class for managing application configuration properties.
 * It loads properties from a default file and allows overriding them with system properties.
 * 
 * @author Umesh Deshmukh
 */
public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class); // Logger for logging information and errors
    private static final String DEFAULT_PROPERTIES = "config/default.properties"; // Default properties file path
    private static Properties properties; // Properties object to hold configuration values

    /**
     * Initializes the configuration by loading properties from the default file
     * and overriding with any system properties if present.
     */
    public static void initialize() {

        // Load properties from the default file
        properties = loadProperties();

        // Override with system properties if they are set
        for (String key : properties.stringPropertyNames()) {
            if (System.getProperties().containsKey(key)) {
                properties.setProperty(key, System.getProperty(key));
            }
        }

        // Log the properties for debugging purposes
        log.info("Test Properties");
        log.info("-----------------");
        for (String key : properties.stringPropertyNames()) {
            log.info("{}={}", key, properties.getProperty(key));
        }
        log.info("-----------------");
    }

    /**
     * Retrieves the property value for the specified key.
     * 
     * @param key The property key
     * @return The property value
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Loads properties from the default properties file.
     * 
     * @return Properties object containing the loaded properties
     */
    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
            properties.load(stream); // Load properties from the input stream
        } catch (Exception e) {
            log.error("Unable to read the property file {}", DEFAULT_PROPERTIES, e); // Log error if loading fails
        }
        return properties;
    }
}
