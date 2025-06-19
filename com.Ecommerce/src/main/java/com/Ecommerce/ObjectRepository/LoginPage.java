package com.Ecommerce.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "Email")
	private WebElement emailTextField;

	@FindBy(id = "Password")
	private WebElement passwordTextField;

	@FindBy(id = "RememberMe")
	private WebElement rememberMeCheckbox;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;

	public void loginFunctionality(String email, String password) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		rememberMeCheckbox.click();
		loginButton.click();
	}

	public void invalidloginFunctionality(String email, String password) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		rememberMeCheckbox.click();
		loginButton.click();
		emailTextField.clear();
	}

}
