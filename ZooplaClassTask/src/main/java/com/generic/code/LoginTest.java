package com.generic.code;

import java.util.concurrent.TimeUnit;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class LoginTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.zoopla.co.uk");
		System.out.println("Home Page Title : " + driver.getTitle());

		// *[@class='ui-button-primary ui-cookie-accept-all-medium-large']
		WebElement MyCookies = driver
				.findElement(By.xpath("//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']"));
		MyCookies.click();
		System.out.println("Page Title after Accept Cookies : " + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// *[@class='button button--tertiary-dark account-link__text']
		WebElement SignInButton = driver
				.findElement(By.xpath("//*[@class='button button--tertiary-dark account-link__text']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');",
				SignInButton);
		SignInButton.click();
		System.out.println("Page Title after Click SignIn : " + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// *[@type='email']
		WebElement Email = driver.findElement(By.xpath("//*[@type='email']"));
		Email.sendKeys("kawser.shafique@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// *[@type='password']
		WebElement Password = driver.findElement(By.xpath("//*[@type='password']"));
		Password.sendKeys("kawser01");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// *[@id='signin_submit']
		WebElement SignIn = driver.findElement(By.xpath("//*[@id='signin_submit']"));
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", SignIn);
		SignIn.click();
		System.out.println("Page Title after LogIn : " + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();

	}

}
