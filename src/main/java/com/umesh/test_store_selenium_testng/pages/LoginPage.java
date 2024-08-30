package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model class representing the Login Page of the application.
 * Provides methods to interact with the login elements and perform actions.
 * Extends the BasePage class to inherit common page functionalities.
 * 
 * @author Umesh
 */
public class LoginPage extends BasePage {

    // WebDriver instance for interacting with the browser.
    private WebDriver driver;

    // WebElement representing the Sign In button on the page.
    @FindBy(className = "user-info")
    private WebElement signin;

    // WebElement representing the Email input field on the login form.
    @FindBy(id = "field-email")
    private WebElement email;

    // WebElement representing the Password input field on the login form.
    @FindBy(id = "field-password")
    private WebElement password;

    // WebElement representing the Submit/Login button on the login form.
    @FindBy(id = "submit-login")
    private WebElement signinButton;

    /**
     * Constructor to initialize the LoginPage with a WebDriver instance.
     * Calls the parent constructor to initialize common page elements.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Method to verify if the LoginPage is displayed.
     * Waits until the Sign In button is visible on the page and then checks its display status.
     * 
     * @return true if the Sign In button is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(signin));
        return signin.isDisplayed();
    }

    /**
     * Method to navigate to a specific URL.
     * 
     * @param url The URL to navigate to.
     */
    public void goTo(String url) {
        this.driver.get(url);
    }

    /**
     * Method to perform a login action.
     * Enters the provided email and password, clicks the Sign In button, 
     * and returns an instance of the HomePage class.
     * 
     * @param emailAddress The email address to enter.
     * @param userPassword The password to enter.
     * @return A new instance of the HomePage class after login.
     */
    public HomePage login(String emailAddress, String userPassword) {
        signin.click();
        email.sendKeys(emailAddress);
        password.sendKeys(userPassword);
        signinButton.click();
        return new HomePage(this.driver);
    }
}
