package com.Ecommerce.register;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.GenericLibrary.BaseTest;
import com.Ecommerce.GenericLibrary.ExcelUtility;
import com.Ecommerce.ObjectRepository.RegisterPage;
import com.Ecommerce.ObjectRepository.WelcomePage;

public class RegisterFunctionalityTest extends BaseTest {

	@DataProvider(name = "registerData")
	public Object[][] registerData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.readMultipleData(EXCEL_PATH, REG_SHEET);
	}

	@Test(dataProvider = "registerData",groups = {"ST","RT"})
	public void registerTest(String gender, String firstName, String lastName, String password)
			throws InterruptedException {

		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		RegisterPage rp = new RegisterPage(driver);
		rp.registerFunctionality(driver, gender, firstName, lastName, w.generateEmail(), password);
	}

}
