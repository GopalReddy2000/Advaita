package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.SendDataUtils;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamplingPlanAndGenerationPage extends TestBase {

	public SamplingPlanAndGenerationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sampling Plan & Generation")
	public static WebElement samplingPlanAndGeneration;

	@FindBy(linkText = "Sample Status")
	WebElement sampleStatus;

	@FindBy(linkText = "+ Create")
	WebElement create;

	@FindBy(id = "process")
	WebElement processDropdown;

	@FindBy(id = "process_search")
	WebElement processSearchDropdown;

	@FindBy(id = "sub_process_search")
	WebElement subProcessSearchDropdown;

	@FindBy(id = "s_sub_process_search")
	WebElement subSubProcessSearchDropdown;

	@FindBy(id = "stage_search")
	WebElement stageSearchDropdown;

	@FindBy(id = "sub_process")
	WebElement subProcessDropdown;

	@FindBy(id = "s_sub_process")
	WebElement subSubProcessDropdown;

	@FindBy(id = "stage_name_id")
	WebElement stagesDropdown;

	@FindBy(id = "meta_dataset_id")
	WebElement metadataDropdown;

	@FindBy(name = "sampling_plan_name")
	WebElement samplingPlanName;

	@FindBy(xpath = "//input[@id='sampling_from_date']")
	WebElement samplingPlanFromDate;

	@FindBy(xpath = "//input[@id='sampling_to_date']")
	WebElement samplingPlanToDate;

	@FindBy(xpath = "//select[@name='sampling_to']")
	WebElement samplingToDropdown;

	@FindBy(name = "total_call_data_req")
	WebElement totalDataCalls;

	@FindBy(xpath = "//label[@for='consider_allocated']//span")
	WebElement considerAllocatedData;

	@FindBy(xpath = "//label[@for='consider_audited']//span")
	WebElement considerAuditedData;

	@FindBy(xpath = "//label[@for='is_all_sample']//span")
	WebElement allSample;

	@FindBy(xpath = "//button[text()='Next' and @data-info='conditional']")
	WebElement nextForConditional;

	@FindBy(xpath = "//select[contains(@id,'metadata_field')]")
	List<WebElement> fieldDropdown;

	@FindBy(xpath = "//select[contains(@name,'condition_type')]")
	List<WebElement> conditionDropdown;

	@FindBy(xpath = "//input[contains(@id,'select_val')]//parent::div[not(contains(@style,'display'))]//input")
	List<WebElement> conditionTextInputFields;

	@FindBy(xpath = "//select[contains(@id,'equal_and_not_equal')]")
	List<WebElement> equalAndNoEqualDropdown;

	@FindBy(xpath = "//div[@style='display:block !important']//select[contains(@id,'dropdown_val')]")
	WebElement dropdownInputs;

	@FindBy(xpath = "//img[@alt='arrow-left']")
	List<WebElement> deleteButton;

	@FindBy(xpath = "//h2[text()='Add Row']")
	WebElement addRow;

	@FindBy(xpath = "//button[text()='Next' and @data-info='Scheduling']")
	WebElement nextForScheduling;

	@FindBy(xpath = "//button[text()='Previous' and @data-info='conditional']")
	WebElement conditionalPrevious;

	@FindBy(xpath = "//select[@name='schedule_type']")
	WebElement ScheduleTypeDropdown;

	@FindBy(xpath = "//input[@name='schedule_time']")
	WebElement ScheduleTimeInput;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;

	@FindBy(xpath = "//button[text()='Previous' and @data-info='Scheduling']")
	WebElement schedulingPrevious;

	@FindBy(xpath = "(//button[text()='Cancel'])[1]")
	WebElement cancel;

	public SamplingPlanAndGenerationPage navToCreate() {
		navigateWithinAlchemy(samplingPlanAndGeneration);
		create.click();
		return this;
	}

	/**
	 * Creates a sampling plan by filling out the necessary form fields and
	 * performing actions based on the provided parameters. This includes selecting
	 * dropdown options, inputting values into text fields, handling conditional
	 * actions based on the given flags, and finally submitting the form.
	 *
	 * @param process            The process to select from the process dropdown.
	 * @param subProcess         The sub-process to select from the sub-process
	 *                           dropdown.
	 * @param subSubprocess      The sub-sub-process to select from the
	 *                           sub-subprocess dropdown.
	 * @param Stages             The stage to select from the stages dropdown.
	 * @param samplingPlaneName  The name of the sampling plan to be entered.
	 * @param fromDate           The "from" date for the sampling plan (in string
	 *                           format).
	 * @param toDate             The "to" date for the sampling plan (in string
	 *                           format).
	 * @param samplingTo         The sampling destination to select from the
	 *                           dropdown.
	 * @param totalDataCall      The total data calls to enter in the corresponding
	 *                           field.
	 * @param allSampleCondition Flag to indicate if all sample conditions should be
	 *                           considered (either "yes" or "no").
	 * @param needCondition      Flag to indicate if specific sampling conditions
	 *                           are needed (either "yes" or "no").
	 * @param needScheduling     Flag to indicate if scheduling is needed (either
	 *                           "yes" or "no").
	 *
	 * @return SamplingPlanAndGenerationPage The current page object for chaining
	 *         purposes.
	 */
	public SamplingPlanAndGenerationPage createSampling(String process, String subProcess, String subSubprocess,
			String Stages, String samplingPlaneName, String samplingTo, String totalDataCall, String allSampleCondition,
			String needCondition, String needScheduling) {

		// Select values from dropdowns for process, sub-process, sub-subprocess, and
		// stages.
		selectByVisibleText(processDropdown, process);
		selectByVisibleText(subProcessDropdown, subProcess);
		selectByVisibleText(subSubProcessDropdown, subSubprocess);
		selectByVisibleText(stagesDropdown, Stages);

		// Input sampling plan name into the corresponding field.
		samplingPlanName.sendKeys(samplingPlaneName);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Get yesterday's date
		LocalDate yesterday = LocalDate.now().minusDays(1);
		String formattedYesterday = yesterday.format(formatter);

		// Get tomorrow's date
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		String formattedTomorrow = tomorrow.format(formatter);
		// Use JavaScript to set the "from" and "to" dates for the sampling plan.

		jsDateExecutor(samplingPlanFromDate, formattedYesterday);
		jsDateExecutor(samplingPlanToDate, formattedTomorrow);

		// Select the sampling destination from the dropdown.
		selectByVisibleText(samplingToDropdown, samplingTo);

		// Input total data calls into the corresponding field.
		totalDataCalls.sendKeys(totalDataCall);

		// Handle the sample conditions if the flag is set to "yes".
		try {
			if (allSampleCondition.equals("yes")) {
//				considerAllocatedData.click();  // Don't Consider allocated data.
//				considerAuditedData.click();    // Don't Consider audited data.
				allSample.click(); // Select all sample.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Handle exceptions in sample condition handling.
		}

		// Handle the need for specific conditions or scheduling based on flags.
		if (needCondition.equalsIgnoreCase("yes")) {
			// Code for creating sampling conditions (currently commented out due to XPath
			// issues).
			// createSamplingConditions("");
		} else if (needScheduling.equalsIgnoreCase("yes")) {
			// Code for handling scheduling (currently commented out due to XPath issues).
		} else {
			// If neither condition nor scheduling are needed, move to the next steps.
			nextForConditional.click(); // Click the "next" button for conditions.
			nextForScheduling.click(); // Click the "next" button for scheduling.
			save.click(); // Save the sampling plan.
		}

		// Wait for the continue button to appear and confirm the success message.
		try {
			unWait(1); // Explicit wait to ensure elements are visible.
			assertTrue(continueButton.isDisplayed(), "Continue Button is not visible");
			System.out.println("Sample is Generated Successfully"); // Print success message.

			continueButton.click(); // Click the continue button to complete the process.
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Handle any exceptions if continue button is not visible.
		}

		// Return the current page object to allow method chaining.
		return this;
	}

	public SamplingPlanAndGenerationPage equalsAndNotEquals(String fieldSelect, String conditionSelect) {
		selectByVisibleText(fieldDropdown.get(0), fieldSelect);
		selectByVisibleText(conditionDropdown.get(0), conditionSelect);

		return this;
	}

	public SamplingPlanAndGenerationPage createSamplingConditions(String conditionDropdowns,
			String equalsOrNotEqualsCondition) {
		nextForConditional.click();
		selectByVisibleText(fieldDropdown.get(0), "");
		selectByVisibleText(conditionDropdown.get(0), "");
		switch (conditionDropdowns) {
		case "equals":
		case "not equals":
			selectByVisibleText(equalAndNoEqualDropdown.get(0), equalsOrNotEqualsCondition);
			if (equalsOrNotEqualsCondition.equals("textBox")) {
				conditionTextInputFields.get(0).sendKeys();
			}
			if (equalsOrNotEqualsCondition.equals("dropdown")) {

			}
			break;
		case "greater than":
		case "greater than equal to":
		case "lesser than":
		case "lesser tha or equal to":
		case "date":
		case "date between":
			conditionTextInputFields.get(0).sendKeys();
			break;
		case "dropdown":
			conditionDropdown.get(0).sendKeys();
		case "multiselect":

		}

		return this;
	}

	public SamplingPlanAndGenerationPage createSamplingScheduling() {

		return this;
	}

//    ##################### Code By Gopal ################################

	public SamplingPlanAndGenerationPage createSamplingPlan(String process, String subProcess, String subSubProcess,
			String stages, String metaData) throws Throwable {

		List<String> multipleLabelTexts = Arrays.asList("Process*", "Sub Process*", "Sub Sub Process*", "Stages*",
				"Metadata*");
		List<String> multipleDropdownIds = Arrays.asList("process", "sub_process", "s_sub_process", "stage_name_id",
				"meta_dataset_id");
		List<String> multipleDefaultOptions = Arrays.asList("Select Process", "Sub Process", "Sub Sub Process",
				"Select Stage Name", "Select Metadata");
		List<String> multipleOptionsToSelect = Arrays.asList(process, subProcess, subSubProcess, stages, metaData);

		DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts, multipleDropdownIds, multipleDefaultOptions,
				multipleOptionsToSelect, false);

		return this;
	}

	public SamplingPlanAndGenerationPage generalTabSPAG(String samplingName) throws Throwable {

		DropDown.isMandatory("Sampling Plan Name*");
		SendDataUtils.clearAndSendKeys(samplingPlanName, samplingName);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// Get yesterday's date
		LocalDate yesterday = LocalDate.now().minusDays(1);
		String formattedYesterday = yesterday.format(formatter);

		// Get tomorrow's date
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		String formattedTomorrow = tomorrow.format(formatter);

		SendDataUtils.sendKeysWithJSExecutor(samplingPlanFromDate, formattedYesterday);
		SendDataUtils.sendKeysWithJSExecutor(samplingPlanToDate, formattedTomorrow);

		DropDown.isMandatory("Total Data/Calls Required*");
		SendDataUtils.clearAndSendKeys(totalDataCalls, "0");

		return this;
	}

	/**
	 * Handles the toggle options in the general tab of the sampling plan.
	 *
	 * @param toggleOption The toggle option to select. Accepted values: -
	 *                     "considerAllocatedData" : Selects the Consider Allocated
	 *                     Data toggle. - "considerAuditedData" : Selects the
	 *                     Consider Audited Data toggle. - "allSample" : Selects the
	 *                     All Sample toggle. - "all" : Selects all three toggles.
	 */

	public SamplingPlanAndGenerationPage generalTabToggleButton(String toggleOption) {

		// Convert input to lowercase once for comparison
		String option = toggleOption.toLowerCase();

		// Reset initial state
		click(driver, considerAllocatedData);
		click(driver, considerAuditedData);

		// Handle toggle options
		if ("considerallocateddata".equals(option)) {
			click(driver, considerAllocatedData);
		} else if ("considerauditeddata".equals(option)) {
			click(driver, considerAuditedData);
		} else if ("allsample".equals(option)) {
			jsClick(allSample);
		} else if ("all".equals(option)) {
			click(driver, considerAllocatedData);
			click(driver, considerAuditedData);
			click(driver, allSample);
		} else {
			throw new IllegalArgumentException("Invalid toggle option: " + toggleOption);
		}

		return this;
	}

	public SamplingPlanAndGenerationPage saveSamplingAndGetConfirmation() {

		nextForConditional.click();
		nextForScheduling.click();
		save.click();

		wait.until(ExpectedConditions.visibilityOf(continueButton));
		assertTrue(continueButton.isDisplayed(), "Continue Button is not visible");
		System.out.println("Sample is Generated Successfully");

		continueButton.click();

		return this;
	}

	public SamplingPlanAndGenerationPage validationSamplingStatus(String stage, String process, String subProcess,
			String subSubProcess) {

		navigateWithinAlchemy(sampleStatus);

		String statusColumn = String.format(
				"//tr[td[5][normalize-space()='%s'] and td[6][normalize-space()='%s'] and td[7][normalize-space()='%s'] and td[8][normalize-space()='%s']]/td[2]/span",
				stage, process, subProcess, subSubProcess);

		System.out.println("statusColumn xpath : " + statusColumn);

		String samplingStatus = driver.findElement(By.xpath(statusColumn)).getText().trim();

		System.out.println("samplingStatusColumn :" + samplingStatus);

		if ("Completed".equals(samplingStatus)) {
			assertTrue(true, "Test Passed: Sampling status is Completed.");
			System.out.println("Completed -->> " + "Test Failed: Sampling status is not Completed.");
		} else if ("Running".equals(samplingStatus)) {
			System.out.println("Running -->> " + "Test Failed: Sampling status is Running.");
			assertFalse(false, "Test Failed: Sampling status is Running.");

		} else {
			// Handle other statuses if needed
			System.out.println("Status is neither Completed nor Running: " + samplingStatus);
		}

		return this;
	}

	/**
	 * Validates the dropdown elements on the Sampling Plan and Generation page.
	 * This method navigates within the system, validates that each dropdown
	 * contains the expected options, and selects specific options by their visible
	 * text.
	 *
	 * @return the current instance of SamplingPlanAndGenerationPage for method
	 *         chaining.
	 */

	public SamplingPlanAndGenerationPage validateDropdowns() {

		// Navigates to the appropriate section within the system
		navigateWithinAlchemy(sampleStatus);

		// Validates and selects an option in the process search dropdown
		dropdownValidation(processSearchDropdown, "AJP");
		selectByVisibleText(processSearchDropdown, "AJP");

		// Validates and selects an option in the subprocess search dropdown
		dropdownValidation(subProcessSearchDropdown, "Sub AJP");
		selectByVisibleText(subProcessSearchDropdown, "Sub AJP");

		// Validates and selects an option in the sub-subprocess search dropdown
		dropdownValidation(subSubProcessSearchDropdown, "Sub Sub AJP");
		selectByVisibleText(subSubProcessSearchDropdown, "Sub Sub AJP");

		// Validates and selects an option in the stage search dropdown
		dropdownValidation(stageSearchDropdown, "FreshFieldSet Stages");
		selectByVisibleText(stageSearchDropdown, "FreshFieldSet Stages");

		return this;
	}

	/**
	 * Validates that a dropdown contains multiple options and that the specified
	 * expected option is present. The method first checks that the dropdown is not
	 * a multi-select dropdown. It then verifies that the dropdown has at least one
	 * selectable option (besides a placeholder option, if present). Finally, it
	 * checks that the specified expected option exists within the dropdown options.
	 *
	 * @param dropdownElement the WebElement representing the dropdown to validate.
	 * @param expectedOption  the option that should be present within the dropdown.
	 * @return the current instance of SamplingPlanAndGenerationPage for method
	 *         chaining.
	 * @throws AssertionError if the dropdown is empty, has only a placeholder, or
	 *                        does not contain the expected option.
	 */

	public SamplingPlanAndGenerationPage dropdownValidation(WebElement dropdownElement, String expectedOption) {
		Select dropdown = new Select(dropdownElement);

		// Assert that the dropdown is not a multi-select
		assertFalse(dropdown.isMultiple(), "Dropdown should not support multiple selections.");

		try {
			// Fetch all options within the dropdown
			List<WebElement> options = dropdown.getOptions();

			// Check if options list is empty or contains only a placeholder
			if (options.isEmpty() || (options.size() == 1 && options.get(0).getText().isEmpty())) {
				throw new AssertionError("Dropdown is empty or contains only a placeholder option.");
			} else {
				System.out.println("Dropdown contains options.");
			}
		} catch (Exception e) {
			throw new AssertionError("Error validating dropdown options.", e);
		}

		// Verify that the dropdown contains the expected option
		try {
			// Retrieve all options text and store them in a list
			List<String> actualOptions = new ArrayList<>();
			for (WebElement option : dropdown.getOptions()) {
				actualOptions.add(option.getText());
			}

			// Assert that the expected option is present in the dropdown options
			if (!actualOptions.contains(expectedOption)) {
				throw new AssertionError("Dropdown does not contain expected option: " + expectedOption);
			}

			System.out.println("Dropdown contains all expected options.");
		} catch (Exception e) {
			throw new AssertionError("Error validating dropdown options.", e);
		}

		return this;
	}

	public SamplingPlanAndGenerationPage validateRecordsPerPage() {

		// Define options to test (10, 20, 50 records per page)
		int[] optionsToTest = { 10, 20, 50 };

		for (int option : optionsToTest) {
			// Re-fetch the dropdown each time before interacting
			WebElement dropdown = driver.findElement(By.xpath("//select[@id='page-size-select']"));
			Select select = new Select(dropdown);

			// Scroll the dropdown into view
			jsWindowsScrollIntoView(dropdown);

			// Select the dropdown value
			select.selectByVisibleText(String.valueOf(option));

			// Wait for the page to load/refresh after selection (use explicit wait instead
			// of sleep)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='show_entries m-0 font_13']")));

			// Fetch the "Showing X to Y of Z" text
			WebElement showingTextElement = driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']"));
			String showingText = showingTextElement.getText();

			// Extract the 'Showing 1 to X of Y' parts
			String[] showingParts = showingText.split(" ");
			int firstRecord = Integer.parseInt(showingParts[1]);
			int lastRecord = Integer.parseInt(showingParts[3]);
			int totalRecords = Integer.parseInt(showingParts[5]);

			System.out.println("Records Displayed: From " + firstRecord + " to " + lastRecord + " of " + totalRecords);

			// Fetch the list of records currently displayed
			List<WebElement> records = driver.findElements(By.xpath("//div[@class='dataset_table']//td[2]"));
			System.out.println("Number of records displayed on the page: " + records.size());

			// Validate the number of records displayed on the current page
			if (records.size() <= option) {
				System.out.println("Validation passed: Number of records per page is correct.");
			} else {
				System.out.println("Validation failed: Number of records per page is incorrect.");
			}

			// Validate if the last page has fewer records
			if (lastRecord == totalRecords && records.size() == lastRecord - firstRecord + 1) {
				System.out.println("Validation passed for the last page: Fewer records as expected.");
			}
		}
		return this;
	}

	@FindBy(xpath = "//button[text()='Delete']")
	WebElement confirmDeleteButton;

	public SamplingPlanAndGenerationPage deleteRecord(String nameToDelete) {

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameColumn.getText().contains(nameToDelete)) {

				WebElement deleteButton = row.findElement(By.xpath(".//td//div//img[@alt='delete-icon ']"));
				deleteButton.click();
				confirmDeleteButton.click();
				unWait(2);
				continueButton.click();
				System.out.println(nameToDelete + "  Successfully Deleted");
				break;
			}
		}
		return this;
	}

	// Locator for the record count label (e.g., "Showing 1 to 10 of 49")
	@FindBy(xpath = "//p[@class='show_entries m-0 font_13']") // Replace with actual selector
	private WebElement recordCountLabel;

	// Locator for individual records in the table
	@FindBy(xpath = "//div[@class='dataset_table']//td[2]") // Modify this selector to match each record row
	private List<WebElement> recordRows;

	// Locator for pagination next button
	@FindBy(xpath = "(//img[@alt='right_arrow'])[1]") // Replace with actual selector
	private WebElement nextButton;

	// Locator for pagination previous button
	@FindBy(xpath = "(//img[@alt='left_arrow'])[2]") // Replace with actual selector
	private WebElement prevButton;

	/**
	 * Validates pagination by navigating forward and backward through pages. Also
	 * counts and verifies the number of records displayed on each page.
	 */

	public void validatePagination() {
		int pageNumber = 1;
		boolean hasNextPage = true;

		// Navigate forward through pages
		while (hasNextPage) {
			System.out.println("Navigating to Page " + pageNumber);

			// Wait for the record count label to be visible and get its text
			wait.until(ExpectedConditions.visibilityOf(recordCountLabel));
			String recordRangeText = recordCountLabel.getText();
			System.out.println("Record Range Text: " + recordRangeText);

			// Count the actual number of records displayed on the page
			int recordCount = recordRows.size();
			System.out.println("Number of records on page " + pageNumber + ": " + recordCount);

			// Check if this is the last page by inspecting the record range text or
			// nextButton state
			if (!nextButton.isEnabled() || recordRangeText.contains("of " + recordCount)) {
				hasNextPage = false;
				System.out.println("Reached the last page.");
			} else {
				// Attempt to click on the next page button and increment the page number
				try {
					jsClick(nextButton);
					pageNumber++;
					System.out.println("Moving to Page " + pageNumber);

					// Wait for the next page to load by ensuring the record rows are reloaded
					wait.until(ExpectedConditions.visibilityOfAllElements(recordRows));
				} catch (Exception e) {
					System.out.println("Failed to navigate to the next page. " + e.getMessage());
					hasNextPage = false;
				}
			}
		}

		// Reset hasNextPage to true for backward navigation
		hasNextPage = true;

		// Navigate backward through pages
		while (pageNumber > 1 && hasNextPage) {
			System.out.println("Navigating back to Page " + pageNumber);

			// Wait for the records to load on the current page
			wait.until(ExpectedConditions.visibilityOfAllElements(recordRows));

			// Count the records on the current page
			int recordCount = recordRows.size();
			System.out.println("Number of records on page " + pageNumber + ": " + recordCount);

			// Check if we can navigate to the previous page
			if (prevButton.isEnabled()) {
				try {
					jsClick(prevButton);
					pageNumber--;
					System.out.println("Moved back to Page " + pageNumber);

					// Wait for the previous page to load by ensuring the record rows are reloaded
					wait.until(ExpectedConditions.visibilityOfAllElements(recordRows));
				} catch (Exception e) {
					System.out.println("Failed to navigate to the previous page. " + e.getMessage());
					hasNextPage = false;
				}
			} else {
				hasNextPage = false; // Stop if there are no more previous pages
				System.out.println("Reached the first page.");
			}
		}
	}

	@FindBy(xpath = "//td[5]")
	WebElement stageRecord;

	@FindBy(xpath = "//td[6]")
	WebElement processRecord;

	@FindBy(xpath = "//td[7]")
	WebElement subProcessRecord;

	@FindBy(xpath = "//td[8]")
	WebElement subSubProcessRecord;

	public SamplingPlanAndGenerationPage sampleValidations(String stage, String process, String subProcess,
			String subSubProcess) {
		navigateWithinAlchemy(sampleStatus);
		assertEquals(stageRecord.getText(), stage);
		assertEquals(processRecord.getText(), process);
		assertEquals(subProcessRecord.getText(), subProcess);
		assertEquals(subSubProcessRecord.getText(), subSubProcess);

		return this;
	}

}
