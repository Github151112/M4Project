package com.Ecommerce.login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.GenericLibrary.BaseTest;
import com.Ecommerce.GenericLibrary.ExcelUtility;
import com.Ecommerce.ObjectRepository.LoginPage;
import com.Ecommerce.ObjectRepository.WelcomePage;

public class InvalidLoginFunctionalityTest extends BaseTest {

	@DataProvider(name = "invalidloginData")
	public Object[][] loginData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.readMultipleData(EXCEL_PATH, INVALID_SHEET);
	}

	@Test(dataProvider = "invalidloginData")
	public void invalidLoginTest(String email, String password) throws InterruptedException {

		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.invalidloginFunctionality(email, password);
		

	}
}
