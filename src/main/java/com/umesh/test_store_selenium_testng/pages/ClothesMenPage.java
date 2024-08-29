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
public class ClothesMenPage extends BasePage{
    
    @FindBy(id = "content-wrapper")
    private WebElement menSection;

    public ClothesMenPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(menSection));
        return menSection.isDisplayed();
    }
    
    public void selectMenClothes() {
        System.out.println("placeholder for selectMenClothes");
    }
}
