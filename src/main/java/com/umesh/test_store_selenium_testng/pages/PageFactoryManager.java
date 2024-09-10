package com.umesh.test_store_selenium_testng.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static LoginPage loginPage;
    private static HomePage homePage;
    private static GlobalMenu globalMenu;
    private static ClothesPage clothesPage;
    private static ClothesMenPage clothesMenPage;
    private static ClothesWomenPage clothesWomenPage;
    private static GlobalHeader globalHeader;

    public static LoginPage getLoginPage(WebDriver driver) {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static HomePage getHomePage(WebDriver driver) {
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static GlobalMenu getGlobalMenu(WebDriver driver) {
        return globalMenu == null ? new GlobalMenu(driver) : globalMenu;
    }

    public static ClothesPage getClothesPage(WebDriver driver) {
        return clothesPage == null ? new ClothesPage(driver) : clothesPage;
    }

    public static ClothesMenPage getClothesMenPage(WebDriver driver) {
        return clothesMenPage == null ? new ClothesMenPage(driver) : clothesMenPage;
    }

    public static ClothesWomenPage getClothesWomenPage(WebDriver driver) {
        return clothesWomenPage == null ? new ClothesWomenPage(driver) : clothesWomenPage;
    }

    public static GlobalHeader getGlobalHeader(WebDriver driver) {
        return globalHeader == null ? new GlobalHeader(driver) : globalHeader;
    }
}
