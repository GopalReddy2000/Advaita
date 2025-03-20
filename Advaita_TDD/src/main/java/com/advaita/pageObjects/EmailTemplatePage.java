package com.advaita.pageObjects;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.FetchDataFromInputTagWithJS;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EmailTemplatePage extends TestBase{

	public EmailTemplatePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="text_search")
	WebElement searchInputField;

	@FindBy(xpath="//select[@id='process_search']")
	WebElement searchProcessDropdown;

	@FindBy(xpath="//select[@id='sub_process_search']")
	WebElement searchSubProcessDropdown;

	@FindBy(xpath="//select[@id='s_sub_process_search']")
	WebElement searchSubSubProcessDropdown;

	@FindBy(xpath="//select[@id='stage_search']")
	WebElement searchStageDropdown;

	@FindBy(xpath="//img[@alt='filter_search']/parent::button")
	WebElement searchButton;

	@FindBy(xpath="//h6[text()='Clear All Filters']")
	WebElement clearAllFilter;

	@FindBy(linkText  ="+ Create")
	WebElement create;

	@FindBy(xpath ="//select[@id='page-size-select']")
	WebElement pageSizeSelect;

	@FindBy(xpath="//select[@id='process']")
	WebElement processDropdown;

	@FindBy(xpath="//select[@id='sub_process']")
	WebElement subProcessDropdown;

	@FindBy(xpath="//select[@id='s_sub_process']")
	WebElement subSubProcessDropdown;

	@FindBy(xpath="//select[@id='stage_name_id']")
	WebElement stageDropdown;

	@FindBy(xpath="//input[@name='template_name']")
	WebElement inputTemplateName;

	@FindBy(xpath="//input[@name='from_email']")
	public
	WebElement inputFromMail;

	@FindBy(xpath="//select[@id='to_email']")
	public WebElement toMailDropdown;

	@FindBy(xpath="//textarea[@name='cc_email']")
	public WebElement inputCCMail;

	@FindBy(xpath="//textarea[@name='bcc_email']")
	public WebElement inputBCCMail;

	@FindBy(xpath="//textarea[@name='remarks']")
	WebElement inputRemarks;

	@FindBy(xpath="//input[@name='disposition']")
	WebElement inputDisposition;

	@FindBy(xpath="//input[@name='subject']")
	WebElement inputSubject;

	@FindBy(xpath="(//span[text()='Paragraph'])[1]")
	WebElement paragraghDropdown;

	@FindBy(xpath="//input[contains(@name,'sub_variable_name')]")
	List<WebElement> inputSubjectVariable;

	@FindBy(xpath="//select[contains(@name,'subvar_stage')]")
	List<WebElement> subjectStageDropdown;

	@FindBy(xpath="//input[contains(@name,'subvar_default_')]")
	List<WebElement> inputSubjectDefaultValue;

	@FindBy(xpath="//label[text()='Subject Variables']//following-sibling::*//img")
	WebElement subjectDeleteButton;

	@FindBy(xpath="//label[text()='Subject Variables']//following-sibling::*//a")
	WebElement subjectAddRow;

	@FindBy(xpath="//select[contains(@name,'stage_field')and not(contains(@name,'subvar'))]")
	List<WebElement> templateStageDropdown;

	@FindBy(xpath="//select[@name='stage_field_name_2']")
	WebElement templateStageDropdown2;

	@FindBy(xpath="//input[contains(@name,'temp_variable_name')]")
	List <WebElement> inputTemplateVarField;

	@FindBy(xpath="//input[not(contains(@name,'subvar')) and contains(@name,'default')]")
	List<WebElement> inputTemplateDefaultField;


	@FindBy(xpath="//div[@class='col-md-12']//img")
	WebElement bodyDeleteButton;

	@FindBy(xpath="//div[@class='col-md-12']//a")
	WebElement bodyVarAddRow;

	@FindBy(id="manual_id")
	WebElement templateCreate;

	@FindBy(xpath="//button[@id='manual_id']//following-sibling::button")
	WebElement templateCancel;

	@FindBy(xpath="//span[text()='Alchemy']")
	WebElement alchemy;

	@FindBy(linkText ="Email Template")
	WebElement emailTemplate;

	@FindBy(id="from_email-error")
	WebElement errorElement;

	@FindBy(xpath="//div[@role='textbox']")
	WebElement inputMessage;

	//	Call Log Tab View
	@FindBy(linkText ="Call Log Tab View")
	WebElement callLogTabView;

	@FindBy(xpath ="//button[contains(normalize-space(), 'Insurance Stage')]")
	WebElement insuranceStage;

	@FindBy(xpath ="//tbody//td[1]//img")
	WebElement eyeButton;

	@FindBy(xpath ="//img[contains(@class,'email')]")
	WebElement emailButton;

	@FindBy(xpath ="//select[@id='select_type_id_email']")
	WebElement selectEmailDrp;

	@FindBy(xpath ="//button[@id='email_form_submit_btn']")
	WebElement send;

	@FindBy(xpath ="//button[@id='email_form_submit_btn']//following-sibling::button")
	WebElement emailCancel;

	@FindBy(xpath ="//tbody//td[8]")
	WebElement custEmail;

	@FindBy(xpath ="//h3[text()='Success']//following-sibling::button")
	WebElement continueButton;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement confirmDeleteButton;

	@FindBy(css = "table.w-100 tbody")
	WebElement formsTableBody;

	@FindBy(css = "img.arrow-left")
	WebElement custPageBack;

//	public EmailTemplatePage navigationToAdmin() {
//		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");
//
//		LoginPage.usernameField.sendKeys("Capture_admin");
//		LoginPage.passwordField.sendKeys("Qwerty@123");
//		LoginPage.signInButton.click();
//		return this;
//	}

	public EmailTemplatePage navigation()
	{


		try {
			jsClick(emailTemplate);

		}catch (NoSuchElementException e) {
			alchemy.click();
			jsClick(emailTemplate);
		}
		return this;
	}

	public EmailTemplatePage InputTemplateField(String tempalteName)
	{
		inputTemplateName.sendKeys(tempalteName);
		return this;
	}

	public EmailTemplatePage validateEmail(WebElement element,String Email)
	{
		try {
			create.click();
			element.sendKeys(Email);
			assertTrue(errorElement.getText().contains("Please enter a valid email address."));
		}catch (NoSuchElementException e) {
			assertTrue(false,"Error message element not found.");
		}
		return this;
	}

	public EmailTemplatePage validateDropdowns()
	{
		jsClick(emailTemplate);
		create.click();
		//		dropdownUtil(processDropdown,processExpectedOptions);
		unWait(1);
		dropdownUtil(processDropdown,"AJP");
		selectByVisibleText(processDropdown,"AJP");
		unWait(1);
		dropdownUtil(subProcessDropdown,"Sub AJP");
		selectByVisibleText(subProcessDropdown,"Sub AJP");
		unWait(1);
		dropdownUtil(subSubProcessDropdown,"Sub Sub AJP");
		selectByVisibleText(subSubProcessDropdown,"Sub Sub AJP");
		unWait(1);
		dropdownUtil(stageDropdown,"Insurance Stage");
		selectByVisibleText(stageDropdown,"Insurance Stage");
		unWait(1);
		dropdownUtil(subjectStageDropdown.get(0),"Name Of the Customer");
		unWait(1);
		dropdownUtil(templateStageDropdown.get(0),"Name Of the Customer");

		return this;
	}

	public void selectByVisibleText(WebElement select, String Value)
	{
		Select subSubProcessDrp=new Select(select);
		subSubProcessDrp.selectByVisibleText(Value);

	}

	public EmailTemplatePage smsTemplate()
	{
		navigateWithinAlchemy(driver.findElement(By.linkText("SMS Template")));
		selectByVisibleText(searchProcessDropdown,"DemoEmpH P");
//		unWaitInMilli(400);
		selectByVisibleText(searchSubProcessDropdown,"DemoEmpH S P");
//		unWaitInMilli(400);
		selectByVisibleText(searchSubSubProcessDropdown,"DemoEmpH S S P");
//		unWaitInMilli(400);
		selectByVisibleText(searchStageDropdown,"DemoEmpH Stage");


		return this;
	}




	public void printoptions(WebElement dropdown)
	{
		Select ProcessDrp=new Select(dropdown);

		for(WebElement options:ProcessDrp.getOptions())
		{
			System.out.println(options.getText());
		}
	}

	public EmailTemplatePage createEmailTemplate(
			String Process,String SubProcess,String SubSubProcess,String Stage,String TemplateName,
			String fromMail,String toMail,String CCMail,String BCC,String Subject,String Message)
	{
		jsClick(emailTemplate);
		create.click();
		//		dropdownUtil(processDropdown,processExpectedOptions);
		unWait(1);
		selectByVisibleText(processDropdown,Process);
		unWait(1);
		selectByVisibleText(subProcessDropdown,SubProcess);
		unWait(1);
		selectByVisibleText(subSubProcessDropdown,SubSubProcess);
		unWait(1);
		selectByVisibleText(stageDropdown,Stage);
		unWait(1);

		inputTemplateName.sendKeys(TemplateName);
		inputFromMail.sendKeys(fromMail);
		selectByVisibleText(toMailDropdown,toMail);
		inputCCMail.sendKeys(CCMail);
		inputBCCMail.sendKeys(BCC);
		inputSubject.sendKeys(Subject);
		inputMessage.sendKeys(Message);

		templateCreate.click();
		unWait(1);
		continueButton.click();

		//		selectByVisibleText(subjectStageDropdown,"Name Of the Customer");
		//		unWait(1);
		//		selectByVisibleText(templateStageDropdown,"Name Of the Customer");

		return this;
	}
	String CustomerEmail;
	String NameOfTheCustomer;
	String phoneNumber;
	public EmailTemplatePage navigateToCustomerProfile(String UserName)
	{
		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");

		LoginPage.usernameField.sendKeys(UserName);
		LoginPage.passwordField.sendKeys("Qwerty@123");
		LoginPage.signInButton.click();

		callLogTabView.click();
		insuranceStage.click();
		NameOfTheCustomer=driver.findElement(By.xpath("//tbody//td[5]")).getText();
		phoneNumber=driver.findElement(By.xpath("//tbody//td[7]")).getText();
		unWait(1);
		CustomerEmail=custEmail.getText();
		eyeButton.click();

		return this;
	}

	public String getFirstSelectedOption(WebElement webelement)
	{
		Select option= new Select(webelement);
		return option.getFirstSelectedOption().getText();
	}

	FetchDataFromInputTagWithJS inputTagText= new FetchDataFromInputTagWithJS();

	public EmailTemplatePage verifyTemplate(String TemplateName,
											String fromMail,String CCMail,String BCC,String Subject,String Message)
	{
		emailButton.click();
		unWait(1);
		selectByVisibleText(selectEmailDrp, TemplateName);
		unWait(1);
		String actualfromMail= inputTagText.dataPrintFromInputtag(inputFromMail,"fromMail");
		String actualCCMail=inputTagText.dataPrintFromInputtag(inputCCMail,"CCMail");
		String actualBCC=inputTagText.dataPrintFromInputtag(inputBCCMail,"BCC");
		String actualSubject=inputTagText.dataPrintFromInputtag(inputSubject,"Subject");

		assertEquals(getFirstSelectedOption(selectEmailDrp),TemplateName);
		assertEquals(fromMail,actualfromMail);
		unWait(1);
		assertEquals(CustomerEmail,getFirstSelectedOption(toMailDropdown));
		assertEquals(CCMail,actualCCMail);
		assertEquals(BCC,actualBCC);
		assertEquals(Subject,actualSubject);
		//		assertEquals(Message,inputMessage.getText());
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

	public void EditInput(WebElement element, String value)
	{
		element.clear();
		element.sendKeys(value);
	}

	public EmailTemplatePage editTemplate(String ToEdit, String editFromMail, String editToMail, String editBCCMail, String editCCMail, String EditSubject) {
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

	public EmailTemplatePage validateEditedTemplate(
			String templateName,
			String toEdit,
			String fromMail,
			String editToMail,
			String ccMail,
			String bcc,
			String subject
	) {
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






}
