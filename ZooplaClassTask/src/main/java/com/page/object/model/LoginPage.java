package com.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	private WebElement MyCookies;
	@FindBy(xpath ="//*[@class='button button--tertiary-dark account-link__text']")
	private WebElement SignInButton;
	@FindBy(xpath ="//*[@type='email']")
	private WebElement Email;
	@FindBy(xpath ="//*[@type='password']")
	private WebElement Password;
	@FindBy(xpath ="//*[@id='signin_submit']")
	private WebElement SignIn;
	
	public WebElement getMyCookies() {
		return MyCookies;
	}
	public WebElement getSignInButton() {
		return SignInButton;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getSignIn() {
		return SignIn;
	}
	
	

}
