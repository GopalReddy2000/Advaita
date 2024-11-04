package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;

import Advaita_TDD.Advaita_TDD.FakeData;
import org.testng.Assert;

public class MetaData extends TestBase {

	FakeData fake = new FakeData();

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//img[@alt='table_drop_down']")
	public WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td[1]//img[@alt='table_drop_down']")
	public WebElement dropDown2;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//span")
	public WebElement fetchProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[1]")
	public WebElement fetchsubProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[3]")
	public WebElement fetchsubSubProcess;

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[1]/td[1]")
	public WebElement fetchDataSet;

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[2]/td[1]")
	public WebElement fetchDataSet1;

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[3]/td[1]")
	public WebElement fetchDataSet2;

	@FindBy(id = "pills-dataset-tab")
	public WebElement dataSetTab;

	@FindBy(xpath = "(//span[@aria-label='Close'])[1]")
	public WebElement closeButton;

	@FindBy(xpath = "//span[text()='Data Setup']")
	public WebElement dataSetup;

	@FindBy(id = "pills-metadata-tab")
	public WebElement metaDataTab;

	@FindBy(xpath = "//div[@class='table-responsive data-view-name']//table/tbody/tr[1]/td[1]")
	public WebElement fetchDataSetColumn1;

	@FindBy(xpath = "//div[@class='table-responsive data-view-name']//table/tbody/tr[2]/td[1]")
	public WebElement fetchDataSetColumn2;

	@FindBy(xpath = "//h1[text()=' Metadata Management ']")
	public WebElement afterClickMetadataTab;

	@FindBy(linkText = "+ Create")
	public WebElement createMetaDataButton;

	@FindBy(xpath = "//div[@class='modal-dialog modal-lg']//div[@class='modal-content']")
	public WebElement createMetaDataPopup;

	@FindBy(id = "metadata_name")
	public WebElement metaDataNameField;

	@FindBy(xpath = "//button[@class='quantity-right-plus btn counter-btn btn-number']")
	public WebElement addPlusColumn;

	@FindBy(xpath = "//button[@class='quantity-left-minus btn counter-btn']")
	public WebElement deleteMinusColumn;

	@FindBy(xpath = "//input[@id='quantity']")
	public WebElement addColumnInputField;

	@FindBy(xpath = "//select[@id='process']")
	public static WebElement selectProcessDropDown;

	@FindBy(xpath = "//label[normalize-space()='Sub Process*']/..//select[@id='sub_process']")
	public static WebElement selectSubProcessDropDown;

	@FindBy(xpath = "//label[normalize-space()='Sub Sub Process*']/..//select[@id='s_sub_process']")
	public static WebElement selectSubSubProcessDropDown;

	@FindBy(name = "primary_dataset_1")
	public static WebElement selectDataSetDropDown;

	@FindBy(name = "primary_dataset_2")
	public WebElement selectDataSetDropDown2;

	@FindBy(name = "join_type_1")
	public WebElement joinTypeDropDown;

	@FindBy(name = "target_dataset_1")
	public WebElement selectDataSetDropDown1;

	@FindBy(name = "primary_datasetField_1-1")
	public WebElement selectDataSetField;

	@FindBy(name = "primary_datasetField_2-1")
	public WebElement selectDataSetFieldBelow;

	@FindBy(name = "target_datasetField_1-1")
	public WebElement selectDataSetField1;

	@FindBy(name = "target_datasetField_2-1")
	public WebElement selectDataSetField2;

	@FindBy(name = "primary_datasetField_1-2")
	public WebElement selectDataSetField1Column2;

	@FindBy(name = "primary_datasetField_2-2")
	public WebElement selectDataSetField2Column2;

	@FindBy(linkText = "+ Remove Row")
	public WebElement removeRowButton;

	@FindBy(linkText = "+ Add Row")
	public WebElement addRowButton;

	@FindBy(xpath = "(//a[text()='+ Add Row'])[2]")
	public WebElement addRowButton2;

	@FindBy(id = "create_btn")
	public WebElement createMetaDataPopUpButton;

	@FindBy(xpath = "//span[text()='Metadata created Successfully']")
	public WebElement confirmationAfterCreatedMetaData;

	@FindBy(xpath = "//div[@id='succs_succ']//button[@aria-label='Close'][normalize-space()='Continue']")
	public WebElement continueButton;

	// Update
	@FindBy(xpath = "//div[@class='dataset_table']//table/tbody/tr[1]/td[1]")
	public WebElement clickOnCreatedMetaData;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public WebElement clickOnCreatedMetaDataCheckBox1;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement clickOnCreatedMetaDataCheckBox2;

	@FindBy(xpath = "(//table[contains(@class,'metadata_subtable')]/tbody/tr/td[4]//input[@type='checkbox'])[last()-3 > 0 and position()=last()-3]")
	public WebElement uniqueIdCheckBox;

	@FindBy(name = "role_name_0")
	public WebElement roleSelectDropDown1;

	@FindBy(name = "role_name_1")
	public WebElement roleSelectDropDown2;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement saveButtonInUpadteMetaData;

	@FindBy(xpath = "//span[text()='Metadata unique fields updated Successfully']")
	public WebElement confirmationAfterUpdateMetaData;

	@FindBy(xpath = "//div[@id='succs_succ']//button[@aria-label='Close'][normalize-space()='Continue']")
	public WebElement continueAfetrUpdateMetaData;

	// Edit
	@FindBy(xpath = "(//table[contains(@class,'w-100')]/tbody/tr/td[5]//img[@alt='table-edit'][contains(@class,'edit_metadata')])[1]")
	public WebElement clickOnMetaDataEditButton;

	@FindBy(xpath = "//button[normalize-space()='Execute']")
	public WebElement clickOnMetaDataExecuteButton;

	@FindBy(xpath = "//span[text()='Failed to create Metadata']")
	public WebElement faildToEdit;

	// Table

	@FindBy(xpath = "(//div[@class='d-flex align-items-center']//img[@class='img-fluid delete-dataset cursor-pointer delete_metadata'])[1]")
	public WebElement DeleteButton_table;

	@FindBy(xpath = "//div[@class='modal-content yes-nopopup']//form[@action='/en/metadata_management/metadata/']//div//p[@class='m-0 font_14 text_black fw-normal']")
	public WebElement deletePopup_table;

	@FindBy(xpath = "//div[@class='modal-content yes-nopopup']//form//div//button[@class='btn btn-primary data-delete font_12 fw-bold line_height11 mr_22']")
	public WebElement deleteButtonConformation_table;

	@FindBy(xpath = "//div[@class='modal-content yes-nopopup']//form//div//button[@class='btn-secondary  text_black data-delete']")
	public WebElement cancelButtonConformation_table;

	@FindBy(xpath = "//div[@class='modal-body d-flex flex-column align-items-center justify-content-center']//span[@id='change_msg']")
	public WebElement deleteSuccessfullyPopup;

	@FindBy(xpath = "//input[@id='text_search']")
	public WebElement searchTextfield_table;

	@FindBy(xpath = "//tbody//tr//td[@class='fw-semi md-one metadata_name_list']")
	public WebElement SearchGetText_table;

	@FindBy(xpath = "//button[@class='filter_search_blk cursor-pointer d-flex align-items-center justify-content-center white_bg']")
	public WebElement searchButton_table;

	@FindBy(xpath = "//select[@id='process_search']")
	public WebElement searchProcessDropdown_table;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public WebElement searchSubProcessDropdown_table;

	@FindBy(xpath = "//select[@id='s_sub_process_search']")
	public WebElement searchSubSubprocessDropdown_table;

	@FindBy(xpath = "//a//img[@alt='notification_icon']")
	public WebElement notificationIconButton_table;

	@FindBy(xpath = "//h1[text()=' Notifications ']")
	public WebElement notificationPage;

	@FindBy(xpath = "(//div//div[@class='noti_blk d-flex justify-content-between '])[1]")
	public WebElement createdMetadataNotification_table;

	@FindBy(xpath = "//span[text()='Metadata View has been created successfully']")
	public WebElement confirmationAfterExecuteMetaData;

	public MetaData() {

		PageFactory.initElements(driver, this);
	}

	String processValue;
	String subProcessValue;
	String subSubProcessValue;

	String dataSetValue;

	DataSet dataSet = new DataSet();

	public void createMetaData(String metaDataName) throws Throwable {

		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(1000);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(1000);

		String process = fetchProcess.getText();
		String subProcess = fetchsubProcess.getText();
		String subSubProcess = fetchsubSubProcess.getText();

		System.out.println("process : " + process + "\n" + "subProcess : " + subProcess + "\n" + "subSubProcess : "
				+ subSubProcess);

		click(driver, dataSetTab);

		String dataSet1 = fetchDataSet.getText();
		System.out.println("dataSet : " + dataSet1);

		click(driver, fetchDataSet);

		Thread.sleep(3000);

		String column1 = fetchDataSetColumn1.getText();
		String column2 = fetchDataSetColumn2.getText();

		click(driver, closeButton);

		String dataSet2 = fetchDataSet1.getText();
		System.out.println("dataSet : " + dataSet2);

		click(driver, fetchDataSet1);

		Thread.sleep(3000);

		String column3 = fetchDataSetColumn1.getText();
		String column4 = fetchDataSetColumn2.getText();

		click(driver, closeButton);

		String dataSet3 = fetchDataSet2.getText();
		System.out.println("dataSet : " + dataSet3);

		click(driver, fetchDataSet2);

		Thread.sleep(3000);

		String column5 = fetchDataSetColumn1.getText();
		String column6 = fetchDataSetColumn2.getText();

		click(driver, closeButton);

		click(driver, metaDataTab);

		Thread.sleep(1000);
		assertTrue(afterClickMetadataTab.isDisplayed(), "afterClickMetadataTab is not displayed.");

		click(driver, createMetaDataButton);

		Thread.sleep(2000);
		assertTrue(createMetaDataPopup.isDisplayed(), "createMetaDataPopup is not displayed.");

		assertTrue(metaDataNameField.isDisplayed(), "metaDataNameField is not displayed.");
		metaDataNameField.clear();
		metaDataNameField.sendKeys("Test " + FakeData.lastName1());

		assertTrue(addPlusColumn.isDisplayed(), "addPlusRow is not displayed."); //
//		click(driver, addPlusColumn);

		// Process,Sub-Process,Sub-Sub-Process
		assertTrue(selectProcessDropDown.isDisplayed(), "selectProcessDropDown is not displayed.");
		Select select = new Select(selectProcessDropDown);
		select.selectByVisibleText(process);

		assertTrue(selectSubProcessDropDown.isDisplayed(), "selectSubProcessDropDown is not displayed.");

		Select select1 = new Select(selectSubProcessDropDown);
		select1.selectByVisibleText(subProcess);

		assertTrue(selectSubSubProcessDropDown.isDisplayed(), "selectSubSubProcessDropDown is not displayed.");
		Select select2 = new Select(selectSubSubProcessDropDown);
		select2.selectByVisibleText(subSubProcess);

		// Data Set Drop Down
		assertTrue(selectDataSetDropDown.isDisplayed(), "selectDataSetDropDown is not displayed.");
		Select select3 = new Select(selectDataSetDropDown);
		select3.selectByVisibleText(dataSet1);

		// Select Left Side Data Set Fields
		assertTrue(selectDataSetField.isDisplayed(), "selectDataSetField is not displayed.");
		Select select4 = new Select(selectDataSetField);
		select4.selectByVisibleText(column1);

		click(driver, addRowButton);

		assertTrue(selectDataSetFieldBelow.isDisplayed(), "selectDataSetFieldBelow is not displayed.");
		Select select5 = new Select(selectDataSetFieldBelow);
		select5.selectByVisibleText(column2);

		Select select6 = new Select(joinTypeDropDown);
		select6.selectByVisibleText("OUTER JOIN");

		// Select Right Side Data Set Fields
		Select select7 = new Select(selectDataSetDropDown1);
		select7.selectByVisibleText(dataSet2);

		assertTrue(selectDataSetField1.isDisplayed(), "selectDataSetField1 is not displayed.");
		Select select8 = new Select(selectDataSetField1);
		select8.selectByVisibleText(column3);

		assertTrue(selectDataSetField2.isDisplayed(), "selectDataSetField2 is not displayed.");
		Select select9 = new Select(selectDataSetField2);
		select9.selectByVisibleText(column4);

		click(driver, addPlusColumn);

		// 2nd Column
		assertTrue(selectDataSetDropDown2.isDisplayed(), "selectDataSetDropDown2 is not displayed.");
		Select select10 = new Select(selectDataSetDropDown2);
		select10.selectByVisibleText(dataSet3);

		assertTrue(selectDataSetField1Column2.isDisplayed(), "selectDataSetField1Column2 is not displayed.");
		Select select11 = new Select(selectDataSetField1Column2);
		select11.selectByVisibleText(column5);

		click(driver, addRowButton2);

		assertTrue(selectDataSetField2Column2.isDisplayed(), "selectDataSetField2Column2 is not displayed.");
		Select select12 = new Select(selectDataSetField2Column2);
		select12.selectByVisibleText(column6);

		click(driver, createMetaDataPopUpButton);

		Thread.sleep(2000);

		assertTrue(confirmationAfterCreatedMetaData.isDisplayed(),
				"confirmationAfterCreatedMetaData is not displayed.");

		click(driver, continueButton);

		click(driver, clickOnCreatedMetaData);

		Thread.sleep(2000);
		click(driver, clickOnCreatedMetaDataCheckBox1);
		Thread.sleep(1000);

		assertTrue(roleSelectDropDown1.isDisplayed(), "roleSelectDropDown1 is not displayed.");
		Select select13 = new Select(roleSelectDropDown1);
		select13.selectByVisibleText("Admin");

		Thread.sleep(1000);
		click(driver, clickOnCreatedMetaDataCheckBox2);
		Thread.sleep(1000);

		assertTrue(roleSelectDropDown2.isDisplayed(), "roleSelectDropDown2 is not displayed.");
		Select select14 = new Select(roleSelectDropDown2);
		select14.selectByVisibleText("QA");

		assertTrue(saveButtonInUpadteMetaData.isDisplayed(), "saveButtonInUpadteMetaData is not displayed.");
		click(driver, saveButtonInUpadteMetaData);

		Thread.sleep(1000);
		assertTrue(confirmationAfterUpdateMetaData.isDisplayed(), "confirmationAfterUpdateMetaData is not displayed.");

		click(driver, continueAfetrUpdateMetaData);

	}

	public void editMetaData() throws Throwable {

		click(driver, metaDataTab);

		Thread.sleep(5000);

		click(driver, clickOnMetaDataEditButton);

		String fetchMetaData = metaDataNameField.getAttribute("value");
		System.out.println("\n" + "\n" + "fetchMetaData : " + fetchMetaData);

		metaDataNameField.clear();
		metaDataNameField.sendKeys(fetchMetaData + "E");

		click(driver, clickOnMetaDataExecuteButton);

		assertTrue(!faildToEdit.isDisplayed(), "faildToEdit is displayed.");

	}

	// Table

	// Verify the User is able to delete the Created MetaData from Data Management
	// Page

	public void delete_createdMetadata()

	{
		click(driver, metaDataTab);

		wait.until(ExpectedConditions.visibilityOf(DeleteButton_table));
		assertTrue(DeleteButton_table.isDisplayed(), "DeleteButton_table is not displayed");
		DeleteButton_table.click();

		assertTrue(deletePopup_table.isDisplayed(), "deletePopup_table is not displayed");

		assertTrue(deleteButtonConformation_table.isDisplayed(), "deleteButtonConformation_table is not displayed");
		deleteButtonConformation_table.click();

		wait.until(ExpectedConditions.visibilityOf(deleteSuccessfullyPopup));
		assertTrue(deleteSuccessfullyPopup.isDisplayed(), "deleteSuccessfullyPopup is not displayed");
		deleteSuccessfullyPopup.getText();

		assertTrue(continueButton.isDisplayed(), "continueButton is not displayed");
		continueButton.click();

	}

	// Verify the user is able to search by entering created process name

	public void searchcreatedMetadata(String TestBarrows) {
		click(driver, metaDataTab);

		assertTrue(searchTextfield_table.isDisplayed(), "searchTextfield_table is not displayed");
		searchTextfield_table.sendKeys(TestBarrows);

		assertTrue(searchButton_table.isDisplayed(), "searchButton_table is not displayed");
		searchButton_table.click();

		assertTrue(SearchGetText_table.isDisplayed(), "SearchGetText_table is not displayed");
		SearchGetText_table.getText();

	}

	// Verify The user is able to search by apply filter select process,sub
	// process,sub sub process

	public void searchByFilters() {

		click(driver, metaDataTab);

//select process
		assertTrue(searchTextfield_table.isDisplayed(), "searchTextfield_table is not displayed");

		assertTrue(searchProcessDropdown_table.isDisplayed(), "searchProcessDropdown is not displayed");

//				// Locate the dropdown element
//	            WebElement dropdownElement = driver.findElement(By.id("process_search"));

		// Create a Select object
		Select dropdown = new Select(searchProcessDropdown_table);

		// Retrieve all options from the dropdown
		List<WebElement> options = dropdown.getOptions();

		// Generate a random index
		Random random = new Random();
		int randomIndex = random.nextInt(options.size());

		// Ensure the random index does not select the first option (if it's a
		// placeholder)
		if (options.get(0).getText().equals("Search Process")) {
			randomIndex = random.nextInt(options.size() - 1) + 1;
		}

		// Select the random option
		dropdown.selectByIndex(randomIndex);

		// Output the selected option
		System.out.println("Selected option: " + options.get(randomIndex).getText());

		// select Subprocess

		// Locate the dropdown element
		assertTrue(searchSubProcessDropdown_table.isDisplayed(), "searchSubProcessDropdown is not displayed");
		searchSubProcessDropdown_table.click();

		// Wait for the dropdown options to be populated
		// WebDriverWait wait = new WebDriverWait(driver, 10);
//	            wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
//	                By.id("sub_process_search"), By.tagName("option")));
		wait.until(ExpectedConditions.visibilityOf(searchSubProcessDropdown_table));

		// Create a Select object
		Select dropdown1 = new Select(searchSubProcessDropdown_table);

		// Retrieve all options from the searchSubProcessDropdown
		List<WebElement> options1 = dropdown.getOptions();

		// Ensure there are options available
		if (options.size() > 1) {
			// Generate a random index, avoiding the first option if it's a placeholder
			Random random1 = new Random();
			int randomIndex1 = random.nextInt(options.size() - 1) + 1;

			// Select the random option
			dropdown.selectByIndex(randomIndex);

			// Output the selected option
			System.out.println("Selected option: " + options.get(randomIndex).getText());
		} else {
			System.out.println("No selectable options found in the dropdown.");
		}

//subsubprocess
		assertTrue(searchSubSubprocessDropdown_table.isDisplayed(), "searchSubSubprocessDropdown_table");
		searchSubSubprocessDropdown_table.click();

		// Create a Select object
		Select dropdown2 = new Select(searchSubSubprocessDropdown_table);

		// Retrieve all options from the dropdown
		List<WebElement> options2 = dropdown.getOptions();

		// Ensure there are options available
		if (options.size() > 1) {
			// Generate a random index, avoiding the first option if it's a placeholder
			Random random2 = new Random();
			int randomIndex2 = random.nextInt(options.size() - 1) + 1;

			// Select the random option
			dropdown.selectByIndex(randomIndex);

			// Output the selected option
			System.out.println("Selected option: " + options.get(randomIndex).getText());
		} else {
			System.out.println("No selectable options found in the dropdown.");
		}

		assertTrue(searchButton_table.isDisplayed(), "searchButton_table is not displayed");
		searchButton_table.click();

	}

	// Verify the able to get notification after Successfully created MetaData

	public void getNotificationAftercreatedMetadata(String metaDataName) throws InterruptedException {
		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(1000);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(1000);

		String process = fetchProcess.getText();
		String subProcess = fetchsubProcess.getText();
		String subSubProcess = fetchsubSubProcess.getText();

		System.out.println("process : " + process + "\n" + "subProcess : " + subProcess + "\n" + "subSubProcess : "
				+ subSubProcess);

		click(driver, dataSetTab);

		String dataSet1 = fetchDataSet.getText();
		System.out.println("dataSet : " + dataSet1);

		click(driver, fetchDataSet);

		Thread.sleep(3000);

		String column1 = fetchDataSetColumn1.getText();
		String column2 = fetchDataSetColumn2.getText();

		click(driver, closeButton);

		String dataSet2 = fetchDataSet1.getText();
		System.out.println("dataSet : " + dataSet2);

		click(driver, fetchDataSet1);

		Thread.sleep(3000);

		String column3 = fetchDataSetColumn1.getText();
		String column4 = fetchDataSetColumn2.getText();

		click(driver, closeButton);

		String dataSet3 = fetchDataSet2.getText();
		System.out.println("dataSet : " + dataSet3);

		click(driver, fetchDataSet2);

		Thread.sleep(3000);

		String column5 = fetchDataSetColumn1.getText();
		String column6 = fetchDataSetColumn2.getText();

		click(driver, closeButton);

		click(driver, metaDataTab);

		Thread.sleep(1000);
		assertTrue(afterClickMetadataTab.isDisplayed(), "afterClickMetadataTab is not displayed.");

		click(driver, createMetaDataButton);

		Thread.sleep(2000);
		assertTrue(createMetaDataPopup.isDisplayed(), "createMetaDataPopup is not displayed.");

		assertTrue(metaDataNameField.isDisplayed(), "metaDataNameField is not displayed.");
		metaDataNameField.clear();
		metaDataNameField.sendKeys("Test " + fake.lastName1());

		assertTrue(addPlusColumn.isDisplayed(), "addPlusRow is not displayed."); //
//			click(driver, addPlusColumn);

		// Process,Sub-Process,Sub-Sub-Process
		assertTrue(selectProcessDropDown.isDisplayed(), "selectProcessDropDown is not displayed.");
		Select select = new Select(selectProcessDropDown);
		select.selectByVisibleText(process);

		assertTrue(selectSubProcessDropDown.isDisplayed(), "selectSubProcessDropDown is not displayed.");

		Select select1 = new Select(selectSubProcessDropDown);
		select1.selectByVisibleText(subProcess);

		assertTrue(selectSubSubProcessDropDown.isDisplayed(), "selectSubSubProcessDropDown is not displayed.");
		Select select2 = new Select(selectSubSubProcessDropDown);
		select2.selectByVisibleText(subSubProcess);

		// Data Set Drop Down
		assertTrue(selectDataSetDropDown.isDisplayed(), "selectDataSetDropDown is not displayed.");
		Select select3 = new Select(selectDataSetDropDown);
		select3.selectByVisibleText(dataSet1);

		// Select Left Side Data Set Fields
		assertTrue(selectDataSetField.isDisplayed(), "selectDataSetField is not displayed.");
		Select select4 = new Select(selectDataSetField);
		select4.selectByVisibleText(column1);

		click(driver, addRowButton);

		assertTrue(selectDataSetFieldBelow.isDisplayed(), "selectDataSetFieldBelow is not displayed.");
		Select select5 = new Select(selectDataSetFieldBelow);
		select5.selectByVisibleText(column2);

		Select select6 = new Select(joinTypeDropDown);
		select6.selectByVisibleText("OUTER JOIN");

		// Select Right Side Data Set Fields
		Select select7 = new Select(selectDataSetDropDown1);
		select7.selectByVisibleText(dataSet2);

		assertTrue(selectDataSetField1.isDisplayed(), "selectDataSetField1 is not displayed.");
		Select select8 = new Select(selectDataSetField1);
		select8.selectByVisibleText(column3);

		assertTrue(selectDataSetField2.isDisplayed(), "selectDataSetField2 is not displayed.");
		Select select9 = new Select(selectDataSetField2);
		select9.selectByVisibleText(column4);

		click(driver, addPlusColumn);

		// 2nd Column
		assertTrue(selectDataSetDropDown2.isDisplayed(), "selectDataSetDropDown2 is not displayed.");
		Select select10 = new Select(selectDataSetDropDown2);
		select10.selectByVisibleText(dataSet3);

		assertTrue(selectDataSetField1Column2.isDisplayed(), "selectDataSetField1Column2 is not displayed.");
		Select select11 = new Select(selectDataSetField1Column2);
		select11.selectByVisibleText(column5);

		click(driver, addRowButton2);

		assertTrue(selectDataSetField2Column2.isDisplayed(), "selectDataSetField2Column2 is not displayed.");
		Select select12 = new Select(selectDataSetField2Column2);
		select12.selectByVisibleText(column6);

		click(driver, createMetaDataPopUpButton);

		Thread.sleep(2000);

		assertTrue(confirmationAfterCreatedMetaData.isDisplayed(),
				"confirmationAfterCreatedMetaData is not displayed.");

		click(driver, continueButton);

		click(driver, clickOnCreatedMetaData);

		Thread.sleep(2000);
		click(driver, clickOnCreatedMetaDataCheckBox1);
		Thread.sleep(1000);

		assertTrue(roleSelectDropDown1.isDisplayed(), "roleSelectDropDown1 is not displayed.");
		Select select13 = new Select(roleSelectDropDown1);
		select13.selectByVisibleText("Admin");

		Thread.sleep(1000);
		click(driver, clickOnCreatedMetaDataCheckBox2);
		Thread.sleep(1000);

		assertTrue(roleSelectDropDown2.isDisplayed(), "roleSelectDropDown2 is not displayed.");
		Select select14 = new Select(roleSelectDropDown2);
		select14.selectByVisibleText("QA");

		assertTrue(saveButtonInUpadteMetaData.isDisplayed(), "saveButtonInUpadteMetaData is not displayed.");
		click(driver, saveButtonInUpadteMetaData);

		Thread.sleep(1000);
		assertTrue(confirmationAfterUpdateMetaData.isDisplayed(), "confirmationAfterUpdateMetaData is not displayed.");

		click(driver, continueAfetrUpdateMetaData);

//			wait.until(ExpectedConditions.visibilityOf(notificationIconButton_table));
		assertTrue(notificationIconButton_table.isDisplayed(), "notificationIconButton_table is not displayed");
		notificationIconButton_table.click();

		driver.getCurrentUrl();
		assertTrue(notificationPage.isDisplayed(), "notificationPage is not displayed");
		notificationPage.getText();

		assertTrue(createdMetadataNotification_table.isDisplayed(),
				"createdMetadataNotification_table is not displayed");
		createdMetadataNotification_table.getText();

	}

//	######################################################################################################################
//	######################################################################################################################
//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$%&%^^*&^(&*(*&(*(&(*^&^*%&$#W%$%(&@$#%^*&$#$%^&*@#$%^&*(&^%$#%^&*($#$@#%^&*!@#$%^&*()#~!@#$%^&*()_(*&^%$^&*()_*&^%^$#
//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	######################################################################################################################
//	######################################################################################################################

	public MetaData navigateToMetaData() throws Throwable {


		// Assert whether Datasetup Button is Displayed on the left Navigation Menu
		assertTrue(metaDataTab.isDisplayed(), "metaDataTab is not Displayed");
		metaDataTab.click();

		String expecteddURL = mainURl + "en/metadata_management/metadata/";

		String actualURL = driver.getCurrentUrl();

		assertEquals(actualURL, expecteddURL);

		return this;
	}

	public MetaData createNewMetaData(String metaData) throws Throwable {

		String process = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
		String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess");
		String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess");
		String dataSetText = PropertieFileUtil.getSingleTextFromPropertiesFile("dataSetName");


		click(driver, createMetaDataButton);

		wait.until(ExpectedConditions.visibilityOf(createMetaDataPopup));
		assertTrue(createMetaDataPopup.isDisplayed());

		FieldVerificationUtils.verifyTextField(metaDataNameField, "Metadata Name", metaData, true, true, 1);

		dataSet.processDropDownSelect(selectProcessDropDown, process)
				.subProcessDropDownSelect(selectSubProcessDropDown, subProcess)
				.subSubProcessDropDownSelect(selectSubSubProcessDropDown, subSubProcess);

		selectDataSet(selectDataSetDropDown, dataSetText);

		return this;
	}

	public MetaData selectDataSet(WebElement selectDataSetDropDown, String dataSetValue) {

		assertTrue(selectDataSetDropDown.isDisplayed());
		Select select = new Select(selectDataSetDropDown);
		select.selectByVisibleText(dataSetValue);

		return this;
	}

	public MetaData verifyCreateButtonAndConfirmation() {

		click(driver, createMetaDataPopUpButton);

		wait.until(ExpectedConditions.visibilityOf(confirmationAfterCreatedMetaData));
		assertTrue(confirmationAfterCreatedMetaData.isDisplayed(),
				"confirmationAfterCreatedMetaData is not displayed.");

		click(driver, continueButton);

		return this;
	}

	public MetaData verifyCreatedMetaDataCheckUniqueIdAndRole(boolean checkUnique, boolean selectAgent)
			throws Throwable {

		Thread.sleep(500);
		click(driver, clickOnCreatedMetaData);

		if (selectAgent) {
			verifyCreatedMetaDataRoleSelect(roleSelectDropDown1, "Agent");
		}

		if (checkUnique) {

			Thread.sleep(500);
			click(driver, uniqueIdCheckBox);
			Thread.sleep(500);
		}

		return this;
	}

	public MetaData verifyCreatedMetaDataRoleSelect(WebElement roleSelectDropDown, String role) {

		assertTrue(roleSelectDropDown.isDisplayed(), "roleSelectDropDown is not displayed.");
		Select select = new Select(roleSelectDropDown);
		select.selectByVisibleText(role);

		return this;
	}

	public MetaData verifySaveButtonAndConfirmationInUpadteMetaData() {

		assertTrue(saveButtonInUpadteMetaData.isDisplayed(), "saveButtonInUpadteMetaData is not displayed.");
		click(driver, saveButtonInUpadteMetaData);

		wait.until(ExpectedConditions.visibilityOf(confirmationAfterUpdateMetaData));
		assertTrue(confirmationAfterUpdateMetaData.isDisplayed(), "confirmationAfterUpdateMetaData is not displayed.");

		click(driver, continueAfetrUpdateMetaData);

		return this;
	}

	public MetaData verifyExecuteUpadtedMetaData() {

		clickOnMetaDataEditButton.click();

		wait.until(ExpectedConditions.visibilityOf(createMetaDataPopup));
		assertTrue(createMetaDataPopup.isDisplayed(), "createMetaDataPopup is not displayed.");

		clickOnMetaDataExecuteButton.click();

		wait.until(ExpectedConditions.visibilityOf(confirmationAfterExecuteMetaData));
		assertTrue(confirmationAfterExecuteMetaData.isDisplayed(),
				"confirmationAfterExecuteMetaData is not displayed.");

		click(driver, continueAfetrUpdateMetaData);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		try {
			assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
					"(//table[contains(@class,'w-100')]/tbody/tr/td[5]//img[@alt='table-edit'][contains(@class,'edit_metadata')])[1]"))));
		} catch (TimeoutException e) {
			System.out.println("Exception : " + e + "\n" + "edit button is displayed.");
			assertFalse(true, "edit button is displayed.");
		}

		return this;
	}


//	Metadata


	public MetaData navToMetadataTable()
	{
		dataSetup.click();
		metaDataTab.click();

		return this;
	}

	@FindBy(id="metadata_name-error")
	WebElement metaDataError;
	public MetaData metaDataTextBox(String metaDataName,String errorMessage)
	{
		createMetaDataButton.click();
		metaDataNameField.sendKeys(metaDataName);
		selectProcesses("AJP","Sub AJP","Sub Sub AJP");

		jsClick(createMetaDataPopUpButton);
		unWait(1);
		System.out.println(metaDataError.getText());

		assert metaDataError.getText().equals(errorMessage);
		return this;
	}

	public MetaData addColumn(String column)
	{
		addColumnInputField.sendKeys(column);
		return this;
	}

	public MetaData selectProcesses(String processValue,String subProcessValue,String subSubProcessValue)
	{
		selectByVisibleText(selectProcessDropDown,processValue);
		selectByVisibleText(selectSubProcessDropDown,subProcessValue);
		selectByVisibleText(selectSubSubProcessDropDown,subSubProcessValue);


		return this;
	}


	public MetaData validateDatasetDropdown(WebElement dropdowns)
	{
		navToMetadataTable();
		metaDataTextBox("","");


		assertFalse( isOptionPresent(dropdowns,"JAP"));
		softAssert.assertTrue( isDropdownEnabled(dropdowns),"isDropdownEnabled failed");
//		softAssert.assertTrue(isNoOptionSelected(dropdowns),"isNoOptionSelected failed");
		softAssert.assertFalse(selectOptionByInvalidIndex(dropdowns,90),"selectOptionByInvalidIndex failed");
		softAssert.assertTrue(selectMultipleOptions(dropdowns),"selectMultipleOptions failed");

		softAssert.assertAll();
		return this;
	}




	// Method to check if an option exists (invalid option test)
	public boolean isOptionPresent(WebElement dropdownElement,String optionText) {

		Select select = new Select(dropdownElement);
		try {
			select.selectByVisibleText(optionText);
			return true;  // Option exists
		} catch (NoSuchElementException e) {
			return false;  // Option does not exist
		}
	}

	// Method to check if the dropdown is disabled
	public boolean isDropdownEnabled(WebElement dropdownElement) {

		return dropdownElement.isEnabled();
	}

	// Method to check if no option is selected (null/empty option)
	public boolean isNoOptionSelected(WebElement dropdownElement) {
		Select select = new Select(dropdownElement);
		String firstSelectedOption = select.getFirstSelectedOption().getText();
		return firstSelectedOption == null || firstSelectedOption.isEmpty();
	}


	// Method to check if an invalid index can be selected
	public boolean selectOptionByInvalidIndex(WebElement dropdownElement,int index) {

		Select select = new Select(dropdownElement);
		try {
			select.selectByIndex(index);
			return true;  // If no exception, index is valid (which should not happen for invalid index)
		} catch (NoSuchElementException | IndexOutOfBoundsException e) {
			return false;  // Expected result, index is invalid
		}
	}

	// Method to check if multiple selections are allowed in a single-select dropdown
	public boolean selectMultipleOptions(WebElement dropdownElement) {

		Select select = new Select(dropdownElement);

		if (!select.isMultiple()) {
			try {
				select.selectByIndex(1);  // Select the first option
				select.selectByIndex(2);  // Attempt to select another option (should not be possible)
				return false;  // If no exception, multiple selections are wrongly allowed
			} catch (Exception e) {
				return true;  // Exception is expected in case of multiple selections in single-select dropdown
			}
		} else {
			return false;  // Dropdown allows multiple selection, skip this test
		}
	}


	// Method to check if a disabled option can be selected
	public boolean selectDisabledOption(String optionText,WebElement dropdownElement) {

		Select select = new Select(dropdownElement);
		WebElement optionToSelect = null;

		for (WebElement option : select.getOptions()) {
			if (option.getText().equals(optionText) && !option.isEnabled()) {
				optionToSelect = option;
				break;
			}
		}

		if (optionToSelect != null) {
			try {
				select.selectByVisibleText(optionText);
				return false;  // If selected, it is a failure (disabled option should not be selectable)
			} catch (Exception e) {
				return true;  // Expected, as the option is disabled
			}
		}
		return false;  // Option not found or not disabled
	}






	// Locator for the search box
	private By searchBox = By.id("searchBox");
	private By searchButton = By.id("searchButton");
	private By errorMessage = By.id("errorMessage");
	private By successMessage = By.id("successMessage");
	private By results = By.xpath("//div[@class='search-result']");
	private By disabledButton = By.id("submitButton");

	// 1. Enter text in the search box and click search
	public void performSearch(String input) {
		WebElement searchInput = driver.findElement(searchBox);
		searchInput.clear();
		searchInput.sendKeys(input);
		driver.findElement(searchButton).click();
	}

	// 2. Validate that the correct error message is displayed
	public void validateErrorMessage(String expectedErrorMessage) {
		String actualErrorMessage = driver.findElement(errorMessage).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch!");
	}

	// 3. Validate that a success message is NOT displayed
	public void validateNoSuccessMessage() {
		try {
			WebElement success = driver.findElement(successMessage);
			Assert.assertFalse(success.isDisplayed(), "Success message should not be displayed.");
		} catch (NoSuchElementException e) {
			// Success message is not found, as expected
			Assert.assertTrue(true);
		}
	}

	// 4. Validate that no search results are displayed
	public void validateNoResultsDisplayed() {
		List<WebElement> resultList = driver.findElements(results);
		Assert.assertTrue(resultList.isEmpty(), "No results should be displayed for invalid input.");
	}

	// 5. Validate that the button is disabled
	public void validateButtonIsDisabled() {
		WebElement button = driver.findElement(disabledButton);
		Assert.assertFalse(button.isEnabled(), "Button should be disabled.");
	}

	// 6. Validate that user is NOT redirected to a specific URL
	public void validateNotRedirectedTo(String unexpectedUrl) {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl, unexpectedUrl, "User should not be redirected to this URL.");
	}

	// 7. Validate that the page title is not an unexpected title
	public void validatePageTitle(String unexpectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertNotEquals(actualTitle, unexpectedTitle, "Unexpected page title found.");
	}

	// 8. Validate that the search input is blank
	public void validateBlankInput() {
		String inputValue = driver.findElement(searchBox).getAttribute("value");
		Assert.assertTrue(inputValue.isEmpty(), "Search input should be blank.");
	}

	// 9. Validate pop-up alert message for invalid actions
	public void validateAlertMessage(String expectedAlertText) {
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		Assert.assertEquals(actualAlertText, expectedAlertText, "Alert message mismatch!");
		alert.accept(); // You can dismiss it
	}

	// 10. Validate that input field does not accept more than a specified number of characters
	public void validateInputFieldLength(int maxLength) {
		String inputValue = driver.findElement(searchBox).getAttribute("value");
		Assert.assertTrue(inputValue.length() <= maxLength, "Input field should not accept more than " + maxLength + " characters.");
	}

	// 11. Validate invalid SQL injection or script injection input
	public void validateSQLInjectionProtection() {
		WebElement error = driver.findElement(errorMessage);
		Assert.assertTrue(error.isDisplayed(), "SQL injection should trigger an error.");
	}

	// 12. Validate missing cookies or session (security check)
	public void validateMissingSessionCookie() {
		Assert.assertNull(driver.manage().getCookieNamed("sessionId"), "Session cookie should not exist for unauthorized access.");
	}

	// 13. Validate that the element is NOT present on the page
	public void validateElementNotPresent(By elementLocator) {
		List<WebElement> element = driver.findElements(elementLocator);
		Assert.assertTrue(element.isEmpty(), "Element should not be present.");
	}

	// 14. Validate incorrect form submission
	public void validateFormNotSubmitted() {
		String successText = driver.findElement(errorMessage).getText();
		Assert.assertNotEquals(successText, "Form submitted successfully", "Form should not be submitted with invalid data.");
	}

	// 15. Validate for security vulnerabilities like XSS or SQL injection
	public void validateForSecurity(String expectedError) {
		String actualError = driver.findElement(errorMessage).getText();
		Assert.assertEquals(actualError, expectedError, "Security vulnerability detected.");
	}


}
