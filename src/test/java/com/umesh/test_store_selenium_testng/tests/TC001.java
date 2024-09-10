package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.pages.*;
import com.umesh.test_store_selenium_testng.tests.model.Credentials;
import com.umesh.test_store_selenium_testng.tests.model.TC001_Test_Data;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;
import com.umesh.test_store_selenium_testng.util.JsonUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

/**
 * Test class for TC001.
 * Contains test data setup and execution of test case.
 *
 * @author Umesh Deshmukh
 */
public class TC001 extends BaseTest {
    private Credentials credentials;
    private TC001_Test_Data tc001_test_data;

    private LoginPage loginPage;
    private HomePage homePage;
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
        tc001_test_data = JsonUtil.getTestData(testDataPath, TC001_Test_Data.class);
        log.info("Test data loaded");
        loginPage = PageFactoryManager.getLoginPage(driver);
        homePage = PageFactoryManager.getHomePage(driver);
        globalMenu = PageFactoryManager.getGlobalMenu(driver);
        globalHeader = PageFactoryManager.getGlobalHeader(driver);
        log.info("credentials in before test " + credentials.email());
    }

    /**
     * Test case for TC001.
     * Validates the search functionality on the global menu.
     */
    @Test
    public void tc001() {
        loginPage.goTo(Config.get(Constants.TEST_STORE_URL));
        loginPage.login(credentials.email(), credentials.password());
        // Assert that the global menu is displayed
        Assert.assertTrue(globalMenu.isDisplayed());
        isLoginSuccessful = true; // Set flag indicating successful login
        log.info("credentials in test " + credentials.email());
        TestListener.getTest().log(Status.INFO, "This is first statement in the test case 01");
        log.info("Logger statement");
        // Perform search operation and validate results
        globalMenu.searchItem(tc001_test_data.searchText());
        Assert.assertTrue(globalMenu.searchResultDisplayed());
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
            log.info("Skipping the sign out as login failed");
            throw new SkipException("Skipping the sign out as login failed"); // Skip sign out if login failed
        }
    }
}
