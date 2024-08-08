package com.advaita.pageObjects;

import com.advaita.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EscalationMatrixPage extends TestBase {
	public EscalationMatrixPage(){
		PageFactory.initElements(driver,this);

	}
	@FindBy(linkText="Escalation Metrics")
	WebElement EscalationMatrixPage;


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

	@FindBy(xpath="//span[text()='Sub AJP ']")
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
	WebElement statusToggleButton;

	@FindBy(linkText ="+ Add Row")
	WebElement addRow;

	@FindBy(xpath ="//button[text()='Save']")
	WebElement save;

	@FindBy(xpath ="//button[text()='Cancel']")
	WebElement cancel;

	@FindBy(xpath ="//span[contains(@id,'status')]")
	WebElement statusCondition;

	@FindBy(linkText  ="Agency Validation")
	WebElement agencyValidaion;

	@FindBy(xpath  ="//select[@id='stage_search']")
	WebElement stageSearch;

	@FindBy(xpath  ="//img[@class='img-fluid' and @alt='filter_search']")
	WebElement stageSearchIcon;

	@FindBy(xpath  ="//img[@alt='table-edit']")
	List<WebElement> recordEyeButton;

	@FindBy(id  ="select2-current_Sec_id-container")
	WebElement reviewDropdown;

	@FindBy(xpath  ="//ul[@id='select2-current_Sec_id-results']//li")
	List<WebElement> reviewDropdownList;

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


	//	-------------------Master-----------
	@FindBy(id  ="menulist3")
	WebElement mastersMenu;

	@FindBy(linkText  ="View/Modify Insurance")
	WebElement viewModifyInsurance;

	@FindBy(xpath  ="//img[@title='View Assignees']")
	WebElement viewAssigness;

	@FindBy(xpath  ="//button[text()='Assign']")
	WebElement assignButton;



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


	public void selectByVisibleText(WebElement select,String Value)
	{
		Select subSubProcessDrp=new Select(select);
		subSubProcessDrp.selectByVisibleText(Value);

	}
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

	public EscalationMatrixPage navigationToTablePage()
	{
		try {
			jsClick(driver, EscalationMatrixPage);
		}catch (Exception e) {

			jsClick(driver, alchemy);
			jsClick(driver, EscalationMatrixPage);
		}

		return this;
	}

	public EscalationMatrixPage table(String nameToDelete)
	{

		jsClick(driver,AJPProcess);
		jsClick(driver,subAJPProcess);
		jsClick(driver,subSubAJPProcess);
		//		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : subSubProcessTable) {
			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameColumn.getText().equals(nameToDelete)) {
				try {
					WebElement process = row.findElement(By.xpath(".//td//img[@alt='table-edit']"));
					jsClick(driver, process);

					System.out.println(nameToDelete + " Successfully Deleted");
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
		statusToggle();
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


	private void statusToggle()
	{
		if(statusCondition.getText().equals("Inactive"))
		{
			statusToggleButton.click();
		}
	}

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

	private void saveRecord()
	{
		jsClick(driver,save);
		unWait(1);
		continueButton.click();
	}

	public EscalationMatrixPage agencyValidation(String managerDecision,String assertEscalatedMessage,String escalationType )
	{
		alchemy.click();
		agencyValidaion.click();
		selectByVisibleText(stageSearch, "Insurance Stage");
		searchIcon.click();

		selectByVisibleText(itemsPerPage,"50");

		jsClick(driver,recordEyeButton.get(recordEyeButton.size() -1));


		js.executeScript("window.scrollTo(0, 500);");
		unWait(1);
		reviewDropdown.click();

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

	public EscalationMatrixPage validationStatusReport()
	{
		navigateWithinAlchemy(validationStatusReport);
		selectByVisibleText(processSearch, "AJP");
		selectByVisibleText(subProcessSearch, "Sub AJP");
		selectByVisibleText(subSubProcessSearch, "Sub Sub AJP");
		selectByVisibleText(stageSearch, "Insurance Stage");
		fromDate.click();
		selectDate(driver,1,2024,"August");
		toDate.click();
		selectDate(driver,7,2024,"August");
		searchIcon.click();
		jsClick(driver,recordEyeButton.get(recordEyeButton.size() -1));

//	Bug	

		return this;
	}
	public EscalationMatrixPage rejectAuditForm(String reEscalatedMessage)
	{
		navigateWithinAlchemy(rejectAuditForm);
		selectByVisibleText(stageSearch,"Insurance Stage");
		searchIcon.click();
		jsClick(driver,recordEyeButton.get(recordEyeButton.size() -1));
		js.executeScript("window.scrollTo(0, 500);");
		unWait(1);
		String reviewDecision=reviewDropdown.getText();
		System.out.println(reviewDecision);
		assertEquals(reviewDecision,"Reject");
		escalateInputField.clear();
		escalateInputField.sendKeys(reEscalatedMessage);

		saveRecord();
		return this;
	}
	public EscalationMatrixPage auditRejectedEscalation()
	{
		navigateWithinAlchemy(agencyValidaion);

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
		jsClick(driver,backButton);

		return this;
	}

	private void viewOrModifyXpath(String masterName)
	{
		String linkText= "View/Modify "+masterName;
		WebElement element= driver.findElement(By.linkText(linkText));
		jsClick(driver,element);
	}





}
