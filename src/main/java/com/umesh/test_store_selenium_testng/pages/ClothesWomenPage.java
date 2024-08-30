package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model class representing the Women's Clothes section of the application.
 * Provides methods to verify the visibility of the Women's Clothes section and to interact with it.
 * This class extends BasePage to inherit common page functionalities.
 * 
 * The ClothesWomenPage class includes a method to verify if the Women's Clothes section is displayed
 * and a placeholder method for selecting women's clothes.
 * 
 * @author Umesh
 */
public class ClothesWomenPage extends BasePage {

    // WebElement representing the header of the Women's Clothes section.
    @FindBy(id = "js-product-list-header")
    private WebElement womenSection;

    /**
     * Constructor to initialize the ClothesWomenPage with a WebDriver instance.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public ClothesWomenPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to verify if the Women's Clothes section is displayed.
     * Waits until the Women's Clothes section header is visible on the page
     * and then checks its display status.
     * 
     * @return true if the Women's Clothes section is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(womenSection));
        return womenSection.isDisplayed();
    }

    /**
     * Placeholder method to select women's clothes.
     * This method can be expanded in the future to include interactions for selecting women's clothes.
     */
    public void selectWomenClothes() {
        System.out.println("placeholder for selectWomenClothes");
    }
}
