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
public class ClothesPage extends BasePage {

    private ClothesMenPage clothesMenPage;
    private ClothesWomenPage clothesWomenPage;

    @FindBy(id = "js-product-list-header")
    private WebElement clotheSection;

    @FindBy(css = ".category-sub-menu > li:nth-child(1) > a:nth-child(1)")
    private WebElement menSection;

    @FindBy(css = ".category-sub-menu > li:nth-child(2) > a:nth-child(1)")
    private WebElement womenSection;

    public ClothesPage(WebDriver driver) {
        super(driver);
        clothesMenPage = PageFactory.initElements(driver, ClothesMenPage.class);
        clothesWomenPage = PageFactory.initElements(driver, ClothesWomenPage.class);
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(clotheSection));
        return clotheSection.isDisplayed();
    }

    public ClothesMenPage goToClothesMenPage() {
        menSection.click();
        return clothesMenPage;
    }

    public ClothesWomenPage goToClothesWomenPage() {
        womenSection.click();
        return clothesWomenPage;
    }

}
