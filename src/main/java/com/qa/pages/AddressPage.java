package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

	 WebDriver driver;
	 
	 @FindBy(xpath = "//span[text()='Proceed to checkout']")
	 WebElement proceedToChkOut;

	public AddressPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage addressCheckOut() {
		proceedToChkOut.click();
		return new ShippingPage(driver);
	}
}
