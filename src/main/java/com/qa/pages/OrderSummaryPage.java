package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {

	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='I confirm my order']")
	WebElement confirmOrder;
	
	
	
	public OrderSummaryPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirmBtn() {
		confirmOrder.click();
		return new OrderConfirmationPage(driver);
	}
	
}
