package com.advaita.pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.PropertieFileUtil;

public class ManualAllocationPage extends TestBase {

	@FindBy(xpath = "(//span[normalize-space()='Alchemy'])[1]")
	public WebElement alchemyButton;

	@FindBy(xpath = "//a[normalize-space()='Manual Allocation']")
	public WebElement manualAllocationButton;

	@FindBy(linkText = "+ Create")
	public WebElement createManualAllocationButton;

	@FindBy(xpath = "//h2[normalize-space()='Create Manual Allocation']")
	public WebElement createManualAllocationPopUp;

	@FindBy(xpath = "//span[normalize-space()='Trainee']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement traineeToogleButton;

	@FindBy(xpath = "//span[normalize-space()='Test']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement testToogleButton;

	@FindBy(xpath = "//span[normalize-space()='Normal Audit']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement normalAuditToogleButton;

	@FindBy(xpath = "//span[normalize-space()='Calibration']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement calibrationToogleButton;

	@FindBy(xpath = "//label[text()='Role']/..//select[@id='to_role']")
	public WebElement roleDropDown;

	@FindBy(xpath = "//label[normalize-space()='To User*']/..//input[@type='search']")
	public WebElement toUserField;

	@FindBy(xpath = "//li[@role='treeitem']")
	public List<WebElement> toUserList;

	@FindBy(id = "manual_id")
	public WebElement saveButton;

	@FindBy(xpath = "//h3[text()='Success']/..//button[normalize-space()='Continue']")
	public WebElement continueButton;

	@FindBy(xpath = "//tr[@class='col_rowval']//input[contains(@class, 'select2-search__field') and @tabindex='-1']")
	public List<WebElement> toUserFields;

	@FindBy(xpath = "(//tr[@class='col_rowval']//input[contains(@class, 'select2-search__field') and @tabindex='-1'])[1]")
	public WebElement singleToUserField;

	@FindBy(xpath = "(//a[text()='Allocate'])[1]")
	public WebElement allocateButton;

	@FindBy(id = "total_sample_count")
	public WebElement totalSample;

	public ManualAllocationPage() {
		PageFactory.initElements(driver, this);
	}

	public ManualAllocationPage navigateToAlchemyManualAllocation() {

		click(driver, alchemyButton);
		click(driver, alchemyButton);
		click(driver, manualAllocationButton);
		click(driver, createManualAllocationButton);

		return this;
	}

	public ManualAllocationPage allocationMethodToggleButton(String toggleOption) {
		switch (toggleOption.toLowerCase()) {
		case "trainee":
			click(driver, traineeToogleButton);
			break;
		case "test":
			click(driver, testToogleButton);
			break;
		case "normalaudit":
			click(driver, normalAuditToogleButton);
			click(driver, normalAuditToogleButton);
			break;
		case "calibration":
			click(driver, calibrationToogleButton);
			break;
		default:
			throw new IllegalArgumentException("Invalid toggle option: " + toggleOption);
		}

		return this;
	}

	public ManualAllocationPage selectProcess_subProcess_SubSubProcess_StagesDropdown(String... processOptions)
			throws Throwable {

		List<String> multipleLabelTexts = Arrays.asList("Process*", "Sub Process*", "Sub Sub Process*", "Stages*");
		List<String> multipleDropdownIds = Arrays.asList("process", "sub_process", "s_sub_process", "stage_name_id");
		List<String> multipleDefaultOptions = Arrays.asList("Select Process", "Sub Process", "Sub Sub Process",
				"Select Stage");
		List<String> multipleOptionsToSelect = Arrays.asList(processOptions);

		DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts, multipleDropdownIds, multipleDefaultOptions,
				multipleOptionsToSelect, true);
		return this;
	}

//	public ManualAllocationPage selectStageDropdown(String stage) throws Throwable {
//
//		DropDown.validateStarMarkAndHandleDropdowns("Stages*", "stage_name_id", "Select Stage", stage, true);
//		return this;
//	}

	public static String selectGroup = "Agent";

	public ManualAllocationPage allocationTypeDropdown(String allocationType, String userName) throws Throwable {

		PropertieFileUtil.storeSingleTextInPropertiesFile("designation", selectGroup);

		switch (allocationType.toLowerCase()) {
		case "call":

			List<String> multipleLabelTexts = Arrays.asList("Allocation Type *", "Role");
			List<String> multipleDropdownIds = Arrays.asList("id_allocation_type", "to_role");
			List<String> multipleDefaultOptions = Arrays.asList("Select", "All");
			List<String> multipleOptionsToSelect = Arrays.asList("Call Wise", selectGroup);

			DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts, multipleDropdownIds, multipleDefaultOptions,
					multipleOptionsToSelect, false);

			String totalSampleCount = totalSample.getText();
	        String sampleCount = totalSampleCount.contains(": ") ? totalSampleCount.split(": ")[1] : "Not found";
	        int count = Integer.parseInt(sampleCount);

			System.out.println("sampleCount : " + count);

			for (int i = 1; i <= count; i++) {

				Thread.sleep(1000);

				actions.moveToElement(singleToUserField).perform();

//				jsClick(driver, item);
				ClickUtilities.clickWithRetry(singleToUserField, 4);
				Thread.sleep(1000);
				String userNameXPath = String.format("//li[@role='treeitem'][normalize-space()='%s']", userName);
				WebElement userNameCall = driver.findElement(By.xpath(userNameXPath));
				userNameCall.click();
//				driver.findElement(By.xpath(userNameXPath)).click();
				actions.moveToElement(allocateButton).perform();
				click(driver, allocateButton);
				wait.until(ExpectedConditions.visibilityOf(continueButton));
				unWait(1);
				jsClick(continueButton);
//				continueButton.click();
				unWait(1);
//				click(driver, continueButton);
//				jsClick(driver, continueButton);

				driver.findElement(By.xpath("//h2[normalize-space()='Create Manual Allocation']")).click();

			}

//			String firstInputXPath = "//tr[@class='col_rowval']//input[contains(@class, 'select2-search__field') and @tabindex='-1']";

			break;
		case "qa":

			List<String> multipleLabelTexts1 = Arrays.asList("Allocation Type *", "From User*");
			List<String> multipleDropdownIds1 = Arrays.asList("id_allocation_type", "from_user");
			List<String> multipleDefaultOptions1 = Arrays.asList("Select", "Select");
			List<String> multipleOptionsToSelect1 = Arrays.asList("QA Wise", "GopalReddy");

			DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts1, multipleDropdownIds1,
					multipleDefaultOptions1, multipleOptionsToSelect1, false);

			DropDown.isMandatory("To User*");
			click(driver, toUserField);

			for (WebElement item : toUserList) {
				click(driver, item);

			}

			driver.findElement(By.xpath("//p[contains(text(),'Total Samples')]")).click();

			break;
		case "cliqa":
			DropDown.validateStarMarkAndHandleDropdown("Allocation Type *", "id_allocation_type", "Select",
					"CliQA Wise");
			break;
		case "tl":
			DropDown.validateStarMarkAndHandleDropdown("Allocation Type *", "id_allocation_type", "Select", "TL Wise");
			break;
		case "role":
			DropDown.validateStarMarkAndHandleDropdown("Allocation Type *", "id_allocation_type", "Select",
					"Role Wise");
			break;
		default:
			throw new IllegalArgumentException("Invalid toggle option: " + allocationType);
		}

		return this;

	}

	public ManualAllocationPage saveAndConfirmation() throws Throwable {

		click(driver, saveButton);

		wait.until(ExpectedConditions.visibilityOf(continueButton));
		assertTrue(continueButton.isDisplayed(), "continueButton is not displayed.");
		click(driver, continueButton);

		return this;
	}

}