package com.advaita.pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;

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
	WebElement recordEyeButton;

	@FindBy(xpath  ="(//span[contains(@class,'select2-selection select2')]//span)[2]")
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
	




	String CustomerEmail;
	String NameOfTheCustomer;
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
		callLogTabView.click();
		insuranceStage.click();
		NameOfTheCustomer=driver.findElement(By.xpath("//tbody//td[5]")).getText();
		phoneNumber=driver.findElement(By.xpath("//tbody//td[7]")).getText();
		unWait(1);
		CustomerEmail=custEmail.getText();
		eyeButton.click();
		escalateInputField.sendKeys(escalateMessage);
		
		return this;
	}
	

	public EscalationMatrixPage agencyValidation(String managerDecision )
	{
		alchemy.click();
		agencyValidaion.click();
		selectByVisibleText(stageSearch, "Insurance Stage");
		searchIcon.click();
		recordEyeButton.click();


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
		
				
		jsClick(driver, backButton);
		return this;
	}

	public EscalationMatrixPage validationStatusReport()
	{
		validationStatusReport.click();
		selectByVisibleText(processSearch, "AJP");
		selectByVisibleText(subProcessSearch, "Sub AJP");
		selectByVisibleText(subSubProcessSearch, "Sub Sub AJP");
		selectByVisibleText(stageSearch, "Insurance Stage");
		fromDate.sendKeys("01-08-2024");
		toDate.sendKeys("06-08-2024");
		searchIcon.click();
		recordEyeButton.click();	
		
		return this;
	}
	
	











}
