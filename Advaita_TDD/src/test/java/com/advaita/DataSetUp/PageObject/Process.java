package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.Pagination;

import Advaita_TDD.Advaita_TDD.FakeData;

//import Advaita_TDD.Advaita_TDD.FakeData;



public class Process extends TestBase {

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

	@FindBy(id = "process_name")
	public static WebElement processNameField;

	@FindBy(id = "process_desc")
	public static WebElement processDescField;

	@FindBy(id = "process_status")
	public static WebElement processStatusDropDown;

	@FindBy(id = "save_and_continnue")
	public static WebElement saveandContinueButton;

	@FindBy(xpath = "//div[@id='pills-popupprocess']//button[@value='save'][normalize-space()='Save']")
	public static WebElement saveButton;

	@FindBy(id = "sub_process")
	public static WebElement subProcessTab;

	@FindBy(xpath = "//select[@id='process_dropdown']")
	public static WebElement selectProcessDropDown;

	@FindBy(id = "sub_process_name")
	public static WebElement subProcessNameField;

	@FindBy(id = "sub_process_desc")
	public static WebElement subProcessDescField;

	@FindBy(id = "sub_process_status")
	public static WebElement subProcessStatusDropDown;

	@FindBy(xpath = "(//button[@value='save_and_continnue'][normalize-space()='Save and Continue'])[2]")
	public static WebElement saveandContinnueButtonInSubProcess;

	@FindBy(xpath = "//div[@id='pills-popupsubprocess']//button[@value='save'][normalize-space()='Save']")
	public static WebElement saveButtonInSubProcess;

	@FindBy(id = "s_sub_process")
	public static WebElement subSubProcessTab;

	@FindBy(id = "sub_process_dropdown")
	public static WebElement selectSubProcessDropDown;

	@FindBy(id = "s_sub_process_name")
	public static WebElement subSubProcessNameField;

	@FindBy(id = "s_sub_process_desc")
	public static WebElement subSubProcessDescField;

	@FindBy(id = "s_sub_process_status")
	public static WebElement subSubProcessStatusDropDown;

	@FindBy(xpath = "//button[normalize-space()='Save And Update']")
	public static WebElement save_UpdateButtonInSubsubProcess;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Process has been created']")
	public static WebElement createSuceessMessage;

	@FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
	public static WebElement continueButton;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//img[@alt='table_drop_down']")
	public static WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td[1]//img[@alt='table_drop_down']")
	public static WebElement dropDown2;

	@FindBy(xpath = "(//div[@class='action_width']//img[@alt='table-edit'])[1]")
	public static WebElement editOption1;

//	@FindBy(xpath = "(//tbody//tr//div[@class='action_width']//img[@alt='table-edit'])[1]")
//	public static WebElement editoption01;

	@FindBy(xpath = "(//div[@class='action_width']//img[@alt='table-edit'])[2]")
	public static WebElement editOption2;

	@FindBy(xpath = "(//div[@class='action_width']//img[@alt='table-edit'])[3]")
	public static WebElement editOption3;

	@FindBy(xpath = "//button[normalize-space()='Save And Update']")
	public static WebElement save_UpdateButtonInSubProcess;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Process has been updated']")
	public static WebElement updateProcessSuceessMassgage;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Sub Process has been updated']")
	public static WebElement updateSubProcessSuceessMassgage;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Sub Sub Process has been updated']")
	public static WebElement updateSubSubProcessSuceessMassgage;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//span")
	public static WebElement fetchCreatedRecord;

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
	public static WebElement TotalProcess;

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
	
	@FindBy(xpath = " //label[text()='Process Name*']/..//input[@id='process_name'] ")
	public static WebElement processExistText;  //Edit section _process name

//    @FindBy(xpath ="(//table[@class='process_table w-100']//tbody//tr)[4]")
//	public static WebElement fetchSubProcssNamElement;

	FakeData fake = new FakeData();

	public Process() {
		PageFactory.initElements(driver, this);
	}

	// Create
	public void createProcess1(String processName, String processDesc) {

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

		assertTrue(saveButton.isDisplayed(), "saveButton is not displayed");
		saveButton.click();

		wait.until(ExpectedConditions.visibilityOf(conformationMesgofCreateProcessElement));
		assertTrue(conformationMesgofCreateProcessElement.isDisplayed(),
				"conformationMesgofCreateProcessElement is not displayed.");

		assertTrue(continuElement.isDisplayed(), "continuElement is not displayed");
		continuElement.click();

	}

	public void createSubProcess(String subprocessfield, String subprocssDesc) {

		assertTrue(fetchProcessName.isDisplayed(), "fetchProcessName is not displayed.");
		String fetchhprocessName = fetchProcessName.getText();

//		System.out.println(fetchhprocessName);

		assertTrue(createProcessButton.isDisplayed(), "createProcessButton is not displayed.");
		createProcessButton.click();

		wait.until(ExpectedConditions.visibilityOf(subProcessTab));
		assertTrue(subProcessTab.isDisplayed(), "subProcessTab is not displayed");
		subProcessTab.click();

		wait.until(ExpectedConditions.visibilityOf(selectProcessDropDown));
		assertTrue(selectProcessDropDown.isDisplayed(), "selectProcessDropDown is not displayed");
		Select select = new Select(selectProcessDropDown);
		select.selectByVisibleText(fetchhprocessName);

		assertTrue(subProcessNameField.isDisplayed(), "subProcessNameField is not displayed");
		subProcessNameField.sendKeys(subprocessfield);

		assertTrue(subProcessDescField.isDisplayed(), "subProcessDescField is not displayed.");
		subProcessDescField.sendKeys(subprocssDesc);

		assertTrue(subProcessStatusDropDown.isDisplayed(), "subProcessStatusDropDown is not displayed.");
		Select select1 = new Select(subProcessStatusDropDown);
		select1.selectByVisibleText("Active");

		assertTrue(saveButtonInSubProcess.isDisplayed(), "saveButtonInSubProcess is not displayed");
		saveButtonInSubProcess.click();

		wait.until(ExpectedConditions.visibilityOf(conformationMesgofCreateProcessElement));
		assertTrue(conformationMesgofCreateProcessElement.isDisplayed(),
				"conformationMesgofCreateProcessElement is not displayed.");

		assertTrue(continuElement.isDisplayed(), "continuElement is not displayed");
		continuElement.click();

	}

	public void createSubSubProcess(String SubsubProcessName, String subSubProcessDesc) throws Throwable {

		//Thread.sleep(2000);

		assertTrue(dropDown1.isDisplayed(), "dropdown is not displayed");
		dropDown1.click();

		Thread.sleep(2000);
		assertTrue(fetchSubProcessName.isDisplayed(), "fetchSubProcessName is not displayed.");
		String fetchSubProcssNameElement = fetchSubProcessName.getText();
		System.out.println("fetchSubProcssNameElement : " + fetchSubProcssNameElement);

		assertTrue(createProcessButton.isDisplayed(), "create button is not displayed.");
		createProcessButton.click();

		wait.until(ExpectedConditions.visibilityOf(subSubProcessTab));
		assertTrue(subSubProcessTab.isDisplayed(), "subSubProcessTab is not displayed");
		subSubProcessTab.click();

		Select select = new Select(selectSubProcessDropDown);
		select.selectByVisibleText(fetchSubProcssNameElement);
		

		assertTrue(subSubProcessNameField.isDisplayed(), "subSubProcessNameField is not displayed");
		subSubProcessNameField.sendKeys(SubsubProcessName);

		assertTrue(subSubProcessDescField.isDisplayed(), "subSubProcessDescField is not displayed");
		subSubProcessDescField.sendKeys(subSubProcessDesc);

		assertTrue(subSubProcessDropDown.isDisplayed(), "subSubProcessDropDown is not displayed");
		Select select2 = new Select(subSubProcessDropDown);
		select2.selectByVisibleText("Active");

		assertTrue(save_UpdateButtonInSubsubProcess.isDisplayed(), "save_UpdateButtonInSubsubProcess is not displayed");
		save_UpdateButtonInSubsubProcess.click();

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
		processNameField.sendKeys(processName);

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
		select1.selectByVisibleText(visibleText);

		subProcessNameField.isDisplayed();
		subProcessNameField.click();
		subProcessNameField.isSelected();
		subProcessNameField.sendKeys(subProcessName);

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
		select3.selectByVisibleText(subVisibleText);

		subSubProcessNameField.isDisplayed();
		subSubProcessNameField.click();
		subSubProcessNameField.isSelected();
		subSubProcessNameField.sendKeys(subSubProcessName);

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
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(createSuceessMessage.isDisplayed(), "It is Not Displayed");
		continueButton.click();

		driver.navigate().refresh();
		Thread.sleep(2000);

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
		wait.until(ExpectedConditions.visibilityOf(updateProcessSuceessMassgage));
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
		wait.until(ExpectedConditions.visibilityOf(updateSubProcessSuceessMassgage));
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
		wait.until(ExpectedConditions.visibilityOf(updateSubSubProcessSuceessMassgage));
		Assert.assertTrue(updateSubSubProcessSuceessMassgage.isDisplayed(), "It is Not Displayed");
		continueButton.click();
	}
	// =====================================================================================================

	//Verify the user is able to do edit "Process"
	
	public void EditProcess(String processname12345) 
	{
//		WebElement DataSetup_Link = driver.findElement(By.xpath("//a[@class='d-flex align-items-center  active ']"));
//		DataSetup_Link.click();
		wait.until(ExpectedConditions.visibilityOf(editOption1));
		assertTrue(editOption1.isDisplayed(), "editOption1 is not displayed.");
		// editOption1.click();
		click(driver, editOption1);

		WebElement processExistText = driver.findElement(By.xpath("//label[text()='Process Name*']/..//input[@id='process_name']"));
		wait.until(ExpectedConditions.visibilityOf(processExistText));
		assertTrue(processExistText.isDisplayed(), "processExextText is not displayed");
		processExistText.getText();
		processExistText.clear();
		processExistText.sendKeys(processname12345);

		wait.until(ExpectedConditions.visibilityOf(processExistText));
		assertTrue(saveButton.isDisplayed(), "saveButton is not displayed.");
		saveButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(updateProcessSuceessMassgage));
		assertTrue(updateProcessSuceessMassgage.isDisplayed(), "updateProcessSuceessMassgage is not displayed");
		
		assertTrue(continueButton.isDisplayed(), "continueButton");
		continueButton.click();
		
		
	}
	
	//Verify the user is able to do edit "Sub-Process"
	
	public void EditSubProcess(String SubprocessName,String subProcessDescription) 
	{
		assertTrue(editOption1.isDisplayed(), "editOption1 is not displayed");
		wait.until(ExpectedConditions.visibilityOf(editOption1));
		editOption1.click();
	
		wait.until(ExpectedConditions.visibilityOf(processExistText));
		assertTrue(processExistText.isDisplayed(), " processExistText is not displayed");
		processExistText.getText();
		
		assertTrue(subProcessTab.isDisplayed(), "subProcessTab is not displayed");
		subProcessTab.click();
		
		wait.until(ExpectedConditions.visibilityOf(selectProcessDropDown));
		assertTrue(selectProcessDropDown.isDisplayed(), "selectProcessDropDown is not displayed");
		
		 // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("process_dropdown"));

        // Initialize the Select class with the dropdown WebElement
        Select dropdown = new Select(dropdownElement);

        // Get all options from the dropdown
        List<WebElement> options = dropdown.getOptions();

        // Create an instance of Random class
        Random random = new Random();

        // Generate a random index based on the number of options
        int randomIndex = random.nextInt(options.size());

        // Select the option at the random index
        dropdown.selectByIndex(randomIndex);

        // Optional: Print the selected option text to verify
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());
        
      assertTrue(subProcessNameField.isDisplayed(), "subProcessNameField is not displyaed");
      subProcessNameField.clear();                                                              //modify 
      subProcessNameField.sendKeys(SubprocessName);
        
        assertTrue(subProcessDescField.isDisplayed(), "subProcessDescField is not displayed");
        //subProcessDescField.clear();                                                           //modify 
        subProcessDescField.sendKeys(subProcessDescription);
        
        assertTrue(saveButtonInSubProcess.isDisplayed(), "saveButtonInSubProcess is not displayed ");
        saveButtonInSubProcess.click();
        
//        assertTrue(updateSubProcessSuceessMassgage.isDisplayed(), "updateSubProcessSuceessMassgage is not displayed");    // Modify Needed
//        assertTrue(continueButton.isDisplayed(), "continueButton.is not displayed");
//        continueButton.click();
        wait.until(ExpectedConditions.visibilityOf(createSuceessMessage));
        assertTrue(createSuceessMessage.isDisplayed(), "createSuceessMessage is not displayed");
     
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        assertTrue(continueButton.isDisplayed(), "continueButton.is not displayed");
      continueButton.click();
        
    }
	
	//Verify the user is able to do edit "Sub sub-Process"
	
	public void EditSubsubProcess(String SubsubprocessNameField, String SubSubprocessDescfield) 
	{
		assertTrue(editOption1.isDisplayed(), "editOption1 is not displayed");
		editOption1.click();
		
		wait.until(ExpectedConditions.visibilityOf(subSubProcessTab));
		assertTrue(subSubProcessTab.isDisplayed(), "subSubProcessTab");
		subSubProcessTab.click();
		
		assertTrue(subProcessDropDown.isDisplayed(), "subProcessDropDown is not displayed");
		 // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("sub_process_dropdown"));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Get all options in the dropdown
        List<WebElement> options = dropdown.getOptions();

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());

        // Select a random option
        dropdown.selectByIndex(randomIndex);

        // Print the selected option's text (optional)
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());
        
        assertTrue(subSubProcessNameField.isDisplayed(), "subSubProcessNameField is not displayed");
        //subSubProcessNameField.clear();
        subSubProcessNameField.sendKeys(SubsubprocessNameField);
        
        assertTrue(subSubProcessDescField.isDisplayed(), "subSubProcessDescField is not displayed");
       // subSubProcessDescField.clear();                                                //Modify
        subSubProcessDescField.sendKeys(SubSubprocessDescfield);
        
        assertTrue(save_UpdateButtonInSubsubProcess.isDisplayed(), "save_UpdateButtonInSubsubProcess is not displayed");
        save_UpdateButtonInSubsubProcess.click();
        
//        assertTrue(updateSubSubProcessSuceessMassgage.isDisplayed(), "updateSubSubProcessSuceessMassgage is not displayed");
//        assertTrue(continueButton.isDisplayed(), "continueButton is not displayed");
//        continueButton.click();                                                         //Modify
        
       assertTrue(save_UpdateButtonInSubsubProcess.isDisplayed(), "save_UpdateButtonInSubsubProcess is not displayed"); 
       save_UpdateButtonInSubsubProcess.click();
       
       wait.until(ExpectedConditions.visibilityOf(createSuceessMessage));
       assertTrue(createSuceessMessage.isDisplayed(), "createSuceessMessage is not displayed");
       
       wait.until(ExpectedConditions.visibilityOf(continueButton));
       assertTrue(continueButton.isDisplayed(), "continueButton is not displayed");
        continueButton.click();
	}
	

//	process table page

	public void tablePage() throws Throwable {

		String searchText = fetchCreatedRecord.getText();

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
	// ===========================================================================================

	// verify user is able to search process

	public void TablePage1() {
		assertTrue(searchBar.isDisplayed(), "searchBar is not displayed");
		searchBar.sendKeys("dfgdgdf");

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		searchButton.click();
	}

	// verify the user is able to clear filter

	public void clearfilter_tablePage() {

		assertTrue(searchBar.isDisplayed(), "searchBar is not displayed");
		searchBar.sendKeys("dfgdgdf");

		assertTrue(clearButton.isDisplayed(), "clearButton is not displayed");
		clearButton.click();

		if (driver.getCurrentUrl().equals("https://pkt-test.transmonqa.in/en/data_management/process/")) {
			System.out.println(driver.getCurrentUrl()
					+ "pass:Search Textfil is cleared and all created process is displayed in project Management page");
		}

		else {
			System.out.println(driver.getCurrentUrl()
					+ "Fail:Search Textfil is not cleared and all created process not in displayed in project Management page");
		}

	}

//Create ProcessSetUp  ==Pending

	// public void ProcessSetup()
//	{
//	 //verify the user is able to click on process setup and save
//		
//		WebElement ProcessSetup=driver.findElement(By.id("createProcessSetup"));
//		assertTrue(ProcessSetup.isDisplayed(), "ProcessSetup is not displayed"); //processSetup element
//		ProcessSetup.click();
//		
//		WebElement processSetupText=driver.findElement(By.id("//h5[@id='addModalLabel']"));
//		assertTrue(processSetupText.isDisplayed(), "processSetupText is not displayed ");
//		processSetupText.getText();
//		
//		WebElement processSetup_SaveButton=driver.findElement(By.id("saveButton"));
//		assertTrue(processSetup_SaveButton.isDisplayed(), "processSetup_SaveButton is not displayed");
//		processSetup_SaveButton.click();
//	}

	// verify the user is able to click on created process dropdown to access the
	// sub list

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
		assertTrue(TotalProcess.isDisplayed(), "TotalProcess is not displayed");
		TotalProcess.getText();
		System.out.println(TotalProcess.getText());

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
	// active Status
	public void SearchCreatedProcesbySelctingStatus_Active() {
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
		driver.getCurrentUrl();
		click(driver, LeftnavigationButton_table);

		if (driver.getCurrentUrl().equals(driver.getCurrentUrl())) {
			System.out.println("Sucessfully landed in next page");
		} else {
			System.out.println("It is not landed in next page");
		}

		assertTrue(showing_pageniation.isDisplayed(), "showing_pageniation is not displayed");
		showing_pageniation.getText();
		System.out.println(showing_pageniation.getText() + "Showing pagination");

	}

}
