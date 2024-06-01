package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//h1[text()='My account']")
	WebElement myAccount;

	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean myaccountText() {
		return myAccount.isDisplayed();
	}
	public boolean validateOrderHistory() {
		return orderHistory.isDisplayed();
	}

	public String getCurrURL() {
		String homePageUrl = driver.getCurrentUrl();
		return homePageUrl;
	}

}
