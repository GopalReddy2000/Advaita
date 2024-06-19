package com.advaita.Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class SendDataUtils extends TestBase {

//	ElementUtils.sendKeysToElement(usernameInput, "exampleuser");
	public static void sendKeysToElement(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
//	ElementUtils.clearAndSendKeys(searchInput, "Selenium WebDriver");
	public static void clearAndSendKeys(WebElement element, String text) {
		
		ClickUtilities.highlightElement(element, driver);
		element.clear();
		element.sendKeys(text);
	}

//	  ElementUtils.sendKeysAndSubmit(passwordInput, "password123");
	public static void sendKeysAndSubmit(WebElement element, String text) {
		sendKeysToElement(element, text);
		element.submit();
	}

	
//	ElementUtils.sendKeysWithEnter(searchInput, "Selenium WebDriver");
	public static void sendKeysWithEnter(WebElement element, String text) {
		sendKeysToElement(element, text);
		element.sendKeys(Keys.ENTER);
	}

//	ElementUtils.appendKeysToElement(searchInput, " with Java");
	public static void appendKeysToElement(WebElement element, String text) {
		element.sendKeys(text);
	}
	
//	ElementUtils.sendKeysWithJSExecutor(passwordInput, "password123", driver);
	public static void sendKeysWithJSExecutor(WebElement element, String text, WebDriver driver) {
	    js.executeScript("arguments[0].value='" + text + "';", element);
	}

	
//	ElementUtils.sendKeysAndBlur(usernameInput, "exampleuser", driver);
	public static void sendKeysAndBlur(WebElement element, String text, WebDriver driver) {
		sendKeysToElement(element, text);
		js.executeScript("arguments[0].blur();", element);
	}

//	ElementUtils.sendKeysWithDelay(searchInput, "Selenium WebDriver", 100);
	public static void sendKeysWithDelay(WebElement element, String text, int delayInMillis)
			throws InterruptedException {
		for (char c : text.toCharArray()) {
			element.sendKeys(String.valueOf(c));
			Thread.sleep(delayInMillis);
		}
	}

//	ElementUtils.sendKeysWithActions(searchInput, driver, "Selenium WebDriver");
	public static void sendKeysWithActions(WebElement element, WebDriver driver, String text) {
		actions.sendKeys(element, text).perform();
	}

//	ElementUtils.sendKeysWithRetry(usernameInput, "exampleuser", 3);
	public static void sendKeysWithRetry(WebElement element, String text, int maxAttempts) {
		int attempts = 0;
		while (attempts < maxAttempts) {
			try {
				sendKeysToElement(element, text);
				break;
			} catch (Exception e) {
				// Handle StaleElementReferenceException or other exceptions
				attempts++;
			}
		}
	}

}
