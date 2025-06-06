package com.advaita.Utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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

	public static void validateDropdownWithOutOrder(WebElement element, String expectedDefaultOption,
			String visibleText) {

		Select dropdown = new Select(element);

		// Verify the dropdown is not multi-select
		assertFalse(dropdown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty dropdown
		List<WebElement> options = dropdown.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Check default selected value
		WebElement defaultSelectedOption = dropdown.getFirstSelectedOption();
		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption, "Default selected option is incorrect.");

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			softAssert.assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
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

		assertNotNull(visibleText, "visibleText is null");
		dropdown.selectByVisibleText(visibleText);

//		Check selected value
		WebElement selectedOption = dropdown.getFirstSelectedOption();
//		String expectedOption = "Select"; // Replace with expected default value
		assertEquals(selectedOption.getText(), visibleText.trim(), "selected option is incorrect.");
	}

	public static void jsDropdownWithAllPossibleValidation(WebDriver driver, WebElement element, String defaultValue,
			String visibleText) throws Throwable {

		// Check for empty drop down
		List<WebElement> options = element.findElements(By.tagName("option"));
		wait.until(ExpectedConditions.visibilityOfAllElements(options));
		softAssert.assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Check if any option is selected by default
		Thread.sleep(1000);
		String getDefaultSelectedScript = "return arguments[0].options[arguments[0].selectedIndex].text;";
		String defaultSelectedOption = (String) js.executeScript(getDefaultSelectedScript, element);

		System.out.println("defaultSelectedOption : " + defaultSelectedOption);

		if (defaultSelectedOption != null) {
			// Verify the default selected option
			softAssert.assertEquals(defaultSelectedOption, defaultValue, "Default selected option is incorrect.");
		} else {
			// Assert that a default option should be selected
			softAssert.fail("No default selected option is present.");
		}

		// Use JavaScript to get all the options' text from the dropdown
		String getAllOptionsScript = "var options = arguments[0].options; " + "var texts = []; "
				+ "for (var i = 0; i < options.length; i++) { " + "    texts.push(options[i].text); " + "} "
				+ "return texts;";

		List<String> optionTexts = (List<String>) js.executeScript(getAllOptionsScript, element);

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (String optionText : optionTexts) {
			System.out.println(optionText);
			softAssert.assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < Math.min(5, options.size()); k++) {
			// Use JavaScript to select an option by index
			String selectByIndexScript = "arguments[0].selectedIndex=" + k + ";";
			js.executeScript(selectByIndexScript, element);

			// After selecting the option, refetch the list of options
			List<WebElement> refreshedOptions = element.findElements(By.tagName("option"));

			// Verify the selected option by retrieving its text using JavaScript
			String selectedOptionText = (String) js.executeScript(getDefaultSelectedScript, element);

			// Ensure you are comparing the right option's text (use the refreshed list)
			softAssert.assertEquals(selectedOptionText, refreshedOptions.get(k).getText(),
					"Failed to select the option by index " + k);

			System.out.println(
					"Option '" + refreshedOptions.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

		unWait(1);
		assertNotNull(visibleText, "visibleText is null");

		// Use JavaScript to select the option by visible text
		String selectByVisibleTextScript = "var options = arguments[0].options; "
				+ "for(var i = 0; i < options.length; i++) { " + "if(options[i].text === '" + visibleText + "') { "
				+ "options[i].selected = true; " + "break; }}";
		js.executeScript(selectByVisibleTextScript, element);

		// Verify the selected option by retrieving its text
		String selectedOptionText = (String) js.executeScript(getDefaultSelectedScript, element);
		softAssert.assertEquals(selectedOptionText, visibleText.trim(), "Selected option is incorrect.");

		// Soft assert all
//		softAssert.assertAll();
	}

	public static void dropdownWithAllPosibleValidation(WebElement element, String defaultValue, String visibleText)
			throws Throwable {

		Select dropDown = new Select(element);

		assertFalse(dropDown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = dropDown.getOptions();
		wait.until(ExpectedConditions.visibilityOfAllElements(options));
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Check if any option is selected by default
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
		unWait(2);
//		List<WebElement> refreshedOptions = element.findElements(By.tagName("option"));
//		wait.until(ExpectedConditions.visibilityOfAllElements(options));
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			softAssert.assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
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

//		wait.until(ExpectedConditions.visibilityOfAllElements(options));
		// After selecting the option, refetch the list of options
		List<WebElement> refreshedOptions1 = element.findElements(By.tagName("option"));
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

	public static boolean validateSelectedDropdownOption(WebElement dropDownElement, String optionToSelect)
			throws Throwable {
		// Initialize the drop down
		Select dropDown = new Select(dropDownElement);

		// Retrieve the currently selected option
		Thread.sleep(400);
		WebElement currentSelectedOption = dropDown.getFirstSelectedOption();

		System.out.println("currentSelectedOption : " + currentSelectedOption.getText());
		// Validate using TestNG Assert
		softAssert.assertEquals(currentSelectedOption.getText(), optionToSelect, "The selected option is not as expected.");

		boolean isValid = currentSelectedOption.getText().equals(optionToSelect);

		if (!isValid) {
			System.out.println("The selected option is not as expected. Expected: " + optionToSelect + ", but found: "
					+ currentSelectedOption.getText());
		}
		return isValid;
	}

	// Utility method for star mark validation and dropdown interaction
	public static void validateStarMarkAndHandleDropdown(String labelText, String dropdownId, String defaultOption,
			String optionToSelect) throws Throwable {
		// Construct the XPath for the label
		String labelXPath = String.format("//label[contains(text(), '%s')]", labelText);
		String dropdownXPath = String.format("%s/..//select[@id='%s']", labelXPath, dropdownId);

		// Locate the label element
		WebElement labelElement = driver.findElement(By.xpath(labelXPath));

		// Assert that the label contains the star mark (*)
		assertTrue(labelElement.getText().contains("*"), "The label does not contain the star mark (*)");

		// Locate and handle the dropdown using the Select class
		WebElement dropdown = driver.findElement(By.xpath(dropdownXPath));
		wait.until(ExpectedConditions.visibilityOf(dropdown));

		try {
			dropdownWithAllPosibleValidation(dropdown, defaultOption, optionToSelect);
		} catch (StaleElementReferenceException e) {
			dropdownWithAllPosibleValidation(dropdown, defaultOption, optionToSelect);
		}
//		dropdownWithAllPosibleValidation(dropdown, defaultOption, optionToSelect);
	}

	public static void validateStarMarkAndHandleDropdowns(Object labelText, Object dropdownId, Object defaultOption,
			Object optionToSelect, boolean checkStarMark) throws Throwable {

		// Convert single values to lists for uniform handling
		List<String> labelTexts = (labelText instanceof String) ? List.of((String) labelText)
				: (List<String>) labelText;
		List<String> dropdownIds = (dropdownId instanceof String) ? List.of((String) dropdownId)
				: (List<String>) dropdownId;
		List<String> defaultOptions = (defaultOption instanceof String) ? List.of((String) defaultOption)
				: (List<String>) defaultOption;
		List<String> optionsToSelect = (optionToSelect instanceof String) ? List.of((String) optionToSelect)
				: (List<String>) optionToSelect;

		// Validate the input sizes
		if (dropdownIds.size() != optionsToSelect.size() || labelTexts.size() != dropdownIds.size()) {
			throw new IllegalArgumentException("The number of label texts, dropdown IDs, and options must match.");
		}

		for (int i = 0; i < dropdownIds.size(); i++) {
			String currentLabelText = labelTexts.get(i);
			String currentDropdownId = dropdownIds.get(i);
			String currentOptionToSelect = optionsToSelect.get(i);
			String currentDefaultOption = defaultOptions.get(i);

			// Construct the XPath for the label
			String labelXPath = String.format("//label[contains(text(), '%s')]", currentLabelText);
			String dropdownXPath = String.format("%s/..//select[@id='%s']", labelXPath, currentDropdownId);

			// Locate the dropdown
			WebElement dropdown = driver.findElement(By.xpath(dropdownXPath));
			wait.until(ExpectedConditions.visibilityOf(dropdown));

			// Check for star mark if required
			if (checkStarMark) {
				WebElement labelElement = driver.findElement(By.xpath(labelXPath));
				assertTrue(labelElement.getText().contains("*"), "The label does not contain the star mark (*)");
			}

			wait.until(ExpectedConditions.visibilityOf(dropdown));
			try {
				dropdownWithAllPosibleValidation(dropdown, currentDefaultOption, currentOptionToSelect);
			} catch (StaleElementReferenceException e) {
				dropdownWithAllPosibleValidation(dropdown, currentDefaultOption, currentOptionToSelect);
			}
		}
	}

	// usage

//	 List<WebElement> dropdowns = List.of(singleDropdown);
//	 List<String> optionsToSelect = List.of("Single Option"); // Replace with your option
//
//   // Handle the single dropdown
//   DropDown.handleRelativeDropdowns(dropdowns, optionsToSelect);

	public static void isMandatory(String currentLabelText) {
		String labelXPath = String.format("//label[contains(text(), '%s')]", currentLabelText);
		WebElement labelElement = driver.findElement(By.xpath(labelXPath));
		assertTrue(labelElement.getText().contains("*"), "The label does not contain the star mark (*)");
	}

//	$$$$$$$$$$$$$$$$$$$$$$$$ Negative Test Scripts $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$ Negative Test Scripts $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$ Negative Test Scripts $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	// Example dropdown element locator
	By dropdownLocator = By.id("dropdown"); // Update with actual dropdown ID

	public void testEmptyDropdownOptions() {
		// Scenario: Dropdown has no options.
		// Expected: Options list should be empty.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertTrue(select.getOptions().isEmpty(), "Dropdown options are not empty.");
	}

	public void testSelectInvalidOptionByVisibleText() {
		// Scenario: Select a non-existent option by visible text.
		// Expected: Exception should be thrown.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertThrows(Exception.class, () -> select.selectByVisibleText("Invalid Option"));
	}

	public void testSelectInvalidOptionByValue() {
		// Scenario: Select a non-existent option by value.
		// Expected: Exception should be thrown.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertThrows(Exception.class, () -> select.selectByValue("invalid_value"));
	}

	public void testSelectInvalidOptionByIndex() {
		// Scenario: Select an option with an out-of-bounds index.
		// Expected: IndexOutOfBoundsException should be thrown.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertThrows(IndexOutOfBoundsException.class, () -> select.selectByIndex(999));
	}

	public void testMultipleSelectionNotAllowed() {
		// Scenario: Attempt multiple selection in a single-select dropdown.
		// Expected: Dropdown should not allow multiple selections.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertFalse(select.isMultiple(), "Dropdown should not allow multiple selections.");
	}

	public void testDropdownDisabled() {
		// Scenario: Dropdown is disabled.
		// Expected: Dropdown should not be enabled for interaction.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Assert.assertFalse(dropdown.isEnabled(), "Dropdown should be disabled.");
	}

	public void testDropdownHidden() {
		// Scenario: Dropdown is not visible on the page.
		// Expected: Dropdown should not be displayed.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Assert.assertFalse(dropdown.isDisplayed(), "Dropdown should be hidden.");
	}

	public void testDropdownWithoutDefaultSelection() {
		// Scenario: Dropdown has no default selection.
		// Expected: No option should be pre-selected.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertNull(select.getFirstSelectedOption(), "Dropdown has a default selection.");
	}

	public void testDropdownOptionsMismatch() {
		// Scenario: Dropdown options do not match the expected list.
		// Expected: Options list should not match the given values.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		String[] expectedOptions = { "Option 1", "Option 2", "Option 3" };
		for (String expected : expectedOptions) {
			boolean match = options.stream().anyMatch(o -> o.getText().equals(expected));
			Assert.assertFalse(match, "Unexpected dropdown option found: " + expected);
		}
	}

	public void testDropdownOptionsContainNull() {
		// Scenario: Dropdown options contain null or empty values.
		// Expected: At least one option should be null or empty.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		boolean containsNull = select.getOptions().stream().anyMatch(o -> o.getText() == null || o.getText().isEmpty());
		Assert.assertTrue(containsNull, "Dropdown options should contain null or empty values.");
	}

	public void testDropdownOptionsDuplicateValues() {
		// Scenario: Dropdown options contain duplicate values.
		// Expected: No duplicate options should be present.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		Set<String> optionSet = new HashSet<>();
		for (WebElement option : options) {
			Assert.assertTrue(optionSet.add(option.getText()), "Duplicate option found: " + option.getText());
		}
	}

	public void testDropdownSelectWithoutOpening() {
		// Scenario: Attempt to select an option without opening the dropdown.
		// Expected: Exception should be thrown.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertThrows(Exception.class, () -> select.selectByIndex(1));
	}

	public void testEmptyOptionSelection() {
		// Scenario: Attempt to select an empty option.
		// Expected: Exception should be thrown.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertThrows(Exception.class, () -> select.selectByVisibleText(""));
	}

	public void testExcessiveDropdownOptions() {
		// Scenario: Dropdown contains an excessive number of options.
		// Expected: Options count should not exceed the acceptable limit (e.g., 1000).
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertTrue(select.getOptions().size() <= 1000, "Dropdown has too many options.");
	}

	public void testDropdownOptionCaseSensitivity() {
		// Scenario: Select an option with incorrect case sensitivity.
		// Expected: Exception should be thrown.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		Assert.assertThrows(Exception.class, () -> select.selectByVisibleText("option 1"));
	}

	public void testDropdownOptionHtmlInjection() {
		// Scenario: Dropdown options contain HTML injection.
		// Expected: Options should not contain malicious HTML tags.
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		boolean containsHtml = select.getOptions().stream().anyMatch(o -> o.getText().contains("<script>"));
		Assert.assertFalse(containsHtml, "Dropdown options should not contain HTML injection.");
	}

	public void testDropdownWithoutAttributes() {
		// Scenario: Dropdown element is missing essential attributes (e.g., ID).
		// Expected: Attributes like ID should not be null.
		WebElement dropdown = driver.findElement(dropdownLocator);
		String id = dropdown.getAttribute("id");
		Assert.assertNotNull(id, "Dropdown should have an ID.");
	}

	public void testDropdownCssMisalignment() {
		// Scenario: Dropdown CSS is misaligned (e.g., incorrect position or
		// visibility).
		// Expected: CSS attributes should match expected values.
		WebElement dropdown = driver.findElement(dropdownLocator);
		String cssValue = dropdown.getCssValue("position");
		Assert.assertEquals(cssValue, "relative", "Dropdown is misaligned.");
	}
	
	
	/**
     * Selects multiple options randomly (one, more than one, or all) from a Select2 multi-select dropdown.
     * @param driver The WebDriver instance.
     * @param questionContainer The WebElement containing the Select2 dropdown.
     * @param random The Random instance for random selection.
     */
	public static void selectMultipleOptionsWithCustomSelection(WebDriver driver, WebElement questionContainer, Random random, int selectionType) {
	    

	    // Find the Select2 input or trigger
	    WebElement select2Trigger = questionContainer.findElement(By.className("select2-selection"));
	    if (select2Trigger == null) {
	        throw new RuntimeException("Select2 trigger not found in question container.");
	    }

	    // Click the trigger to open the dropdown
	    select2Trigger.click();

	    // Wait for the dropdown to be visible
	    WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.className("select2-dropdown")));

	    // Find all options in the dropdown
	    List<WebElement> options = dropdown.findElements(By.className("select2-results__option"));
	    if (options.isEmpty()) {
	        System.out.println("No options found in Select2 dropdown for question: " + questionContainer.getText());
	        return;
	    }

	    int totalOptions = options.size();
	    System.out.println("Total options available: " + totalOptions);

	    // Decide how many options to select based on the custom selectionType
	    int optionsToSelect;
	    switch (selectionType) {
	        case 0: // Select exactly one option
	            optionsToSelect = 1;
	            System.out.println("Selecting exactly 1 option.");
	            break;
	        case 1: // Select more than one option (up to totalOptions)
	            optionsToSelect = random.nextInt(totalOptions - 1) + 2; // Ensures at least 2 options
	            System.out.println("Selecting " + optionsToSelect + " options (more than one).");
	            break;
	        case 2: // Select all options
	            optionsToSelect = totalOptions;
	            System.out.println("Selecting all " + totalOptions + " options.");
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid selectionType. Use 0 (one), 1 (more than one), or 2 (all).");
	    }

	    // Ensure optionsToSelect doesn’t exceed totalOptions
	    optionsToSelect = Math.min(optionsToSelect, totalOptions);

	    // Shuffle the options to select randomly
	    java.util.Collections.shuffle(options);

	    // Select the specified number of options
	    int selectedCount = 0;
	    for (WebElement option : options) {
	        if (selectedCount >= optionsToSelect) {
	            break;
	        }
	        String optionText = option.getText();

	        // Check if the option is already selected (aria-selected="true")
	        boolean isSelected = "true".equals(option.getAttribute("aria-selected"));
	        if (!isSelected) {
	            actions.moveToElement(option).click().perform();
	            System.out.println("Selected option: " + optionText);
	            selectedCount++;
	        } else {
	            System.out.println("Option already selected: " + optionText);
	        }
	    }
	    
	    select2Trigger.click();
	    
//	    driver.findElement(By.xpath("//div[@class='page_body']")).click();

	    // Optionally, close the dropdown
	    // select2Trigger.click(); // Uncomment if closing is required
	}



}
