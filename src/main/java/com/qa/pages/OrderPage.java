package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	WebDriver driver;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedChkOut;
	
	public OrderPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateTotalPrice() {
		return totalPrice.isDisplayed();
	}
	
	public LoginPage proceedToCheckOut() {
		proceedChkOut.click();
		return new LoginPage(driver);
	}
}
