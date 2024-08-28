/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.listener;

/**
 *
 * @author umesh
 */
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

public class TestListener implements ITestListener {

    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    protected static Map<String, ExtentTest> extentTestMap = new HashMap<>();
    protected ExtentReports extent;
    protected ExtentTest extentTest;

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

    @Override
    public void onTestStart(ITestResult itr) {
        String testName = itr.getTestContext().getName() + " - " + itr.getMethod().getMethodName();
        extentTest = extent.createTest(testName);
        test.set(extentTest);
        extentTestMap.put(testName, extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult itr) {
        test.get().pass("Test Passed");
    }

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

    @Override
    public void onTestSkipped(ITestResult itr) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext itc) {
        if (extent != null) {
            extent.flush();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult itr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
    
    public static ExtentTest getTest() {
        return test.get();
    }
}
