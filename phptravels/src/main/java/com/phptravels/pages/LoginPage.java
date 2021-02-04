package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

	private String pageURL = "https://www.phptravels.net/login";
	private By usernameLocator = By.xpath("//input[@type='email']");
	private By passwordLocator = By.xpath("//input[@type='password']");
	private By logInButtonLocator = By.xpath("//form[@id='loginfrm']/button[@type='submit']");
	private By errorMessageLocator = By.xpath("//form[@id='loginfrm']//div[@class='alert alert-danger']");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void openPage() {
		System.out.println("opening main page");
		openURL(pageURL);
	}

	public SecureAreaPage fillingTheCredentials(String username, String password) {
		System.out.println("filling up the form");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
		return new SecureAreaPage(driver);

	}
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 5);
	}

	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}

}
