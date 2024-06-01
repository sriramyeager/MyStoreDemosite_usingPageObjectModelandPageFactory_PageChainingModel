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

public class LoginPageTest extends baseClass{

	public LoginPageTest() {
		super();
	}

	WebDriver driver;
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
	@Test(groups = {"Smoke","Sanity"})
	public void loginTest() {
		IndexPage indexPage = new IndexPage(driver); 
		loginPage =indexPage.clickSignBtn();
		homePage =loginPage.login(prop.getProperty("emailAddress"), prop.getProperty("password"));
		String actualURL =  homePage.getCurrURL();
		String expectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
	}



}
