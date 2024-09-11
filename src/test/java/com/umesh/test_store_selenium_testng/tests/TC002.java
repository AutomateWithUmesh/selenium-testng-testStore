package com.umesh.test_store_selenium_testng.tests;

import com.aventstack.extentreports.Status;
import com.umesh.test_store_selenium_testng.listener.TestListener;
import com.umesh.test_store_selenium_testng.pages.ClothesMenPage;
import com.umesh.test_store_selenium_testng.pages.ClothesPage;
import com.umesh.test_store_selenium_testng.pages.GlobalHeader;
import com.umesh.test_store_selenium_testng.pages.GlobalMenu;
import com.umesh.test_store_selenium_testng.pages.LoginPage;
import com.umesh.test_store_selenium_testng.pages.PageFactoryManager;
import com.umesh.test_store_selenium_testng.tests.model.Credentials;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;
import com.umesh.test_store_selenium_testng.util.JsonUtil;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test class for TC002.
 * Tests navigation and interactions with the Clothes and ClothesMen pages.
 * 
 * @author Umesh Deshmukh
 */
public class TC002 extends BaseTest {

    private LoginPage loginPage;
    private GlobalMenu globalMenu;
    private GlobalHeader globalHeader;
    private ClothesPage clothesPage;
    private ClothesMenPage clothesMenPage;
    private Credentials credentials;

    @BeforeTest
    @Parameters({ "testDataPath", "credentialsFilePath" })
    public void loadTestData(@Optional String testDataPath, String credentialsFilePath) {
        credentials = JsonUtil.getTestData(credentialsFilePath, Credentials.class);
        log.info("Test data loaded");

        /**
         * Create objects of the required pages
         */
        loginPage = PageFactoryManager.getLoginPage(driver);
        globalMenu = PageFactoryManager.getGlobalMenu(driver);
        globalHeader = PageFactoryManager.getGlobalHeader(driver);
        clothesPage = PageFactoryManager.getClothesPage(driver);
        clothesMenPage = PageFactoryManager.getClothesMenPage(driver);
        log.info("Required page objects are created");
    }

    /**
     * Test case for TC002.
     * Validates navigation and interactions with Clothes and ClothesMen pages.
     */
    @Test
    public void tc002() {
        loginPage.goTo(Config.get(Constants.TEST_STORE_URL));
        loginPage.login(credentials.email(), credentials.password());
        // Assert that the global menu is displayed
        Assert.assertTrue(globalMenu.isDisplayed());
        isLoginSuccessful = true; // Set flag indicating successful login
        // Log and print statements
        TestListener.getTest().log(Status.INFO, "This is first statement in the test case 02");
        log.info("Logger statement tc002");

        // Navigate to Clothes Page
        //clothesPage = globalMenu.goToClothesPage();
        globalMenu.goToClothesPage();
        Assert.assertTrue(clothesPage.isDisplayed(), "Clothes Page is not displayed");

        // Navigate to Clothes Men Page
        //clothesMenPage = clothesPage.goToClothesMenPage();
        clothesPage.goToClothesMenPage();
        Assert.assertTrue(clothesMenPage.isDisplayed(), "Clothes Men Page is not displayed");

        // Select clothes on Clothes Men Page
        clothesMenPage.selectMenClothes();

        // Click on My Store Logo to return to main page
        globalMenu.clickMyStoreLogo();
        log.info("TC002 completed");
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
            log.info("TC002 Skipping the sign out as login failed");
            throw new SkipException("Skipping the sign out as login failed"); // Skip sign out if login failed
        }
    }
}
