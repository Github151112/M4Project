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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant {

	public FileUtility f = new FileUtility();
	public WebDriverUtility w = new WebDriverUtility();
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void toConnectServer() {
		Reporter.log("==server connected successfully==", true);
	}

	@BeforeTest(alwaysRun = true)
	public void toConnectDatabase() {
		Reporter.log("==database connected successfully", true);
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) {
		//String browser = f.readDataFromProperty(PROP_PATH, "browser");
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

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	@AfterTest(alwaysRun = true)
	public void closeDatabase() {
		Reporter.log("==database closed successfully", true);
	}

	@AfterSuite(alwaysRun = true)
	public void closeServer() {
		Reporter.log("==server closed successfully", true);
	}

}
