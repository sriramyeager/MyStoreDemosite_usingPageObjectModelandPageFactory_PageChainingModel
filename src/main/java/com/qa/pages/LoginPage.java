/**
 * 
 */
package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class LoginPage  {

	WebDriver driver;


	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "passwd")
	WebElement passwordfield;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']//span[1]")
	WebElement signInBtn;
	
	//Create Account Field
	@FindBy(id = "email_create")
	WebElement createEmailField;

	@FindBy(xpath = "(//button[@type='submit']//span)[2]")
	WebElement clickEmailBtn;



	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public HomePage login(String email , String password) {
		emailField.sendKeys(email);
		passwordfield.sendKeys(password);
		signInBtn.click();
		return new HomePage(driver);
	}
	public AddressPage login1(String email , String password) {
		emailField.sendKeys(email);
		passwordfield.sendKeys(password);
		signInBtn.click();
		return new AddressPage(driver);
	}
	
	public AccountCreationPage createNewAccount(String email) {
		createEmailField.sendKeys(email);
		clickEmailBtn.click();
		return new AccountCreationPage(driver);
	}
}

