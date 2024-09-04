package com.advaita.Utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;

public class FieldVerificationUtils extends TestBase {

	public static void verifyTextField(WebElement field, String labelText, String fieldValue, boolean isRequired,
			boolean isEnabled, int timeoutInSeconds) {

		WebElement label = driver.findElement(By.xpath("//label[normalize-space()='" + labelText + "*" + "']"));

		// Check if the popup or field container is displayed (if applicable)
		assertTrue(field.isDisplayed(), labelText + " is not displayed.");

		// Verify label
		String text = label.getText();
		if (isRequired) {
			char lastChar = text.charAt(text.length() - 1);
			assertEquals(lastChar, '*', labelText + " label does not end with '*'.");
		}

		// Verify field properties
		if (isEnabled) {
			assertTrue(field.isEnabled(), labelText + " is not enabled.");
		}

		// Verify field is empty before entering text
		String existingText = field.getAttribute("value");
		assertTrue(existingText.isEmpty(), labelText + " is not empty before entering text.");

		// Validate input
		assertNotNull(fieldValue, labelText + " is null.");
		assertFalse(fieldValue.trim().isEmpty(), labelText + " is empty.");
		assertTrue(fieldValue.matches("^[a-zA-Z0-9 ]+$"), labelText + " contains invalid characters.");

		SendDataUtils.clearAndSendKeys(field, fieldValue);

		// Wait for any validation error to disappear

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));

		try {
			assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[normalize-space()='"
					+ labelText + "*" + "']/..//label[normalize-space()='This field is required.']"))));
		} catch (TimeoutException e) {
			System.out.println("Exception : " + e + "\n" + labelText + " is displayed.");
			assertFalse(true, labelText + " is displayed");
		}

		// Verify entered text
		String enteredText = field.getAttribute("value");
		assertEquals(enteredText, fieldValue, labelText + " is not correctly entered in the field.");
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
