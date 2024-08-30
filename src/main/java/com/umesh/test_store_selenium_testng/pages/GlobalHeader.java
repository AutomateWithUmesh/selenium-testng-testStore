package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class representing the Global Header of the application.
 * Provides methods to interact with elements like the sign-out button.
 * 
 * The Global Header is a common element visible across multiple pages.
 * This class allows interactions with the header components, such as signing out.
 * 
 * @author Umesh
 */
public class GlobalHeader {

    // WebElement representing the Sign Out button in the header.
    @FindBy(css = ".logout.hidden-sm-down")
    private WebElement signoutButton;

    /**
     * Constructor to initialize the GlobalHeader with a WebDriver instance.
     * Uses PageFactory to initialize web elements defined in this class.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public GlobalHeader(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to perform a sign-out action.
     * Clicks the Sign Out button in the header to log the user out.
     */
    public void signout() {
        signoutButton.click();
    }
}
