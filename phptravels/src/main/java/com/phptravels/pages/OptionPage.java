package com.phptravels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OptionPage extends BasePageObject {

	private String newURL = "https://www.phptravels.net/flights/search/LHE/DXB/oneway/economy/2020-07-30/4/0/0";
	private By sliderLocator =By.xpath("//span[@class='irs-slider to']");
	private By acceptCookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	private By priceValue = By.xpath("//span[@class='irs-to']");
	private By directionValue = By.xpath("//div[@id='group_main']//label[@class='custom-control-label go-left']");
	private By checkboxesValue = By.xpath("//label[@class='custom-control-label go-left']");
	private By airlineValue = By.xpath("(//label[@class='custom-control-label go-left'])[14]");
	private By searchButton = By.xpath("//div[@class='theme-search-results-item-preview']/div[@class='row']/form//button[@type='submit']");
	private By confirmButton = By.xpath("//button[@type='submit']");
	private By errorMessages = By.xpath("//div[@class='alert alert-danger']");
	private By nameValue = By.xpath("//input[@name='firstname']");
	private By lastnameValue = By.xpath("//input[@name='lastname']");

	public OptionPage(WebDriver driver) {
		super(driver);

	}

	public void open() {
		driver.get(newURL);

	}

	public void getSliderTo(String value) {
		System.out.println("Moving slider to " + value);
		int width = find(sliderLocator).getSize().getWidth();
		double percent = Double.parseDouble(value) / 270;
		int xOffset = (int) (width * percent);
		Actions action = new Actions(driver);
		action.dragAndDropBy(find(sliderLocator), -xOffset, 0).build().perform();
		
		
		
		
		
		
		
		
//		int steps = (int) (Double.parseDouble(value) / 1);
//
//		// Perform steps
//		pressKey(sliderLocator, Keys.ENTER);
//		for (int i = 0; i < steps; i++) {
//			pressKey(sliderLocator, Keys.ARROW_LEFT);
//		}
	}
	

	

	public void dismissCookies() {
		click(acceptCookie);

	}

	public void pickDirection() {
		click(directionValue);
		
		
	}

	public String getNumberText() {
		String price = find(priceValue).getText();
		System.out.println("The chosen value is: " + price);
		return price;
		
	}

	public void chooseAirline() {
		List<WebElement> checkbox = findAll(checkboxesValue);
		System.out.println("total airlines options are " + checkbox.size());
		System.out.println("choosing Okay Airways");
//		for (int i=0; i<checkbox.size();i++) {
//			WebElement ele = checkbox.get(i);
		click(airlineValue);
		}

	public void clickSearch() {
		System.out.println("clicking search button");
		click(searchButton);
		
	}



	public void confirmWithoutFillingIn() {
		System.out.println("confirming booking without filling in");
		click(confirmButton);
		
	}
		
	public void fillInForm() {
		click(confirmButton);
//		type("Matilda",nameValue);
//		type("Tuna",lastnameValue);
	}

	public String getErrorText() {
		return find(errorMessages).getText();
	}
}

