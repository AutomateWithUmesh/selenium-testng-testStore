package com.umesh.test_store_selenium_testng.tests;

/**
 * BaseTest provides a common setup and teardown framework for test cases.
 * It initializes the WebDriver, performs login, and provides access to page objects and utilities.
 * 
 * @author Umesh Deshmukh
 */
import com.umesh.test_store_selenium_testng.pages.HomePage;
import com.umesh.test_store_selenium_testng.pages.GlobalFooter;
import com.umesh.test_store_selenium_testng.pages.GlobalHeader;
import com.umesh.test_store_selenium_testng.pages.GlobalMenu;
import com.umesh.test_store_selenium_testng.pages.LoginPage;
import com.umesh.test_store_selenium_testng.tests.model.Credentials;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;
import com.umesh.test_store_selenium_testng.util.JsonUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    protected boolean isLoginSuccessful = false; // Flag to track if login was successful

    protected WebDriver driver; // WebDriver instance for browser interactions
    private Credentials credentials; // Holds login credentials
    private LoginPage loginPage; // Page object for login page
    protected HomePage homePage; // Page object for home page after login
    protected GlobalHeader globalHeader; // Page object for global header
    protected GlobalFooter globalFooter; // Page object for global footer
    protected GlobalMenu globalMenu; // Page object for global menu

    /**
     * Initializes configuration settings before any test classes are run.
     */
    @BeforeSuite
    public void setupConfig() {
        Config.initialize(); // Load configuration settings
    }

    /**
     * Sets up the WebDriver and other necessary components before each test class.
     * Retrieves credentials from a file and performs login.
     * 
     * @param ctx The TestNG context used to set attributes
     * @param credentialsFilePath Path to the JSON file containing test credentials
     * @throws MalformedURLException If the URL is malformed
     */
    @BeforeClass
    @Parameters({"credentialsFilePath"})
    public void setupDriver(ITestContext ctx, String credentialsFilePath) throws MalformedURLException {
        driver = DriverFactory.getDriver(); // Initialize the WebDriver
        ctx.setAttribute(Constants.DRIVER, driver); // Set WebDriver attribute in the context
        if (credentialsFilePath == null || credentialsFilePath.isEmpty()) {
            throw new IllegalArgumentException("credentialsFilePath parameter must be set"); // Validate input
        }
        credentials = JsonUtil.getTestData(credentialsFilePath, Credentials.class); // Load credentials
        loginPage = new LoginPage(driver); // Initialize page object for login
        homePage = login(); // Perform login
        globalHeader = homePage.getGlobalHeader(); // Initialize page object for global header
        globalFooter = homePage.getGlobalFooter(); // Initialize page object for global footer
        globalMenu = homePage.getGlobalMenu(); // Initialize page object for global menu
    }
     
    /**
     * Cleans up after each test class. Signs out if login was successful and quits the WebDriver.
     */
    @AfterClass(alwaysRun = true)
    public void quitDriver() {
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
        DriverFactory.quitDriver(); // Quit the WebDriver
    }

    /**
     * Performs login using the provided credentials and returns the HomePage object.
     * 
     * @return HomePage object representing the page after successful login
     */
    private HomePage login() {
        String email;
        String password;
        email = credentials.email(); // Retrieve email from credentials
        password = credentials.password(); // Retrieve password from credentials
        try {
            loginPage.goTo(Config.get(Constants.TEST_STORE_URL)); // Navigate to the login page
            Assert.assertTrue(loginPage.isDisplayed()); // Verify login page is displayed
            homePage = loginPage.login(email, password); // Perform login
            //Assert.assertTrue(globalHeader.getMenuHeader().isDisplayed()); // Optionally verify header
            isLoginSuccessful = true; // Set flag indicating successful login
            return homePage; // Return HomePage object
        } catch (AssertionError | Exception e) {
            log.error("Login failed: {}", e.getMessage()); // Log error message
            throw new RuntimeException("Login failed: {}" + e.getMessage(), e); // Rethrow as runtime exception
        }
    }
}
