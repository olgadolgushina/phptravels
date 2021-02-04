package com.phptravels.bookingtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.base.TestUtilities;
import com.phptravels.pages.HomePage;
import com.phptravels.pages.LoginPage;
import com.phptravels.pages.OptionPage;
import com.phptravels.pages.SecureAreaPage;

public class BookingTest extends TestUtilities {

	@Test
	public void bookingTest() {
		String correctNumberOfPeople = "2";

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openPage();

		SecureAreaPage secureAreaPage = loginPage.fillingTheCredentials("user@phptravels.com", "demouser");
		secureAreaPage.waitForPageToLoad();

		HomePage homePage = secureAreaPage.openHomePage();

		homePage.dismissCookies();

		homePage.openFlightPage();

		homePage.waitForHomePageToLoad();

		homePage.selectOption();

		String selectedOption = homePage.getSelectedOption();
		sleep(5000);
		Assert.assertTrue(selectedOption.equals("Business"), "Should be Business: " + selectedOption);
		sleep(5000);
		homePage.pickTheDate();

		// verify dates
//      	String selectedDate = homePage.getPickedDate();
//      	sleep(5000);
//      	Assert.assertTrue(selectedDate.contains("2020"), "date should be 29: " + selectedDate);
//      	

		
		// pick the number of people
		homePage.pickPeople();

		sleep(5000);

		// practicing verification
		// Assert.assertTrue(homePage.verifyPeople(correctNumberOfPeople), "Number of
		// people is not expected");

		 homePage.clickSearch();
	}

}
