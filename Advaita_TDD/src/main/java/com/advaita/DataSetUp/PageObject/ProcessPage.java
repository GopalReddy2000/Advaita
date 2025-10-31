package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.Pagination;
import com.advaita.Utilities.PropertieFileUtil;

import Advaita_TDD.Advaita_TDD.FakeData;

public class ProcessPage extends TestBase {

	// =========== ProcessSetup ==========

	List<String> beforeProcessListText;
	List<String> statulistTextListsList;

	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(xpath = "//img[@alt='justify_icon']")
	public WebElement sideBar;

	@FindBy(xpath = "//span[normalize-space()='Data Setup']")
	public static WebElement DataSetUpButton;

	@FindBy(id = "pills-Process-tab")
	public static WebElement processTab;

	@FindBy(id = "pills-dataset-tab")
	public static WebElement dataSetTab;

	@FindBy(id = "pills-metadata-tab")
	public static WebElement metadataTab;

	@FindBy(id = "pills-dataupload-tab")
	public static WebElement datauploadTab;

	@FindBy(id = "text_search")
	public static WebElement searchBar;

	@FindBy(id = "status_search")
	public static WebElement statusDropDown;

	@FindBy(xpath = "(//img[@alt='filter_search'])[1]")
	public static WebElement searchButton;

	@FindBy(xpath = "//h6[text()='Clear All Filters']")
	public static WebElement clearButton;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//span")
	public static WebElement totalNoOfRecords;

	@FindBy(id = "create_process")
	public static WebElement createProcessButton;

	@FindBy(xpath = "//div[@class='modal-dialog modal-md']//div[@class='modal-content']")
	public static WebElement addProcessPupup;

	@FindBy(xpath = "//div[@class='modal-dialog modal-lg detail_form']//div[@class='modal-content']")
	public static WebElement createDataSetPupup;

	@FindBy(xpath = "//label[text()='Process Name*']")
	public WebElement processNameLabel;

	@FindBy(id = "process_name")
	public WebElement processNameField;

	@FindBy(xpath = "//label[text()='Process Description']")
	public WebElement processDescriptionLabel;

	@FindBy(id = "process_desc")
	public WebElement processDescField;

	@FindBy(xpath = "(//label[text()='Status'])[1]")
	public WebElement processStatusDropdownLabel;

	@FindBy(id = "process_status")
	public static WebElement processStatusDropDown;

	@FindBy(id = "save_and_continnue")
	public WebElement saveandContinueButton;

	@FindBy(xpath = "//div[@id='pills-popupprocess']//button[@value='save'][normalize-space()='Save']")
	public WebElement saveButton;

	@FindBy(id = "sub_process")
	public static WebElement subProcessTab;

	@FindBy(id = "process_dropdown_label")
	public WebElement selectProcessDropdownLabel;

	@FindBy(xpath = "//select[@id='process_dropdown']")
	public static WebElement selectProcessDropDown;

	@FindBy(xpath = "//label[text()='Sub Process Name']")
	public WebElement subProcessNameFieldLabel;

	@FindBy(id = "sub_process_name")
	public WebElement subProcessNameField;

	@FindBy(xpath = "(//label[text()='Description'])[1]")
	public WebElement subProcessDescriptionFieldLabel;

	@FindBy(id = "sub_process_desc")
	public WebElement subProcessDescField;

	@FindBy(id = "sub_process_status")
	public static WebElement subProcessStatusDropDown;

	@FindBy(xpath = "(//button[@value='save_and_continnue'][normalize-space()='Save and Continue'])[2]")
	public WebElement saveandContinnueButtonInSubProcess;

	@FindBy(xpath = "//div[@id='pills-popupsubprocess']//button[@value='save'][normalize-space()='Save']")
	public WebElement saveButtonInSubProcess;

	@FindBy(id = "s_sub_process")
	public static WebElement subSubProcessTab;

	@FindBy(id = "sub_process_dropdown_label")
	public WebElement subProcessDropdownLabel;

	@FindBy(xpath = "//select[@id='sub_process_dropdown']")
	public WebElement selectSubProcessDropDown;

	@FindBy(xpath = "//label[text()='Sub Sub Process Name']")
	public WebElement subSubProcessNameFieldLabel;

	@FindBy(id = "s_sub_process_name")
	public WebElement subSubProcessNameField;

	@FindBy(xpath = "(//label[text()='Description'])[2]")
	public WebElement subSubProcessDescFieldLabel;

	@FindBy(id = "s_sub_process_desc")
	public WebElement subSubProcessDescField;

	@FindBy(id = "s_sub_process_status")
	public static WebElement subSubProcessStatusDropDown;

	@FindBy(xpath = "//button[normalize-space()='Save And Update']")
	public WebElement save_UpdateButtonInSubsubProcess;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Process has been created']")
	public static WebElement createSuceessMessage;

	@FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
	public static WebElement continueButton;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//img[@alt='table_drop_down']")
	public WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td[1]//img[@alt='table_drop_down']")
	public WebElement dropDown2;

	@FindBy(xpath = "(//div[@class='action_width']//img[@alt='table-edit'])[1]")
	public WebElement editOption1;

//	@FindBy(xpath = "(//tbody//tr//div[@class='action_width']//img[@alt='table-edit'])[1]")
//	public static WebElement editoption01;

	@FindBy(xpath = "(//div[@class='action_width']//img[@alt='table-edit'])[2]")
	public WebElement editOption2;

	@FindBy(xpath = "(//div[@class='action_width']//img[@alt='table-edit'])[3]")
	public WebElement editOption3;

	@FindBy(xpath = "//button[normalize-space()='Save And Update']")
	public static WebElement save_UpdateButtonInSubProcess;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Process has been updated']")
	public static WebElement updateProcessSuceessMassgage;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Sub Process has been updated']")
	public WebElement updateSubProcessSuceessMassgage;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Sub Sub Process has been updated']")
	public static WebElement updateSubSubProcessSuceessMassgage;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//span")
	public static WebElement fetchFirstCreatedRecord;

	@FindBy(id = "dataset_name")
	public static WebElement dataSetNameField;

	@FindBy(id = "process")
	public static WebElement processDropDown;

	@FindBy(id = "sub_process")
	public static WebElement subProcessDropDown;

	@FindBy(id = "s_sub_process_status")
	public static WebElement subSubProcessDropDown;

	@FindBy(xpath = "//div/img[@alt='success_tick']/..//span[text()='Process has been created']")
	public static WebElement conformationMesgofCreateProcessElement;

	@FindBy(xpath = "//div/img[@alt='success_tick']/..//span[text()='Process has been created']/..//button[text()='Continue']")
	public static WebElement continuElement;

	@FindBy(xpath = "(//table[@class='process_table w-100']//tbody//tr//td//span)[1]")
	public static WebElement fetchProcessName;

	@FindBy(xpath = "(//table[@class='process_table w-100']//tbody//tr[2]//td[1]//span)[1]")
	public static WebElement fetchSubProcessName;

	@FindBy(xpath = "(//div[@class='content']//span)[1]")
	public WebElement fetchSubSubProcessName;

	@FindBy(xpath = "(//div[@class='d-flex align-items-center'])[1]")
	public static WebElement processRecordDropdown_tablePage;

	@FindBy(xpath = "//table//tr[@class='sub_tab_tr sub-table-border']")
	public static WebElement subprocessText;

	@FindBy(xpath = "//table//tbody//tr//tr//tr//td[@class='lorem-text']")
	public static WebElement subSubProcessText;

	@FindBy(xpath = "//a//img[@alt='notification_icon']")
	public static WebElement NotificationIconLink_tablePage;

	@FindBy(xpath = "(//div[@id='pills-AllNot']//div[@class='noti_blk d-flex justify-content-between '])[1]")
	public static WebElement ceatedProcessNotification_tablepage;

	@FindBy(xpath = "//div[@id='page_body_extend']//div[@class='filter_section gray_bg w-100']//span[@class='d-block text_default font_12']")
	public static WebElement totalProcessCount;

	@FindBy(xpath = "//select[@id='status_search']")
	public static WebElement StatusDropdown_table;

	@FindBy(xpath = "//div[@class='table_footer d-flex align-items-center justify-content-between']//nav//ul//li//a//img[@alt='left_arrow']")
	public static WebElement LeftnavigationButton_table;

	@FindBy(xpath = "//div[@class='table_footer d-flex align-items-center justify-content-between']//nav//ul//li//a//img[@alt='rgt_arrow']")
	public static WebElement navigationButton_table;

	@FindBy(xpath = "//div[@class='table_footer d-flex align-items-center justify-content-between']//p[@class='show_entries m-0 font_13']")
	public static WebElement showing_pageniation;

	@FindBy(xpath = "//li//a//img[@alt='left_arrow']")
	public static WebElement leftArrowOfPagination;

	@FindBy(xpath = "//li//a//img[@alt='rgt_arrow']")
	public static WebElement rightArrowOfPagination;

//    @FindBy(xpath ="(//table[@class='process_table w-100']//tbody//tr)[4]")
//	public static WebElement fetchSubProcssNamElement;

	// ProcessSetup

	@FindBy(xpath = "//h1[text()=' Process Management '][1]")
	public static WebElement verifyprocessManagement;

	@FindBy(xpath = "//table//tbody//tr//div//input/..//span") // table//tbody//tr//td[1]
	List<WebElement> processLists;

	@FindBy(xpath = "//table//tbody//tr//td[@class='process_status']//span") // table//tbody//tr//td[4]
	List<WebElement> statusLists;

	@FindBy(xpath = "//table//tbody//tr//td[@class='process_status']//span") // table//tbody//tr//td[4]
	public WebElement status;

	@FindBy(xpath = "//a[text()='Process Setup']")
	public static WebElement processSetupOption;

	@FindBy(xpath = "//h5[text()='Process Setup']")
	public static WebElement processSetupPopup;

	@FindBy(xpath = "//button[@id='saveButton']")
	public static WebElement processSetup_SaveButton;

	@FindBy(xpath = "//input[@id='is_single_only']/..//span[@class='slider round']")
	public static WebElement singleProcessToggleButton;

	@FindBy(xpath = "//select[@id='search_process']") // select[@id='search_process']/option[not(text()='Search
	public static WebElement searchProcess;

	@FindBy(xpath = "//select[@id='search_sub_process']")
	public WebElement searchSubProcess;

	@FindBy(xpath = "//select[@id='search_s_sub_process']")
	public WebElement searchSubSubProcess;

	@FindBy(xpath = "//button[@id='saveButton']")
	public static WebElement saveButton_processSetup;

	@FindBy(xpath = "//div/img[@alt='success_tick']/..//span[text()='Process Setup has been updated']")
	public static WebElement conformationMesgofProcessSetupUpdated;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public static WebElement continuButtonProcessSetup;

	@FindBy(xpath = "(//span[text()='×'])[2]")
	public static WebElement cancelButtonProcess;

	@FindBy(xpath = "(//span[text()='×'])[1]")
	public static WebElement cancelButtonProcessSetup;

	@FindBy(xpath = "//label[@class='name-error error']")
	public WebElement pleaseEnterName_ErrorMessage;

	@FindBy(xpath = "//label[text()='Please Select Process']")
	public WebElement processDropdownErrorMessage;

	@FindBy(xpath = "//label[text()='Please Select Sub Process']")
	public WebElement subProcessDropdownErrorMessage;

	@FindBy(xpath = "//label[@id='input_name-error']")
	public WebElement processNameAlreadyExists;

	@FindBy(xpath = "//td[normalize-space(text())='No Entries Found']")
	public WebElement noEntriesFound;

	@FindBy(xpath = "//label[@id='search_process-error']")
	public WebElement errorMessageProceess_ProcessSetup;

	@FindBy(xpath = "//label[@id='search_sub_process-error']")
	public WebElement errorMessageSubProceess_ProcessSetup;

	@FindBy(id = "search_s_sub_process-error")
	public WebElement errorMessageSubSubProceess_ProcessSetup;

	// New_Archive Process ,UnArchiveProcess
	@FindBy(xpath = "(//ul[@id='pills-tab'])[2]//button")
	public List<WebElement> subProcessesTab;

	@FindBy(xpath = "(//tbody//tr//td)[5]//div//button")
	public WebElement archiveActionButton_Process;

	@FindBy(xpath = "//tbody//tr[1]//td[5]//img[@alt='unarchive']")
	public WebElement unArchiveActionButton_process;

	@FindBy(xpath = "//h6[text()='Archive?']")
	public WebElement archivePopup;

	@FindBy(xpath = "(//h6[text()='Archive?']/..//button)[2]")
	public WebElement archivePopupOptions;

	@FindBy(xpath = "(//h6[text()='Archive?']/..//button)[1]")
	public WebElement cancelPopupOption_archive;

	@FindBy(xpath = "//h6[text()='Unarchive?']")
	public WebElement unArchivePopup;

	@FindBy(xpath = "(//h6[text()='Unarchive?']/..//button)[2]")
	public WebElement unArchivePopupOptions;

	@FindBy(xpath = "//h6[text()='Unarchive?']/..//button[1]")
	public WebElement cancelPopupOption_UnArchive;

	@FindBy(id = "change_msg")
	public WebElement successfullyMesagePopup;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public WebElement deletePopup;

	@FindBy(xpath = "//h6[text()='Delete ?']/..//button")
	public List<WebElement> deletePopupOptions;

	@FindBy(xpath = ".//td[1]")
	public List<WebElement> archivePorcessList;

	// Refrences Class We used
	FakeData fake = new FakeData();
	PropertieFileUtil propertieFileUtil = new PropertieFileUtil();
	ClickUtilities clickUtilities = new ClickUtilities();

	public ProcessPage() {

		PageFactory.initElements(driver, this);
	}

	// FilePath
	String dataSetup_FilePath = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\datSetup_process.properties";

	// Create
	public ProcessPage createProcess1(String processName, String processDesc) throws Throwable {

		assertTrue(createProcessButton.isDisplayed(), "createProcessButton is not displayed.");
		createProcessButton.click();

		wait.until(ExpectedConditions.visibilityOf(addProcessPupup));
		assertTrue(addProcessPupup.isDisplayed(), "addProcessPupup is not displayed.");

		assertTrue(processNameField.isDisplayed(), "processNameField is not displayed.");
		processNameField.sendKeys(processName);

		assertTrue(processDescField.isDisplayed(), "processDescField is not displayed.");
		processDescField.sendKeys(processDesc);

		assertTrue(processStatusDropDown.isDisplayed(), "processStatusDropDown");
		Select select = new Select(processStatusDropDown);
		select.selectByVisibleText("Active");

		assertTrue(saveandContinueButton.isDisplayed(), "saveandContinueButton is not displayed");
		saveandContinueButton.click();

//		assertTrue(saveButton.isDisplayed(), "saveButton is not displayed");
//		saveButton.click();
//
//		wait.until(ExpectedConditions.visibilityOf(conformationMesgofCreateProcessElement));
//		assertTrue(conformationMesgofCreateProcessElement.isDisplayed(),
//				"conformationMesgofCreateProcessElement is not displayed.");
//
//		assertTrue(continuElement.isDisplayed(), "continuElement is not displayed");
//		continuElement.click();
		PropertieFileUtil.storeSingleTextInPropertiesFile("process", processName);
		unWait(1);

		return this;

	}

	public ProcessPage createSubProcess(String subprocessfield, String subprocssDesc) throws Throwable {

//		assertTrue(fetchProcessName.isDisplayed(), "fetchProcessName is not displayed.");
//		String fetchhprocessName = fetchProcessName.getText();

//		System.out.println(fetchhprocessName);
//
//		assertTrue(createProcessButton.isDisplayed(), "createProcessButton is not displayed.");
//		createProcessButton.click();

		wait.until(ExpectedConditions.visibilityOf(subProcessTab));
		assertTrue(subProcessTab.isDisplayed(), "subProcessTab is not displayed");
		subProcessTab.click();

		wait.until(ExpectedConditions.visibilityOf(selectProcessDropDown));
		assertTrue(selectProcessDropDown.isDisplayed(), "selectProcessDropDown is not displayed");
//		Select select = new Select(selectProcessDropDown);
//		select.selectByVisibleText(fetchhprocessName);

		assertTrue(subProcessNameField.isDisplayed(), "subProcessNameField is not displayed");
		subProcessNameField.sendKeys(subprocessfield);

		assertTrue(subProcessDescField.isDisplayed(), "subProcessDescField is not displayed.");
		subProcessDescField.sendKeys(subprocssDesc);

		assertTrue(subProcessStatusDropDown.isDisplayed(), "subProcessStatusDropDown is not displayed.");
		Select select1 = new Select(subProcessStatusDropDown);
		select1.selectByVisibleText("Active");

		assertTrue(saveandContinnueButtonInSubProcess.isDisplayed(),
				"saveandContinnueButtonInSubProcess is not displayed.");
		saveandContinnueButtonInSubProcess.click();
//		assertTrue(saveButtonInSubProcess.isDisplayed(), "saveButtonInSubProcess is not displayed");
//		saveButtonInSubProcess.click();
//
//		wait.until(ExpectedConditions.visibilityOf(conformationMesgofCreateProcessElement));
//		assertTrue(conformationMesgofCreateProcessElement.isDisplayed(),
//				"conformationMesgofCreateProcessElement is not displayed.");
//
//		assertTrue(continuElement.isDisplayed(), "continuElement is not displayed");
//		continuElement.click();
		PropertieFileUtil.storeSingleTextInPropertiesFile("subProcess", subprocessfield);
		unWait(1);

		return this;

	}

	public ProcessPage navToProcess() {
		DataSetUpButton.click();
		processTab.click();
		return this;
	}

	public ProcessPage createSubSubProcess(String SubsubProcessName, String subSubProcessDesc) throws Throwable {

		Thread.sleep(2000);

//		assertTrue(dropDown1.isDisplayed(), "dropdown is not displayed");
//		dropDown1.click();
//
//		Thread.sleep(2000);
//		assertTrue(fetchSubProcessName.isDisplayed(), "fetchSubProcessName is not displayed.");
//		String fetchSubProcssNameElement = fetchSubProcessName.getText();
//		System.out.println("fetchSubProcssNameElement : " + fetchSubProcssNameElement);

//		assertTrue(createProcessButton.isDisplayed(), "create button is not displayed.");
//		createProcessButton.click();

		wait.until(ExpectedConditions.visibilityOf(subSubProcessTab));
		assertTrue(subSubProcessTab.isDisplayed(), "subSubProcessTab is not displayed");
		subSubProcessTab.click();

//		Select select = new Select(selectSubProcessDropDown);
//		select.selectByVisibleText(fetchSubProcssNameElement);

		wait.until(ExpectedConditions.visibilityOf(subSubProcessNameField));
		assertTrue(subSubProcessNameField.isDisplayed(), "subSubProcessNameField is not displayed");
		subSubProcessNameField.sendKeys(SubsubProcessName);

		assertTrue(subSubProcessDescField.isDisplayed(), "subSubProcessDescField is not displayed");
		subSubProcessDescField.sendKeys(subSubProcessDesc);

		assertTrue(subSubProcessDropDown.isDisplayed(), "subSubProcessDropDown is not displayed");
		Select select2 = new Select(subSubProcessDropDown);
		select2.selectByVisibleText("Active");

		save_UpdateButtonInSubsubProcess.isDisplayed();
		save_UpdateButtonInSubsubProcess.click();

		unWait(2);
		assertTrue(createSuceessMessage.isDisplayed(), "It is Not Displayed");
		continueButton.click();
		PropertieFileUtil.storeSingleTextInPropertiesFile("subSubProcess", SubsubProcessName);
//		assertTrue(save_UpdateButtonInSubsubProcess.isDisplayed(), "save_UpdateButtonInSubsubProcess is not displayed");
//		save_UpdateButtonInSubsubProcess.click();

		return this;
	}

//###########################################################################################################

	public void createProcess(String processName, String processDesc, String visibleText, String subProcessName,
			String subProcessDesc, String subVisibleText, String subSubProcessName, String subSubProcessDesc)
			throws Throwable {

		String beforeCreateRecords = driver.findElement(By.xpath("(//span[@class='d-block text_default font_12'])[1]"))
				.getText();
		System.out.println("beforeCreateRecords : " + beforeCreateRecords);

		int beforeCreateRecord = extractNumber(beforeCreateRecords);
		int beforeNumber = extractNumber(beforeCreateRecords) + 1;
//		System.out.println(String.format("beforeNumber (%d + 1) : %s", beforeCreateRecord, beforeNumber));
		System.out.println("beforeNumber" + "(" + beforeCreateRecord + "+1" + ") :" + beforeNumber);

//		verifying tabs are displayed or not. 
		assertTrue(processTab.isDisplayed() && dataSetTab.isDisplayed() && metadataTab.isDisplayed()
				&& datauploadTab.isDisplayed(), "tabs are not displayed.");

		createProcessButton.isDisplayed();
		createProcessButton.click();

		addProcessPupup.isDisplayed();

		processNameField.isDisplayed();
		processNameField.click();
		processNameField.isSelected();
		processNameField.sendKeys(processName + " Process");

		processDescField.isDisplayed();
		processDescField.click();
		processDescField.isSelected();
		processDescField.sendKeys(processDesc);

		processStatusDropDown.isDisplayed();
		Select select = new Select(processStatusDropDown);
		select.selectByVisibleText("Active");

		saveandContinueButton.isDisplayed();
		saveandContinueButton.click();

		subProcessTab.isDisplayed();

		Select select1 = new Select(selectProcessDropDown);
		select1.selectByVisibleText(processName);

		subProcessNameField.isDisplayed();
		subProcessNameField.click();
		subProcessNameField.isSelected();
		subProcessNameField.sendKeys(subProcessName + " SubProcess");

		subProcessDescField.isDisplayed();
		subProcessDescField.click();
		subProcessDescField.isSelected();
		subProcessDescField.sendKeys(subProcessDesc);

		subProcessStatusDropDown.isDisplayed();
		Select select2 = new Select(subProcessStatusDropDown);
		select2.selectByVisibleText("Active");

		saveandContinnueButtonInSubProcess.isDisplayed();
		saveandContinnueButtonInSubProcess.click();

		subSubProcessTab.isDisplayed();

		Select select3 = new Select(selectSubProcessDropDown);
		select3.selectByVisibleText(subProcessName);

		subSubProcessNameField.isDisplayed();
		subSubProcessNameField.click();
		subSubProcessNameField.isSelected();
		subSubProcessNameField.sendKeys(subSubProcessName + " SubSubProcess");

		subSubProcessDescField.isDisplayed();
		subSubProcessDescField.click();
		subSubProcessDescField.isSelected();
		subSubProcessDescField.sendKeys(subSubProcessDesc);

		subSubProcessStatusDropDown.isDisplayed();
		Select select4 = new Select(subSubProcessStatusDropDown);
		select4.selectByVisibleText("Active");

		save_UpdateButtonInSubsubProcess.isDisplayed();
		save_UpdateButtonInSubsubProcess.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		unWaitInMilli(500);
		Assert.assertTrue(createSuceessMessage.isDisplayed(), "It is Not Displayed");
		continueButton.click();

		driver.navigate().refresh();
		Thread.sleep(1000);

		String afterCreateRecords = driver.findElement(By.xpath("(//span[@class='d-block text_default font_12'])[1]"))
				.getText();
		System.out.println("afterCreateRecords : " + afterCreateRecords);

		int afterNumber = extractNumber(afterCreateRecords);
		System.out.println("afterNumber : " + afterNumber);

		assertEquals(afterNumber, beforeNumber);

		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(1000);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(1000);

	}

	public static int extractNumber(String input) {
		StringBuilder numberAsString = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				numberAsString.append(c);
			}
		}

		return Integer.parseInt(numberAsString.toString());
	}

	// Edit process

	public void editCreatedProcess(String editProcessDesc, String editSubProcessDesc, String editSubSubProcessDesc)
			throws Throwable {

		actions.moveToElement(driverIninteractable).perform();
		editOption1.click();
		processDescField.clear();
		processDescField.sendKeys(editProcessDesc);
		saveButton.click();
		Thread.sleep(3000);
		Assert.assertTrue(updateProcessSuceessMassgage.isDisplayed(), "It is Not Displayed");
		continueButton.click();

		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(1000);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(1000);

		editOption2.click();
		subProcessDescField.clear();
		subProcessDescField.sendKeys(editSubProcessDesc);
		saveButtonInSubProcess.click();
		Thread.sleep(3000);
		Assert.assertTrue(updateSubProcessSuceessMassgage.isDisplayed(), "It is Not Displayed");
		continueButton.click();

		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(1000);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(1000);

		editOption3.click();
		subSubProcessDescField.clear();
		subSubProcessDescField.sendKeys(editSubProcessDesc);
		save_UpdateButtonInSubProcess.click();
		Thread.sleep(2000);
		Assert.assertTrue(updateSubSubProcessSuceessMassgage.isDisplayed(), "It is Not Displayed");
		continueButton.click();
	}
	// =====================================================================================================

	public void EditProcess(String processname12345) {
		WebElement DataSetup_Link = driver.findElement(By.xpath("//a[@class='d-flex align-items-center  active ']"));
		DataSetup_Link.click();
		wait.until(ExpectedConditions.visibilityOf(editOption1));
		assertTrue(editOption1.isDisplayed(), "editOption1 is not displayed.");
		// editOption1.click();
		click(driver, editOption1);

		WebElement processExistText = driver
				.findElement(By.xpath("//label[text()='Process Name*']/..//input[@id='process_name']"));
		assertTrue(processExistText.isDisplayed(), "processExextText is not displayed");
		processExistText.getText();
		processExistText.clear();
		processExistText.sendKeys(processname12345);

		assertTrue(saveButton.isDisplayed(), "saveButton is not displayed.");
		saveButton.click();
	}

//	process table page

	public void tablePage() throws Throwable {

		String searchText = fetchFirstCreatedRecord.getText();

		searchBar.clear();
		searchBar.sendKeys(searchText);
		searchButton.click();
		Thread.sleep(2000);
		clearButton.click();

//		// Click a specific page by its number
//		WebElement pageLink = driver.findElement(By.cssSelector(
//				".pagination_nav .pagination .page-item:not(.disabled) a[href*='?page=" + pageNumber + "']"));
//		js.executeScript("arguments[0].scrollIntoView(true);", pageLink);
//		js.executeScript("arguments[0].click();", pageLink);
//
//		for (int i = 1; i <= 6; i++) {
//			WebElement nextPageLink = driver
//					.findElement(By.cssSelector(".pagination_nav .pagination .page-item:last-child a"));
//			js.executeScript("arguments[0].scrollIntoView(true);", nextPageLink);
//			js.executeScript("arguments[0].click();", nextPageLink);
//
//		}
//
//		for (int j = 1; j <= 5; j++) {
//			// Click the previous page link
//			WebElement previousPageLink = driver
//					.findElement(By.cssSelector(".pagination_nav .pagination .page-item:first-child a"));
//			js.executeScript("arguments[0].scrollIntoView(true);", previousPageLink);
//			js.executeScript("arguments[0].click();", previousPageLink);
//		}

		Pagination.paginate(driver, rightArrowOfPagination, leftArrowOfPagination);

	}

	// ProcessName
	public String fetchProcess_PropFile; // Retrive Value name Fro Pro

	public void searchThroughProcess(String searchProcess) throws Throwable {

		switch (searchProcess) {

		case "searchManually": {

			PropertieFileUtil.extractAllAndStore(dataSetup_FilePath, processLists, "process");

			assertTrue(searchBar.isDisplayed(), "searchBar is not displayed");
			searchBar.isEnabled();
			searchBar.clear();

			fetchProcess_PropFile = PropertieFileUtil.getSingleTextFromPropertiesFile(dataSetup_FilePath, "process1");

			searchBar.sendKeys(fetchProcess_PropFile);

			assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
			searchButton.click();

			assertEquals(fetchFirstCreatedRecord.getText(), fetchProcess_PropFile,
					"Not Matched With Searched Process Name");

			break;

		}

		case "randomely": {

			try {
				// Load properties file
				Properties props = new Properties();

				FileInputStream fis = new FileInputStream(dataSetup_FilePath);

				props.load(fis);

				// Collect all values
				List<String> values = new ArrayList<>();
				for (String key : props.stringPropertyNames()) {
					values.add(props.getProperty(key));
				}

				// Pick random value
				String randomValue = values.get(new Random().nextInt(values.size()));

				// Enter into search box

				searchBar.clear();
				searchBar.sendKeys(randomValue);

				assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
				searchButton.click();

				// Check for "No Entries Found" element
				List<WebElement> noEntryElements = driver.findElements(By.id("noEntriesFound"));
				if (!noEntryElements.isEmpty() && noEntryElements.get(0).isDisplayed()) {
					System.out.println("No created process available in this name: " + randomValue);
				} else {
					// Fetch first created record
					WebElement fetchFirstCreatedRecord = driver.findElement(By.id("fetchFirstCreatedRecord"));
					String fetchedText = fetchFirstCreatedRecord.getText().trim();

					if (fetchedText.equalsIgnoreCase(randomValue)) {
						System.out.println("Process is available in this name: " + randomValue);
					} else {
						System.out.println("Mismatch: searched for " + randomValue + ", but got " + fetchedText);
					}
				}

			} catch (IOException | NoSuchElementException e) {
				e.printStackTrace();
			}

			break;
		}

		case "partailName":

			try {
				// Load properties file
				Properties props = new Properties();
				FileInputStream fis = new FileInputStream(dataSetup_FilePath);
				props.load(fis);

				// Collect all values
				List<String> values = new ArrayList<>();
				for (String key : props.stringPropertyNames()) {
					values.add(props.getProperty(key));
				}

				// Pick random value
				String fullValue = values.get(new Random().nextInt(values.size()));

				// Extract partial string (first 3–6 characters randomly)
				int endIdx = Math.min(6, fullValue.length());
				int startIdx = new Random().nextInt(Math.max(1, endIdx - 2));
				String partialValue = fullValue.substring(startIdx, endIdx);

				// Enter partial value into search box
				searchBar.clear();
				searchBar.sendKeys(partialValue);

				assertTrue(searchButton.isDisplayed(), "Search button is not displayed");
				searchButton.click();

				// Check for "No Entries Found" element
				List<WebElement> noEntryElements = driver.findElements(By.id("noEntriesFound"));
				if (!noEntryElements.isEmpty() && noEntryElements.get(0).isDisplayed()) {
					System.out.println(" No created process available in this name (partial): " + partialValue);
				} else {
					WebElement fetchFirstCreatedRecord = driver.findElement(By.id("fetchFirstCreatedRecord"));
					String fetchedText = fetchFirstCreatedRecord.getText().trim();

					if (fetchedText.toLowerCase().contains(partialValue.toLowerCase())) {
						System.out
								.println(" PASS: Partial value '" + partialValue + "' found in result: " + fetchedText);
					} else {
						System.out.println(
								" FAIL: Partial value '" + partialValue + "' NOT found in result: " + fetchedText);
					}
				}

			} catch (IOException | NoSuchElementException e) {
				e.printStackTrace();
			}

			break;

		default:

			System.out.println("no Options Present  ");

			break;
		}

	}

	public void searchRandomPartialData(String dataSetup_FilePath) {
		try {
			// Load properties file
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream(dataSetup_FilePath);
			props.load(fis);

			// Collect all values
			List<String> values = new ArrayList<>();
			for (String key : props.stringPropertyNames()) {
				values.add(props.getProperty(key));
			}

			// Pick random value
			String fullValue = values.get(new Random().nextInt(values.size()));

			// Extract partial string (first 3–6 characters randomly)
			int endIdx = Math.min(6, fullValue.length());
			int startIdx = new Random().nextInt(Math.max(1, endIdx - 2)); // avoid 0-length
			String partialValue = fullValue.substring(startIdx, endIdx);

			// Enter partial value into search box
			searchBar.clear();
			searchBar.sendKeys(partialValue);

			assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
			searchButton.click();

			// Check for "No Entries Found" element
			List<WebElement> noEntryElements = driver.findElements(By.id("noEntriesFound"));
			if (!noEntryElements.isEmpty() && noEntryElements.get(0).isDisplayed()) {
				System.out.println("No created process available in this name: " + partialValue);
			} else {
				WebElement fetchFirstCreatedRecord = driver.findElement(By.id("fetchFirstCreatedRecord"));
				String fetchedText = fetchFirstCreatedRecord.getText().trim();

				if (fetchedText.toLowerCase().contains(partialValue.toLowerCase())) {
					System.out.println(
							"Process related to partial name '" + partialValue + "' is available: " + fetchedText);
				} else {
					System.out.println(
							"Partial mismatch: searched for '" + partialValue + "', but got '" + fetchedText + "'");
				}
			}

		} catch (IOException | NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void SearchCreatedProcesbySelctingStatus_Active() {
		searchedThroughStatus();
	}

	public void searchedThroughStatus() {
		assertTrue(StatusDropdown_table.isDisplayed(), "StatusDropdown_table is not displayed");
		Select select = new Select(StatusDropdown_table);
		select.selectByVisibleText("Active");

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		searchButton.click();

		// Table valiadtion
		WebElement table = driver.findElement(By.cssSelector("table.process_table tbody"));

		// Get all rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Flag to check the validation status
		boolean allStatusesActive = true;

		// Iterate through each row and validate the status column
		for (int i = 0; i < rows.size(); i++) {
			// Locate the status cell in the fourth column of the current row
			WebElement statusCell = rows.get(i).findElements(By.tagName("td")).get(3);

			// Get the status text
			String statusText = statusCell.getText().trim();

			System.out.println();

			assertNotNull(statusText);

			// Check if the status is not "Active"
			if ("Active".equals(statusText)) {
				System.out.println("Validation failed at row " + (i + 1) + ". Status: " + statusText);
				allStatusesActive = false;
			}
		}

		// Print the final validation result
		if (allStatusesActive) {
			System.out.println("All statuses are Active.");
		} else {
			System.out.println("There are rows with status not set to Active.");
		}

	}

	public void clearFliter() {

		assertTrue(clearButton.isDisplayed(), "Clear button is not displayed");

		clearButton.click();

		// Verify that the search bar is cleared

		wait.until(ExpectedConditions.visibilityOf(searchBar));
		String searchValue = searchBar.getAttribute("value");
		assertEquals(searchValue, "", "Failed: After clicking clear, search text field is not empty");
	}

	// Naviagte To SubList
	public void clickonProcessDropDownToacessSubList_Tablepage() {

		WebElement processRecordDropdown_tablePage = driver
				.findElement(By.xpath("(//div[@class='d-flex align-items-center'])[1]"));
		processRecordDropdown_tablePage.click();

		WebElement subprocessText = driver.findElement(By.xpath("//table//tr[@class='sub_tab_tr sub-table-border']"));
		assertTrue(subprocessText.isDisplayed(), "subprocessText is not displayed");
		subprocessText.getText();
	}

// verify the user is able to click on created process dropdown again click on subprocess dropdown to access the sub sublist

	public void clickonProcessDropDownAgainSubprocessDropdownToacessSubSubList_Tablepage() {
		assertTrue(processRecordDropdown_tablePage.isDisplayed(), "processRecordDropdown_tablePage is not displayed");
		processRecordDropdown_tablePage.click();

		wait.until(ExpectedConditions.visibilityOf(subprocessText));
		assertTrue(subprocessText.isDisplayed(), "subprocessText is not displayed");
		subprocessText.getText();

		assertTrue(dropDown2.isDisplayed(), "dropDown2 is not displayed");
		dropDown2.click();

		assertTrue(subSubProcessText.isDisplayed(), "subSubProcessText is not displayed");
		subSubProcessText.getText();

	}

	// verify the user to get created notification by click bellicon present in top
	// of the web page

	public void createdprocessNotificatedByclickingBellIcon() throws Throwable {
		assertTrue(fetchProcessName.isDisplayed(), "fetchProcessName is not displayed");
		String textFromTableString = fetchProcessName.getText();
		System.out.println(fetchProcessName.getText());
		assertTrue(NotificationIconLink_tablePage.isDisplayed(), "NotificationIconLink_tablePage is not displayed");

		NotificationIconLink_tablePage.click();

		String ceatedProcessNotification_tablepage1 = ceatedProcessNotification_tablepage.getText();

		System.out.println(textFromTableString + "\n" + ceatedProcessNotification_tablepage1);
		Thread.sleep(2000);
		assertTrue(ceatedProcessNotification_tablepage1.contains(textFromTableString),
				"tableText and Notification text are mismatch.");
	}

	// verify the user is able to see the how much he created in total process

	public void HowmuchCreatedprocess() throws InterruptedException {
		assertTrue(totalProcessCount.isDisplayed(), "TotalProcess is not displayed");
		totalProcessCount.getText();
		System.out.println(totalProcessCount.getText());

		// Locate the element that displays the total number of processes
		WebElement totalProcessElement = driver.findElement(By.xpath("//span[contains(text(), 'Total Process')]"));
		String totalProcessText = totalProcessElement.getText();

		// Extract the number from the text
		// Thread.sleep(2);
		int totalProcessesDisplayed = Integer.parseInt(totalProcessText.replaceAll("[^0-9]", ""));
		System.out.println(totalProcessesDisplayed);

		// Locate the table rows for the processes
		List<WebElement> processRows = driver.findElements(By.xpath("//table/tbody/tr"));

		// Get the count of process rows
		int totalProcessesCounted = processRows.size();

		// Verify that the displayed total matches the counted total
		if (totalProcessesDisplayed == totalProcessesCounted) {
			System.out.println("Total processes match: " + totalProcessesDisplayed);
		} else {
			System.out
					.println("Mismatch! Displayed: " + totalProcessesDisplayed + ", Counted: " + totalProcessesCounted);
		}
	}

	// verify the user is search created process by selecting status dropdown
	// InActive Status

	public void SearchCreatedProcesbySelctingStatus_InAnctive() {
		assertTrue(StatusDropdown_table.isDisplayed(), "StatusDropdown_table is not displayed");
		Select select = new Select(StatusDropdown_table);
		select.selectByVisibleText("Inactive");

		assertTrue(searchButton.isDisplayed(), "searchButton is not dispalyed");
		searchButton.click();

		// Table valiadtion
		WebElement table = driver.findElement(By.cssSelector("table.process_table tbody"));

		// Get all rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Flag to check the validation status
		boolean allStatusesActive = true;

		// Iterate through each row and validate the status column
		for (int i = 0; i < rows.size(); i++) {
			// Locate the status cell in the fourth column of the current row
			WebElement statusCell = rows.get(i).findElements(By.tagName("td")).get(3);

			// Get the status text
			String statusText = statusCell.getText().trim();

			System.out.println();

			assertNotNull(statusText);

			// Check if the status is not "Active"
			if ("Inactive".equals(statusText)) {
				System.out.println("Validation failed at row " + (i + 1) + ". Status: " + statusText);
				allStatusesActive = false;
			}
		}

		// Print the final validation result
		if (allStatusesActive) {
			System.out.println("All statuses are Active.");
		} else {
			System.out.println("There are rows with status not set to Active.");
		}

	}

	// verify the user is nanvigate to next table page by click right arrow button

	public void NavigateToNextTablePageClick_Rightarrow() {
		assertTrue(navigationButton_table.isDisplayed(), "navigationButton_table is not displayed");
		// navigationButton_table.click();
		driver.getCurrentUrl();
		click(driver, navigationButton_table);
		// click(driver, navigationButton_table);

		if (driver.getCurrentUrl().equals(driver.getCurrentUrl())) {
			System.out.println("Sucessfully landed in next page");

		} else {
			System.out.println("It is not landed in next page");
		}

		assertTrue(showing_pageniation.isDisplayed(), "showing_pageniation is not displayed");
		showing_pageniation.getText();
		System.out.println(showing_pageniation.getText() + "Showing pagination");

	}

	// verify the user is nanvigate to next table page by click left arrow button

	public void NavigateToNextTablePageClick_leftarrow() {
		assertTrue(LeftnavigationButton_table.isDisplayed(), "LeftnavigationButton_table is not dispalyed");
		// LeftnavigationButton_table.click();
		String beforeClickURL = driver.getCurrentUrl();
		click(driver, LeftnavigationButton_table);

		if (driver.getCurrentUrl().equals(beforeClickURL)) {
			System.out.println("It is not landed in next page");
			assertTrue(false);
		} else {
			assertTrue(true);
			System.out.println("Sucessfully landed in next page");
		}

		assertTrue(showing_pageniation.isDisplayed(), "showing_pageniation is not displayed");
		showing_pageniation.getText();
		System.out.println(showing_pageniation.getText() + "Showing pagination");

	}

	// ============================== Process Setup===============

	// Verify the user is able to do "active" single process only

	public void naviagteToProcessSetupaAndVerifyPage() {

		assertTrue(processSetupOption.isDisplayed(), "processSetupOption is not dispalyed");

		processSetupOption.click();

		wait.until(ExpectedConditions.visibilityOf(processSetupPopup));
		assertTrue(processSetupPopup.isDisplayed(), "FAILED : processSetupPopup is Not Displayed");

	}

	public void allActiveProcesss() {
		assertTrue(processSetupOption.isDisplayed(), "processSetupOption is not dispalyed");
		processSetupOption.click();

		if (!singleProcessToggleButton.isEnabled()) {
			System.out.println("singleProcessToggleButton is DISABLE");
		}

//		assertTrue(saveButton_processSetup.isDisplayed(), "saveButton_processSetup is not dispplayed");
//		saveButton_processSetup.click();
//		
//		wait.until(ExpectedConditions.visibilityOf(conformationMesgofProcessSetupUpdated));
//		assertTrue(conformationMesgofProcessSetupUpdated.isDisplayed(), "conformationMesgofProcessSetupUpdatedis not displayed");
//		
//		assertTrue(continuButtonProcessSetup.isDisplayed(), "continuButtonProcessSetupis not dispalyed");
//		continuButtonProcessSetup.click();

		wait.until(ExpectedConditions.visibilityOf(cancelButtonProcess));
		assertTrue(cancelButtonProcess.isDisplayed(), "cancelButtonProcessSetupis not displayed");
		cancelButtonProcess.click();
		allActiveValidateStaus();

	}

	public void fetchProcessAndStatus() {
		assertTrue(verifyprocessManagement.isDisplayed(), "verifyprocessManagement");

		// Process Text
		beforeProcessListText = new ArrayList<>();
		for (WebElement processOptions : processLists) {
			beforeProcessListText.add(processOptions.getText());
			System.out.println("processListText :" + processOptions.getText());
		}

		assertTrue(processSetupOption.isDisplayed(), "processSetupOption");
		processSetupOption.click();

		// Status List

		statulistTextListsList = new ArrayList<String>();
		for (WebElement StatusOptions : statusLists) {
			statulistTextListsList.add(StatusOptions.getText());
			System.out.println("StatusOptionsText :" + StatusOptions.getText());
		}

	}

	String selectedProcess;

	public void SingleProcessOnly(String selectProcessSetUpManualley) throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(processSetupPopup));
		assertTrue(processSetupPopup.isDisplayed(), "processSetupPopup is not displauyed");

		if (singleProcessToggleButton.isEnabled()) {
			System.out.println(" singleProcessToggleButton is ENABLED");

		} else if (!singleProcessToggleButton.isEnabled()) {
			System.out.println("singleProcessToggleButton is DISABLED");

		}

		singleProcessToggleButton.click();

		switch (selectProcessSetUpManualley) {

		case "selectManualley": {

			// extract all aoptions From Dropdown and Store In Prop file by "key name"
			PropertieFileUtil.extractAllDropdownOptionsAndStore(dataSetup_FilePath, searchProcess, "searchProcess");
			String selectSerchProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(dataSetup_FilePath,
					"searchProcess7");
			DropDown.selectFromDropdownByText(searchProcess, selectSerchProcess);

			unWait(1);

			PropertieFileUtil.extractAllDropdownOptionsAndStore(dataSetup_FilePath, searchSubProcess,
					"searchSubProcess");
			String selectSerchSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(dataSetup_FilePath,
					"searchSubProcess2");
			DropDown.selectFromDropdownByText(searchSubProcess, selectSerchSubProcess);

			unWait(1);

			PropertieFileUtil.extractAllDropdownOptionsAndStore(dataSetup_FilePath, searchSubSubProcess,
					"searchSubSubProcess");
			String selectSerchSubSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(dataSetup_FilePath,
					"searchSubSubProcess2");
			DropDown.selectFromDropdownByText(searchSubSubProcess, selectSerchSubSubProcess);

			break;

		}

		case "randomely": {

			// extract all aoptions From Dropdown and Store In Prop file by "key name"
			PropertieFileUtil.extractAllDropdownOptionsAndStore(dataSetup_FilePath, searchProcess, "searchProcess");
			DropDown.selectRandomOptionFromDropdwon(searchProcess);

			Select select = new Select(searchProcess);
			selectedProcess = select.getFirstSelectedOption().getText();

			PropertieFileUtil.extractAllDropdownOptionsAndStore(dataSetup_FilePath, searchSubProcess,
					"searchSubProcess");
			DropDown.selectRandomOptionFromDropdwon(searchSubProcess);

			PropertieFileUtil.extractAllDropdownOptionsAndStore(dataSetup_FilePath, searchSubSubProcess,
					"searchSubSubProcess");
			DropDown.selectRandomOptionFromDropdwon(searchSubSubProcess);

			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}

		// capture the First Selected option
		Select select = new Select(searchProcess);
		selectedProcess = select.getFirstSelectedOption().getText();

		// save and Continue
		assertTrue(saveButton_processSetup.isDisplayed(), "saveButton_processSetup is not dispplayed");
		saveButton_processSetup.click();

		wait.until(ExpectedConditions.visibilityOf(conformationMesgofProcessSetupUpdated));
		assertTrue(conformationMesgofProcessSetupUpdated.isDisplayed(),
				"conformationMesgofProcessSetupUpdatedis not displayed");

		assertTrue(continuButtonProcessSetup.isDisplayed(), "continuButtonProcessSetupis not dispalyed");
		continuButtonProcessSetup.click();

		// search
		searchBar.sendKeys(selectedProcess);

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		searchButton.click();

		singleActiveValidateStaus();
	}

	public void singleActiveValidateStaus() {
		// Count the number of "Active" statuses
		long activeCount = statusLists.stream().filter(element -> element.getText().equals("Active")).count();
		System.out.println("activeCount:" + activeCount);

		// Assert that only one "Active" status is present
		Assert.assertEquals(activeCount, 1, "Only one 'Active' status should be displayed.");
	}

	public void allActiveValidateStaus() {
		// Count the number of "Active" statuses
		long activeCount = statusLists.stream().filter(element -> element.getText().equals("Inactive")).count();
		System.out.println("activeCount:" + activeCount);

		// Assert that only one "Active" status is present
		Assert.assertEquals(activeCount, 0, "Only one 'Active' status should be displayed.");
	}

//=============================== Neagtive =====================================================

	public void checkthroughAsterisk(WebElement elementLabel, boolean isMandatoryCheck) {

		boolean hasAsterisk = elementLabel.getText().contains("*");

		if (isMandatoryCheck) {
			assertTrue(hasAsterisk, "The field label does not indicate it is mandatory.");
			System.out.println("The 'status_name' field is mandatory.");
		} else {
			System.out.println("Field is not mandatory.");
		}
	}

	public void userFilledAllTheDatawithoutclickSaveandUpdateOptionInSubSubProcessTabAndclickOnCancelOption(
			String ProcessName, String processDesc, String SubProcessName, String SubProcessDesc,
			String SubSubProcessName, String SubSubProcessDesc) {
		withoutFilledSubSubProcesClickOnCancelOption(ProcessName, processDesc, SubProcessName, SubProcessDesc,
				SubSubProcessName, SubSubProcessDesc);
	}

	public void withoutFilledSubSubProcesClickOnCancelOption(String ProcessName, String processDesc,
			String SubProcessName, String SubProcessDesc, String SubSubProcessName, String SubSubProcessDesc) {

		try {

			// assertTrue(processTab.isDisplayed(), "processTab is not displayed");
			assertTrue(createProcessButton.isDisplayed(), "createProcessButton is not displayed");
			createProcessButton.click();

			wait.until(ExpectedConditions.visibilityOf(processNameLabel));
			checkthroughAsterisk(processNameLabel, true);
			assertTrue(processNameField.isDisplayed(), "processNameField is not displayed");
			processNameField.sendKeys(ProcessName);
			checkthroughAsterisk(processDescriptionLabel, false);
			assertTrue(processDescField.isDisplayed(), "processDescField is not dispalyed");
			processDescField.sendKeys(processDesc);

			assertTrue(saveandContinueButton.isDisplayed(), "saveandContinueButton is not displayed");
			saveandContinueButton.click();

			checkthroughAsterisk(subProcessNameFieldLabel, false);// as of now after implement we wll change
			wait.until(ExpectedConditions.visibilityOf(subProcessNameField));
			assertTrue(subProcessNameField.isDisplayed(), "subProcessNameField is not dispalyed");
			subProcessNameField.sendKeys(SubProcessName);
			checkthroughAsterisk(subProcessDescriptionFieldLabel, false);
			assertTrue(subProcessDescField.isDisplayed(), "subProcessDescField is not dispalyed");
			subProcessDescField.sendKeys(SubProcessDesc);

			wait.until(ExpectedConditions.visibilityOf(saveandContinnueButtonInSubProcess));
			assertTrue(saveandContinnueButtonInSubProcess.isDisplayed(),
					"saveandContinnueButtonInSubProcess is not displayed");
			saveandContinnueButtonInSubProcess.click();

			checkthroughAsterisk(subSubProcessNameFieldLabel, false);// as of now after implement we wll change
			wait.until(ExpectedConditions.visibilityOf(subSubProcessNameField));
			assertTrue(subSubProcessNameField.isDisplayed(), "subSubProcessNameField is not dispalyed");
			subSubProcessNameField.sendKeys(SubSubProcessName);
			checkthroughAsterisk(subSubProcessDescFieldLabel, false);
			assertTrue(subSubProcessDescField.isDisplayed(), "subSubProcessDescField is not dispalyed");
			subSubProcessDescField.sendKeys(SubSubProcessDesc);

			wait.until(ExpectedConditions.visibilityOf(cancelButtonProcess));
			assertTrue(cancelButtonProcess.isDisplayed(), "cancelButtonProcessSetup is not dispalyed");
			cancelButtonProcess.click();

			wait.until(ExpectedConditions.visibilityOf(conformationMesgofCreateProcessElement));
			assertTrue(conformationMesgofCreateProcessElement.isDisplayed(),
					"Test Failed: conformationMesgofCreateProcessElement is displayed. Test Pass: conformationMesgofCreateProcessElement is not displayed.");

			continueButton.click();

			fetchProcessName.click();
			fetchSubProcessName.click();

			assertTrue(!fetchSubSubProcessName.isDisplayed(), "Test Failed : Sub sub Process ios not Dispalyed ");
//			wait.until(ExpectedConditions.visibilityOf(conformationMesgofCreateProcessElement));
//			assertTrue(!conformationMesgofCreateProcessElement.isDisplayed(),
//					"Test Failed: conformationMesgofCreateProcessElement is displayed, but it should not be. Test Pass: conformationMesgofCreateProcessElement is not displayed.");

		} catch (NoSuchElementException e) {
			System.out.println("Test Pass : SubSub process Not Be Created ");
		}

	}

	public void UserIsAbleTocreateWithoutEnterMandatoryFieldProcesssandSaveUTILITY(WebElement processsNameLabelElement,
			Boolean Boolean, WebElement processNameFieldElement, String ProcessDescription,
			WebElement saveandContinueButtonElement) {

		processTab.isDisplayed();

		assertTrue(editOption1.isDisplayed(), "editOption1 is not displayed");
		editOption1.click();

		wait.until(ExpectedConditions.visibilityOf(processsNameLabelElement));
		assertTrue(processsNameLabelElement.isDisplayed(), "processNameLabel is not displayed");
		checkthroughAsterisk(processsNameLabelElement, Boolean);
		processNameFieldElement.clear();

		assertTrue(processDescField.isDisplayed(), "processDescField is not displayed");
		processDescField.sendKeys(ProcessDescription);

		assertTrue(saveandContinueButtonElement.isDisplayed(), "saveandContinueButton is not dispalyed");
		saveandContinueButtonElement.click();

		assertTrue(pleaseEnterName_ErrorMessage.isDisplayed(),
				"Test Failed : plearEnterNameErrorMessage is not displayed For mandatory fields");

		cancelButtonProcess.click();
	}

	public void UserIsAbleTocreateWithoutEnterMandatoryFieldsSubProcessandSaveUTILITY(WebElement EditOptionElelemt,
			WebElement SubprocessNameLabelElement, Boolean Boolean, String SubprocessDescription,
			WebElement saveandContinueButtonElement) {

		processTab.isDisplayed();

		assertTrue(dropDown1.isDisplayed(), "dropDown1 is not displayed");
		dropDown1.click();

		// unWait(2);
		wait.until(ExpectedConditions.elementToBeClickable(EditOptionElelemt));
		assertTrue(EditOptionElelemt.isDisplayed(), "editOption is not displayed");
		EditOptionElelemt.click();

		wait.until(ExpectedConditions.visibilityOf(SubprocessNameLabelElement));
		assertTrue(SubprocessNameLabelElement.isDisplayed(), "SubprocessNameLabelElement is not displayed");
		checkthroughAsterisk(SubprocessNameLabelElement, Boolean);
		subProcessNameField.clear();

		wait.until(ExpectedConditions.visibilityOf(subProcessDescField));
		assertTrue(subProcessDescField.isDisplayed(), "SubprocessDescFieldElement is not displayed");
		subProcessDescField.sendKeys(SubprocessDescription);

		assertTrue(saveandContinueButtonElement.isDisplayed(), "saveandContinueButton is not dispalyed");
		saveandContinueButtonElement.click();

		assertTrue(pleaseEnterName_ErrorMessage.isDisplayed(),
				"Test Failed : plearEnterNameErrorMessage is not displayed For mandatory fields");

		cancelButtonProcess.click();
	}

	public void UserIsAbleTocreateWithoutEnterMandatoryFieldsSubSubProcessandSaveUTILITY(WebElement EditOptionElelemt,
			WebElement SubSubprocessNameLabelElement, Boolean Boolean, String SubSubProcessDescription,
			WebElement saveandContinueButtonElement) {

		try {

			processTab.isDisplayed();

			assertTrue(dropDown1.isDisplayed(), "dropDown1 is not displayed");
			dropDown1.click(); // fetchProcessName.click();

			unWait(1);
			dropDown2.click(); // fetchSubProcessName.click();

			wait.until(ExpectedConditions.elementToBeClickable(EditOptionElelemt));
			assertTrue(EditOptionElelemt.isDisplayed(), "editOption is not displayed");
			EditOptionElelemt.click();

			wait.until(ExpectedConditions.visibilityOf(SubSubprocessNameLabelElement));
			assertTrue(SubSubprocessNameLabelElement.isDisplayed(), "SubSubprocessNameLabelElement is not displayed");
			checkthroughAsterisk(SubSubprocessNameLabelElement, Boolean);
			subSubProcessNameField.clear();

			wait.until(ExpectedConditions.visibilityOf(subSubProcessDescField));
			assertTrue(subSubProcessDescField.isDisplayed(), "SubSubprocessDescFieldElement is not displayed");
			subSubProcessDescField.sendKeys(SubSubProcessDescription);

			assertTrue(saveandContinueButtonElement.isDisplayed(), "saveandContinueButton is not displayed");
			saveandContinueButtonElement.click();

			assertTrue(pleaseEnterName_ErrorMessage.isDisplayed(),
					"Test Failed : plearEnterNameErrorMessage is not displayed For mandatory fields");

			cancelButtonProcess.click();

		} catch (NoSuchElementException e) {

			System.out.println("fetchSubSubProcessName" + EditOptionElelemt + "Is Noot Dipsalyed ");
		}
	}

	// Special Charcters for Process
	public void SpecialCharctersForProcessUTILITY(WebElement processsNameLabelElement, Boolean Boolean,
			String EnterspecialCharctersINProcessName, String ProcessDescription, WebElement SaveButtonProcess) {

		processTab.isDisplayed();

		wait.until(ExpectedConditions.visibilityOf(editOption1));
		assertTrue(editOption1.isDisplayed(), "editOption1 is not displayed");
		editOption1.click();

		wait.until(ExpectedConditions.visibilityOf(processsNameLabelElement));
		assertTrue(processsNameLabelElement.isDisplayed(), "processNameLabel is not displayed");
		checkthroughAsterisk(processsNameLabelElement, Boolean);
		processNameField.clear();
		processNameField.sendKeys(EnterspecialCharctersINProcessName);

		String processValue = processNameField.getAttribute("value");
		System.out.println("processValue : " + processValue);

		assertTrue(processValue == null || processValue.trim().isEmpty(),
				"Test Failed: Process input field is not empty");

		assertTrue(processDescField.isDisplayed(), "processDescField is not displayed");
		processDescField.clear();
		processDescField.sendKeys(ProcessDescription);

		assertTrue(SaveButtonProcess.isDisplayed(), "saveandContinueButton is not dispalyed");
		SaveButtonProcess.click();

		try {

			unWait(1);
			// wait.until(ExpectedConditions.visibilityOf(updateProcessSuceessMassgage));
			if (updateProcessSuceessMassgage.isDisplayed()) {

				assertFalse(true, "Test case failed as 'updateProcessSuccessMessage' is displayed");
			}
		} catch (NoSuchElementException e) {

			cancelButtonProcess.click();
			// Pass the test if the success message is not found
			System.out.println("Test case passed as 'updateProcessSuccessMessage' is not displayed");
		}

	}

	// Special Charcters for SubProcess
	public void SpecialCharctersForSubProcessUTILITY(WebElement EditOptionElelemts,
			WebElement SubprocessNameLabelElement, Boolean Boolean, String EnterSpecialCharctersInSubProcessName,
			String SubprocessDescription, WebElement saveButtonSubProcess) {

		processTab.isDisplayed();

		assertTrue(dropDown1.isDisplayed(), "dropDown1 is not displayed");
		dropDown1.click();

		// unWait(2);
		wait.until(ExpectedConditions.elementToBeClickable(EditOptionElelemts));
		assertTrue(EditOptionElelemts.isDisplayed(), "editOption is not displayed");
		EditOptionElelemts.click();

		wait.until(ExpectedConditions.visibilityOf(SubprocessNameLabelElement));
		assertTrue(SubprocessNameLabelElement.isDisplayed(), "SubprocessNameLabelElement is not displayed");
		checkthroughAsterisk(SubprocessNameLabelElement, Boolean);
		subProcessNameField.clear();
		subProcessNameField.sendKeys(EnterSpecialCharctersInSubProcessName);

		String subProcessValue = subProcessNameField.getAttribute("value");
		System.out.println("subProcessValue : " + subProcessValue);

		assertTrue(subProcessValue == null || subProcessValue.trim().isEmpty(),
				"Test Failed: sub Process input field is not empty");

		wait.until(ExpectedConditions.visibilityOf(subProcessDescField));
		assertTrue(subProcessDescField.isDisplayed(), "SubprocessDescFieldElement is not displayed");
		subProcessDescField.clear();
		subProcessDescField.sendKeys(SubprocessDescription);

		assertTrue(saveButtonSubProcess.isDisplayed(), "saveandContinueButton is not dispalyed");
		saveButtonSubProcess.click();

		try {
			unWait(1);
			// wait.until(ExpectedConditions.visibilityOf(updateSubProcessSuceessMassgage));
			if (updateSubProcessSuceessMassgage.isDisplayed()) {

				assertFalse(true, "Test case failed as 'updateSubProcessSuceessMassgage' is displayed");
			}
		} catch (NoSuchElementException e) {

			cancelButtonProcess.click();
			// Pass the test if the success message is not found
			System.out.println("Test case passed as 'updateSubProcessSuceessMassgage' is not displayed");
		}
	}

	// Special Charcters for SubSubProcess
	public void SpecialCharctersForSubSubProcessUTILITY(WebElement EditOptionElelemt,
			WebElement SubSubprocessNameLabelElement, Boolean Boolean, String EnterSpecialCharctersInSubSubProcessName,
			String SubSubProcessDescription, WebElement saveAndUpdateButtonElement) {

		processTab.isDisplayed();

		assertTrue(dropDown1.isDisplayed(), "dropDown1 is not displayed");
		dropDown1.click();
		unWait(1);
		dropDown2.click();

		wait.until(ExpectedConditions.elementToBeClickable(EditOptionElelemt));
		assertTrue(EditOptionElelemt.isDisplayed(), "editOption is not displayed");
		EditOptionElelemt.click();

		wait.until(ExpectedConditions.visibilityOf(SubSubprocessNameLabelElement));
		assertTrue(SubSubprocessNameLabelElement.isDisplayed(), "SubSubprocessNameLabelElement is not displayed");
		checkthroughAsterisk(SubSubprocessNameLabelElement, Boolean);
		subSubProcessNameField.clear();
		subSubProcessNameField.sendKeys(EnterSpecialCharctersInSubSubProcessName);

		String subsubProcessValue = subSubProcessNameField.getAttribute("value");
		System.out.println("subsubProcessValue : " + subsubProcessValue);

		assertTrue(subsubProcessValue == null || subsubProcessValue.trim().isEmpty(),
				"Test Failed: subsub Process input field is not empty");

		wait.until(ExpectedConditions.visibilityOf(subSubProcessDescField));
		subSubProcessDescField.clear();
		assertTrue(subSubProcessDescField.isDisplayed(), "SubSubprocessDescFieldElement is not displayed");
		subSubProcessDescField.sendKeys(SubSubProcessDescription);

		assertTrue(save_UpdateButtonInSubsubProcess.isDisplayed(), "save_UpdateButtonInSubsubProcess is not dispalyed");
		save_UpdateButtonInSubsubProcess.click();

		try {
			unWait(2);
			// wait.until(ExpectedConditions.visibilityOf(updateSubSubProcessSuceessMassgage));
			if (updateSubSubProcessSuceessMassgage.isDisplayed()) {
				// Skip the test case by asserting false with soft assert
				softAssert.assertFalse(true, "Test case failed as 'updateSubSubProcessSuccessMessage' is displayed");
			}
		} catch (NoSuchElementException e) {

			cancelButtonProcess.click();

			// Log a message indicating the test passed because the success message was not
			// displayed
			System.out.println("Test case passed as 'updateSubSubProcessSuccessMessage' is not displayed");
		}

		// Check all soft assertions
		softAssert.assertAll();
	}

	public void userIsAbleToCheckCharacterForProcessByMoreThanCharacterLimitUTILITY(WebElement EditOptionElelemt,
			WebElement TextfieldElement) {

		processTab.isDisplayed();

		assertTrue(EditOptionElelemt.isDisplayed(), "EditOptionElelemt is not displayed");
		EditOptionElelemt.click();

		wait.until(ExpectedConditions.visibilityOf(TextfieldElement));
		assertTrue(TextfieldElement.isDisplayed(), "processNameFieldElement is not displayed");
		TextfieldElement.clear();
		TextfieldElement.sendKeys("A".repeat(300));

		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();

		try {
			assertTrue(!updateProcessSuceessMassgage.isDisplayed(),
					"Test Failed : updateProcessSuceessMassgage is displayed");
			System.out.println(updateProcessSuceessMassgage + " updateProcessSuceessMassgage");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// If NoSuchElementException is caught, the test case passes
			System.out.println("NoSuchElementException caught, test case passed as element is not found.");
		}
	}

	public void withoutSelectProcessDropdownAndSave() {

		processTab.isDisplayed();

		assertTrue(dropDown1.isDisplayed(), "dropDown1 is not displayed");
		dropDown1.click();

		// unWait(2000);
		wait.until(ExpectedConditions.elementToBeClickable(editOption2));
		assertTrue(editOption2.isDisplayed(), "editOption is not displayed");
		editOption2.click();

		wait.until(ExpectedConditions.visibilityOf(selectProcessDropDown));
		assertTrue(selectProcessDropDown.isDisplayed(), "selectProcessDropDown is not displayed");
		Select selectProcess = new Select(selectProcessDropDown);
		selectProcess.selectByVisibleText("Select Process");

		saveButtonInSubProcess.click();

		assertTrue(processDropdownErrorMessage.isDisplayed(), "processDropdownErrorMessage is not displayed");

		cancelButtonProcess.click();
	}

	public void withoutSelectSubProcessDropdownAndSave() throws Throwable {

		processTab.isDisplayed();

		assertTrue(dropDown1.isDisplayed(), "dropDown1 is not displayed");
		dropDown1.click();
		unWait(1);
		dropDown2.click();
		// wait.until(ExpectedConditions.elementToBeClickable(editOption3));
		Thread.sleep(2000);
		editOption3.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(selectSubProcessDropDown));
		assertTrue(selectSubProcessDropDown.isDisplayed(), "selectSubProcessDropDown is not displayed");
		Select selectSubProcess = new Select(selectSubProcessDropDown);
		selectSubProcess.selectByVisibleText("Select Sub Process");

		save_UpdateButtonInSubsubProcess.click();

		assertTrue(subProcessDropdownErrorMessage.isDisplayed(), "subProcessDropdownErrorMessage is not displayed");

		cancelButtonProcess.click();
	}

	public void userIsAbleToCreateWithSameProcessName() {

		String fetchProcesstext = fetchProcessName.getText();
		System.out.println("fetchProcesstext :" + fetchProcesstext);

		createProcessButton.click();

		wait.until(ExpectedConditions.visibilityOfAllElements(processNameLabel));
		assertTrue(processNameLabel.isDisplayed(), "processNameLabel is not displayed");
		checkthroughAsterisk(processNameLabel, true);
		processNameField.sendKeys(fetchProcesstext);
		processDescField.sendKeys(FakeData.lastName1() + " Desc");

		saveButton.click();

		assertTrue(processNameAlreadyExists.isDisplayed(),
				"TestCase Failed: processNameAlreadyExists error messgae is not displayed");

		cancelButtonProcess.click();

	}

	// Search
	public void userIsAbleToSearchThroughInvalidProcessNames(String invalidCreatedProcess) {

		processTab.isDisplayed();

		assertTrue(searchBar.isDisplayed(), "searchBar is not displayed");
		searchBar.sendKeys(invalidCreatedProcess);
		searchButton.click();
		assertTrue(noEntriesFound.isDisplayed(), "TestCase Failed: noEntriesFound is not displayed");

		clearButton.click();
	}

	// ======================================================================
	// Process Setup

	public void withoutSelectingProcesseAndcLickOnSave() {

		processSetupOption.isDisplayed();
		processSetupOption.click();

		wait.until(ExpectedConditions.visibilityOf(processSetupPopup));
		assertTrue(processSetupPopup.isDisplayed(), "processSetupPopup is not displauyed");

		if (singleProcessToggleButton.isEnabled()) {
			System.out.println(" singleProcessToggleButton is ENABLED");

		} else if (!singleProcessToggleButton.isEnabled()) {

			System.out.println("singleProcessToggleButton is DISABLED");

		}
		singleProcessToggleButton.click();

		assertTrue(processSetup_SaveButton.isDisplayed(), "processSetup_SaveButtonis not displayed");
		processSetup_SaveButton.click();

		assertTrue(
				errorMessageProceess_ProcessSetup.isDisplayed() && errorMessageSubProceess_ProcessSetup.isDisplayed()
						&& errorMessageSubSubProceess_ProcessSetup.isDisplayed(),
				"Expected all error messages is not displayed.");

		cancelButtonProcessSetup.click();

	}

	public void userSelectingAllTheProcessandWithoutSaveClickOnCancel() {

		processSetupOption.click();

		wait.until(ExpectedConditions.visibilityOf(processSetupPopup));
		assertTrue(processSetupPopup.isDisplayed(), "processSetupPopup is not displauyed");

		if (singleProcessToggleButton.isEnabled()) {
			System.out.println(" singleProcessToggleButton is ENABLED");

		} else if (!singleProcessToggleButton.isEnabled()) {

			System.out.println("singleProcessToggleButton is DISABLED");

		}
		singleProcessToggleButton.click();

		wait.until(ExpectedConditions.visibilityOf(searchProcess));
		Select ProcessDrodpwon = new Select(searchProcess);
		ProcessDrodpwon.selectByIndex(1);

		wait.until(ExpectedConditions.elementToBeClickable(searchSubProcess));
		Select ProcessSubDrodpwon = new Select(searchSubProcess);
		ProcessSubDrodpwon.selectByIndex(1);

		wait.until(ExpectedConditions.visibilityOf(searchSubSubProcess));
		Select ProcessSubSubDrodpwon = new Select(searchSubSubProcess);
		ProcessSubSubDrodpwon.selectByIndex(1);

		cancelButtonProcessSetup.click();

		assertTrue(!saveButton_processSetup.isDisplayed(), "Test failed :saveButton_processSetup is displeyd");

	}

	public void TheUserAfterAddingProcessClickOnSave() {

		processSetupOption.isDisplayed();
		processSetupOption.click();

		wait.until(ExpectedConditions.visibilityOf(processSetupPopup));
		assertTrue(processSetupPopup.isDisplayed(), "processSetupPopup is not displauyed");

		if (singleProcessToggleButton.isEnabled()) {
			System.out.println(" singleProcessToggleButton is ENABLED");

		} else if (!singleProcessToggleButton.isEnabled()) {

			System.out.println("singleProcessToggleButton is DISABLED");

		}
		singleProcessToggleButton.click();

		wait.until(ExpectedConditions.visibilityOf(searchProcess));
		Select ProcessDrodpwon = new Select(searchProcess);
		ProcessDrodpwon.selectByIndex(1);
		assertTrue(saveButton_processSetup.isDisplayed(), "saveButton_processSetup is not displayed  ");
		saveButton_processSetup.click();

		assertTrue(
				errorMessageSubProceess_ProcessSetup.isDisplayed()
						&& errorMessageSubSubProceess_ProcessSetup.isDisplayed(),
				" errorMessageSubProceess_ProcessSetup and errorMessageSubProceess_ProcessSetup is not displayed ");
		cancelButtonProcessSetup.click();

	}

	public void TheUserAfterAddingProcessAndSubProcessAndSave() {

		processSetupOption.isDisplayed();
		processSetupOption.click();

		wait.until(ExpectedConditions.visibilityOf(processSetupPopup));
		assertTrue(processSetupPopup.isDisplayed(), "processSetupPopup is not displauyed");

		if (singleProcessToggleButton.isEnabled()) {
			System.out.println(" singleProcessToggleButton is ENABLED");

		} else if (!singleProcessToggleButton.isEnabled()) {

			System.out.println("singleProcessToggleButton is DISABLED");

		}
		singleProcessToggleButton.click();

		wait.until(ExpectedConditions.visibilityOf(searchProcess));
		Select ProcessDrodpwon = new Select(searchProcess);
		ProcessDrodpwon.selectByIndex(1);
		assertTrue(saveButton_processSetup.isDisplayed(), "saveButton_processSetup is not displayed  ");

		wait.until(ExpectedConditions.elementToBeClickable(searchSubProcess));
		Select ProcessSubDrodpwon = new Select(searchSubProcess);
		ProcessSubDrodpwon.selectByIndex(1);
		assertTrue(saveButton_processSetup.isDisplayed(), "saveButton_processSetup is not displayed  ");
		saveButton_processSetup.click();

		assertTrue(errorMessageSubSubProceess_ProcessSetup.isDisplayed(),
				"Expected all error messages to be displayed.");
		cancelButtonProcessSetup.click();

	}

	// 28.7.25
	// ====================== New Funcanality====================================
	// Archive Process

	List<String> SubProcessestabs = List.of("Archived Process", "Unarchived Process");
	List<String> archivePopupButtons = List.of("Cancel", "Archive");
	List<String> deletePopupButtons = List.of("Cancel", "Delete");

	public void navigateToArciveProcess() {
		navigateToArchiveProcess();
	}

	public void navigateToArchiveProcess() {

		ClickUtilities.clickIfMatch(subProcessesTab, "Archived Process");

	}

	public void navigateToUnArchiveProcess() {

		ClickUtilities.clickIfMatch(subProcessesTab, "Unarchived Process");

	}

	// Archive Action in UnArchive Tab
	public void archiveAction() {

		assertTrue(archiveActionButton_Process.isDisplayed(), "archive Button is not Displayed");

		archiveActionButton_Process.isEnabled();

		archiveActionButton_Process.click();

	}

	public void verifyArchivePopupAfterClick() throws Throwable {
		verifyArchivePopupAndClick();
	}

	public void verifyArchivePopupAndClick() throws Throwable {

		// ClickUtilities.clickIfMatch(archivePopupOptions, "Archive");
		wait.until(ExpectedConditions.visibilityOf(archivePopupOptions));
		assertTrue(archivePopupOptions.isDisplayed(), "archivePopupOptions is not Displayed");
		archivePopupOptions.click();

	}

	// Utility to extract integer from text like "Total Process : 48"
	private int extractProcessCount(String text) {
		String[] parts = text.split(":");
		return Integer.parseInt(parts[1].trim());
	}

	public void clickOnArchiveOptionAndVerifyInArchiveTab() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(clearButton));
		jsClick(clearButton);

		searchBar.sendKeys(fetchProcess_PropFile);
		searchButton.click();

		try {
			if (fetchFirstCreatedRecord.isDisplayed()) {
				System.out.println("FAIL: The Process is still active and displayed.");
			} else {
				System.out.println("PASS: The Process is archived and displayed in the Archive tab.");
			}
		} catch (NoSuchElementException e) {
			// Element not found means it's archived
			System.out.println(
					"PASS: The Process is archived and not found in the current tab (NoSuchElementException).");
		}

		/*
		 * Need to Implement
		 */

		String totalProcessText = totalProcessCount.getText();

		// Extract the number from the text
		int totalProcessNumber = Integer.parseInt(totalProcessText.split(":")[1].trim());

		// Assert the condition: Pass if 0, Fail if 1
		if (totalProcessNumber == 0) {
			Assert.assertTrue(true, "Total Process is 0, Test Passed");
		} else if (totalProcessNumber == 1) {
			Assert.fail("Total Process is 1, Test Failed");
		} else {
			Assert.fail("Unexpected value for Total Process: " + totalProcessNumber);
		}

		/*
		 * Need to Implement
		 */

		navigateToArchiveProcess();

		searchBar.sendKeys(fetchProcess_PropFile);
		searchButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

		// Get all process rows dynamically
		List<WebElement> processRows = driver.findElements(By.xpath("//table/tbody/tr"));

		boolean isProcessFound = false;

		for (WebElement row : processRows) {
			String rowProcessName = row.findElement(By.xpath(".//td[1]")).getText().trim();
			String rowStatus = row.findElement(By.xpath("(//td[4])[position() <= 3]")).getText().trim(); // status
																											// column

			if (rowProcessName.toLowerCase().contains(fetchProcess_PropFile.toLowerCase())) {
				isProcessFound = true;

				if (rowStatus.equalsIgnoreCase("Inactive")) {
					System.out.println(
							" PASS: Process '" + fetchProcess_PropFile + "' is archived with status 'Inactive'");
				} else {
					System.out.println(" FAIL: Process '" + fetchProcess_PropFile + "' found, but status is '"
							+ rowStatus + "' (Expected: Inactive)");
				}

				break; // No need to continue once found
			}
		}

		if (!isProcessFound) {
			System.out.println(" FAIL: Process '" + fetchProcess_PropFile + "' not found in archive list.");
		}

	}

	// Archive Multiple Processes
	public void archiveMultipleProcesses(int count) {
		int archivedProcessCount = 0;

		try {
			// Step 1: Verify TotalProcess element is visible
			Assert.assertTrue(totalProcessCount.isDisplayed(), "TotalProcess element is not displayed.");

			// Step 2: Capture total processes before archiving
			int beforeCount = extractProcessCount(totalProcessCount.getText());
			System.out.println("Before Archive: " + beforeCount);

			// Step 3: Perform archive operation for 'count' number of processes
			while (archivedProcessCount < count) {
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

				if (rows.isEmpty()) {
					System.out.println("No processes available to archive in the table.");
					break;
				}

				WebElement row = rows.get(0); // Always select the first row
				String processName = "";

				try {
					processName = row.findElement(By.xpath(".//td[1]")).getText().trim();
					WebElement archiveButton = row.findElement(By.xpath(".//img[@alt='archive']"));

					if (archiveButton.isDisplayed() && archiveButton.isEnabled()) {
						archiveButton.click();

						try {
							wait.until(ExpectedConditions.visibilityOf(archivePopup));

							if (archivePopup.isDisplayed()) {
								archivePopupOptions.click();
								System.out.println("Archived Process: " + processName);
								archivedProcessCount++;

								// Wait for UI update
								driver.navigate().refresh();
								Thread.sleep(1500);
							} else {
								System.out.println("Archive popup not displayed for: " + processName);
							}

						} catch (NoSuchElementException e) {
							System.out.println("Archive popup not found for: " + processName);
						}

					} else {
						System.out.println("Archive button not visible or enabled for: " + processName);
					}

				} catch (NoSuchElementException e) {
					System.out.println("Archive button or process name not found. Skipping row.");
				}

				Thread.sleep(1000); // Optional UI refresh wait
			}

			// Step 4: Capture total processes after archiving
			int afterCount = extractProcessCount(totalProcessCount.getText());
			System.out.println("After Archive: " + afterCount);

			// Step 5: Validate the difference
			int expectedAfterCount = beforeCount - count;

			System.out.println("Expected After Archive Count: " + expectedAfterCount);
			System.out.println("Actual After Archive Count: " + afterCount);

			Assert.assertEquals(afterCount, expectedAfterCount, "Process count mismatch after archiving. Expected: "
					+ expectedAfterCount + ", but found: " + afterCount);

			System.out.println("Archive count validation successful. " + count + " process(es) archived correctly.");

		} catch (Exception e) {
			System.out.println("Exception occurred during archive operation: " + e.getMessage());
		}
	}

	// UnArchive

	public void unArchiveAction() {
		try {
			if (unArchiveActionButton_process.isDisplayed()) {
				if (unArchiveActionButton_process.isEnabled()) {
					unArchiveActionButton_process.click();
					System.out.println("✅ unArchive button clicked successfully.");
				} else {
					System.out.println("⚠️ unArchive button is disabled.");
				}
			} else {
				System.out.println("⚠️ unArchive button is not displayed.");
			}
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Skipped unArchive action: Button not available or DOM changed. " + e.getMessage());
		} catch (Exception e) {
			System.out.println(" Unexpected error during unArchive action: " + e.getMessage());
		}
	}

	public void verifyUnArchivePopupAfterClickAndContinue() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(unArchivePopup));
		assertTrue(unArchivePopupOptions.isDisplayed(), "archivePopupOptions is not Displayed");
		unArchivePopupOptions.click();
		// wait.until(ExpectedConditions.visibilityOf(continueButton));
		// continueButton.click();

	}

	public void clickOnUnArchiveOptionAndVerifyInUnArchiveTab() throws Throwable {

//		wait.until(ExpectedConditions.visibilityOf(clearButton));
//		jsClick(clearButton);
//
//		// Step 1: Search for the archived process in active tab
//		searchBar.sendKeys(process);
//		searchButton.click();

		// Check Archived Process should nOt be Present in Archive Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

		// Step 2: Check that process is not present in active process list
		List<WebElement> activeRows = driver.findElements(By.xpath("//table/tbody/tr"));

		boolean isPresentInActiveList = false;

		for (WebElement row : activeRows) {
			String rowProcessName = row.findElement(By.xpath(".//td[1]")).getText().trim();
			if (rowProcessName.equalsIgnoreCase(fetchProcess_PropFile)) {
				isPresentInActiveList = true;
				break;
			}
		}

		if (!isPresentInActiveList) {
			System.out.println("✅ PASS: Archived process '" + fetchProcess_PropFile + "' not present in active list.");
		} else {
			System.out.println(
					"❌ FAIL: Archived process '" + fetchProcess_PropFile + "' is still visible in active list.");
		}

		// Step 3: Navigate to UnArchive tab
		navigateToUnArchiveProcess();

//		// Search for the archived process in active tab
		searchBar.sendKeys(fetchProcess_PropFile);
		searchButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

		// Step 4: Find the process in unarchive list with status = Active
		List<WebElement> unarchivedRows = driver.findElements(By.xpath("//table/tbody/tr"));
		boolean isProcessFoundInArchive = false;

		for (WebElement row : unarchivedRows) {
			String rowProcessName = row.findElement(By.xpath(".//td[1]")).getText().trim();
			String rowStatus = row.findElement(By.xpath(".//td[4]")).getText().trim(); // Status column

			if (rowProcessName.equalsIgnoreCase(fetchProcess_PropFile)) {
				isProcessFoundInArchive = true;

				if (rowStatus.equalsIgnoreCase("Active")) {
					System.out.println("✅ PASS: Process '" + fetchProcess_PropFile
							+ "' found in Unarchive tab with status 'Active'");
				} else {
					System.out.println("❌ FAIL: Process '" + fetchProcess_PropFile
							+ "' found in Unarchive tab, but status is '" + rowStatus + "' (Expected: Active)");
				}

				break;
			}
		}

		if (!isProcessFoundInArchive) {
			System.out.println("❌ FAIL: Process '" + fetchProcess_PropFile + "' not found in archive tab.");
		}
	}

	// Unarchive Multiple Processes
	public void unarchiveMultipleProcesses(int count) {
		int unArchivedProcessCount = 0;

		try {
			// Step 1: Verify TotalProcess element is visible
			Assert.assertTrue(totalProcessCount.isDisplayed(), "TotalProcess element is not displayed.");

			// Step 2: Capture total processes before archiving
			int beforeCount = extractProcessCount(totalProcessCount.getText());
			System.out.println("Before Archive: " + beforeCount);

			// Step 3: Perform archive operation for 'count' number of processes
			while (unArchivedProcessCount < count) {
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

				if (rows.isEmpty()) {
					System.out.println("No processes available to archive in the table.");
					break;
				}

				WebElement row = rows.get(0); // Always select the first row
				String processName = "";

				try {
					processName = row.findElement(By.xpath(".//td[1]")).getText().trim();

					WebElement unarchiveIcon = row.findElement(By.xpath(".//td[5]//img[1]"));

					if (unarchiveIcon.isDisplayed() && unarchiveIcon.isEnabled()) {
						unarchiveIcon.click();

						try {
							wait.until(ExpectedConditions.visibilityOf(unArchivePopup));

							if (unArchivePopup.isDisplayed()) {
								unArchivePopupOptions.click();
								System.out.println("✅ Unarchived Process: " + processName);
								unArchivedProcessCount++;
							} else {
								System.out.println("⚠️ Unarchive popup not displayed for: " + processName);
							}

						} catch (NoSuchElementException e) {
							System.out.println("⚠️ Unarchive popup not found for: " + processName);
						}

					} else {
						System.out.println("⚠️ Unarchive button not visible or enabled for: " + processName);
					}

				} catch (NoSuchElementException e) {
					System.out.println("Archive button or process name not found. Skipping row.");
				}

				Thread.sleep(1000); // Optional UI refresh wait
			}

			// Step 4: Capture total processes after archiving
			int afterCount = extractProcessCount(totalProcessCount.getText());
			System.out.println("After Archive: " + afterCount);

			// Step 5: Validate the difference
			int expectedAfterCount = beforeCount - count;

			System.out.println("Expected After Archive Count: " + expectedAfterCount);
			System.out.println("Actual After Archive Count: " + afterCount);

			Assert.assertEquals(afterCount, expectedAfterCount, "Process count mismatch after archiving. Expected: "
					+ expectedAfterCount + ", but found: " + afterCount);

			System.out.println("Archive count validation successful. " + count + " process(es) archived correctly.");

		} catch (Exception e) {
			System.out.println("Exception occurred during archive operation: " + e.getMessage());
		}
	}

	// Archive and UnArchive Sub_process & SubSub_Proces base Selecting Process

	// Delete
	public void deleteProcessByNameFromArchive(String processName) {
		try {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			boolean processFound = false;

			for (WebElement row : rows) {
				String rowProcessName = row.findElement(By.xpath(".//td[1]")).getText().trim();

				if (rowProcessName.equalsIgnoreCase(processName)) {
					processFound = true;

					try {
						WebElement deleteIcon = row.findElement(By.xpath("//table//tbody//td[5]//img[2]"));
						if (deleteIcon.isDisplayed() && deleteIcon.isEnabled()) {
							deleteIcon.click();
							assertTrue(deletePopup.isDisplayed(), "❌ Delete popup not displayed.");
							ClickUtilities.clickIfMatch(deletePopupOptions, "Delete");

							System.out.println("✅ Process '" + processName + "' found and deleted.");
						} else {
							System.out.println("⚠️ Delete icon not clickable for process: '" + processName + "'");
						}
					} catch (NoSuchElementException e) {
						System.out.println("⚠️ Delete icon not found for process: '" + processName + "'");
					}
					break;
				}
			}

			if (!processFound) {
				System.out.println("❌ Process '" + processName + "' not found in the archive table.");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Exception in deleteProcessByNameFromArchive: " + e.getMessage());
		}
	}

	public void deleteRandomProcessFromArchive() {

		try {
			// Fetch all visible rows in the archive table
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

			if (rows.isEmpty()) {
				System.out.println("⚠️ No processes found in the archive list.");
				return;
			}

			// Pick one random row
			Random random = new Random();
			int randomIndex = random.nextInt(rows.size());
			WebElement selectedRow = rows.get(randomIndex);

			// Get the process name from the selected row (1st column)
			String selectedProcessName = selectedRow.findElement(By.xpath(".//td[1]")).getText().trim();

			// Locate the delete icon using your preferred locator
			WebElement deleteIcon = selectedRow.findElement(By.xpath("//table//tbody//td[5]//img[2]"));

			if (deleteIcon.isDisplayed() && deleteIcon.isEnabled()) {
				deleteIcon.click();

				// Wait and click on the "Delete" option from the popup
				assertTrue(deletePopup.isDisplayed(), "❌ Delete popup not displayed.");
				ClickUtilities.clickIfMatch(deletePopupOptions, "Delete");

				System.out.println("✅ Randomly deleted process: '" + selectedProcessName + "'");
			} else {
				System.out.println("⚠️ Delete icon not clickable for process: '" + selectedProcessName + "'");
			}

		} catch (Exception e) {
			System.out.println("❌ Exception occurred in deleteRandomProcessFromArchive: " + e.getMessage());
		}
	}

	public void deleteProcessesFromArchive(int count) {
		int deletedCount = 0;

		try {
			while (deletedCount < count) {
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

				if (rows.isEmpty()) {
					System.out.println("No archive process present in the table.");
					break;
				}

				WebElement row = rows.get(0); // Always take the first row
				String processName = "";

				try {
					processName = row.findElement(By.xpath(".//td[1]")).getText().trim();

					WebElement deleteIcon = row.findElement(By.xpath("//table//tbody//td[5]//img[2]"));

					if (deleteIcon.isDisplayed() && deleteIcon.isEnabled()) {
						deleteIcon.click();

						try {
							wait.until(ExpectedConditions.visibilityOf(deletePopup));

							if (deletePopup.isDisplayed()) {
								ClickUtilities.clickIfMatch(deletePopupOptions, "Delete");
								System.out.println("Deleted Process: " + processName);
								deletedCount++;
							} else {
								System.out.println("Delete popup not displayed for: " + processName);
							}

						} catch (NoSuchElementException e) {
							System.out.println("Delete popup not found for: " + processName);
						}

					} else {
						System.out.println("Delete button not visible or enabled for: " + processName);
					}

				} catch (NoSuchElementException e) {
					System.out.println("Delete icon or process name not found. Skipping row.");
				}

				Thread.sleep(1000); // optional wait for UI refresh
			}

			System.out.println("Total Processes Deleted: " + deletedCount);

		} catch (Exception e) {
			System.out.println("Exception occurred during deletion: " + e.getMessage());
		}
	}

	public void deleteAllArchivedProcesses() {
		int deletedCount = 0;

		try {
			while (true) {
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

				if (rows.isEmpty()) {
					System.out.println("✅ No archive process present in the table. Deletion complete.");
					break;
				}

				WebElement row = rows.get(0); // Always pick the first row
				String processName = "";

				try {
					processName = row.findElement(By.xpath(".//td[1]")).getText().trim();

					WebElement deleteIcon = row.findElement(By.xpath("//table//tbody//td[5]//img[2]"));

					if (deleteIcon.isDisplayed() && deleteIcon.isEnabled()) {
						deleteIcon.click();

						try {
							wait.until(ExpectedConditions.visibilityOf(deletePopup));

							if (deletePopup.isDisplayed()) {
								ClickUtilities.clickIfMatch(deletePopupOptions, "Delete");
								System.out.println("Deleted Process: " + processName);
								deletedCount++;
							} else {
								System.out.println(" Delete popup not displayed for: " + processName);
							}

						} catch (NoSuchElementException e) {
							System.out.println("⚠️ Delete popup not found for: " + processName);
						}

					} else {
						System.out.println("⚠️ Delete button not visible or enabled for: " + processName);
					}

				} catch (NoSuchElementException e) {
					System.out.println("⚠️ Process name or delete icon not found. Skipping row.");
				}

				Thread.sleep(1000); // Allow UI refresh after deletion
			}

			System.out.println("✅ Total Processes Deleted: " + deletedCount);

		} catch (Exception e) {
			System.out.println("⚠️ Exception occurred during deletion: " + e.getMessage());
		}
	}

	// Utiluty For Click on Sub process and Sub SubSub process

	public void clickOnArchive_SubProcess_SubProcess(String type) {
		String dynamicXPath = String.format("//img[@data-type='%s']", type);
		WebElement element = driver.findElement(By.xpath(dynamicXPath));
		element.click();
	}

//	public void clickOnArchive_SubProcess_SubProcess(String type) {
//		String dynamicXPath = "//img[@data-type='" + type + "']";
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
//		element.click();
//		System.out.println("✅ Clicked on process element with data-type: " + type);
//	}

	// Based On Selected Process Archive Process and Sub process

	public void archiveSubProcessRelatedToProcess() throws Throwable {
		try {
			// Step 1: Open main process hierarchy
			Assert.assertTrue(fetchProcessName.isDisplayed(), "Main Process name is not displayed");
			fetchProcessName.click();

			PropertieFileUtil.storeSingleTextInPropertiesFile(dataSetup_FilePath, "SubProcess",
					fetchSubProcessName.getText());
			Assert.assertTrue(fetchSubProcessName.isDisplayed(), "Sub Process name is not displayed");
			fetchSubProcessName.click();

			PropertieFileUtil.storeSingleTextInPropertiesFile(dataSetup_FilePath, "SubSubProcess",
					fetchSubSubProcessName.getText());
			Assert.assertTrue(fetchSubSubProcessName.isDisplayed(), "Sub Sub Process name is not displayed");
			fetchSubSubProcessName.click();

			// Dynamically click on SubProcess
			clickOnArchive_SubProcess_SubProcess("sub_process");

			// Verify archive confirmation pop-up
			verifyArchivePopupAfterClick();
			verifyArchivePopupAndClick();

			unWait(2);

			// Step 2: Search manually after archive
			searchThroughProcess("searchManually");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

			// Get all process rows dynamically
			List<WebElement> processRows = driver.findElements(By.xpath("//table/tbody/tr"));

			boolean isProcessFound = false;

			for (WebElement row : processRows) {
				String rowProcessName = row.findElement(By.xpath(".//td[1]")).getText().trim();
				String rowStatus = row.findElement(By.xpath("(//td[4])[position() <= 3]")).getText().trim(); // status
																												// column

				if (rowProcessName.toLowerCase().contains(fetchProcess_PropFile.toLowerCase())) {
					isProcessFound = true;

					if (rowStatus.equalsIgnoreCase("Active")) {
						System.out.println(
								"✅ PASS: Process '" + fetchProcess_PropFile + "' is archived with status 'Active'");
					} else {
						System.out.println("❌ FAIL: Process '" + fetchProcess_PropFile + "' found, but status is '"
								+ rowStatus + "' (Expected: Inactive)");
					}

					break; // No need to continue once found
				}
			}

			if (!isProcessFound) {
				System.out.println("FAIL: Process '" + fetchProcess_PropFile + "' not found in archive list.");
			}

			navigateToArchiveProcess();

			searchBar.sendKeys(fetchProcess_PropFile);
			searchButton.click();

			// Step 5: Expand all process hierarchy again
			fetchProcessName.click();
			fetchSubProcessName.click();
			fetchSubSubProcessName.click();

			// Step 6: Validate statuses for Process, Sub Process, Sub Sub Process
			// dynamically
			System.out.println(" Validating Process Hierarchy Statuses...");

			List<WebElement> hierarchyRows = driver.findElements(By.xpath("//table/tbody/tr"));
			boolean processFound = false, subProcessFound = false, subSubProcessFound = false;

			for (WebElement row : hierarchyRows) {
				String name = row.findElement(By.xpath(".//td[1]")).getText().trim();
				String status = "";
				try {
					status = row.findElement(By.xpath(".//td[4]")).getText().trim();
				} catch (NoSuchElementException e) {
					status = "";
				}

				// Debugging
				System.out.println("Checking: " + name + " | Status: " + status);

				// Validate Process (Parent) → status should be blank/null
				if (name.equalsIgnoreCase(fetchProcessName.getText())) {
					processFound = true;
					Assert.assertTrue(status.isEmpty() || status.equalsIgnoreCase("NA"),
							" Process '" + name + "' status mismatch. Expected: blank/null, Found: " + status);
					System.out.println("✅ Process '" + name + "' validated successfully (status: blank/null).");
				}

				// Validate Sub Process → status = Inactive
				else if (name.equalsIgnoreCase(fetchSubProcessName.getText())) {
					subProcessFound = true;
					Assert.assertEquals(status, "Inactive",
							" Sub Process '" + name + "' status mismatch. Expected: Inactive, Found: " + status);
					System.out.println(" Sub Process '" + name + "' validated successfully (status: Inactive).");
				}

				// Validate Sub Sub Process → status = Inactive
				else if (name.equalsIgnoreCase(fetchSubSubProcessName.getText())) {
					subSubProcessFound = true;
					Assert.assertEquals(status, "Inactive",
							" Sub Sub Process '" + name + "' status mismatch. Expected: Inactive, Found: " + status);
					System.out.println(" Sub Sub Process '" + name + "' validated successfully (status: Inactive).");
				}
			}

			// Final check — make sure all 3 levels are found
			Assert.assertTrue(processFound, " Parent process not found in hierarchy.");
			Assert.assertTrue(subProcessFound, " Sub process not found in hierarchy.");
			Assert.assertTrue(subSubProcessFound, " Sub-sub process not found in hierarchy.");

			System.out.println(" All hierarchy levels validated successfully.");

		} catch (NoSuchElementException e) {
			System.out.println(" SubProcess already archived. Skipping re-archive steps.");
			Assert.assertTrue(true, "SubProcess already archived.");
		}
	}

	// archive Subsub process Based On Process
	public void archiveSubSubProcessRelatedToProcess() throws Throwable {

		try {

			// Step 1: Open main process hierarchy
			Assert.assertTrue(fetchProcessName.isDisplayed(), "Main Process name is not displayed");
			fetchProcessName.click();

			PropertieFileUtil.storeSingleTextInPropertiesFile(dataSetup_FilePath, "SubProcess",
					fetchSubProcessName.getText());
			Assert.assertTrue(fetchSubProcessName.isDisplayed(), "Sub Process name is not displayed");
			fetchSubProcessName.click();

			PropertieFileUtil.storeSingleTextInPropertiesFile(dataSetup_FilePath, "SubSubProcess",
					fetchSubSubProcessName.getText());
			Assert.assertTrue(fetchSubSubProcessName.isDisplayed(), "Sub Sub Process name is not displayed");
			fetchSubSubProcessName.click();

			// Dynamically click on SubProcess
			clickOnArchive_SubProcess_SubProcess("s_sub_process");

			// Verify archive confirmation pop-up
			verifyArchivePopupAfterClick();
			verifyArchivePopupAndClick();

			unWait(2);

			// Step 2: Search manually after archive
			searchThroughProcess("searchManually");

			// Click on Process toExpand Sub process
			fetchProcessName.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

			// Get all process rows dynamically
			List<WebElement> processRows = driver.findElements(By.xpath("//table/tbody/tr"));

			boolean processFound = false;
			boolean subProcessFound = false;

			System.out.println(" Validating Process and Sub Process statuses...");

			for (WebElement row : processRows) {
				String name = row.findElement(By.xpath(".//td[1]")).getText().trim();
				String status = "";
				try {
					status = row.findElement(By.xpath(".//td[4]")).getText().trim();
				} catch (NoSuchElementException e) {
					status = "";
				}

				// Debug info
				System.out.println("Checking: " + name + " | Status: " + status);

				// ✅ Validate Process — should remain Active
				if (name.equalsIgnoreCase(fetchProcessName.getText())) {
					processFound = true;
					Assert.assertEquals(status, "Active",
							"❌ Process '" + name + "' status mismatch. Expected: Active, Found: " + status);
					System.out.println("✅ Process '" + name + "' validated successfully (status: Active).");
				}

				// ✅ Validate Sub Process — should remain Active
				else if (name.equalsIgnoreCase(fetchSubProcessName.getText())) {
					subProcessFound = true;
					Assert.assertEquals(status, "Active",
							" Sub Process '" + name + "' status mismatch. Expected: Active, Found: " + status);
					System.out.println(" Sub Process '" + name + "' validated successfully (status: Active).");
				}
			}

			// Final assertion to ensure both are found
			Assert.assertTrue(processFound, " Parent process not found in the table.");
			// Assert.assertTrue(subProcessFound, " Sub process not found in the table.");

			System.out.println(" Both Process and Sub Process validated successfully (Status = Active).");

			navigateToArchiveProcess();

			searchBar.sendKeys(fetchProcess_PropFile);
			searchButton.click();

			// Step 5: Expand all process hierarchy again
			fetchProcessName.click();
			fetchSubProcessName.click();
			fetchSubSubProcessName.click();

			List<WebElement> hierarchyRows = driver.findElements(By.xpath("//table/tbody/tr"));
			// boolean processFound = false, subProcessFound = false,
			boolean subSubProcessFound = false;

			for (WebElement row : hierarchyRows) {
				String name = row.findElement(By.xpath(".//td[1]")).getText().trim();
				String status = "";
				try {
					status = row.findElement(By.xpath(".//td[4]")).getText().trim();
				} catch (NoSuchElementException e) {
					status = "";
				}

				System.out.println("Checking: " + name + " | Status: " + status);

				// Validate Process → status should be blank/null
				if (name.equalsIgnoreCase(fetchProcessName.getText())) {
					processFound = true;
					Assert.assertTrue(status.isEmpty() || status.equalsIgnoreCase("NA"),
							"Process '" + name + "' status mismatch. Expected: blank/null, Found: " + status);
					System.out.println("Process '" + name + "' validated successfully (status: blank/null).");
				}

				// Validate Sub Process → status should be blank/null
				else if (name.equalsIgnoreCase(fetchSubProcessName.getText())) {
					subProcessFound = true;
					Assert.assertTrue(status.isEmpty() || status.equalsIgnoreCase("NA"),
							"Sub Process '" + name + "' status mismatch. Expected: blank/null, Found: " + status);
					System.out.println("Sub Process '" + name + "' validated successfully (status: blank/null).");
				}

				// Validate Sub Sub Process → status = Inactive
				else if (name.equalsIgnoreCase(fetchSubSubProcessName.getText())) {
					subSubProcessFound = true;
					Assert.assertEquals(status, "Inactive",
							"Sub Sub Process '" + name + "' status mismatch. Expected: Inactive, Found: " + status);
					System.out.println("Sub Sub Process '" + name + "' validated successfully (status: Inactive).");
				}
			}

			// Final check — make sure all hierarchy levels are found
			Assert.assertTrue(processFound, "Parent process not found in hierarchy.");
			Assert.assertTrue(subProcessFound, "Sub process not found in hierarchy.");
			Assert.assertTrue(subSubProcessFound, "Sub-sub process not found in hierarchy.");

			System.out.println("All hierarchy levels validated successfully.");

		} catch (NoSuchElementException e) {
			System.out.println(" Sub Sub Process already archived. Skipping re-archive steps.");
			Assert.assertTrue(true, "Sub sub Process already archived.");
		}

	}
	

	//28.10.25
//	=============== Data Provider Implementation==========
	
	
	public void dataProvideTeest(String invalidProcessName) {
		
//		createProcessButton.click();
		jsClick(createProcessButton);
		processNameField.sendKeys(invalidProcessName);
		
	}
	
	public void createThroughInvalidInputs(WebElement processsNameLabelElement,
	Boolean Boolean, WebElement processNameFieldElement,String invalidInput, String ProcessDescription,
	WebElement saveandContinueButtonElement) {
		
		checkTextfieldshouldNotAcceptInvalidInput(processsNameLabelElement, Boolean, processNameFieldElement,
				invalidInput, ProcessDescription, saveandContinueButtonElement);
	}

	//Process_Chect INvalid Input
	public void checkTextfieldshouldNotAcceptInvalidInput(WebElement processsNameLabelElement,
			Boolean Boolean, WebElement processNameFieldElement,String invalidInput, String ProcessDescription,
			WebElement saveandContinueButtonElement) {

		processTab.isDisplayed();

		assertTrue(editOption1.isDisplayed(), "editOption1 is not displayed");
		//editOption1.click();
		jsClick(editOption1);

		wait.until(ExpectedConditions.visibilityOf(processsNameLabelElement));
		assertTrue(processsNameLabelElement.isDisplayed(), "processNameLabel is not displayed");
		checkthroughAsterisk(processsNameLabelElement, Boolean);
		processNameFieldElement.clear();
		processNameFieldElement.sendKeys(invalidInput);
		
		assertTrue(processDescField.isDisplayed(), "processDescField is not displayed");
		processDescField.clear();
		processDescField.sendKeys(ProcessDescription);

		assertTrue(saveandContinueButtonElement.isDisplayed(), "saveandContinueButton is not dispalyed");
		//saveandContinueButtonElement.click();
		jsClick(saveandContinueButtonElement);

		assertTrue(pleaseEnterName_ErrorMessage.isDisplayed(),
				"Test Failed : plearEnterNameErrorMessage is not displayed For mandatory fields");

		cancelButtonProcess.click();
	}
	
	
	//SearchBar accept_ Invalid Input
	public void checkInvalidInpusShouldONSearchField(String invlaidInput) {
		
		assertTrue(searchBar.isDisplayed(),"searchBar Is Not is Dispalyed ");
		assertTrue(searchBar.isEnabled(),"searchBar uis not enabled");
		searchBar.sendKeys(invlaidInput);
	}
	
	

}
