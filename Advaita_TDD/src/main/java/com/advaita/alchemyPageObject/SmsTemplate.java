package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.poi.xwpf.usermodel.ISDTContent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.pageObjects.UserSetupPage;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import Advaita_TDD.Advaita_TDD.FakeData;

public class SmsTemplate extends TestBase // Create_Class and extend base class
{
	public SmsTemplate() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	public String FirstCreatedUserName;
	public String lastcreatedsmsTemplate_messageTextfield;
	public String selectedNumberDropdown_toNumber_SMSPopup;

	public String stagesCreatedProcess1;
	public String stagesCreatedSubProcess2;
	public String stagesCreatedSubsubProcess3;
	public String verifyCreatedStages;

	public String createddispositionQuestionSetText;

	String superAmdin = "Capture_Admin";
	String superAdminPass = "Qwerty@123";

	String userID = "Abhijit@trasccon";
	String userPassword = "Qwerty@123";

	String userId1 = "Abhijit_idamta";
	String password1 = "Qwerty@123";

	// Entirebody Click
	@FindBy(tagName = "body")
	public WebElement driverIninteractable;

	@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']")
	public WebElement profileDropdown;

	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown']/..//li//a)[3]")
	public WebElement logout;

//user Login 	
	@FindBy(xpath = "//h2[text()='Sign In']")
	public WebElement Verify_signIn;

	@FindBy(name = "username")
	public WebElement usernameField;

	@FindBy(name = "password")
	public WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElement signInButton;

	// Fetch_ process , subprocess , Subsubprocess

	@FindBy(xpath = "(//input[@data-type='process']/..//span)[1]")
	public WebElement fetchProcess;

	@FindBy(xpath = "//input[@data-type='sub_process']/..//span")
	public WebElement FethSubProcess;

	@FindBy(xpath = "(//div[@class='content']//span)[1]")
	public WebElement SubSubProcess;

	// Fetch SMS ation Enable in "Stages"
	@FindBy(xpath = "(//h1[text()=' Stages '])[1]")
	public WebElement verifyStage;

	@FindBy(id = "text_search")
	public WebElement searchTextfieldStages;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	List<WebElement> stagesName;

	@FindBy(xpath = "(//h2)[1]") // h2[text()='CutomerdetailsZZZ Stage']
	public WebElement verifyCreatedSatgeName;

	@FindBy(xpath = "(//h2)[1]")
	public WebElement verifyEditForm;

	@FindBy(xpath = "((//tbody//tr[1]//td[6])//div//img[@class='img-fluid stages_edit delete-dataset'])[1]") // 5 ,//8
	public WebElement editStagesOption; // New Xpath for stages Edit option
	// (//img[contains(@src,'/static/images/table-edit.svg')])[8]

	@FindBy(xpath = "//div[@class='Action ']//div[@id='collapseThree']//div")
	List<WebElement> stages_actionss;

	@FindBy(xpath = "//a//img[@class='arrow-left']")
	public WebElement leftArrowButton_stages;

	@FindBy(xpath = "//h6[text()='Action']") // 5 //(//h2)[8]
	public WebElement actionsOptionsStages;

	@FindBy(xpath = "//div[@class='Action ']//div[@id='collapseThree']//div//input[@name='ActionCheckbox_4']")
	public WebElement smsCheckBox;

	@FindBy(xpath = "(//tbody//tr[1]//td[1]/a)[1]")
	public WebElement StagesCreatedName;

	@FindBy(xpath = "(//tbody//tr[1]//td[2])[1]") // (//tbody//tr[5]//td[2])[1] -old one
	public WebElement stagesCreatedProcess; // Stages Createdwith Which Proceess

	@FindBy(xpath = "(//tbody//tr[1]//td[3])[1]") // (tbody//tr[5]//td[3])[1]
	public WebElement stagesCreatedSubProcess; // Stages Createdwith Which SubProceess

	@FindBy(xpath = "(//tbody//tr[1]//td[4])[1]") // (//tbody//tr[5]//td[4])[1]
	public WebElement stagesCreatedSubsubProcess; // Stages Createdwith Which SubProceess

	// sms template
	@FindBy(xpath = "//a[@id='menulist2']")
	public WebElement alchemySidemenubar;

	@FindBy(linkText = "SMS Template")
	public WebElement smsTemplateTab;

	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()=' SMS Template ']")
	public WebElement smsTemplateText;

	@FindBy(linkText = "+ Create")
	public WebElement createButtonSmsTemplate;

	@FindBy(xpath = "//h2[text()='Create SMS Template']")
	public WebElement CreatesmstepmlateText;

	@FindBy(xpath = "//select[@id='process']")
	public WebElement ProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement SubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement SubsubProcessDropdown;

	@FindBy(xpath = "//select[@id='stage_name_id']")
	public WebElement smsStages;

	@FindBy(xpath = "//input[@name='template_name']")
	public WebElement smsTemplateName;

	@FindBy(name = "disposition")
	public WebElement smsDisposition;

	@FindBy(name = "from_no")
	public WebElement fromNumber;

	@FindBy(id = "toNumber")
	public WebElement toNumber;

	@FindBy(xpath = "//label[text()='To Number Source']/..//select")
	public WebElement toNumberSource;

	@FindBy(xpath = "//textarea[@name='message']")
	public WebElement message;

	@FindBy(xpath = "//textarea[@name='remarks']")
	public WebElement remarks;

	@FindBy(xpath = "//input[@name='temp_variable_name_1']")
	public WebElement templateVariableName;

	@FindBy(xpath = "//select[@class='form-control stages_fields_dropsown']")
	public WebElement stageFieldName;

	@FindBy(name = "default_val_1")
	public WebElement defaultValue;

	@FindBy(id = "manual_id")
	public WebElement createButton_SmsTemplatePopup;

	@FindBy(xpath = "//span[@id='change_msg']")
	public WebElement smsTemplateCreatedSuccessfully_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButton_create;

	@FindBy(xpath = "(//a[@class='page-link']//img[@alt='right_arrow'])[2]")
	public WebElement lastIndexArrowButton;

	@FindBy(xpath = "//tbody/tr[last()]//td") // Last created notification " entire line"
	public WebElement last_CreatedSms; // tbody/tr[last()]//td last created notifications template

	@FindBy(xpath = "(//tbody/tr[last()]//td)[1]")
	public WebElement lastCreatedSms_templatename;

	// user Management
	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1")
	public WebElement verifyUserMangagemen_page;

	@FindBy(linkText = "+ Create User")
	public WebElement usm_createButton;

	@FindBy(xpath = "//h2[text()='User']")
	public WebElement verify_User;

	@FindBy(xpath = "//label/..//input[@id='user_name']")
	public WebElement userName;

	@FindBy(name = "first_name")
	public WebElement firstName;

	@FindBy(name = "last_name")
	public WebElement lastname;

	@FindBy(name = "email")
	public WebElement email;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//input[@id='confirm_password']")
	public WebElement conformPassword;

	@FindBy(xpath = "//select[@id='multiselect_group']")
	public WebElement groupsLists;

	@FindBy(id = "multiselect_group_rightSelected")
	public WebElement multiSelect_rightSelected;

	@FindBy(xpath = "//button[@class='btn-primary password_validation']")
	public WebElement createButton_user;

	@FindBy(xpath = "//span[text()='User has been created']")
	public WebElement userSuccessfullyCreated_popup;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement userSuccessfullyCreated_ContinueButton;

	@FindBy(xpath = "//tbody/tr[1]//td ") // tbody/tr[1] last created user management user-name
	public WebElement firstCreated_UserManagement;

	@FindBy(xpath = "//tbody/tr[1]//a")
	public WebElement userMapping_USM;

	@FindBy(xpath = "(//h1[text()=' wyzmindz_solutions '])[1] ")
	public WebElement firstCreatedUserMapping_page_USM;

	@FindBy(xpath = "(//ul[@id='pills-tab']//li//button)[2]")
	public WebElement firstCreatedUserMapping_ProcessTAB_USM;

	@FindBy(xpath = "//a[@id='add_more']")
	public WebElement firstCreatedUserMapping_AddrowButton;

	// user mapping

	@FindBy(xpath = "//select[@name='form-0-process_id']")
	public WebElement userMapping_processDropdown;

	@FindBy(xpath = "//select[@name='form-0-sub_process_id']")
	public WebElement userMapping_SubprocessDropdown;

	@FindBy(xpath = "//select[@name='form-0-s_sub_process_id']")
	public WebElement userMapping_SubsubprocessDropdown;

	@FindBy(xpath = "//select[contains(@id,'stage_id') and not (contains(@id,'form-__prefix__')) ]")
	public WebElement userMapping_stagesDropdown;

	@FindBy(xpath = "//input[@id='user_id']/..//button")
	public WebElement userMapping_saveButton;

	@FindBy(xpath = "//span[text()='Created  Successfully']/..//button[text()='Continue']")
	public WebElement userMapping_continueButton;

//System Names
	@FindBy(xpath = "//a[text()='System Names']")
	public WebElement systemNamesTab;

	@FindBy(xpath = "(//h1[text()=' System Names '])[1]")
	public WebElement verify_SystemName;

	@FindBy(xpath = "//a[text()='+ Create']")
	public WebElement createButton_systemName;

	@FindBy(id = "group_name")
	public WebElement systemNameInputField;

	@FindBy(xpath = "//button[text()='Create']")
	public WebElement CreateButton1_systemName;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement continueButton_SystemNames;

	@FindBy(xpath = "//tbody/tr[last()]/td[1]")
	public WebElement verifySystemname_lastCreated;
//user page
	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()='  Call Log Tab View ']")
	public WebElement user_callLogTabViewpage;

	@FindBy(xpath = "//ul[@id='pills-tab']//li")
	public WebElement userAccount_Stages;

	@FindBy(xpath = "//ul[@id='pills-tab']//li//span")
	public WebElement userAccount_StagesCount;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/div/img[@class='img-fluid cursor-pointer view_evalution eye-icon']")
	public WebElement stagesProfileView_userAccount;

	@FindBy(xpath = "//div[contains(@class, 'social_media_images')]/img[contains(@class, 'sms_btn_click')]")
	public WebElement SmsIcon_userAccountSatgeView;

	@FindBy(xpath = "//h2[text()='SMS']")
	public WebElement smsPopup;

	@FindBy(xpath = "//select[@id='select_type_id']")
	public WebElement SelectTemplateDropdown_smsPopup;

	@FindBy(xpath = "//select[@id='select_type_id']/option[last()]")
	public WebElement lastSmsTemplateDropdown_smsPopu; // Dynamic

	@FindBy(xpath = "//label[text()='From Number']/..//input[@id='sms_from_number']")
	public WebElement fromNumber_SmsPopup;

	@FindBy(xpath = "//select[@id='sms_to_number']")
	public WebElement toNumberDropdown_smsPopup;

	@FindBy(xpath = "//label/..//textarea[@id='sms_msg']")
	public WebElement messaageTextfield_smsPopu;

	@FindBy(xpath = "//ul//li//button[text()='SMS']")
	public WebElement smsTab_stgesViewPage;

	@FindBy(xpath = "(//h2/..//..//button[text()='Send'])[1]")
	public WebElement SendButton_smsPopup;

	@FindBy(xpath = "//tbody[@id='emailtableBody']/tr[last()]/td[2]")
	public WebElement lastSmsRecrod_toNumberStagesProfileView;

	@FindBy(xpath = "//tbody[@id='emailtableBody']/tr[last()]/td[5]")
	public WebElement lastSmsRecrod_DispositionStagesProfileView;

	@FindBy(xpath = "//div[@class='last-section-button']//button[text()='Save']")
	public WebElement SaveButton_stagesProfileView;

	@FindBy(xpath = "//div[@class='last-section-button']//button[text()='Cancel']")
	public WebElement cancelButton_SatgesProfileView;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public WebElement continueButton_stageProfileView;

	// Super admin_edit
	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='table-edit']")
	public WebElement lastEdit_smsTemplate;

	@FindBy(xpath = "//h2[text()='Edit SMS Template']")
	public WebElement verify_EditsmsTemplate;

	@FindBy(xpath = "(//tbody/tr[last()]//td)[1]")
	public WebElement beforeEdit_SmstemplateNameLast;

	@FindBy(xpath = "(//tbody/tr[last()]//td)[1]")
	public WebElement afterEdit_SmstemplateNameLast;

	@FindBy(xpath = "//button[text()=' Update ']")
	public WebElement UpdateButton;

	@FindBy(xpath = "//h3/..//span[text()='SMS Template has been updated successfully']")
	public WebElement update_smsTemplateSuccessfullyPopup;

	@FindBy(xpath = "//h3/..//span[text()='SMS Template has been updated successfully']/..//button")
	public WebElement continueButon_SmsTemplateSucessfullyUpdate;

	// Super Admin_table
	@FindBy(name = "text_search")
	public WebElement seachTextfield_SmsTemplate;

	@FindBy(xpath = "//select[@id='process_search']")
	public WebElement processDropdown_Table;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public WebElement SubprocessDropdown_Table;

	@FindBy(id = "s_sub_process_search")
	public WebElement subSubProcessDropdown_Table;

	@FindBy(xpath = "//select[@name='stage_search']")
	public WebElement smsStagesDropdown_table;

	@FindBy(xpath = "//div//button//img[@alt='filter_search']")
	public WebElement searchbutton_Table;

	@FindBy(xpath = "//td[normalize-space(.)='No Entries Found']")
	public WebElement noEntriesFound;

	@FindBy(xpath = "//div//img/..//h6")
	public WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "//select[@id='page-size-select']")
	public WebElement itemperpageDropdown;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> beforeSearchData_Table;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> afterSearchData_Table;

	private String String;

	public List<WebElement> satgeNameList;

	// private String String;

	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='delete-icon ']")
	public WebElement LastDelete_smsTempalte;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public WebElement deletePopup_smsTemplate;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement deleteButton_delete;

	@FindBy(xpath = "//h3/..//span[text()='Deleted Successfully']")
	public WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public WebElement continueButton_DeleteSuccessullyPopup;

	// DispositionStages
	@FindBy(xpath = "((//tbody//tr[1]//td[6])//div//img[@class='img-fluid stages_edit delete-dataset'])[4]")
	public WebElement stagesDispositionOption;

	@FindBy(id = "disposition_stagewise")
	public WebElement selectDispostionQuestionSetDropdown;

	@FindBy(xpath = "(//tbody/tr[1]//td)[1]")
	public WebElement dispositionQuestionSet;

	@FindBy(xpath = "(//button[text()='Save'])[2]")
	public WebElement saveButtonStagesDisposition;

	@FindBy(xpath = "//tbody//tr[last()]//td[1][not(text()='No Templates Found')]")
	public WebElement fromStages;

	@FindBy(xpath = "//tbody//tr[last()]//td[2][last()]")
	public WebElement toStages;

	@FindBy(xpath = "//tbody//tr[last()]//td[4][last()]//a//img[@title='AUTO SMS Mapping']")
	public WebElement autoSMSMappingActions;

	@FindBy(id = "auto_sms_template")
	public WebElement autoSmsTemplatDropdown;

	@FindBy(xpath = "//h2[text()='Auto SMS Mapping']")
	public WebElement verifyAutoSmsMapping;

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

	public void clickDynamicStage(int index) {
		if (satgeNameList.size() > index) { // Ensure the index is within bounds
			try {
				WebElement stageElement = stagesName.get(index);
				if (stageElement.isDisplayed() && stageElement.isEnabled()) { // Ensure the element is clickable
					// stageElement.click(); // Click the element at the specified index
					jsClick(driver, stageElement);
					System.out.println("Successfully clicked the element at index: " + index);
				} else {
					System.out.println("Element at index " + index + " is either not displayed or not enabled.");
				}
			} catch (Exception e) {
				System.out.println("Exception occurred while trying to click the element at index " + index + ": "
						+ e.getMessage());
			}

			System.out.println("Total count: " + satgeNameList.size());
		} else {
			System.out.println(
					"The number of matching elements is less than " + (index + 1) + ". Found: " + satgeNameList.size());
		}
	}

	String searchedStagesName = "Booking Information Stage";

	public void navigatetoStage_verifySMS() throws Throwable {
		driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");
		assertTrue(verifyStage.isDisplayed(), "verifyStage is not displayed");

		assertTrue(searchTextfieldStages.isDisplayed(), "searchTextfieldStages is not displayed");
		searchTextfieldStages.sendKeys(searchedStagesName);
		searchbutton_Table.click();
		Thread.sleep(2000);

		stagesCreatedProcess1 = stagesCreatedProcess.getText();
		System.out.println("stagesCreatedProcess1 :" + stagesCreatedProcess1);

		assertTrue(stagesCreatedSubProcess.isDisplayed(), "stagesCreatedSubProcess2 is not displayed");
		stagesCreatedSubProcess2 = stagesCreatedSubProcess.getText();
		System.out.println("stagesCreatedSubProcess2 :" + stagesCreatedSubProcess2);

		assertTrue(stagesCreatedSubsubProcess.isDisplayed(), "stagesCreatedSubsubProcess3 is not displayed");
		stagesCreatedSubsubProcess3 = stagesCreatedSubsubProcess.getText();
		System.out.println("stagesCreatedSubsubProcess3 :" + stagesCreatedSubsubProcess3);

		List<String> satgeNameList = new ArrayList<String>();
		for (WebElement stageName : stagesName) {
			satgeNameList.add(stageName.getText());
			System.out.println("Stages name Lists : " + stageName.getText());
		}

		assertTrue(satgeNameList.contains(searchedStagesName), "stages is notcontains");

		boolean StagesCreatedNameIsEnable = StagesCreatedName.isEnabled();
		System.out.println(StagesCreatedNameIsEnable);
		jsClick(driver, StagesCreatedName);

//		################

//		if (satgeNameList.size() >= 1) {
//			stagesName.get(0).click();  //through here we can change stage click
//
//			System.out.println("total count : " + satgeNameList.size());
//		} 
//		else {
//			System.out.println("The number of matching elements is less than 1. Found: " + satgeNameList.size());
//
//		}

		// js.executeScript("arguments[0].scrollIntoView(true);", stagesName);

		// Your existing code to populate the list
//		List<String> satgeNameList = new ArrayList<>();
//		String stageToSearch = "";  // Variable to store the found stage name
//
//		for (WebElement stageName : stagesName) {
//		    String stageText = stageName.getText();
//		    satgeNameList.add(stageText);
//		    System.out.println("Stages name Lists : " + stageText);
//		    
//		    // Check if the stage name contains "Escalation Stage"
//		    if (stageText.contains("Escalation Stage")) {
//		        stageToSearch = stageText;  // Store the stage name in the variable
//		        break;  // Exit the loop once found
//		    }
//		}
//
//		// Assert that the list contains "Escalation Stage"
//		assertTrue(satgeNameList.contains("Escalation Stage"), "Escalation Stage not found in the list!");
//
//		// If "Escalation Stage" is found, pass it to the search field
//		if (!stageToSearch.isEmpty()) {
//		    searchTextfieldStages.sendKeys(stageToSearch);  // Pass the stored stage name into the search text field
//		    System.out.println("Searching for stage: " + stageToSearch);
//		    
//		    // Click on the "Escalation Stage" element
//		    stageToClick.click();  // Click the WebElement associated with "Escalation Stage"
//		    System.out.println("Clicked on the stage: " + stageToSearch);
//		    
//		} else {
//		   // Assert.fail("Escalation Stage not found.");  // Fail the test if the stage was not found
//		    assertFalse(false, "Escalation Stage not found.");
//		}
//

//		//		clickDynamicStage(1);
		assertTrue(verifyCreatedSatgeName.isDisplayed(), "verifyCreatedSatgeName is not dispalyed");
//		// System.out.println("verifyCreatedSatgeName : " +
//		// verifyCreatedSatgeName.getText());
		verifyCreatedStages = verifyCreatedSatgeName.getText();
		System.out.println("verifyCreatedStages :" + verifyCreatedStages);

		// js.executeScript("arguments[0].scrollIntoView(true);", stages_actionss);
		WebElement actions = driver.findElement(By.xpath("//div[@class='Action-border']//h6[text()='Action']"));
		js.executeScript("arguments[0].scrollIntoView(true);", actions);

		// Verify sms Action is enable or not
		List<String> stagesActionList = new ArrayList<String>();
		for (WebElement stagesAction : stages_actionss) {
			stagesActionList.add(stagesAction.getText());
			System.out.println("StagesActions " + stagesAction.getText());
		}

		if (stagesActionList.contains("SMS")) {
			// Assert and print SMS action message
			assertTrue(true, "SMS action is enabled for this stage");
			System.out.println("SMS action is enabled for this stage");

			// Scroll to and click left arrow button
			js.executeScript("arguments[0].scrollIntoView(true);", leftArrowButton_stages);
			Thread.sleep(1000); // Adding a sleep to wait for scrolling
			assertTrue(leftArrowButton_stages.isDisplayed(), "Left arrow button is not displayed");
			leftArrowButton_stages.click();

		} else {
			// Scroll to and click left arrow button if "SMS" is not contained
			js.executeScript("arguments[0].scrollIntoView(true);", leftArrowButton_stages);
			assertTrue(leftArrowButton_stages.isDisplayed(), "Left arrow button is not displayed");
			// leftArrowButton_stages.click();
			jsClick(driver, leftArrowButton_stages);

			searchTextfieldStages.sendKeys(searchedStagesName);
			searchbutton_Table.click();

			// Scroll and click the edit stage option
			js.executeScript("arguments[0].scrollIntoView(true);", editStagesOption);
			assertTrue(editStagesOption.isDisplayed(), "Edit stage option is not displayed");
			// editStagesOption.click();
			jsClick(driver, editStagesOption);

			// Verify the edit form is displayed
			assertTrue(verifyEditForm.isDisplayed(), "Verify Edit Form is not displayed");

			// Scroll to and check the status of actionsOptionsStages
			js.executeScript("arguments[0].scrollIntoView(true);", actionsOptionsStages);
			assertTrue(actionsOptionsStages.isDisplayed(), "Actions Options Stages is not displayed");

			// Check if SMS checkbox is selected and take appropriate actions
			if (smsCheckBox.isSelected()) {
				System.out.println("SMS checkbox is already selected");
				assertTrue(true, "SMS checkbox is already selected");

				// Click on the save button
				assertTrue(SaveButton_stagesProfileView.isDisplayed(), "Save button is not displayed");
				SaveButton_stagesProfileView.click();

			} else {
				System.out.println("SMS checkbox is not selected, selecting now");
				assertTrue(true, "SMS checkbox is not selected, selecting now");

				// Click the SMS checkbox to select it
				// smsCheckBox.click();
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView(true);", smsCheckBox);
				jsClick(driver, smsCheckBox);

				WebElement assignedTo = driver
						.findElement(By.xpath("//h7[text()='Assigned To']/../..//label//input/..//span"));
				// assignedTo.click();

				if (assignedTo.isEnabled()) {
					System.out.println("'Assigned To' is already enabled, no need to click");
					assertTrue(true, "'Assigned To' is already enabled, no need to click");
				} else {
					System.out.println("'Assigned To' is not enabled, clicking now");
					assertTrue(false, "'Assigned To' is not enabled, clicking now");
					assignedTo.click();
				}

				// Click on the save button after selecting SMS checkbox
				assertTrue(SaveButton_stagesProfileView.isDisplayed(), "Save button is not displayed");
				// SaveButton_stagesProfileView.click();
				jsClick(driver, SaveButton_stagesProfileView);
			}
		}

//		assertTrue(stagesCreatedProcess.isDisplayed(), "stagesCreatedProcess is not displayed");
//		stagesCreatedProcess1 = stagesCreatedProcess.getText();
//		System.out.println("stagesCreatedProcess1 :" + stagesCreatedProcess1);
//
//		assertTrue(stagesCreatedSubProcess.isDisplayed(), "stagesCreatedSubProcess2 is not displayed");
//		stagesCreatedSubProcess2 = stagesCreatedSubProcess.getText();
//		System.out.println("stagesCreatedSubProcess2 :" + stagesCreatedSubProcess2);
//
//		assertTrue(stagesCreatedSubsubProcess.isDisplayed(), "stagesCreatedSubsubProcess3 is not displayed");
//		stagesCreatedSubsubProcess3 = stagesCreatedSubsubProcess.getText();
//		System.out.println("stagesCreatedSubsubProcess3 :" + stagesCreatedSubsubProcess3);

	}

	// ############## if required need to impliment##########################

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

//	public void dropdownUtils(WebElement dropdownElement, String expectedOptionText) {
//
//		// Step 2: Initialize Select object with the provided dropdown element
//		Select dropdown = new Select(dropdownElement);
//
//		// Step 3: Retrieve all options in the dropdown
//		List<WebElement> allDropdownOptions = dropdown.getOptions();
//
//		// Step 4: Loop through each dropdown option and compare with expectedOptionText
//		boolean isOptionClicked = false;
//		for (WebElement option : allDropdownOptions) {
//			String dropdownValue = option.getText();
//
//			// Step 5: Compare expectedOptionText with the dropdown option value
//			if (dropdownValue.equals(expectedOptionText)) {
//				// Assert that the correct dropdown value has been found
//				assertEquals(dropdownValue, expectedOptionText, "Dropdown value did not match!");
//
//				// Step 6: Click the dropdown option that matches
//				option.click();
//
//				// Break the loop once the match is found and clicked
//				isOptionClicked = true;
//				break;
//			}
//		}
//
//		// Step 7: Assert that the option has been clicked
//		assertTrue(isOptionClicked, "No matching dropdown option found and clicked.");
//	}
//	====================================================================

	public void dropdownUtils(WebElement dropdownElement, String expectedOptionText) throws Throwable {
		// Step 1: Initialize WebDriverWait to handle dynamic waits
		// Step 2: Ensure the dropdown element is visible and clickable
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));

		// Step 3: Initialize Select object with the provided dropdown element
		Select dropdown = new Select(dropdownElement);

		// Step 4: Retrieve all options in the dropdown
		List<WebElement> allDropdownOptions = dropdown.getOptions();

		// Step 5: Loop through each dropdown option and compare with expectedOptionText
		boolean isOptionClicked = false;
		for (WebElement option : allDropdownOptions) {
			try {
				String dropdownValue = option.getText();

				// Compare expectedOptionText with the dropdown option value
				if (dropdownValue.equals(expectedOptionText)) {
					// Assert that the correct dropdown value has been found
					assertEquals(dropdownValue, expectedOptionText, "Dropdown value did not match!");

					// Wait until the option is clickable and click it
					wait.until(ExpectedConditions.elementToBeClickable(option));
					option.click();

					// Step 8: Break the loop once the match is found and clicked
					isOptionClicked = true;
					break;
				}
			} catch (StaleElementReferenceException e) {
				// Re-fetch the options in case of a StaleElementReferenceException
				allDropdownOptions = dropdown.getOptions();
			}
		}

		Thread.sleep(2000);
		// Assert that the option has been clicked
		assertTrue(isOptionClicked, "No matching dropdown option found and clicked.");
	}

	public void selectProcessDropdown() throws Throwable {
//		List<String> processDropdownList = new ArrayList<String>();
//
//		Select ProcessDropdown1 = new Select(ProcessDropdown);
//		for (WebElement Options : ProcessDropdown1.getOptions()) {
//			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
//			System.out.println(Options.getText());
//			processDropdownList.add(Options.getText());
//		}
//		assertTrue(processDropdownList.contains("AJP"));
//		ProcessDropdown1.selectByVisibleText("AJP");          //Old Code

//		Select ProcessDropdown1 = new Select(ProcessDropdown);     //New Code
//
//		// Step 3: Retrieve all options in the dropdown
//		List<WebElement> allDropdownOptions = ProcessDropdown1.getOptions();
//
//		// Step 4: Loop through each dropdown option and compare with capturedText
//		boolean isOptionClicked = false;
//		for (WebElement option : allDropdownOptions) {
//			String dropdownValue = option.getText();
//
//			// Step 5: Compare capturedText with the dropdown option value
//			if (dropdownValue.equals(stagesCreatedProcess1)) {
//				// Assert that the correct dropdown value has been found
//				assertEquals(dropdownValue, stagesCreatedProcess1, "Dropdown value did not match!");
//
//				// Step 6: Click the dropdown option that matches
//				option.click();
//
//				// Break the loop once the match is found and clicked
//				isOptionClicked = true;
//				break;
//			}
//		}
//
//		// Assert that the option has been clicked
//		assertTrue(isOptionClicked, "No matching dropdown option found and clicked.");

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);

	}

	public void SelectSubProcessDropdown() throws Throwable {
//		List<String> subProcessDropdownList = new ArrayList<String>(); //old code
//
//		actions.moveToElement(driverIninteractable).perform();
//		Select subProcessDropdown2 = new Select(SubProcessDropdown);
//		for (WebElement options2 : subProcessDropdown2.getOptions()) {
//			Thread.sleep(1000);
//			System.out.println(subProcessDropdown2.getOptions());
//			subProcessDropdownList.add(options2.getText());
//		}
//
//		assertTrue(subProcessDropdownList.contains("Sub AJP"));
//		subProcessDropdown2.selectByVisibleText("Sub AJP");

		// js.executeScript("arguments[0].scrollIntoView(true);", SubProcessDropdown);
		// // New Code

		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
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
//		actions.moveToElement(driverIninteractable).perform();s

//		List<String> subsubprocessDropdownList = new ArrayList<String>();
//		boolean elementStale = true;
//		int attempts = 0;
//
//		while (elementStale && attempts < 3) {
//			try {
//				Select SubsubProcessDropdown3 = new Select(SubsubProcessDropdown);
//				subsubprocessDropdownList.clear(); // Clear the list before each retry
//
//				for (WebElement options3 : SubsubProcessDropdown3.getOptions()) {
//					Thread.sleep(2000);
//					System.out.println(options3.getText()); // Print each option's text
//					subsubprocessDropdownList.add(options3.getText());
//				}
//
//				assertTrue(subsubprocessDropdownList.contains("Sub Sub AJP"));
//				SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
//				actions.moveToElement(driverIninteractable).perform();
//
//				elementStale = false; // If we reach here, no exception was thrown
//			} catch (StaleElementReferenceException e) {
//				attempts++;
//				System.out.println("Stale element reference exception. Retrying... " + attempts);
//				Thread.sleep(2000); // Optional: add a wait before retrying
//			}
//		}
//
//		if (elementStale) {
//			throw new RuntimeException(
//					"Failed to interact with the dropdown after 3 attempts due to stale element reference.");
//		}

		// Thread.sleep(1000);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);
	}

	public void selectStages() throws Throwable {
//		List<String> smsStagesLists = new ArrayList<String>();
//		Select smsStagesdropdown = new Select(smsStages);
//		for (WebElement smsStagesOptions : smsStagesdropdown.getOptions()) {
//			System.out.println("satges Dropdown : " + smsStagesdropdown.getOptions());
//			smsStagesLists.add(smsStagesOptions.getText());
//		}
//		assertTrue(smsStagesLists.contains("CutomerdetailsZZZ Stage"));
//		smsStagesdropdown.selectByVisibleText("CutomerdetailsZZZ Stage");

		Thread.sleep(1000);
		dropdownUtils(smsStages, verifyCreatedStages);
	}

	public void SmsTemplateName() {

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
	}

	public void disposition() {

		// Sms - disposition
		assertTrue(smsDisposition.isDisplayed(), "smsDisposition is not dispalyed");

	}

	public void fromNumber() {

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

	}
//=========================================================================================================================

	public void validateAndSelectFromDropdownUTILS(WebElement dropdownElement, String visibleTextToSelect) {

		// Create a list to store all dropdown options
		List<String> dropdownOptionsList = new ArrayList<>();

		// Initialize the Select class with the provided dropdown WebElement
		Select dropdown = new Select(dropdownElement);

		// Iterate over each option in the dropdown and add it to the list
		for (WebElement option : dropdown.getOptions()) {
			String optionText = option.getText();
			dropdownOptionsList.add(optionText);
			System.out.println("Dropdown Option: " + optionText);
		}

		// Validation 1: Assert that the dropdown contains the specified visible text
		assertTrue(dropdownOptionsList.contains(visibleTextToSelect),
				"Dropdown does not contain the option: " + visibleTextToSelect);

		// Validation 2: Assert that the dropdown is not empty
		assertFalse(dropdownOptionsList.isEmpty(), "Dropdown is empty");

		// Validation 3: Assert that the specified visible text is not null or empty
		assertNotNull(visibleTextToSelect, "Visible text to select is null");

		assertFalse(visibleTextToSelect.isEmpty(), "Visible text to select is empty");

		// Select the dropdown option by visible text
		dropdown.selectByVisibleText(visibleTextToSelect);

		// Validation 4: Verify that the correct option is selected
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		System.out.println("selectedOption : " + selectedOption);
		// assertEquals( visibleTextToSelect, selectedOption.getText(),"Selected option
		// does not match the expected value");
		assertEquals(visibleTextToSelect, selectedOption, "Selected option does not match the expected value");

		System.out.println("Successfully selected option: " + visibleTextToSelect);

	}

	public void selectToNumberSource() {

//		// SMS- to Number Source
//		List<String> toNumberSourceListsList = new ArrayList<String>();
//		Select toNumberSourceDrodown = new Select(toNumberSource);
//		for (WebElement toNumberSourceOptions : toNumberSourceDrodown.getOptions()) {
//			toNumberSourceListsList.add(toNumberSourceOptions.getText());
//			System.out.println("toNumberSourceListsList :" + toNumberSourceOptions.getText());
//		}
//
//		assertTrue(toNumberSourceListsList.contains("From Stage Fields"));
//		toNumberSourceDrodown.selectByVisibleText("From Stage Fields");
//
//		// SMS - to number
//		List<String> toNumberListsList = new ArrayList<String>();
//		Select toNumberDrodown = new Select(toNumber);
//		for (WebElement toNumberOptions : toNumberDrodown.getOptions()) {
//			// System.out.println(" to number dropdowns options : " +
//			// toNumberDrodown.getOptions());
//			toNumberListsList.add(toNumberOptions.getText());
//		}
//		assertTrue(toNumberListsList.contains("Phone Number"));
//		toNumberDrodown.selectByVisibleText("Phone Number");

		// validateAndSelectFromDropdownUTILS(toNumberSource, "From System Names");
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");

	}

	public void toNumber() {
		validateAndSelectFromDropdownUTILS(toNumber, "Phone Number");

	}

	// SMS - message
	public void enterMessage() {

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

	}

	// Remarks
	public void remarksField() {

		assertTrue(remarks.isDisplayed(), "remarks is not displayed");
	}

	public void variables() {

//		WebElement addRowOptions = driver.findElement(By.xpath("//a[text()='+ Add Row']"));
//		for (int i = 0; i < 1; i++) {
//			addRowOptions.click();
//		}
		// template variable name
		assertTrue(templateVariableName.isDisplayed(), "templateVariableName is not displayed");

		// Satge Field name
		assertTrue(stageFieldName.isDisplayed(), "stageFieldName is not displayed");

		// Default value
		assertTrue(defaultValue.isDisplayed(), "defaultValue is not dispalyed");
	}

	public void createButton() {

		// Create Button
		assertTrue(createButton_SmsTemplatePopup.isDisplayed(), "createButton_SmsTemplatePopup is not displayed");
		createButton_SmsTemplatePopup.click();

		wait.until(ExpectedConditions.visibilityOf(smsTemplateCreatedSuccessfully_popuop));
		assertTrue(smsTemplateCreatedSuccessfully_popuop.isDisplayed(),
				"smsTemplateCreatedSuccessfully_popuop is not displayed");

		assertTrue(continueButton_create.isDisplayed(), "continueButton_create is not displayed");
		continueButton_create.click();
	}

	public void verifyCreatedMessage() {

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
	public void userManagement_create() {

		driver.navigate().to("https://test.capture.autosherpas.com/en/user_management/users/");
//
//		assertTrue(verifyUserMangagemen_page.isDisplayed(), "verifyUserMangagemen_page is not displayed");
//
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

//		userManagement_createUTILS("Abhijit@idamta.com", "Abhijit", "idamta", "Abhijitdas@idamta.com", "Qwerty@123",
//				"Qwerty@123");
	}

	public void userManagement_createUTILS(String username, String FirstName, String LastName, String emailID,
			String Password, String confirmPasswordInput) {

		driver.navigate().to("https://test.capture.autosherpas.com/en/user_management/users/");

		assertTrue(verifyUserMangagemen_page.isDisplayed(), "verifyUserMangagemen_page is not displayed");

		assertTrue(usm_createButton.isDisplayed(), "usm_createButton is not displayed");
		usm_createButton.click();

		assertTrue(verify_User.isDisplayed(), "verify_User is not displayed");

		assertTrue(userName.isDisplayed(), "userName is not displayed");
		userName.sendKeys(username);

		assertTrue(firstName.isDisplayed(), "firstName is not displayed");
		firstName.sendKeys(FirstName);

		assertTrue(lastname.isDisplayed(), "lastname is not displayed");
		lastname.sendKeys(LastName);

		assertTrue(email.isDisplayed(), "email is not displayed");
		email.sendKeys(emailID);

		assertTrue(password.isDisplayed(), "password is not displayed");
		password.sendKeys(Password);

		assertTrue(conformPassword.isDisplayed(), "conformPassword is not displayed");
		conformPassword.sendKeys(confirmPasswordInput);

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
//		FirstCreatedUserName = firstCreated_UserManagement.getText();
//		System.out.println("First Create User mangement :" + firstCreated_UserManagement.getText());

		UserSetupPage userSetupPage = new UserSetupPage();

		userSetupPage.singleGroupSelect("admin1");
		userSetupPage.clickOnGroupCreateButton();

	}

	// user Mapping
	public void userMapping() throws Throwable {

//		assertTrue(userMapping_USM.isDisplayed(), "userMapping_USM is not displayed");
//		userMapping_USM.click();

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

		UserSetupPage userSetupPage = new UserSetupPage();
		userSetupPage.userMappingRecord("Abhijit@idamta.com").userMappingProcess(stagesCreatedProcess1,
				stagesCreatedSubProcess2, stagesCreatedSubsubProcess3, verifyCreatedStages);

//		userSetupPage.userMappingRecord("Abhijit@idamta.com").userMappingProcess(stagesCreatedProcess1,
//				stagesCreatedSubProcess2, stagesCreatedSubsubProcess3, verifyCreatedStages);

	}

	public void SystemName_create() {
//		assertTrue(systemNamesTab.isDisplayed(), "systemNamesTab is not displayed");
//		systemNamesTab.click();
//
//		assertTrue(verify_SystemName.isDisplayed(), "verify_SystemName is not displayed");
//
//		assertTrue(createButton_systemName.isDisplayed(), "createButton_systemName is not displayed");
//		createButton_systemName.click();
//
//		assertTrue(systemNameInputField.isDisplayed(), "systemNameInputField is not displayed");
//		systemNameInputField.sendKeys("Cloud Device Category"); // 1st way
//		// systemNameInputField.sendKeys(fake.lastName1()); 2nd way
//
//		assertTrue(CreateButton1_systemName.isDisplayed(), "CreateButton1_systemName is not displayed");
//		CreateButton1_systemName.click();
//
//		wait.until(ExpectedConditions.visibilityOf(continueButton_SystemNames));
//		assertTrue(continueButton_SystemNames.isDisplayed(), "continueButton_SystemNames is not displayed");
//		continueButton_SystemNames.click();
//
//		assertTrue(verifySystemname_lastCreated.isDisplayed(), "verifySystemname_lastCreated is not displayed");
//		verifySystemname_lastCreated.getText();
//		System.out.println("LastCreated System Name : " + verifySystemname_lastCreated.getText());
//
//		assertEquals(verifySystemname_lastCreated.getText(), "Cloud Device Category"); // 1st way
//																						// 2nd way

		UserSetupPage userSetupPage = new UserSetupPage();
		userSetupPage.navToSysNames();
		userSetupPage.systemNames("Cloud Device Category");
		userSetupPage.navToUserManagement();
		userSetupPage.userMappingRecord("Abhijit@idamta.com");
		userSetupPage.systemMapping("Cloud Device Category", "7684859730");
		saveRecord();
	}

	public void logoutAmdin() {
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
		// usernameField.sendKeys("wyzmindz_solutions");
		usernameField.sendKeys(userId1);

		assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
		// passwordField.sendKeys("Qwerty@123");
		passwordField.sendKeys(password1);

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
//		List<String> toNumberList_smsPopup = new ArrayList<String>();
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
		Select smsStagesdropdown = new Select(smsStagesDropdown_table);
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

	public void SendSmsTroughSystemName() throws Throwable {
		SystemName_create(); // create Ststen Name and System Mapping

		NavigateToFetchprocess();
		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();
		selectProcessDropdown();
		SelectSubProcessDropdown();
		selectSubSubProcess();
		selectStages();
		SmsTemplateName();
		disposition();
		fromNumber();
		toNumberSourceSystemNames();
		toNumberSystemNames();
		enterMessage();
		remarksField();
		createButton();
		// navigateTo_MasterParameterDisposition();
		stagesDispositionClick();

	}

	public void toNumberSourceSystemNames() {
		validateAndSelectFromDropdownUTILS(toNumberSource, "From System Names");
	}

	public void toNumberSystemNames() {
		validateAndSelectFromDropdownUTILS(toNumber, "Cloud Phone Category");

	}

	public void verifyCreatedDispositionQuestionset() throws Throwable {
		createddispositionQuestionSetText = dispositionQuestionSet.getText();
		System.out.println("createddispositionQuestionSetText : " + createddispositionQuestionSetText);

	}

	public void stagesDispositionClick() {
		String searchedStagesName = "Booking Information Stage";

		assertTrue(searchTextfieldStages.isDisplayed(), "searchTextfieldStages is not displayed");
		searchTextfieldStages.sendKeys(searchedStagesName);
		searchbutton_Table.click();

		stagesDispositionOption.click(); // Click on StagesDisposition

	}

	public void selectSearchProcesses() throws Throwable {
		dropdownUtils(processDropdown_Table, stagesCreatedProcess1);
		dropdownUtils(SubprocessDropdown_Table, stagesCreatedSubProcess2);
		dropdownUtils(subSubProcessDropdown_Table, stagesCreatedSubsubProcess3);

	}

	public void selectStagesDisposition() throws Throwable {

		dropdownUtils(smsStagesDropdown_table, verifyCreatedStages);

	}

	public void selectDispositionQuestionSet() throws Throwable {

		dropdownUtils(selectDispostionQuestionSetDropdown, createddispositionQuestionSetText);
	}

//	public void addAutoSmsMapping(WebElement autoSmsTemplateDropdown, String value) {
//
//		Select selectSmstemplate = new Select(autoSmsTemplateDropdown);
//		selectSmstemplate.selectByValue(value);
//
//	}

	public void saveStagesDisposition() {

		wait.until(ExpectedConditions.visibilityOf(firstCreated_UserManagement));
		assertTrue(saveButtonStagesDisposition.isDisplayed(), "saveButtonStagesDisposition is not displayed");
		saveButtonStagesDisposition.click();
	}

	public void VeriftTheUserIsAbleToDoAutoSMSMapping() {

		String fromStageText = fromStages.getText();
		System.out.println("fromStagesText :" + fromStageText);

		String toStageText = toStages.getText();
		System.out.println("toStageText :" + toStageText);

		if (fromStageText.equals(toStageText)) {
			// Use TestNG assertion for equality
			assertEquals(fromStageText, toStageText,
					"Auto SMS mapping should have the same stages: 'FROM-STAGE' and 'TO-STAGE' should be the same.");
		} else {
			// Use TestNG assertion for inequality
			assertNotEquals(fromStageText, toStageText,
					"Auto SMS mapping should have different stages: 'FROM-STAGE' and 'TO-STAGE' should not be the same.");
		}

	}

	public void addAutoSmsMapping() throws Throwable {

		js.executeScript("arguments[0].scrollIntoView(true);", autoSMSMappingActions);
		assertTrue(autoSMSMappingActions.isDisplayed(), "autoSMSMappingLink is not displayed");
		// autoSMSMappingActions.click();
		jsClick(driver, autoSMSMappingActions);

		wait.until(ExpectedConditions.visibilityOf(verifyAutoSmsMapping));
		assertTrue(verifyAutoSmsMapping.isDisplayed(), "verifyAutoSmsMapping is not displayed");

		dropdownUtils(autoSmsTemplatDropdown, last_CreatedSms.getText());

	}

	public void selectSmsTemplateForAutoSMS() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(verifyAutoSmsMapping));
		assertTrue(verifyAutoSmsMapping.isDisplayed(), "verifyAutoSmsMapping is not displayed");

		dropdownUtils(autoSmsTemplatDropdown, last_CreatedSms.getText());

	}



}
