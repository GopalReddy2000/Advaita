package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.pageObjects.StagesActions;

public class ValidationStatusReport extends TestBase {

	// Elements

	@FindBy(xpath = "//a[text()='Validation Status Report']")
	public WebElement validationStatusReportOption;

	@FindBy(xpath = "//a[text()='Validation Status Report']")
	public WebElement verifypage;

	@FindBy(id = "process_search")
	public WebElement processDropdown;

	@FindBy(id = "sub_process_search")
	public WebElement subProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process_search']")
	public WebElement subSubProcessDropdown;

	@FindBy(xpath = "//select[@id='stage_search']")
	public WebElement stagesDropdwon;

	@FindBy(xpath = "//input[@name='from_date']")
	public WebElement fromDate;

	@FindBy(xpath = "//input[@name='to_date']")
	public WebElement toDate;

	@FindBy(xpath = "(//img[@alt='filter_search'])[1]")
	public static WebElement searchButton;

	@FindBy(xpath = "//td[normalize-space(text())='No Entries Found']")
	public WebElement noEntriendFoundElement;

	@FindBy(id = "change_error_msg")
	public WebElement noLabelNameForGivenStagesErrorMessage;

	@FindBy(xpath = "(//button[text()='Continue'])[2]")
	public WebElement continueButton;

	@FindBy(xpath = "//table//tr//th")
	public List<WebElement> validationsStatusReportColumns;

	@FindBy(xpath = "(//img[contains(@class,' eye_icon_audit v')])[1]")
	public WebElement eyeIcon;

	@FindBy(xpath = "(//h2)[1]")
	public WebElement verifStageInAuditPagElement;

	@FindBy(xpath = "//a[text()='Export']")
	public WebElement exportOption;

	@FindBy(xpath = "(//label[text()='Trans Unique Id']/..//input)[2]")
	public WebElement transUniqueIdValue;

	public ValidationStatusReport() {
		PageFactory.initElements(driver, this);
	}

	// Helper method User By the References Of this Classes
	HomePage homePage = new HomePage();
	StagesActions stagesActions = new StagesActions();
	PropertieFileUtil propertieFileUtil = new PropertieFileUtil();
	DropDown dropDown = new DropDown();
	FieldVerificationUtils fieldVerificationUtils = new FieldVerificationUtils();

	// FilePath

	String validationStatusReort_FilePath = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\validationStatusReport.properties";

	// Methods

	public void navigateToValidationStatusReportAndVerify() {

		// homePage.navigateTo_AlchemyModule();

		wait.until(ExpectedConditions.visibilityOf(validationStatusReportOption));
		assertTrue(validationStatusReportOption.isDisplayed(), "validationStatusReportOption is not Displayed");
		// validationStatusReportOption.click();
		jsClick(validationStatusReportOption);

//		wait.until(ExpectedConditions.visibilityOf(verifypage));
//		assertTrue(verifypage.isDisplayed() && verifypage.getText() == " Validation Status Report",
//				"Failed: Validation Status report page is Not Displayed");

	}

	public void verifyFirstSelectedDropdownOption(WebElement DropdownElement, String dropdownOption) {

		Select select = new Select(DropdownElement);

		String firstSelectedDropdownOption = select.getFirstSelectedOption().getText();

		assertTrue(firstSelectedDropdownOption.equals(dropdownOption), "Failed: options Not Matched ");

	}

	public void selectProcess(String selectProcess) throws Throwable {

		switch (selectProcess) {
		case "givenprocessname":

			PropertieFileUtil.extractAllDropdownOptionsAndStore(validationStatusReort_FilePath, processDropdown,
					"process");
			String process = PropertieFileUtil.getSingleTextFromPropertiesFile(validationStatusReort_FilePath,
					"process7");

			dropDown.dropdownUtils(processDropdown, process);

			verifyFirstSelectedDropdownOption(processDropdown, process);

			break;

		case "randomprocess":

			DropDown.selectRandomOptionFromDropdwon(processDropdown);

			break;

		default:
			break;
		}

	}

	public void selectSubProcess(String selectSubProcess) throws Throwable {

		switch (selectSubProcess) {

		case "givenSubprocessname":

			PropertieFileUtil.extractAllDropdownOptionsAndStore(validationStatusReort_FilePath, subProcessDropdown,
					"Subprocess");
			String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(validationStatusReort_FilePath,
					"subProcess2");

			dropDown.dropdownUtils(subProcessDropdown, subProcess);

			verifyFirstSelectedDropdownOption(subProcessDropdown, subProcess);

			break;

		case "randomSubprocess":

			DropDown.selectRandomOptionFromDropdwon(subProcessDropdown);

			break;

		default:
			break;
		}

	}

	public void selectSubSubProcess(String selectSubSubProcess) throws Throwable {

		switch (selectSubSubProcess) {
		case "givensubsubprocessname":

			PropertieFileUtil.extractAllDropdownOptionsAndStore(validationStatusReort_FilePath, subSubProcessDropdown,
					"SubSubprocess");
			String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(validationStatusReort_FilePath,
					"SubSubprocess2");

			dropDown.dropdownUtils(subSubProcessDropdown, subSubProcess);

			verifyFirstSelectedDropdownOption(subSubProcessDropdown, subSubProcess);

			break;

		case "randomSubSubprocess":

			DropDown.selectRandomOptionFromDropdwon(subSubProcessDropdown);

			break;

		default:
			break;
		}

	}

	String stage;

	public void selectStages(String givenStageName) throws Throwable {

		switch (givenStageName) {

		case "givenStageName":

			// fieldVerificationUtils.checkthroughAsterisk(stageLabel, true);

			// Fetch Data FDrom Prperties File
			PropertieFileUtil.extractAllDropdownOptionsAndStore(validationStatusReort_FilePath, stagesDropdwon,
					"stage");

			stage = PropertieFileUtil.getSingleTextFromPropertiesFile(validationStatusReort_FilePath, "stage2");

			// select Process Dropdown
			dropDown.dropdownUtils(stagesDropdwon, stage);

			verifyFirstSelectedDropdownOption(stagesDropdwon, stage);

			break;

		case "randomStage":

			// fieldVerificationUtils.checkthroughAsterisk(stageLabel, true);

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(stagesDropdwon);

			break;

		default:
			break;
		}

	}

	// ---------- From Date ----------
	public void fromDate(String mode, WebElement DatePicker) {
		try {
			// Wait until visible and clickable

			wait.until(ExpectedConditions.visibilityOf(DatePicker));
			wait.until(ExpectedConditions.elementToBeClickable(DatePicker));

			// Remove readonly (if any)

			js.executeScript("arguments[0].removeAttribute('readonly')", DatePicker);

			String dateToEnter = "";

			switch (mode.toLowerCase()) {

			case "manual":

				dateToEnter = "12-07-2025"; // Your desired fixed date

				break;

			case "random":
				dateToEnter = generateRandomPastDate(); // Format: yyyy-MM-dd
				break;

			default:
				System.out.println("⚠️ Invalid mode passed: " + mode);
				return;
			}

			// Inject the date using JS (more reliable)
			js.executeScript("arguments[0].value='" + dateToEnter + "'", DatePicker);

			// Optional validation (logging)
			String actualDate = DatePicker.getAttribute("value");
			System.out.println("✅ From Date set to: " + actualDate + " (mode: " + mode + ")");

		} catch (Exception e) {
			System.err.println("❌ Error while setting From Date (" + mode + "): " + e.getMessage());
		}
	}

	// ---------- to Date ----------
	public void toDate(String mode, WebElement DatePicker) {
		try {
			// Wait until visible and clickable

			wait.until(ExpectedConditions.visibilityOf(DatePicker));
			wait.until(ExpectedConditions.elementToBeClickable(DatePicker));

			// Remove readonly (if any)

			js.executeScript("arguments[0].removeAttribute('readonly')", DatePicker);

			String dateToEnter = "";

			switch (mode.toLowerCase()) {

			case "manual":

				dateToEnter = "18-07-2025"; // Your desired fixed date

				break;

			case "random":
				dateToEnter = generateRandomPastDate(); // Format: yyyy-MM-dd
				break;

			default:
				System.out.println("⚠️ Invalid mode passed: " + mode);
				return;
			}

			// Inject the date using JS (more reliable)
			js.executeScript("arguments[0].value='" + dateToEnter + "'", DatePicker);

			// Optional validation (logging)
			String actualDate = DatePicker.getAttribute("value");
			System.out.println("✅ From Date set to: " + actualDate + " (mode: " + mode + ")");

		} catch (Exception e) {
			System.err.println("❌ Error while setting From Date (" + mode + "): " + e.getMessage());
		}
	}

	private String generateRandomPastDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickOnSearchButtonAndVefiy() throws Throwable {

		assertTrue(searchButton.isDisplayed(), "searchButton is not Displayed");

		searchButton.click();

		try {
			if (!noEntriendFoundElement.isDisplayed()) {

				System.out.println("Pass: Report Fields are Added For This Stages");

				PropertieFileUtil.extractAllAndStore(validationStatusReort_FilePath, validationsStatusReportColumns,
						"ReportsFields");

				String transUniqueID = PropertieFileUtil.getSingleTextFromPropertiesFile(validationStatusReort_FilePath,
						"ReportsFields14");

				List<String> listOfColumns = new ArrayList<String>();

				for (WebElement columnName : validationsStatusReportColumns) {
					String columnText = columnName.getText().trim(); // optional trim
					listOfColumns.add(columnText);
				}

				assertTrue(listOfColumns.contains(transUniqueID), "Failed :Trans Unique Id Not Present in Thsi Column");

			} else {

				wait.until(ExpectedConditions.visibilityOf(noLabelNameForGivenStagesErrorMessage));
				assertTrue(noLabelNameForGivenStagesErrorMessage.isDisplayed(),
						"noLabelNameForGivenStagesErrorMessage is Not Dispaleyd");

				System.out.println("⚠️ Failed: 'NoReport Fields' are added for this stage.");

				continueButton.click();

				stagesActions.navtoStages();
				stagesActions.naviagtoStageActions(stage);
				//stagesActions.chooseStagesActionOption("Report Fields");
				stagesActions.chooseStagesActionOption();

			}
		} catch (NoSuchElementException e) {
			// Element doesn't exist → treat it same as not displayed
			PropertieFileUtil.extractAllAndStore(validationStatusReort_FilePath, validationsStatusReportColumns,
					"ReportsFields");
		} catch (Exception e) {
			// Log any unexpected error
			System.out.println("❌ Unexpected error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void viewValidationStatusReport() throws IOException {

		assertTrue(eyeIcon.isDisplayed(), "eyeIcon is nOt Displayed");
		eyeIcon.click();

		String stageName = PropertieFileUtil.getSingleTextFromPropertiesFile(validationStatusReort_FilePath,
				"ReportsFields4");

	}

	public void exportReport() {

		assertTrue(exportOption.isDisplayed(), "exportOption is nOt Dispaleyd");
		exportOption.click();

	}

	public void clearFilter() {

	}

}
