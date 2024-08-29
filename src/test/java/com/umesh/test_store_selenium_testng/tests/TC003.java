/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.pages.ClothesMenPage;
import com.umesh.test_store_selenium_testng.pages.ClothesPage;
import com.umesh.test_store_selenium_testng.pages.ClothesWomenPage;
import static com.umesh.test_store_selenium_testng.tests.BaseTest.log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author umesh
 */
public class TC003 extends BaseTest {

    private ClothesPage clothesPage;
    private ClothesWomenPage clothesWomenPage;
    private ClothesMenPage clothesMenPage;

    /**
     * if we have multiple tests under single class, then create common page
     * objects under BeforeMethod or BeforeClass. Objects specific to test
     * should be created under Test directly.
     */
    
    @BeforeMethod
    public void setPageObjects() {
        clothesPage = globalMenu.goToClothesPage();
        Assert.assertTrue(clothesPage.isDisplayed());
    }
    @Test
    public void tc003_1() {
        TestListener.getTest().log(Status.INFO, "This is first statement in the test case 03_1");
        log.info("Logger statement tc003_1");
        clothesMenPage = clothesPage.goToClothesMenPage();
        Assert.assertTrue(clothesMenPage.isDisplayed());
        clothesMenPage.selectMenClothes();
        globalMenu.clickMyStoreLogo();
    }

    @Test
    public void tc003_2() {
        TestListener.getTest().log(Status.INFO, "This is first statement in the test case 03_2");
        log.info("Logger statement tc003_2");
        clothesWomenPage = clothesPage.goToClothesWomenPage();
        Assert.assertTrue(clothesWomenPage.isDisplayed());
        clothesWomenPage.selectWomenClothes();
        globalMenu.clickMyStoreLogo();
    }
}
