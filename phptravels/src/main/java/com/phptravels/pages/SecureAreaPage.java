package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

	public By helloMessage = By.cssSelector(".text-align-left");
//	private By helloMessage = By.linkText("Hi, Demo User");
	private By profileLink = By.linkText("MY PROFILE");
	private By wishlistLink = By.linkText("WISHLIST");
	private By homeLink = By.linkText("HOME");

	public SecureAreaPage(WebDriver driver) {
		super(driver);

	}

	public void waitForPageToLoad() {
		System.out.println("wait for  page to load");
		waitForVisibilityOf(helloMessage);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public ProfilePage openProfilePage() {
		System.out.println("opening profile link");
		click(profileLink);
		return new ProfilePage(driver);
	}

	public WishlistPage openWishlistPage() {
		System.out.println("opening wishlist link");
		click(wishlistLink);
		return new WishlistPage(driver);
	}

	public HomePage openHomePage() {

		System.out.println("opening home link");
		click(homeLink);
		return new HomePage(driver);
	}

}
