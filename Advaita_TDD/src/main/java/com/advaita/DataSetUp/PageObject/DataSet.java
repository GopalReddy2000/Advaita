package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.DynamicXpath;
import com.advaita.Utilities.Pagination;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.Utilities.SendDataUtils;

import Advaita_TDD.Advaita_TDD.FakeData;

public class DataSet extends TestBase {

	@FindBy(xpath = "//a[normalize-space()='Data Setup']")
	private static WebElement dataSetup;

	@FindBy(id = "pills-dataset-tab")
	public static WebElement dataSetTab;

	@FindBy(xpath = "(//a[normalize-space()='+ Create'])[1]")
	public static WebElement createDataSetButton;

	@FindBy(xpath = "//div[@class='modal-dialog modal-lg detail_form']//div[@class='modal-content']")
	public static WebElement createDataSetPupup;

	@FindBy(id = "dataset_name")
	public static WebElement dataSetNameField;

	@FindBy(xpath = "//input[@name='form-0-dataset_fieldname']")
	public static WebElement fieldNameField;

	@FindBy(xpath = "//input[@id='id_form-0-ds_field_label']")
	public static WebElement labelField;

	@FindBy(id = "id_form-0-ds_field_type")
	public static WebElement typeDropDown;

	@FindBy(id = "id_form-0-ds_field_value")
	public static WebElement maxLengthField;

	@FindBy(id = "id_form-0-ds_is_mandatory")
	public static WebElement mandetoryDropDown;

	@FindBy(xpath = "//a[@id='add_more'][normalize-space()='+ Add Row']")
	public static WebElement addRowButton;

	@FindBy(xpath = "//input[@name='form-1-dataset_fieldname']")
	public static WebElement fieldNameField1;

	@FindBy(xpath = "//input[@id='id_form-1-ds_field_label']")
	public static WebElement labelField1;

	@FindBy(id = "id_form-1-ds_field_type")
	public static WebElement typeDropDown1;

	@FindBy(id = "id_form-1-ds_field_value")
	public static WebElement maxLengthField1;

	@FindBy(id = "id_form-1-ds_is_mandatory")
	public static WebElement mandetoryDropDown1;

	// ########################################

	@FindBy(xpath = "//input[@name='form-2-dataset_fieldname']")
	public static WebElement fieldNameField2;

	@FindBy(xpath = "(//input[@class='form-control'])[5]")
	public static WebElement editFieldName;

	@FindBy(xpath = "//input[@id='id_form-2-ds_field_label']")
	public static WebElement labelField2;

	@FindBy(xpath = "(//input[@class='form-control'])[6]")
	public static WebElement editLabelField;

	@FindBy(id = "id_form-2-ds_field_type")
	public static WebElement typeDropDown2;

	@FindBy(xpath = "(//select[@class='form-control field_type_dropdown'])[3]")
	public static WebElement editTypeDropDown;

	@FindBy(id = "id_form-2-ds_field_value")
	public static WebElement maxLengthField2;

	@FindBy(xpath = "(//textarea[@class='form-control'])[3]")
	public static WebElement editMaxLengthField;

	@FindBy(id = "id_form-2-ds_is_mandatory")
	public static WebElement mandetoryDropDown2;

	@FindBy(xpath = "(//select[@class='form-control'])[3]")
	public static WebElement editMandetoryDropDown;

	@FindBy(xpath = "(//img[@alt='delete-icon'])[4]")
	public static WebElement deleteButton;

	@FindBy(id = "create_btn")
	public static WebElement dataSetCreateButton;

	@FindBy(id = "change_msg")
	public static WebElement dataSetCreateSuccessPopUp;

	@FindBy(xpath = "(//button[@aria-label='Close'][normalize-space()='Continue'])[1]")
	public static WebElement continueButton;

	@FindBy(id = "process")
	public static WebElement processDropDown;

	@FindBy(id = "sub_process")
	public static WebElement subProcessDropDown;

	@FindBy(id = "s_sub_process")
	public static WebElement subSubProcessDropDown;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//img[@alt='table_drop_down']")
	public static WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td[1]//img[@alt='table_drop_down']")
	public static WebElement dropDown2;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//span")
	public static WebElement fetchProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[1]")
	public static WebElement fetchsubProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[3]")
	public static WebElement fetchsubSubProcess;

	@FindBy(xpath = "(//div//p)[1]")
	public static WebElement fetchTotalRecord;

	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public static WebElement editButton;

	@FindBy(xpath = "//table[@class='w-100']/tbody/tr[1]/td[1]")
	public static WebElement fetchCurrentCreated;

	@FindBy(xpath = "(//span[@class='d-flex cross_span'])[1]")
	public static WebElement closeButton;

	@FindBy(id = "text_search")
	public static WebElement searchBar;

	@FindBy(id = "process_search")
	public static WebElement processSearch;

	@FindBy(id = "sub_process_search")
	public static WebElement subProcessSearch;

	@FindBy(id = "s_sub_process_search")
	public static WebElement subSubProcessSearch;

	@FindBy(xpath = "(//img[@src='/static/images/filter_search.svg'])[1]")
	public static WebElement searchButon;

	@FindBy(xpath = "(//h6[normalize-space()='Clear All Filters'])[1]")
	public static WebElement clearButton;

	@FindBy(xpath = "//table[@class='w-100']//tr//td//img[1]")
	public static List<WebElement> deleteDataSet;

	@FindBy(xpath = "//div[@id='id_confrm_popp']//button[text()='Delete']")
	public static WebElement popDeleteButton;

	@FindBy(xpath = "//h3[@class='page_heading mb_8']/following-sibling::span[@id='change_msg']")
	public static WebElement notificationTxt;

//	@FindBy(xpath = "//h3[@class='page_heading mb_8']/following-sibling::span[@id='change_msg']")
//	public static WebElement notificationTxt;

	@FindBy(xpath = "//img[@alt='rgt_arrow']//parent::a")
	public static WebElement paginationRightArrow;

	@FindBy(xpath = "//p[@class='show_entries m-0 font_13']")
	public static WebElement showingNumberOfRecords;

	@FindBy(xpath = "//div[@class='mt_20']//button[@type='submit']")
	public static WebElement recordDeleteButton;

	ScreenShorts ss = new ScreenShorts();
	Pagination pg = new Pagination();

	FakeData fake = new FakeData();

	String processValue;
	String subProcessValue;
	String subSubProcessValue;

	String dataSetName1 = FakeData.firstCapString() + " Name";

	public DataSet() {
		PageFactory.initElements(driver, this);
	}

	public void createDataSet(String type) throws Throwable {

		// Faker faker = new Faker();
		HomePage.clickOnProcessManagementCreate();
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

		assertEquals(actualURL, expecteddURL);

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

		assertEquals(afterResult, beforeTotalRecored);

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
		assertEquals(300, xCoordinate);

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
			jsClick(driver, element);
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

		jsClick(driver, getRandomElement(deleteDataSet));
		jsClick(driver, recordDeleteButton);
		wait.until(ExpectedConditions.visibilityOf(notificationTxt));
		System.out.println(notificationTxt.getText());
		Assert.assertEquals(notificationTxt.getText(), "Dataset has been deleted successfully");

	}

//	##############################################################################################################################
//	##############################################################################################################################
//	##############################################################################################################################
//	##############################################################################################################################

	public DataSet navigateToDataSetup() throws Throwable {

		// Faker faker = new Faker();
		HomePage.clickOnProcessManagementCreate();
		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(1000);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(1000);

		processValue = fetchProcess.getText();
		subProcessValue = fetchsubProcess.getText();
		subSubProcessValue = fetchsubSubProcess.getText();

		System.out.println("process : " + processValue + "\n" + "subProcess : " + subProcessValue + "\n"
				+ "subSubProcess : " + subSubProcessValue);

		// Assert whether Datasetup Button is Displayed on the left Navigation Menu
		assertTrue(dataSetup.isDisplayed(), "DataSetup is not Displayed");
		dataSetup.click();

		assertTrue(dataSetTab.isDisplayed(), "Datasetup Tab is not Displayed");
		dataSetTab.click();

		String expecteddURL = "https://test.capture.autosherpas.com/en/dataset_management/dataset/";

		String actualURL = driver.getCurrentUrl();

		assertEquals(actualURL, expecteddURL);

		return this;
	}

	public DataSet createNewDataSet(String dataSetName) {

		click(driver, createDataSetButton);

		wait.until(ExpectedConditions.visibilityOf(createDataSetPupup));
		assertTrue(createDataSetPupup.isDisplayed());

		verifyDataSetNameField(dataSetName);

		processDropDownSelect().subProcessDropDownSelect().subSubProcessDropDownSelect();

		return this;
	}

	public void verifyDataSetNameField(String dataSetName) {

		assertTrue(createDataSetPupup.isDisplayed(), "createDataSetPupup is not displayed.");

		String text = driver.findElement(By.xpath("//label[normalize-space()='Dataset Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*', "dataSetNameField label does not end with '*'.");

		assertTrue(dataSetNameField.isEnabled(), "dataSetNameField is not enabled.");

		String existingText = dataSetNameField.getAttribute("value");
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

		String enteredText = dataSetNameField.getAttribute("value");
		assertEquals(enteredText, dataSetName, "dataSetName is not correctly entered in the field.");
	}

	
	public DataSet enterFieldNameAndValidations(List<Map<String, String>> fieldData) throws Throwable {


	    for (int i = 0; i < fieldData.size(); i++) {
	        Map<String, String> row = fieldData.get(i);

	        String fieldName = row.get("FieldName");
	        String type = row.get("Type");
	        String maxLength = row.get("MaxLength");
	        String isMandatory = row.get("IsMandatory");

	        // Verify and input field name
//	        WebElement fieldNameField = DynamicXpath.dataSetField(i);
	        verifyFieldNameField(DynamicXpath.dataSetField(i), fieldName);

	        // Verify and input label name
//	        WebElement labelNameField = DynamicXpath.dataSetLabelField(i);
	        verifyLabelNameField(DynamicXpath.dataSetLabelField(i), fieldName);

	        // Select type from dropdown
	        typeDropDownSelect(i, type);

	        // Handle maxLength only if the type is not True/False
	            verifyMaxLengthField(DynamicXpath.dataSetMaxLength(i), maxLength);

	        // Select mandatory option
//	        WebElement mandatoryDropDown = DynamicXpath.dataSetMandatoryDropDown(i);
	        mandatoryDropDownSelect(i, isMandatory);

	        // Add a new row unless it's the last iteration
	        if (i < fieldData.size() - 1) {
	        	click(driver, addRowButton);
	        }
	    }

	    return this;
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
		assertEquals(enteredText, fieldName, "fieldName is not correctly entered in the field.");

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
		assertEquals(enteredText, labelName, "fieldName is not correctly entered in the field.");

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
		assertEquals(enteredText, maxLength, "maxLength is not correctly entered in the field.");

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

	public DataSet processDropDownSelect() {

		assertTrue(processDropDown.isDisplayed());
		Select select = new Select(processDropDown);
		select.selectByVisibleText(processValue);

		return this;
	}

	public DataSet subProcessDropDownSelect() {

		assertTrue(subProcessDropDown.isDisplayed());
		Select select1 = new Select(subProcessDropDown);
		select1.selectByVisibleText(subProcessValue);

		return this;
	}

	public DataSet subSubProcessDropDownSelect() {

		assertTrue(subSubProcessDropDown.isDisplayed());
		Select select = new Select(subSubProcessDropDown);
		select.selectByVisibleText(subSubProcessValue);

		return this;
	}
	
	
	
	
	public static List<Map<String, String>> generateEmployeeQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Employee Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Employee ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Department", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Position", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Joining", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Salary", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Phone Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    return questions;
	}

	public static List<Map<String, String>> generateCustomerQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Customer Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Customer ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Registration", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Preferred Contact Method", "Type", "DropDown", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Purchase History", "Type", "Text Area", "MaxLength", "300", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Loyalty Points", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    return questions;
	}

	public static List<Map<String, String>> generateVendorQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Vendor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Vendor ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Person", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Business Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Registration Number", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Onboarding", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Payment Terms", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    return questions;
	}

	public static List<Map<String, String>> generateCompanyQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Company Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Company ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Industry", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Person", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Registration Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Tax ID", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Business Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    return questions;
	}

	public static List<Map<String, String>> generateStudentQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Student Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Student ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Gender", "Type", "DropDown", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Course", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Year of Study", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    return questions;
	}

	public static List<Map<String, String>> generateTechEduQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Student Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Student ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Course Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Enrollment Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Grade", "Type", "Text Area", "MaxLength", "5", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Instructor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Semester", "Type", "DropDown", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Attendance", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Assignments Completed", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Extra-Curricular Activities", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    return questions;
	}

	public static List<Map<String, String>> generateMedicalQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Patient Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Patient ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Gender", "Type", "DropDown", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Blood Type", "Type", "DropDown", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Allergies", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Medical History", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Current Medication", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Insurance Provider", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    return questions;
	}



}
