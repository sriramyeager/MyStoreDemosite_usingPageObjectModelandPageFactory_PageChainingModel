package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.baseClass;
import com.qa.pages.IndexPage;

public class IndexPageTest extends baseClass{

	public IndexPageTest(){
		super();
	}

	WebDriver driver;
	IndexPage indexPage;
	
	@BeforeTest(groups = {"Smoke","Sanity","Regression"}) 
	public void setup(){
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
	}
	@AfterTest(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		 indexPage = new IndexPage(driver);
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		 String actualTitle =indexPage.myStoreTitle();
		 //System.out.println(actualTitle);
		 Assert.assertEquals(actualTitle, "My Shop");
	}
	
	
    
}
