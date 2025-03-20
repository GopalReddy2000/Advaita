package com.advaita.pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.PropertieFileUtil;

public class ReAllocationPage extends TestBase {

	@FindBy(id = "process")
	public WebElement processDropDown;

	@FindBy(id = "sub_process")
	public WebElement subProcessDropDown;

	@FindBy(id = "s_sub_process")
	public WebElement subSubProcessDropDown;

	@FindBy(id = "stage_name_id")
	public WebElement stageDropDown;

	@FindBy(id = "from_designation")
	public WebElement fromDesignationDropDown;

	@FindBy(id = "from_user")
	public WebElement fromUserDropDown;

	@FindBy(xpath = "//a[normalize-space()='Re Allocation']")
	public WebElement reAllocationButton;

	@FindBy(xpath = "//button[@type='button']/img")
	public WebElement searchButton;

	@FindBy(xpath = "(//p[contains(@class,'show_entries')])[1]")
	public WebElement recordCount;

	@FindBy(xpath = "//label[normalize-space()='To User*']/..//input[@type='search']")
	public WebElement toUserField;

	@FindBy(xpath = "//li[@role='treeitem']")
	public List<WebElement> toUserList;

	@FindBy(xpath = "//table//div[contains(@class,'optional-check')]/input")
	public List<WebElement> listOfCheckBox;

	@FindBy(xpath = "(//table//div[contains(@class,'optional-check')]/input)[1]")
	public WebElement checkBox;

	@FindBy(id = "reallocationBtn")
	public WebElement reAllocateButton;

	@FindBy(id = "reallocationAllBtn")
	public WebElement reAllocateAllButton;

	@FindBy(xpath = "//h3[text()='Success']/..//button[normalize-space()='Continue']")
	public WebElement continueButton;

	public ReAllocationPage() {

		PageFactory.initElements(driver, this);
	}

	public ReAllocationPage navigateToReAllocation() throws Throwable {

		navigateWithinAlchemy(reAllocationButton);

		return this;

	}

	public ReAllocationPage selectProcess_SubProcess_SubSubProcess_Stages(String process, String subProcess,
			String subSubProcess) throws Throwable {

//		List<String> multipleLabelTexts1 = Arrays.asList("Process*", "Sub Process*", "Sub Sub Process*");
//		List<String> multipleDropdownIds1 = Arrays.asList("process", "sub_process", "s_sub_process");
//		List<String> multipleDefaultOptions1 = Arrays.asList("Select Process", "Sub Process", "Sub Sub Process");
//		List<String> multipleOptionsToSelect1 = Arrays.asList(process, subProcess, subSubProcess);
//
//		DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts1, multipleDropdownIds1, multipleDefaultOptions1,
//				multipleOptionsToSelect1, true);

		DropDown.isMandatory("Process*");
		DropDown.dropdownWithAllPosibleValidation(processDropDown, "Select Process", process);
		unWait(1);

		wait.until(ExpectedConditions.visibilityOf(subProcessDropDown));
		DropDown.isMandatory("Sub Process*");
		DropDown.dropdownWithAllPosibleValidation(subProcessDropDown, "Sub Process", subProcess);
		unWait(2);

		wait.until(ExpectedConditions.visibilityOf(subSubProcessDropDown));
		DropDown.isMandatory("Sub Sub Process*");
		DropDown.dropdownWithAllPosibleValidation(subSubProcessDropDown, "Sub Sub Process", subSubProcess);
		unWait(2);

		return this;
	}

	public ReAllocationPage selectStages(String stages) throws Throwable {

		DropDown.isMandatory("Stage*");
//		unWait(1);
		wait.until(ExpectedConditions.visibilityOf(stageDropDown));

//		DropDown.jsDropdownWithAllPossibleValidation(driver, stageDropDown, "Select Stage Name", stages);
		DropDown.dropdownWithAllPosibleValidation(stageDropDown, "Select Stage Name", stages);
		unWait(2);

		return this;
	}

	public ReAllocationPage selectFromDesignation(String designation) throws Throwable {

		DropDown.validateStarMarkAndHandleDropdown("From Designation*", "from_designation", "Select From Designation",
				designation);

		unWait(2);
//		
//		DropDown.isMandatory("From Designation*");
//		wait.until(ExpectedConditions.visibilityOf(fromDesignationDropDown));
//		DropDown.jsDropdownWithAllPossibleValidation(driver, fromDesignationDropDown, "Select From Designation",
//				designation);

		return this;
	}

	public ReAllocationPage selectFromUser(String user) throws Throwable {

		DropDown.validateStarMarkAndHandleDropdown("From User*", "from_user", "Select From User", user);

//		DropDown.isMandatory("From User*");
//		wait.until(ExpectedConditions.visibilityOf(fromUserDropDown));
//
//		DropDown.jsDropdownWithAllPossibleValidation(driver, fromUserDropDown, "Select From Designation", user);

		return this;
	}

	public ReAllocationPage selectToDesignation(String designation) throws Throwable {

		DropDown.validateStarMarkAndHandleDropdown("To Designation*", "to_designation", "Select To Designation",
				designation);
		
		unWaitInMilli(500);

		return this;
	}

	public ReAllocationPage search() throws Throwable {

		click(driver, searchButton);

		validationAfterSearch();

		return this;
	}

	public ReAllocationPage validationAfterSearch() throws Throwable {

		String totalRecordsCount = recordCount.getText();
		String recordsCount = totalRecordsCount.contains("of ") ? totalRecordsCount.split("of ")[1] : "Not found";
		int count = Integer.parseInt(recordsCount);
		System.out.println("Count : " + count);
		String noOfRecords = PropertieFileUtil.getSingleTextFromPropertiesFile("no.OfRecord");
		softAssert.assertEquals(noOfRecords, String.valueOf(count), "noOfRecords are not equal.");

		return this;
	}

	public ReAllocationPage selectToUser(List<String> toUsersList) throws Throwable {
		DropDown.isMandatory("To User*");
		click(driver, toUserField); // Open the dropdown or field

		// Loop through the list of users and select each one
		for (String toUser : toUsersList) {
			String toUserXpath = String.format("//li[contains(@role,'treeitem')][normalize-space()='%s']", toUser);
			WebElement userElement = driver.findElement(By.xpath(toUserXpath));
			click(driver, userElement); // Select each user
		}

		click(driver, recordCount); // Click on record count or any other button after selecting users

		return this;
	}

	public ReAllocationPage reAllocationOfRecords(int maxClicks, String condition, String designation,
			List<String> toUsersList) throws Throwable {

		switch (condition.toLowerCase()) {

		case "all":

			click(driver, reAllocateAllButton);

			break;

		case "multiple":

			if (maxClicks > 1) {
				clickMultipleCheckBoxes(maxClicks, null, null, null);
			}

			break;

		case "single":

			if (maxClicks >= 1) {
				clickMultipleCheckBoxes(maxClicks, "single", designation, toUsersList);
			}

			break;

		default:
			throw new IllegalArgumentException("Invalid toggle option: " + condition);
		}

		return this;
	}

	private void clickMultipleCheckBoxes(int maxClicks, String condition, String designation, List<String> toUsersList)
			throws Throwable {
		int count = 0;

		// Single execution flow: Only if condition is "single"
		if ("single".equalsIgnoreCase(condition)) {
			// Click the specific checkbox based on the maxClicks count
			while (count < maxClicks) {
				// Move to the specific single checkbox element
				actions.moveToElement(checkBox).perform();

				// Click the checkbox
				checkBox.sendKeys(Keys.SPACE);

				// Perform the actions for each checkbox interaction
				click(driver, reAllocateButton); // Click reAllocateButton after each checkbox interaction
				ReAllocateAndConfirmation(); // Call reallocation and confirmation method after each checkbox interaction
				
				// Only select designation and users if this is NOT the last iteration
				if (count < maxClicks - 1) {
					selectToDesignation(designation); // Select the designation
					selectToUser(toUsersList); // Select users from the list
				}

				count++; // Increment the count
			}
		}
		// Multiple execution flow: Loop through multiple checkboxes in listOfCheckBox
		else if ("multiple".equalsIgnoreCase(condition) || condition == null) {
			// Loop through the list of checkboxes up to maxClicks count
			for (WebElement checkBox : listOfCheckBox) {
				if (count >= maxClicks) {
					break; // Exit loop after reaching maxClicks
				}

				// Move to the checkbox element
				actions.moveToElement(checkBox).perform();

				// Click the checkbox
				checkBox.sendKeys(Keys.SPACE);

				count++; // Increment the count
			}

			// Perform the actions after interacting with all selected checkboxes
			click(driver, reAllocateButton); // Click reAllocateButton after interacting with checkboxes
			ReAllocateAndConfirmation(); // Call reallocation and confirmation method
		}
	}

	public ReAllocationPage ReAllocateAndConfirmation() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(continueButton));
		assertTrue(continueButton.isDisplayed(), "continueButton is not displayed.");
		click(driver, continueButton);

		return this;
	}
}
