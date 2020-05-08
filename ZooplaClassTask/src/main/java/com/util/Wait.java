package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public void getExplicitWait(WebDriver driver, WebElement element) {

		WebDriverWait Wait = new WebDriverWait(driver,45);
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
