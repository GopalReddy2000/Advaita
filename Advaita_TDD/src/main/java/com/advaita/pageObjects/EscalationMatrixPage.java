package com.advaita.pageObjects;

import static Advaita_TDD.Advaita_TDD.FakeData.lastName2;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.advaita.BaseClass.TestBase;

public class EscalationMatrixPage extends TestBase {
	private static final Logger log = LoggerFactory.getLogger(EscalationMatrixPage.class);

	public EscalationMatrixPage(){
		PageFactory.initElements(driver,this);

	}

	@FindBy(linkText="Escalation Metrics")
	public WebElement escalationMatrixPage;

	@FindBy(id="menulist2")
	WebElement alchemy;

	@FindBy(id="text_search")
	WebElement searchBox;

	@FindBy(id="status_search")
	WebElement statusDrp;

	@FindBy(xpath="//button//img[@alt='filter_search']")
	WebElement searchIcon;

	@FindBy(xpath="//h6[text()='Clear All Filters']")
	WebElement clearAllFilter;

	@FindBy(xpath="//span[text()='AJP']")
	WebElement AJPProcess;

	@FindBy(xpath="//span[text()='Sub AJP']")
	WebElement subAJPProcess;

	@FindBy(xpath="(//span[text()='Sub Sub AJP'])[1]")
	WebElement subSubAJPProcess;

	@FindBy(xpath="//tr[@class='collpase_tr main_sub_cat_tr sub_sub_ctr border_none active']//tr")
	List<WebElement> subSubProcessTable;

	@FindBy(xpath="//select[contains(@id,'level')]")
	List<WebElement> level1Drp;

	@FindBy(xpath="//select[contains(@id,'role_select') and not(contains(@id,'to_role_select'))]")
	List<WebElement> fromRole;

	@FindBy(xpath="//select[contains(@id,'question')]")
	List<WebElement> questionID;

	@FindBy(xpath="//select[contains(@id,'decision_option')]")
	List <WebElement> decisionOption;

	@FindBy(xpath="//select[contains(@id,'to_role')]")
	List<WebElement> toRole;

	@FindBy(xpath="//select[contains(@id,'to_stage')]")
	List<WebElement> toStage;

	@FindBy(xpath="//span[@class='slider round']")
	List<WebElement> statusToggleButton;

	@FindBy(linkText ="+ Add Row")
	WebElement addRow;

	@FindBy(xpath ="//button[text()='Save']")
	WebElement save;

	@FindBy(xpath ="//button[text()='Cancel']")
	WebElement cancel;

	@FindBy(xpath ="//span[contains(@id,'status')]")
	WebElement statusCondition;

	@FindBy(linkText  ="Agency Validation")
	public WebElement agencyValidaion;

	@FindBy(xpath  ="//select[@id='stage_search']")
	WebElement stageSearch;

	@FindBy(xpath  ="//img[@class='img-fluid' and @alt='filter_search']")
	WebElement stageSearchIcon;

	@FindBy(xpath  ="//td//img[@alt='table-edit']")
	List<WebElement> recordEyeButton;
//
//	@FindBy(id  ="select2-current_Sec_id-container")
//	WebElement reviewDropdown;

	@FindBy(xpath  ="//ul[@id='select2-current_Sec_id-results']//li")
	List<WebElement> reviewDropdownList;

	@FindBy(xpath  ="//select[@id='current_Sec_id']")
	WebElement reviewDropDown;


	@FindBy(xpath  ="//div//textarea")
	WebElement escaltionTextArea;

	@FindBy(xpath  ="(//button[text()='Continue'])[1]")
	WebElement continueButton;

	@FindBy(linkText  ="Validation Status Report")
	WebElement validationStatusReport;

	@FindBy(xpath  ="//select[@id='process_search']")
	WebElement processSearch;

	@FindBy(xpath  ="//select[@id='sub_process_search']")
	WebElement subProcessSearch;

	@FindBy(xpath  ="//select[@id='s_sub_process_search']")
	WebElement subSubProcessSearch;

	@FindBy(xpath  ="//input[@name='from_date']")
	WebElement fromDate;

	@FindBy(xpath  ="//input[@name='to_date']")
	WebElement toDate;

	@FindBy(linkText ="Call Log Tab View")
	WebElement callLogTabView;

	@FindBy(linkText ="Call Log Stage View")
	WebElement callLogStageView;

	@FindBy(xpath ="//button[contains(normalize-space(), 'Insurance Stage')]")
	WebElement insuranceStage;

	@FindBy(xpath ="//tbody//td[1]//img")
	WebElement eyeButton;

	@FindBy(xpath ="//tbody//td[8]")
	WebElement custEmail;

	@FindBy(xpath ="//label[text()='Remarks ']/following-sibling::textarea")
	WebElement escalateInputField;

	@FindBy(css  ="img.arrow-left")
	WebElement backButton;

	@FindBy(linkText  ="Rejected Audit Form")
	WebElement rejectAuditForm;

	@FindBy(xpath  ="//select[@id='page-size-select']")
	WebElement itemsPerPage;

	@FindBy(xpath = "(//button[text()='Question'])[2]")
	WebElement questionTab;

	@FindBy(xpath = "//label[text()='Review remarks ']/following-sibling::textarea")
	WebElement	reviewRemarksInput;

	@FindBy(xpath = "//label[text()='Email ID ']/following-sibling::input")
	WebElement emailID;

	@FindBy(xpath = "//select[@id='stage_name_deposion']")
	WebElement stageNameDispositionDropdown;

	@FindBy(xpath = "//select[@id='assigned_to']")
	WebElement assignToDropdown;

	//	-------------------Master-----------
	@FindBy(id  ="menulist3")
	WebElement mastersMenu;

	@FindBy(linkText  ="View/Modify Insurance")
	WebElement viewModifyInsurance;

	@FindBy(xpath  ="//img[@title='View Assignees']")
	WebElement viewAssigness;

	@FindBy(xpath  ="//button[text()='Assign']")
	WebElement assignButton;

	@FindBy(xpath  ="//td[normalize-space()='No Entries Found']")
	WebElement noEntriesFound;


	@FindBy(xpath  ="//h6[text()='Local Filters']")
	WebElement localFilters;

	@FindBy(xpath  ="//div[@id='collapseOne']//input[@placeholder='DD-MM-YYYY']")
	List<WebElement> datePickers;

	@FindBy(linkText ="Rejected Audit Form")
	WebElement rejectedAuditForm;


//	*********TransAction Report*****************


	@FindBy(linkText = "Transaction Report")
	public static WebElement transActionReport;

	@FindBy(xpath = "//select[@name='Audit_Created_By']")
	public static WebElement auditCreatedByFilter;

	@FindBy(xpath = "//select[@name='Email ID']")
	public static WebElement emailIdFilter;

	@FindBy(xpath = "//select[@name='Name']")
	public static WebElement nameFilter;

	@FindBy(xpath = "//select[@name='Review Status']")
	public static WebElement reviewStatusFilter;


	String customerEmail;
	String nameOfTheCustomer;
	String phoneNumber;

	List<String> levels = List.of(
			"--Select--", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20"
	);

	List<String> roles = List.of(
			"--Select--",
			"Admin",
			"Agent",
			"CE Head",
			"Complaint Desk",
			"CRC Admin",
			"Drivingschool",
			"DSE",
			"Insurance",
			"QA",
			"Sales",
			"Service",
			"Team Lead",
			"Usedcar",
			"View",
			"View 2",
			"View Alchemy"
	);

	List<String> QuestionID = List.of(
			"--Select--","Manager Review"
	);

	List<String> DecisionOption = List.of(
			"--Select--",
			"Accept",
			"Reject"
	);

	List<String> ToRole = List.of(

			"Admin",
			"Agent",
			"CE Head",
			"Complaint Desk",
			"CRC Admin",
			"Drivingschool",
			"DSE",
			"Insurance",
			"QA",
			"Sales",
			"Service",
			"Team Lead",
			"Usedcar",
			"View",
			"View 2",
			"View Alchemy",
			"End"
	);

	List<String> ToStage = List.of(
			"-",
			"Agency Validation",
			"Rejected Audit Form"
	);

	public static void selectDate(WebDriver driver, int day, int year, String month) {
		// Click on the date picker trigger to open the date picker
		/*WebElement datePickerTrigger = driver.findElement(By.id("id_of_datepicker_trigger_element"));
		datePickerTrigger.click();*/

		// Click on the year label to open the year selector
		WebElement yearLabel = driver.findElement(By.cssSelector("div.xdsoft_label.xdsoft_year"));
		unWait(1);
		yearLabel.click();

		// Select the desired year
		WebElement yearOption = driver.findElement(By.cssSelector("div.xdsoft_option[data-value='" + year + "']"));
		unWait(1);
		yearOption.click();

		// Click on the month label to open the month selector
		WebElement monthLabel = driver.findElement(By.cssSelector("div.xdsoft_label.xdsoft_month"));
		unWait(1);
		monthLabel.click();

		// Select the desired month
		WebElement monthOption = driver.findElement(By.xpath("//div[contains(@class, 'xdsoft_option') and text()='" + month + "']"));
		unWait(1);
		monthOption.click();

		// Select the desired date (day)
		WebElement dateOption = driver.findElement(By.cssSelector("div.xdsoft_option[data-value='"+day+"']"));
		unWait(1);
		dateOption.click();
	}


	//	public void selectByVisibleText(WebElement select,String Value)
//	{
//		Select subSubProcessDrp=new Select(select);
//		subSubProcessDrp.selectByVisibleText(Value);
//
//	}
	public void selectByVisibleTextMulti(WebElement dropdown,String Value)
	{
		Select select=new Select(dropdown);
		select.deselectAll();
		select.selectByVisibleText(Value);

	}

	public EscalationMatrixPage dropdownUtil(WebElement dropdownElement,List<String> expectedOptions)
	{
		Select dropdown=new Select(dropdownElement);
		assertTrue(!dropdown.isMultiple());
		try {
			List<WebElement> options = dropdown.getOptions();

			// Check if options list is empty or contains only one placeholder option
			if (options.isEmpty() || (options.size() == 1 && options.get(0).getText().isEmpty())) {
				throw new AssertionError("Dropdown is empty or contains only a placeholder option.");
			} else {
				System.out.println("Dropdown contains options.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Error validating dropdown options.", e);
		}

		//		Verify the dropdown contains the expected options.

		try {
			// Get all options from the dropdown
			List<WebElement> options = dropdown.getOptions();

			// Create a list to hold the actual options text
			List<String> actualOptions = new ArrayList<>();
			for (WebElement option : options) {
				actualOptions.add(option.getText());
			}

			// Check if each expected option is present in the actual options

			for (String expectedOption : expectedOptions) {
				if (!actualOptions.contains(expectedOption)) {
					throw new AssertionError("Dropdown does not contain expected option: " + expectedOption);
				}
			}

			System.out.println("Dropdown contains all expected options.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Error validating dropdown options.", e);
		}

		return this;
	}

	public EscalationMatrixPage navigationToEscalationTablePage()
	{
		try {
			jsClick(escalationMatrixPage);
		}catch (Exception e) {

			jsClick(alchemy);
			jsClick(escalationMatrixPage);
		}

		return this;
	}

	public EscalationMatrixPage table(String nameToDelete)
	{

		jsClick(AJPProcess);
		jsClick(subAJPProcess);
		jsClick(subSubAJPProcess);
		//		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : subSubProcessTable) {
			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameColumn.getText().equals(nameToDelete)) {
				try {
					WebElement process = row.findElement(By.xpath(".//td//img[@alt='table-edit']"));
					jsClick(process);

					System.out.println(nameToDelete + " Successfully Clicked");
				} catch (Exception e) {
					System.out.println("Failed to delete the record: " + e.getMessage());
				}
				break;

			}

		}
		return this;
	}


	public EscalationMatrixPage escalationCreation() {
		unWait(1);
		fillEscalationDetails(0, "1", "Agent", "Manager Review", "--Select--", "Team Lead", "Agency Validation");

		handleEscalationDetails(1, "2", "Team Lead", "Manager Review", "Accept", "End", "-");
		handleEscalationDetails(2, "2", "Team Lead", "Manager Review", "Reject", "Agent", "Rejected Audit Form");

		return this;
	}


	private void fillEscalationDetails(int index, String level, String fromRoleText, String questionIDText, String decisionOptionText, String toRoleText, String toStageText) {
		selectByVisibleText(level1Drp.get(index), level);
		selectByVisibleText(fromRole.get(index), fromRoleText);
		selectByVisibleText(questionID.get(index), questionIDText);
		selectByVisibleText(decisionOption.get(index), decisionOptionText);
		selectByVisibleTextMulti(toRole.get(index), toRoleText);
		selectByVisibleText(toStage.get(index), toStageText);
		toggleStatus("on",0);
	}

	private void handleEscalationDetails(int index, String level, String fromRoleText, String questionIDText, String decisionOptionText, String toRoleText, String toStageText) {
		try {
			if (level1Drp.get(index).isDisplayed()) {
				fillEscalationDetails(index, level, fromRoleText, questionIDText, decisionOptionText, toRoleText, toStageText);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
			addRow.click();
			fillEscalationDetails(index, level, fromRoleText, questionIDText, decisionOptionText, toRoleText, toStageText);
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
			addRow.click();
			fillEscalationDetails(index, level, fromRoleText, questionIDText, decisionOptionText, toRoleText, toStageText);
		}
	}


	/*private void statusToggle()
	{
		if(statusCondition.getText().equals("Inactive"))
		{
			statusToggleButton.click();
		}
	}*/

	public void printoptions(WebElement dropdown)
	{
		Select ProcessDrp=new Select(dropdown);

		for(WebElement options:ProcessDrp.getOptions())
		{
			System.out.println(options.getText());
		}
	}

	public EscalationMatrixPage dropdownValidations()
	{
		unWait(1);
		dropdownUtil(level1Drp.get(0),levels);
		dropdownUtil(fromRole.get(0),roles);

		dropdownUtil(questionID.get(0),QuestionID);
		dropdownUtil(decisionOption.get(0),DecisionOption);
		dropdownUtil(toRole.get(0),ToRole);
		dropdownUtil(toStage.get(0),ToStage);

		return this;
	}

	public EscalationMatrixPage escalateRecord(String escalateMessage)
	{
		navigateWithinAlchemy(callLogTabView);
		// Click on necessary tabs and stages

		insuranceStage.click();

		// Retrieve customer details


		try {

			// Attempt to click the eye button and escalate
			nameOfTheCustomer = driver.findElement(By.xpath("//tbody//td[5]")).getText();
			phoneNumber = driver.findElement(By.xpath("//tbody//td[7]")).getText();
			unWait(1); // Assuming this is a method that waits for 1 second
			customerEmail = custEmail.getText();
			eyeButton.click();
			escalateInputField.sendKeys(escalateMessage);
			saveRecord();
		} catch (NoSuchElementException e) {
			// If the eye button is not found, assign the record and retry the process
			assignRecord();

			// Re-navigate and re-retrieve customer details
			navigateWithinAlchemy(callLogTabView);
			insuranceStage.click();
			nameOfTheCustomer = driver.findElement(By.xpath("//tbody//td[5]")).getText();
			phoneNumber = driver.findElement(By.xpath("//tbody//td[7]")).getText();
			unWait(1);
			String customerEmail = custEmail.getText();

			// Retry the escalation process
			eyeButton.click();
			escalateInputField.sendKeys(escalateMessage);
			saveRecord();
		}


		return this;
	}

	String firstName="name";
	String lastname="Paulr";

	public void getName(String firstName,String lastname){

		this.firstName=firstName;
	}


	public EscalationMatrixPage agencyValidation1(String StageName,String managerDecision,String assertEscalatedMessage,String escalationType )
	{
		navigateWithinAlchemy(agencyValidaion);

		selectByVisibleText(stageSearch, StageName);
		searchIcon.click();

		selectByVisibleText(itemsPerPage,"50");

		jsClick(recordEyeButton.get(recordEyeButton.size() -1));


		js.executeScript("window.scrollTo(0, 500);");
		unWait(1);

//		reviewDropdown.click();

		for(WebElement option:reviewDropdownList)
		{
			if(option.getText().equals(managerDecision))
			{
				option.click();
				break;
			}
		}

		String remarks= escaltionTextArea.getText();
		System.out.println(remarks);
		assertEquals(remarks,assertEscalatedMessage);
		if (escalationType.equals("Escalation")) {
			saveRecord();
		}else {

		}
		return this;
	}



	public EscalationMatrixPage rejectAuditForm(String reEscalatedMessage)
	{
		navigateWithinAlchemy(rejectAuditForm);
		selectByVisibleText(stageSearch,"Insurance Stage");
		searchIcon.click();
		jsClick(recordEyeButton.get(recordEyeButton.size() -1));
		js.executeScript("window.scrollTo(0, 500);");
		unWait(1);
		String reviewDecision=reviewDropDown.getText();
		System.out.println(reviewDecision);
		assertEquals(reviewDecision,"Reject");
		escalateInputField.clear();
		escalateInputField.sendKeys(reEscalatedMessage);

		saveRecord();
		return this;
	}
	public EscalationMatrixPage rejectedAuditForm(String stageName,String createdBy,String submitted ){

		navigateWithinAlchemy(rejectedAuditForm);
		selectByVisibleText(stageSearch,stageName);

		assert  submittedBy.getText().equals(submitted);
		assert escalationDisposition.getText().equals("REJECT");
		assert auditCreatedByValue.getText().equals(createdBy);


		return this;
	}

	public EscalationMatrixPage assignRecord()
	{
		mastersMenu.click();
		viewOrModifyXpath("Insurance");
		viewAssigness.click();
		unWait(1);
		assignButton.click();
		unWait(1);
		jsClick(backButton);

		return this;
	}

	private void viewOrModifyXpath(String masterName)
	{
		String linkText= "View/Modify "+masterName;
		WebElement element= driver.findElement(By.linkText(linkText));
		jsClick(element);
	}


	public EscalationMatrixPage searchValidations(String negativeInputs)
	{

		sendKeys(searchBox,negativeInputs);
		searchIcon.click();

		assert noEntriesFound() || operationalError();

		if(operationalError()){
			driver.navigate().back();
		}

		return this;
	}

	public EscalationMatrixPage escalateRecordEndToEnd(String stageName)
	{
		navigateWithinAlchemy(escalationMatrixPage);
		sendKeys(searchBox,"AJP");
		searchIcon.click();

		table(stageName);
		fillEscalationDetails(0,"1","Agent","Review Status","--Select--","Team Lead","Agency Validation");

		handleEscalationDetails(1,"2","Team Lead","Review Status","Accept","Admin","Agency Validation");
		handleEscalationDetails(2,"2","Team Lead","Review Status","Reject","Agent","Rejected Audit Form");

		handleEscalationDetails(3,"3","Admin","Review Status","Accept","End","-");
		handleEscalationDetails(4,"3","Admin","Review Status","Reject","Team Lead","Rejected Audit Form");

		save.click();
		unWaitInMilli(400);
		continueButton.click();

		return this;
	}

	String actualAuditedTime;
	String remarks="remarks"+lastName2();
	String escalationGmail=lastName2()+"@gmail.com";

	public EscalationMatrixPage agentAssignment(String stageName,String user){
		loginToUser(user);
		navigateWithinAlchemy(callLogStageView);
		selectByVisibleText(stageSearch,stageName);
		searchIcon.click();
		try{
			if(noEntriesFound.isDisplayed()){
				loginToUser("Capture_admin");
				disposeData(stageName,user);
			}}catch (NoSuchElementException ignored){

		}
		unWaitInMilli(300);
		jsClick(recordEyeButton.get(0));

		jsClick(questionTab);
		reviewRemarksInput.sendKeys(remarks);
		emailID.sendKeys(escalationGmail);
		actualAuditedTime=getCurrentDateTimeInUTC();

		jsClick(save);

		unWait(1);
		continueButton.click();
		System.out.println(actualAuditedTime);


		return this;
	}

	private WebElement stageXpath(String stageName)
	{
		String xpath="//button[contains(normalize-space(), '"+stageName+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	public EscalationMatrixPage disposeData(String stageName,String user)
	{

		navigateWithinAlchemy(callLogTabView);
		jsClick(stageXpath(stageName));
		recordEyeButton.get(0).click();

		jsWindowsScroll(500);

		selectByVisibleText(stageNameDispositionDropdown,stageName);
		selectByVisibleText(assignToDropdown,user);

		saveRecord();

		return this;
	}

//****************Agency Validation*********************



	@FindBy(xpath="//td[11]")
	List<WebElement> auditedTime;
	String expectedAuditedTime;

	@FindBy(xpath = "//label[text()='Remarks *']/../textarea")
	WebElement managerRemarksInput;

	@FindBy(xpath = "//td[4]")
	static WebElement escalationDisposition;

	@FindBy(xpath = "//td[11]")
	static WebElement auditCreatedByValue;

	@FindBy(xpath = "//td[20]")
	static WebElement submittedBy;

	public static void assertEscalations(String status, String createdBy,String submitted){
		String escalationStatus=escalationDisposition.getText();
		String createdByText=auditCreatedByValue.getText();
		String submittedByText=submittedBy.getText();
//		softAssert.assertEquals(escalationStatus, status);
		softAssert.assertEquals(createdByText, createdBy);
		softAssert.assertEquals(submittedByText, submitted);


	}

	public EscalationMatrixPage agencyValidation(String stageName,String reviewDecision,String name1,String name2)
	{
		navigateWithinAlchemy(agencyValidaion);
		selectByVisibleText(stageSearch,stageName);
		searchIcon.click();
		assertEscalations(reviewDecision,name1,name2);
		try {
			selectByVisibleText(itemsPerPage, "50");
		}catch (Exception e){
			System.out.println("selectByVisibleText(itemsPerPage, 50); is not visible");
		}
		assertAgencyValidation(name1,name2);
		try {
			jsClick(recordEyeButton.get(recordEyeButton.size() - 1));
		}catch (Exception e){
			jsClick(recordEyeButton.get(0));
		}
		selectByVisibleText(reviewDropDown,reviewDecision);
		managerRemarksInput.sendKeys("Reviewed");

		saveRecord();

		softAssert.assertAll();

		return this;
	}

	public EscalationMatrixPage assertAgencyValidation(String name1,String name2){
		String tableDetails= tableRows.get(tableRows.size()-1).getText();
		assertTrue(tableDetails.contains(name1) && tableDetails.contains(name2));

		return this;
	}


	public EscalationMatrixPage agencyValItemsPerPageDropdown(String stageName)
	{
		navigateWithinAlchemy(agencyValidaion);
		selectByVisibleText(stageSearch,stageName);
		searchIcon.click();
		validateRecordsPerPage();

		return this;
	}

	public EscalationMatrixPage stageDropdown(String stageName)
	{
		navigateWithinAlchemy(agencyValidaion);
		assert isDropdownEnabled(stageSearch);
		assert  isOptionPresent(stageSearch,stageName);


		return this;
	}

	//	************************* Validation Status Report ************************

	public EscalationMatrixPage validationStatusReportFilter(String stageName, String fromDateValue, String toDateValue)
	{

		navigateWithinAlchemy(validationStatusReport);
		selectByVisibleText(processSearch, "AJP");
		selectByVisibleText(subProcessSearch, "Sub AJP");
		selectByVisibleText(subSubProcessSearch, "Sub Sub AJP");
		selectByVisibleText(stageSearch, stageName);


		jsDateExecutor(fromDate,fromDateValue);

		jsDateExecutor(toDate,toDateValue);

		searchIcon.click();

//	Bug, the new records are stored at the last.

		return this;
	}

	StagesActions stagesActions=new StagesActions();
	String reportFilters ="Report Filters";
	int dropdown=0;
	int datePicker=1;
	int dateRangePicker=2;
	int multiSelect=3;
	int textBox=4;
	int valueRange=5;

	List<String> dropdownOptions=List.of("Name","Email ID");
	List<String> datePickerOptions=List.of("Audit_Created_On");
	List<String> dateRangePickerOptions=List.of("Audit_Created_On");
	List<String> multiSelectOptions=List.of("Name","Email ID");
	List<String> textBoxOptions=List.of("Name","Email ID");
	List<String> valueRangeOptions=List.of("Phone Number","Email ID");

	public void assignReportFilters(String stageName){
		stagesActions.workFlowDesign.click();
		stagesActions.stagesTab.click();
		searchBox.sendKeys(stageName);
		searchIcon.click();
		stagesActions.clickOnStageHistoryField(stageName,reportFilters);
		selectByVisibleTextForMultiSelect(dropdown,dropdownOptions);
		selectByVisibleTextForMultiSelect(datePicker,datePickerOptions);
		selectByVisibleTextForMultiSelect(dateRangePicker,dateRangePickerOptions);
		selectByVisibleTextForMultiSelect(multiSelect,multiSelectOptions);
		selectByVisibleTextForMultiSelect(textBox,textBoxOptions);
		selectByVisibleTextForMultiSelect(valueRange,valueRangeOptions);

		saveRecord();
	}

	private void selectByVisibleTextForMultiSelect(int element,List<String> toSelect)
	{
		jsClick(stagesActions.allLeftButton.get(element));
		Select select= new Select(stagesActions.fromMultiselectDropdown.get(element));

		for(String element1:toSelect){
			select.selectByVisibleText(element1);
			jsClick(stagesActions.SingleRightButton.get(element));
		}

	}

	@FindBy(xpath = "//div[@id='collapseOne']//select")
	List<WebElement> localFiltersSelect;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> tableRows;


	private String selectRandomDropdownAndValue(List<WebElement> dropdownElements) {
		Random random = new Random();

		// Randomly select a dropdown from the list
		int dropdownIndex = random.nextInt(dropdownElements.size());
		WebElement selectedDropdownElement = dropdownElements.get(dropdownIndex);

		// Create a Select object to interact with the dropdown
		Select select = new Select(selectedDropdownElement);

		// Get all options in the dropdown
		List<WebElement> options = select.getOptions();

		// Randomly select an option from the dropdown
		int optionIndex = random.nextInt(options.size());
		WebElement selectedOption = options.get(optionIndex);

		// Select the option
		select.selectByVisibleText(selectedOption.getText());

		// Return the selected value
		return selectedOption.getText();
	}

	public EscalationMatrixPage validationStatusLocalFilterWithDropdown(){

		localFilters.click();
		String selectValue=selectRandomDropdownAndValue(localFiltersSelect);
		System.out.println(selectValue);
		jsClick(searchIcon);
		String expectedValue=tableRows.get(0).getText();
		System.out.println(expectedValue);
		assertTrue(expectedValue.contains(selectValue));

		return this;
	}

	public EscalationMatrixPage validateRecordsPerPage() {

		// Define options to test (10, 20, 50 records per page)
		int[] optionsToTest = {10, 20, 50};

		for (int option : optionsToTest) {
			// Re-fetch the dropdown each time before interacting
			WebElement dropdown = driver.findElement(By.xpath("//select[@id='page-size-select']"));
			Select select = new Select(dropdown);

			// Scroll the dropdown into view
			jsWindowsScrollIntoView(dropdown);

			// Select the dropdown value
			select.selectByVisibleText(String.valueOf(option));

			// Wait for the page to load/refresh after selection (use explicit wait instead of sleep)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='show_entries m-0 font_13']")));

			// Fetch the "Showing X to Y of Z" text
			WebElement showingTextElement = driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']"));
			String showingText = showingTextElement.getText();

			// Extract the 'Showing 1 to X of Y' parts
			String[] showingParts = showingText.split(" ");
			int firstRecord = Integer.parseInt(showingParts[1]);
			int lastRecord = Integer.parseInt(showingParts[3]);
			int totalRecords = Integer.parseInt(showingParts[5]);

			System.out.println("Records Displayed: From " + firstRecord + " to " + lastRecord + " of " + totalRecords);

			// Fetch the list of records currently displayed
			List<WebElement> records = driver.findElements(By.xpath("//td[2]"));
			System.out.println("Number of records displayed on the page: " + records.size());

			// Validate the number of records displayed on the current page
			if (records.size() <= option) {
				System.out.println("Validation passed: Number of records per page is correct.");
			} else {
				System.out.println("Validation failed: Number of records per page is incorrect.");
			}

			// Validate if the last page has fewer records
			if (lastRecord == totalRecords && records.size() == lastRecord - firstRecord + 1) {
				System.out.println("Validation passed for the last page: Fewer records as expected.");
			}

		}
		return this;
	}


	public EscalationMatrixPage navigateToValidationStatusReport(String loginUserName,String stageName,String reviewRemarks,String EmailId){
		loginToUser(loginUserName);
		navigateWithinAlchemy(callLogStageView);
		selectByVisibleText(stageSearch,stageName);
		searchIcon.click();

		recordEyeButton.get(0).click();
		unWait(1);

		jsClick(questionTab);
		sendKeys(reviewRemarksInput,reviewRemarks);
		sendKeys(emailID,EmailId);
		sendKeys(emailID,EmailId);

		selectByVisibleText(stageNameDispositionDropdown,stageName);
		selectByVisibleText(assignToDropdown,loginUserName);
		saveRecord();

		return this;
	}





	private void toggleStatus(String toggleAction,int toggleButton) {
		String currentStatus = statusCondition.getText();

		if (currentStatus.equals("Active") && toggleAction.equals("off")) {
			statusToggleButton.get(toggleButton).click();
			System.out.println("Toggled from Active to Inactive.");
		} else if ((currentStatus.equals("Active") && toggleAction.equals("on")) ||
				(currentStatus.equals("Inactive") && toggleAction.equals("off"))) {
			System.out.println("No toggle action needed. Current status: " + currentStatus);
		} else if (currentStatus.equals("Inactive") && toggleAction.equals("on")) {
			statusToggleButton.get(toggleButton).click();
			System.out.println("Toggled from Inactive to Active.");
		}
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

	public static String getCurrentDateTimeInUTC() {
		// Get the current instant in UTC
		Instant now = Instant.now();

		// Define the formatter for the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
				.withZone(ZoneOffset.UTC);

		// Format the current instant
		return formatter.format(now);
	}
	public static boolean isWithinOneSecond(String recordedTime, String expectedAuditedTime) {
		// Parse the recorded time string to an Instant
		Instant recordedInstant = Instant.parse(recordedTime);
		// Parse the expected audited time string to an Instant
		Instant currentInstant = Instant.parse(expectedAuditedTime);


		// Check if the current time is within ±1 second of the recorded time
		boolean isWithinRange = Math.abs(currentInstant.getEpochSecond() - recordedInstant.getEpochSecond()) <= 1;

		// Print a failure message if the timings are mismatched
		if (!isWithinRange) {
			System.out.println("Failure: The timings are not within ±1 second. Recorded: " + recordedInstant + ", Expected: " + currentInstant);
		}

		return isWithinRange;
	}


	private boolean operationalError()
	{
		return driver.getPageSource().contains("OperationalError");
	}

	private boolean noEntriesFound()
	{
		try{
			return noEntriesFound.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

//	*********Transaction Report***********

	public EscalationMatrixPage transActionReport(String process, String subProcess,String subSubProcess,String stageName, String fromDateValue, String toDateValue){

		navigateWithinAlchemy(transActionReport);
		selectByVisibleText(processSearch, process);
		dropdownUtil(processSearch,process);
		selectByVisibleText(subProcessSearch, subProcess);
		dropdownUtil(subProcessSearch,subProcess);
		selectByVisibleText(subSubProcessSearch, subSubProcess);
		dropdownUtil(subSubProcessSearch,subSubProcess);
		selectByVisibleText(stageSearch, stageName);
		dropdownUtil(stageSearch,stageName);

		jsDateExecutor(fromDate,fromDateValue);

		jsDateExecutor(toDate,toDateValue);

		searchIcon.click();


		return this;
	}


	public EscalationMatrixPage localFilter(String auditedBy,String email,String name,String reviewStatus){

		localFilters.click();

		selectByVisibleText(auditCreatedByFilter,auditedBy);
		selectByVisibleText(emailIdFilter,email);
		selectByVisibleText(nameFilter,name);
		selectByVisibleText(reviewStatusFilter,reviewStatus);

		searchBox.click();

		return this;
	}

	public EscalationMatrixPage assertTransAction(){



		return this;
	}



}
