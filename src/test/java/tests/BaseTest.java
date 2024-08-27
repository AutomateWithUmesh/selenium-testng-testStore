/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

/**
 *
 * @author umesh
 */
import listener.TestListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.Config;
import util.Constants;

@Listeners({ TestListener.class })
public abstract class BaseTest {

	private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);

	protected WebDriver driver;

	@BeforeSuite
	public void setupConfig() {
		Config.initialize();
	}

	@BeforeTest
	public void setDriver(ITestContext ctx) throws MalformedURLException {
		driver = DriverFactory.getDriver();
	}
	ctx.setAttribute(Constants., ctx);

	private WebDriver getRemoteDriver() throws MalformedURLException {
		/*
		 * // http://localhost:4444/wd/hub Capabilities capabilities; if
		 * (System.getProperty("browser").equalsIgnoreCase("chrome")) {
		 * //if(browser.equalsIgnoreCase("chrome")) { use when we want to run test based
		 * on browser value given in xml. capabilities = new ChromeOptions(); } else {
		 * capabilities = new FirefoxOptions(); } return new RemoteWebDriver(new
		 * URL("http://localhost:4444/wd/hub"), capabilities);
		 */
		Capabilities capabilities = new ChromeOptions();
		if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
			capabilities = new FirefoxOptions();
		}
		String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
		String hubHost = Config.get(Constants.GRID_HUB_HOST);
		String url = String.format(urlFormat, hubHost);
		log.info("grid url: {}", url);
		return new RemoteWebDriver(new URL(url), capabilities);
	}

	private WebDriver getLocalDriver() {
		// WebDriverManager.chromedriver().clearDriverCache().setup();
//		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
//		this.driver = new ChromeDriver();
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		return this.driver;
	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}

	// to watch selenium grid performing action, lets add delays after each method
	/*
	 * @AfterMethod public void sleep() {
	 * Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5)); }
	 */
}