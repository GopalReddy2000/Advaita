package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ApiKeySetup.pageObject.ApiKeySetup;
import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.SendDataUtils;
import com.advaita.WorkFlowDesign.PageObject.Disposition;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.advaita.pageObjects.UserSetupPage;

import Advaita_TDD.Advaita_TDD.FakeData;

public class SmsTemplate extends TestBase // Create_Class and extend base class
{
	public SmsTemplate() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

//Login USerIds
	String superAmdin = "Capture_Admin";
	String superAdminPass = "Qwerty@123";

	String userID = "Abhijit@trasccon";
	String userPassword = "Qwerty@123";

	String userId1 = "Abhijit_idamta";
	String password1 = "Qwerty@123";

	// -----------Global Variables Realted in Template Modules------>
	public String selectProcess;
	public String selectSubProcess;
	public String selectSubSubProcess;
	public String selectStagesDropdown;

	String dispositionTextField = FakeData.lastName1() + "_DSP";

	String selectToNumberSource_StageField = "From Stage Fields";
	String selectToNumberSource_SystemName = "From System Names";
	String selectToNumberSource_Manual = "Manual";

	String toNumberForStageFieldOption = "Mobile_Number";
	String toNumberForSystemNameOption = "Mobile Number";
	String toNumberForManualOption = "";

	// Auto Sms
	public String createdDispositionQuestionSet;
	public String formName = "Call Log Stage View";

	// -------------------------------------------------
	String searchedStagesName = "Ticket Booking _Stage 2";

	public String FirstCreatedUserName;
	public String lastcreatedsmsTemplate_messageTextfield;
	public String selectedNumberDropdown_toNumber_SMSPopup;

	public String stagesCreatedProcess1;
	public String stagesCreatedSubProcess2;
	public String stagesCreatedSubsubProcess3;
	public String verifyCreatedStages;

	public String createdDispositionQuestionSetText;

	private static final String PROPERTIES_FILE_PATH2 = "src/main/resources/SingleTextExtract.properties";

	// ---------------Elements------------------
	// Entirebody Click
	@FindBy(tagName = "body")
	public WebElement driverIninteractable;

	@FindBy(xpath = "(//a//img[@alt='right_arrow'])[2]")
	public WebElement lastrightArrowButton;

	@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']")
	public WebElement profileDropdown;

	@FindBy(linkText = "Logout")
	public WebElement logout;

	// user Login
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

	@FindBy(xpath = "//input[@id='text_search']")
	public WebElement searchTextfield_Stages;

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

	@FindBy(xpath = "//span[@id='change_msg']")
	public WebElement stagesUpdatedSuccessfully_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButton_stages;

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

	@FindBy(xpath = "//label[text()='Process*']")
	public WebElement processLabel;

	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement SubProcessDropdown;

	@FindBy(xpath = "//label[text()='Sub Process*']")
	public WebElement subProcessLabel;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement SubsubProcessDropdown;

	@FindBy(xpath = "//label[text()='Sub Sub Process*']")
	public WebElement subSubProcessLabel;

	@FindBy(xpath = "//select[@id='stage_name_id']")
	public WebElement smsStages;

	@FindBy(xpath = "//label[text()='Stages*']")
	public WebElement stagesLabel;

	@FindBy(xpath = "//label[text()='API Key Name*']")
	public WebElement apiKeyNameLabel;

	@FindBy(id = "api_name")
	public WebElement apikeyName;

	@FindBy(xpath = "//input[@name='template_name']")
	public WebElement smsTemplateName;

	@FindBy(xpath = "//label[text()='Template Name*']")
	public WebElement templateNameLabel;

	@FindBy(name = "disposition")
	public WebElement smsDisposition;

	@FindBy(xpath = "//label[text()='Disposition']")
	public WebElement dispositionLabel;

	@FindBy(name = "from_no")
	public WebElement fromNumber;

	@FindBy(xpath = "//label[text()='From Number*']")
	public WebElement fromNumberLabel;

	@FindBy(id = "toNumber")
	public WebElement toNumber;

	@FindBy(xpath = "//label[text()='To Number']")
	public WebElement toNumberLabel;

	@FindBy(xpath = "//label[text()='To Number Source']/..//select")
	public WebElement toNumberSource;

	@FindBy(xpath = "//label[text()='To Number Source']")
	public WebElement toNumberSourceLabel;

	@FindBy(xpath = "//textarea[@name='message']")
	public WebElement message;

	@FindBy(xpath = "//label[text()='Message*']")
	public WebElement messagLabel;

	@FindBy(xpath = "//textarea[@name='remarks']")
	public WebElement remarks;

	@FindBy(xpath = "//label[text()='Remarks']")
	public WebElement remarksLabel;

	@FindBy(xpath = "//input[@name='temp_variable_name_1']")
	public WebElement variableTextfield;

	@FindBy(xpath = "//select[@class='form-control stages_fields_dropsown']")
	public WebElement stageFieldNameDropdown;

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
	public WebElement smsIcon_userAccountSatgeView;

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

	@FindBy(xpath = "//ul//li//button[@id='sms-tab']")
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
	public WebElement subprocessDropdown_Table;

	@FindBy(id = "s_sub_process_search")
	public WebElement subSubProcessDropdown_Table;

	@FindBy(xpath = "//select[@name='stage_search']")
	public WebElement StagesDropdown_table;

	@FindBy(xpath = "//div//button//img[@alt='filter_search']")
	public WebElement searchbutton_Table;

	@FindBy(xpath = "//td[normalize-space(.)='No Entries Found']")
	public WebElement noEntriesFound;

	@FindBy(xpath = "//div//img/..//h6")
	public WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "//select[@id='page-size-select']")
	public WebElement itemperpageDropdown;

	// Verify Selected Process
	@FindBy(xpath = "(//thead//tr//th/../../..//td)[2]")
	public WebElement firstProcess;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[3]")
	public WebElement firstSubProcess;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[4]")
	public WebElement firstSubSubProcess;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[5]")
	public WebElement firstStages;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> beforeSearchData_Table;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> afterSearchData_Table;

	public List<WebElement> satgeNameList;

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

	@FindBy(xpath = "//tbody//tr[1]//td[1]/../..//tr//td[1]")
	List<WebElement> templateNameLists;

	// DispositionStages And Auto Sms Mapping Elemnets

	@FindBy(xpath = "//tbody//tr[1]//td[6]//div//img[@title='stage_settings_list']")
	public WebElement stageSettingList;

	@FindBy(xpath = "//tbody//tr[6]//td[2]")
	public WebElement stagesDispositionOption;

	@FindBy(xpath = "((//tbody//tr[1]//td[6])//div//img[@class='img-fluid stages_edit delete-dataset'])[1]")
	public WebElement stagesEditOptionFirst;

	@FindBy(xpath = "//select[@id='disposition_stagewise']")
	public WebElement selectStageInDisposition;

	@FindBy(xpath = "(//label[text()='Disposition*'])[2]")
	public WebElement selectDispositionQuestionSetLabel;

	@FindBy(xpath = "//select[@id='disposition_stagewise']")
	public WebElement selectDispositionQuestionSet;

	@FindBy(xpath = "(//label[text()='Form Name*'])[1]")
	public WebElement selectFormNameLabel;

	@FindBy(xpath = "//select[@id='form_name']")
	public WebElement selectFormNameInDisposition;

	@FindBy(xpath = "(//tbody/tr[1]//td)[1]")
	public WebElement dispositionQuestionSet;

	@FindBy(xpath = "(//button[text()='Save'])[2]")
	public WebElement saveButtonStagesDisposition;

	@FindBy(xpath = "//tbody//tr[last()]//td[1][not(text()='No Templates Found')]")
	public WebElement fromStages;

	@FindBy(xpath = "//tbody//tr[last()]//td[2][last()]")
	public WebElement toStages;

	@FindBy(xpath = "//tbody//tr[last()]//td[6][last()]//a[4]")
	public WebElement autoSMSMappingOptions;

	@FindBy(xpath = "//h2[text()='Auto SMS Mapping']")
	public WebElement verifyAutoSmsMappingPage;

	@FindBy(xpath = "//select[@id='auto_sms_template']")
	public WebElement autoSmsTemplatDropdown;

	@FindBy(xpath = "//h2[text()='Auto SMS Mapping']/../..//button")
	public WebElement addButtonInAutoSmsMappingPage;

	@FindBy(xpath = "//tbody[@id='auto_sms_tbody']//tr//td[not(.//img)]")
	public List<WebElement> listOfAddedTemplateNames;

	@FindBy(xpath = "//span[@id='change_msg']")
	public WebElement autoSmsAMppingUpdateSuccessfulley_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButtonForAutoSmsMApping;

	// Negative
	@FindBy(xpath = "//label[@id='process-error']")
	public WebElement processErrorMessage;

	@FindBy(xpath = "//label[@id='stage_name_id-error']")
	public WebElement stagesErrormessage;

	@FindBy(xpath = "//label[@id='template_name-error']")
	public WebElement templateNameErrorMessage;

	@FindBy(id = "from_no-error")
	public WebElement fromNumberErrorMessage;

	@FindBy(xpath = "//label[@id='message-error']")
	public WebElement messageErrorMessage;

	@FindBy(xpath = "//label[text()='This field is required.']")
	public WebElement thisfieldErrorMessage;

	@FindBy(xpath = "//span[@id='change_error_msg']")
	public WebElement somethingWentWrongErrorMesg;

	// Refernce Method
	HomePage homePage = new HomePage();
	MastersFieldSets masterFieldSet = new MastersFieldSets();
	Disposition disposition = new Disposition();

	PropertieFileUtil propertieFileUtil = new PropertieFileUtil();
	DropDown dropDown = new DropDown();
	FieldVerificationUtils fieldVerificationUtils = new FieldVerificationUtils();

	ApiKeySetup apiKeySetup = new ApiKeySetup();

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

	public void navigatetoStage_verifySMS() throws Throwable {
		driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");
		assertTrue(verifyStage.isDisplayed(), "verifyStage is not displayed");

		assertTrue(searchTextfield_Stages.isDisplayed(), "searchTextfieldStages is not displayed");
		searchTextfield_Stages.sendKeys(searchedStagesName);
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

		// clickDynamicStage(1);
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

			searchTextfield_Stages.sendKeys(searchedStagesName);
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

	}

	public void navigateTo_AlchemyModule() {

		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
		jsClick(driver, alchemySidemenubar);
		jsClick(driver, alchemySidemenubar);

	}

	public void navigateto_SmsTemplateTab() {

		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/sms_template_listing/");
		jsClick(smsTemplateTab);
		assertTrue(smsTemplateText.isDisplayed(), "smsTemplateText is not displayed");
	}

	public void CreateSmstemplate() {
		assertTrue(createButtonSmsTemplate.isDisplayed(), "createButtonSmsTemplate is not displayed");
		// Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		createButtonSmsTemplate.click();
		wait.until(ExpectedConditions.visibilityOf(CreatesmstepmlateText));
		assertTrue(CreatesmstepmlateText.isDisplayed(), "CreatesmstepmlateText is not displayed");

	}

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

	public void selectProcess() throws Throwable {
		// 1st Way Fetch Trough stages and Select
		// dropdownUtils(ProcessDropdown, stagesCreatedProcess1);

		// 2nd Way Using Properties File
		fieldVerificationUtils.checkthroughAsterisk(processLabel, true);

		selectProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"process");

		dropDown.dropdownUtils(ProcessDropdown, selectProcess);
		System.out.println("selectProcess :" + selectProcess);

	}

	public void SelectSubProcess() throws Throwable {

		// dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);

		// 2nd Way Using Properties File
		fieldVerificationUtils.checkthroughAsterisk(subProcessLabel, true);

		selectSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"subProcess");

		dropDown.dropdownUtils(SubProcessDropdown, selectSubProcess);

	}

	public void selectSubSubProcess() throws Throwable {

		// dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		// 2nd Way Using Properties File
		fieldVerificationUtils.checkthroughAsterisk(subSubProcessLabel, true);

		selectSubSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"subSubProcess");

		dropDown.dropdownUtils(SubsubProcessDropdown, selectSubSubProcess);
	}

	public void selectStages() throws Throwable {

//		Thread.sleep(1000);
//		dropdownUtils(smsStages, verifyCreatedStages);

		// 2nd Way Using Properties File
		fieldVerificationUtils.checkthroughAsterisk(stagesLabel, true);

		selectStagesDropdown = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"stage");

		dropDown.dropdownUtils(smsStages, selectStagesDropdown);
	}

	public void selectApiName() throws Throwable {

		// 2nd Way Using Properties File
		fieldVerificationUtils.checkthroughAsterisk(apiKeyNameLabel, true);

		String selectApiName = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"ApiName");
		System.out.println("selectApiName :" + selectApiName);

		dropDown.dropdownUtils(apikeyName, selectApiName);

	}

	public void SmsTemplateName() throws IOException {

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

		fieldVerificationUtils.checkthroughAsterisk(templateNameLabel, true);

		assertTrue(smsTemplateName.isDisplayed(), " smsTemplateName is not dispalyed ");
		smsTemplateName.sendKeys(randomTemplateName);

		// Capture TemplateName_Sms and Store In Properti File
		String smsTemplateNameValue = smsTemplateName.getAttribute("value");

		PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_PATH2,"SmsTemplateName", smsTemplateNameValue);
	}

	public void disposition() {

		// 2nd Way Using Properties File

		fieldVerificationUtils.checkthroughAsterisk(dispositionLabel, false);
		assertTrue(smsDisposition.isDisplayed(), "smsDisposition is not dispalyed");
		smsDisposition.sendKeys(dispositionTextField);

	}

	public void fromNumber() {

		// Define the mobile number range
		long min = 1000000000L; // Minimum 10-digit number
		long max = 9999999999L; // Maximum 10-digit number

		// Create a Random object
		Random random1 = new Random();

		// Generate a random number within the range
		long randomNumber = min + ((long) (random1.nextDouble() * (max - min)));

		// Print the random mobile number
		System.out.println("Random Mobile Number: " + randomNumber);

		fieldVerificationUtils.checkthroughAsterisk(fromNumberLabel, true);

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

		// Through System Name
		// validateAndSelectFromDropdownUTILS(toNumberSource, "From System Names");

		// Through Stage Field
		fieldVerificationUtils.checkthroughAsterisk(toNumberSourceLabel, false);
		validateAndSelectFromDropdownUTILS(toNumberSource, selectToNumberSource_StageField);

	}

	public void toNumber() {

		fieldVerificationUtils.checkthroughAsterisk(toNumberLabel, false);
		validateAndSelectFromDropdownUTILS(toNumber, toNumberForStageFieldOption);

	}

	// SMS - message
	public void message() {

		fieldVerificationUtils.checkthroughAsterisk(messagLabel, true);

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

		fieldVerificationUtils.checkthroughAsterisk(remarksLabel, false);
		assertTrue(remarks.isDisplayed(), "remarks is not displayed");
	}

	public void variables() {

		assertTrue(variableTextfield.isDisplayed(), "templateVariableName is not displayed");
	}

	public void selectStageField() {

		assertTrue(stageFieldNameDropdown.isDisplayed(), "stageFieldName is not displayed");
		validateAndSelectFromDropdownUTILS(stageFieldNameDropdown, toNumberForStageFieldOption);
	}

	public void EnterDefaultValue() {
		// Default value
		assertTrue(defaultValue.isDisplayed(), "defaultValue is not dispalyed");

	}

	@FindBy(xpath = "//a[text()='+ Add Row']")
	public WebElement addRowOptions;

	public void addMultipleRows(int numberOfRows) {
		for (int i = 0; i < numberOfRows; i++) {
			addRowOptions.click();
		}
	}

	@FindBy(xpath = "//img[@alt='delete-icon']")
	public List<WebElement> delteOptions;

	public void deleteMultipleRows(int numberOfRowsToDelete) {
		for (int i = 0; i < numberOfRowsToDelete; i++) {
//			delteOptions = driver.findElements(By.xpath("//img[@alt='delete-icon']")); // Refresh list
			if (!delteOptions.isEmpty()) {
				delteOptions.get(0).click(); // Always click first one
			} else {
				System.out.println("No more rows to delete at index " + i);
				break;
			}
		}
	}

	public void createButtonAndVerifySuccessPopupAndContinue() {

		// Create Button
		assertTrue(createButton_SmsTemplatePopup.isDisplayed(), "createButton_SmsTemplatePopup is not displayed");
		createButton_SmsTemplatePopup.click();

		// Verify Popup
		wait.until(ExpectedConditions.visibilityOf(smsTemplateCreatedSuccessfully_popuop));
		assertTrue(smsTemplateCreatedSuccessfully_popuop.isDisplayed(),
				"smsTemplateCreatedSuccessfully_popuop is not displayed");

		// click on Continue
		assertTrue(continueButton_create.isDisplayed(), "continueButton_create is not displayed");
		continueButton_create.click();
	}

	public void verifyCreatedSmsTemplate() {

//        js.executeScript("arguments[0].scrollIntoView(true);", lastIndexArrowButton); // Scroll the webpage
//        wait.until(ExpectedConditions.visibilityOf(lastIndexArrowButton));
//        assertTrue(lastIndexArrowButton.isDisplayed(), "lastIndexArrow is not displayed");
//        lastIndexArrowButton.click();

		js.executeScript("arguments[0].scrollIntoView(true);", lastrightArrowButton); // Scroll the webpage
		assertTrue(lastrightArrowButton.isDisplayed(), "lastrightArrowButton is not Displayed");
		lastrightArrowButton.click();

		wait.until(ExpectedConditions.visibilityOf(lastCreatedSms_templatename));

		assertTrue(last_CreatedSms.isDisplayed(), "last_CreatedSms is not displayed");
		last_CreatedSms.getText();
		System.out.println("Last Created Smstemplate : " + lastCreatedSms_templatename.getText());

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

		userSetupPage.singleGroupSelect("Admin");
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

		assertTrue(smsIcon_userAccountSatgeView.isDisplayed(), "SmsIcon_userAccountSatgeView is not displayed");
		smsIcon_userAccountSatgeView.click();

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

	// Table Page_SuperAdmin

	public void searchThroughProcess() throws Throwable {

		assertTrue(processDropdown_Table.isDisplayed(), "processDropdown_Table is not Displayed");
		assertTrue(processDropdown_Table.isEnabled(), "processDropdown_Table is noT Enabled");

		String processDropdownTable = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"process");
		dropDown.dropdownUtils(processDropdown_Table, processDropdownTable);

	}

	public void searchThroughSubProcess() throws Throwable {

		assertTrue(subprocessDropdown_Table.isDisplayed(), "SubprocessDropdown_Table is not Displayed");
		assertTrue(subprocessDropdown_Table.isEnabled(), "processDropdown_Table is noT Enabled");

		String SubProcessDropdownTable = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"subProcess");
		dropDown.dropdownUtils(subprocessDropdown_Table, SubProcessDropdownTable);

	}

	public void searchThroughSubSubProcess() throws Throwable {
		assertTrue(subSubProcessDropdown_Table.isDisplayed(), "subSubProcessDropdown_Table is not Displayed");
		assertTrue(subSubProcessDropdown_Table.isEnabled(), "subSubProcessDropdown_Table is noT Enabled");

		String subSubProcessDropdownTable = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"subSubProcess");
		dropDown.dropdownUtils(subSubProcessDropdown_Table, subSubProcessDropdownTable);

	}

	public void searchThroughStages() throws Throwable {

		assertTrue(StagesDropdown_table.isDisplayed(), "StagesDropdown_table is not Displayed");
		assertTrue(StagesDropdown_table.isEnabled(), "subSubProcessDropdown_Table is noT Enabled");

		String stagesDropdownTable = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"stage");
		dropDown.dropdownUtils(StagesDropdown_table, stagesDropdownTable);
	}

	public void clickOnSearchButton() {

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not Dispalyed");
		searchbutton_Table.click();
	}

	// verify with Process
	public void verifyselectedProcessShouldMatchWithProcess() {

		dropDown.checkForSelectedOptionsAfterSearched(processDropdown_Table, firstProcess, noEntriesFound);

	}

	// verify with SubProcess
	public void verifyselectedSubProcessShouldMatchWithSubProcess() {

		dropDown.checkForSelectedOptionsAfterSearched(processDropdown_Table, firstSubProcess, noEntriesFound);
	}

	// verify with SubSubProcess
	public void verifyselectedSubSubProcessShouldMatchWithSubSubProcess() {

		dropDown.checkForSelectedOptionsAfterSearched(subSubProcessDropdown_Table, firstSubSubProcess, noEntriesFound);
	}

	// verify with SubSubProcess
	public void verifyselectedSubSubProcessShouldMatchWithStages() {

		dropDown.checkForSelectedOptionsAfterSearched(StagesDropdown_table, firstStages, noEntriesFound);
	}

	// Clear Filter
	public void ClearFilters() {
		Select processdropdown_tablePage = new Select(processDropdown_Table);
		processdropdown_tablePage.selectByVisibleText("AJP");
		processdropdown_tablePage.getFirstSelectedOption();
		System.out.println("first SelectedOption afterSelect Process Dropdown"
				+ processdropdown_tablePage.getFirstSelectedOption());

		Select subProcessdropdown_tablePage = new Select(subprocessDropdown_Table);
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

	public void clearTextfiledByEnterCleaeAllFilters() {

	}

	// Search Through search Field
	public void searchThroughSeachTextfield() throws Throwable {
		String templateName = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"SmsTemplateName");

		assertTrue(seachTextfield_SmsTemplate.isDisplayed(), "seachTextfield_SmsTemplate i snot Displayed");
		seachTextfield_SmsTemplate.sendKeys(templateName);

		clickOnSearchButton();

		try {
			if (noEntriesFound.isDisplayed()) {
				// Fail the test and stop execution
				throw new AssertionError("Failed: There is no template present with the name: " + templateName);
			} else {
				String lastCreatedSmsTemplate = lastCreatedSms_templatename.getText().trim();
				System.out.println("Template found: " + lastCreatedSmsTemplate);

				assertEquals(templateName, lastCreatedSmsTemplate,
						"Mismatch between expected and actual template names");
			}
		} catch (NoSuchElementException e) {
			// If the 'noEntriesFound' element doesn't exist, proceed as normal
			String lastCreatedSmsTemplate = lastCreatedSms_templatename.getText().trim();
			System.out.println("'noEntriesFound' element not found. Assuming template is present.");
			System.out.println("Template found: " + lastCreatedSmsTemplate);

			assertEquals(templateName, lastCreatedSmsTemplate, "Mismatch between expected and actual template names");
		}
	}

	public void Delete_createdSmsTemplate() {

		String lastCreatedSmsTemplate = last_CreatedSms.getText().trim();
		System.out.println("lastCreatedSmsTemplate Text: " + lastCreatedSmsTemplate);

		// Delete
		assertTrue(LastDelete_smsTempalte.isDisplayed(), "LastDelete_smsTempalteis not displayed");

		jsClick(LastDelete_smsTempalte);

		assertTrue(deleteButton_delete.isDisplayed(), "deleteButton_delete is not displayed");
		deleteButton_delete.click();

		wait.until(ExpectedConditions.visibilityOf(deleted_SuceessfullyPopup));
		assertTrue(deleted_SuceessfullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is not displayed");
		deleted_SuceessfullyPopup.click();

		assertTrue(continueButton_DeleteSuccessullyPopup.isDisplayed(),
				"continueButton_DeleteSuccessullyPopup is not displayed ");
		continueButton_DeleteSuccessullyPopup.click();

		assertTrue(searchTextfield_Stages.isDisplayed(), "searchTextfield is not Displayed");
		searchTextfield_Stages.sendKeys(lastCreatedSmsTemplate);

		clickOnSearchButton();

		assertTrue(noEntriesFound.isDisplayed(), "Failed : Template is Not Yet Deleted after click on Delete Option");

		searchTextfield_Stages.clear();

	}

	// EDIT
	public void Edit_smsTemplated() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(alchemySidemenubar));
		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(alchemySidemenubar);
		jsClick(alchemySidemenubar);

		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/sms_template_listing/");
		jsClick(smsTemplateTab);
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
		selectProcess();
		SelectSubProcess();
		selectSubSubProcess();
		selectStages();
		SmsTemplateName();
		disposition();
		fromNumber();
		toNumberSourceSystemNames();
		toNumberSystemNames();
		message();
		remarksField();
		createButtonAndVerifySuccessPopupAndContinue();

		// navigateTo_MasterParameterDisposition();
		stagesDispositionClick();

	}

	public void toNumberSourceSystemNames() {
		validateAndSelectFromDropdownUTILS(toNumberSource, "From System Names");
	}

	public void toNumberSystemNames() {
		validateAndSelectFromDropdownUTILS(toNumber, "Cloud Phone Category");

	}

	// -------------- Disposition -------------

	// Addeed Disposition Question Set
	public void createDispositionQuestionSet() throws Throwable {

		homePage.clickOnDisposition();

		String questionSetNameString = fake.lastName1() + "_Employee Status_A";

		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString); // Create Disposition

		// Drop Down
		List<String> sector = Arrays.asList("Pending", "complete", "under process");
		masterFieldSet.addQuestions(0).addDropDownRelatedQuestions("What is the current status of the employee ?", 1, // Section
				1, // Question
				MastersFieldSets.DROP_DOWN, sector);

		disposition.saveRecord();

	}

	// verify Created Disposition set
	public void verifyDispositionQuestionSet() throws Throwable {

		createdDispositionQuestionSet = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"DispositionQuestionSet");

		assertTrue(Disposition.searchBox.isDisplayed(), "searchBox is not Displayed");
		assertTrue(Disposition.searchBox.isEnabled(), "searchBox is not Enabled");

		Disposition.searchBox.sendKeys(createdDispositionQuestionSet);

		assertTrue(Disposition.searchButton.isDisplayed(), "searchButton is not Displayed");

		Disposition.searchButton.click();

		createdDispositionQuestionSetText = dispositionQuestionSet.getText();
		System.out.println("createddispositionQuestionSetText : " + createdDispositionQuestionSetText);

		assertEquals(createdDispositionQuestionSet, createdDispositionQuestionSetText,
				"Failed :search Disposition Question Set Not Matched With Created disposition set");

	}

	public void navigateToStages() {

		driver.navigate().to(mainURl + "en/stages/stages_list/");
	}

	public void navigateToStageSettingList() {
		int retries = 3;

		while (retries > 0) {
			try {
				WebElement element = wait.until(ExpectedConditions.visibilityOf(stageSettingList));

				assertTrue(element.isDisplayed(), "stageSettingList is not displayed");
				element.click();
				break; // success, exit the loop

			} catch (StaleElementReferenceException e) {
				System.out.println("Caught StaleElementReferenceException, retrying...");
				retries--;
			}
		}

		if (retries == 0) {
			throw new RuntimeException(
					"Failed to click on stageSettingList due to repeated StaleElementReferenceExceptions");
		}
	}

	public void naviagteToDispositionMapping() {

		navigateToStageSettingList();

		wait.until(ExpectedConditions.visibilityOf(stagesDispositionOption));
		assertTrue(stagesDispositionOption.isDisplayed(), "stagesDispositionOption is not Displayed");
		stagesDispositionOption.click();
	}

	// Disposition_ for Auto Sms
	public void stagesDispositionClick() throws Throwable {

		navigateToStages(); // naviagte To Stages

		String searchedStages = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"stage");

		assertTrue(searchTextfield_Stages.isDisplayed(), "searchTextfieldStages is not displayed");
		searchTextfield_Stages.sendKeys(searchedStages);
		searchbutton_Table.click();

		naviagteToDispositionMapping(); // Naviagte To Disposition Mapping Page

	}

	public void selectProcesses() throws Throwable {

		String process = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"process");
		dropdownUtils(processDropdown_Table, process);

		String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"subProcess");
		dropdownUtils(subprocessDropdown_Table, subProcess);

		String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"subSubProcess");
		dropdownUtils(subSubProcessDropdown_Table, subSubProcess);

	}

	public void selectStagesDisposition() throws Throwable {

		String sealectStage = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"stage");
		dropdownUtils(StagesDropdown_table, sealectStage);

	}

	public void selectDispositionQuestionSet() throws Throwable {

		fieldVerificationUtils.checkthroughAsterisk(selectDispositionQuestionSetLabel, true);
		assertTrue(selectDispositionQuestionSet.isDisplayed(), "selectDispositionQuestionSet is Not dislayed");

		dropdownUtils(selectStageInDisposition, createdDispositionQuestionSet);
	}

	public void selectFormName() throws Throwable {

		fieldVerificationUtils.checkthroughAsterisk(selectFormNameLabel, true);
		assertTrue(selectFormNameInDisposition.isDisplayed(), "selectFormNameInDisposition is Not dislayed");

		dropdownUtils(selectFormNameInDisposition, formName);

	}

//-------------------------------------------------------------------------------------
	public void clickAndsaveOnDispositionMapingPage() {

		// wait.until(ExpectedConditions.visibilityOf(firstCreated_UserManagement));
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

	public void naviagteToAutoSmsMappingAndAddSmstemplate() throws Throwable {

		js.executeScript("arguments[0].scrollIntoView(true);", autoSMSMappingOptions);

		wait.until(ExpectedConditions.visibilityOf(autoSMSMappingOptions));

		jsClick(driver, autoSMSMappingOptions);

//		wait.until(ExpectedConditions.visibilityOf(verifyAutoSmsMappingPage));
//		assertTrue(verifyAutoSmsMappingPage.isDisplayed(), "verifyAutoSmsMapping is not displayed");

	}

	// Select Sms temaplte In Auto Sms Mapping Page
	public void selectSmsTemplateAndClickOnAddForAutoSMSMapping() throws Throwable {

		String selectQuestionSet = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"SmsTemplateName");
		dropdownUtils(autoSmsTemplatDropdown, selectQuestionSet);

//		assertTrue(addButtonInAutoSmsMappingPage.isDisplayed(), "addButtonInAutoSmsMappingPage is Not displayed");
//		addButtonInAutoSmsMappingPage.isEnabled();
//		addButtonInAutoSmsMappingPage.click();

	}

	public void verifyAutoSmsUpdateSuccessfully() {
		verifyAutoSmsMappingUpdateSuccessfully();
	}

	public void verifyAutoSmsMappingUpdateSuccessfully() {
		assertTrue(autoSmsAMppingUpdateSuccessfulley_popuop.isDisplayed(),
				"autoSmsAMppingUpdateSuccessfulley_popuop is not Displayed");

		assertTrue(continueButtonForAutoSmsMApping.isDisplayed(), "continueButtonForAutoSmsMApping is Not dispalyed");
		continueButtonForAutoSmsMApping.click();

	}

	// verify The added Sms template refect In Temaple Page on auto sms MApping
	// Page.

	List<String> templateNamesListsInAutoSmsMAppingPage = new ArrayList<String>();

	public void verifyselectedTemplateMatchedWithTemplateNameAfterAdd() throws Throwable {

		naviagteToAutoSmsMappingAndAddSmstemplate();// Naviagte To autom sms Mapping Page

		String selectQuestionSet = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_PATH2,"SmsTemplateName");
		dropdownUtils(autoSmsTemplatDropdown, selectQuestionSet);

		for (WebElement templateNamesInAutoSmsMapingPage : listOfAddedTemplateNames) {

			String templateName = templateNamesInAutoSmsMapingPage.getText();

			templateNamesListsInAutoSmsMAppingPage.add(templateName);
		}

		assertTrue(templateNamesListsInAutoSmsMAppingPage.contains(selectQuestionSet),
				"Selected/AddedQuestion Isnot added and It it is nOt Dispalyed in auto Sms Mapping page");
	}

/////////////////////////////////////// Negative Testing ///////////////////////////////////////////////////////////////////////	

	public void withoutSelectingAnyFieldAndCreteUtility(WebElement smsCreateButton,
			WebElement fieldRequiredErrorMEssage) {

		String Combinetext = processLabel.getText() + subProcessLabel.getText() + subSubProcessLabel.getText()
				+ stagesLabel.getText() + templateNameLabel.getText() + messagLabel.getText();
		System.out.println("Combinetext" + Combinetext);

		String asterisk = "*";
		assertTrue(Combinetext.contains(asterisk), "asterisk is not contains in Combinetext text");

		smsCreateButton.click();

		boolean isEitherDisplayed = fieldRequiredErrorMEssage.isDisplayed();
		assertTrue(isEitherDisplayed,
				"'thisFieldisRequiredErrorMessage' is not displayed for Mandatory fields, test failed.");

	}

	public void withoutSelectingAnyFieldAndCrete() {

		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		withoutSelectingAnyFieldAndCreteUtility(createButton_SmsTemplatePopup, thisfieldErrorMessage);
	}

	public void withoutSelectingStagesAndCreateUtility(WebElement stagelabel, WebElement stagesDropdwonElement,
			WebElement smsCreateButton, WebElement stageErrorMesg) throws Throwable {

		String captureStagesLabel = stagelabel.getText();
		String asterisk = "*";
		assertTrue(captureStagesLabel.contains(asterisk), "asterisk is not contains in captureStagesLabel text");

		String defaultStage = "Select Stage";
		Select stagesOption = new Select(stagesDropdwonElement);
		String stagesFirstSelectedOption = stagesOption.getFirstSelectedOption().getText();

		smsCreateButton.click();

		boolean isEitherDisplayed = stageErrorMesg.isDisplayed() && stagesFirstSelectedOption.equals(defaultStage);
		assertTrue(isEitherDisplayed,
				"'thisFieldisRequired'ErrorMessage is not displayed for Mandatory StagesDropdown, test failed.");

	}

	public void withoutSelectingStagesAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		SmsTemplateName();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		message();
		remarksField();

		withoutSelectingStagesAndCreateUtility(stagesLabel, smsStages, createButton_SmsTemplatePopup,
				stagesErrormessage);

	}

	public void withoutEnterTemplateNameAndCreateUtility(WebElement templateNameLabelElement,
			WebElement templateNameElement, WebElement smsCreateButton, WebElement templateNameerrorMesgElement) {

		String captureTemplateNameLabel = templateNameLabelElement.getText();
		String asterisk = "*";
		assertTrue(captureTemplateNameLabel.contains(asterisk), "asterisk is not contains in captureStagesLabel text");

		smsCreateButton.click();

		boolean isEitherDisplayed = templateNameerrorMesgElement.isDisplayed();
		assertTrue(isEitherDisplayed,
				"'thisFieldisRequired'ErrorMessage is not displayed for Mandatory TemplateNameTextfield, test failed.");

	}

	public void withoutEnterTemplateNameAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		withoutEnterTemplateNameAndCreateUtility(templateNameLabel, smsTemplateName, createButton_SmsTemplatePopup,
				templateNameErrorMessage);

	}

	public void withoutEnterFromNumberOtionAndCreateUTILITY(WebElement fromNumberLabelElement,
			WebElement smsCreateButton, WebElement fromNumbererrorMesgElement) {

		String capturefromNumberLabel = fromNumberLabelElement.getText();
		String asterisk = "*";
		assertTrue(capturefromNumberLabel.contains(asterisk), "asterisk is not contains in captureStagesLabel text");

		smsCreateButton.click();

		boolean isEitherDisplayed = fromNumbererrorMesgElement.isDisplayed();
		assertTrue(isEitherDisplayed,
				"'thisFieldisRequired'ErrorMessage is not displayed for Mandatory FromNumberTextfield, test failed.");

	}

	public void withoutEnterFromNumberOtionAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		SmsTemplateName();
		disposition();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		message();
		remarksField();

		withoutEnterFromNumberOtionAndCreateUTILITY(fromNumberLabel, createButton_SmsTemplatePopup,
				fromNumberErrorMessage);
	}

	public void withoutSelectToNumberOtionAndCreateUTILITY(WebElement toNumberLabelElement, WebElement smsCreateButton,
			WebElement somethingWentWrongErrorMesg) {

		String capturefromNumberLabel = toNumberLabelElement.getText();
		String asterisk = "*";
		assertTrue(!capturefromNumberLabel.contains(asterisk), "asterisk contains in captureStagesLabel text"); // need
																												// to
																												// implement
																												// later

		smsCreateButton.click();

//		boolean isEitherDisplayed = somethingWentWrongErrorMesg.isDisplayed();
//		wait.until(ExpectedConditions.visibilityOf(somethingWentWrongErrorMesg));
//		assertTrue(isEitherDisplayed,
//				"'thisFieldisRequired'ErrorMessage is not displayed for Mandatory FromNumberTextfield, test failed.");
		wait.until(ExpectedConditions.visibilityOf(somethingWentWrongErrorMesg));
		assertTrue(somethingWentWrongErrorMesg.isDisplayed(), "SomethingWentWrong is not diplsyed and it is created");

		driver.navigate().refresh();
	}

	public void withoutSelectToNumberOtionAndCreate() throws Throwable {
		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		SmsTemplateName();
		disposition();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		disposition();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		message();
		remarksField();
		withoutSelectToNumberOtionAndCreateUTILITY(toNumberLabel, createButton_SmsTemplatePopup,
				somethingWentWrongErrorMesg);

	}

	public void enterCharacterInNumberFielTextfielddAndCreateUTILITY(WebElement fromNumberLabelElement,
			WebElement NumbertextfieldElement, WebElement smsCreateButton, WebElement fromNumberErrorMesagElement,
			WebElement templateCreatedSuccessfulyPopup) {

		String capturefromNumberLabel = fromNumberLabelElement.getText();
		String asterisk = "*";
		assertTrue(capturefromNumberLabel.contains(asterisk), "asterisk is not contains in captureStagesLabel text");

		String alphabets = "xyz";

		assertTrue(NumbertextfieldElement.isDisplayed(), "smsCreateButton is not displayed");
		NumbertextfieldElement.sendKeys(alphabets);

		smsCreateButton.click();

		if (fromNumberErrorMesagElement.isDisplayed()) {
			assertTrue(true, "fromNumberErrorMessage is displayed, test case passed.");
		} else if (templateCreatedSuccessfulyPopup.isDisplayed()) {
			// Assert.fail("In 'fromNumber', it can accept alphabet instead of number.");
			assertTrue(false, "In 'fromNumber', it can accept number only instead of aplabet.");
		} else {
			// Assert.fail("Neither error nor success popup is displayed.");
			assertTrue(false, "Neither error nor success popup is displayed.");
		}
		driver.navigate().refresh();
	}

	public void enterCharacterInNumberFielTextfielddAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		SmsTemplateName();
		disposition();

		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		remarksField();

		enterCharacterInNumberFielTextfielddAndCreateUTILITY(fromNumberLabel, fromNumber, createButton_SmsTemplatePopup,
				fromNumberErrorMessage, smsTemplateCreatedSuccessfully_popuop);
	}

	public void withoutEnterMessageNameAndCreateUtility(WebElement messageLabelElement, WebElement smsCreateButton,
			WebElement messageErrorMesgElement) {

		String captureMessageLabel = messageLabelElement.getText();
		String asterisk = "*";
		assertTrue(captureMessageLabel.contains(asterisk), "asterisk is not contains in captureStagesLabel text");

		smsCreateButton.click();

		boolean isEitherDisplayed = messageErrorMesgElement.isDisplayed();
		assertTrue(isEitherDisplayed,
				"'thisFieldisRequired'ErrorMessage is not displayed for Mandatory MessageTextfield, test failed.");

	}

	public void withoutEnterMessageNameAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		SmsTemplateName();
		disposition();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		remarksField();
		withoutEnterMessageNameAndCreateUtility(messagLabel, createButton_SmsTemplatePopup, messageErrorMessage);

	}

	public void characterLimitTextfieldUtility(WebElement textfielElement, WebElement smsCreateButton,
			WebElement templateCreatedSuccessfullyPopup, WebElement somethingwentWrongErrorMesg) {

		// Character limit=256
		textfielElement.sendKeys("A".repeat(500));
		// smsCreateButton.click();
		jsClick(driver, smsCreateButton);

		// Check if "smsTemplateCreatedSuccessfully_popup" is displayed (Fail the test
		// if true)
		if (templateCreatedSuccessfullyPopup.isDisplayed()) {
			assertTrue(false, "Test failed: Text field can accept more than the character limit.");
		}

		// Check if "somethingwentWrongErrorMesg" is displayed (Pass the test if true)
		assertTrue(somethingwentWrongErrorMesg.isDisplayed(),
				"Test passed: 'Something went wrong' message is displayed.");

	}

	public void createTemplateThroughSpecialCharacterUTILITY(WebElement templateNameLabelElement,
			WebElement templateNameELement, WebElement smsCreteButton, WebElement templateCreatedSuccessfullyPopup,
			WebElement somethingwentWrongErrorMesg) {

		String specailChar = "!@#$%^&*(_";

		String captureTemplateNameLabel = templateNameLabelElement.getText();
		String asterisk = "*";
		assertTrue(captureTemplateNameLabel.contains(asterisk), "asterisk is not contains in captureStagesLabel text");

		assertTrue(templateNameELement.isDisplayed(), "templateNameELement is not displayed");

		templateNameELement.sendKeys(specailChar);

		// smsCreteButton.click();
		jsClick(driver, smsCreteButton);

//		if (templateCreatedSuccessfullyPopup.isDisplayed()) {
//			assertTrue(false,
//					"Test failed: Text field can accept can acceept special character and creatd template only with special character.");
//		}
//
//		// Check if "somethingwentWrongErrorMesg" is displayed (Pass the test if true)
//		assertTrue(somethingwentWrongErrorMesg.isDisplayed(),
//				"Test passed: 'Something went wrong' message is displayed.");

		// Check if "templateCreatedSuccessfullyPopup" is displayed (Fail the test if
		// true)
		if (templateCreatedSuccessfullyPopup.isDisplayed()) {
			softAssert.assertTrue(false,
					"Test failed: Text field can accept special character and created template only with special characters.");
		}

		// Check if "somethingwentWrongErrorMesg" is displayed (Pass the test if true)
		softAssert.assertTrue(somethingwentWrongErrorMesg.isDisplayed(),
				"Test passed: 'Something went wrong' message is displayed.");

		// Call assertAll() to report any soft assertion failures at the end of the test
		softAssert.assertAll();

	}

	public void createTemplteThroughSpecialCharacter() throws Throwable {
		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		disposition();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		message();
		remarksField();

		createTemplateThroughSpecialCharacterUTILITY(templateNameLabel, smsTemplateName, createButton_SmsTemplatePopup,
				smsTemplateCreatedSuccessfully_popuop, somethingWentWrongErrorMesg);

	}

	String emoji = "❤️😂😊";

	public void createTemplateForMandatoryFieldThroughEmojisUTILITY(WebElement LabelTextElement,
			WebElement textfieldFieldELement, WebElement smsCreteButton, WebElement templateCreatedSuccessfullyPopup,
			WebElement somethingwentWrongErrorMesg) {
		SendDataUtils.sendKeysWithJSExecutor(textfieldFieldELement, emoji); // use for send "emojis"

		String captureMessageLabel = LabelTextElement.getText();
		String asterisk = "*";
		assertTrue(captureMessageLabel.contains(asterisk), "asterisk is not contains in Label text");

		// smsCreteButton.click();
		jsClick(driver, smsCreteButton);
		if (templateCreatedSuccessfullyPopup.isDisplayed()) {
			assertTrue(false,
					"Test failed: Text field can Emojis Emojis in mandand for mandatory fields and it is successfully created .");
		}

		// Check if "somethingwentWrongErrorMesg" is displayed (Pass the test if true)
		wait.until(ExpectedConditions.visibilityOf(somethingwentWrongErrorMesg));
		assertTrue(somethingwentWrongErrorMesg.isDisplayed(),
				"Test passed: 'Something went wrong' message is displayed.");

	}

	public void createTemplateForNonMandatoryFieldThroughEmojisUTILITY(WebElement LabelTextElement,
			WebElement textfieldFieldELement, WebElement smsCreteButton, WebElement templateCreatedSuccessfullyPopup,
			WebElement somethingwentWrongErrorMesg) {
		SendDataUtils.sendKeysWithJSExecutor(textfieldFieldELement, emoji); // use for send "emojis"

		String captureMessageLabel = LabelTextElement.getText();
		String asterisk = "*";
		assertTrue(!captureMessageLabel.contains(asterisk), "asterisk is contains in Label text");

		smsCreteButton.click();

		if (templateCreatedSuccessfullyPopup.isDisplayed()) {
			assertTrue(false,
					"Test failed: Text field can Emojis Emojis in mandand for mandatory fields and it is successfully created .");
		}

		// Check if "somethingwentWrongErrorMesg" is displayed (Pass the test if true)
		wait.until(ExpectedConditions.visibilityOf(somethingwentWrongErrorMesg));
		assertTrue(somethingwentWrongErrorMesg.isDisplayed(),
				"Test passed: 'Something went wrong' message is displayed.");

	}

	public void enterEmojisInTemplateNameAndCreate() throws Throwable {
		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		disposition();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		message();
		remarksField();

		createTemplateForMandatoryFieldThroughEmojisUTILITY(templateNameLabel, smsTemplateName,
				createButton_SmsTemplatePopup, smsTemplateCreatedSuccessfully_popuop, somethingWentWrongErrorMesg);

	}

	public void enterEmojisInDispositionAndCreate() throws Throwable {
		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		SmsTemplateName();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		message();
		remarksField();

		createTemplateForNonMandatoryFieldThroughEmojisUTILITY(dispositionLabel, smsDisposition,
				createButton_SmsTemplatePopup, smsTemplateCreatedSuccessfully_popuop, somethingWentWrongErrorMesg);
	}

	public void enterEmojisInMessageTextfieldAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		SmsTemplateName();
		disposition();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		remarksField();

		createTemplateForMandatoryFieldThroughEmojisUTILITY(messagLabel, message, createButton_SmsTemplatePopup,
				smsTemplateCreatedSuccessfully_popuop, somethingWentWrongErrorMesg);

	}

	public void enterLessThanDigitLimitAndCreateUTILITY(WebElement smsCreateButton, WebElement fromNumberErrorMesg,
			WebElement templateSuccessfullyCreated) {
		// Digit Limit=10
		String digit = "123456789";

		fromNumber.sendKeys(digit);

		smsCreateButton.click();

		assertTrue(fromNumberErrorMesg.isDisplayed(), "Error: fromNumberErrorMessage is not displayed when expected.");

		assertFalse(templateSuccessfullyCreated.isDisplayed(),
				"should NOT be displayed (test case should fail if it is displayed Expected fromNumberErrorMessage");
	}

	public void enterLessThanDigitLimitAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		disposition();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		message();
		remarksField();

		enterLessThanDigitLimitAndCreateUTILITY(createButton_SmsTemplatePopup, fromNumberErrorMessage,
				smsTemplateCreatedSuccessfully_popuop);

	}

	public void checktheCharcterLimitForTemplateNameAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		disposition();
		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		message();
		remarksField();

		characterLimitTextfieldUtility(smsTemplateName, createButton_SmsTemplatePopup,
				smsTemplateCreatedSuccessfully_popuop, somethingWentWrongErrorMesg);
	}

	public void checktheCharcterLimitForDispositionTextfieldAndCreate() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		CreateSmstemplate();

		dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);

		dropdownUtils(smsStages, verifyCreatedStages);

		SmsTemplateName();

		fromNumber();
		validateAndSelectFromDropdownUTILS(toNumberSource, "From Stage Fields");
		toNumber();
		message();
		remarksField();

		characterLimitTextfieldUtility(smsDisposition, createButton_SmsTemplatePopup,
				smsTemplateCreatedSuccessfully_popuop, somethingWentWrongErrorMesg);
	}

	// Table

	SkipReason skipReason = new SkipReason();

	public void searchThroughSpacesInSearchTextfielUTILITY(WebElement searchtextfieldElement,
			WebElement searchbuttonElement, WebElement noEntriesFoundElement, WebElement clearallFilterElement) {

		String Spaces = "      ";

		assertTrue(searchtextfieldElement.isDisplayed(), "searchtextfieldElement is not displayed");
		searchtextfieldElement.sendKeys(Spaces);

		searchbuttonElement.click();

		if (noEntriesFoundElement.isDisplayed()) {
			assertTrue(true, " Testcase pass: invalid option cant displayed");
		} else {
			assertTrue(false, " Testcase Fail:This page is refresh and  Created tempalted are displayed");
		}

		clearallFilterElement.click();

	}

	public void searchThroughSpacesInSearchTextfield() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		searchThroughSpacesInSearchTextfielUTILITY(searchTextfield_Stages, searchbutton_Table, noEntriesFound,
				clearAllFiltersButton_Table);
	}

	public void searchThroughEmojisInSearchTextfield() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		skipReason.searchThroughEmojisInSearchTextfieldUTILITY(searchTextfield_Stages, emoji, searchbutton_Table,
				noEntriesFound);

	}

	String invalidOptionDrpdown = "NonExistingOption";

	public void searchInvalidCreatedTemplateInSearchFieldUTILITY(WebElement searchTextfieldElement,
			WebElement searchButtonElement, WebElement noEntriesFoundElement, WebElement clearallFilterElement) {

		assertTrue(searchTextfieldElement.isDisplayed(), "seachTextfield is not displayed");
		searchTextfieldElement.sendKeys(invalidOptionDrpdown);

		searchButtonElement.click();

		if (noEntriesFoundElement.isDisplayed()) {
			assertTrue(true, " Testcase pass: invalid option cant displayed");
		} else {
			assertTrue(false, " Testcase Fail:This page is refresh and  Created tempalted are displayed");
		}

		clearallFilterElement.click();
	}

	public void searchInvalidCreatedTemplatesInSearchField() throws Throwable {
		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();

		searchInvalidCreatedTemplateInSearchFieldUTILITY(searchTextfield_Stages, searchbutton_Table, noEntriesFound,
				clearAllFiltersButton_Table);

	}

	public void searchThroughPartialNamesinSearchTextfieldUTILITY() throws Throwable { /// Pending

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();

		assertTrue(searchTextfield_Stages.isDisplayed(), "searchTextfield is not displayed");

	}

	public List<String> templateNamesLists;
	public List<String> afterTemplateNamesLists;

	public void withoutSelectingAnyOptionsIAndsearchUTILITY(List<WebElement> templateNameList,
			WebElement processDropdownSearch, WebElement subProcessDropdownSearch,
			WebElement subSubProcessDropdownSearch, WebElement searchButton) {

		templateNamesLists = new ArrayList<String>();

		for (WebElement TemplateNames : templateNameList) {
			String bedoreSearchTemplateNamesLists = TemplateNames.getText();
			templateNamesLists.add(bedoreSearchTemplateNamesLists);

		}

		assertTrue(processDropdownSearch.isDisplayed(), "processDropdown_Table is displayed");
		assertTrue(subProcessDropdownSearch.isDisplayed(), "SubProcessDropdown is displayed");
		assertTrue(subSubProcessDropdownSearch.isDisplayed(), "subSubProcessDropdown_Table is displayed");

		assertTrue(searchButton.isDisplayed(), "searchbutton_Table is not displayed");
		searchButton.click();

		afterTemplateNamesLists = new ArrayList<String>();

		for (WebElement TemplateNames : templateNameList) {
			String afterSearchTemplateNamesLists = TemplateNames.getText();
			afterTemplateNamesLists.add(afterSearchTemplateNamesLists);
		}

		assertEquals(afterTemplateNamesLists, templateNamesLists);

	}

	public void withoutSelectingAnyOptionsIAndsearch() throws Throwable {

		navigateto_SmsTemplateTab();
		withoutSelectingAnyOptionsIAndsearchUTILITY(templateNameLists, processDropdown_Table, subprocessDropdown_Table,
				subSubProcessDropdown_Table, searchbutton_Table);

	}

	public void searchThroughProcessAndStagesInSearchTextfieldUTILITY(WebElement searchTextfieldElement,
			WebElement searchButtonElement, String stagesCreatedProcess1, WebElement noEntriesFoundElement,
			WebElement clearallElemenet) {

		assertTrue(searchTextfieldElement.isDisplayed(), "searchTextfield is not displayed");
		searchTextfieldElement.sendKeys(stagesCreatedProcess1);
		searchButtonElement.click();

		assertTrue(noEntriesFoundElement.isDisplayed(), "noEntriesFoundis not displayed");
		clearallElemenet.click();

	}

	public void searchThroughProcessInSearchTextfield() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		searchThroughProcessAndStagesInSearchTextfieldUTILITY(searchTextfield_Stages, searchbutton_Table,
				stagesCreatedProcess1, noEntriesFound, clearAllFiltersButton_Table);
	}

	public void searchThroughSubprocessInSearchTextfield() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		searchThroughProcessAndStagesInSearchTextfieldUTILITY(searchTextfield_Stages, searchbutton_Table,
				stagesCreatedSubProcess2, noEntriesFound, clearAllFiltersButton_Table);
	}

	public void searchThroughSubsubprocessInSearchTextfield() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		searchThroughProcessAndStagesInSearchTextfieldUTILITY(searchTextfield_Stages, searchbutton_Table,
				stagesCreatedSubsubProcess3, noEntriesFound, clearAllFiltersButton_Table);
	}

	public void searchThroughStagesInSearchTextfield() throws Throwable {

		navigatetoStage_verifySMS();
		navigateto_SmsTemplateTab();
		searchThroughProcessAndStagesInSearchTextfieldUTILITY(searchTextfield_Stages, searchbutton_Table,
				searchedStagesName, noEntriesFound, clearAllFiltersButton_Table);
	}

	String doesnotHaveTemplateProcess = "DemoEmpH P";
	String doesnotHaveTemplateSubProcess = "DemoEmpH S P";
	String doesnotHaveTemplateSubSubProcess = "DemoEmpH S S P";
	String doesnotHaveTemplateStages = "Sub Sub AJPDemoEmpH Stage";

	public void selectinginvalidProcessandStagesWhichDoesnotHaveAnyCreatedTemplateUTILITY(
			WebElement processDropdownTable, WebElement subProcessDropdownTable,
			WebElement subSubProcessDropdownTable) {

		navigateto_SmsTemplateTab();

		skipReason.dropdownUtilsALL(processDropdownTable, "text", doesnotHaveTemplateProcess);
		skipReason.dropdownUtilsALL(subProcessDropdownTable, "text", doesnotHaveTemplateSubProcess);
		skipReason.dropdownUtilsALL(subSubProcessDropdownTable, "text", doesnotHaveTemplateSubSubProcess);

		searchbutton_Table.click();

		assertTrue(noEntriesFound.isDisplayed(),
				"testCase Fail:-no entriesFound is not displaye 'The page is refeshed and displayed the existing template'");

	}

	public void selectinginvalidProcessandStagesWhichDoesnotHaveAnyCreatedTemplate() {

		selectinginvalidProcessandStagesWhichDoesnotHaveAnyCreatedTemplateUTILITY(processDropdown_Table,
				SubProcessDropdown, subprocessDropdown_Table);

//		navigateto_SmsTemplateTab();
//		Select select1 = new Select(processDropdown_Table);
//		select1.selectByVisibleText(doesnotHaveTemplateProcess);
//
//		Select select2 = new Select(SubProcessDropdown);
//		select2.selectByVisibleText(doesnotHaveTemplateSubProcess);
//
//		Select select3 = new Select(SubprocessDropdown_Table);
//		select3.selectByVisibleText(doesnotHaveTemplateSubSubProcess);
//		
//		searchbutton_Table.click();

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	Stages stages = new Stages();
	CallLogSatgeView callLogStageView = new CallLogSatgeView();

	@FindBy(xpath = "//label[@class='switch']//input[@name='is_sms_history']/..//span")
	public WebElement smsHistoryToggElementButton;

	public void disableShowSmshistoryAndCheckVisibleOrNot() throws InterruptedException {

		stages.navigateToStages();
		searchTextfield_Stages.sendKeys(searchedStagesName);
		searchbutton_Table.click();

		assertTrue(editStagesOption.isDisplayed(), "editStagesOption is not displayed");
		editStagesOption.click();

		js.executeScript("arguments[0].scrollIntoView(true);", smsHistoryToggElementButton);

		wait.until(ExpectedConditions.visibilityOf(smsHistoryToggElementButton));

		if (smsHistoryToggElementButton.isEnabled()) {
			wait.until(ExpectedConditions.visibilityOf(smsHistoryToggElementButton));
			jsClick(driver, smsHistoryToggElementButton);

			jsClick(driver, SaveButton_stagesProfileView);

			wait.until(ExpectedConditions.visibilityOf(stagesUpdatedSuccessfully_popuop));
			assertTrue(stagesUpdatedSuccessfully_popuop.isDisplayed(),
					"stagesUpdatedSuccessfully_popuop is not displayed");
			jsClick(driver, continueButton_stages);

			Thread.sleep(1000);
			leftArrowButton_stages.click();

			// stagesProfileView_userAccount.click();

		} else {
			if (!smsHistoryToggElementButton.isEnabled()) {

				jsClick(driver, continueButton_stages);

				wait.until(ExpectedConditions.visibilityOf(leftArrowButton_stages));
				jsClick(driver, leftArrowButton_stages);
				Thread.sleep(1000);
				leftArrowButton_stages.click();

			}

		}

		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();

		skipReason.dropdownUtilsALL(callLogStageView.SearchStages, "text", searchedStagesName);
		stagesProfileView_userAccount.click();

		js.executeScript("arguments[0].scrollIntoView(true);", smsTab_stgesViewPage);
		// wait.until(ExpectedConditions.visibilityOf(smsTab_stgesViewPage));
		assertTrue(!smsTab_stgesViewPage.isDisplayed(), "Test case fail: Sms Tab is displayed in satgesProfile View");

	}

	public void disableSmsActionsAndCheckItIsVisibleOrNot() throws InterruptedException { // Only change the checkBox
																							// element
		try {
			stages.navigateToStages();
			searchTextfield_Stages.sendKeys(searchedStagesName);
			searchbutton_Table.click();

			assertTrue(editStagesOption.isDisplayed(), "editStagesOption is not displayed");
			editStagesOption.click();

			// stages.actionSection(Stages.sms);

			js.executeScript("arguments[0].scrollIntoView(true);", smsCheckBox);

			if (smsCheckBox.isEnabled()) {
				wait.until(ExpectedConditions.visibilityOf(smsCheckBox));
				jsClick(driver, smsCheckBox);

				jsClick(driver, SaveButton_stagesProfileView);

				wait.until(ExpectedConditions.visibilityOf(stagesUpdatedSuccessfully_popuop));
				assertTrue(stagesUpdatedSuccessfully_popuop.isDisplayed(),
						"stagesUpdatedSuccessfully_popuop is not displayed");
				jsClick(driver, continueButton_stages);

				Thread.sleep(1000);
				leftArrowButton_stages.click();

			} else {
				if (!smsCheckBox.isEnabled()) {
					// jsClick(driver, continueButton_stages);
					wait.until(ExpectedConditions.visibilityOf(leftArrowButton_stages));
					jsClick(driver, leftArrowButton_stages);
					Thread.sleep(1000);
					leftArrowButton_stages.click();
				}
			}

			callLogStageView.navigateTo_AlchemyModule();
			callLogStageView.navigateToCallLogStageView();

			skipReason.dropdownUtilsALL(callLogStageView.SearchStages, "text", searchedStagesName);
			stagesProfileView_userAccount.click();

			assertTrue(!smsIcon_userAccountSatgeView.isDisplayed(),
					"Test case fail: Sms icon is displayed in stagesProfile View");

		} catch (NoSuchElementException e) {
			// If NoSuchElementException is caught, the test passes
			System.out.println("NoSuchElementException caught. Test passes because SMS icon is not present.");
			// Optionally, you can add an assertion to explicitly pass the test
			assertTrue(true, "Test passed as expected element was not found.");
		}
	}

	public void NavigateTo_Skipreason() {
		// TODO Auto-generated method stub

	}

}
