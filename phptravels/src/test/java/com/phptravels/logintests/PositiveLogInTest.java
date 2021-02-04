package com.phptravels.logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.base.TestUtilities;
import com.phptravels.pages.LoginPage;
import com.phptravels.pages.SecureAreaPage;

public class PositiveLogInTest extends TestUtilities {

	@Test
	public void positiveLogInTest() {
		
		System.out.println("starting positive test");

		LoginPage loginPage = new LoginPage(driver);
		String expectedPageTitle = "My Account";
		String expectedUrl = "https://www.phptravels.net/account/";
		loginPage.openPage();
		
		SecureAreaPage secureAreaPage = loginPage.fillingTheCredentials("user@phptravels.com","demouser");
		secureAreaPage.waitForPageToLoad();
		
		// Verifications
		// 1 -Verify title of the page is correct - My Account
		System.out.println("verifying Page Title");
		String actualTitle = secureAreaPage.getTitle();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page title is not expected. \nExpected: " + expectedPageTitle + "\nActual: " + actualTitle);
		
		//2- verify the URL
		System.out.println("verifying new URL");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		
		

	}

}
