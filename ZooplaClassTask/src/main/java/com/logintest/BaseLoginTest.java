package com.logintest;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.util.Highlighter;
import com.util.Wait;

public class BaseLoginTest {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.zoopla.co.uk");
		System.out.println("Home Page Title : " + driver.getTitle());

		WebElement MyCookies = driver
				.findElement(By.xpath("//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']"));
		MyCookies.click();
		System.out.println("Page Title after Accept Cookies : " + driver.getTitle());
		System.out.println("Current Url :" + driver.getCurrentUrl());

		WebElement SignInButton = driver
				.findElement(By.xpath("//*[@class='button button--tertiary-dark account-link__text']"));
		Highlighter.GetColor(driver, SignInButton);
		SignInButton.click();
		System.out.println("Current Url After SignIn :" + driver.getCurrentUrl());
		System.out.println("Login Page Title :" + driver.getTitle());

		WebElement Email = driver.findElement(By.xpath("//*[@type='email']"));
		new Wait().getExplicitWait(driver, Email);
		Highlighter.GetColor(driver, Email, "red");
		Email.sendKeys("kawser.shafique@gmail.com");

		WebElement Password = driver.findElement(By.xpath("//*[@type='password']"));
		new Wait().getExplicitWait(driver, Password);
		Highlighter.GetColor(driver, Password, "orange");
		Password.sendKeys("kawser01");

		WebElement SignIn = driver.findElement(By.xpath("//*[@id='signin_submit']"));
		new Wait().getExplicitWait(driver, SignIn);
		Highlighter.GetColor(driver, SignIn, "yellow");
		SignIn.click();
		System.out.println("Current Url After Login :" + driver.getCurrentUrl());
		System.out.println("Page Title after LogIn :" + driver.getTitle());

		driver.quit();

	}

}
