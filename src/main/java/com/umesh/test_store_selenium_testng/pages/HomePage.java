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

    /**
     * Method to retrieve the GlobalHeader component.
     * 
     * @return An instance of the GlobalHeader class.
     */
    public GlobalHeader getGlobalHeader() {
        return new GlobalHeader(this.driver);
    }

    /**
     * Method to retrieve the GlobalFooter component.
     * 
     * @return An instance of the GlobalFooter class.
     */
    public GlobalFooter getGlobalFooter() {
        return new GlobalFooter(this.driver);
    }

    /**
     * Method to retrieve the GlobalMenu component.
     * 
     * @return An instance of the GlobalMenu class.
     */
    public GlobalMenu getGlobalMenu() {
        return new GlobalMenu(this.driver);
    }
}
