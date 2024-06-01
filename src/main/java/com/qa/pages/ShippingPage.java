package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

	WebDriver driver;
	
	@FindBy(id = "cgv")
	WebElement terms;
	@FindBy(xpath = "(//button[@type='submit']//span)[2]")
	WebElement checkOut;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkTheTerms() {
		terms.click();
	}
	public PaymentPage shippingCheckOut() {
		checkOut.click();
		return new PaymentPage(driver);
	}
}
