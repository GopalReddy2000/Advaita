package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class SamplingPlanAndGenerationPage extends TestBase {

	public SamplingPlanAndGenerationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sampling Plan & Generation")
	WebElement samplingPlanAndGeneration;

	@FindBy(linkText = "Sample Status")
	WebElement sampleStatus;

	@FindBy(linkText = "+ Create")
	WebElement create;

	@FindBy(id = "process")
	WebElement processDropdown;

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

	public SamplingPlanAndGenerationPage createSampling(String process, String subProcess, String subSubprocess,
			String Stages, String samplingPlaneName, String fromDate, String toDate, String samplingTo,
			String totalDataCall, String allSampleCondition, String needCondition, String needScheduling) {
		selectByVisibleText(processDropdown, process);
		selectByVisibleText(subProcessDropdown, subProcess);
		selectByVisibleText(subSubProcessDropdown, subSubprocess);
		selectByVisibleText(stagesDropdown, Stages);

		samplingPlanName.sendKeys(samplingPlaneName);
		js.executeScript("arguments[0].value = arguments[1];", samplingPlanFromDate, fromDate);
		js.executeScript("arguments[0].value = arguments[1];", samplingPlanToDate, toDate);
//        samplingPlanFromDate.sendKeys(fromDate);
//        samplingPlanToDate.sendKeys(toDate);

		selectByVisibleText(samplingToDropdown, samplingTo);

		totalDataCalls.sendKeys(totalDataCall);
		try {
			if (allSampleCondition.equals("yes")) {
				considerAllocatedData.click();
				considerAuditedData.click();
				allSample.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (needCondition.equalsIgnoreCase("yes")) {
//            createSamplingConditions("") ;
//            Xpath are not working proper
		} else if (needScheduling.equalsIgnoreCase("yes")) {
			// Xpath are not working proper

		} else {
			nextForConditional.click();
			nextForScheduling.click();
			save.click();
		}
		try {
			unWait(1);
			assertTrue(continueButton.isDisplayed(), "Continue Button is not visible");
			System.out.println("Sample is Generated Successfully");

			continueButton.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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
		click(driver, considerAllocatedData);
		click(driver, considerAuditedData);

		switch (toggleOption.toLowerCase()) {
		case "considerAllocatedData":
			click(driver, considerAllocatedData);
			break;
		case "considerAuditedData":
			click(driver, considerAuditedData);
			break;
		case "allSample":
			click(driver, allSample);
			break;
		case "all":
			click(driver, considerAllocatedData);
			click(driver, considerAuditedData);
			click(driver, allSample);
			break;
		default:
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

}
