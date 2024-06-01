package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement confirmMessag;
	
	
	
	
	public OrderConfirmationPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String validateConfirmMsg() {
		String confirmMsg = confirmMessag.getText();
		 return confirmMsg;
		
	}
}
