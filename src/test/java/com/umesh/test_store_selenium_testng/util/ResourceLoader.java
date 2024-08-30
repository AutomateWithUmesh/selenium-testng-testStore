package com.umesh.test_store_selenium_testng.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ResourceLoader is a utility class for loading resources from different locations.
 * It first attempts to load resources from the classpath. If not found, it then attempts to load
 * from the filesystem.
 * 
 * @author Umesh Deshmukh
 */
public class ResourceLoader {

    private static final Logger log = LoggerFactory.getLogger(ResourceLoader.class); // Logger for logging resource loading

    /**
     * Attempts to load a resource from the classpath or filesystem.
     * 
     * @param path the path to the resource
     * @return an InputStream for the resource
     * @throws Exception if the resource cannot be found or accessed
     */
    public static InputStream getResource(String path) throws Exception {
        log.info("Reading resource from location: {}", path);

        // Attempt to load resource from classpath
        InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
        if (Objects.nonNull(stream)) {
            return stream; // Return if found in classpath
        }

        // Attempt to load resource from filesystem if not found in classpath
        return Files.newInputStream(Path.of(path));
    }
}
