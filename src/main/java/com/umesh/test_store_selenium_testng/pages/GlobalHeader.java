/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author umesh
 */
public class GlobalHeader {

    @FindBy(css = ".logout.hidden-sm-down")
    private WebElement signoutButton;
    
    public GlobalHeader(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    
    public void signout(){
        signoutButton.click();
    }
}
