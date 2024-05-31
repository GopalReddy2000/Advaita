package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;

public class MetaData extends TestBase {
	
	FakeData fake = new FakeData();

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

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[1]/td[1]")
	public static WebElement fetchDataSet;

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[2]/td[1]")
	public static WebElement fetchDataSet1;

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[3]/td[1]")
	public static WebElement fetchDataSet2;

	@FindBy(id = "pills-dataset-tab")
	public static WebElement dataSetTab;

	@FindBy(xpath = "(//span[@aria-label='Close'])[1]")
	public static WebElement closeButton;

	@FindBy(id = "pills-metadata-tab")
	public static WebElement metaDataTab;

	@FindBy(xpath = "//div[@class='table-responsive data-view-name']//table/tbody/tr[1]/td[1]")
	public static WebElement fetchDataSetColumn1;

	@FindBy(xpath = "//div[@class='table-responsive data-view-name']//table/tbody/tr[2]/td[1]")
	public static WebElement fetchDataSetColumn2;

	@FindBy(xpath = "//h1[text()=' Metadata Management ']")
	public static WebElement afterClickMetadataTab;

	@FindBy(linkText = "+ Create")
	public static WebElement createMetaDataButton;

	@FindBy(xpath = "//div[@class='modal-dialog modal-lg']//div[@class='modal-content']")
	public static WebElement createMetaDataPopup;

	@FindBy(id = "metadata_name")
	public static WebElement metaDataNameField;

	@FindBy(xpath = "//button[@class='quantity-right-plus btn counter-btn btn-number']")
	public static WebElement addPlusColumn;

	@FindBy(xpath = "//button[@class='quantity-left-minus btn counter-btn']")
	public static WebElement deleteMinusColumn;

	@FindBy(id = "process")
	public static WebElement selectProcessDropDown;

	@FindBy(id = "sub_process")
	public static WebElement selectSubProcessDropDown;

	@FindBy(id = "s_sub_process")
	public static WebElement selectSubSubProcessDropDown;

	@FindBy(name = "primary_dataset_1")
	public static WebElement selectDataSetDropDown;

	@FindBy(name = "primary_dataset_2")
	public static WebElement selectDataSetDropDown2;

	@FindBy(name = "join_type_1")
	public static WebElement joinTypeDropDown;

	@FindBy(name = "target_dataset_1")
	public static WebElement selectDataSetDropDown1;

	@FindBy(name = "primary_datasetField_1-1")
	public static WebElement selectDataSetField;

	@FindBy(name = "primary_datasetField_2-1")
	public static WebElement selectDataSetFieldBelow;

	@FindBy(name = "target_datasetField_1-1")
	public static WebElement selectDataSetField1;

	@FindBy(name = "target_datasetField_2-1")
	public static WebElement selectDataSetField2;

	@FindBy(name = "primary_datasetField_1-2")
	public static WebElement selectDataSetField1Column2;

	@FindBy(name = "primary_datasetField_2-2")
	public static WebElement selectDataSetField2Column2;

	@FindBy(linkText = "+ Remove Row")
	public static WebElement removeRowButton;

	@FindBy(linkText = "+ Add Row")
	public static WebElement addRowButton;

	@FindBy(xpath = "(//a[text()='+ Add Row'])[2]")
	public static WebElement addRowButton2;

	@FindBy(id = "create_btn")
	public static WebElement createMetaDataPopUpButton;

	@FindBy(xpath = "//span[text()='Metadata created Successfully']")
	public static WebElement confirmationAfterCreatedMetaData;

	@FindBy(xpath = "//div[@id='succs_succ']//button[@aria-label='Close'][normalize-space()='Continue']")
	public static WebElement continueButton;

	// Update
	@FindBy(xpath = "//div[@class='dataset_table']//table/tbody/tr[1]/td[1]")
	public static WebElement clickOnCreatedMetaData;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public static WebElement clickOnCreatedMetaDataCheckBox1;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public static WebElement clickOnCreatedMetaDataCheckBox2;

	@FindBy(name = "role_name_0")
	public static WebElement roleSelectDropDown1;

	@FindBy(name = "role_name_1")
	public static WebElement roleSelectDropDown2;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	public static WebElement saveButtonInUpadteMetaData;

	@FindBy(xpath = "//span[text()='Metadata unique fields updated Successfully']")
	public static WebElement confirmationAfterUpdateMetaData;

	@FindBy(xpath = "//div[@id='succs_succ']//button[@aria-label='Close'][normalize-space()='Continue']")
	public static WebElement continueAfetrUpdateMetaData;

	// Edit
	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public static WebElement clickOnMetaDataEditButton;
	
	@FindBy(xpath = "//button[normalize-space()='Execute']")
	public static WebElement clickOnMetaDataExecuteButton;
	
	@FindBy(xpath = "//span[text()='Failed to create Metadata']")
	public static WebElement faildToEdit;

	public MetaData() {

		PageFactory.initElements(driver, this);
	}

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
		metaDataNameField.sendKeys("Test " + fake.lastName1());

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
		System.out.println("\n"+"\n"+"fetchMetaData : " + fetchMetaData);
		
		metaDataNameField.clear();
		metaDataNameField.sendKeys(fetchMetaData+"E");
		
		click(driver, clickOnMetaDataExecuteButton);
		
		assertTrue(!faildToEdit.isDisplayed(), "faildToEdit is displayed.");
		

	}
}
