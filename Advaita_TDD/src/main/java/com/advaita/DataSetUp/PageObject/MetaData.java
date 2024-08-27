package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	//Table
	
	@FindBy(xpath="(//div[@class='d-flex align-items-center']//img[@class='img-fluid delete-dataset cursor-pointer delete_metadata'])[1]")
	public static WebElement DeleteButton_table;
	
	@FindBy(xpath ="//div[@class='modal-content yes-nopopup']//form[@action='/en/metadata_management/metadata/']//div//p[@class='m-0 font_14 text_black fw-normal']")
	public static WebElement deletePopup_table;
	
	@FindBy(xpath = "//div[@class='modal-content yes-nopopup']//form//div//button[@class='btn btn-primary data-delete font_12 fw-bold line_height11 mr_22']")
	public static WebElement deleteButtonConformation_table;
	
	@FindBy(xpath = "//div[@class='modal-content yes-nopopup']//form//div//button[@class='btn-secondary  text_black data-delete']")
	public static WebElement  cancelButtonConformation_table;
	
	@FindBy(xpath = "//div[@class='modal-body d-flex flex-column align-items-center justify-content-center']//span[@id='change_msg']")
	public static WebElement deleteSuccessfullyPopup;
	
	@FindBy(xpath = "//input[@id='text_search']")
	public static WebElement searchTextfield_table;
	
	@FindBy(xpath="//tbody//tr//td[@class='fw-semi md-one metadata_name_list']")
	public static WebElement SearchGetText_table;
	
	@FindBy(xpath = "//button[@class='filter_search_blk cursor-pointer d-flex align-items-center justify-content-center white_bg']")
	public static WebElement searchButton_table;
	
	@FindBy(xpath = "//select[@id='process_search']")
	public static WebElement searchProcessDropdown_table;
	
	@FindBy(xpath = "//select[@id='sub_process_search']")
	public static WebElement searchSubProcessDropdown_table;
	
	@FindBy(xpath ="//select[@id='s_sub_process_search']")
	public static WebElement searchSubSubprocessDropdown_table;
	
	@FindBy(xpath = "//a//img[@alt='notification_icon']")
	public static WebElement notificationIconButton_table;
	
	@FindBy(xpath="//h1[text()=' Notifications ']")
	public static WebElement notificationPage;
	
	@FindBy(xpath = "(//div//div[@class='noti_blk d-flex justify-content-between '])[1]")
	public static WebElement createdMetadataNotification_table;
	
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

	public void editMetaData() throws Throwable 
	{
		
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
	
	//Table
	
	//Verify the User is able to delete the  Created MetaData from Data Management Page
	
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
	
	//Verify the user is able to search by entering created process name

	public void searchcreatedMetadata(String TestBarrows) 
	{
		click(driver, metaDataTab);
		
		assertTrue(searchTextfield_table.isDisplayed(), "searchTextfield_table is not displayed");
		searchTextfield_table.sendKeys(TestBarrows);
		
		
		assertTrue(searchButton_table.isDisplayed(), "searchButton_table is not displayed");
		searchButton_table.click();
		
		assertTrue(SearchGetText_table.isDisplayed(), "SearchGetText_table is not displayed");
		SearchGetText_table.getText();
		
	}
	
	//Verify The user is able to search by apply filter select process,sub process,sub sub process
	
		public void searchByFilters() 
			{
			
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

	            // Ensure the random index does not select the first option (if it's a placeholder)
	            if (options.get(0).getText().equals("Search Process")) {
	                randomIndex = random.nextInt(options.size() - 1) + 1;
	            }

	            // Select the random option
	            dropdown.selectByIndex(randomIndex);

	            // Output the selected option
	            System.out.println("Selected option: " + options.get(randomIndex).getText());
	            
 //select Subprocess
	            
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
		
		//Verify the able to get notification after Successfully created MetaData

		public void getNotificationAftercreatedMetadata(String metaDataName) throws InterruptedException 
		{
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
			
			assertTrue(createdMetadataNotification_table.isDisplayed(), "createdMetadataNotification_table is not displayed");
			createdMetadataNotification_table.getText();
			
			
		;
			
			
		}

			
	
	
}
