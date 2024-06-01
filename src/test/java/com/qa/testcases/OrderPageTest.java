package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.baseClass;
import com.qa.pages.AddToCartPage;
import com.qa.pages.IndexPage;
import com.qa.pages.OrderPage;
import com.qa.pages.SearchResultPage;

public class OrderPageTest extends baseClass {

	public OrderPageTest() {
		super();
	}

	WebDriver driver; 
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage; 
    
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(){
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	@Test(groups = "Regression")
	public void verifyTotalPrice() {
		indexPage = new IndexPage(driver);
		searchResultPage =  indexPage.searchProduct("blouse");	
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
	  	orderPage = addToCartPage.clickCheckOut();
	  	Boolean result = orderPage.validateTotalPrice();
	  	Assert.assertTrue(result);
	 
	}
}
