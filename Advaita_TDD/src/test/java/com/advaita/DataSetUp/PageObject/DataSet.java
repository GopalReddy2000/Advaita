package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.Pagination;
import com.advaita.Utilities.ScreenShorts;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class DataSet extends TestBase {

	@FindBy(xpath="//a[normalize-space()='Data Setup']")
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

	@FindBy(xpath = "(//a[normalize-space()='+ Add Row'])[1]")
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

	@FindBy(xpath ="//table[@class='w-100']//img[@id=\"id_delete\"]")
	public static WebElement deleteDataSet;

	@FindBy(xpath ="//div[@id=\"id_confrm_popp\"]//button[text()='Delete']")
	public static WebElement popDeleteButton;
	
	@FindBy(xpath="//div[@id=\"succs_succ\"]//span[@id=\"change_msg\"]")
	public static WebElement notificationTxt;
	
	@FindBy(xpath="//div[@id=\"succs_succ\"]//button[normalize-space()=\"Continue\"]")
	public static WebElement notificationDeleteButton;

	ScreenShorts ss = new ScreenShorts();
	Pagination pg = new Pagination();

	FakeData fake = new FakeData();

	public DataSet() {
		PageFactory.initElements(driver, this);
	}

	public void createDataSet(String fieldName, String labelName, String maxLength, String type)
			throws Throwable {

		//		Faker faker = new Faker();

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

		//		Assert whether Datasetup Button is Displayed on the left Navigation Menu
		assertTrue(dataSetup.isDisplayed(),"DataSetup is not Displayed");
		dataSetup.click();

		assertTrue(dataSetTab.isDisplayed(),"Datasetup Tab is not Displayed");
		dataSetTab.click();

		String expecteddURL = "https://pkt-test.transmonqa.in/en/dataset_management/dataset/";

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
			//		assertTrue(dataSetNameField.isSelected());
			if (i == 1) {
				dataSetNameField.sendKeys(fake.firstCapString()+" Name");
			}

			if (i == 2) {
				dataSetNameField.sendKeys(fake.firstCapString()+" Name");
			}

			if (i == 3) {
				dataSetNameField.sendKeys(fake.firstCapString()+" Name");
			}

			if (i == 4) {
				dataSetNameField.sendKeys(fake.firstCapString()+" Name");
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
			//		assertTrue(fieldNameField.isSelected());
			fieldNameField.sendKeys(fake.lastName1()+" Field");

			assertTrue(labelField.isDisplayed());
			assertTrue(labelField.isEnabled());
			labelField.click();
			//		assertTrue(labelField.isSelected());
			labelField.sendKeys(fake.lastName1()+" Field");

			assertTrue(typeDropDown.isDisplayed());
			Select select3 = new Select(typeDropDown);
			select3.selectByVisibleText(type);

			assertTrue(maxLengthField.isDisplayed());
			assertTrue(maxLengthField.isEnabled());
			maxLengthField.click();
			//		assertTrue(maxLengthField.isSelected());
			maxLengthField.sendKeys(maxLength);

			assertTrue(mandetoryDropDown.isDisplayed());
			Select select4 = new Select(mandetoryDropDown);
			select4.selectByVisibleText("Yes");

			for (int j = 1; j <= 2; j++) {
				addRowButton.click();
			}

			assertTrue(fieldNameField1.isDisplayed());
			assertTrue(fieldNameField1.isEnabled());
			fieldNameField1.click();
			//		assertTrue(fieldNameField.isSelected());
			fieldNameField1.sendKeys(fake.lastName1()+" Field");

			assertTrue(labelField1.isDisplayed());
			assertTrue(labelField1.isEnabled());
			labelField1.click();
			//		assertTrue(labelField.isSelected());
			labelField1.sendKeys(fake.lastName1()+" Field");

			assertTrue(typeDropDown1.isDisplayed());
			Select select5 = new Select(typeDropDown1);
			select5.selectByVisibleText("Boolean");

			assertTrue(maxLengthField1.isDisplayed());
			assertTrue(maxLengthField1.isEnabled());
			maxLengthField1.click();
			//		assertTrue(maxLengthField.isSelected());
			maxLengthField1.sendKeys("300");

			assertTrue(mandetoryDropDown1.isDisplayed());
			Select select6 = new Select(mandetoryDropDown1);
			select6.selectByVisibleText("Yes");

			// #####################################################

			assertTrue(fieldNameField2.isDisplayed());
			assertTrue(fieldNameField2.isEnabled());
			fieldNameField2.click();
			//		assertTrue(fieldNameField.isSelected());
			fieldNameField2.sendKeys(fake.lastName1()+" Field");

			assertTrue(labelField2.isDisplayed());
			assertTrue(labelField2.isEnabled());
			labelField2.click();
			//		assertTrue(labelField.isSelected());
			labelField2.sendKeys("Test Label 3");

			assertTrue(typeDropDown2.isDisplayed());
			Select select7 = new Select(typeDropDown2);
			select7.selectByVisibleText("Number");

			assertTrue(maxLengthField2.isDisplayed());
			assertTrue(maxLengthField2.isEnabled());
			maxLengthField2.click();
			//		assertTrue(maxLengthField.isSelected());
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

	}

	// ################################################################################################################

	public void editDataSet(String editDatasetName) throws Throwable {

		//		dataSetTab.click();
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
		//		assertTrue(fieldNameField.isSelected());
		editFieldName.sendKeys("Edit Test Field Name 3");

		assertTrue(editLabelField.isDisplayed());
		assertTrue(editLabelField.isEnabled());
		editLabelField.click();
		//		assertTrue(labelField.isSelected());
		editLabelField.sendKeys("Edit Test Label 3");

		assertTrue(editTypeDropDown.isDisplayed());
		Select select1 = new Select(editTypeDropDown);
		select1.selectByVisibleText("Text Area");

		assertTrue(editMaxLengthField.isDisplayed());
		assertTrue(editMaxLengthField.isEnabled());
		editMaxLengthField.click();
		//		assertTrue(maxLengthField.isSelected());
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

		//		Validate the X and Y Axes of all Boxes and bars in dataset page
		Point searchLocation=searchBar.getLocation();
		// Get the location (X and Y coordinates) of the searchBar element
		int xCoordinate= searchLocation.getX();
		int yCoordinate= searchLocation.getY();

		System.out.println("X Coordinates:"+ xCoordinate+"\n"+"Y Coordinates:"+yCoordinate);
		assertEquals(300,xCoordinate);

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

		//		Thread.sleep(2000);
		//		ss.takeScreenShot("afterSearch");


		//		Validate Clear All filters button
		clearButton.click();


		Thread.sleep(2000);
		// Find the pagination element
		Pagination.goToNextPage(driver, 5);
		Pagination.goToPreviousPage(driver, 4);
		//		Pagination.lastAndFirstPagination(driver,7);
		//		Pagination.lastAndFirstPagination(driver,1);

		//		Thread.sleep(3000);

	}

	public void deleteDataSet()
	{
		dataSetup.click();

		dataSetTab.click();
		
		int initialRowCount=getRowCount();
		
		List<WebElement> deleteButton=driver.findElements((By) deleteDataSet);

		Assert.assertFalse(deleteButton.isEmpty(),"No Delete icon is present");

		for(WebElement delete:deleteButton)
		{
			if(delete.isEnabled()) {
				delete.click();
				
				if (popDeleteButton.isEnabled()) {
					popDeleteButton.click();
					String notifyTxt=notificationTxt.getText();
					
					if(notifyTxt.contains("Dataset has been deleted successfully.")) {
						notificationDeleteButton.click();
						
					}else {Assert.fail("No Delete popup");}
					
			
				}else {Assert.fail("popDeleteButton is Disabled");}

			}
			else {
				Assert.fail("Delete Button is Disabled");
			}
		}
		int finalRowCount= getRowCount();
		Assert.assertEquals(finalRowCount, initialRowCount);

	}
	private int getRowCount() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='w-100']//tbody//tr"));
        // Subtracting 1 to exclude the header row
        return rows.size() - 1;
    } 



}
