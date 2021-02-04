package com.phptravels.profiletests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.base.TestUtilities;
import com.phptravels.pages.LoginPage;
import com.phptravels.pages.NewsletterPage;
import com.phptravels.pages.ProfilePage;
import com.phptravels.pages.SecureAreaPage;
import com.phptravels.pages.WishlistPage;

public class ProfileTests extends TestUtilities {

	@Test
	public void profileTests() {

		LoginPage loginPage = new LoginPage(driver);
		String correctCountry = "Australia";
		String correctWishlistMessage = "No Wishlist Items Found";
		

		loginPage.openPage();

		SecureAreaPage secureAreaPage = loginPage.fillingTheCredentials("user@phptravels.com", "demouser");
		secureAreaPage.waitForPageToLoad();
		
		ProfilePage  profilePage = secureAreaPage.openProfilePage();
		
		 String actualCountry = profilePage.getCountryValue();
		
		//verify the country text
		
		Assert.assertTrue(correctCountry.equals(actualCountry), "Country is not expected. \nExpected: " + correctCountry + "\nActual: " + actualCountry);
		sleep(5000);

		
		profilePage.dismissCookies();
		
		profilePage.clickSubmit();
		
		// verify back to secure page
		
		
       secureAreaPage.waitForPageToLoad();
       
       // wishlist test 
       
       WishlistPage wishlistPage = secureAreaPage.openWishlistPage();
       
       
       
       Assert.assertTrue(wishlistPage.isCorrectMessage(correctWishlistMessage), "Message is not expected");
       sleep(5000);
		
		// newsletter test
       
       NewsletterPage  newsletterPage = wishlistPage.openNewsletterPage();
       newsletterPage.clickSubscription();
       sleep(5000);
		
	}

}
