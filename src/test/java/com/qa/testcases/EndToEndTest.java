package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.baseClass;
import com.qa.pages.AddToCartPage;
import com.qa.pages.AddressPage;
import com.qa.pages.IndexPage;
import com.qa.pages.LoginPage;
import com.qa.pages.OrderConfirmationPage;
import com.qa.pages.OrderPage;
import com.qa.pages.OrderSummaryPage;
import com.qa.pages.PaymentPage;
import com.qa.pages.SearchResultPage;
import com.qa.pages.ShippingPage;

public class EndToEndTest extends baseClass {

	public EndToEndTest() {
		super();
	}

	WebDriver driver; 
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;


	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(){
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));

	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	@Test(groups = "Regression")
	public void addToCartTest() {
		indexPage = new IndexPage(driver);
		searchResultPage =  indexPage.searchProduct("blouse");	
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickCheckOut();
		loginPage =orderPage.proceedToCheckOut();
		addressPage = loginPage.login1(prop.getProperty("emailAddress"), prop.getProperty("password"));
		shippingPage = addressPage.addressCheckOut();
		shippingPage.checkTheTerms();
		paymentPage = shippingPage.shippingCheckOut();
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage= orderSummaryPage.clickOnConfirmBtn();
		String actualMsg = orderConfirmationPage.validateConfirmMsg();
		String expectedMsg ="Your order on My Shop is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);





	}
}
