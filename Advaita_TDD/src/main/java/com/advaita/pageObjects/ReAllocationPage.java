package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.PropertieFileUtil;

public class ReAllocationPage extends TestBase {

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

		List<String> multipleLabelTexts1 = Arrays.asList("Process*", "Sub Process*", "Sub Sub Process*");
		List<String> multipleDropdownIds1 = Arrays.asList("process", "sub_process", "s_sub_process");
		List<String> multipleDefaultOptions1 = Arrays.asList("Select Process", "Sub Process", "Sub Sub Process");
		List<String> multipleOptionsToSelect1 = Arrays.asList(process, subProcess, subSubProcess);

		DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts1, multipleDropdownIds1, multipleDefaultOptions1,
				multipleOptionsToSelect1, true);

		return this;
	}

	public ReAllocationPage selectStages(String stages) throws Throwable {

		DropDown.isMandatory("Stage*");
//		unWait(1);
		wait.until(ExpectedConditions.visibilityOf(stageDropDown));

		DropDown.jsDropdownWithAllPossibleValidation(driver, stageDropDown, "Select Stage Name", stages);
//		DropDown.dropdownWithAllPosibleValidation(stageDropDown, "Select Stage Name", stages);
//		DropDown.dropdownWithAllPosibleValidation(stageDropDown, "Select Stage Name", stages);
		return this;
	}

	public ReAllocationPage selectFromDesignation(String designation) throws Throwable {
//
//		DropDown.validateStarMarkAndHandleDropdown("From Designation*", "from_designation", "Select From Designation",
//				designation);
//		
		DropDown.isMandatory("From Designation*");
		wait.until(ExpectedConditions.visibilityOf(fromDesignationDropDown));
		DropDown.jsDropdownWithAllPossibleValidation(driver, fromDesignationDropDown, "Select From Designation",
				designation);

		return this;
	}

	public ReAllocationPage selectFromUser(String user) throws Throwable {

//		DropDown.validateStarMarkAndHandleDropdown("From User*", "from_user", "Select From User", user);

		DropDown.isMandatory("From User*");
		wait.until(ExpectedConditions.visibilityOf(fromUserDropDown));

		DropDown.jsDropdownWithAllPossibleValidation(driver, fromUserDropDown, "Select From Designation", user);

		return this;
	}

	public ReAllocationPage selectToDesignation(String designation) throws Throwable {

		DropDown.validateStarMarkAndHandleDropdown("To Designation*", "to_designation", "Select To Designation",
				designation);

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
		assertEquals(noOfRecords, String.valueOf(count), "noOfRecords are not equal.");

		return this;
	}

	public ReAllocationPage selectToUser(String designation) throws Throwable {

		DropDown.isMandatory("To User*");
		click(driver, toUserField);

		for (WebElement item : toUserList) {
			click(driver, item);

		}

		click(driver, recordCount);

		return this;
	}

	public ReAllocationPage reAllocationOfRecords(String condition, int maxClicks) throws Throwable {

		switch (condition.toLowerCase()) {

		case "all":

			click(driver, reAllocateAllButton);

			break;

		case "single":

//			int maxClicks = 5; // Number of checkboxes to click
			int count = 0; // Counter to track how many have been clicked

			for (WebElement checkBox : listOfCheckBox) {
				if (count < maxClicks) {
					actions.moveToElement(checkBox).perform();
					checkBox.sendKeys(Keys.SPACE);
					count++;
				} else {
					break; // Exit the loop after clicking 5 checkboxes
				}
			}

			click(driver, reAllocateButton);
			ReAllocateAndConfirmation();

			break;

		default:
			throw new IllegalArgumentException("Invalid toggle option: " + condition);
		}

		return this;
	}

	public ReAllocationPage ReAllocateAndConfirmation() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(continueButton));
		assertTrue(continueButton.isDisplayed(), "continueButton is not displayed.");
		click(driver, continueButton);

		return this;
	}
}
