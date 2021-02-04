package com.phptravels.optiontest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.base.TestUtilities;
import com.phptravels.pages.OptionPage;

public class OptionTest extends TestUtilities {

	@Test
	public void optionTest() {
		
		OptionPage optionPage = new OptionPage(driver);
		optionPage.open();
		optionPage.dismissCookies();
		String value = "248";
		sleep(2000);
//		optionPage.getSliderTo(value);
//		sleep(2000);
//		 String selectedRange = optionPage.getNumberText();
//		//verify the price range
//		 Assert.assertEquals(selectedRange, value, "price range should be" + value);
		
		optionPage.pickDirection();
		sleep(2000);
		optionPage.chooseAirline();
		optionPage.clickSearch();
		optionPage.confirmWithoutFillingIn();
		String message = optionPage.getErrorText();
		System.out.println("The error messages are " + message);
		Assert.assertTrue(message.contains("is required"), "Message doesn't contain expected text.");
		optionPage.fillInForm();
}
}
