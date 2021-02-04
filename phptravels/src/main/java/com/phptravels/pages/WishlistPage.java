package com.phptravels.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePageObject {
	private By messageText = By.xpath("//div[@id='wishlist']");
	private By newsletterLink = By.linkText("NEWSLETTER");
	
	

	
	public WishlistPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean isCorrectMessage(String correctWishlistMessage) {
		
		System.out.println("verifying the Wishlist message");
		
		if (getText(messageText).equals(correctWishlistMessage)) {
			return true;

		}
		return false;
}


	public NewsletterPage openNewsletterPage() {
		System.out.println("opening newsletter link");
		 click(newsletterLink);
		 return new NewsletterPage(driver);
	}

	
}
