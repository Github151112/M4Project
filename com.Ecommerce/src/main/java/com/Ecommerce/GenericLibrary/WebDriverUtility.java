package com.Ecommerce.GenericLibrary;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public String generateEmail() {
		Random r = new Random();
		int no = r.nextInt(10000);
		String email = "aman" + no + "@gmail.com";
		return email;
	}
	 public static String getCurrentDateTimeAsNumber() {
	        LocalDateTime now = LocalDateTime.now();
	        // Format: yyyyMMddHHmmss
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        return now.format(formatter);
	    }

}
