package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.FetchDataFromInputTagWithJS;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;

import Advaita_TDD.Advaita_TDD.FakeData;

public class EmailTemplatePage extends TestBase {

	public EmailTemplatePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "text_search")
	WebElement searchInputField;

	@FindBy(xpath = "//select[@id='process_search']")
	WebElement searchProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	WebElement searchSubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process_search']")
	WebElement searchSubSubProcessDropdown;

	@FindBy(xpath = "//select[@id='stage_search']")
	WebElement searchStageDropdown;

	@FindBy(xpath = "//img[@alt='filter_search']/parent::button")
	WebElement searchButton;

	@FindBy(xpath = "//h6[text()='Clear All Filters']")
	WebElement clearAllFilter;

	@FindBy(linkText = "+ Create")
	WebElement create;

	@FindBy(xpath = "//h2[text()='Create Email Template']")
	public WebElement verifyCreateEmailTemplate;

	@FindBy(xpath = "//select[@id='page-size-select']")
	WebElement pageSizeSelect;

	@FindBy(xpath = "//label[text()='Process*']")
	public WebElement processDropdownLabel;

	@FindBy(xpath = "//select[@id='process']")
	WebElement processDropdown;

	@FindBy(xpath = "//label[text()='Sub Process*']")
	public WebElement subProcessDropdownLabel;

	@FindBy(xpath = "//select[@id='sub_process']")
	WebElement subProcessDropdown;

	@FindBy(xpath = "//label[text()='Sub Sub Process*']")
	public WebElement subSubProcessDropdownLabel;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	WebElement subSubProcessDropdown;

	@FindBy(xpath = "//label[text()='Stages*']")
	public WebElement stagesLabel;

	@FindBy(xpath = "//select[@id='stage_name_id']")
	WebElement stageDropdown;

	@FindBy(xpath = "//label[text()='API Key Name*']")
	public WebElement apiKeyNameLabel;

	@FindBy(xpath = "//label[text()='Template Name*']")
	public WebElement inputTemplateNameLabel;

	@FindBy(id = "api_name")
	public WebElement apiNameDropdown;

	@FindBy(xpath = "//input[@name='template_name']")
	WebElement inputTemplateName;

	@FindBy(xpath = "//label[text()='From*']")
	public WebElement inputFromMailLabel;

	@FindBy(xpath = "//input[@name='from_email']")
	public WebElement inputFromMail;

	@FindBy(xpath = "//select[@id='emailtype']")
	public WebElement toNumberSource;

	@FindBy(xpath = "//select[@id='to_email']")
	public WebElement toMailDropdown;

	@FindBy(xpath = "//textarea[@name='cc_email']")
	public WebElement inputCCMail;

	@FindBy(xpath = "//textarea[@name='bcc_email']")
	public WebElement inputBCCMail;

	@FindBy(xpath = "//textarea[@name='remarks']")
	WebElement inputRemarks;

	@FindBy(xpath = "//input[@name='disposition']")
	WebElement inputDisposition;

	@FindBy(xpath = "//label[text()='Email For*']")
	WebElement emailForLabel;

	@FindBy(id = "Emailfor")
	public WebElement emailFordropdown;

	@FindBy(xpath = "//label[text()='Subject*']")
	public WebElement subjectLabel;

	@FindBy(xpath = "//input[@name='subject']")
	WebElement inputSubject;

	@FindBy(xpath = "//label[text()='Level']")
	public WebElement lavelLabel;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
	public WebElement levelOption;

	@FindBy(xpath = "(//span[text()='Paragraph'])[1]")
	WebElement paragraghDropdown;

	@FindBy(xpath = "//input[contains(@name,'sub_variable_name')]")
	List<WebElement> inputSubjectVariable;

	@FindBy(xpath = "//select[contains(@name,'subvar_stage')]")
	List<WebElement> subjectStageDropdown;

	@FindBy(xpath = "//input[contains(@name,'subvar_default_')]")
	List<WebElement> inputSubjectDefaultValue;

	@FindBy(xpath = "//label[text()='Subject Variables']//following-sibling::*//img")
	WebElement subjectDeleteButton;

	@FindBy(xpath = "//label[text()='Subject Variables']//following-sibling::*//a")
	WebElement subjectAddRow;

	@FindBy(xpath = "//select[contains(@name,'stage_field')and not(contains(@name,'subvar'))]")
	List<WebElement> templateStageDropdown;

	@FindBy(xpath = "//select[@name='stage_field_name_2']")
	WebElement templateStageDropdown2;

	@FindBy(xpath = "//input[contains(@name,'temp_variable_name')]")
	List<WebElement> inputTemplateVarField;

	@FindBy(xpath = "//input[not(contains(@name,'subvar')) and contains(@name,'default')]")
	List<WebElement> inputTemplateDefaultField;

	@FindBy(xpath = "//div[@class='col-md-12']//img")
	WebElement bodyDeleteButton;

	@FindBy(xpath = "//div[@class='col-md-12']//a")
	WebElement bodyVarAddRow;

	@FindBy(id = "manual_id")
	WebElement templateCreate;

	@FindBy(xpath = "//button[@id='manual_id']//following-sibling::button")
	WebElement templateCancel;

	@FindBy(xpath = "//span[text()='Alchemy']")
	WebElement alchemy;

	@FindBy(linkText = "Email Template")
	WebElement emailTemplate;

	@FindBy(id = "from_email-error")
	WebElement errorElement;

	@FindBy(xpath = "//div[@role='textbox']")
	WebElement inputMessage;

	// Call Log Tab View
	@FindBy(linkText = "Call Log Tab View")
	WebElement callLogTabView;

	@FindBy(xpath = "//button[contains(normalize-space(), 'Insurance Stage')]")
	WebElement insuranceStage;

	@FindBy(xpath = "//tbody//td[1]//img")
	WebElement eyeButton;

	@FindBy(xpath = "//img[contains(@class,'email')]")
	WebElement emailButton;

	@FindBy(xpath = "//select[@id='select_type_id_email']")
	WebElement selectEmailDrp;

	@FindBy(xpath = "//button[@id='email_form_submit_btn']")
	WebElement send;

	@FindBy(xpath = "//button[@id='email_form_submit_btn']//following-sibling::button")
	WebElement emailCancel;

	@FindBy(xpath = "//tbody//td[8]")
	WebElement custEmail;

	@FindBy(xpath = "//h3[text()='Success']//following-sibling::button")
	WebElement continueButton;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement confirmDeleteButton;

	@FindBy(css = "table.w-100 tbody")
	WebElement formsTableBody;

	@FindBy(css = "img.arrow-left")
	WebElement custPageBack;

	// References Class
	FakeData fakeData = new FakeData();

	FieldVerificationUtils fieldVerificationUtils = new FieldVerificationUtils();

	DropDown dropDown = new DropDown();
	Random random = new Random();

	private static final String emailTemplate_Path8 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\email.Properties";
	private static final String PROPERTIES_FILE_PATH2 = "src/main/resources/SingleTextExtract.properties";

//	public EmailTemplatePage navigationToAdmin() {
//		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");
//
//		LoginPage.usernameField.sendKeys("Capture_admin");
//		LoginPage.passwordField.sendKeys("Qwerty@123");
//		LoginPage.signInButton.click();
//		return this;
//	}

	public EmailTemplatePage navigation() {

		try {
			jsClick(emailTemplate);

		} catch (NoSuchElementException e) {
			alchemy.click();
			jsClick(emailTemplate);
		}
		return this;
	}

	public EmailTemplatePage InputTemplateField(String tempalteName) {
		inputTemplateName.sendKeys(tempalteName);
		return this;
	}

	public EmailTemplatePage validateEmail(WebElement element, String Email) {
		try {
			create.click();
			element.sendKeys(Email);
			assertTrue(errorElement.getText().contains("Please enter a valid email address."));
		} catch (NoSuchElementException e) {
			assertTrue(false, "Error message element not found.");
		}
		return this;
	}

	public EmailTemplatePage validateDropdowns() {
		jsClick(emailTemplate);
		create.click();
		// dropdownUtil(processDropdown,processExpectedOptions);
		unWait(1);
		dropdownUtil(processDropdown, "AJP");
		selectByVisibleText(processDropdown, "AJP");
		unWait(1);
		dropdownUtil(subProcessDropdown, "Sub AJP");
		selectByVisibleText(subProcessDropdown, "Sub AJP");
		unWait(1);
		dropdownUtil(subSubProcessDropdown, "Sub Sub AJP");
		selectByVisibleText(subSubProcessDropdown, "Sub Sub AJP");
		unWait(1);
		dropdownUtil(stageDropdown, "Insurance Stage");
		selectByVisibleText(stageDropdown, "Insurance Stage");
		unWait(1);
		dropdownUtil(subjectStageDropdown.get(0), "Name Of the Customer");
		unWait(1);
		dropdownUtil(templateStageDropdown.get(0), "Name Of the Customer");

		return this;
	}

	public void selectByVisibleText(WebElement select, String Value) {
		Select subSubProcessDrp = new Select(select);
		subSubProcessDrp.selectByVisibleText(Value);

	}

	public EmailTemplatePage smsTemplate() {
		navigateWithinAlchemy(driver.findElement(By.linkText("SMS Template")));
		selectByVisibleText(searchProcessDropdown, "DemoEmpH P");
//		unWaitInMilli(400);
		selectByVisibleText(searchSubProcessDropdown, "DemoEmpH S P");
//		unWaitInMilli(400);
		selectByVisibleText(searchSubSubProcessDropdown, "DemoEmpH S S P");
//		unWaitInMilli(400);
		selectByVisibleText(searchStageDropdown, "DemoEmpH Stage");

		return this;
	}

	public void printoptions(WebElement dropdown) {
		Select ProcessDrp = new Select(dropdown);

		for (WebElement options : ProcessDrp.getOptions()) {
			System.out.println(options.getText());
		}
	}

	public EmailTemplatePage createEmailTemplate(String Process, String SubProcess, String SubSubProcess, String Stage,
			String TemplateName, String fromMail, String toMail, String CCMail, String BCC, String Subject,
			String Message) {
		jsClick(emailTemplate);
		create.click();
		// dropdownUtil(processDropdown,processExpectedOptions);
		unWait(1);
		selectByVisibleText(processDropdown, Process);
		unWait(1);
		selectByVisibleText(subProcessDropdown, SubProcess);
		unWait(1);
		selectByVisibleText(subSubProcessDropdown, SubSubProcess);
		unWait(1);
		selectByVisibleText(stageDropdown, Stage);
		unWait(1);

		inputTemplateName.sendKeys(TemplateName);
		inputFromMail.sendKeys(fromMail);
		selectByVisibleText(toMailDropdown, toMail);
		inputCCMail.sendKeys(CCMail);
		inputBCCMail.sendKeys(BCC);
		inputSubject.sendKeys(Subject);
		inputMessage.sendKeys(Message);

		templateCreate.click();
		unWait(1);
		continueButton.click();

		// selectByVisibleText(subjectStageDropdown,"Name Of the Customer");
		// unWait(1);
		// selectByVisibleText(templateStageDropdown,"Name Of the Customer");

		return this;
	}

	String CustomerEmail;
	String NameOfTheCustomer;
	String phoneNumber;

	public EmailTemplatePage navigateToCustomerProfile(String UserName) {
		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");

		LoginPage.usernameField.sendKeys(UserName);
		LoginPage.passwordField.sendKeys("Qwerty@123");
		LoginPage.signInButton.click();

		callLogTabView.click();
		insuranceStage.click();
		NameOfTheCustomer = driver.findElement(By.xpath("//tbody//td[5]")).getText();
		phoneNumber = driver.findElement(By.xpath("//tbody//td[7]")).getText();
		unWait(1);
		CustomerEmail = custEmail.getText();
		eyeButton.click();

		return this;
	}

	public String getFirstSelectedOption(WebElement webelement) {
		Select option = new Select(webelement);
		return option.getFirstSelectedOption().getText();
	}

	FetchDataFromInputTagWithJS inputTagText = new FetchDataFromInputTagWithJS();

	public EmailTemplatePage verifyTemplate(String TemplateName, String fromMail, String CCMail, String BCC,
			String Subject, String Message) {
		emailButton.click();
		unWait(1);
		selectByVisibleText(selectEmailDrp, TemplateName);
		unWait(1);
		String actualfromMail = inputTagText.dataPrintFromInputtag(inputFromMail, "fromMail");
		String actualCCMail = inputTagText.dataPrintFromInputtag(inputCCMail, "CCMail");
		String actualBCC = inputTagText.dataPrintFromInputtag(inputBCCMail, "BCC");
		String actualSubject = inputTagText.dataPrintFromInputtag(inputSubject, "Subject");

		assertEquals(getFirstSelectedOption(selectEmailDrp), TemplateName);
		assertEquals(fromMail, actualfromMail);
		unWait(1);
		assertEquals(CustomerEmail, getFirstSelectedOption(toMailDropdown));
		assertEquals(CCMail, actualCCMail);
		assertEquals(BCC, actualBCC);
		assertEquals(Subject, actualSubject);
		// assertEquals(Message,inputMessage.getText());
		send.click();
		jsClick(custPageBack);
		return this;
	}

	public EmailTemplatePage actionRecord(String nameToDelete, String action) {

		selectByVisibleText(pageSizeSelect, "50");
		unWait(1);

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {
			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameColumn.getText().contains(nameToDelete)) {
				switch (action) {
				case "Delete":
					try {
						WebElement deleteButton = row.findElement(By.xpath(".//td//div//img[@alt='delete-icon ']"));
						jsClick(deleteButton);

						confirmDeleteButton.click();
						unWait(2);
						continueButton.click();
						System.out.println(nameToDelete + " Successfully Deleted");
					} catch (Exception e) {
						System.out.println("Failed to delete the record: " + e.getMessage());
					}
					break;

				case "Edit":
					try {
						WebElement editButton = row.findElement(By.xpath(".//td//img[@alt='table-edit']"));
						jsClick(editButton);
					} catch (Exception e) {
						System.out.println("Failed to edit the record: " + e.getMessage());
					}
					break;

				default:
					System.out.println("Invalid action: " + action);
				}
				// Once the action is performed, exit the loop
				break;
			}
		}

		return this;
	}

	public void EditInput(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public EmailTemplatePage editTemplate(String ToEdit, String editFromMail, String editToMail, String editBCCMail,
			String editCCMail, String EditSubject) {
		if (ToEdit.equals(null)) {
			System.out.println("ToEdit parameter cannot be null");
		}

		switch (ToEdit) {
		case "From":
			EditInput(inputFromMail, editFromMail);
			break;
		case "To":
			selectByVisibleText(toMailDropdown, editToMail);
			break;
		case "BCC":
			EditInput(inputBCCMail, editBCCMail);
			break;
		case "CC":
			EditInput(inputCCMail, editCCMail);
			break;
		case "Subject":
			EditInput(inputSubject, EditSubject);
			break;
		default:
			// Handle unexpected values of ToEdit
			throw new IllegalArgumentException("Unexpected value: " + ToEdit);
		}
		jsClick(templateCreate);
		unWait(1);
		continueButton.click();

		return this;
	}

	public EmailTemplatePage validateEditedTemplate(String templateName, String toEdit, String fromMail,
			String editToMail, String ccMail, String bcc, String subject) {
		// Click the email button
		emailButton.click();
		unWait(1);

		// Select the template from dropdown
		selectByVisibleText(selectEmailDrp, templateName);
		unWait(1);

		// Retrieve the actual values from input tags
		String actualFromMail = inputTagText.dataPrintFromInputtag(inputFromMail, "fromMail");
		String actualCCMail = inputTagText.dataPrintFromInputtag(inputCCMail, "CCMail");
		String actualBCC = inputTagText.dataPrintFromInputtag(inputBCCMail, "BCC");
		String actualSubject = inputTagText.dataPrintFromInputtag(inputSubject, "Subject");

		// Assert that the selected option in the dropdown is as expected
		assertEquals(getFirstSelectedOption(selectEmailDrp), templateName);
		unWait(1);

		// Switch case to check the edited field
		switch (toEdit) {
		case "From":
			assertEquals(fromMail, actualFromMail);
			break;
		case "BCC":
			assertEquals(bcc, actualBCC);
			break;
		case "CC":
			assertEquals(ccMail, actualCCMail);
			break;
		case "Subject":
			assertEquals(subject, actualSubject);
			break;
		default:
			throw new IllegalArgumentException("Invalid value for 'toEdit': " + toEdit);
		}

		// Click send button and navigate back
		send.click();
		jsClick(custPageBack);

		return this;
	}

	public EmailTemplatePage variables(String valueType, String inputVariable, String variable1, String variable2,
			String selectValue1, String selectValue2, String defaultValue1, String defaultValue2) {
		try {
			jsClick(emailTemplate);
			create.click();

			unWait(1);
			selectByVisibleText(processDropdown, "AJP");
			unWait(1);
			selectByVisibleText(subProcessDropdown, "Sub AJP");
			unWait(1);
			selectByVisibleText(subSubProcessDropdown, "Sub Sub AJP");
			unWait(1);
			selectByVisibleText(stageDropdown, "Insurance Stage");
			unWait(1);

			inputTemplateName.sendKeys("Testing Variables1");
			inputFromMail.sendKeys("Testing@gmail.com");
			selectByVisibleText(toMailDropdown, "Email ID");

			inputSubject.sendKeys(inputVariable);
			unWait(1);
			inputMessage.sendKeys(inputVariable);
			subjectAddRow.click();

			inputSubjectVariable.get(0).sendKeys(variable1);
			inputSubjectVariable.get(1).sendKeys(variable2);
			bodyVarAddRow.click();

			inputTemplateVarField.get(0).sendKeys(variable1);
			inputTemplateVarField.get(1).sendKeys(variable2);

			switch (valueType) {
			case "Stage":
				selectByVisibleText(subjectStageDropdown.get(0), selectValue1);
				selectByVisibleText(subjectStageDropdown.get(1), selectValue2);
				selectByVisibleText(templateStageDropdown.get(0), selectValue1);
				selectByVisibleText(templateStageDropdown.get(1), selectValue2);
				break;

			case "Default":
				inputSubjectDefaultValue.get(0).sendKeys(defaultValue1);
				inputSubjectDefaultValue.get(1).sendKeys(defaultValue2);
				inputTemplateDefaultField.get(0).sendKeys(defaultValue1);
				inputTemplateDefaultField.get(1).sendKeys(defaultValue2);
				break;

			default:
				System.out.println("Invalid valueType: " + valueType);
				break;
			}
		} catch (Exception e) {
			System.out.println("An error occurred while creating the email template: " + e.getMessage());
		}

		try {
			jsClick(templateCreate);
			unWait(1);
			continueButton.click();
		} catch (Exception e) {
			System.out.println("An error occurred while finalizing the email template creation: " + e.getMessage());
		}

		return this;
	}

	public EmailTemplatePage verifyVaribles() {

		// Click the email button
		emailButton.click();
		unWait(1);

		// Select the template from dropdown
		selectByVisibleText(selectEmailDrp, "Testing Variables1");
		unWait(1);

		String actualSubject = inputTagText.dataPrintFromInputtag(inputSubject, "Subject");
		String actualMessage = inputTagText.dataPrintFromInputtag(inputMessage, "Subject");

		softAssert.assertTrue(actualSubject.contains(NameOfTheCustomer));
		softAssert.assertTrue(actualSubject.contains(phoneNumber));
		softAssert.assertTrue(actualMessage.contains(NameOfTheCustomer));
		softAssert.assertTrue(actualMessage.contains(phoneNumber));

		softAssert.assertAll();

		return this;
	}

//===================================================================================================================

	public String cc_BCC_PlaceholderText = "Enter comma seperated email without space for multiple emails (Ex. abc@gmail.com,xyz@gmail.com)";

	public void navigatetoCraeteAndVerify() {
		navigatetoCreateAndVerify();
	}

	public void navigatetoCreateAndVerify() {

		assertTrue(create.isDisplayed(), "create is not Dislayed");
		create.click();

		wait.until(ExpectedConditions.visibilityOf(verifyCreateEmailTemplate));
		assertTrue(verifyCreateEmailTemplate.isDisplayed(), "verifyCreateEmailTemplate is not displayed");

	}

	// Process Select Process
	public void selectProcess(String selectProcess) throws Throwable {

		switch (selectProcess) {
		case "givenprocessname":

			fieldVerificationUtils.checkthroughAsterisk(processDropdownLabel, true);

			// Fetch Data FDrom Prperties File
			String process = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2, "process");

			// select Process Dropdown
			dropDown.dropdownUtils(processDropdown, process);

			break;

		case "randomprocess":

			fieldVerificationUtils.checkthroughAsterisk(processDropdownLabel, true);

			// select Process Dropdown
			DropDown.selectRandomOptionFromDropdwon(processDropdown);

			break;

		default:
			break;
		}

	}

	public void selectSubProcess(String selectSubProcess) throws Throwable {

		switch (selectSubProcess) {

		case "givenSubprocessname":

			fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);

			// Fetch Data FDrom Prperties File
			String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2, "subProcess");

			// select Process Dropdown
			dropDown.dropdownUtils(subProcessDropdown, subProcess);

			break;

		case "randomSubprocess":

			fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(subProcessDropdown);

			break;

		default:
			break;
		}

	}

	public void selectSubSubProcess(String selectSubSubProcess) throws Throwable {

		switch (selectSubSubProcess) {
		case "givensubsubprocessname":

			fieldVerificationUtils.checkthroughAsterisk(subSubProcessDropdownLabel, true);

			// Fetch Data FDrom Prperties File
			String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,
					"subSubProcess");

			// select Process Dropdown
			dropDown.dropdownUtils(subSubProcessDropdown, subSubProcess);

			break;

		case "randomSubSubprocess":

			fieldVerificationUtils.checkthroughAsterisk(subSubProcessDropdownLabel, true);

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(subSubProcessDropdown);

			break;

		default:
			break;
		}

	}

	public void selectStages(String givenStageName) throws Throwable {

		switch (givenStageName) {

		case "givenStageName":

			fieldVerificationUtils.checkthroughAsterisk(stagesLabel, true);

			// Fetch Data FDrom Prperties File
			String stage = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2, "stage");

			// select Process Dropdown
			dropDown.dropdownUtils(stageDropdown, stage);

			break;

		case "randomStage":

			fieldVerificationUtils.checkthroughAsterisk(stagesLabel, true);

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(stageDropdown);

			break;

		default:
			break;
		}

	}

	public void selectApiKyeName() throws Throwable {

		fieldVerificationUtils.checkthroughAsterisk(apiKeyNameLabel, true);

		assertTrue(apiNameDropdown.isDisplayed(), "apiNameDropdown is not Displayed");

		PropertieFileUtil.extractAllDropdownOptionsAndStore(emailTemplate_Path8, apiNameDropdown, "ApiKeyName");

		String apikyeName = PropertieFileUtil.getSingleTextFromPropertiesFile(emailTemplate_Path8, "ApiKeyName2");

		// select Process Dropdown
		dropDown.dropdownUtils(apiNameDropdown, apikyeName);

	}

	public void enterTemplateName() {

		fieldVerificationUtils.checkthroughAsterisk(inputTemplateNameLabel, true);

		assertTrue(inputTemplateName.isDisplayed(), "inputTemplateName is not Displayed");

		inputTemplateName.sendKeys(fakeData.generateTemplateName());

	}

	public void EnterFromMailID() {

		fieldVerificationUtils.checkthroughAsterisk(inputFromMailLabel, true);

		assertTrue(inputFromMail.isDisplayed(), "inputFromMail is not Displayed");

		inputFromMail.sendKeys(fakeData.generateEmailId());

	}

	public void toEmailSource(String selectToEmailSource) throws Throwable {

		switch (selectToEmailSource) {
		case "SelectmanuallyToNumberSource":

			// Fetch Data from Prperties File
			PropertieFileUtil.extractAllDropdownOptionsAndStore(emailTemplate_Path8, toNumberSource, "toNumberSource");

			String selectToNumberSource = PropertieFileUtil.getSingleTextFromPropertiesFile(emailTemplate_Path8,
					"toNumberSource1");

			dropDown.dropdownUtils(toNumberSource, selectToNumberSource);

			break;

		case "random":

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(toNumberSource);

			break;

		default:
			break;
		}

	}

	public void toMmail() throws Throwable {

		// Fetch Data from Prperties File
		PropertieFileUtil.extractAllDropdownOptionsAndStore(emailTemplate_Path8, toMailDropdown, "toMail");

		String toMail = PropertieFileUtil.getSingleTextFromPropertiesFile(emailTemplate_Path8, "toMail6");

		dropDown.dropdownUtils(toMailDropdown, toMail);
	}

	public void enterCC() {

		fieldVerificationUtils.verifyPlaceholder(inputCCMail, cc_BCC_PlaceholderText);

		inputCCMail.clear();
		inputCCMail.sendKeys(fakeData.generateMultipleEmailIds(3));

	}

	public void enterbcc() {

		fieldVerificationUtils.verifyPlaceholder(inputBCCMail, cc_BCC_PlaceholderText);

		inputBCCMail.clear();
		inputBCCMail.sendKeys(fakeData.generateMultipleEmailIds(1));

	}

	public void remarksTextfield() {

		assertTrue(inputRemarks.isDisplayed(), "inputRemarks is not Dispalyed");
		inputRemarks.isEnabled();
		inputRemarks.clear();
		inputRemarks.sendKeys(FakeData.lastName1() + "_Remarks");

	}

	public void disposition() {

		assertTrue(inputDisposition.isDisplayed(), "inputDisposition is not displayed");

		inputDisposition.isEnabled();
		inputDisposition.clear();

		inputDisposition.sendKeys(FakeData.lastName1() + "_Disposition");

	}

	public void selectEmailForDropdown(String SelectEmailFor) throws Throwable {

		switch (SelectEmailFor) {
		
		case "SelectmanuallyEmailFor":

			// Fetch Data from Prperties File
			fieldVerificationUtils.checkthroughAsterisk(emailForLabel, true);
			PropertieFileUtil.extractAllDropdownOptionsAndStore(emailTemplate_Path8, emailFordropdown, "emailFor");

			String emailFor = PropertieFileUtil.getSingleTextFromPropertiesFile(emailTemplate_Path8, "emailFor2");

			dropDown.dropdownUtils(emailFordropdown, emailFor);

			break;

		case "random":

			// select SubProcess Dropdown
			fieldVerificationUtils.checkthroughAsterisk(emailForLabel, true);
			DropDown.selectRandomOptionFromDropdwon(emailFordropdown);

			break;

		default:
			break;
		}

	}

	public void subject() {

		fieldVerificationUtils.checkthroughAsterisk(subjectLabel, true);

		inputSubject.isEnabled();
		subjectLabel.clear();
		subjectLabel.sendKeys(fakeData.lastName1() + "_Subject");
	}

	public void handleSelect2RolesDropdown(String mode, String... manualOptions) {

		try {
			// Step 1: Click to open the Select2 dropdown
			WebElement dropdownTrigger = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-mailToRoles-container']")));
			dropdownTrigger.click();

			// Step 2: Wait for dropdown options to be visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-results")));

			// Step 3: Switch case for Random or Manual selection
			switch (mode.toLowerCase()) {
			case "random":
				List<WebElement> allOptions = driver.findElements(By.xpath(
						"//ul[@class='select2-results__options']/li[not(contains(@class, 'select2-results__option--select-all'))]"));
				int randIndex = random.nextInt(allOptions.size());
				WebElement randomOption = allOptions.get(randIndex);
				System.out.println("Randomly selected: " + randomOption.getText());
				randomOption.click();
				break;

			case "manual":
				for (String option : manualOptions) {
					// Type in the search box
					// WebElement searchBox =
					// driver.findElement(By.xpath("//input[@class='select2-search__field']"));
					lavelLabel.clear();
					lavelLabel.sendKeys(option);
					Thread.sleep(500); // slight wait for filter

					WebElement matchedOption = wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//li[contains(@class,'select2-results__option') and text()='" + option + "']")));
					matchedOption.click();
					System.out.println("Manually selected: " + option);
				}
				break;

			default:
				System.out.println("Invalid mode. Use 'random' or 'manual'.");
			}

			// Optional: Validation - print selected items
			List<WebElement> selectedItems = driver
					.findElements(By.xpath("//li[contains(@class,'select2-selection__choice')]"));
			for (WebElement selected : selectedItems) {
				System.out.println("Selected role: " + selected.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Dropdown interaction failed!");
		}
	}

}
