package com.advaita.Utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;

public class DropDown extends TestBase {

	public static void selectWithRetry(WebElement processElement, String fetchProcessRecord) {
//	    WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
		int maxAttempts = 3;
		int attempts = 0;

		while (attempts < maxAttempts) {
			try {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(processElement)));

				Select process = new Select(processElement);
				process.selectByVisibleText(fetchProcessRecord);

				// If successful, break out of the loop
				System.out.println("Successfully selected: " + fetchProcessRecord);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				if (attempts == maxAttempts) {
					System.out.println("Failed to select after " + maxAttempts + " attempts.");
					throw e; // Re-throw the exception if all attempts fail
				}
				System.out.println("Encountered a stale element. Retrying... (Attempt " + attempts + ")");
			}
		}

	}
//	###############################################################

	public static void selectAndVerifyOptionsByIndex(WebElement selectElement, List<WebElement> options) {
		int maxAttempts = 3;

		for (int k = 0; k < options.size(); k++) {
			int attempts = 0;
			while (attempts < maxAttempts) {
				try {
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(selectElement)));

					Select subSubProcess = new Select(selectElement);
					subSubProcess.selectByIndex(k);

					WebElement selectedOption = wait.until(ExpectedConditions.refreshed(
							ExpectedConditions.elementToBeClickable(subSubProcess.getFirstSelectedOption())));

					String expectedText = options.get(k).getText();
					String actualText = selectedOption.getText();

					Assert.assertEquals(actualText, expectedText, "Failed to select the option by index " + k);

					System.out.println("Option '" + expectedText + "' was successfully selected by index " + k + ".");

					// If successful, break out of the retry loop
					break;
				} catch (StaleElementReferenceException e) {
					attempts++;
					if (attempts == maxAttempts) {
						System.out.println(
								"Failed to select option at index " + k + " after " + maxAttempts + " attempts.");
						throw e; // Re-throw the exception if all attempts fail
					}
					System.out.println(
							"Encountered a stale element. Retrying... (Attempt " + attempts + " for index " + k + ")");
				}
			}
		}
	}

	public static void validateDropdown(Select dropdown, String expectedDefaultOption, String[] expectedOrder) {
		// Verify the dropdown is not multi-select
		assertFalse(dropdown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty dropdown
		List<WebElement> options = dropdown.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Check default selected value
		WebElement defaultSelectedOption = dropdown.getFirstSelectedOption();
		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption, "Default selected option is incorrect.");

		// Verify the order of options
		for (int i = 0; i < expectedOrder.length; i++) {
			assertEquals(options.get(i).getText(), expectedOrder[i], "Option order is incorrect at index " + i);
		}

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int i = 0; i < options.size(); i++) {
			dropdown.selectByIndex(i);
			WebElement selectedOption = dropdown.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(i).getText(),
					"Failed to select the option by index " + i);
			System.out
					.println("Option '" + options.get(i).getText() + "' was successfully selected by index " + i + ".");
		}
	}

	public static void dropdownWithAllPosibleValidation(WebElement element, String defaultValue, String visibleText)
			throws Throwable {

		Select dropDown = new Select(element);

		assertFalse(dropDown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = dropDown.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Check if any option is selected by default
		Thread.sleep(1000);
		WebElement defaultSelectedOption = dropDown.getFirstSelectedOption();
		String expectedDefaultOption = defaultValue; // Replace with expected default value

		if (defaultSelectedOption != null) {
			// Verify the default selected option
			softAssert.assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
					"Default selected option is incorrect.");
		} else {
			// Assert that a default option should be selected
			softAssert.fail("No default selected option is present.");
		}

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < Math.min(5, options.size()); k++) {
			dropDown.selectByIndex(k);
			WebElement selectedOption = dropDown.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

		assertNotNull(visibleText, "visibleText is null");
		dropDown.selectByVisibleText(visibleText);

//		Check selected value
		WebElement selectedOption = dropDown.getFirstSelectedOption();
//		String expectedOption = "Select"; // Replace with expected default value
		assertEquals(selectedOption.getText(), visibleText.trim(), "selected option is incorrect.");
	}

	// Method to check if a specific text is present in the dropdown options
	public static boolean isTextPresentInDropDown(WebElement selectMetaDatDropDownElement, String metaDataText) {
		// Create a Select object for the dropdown
		Select select = new Select(selectMetaDatDropDownElement);

		// Retrieve all options in the dropdown
		List<WebElement> options = select.getOptions();

		// Iterate through the options and check if the specified text is present
		for (WebElement option : options) {
			if (option.getText().equals(metaDataText)) {
				return true; // Text found in the dropdown
			}
		}

		return false; // Text not found in the dropdown
	}

	public static boolean validateSelectedDropdownOption(WebElement dropDownElement, String optionToSelect) throws Throwable {
		// Initialize the drop down
		Select dropDown = new Select(dropDownElement);

		// Retrieve the currently selected option
		Thread.sleep(400);
		WebElement currentSelectedOption = dropDown.getFirstSelectedOption();

		System.out.println("currentSelectedOption : " + currentSelectedOption.getText());
		// Validate using TestNG Assert
		Assert.assertEquals(currentSelectedOption.getText(), optionToSelect, "The selected option is not as expected.");

		boolean isValid = currentSelectedOption.getText().equals(optionToSelect);

		if (!isValid) {
			System.out.println("The selected option is not as expected. Expected: " + optionToSelect + ", but found: "
					+ currentSelectedOption.getText());
		}
		return isValid;
	}

}
