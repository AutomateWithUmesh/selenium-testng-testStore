package com.umesh.test_store_selenium_testng.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JsonUtil is a utility class for handling JSON operations.
 * It uses Jackson's ObjectMapper to parse JSON data into Java objects.
 * 
 * @author Umesh Deshmukh
 */
public class JsonUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class); // Logger for logging errors
    private static final ObjectMapper mapper = new ObjectMapper(); // Jackson ObjectMapper instance for JSON parsing

    /**
     * Reads JSON data from a specified path and maps it to a Java object of the given type.
     * 
     * @param path the path to the JSON resource file
     * @param type the class type to map the JSON data to
     * @param <T> the type of the Java object
     * @return an instance of the specified type containing the JSON data, or null if an error occurs
     */
    public static <T> T getTestData(String path, Class<T> type){
        try (InputStream stream = ResourceLoader.getResource(path)) {
            return mapper.readValue(stream, type); // Parse JSON data into Java object
        } catch (Exception e) {
            log.error("Unable to read test data from path: {}", path, e); // Log error if parsing fails
        }
        return null; // Return null if an exception occurs
    }
}
