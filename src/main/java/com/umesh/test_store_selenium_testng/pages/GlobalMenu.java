/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author umesh
 */
public class GlobalMenu extends BasePage {

    private WebDriver driver;
    private ClothesPage clothesPage;
    private AccessoriesPage accessoriesPage;
    private ArtPage artPage;

    @FindBy(css = "#category-3 .dropdown-item")
    private WebElement clothesMenu;

    @FindBy(className = "logo")
    private WebElement myStoreLogo;
    
    @FindBy(className ="ui-autocomplete-input")
    private WebElement searchTextBox;
    
    @FindBy(id = "js-product-list-header")
    private WebElement searchResult;

    public GlobalMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
        clothesPage = PageFactory.initElements(this.driver, ClothesPage.class);
        accessoriesPage = PageFactory.initElements(this.driver, AccessoriesPage.class);
        artPage = PageFactory.initElements(this.driver, ArtPage.class);
    }

    public ClothesPage goToClothesPage() {
        clothesMenu.click();
        System.out.println("Inside getClothesPage");
        return clothesPage;
    }

    public AccessoriesPage goToAccessoriesPage() {
        return accessoriesPage;
    }

    public ArtPage goToArtPage() {
        return artPage;
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(myStoreLogo));
        return myStoreLogo.isDisplayed();
    }
    
    public void searchItem(String searchText) {
        searchTextBox.sendKeys(searchText,Keys.ENTER);
    }
    
    public void clickMyStoreLogo() {
        myStoreLogo.click();
    }
    
    public boolean searchResultDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        return searchResult.isDisplayed();
    }

}
