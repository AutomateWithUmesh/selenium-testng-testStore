/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.tests;

/**
 *
 * @author umesh
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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

    protected boolean isLoginSuccessful = false;

    protected WebDriver driver;
    private Credentials credentials;
    private  LoginPage loginPage;
    protected  HomePage homePage;
    protected  GlobalHeader globalHeader;
    protected  GlobalFooter globalFooter;
    protected  GlobalMenu globalMenu;

    @BeforeSuite
    public void setupConfig() {
        Config.initialize();
    }

    @BeforeClass
    @Parameters({"credentialsFilePath"})
    public void setupDriver(ITestContext ctx, String credentialsFilePath) throws MalformedURLException {
        driver = DriverFactory.getDriver();
        ctx.setAttribute(Constants.DRIVER, driver);
        if (credentialsFilePath == null || credentialsFilePath.isEmpty()) {
            throw new IllegalArgumentException("credentialsFilePath parameter must be set");
        }
        credentials = JsonUtil.getTestData(credentialsFilePath, Credentials.class);
        loginPage = new LoginPage(driver);
        homePage = login();
        globalHeader = homePage.getGlobalHeader();
        globalFooter = homePage.getGlobalFooter();
        globalMenu = homePage.getGlobalMenu();
    }
     
    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        if (isLoginSuccessful) {
            log.info("Running the sign out");
            globalHeader.signout();
            Assert.assertTrue(loginPage.isDisplayed());
            log.info("Sign out completed");
            driver.manage().deleteAllCookies();
            log.info("cookies deleted");
        } else {
            log.info("Skipping the sign out as login failed");
            throw new SkipException("Skipping the sign out as login failed");
        }
        DriverFactory.quitDriver();
    }

    private HomePage login() {
        String email;
        String password;
        email = credentials.email();
        password = credentials.password();
        try {
            loginPage.goTo(Config.get(Constants.TEST_STORE_URL));
            Assert.assertTrue(loginPage.isDisplayed());
            homePage = loginPage.login(email, password);
            //Assert.assertTrue(globalHeader.getMenuHeader().isDisplayed());
            isLoginSuccessful = true;
            return homePage;
        } catch (AssertionError | Exception e) {
            log.error("Login failed: {}", e.getMessage());
            throw new RuntimeException("Login failed: {}" + e.getMessage(), e);
        }
    }
}
