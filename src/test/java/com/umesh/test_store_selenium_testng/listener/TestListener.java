package com.umesh.test_store_selenium_testng.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

/**
 * Implementation of TestNG ITestListener to integrate with ExtentReports for reporting test results.
 * This listener generates an HTML report for the test execution and captures screenshots for failed tests.
 * 
 * @Author Umesh Deshmukh
 */
public class TestListener implements ITestListener {

    // Thread-local variable to store ExtentTest instances for parallel test execution.
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    // Map to store ExtentTest instances keyed by test names.
    protected static Map<String, ExtentTest> extentTestMap = new HashMap<>();
    
    // ExtentReports instance for generating the test report.
    protected ExtentReports extent;
    
    // ExtentTest instance for recording test results.
    protected ExtentTest extentTest;

    /**
     * Initializes ExtentReports and attaches a reporter to generate the HTML report.
     * Sets system information for the report.
     * 
     * @param itc Test context containing information about the test execution.
     */
    @Override
    public void onStart(ITestContext itc) {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Automation_Report.html");
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Automation Run Report");
            sparkReporter.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User Name", "Umesh Deshmukh");
        }
    }

    /**
     * Creates a new test entry in the report for the started test method.
     * 
     * @param itr Information about the test method that has started.
     */
    @Override
    public void onTestStart(ITestResult itr) {
        String testName = itr.getTestContext().getName() + " - " + itr.getMethod().getMethodName();
        extentTest = extent.createTest(testName);
        test.set(extentTest);
        extentTestMap.put(testName, extentTest);
    }

    /**
     * Logs a success message to the report for the passed test method.
     * 
     * @param itr Information about the test method that has passed.
     */
    @Override
    public void onTestSuccess(ITestResult itr) {
        test.get().pass("Test Passed");
    }

    /**
     * Logs a failure message and captures a screenshot if the test method fails.
     * 
     * @param itr Information about the test method that has failed.
     */
    @Override
    public void onTestFailure(ITestResult itr) {
        test.get().fail("Test Failed");
        WebDriver driver = (WebDriver) itr.getTestContext().getAttribute("driver");
        if (driver != null) {
            String screenshotPath = takescreenshot(driver, itr.getMethod().getMethodName());
            test.get().addScreenCaptureFromPath(screenshotPath);
        }
        test.get().fail(itr.getThrowable());
    }

    /**
     * Logs a skip message to the report for the skipped test method.
     * 
     * @param itr Information about the test method that was skipped.
     */
    @Override
    public void onTestSkipped(ITestResult itr) {
        test.get().skip("Test Skipped");
    }

    /**
     * Flushes the ExtentReports instance to write the results to the report file.
     * 
     * @param itc Test context containing information about the test execution.
     */
    @Override
    public void onFinish(ITestContext itc) {
        if (extent != null) {
            extent.flush();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult itr) {
        throw new UnsupportedOperationException("Not supported yet."); // This method is not implemented.
    }

    /**
     * Captures a screenshot of the current browser window.
     * 
     * @param driver WebDriver instance used to take the screenshot.
     * @param methodName Name of the test method for naming the screenshot file.
     * @return The path to the saved screenshot file.
     */
    private String takescreenshot(WebDriver driver, String methodName) {
        String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + methodName + "-" + dateName + ".png";
        File destFile = new File(screenshotPath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
    
    /**
     * Provides access to the current ExtentTest instance for the current thread.
     * 
     * @return The current ExtentTest instance.
     */
    public static ExtentTest getTest() {
        return test.get();
    }
}
