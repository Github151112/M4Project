package com.Ecommerce.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest implements IAutoConstant {

	FileUtility f = new FileUtility();
	WebDriverUtility w = new WebDriverUtility();
	public WebDriver driver;

	@BeforeSuite
	public void toConnectServer() {
		Reporter.log("==server connected successfully==", true);
	}

	@BeforeTest
	public void toConnectDatabase() {
		Reporter.log("==database connected successfully", true);
	}

	@BeforeClass
	public void setUp() {
		String browser = f.readDataFromProperty(PROP_PATH, "browser");
		String url = f.readDataFromProperty(PROP_PATH, "url");
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			Reporter.log("Invalid Browser", true);
		}
		w.maximizeWindow(driver);
		w.implicitWait(driver, 10);
		driver.get(url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@AfterTest
	public void closeDatabase() {
		Reporter.log("==database closed successfully", true);
	}

	@AfterSuite
	public void closeServer() {
		Reporter.log("==server closed successfully", true);
	}

}
