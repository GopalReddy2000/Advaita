package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.bytebuddy.utility.JavaConstant.Dynamic;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;

public class SmsTemplate extends TestBase // Create_Class and extend base class
{
	public SmsTemplate() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	public static String FirstCreatedUserName;
	public static String lastcreatedsmsTemplate_messageTextfield;
	public static String selectedNumberDropdown_toNumber_SMSPopup;

	// Entirebody Click
	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']")
	public static WebElement profileDropdown;

	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown']/..//li//a)[3]")
	public static WebElement logout;

//user Login 	
	@FindBy(xpath = "//h2[text()='Sign In']")
	public static WebElement Verify_signIn;

	@FindBy(name = "username")
	public static WebElement usernameField;

	@FindBy(name = "password")
	public static WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	public static WebElement signInButton;

	// Fetch_ process , subprocess , Subsubprocess

	@FindBy(xpath = "(//input[@data-type='process']/..//span)[1]")
	public static WebElement fetchProcess;

	@FindBy(xpath = "//input[@data-type='sub_process']/..//span")
	public static WebElement FethSubProcess;

	@FindBy(xpath = "(//div[@class='content']//span)[1]")
	public static WebElement SubSubProcess;

	// Fetch SMS ation Enable in "Stages"
	@FindBy(xpath = "(//h1[text()=' Stages '])[1]")
	public static WebElement verifyStage;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	List<WebElement> stagesName;

	@FindBy(xpath = "//h2[text()='CutomerdetailsZZZ Stage']")
	public static WebElement verifyCreatedSatgeName;

	@FindBy(xpath = "//tr[td/a[contains(@href, '/en/stages/view_stages/60/')]]//img[contains(@class, 'stages_edit') and contains(@src, 'table-edit.svg')]")
	public static WebElement editButtio_stages; // Its static Edit button only for "customerdetailsZZZ"

	@FindBy(xpath = "//div[@class='Action ']//div[@id='collapseThree']//div")
	List<WebElement> stages_actions;

	@FindBy(xpath = "//a//img[@class='arrow-left']")
	public static WebElement leftArrowButton_stages;

	// sms template
	@FindBy(xpath = "//a[@id='menulist2']")
	public static WebElement alchemySidemenubar;

	@FindBy(linkText = "SMS Template")
	public static WebElement smsTemplateTab;

	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()=' SMS Template ']")
	public static WebElement smsTemplateText;

	@FindBy(linkText = "+ Create")
	public static WebElement createButtonSmsTemplate;

	@FindBy(xpath = "//h2[text()='Create SMS Template']")
	public static WebElement CreatesmstepmlateText;

	@FindBy(xpath = "//select[@id='process']")
	public static WebElement ProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process']")
	public static WebElement SubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public static WebElement SubsubProcessDropdown;

	@FindBy(xpath = "//select[@id='stage_name_id']")
	public static WebElement smsStages;

	@FindBy(xpath = "//input[@name='template_name']")
	public static WebElement smsTemplateName;

	@FindBy(name = "disposition")
	public static WebElement smsDisposition;

	@FindBy(name = "from_no")
	public static WebElement fromNumber;

	@FindBy(id = "toNumber")
	public static WebElement toNumber;

	@FindBy(xpath = "//label[text()='To Number Source']/..//select")
	public static WebElement toNumberSource;

	@FindBy(xpath = "//textarea[@name='message']")
	public static WebElement message;

	@FindBy(xpath = "//textarea[@name='remarks']")
	public static WebElement remarks;

	@FindBy(xpath = "//input[@name='temp_variable_name_1']")
	public static WebElement templateVariableName;

	@FindBy(xpath = "//select[@class='form-control stages_fields_dropsown']")
	public static WebElement stageFieldName;

	@FindBy(name = "default_val_1")
	public static WebElement defaultValue;

	@FindBy(id = "manual_id")
	public static WebElement createButton_SmsTemplatePopup;

	@FindBy(xpath = "//span[@id='change_msg']")
	public static WebElement smsTemplateCreatedSuccessfully_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public static WebElement continueButton_create;

	@FindBy(xpath = "(//a[@class='page-link']//img[@alt='right_arrow'])[2]")
	public static WebElement lastIndexArrowButton;

	@FindBy(xpath = "//tbody/tr[last()]//td") // Last created notification " entire line"
	public static WebElement last_CreatedSms; // tbody/tr[last()]//td last created notifications template

	@FindBy(xpath = "(//tbody/tr[last()]//td)[1]")
	public static WebElement lastCreatedSms_templatename;

	// user Management
	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1")
	public static WebElement verifyUserMangagemen_page;

	@FindBy(linkText = "+ Create User")
	public static WebElement usm_createButton;

	@FindBy(xpath = "//h2[text()='User']")
	public static WebElement verify_User;

	@FindBy(xpath = "//label/..//input[@id='user_name']")
	public static WebElement userName;

	@FindBy(name = "first_name")
	public static WebElement firstName;

	@FindBy(name = "last_name")
	public static WebElement lastname;

	@FindBy(name = "email")
	public static WebElement email;

	@FindBy(name = "password")
	public static WebElement password;

	@FindBy(xpath = "//input[@id='confirm_password']")
	public static WebElement conformPassword;

	@FindBy(xpath = "//select[@id='multiselect_group']")
	public static WebElement groupsLists;

	@FindBy(id = "multiselect_group_rightSelected")
	public static WebElement multiSelect_rightSelected;

	@FindBy(xpath = "//button[@class='btn-primary password_validation']")
	public static WebElement createButton_user;

	@FindBy(xpath = "//span[text()='User has been created']")
	public static WebElement userSuccessfullyCreated_popup;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public static WebElement userSuccessfullyCreated_ContinueButton;

	@FindBy(xpath = "//tbody/tr[1]//td ") // tbody/tr[1] last created user management user-name
	public static WebElement firstCreated_UserManagement;

	@FindBy(xpath = "//tbody/tr[1]//a")
	public static WebElement userMapping_USM;

	@FindBy(xpath = "(//h1[text()=' wyzmindz_solutions '])[1] ")
	public static WebElement firstCreatedUserMapping_page_USM;

	@FindBy(xpath = "(//ul[@id='pills-tab']//li//button)[2]")
	public static WebElement firstCreatedUserMapping_ProcessTAB_USM;

	@FindBy(xpath = "//a[@id='add_more']")
	public static WebElement firstCreatedUserMapping_AddrowButton;

	// user mapping

	@FindBy(xpath = "//select[@name='form-0-process_id']")
	public static WebElement userMapping_processDropdown;

	@FindBy(xpath = "//select[@name='form-0-sub_process_id']")
	public static WebElement userMapping_SubprocessDropdown;

	@FindBy(xpath = "//select[@name='form-0-s_sub_process_id']")
	public static WebElement userMapping_SubsubprocessDropdown;

	@FindBy(xpath = "//select[contains(@id,'stage_id') and not (contains(@id,'form-__prefix__')) ]")
	public static WebElement userMapping_stagesDropdown;

	@FindBy(xpath = "//input[@id='user_id']/..//button")
	public static WebElement userMapping_saveButton;

	@FindBy(xpath = "//span[text()='Created  Successfully']/..//button[text()='Continue']")
	public static WebElement userMapping_continueButton;

//System Names
	@FindBy(xpath = "//a[text()='System Names']")
	public static WebElement systemNamesTab;

	@FindBy(xpath = "(//h1[text()=' System Names '])[1]")
	public static WebElement verify_SystemName;

	@FindBy(xpath = "//a[text()='+ Create']")
	public static WebElement createButton_systemName;

	@FindBy(id = "group_name")
	public static WebElement systemNameInputField;

	@FindBy(xpath = "//button[text()='Create']")
	public static WebElement CreateButton1_systemName;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public static WebElement continueButton_SystemNames;

	@FindBy(xpath = "//tbody/tr[last()]/td[1]")
	public static WebElement verifySystemname_lastCreated;
//user page
	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()='  Call Log Tab View ']")
	public static WebElement user_callLogTabViewpage;

	@FindBy(xpath = "//ul[@id='pills-tab']//li")
	public static WebElement userAccount_Stages;

	@FindBy(xpath = "//ul[@id='pills-tab']//li//span")
	public static WebElement userAccount_StagesCount;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/div/img[@class='img-fluid cursor-pointer view_evalution eye-icon']")
	public static WebElement stagesProfileView_userAccount;

	@FindBy(xpath = "//div[contains(@class, 'social_media_images')]/img[contains(@class, 'sms_btn_click')]")
	public static WebElement SmsIcon_userAccountSatgeView;

	@FindBy(xpath = "//h2[text()='SMS']")
	public static WebElement smsPopup;

	@FindBy(xpath = "//select[@id='select_type_id']")
	public static WebElement SelectTemplateDropdown_smsPopup;

	@FindBy(xpath = "//select[@id='select_type_id']/option[last()]")
	public static WebElement lastSmsTemplateDropdown_smsPopu; // Dynamic

	@FindBy(xpath = "//label[text()='From Number']/..//input[@id='sms_from_number']")
	public static WebElement fromNumber_SmsPopup;

	@FindBy(xpath = "//select[@id='sms_to_number']")
	public static WebElement toNumberDropdown_smsPopup;

	@FindBy(xpath = "//label/..//textarea[@id='sms_msg']")
	public static WebElement messaageTextfield_smsPopu;

	@FindBy(xpath = "//ul//li//button[text()='SMS']")
	public static WebElement smsTab_stgesViewPage;

	@FindBy(xpath = "(//h2/..//..//button[text()='Send'])[1]")
	public static WebElement SendButton_smsPopup;

	@FindBy(xpath = "//tbody[@id='emailtableBody']/tr[last()]/td[2]")
	public static WebElement lastSmsRecrod_toNumberStagesProfileView;

	@FindBy(xpath = "//tbody[@id='emailtableBody']/tr[last()]/td[5]")
	public static WebElement lastSmsRecrod_DispositionStagesProfileView;

	@FindBy(xpath = "//div[@class='last-section-button']//button[text()='Save']")
	public static WebElement SaveButton_stagesProfileView;

	@FindBy(xpath = "//div[@class='last-section-button']//button[text()='Cancel']")
	public static WebElement cancelButton_SatgesProfileView;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public static WebElement continueButton_stageProfileView;

	// Super admin_edit
	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='table-edit']")
	public static WebElement lastEdit_smsTemplate;

	@FindBy(xpath = "//h2[text()='Edit SMS Template']")
	public static WebElement verify_EditsmsTemplate;

	@FindBy(xpath = "(//tbody/tr[last()]//td)[1]")
	public static WebElement beforeEdit_SmstemplateNameLast;

	@FindBy(xpath = "(//tbody/tr[last()]//td)[1]")
	public static WebElement afterEdit_SmstemplateNameLast;

	@FindBy(xpath = "//button[text()=' Update ']")
	public static WebElement UpdateButton;

	@FindBy(xpath = "//h3/..//span[text()='SMS Template has been updated successfully']")
	public static WebElement update_smsTemplateSuccessfullyPopup;

	@FindBy(xpath = "//h3/..//span[text()='SMS Template has been updated successfully']/..//button")
	public static WebElement continueButon_SmsTemplateSucessfullyUpdate;

	// Super Admin_table
	@FindBy(name = "text_search")
	public static WebElement seachTextfield_SmsTemplate;

	@FindBy(xpath = "//select[@id='process_search']")
	public static WebElement processDropdown_Table;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public static WebElement SubprocessDropdown_Table;

	@FindBy(id = "s_sub_process_search")
	public static WebElement subSubProcessDropdown_Table;

	@FindBy(xpath = "//select[@name='stage_search']")
	public static WebElement smsStages_table;

	@FindBy(xpath = "//div//button//img[@alt='filter_search']")
	public static WebElement searchbutton_Table;

	@FindBy(xpath = "//td[normalize-space(.)='No Entries Found']")
	public static WebElement noEntriesFound;

	@FindBy(xpath = "//div//img/..//h6")
	public static WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "//select[@id='page-size-select']")
	public static WebElement itemperpageDropdown;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> beforeSearchData_Table;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> afterSearchData_Table;

	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='delete-icon ']")
	public static WebElement LastDelete_smsTempalte;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public static WebElement deletePopup_smsTemplate;

	@FindBy(xpath = "//button[text()='Delete']")
	public static WebElement deleteButton_delete;

	@FindBy(xpath = "//h3/..//span[text()='Deleted Successfully']")
	public static WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public static WebElement continueButton_DeleteSuccessullyPopup;

	public void NavigateToFetchprocess() {
		driver.navigate().to("https://test.capture.autosherpas.com/en/data_management/process/");
		fetchProcess.getText();
		System.out.println("Fetchprocessname :" + fetchProcess.getText());

		fetchProcess.click();
		FethSubProcess.getText();
		System.out.println("FetchSubProcess name : " + FethSubProcess.getText());

		FethSubProcess.click();
		SubSubProcess.getText();
		System.out.println("Fetch SubSubProcessName : " + SubSubProcess.getText());

	}

	public void navigatetoStage_verifySMS() throws Throwable {
		driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");
		assertTrue(verifyStage.isDisplayed(), "verifyStage is not displayed");
		List<String> satgeNameList = new ArrayList<String>();
		for (WebElement stageName : stagesName) {
			satgeNameList.add(stageName.getText());
			System.out.println("Stages name Lists : " + stageName.getText());
		}
		// satgeNameList.contains("CutomerdetailsZZZ Stage");

		assertTrue(satgeNameList.contains("CutomerdetailsZZZ Stage"));

		if (satgeNameList.size() >= 1) {
			stagesName.get(2).click();
			System.out.println("total count : " + satgeNameList.size());

		} else {
			System.out.println("The number of matching elements is less than 1. Found: " + satgeNameList.size());

		}
		assertTrue(verifyCreatedSatgeName.isDisplayed(), "verifyCreatedSatgeName is not dispalyed");
		System.out.println("verifyCreatedSatgeName : " + verifyCreatedSatgeName.getText());

		// js.executeScript("arguments[0].scrollIntoView(true);", stages_actions);

		List<String> stagesActionList = new ArrayList<String>();
		for (WebElement stagesAction : stages_actions) {
			stagesActionList.add(stagesAction.getText());
			System.out.println("StagesActions " + stagesAction.getText());
		}

		assertTrue(stagesActionList.contains("SMS"), "Sms action not yet displayed in action table");

		assertTrue(leftArrowButton_stages.isDisplayed(), "left arrow button is not displayed");
		leftArrowButton_stages.click();

		assertTrue(verifyStage.isDisplayed(), "stagesPage not displayed");
		// ############## if required need to impliment##########################

	}

	public void navigateTo_AlchemyModule() {

		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		jsClick(driver, alchemySidemenubar);

	}

	public void navigateto_SmsTemplateTab() {

		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/sms_template_listing/");
		jsClick(driver, smsTemplateTab);
		assertTrue(smsTemplateText.isDisplayed(), "smsTemplateText is not displayed");
	}

	public void CreateSmstemplate() {
		assertTrue(createButtonSmsTemplate.isDisplayed(), "createButtonSmsTemplate is not displayed");
		// Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		createButtonSmsTemplate.click();
		wait.until(ExpectedConditions.visibilityOf(CreatesmstepmlateText));
		assertTrue(CreatesmstepmlateText.isDisplayed(), "CreatesmstepmlateText is not displayed");

	}

	public void selectProcessDropdown() {
		List<String> processDropdownList = new ArrayList<String>();
//		for (WebElement smsprocessDropdownLists : ProcessDropdown)
//		{		
//			processDropdownList.add(smsprocessDropdownLists.getText());
//			System.out.println("smsprocessDropdownList : "+smsprocessDropdownLists.getText());

//		}

		Select ProcessDropdown1 = new Select(ProcessDropdown);
		for (WebElement Options : ProcessDropdown1.getOptions()) {
			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
			System.out.println(Options.getText());
			processDropdownList.add(Options.getText());
		}
		assertTrue(processDropdownList.contains("AJP"));
		ProcessDropdown1.selectByVisibleText("AJP");
	}

	public void SelectSubProcessDropdown() throws Throwable {
		List<String> subProcessDropdownList = new ArrayList<String>();

		actions.moveToElement(driverIninteractable).perform();
		Select subProcessDropdown2 = new Select(SubProcessDropdown);
		for (WebElement options2 : subProcessDropdown2.getOptions()) {
			Thread.sleep(1000);
			System.out.println(subProcessDropdown2.getOptions());
			subProcessDropdownList.add(options2.getText());
		}

		assertTrue(subProcessDropdownList.contains("Sub AJP"));
		subProcessDropdown2.selectByVisibleText("Sub AJP");
	}

	public void selectSubSubProcess() throws Throwable {
//		List<String>subsubprocessDropdownList=new ArrayList<String>();
//		Select SubsubProcessDropdown3= new Select(SubsubProcessDropdown);
//		for (WebElement options3 : SubsubProcessDropdown3.getOptions())
//		{
//			Thread.sleep(2000);
//			System.out.println(SubsubProcessDropdown3.getOptions());
//			subsubprocessDropdownList.add(options3.getText());
//		}
//		assertTrue(subsubprocessDropdownList.contains("Sub Sub AJP"));
//		SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
//		actions.moveToElement(driverIninteractable).perform();

		List<String> subsubprocessDropdownList = new ArrayList<String>();
		boolean elementStale = true;
		int attempts = 0;

		while (elementStale && attempts < 3) {
			try {
				Select SubsubProcessDropdown3 = new Select(SubsubProcessDropdown);
				subsubprocessDropdownList.clear(); // Clear the list before each retry

				for (WebElement options3 : SubsubProcessDropdown3.getOptions()) {
					Thread.sleep(2000);
					System.out.println(options3.getText()); // Print each option's text
					subsubprocessDropdownList.add(options3.getText());
				}

				assertTrue(subsubprocessDropdownList.contains("Sub Sub AJP"));
				SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
				actions.moveToElement(driverIninteractable).perform();

				elementStale = false; // If we reach here, no exception was thrown
			} catch (StaleElementReferenceException e) {
				attempts++;
				System.out.println("Stale element reference exception. Retrying... " + attempts);
				Thread.sleep(2000); // Optional: add a wait before retrying
			}
		}

		if (elementStale) {
			throw new RuntimeException(
					"Failed to interact with the dropdown after 3 attempts due to stale element reference.");
		}
	}

	public void selectStages() {
		List<String> smsStagesLists = new ArrayList<String>();
		Select smsStagesdropdown = new Select(smsStages);
		for (WebElement smsStagesOptions : smsStagesdropdown.getOptions()) {
			System.out.println("satges Dropdown : " + smsStagesdropdown.getOptions());
			smsStagesLists.add(smsStagesOptions.getText());
		}
		assertTrue(smsStagesLists.contains("CutomerdetailsZZZ Stage"));
		smsStagesdropdown.selectByVisibleText("CutomerdetailsZZZ Stage");

	}

	public void CreateSmsTemplateContinue() {

		// SMS - Template name
		// Array of predefined SMS template names
		String[] templateNames = { "Welcome_Message", "Order_Confirmation", "Shipping_Notification", "Promotion_Offer",
				"Thank_You_Message", "Account_Verification", "Password_Reset", "Event_Invitation", "Feedback_Request",
				"Loyalty_Reward" };

		// Create a Random object
		Random random = new Random();

		// Generate a random index to select a template name
		int randomIndex = random.nextInt(templateNames.length);

		// Print the selected random template name
		String randomTemplateName = templateNames[randomIndex];
		System.out.println("Random SMS Template Name: " + randomTemplateName);

		assertTrue(smsTemplateName.isDisplayed(), " smsTemplateName is not dispalyed ");
		smsTemplateName.sendKeys(randomTemplateName);

		// Sms - disposition
		assertTrue(smsDisposition.isDisplayed(), "smsDisposition is not dispalyed");

		// Sms From number
		// Define the mobile number range
		long min = 1000000000L; // Minimum 10-digit number
		long max = 9999999999L; // Maximum 10-digit number

		// Create a Random object
		Random random1 = new Random();

		// Generate a random number within the range
		long randomNumber = min + ((long) (random1.nextDouble() * (max - min)));

		// Print the random mobile number
		System.out.println("Random Mobile Number: " + randomNumber);

		fromNumber.sendKeys(String.valueOf(randomNumber)); // String.valueOf = any thing is there convert to string
															// value

		// SMS- to Number Source
		List<String> toNumberSourceListsList = new ArrayList<String>();
		Select toNumberSourceDrodown = new Select(toNumberSource);
		for (WebElement toNumberSourceOptions : toNumberSourceDrodown.getOptions()) {
			System.out.println(" to number source dropdownsoptions : " + toNumberSourceDrodown.getOptions());
			toNumberSourceListsList.add(toNumberSourceOptions.getText());
		}
		assertTrue(toNumberSourceListsList.contains("From Stage Fields"));
		toNumberSourceDrodown.selectByVisibleText("From Stage Fields");

		// SMS - to number
		List<String> toNumberListsList = new ArrayList<String>();
		Select toNumberDrodown = new Select(toNumber);
		for (WebElement toNumberOptions : toNumberDrodown.getOptions()) {
			System.out.println(" to number dropdowns options : " + toNumberDrodown.getOptions());
			toNumberListsList.add(toNumberOptions.getText());
		}
		assertTrue(toNumberListsList.contains("Mobile number"));
		toNumberDrodown.selectByVisibleText("Mobile number");

		// SMS - message

		// Array of predefined messages
		String[] messages = { "Dear Customer, thank you for your purchase! We hope you enjoy your new product.",
				"Hello! We have an exclusive offer just for you. Visit our store to find out more!",
				"Dear Valued Customer, your order has been shipped and will arrive soon. Thank you for shopping with us!",
				"Hi there! Don't miss out on our latest discounts. Shop now and save big!",
				"Dear Customer, we appreciate your loyalty. Here's a special discount code just for you: SAVE20." };

		// Create a Random object
		Random random2 = new Random();

		// Generate a random index to select a message
		int randomIndex2 = random2.nextInt(messages.length);

		// Print the selected random message
		String randomMessage = messages[randomIndex2];
		System.out.println("Random Message: " + randomMessage);

		assertTrue(message.isDisplayed(), "message is not displayed");
		message.sendKeys(randomMessage);

		message.getText();
		System.out.println("lastcreatedsmsTemplate_messageTextfield : " + lastcreatedsmsTemplate_messageTextfield);

//Remarks
		assertTrue(remarks.isDisplayed(), "remarks is not displayed");

//template variable name
		assertTrue(templateVariableName.isDisplayed(), "templateVariableName is not displayed");

//Satge Field name
		assertTrue(stageFieldName.isDisplayed(), "stageFieldName is not displayed");

//Default value
		assertTrue(defaultValue.isDisplayed(), "defaultValue is not dispalyed");

//Create Button        
		assertTrue(createButton_SmsTemplatePopup.isDisplayed(), "createButton_SmsTemplatePopup is not displayed");
		createButton_SmsTemplatePopup.click();

		wait.until(ExpectedConditions.visibilityOf(smsTemplateCreatedSuccessfully_popuop));
		assertTrue(smsTemplateCreatedSuccessfully_popuop.isDisplayed(),
				"smsTemplateCreatedSuccessfully_popuop is not displayed");

		assertTrue(continueButton_create.isDisplayed(), "continueButton_create is not displayed");
		continueButton_create.click();

//        js.executeScript("arguments[0].scrollIntoView(true);", lastIndexArrowButton); // Scroll the webpage
//        wait.until(ExpectedConditions.visibilityOf(lastIndexArrowButton));
//        assertTrue(lastIndexArrowButton.isDisplayed(), "lastIndexArrow is not displayed");
//        lastIndexArrowButton.click();

		wait.until(ExpectedConditions.visibilityOf(last_CreatedSms));
		assertTrue(last_CreatedSms.isDisplayed(), "last_CreatedSms is not displayed");
		last_CreatedSms.getText();
		System.out.println("Last Created Smstemplate : " + last_CreatedSms.getText());

//        wait.until(ExpectedConditions.visibilityOf(lastEdit_smsTemplate));
//        assertTrue(lastEdit_smsTemplate.isDisplayed(), "lastEdit_smsTemplate is not displayed");
//        //lastEdit_smsTemplate.click();
//        jsClick(driver, lastEdit_smsTemplate);
//        lastcreatedsmsTemplate_messageTextfield=lastEdit_smsTemplate.getText();
//        System.out.println("LastCreatedSmsTemplate_messageTextfield : "+lastEdit_smsTemplate.getText());     //need to implement 1
//        

	}

	// Verify the user is able to create
	public void userManagement_create(String wyzmindz_solutions, String wyzmindz, String solutions) {

		driver.navigate().to("https://test.capture.autosherpas.com/en/user_management/users/");

		assertTrue(verifyUserMangagemen_page.isDisplayed(), "verifyUserMangagemen_page is not displayed");

//		assertTrue(usm_createButton.isDisplayed(), "usm_createButton is not displayed");
//		usm_createButton.click();
//		
//		assertTrue(verify_User.isDisplayed(), "verify_User");
//		
//		assertTrue(userName.isDisplayed(), "userName");
//		userName.sendKeys(wyzmindz_solutions);
//		
//		assertTrue(firstName.isDisplayed(), "firstName is not displayed");
//		firstName.sendKeys(wyzmindz);
//		
//		
//		assertTrue(lastname.isDisplayed(), "lastname is not displayed");
//		lastname.sendKeys(solutions);
//		
//		assertTrue(email.isDisplayed(), "email is not displayed");
//		email.sendKeys("wyzmindzsolutions@gmail.com");
//		
//		assertTrue(password.isDisplayed(), "password is not displayed");
//		password.sendKeys("Qwerty@123");
//		
//		assertTrue(conformPassword.isDisplayed(), "conformPassword is not displayed");
//		conformPassword.sendKeys("Qwerty@123");
//		
////Groups		
//		List<String>groupsListsList=new ArrayList<String>();
//		Select groupListsdropdown=new Select(groupsLists);
//		for (WebElement groupsOptions : groupListsdropdown.getOptions()) 
//		{
//			System.out.println(" GroupsOptionsLists : "+groupListsdropdown.getOptions());
//			groupsListsList.add(groupsOptions.getText());
//		}
//		assertTrue(groupsListsList.contains("Agent"));
//		groupListsdropdown.selectByVisibleText("Agent");
//		
//		assertTrue(multiSelect_rightSelected.isDisplayed(), "multiSelect_rightSelected is not displayed");
////		multiSelect_rightSelected.click();
//		ClickUtilities.clickWithRetry(multiSelect_rightSelected, 2);		
//		
//		
//		assertTrue(createButton_user.isDisplayed(), "CreateButton_user is not displayed");
//		//CreateButton_user.click();
//		click(driver, createButton_user);
//		
//		assertTrue(userSuccessfullyCreated_popup.isDisplayed(), "userSuccessfullyCreated_popup is not displayed");
//		assertTrue(userSuccessfullyCreated_ContinueButton.isDisplayed(), "userSuccessfullyCreated_ContinueButton");
//		

		// FirstCreatedUserName=firstCreated_UserManagement.getText(); global variable
		FirstCreatedUserName = firstCreated_UserManagement.getText();
		System.out.println("First Create User mangement :" + firstCreated_UserManagement.getText());

	}

	// user Mapping
	public void userMapping() throws Throwable {

		assertTrue(userMapping_USM.isDisplayed(), "userMapping_USM is not displayed");
		userMapping_USM.click();

//		assertTrue(firstCreatedUserMapping_page_USM.isDisplayed(), "firstCreatedUserMapping_page_USM is not displayed");
//		firstCreatedUserMapping_page_USM.click();
//		
//		assertTrue(firstCreatedUserMapping_ProcessTAB_USM.isDisplayed(), "firstCreatedUserMapping_ProcessTAB_USM is not displayed");
//		firstCreatedUserMapping_ProcessTAB_USM.click();
//		
//		assertTrue(firstCreatedUserMapping_AddrowButton.isDisplayed(), "firstCreatedUserMapping_AddrowButton is not displayed");
//		firstCreatedUserMapping_AddrowButton.click();
//		
//		
//		//"process" and "stages" slection for user Mapping
//		//UserMApping_Process
//		List<String>userMapping_processdropdownList=new ArrayList<String>();
//		Select userMapping_processDropdowns =new Select(userMapping_processDropdown);
//		for (WebElement Options : userMapping_processDropdowns.getOptions()) 
//		{
//			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
//			System.out.println(Options.getText());
//			userMapping_processdropdownList.add(Options.getText());
//		}
//		assertTrue(	userMapping_processdropdownList.contains("AJP")); 
//		userMapping_processDropdowns.selectByVisibleText("AJP");
//		
//	//UserMapping_Subprocess	
//		List<String>userMapping_SubprocessdropdownList=new ArrayList<String>();
//		Select userMapping_SubprocessDropdowns =new Select(userMapping_SubprocessDropdown);
//		for (WebElement Options : userMapping_SubprocessDropdowns.getOptions()) 
//		{
//			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
//			Thread.sleep(1000);
//			System.out.println("UserMapping_Subprocess	:"+"\n"+Options.getText());
//			userMapping_SubprocessdropdownList.add(Options.getText());
//		}
//		assertTrue(	userMapping_SubprocessdropdownList.contains("Sub AJP")); 
//		userMapping_SubprocessDropdowns.selectByVisibleText("Sub AJP");
//		
//	//UserMapping_SubSubProcess
//		List<String>userMapping_SubsubprocessdropdownList=new ArrayList<String>();
//		Select userMapping_SubsubprocessDropdowns =new Select(userMapping_SubsubprocessDropdown);
//		for (WebElement Options : userMapping_SubsubprocessDropdowns.getOptions()) 
//		{
//			Thread.sleep(1000);
//			System.out.println("UserMapping_SubSubProcess	:"+"\n"+Options.getText());
//			userMapping_SubsubprocessdropdownList.add(Options.getText());
//		}
//		assertTrue(	userMapping_SubsubprocessdropdownList.contains("Sub Sub AJP")); 
//		userMapping_SubsubprocessDropdowns.selectByVisibleText("Sub Sub AJP");
//		
//     //user Mpping Stages
//		List<String>UserMapping_StagesLists=new ArrayList<String>();
//		Select userMapping_Stagesdropdown=new Select(userMapping_stagesDropdown);
//		for (WebElement smsStagesOptions : userMapping_Stagesdropdown.getOptions()) 
//		{
//			System.out.println("UserMapping satges Dropdown : "+userMapping_Stagesdropdown.getOptions());
//			UserMapping_StagesLists.add(smsStagesOptions.getText());
//		}
//			assertTrue(UserMapping_StagesLists.contains("CutomerdetailsZZZ Stage"));
//			userMapping_Stagesdropdown.selectByVisibleText("CutomerdetailsZZZ Stage");
//			
//			assertTrue(userMapping_saveButton.isDisplayed(), "userMapping_saveButton is not displayed");
//			userMapping_saveButton.click();
//			
//			assertTrue(userMapping_continueButton.isDisplayed(), "userMapping_continueButton is not displayed");
//			userMapping_continueButton.click();

	}

	public void SystemName_create() {
		assertTrue(systemNamesTab.isDisplayed(), "systemNamesTab is not displayed");
		systemNamesTab.click();

		assertTrue(verify_SystemName.isDisplayed(), "verify_SystemName is not displayed");

		assertTrue(createButton_systemName.isDisplayed(), "createButton_systemName is not displayed");
		createButton_systemName.click();

		assertTrue(systemNameInputField.isDisplayed(), "systemNameInputField is not displayed");
		systemNameInputField.sendKeys("Cloud Device Category"); // 1st way
		// systemNameInputField.sendKeys(fake.lastName1()); 2nd way

		assertTrue(CreateButton1_systemName.isDisplayed(), "CreateButton1_systemName is not displayed");
		CreateButton1_systemName.click();

		wait.until(ExpectedConditions.visibilityOf(continueButton_SystemNames));
		assertTrue(continueButton_SystemNames.isDisplayed(), "continueButton_SystemNames is not displayed");
		continueButton_SystemNames.click();

		assertTrue(verifySystemname_lastCreated.isDisplayed(), "verifySystemname_lastCreated is not displayed");
		verifySystemname_lastCreated.getText();
		System.out.println("LastCreated System Name : " + verifySystemname_lastCreated.getText());

		assertEquals(verifySystemname_lastCreated.getText(), "Cloud Device Category"); // 1st way
																						// 2nd way

		// Logout
		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
		profileDropdown.click();

		assertTrue(logout.isDisplayed(), "logout is not displayed");
		logout.click();
	}

	// SignIn
	public void loginas_UserCredentials() throws Throwable {
		assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");
		assertTrue(usernameField.isDisplayed(), "usernameField is not displayed");
		usernameField.sendKeys("wyzmindz_solutions");

		assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
		passwordField.sendKeys("Qwerty@123");

		assertTrue(signInButton.isDisplayed(), "signInButton is not displayed");
		signInButton.click();

		assertTrue(user_callLogTabViewpage.isDisplayed(), "user_callLogTabViewpage is not displayed");
		user_callLogTabViewpage.getText();

		// Assume this is the number we are checking
		int number = 100;
		// Check if the number is not equal to zero
		if (number != 0) {
			// Click the element
			userAccount_StagesCount.click();
			System.out.println("Element clicked because the number is not zero.");
		} else {
			System.out.println("Number is zero, element not clicked.");
		}

		// Stages profile view
		assertTrue(stagesProfileView_userAccount.isDisplayed(), "stagesProfileView_userAccount is not displayed");
		stagesProfileView_userAccount.click();

		assertTrue(SmsIcon_userAccountSatgeView.isDisplayed(), "SmsIcon_userAccountSatgeView is not displayed");
		SmsIcon_userAccountSatgeView.click();

		wait.until(ExpectedConditions.visibilityOf(smsPopup));
		assertTrue(smsPopup.isDisplayed(), "smsPopup is not displayed");

		// Select sms Template from dropdwon
		List<String> templateList_smsPopup = new ArrayList<String>();
		Select templateDropdownList_smsPopup = new Select(SelectTemplateDropdown_smsPopup);
		for (WebElement toNumberSourceOptions : templateDropdownList_smsPopup.getOptions()) {
			System.out
					.println(" template name Dorpdown From Sms Popup : " + templateDropdownList_smsPopup.getOptions());
			templateList_smsPopup.add(toNumberSourceOptions.getText());
		}

//            assertTrue(templateList_smsPopup.contains("Offer letter"));
//            templateDropdownList_smsPopup.selectByVisibleText("Offer letter"); 

		// templateDropdownList_smsPopup.selectByIndex(-1);
		// templateDropdownList_smsPopup.selectByIndex(((List<String>) options).size() -
		// 1);

		List<WebElement> options = templateDropdownList_smsPopup.getOptions();
		// Select the last option by index
		if (options.size() > 0) {
			int lastIndex = options.size() - 1;
			templateDropdownList_smsPopup.selectByIndex(lastIndex);
		} else {
			System.out.println("No options available in the dropdown.");
		}

		wait.until(ExpectedConditions.visibilityOf(fromNumber_SmsPopup));
		assertTrue(fromNumber_SmsPopup.isDisplayed(), "fromNumber_SmsPopup is not displayed");
		System.out.println("fromNumber text in sms Popup  : " + fromNumber_SmsPopup.getText());

		// to Number Dropdwon In SmsPopuo
		List<String> toNumberList_smsPopup = new ArrayList<String>();
		Select toNumberDropdownList_smsPopup = new Select(toNumberDropdown_smsPopup);
		for (WebElement toNumberSourceOptions : toNumberDropdownList_smsPopup.getOptions()) {
			System.out.println(" toNumbeDorpdown From SmsPopup : " + toNumberDropdownList_smsPopup.getOptions());
			templateList_smsPopup.add(toNumberSourceOptions.getText());
		}
//            assertTrue(toNumberList_smsPopup.contains("7685612345"));
//            toNumberDropdownList_smsPopup.selectByVisibleText("7685612345"); 
		toNumberDropdownList_smsPopup.selectByIndex(0);
		selectedNumberDropdown_toNumber_SMSPopup = toNumberDropdownList_smsPopup.getFirstSelectedOption().getText(); // want
																														// we
																														// can
																														// delete
																														// "Doubt
																														// "

		assertTrue(messaageTextfield_smsPopu.isDisplayed(), "messaageTextfield_smsPopu is not displayed");

		// equal last created sms "message field" and sending sms "message" field

		// assertEquals(lastcreatedsmsTemplate_messageTextfield,
		// messaageTextfield_smsPopu.getText()); //need to implement 1

		assertTrue(SendButton_smsPopup.isDisplayed(), "SendButton_smsPopup is not displayed");
		SendButton_smsPopup.click();

		js.executeScript("arguments[0].scrollIntoView(true);", smsTab_stgesViewPage);
		wait.until(ExpectedConditions.visibilityOf(smsTab_stgesViewPage));
		assertTrue(smsTab_stgesViewPage.isDisplayed(), "smsTab_stgesViewPage is not displayed");
		smsTab_stgesViewPage.click();

		js.executeScript("arguments[0].scrollIntoView(true);", lastSmsRecrod_toNumberStagesProfileView);
		assertEquals(lastSmsRecrod_toNumberStagesProfileView.getText(), selectedNumberDropdown_toNumber_SMSPopup);

		assertTrue(lastSmsRecrod_DispositionStagesProfileView.isDisplayed(),
				"lastSmsRecrod_DispositionStagesProfileView is not displayed");
		System.out.println(
				"lastSmsRecrod_DispositionStagesProfileView : " + lastSmsRecrod_DispositionStagesProfileView.getText());

//           assertTrue(SaveButton_stagesProfileView.isDisplayed(), "SaveButton_stagesProfileView is not displayed");
//           SaveButton_stagesProfileView.click();
//           
//           wait.until(ExpectedConditions.visibilityOf(continueButton_stageProfileView));
//           assertTrue(continueButton_stageProfileView.isDisplayed(), "continueButton_stageProfileView is not displayed");
//           continueButton_stageProfileView.click();                                                 //need to impliment lated

		assertTrue(cancelButton_SatgesProfileView.isDisplayed(), "cancelButton_SatgesProfileView is not displayed");
		cancelButton_SatgesProfileView.click();

		// User Logout
		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
		profileDropdown.click();

		assertTrue(logout.isDisplayed(), "logout is not displayed");
		logout.click();
	}

	// Table page
	// Again login to "Super admin"
	public void searchThrough_processes() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(alchemySidemenubar));
		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		jsClick(driver, alchemySidemenubar);

		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/sms_template_listing/");
		jsClick(driver, smsTemplateTab);
		assertTrue(smsTemplateText.isDisplayed(), "smsTemplateText is not displayed");

		// before SearchData
		List<String> beforeSearchDataLists_Table = new ArrayList<String>();
		for (WebElement beforeSearchData_Table : beforeSearchData_Table) {
			beforeSearchDataLists_Table.add(beforeSearchData_Table.getText());
			System.out.println("before search data  :" + beforeSearchData_Table.getText());
		}

		List<String> processDropdown1List_Table = new ArrayList<String>();
		Select processDropdown1_Table = new Select(processDropdown_Table);
		for (WebElement Options : processDropdown1_Table.getOptions()) {
			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
			System.out.println(Options.getText());
			processDropdown1List_Table.add(Options.getText());
		}
		assertTrue(processDropdown1List_Table.contains("AJP"));
		processDropdown1_Table.selectByVisibleText("AJP");

		List<String> subProcessDropdown2List_Table = new ArrayList<String>();
		actions.moveToElement(driverIninteractable).perform();
		Select subProcessDropdown2_Table = new Select(SubprocessDropdown_Table);
		for (WebElement options2 : subProcessDropdown2_Table.getOptions()) {
			Thread.sleep(1000);
			System.out.println(subProcessDropdown2_Table.getOptions());
			subProcessDropdown2List_Table.add(options2.getText());
		}

		assertTrue(subProcessDropdown2List_Table.contains("Sub AJP"));
		subProcessDropdown2_Table.selectByVisibleText("Sub AJP");

		List<String> subsubprocessDropdown3List_Table = new ArrayList<String>();
		boolean elementStale = true;
		int attempts = 0;

		while (elementStale && attempts < 3) {
			try {
				Select subsubProcessDropdown3_Table = new Select(subSubProcessDropdown_Table);
				subsubprocessDropdown3List_Table.clear(); // Clear the list before each retry

				for (WebElement options3 : subsubProcessDropdown3_Table.getOptions()) {
					Thread.sleep(2000);
					System.out.println(options3.getText()); // Print each option's text
					subsubprocessDropdown3List_Table.add(options3.getText());

				}

				assertTrue(subsubprocessDropdown3List_Table.contains("Sub Sub AJP"));
				subsubProcessDropdown3_Table.selectByVisibleText("Sub Sub AJP");
				actions.moveToElement(driverIninteractable).perform();

				elementStale = false; // If we reach here, no exception was thrown
			} catch (StaleElementReferenceException e) {
				attempts++;
				System.out.println("Stale element reference exception. Retrying... " + attempts);
				Thread.sleep(2000); // Optional: add a wait before retrying
			}
		}

		if (elementStale) {
			throw new RuntimeException(
					"Failed to interact with the dropdown after 3 attempts due to stale element reference.");
		}

		List<String> smsStagesLists = new ArrayList<String>();
		Select smsStagesdropdown = new Select(smsStages_table);
		for (WebElement smsStagesOptions : smsStagesdropdown.getOptions()) {
			System.out.println("satges Dropdown : " + smsStagesdropdown.getOptions());
			smsStagesLists.add(smsStagesOptions.getText());
		}
		assertTrue(smsStagesLists.contains("CutomerdetailsZZZ Stage"));
		smsStagesdropdown.selectByVisibleText("CutomerdetailsZZZ Stage");

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		searchbutton_Table.click();

		// after SearchData
		List<String> afterSearchDataLists_Table = new ArrayList<String>();
		for (WebElement afterSearchData_Table : beforeSearchData_Table) {
			afterSearchDataLists_Table.add(afterSearchData_Table.getText());
			System.out.println("After search based on process :" + afterSearchData_Table.getText());
		}

		assertEquals(beforeSearchDataLists_Table, afterSearchDataLists_Table);

		assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not dislayed");

	}

	// Verifythe user is able to Clearall filters
	public void ClearFilters() {
		Select processdropdown_tablePage = new Select(processDropdown_Table);
		processdropdown_tablePage.selectByVisibleText("AJP");
		processdropdown_tablePage.getFirstSelectedOption();
		System.out.println("first SelectedOption afterSelect Process Dropdown"
				+ processdropdown_tablePage.getFirstSelectedOption());

		Select subProcessdropdown_tablePage = new Select(SubprocessDropdown_Table);
		subProcessdropdown_tablePage.selectByVisibleText("Sub AJP");
		subProcessdropdown_tablePage.getFirstSelectedOption();
		System.out.println(" first  SelectedOption afterSelect SubProcess Dropdown : "
				+ subProcessdropdown_tablePage.getFirstSelectedOption());

		Select subSubProcessdropdown_tablePage = new Select(subSubProcessDropdown_Table);
		subSubProcessdropdown_tablePage.selectByVisibleText("Sub Sub AJP");
		subSubProcessdropdown_tablePage.getFirstSelectedOption();
		System.out.println(" first SelectedOption afterSelect SubProcess Dropdown : "
				+ subSubProcessdropdown_tablePage.getFirstSelectedOption());

		assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not displayed");
		clearAllFiltersButton_Table.click();

		processdropdown_tablePage.getFirstSelectedOption();
		System.out.println(
				"After clear first selected option of process : " + processdropdown_tablePage.getFirstSelectedOption());

		subProcessdropdown_tablePage.getFirstSelectedOption();
		System.out.println("After clear first selected option of Subprocess "
				+ subProcessdropdown_tablePage.getFirstSelectedOption());

		subSubProcessdropdown_tablePage.getFirstSelectedOption();
		System.out.println("After clear first selected option of Subprocess : "
				+ subSubProcessdropdown_tablePage.getFirstSelectedOption());
	}

	public void SearchThroughSearchField() throws Throwable {
		Thread.sleep(1000);
		String lastCreatedsmsTemplate = lastCreatedSms_templatename.getText();
		System.out.println("lastCreatedsmsTemplate : " + lastCreatedsmsTemplate);

		assertTrue(seachTextfield_SmsTemplate.isDisplayed(), lastCreatedsmsTemplate);
		lastCreatedsmsTemplate.isEmpty();
		seachTextfield_SmsTemplate.sendKeys(lastCreatedsmsTemplate);

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		searchbutton_Table.click(); // need to implement

		assertTrue(noEntriesFound.isDisplayed(), "noEntriesFound is not displayed");
		assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not displayed");
		clearAllFiltersButton_Table.click();
		assertTrue(smsTemplateText.isDisplayed(), "smsTemplateText is not displayed");
	}

	public void Delete_createdSmsTemplate() {
		assertTrue(LastDelete_smsTempalte.isDisplayed(), "LastDelete_smsTempalteis not displayed");
		// LastDelete_smsTempalte.click();
		jsClick(driver, LastDelete_smsTempalte);

		assertTrue(deleteButton_delete.isDisplayed(), "deleteButton_delete is not displayed");
		deleteButton_delete.click();

		wait.until(ExpectedConditions.visibilityOf(deleted_SuceessfullyPopup));
		assertTrue(deleted_SuceessfullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is not displayed");
		deleted_SuceessfullyPopup.click();

		assertTrue(continueButton_DeleteSuccessullyPopup.isDisplayed(),
				"continueButton_DeleteSuccessullyPopup is not displayed ");
		continueButton_DeleteSuccessullyPopup.click();
	}

	// EDIT
	public void Edit_smsTemplated() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(alchemySidemenubar));
		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		jsClick(driver, alchemySidemenubar);

		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/sms_template_listing/");
		jsClick(driver, smsTemplateTab);
		assertTrue(smsTemplateText.isDisplayed(), "smsTemplateText is not displayed");

		Thread.sleep(1000);
		String beforeEdit_SmsTemplatenameLast_smsTemplate = beforeEdit_SmstemplateNameLast.getText();
		System.out.println("beforeEdit_SmstemplateNameLast : " + beforeEdit_SmsTemplatenameLast_smsTemplate);

		assertTrue(lastEdit_smsTemplate.isDisplayed(), "lastEdit_smsTemplate is not displayed");
		lastEdit_smsTemplate.click();

		wait.until(ExpectedConditions.visibilityOf(verify_EditsmsTemplate));
		assertTrue(verify_EditsmsTemplate.isDisplayed(), "verify_EditsmsTemplate is not displayed");

		assertTrue(smsTemplateName.isDisplayed(), "smsTemplateName is snot displayed");
		assertEquals(beforeEdit_SmsTemplatenameLast_smsTemplate, smsTemplateName.getAttribute("value"));
		System.out.println("sms template attribute value" + smsTemplateName.getAttribute("value"));
		smsTemplateName.clear();
		smsTemplateName.sendKeys(fake.lastName1());

		assertTrue(message.isDisplayed(), "message i snot displayed");
		message.clear();
		message.sendKeys(fake.lastName1());

		assertTrue(UpdateButton.isDisplayed(), "UpdateButton is not displayed");
		UpdateButton.click();

		wait.until(ExpectedConditions.visibilityOf(update_smsTemplateSuccessfullyPopup));
		assertTrue(update_smsTemplateSuccessfullyPopup.isDisplayed(),
				"update_smsTemplateSuccessfullyPopup is not displayed");
		update_smsTemplateSuccessfullyPopup.click();

		assertTrue(continueButon_SmsTemplateSucessfullyUpdate.isDisplayed(),
				"continueButon_SmsTemplateSucessfullyUpdate is not displayed");
		continueButon_SmsTemplateSucessfullyUpdate.click();

		assertTrue(smsTemplateText.isDisplayed(), "smsTemplateText is not displayed");

		Thread.sleep(1000);
		String afterEdit_SmsTemplateNameLast_smstemplate = afterEdit_SmstemplateNameLast.getText();
		System.out.println("afterEdit_SmstemplateNameLast :" + afterEdit_SmsTemplateNameLast_smstemplate);

		assertNotEquals(beforeEdit_SmsTemplatenameLast_smsTemplate, afterEdit_SmsTemplateNameLast_smstemplate);

	}

	public void SendSmsTroughSystemName() {

	}

}
