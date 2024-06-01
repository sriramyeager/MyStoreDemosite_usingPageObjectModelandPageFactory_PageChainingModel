package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.baseClass;
import com.qa.pages.AccountCreationPage;
import com.qa.pages.IndexPage;
import com.qa.pages.LoginPage;

public class AccountCreatePageTest extends baseClass {

	public AccountCreatePageTest() {
		super();
	}

	WebDriver driver; 
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
    
	
	@BeforeMethod (groups = {"Smoke","Sanity","Regression"})
	public void setup(){
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));

	}
	@AfterMethod (groups = {"Smoke","Sanity","Regression"}) 
	public void tearDown(){
		driver.quit();
	}
	@Test(groups = "Sanity")
	public void verifyCreateAccountPageTest() {
		indexPage = new IndexPage(driver);
		loginPage= indexPage.clickSignBtn();
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("email"));
		Boolean result = accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
	}











}
