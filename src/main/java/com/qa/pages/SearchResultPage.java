package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver driver;

	@FindBy(xpath = "(//div[@class='left-block']//div)[1]")
	WebElement productResult;



	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean isProductAvailable() {
		return productResult.isDisplayed();
	}

	public AddToCartPage clickOnProduct() {
		productResult.click();
	return new AddToCartPage(driver);
	}



}


