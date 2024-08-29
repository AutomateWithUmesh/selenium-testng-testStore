/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author umesh
 */
public class LoginPage extends BasePage {
    
    private WebDriver driver;
    
    @FindBy(className = "user-info")
    private WebElement signin;

    @FindBy(id = "field-email")
    private WebElement email;

    @FindBy(id = "field-password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement signinButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(signin));
        return signin.isDisplayed();
    }
    
    public void goTo(String url) {
        this.driver.get(url);
    }
    
    public HomePage login(String emailAddress, String userPassword) {
        signin.click();
        email.sendKeys(emailAddress);
        password.sendKeys(userPassword);
        signinButton.click();
        return new HomePage(this.driver);
    }

}
