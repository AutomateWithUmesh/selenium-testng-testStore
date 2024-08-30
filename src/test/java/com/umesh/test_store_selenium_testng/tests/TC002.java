package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.pages.ClothesMenPage;
import com.umesh.test_store_selenium_testng.pages.ClothesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for TC002.
 * Tests navigation and interactions with the Clothes and ClothesMen pages.
 * 
 * @author Umesh Deshmukh
 */
public class TC002 extends BaseTest {

    private ClothesPage clothesPage;
    private ClothesMenPage clothesMenPage;

    /**
     * Test case for TC002.
     * Validates navigation and interactions with Clothes and ClothesMen pages.
     */
    @Test
    public void tc002() {
        // Log and print statements
        TestListener.getTest().log(Status.INFO, "This is first statement in the test case 02");
        log.info("Logger statement tc002");

        // Navigate to Clothes Page
        clothesPage = globalMenu.goToClothesPage();
        Assert.assertTrue(clothesPage.isDisplayed(), "Clothes Page is not displayed");

        // Navigate to Clothes Men Page
        clothesMenPage = clothesPage.goToClothesMenPage();
        Assert.assertTrue(clothesMenPage.isDisplayed(), "Clothes Men Page is not displayed");

        // Select clothes on Clothes Men Page
        clothesMenPage.selectMenClothes();

        // Click on My Store Logo to return to main page
        globalMenu.clickMyStoreLogo();
    }
}
