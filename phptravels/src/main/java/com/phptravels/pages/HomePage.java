package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePageObject {

	private By flightLocator = By.linkText("FLIGHTS");

	private By acceptCookie = By.xpath("//button[@class='cc-btn cc-dismiss']");

	
	private By clickElement = By.xpath("//a[@class='chosen-single']");
	private By businessLocator = By.xpath("//ul[@class='chosen-results']/li[.='Business']");
	private By calendar = By.xpath("//input[@id='FlightsDateStart']");
	private By date = By.xpath("//div[@id='datepickers-container']/div[8]//div[.='30']");
	private By searchButton = By.xpath("//div[@id='flights']/div//form[@role='search']//button[@type='submit']");
	private By peopleCount = By.xpath("(//button[@class='btn btn-white bootstrap-touchspin-up '])[3]");

	public HomePage(WebDriver driver) {
		super(driver);

	}

	public void waitForHomePageToLoad() {
		System.out.println("wait for home page to load");
		waitForVisibilityOf(flightLocator);

	}

	public void dismissCookies() {
		click(acceptCookie);

	}

//	public void selectOption(String OptionPackage) {
//		System.out.println("Selecting option " + OptionPackage + " from dropdown");
//		WebElement dropdownElement = find(dropDown);
//		Select dropDown = new Select(dropdownElement);
//		dropDown.selectByValue(OptionPackage);
//
//	}
	public void selectOption() {
		System.out.println("Selecting option from dropdown");
		click(clickElement);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(businessLocator));
		click(businessLocator);

	}

	public void openFlightPage() {
		System.out.println("opening flight link");
		click(flightLocator);

	}

	public String getSelectedOption() {
		String text = find(clickElement).getText();
		System.out.println("verifying the cabinclass");
		return text;
	}

	public void pickTheDate() {
		System.out.println("picking a date");
		click(calendar);
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(date));
		click(date);

	}

	public String getPickedDate() {
		System.out.println("verifying the date");
		String number = find(calendar).getText();
		System.out.println("actual date: " + number);
		return number;
	}

	public OptionPage clickSearch() {
		System.out.println("clicking search button");
		click(searchButton);
		return new OptionPage(driver);

	}

	// people 4 people
	public void pickPeople() {
		System.out.println("picking people");
		for (int i = 0; i < 3; i++) {

			click(peopleCount);

		}
	}

	// practicing verification
//	public boolean verifyPeople(String correctNumberOfPeople) {
//		System.out.println("verifying the number of people");
//
//		WebElement peopleInput = driver
//				.findElement(By.xpath("//input[@class='form-control touch-spin-03 form-readonly-control']"));
//		String value = peopleInput.getAttribute("value");
//		System.out.println("number of people: " + value);
//
//		if (value.equalsIgnoreCase("2")) {
//
//			return true;
//		}
//		return false;
//	
//
//	}

}
