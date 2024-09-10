package com.umesh.test_store_selenium_testng.tests;

/**
 * BaseTest provides a common setup and teardown framework for test cases.
 * It initializes the WebDriver, performs login, and provides access to page objects and utilities.
 * 
 * @author Umesh Deshmukh
 */
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;


public abstract class BaseTest {

    protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    protected boolean isLoginSuccessful = false; // Flag to track if login was successful

    protected WebDriver driver; // WebDriver instance for browser interactions

    /**
     * Initializes configuration settings before any test classes are run.
     */
    @BeforeSuite
    public void setupConfig() {
        Config.initialize(); // Load configuration settings
    }

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        driver = DriverFactory.getDriver(); // Initialize the WebDriver
        ctx.setAttribute(Constants.DRIVER, driver); // Set WebDriver attribute in the context
    }
     

    @AfterTest
    public void quitDriver() {
        DriverFactory.quitDriver();
    }

}
