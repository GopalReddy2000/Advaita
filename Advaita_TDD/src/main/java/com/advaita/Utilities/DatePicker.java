package com.advaita.Utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;

public class DatePicker extends TestBase {
	
	
	
	// Date Picker 1
		public static void nextDatePicker(WebDriver driver, WebElement element, int numberOfClicks)
				throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			assertTrue(element.isDisplayed(), "Date Picker is not Displayed.");
			Thread.sleep(2000);
			click(driver, element);

			for (int i = 0; i < numberOfClicks; i++) {
				element.sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(500); // Add a small delay if needed
			}

			element.sendKeys(Keys.ARROW_RIGHT);
			element.sendKeys(Keys.ENTER);
		}
		

		// Date Picker 2
		public static void selectPreviousDate(WebDriver driver, WebElement element, int numberOfClicks)
				throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			assertTrue(element.isDisplayed(), "Date Picker is not Displayed.");
			Thread.sleep(2000);
			click(driver, element);

			for (int i = 0; i < numberOfClicks; i++) {
				element.sendKeys(Keys.ARROW_UP);
				Thread.sleep(500); // Add a small delay if needed
			}

			element.sendKeys(Keys.ARROW_LEFT);
			element.sendKeys(Keys.ENTER);
		}

}
