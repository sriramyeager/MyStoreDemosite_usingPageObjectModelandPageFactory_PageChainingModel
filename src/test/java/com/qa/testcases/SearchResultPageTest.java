package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.baseClass;
import com.qa.pages.IndexPage;
import com.qa.pages.SearchResultPage;

public class SearchResultPageTest extends baseClass {

	public SearchResultPageTest() {
		super();
	}

	WebDriver driver; 
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"}) 
	public void setup(){
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));

	}
	@AfterMethod (groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void productAvailabiltyTest() {
		indexPage = new IndexPage(driver);
		searchResultPage =  indexPage.searchProduct("blouse");
		Boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		
		
	}
	
	
	
	
	
}
