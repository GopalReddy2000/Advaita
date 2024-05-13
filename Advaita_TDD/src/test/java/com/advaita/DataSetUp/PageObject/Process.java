package com.advaita.DataSetUp.PageObject;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;

public class Process extends TestBase {

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

	@FindBy(id = "process_dropdown")
	public static WebElement selectProcessDropDown;

	@FindBy(id = "sub_process_name")
	public static WebElement subProcessField;

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
	public static WebElement save_UpdateButtonInSubProcess;

	@FindBy(xpath = "//span[@id='change_msg'][text()='Process has been created']")
	public static WebElement createSuceessMassgage;

	@FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
	public static WebElement continueButton;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//img[@alt='table_drop_down']")
	public static WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td[1]//img[@alt='table_drop_down']")
	public static WebElement dropDown2;

	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public static WebElement editOption1;

	@FindBy(xpath = "(//img[@alt='table-edit'])[2]")
	public static WebElement editOption2;

	@FindBy(xpath = "(//img[@alt='table-edit'])[3]")
	public static WebElement editOption3;

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

	@FindBy(id = "s_sub_process")
	public static WebElement subSubProcessDropDown;

	public Process() {
		PageFactory.initElements(driver, this);
	}

	public void createProcess(String processName, String processDesc, String visibleText, String subProcessName,
			String subProcessDesc, String subVisibleText, String subSubProcessName, String subSubProcessDesc)
			throws Throwable {

		String beforeCreateRecords = driver.findElement(By.xpath("(//span[@class='d-block text_default font_12'])[1]"))
				.getText();
		System.out.println("beforeCreateRecords : " + beforeCreateRecords);

		int beforeCreateRecord = extractNumber(beforeCreateRecords);
		int beforeNumber = extractNumber(beforeCreateRecords)+1;
//		System.out.println(String.format("beforeNumber (%d + 1) : %s", beforeCreateRecord, beforeNumber));
		System.out.println("beforeNumber"+"("+beforeCreateRecord+"+1"+") :"+ beforeNumber);

		assertTrue(processTab.isDisplayed() && dataSetTab.isDisplayed() && metadataTab.isDisplayed() && datauploadTab.isDisplayed(), "tabs are not displayed.");

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

		subProcessField.isDisplayed();
		subProcessField.click();
		subProcessField.isSelected();
		subProcessField.sendKeys(subProcessName);

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

		save_UpdateButtonInSubProcess.isDisplayed();
		save_UpdateButtonInSubProcess.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(createSuceessMassgage.isDisplayed(), "It is Not Displayed");
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
	
	

	public void editCreatedProcess(String editProcessDesc, String editSubProcessDesc, String editSubSubProcessDesc)
			throws Throwable {

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

	public void tablePage(int pageNumber) throws Throwable {

		String searchText = fetchCreatedRecord.getText();

		searchBar.clear();
		searchBar.sendKeys(searchText);
		searchButton.click();
		Thread.sleep(2000);
		clearButton.click();

		js = (JavascriptExecutor) driver;

		// Click a specific page by its number
		WebElement pageLink = driver.findElement(By.cssSelector(
				".pagination_nav .pagination .page-item:not(.disabled) a[href*='?page=" + pageNumber + "']"));
		js.executeScript("arguments[0].scrollIntoView(true);", pageLink);
		js.executeScript("arguments[0].click();", pageLink);

		for (int i = 1; i <= 6; i++) {
			WebElement nextPageLink = driver
					.findElement(By.cssSelector(".pagination_nav .pagination .page-item:last-child a"));
			js.executeScript("arguments[0].scrollIntoView(true);", nextPageLink);
			js.executeScript("arguments[0].click();", nextPageLink);

		}

		for (int j = 1; j <= 5; j++) {
			// Click the previous page link
			WebElement previousPageLink = driver
					.findElement(By.cssSelector(".pagination_nav .pagination .page-item:first-child a"));
			js.executeScript("arguments[0].scrollIntoView(true);", previousPageLink);
			js.executeScript("arguments[0].click();", previousPageLink);
		}

	}

}
