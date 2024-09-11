package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.pages.*;
import com.umesh.test_store_selenium_testng.tests.model.Credentials;
import com.umesh.test_store_selenium_testng.tests.model.TC001_Test_Data;
import com.umesh.test_store_selenium_testng.tests.model.TC004_Test_Data;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;
import com.umesh.test_store_selenium_testng.util.JsonUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test class for TC001.
 * Contains test data setup and execution of test case.
 *
 * @author Umesh Deshmukh
 */
public class TC004 extends BaseTest {
    private Credentials credentials;
    private TC004_Test_Data tc004_test_data;
    private LoginPage loginPage;
    private GlobalMenu globalMenu;
    private GlobalHeader globalHeader;

    /**
     * Loads test data from the specified path before each method.
     *
     * @param testDataPath path to the test data JSON file
     */
    @BeforeTest
    @Parameters({"testDataPath", "credentialsFilePath"})
    public void loadTestData(String testDataPath, String credentialsFilePath) {
        credentials = JsonUtil.getTestData(credentialsFilePath, Credentials.class);
        tc004_test_data = JsonUtil.getTestData(testDataPath, TC004_Test_Data.class);
        log.info("Test data loaded");

        /**
         * Create objects of the required pages
         */
        loginPage = PageFactoryManager.getLoginPage(driver);
        globalMenu = PageFactoryManager.getGlobalMenu(driver);
        globalHeader = PageFactoryManager.getGlobalHeader(driver);
        log.info("Required page objects are created");
    }

    /**
     * Test case for TC001.
     * Validates the search functionality on the global menu.
     */
    @Test
    public void tc004() {
        loginPage.goTo(Config.get(Constants.TEST_STORE_URL));
        loginPage.login(credentials.email(), credentials.password());
        // Assert that the global menu is displayed
        Assert.assertTrue(globalMenu.isDisplayed());
        isLoginSuccessful = true; // Set flag indicating successful login
        log.info("On the home page after successful login");
        TestListener.getTest().log(Status.INFO, "On the home page after successful login");

        // Perform search operation and validate results
        log.info("Perform search operation and validate results");
        TestListener.getTest().log(Status.INFO, "Perform search operation and validate results");
        globalMenu.searchItem(tc004_test_data.searchText());

        log.info("Check if intended search is displayed");
        TestListener.getTest().log(Status.INFO, "Check if intended search is displayed");
        Assert.assertFalse(globalMenu.searchResultDisplayed());
        log.info("TC004 completed");
    }

    @AfterTest
    public void signOut() {
        if (isLoginSuccessful) {
            log.info("Running the sign out");
            globalHeader.signout(); // Perform sign out
            Assert.assertTrue(loginPage.isDisplayed()); // Verify login page is displayed after sign out
            log.info("Sign out completed");
            driver.manage().deleteAllCookies(); // Clear cookies
            log.info("Cookies deleted");
        } else {
            log.info("TC004 Skipping the sign out as login failed");
            throw new SkipException("Skipping the sign out as login failed"); // Skip sign out if login failed
        }
    }
}
