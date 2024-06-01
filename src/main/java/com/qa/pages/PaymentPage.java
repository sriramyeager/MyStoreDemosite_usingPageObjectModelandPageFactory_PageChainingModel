package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'Pay by bank wire (order processing will be longer)')]")
	WebElement bankwireMethod;
	

	public PaymentPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		bankwireMethod.click();
		return new OrderSummaryPage(driver);
	}
}
