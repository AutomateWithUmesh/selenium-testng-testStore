/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umesh.test_store_selenium_testng.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;

/**
 *
 * @author umesh
 */
public class DriverFactory {
    
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() throws MalformedURLException {
		WebDriver webDriver;
		if (driver.get() == null) {
			if (Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED))) {
				webDriver = getRemoteDriver();
			} else { 
				webDriver = getLocalDriver();
			}
			driver.set(webDriver);
		}
		return driver.get();
	}
	
	private static WebDriver getRemoteDriver() throws MalformedURLException {
		WebDriver remoteDriver;
		Capabilities capabilities = new ChromeOptions();
		if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
			capabilities = new FirefoxOptions();
		}
		String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
		String hubHost = Config.get(Constants.GRID_HUB_HOST);
		String url = String.format(urlFormat, hubHost);
		//log.info("grid url: {}", url);
		remoteDriver = new RemoteWebDriver(new URL(url), capabilities);
		return remoteDriver;
	}
	
	private static WebDriver getLocalDriver() {
		WebDriver localDriver = null;
		
		if (Constants.CHROME.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
			WebDriverManager.chromedriver().setup();
			localDriver = new ChromeDriver();
		} else if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
			WebDriverManager.firefoxdriver().setup();
			localDriver = new FirefoxDriver();
		}
		driver.set(localDriver);
		localDriver.manage().window().maximize();
		return localDriver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.get().quit();
			driver.remove();
		}
	}
    
}
