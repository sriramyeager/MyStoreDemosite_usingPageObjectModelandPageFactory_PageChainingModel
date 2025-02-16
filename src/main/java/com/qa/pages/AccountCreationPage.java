package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {

	WebDriver driver;

	
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement accountCreatePage;


	public AccountCreationPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	
	public Boolean validateAccountCreatePage() {
		return accountCreatePage.isDisplayed();
	}
	
	
	
	
	
	
	
	
}
