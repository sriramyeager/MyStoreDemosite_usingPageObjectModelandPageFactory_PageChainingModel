package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.baseClass;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.pages.LoginPage;

public class HomePageTest extends baseClass {

	public HomePageTest() {
		super();
	}

	WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(){
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}

	@Test(groups = "Smoke")
	public void myAccountIsDisplayed() {
		indexPage = new IndexPage(driver);
		loginPage  = indexPage.clickSignBtn();
		homePage =loginPage.login(prop.getProperty("emailAddress"), prop.getProperty("password"));
		Boolean result = homePage.myaccountText();
		Assert.assertTrue(result);

	}

	@Test(groups = "Smoke")
	public void validateWishList() {
		indexPage = new IndexPage(driver);
		loginPage  = indexPage.clickSignBtn();
		homePage =loginPage.login(prop.getProperty("emailAddress"), prop.getProperty("password"));
		Boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);

	}
	


	
















}
