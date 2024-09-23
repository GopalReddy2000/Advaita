package com.advaita.Utilities;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e3) {
			js.executeScript("arguments[0].click();", element);
		}

	}

//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void normalClick(WebElement element) throws Throwable {
		
		assertTrue(element.isDisplayed(), "element is not displayed.");
		element.click();

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
//				System.out.println("e1 : "+e1);
				Thread.sleep(200);
				element.click();
			}

		}
	}

	public static void multiClickWithRetry(WebDriver driver, WebElement element, int count) throws Throwable {

		for (int i = 1; i < count; i++) {
			wait.until(ExpectedConditions.visibilityOf(element));
			try {
				if (!element.isDisplayed()) {
					throw new NoSuchElementException("Element not visible so could not click: " + element);
				}

				js.executeScript("arguments[0].scrollIntoView(true);", element);
				clickWithRetry(element, count);
				Thread.sleep(700);
			} catch (Exception e1) {
//				System.out.println("e1 : "+e1);
				Thread.sleep(200);
				clickWithRetry(element, count);
			}

		}
	}

//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//	ElementUtils.clickWithActions(menuOption, driver);
	public static void clickWithActions(WebElement element, WebDriver driver) {
		actions.click(element).perform();
	}

//	ElementUtils.clickWithRetry(submitButton, 3);
	public static void clickWithRetry(WebElement element, int maxAttempts) throws Throwable {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		assertTrue(element.isDisplayed());
		int attempts = 0;
		while (attempts < maxAttempts) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				// Handle StaleElementReferenceException or other exceptions
				attempts++;
				Thread.sleep(200);
			}
		}
	}

//	ElementUtils.clickWithDelay(agreeCheckbox, 1000); // Delay of 1 second
	public static void clickWithDelay(WebElement element, int delayInMillis) throws InterruptedException {
		Thread.sleep(delayInMillis);
		element.click();
	}

//	ElementUtils.clickAndWaitForClickable(submitButton, driver, 10); // Wait up to 10 seconds
	public static void clickAndWaitForClickable(WebElement element, WebDriver driver, Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

//	ElementUtils.doubleClickElement(elementToDoubleClick, driver);
	public static void doubleClickElement(WebElement element, WebDriver driver) {
		actions.doubleClick(element).perform();
	}

//	ElementUtils.clickWithCoordinates(elementWithOffset, driver, 10, 20); // Click with an offset of 10 pixels horizontally and 20 pixels vertically
	public static void clickWithCoordinates(WebElement element, WebDriver driver, int xOffset, int yOffset) {
		actions.moveToElement(element, xOffset, yOffset).click().perform();
	}

//	ElementUtils.rightClickElement(elementToRightClick, driver);
	public static void rightClickElement(WebElement element, WebDriver driver) {
		actions.contextClick(element).perform();
	}

//	ElementUtils.clickAndHoldElement(draggableElement, driver);
	public static void clickAndHoldElement(WebElement element, WebDriver driver) {
		actions.clickAndHold(element).perform();
	}

//	WebElement draggableElement = driver.findElement(By.id("draggable"));
//	WebElement droppableElement = driver.findElement(By.id("droppable"));
//	ElementUtils.clickAndDragToElement(draggableElement, droppableElement, driver);
	public static void clickAndDragToElement(WebElement sourceElement, WebElement targetElement, WebDriver driver) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement).release().perform();
	}

//	WebElement elementToDoubleClick = driver.findElement(By.id("doubleClick"));
//	ElementUtils.doubleClickAndDrag(elementToDoubleClick, driver);
	public static void doubleClickAndDrag(WebElement element, WebDriver driver) {
		actions.doubleClick(element).perform();
		actions.clickAndHold(element).moveByOffset(50, 0).release().perform();
	}

//	WebElement draggableElement = driver.findElement(By.id("draggable"));
//	ElementUtils.clickAndHoldWithOffset(draggableElement, driver, 50, 50); // Drag from (50, 50) offset
	public static void clickAndHoldWithOffset(WebElement element, WebDriver driver, int xOffset, int yOffset) {
		actions.clickAndHold(element).moveByOffset(xOffset, yOffset).release().perform();
	}

//	ElementUtils.clickAndHighlightElement(elementToHighlight, driver);
	public static void clickAndHighlightElement(WebElement element, WebDriver driver) throws Throwable {
		js.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);
		try {

			js.executeScript("arguments[0].scrollIntoView(true);", element);
			clickWithRetry(element, 2);

			Thread.sleep(1000); // Highlight for 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.backgroundColor = '';", element); // Remove highlight
	}

//	ElementUtils.clickAndHighlightElement(elementToHighlight, driver);
	public static void highlightElement(WebElement element, WebDriver driver) {
//		js.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);
		js.executeScript("arguments[0].style.backgroundColor = 'lime';", element);
		try {

			Thread.sleep(1000); // Highlight for 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.backgroundColor = '';", element); // Remove highlight
	}

}
