package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;

public class NotificationTemplate extends TestBase {

	FakeData fake = new FakeData();

	public NotificationTemplate() {
		PageFactory.initElements(driver, this);

	}

	String userId = "Wyzmindz_solutions";
	String userPassword = "Qwerty@123";

	// EntireBodyClick
	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	List<String> metaDataLists;
	public static String templateTextStringValue;
	public static String MessageTextStringValue;
	List<String> beforeSearchDataLists_Table;
	List<String> afterSearchDataLists_Table;

	public static String last_CreatedNotificationTemplate;

	public static String beforeSelectProcessdropdown1Options;
	public static String afterSelectProcessdropdown1Options;

	public static String beforeSelectSubProcessdropdown2Options;
	public static String afterSelectSubProcessdropdown2Options;

	public static String beforeSelectSubSubProcessdropdown3Options;
	public static String afterSelectSubSubProcessdropdown3Options;

	// user account
	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()='  Call Log Tab View ']")
	public static WebElement user_callLogTabViewpage;

	@FindBy(xpath = "//ul[@id='pills-tab']//li//span")
	public static WebElement userAccount_StagesCount;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/div/img[@class='img-fluid cursor-pointer view_evalution eye-icon']")
	public static WebElement stagesProfileView_userAccount;

	@FindBy(xpath = "//tbody//td/../..//tr[1]//td[9]")
	public static WebElement transuniquID_userAccount;

	@FindBy(xpath = "//input[@placeholder='HH:MM']")
	public static WebElement TimeInputPicker;

	@FindBy(xpath = "//input[@id='startDate']")
	public static WebElement DateInputPicker;

	@FindBy(xpath = "//div[contains(@class, 'datepicker')]")
	public static WebElement DatePicker;

	@FindBy(xpath = "//h6[text()='Disposition']")
	public static WebElement disositionTab;

	@FindBy(xpath = "(//label[@class='radio w-40'])[]")
	public static WebElement autoRadioButton;

	@FindBy(xpath = "(//label[@class='radio w-40'])[2]")
	public static WebElement manualRadioButton;

	@FindBy(xpath = "(//label[@class='radio processss'])[1]")
	public static WebElement withinProcessRadioButton;

	@FindBy(xpath = "(//label[@class='radio processss'])[2]")
	public static WebElement outsideProcessRadioButton;

	@FindBy(xpath = "//span[@class='select2-results']//ul//li")
	public static List<WebElement> selectStage_disposition;

	
	//SuperAdmin Admin
	@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']//span[text()='Admin Super Admin']")
	public static WebElement profileDropdown;
	
	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown']/..//li//a)[3]")
	public static WebElement logout;
	
	

	// user Login
	@FindBy(xpath = "//h2[text()='Sign In']")
	public static WebElement Verify_signIn;

	@FindBy(name = "username")
	public static WebElement usernameField;

	@FindBy(name = "password")
	public static WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	public static WebElement signInButton;

//	@FindBy(xpath = "//div[contains(@class,'section-A-scroll')]//div//div//label/..//input/..//label[text()='Trans Unique Id']/..//h6")
//	public static WebElement transUniqueId_stageProfileView;

	@FindBy(xpath = "//input/..//label[text()='Trans Unique Id']/..//h6")
	public static WebElement transUniqueId_stageProfileView;

	// Fetch_ process , subprocess , Subsubprocess

	@FindBy(xpath = "(//input[@data-type='process']/..//span)[1]")
	public static WebElement fetchProcess;

	@FindBy(xpath = "//input[@data-type='sub_process']/..//span")
	public static WebElement FethSubProcess;

	@FindBy(xpath = "(//div[@class='content']//span)[1]")
	public static WebElement SubSubProcess;

	// DataSetup_metadat
	@FindBy(xpath = "//button[@id='pills-metadata-tab']")
	public static WebElement metaDataTab;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	List<WebElement> MetaDataName;

	@FindBy(xpath = "(//table[@class='w-100']//tbody//td[1])[last()-1]")
	public static WebElement SlastCretedMetadata;

	@FindBy(xpath = "(//h1[text()=' Metadata Management '])[1]")
	public static WebElement verifyMetaDataManagement;

	@FindBy(xpath = "//tbody[@class='view_all_colmns']//tr//td[2]")
	List<WebElement> MetaDataList;

	@FindBy(xpath = "//div[@class='last-section-button']//button[text()='Cancel']")
	public static WebElement cancelButtonMetaData;

	// Fetch"Stages"
	@FindBy(xpath = "(//h1[text()=' Stages '])[1]")
	public static WebElement verifyStage;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	List<WebElement> stagesName;

	// measurableSet
	@FindBy(xpath = "//button[@id='pills-MasterParameter-tab']")
	public static WebElement measurableParameterTab;

	@FindBy(xpath = "//h1[text()=' Master Parameter '][1]")
	public static WebElement verifyMasterParameter;

	@FindBy(xpath = "//button[@id='pills-MeasurableSet-tab']")
	public static WebElement measurableTab;

	@FindBy(linkText = "+ Add Measurable Set")
	public static WebElement addMeasurableSet;

	@FindBy(xpath = "//h2[text()='Create Question Set']")
	public static WebElement verifyCreateQuestionSet;

	@FindBy(xpath = "(//a[text()='Add Question'])[1]")
	public static WebElement addQuestion;

	@FindBy(xpath = "//input[@id='questionSet_name']")
	public static WebElement questionSetName;

	@FindBy(xpath = "//div[@class='questionset_form left_section_1']")
	public static WebElement Section1;

	@FindBy(xpath = "//div[@class='questionset_form left_section_1']//input[@name='question_1_1']")
	public static WebElement Question1;

	@FindBy(xpath = "(//div[@class='row firstquestion-function'])[1]//a")
	List<WebElement> selectQuestionTypElements;

	// Notification Template

	@FindBy(xpath = "//a[@id='menulist2']")
	public static WebElement alchemySidemenubar;

	@FindBy(linkText = "Notification Template")
	public static WebElement notificationTemplate_Tab;

	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()=' Notifications']")
	public static WebElement notificationTemplateText;

	@FindBy(linkText = "+ Create")
	public static WebElement createButtonNotificationTemplate;

	@FindBy(xpath = "//h2[text()='Create Notification Template']")
	public static WebElement CreateNotificationTepmlateTpopUp;

	@FindBy(xpath = "//select[@id='process']")
	public static WebElement ProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process']")
	public static WebElement SubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public static WebElement SubsubProcessDropdown;

	@FindBy(xpath = "//select[@id='stage_name_id']")
	public static WebElement notificationStagesDropdown;

	@FindBy(xpath = "//input[@name='template_name']")
	public static WebElement notificationTemplateName;

	@FindBy(xpath = "//select[@name='notification_date']")
	public static WebElement notificationDate;

	@FindBy(xpath = "//select[@name='notification_time']")
	public static WebElement notificationTime;

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
	public static WebElement createButton_NotificatioTemplatePopup;

	@FindBy(xpath = "//span[@id='change_msg']")
	public static WebElement notificationTemplateCreatedSuccessfully_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public static WebElement continueButton_create;

	@FindBy(xpath = "//tbody/tr[last()]//td[1]") // Last created sms " entire line"
	public static WebElement last_CreatedNotifications;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> beforeSearchData_Table;

	// notificationTemplate Table

	@FindBy(name = "text_search")
	public static WebElement seachTextfield_NotificationTemplate;

	@FindBy(xpath = "//select[@id='process_search']")
	public static WebElement ProcessDropdown_table;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public static WebElement SubProcessDropdown_table;

	@FindBy(xpath = "//select[@id='s_sub_process_search']")
	public static WebElement subSubProcessDropdown_table;

	@FindBy(xpath = "//select[@id='stage_search']")
	public static WebElement notificationStages_table;

	@FindBy(xpath = "//div//button//img[@alt='filter_search']")
	public static WebElement searchbutton_Table;

	@FindBy(xpath = "//div//img/..//h6")
	public static WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='delete-icon']")
	public static WebElement LastDelete_NotificationTempalte;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public static WebElement deletePopup_NotificationTemplate;

	@FindBy(xpath = "//button[text()='Delete']")
	public static WebElement deleteButton_delete;

	@FindBy(xpath = "//h3/..//span[@id='change_msg']")
	public static WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public static WebElement continueButton_DeleteSuccessullyPopup;

	// EDIT

	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='table-edit']")
	public static WebElement LastEdit_NotificationTempalte;

	@FindBy(xpath = "//h2[text()='Edit Notification Template']")
	public static WebElement verify_EditNotificationTemplate;

	@FindBy(xpath = "//input[@name='template_name']")
	public static WebElement EditTemplateName;

	@FindBy(xpath = "//textarea[@name='message']")
	public static WebElement editMessageTextfield;

	@FindBy(xpath = "//button[text()=' Update ']")
	public static WebElement updateButton;

	@FindBy(xpath = "//h3/..//span[@id='change_msg']")
	public static WebElement UpdateNotification_SuceessfullyPopup;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public static WebElement continueButton_Edit;

	public void NavigateToProcess() {
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

	public void FetchMetaData() throws Throwable {
		assertTrue(metaDataTab.isDisplayed(), "metaDataTab is not displayed");
		metaDataTab.click();

		assertTrue(verifyMetaDataManagement.isDisplayed(), "verifyMetaDataManagement is not displayed");
		System.out.println("verifyMetaDataManagement : " + verifyMetaDataManagement.getText());

		List<String> metaDataNameList = new ArrayList<String>();
		for (WebElement metadataName : MetaDataName) {
			metaDataNameList.add(metadataName.getText());
			System.out.println("metaDataNameList :" + metadataName.getText());

		}

		assertTrue(metaDataNameList.containsAll(metaDataNameList));
		System.out.println(metaDataNameList.containsAll(metaDataNameList));
		metaDataNameList.size();

		assertTrue(metaDataNameList.contains("CsutomerdetailsZZZMF_metadata"),
				"CsutomerdetailsZZZMF_metadata not displayed");

		if (metaDataNameList.size() == 3) {
			for (WebElement metadataName : MetaDataName) {
				metadataName.click();
			}
		}

		js.executeScript("arguments[0].scrollIntoView(true);", SlastCretedMetadata);
		assertTrue(SlastCretedMetadata.isDisplayed(), "SlastCretedMetadata is not displayed");
		// SlastCretedMetadata.click();
		jsClick(driver, SlastCretedMetadata);

		String metaDataURL = driver.getCurrentUrl();
		System.out.println("metaDataURL :" + metaDataURL);

		metaDataLists = new ArrayList<String>(); // in this variable all "metadatfieldlists" are present

		for (WebElement metaDataElementLists : MetaDataList) {
			Thread.sleep(1000);
			metaDataLists.add(metaDataElementLists.getText()); // Create global varialbe " metadata" list
			System.out.println("metaDataElementLists :" + metaDataElementLists.getText());
		}
		assertTrue(metaDataLists.containsAll(metaDataLists));
		System.out.println("metaDataElementListsText" + metaDataLists.containsAll(metaDataLists));

		assertTrue(cancelButtonMetaData.isDisplayed(), "cancelButtonMetaData is not displayed");
		cancelButtonMetaData.click();

		assertTrue(verifyMetaDataManagement.isDisplayed(), "verifyMetaDataManagementis not displayed");

	}

	public void FetchStages() {
		driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");

		assertTrue(verifyStage.isDisplayed(), "verifyStageis not displayed");
		System.out.println("verifyStage text : " + verifyStage.getText());

		List<String> satgeNameList = new ArrayList<String>();
		for (WebElement stageName : stagesName) {
			satgeNameList.add(stageName.getText());
			System.out.println("Stages name Lists : " + stageName.getText());

		}
		assertTrue(satgeNameList.containsAll(satgeNameList));
		assertTrue(satgeNameList.contains("CutomerdetailsZZZ Stage"));
	}

	////// MeasurableSet////

	public void navigateTo_AlchemyModule() {

		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		String alchemyCurrentUrl = driver.getCurrentUrl();
		System.out.println("alchemyCurrentUrl : " + alchemyCurrentUrl);

	}

	public void NavigateToNotificationtemplate() throws Throwable {

		assertTrue(notificationTemplate_Tab.isDisplayed(), "notificationTemplate_Tab is not displayed");
		// notificationTemplate_Tab.click();
		jsClick(driver, notificationTemplate_Tab);
		// driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/cre_notification/");

		String notificationURL = driver.getCurrentUrl();
		System.out.println("notificationURL :" + notificationURL);

		assertTrue(notificationTemplateText.isDisplayed(), "notificationTemplateText is not displayed");

	}

	public void CreateNotificationTemplate() throws Throwable {

		assertTrue(createButtonNotificationTemplate.isDisplayed(), "createButtonNotificationTemplate is displayed");
		createButtonNotificationTemplate.click();

		wait.until(ExpectedConditions.visibilityOf(CreateNotificationTepmlateTpopUp));
		assertTrue(CreateNotificationTepmlateTpopUp.isDisplayed(), "CreateNotificationTepmlateText is not displayed");

		// Process
		List<String> processDropdownList = new ArrayList<String>();
		Select ProcessDropdown1 = new Select(ProcessDropdown);
		for (WebElement Options : ProcessDropdown1.getOptions()) {
			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
			System.out.println(Options.getText());
			processDropdownList.add(Options.getText());
		}
		assertTrue(processDropdownList.contains("AJP"));

		beforeSelectProcessdropdown1Options = ProcessDropdown1.getFirstSelectedOption().getText();
		System.out.println("beforeSelectProcessdropdown1Options: " + beforeSelectProcessdropdown1Options);

		ProcessDropdown1.selectByVisibleText("AJP");

		afterSelectProcessdropdown1Options = ProcessDropdown1.getFirstSelectedOption().getText();
		System.out.println("afterSelectProcessdropdown1Options:" + afterSelectProcessdropdown1Options);

		assertNotEquals(beforeSelectProcessdropdown1Options, afterSelectProcessdropdown1Options);

		// Subprocess
		List<String> subProcessDropdownList = new ArrayList<String>();

		actions.moveToElement(driverIninteractable).perform();
		Select subProcessDropdown2 = new Select(SubProcessDropdown);
		for (WebElement options2 : subProcessDropdown2.getOptions()) {
			// Thread.sleep(1000);
			System.out.println(subProcessDropdown2.getOptions());
			subProcessDropdownList.add(options2.getText());
		}

		assertTrue(subProcessDropdownList.contains("Sub AJP"));

		beforeSelectSubProcessdropdown2Options = subProcessDropdown2.getFirstSelectedOption().getText();
		System.out.println("beforeSelectSubProcessdropdown2Options: " + beforeSelectSubProcessdropdown2Options);

		subProcessDropdown2.selectByVisibleText("Sub AJP");
		// subProcessDropdown2.selectByIndex(1);

		afterSelectSubProcessdropdown2Options = subProcessDropdown2.getFirstSelectedOption().getText();
		System.out.println("afterSelectSubProcessdropdown2Options:" + afterSelectSubProcessdropdown2Options);

		// SubSubprocess
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

				beforeSelectSubSubProcessdropdown3Options = SubsubProcessDropdown3.getFirstSelectedOption().getText();
				System.out.println(
						"beforeSelectSubSubProcessdropdown3Options: " + beforeSelectSubSubProcessdropdown3Options);

				SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
				// SubsubProcessDropdown3.selectByIndex(1);
				actions.moveToElement(driverIninteractable).perform();

				afterSelectSubSubProcessdropdown3Options = SubsubProcessDropdown3.getFirstSelectedOption().getText();
				System.out.println(
						"afterSelectSubSubProcessdropdown3Options:" + afterSelectSubSubProcessdropdown3Options);

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

		// select Satges
		List<String> smsStagesLists = new ArrayList<String>();
		Select NotifationStagesdropdown = new Select(notificationStagesDropdown);
		for (WebElement smsStagesOptions : NotifationStagesdropdown.getOptions()) {
			System.out.println("satges Dropdown : " + NotifationStagesdropdown.getOptions());
			smsStagesLists.add(smsStagesOptions.getText());
		}
		assertTrue(smsStagesLists.contains("CutomerdetailsZZZ Stage"));

		String beforeSelectStagesDPOption = NotifationStagesdropdown.getFirstSelectedOption().getText();
		System.out.println("beforeSelectStagesDPOption: " + beforeSelectStagesDPOption);

		NotifationStagesdropdown.selectByVisibleText("CutomerdetailsZZZ Stage");

		String afterSelectNotificationDPOption = NotifationStagesdropdown.getFirstSelectedOption().getText();
		System.out.println("afterSelectNotificationDPOption:" + afterSelectNotificationDPOption);

		assertNotEquals(beforeSelectStagesDPOption, afterSelectNotificationDPOption);

		// template Name
		assertTrue(notificationTemplateName.isDisplayed(), "notificationTemplateName is not displyed");

		String[] templateNames = { "Flash_Sale_Alert", "Membership_Renewal_Reminder", "Event_Registration_Confirmation",
				"Shipping_Notification", "Password_Reset_Alert", "Account_Verification", "New_Feature_Announcement",
				"Billing_Statement_Notification", "Order_Confirmation", "Gift_Card_Redeemed", "Appointment_Reminder",
				"Service_Appointment_Confirmation", "Promotion_Alert", "Subscription_Expiration_Notice",
				"Content_Download_Link", "New_Message_Notification", "Account_Security_Update", "VIP_Access_Granted",
				"Reorder_Reminder", "Limited_Time_Discount", "Maintenance_Scheduled_Notification", "Security_Alert",
				"Invite_Friend_Notification", "Trial_Expiry_Notice", "Important_Update", "Out_of_Stock_Notice",
				"Price_Drop_Alert", "Content_Sharing_Notification", "Upgrade_Available_Notification",
				"Customer_Experience_Survey", "Promotional_Campaign_Alert", };

		// Create a Random object
		Random random = new Random();

		// Generate a random index to select a template name
		int randomIndex = random.nextInt(templateNames.length);

		// Print the selected random template name
		String randomTemplateName = templateNames[randomIndex];
		System.out.println("Random SMS Template Name: " + randomTemplateName);

//				String templateTextString = notificationTemplateName.getAttribute("value"); //1st way
//				System.out.println(templateTextString);

		assertTrue(notificationTemplateName.getAttribute("value").isEmpty(),
				"notificationTemplateName field is not emplety"); // 2ndway

		notificationTemplateName.sendKeys(randomTemplateName);

		templateTextStringValue = notificationTemplateName.getAttribute("value"); // 1st way "Global variable"
		System.out.println("templateTextString: " + templateTextStringValue);

		// NotificationDate Dropdwon

		List<String> notificationDateLists = new ArrayList<String>();
		Select notifationDatedropdown = new Select(notificationDate);
		for (WebElement notificationDateDropdowOptions : notifationDatedropdown.getOptions()) {
			System.out.println("notificationDateDropdowOptions : " + notificationDateDropdowOptions.getText());
			notificationDateLists.add(notificationDateDropdowOptions.getText());
		}

		// assertTrue(notificationDateLists.contains(metaDataLists), " metadata text not
		// displayed"); //need to implement "metadata list" equal to "notifaceDate
		// Dropdown"
		assertTrue(notificationDateLists.contains("Notification Date"));

		String beforeSelectNotificateDateOption = notifationDatedropdown.getFirstSelectedOption().getText();
		System.out.println("beforeSelectNotificateDateOption: " + beforeSelectNotificateDateOption);

		Thread.sleep(1000);
		notifationDatedropdown.selectByVisibleText("Notification Date");
		// NotifationStagesdropdown.selectByValue("Notification Date");

		String afterSelectNotificateDateOption = notifationDatedropdown.getFirstSelectedOption().getText();
		System.out.println("afterSelectNotificateDateOption:" + afterSelectNotificateDateOption);

		assertNotEquals(beforeSelectNotificateDateOption, afterSelectNotificateDateOption);

		// Notification Time

		List<String> notificationTimeLists = new ArrayList<String>();
		Select notifationTimedropdown = new Select(notificationTime);
		for (WebElement notificationTimeDropdowOptions : notifationTimedropdown.getOptions()) {
			System.out.println("notificationTimeDropdowOptions : " + notificationTimeDropdowOptions.getText());
			notificationTimeLists.add(notificationTimeDropdowOptions.getText());
		}
		// assertTrue(notificationTimeLists.containsAll(metaDataLists), " metadata text
		// not displayed"); //need to implement "metadata list" equal to "notifaceTime
		// Dropdown"
		assertTrue(notificationTimeLists.contains("Notification Time"));

		String beforeSelectNotificateTimeOption = notifationTimedropdown.getFirstSelectedOption().getText();
		System.out.println("beforeSelectNotificateTimeOption: " + beforeSelectNotificateTimeOption);

		notifationTimedropdown.selectByVisibleText("Notification Time");

		String afterSelectNotificateTimeOption = notifationTimedropdown.getFirstSelectedOption().getText();
		System.out.println("afterSelectNotificateTimeOption:" + afterSelectNotificateTimeOption);

		assertNotEquals(beforeSelectNotificateTimeOption, afterSelectNotificateTimeOption);

		// MesagTextfield
		assertTrue(message.isDisplayed(), "message is not displayed");
		message.sendKeys(fake.lastName1());

		MessageTextStringValue = message.getAttribute("value"); // 1st way "Global variable"
		System.out.println("MessageTextStringValue: " + MessageTextStringValue);

		assertTrue(remarks.isDisplayed(), "remarksis not displayed");
		remarks.sendKeys(fake.lastName1());

		assertTrue(createButton_NotificatioTemplatePopup.isDisplayed(),
				"createButton_NotificatioTemplatePopupis not displayed");
		createButton_NotificatioTemplatePopup.click();

		wait.until(ExpectedConditions.visibilityOf(notificationTemplateCreatedSuccessfully_popuop));
		assertTrue(notificationTemplateCreatedSuccessfully_popuop.isDisplayed(),
				"notificationTemplateCreatedSuccessfully_popuopis not displayed");

		assertTrue(continueButton_create.isDisplayed(), "continueButton_createis not displayed");
		continueButton_create.click();

		driver.getCurrentUrl();

		wait.until(ExpectedConditions.visibilityOf(last_CreatedNotifications));
		assertTrue(last_CreatedNotifications.isDisplayed(), "last_CreatedNotifications is not displayed");

		last_CreatedNotificationTemplate = last_CreatedNotifications.getText();
		System.out.println("last_CreatedNotificationTemplate : " + last_CreatedNotificationTemplate);

		assertEquals(templateTextStringValue, last_CreatedNotificationTemplate);

	}

	public void logoutFromAdmin() {

		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
		profileDropdown.click();

		assertTrue(logout.isDisplayed(), "logout is not displayed");
		logout.click();

		assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");
	}

	public void loginAsUserCrediantials() {
		assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");

		assertTrue(usernameField.isDisplayed(), "usernameField is not displayed");
		usernameField.sendKeys(userId);

		assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
		passwordField.sendKeys(userPassword);

		assertTrue(signInButton.isDisplayed(), "signInButton");
		signInButton.click();

		assertTrue(user_callLogTabViewpage.isDisplayed(), "user_callLogTabViewpage is not displayed");
		user_callLogTabViewpage.getText();
	}

	public void sendNotifcation() throws Throwable {
		// driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");
		assertTrue(user_callLogTabViewpage.isDisplayed(), "user_callLogTabViewpageis not displayed");

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

//        Select itemPerpage=new Select(itemperpageDropdown);
//		itemPerpage.selectByIndex(2);

		assertTrue(transuniquID_userAccount.isDisplayed(), "transuniquID_userAccountis not displayed");
		System.out.println("transuniquID_userAccount :" + transuniquID_userAccount.getText());

		assertTrue(stagesProfileView_userAccount.isDisplayed(), "stagesProfileView_userAccount is not displayed");
		stagesProfileView_userAccount.click();

		js.executeScript("arguments[0].scrollIntoView(true);", transUniqueId_stageProfileView);
		Thread.sleep(2000);
		assertTrue(transUniqueId_stageProfileView.isDisplayed(), "transUniqueId_stageProfileViewis not displayed");
		System.out.println("transUniqueId_stageProfileView :" + transUniqueId_stageProfileView);

		// assertEquals(transuniquID_userAccount.getText(),
		// transUniqueId_stageProfileView.getText());

	}

	public void TimeSelection() {
		assertTrue(TimeInputPicker.isDisplayed(), "TimePicker is not dispalyed");

		// Get the current time
		Calendar calendar = Calendar.getInstance();

		// Add one minute to the current time
		calendar.add(Calendar.MINUTE, 2);

		// Format the new time as "HH:MM"
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String newTime = timeFormat.format(calendar.getTime());

		// Set the value of the input field
		TimeInputPicker.clear(); // Clear any existing value
		TimeInputPicker.sendKeys(newTime);
	}

	public void DateSelection() {
		assertTrue(DateInputPicker.isDisplayed(), "DateInputPickeris not dispalyed");

		// Explicit wait to ensure the input field is clickable
		wait.until(ExpectedConditions.elementToBeClickable(DateInputPicker));

		// Get the current system date using LocalDate
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);

		// Click on the input field to open the date picker
		DateInputPicker.click();

		// Wait for the date picker to become visible (adjust XPath as needed)
		WebElement datePicker = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'datepicker')]")));

		// Get the current day of the month
		int dayOfMonth = currentDate.getDayOfMonth();
		String dayOfMonthString = String.valueOf(dayOfMonth);

		// Find and click the current date in the date picker
		WebElement currentDateElement = datePicker
				.findElement(By.xpath("//td[normalize-space()='" + dayOfMonthString + "']"));
		currentDateElement.click();

	}

	public void DispostionManualOutsideProcess() throws Throwable {

		Thread.sleep(1000);

		js.executeScript("arguments[0].scrollIntoView(true);", disositionTab);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualRadioButton));
		assertTrue(disositionTab.isDisplayed(), "disositionTab is not displayed");

		assertTrue(manualRadioButton.isDisplayed(), "manualRadioButtonis not displayed");

		// OutsideProcess
		// Check if the radio button is already selected
		boolean isSelected = manualRadioButton.isSelected();

		// If not selected, click the radio button
		if (!isSelected) {
			jsClick(driver, manualRadioButton);
		}

		assertTrue(outsideProcessRadioButton.isDisplayed(), "outsideProcessRadioButtonis not displayed");

		boolean isSelectedOutsidepProcess = outsideProcessRadioButton.isSelected();

		if (!isSelectedOutsidepProcess) {
			outsideProcessRadioButton.click();
		}

	}

	public void DispostionManualWithinProcess() throws Throwable {

		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", disositionTab);
		Thread.sleep(1000);
		assertTrue(disositionTab.isDisplayed(), "disositionTab is not displayed");

		wait.until(ExpectedConditions.visibilityOf(manualRadioButton));
		assertTrue(manualRadioButton.isDisplayed(), "manualRadioButtonis not displayed");

		// Check if the radio button is already selected
		boolean isSelected = manualRadioButton.isSelected();

		// If not selected, click the radio button
		if (!isSelected) {
			jsClick(driver, manualRadioButton);
		}

		assertTrue(withinProcessRadioButton.isDisplayed(), "withinProcessRadioButton is not displayed");

//		//WithinProcess
		// Check if the radio button is already selected
		boolean isSelectedWithinProcess = withinProcessRadioButton.isSelected();

		// If not selected, click the radio button
		if (!isSelectedWithinProcess) {
			withinProcessRadioButton.click();
		}

		// Check if the size of the list is equal to 3
		if (selectStage_disposition.size() == 3) {
			// Iterate over the elements and click each one
			for (WebElement selectStage_dispositionItems : selectStage_disposition) {
				selectStage_dispositionItems.click();
			}
		}

	}

	// Table
	public void SearchThroughProcesses() {

		// beforeSearchDataLists_TableNotification Template
		beforeSearchDataLists_Table = new ArrayList<String>();
		for (WebElement beforeSearchData_Table : beforeSearchData_Table) {
			beforeSearchDataLists_Table.add(beforeSearchData_Table.getText());
			System.out.println("before search data  :" + beforeSearchData_Table.getText());
		}

		Select selectProcesSelect = new Select(ProcessDropdown_table);
		// selectProcesSelect.selectByIndex(1);
		selectProcesSelect.selectByVisibleText("AJP");
		assertNotEquals(beforeSelectProcessdropdown1Options, afterSelectProcessdropdown1Options);

		Select selectSubProcessSelect = new Select(SubProcessDropdown_table);
		// selectSubProcessSelect.selectByIndex(1);
		selectSubProcessSelect.selectByVisibleText("Sub AJP ");
		assertNotEquals(beforeSelectSubProcessdropdown2Options, afterSelectSubProcessdropdown2Options);

		Select selectSubsubProcessSelect = new Select(subSubProcessDropdown_table);
		// selectSubsubProcessSelect.selectByIndex(1);
		selectSubsubProcessSelect.selectByVisibleText("Sub Sub AJP ");
		assertNotEquals(beforeSelectSubSubProcessdropdown3Options, afterSelectSubSubProcessdropdown3Options);

		String beforeSearchByProcessUrl = driver.getCurrentUrl();

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		searchbutton_Table.click();

		String afterSearchByProcessUrl = driver.getCurrentUrl();
		assertNotEquals(beforeSearchByProcessUrl, afterSearchByProcessUrl);

		// after SearchData notification Template
		afterSearchDataLists_Table = new ArrayList<String>();
		for (WebElement afterSearchData_Table : beforeSearchData_Table) {
			afterSearchDataLists_Table.add(afterSearchData_Table.getText());
			System.out.println("After search based on process :" + afterSearchData_Table.getText());
		}

		// assertNotEquals(beforeSearchDataLists_Table, afterSearchDataLists_Table);
		// //Defect= after fixed need to implement " chage to not eqaul"
		assertEquals(beforeSearchDataLists_Table, afterSearchDataLists_Table);

	}

	public void ClearllFilters() {

		assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not displayed");
		clearAllFiltersButton_Table.click();

		assertNotEquals(afterSelectProcessdropdown1Options, beforeSelectProcessdropdown1Options);
		assertNotEquals(afterSelectSubProcessdropdown2Options, beforeSelectSubProcessdropdown2Options);
		assertNotEquals(afterSelectSubSubProcessdropdown3Options, beforeSelectSubSubProcessdropdown3Options);
	}

	public void searchThroughSearchfield() {
		assertTrue(seachTextfield_NotificationTemplate.isDisplayed(), "seachTextfield_SmsTemplate");
		seachTextfield_NotificationTemplate.sendKeys(last_CreatedNotificationTemplate);

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		searchbutton_Table.click(); // Pending after fixed it Continued

	}

	public void SearchThroughSatges() {
		Select selectProcesSelect = new Select(ProcessDropdown_table);
		// selectProcesSelect.selectByIndex();
		selectProcesSelect.selectByVisibleText("AJP");
		assertNotEquals(beforeSelectProcessdropdown1Options, afterSelectProcessdropdown1Options);

		Select selectSubProcessSelect = new Select(SubProcessDropdown_table);
		selectSubProcessSelect.selectByVisibleText("Sub AJP ");
		// selectSubProcessSelect.selectByIndex();
		//selectSubProcessSelect.selectByValue(" ");
		assertNotEquals(beforeSelectSubProcessdropdown2Options, afterSelectSubProcessdropdown2Options);

		Select selectSubsubProcessSelect = new Select(subSubProcessDropdown_table);
		selectSubsubProcessSelect.selectByVisibleText("Sub Sub AJP ");
		//selectSubsubProcessSelect.selectByIndex();
		//selectSubsubProcessSelect.selectByValue("");
		assertNotEquals(beforeSelectSubSubProcessdropdown3Options, afterSelectSubSubProcessdropdown3Options);

		// String beforeSearchByProcessUrl=driver.getCurrentUrl();

		Select searchStageSelect = new Select(notificationStages_table);
		String beforeSelectStagesOptions = searchStageSelect.getFirstSelectedOption().getText();
		searchStageSelect.selectByVisibleText("CutomerdetailsZZZ Stage");
		// searchStageSelect.selectByIndex();
		//searchStageSelect.selectByValue("");
		
		
		String afterSelectStagesOptions = searchStageSelect.getFirstSelectedOption().getText();

		// String afterSearchByProcessUrl=driver.getCurrentUrl();

		// assertNotEquals(beforeSearchByProcessUrl, afterSearchByProcessUrl);
		assertNotEquals(beforeSelectStagesOptions, afterSelectStagesOptions);

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		searchbutton_Table.click();

//		assertNotEquals(beforeSearchDataLists_Table, afterSearchDataLists_Table); //Defect= after fixed need to implement  " chage to not eqaul"
//		System.out.println("Before Search Data: " + beforeSearchDataLists_Table + "\nAfter Search Data: " + afterSearchDataLists_Table); 		
		assertEquals(beforeSearchDataLists_Table, afterSearchDataLists_Table);

	}

	public void EditNotificationTemplate() {
		assertTrue(LastEdit_NotificationTempalte.isDisplayed(), "LastEdit_NotificationTempalte is not displayed");
		LastEdit_NotificationTempalte.click();

		wait.until(ExpectedConditions.visibilityOf(verify_EditNotificationTemplate));
		assertTrue(verify_EditNotificationTemplate.isDisplayed(), "verify_EditNotificationTemplate is not displayed");

		//Template Name
		String EditNotificationTemplateValue = EditTemplateName.getAttribute("Value");
		System.out.println("EditNotificationTemplateValue : " + EditNotificationTemplateValue);

		assertEquals(last_CreatedNotificationTemplate, EditNotificationTemplateValue);
 
		System.out.println("last_CreatedNotificationTemplate:" + last_CreatedNotificationTemplate);
		System.out.println("EditNotificationTemplateValue:" + EditNotificationTemplateValue);
		EditTemplateName.clear();
		EditTemplateName.sendKeys(fake.lastName1());

		String afterEditNotificationTemplateName = EditTemplateName.getAttribute("value");
		System.out.println("afterEditEditTemplateName :" + EditTemplateName.getAttribute("value"));

		// Message
		String editMessageTextfieldValue = editMessageTextfield.getAttribute("value");
		System.out.println("editMessageTextfieldValue:" + editMessageTextfieldValue);
		assertEquals(editMessageTextfieldValue, MessageTextStringValue);
		editMessageTextfield.clear();
		editMessageTextfield.sendKeys(fake.lastName1());

		wait.until(ExpectedConditions.visibilityOf(updateButton));
		assertTrue(updateButton.isDisplayed(), "updateButton is not displayed");
		updateButton.click();

		wait.until(ExpectedConditions.visibilityOf(UpdateNotification_SuceessfullyPopup));
		assertTrue(UpdateNotification_SuceessfullyPopup.isDisplayed(),
				"UpdateNotification_SuceessfullyPopupis not displayed");

		wait.until(ExpectedConditions.visibilityOf(continueButton_Edit));
		assertTrue(continueButton_Edit.isDisplayed(), "continueButton_Edit is not displayed");
		continueButton_Edit.click();

		assertNotEquals(afterEditNotificationTemplateName, last_CreatedNotificationTemplate);

	}

	public void DeleteNotificationTemplate() {

		// beforeSearchDataLists_TableNotification Template
		beforeSearchDataLists_Table = new ArrayList<String>();
		for (WebElement beforeSearchData_Table : beforeSearchData_Table) {
			beforeSearchDataLists_Table.add(beforeSearchData_Table.getText());
			System.out.println("before search data  :" + beforeSearchData_Table.getText());
		}

		assertTrue(LastDelete_NotificationTempalte.isDisplayed(), "LastDelete_NotificationTempalte is not displayed");
		LastDelete_NotificationTempalte.click();
		// jsClick(driver, LastDelete_NotificationTempalte);

		assertTrue(deletePopup_NotificationTemplate.isDisplayed(), "deletePopup_NotificationTemplate is not displayed");
		assertTrue(deleteButton_delete.isDisplayed(), "deleteButton_deleteis not displayed");
		deleteButton_delete.click();

		wait.until(ExpectedConditions.visibilityOf(continueButton_DeleteSuccessullyPopup));
		assertTrue(continueButton_DeleteSuccessullyPopup.isDisplayed(),
				"continueButton_DeleteSuccessullyPopup is not displayed");
		continueButton_DeleteSuccessullyPopup.click();

//		searchbutton_Table.click();
//		assertEquals(templateTextStringValue, " ");  //Defect after fixed ned to implement 
		// no entries found should displayed
		afterSearchDataLists_Table = new ArrayList<String>();
		for (WebElement afterSearchData_Table : beforeSearchData_Table) {
			afterSearchDataLists_Table.add(afterSearchData_Table.getText());
			System.out.println("After search based on process :" + afterSearchData_Table.getText());
		}

		assertNotEquals(beforeSearchDataLists_Table, afterSearchDataLists_Table); // not equal with before text and  after text
	}
																					

}
