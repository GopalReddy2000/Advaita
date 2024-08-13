package com.advaita.pageObjects;

import com.advaita.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StagesActions extends TestBase{
	public StagesActions()
	{
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//span[text()='Workflow Design']")
	WebElement workFlowDesign;

	@FindBy(xpath="//button[text()='Stages']")
	WebElement stagesTab;

	@FindBy(xpath="//img[@title='Evaluation Fields']")
	public static WebElement stageEvaluationFields;

	@FindBy(xpath="//input[@name='q']")
	public static WebElement evaluationMultiSearch;

	@FindBy(xpath="//select[@id='multiselect']")
	public static WebElement fromMultiSelectDropdown;

	@FindBy(xpath="//select[@id='multiselect_to']")
	public static WebElement toMultiSelectDropdown;

	@FindBy(xpath="//button[@id='multiselect_rightAll']")
	WebElement allRightButton;

	@FindBy(xpath="//button[@id='multiselect_rightSelected']")
	WebElement singleRightButton;

	@FindBy(xpath="//button[contains(@id,'rightSelected')]")
	List<WebElement> SingleRightButton;

	@FindBy(xpath="//button[@id='multiselect_leftSelected']")
	WebElement singleLeftButton;

	@FindBy(xpath="//button[contains(@id,'leftAll')]")
	List<WebElement> allLeftButton;

	@FindBy(xpath="//button[@id='moveUp']")
	WebElement moveUp;

	@FindBy(id="moveDown")
	WebElement moveDown;

	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
@FindBy(xpath="//button[@onClick='add_stagewise_disposition()']")
	WebElement dispositionSetSave;

	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancel;


	@FindBy(xpath="//img[@title='Stage History Fields']")
	WebElement stageHistoryFields;

	@FindBy(xpath="//img[@title='Evulation Filter']")
	WebElement stageEvaluationFilter;

	@FindBy(xpath="//img[@title='Disposition']")
	WebElement stageDispositionAction;

	@FindBy(xpath="//img[@title='SOP']")
	WebElement stageSOP;

	@FindBy(xpath="//img[@title='Report Fields']")
	WebElement stageReportsFields;

	@FindBy(xpath="//img[@title='Schduler Filters']")
	WebElement stageSchedulerFilters;

	@FindBy(xpath="//img[@title='Stage Process Fields']")
	WebElement stageProcesFields;

	@FindBy(xpath="//img[@title='Report Filters']")
	WebElement stageReportFilters;

	@FindBy(xpath="//img[@title='Assign To Filter']")
	WebElement stageAssignToFilters;

	@FindBy(xpath="//label[not(@class='drag-drop ')]")
	WebElement SOPName;

	@FindBy(linkText="Call Log Tab View")
	WebElement callLogTabView;

	@FindBy(xpath ="//button[contains(normalize-space(), 'Insurance Stage')]")
	WebElement insuranceStage;

	@FindBy(xpath ="//thead//tr/th")
	List<WebElement> evaluationFieldHeader;

	@FindBy(xpath ="//thead[@class='orga_thead tabke_static']//th")
	List<WebElement> stageHistoryFieldHeader;

	@FindBy(xpath ="//td//img[@alt='table-edit']")
	List<WebElement> recordEyeButton;

	@FindBy(xpath ="//h6[text()='Stage History']")
	WebElement stageHistorySection;

	@FindBy(xpath ="//select[@id='unique_multiselect']")
	WebElement datePickerDropdown;

	@FindBy(xpath ="//select[@id='date_range_picker']")
	WebElement dateRangerDropdown;

	@FindBy(xpath ="//select[@id='muti_unique_multiselect']")
	WebElement multiSelectDropdown;

	@FindBy(xpath ="//select[@id='textbox_multiselect']")
	WebElement textBoxDropdown;

	@FindBy(xpath ="//select[@id='value_range_picker']")
	WebElement valueRangeDropdown;

	@FindBy(xpath ="//h6[text()='Local Filters']")
	WebElement localFilterSection;

	@FindBy(xpath ="//div[contains(@class,'local_filter_section')]//label")
	List<WebElement> localFilterHeaders;

	@FindBy(id ="sopDocu")
	WebElement sopDocUpload;

	@FindBy(xpath ="//h6[text()='SOP Documents']")
	WebElement SOPDocumentSection;

	@FindBy(xpath ="(//tbody)[1]//td[1]")
	List<WebElement> SOPRecords;

	@FindBy(linkText ="Validation Status Report")
	WebElement validationStatusReport;

	@FindBy(xpath ="//select[@id='process_search']")
	WebElement processField;

	@FindBy(xpath ="//select[@id='sub_process_search']")
	WebElement subProcessField;

	@FindBy(xpath ="//select[@id='s_sub_process_search']")
	WebElement subSubProcessField;

	@FindBy(xpath ="//select[@id='stage_search']")
	WebElement stageSearch;

	@FindBy(xpath ="//select[@id='disposition_stagewise']")
	WebElement dispositionDropdown;

	@FindBy(xpath ="//input[@name='from_date']")
	WebElement fromDate;

	@FindBy(xpath ="//input[@name='to_date']")
	WebElement toDate;

	@FindBy(xpath ="//img[@alt='filter_search' and @class='img-fluid']")
	WebElement searchButton;

	@FindBy(xpath ="//tr//th")
	List<WebElement> validationStatusReportHeaders;

	@FindBy(xpath ="//table[@id='interaction-history']//th//span[1]")
	List<WebElement> interactionFieldsHeader;

	@FindBy(xpath ="//button[text()='Interaction History']")
	WebElement interactionHistory;

	@FindBy(xpath ="//td[3]")
	WebElement dispositionQuestionSet;

	@FindBy(xpath ="//select[@id='stage_name_deposion']")
	WebElement dispositionStage;

	@FindBy(xpath ="//select[@id='assigned_to']")
	WebElement assignTo;

	@FindBy(xpath ="//div[@class='disposition_question_section row']//label")
	List<WebElement> dispositionQuestions;







	public StagesActions navtoStages()
	{
		workFlowDesign.click();
		stagesTab.click();
		return this;
	}

	public StagesActions clickOnStageHistoryField(String recordName,String ActionButton)
	{
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (recordName.equals(usernameColumn.getText()) ) {

				WebElement button = row.findElement(By.xpath(".//img[@title='"+ActionButton+"']"));
				button.click();

				System.out.println(recordName+" Successfully Clicked");

//				Assert.assertTrue(driver.getTitle().contains(ActionButton)); ;

				break;
			}
		}
		return this;
	}

	private void printOptions(WebElement element)
	{
		Select select=new Select(element);
		for(WebElement elemnt:select.getOptions())
		{
			System.out.println(elemnt.getText());
		}


	}

	private void selectOptionsInMultiSelect(WebElement element,List<String> options )
	{
		allLeftButton.get(0).click();
		Select select=new Select(element);
		for(String option:options)
		{
			select.selectByVisibleText(option);
			singleRightButton.click();
		}
		singleRightButton.click();
	}


	List<String> evaluationFieldOptions = List.of(
			"Name Of the Customer",
			"Place of Living",
			"Phone Number",
			"Email ID",
			"Is Primary",
			"Trans Unique Id"
	);


	public StagesActions escalationFields()
	{
		allLeftButton.get(0).click();
		selectOptionsInMultiSelect(fromMultiSelectDropdown,evaluationFieldOptions);
//		singleRightButton.click();
		saveRecord();

		navigateWithinAlchemy(callLogTabView);
		insuranceStage.click();

		int startIndex = 4;
		for (int i = 0; i < evaluationFieldOptions.size(); i++) {
			String actualHeader =evaluationFieldHeader.get(startIndex +i).getText().trim();
			System.out.println(actualHeader);
			Assert.assertEquals(evaluationFieldOptions.get(i), actualHeader);
			if (!actualHeader.equals(evaluationFieldOptions.get(i))) {
				System.out.println("Header mismatch: Expected - " + evaluationFieldOptions.get(i) + ", but found - " + actualHeader);
			} else {
				System.out.println("Header matched: " + actualHeader);
			}
		}
		return this;
	}

	public StagesActions stageHistoryFields()
	{
		allLeftButton.get(0).click();
		// evaluationFieldOptions and stageHistoryOptions Field Options are same.
		selectOptionsInMultiSelect(fromMultiSelectDropdown,evaluationFieldOptions);
//		singleRightButton.click();

		saveRecord();

		navigateWithinAlchemy(callLogTabView);
		insuranceStage.click();
//		unWait(1);
		recordEyeButton.get(0).click();

		js.executeScript("window.scrollTo(0, 1500);");

		try{
			stageHistoryFieldHeader.get(0).getText();
		}catch (NoSuchElementException e)
		{
			jsClick(driver,stageHistorySection);
		}
		for (int i = 0; i < evaluationFieldOptions.size(); i++) {
			String actualHeader =evaluationFieldHeader.get(i).getText().trim();
			System.out.println(actualHeader);
			softAssert.assertEquals(evaluationFieldOptions.get(i), actualHeader);
			if (!actualHeader.equals(evaluationFieldOptions.get(i))) {
				System.out.println("Header mismatch: Expected - " + evaluationFieldOptions.get(i) + ", but found - " + actualHeader);
			} else {
				System.out.println("Header matched: " + actualHeader);
			}
			softAssert.assertAll();
		}
		return this;
	}


	public void selectAndClickOptions( List<WebElement> dropdowns, List<String> options, List<WebElement> buttons) {
		for (int i = 0; i < options.size(); i++) {
			jsClick(driver,allLeftButton.get(i));

			selectOptionsInMultiSelect(dropdowns.get(i), options.get(i));
			jsClick(driver, buttons.get(i));
			System.out.println(options.get(i));
		}
	}

	private void selectOptionsInMultiSelect(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}



	public StagesActions evaluationFilter()
	{
		selectAndClickOptions(
				Arrays.asList(fromMultiSelectDropdown,
						datePickerDropdown,
						dateRangerDropdown,
						multiSelectDropdown,
						textBoxDropdown,
						valueRangeDropdown),
				evaluationFieldOptions,
				SingleRightButton);

		saveRecord();

		navigateWithinAlchemy(callLogTabView);
		insuranceStage.click();
		localFilterSection.click();
		List<String> actual = List.of();
		for (int i = 0; i < evaluationFieldOptions.size(); i++) {
			String actualHeader =localFilterHeaders.get(i).getText().trim();
			System.out.println(actualHeader);
			if (!actualHeader.equals(evaluationFieldOptions.get(i))) {
				System.out.println("Header mismatch: Expected - " + evaluationFieldOptions.get(i) + ", but found - " + actualHeader);
			} else {
				System.out.println("Header matched: " + actualHeader);
			}

		}
		softAssert.assertTrue(evaluationFieldOptions.containsAll(actual) );
		softAssert.assertAll();
		return this;
	}

	public StagesActions Sop()
	{
		sopDocUpload.sendKeys("C:/Users/W2390/IdeaProjects/Advaita/Advaita_TDD/SOPDocs/Newsletter.pdf");
		saveRecord();
		String uploadedSOP=SOPRecords.get(0).getText();
		backButton.click();

		navigateWithinAlchemy(callLogTabView);
		insuranceStage.click();
		recordEyeButton.get(0).click();

		jsClick(driver,SOPDocumentSection);
		assert (SOPRecords.get(0).getText().equals(uploadedSOP));


		return this;
	}


	public StagesActions SOPDelete(String recordName)
	{
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (recordName.equals(usernameColumn.getText()) ) {

				WebElement button = row.findElement(By.cssSelector("img.delete_stages_sop"));
				button.click();

				System.out.println(recordName+" Successfully Clicked");

				break;
			}
		}
		backButton.click();
		navigateWithinAlchemy(callLogTabView);
		insuranceStage.click();
		recordEyeButton.get(0).click();
		Assert.assertFalse(SOPRecords.contains(recordName),"Record still exists!");;

		return this;
	}



//	Write Code for SOP Delete

	List<String> reportFieldsOptions = Arrays.asList(
			"Name Of the Customer",
			"Phone Number",
			"tansUniqueId",
			"AuditScore",
			"ScoredValue",
			"Remarks",
			"Manager Review",
			"Trans Unique Id"
	);

	public StagesActions reportFields()
	{
		selectOptionsInMultiSelect(fromMultiSelectDropdown,reportFieldsOptions);
		saveRecord();

		navigateWithinAlchemy(validationStatusReport);
		selectProcess();
		js.executeScript("arguments[0].value='01-08-2024';", fromDate);
		js.executeScript("arguments[0].value='08-08-2024';", toDate);
		searchButton.click();

		int startIndex = 1;
		for (int i = 0; i < reportFieldsOptions.size(); i++) {
			String actualHeader =validationStatusReportHeaders.get(startIndex+i).getText().trim();
			Assert.assertEquals(reportFieldsOptions.get(i), actualHeader);
			if (!actualHeader.equals(reportFieldsOptions.get(i))) {
				System.out.println("Header mismatch: Expected - " + reportFieldsOptions.get(i) + ", but found - " + actualHeader);
			} else {
				System.out.println("Header matched: " + actualHeader);
			}
		}

		return this;
	}
	private void selectByVisibleText(WebElement element,String toSelect)
	{
		Select select= new Select(element);
		select.selectByVisibleText(toSelect);
	}

	private void selectProcess()
	{
		selectByVisibleText(processField,"AJP");
		selectByVisibleText(subProcessField,"Sub AJP");
		selectByVisibleText(subSubProcessField,"Sub Sub AJP");
		selectByVisibleText(stageSearch,"Insurance Stage");
	}

	List<String> stageProcessFieldsList = Arrays.asList(
			"Name Of the Customer",
			"Phone Number",
			"To Stage Name",
			"stageName",
			"stageID",
			"stageTransactionId"
	);

	public StagesActions stageProcessFields()
	{

//		selectOptionsInMultiSelect(fromMultiSelectDropdown,stageProcessFieldsList);
//		saveRecord();

		navigateWithinAlchemy(callLogTabView);
		jsClick(driver,insuranceStage);
		jsClick(driver,recordEyeButton.get(recordEyeButton.size()-1));
		jsClick(driver,interactionHistory);
		unWait(1);
		List<String> actualInteractionHeaders = new ArrayList<>();
		for (int i = 0; i < stageProcessFieldsList.size(); i++) {
			Object actualHeader = js.executeScript("return arguments[0].innerText;", interactionFieldsHeader.get(i));
			String actualHeaders = (String)actualHeader;
			System.out.println(actualHeaders);
			actualInteractionHeaders.add(actualHeaders);
			if (!actualHeader.equals(stageProcessFieldsList.get(i))) {
				System.out.println("Header mismatch: Expected - " + stageProcessFieldsList.get(i) + ", but found - " + actualHeader);
			} else {
				System.out.println("Header matched: " + actualHeader);
			}

//			Text() Is not Printing
		}
		Assert.assertTrue(actualInteractionHeaders.contains(stageProcessFieldsList) );
		return this;
	}

	public StagesActions reportFilters()
	{
		selectAndClickOptions(
			Arrays.asList(fromMultiSelectDropdown,
					datePickerDropdown,
					dateRangerDropdown,
					multiSelectDropdown,
					textBoxDropdown,
					valueRangeDropdown),
			evaluationFieldOptions,
			SingleRightButton);
		saveRecord();
		navigateWithinAlchemy(validationStatusReport);
		selectProcess();
		js.executeScript("arguments[0].value='01-08-2024';", fromDate);
		js.executeScript("arguments[0].value='08-08-2024';", toDate);
		searchButton.click();
		localFilterSection.click();
		for (int i = 0; i < evaluationFieldOptions.size(); i++) {
			String actualHeader =localFilterHeaders.get(i).getText().trim();
			System.out.println(actualHeader);
			if (!actualHeader.equals(evaluationFieldOptions.get(i))) {
				System.out.println("Header mismatch: Expected - " + evaluationFieldOptions.get(i) + ", but found - " + actualHeader);
			} else {
				System.out.println("Header matched: " + actualHeader);
			}
		}

		return this;
	}

	public StagesActions disposition()
	{
		selectProcess();

		Select select=new Select(dispositionDropdown);
		select.selectByIndex(1);
		dispositionSetSave.click();
		String selectedOption=select.getFirstSelectedOption().getText();
		Assert.assertEquals(dispositionQuestionSet.getText(),selectedOption);
		backButton.click();
		navigateWithinAlchemy(callLogTabView);
		insuranceStage.click();
		recordEyeButton.get(0).click();

		selectOptionsInMultiSelect(dispositionStage,"Insurance Stage");
		selectOptionsInMultiSelect(assignTo,"Capture_admin");

		Assert.assertEquals(dispositionQuestions.get(0).getText(),"Did you verify?");

		return this;
	}




}
