package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;

/**
 * Page Object Model class representing the Global Footer of the application.
 * This class can be extended to interact with elements located in the footer section of the page.
 * 
 * The Global Footer is a common element visible across multiple pages.
 * Currently, this class serves as a placeholder for future footer-related methods and elements.
 * 
 * @author Umesh
 */
public class GlobalFooter {

    // WebDriver instance for interacting with the browser.
    private WebDriver driver;

    /**
     * Constructor to initialize the GlobalFooter with a WebDriver instance.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public GlobalFooter(WebDriver driver) {
        this.driver = driver;
    }
}
