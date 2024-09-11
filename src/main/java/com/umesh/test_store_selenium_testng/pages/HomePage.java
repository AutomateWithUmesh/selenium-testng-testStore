package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;

/**
 * Page Object Model class representing the Home Page of the application.
 * Provides access to global components like the header, footer, and menu.
 * This class serves as the landing page after a successful login.
 * 
 * @author Umesh
 */
public class HomePage {

    // WebDriver instance for interacting with the browser.
    private WebDriver driver;

    /**
     * Constructor to initialize the HomePage with a WebDriver instance.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //home page methods
}
