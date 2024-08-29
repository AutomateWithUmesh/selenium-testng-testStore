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
public class ClothesWomenPage extends BasePage {

    @FindBy(id = "js-product-list-header")
    private WebElement womenSection;

    public ClothesWomenPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(womenSection));
        return womenSection.isDisplayed();
    }

    public void selectWomenClothes() {
        System.out.println("placeholder for selectWomenClothes");
    }
}
