package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePageObject {
	private By countryText = By.xpath("//div[@class='chosen-container chosen-container-single']");
	private By submitButton = By.xpath("//form[@id='profilefrm']//button[@type='submit']");
	private By acceptCookie = By.xpath("//div[@id='cookyGotItBtnBox']//button[@role='button']");
	
	

	public ProfilePage(WebDriver driver) {
		super(driver);
	}


	public String getCountryValue() {
		String value = find(countryText).getText();
		System.out.println(("Country value is " + value));
		return value;
		
	}
	

	public void clickSubmit() {
		System.out.println("Clicking submit button");
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.elementToBeClickable(submitButton));
		click(submitButton);
		
	}


	public void dismissCookies() {
		click(acceptCookie);
		
	}



}
