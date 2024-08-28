/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.tests;

/**
 *
 * @author umesh
 */
import com.umesh.test_store_selenium_testng.pages.DashboardPage;
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
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @BeforeSuite
    public void setupConfig() {
        Config.initialize();
    }

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        driver = DriverFactory.getDriver();
        ctx.setAttribute(Constants.DRIVER, driver);
    }

    @BeforeClass
    @Parameters({"credentialsFilePath"})
    public void loginToApplication(String credentialsFilePath) {
        credentials = JsonUtil.getTestData(credentialsFilePath, Credentials.class);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        login();
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() {
        DriverFactory.quitDriver();
    }

    private void login() {
        String email;
        String password;
        email = credentials.email();
        password = credentials.password();
        try {
            loginPage.goTo(Config.get(Constants.TEST_STORE_URL));
            Assert.assertTrue(loginPage.isDisplayed());
            loginPage.login(email, password);
            Assert.assertTrue(dashboardPage.getHeaderComponent().isDisplayed());
            isLoginSuccessful = true;
        } catch (AssertionError | Exception e) {
            log.error("Login failed: {}", e.getMessage());
            throw new RuntimeException("Login failed: {}" + e.getMessage(), e);
        }
    }

    @AfterClass
    public void signoutFromApplication() {
        if (isLoginSuccessful) {
            log.info("Running the sign out");
            dashboardPage.getHeaderComponent().signout();
            Assert.assertTrue(loginPage.isDisplayed());
            log.info("Sign out completed");
        } else {
            log.info("Skipping the sign out as login failed");
            throw new SkipException("Skipping the sign out as login failed");
        }
    }
}
