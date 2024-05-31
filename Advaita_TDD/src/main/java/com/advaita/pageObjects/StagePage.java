package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.Pagination;
import com.google.common.util.concurrent.Uninterruptibles;

public class StagePage extends TestBase{

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']//parent::a")
	public WebElement workFlowDesignButton;

	@FindBy(xpath = "//button[normalize-space()='Stages']")
	public WebElement stagesTab;

	@FindBy(id = "text_search")
	public WebElement searchBox;

	@FindBy(xpath = "//img[@alt='filter_search']//parent::button")
	public WebElement searchButton;

	@FindBy(xpath = "//table//tbody//tr//td[1]")
	public WebElement stageName;

	@FindBy(id = "filter_date")
	public WebElement datePicker;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_year']")
	public WebElement yearDropdown;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_year']//div[text()='2024']")
	public WebElement year;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_month']")
	public WebElement monthDropdown;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_month']//div[text()='June']")
	public WebElement month;

	@FindBy(xpath = "//div[@class='xdsoft_calendar']//..//td//div[text()='21']")
	public WebElement day;

	@FindBy(xpath = "//h6[normalize-space()='Clear All Filters']")
	public WebElement clearAllfilter;

	@FindBy(xpath = "(//button[@class='xdsoft_prev'])[1]")
	public WebElement datePickerPrevButton;

	@FindBy(xpath = "(//button[@class='xdsoft_next'])[1]")
	public WebElement datePickerNxtButton;

	@FindBy(xpath = "//div[@class='xdsoft_label xdsoft_month']//div[contains(@class,'xdsoft_option ')]")
	public List<WebElement> listOfMonths;

	@FindBy(xpath = "(//div[@class='dataset_table']//tbody//tr//td[1]//a)")
	public List<WebElement> listOfDataSet;

	@FindBy(xpath = "//h2[normalize-space()='Refresh']")
	public WebElement refresh;

	@FindBy(xpath = "//input[@type='radio' and @id='In progress']")
	public WebElement inProgressRadioButton;

	@FindBy(xpath = "//input[@type='radio' and @id='Resolved']")
	public WebElement resolvedRadioButton;

	@FindBy(xpath = "//input[@type='radio' and @data-info='AUTO']")
	public WebElement autoRadioButton;

	@FindBy(xpath = "//input[@type='radio' and @data-info='Manual']")
	public WebElement manualRadioButton;

	@FindBy(css = ".pagination li:not(.next):not(.prev)")
	public By paginationLocator;

	@FindBy(xpath = "//img[@alt='rgt_arrow']")
	public WebElement rightArrow;

	@FindBy(xpath = "//img[@alt='left_arrow']")
	public WebElement leftArrow;

	@FindBy(xpath = "//img[@alt='delete-icon ']")
	public List<WebElement> deleteButtons;

	@FindBy(xpath="//button[normalize-space()='Delete']")
	public WebElement confirmationdeleteButton;

	@FindBy(xpath="//span[@id='change_msg']")
	public WebElement deleteSuccessMsg;

	@FindBy(xpath="(//button[normalize-space()='Continue'])[1]")
	public WebElement deleteSuccessButton;

	

	@FindBy(xpath = "//img[@title='Duplicate Stage']")
	public List<WebElement> duplicateButtons;

	@FindBy(xpath="(//button[@type='submit'])[2]")
	public WebElement duplicateYesButton;

	@FindBy(xpath="//span[@id='change_msg']")
	public WebElement duplicateSuccessConfirmMessage;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement duplicateContinueButton;
	
	@FindBy(xpath = "//img[@alt='table-edit' and @class='img-fluid stages_edit delete-dataset']")
	public List<WebElement> editButtons;
	
	@FindBy(xpath = "//input[@id='stage_name']")
	public WebElement editStageName;
	
	@FindBy(xpath = "//select[@id='process']")
	public WebElement editProcess;
	
	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement editSubProcess;
	
	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement editSubSubProcess;
	
	@FindBy(xpath = "//select[@id='calculation_type']")
	public WebElement editCalculationType;
	
	@FindBy(id = "submt_single")
	public WebElement editSave;
	
	
	@FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
	public WebElement editSuccessContinue;
	
	@FindBy(xpath = "//img[@class='arrow-left']//parent::a")
	public WebElement editBackButton;
	

	public StagePage() {
		PageFactory.initElements(driver, this);
	}


	public void CommonNavigation() {
		click(driver,workFlowDesignButton);
		click(driver,stagesTab);

	}

	public void existingStageNameWitoutDatePicker()
	{
		CommonNavigation();
		searchBox.sendKeys("In Progress");
		click(driver,searchButton);
		Assert.assertEquals(stageName.getText(),"In Progress");

	}

	public void searchOnlyWithDatePicker()
	{
		CommonNavigation();
		click(driver,datePicker);
		click(driver,yearDropdown);
		click(driver,year);
		click(driver,monthDropdown);
		click(driver,month);
		click(driver,day);
		click(driver,searchButton);
	}

	public void clearAllFilters()
	{
		CommonNavigation();
		String value=stageName.getText();
		searchBox.sendKeys("In Progress");
		click(driver,searchButton);
		String value0=stageName.getText();
		assertEquals(value0, "In Progress");
		click(driver,clearAllfilter);
		String value1=stageName.getText();
		assertEquals(value, value1);
	}

	public void pagination()
	{
		CommonNavigation();

		Pagination.paginate(driver, rightArrow, leftArrow);

	}


	public void monthsInDatePicker() {
		CommonNavigation();
		click(driver,datePicker);

		click(driver,monthDropdown); 


//		List<WebElement> monthElements=listOfMonths;

		List<String> capturedMonths = new ArrayList<>();

		for (WebElement monthElement : listOfMonths) { 
			String monthText = monthElement.getText();
			System.out.println(monthElement.getText()); 

			capturedMonths.add(monthText);
		}

		List<String> expectedMonths = List.of(
				"January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" );


		Assert.assertEquals(capturedMonths, expectedMonths,
				"The captured months should match the expected months");

	}

	public void viewingCreatedStage()
	{
		CommonNavigation();

		List<WebElement> StageNames=listOfDataSet;

		int randomIndex = ThreadLocalRandom.current().nextInt(StageNames.size());
		WebElement st=StageNames.get(randomIndex);

		wait.until(ExpectedConditions.elementToBeClickable(st));
		click(driver,st);

		assertTrue(refresh.isEnabled());

	}

	public void verifyViewRadioButtons()
	{
		CommonNavigation();

		List<WebElement> StageNames=listOfDataSet;

		int randomIndex = ThreadLocalRandom.current().nextInt(StageNames.size());

		WebElement st=StageNames.get(randomIndex);
		click(driver,st);
		js.executeScript("arguments[0].scrollIntoView(true);", manualRadioButton);
		assertTrue(!manualRadioButton.isEnabled());
		js.executeScript("arguments[0].scrollIntoView(true);", autoRadioButton);
		assertTrue(!autoRadioButton.isEnabled());

	}

	public void numberOfStagesListed()
	{
		CommonNavigation();
		System.out.println(listOfDataSet.size());
		assertEquals(listOfDataSet.size(), 10);
	}


	public void duplicateDuplicate()
	{
		CommonNavigation();
		
		String beforeRecord=driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(beforeRecord);
		
		int beforeDuplicateRecord=extractNumber(beforeRecord)+1;
		
		List<WebElement> duplicateButton=duplicateButtons;
		List<WebElement> StageNames=listOfDataSet;

		int randomIndex = ThreadLocalRandom.current().nextInt(duplicateButton.size());

		WebElement dpb=duplicateButton.get(randomIndex);
		WebElement stn=StageNames.get(randomIndex);
		click(driver, dpb);
		
		duplicateYesButton.click();
		duplicateContinueButton.click();
		
		driver.navigate().refresh();

		String afterDup= driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(afterDup);
		
		assertNotNull(afterDup);
		
		int afterDuplicateRecord=extractNumber(afterDup);
		
		assertEquals(beforeDuplicateRecord,afterDuplicateRecord);
		
	}

	public void deleteFunction()
	{
		CommonNavigation();
		
		String beforeDeleteRecord=driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(beforeDeleteRecord);
		int beforeDelRecord =extractNumber(beforeDeleteRecord)-1;
//		int beforeDeleRecord=extractNumber(beforeDeleteRecord)-1;

		List<WebElement> deleteButton=deleteButtons;
		List<WebElement> StageNames=listOfDataSet;

		int randomIndex = ThreadLocalRandom.current().nextInt(deleteButton.size());

		WebElement db=deleteButton.get(randomIndex);
		assertTrue(db.isEnabled(),"Delete Button is not Enabled"+db);

		click(driver, db);
		
		confirmationdeleteButton.click();
		deleteSuccessButton.click();
		
		driver.navigate().refresh();

		String afterDel= driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']")).getText();
		System.out.println(afterDel);
		
		assertNotNull(afterDel);
		
		int afterDupRecord =extractNumber(afterDel);
		
		assertEquals(beforeDelRecord,afterDupRecord);

	}
	
	public void editButtons()
	{
		CommonNavigation();
		List<WebElement> editButton=editButtons;

		int randomIndex = ThreadLocalRandom.current().nextInt(editButton.size());
		WebElement eb=editButton.get(randomIndex);

		assertTrue(eb.isEnabled(),"Edit Button is not Enabled"+eb);

	}
	
	public void editStageNavigation()
	{
		CommonNavigation();
		List<WebElement> editButton=editButtons;

		int randomIndex = ThreadLocalRandom.current().nextInt(editButton.size());
		WebElement eb=editButton.get(randomIndex);
		
		click(driver, eb);
		
	}
	
	public void editStageForm()
	{
		editStageNavigation();
		
		
		System.out.println(editStageName.getText());
		
//		String renaming=generateRandomAlphabeticString(5);
		editStageName.clear();
//		editStageName.sendKeys(renaming);
		
//		Selecting the process Dropdown randomly fetching from the dropdown it self;
		Select processDropdown= new Select(editProcess);
		System.out.println(processDropdown.getFirstSelectedOption().getText());
		List<WebElement>ProcessOptions= processDropdown.getOptions();
		int randomIndex = ThreadLocalRandom.current().nextInt(ProcessOptions.size());
		String processVisibleText=ProcessOptions.get(randomIndex).getText();
		
		processDropdown.selectByVisibleText(processVisibleText);
		System.out.println(processDropdown.getFirstSelectedOption().getText());
		
//		Selecting Sub Process from Process
		Select subProcessDropdown= new Select(editSubProcess);
		System.out.println(subProcessDropdown.getFirstSelectedOption().getText());
		subProcessDropdown.selectByIndex(1);
		System.out.println(subProcessDropdown.getFirstSelectedOption().getText());
		
//		Selecting Sub Sub Process from Process
		Select subSubProcessDropdown= new Select(editSubSubProcess);
		System.out.println(subSubProcessDropdown.getFirstSelectedOption().getText());
		
		subSubProcessDropdown.selectByIndex(1);
		System.out.println(subSubProcessDropdown.getFirstSelectedOption().getText());
		
		
		Select calculation= new Select( editCalculationType);
		List<WebElement> calOptions=calculation.getOptions();
		
		List<String> ActualStrings=new ArrayList<>();
		for(WebElement options:calOptions)
		{
			String text=options.getText();
			System.out.println(
			options.getText());
			ActualStrings.add(text);
			
			
		}
		List<String> expectedStrings = List.of("Question Wise","Parameter Wise","Domain Wise");
		
		Assert.assertEquals(expectedStrings, ActualStrings);
		
		editSave.click();
		
		editSuccessContinue.click();
		
		click(driver, editBackButton);
		
//		assertEquals(stageName.getText(), renaming);
		
		
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


}
