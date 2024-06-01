package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {


	WebDriver driver;


	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "(//button[@type='submit']//span)[3]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//h2[text()[normalize-space()='Product successfully added to your shopping cart']]")
	WebElement addToCartMsg;


	@FindBy(xpath = "//span[text()[normalize-space()='Proceed to checkout']]")
	WebElement proccedToCheckOut;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectSize(String size1) {
		Select select = new Select(size);
		select.selectByVisibleText(size1);
	}

	public void clickOnAddToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement click =	wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		click.click();

	}

	public Boolean valdiateAddToCartMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	    WebElement visible = wait.until(ExpectedConditions.visibilityOf(addToCartMsg));
	return	visible.isDisplayed();
	}

	
	public OrderPage clickCheckOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement click =	wait.until(ExpectedConditions.elementToBeClickable(proccedToCheckOut));
		click.click();
		return new OrderPage(driver);
	}




}
