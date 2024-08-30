package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.tests.model.TC001_Test_Data;
import com.umesh.test_store_selenium_testng.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test class for TC001.
 * Contains test data setup and execution of test case.
 * 
 * @author Umesh Deshmukh
 */
public class TC001 extends BaseTest {
    private TC001_Test_Data tc001_test_data;
    
    /**
     * Loads test data from the specified path before each method.
     * 
     * @param testDataPath path to the test data JSON file
     */
    @BeforeMethod
    @Parameters("testDataPath")
    public void loadTestData(String testDataPath) {
        tc001_test_data = JsonUtil.getTestData(testDataPath, TC001_Test_Data.class);
        log.info("Test data loaded");
    }
    
    /**
     * Test case for TC001.
     * Validates the search functionality on the global menu.
     */
    @Test
    public void tc001() {
        TestListener.getTest().log(Status.INFO, "This is first statement in the test case 01");
        log.info("Logger statement");

        // Assert that the global menu is displayed
        Assert.assertTrue(globalMenu.isDisplayed());

        // Perform search operation and validate results
        globalMenu.searchItem(tc001_test_data.searchText());
        Assert.assertTrue(globalMenu.searchResultDisplayed());
    }
}
