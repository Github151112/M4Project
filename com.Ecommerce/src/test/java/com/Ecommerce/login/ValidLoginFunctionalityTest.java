package com.Ecommerce.login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.GenericLibrary.BaseTest;
import com.Ecommerce.GenericLibrary.ExcelUtility;
import com.Ecommerce.ObjectRepository.LoginPage;
import com.Ecommerce.ObjectRepository.RegisterPage;
import com.Ecommerce.ObjectRepository.WelcomePage;

public class ValidLoginFunctionalityTest extends BaseTest {

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.readMultipleData(EXCEL_PATH, lOGIN_SHEET);
	}

	@Test(dataProvider = "loginData",groups = {"FT","RT"})
	public void loginTest(String email, String password) throws InterruptedException {

		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login","login page is displayed");
		LoginPage lp = new LoginPage(driver);
		lp.loginFunctionality(email, password);
		RegisterPage r = new RegisterPage(driver);
		Assert.assertEquals(r.getLogoutLink().isDisplayed(), true,"logged in sucessfully");

	}

}
