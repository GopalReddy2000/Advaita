package com.advaita.Utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;

public class FieldVerificationUtils extends TestBase {

	public static void verifyTextField(WebElement field, String labelText, String fieldValue, boolean isRequired,
			boolean isEnabled, int timeoutInSeconds) {

// Verify field visibility
		assertTrue(field.isDisplayed(), labelText + " is not displayed.");

		if (isRequired) {
			WebElement label = driver.findElement(By.xpath("//label[normalize-space()='" + labelText + "*']"));
			assertTrue(label.isDisplayed(), labelText + " label is not displayed.");

// Verify that label ends with '*'
			assertTrue(label.getText().endsWith("*"), labelText + " label does not end with '*'.");
		}

// Verify field enabled status if applicable
		if (isEnabled) {
			assertTrue(field.isEnabled(), labelText + " is not enabled.");
		}

// Verify that the field is empty before entering text
		assertTrue(field.getAttribute("value").isEmpty(), labelText + " is not empty before entering text.");

// Validate fieldValue
		assertNotNull(fieldValue, labelText + " is null.");
		assertFalse(fieldValue.trim().isEmpty(), labelText + " is empty.");
		assertTrue(fieldValue.matches("^[a-zA-Z0-9 ]+$"), labelText + " contains invalid characters.");

// Clear and send text
		SendDataUtils.clearAndSendKeys(field, fieldValue);

// Wait for validation error message to disappear
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));

		try {
			boolean isErrorGone = wait
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[normalize-space()='"
							+ labelText + "*']/..//label[normalize-space()='This field is required.']")));
			assertTrue(isErrorGone, labelText + " required error message is still displayed.");
		} catch (TimeoutException e) {
			fail(labelText + " required error message is displayed.");
		}

// Verify entered text matches fieldValue
		assertEquals(field.getAttribute("value"), fieldValue, labelText + " is not correctly entered in the field.");
	}

	public static void verifyTextArea(WebElement field, String fieldValue, boolean isEnabled) {

		// Verify field properties
		if (isEnabled) {
			assertTrue(field.isEnabled(), "field is not enabled.");
		}

		// Verify field is empty before entering text
		String existingText = field.getAttribute("value");
		assertTrue(existingText.isEmpty(), "field is not empty before entering text.");

		// Validate input
		assertNotNull(fieldValue, "field is null.");
		assertFalse(fieldValue.trim().isEmpty(), "field is empty.");
//		assertTrue(fieldValue.matches("^[a-zA-Z0-9 ]+$"), "field contains invalid characters.");

		SendDataUtils.clearAndSendKeys(field, fieldValue);

		// Verify entered text
		String enteredText = field.getAttribute("value");
		assertEquals(enteredText, fieldValue, "field is not correctly entered in the field.");
	}
}
