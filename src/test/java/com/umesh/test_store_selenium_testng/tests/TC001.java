/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.tests.model.TC001_Test_Data;
import com.umesh.test_store_selenium_testng.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author umesh
 */
public class TC001 extends BaseTest{
    private TC001_Test_Data tc001_test_data;
    
    @BeforeMethod
    @Parameters("testDataPath")
    public void loadTestData(String testDataPath) {
        tc001_test_data = JsonUtil.getTestData(testDataPath, TC001_Test_Data.class);
        log.info("Test data loaded");
    }
    
    @Test
    public void tc001() {
        TestListener.getTest().log(Status.INFO,"This is first statement in the test case 01");
        log.info("Logger statement");
        Assert.assertTrue(globalMenu.isDisplayed());
        globalMenu.searchItem(tc001_test_data.searchText());
        Assert.assertTrue(globalMenu.searchResultDisplayed());
    }
}