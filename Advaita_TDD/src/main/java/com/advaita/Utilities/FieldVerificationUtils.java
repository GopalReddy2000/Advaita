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

//	$$$$$$$$$$$$$$$$$$$$$$$$ Negative Test Scripts $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$ Negative Test Scripts $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$ Negative Test Scripts $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

//  1
	public static void testEmptyInput(WebElement textField) {
		textField.clear();
		textField.sendKeys("");

	}

//  2
	public static void testExceedMaxCharacterLimit(WebElement textField, int limit) {
		String longInput = "A".repeat(limit); // Input exceeding max limit
		textField.clear();
		textField.sendKeys(longInput);
	}

//	3
	public static void testInvalidCharacters(WebElement textField) {
		textField.clear();
		textField.sendKeys("@#$%^&*"); // Invalid characters
	}

//	4
	public static void testSQLInjectionAttempt(WebElement textField) {
		textField.clear();
		textField.sendKeys("' OR 1=1; --"); // Common SQL Injection attempt
	}

//  5
	public static void testScriptInjectionAttempt(WebElement textField) {
		textField.clear();
		textField.sendKeys("<script>alert('Test')</script>"); // XSS Injection attempt
	}

//  6
	public static void testOnlyWhitespaceInput(WebElement textField) {
		textField.clear();
		textField.sendKeys("   "); // Input with only whitespaces
	}

//  7
	public static void testNumericInputOnly(WebElement textField) {
		textField.clear();
		textField.sendKeys("1234567890"); // Numeric input only
	}

//  8
	public static void testSpecialCharactersAndNumericInput(WebElement textField) {
		textField.clear();
		textField.sendKeys("1234@#$%"); // Numeric and special character input
	}

//	9
	public static void testLeadingAndTrailingSpaces(WebElement textField) {
		textField.clear();
		textField.sendKeys("   Test Input   "); // Input with leading and trailing spaces
	}

//	10
	public static void testEmptyAfterTypingAndClearing(WebElement textField) {
		textField.clear();
		textField.sendKeys("SomeInput");
		textField.clear();
	}

//	11
	public static void testInputWithHTMLTags(WebElement textField) {
		textField.clear();
		textField.sendKeys("<h1>Header</h1>"); // HTML tags input
	}

//	12
	public static void testInputWithSpacesBetweenCharacters(WebElement textField) {
		textField.clear();
		textField.sendKeys("T e s t"); // Input with spaces between characters
	}

//	13
	public static void testUnicodeInput(WebElement textField) {

		String text = "こんにちは";// Input with non-ASCII characters (Japanese)
		textField.clear();
		js.executeScript("arguments[0].value='" + text + "';", textField);
	}

//	14
	public static void testInputWithNewlineCharacters(WebElement textField) {
		textField.clear();
		textField.sendKeys("Test\nInput"); // Input with newline characters
	}

//  15
	public static void testInputWithTabCharacters(WebElement textField) {
		textField.clear();
		textField.sendKeys("Test\tInput"); // Input with tab characters
	}

//	16
	public static void testInputWithEmojiCharacters(WebElement textField) {

		String text = "😊🚀🌟💕💕";
		textField.clear();
		js.executeScript("arguments[0].value='" + text + "';", textField);
	}

//	17
	public static void testInputWithSingleCharacter(WebElement textField) {
		textField.clear();
		textField.sendKeys("A"); // Single character input
	}

//	18
	public static void testInputWithSpecialCharacterAtStart(WebElement textField) {
		textField.clear();
		textField.sendKeys("@TestInput"); // Input starting with special character
	}

//	19
	public static void testInputWithSpecialCharacterAtEnd(WebElement textField) {
		textField.clear();
		textField.sendKeys("TestInput@"); // Input ending with special character
	}

//	20
	public static void testInputWithDuplicateCharacters(WebElement textField) {
		textField.clear();
		textField.sendKeys("aaaaaa"); // Repeated identical characters
	}

//	21
	public static void testInputWithMixedCase(WebElement textField) {
		textField.clear();
		textField.sendKeys("TeStInPuT"); // Input with mixed uppercase and lowercase
	}

//	22
	public static void testInputWithMultipleSpaces(WebElement textField) {
		textField.clear();
		textField.sendKeys("Test    Input"); // Input with multiple spaces in between
	}

//	23
	public static void testInputWithZero(WebElement textField) {
		textField.clear();
		textField.sendKeys("0"); // Input with zero only
	}

//	24
	public static void testInputWithEscapeCharacters(WebElement textField) {
		textField.clear();
		textField.sendKeys("\\n\\t\\b\\r"); // Escape characters input
	}

//	25
	public static void testInputWithHTMLComment(WebElement textField) {
		textField.clear();
		textField.sendKeys("<!-- This is a comment -->"); // Input with HTML comment tags
	}

//	26
	public static void testInputWithMultipleSpecialCharacters(WebElement textField) {
		textField.clear();
		textField.sendKeys("~!@#$%^&*()_+=-`{}[]|\\:;\"'<>,.?/"); // Input with multiple special characters
	}

//	27
	public static void testInputWithExtremelyLargeNumber(WebElement textField) {
		textField.clear();
		textField.sendKeys("999999999999999999999999"); // Extremely large numeric value
	}

}
