package com.umesh.test_store_selenium_testng.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;

/**
 * DriverFactory provides methods to initialize and manage WebDriver instances.
 * It supports both local and remote WebDriver setups, including browser-specific configurations.
 * 
 * @author Umesh Deshmukh
 */
public class DriverFactory {
    
    // ThreadLocal WebDriver instance to support parallel test execution
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    /**
     * Retrieves a WebDriver instance. Initializes a new WebDriver if it doesn't already exist.
     * Uses remote WebDriver if configured, otherwise initializes a local WebDriver.
     * 
     * @return WebDriver instance
     * @throws MalformedURLException If the URL format for remote WebDriver is incorrect
     */
    public static WebDriver getDriver() throws MalformedURLException {
        WebDriver webDriver;
        if (driver.get() == null) {
            if (Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED))) {
                // Initialize remote WebDriver if grid is enabled
                webDriver = getRemoteDriver();
            } else { 
                // Initialize local WebDriver if grid is not enabled
                webDriver = getLocalDriver();
            }
            driver.set(webDriver);
        }
        return driver.get();
    }
    
    /**
     * Initializes and returns a RemoteWebDriver instance for browser grid testing.
     * 
     * @return RemoteWebDriver instance
     * @throws MalformedURLException If the URL format for remote WebDriver is incorrect
     */
    private static WebDriver getRemoteDriver() throws MalformedURLException {
        WebDriver remoteDriver;
        // Set up capabilities based on the configured browser
        Capabilities capabilities = new ChromeOptions();
        if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
            capabilities = new FirefoxOptions();
        }
        // Build the URL for the Selenium Grid hub
        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat, hubHost);
        remoteDriver = new RemoteWebDriver(new URL(url), capabilities);
        return remoteDriver;
    }
    
    /**
     * Initializes and returns a local WebDriver instance based on the configured browser.
     * 
     * @return Local WebDriver instance
     */
    private static WebDriver getLocalDriver() {
        WebDriver localDriver = null;
        
        // Set up local WebDriver based on the configured browser
        if (Constants.CHROME.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
            WebDriverManager.chromedriver().setup();
            localDriver = new ChromeDriver();
        } else if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
            WebDriverManager.firefoxdriver().setup();
            localDriver = new FirefoxDriver();
        }
        driver.set(localDriver);
        localDriver.manage().window().maximize(); // Maximize the browser window
        return localDriver;
    }

    /**
     * Quits the WebDriver instance and removes it from the ThreadLocal storage.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit(); // Quit the WebDriver session
            driver.remove(); // Remove the WebDriver from ThreadLocal storage
        }
    }
}
