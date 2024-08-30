package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model class representing the Clothes section of the application.
 * Provides methods to interact with the Men's and Women's Clothes sections.
 * This class extends BasePage to inherit common page functionalities.
 * 
 * The ClothesPage class includes methods to navigate to the Men's and Women's Clothes pages.
 * It also verifies if the main Clothes section is displayed.
 * 
 * This page is designed to handle navigation and interaction with subcategories (Men and Women)
 * within the Clothes section.
 * 
 * @author Umesh
 */
public class ClothesPage extends BasePage {

    // Page objects for the Men's and Women's Clothes pages.
    private ClothesMenPage clothesMenPage;
    private ClothesWomenPage clothesWomenPage;

    // WebElement representing the main Clothes section header.
    @FindBy(id = "js-product-list-header")
    private WebElement clotheSection;

    // WebElement for navigating to the Men's Clothes section.
    @FindBy(css = ".category-sub-menu > li:nth-child(1) > a:nth-child(1)")
    private WebElement menSection;

    // WebElement for navigating to the Women's Clothes section.
    @FindBy(css = ".category-sub-menu > li:nth-child(2) > a:nth-child(1)")
    private WebElement womenSection;

    /**
     * Constructor to initialize the ClothesPage with a WebDriver instance.
     * Also initializes the page objects for the Men's and Women's Clothes pages.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public ClothesPage(WebDriver driver) {
        super(driver);
        clothesMenPage = PageFactory.initElements(driver, ClothesMenPage.class);
        clothesWomenPage = PageFactory.initElements(driver, ClothesWomenPage.class);
    }

    /**
     * Method to verify if the main Clothes section is displayed.
     * Waits until the main Clothes section header is visible on the page
     * and then checks its display status.
     * 
     * @return true if the Clothes section is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(clotheSection));
        return clotheSection.isDisplayed();
    }

    /**
     * Method to navigate to the Men's Clothes page.
     * Clicks the link to the Men's Clothes section and returns the corresponding page object.
     * 
     * @return the ClothesMenPage object representing the Men's Clothes section.
     */
    public ClothesMenPage goToClothesMenPage() {
        menSection.click();
        return clothesMenPage;
    }

    /**
     * Method to navigate to the Women's Clothes page.
     * Clicks the link to the Women's Clothes section and returns the corresponding page object.
     * 
     * @return the ClothesWomenPage object representing the Women's Clothes section.
     */
    public ClothesWomenPage goToClothesWomenPage() {
        womenSection.click();
        return clothesWomenPage;
    }
}
