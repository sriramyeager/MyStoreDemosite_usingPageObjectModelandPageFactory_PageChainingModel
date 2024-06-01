package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement  myShopLogo;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;

	@FindBy(xpath = "//form[@id='searchbox']//button[1]")
	WebElement searchBtn;




	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public LoginPage clickSignBtn() {
		signInBtn.click();
		return new LoginPage(driver);
	}
	
	public boolean validateLogo() {
		return myShopLogo.isDisplayed();
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchProductBox.sendKeys(productName);
		searchBtn.click();
		return new SearchResultPage(driver);
	}
    
	
	public String myStoreTitle() {
	String myStoreTitle1 = driver.getTitle();
	return myStoreTitle1;
	}


}
