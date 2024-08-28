/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author umesh
 */
public class MenuComponent extends BasePage{
    
    @FindBy(id = "#category-3")
    private WebElement clothesMenuLink;

    public MenuComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(clothesMenuLink));
        return clothesMenuLink.isDisplayed();
    }
    
}
