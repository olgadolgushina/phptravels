package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsletterPage extends BasePageObject{
	private By subscriptionButton = By.xpath("//div[@id='newsletter']//span");
	
	public NewsletterPage(WebDriver driver) {
		super(driver);
		
	}

	public void clickSubscription() {
		
		
		WebDriverWait wait2 = new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(subscriptionButton));
		 click(subscriptionButton);
		 System.out.println("clicking NO to subscription");
		 
	}
	

}
