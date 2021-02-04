package com.phptravels.logintests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.base.CsvDataProviders;
import com.phptravels.base.TestUtilities;
import com.phptravels.pages.LoginPage;


public class NegativeLogInTest extends TestUtilities {

	
	@Test( dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTest(Map<String, String> testData){
		
		System.out.println("starting negative test");
		
		// Data  ( in paranteces are from headers from csv file)
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");
		
		System.out.println("Starting negativeLogInTesting  #" + no + " for " + description);
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.fillingTheCredentials(username,password);
		
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();
		
		
		
		// Verifications
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
		
	}
	
}
