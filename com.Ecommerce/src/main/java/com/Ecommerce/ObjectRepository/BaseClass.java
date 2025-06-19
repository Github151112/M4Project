package com.Ecommerce.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public BaseClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
