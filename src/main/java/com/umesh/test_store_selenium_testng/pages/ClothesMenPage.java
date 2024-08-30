package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model class representing the Men's Clothes section of the application.
 * Provides methods to verify the visibility of the Men's Clothes section and to interact with it.
 * This class extends BasePage to inherit common page functionalities.
 * 
 * The ClothesMenPage class includes a method to verify if the Men's Clothes section is displayed
 * and a placeholder method for selecting men's clothes.
 * 
 * This class can be expanded to include more interactions related to the Men's Clothes section.
 * 
 * @Author Umesh
 */
public class ClothesMenPage extends BasePage {
    
    // WebElement representing the main container for the Men's Clothes section.
    @FindBy(id = "content-wrapper")
    private WebElement menSection;

    /**
     * Constructor to initialize the ClothesMenPage with a WebDriver instance.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public ClothesMenPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to verify if the Men's Clothes section is displayed.
     * Waits until the Men's Clothes section container is visible on the page
     * and then checks its display status.
     * 
     * @return true if the Men's Clothes section is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(menSection));
        return menSection.isDisplayed();
    }

    /**
     * Placeholder method to select men's clothes.
     * This method can be expanded in the future to include interactions for selecting men's clothes.
     */
    public void selectMenClothes() {
        System.out.println("placeholder for selectMenClothes");
    }
}
