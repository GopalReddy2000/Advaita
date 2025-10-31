package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.DynamicXpath;
import com.advaita.Utilities.Pagination;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.Utilities.SendDataUtils;

import Advaita_TDD.Advaita_TDD.FakeData;

public class DataSet extends TestBase {

	@FindBy(xpath = "//a[normalize-space()='Data Setup']")
	public WebElement dataSetup;

	@FindBy(id = "pills-dataset-tab")
	public WebElement dataSetTab;

	@FindBy(xpath = "(//ul[@id='pills-tab'])[2]//button")
	public List<WebElement> dataSetTabs;

	@FindBy(xpath = "(//h1[normalize-space()='Dataset Management'])[1]")
	public WebElement verifyDataSetManagementElement;

	@FindBy(xpath = "(//a[normalize-space()='+ Create'])[1]")
	public WebElement createDataSetButton;

	@FindBy(xpath = "//div[@class='modal-dialog modal-lg detail_form']//div[@class='modal-content']")
	public WebElement createDataSetPupup;

	@FindBy(id = "dataset_name")
	public WebElement dataSetNameField;

	@FindBy(xpath = "//input[@name='form-0-dataset_fieldname']")
	public WebElement fieldNameField;

	@FindBy(xpath = "//input[contains(@id,'dataset_fieldname') and not(contains(@id,'prefix'))]")
	public List<WebElement> fieldNameFields;

	@FindBy(xpath = "//input[contains(@id,'ds_field_label') and not(contains(@id,'prefix'))]")
	public List<WebElement> labelFieldNames;

	@FindBy(xpath = "//select[contains(@id,'ds_field_type') and not(contains(@id,'prefix'))]")
	public List<WebElement> fieldTypes;

	@FindBy(xpath = "//textarea[contains(@id,'ds_field_value') and not(contains(@id,'prefix'))]")
	public List<WebElement> maxLengthFields;

	@FindBy(xpath = "//select[contains(@id,'ds_is_mandatory') and not(contains(@id,'prefix'))]")
	public List<WebElement> isMandatoryDropdown;

	@FindBy(xpath = "//a[@id='add_more']")
	public WebElement addRow;

	@FindBy(id = "create_btn")
	public WebElement create;

	@FindBy(xpath = "//input[@id='id_form-0-ds_field_label']")
	public WebElement labelField;

	@FindBy(id = "id_form-0-ds_field_type")
	public WebElement typeDropDown;

	@FindBy(id = "id_form-0-ds_field_value")
	public WebElement maxLengthField;

	@FindBy(id = "id_form-0-ds_is_mandatory")
	public WebElement mandetoryDropDown;

	@FindBy(xpath = "//a[@id='add_more'][normalize-space()='+ Add Row']")
	public WebElement addRowButton;

	@FindBy(xpath = "//input[@name='form-1-dataset_fieldname']")
	public WebElement fieldNameField1;

	@FindBy(xpath = "//input[@id='id_form-1-ds_field_label']")
	public WebElement labelField1;

	@FindBy(id = "id_form-1-ds_field_type")
	public WebElement typeDropDown1;

	@FindBy(id = "id_form-1-ds_field_value")
	public WebElement maxLengthField1;

	@FindBy(id = "id_form-1-ds_is_mandatory")
	public WebElement mandetoryDropDown1;

	// ########################################

	@FindBy(xpath = "//input[@name='form-2-dataset_fieldname']")
	public WebElement fieldNameField2;

	@FindBy(xpath = "(//input[@class='form-control'])[5]")
	public WebElement editFieldName;

	@FindBy(xpath = "//input[@id='id_form-2-ds_field_label']")
	public WebElement labelField2;

	@FindBy(xpath = "(//input[@class='form-control'])[6]")
	public WebElement editLabelField;

	@FindBy(id = "id_form-2-ds_field_type")
	public WebElement typeDropDown2;

	@FindBy(xpath = "(//select[@class='form-control field_type_dropdown'])[3]")
	public WebElement editTypeDropDown;

	@FindBy(id = "id_form-2-ds_field_value")
	public WebElement maxLengthField2;

	@FindBy(xpath = "(//textarea[@class='form-control'])[3]")
	public WebElement editMaxLengthField;

	@FindBy(id = "id_form-2-ds_is_mandatory")
	public WebElement mandetoryDropDown2;

	@FindBy(xpath = "(//select[@class='form-control'])[3]")
	public WebElement editMandetoryDropDown;

	@FindBy(xpath = "(//img[@alt='delete-icon'])[4]")
	public WebElement deleteButton;

	@FindBy(xpath = "//tr[not(@id='empty_form')]//img[@alt='delete-icon']")
	public List<WebElement> deleteButtons;

	@FindBy(id = "create_btn")
	public WebElement dataSetCreateButton;

	@FindBy(id = "change_msg")
	public WebElement dataSetCreateSuccessPopUp;

	@FindBy(xpath = "(//button[@aria-label='Close'][normalize-space()='Continue'])[1]")
	public WebElement continueButton;

	@FindBy(id = "process")
	public WebElement processDropDown;

	@FindBy(id = "sub_process")
	public WebElement subProcessDropDown;

	@FindBy(id = "s_sub_process")
	public WebElement subSubProcessDropDown;

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

	@FindBy(xpath = "(//div//p)[1]")
	public WebElement fetchTotalRecord;

	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public WebElement editButton;

	@FindBy(xpath = "//table[@class='w-100']/tbody/tr[1]/td[1]")
	public WebElement fetchCurrentCreated;

	@FindBy(xpath = "(//span[@class='d-flex cross_span'])[1]")
	public WebElement closeButton;

	@FindBy(id = "text_search")
	public WebElement searchBar;

	@FindBy(id = "process_search")
	public WebElement processSearch;

	@FindBy(id = "sub_process_search")
	public WebElement subProcessSearch;

	@FindBy(id = "s_sub_process_search")
	public WebElement subSubProcessSearch;

	@FindBy(xpath = "(//img[@src='/static/images/filter_search.svg'])[1]")
	public WebElement searchButon;

	@FindBy(xpath = "(//h6[normalize-space()='Clear All Filters'])[1]")
	public WebElement clearButton;

	@FindBy(xpath = "//table[@class='w-100']//tr//td//img[1]")
	public List<WebElement> deleteDataSet;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public WebElement deletePopup;

	@FindBy(xpath = "//div[@id='id_confrm_popp']//button[text()='Delete']")
	public WebElement popDeleteButton;

	@FindBy(xpath = "//h3[@class='page_heading mb_8']/following-sibling::span[@id='change_msg']")
	public WebElement notificationTxt;

//	@FindBy(xpath = "//h3[@class='page_heading mb_8']/following-sibling::span[@id='change_msg']")
//	public WebElement notificationTxt;

	@FindBy(xpath = "//img[@alt='rgt_arrow']//parent::a")
	public WebElement paginationRightArrow;

	@FindBy(xpath = "//p[@class='show_entries m-0 font_13']")
	public WebElement showingNumberOfRecords;

	@FindBy(xpath = "//div[@class='mt_20']//button[@type='submit']")
	public WebElement recordDeleteButton;

	// New_Archive Process ,UnArchiveProcess

	@FindBy(xpath = "//tr//td[1]")
	List<WebElement> dataSetLists;

	@FindBy(xpath = "(//ul[@id='pills-tab'])[2]//button")
	public List<WebElement> tab;

	@FindBy(xpath = "//tr//td[6]//img[@alt='archive']")
	List<WebElement> archiveActions;

	@FindBy(xpath = "//tr//td[6]//img[@alt='unarchive']")
	public WebElement unArchiveAction;

	@FindBy(xpath = "//tr//td[6]//img[@alt='archive']")
	public WebElement archiveAction;

	@FindBy(id = "change_msg")
	public WebElement archivePopup;

	@FindBy(xpath = "(//tr//td[1])[position()<=1]")
	public static WebElement fetchFirstCreatedRecord;

	@FindBy(xpath = "//td[normalize-space(text())='No Entries Found']")
	public WebElement noEntriesFound;

	ScreenShorts ss = new ScreenShorts();
	Pagination pg = new Pagination();

//	FakeData fake = new FakeData();

//	String processValue;
//	String subProcessValue;
//	String subSubProcessValue;

//	String processValue = "AJP";
//	String subProcessValue = "Sub AJP";
//	String subSubProcessValue = "Sub Sub AJP";

	String dataSetName1 = FakeData.firstCapString() + " Name";
	// String dataSetName1 = "abhijit"+"_Name";

	public DataSet() {
		PageFactory.initElements(driver, this);
	}

	HomePage hp = new HomePage();

	// ====> Global
	String dataset_filePath = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\DataSet.properties";

	public String fetchDatset_PropFile; // Retrive Value name Fro Pro

	public DataSet navigatToDatasetManagemnetPage() {

		dataSetup.click();

		dataSetTab.click();

		assertTrue(verifyDataSetManagementElement.isDisplayed(), "verifyDataSetManagementElement is not Diaplyed");

		return this;

	}

	public void naviateToUnarchiveDataset() {

		navigatToDatasetManagemnetPage();

	}

	public void naviateToArchiveDataset(String tabName) {

		// navigatToDatasetManagemnetPage();
		ClickUtilities.clickIfMatch(dataSetTabs, tabName);

	}

	public void createDataSet(String type) throws Throwable {

		// Faker faker = new Faker();
		hp.clickOnProcessManagementCreate();
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

		// Assert whether Datasetup Button is Displayed on the left Navigation Menu
		assertTrue(dataSetup.isDisplayed(), "DataSetup is not Displayed");
		dataSetup.click();

		assertTrue(dataSetTab.isDisplayed(), "Datasetup Tab is not Displayed");
		dataSetTab.click();

		String expecteddURL = "https://test.capture.autosherpas.com/en/dataset_management/dataset/";

		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(actualURL, expecteddURL);

		String totalRecord = fetchTotalRecord.getText();
		String beforeResult = totalRecord.replace("Showing 1 to 10 of ", "");
		System.out.println("Before Result: " + beforeResult);
		String beforeTotalRecored = String.valueOf(Integer.parseInt(beforeResult) + 4);

		for (int i = 1; i <= 4; i++) {

			assertTrue(createDataSetButton.isDisplayed());
			createDataSetButton.click();

			Thread.sleep(2000);
			assertTrue(createDataSetPupup.isDisplayed());

			assertTrue(dataSetNameField.isDisplayed());
			assertTrue(dataSetNameField.isEnabled());
			dataSetNameField.click();
			// assertTrue(dataSetNameField.isSelected());
			if (i == 1) {
				dataSetNameField.sendKeys(FakeData.firstCapString() + " Name");
			}

			if (i == 2) {
				dataSetNameField.sendKeys(FakeData.firstCapString() + " Name");
			}

			if (i == 3) {
				dataSetNameField.sendKeys(FakeData.firstCapString() + " Name");
			}

			if (i == 4) {
				dataSetNameField.sendKeys(FakeData.firstCapString() + " Name");
			}

			assertTrue(processDropDown.isDisplayed());
			Select select = new Select(processDropDown);
			select.selectByVisibleText(process);

			assertTrue(subProcessDropDown.isDisplayed());
			Select select1 = new Select(subProcessDropDown);
			select1.selectByVisibleText(subProcess);

			assertTrue(subSubProcessDropDown.isDisplayed());
			Select select2 = new Select(subSubProcessDropDown);
			select2.selectByVisibleText(subSubProcess);

			assertTrue(fieldNameField.isDisplayed());
			assertTrue(fieldNameField.isEnabled());
			fieldNameField.click();
			// assertTrue(fieldNameField.isSelected());
			fieldNameField.sendKeys(FakeData.lastName1() + " Field");

			assertTrue(labelField.isDisplayed());
			assertTrue(labelField.isEnabled());
			labelField.click();
			// assertTrue(labelField.isSelected());
			labelField.sendKeys(FakeData.lastName1() + " Field");

			assertTrue(typeDropDown.isDisplayed());
			Select select3 = new Select(typeDropDown);
			select3.selectByVisibleText(type);

			assertTrue(maxLengthField.isDisplayed());
			assertTrue(maxLengthField.isEnabled());
			maxLengthField.click();
			// assertTrue(maxLengthField.isSelected());
			maxLengthField.sendKeys("10");

			assertTrue(mandetoryDropDown.isDisplayed());
			Select select4 = new Select(mandetoryDropDown);
			select4.selectByVisibleText("Yes");

			for (int j = 1; j <= 2; j++) {
				addRowButton.click();
			}

			assertTrue(fieldNameField1.isDisplayed());
			assertTrue(fieldNameField1.isEnabled());
			fieldNameField1.click();
			// assertTrue(fieldNameField.isSelected());
			fieldNameField1.sendKeys(FakeData.lastName1() + " Field");

			assertTrue(labelField1.isDisplayed());
			assertTrue(labelField1.isEnabled());
			labelField1.click();
			// assertTrue(labelField.isSelected());
			labelField1.sendKeys(FakeData.lastName1() + " Field");

			assertTrue(typeDropDown1.isDisplayed());
			Select select5 = new Select(typeDropDown1);
			select5.selectByVisibleText("Boolean");

			assertTrue(maxLengthField1.isDisplayed());
			assertTrue(maxLengthField1.isEnabled());
			maxLengthField1.click();
			// assertTrue(maxLengthField.isSelected());
			maxLengthField1.sendKeys("300");

			assertTrue(mandetoryDropDown1.isDisplayed());
			Select select6 = new Select(mandetoryDropDown1);
			select6.selectByVisibleText("Yes");

			// #####################################################

			assertTrue(fieldNameField2.isDisplayed());
			assertTrue(fieldNameField2.isEnabled());
			fieldNameField2.click();
			// assertTrue(fieldNameField.isSelected());
			fieldNameField2.sendKeys(FakeData.lastName1() + " Field");

			assertTrue(labelField2.isDisplayed());
			assertTrue(labelField2.isEnabled());
			labelField2.click();
			// assertTrue(labelField.isSelected());
			labelField2.sendKeys("Test Label 3");

			assertTrue(typeDropDown2.isDisplayed());
			Select select7 = new Select(typeDropDown2);
			select7.selectByVisibleText("Number");

			assertTrue(maxLengthField2.isDisplayed());
			assertTrue(maxLengthField2.isEnabled());
			maxLengthField2.click();
			// assertTrue(maxLengthField.isSelected());
			maxLengthField2.sendKeys("400");

			assertTrue(mandetoryDropDown2.isDisplayed());
			Select select8 = new Select(mandetoryDropDown2);
			select8.selectByVisibleText("No");

			deleteButton.click();

			dataSetCreateButton.click();

			Thread.sleep(3000);
			assertTrue(dataSetCreateSuccessPopUp.isDisplayed(), "dataSetCreateSuccessPopUp is not displayed.");

			assertTrue(continueButton.isDisplayed(), "continueButton is not displayed.");
			continueButton.click();

		}

		Thread.sleep(2000);
		assertTrue(fetchTotalRecord.isDisplayed());
		String afterTotalRecord = fetchTotalRecord.getText();
		String afterResult = afterTotalRecord.replace("Showing 1 to 10 of ", "");
		System.out.println("After Result: " + afterResult);

		Assert.assertEquals(afterResult, beforeTotalRecored);

		System.out.println("The User is Able to Create Dataset");

	}

	// ################################################################################################################

	public void editDataSet(String editDatasetName) throws Throwable {

		// dataSetTab.click();
		click(driver, dataSetTab);

		assertTrue(editButton.isDisplayed(), "editButton is not displayed.");
		editButton.click();

		Thread.sleep(2000);
		assertTrue(dataSetNameField.isDisplayed(), "dataSetNameField is not displayed.");
		dataSetNameField.clear();
		dataSetNameField.sendKeys(editDatasetName);

		List<WebElement> deleteIcons = driver.findElements(By.xpath("//img[@alt='delete-icon']"));
		if (deleteIcons.size() > 2) {
			// Iterate from index 2 to the end of the list
			for (int i = 2; i < deleteIcons.size() - 1; i++) {
				WebElement deleteIcon = deleteIcons.get(i);
				deleteIcon.click();
				// Perform your actions after clicking on each delete icon
			}
		} else {
			System.out.println("There are less than three delete icons on the page.");
		}

		assertTrue(addRowButton.isDisplayed(), "dataSetNameField is not displayed.");
		addRowButton.click();

		assertTrue(editFieldName.isDisplayed());
		assertTrue(editFieldName.isEnabled());
		editFieldName.click();
		// assertTrue(fieldNameField.isSelected());
		editFieldName.sendKeys("Edit Test Field Name 3");

		assertTrue(editLabelField.isDisplayed());
		assertTrue(editLabelField.isEnabled());
		editLabelField.click();
		// assertTrue(labelField.isSelected());
		editLabelField.sendKeys("Edit Test Label 3");

		assertTrue(editTypeDropDown.isDisplayed());
		Select select1 = new Select(editTypeDropDown);
		select1.selectByVisibleText("Text Area");

		assertTrue(editMaxLengthField.isDisplayed());
		assertTrue(editMaxLengthField.isEnabled());
		editMaxLengthField.click();
		// assertTrue(maxLengthField.isSelected());
		editMaxLengthField.sendKeys("400");

		assertTrue(editMandetoryDropDown.isDisplayed());
		Select select2 = new Select(editMandetoryDropDown);
		select2.selectByVisibleText("Yes");

		dataSetCreateButton.click();

	}

	public void dataSetTablePage() throws Throwable {
		dataSetup.click();

		dataSetTab.click();

		assertTrue(fetchCurrentCreated.isDisplayed(), "fetchCurrentCreated is not displayed.");

		String createdDataSet = fetchCurrentCreated.getText();

		fetchCurrentCreated.click();

		Thread.sleep(1000);
		String procesText = driver
				.findElement(
						By.xpath("//h3[normalize-space()='Process']/..//h3[@class='process-first process_name_data']"))
				.getText();

		String subProcesText = driver
				.findElement(By.xpath(
						"//h3[normalize-space()='Sub Process']/..//h3[@class='process-first s_process_name_data']"))
				.getText();

		String subSubProcesText = driver.findElement(By
				.xpath("//h3[normalize-space()='Sub Sub Process']/..//h3[@class='process-first ss_process_name_data']"))
				.getText();

		System.out.println("createdDataSet : " + createdDataSet + "\n" + procesText + "\n" + subProcesText + "\n"
				+ subSubProcesText);

		Thread.sleep(2000);
		assertTrue(closeButton.isDisplayed(), "closeButton is not displayed.");
		closeButton.click();

		assertTrue(searchBar.isDisplayed(), "searchBar is not displayed.");

		// Validate the X and Y Axes of all Boxes and bars in dataset page
		Point searchLocation = searchBar.getLocation();
		// Get the location (X and Y coordinates) of the searchBar element
		int xCoordinate = searchLocation.getX();
		int yCoordinate = searchLocation.getY();

		System.out.println("X Coordinates:" + xCoordinate + "\n" + "Y Coordinates:" + yCoordinate);
		Assert.assertEquals(300, xCoordinate);

		searchBar.clear();
		searchBar.sendKeys(createdDataSet);

		Select select = new Select(processSearch);
		Select select1 = new Select(subProcessSearch);
		Select select2 = new Select(subSubProcessSearch);

		select.selectByVisibleText(procesText);
		select1.selectByVisibleText(subProcesText);
		select2.selectByVisibleText(subSubProcesText);

		assertTrue(searchButon.isDisplayed(), "searchButon is not displayed.");
		searchButon.click();

		// Thread.sleep(2000);
		// ss.takeScreenShot("afterSearch");

		// Validate Clear All filters button
		clearButton.click();
		// jsClick(clearButton);

		Thread.sleep(2000);
		// Find the pagination element
		Pagination.goToNextPage(driver, 5);
		Pagination.goToPreviousPage(driver, 4);
		// Pagination.lastAndFirstPagination(driver,7);
		// Pagination.lastAndFirstPagination(driver,1);

		// Thread.sleep(3000);

	}

	public static WebElement getRandomElement(List<WebElement> elements) {
		int randomIndex = ThreadLocalRandom.current().nextInt(elements.size());
		return elements.get(randomIndex);
	}

	public static void clickMultipleTimes(WebElement element, int times) {
		for (int i = 0; i < times; i++) {
			jsClick(element);
		}
	}

	public static int generateRandomNumber(int a) {
		return ThreadLocalRandom.current().nextInt(1, a);
	}

	public void deleteDataSet() {

		dataSetup.click();
		dataSetTab.click();
		String text = showingNumberOfRecords.getText();
		int numberOfPages = Integer.parseInt(text.substring(text.indexOf("of") + 3, text.length() - 1));
		clickMultipleTimes(paginationRightArrow, generateRandomNumber(numberOfPages));
		String text1 = showingNumberOfRecords.getText();

		System.out.println(text1);

		for (int a = 0; a < deleteDataSet.size(); a++)

		{
			System.out.println((a + 1) + "st Delete Button is Enabled: " + deleteDataSet.get(a).isEnabled());
		}

		jsClick(getRandomElement(deleteDataSet));
		jsClick(recordDeleteButton);
		wait.until(ExpectedConditions.visibilityOf(notificationTxt));
		System.out.println(notificationTxt.getText());
		Assert.assertEquals(notificationTxt.getText(), "Dataset has been deleted successfully");

	}

//	##############################################################################################################################
//	##############################################################################################################################
//	##############################################################################################################################
//	##############################################################################################################################

	public DataSet navigateToDataSetup() throws Throwable {
		hp.clickOnProcessManagementCreate();
//		fecthProcess_SubProces_SubSubProcess();

		// Assert whether Datasetup Button is Displayed on the left Navigation Menu
		assertTrue(dataSetup.isDisplayed(), "DataSetup is not Displayed");
		dataSetup.click();

		assertTrue(dataSetTab.isDisplayed(), "Datasetup Tab is not Displayed");
		dataSetTab.click();

		String expecteddURL = mainURl + "en/dataset_management/dataset/";

		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(actualURL, expecteddURL);

		return this;
	}

	public DataSet fecthProcess_SubProces_SubSubProcess() throws Throwable {

		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(1000);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(1000);

		PropertieFileUtil.storeSingleTextInPropertiesFile("process", fetchProcess.getText());
		PropertieFileUtil.storeSingleTextInPropertiesFile("subProcess", fetchsubProcess.getText());
		PropertieFileUtil.storeSingleTextInPropertiesFile("subSubProcess", fetchsubSubProcess.getText());

		System.out.println("Process : " + fetchProcess.getText() + "\n" + "Sub Process : " + fetchsubProcess.getText()
				+ "\n" + "Sub Sub Process : " + fetchsubSubProcess.getText());

		System.out.println("Data Set Process : " + PropertieFileUtil.getSingleTextFromPropertiesFile("Process") + "\n"
				+ "Data Set Sub Process : " + PropertieFileUtil.getSingleTextFromPropertiesFile("subprocess") + "\n"
				+ "Data Set Sub Sub Process : " + PropertieFileUtil.getSingleTextFromPropertiesFile("subSubprocess"));

//		String process = fetchProcess.getText();
//		String subProcess = fetchsubProcess.getText();
//		String subSubProcess = fetchsubSubProcess.getText();
//
//		PropertieFileUtil.storeSingleTextInPropertiesFile("process", process);
//		PropertieFileUtil.storeSingleTextInPropertiesFile("subProcess", subProcess);
//		PropertieFileUtil.storeSingleTextInPropertiesFile("subSubProcess", subSubProcess);

		return this;
	}

	public DataSet navToDataset() {
		dataSetup.click();
		dataSetTab.click();

		return this;
	}

	public DataSet createDatasetButton() {
		jsClick(createDataSetButton);
		return this;
	}

	public DataSet datasetNameField(String datasetName) {
		sendKeys(dataSetNameField, datasetName);
		return this;
	}

	public DataSet processDropdown(String process) {
		selectByVisibleText(processDropDown, process);
		return this;
	}

	public DataSet subProcessDropdown(String subProcess) {
		selectByVisibleText(subProcessDropDown, subProcess);
		return this;
	}

	public DataSet subSubProcessDropdown(String subSubProcess) {
		selectByVisibleText(subSubProcessDropDown, subSubProcess);
		return this;
	}

	public DataSet deleteAllFields() {
		clickMultipleTimes(deleteButtons.get(0), deleteButtons.size());
		return this;
	}

	@FindBy(id = "dataset_name-error")
	WebElement datasetError;

	@FindBy(id = "process-error")
	WebElement processError;

	@FindBy(id = "sub_process-error")
	WebElement subProcessError;

	@FindBy(id = "s_sub_process-error")
	WebElement subSubProcessError;

	public DataSet createDataset(String datasetName, String process, String subProcess, String subSubProcess) {
		dataSetup.click();
		dataSetTab.click();
		createDataSetButton.click();
		dataSetNameField.sendKeys(datasetName);

		selectByVisibleText(processDropDown, process);
		selectByVisibleText(subProcessDropDown, subProcess);
		selectByVisibleText(subSubProcessDropDown, subSubProcess);

		return this;
	}

	public void selectByValue(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public DataSet fieldNameInput(int fieldNameNumber, String fieldName) {
		sendKeys(fieldNameFields.get(fieldNameNumber), fieldName);
		return this;
	}

	public DataSet labelNameInput(int fieldNameNumber, String fieldName) {
		sendKeys(labelFieldNames.get(fieldNameNumber), fieldName);
		return this;
	}

	public DataSet type(int fieldNameNumber, String fieldType) {
		selectByVisibleText(fieldTypes.get(fieldNameNumber), fieldType);
		return this;
	}

	public DataSet maxLengthFields(int fieldNameNumber, String maxLength) {
		selectByVisibleText(maxLengthFields.get(fieldNameNumber), maxLength);
		return this;
	}

	public DataSet isMandatory(int fieldNameNumber, String isMandatoryValue) {
		selectByValue(isMandatoryDropdown.get(fieldNameNumber), isMandatoryValue);
		return this;
	}

	public boolean datasetError(String dataSetError) {

		return datasetError.isDisplayed() && datasetError.getText().equals(dataSetError);
	}

	public boolean processError() {

		return processError.isDisplayed();
	}

	public boolean subProcessError() {

		return subProcessError.isDisplayed();
	}

	public boolean subSubProcessError() {

		return subSubProcessError.isDisplayed();
	}

	public DataSet addFieldNames(int fieldNameNumber, String fieldName, String fieldType, String maxLength,
			String isMandatoryValue) {
		fieldNameFields.get(fieldNameNumber).sendKeys(fieldName);
		labelFieldNames.get(fieldNameNumber).sendKeys(fieldName);
		selectByVisibleText(fieldTypes.get(fieldNameNumber), fieldType);
		maxLengthFields.get(fieldNameNumber).sendKeys(maxLength);
		selectByValue(isMandatoryDropdown.get(fieldNameNumber), isMandatoryValue);

		return this;
	}

	public DataSet addRow() {
		jsClick(addRow);
		return this;
	}

	public DataSet recordCreateButton() {
		jsClick(create);
		return this;
	}

	public DataSet datasetCreate() {
		create.click();
		unWaitInMilli(500);
		continueButton.click();
		return this;
	}

	public DataSet createNewDataSet(String dataSetName) throws Throwable {

		click(driver, createDataSetButton);

		wait.until(ExpectedConditions.visibilityOf(createDataSetPupup));
		assertTrue(createDataSetPupup.isDisplayed());

		verifyDataSetNameField(dataSetName);

		processDropDownSelect(processDropDown, PropertieFileUtil.getSingleTextFromPropertiesFile("Process"))
				.subProcessDropDownSelect(subProcessDropDown,
						PropertieFileUtil.getSingleTextFromPropertiesFile("Subprocess"))
				.subSubProcessDropDownSelect(subSubProcessDropDown,
						PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess"));

		return this;
	}

	public void verifyDataSetNameField(String dataSetName) throws Throwable {

		System.out.println("Data Set Process : " + PropertieFileUtil.getSingleTextFromPropertiesFile("process") + "\n"
				+ "Data Set Sub Process : " + PropertieFileUtil.getSingleTextFromPropertiesFile("subprocess") + "\n"
				+ "Data Set Sub Sub Process : " + PropertieFileUtil.getSingleTextFromPropertiesFile("subprocess"));

		assertTrue(createDataSetPupup.isDisplayed(), "createDataSetPupup is not displayed.");

		String text = driver.findElement(By.xpath("//label[normalize-space()='Dataset Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		Assert.assertEquals(lastChar, '*', "dataSetNameField label does not end with '*'.");

		assertTrue(dataSetNameField.isEnabled(), "dataSetNameField is not enabled.");

		String existingText = dataSetNameField.getAttribute("value");
		assert existingText != null;
		assertTrue(existingText.isEmpty(), "dataSetNameField is not empty before entering text.");

		assertNotNull(dataSetName, "dataSetName is null.");
		assertFalse(dataSetName.trim().isEmpty(), "dataSetName is empty.");
		assertTrue(dataSetName.matches("^[a-zA-Z0-9 ]+$"), "dataSetName contains special characters.");

		SendDataUtils.clearAndSendKeys(dataSetNameField, dataSetName);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		try {
			assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
					"//label[normalize-space()='Dataset Name*']/..//label[normalize-space()='This field is required.']"))));
		} catch (TimeoutException e) {
			System.out.println(
					"Exception : " + e + "\n" + "Exsting User Displayed Or Not : " + dataSetName + " is Displayed.");
			assertFalse(true, "dataSetName is displayed");
		}

		unWait(1);

		String enteredText = dataSetNameField.getAttribute("value");
		Assert.assertEquals(enteredText, dataSetName.replace(" ", ""),
				"dataSetName is not correctly entered in the field.");
	}

	public DataSet processDropDownSelect(WebElement processDropDown, String processValue) {

		assertTrue(processDropDown.isDisplayed());
		Select select = new Select(processDropDown);
		select.selectByVisibleText(processValue);

		return this;
	}

	public DataSet subProcessDropDownSelect(WebElement subProcessDropDown, String subProcessValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='sub_process']/option")));

		assertTrue(subProcessDropDown.isDisplayed());
		Select select1 = new Select(subProcessDropDown);
		select1.selectByVisibleText(subProcessValue);

		return this;
	}

	public DataSet subSubProcessDropDownSelect(WebElement subSubProcessDropDown, String subSubProcessValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='s_sub_process']/option")));

		assertTrue(subSubProcessDropDown.isDisplayed());
		Select select = new Select(subSubProcessDropDown);
		select.selectByVisibleText(subSubProcessValue);

		return this;
	}

	private static final String PROPERTIES_FILE = "src/main/resources/DataSet.properties";

	public DataSet enterFieldNameAndValidations(List<Map<String, String>> fieldData) throws Throwable {
		// Using LinkedHashMap to maintain order
		LinkedHashMap<String, String> labelMap = new LinkedHashMap<>();

		try (FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE)) {
			properties.store(fos, "Cleared Existing Labels");
		}

		for (int i = 0; i < fieldData.size(); i++) {
			Map<String, String> row = fieldData.get(i);

			String fieldName = row.get("FieldName");
			String type = row.get("Type");
			String maxLength = row.get("MaxLength");
			String isMandatory = row.get("IsMandatory");

			verifyFieldNameField(DynamicXpath.dataSetField(i), fieldName);
//			verifyLabelNameField(DynamicXpath.dataSetLabelField(i), fieldName);
			verifyLabelNameFieldValue(DynamicXpath.dataSetLabelField(i), fieldName);

			// Store label in LinkedHashMap
			labelMap.put("label_" + i, fieldName);

			typeDropDownSelect(i, type);

			if (!"Date".equalsIgnoreCase(type) && !"Date Time".equalsIgnoreCase(type)) {
				verifyMaxLengthField(DynamicXpath.dataSetMaxLength(i), maxLength);
			}

			mandatoryDropDownSelect(i, isMandatory);

			if (i < fieldData.size() - 1) {
				click(driver, addRowButton);
			}
		}

		// Write to properties file in the correct order
		try (FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE)) {
			for (Map.Entry<String, String> entry : labelMap.entrySet()) {
				properties.setProperty(entry.getKey(), entry.getValue());
			}
			properties.store(fos, "Stored Label Names");
		}

		return this;
	}

	public ArrayList<String> getLabelNamesFromProperties() {

		ArrayList<String> labelNames = new ArrayList<>();
		LinkedHashMap<String, String> labelMap = new LinkedHashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_FILE))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("=")) {
					String[] parts = line.split("=", 2);
					labelMap.put(parts[0].trim(), parts[1].trim());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		labelNames.addAll(labelMap.values()); // Maintain insertion order

		return labelNames;
	}

	public DataSet verifyFieldNameField(WebElement fieldNameField, String fieldName) {

		assertTrue(fieldNameField.isEnabled(), "fieldNameField is not enabled.");

		String existingText = fieldNameField.getAttribute("value");
		assertTrue(existingText.isEmpty(), "fieldNameField is not empty before entering text.");

		assertNotNull(fieldName, "fieldName is null.");
		assertFalse(fieldName.trim().isEmpty(), "fieldName is empty.");
//		assertTrue(fieldName.matches("^[a-zA-Z0-9 ]+$"), "fieldName contains special characters.");

		SendDataUtils.clearAndSendKeys(fieldNameField, fieldName);

		String enteredText = fieldNameField.getAttribute("value");
		Assert.assertEquals(enteredText.replace(" ", ""), fieldName.replace(" ", ""),
				"fieldName is not correctly entered in the field.");

		return this;
	}

	public DataSet verifyLabelNameField(WebElement labelNameField, String labelName) {

		assertTrue(labelNameField.isEnabled(), "fieldNameField is not enabled.");

		String existingText = labelNameField.getAttribute("value");
		assertTrue(existingText.isEmpty(), "fieldNameField is not empty before entering text.");

		assertNotNull(labelName, "fieldName is null.");
		assertFalse(labelName.trim().isEmpty(), "fieldName is empty.");
//		assertTrue(labelName.matches("^[a-zA-Z0-9 ]+$"), "fieldName contains special characters.");

		SendDataUtils.clearAndSendKeys(labelNameField, labelName);

		String enteredText = labelNameField.getAttribute("value");
		Assert.assertEquals(enteredText, labelName.replace(" ", ""),
				"fieldName is not correctly entered in the field.");

		return this;
	}

	public DataSet verifyLabelNameFieldValue(WebElement labelNameField, String labelName) {

		assertTrue(labelNameField.isEnabled(), "fieldNameField is not enabled.");

		String enteredText = labelNameField.getAttribute("value");
		Assert.assertEquals(enteredText, labelName.replace(" ", ""),
				"fieldName is not correctly entered in the field.");

		return this;
	}

	public DataSet verifyMaxLengthField(WebElement maxLengthField, String maxLength) {

		assertTrue(maxLengthField.isEnabled(), "maxLengthField is not enabled.");

		String existingText = maxLengthField.getAttribute("value");
		assertTrue(existingText.isEmpty(), "maxLengthField is not empty before entering text.");

		assertNotNull(maxLength, "maxLength is null.");
		assertFalse(maxLength.trim().isEmpty(), "maxLength is empty.");
//		assertTrue(maxLength.matches("^[a-zA-Z0-9 ]+$"), "maxLength contains special characters.");

		SendDataUtils.clearAndSendKeys(maxLengthField, maxLength);

		String enteredText = maxLengthField.getAttribute("value");
		Assert.assertEquals(enteredText, maxLength, "maxLength is not correctly entered in the field.");

		return this;
	}

	public DataSet typeDropDownSelect(int index, String type) throws Throwable {

		DropDown.dropdownWithAllPosibleValidation(DynamicXpath.dataSetTypeDropDown(index), "Character", type);

		return this;
	}

	public DataSet mandatoryDropDownSelect(int index, String isMandatory) throws Throwable {

		DropDown.dropdownWithAllPosibleValidation(DynamicXpath.dataSetMandatoryDropDown(index), "Yes", isMandatory);

		return this;
	}

	public DataSet createDataSetButtonAndConfirmation() throws Throwable {

		dataSetCreateButton.click();

		wait.until(ExpectedConditions.visibilityOf(dataSetCreateSuccessPopUp));
		assertTrue(dataSetCreateSuccessPopUp.isDisplayed(), "dataSetCreateSuccessPopUp is not displayed.");

		assertTrue(continueButton.isDisplayed(), "continueButton is not displayed.");
		continueButton.click();

		return this;
	}

//	=====================================================================

// New Funcanality 

	// Search

	public void searchThroughDatasetName(String searchProcess) throws Throwable {

		switch (searchProcess) {

		case "searchManually": {

			PropertieFileUtil.extractAllAndStore(dataset_filePath, dataSetLists, "dataSet");

			assertTrue(searchBar.isDisplayed(), "searchBar is not displayed");
			searchBar.isEnabled();
			searchBar.clear();

			fetchDatset_PropFile = PropertieFileUtil.getSingleTextFromPropertiesFile(dataset_filePath, "dataSet1");

			searchBar.sendKeys(fetchDatset_PropFile);

			assertTrue(searchBar.isDisplayed(), "searchButton is not displayed");
			searchButon.click();

			assertEquals(fetchCurrentCreated.getText(), fetchDatset_PropFile, "Not Matched With Searched Process Name");

			break;

		}

		case "randomely": {

			try {
				// Load properties file
				Properties props = new Properties();

				FileInputStream fis = new FileInputStream(dataset_filePath);

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

				assertTrue(searchButon.isDisplayed(), "searchButton is not displayed");
				searchButon.click();

				// Check for "No Entries Found" element
				List<WebElement> noEntryElements = driver.findElements(By.id("noEntriesFound"));
				if (!noEntryElements.isEmpty() && noEntryElements.get(0).isDisplayed()) {
					System.out.println("No created dataset available in this name: " + randomValue);
				} else {
					// Fetch first created record
//					WebElement fetchFirstCreatedRecord = driver.findElement(By.id("fetchFirstCreatedRecord"));
					String fetchedText = fetchCurrentCreated.getText().trim();

					if (fetchedText.equalsIgnoreCase(randomValue)) {
						System.out.println("dataset is available in this name: " + randomValue);
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
				FileInputStream fis = new FileInputStream(dataset_filePath);
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

				assertTrue(searchButon.isDisplayed(), "Search button is not displayed");
				searchButon.click();

				// Check for "No Entries Found" element
				List<WebElement> noEntryElements = driver.findElements(By.id("noEntriesFound"));
				if (!noEntryElements.isEmpty() && noEntryElements.get(0).isDisplayed()) {
					System.out.println(" No created process available in this name (partial): " + partialValue);
				} else {
					// WebElement fetchFirstCreatedRecord =
					// driver.findElement(By.id("fetchFirstCreatedRecord"));
					String fetchedText = fetchCurrentCreated.getText().trim();

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

	// =====>Delete

	// Delete
	public void deleteDatsetFromArchiveTab(String datasetName) {
		try {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			boolean processFound = false;

			for (WebElement row : rows) {
				String rowProcessName = row.findElement(By.xpath(".//td[1]")).getText().trim();

				if (rowProcessName.equalsIgnoreCase(datasetName)) {
					processFound = true;

					try {
						WebElement deleteIcon = row.findElement(By.xpath("//table[@class='w-100']//tr//td//img[2]"));
						if (deleteIcon.isDisplayed() && deleteIcon.isEnabled()) {
							deleteIcon.click();
							assertTrue(deletePopup.isDisplayed(), " Delete popup not displayed.");
							ClickUtilities.clickIfMatch(popDeleteButton, "Delete");

							System.out.println("dataset '" + datasetName + "' found and deleted.");
						} else {
							System.out.println("⚠ Delete icon not clickable for datasetName: '" + datasetName + "'");
						}
					} catch (NoSuchElementException e) {
						System.out.println("⚠ Delete icon not found for process: '" + datasetName + "'");
					}
					break;
				}
			}

			if (!processFound) {
				System.out.println(" delete '" + datasetName + "' not found in the archive table.");
			}
		} catch (Exception e) {
			System.out.println(" Exception in deleteProcessByNameFromArchive: " + e.getMessage());
		}
	}

	// Utility to get Cunt for "showing "Showing 1 to 10 of 248"

	public int getTotalCountFromElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver1 -> !element.getText().trim().isEmpty()); // Wait until text is not empty

		String text = element.getText().replaceAll("\\s+", " ").trim();
		System.out.println("🔍 Raw text captured from element: '" + text + "'");

		// Use regex to extract last number
		Pattern pattern = Pattern.compile("(\\d+)(?!.*\\d)");
		Matcher matcher = pattern.matcher(text);

		if (matcher.find()) {
			int totalCount = Integer.parseInt(matcher.group(1));
			System.out.println("✅ Total count extracted successfully: " + totalCount);
			return totalCount;
		} else {
			System.out.println("⚠️ No numeric count found in text: '" + text + "'");
			return 0; // Return 0 safely instead of throwing exception
		}
	}

	// archive and Unarchive Dataset

	public void archiveAction() {

		assertTrue(archiveAction.isDisplayed(), "archive Button is not Displayed");

		archiveAction.isEnabled();

		archiveAction.click();

	}

	public void verifyArchivePopupAndClick() throws Throwable {

		// ClickUtilities.clickIfMatch(archivePopupOptions, "Archive");

		wait.until(ExpectedConditions.visibilityOf(archivePopup));
		assertTrue(archivePopup.isDisplayed(), "archivePopup is not Displayed");
		continueButton.click();

	}

	// ArchiveDataSet_single and Verify In Archiv Tab
	public void archiveDataset(String archive_unarchivetab,String status) throws Throwable {
		// 1️⃣ Capture total count before archive
		int beforeCount = getTotalCountFromElement(showingNumberOfRecords);
		System.out.println(" Total dataset count before archive: " + beforeCount);

		// 2️⃣ Perform archive steps
		searchThroughDatasetName("searchManually");
		
		clearButton.click();
		
		unWait(2);
		
		archiveAction();
		
		verifyArchivePopupAndClick();

		int afterCount = getTotalCountFromElement(showingNumberOfRecords);
		System.out.println(" Total dataset count after archive: " + afterCount);

		// 4️⃣ Verify count decreased dynamically (not necessarily by 1)
		Assert.assertTrue(afterCount < beforeCount, "FAIL: Total count did not decrease after archiving (Before: "
				+ beforeCount + ", After: " + afterCount + ")");

		System.out.println(" PASS: Total dataset count decreased from " + beforeCount + " to " + afterCount);

		// Navigate To Archive Dataset tab
		naviateToArchiveDataset(archive_unarchivetab);

		// Search in ArchiveDataSet Tab
		searchBar.sendKeys(fetchDatset_PropFile);
		searchButon.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

		// Get all process rows dynamically
		List<WebElement> processRows = driver.findElements(By.xpath("//table/tbody/tr"));

		boolean isProcessFound = false;

		for (WebElement row : processRows) {
			String rowProcessName = row.findElement(By.xpath(".//td[1]")).getText().trim();
			String rowStatus = row.findElement(By.xpath("(//td[5])")).getText().trim(); // status
																						// column

			if (rowProcessName.toLowerCase().contains(fetchDatset_PropFile.toLowerCase())) {
				isProcessFound = true;

				if (rowStatus.equalsIgnoreCase(status)) {
					System.out.println(
							" PASS: dataSet '" + fetchDatset_PropFile + "' is archived with status 'Inactive'");
				} else {
					System.out.println(" FAIL: Process '" + fetchDatset_PropFile + "' found, but status is '"
							+ rowStatus + "' (Expected: Inactive)");
				}

				break; // No need to continue once found
			}
		}

		if (!isProcessFound) {
			System.out.println(" FAIL: Process '" + fetchDatset_PropFile + "' not found in archive list.");
		}

	}

	// Archive Multiple DatSet

	public void archive_Unarchive_MultipleDatasets(WebElement archiveAction, int count) {
		int archivedCount = 0;

		try {
			// ✅ Step 1: Ensure element is visible
			Assert.assertTrue(showingNumberOfRecords.isDisplayed(),
					"❌ 'Showing-number-of-records' element is not displayed.");

			// ✅ Step 2: Capture total before archive
			int beforeCount = getTotalCountFromElement(showingNumberOfRecords);
			System.out.println("📊 Total datasets before archive: " + beforeCount);

			// ✅ Step 3: Start archive loop
			while (archivedCount < count) {
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

				if (rows.isEmpty()) {
					System.out.println("⚠️ No dataset rows available to archive. Stopping loop.");
					break;
				}

				WebElement firstRow = rows.get(0);
				String datasetName = "";

				try {
					datasetName = firstRow.findElement(By.xpath(".//td[1]")).getText().trim();
				} catch (NoSuchElementException e) {
					System.out.println("⚠️ Could not read dataset name in the row - skipping this iteration.");
					continue;
				}

				try {
					// ✅ Use archiveAction element inside the row
//	                WebElement archiveAction = firstRow.findElement(
//	                        By.xpath(".//img[@alt='archive'] | .//button[contains(@class,'archive')]"));

					if (archiveAction.isDisplayed() && archiveAction.isEnabled()) {
						archiveAction.click();

						// ✅ Wait for archive popup and confirm
						wait.until(ExpectedConditions.visibilityOf(archivePopup));
						Assert.assertTrue(archivePopup.isDisplayed(), "❌ archivePopup is not Displayed");
						continueButton.click();

						System.out.println("🗂️ Archived dataset (confirmed via popup): " + datasetName);
						archivedCount++;

						// ✅ Wait dynamically until count decreases
						int expectedCountAfter = beforeCount - archivedCount;
						wait.until(driver1 -> {
							int currentCount = getTotalCountFromElement(showingNumberOfRecords);
							return currentCount <= expectedCountAfter;
						});

						int newCount = getTotalCountFromElement(showingNumberOfRecords);
						System.out.println("📉 Count updated after archiving '" + datasetName + "': " + newCount);

					} else {
						System.out.println("⚠️ Archive action not visible or disabled for dataset: " + datasetName);
					}

				} catch (NoSuchElementException e) {
					System.out.println("⚠️ archiveAction not found for dataset: " + datasetName);
				}
			}

			// ✅ Step 4: Capture total after archive
			int afterCount = getTotalCountFromElement(showingNumberOfRecords);
			System.out.println("📊 Total datasets after archive: " + afterCount);

			// ✅ Step 5: Validate count dynamically
			int expectedAfterCount = beforeCount - archivedCount;
			System.out.println("🔎 Expected count after archive: " + expectedAfterCount + ", Actual: " + afterCount);

			Assert.assertEquals(afterCount, expectedAfterCount, "❌ Dataset count mismatch after archiving. Expected: "
					+ expectedAfterCount + ", but found: " + afterCount);

			System.out.println("✅ Archive validation successful. " + archivedCount + " dataset(s) archived correctly.");

		} catch (Exception e) {
			Assert.fail("❌ Exception occurred during dataset archive operation: " + e.getMessage(), e);
		}
	}

//=========================================================================
	@FindBy(xpath = "//h2[text()='Create Dataset']/following-sibling::span")
	WebElement close;

	public DataSet close() {
		jsClick(close);
		return this;
	}

	
	//Child Class
	public class CustomDataSet extends DataSet {

	    @Override
	    public void naviateToArchiveDataset(String tabName) {
	        // ✅ Locate the Archive tab using the updated XPath
	        WebElement archiveTab = driver.findElement(By.xpath("(//ul[@id='pills-tab'])[2]//button"));

	        // ✅ Use JS click for stability
	        jsClick(archiveTab);

	        System.out.println("✅ Custom navigation performed for: " + tabName + " via Archive Tab XPath");
	    }
	}

}
