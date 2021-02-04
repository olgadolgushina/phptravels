package com.phptravels.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)

	protected void methodsetUp(String browser) {
		System.out.println("Method Set Up");
		driver = BrowserDriverFactory.getDriver(browser);
	}

//	@AfterMethod(alwaysRun = true)
//	protected void methodtearDown() {
//		System.out.println("Method tear down");
//		driver.quit();
//	}

}
