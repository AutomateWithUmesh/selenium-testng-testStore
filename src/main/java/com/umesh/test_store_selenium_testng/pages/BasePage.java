package com.umesh.test_store_selenium_testng.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract base class for all page classes.
 * Provides common functionalities for interacting with web pages.
 * All page classes should extend this class.
 * 
 * @author Umesh
 */
public abstract class BasePage {

    // WebDriver instance used to interact with the web browser.
    protected final WebDriver driver;

    // WebDriverWait instance used to manage waits for elements to be available or conditions to be met.
    protected final WebDriverWait wait;

    /**
     * Constructor to initialize the WebDriver and WebDriverWait.
     * Also initializes web elements defined in the page classes using PageFactory.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebDriverWait with a timeout of 30 seconds.
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Initialize web elements for the current page object.
        PageFactory.initElements(driver, this);
    }

    /**
     * Abstract method to be implemented by all derived page classes.
     * This method should contain logic to verify if the page is displayed.
     * 
     * @return true if the page is displayed, false otherwise.
     */
    public abstract boolean isDisplayed();
}
