package com.advaita.Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;

public class ClickUtilities extends TestBase {

	public static void click(WebDriver driver, WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			if (!element.isDisplayed()) {
				throw new NoSuchElementException("Element not visible so could not click: " + element);
			}

			element.click();
		} catch (Exception e1) {
			try {
				element.sendKeys(Keys.ENTER);
			} catch (Exception e2) {
				try {
					js.executeScript("arguments[0].click();", element);
				} catch (Exception e3) {
					actions.click(element).build().perform();
				}
			}

		}

	}

//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void jsClick(WebDriver driver, WebElement element) {
		try {
			if (!element.isDisplayed()) {
				throw new NoSuchElementException("Element not visible so could not click: " + element);
			}
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e3) {
			js.executeScript("arguments[0].click();", element);
		}

	}

//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void multiJSClick(WebDriver driver, WebElement element, int count) throws Throwable {

		for (int i = 1; i <= count; i++) {
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(element));
			try {
				if (!element.isDisplayed()) {
					throw new NoSuchElementException("Element not visible so could not click: " + element);
				}
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(500);
			} catch (Exception e1) {
				System.out.println(e1);
			}

		}
	}

//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void multiClick(WebDriver driver, WebElement element, int count) throws Throwable {

		for (int i = 1; i < count; i++) {
			wait.until(ExpectedConditions.visibilityOf(element));
			try {
				if (!element.isDisplayed()) {
					throw new NoSuchElementException("Element not visible so could not click: " + element);
				}

				js.executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
				Thread.sleep(700);
			} catch (Exception e1) {
				System.out.println("e1 : "+e1);
				Thread.sleep(200);
				element.click();
			}

		}
	}

//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
