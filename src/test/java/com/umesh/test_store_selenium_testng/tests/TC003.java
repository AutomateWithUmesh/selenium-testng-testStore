package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.pages.ClothesMenPage;
import com.umesh.test_store_selenium_testng.pages.ClothesPage;
import com.umesh.test_store_selenium_testng.pages.ClothesWomenPage;
import static com.umesh.test_store_selenium_testng.tests.BaseTest.log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for TC003.
 * Tests navigation and interactions with Clothes Men and Clothes Women pages.
 * 
 * @author Umesh Deshmukh
 */
public class TC003 extends BaseTest {

    private ClothesPage clothesPage;
    private ClothesWomenPage clothesWomenPage;
    private ClothesMenPage clothesMenPage;

    /**
     * Sets up common page objects for the tests.
     * Creates page objects common to multiple tests in this class.
     */
    @BeforeMethod
    public void setPageObjects() {
        clothesPage = globalMenu.goToClothesPage();
        Assert.assertTrue(clothesPage.isDisplayed(), "Clothes Page is not displayed");
    }

    /**
     * Test case 03_1.
     * Validates navigation to Clothes Men page and selection of clothes.
     */
    @Test
    public void tc003_1() {
        TestListener.getTest().log(Status.INFO, "This is the first statement in the test case 03_1");
        log.info("Logger statement tc003_1");

        clothesMenPage = clothesPage.goToClothesMenPage();
        Assert.assertTrue(clothesMenPage.isDisplayed(), "Clothes Men Page is not displayed");

        clothesMenPage.selectMenClothes();
        globalMenu.clickMyStoreLogo();
    }

    /**
     * Test case 03_2.
     * Validates navigation to Clothes Women page and selection of clothes.
     */
    @Test
    public void tc003_2() {
        TestListener.getTest().log(Status.INFO, "This is the first statement in the test case 03_2");
        log.info("Logger statement tc003_2");

        clothesWomenPage = clothesPage.goToClothesWomenPage();
        Assert.assertTrue(clothesWomenPage.isDisplayed(), "Clothes Women Page is not displayed");

        clothesWomenPage.selectWomenClothes();
        globalMenu.clickMyStoreLogo();
    }
}
