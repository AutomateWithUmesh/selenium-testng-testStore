package com.umesh.test_store_selenium_testng.util;

/**
 * Constants class holds configuration keys and constant values used throughout the project.
 * This class centralizes configuration keys and constants for easy management and maintenance.
 * 
 * @author Umesh Deshmukh
 */
public class Constants {

    // Keys for Selenium Grid configuration
    public static final String GRID_ENABLED = "selenium.grid.enabled"; // Key to enable or disable Selenium Grid
    public static final String GRID_URL_FORMAT = "selenium.grid.urlFormat"; // Key for the URL format of Selenium Grid
    public static final String GRID_HUB_HOST = "selenium.grid.hubHost"; // Key for the Selenium Grid hub host

    // Keys for browser configuration
    public static final String BROWSER = "browser"; // Key to specify the browser type (e.g., chrome, firefox)
    public static final String CHROME = "chrome"; // Constant value for Chrome browser
    public static final String FIREFOX = "firefox"; // Constant value for Firefox browser

    // Key for WebDriver
    public static final String DRIVER = "driver"; // Key to retrieve the WebDriver instance

    // Key for the test store URL
    public static final String TEST_STORE_URL = "test.store.url"; // Key for the URL of the test store application

}
