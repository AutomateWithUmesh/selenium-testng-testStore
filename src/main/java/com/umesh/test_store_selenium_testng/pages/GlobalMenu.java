package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model class representing the Global Menu of the application.
 * Provides methods to interact with the menu options and search functionality.
 * This class extends BasePage to inherit common page functionalities.
 * 
 * It includes navigation to specific sections such as Clothes, Accessories, and Art.
 * Additionally, it provides a search function and allows interaction with the store logo.
 * 
 * @author Umesh
 */
public class GlobalMenu extends BasePage {

    // WebDriver instance for interacting with the browser.
    private WebDriver driver;

    // Page objects for the subpages accessible from the Global Menu.
    private ClothesPage clothesPage;
    private AccessoriesPage accessoriesPage;
    private ArtPage artPage;

    // WebElement representing the Clothes menu option.
    @FindBy(css = "#category-3 .dropdown-item")
    private WebElement clothesMenu;

    // WebElement representing the store logo (e.g., "My Store").
    @FindBy(className = "logo")
    private WebElement myStoreLogo;

    // WebElement representing the search text box.
    @FindBy(className ="ui-autocomplete-input")
    private WebElement searchTextBox;

    // WebElement representing the search results header.
    @FindBy(id = "js-product-list-header")
    private WebElement searchResult;

    /**
     * Constructor to initialize the GlobalMenu with a WebDriver instance.
     * It also initializes page objects for ClothesPage, AccessoriesPage, and ArtPage.
     * 
     * @param driver The WebDriver instance to be used by this page class.
     */
    public GlobalMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
        clothesPage = PageFactory.initElements(this.driver, ClothesPage.class);
        accessoriesPage = PageFactory.initElements(this.driver, AccessoriesPage.class);
        artPage = PageFactory.initElements(this.driver, ArtPage.class);
    }

    /**
     * Method to navigate to the Clothes page.
     * Clicks the Clothes menu option and returns an instance of ClothesPage.
     * 
     * @return An instance of ClothesPage after clicking the menu option.
     */
    public void goToClothesPage() {
        clothesMenu.click();
        System.out.println("Inside getClothesPage");
        //return clothesPage;
    }

    /**
     * Method to navigate to the Accessories page.
     * 
     * @return An instance of AccessoriesPage.
     */
    public AccessoriesPage goToAccessoriesPage() {
        return accessoriesPage;
    }

    /**
     * Method to navigate to the Art page.
     * 
     * @return An instance of ArtPage.
     */
    public ArtPage goToArtPage() {
        return artPage;
    }

    /**
     * Method to verify if the GlobalMenu is displayed.
     * Waits until the store logo is visible on the page and then checks its display status.
     * 
     * @return true if the store logo is displayed, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(myStoreLogo));
        return myStoreLogo.isDisplayed();
    }

    /**
     * Method to perform a search operation using the search text box.
     * Enters the provided search text and submits the search by pressing ENTER.
     * 
     * @param searchText The text to search for.
     */
    public void searchItem(String searchText) {
        searchTextBox.sendKeys(searchText, Keys.ENTER);
    }

    /**
     * Method to click the store logo.
     * Typically used to navigate back to the home page or refresh the page.
     */
    public void clickMyStoreLogo() {
        myStoreLogo.click();
    }

    /**
     * Method to verify if the search results are displayed.
     * Waits until the search results header is visible and then checks its display status.
     * 
     * @return true if the search results header is displayed, false otherwise.
     */
    public boolean searchResultDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        return searchResult.isDisplayed();
    }
}
