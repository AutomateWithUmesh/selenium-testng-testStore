/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.pages.ClothesMenPage;
import com.umesh.test_store_selenium_testng.pages.ClothesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author umesh
 */
public class TC002 extends BaseTest {

    private ClothesPage clothesPage;
    private ClothesMenPage clothesMenPage;

    @Test
    public void tc002() {
        TestListener.getTest().log(Status.INFO, "This is first statement in the test case 02");
        log.info("Logger statement tc002");
        clothesPage = globalMenu.goToClothesPage();
        Assert.assertTrue(clothesPage.isDisplayed());
        clothesMenPage = clothesPage.goToClothesMenPage();
        Assert.assertTrue(clothesMenPage.isDisplayed());
        clothesMenPage.selectMenClothes();
        globalMenu.clickMyStoreLogo();
    }
}
