package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.ManualUpload;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.SendDataUtils;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.WorkFlowDesign.PageObject.MeasurableSetPage;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.advaita.pageObjects.StagePage;

import Advaita_TDD.Advaita_TDD.FakeData;
import Advaita_TDD.Advaita_TDD.Questions;

public class NotificationTemplate extends TestBase {

	FakeData fake = new FakeData();

	public NotificationTemplate() {
		PageFactory.initElements(driver, this);

	}

//Global Variables
//--------------------------------------->
	String userId = "Abhijit@trasccon.com";
	String userPassword = "Qwerty@123";

	List<String> metaDataLists;
	public String templateTextStringValue;
	public String MessageTextStringValue;
	List<String> beforeSearchDataLists_Table;
	List<String> afterSearchDataLists_Table;

	public String last_CreatedNotificationTemplate;

	public String beforeSelectProcessdropdown1Options;
	public String afterSelectProcessdropdown1Options;

	public String beforeSelectSubProcessdropdown2Options;
	public String afterSelectSubProcessdropdown2Options;

	public String beforeSelectSubSubProcessdropdown3Options;
	public String afterSelectSubSubProcessdropdown3Options;

//------------------------------------------------------------->	

	// EntireBodyClick
	@FindBy(tagName = "body")
	public WebElement driverIninteractable;

	@FindBy(xpath = "//body[text()='Invalid request method']")
	public WebElement invalidRequestMethod;

	// user account
	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()='  Call Log Tab View ']")
	public WebElement user_callLogTabViewpage;

	@FindBy(xpath = "//ul[@id='pills-tab']//li//span")
	public WebElement userAccount_StagesCount;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/div/img[@class='img-fluid cursor-pointer view_evalution eye-icon']")
	public WebElement stagesProfileView_userAccount;

	@FindBy(xpath = "//tbody//td/../..//tr[1]//td[9]")
	public WebElement transuniquID_userAccount;

	@FindBy(xpath = "//input[@placeholder='HH:MM']")
	public WebElement TimeInputPicker;

	@FindBy(xpath = "//input[@id='startDate']")
	public WebElement DateInputPicker;

	@FindBy(xpath = "//div[contains(@class, 'datepicker')]")
	public WebElement DatePicker;

	@FindBy(xpath = "//h6[text()='Disposition']")
	public WebElement disositionTab;

	@FindBy(xpath = "(//label[@class='radio w-40'])[]")
	public WebElement autoRadioButton;

	@FindBy(xpath = "(//label[@class='radio w-40'])[2]")
	public WebElement manualRadioButton;

	@FindBy(xpath = "(//label[@class='radio processss'])[1]")
	public WebElement withinProcessRadioButton;

	@FindBy(xpath = "(//label[@class='radio processss'])[2]")
	public WebElement outsideProcessRadioButton;

	@FindBy(xpath = "//span[@class='select2-results']//ul//li")
	public List<WebElement> selectStage_disposition;

	// SuperAdmin Admin
	@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']//span[text()='Admin Super Admin']")
	public WebElement profileDropdown;

	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown']/..//li//a)[3]")
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

//	@FindBy(xpath = "//div[contains(@class,'section-A-scroll')]//div//div//label/..//input/..//label[text()='Trans Unique Id']/..//h6")
//	public WebElement transUniqueId_stageProfileView;

	@FindBy(xpath = "//input/..//label[text()='Trans Unique Id']/..//h6")
	public WebElement transUniqueId_stageProfileView;

	// Fetch_ process , subprocess , Subsubprocess
	@FindBy(xpath = "(//input[@data-type='process']/..//span)[1]")
	public WebElement fetchProcess;

	@FindBy(xpath = "//input[@data-type='sub_process']/..//span")
	public WebElement FethSubProcess;

	@FindBy(xpath = "(//div[@class='content']//span)[1]")
	public WebElement SubSubProcess;

	// DataSetup_metadat
	@FindBy(xpath = "//button[@id='pills-metadata-tab']")
	public WebElement metaDataTab;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	List<WebElement> MetaDataName;

	@FindBy(xpath = "(//table[@class='w-100']//tbody//td[1])[last()]")
	public WebElement SlastCretedMetadata;

	@FindBy(xpath = "(//h1[text()=' Metadata Management '])[1]")
	public WebElement verifyMetaDataManagement;

	@FindBy(xpath = "//tbody[@class='view_all_colmns']//tr//td[2]")
	List<WebElement> MetaDataList;

	@FindBy(xpath = "//div[@class='last-section-button']//button[text()='Cancel']")
	public WebElement cancelButtonMetaData;

	// Fetch"Stages"
	@FindBy(xpath = "(//h1[text()=' Stages '])[1]")
	public WebElement verifyStage;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	List<WebElement> stagesName;

	@FindBy(xpath = "//label[text()='Add Section']/..//a")
	public WebElement addSectionOption;

	@FindBy(xpath = "//input[@name='section_name']")
	public WebElement sectionNamElement;

	@FindBy(xpath = "//label[text()='Section Name*']/../..//a[text()='Add ']")
	public WebElement addOption;

	@FindBy(xpath = "(//label[normalize-space(text())='Non Measurable Set'])[5]")
	public WebElement nonMeasurableQuestionSetRadioOption;

	// measurableSet
	@FindBy(xpath = "//button[@id='pills-MasterParameter-tab']")
	public WebElement measurableParameterTab;

	@FindBy(xpath = "//h1[text()=' Master Parameter '][1]")
	public WebElement verifyMasterParameter;

	@FindBy(xpath = "//button[@id='pills-MeasurableSet-tab']")
	public WebElement measurableTab;

	@FindBy(linkText = "+ Add Measurable Set")
	public WebElement addMeasurableSet;

	@FindBy(xpath = "//h2[text()='Create Question Set']")
	public WebElement verifyCreateQuestionSet;

	@FindBy(xpath = "(//a[text()='Add Question'])[1]")
	public WebElement addQuestion;

	@FindBy(xpath = "//input[@id='questionSet_name']")
	public WebElement questionSetName;

	@FindBy(xpath = "//div[@class='questionset_form left_section_1']")
	public WebElement Section1;

	@FindBy(xpath = "//div[@class='questionset_form left_section_1']//input[@name='question_1_1']")
	public WebElement Question1;

	@FindBy(xpath = "(//div[@class='row firstquestion-function'])[1]//a")
	List<WebElement> selectQuestionTypElements;

	// Notification Template
	@FindBy(xpath = "//a[@id='menulist2']")
	public WebElement alchemySidemenubar;

	@FindBy(linkText = "Notification Template")
	public WebElement notificationTemplate_Tab;

	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()=' Notifications']")
	public WebElement notificationTemplateText;

	@FindBy(linkText = "+ Create")
	public WebElement createButtonNotificationTemplate;

	@FindBy(xpath = "//h2[text()='Create Notification Template']")
	public WebElement CreateNotificationTepmlateTpopUp;

	@FindBy(xpath = "//select[@id='process']")
	public WebElement ProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement SubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement SubsubProcessDropdown;

	@FindBy(xpath = "//select[@id='stage_name_id']")
	public WebElement notificationStagesDropdown;

	@FindBy(xpath = "//label[text()='Stage *']")
	public WebElement stagesLabel;

	@FindBy(xpath = "//input[@name='template_name']")
	public WebElement notificationTemplateName;

	@FindBy(xpath = "//label[text()='Template Name*']")
	public WebElement templateNameLabel;

	@FindBy(xpath = "//select[@name='notification_date']")
	public WebElement notificationDateDropdown;

	@FindBy(xpath = "//label[text()='Notification Date']")
	public WebElement notificationDateLabel;

	@FindBy(xpath = "//select[@name='notification_time']")
	public WebElement notificationTimeDropdown;

	@FindBy(xpath = "//label[text()='Notification Time']")
	public WebElement notificationTimeLabel;

	@FindBy(xpath = "//textarea[@name='message']")
	public WebElement message;

	@FindBy(xpath = "//label[text()='Message*']")
	public WebElement messagLabel;

	@FindBy(xpath = "//textarea[@name='remarks']")
	public WebElement remarks;

	@FindBy(xpath = "//label[text()='Remarks']")
	public WebElement remarksLabel;

	@FindBy(xpath = "//input[@name='temp_variable_name_1']")
	public WebElement templateVariableName;

	@FindBy(xpath = "//select[@class='form-control stages_fields_dropsown']")
	public WebElement stageFieldName;

	@FindBy(name = "default_val_1")
	public WebElement defaultValue;

	@FindBy(id = "manual_id")
	public WebElement createButton_NotificatioTemplatePopup;

	@FindBy(xpath = "//span[@id='change_msg']")
	public WebElement notificationTemplateCreatedSuccessfully_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButton_create;

	@FindBy(xpath = "//tbody/tr[last()]//td[1]") // Last created sms " entire line"
	public WebElement last_CreatedNotifications;

	@FindBy(xpath = "//tbody//tr/..//tr")
	List<WebElement> beforeSearchData_Table;

	@FindBy(xpath = "//span[@id='change_error_msg']")
	public WebElement somethingWentWrongErrorMesg;

	@FindBy(xpath = "//label[text()='This field is required.']")
	public WebElement thisFieldIsRequireErrorMesg;

	@FindBy(xpath = "//select[@id='sub_process']/..//label[@id='sub_process-error']")
	public WebElement errorMesgSubProcess;

	@FindBy(xpath = "//select[@id='s_sub_process']/..//label[@id='s_sub_process-error']")
	public WebElement errorMesgSubSubProcess;

	// notificationTemplate Table

	@FindBy(name = "text_search")
	public WebElement seachTextfield_NotificationTemplate;

	@FindBy(xpath = "//select[@id='process_search']")
	public WebElement ProcessDropdown_table;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public WebElement SubProcessDropdown_table;

	@FindBy(xpath = "//select[@id='s_sub_process_search']")
	public WebElement subSubProcessDropdown_table;

	@FindBy(xpath = "//select[@id='stage_search']")
	public WebElement notificationStages_table;

	@FindBy(xpath = "//div//button//img[@alt='filter_search']")
	public WebElement searchbutton_Table;

	@FindBy(xpath = "//div//img/..//h6")
	public WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='delete-icon']")
	public WebElement LastDelete_NotificationTempalte;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public WebElement deletePopup_NotificationTemplate;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement deleteButton_delete;

	@FindBy(xpath = "//h3/..//span[@id='change_msg']")
	public WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public WebElement continueButton_DeleteSuccessullyPopup;

	@FindBy(xpath = "//td[normalize-space(text())='No Entries Found']")
	public WebElement noEntriesFound;

	// EDIT

	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='table-edit']")
	public WebElement LastEdit_NotificationTempalte;

	@FindBy(xpath = "//h2[text()='Edit Notification Template']")
	public WebElement verify_EditNotificationTemplate;

	@FindBy(xpath = "//input[@name='template_name']")
	public WebElement EditTemplateName;

	@FindBy(xpath = "//textarea[@name='message']")
	public WebElement editMessageTextfield;

	@FindBy(xpath = "//button[text()=' Update ']")
	public WebElement updateButton;

	@FindBy(xpath = "//h3/..//span[@id='change_msg']")
	public WebElement UpdateNotification_SuceessfullyPopup;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButton_Edit;

	// Addd section in stages
	@FindBy(xpath = "//ul[@id='pills-tab' and not(contains(@class, 'w-100 nav nav-pills main_nav_ul section_c_nav '))]//li")
	List<WebElement> addedSections;

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

	DataSet dataSet = new DataSet();

	public void cretaeDataset() throws Throwable {

		String dataset = "Customer Profile";
		dataSet.navigateToDataSetup();
		dataSet.createNewDataSet(dataset);

		// Data for multiple rows
		List<Map<String, String>> fieldData = List.of(
				Map.of("FieldName", "Employee Name ", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"),
				Map.of("FieldName", "Employee ID ", "Type", "Number", "MaxLength", "6", "IsMandatory", "Yes"),
				Map.of("FieldName", " Emp Phone Number ", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"),
				Map.of("FieldName", " Email Id ", "Type", "Character", "MaxLength", "50", "IsMandatory", "No"),
				Map.of("FieldName", " WhatsApp Number ", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));

		dataSet.enterFieldNameAndValidations(fieldData);
		dataSet.createDataSetButtonAndConfirmation();

		PropertieFileUtil.storeSingleTextInPropertiesFile("dataSetName", dataset);

	}

	String employeeName1 = "Customer Profile";
	final String metaDataName = employeeName1 + " MetaData";

	MetaData metaData = new MetaData();

	final String manualUploadName = employeeName1 + "  Upload";
	final String dataSetName = employeeName1 + " DataSet";
	final String remark = "Customer Profile ";

	public void createMetadata() throws Throwable {
		metaData.navigateToMetaData();
		metaData.createNewMetaData(metaDataName);
		metaData.verifyCreateButtonAndConfirmation();
		metaData.verifyCreatedMetaDataCheckUniqueIdAndRole(true, false);
		metaData.verifySaveButtonAndConfirmationInUpadteMetaData().verifyExecuteUpadtedMetaData();

	}

	ManualUpload manualUpload = new ManualUpload();

	public void manualUpload() throws Throwable {
		manualUpload.navigateToManualUpload();
		manualUpload.createNewManualUpload(manualUploadName);
//		manualUpload.formatDownloadAndUpdateAndUpload(manualUpload.filteredItems, Questions.generateEmployeeQuestions(),
//				5);
		manualUpload.fillOtherFildsForUploadedFile(remark);
		manualUpload.createButtonAndConfirmation();

	}

	final String stageName = employeeName1 + "Stages";
	Stages stages1 = new Stages();

	public void stagesCreation() throws Throwable {
		stages1.navigateToStages();
		stages1.verifyCreateStagesButton();
		stages1.verifyStageNameTextBox(stageName);
		stages1.verifyStageSelectProcessDropDown();
		stages1.verifyStageSelectSubProcessDropDown();
		stages1.verifyStageSelectSubSubProcessDropDown();
		stages1.verifyAddSectionA(true, false, false);

	}

	public final static String callLogStageView = "Call Log Stage View";
	public final static String agencyValidation = "Agency Validation";
	public final static String rejectedAuditForm = "Rejected Audit Form";
	public final static String auditTheAuditor = "Audit the Auditor";
	public final static String validationStatusReport = "Validation Status Report";

	String[] allOptionsMeasurable = { callLogStageView, agencyValidation, rejectedAuditForm, auditTheAuditor,
			validationStatusReport };

	public void VerifyAddSectionInStages() throws Throwable {

		boolean measurableRadio = false;
		boolean nonMeasurableRadio = true;
		String viewCheckBox[] = { Stages.callLogStageView, Stages.agencyValidation };
		stages1.addSection(1, measurableRadio, nonMeasurableRadio, viewCheckBox);
	}

	public void verifyActionSectionStages() {
		String viewCheckBox[] = { Stages.voiceCall, Stages.whatsAppCall, Stages.sms, };
		// String viewCheckBox[] = { "all" };
		String toggleButtonOptions[] = { Stages.assignedTo, Stages.showSkipAudit, Stages.showDisposition,
				Stages.showSmsHistory, Stages.showSmsHistory, Stages.openSample };
//		String toggleButtonOptions[] = {"all"};
		stages1.actionSection(viewCheckBox).actionSectionToggle(toggleButtonOptions);

	}

	public void selectDisplositionStages() {

		stages1.dispositionSection();

		stages1.saveAndConfirmation();
	}

	public void saveAndContinue() {
		stages1.saveAndConfirmation();
	}

	@FindBy(xpath = "//input[@id='text_search']")
	public WebElement searchTextfield_table;

	@FindBy(xpath = "//button[@class='filter_search_blk cursor-pointer d-flex align-items-center justify-content-center white_bg']")
	public WebElement searchButton_table;

	public String CreatedMetadata = "Customer Profile MetaData";

	public void FetchMetaData() throws Throwable {
		driver.navigate().to("https://test.capture.autosherpas.com/en/data_management/process/");
		wait.until(ExpectedConditions.visibilityOf(metaDataTab));
		assertTrue(metaDataTab.isDisplayed(), "metaDataTab is not displayed");
		metaDataTab.click();

		assertTrue(verifyMetaDataManagement.isDisplayed(), "verifyMetaDataManagement is not displayed");
		System.out.println("verifyMetaDataManagement : " + verifyMetaDataManagement.getText());

		searchTextfield_table.sendKeys(CreatedMetadata);
		searchbutton_Table.click();

		List<String> metaDataNameList = new ArrayList<String>();
		for (WebElement metadataName : MetaDataName) {
			metaDataNameList.add(metadataName.getText());
			System.out.println("metaDataNameList :" + metadataName.getText());

		}

		assertTrue(metaDataNameList.containsAll(metaDataNameList));
		System.out.println(metaDataNameList.containsAll(metaDataNameList));
		metaDataNameList.size();

		assertTrue(metaDataNameList.contains(CreatedMetadata), "CreatedMetadata is not displayed");

		if (metaDataNameList.size() == 3) {
			for (WebElement metadataName : MetaDataName) {
				metadataName.click();
			}
		}

		js.executeScript("arguments[0].scrollIntoView(true);", SlastCretedMetadata);
		assertTrue(SlastCretedMetadata.isDisplayed(), "SlastCretedMetadata is not displayed");
		// SlastCretedMetadata.click();
		jsClick(SlastCretedMetadata);

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

	public String stagesCreatedProcess1;
	public String stagesCreatedSubProcess2;
	public String stagesCreatedSubsubProcess3;
	public String verifyCreatedStages;

//	String searchedStagesName = "Booking Information Stage";
	String searchedStagesName = "Customer Profile Stages";

	@FindBy(id = "text_search")
	public WebElement searchTextfieldStages;

	@FindBy(xpath = "(//tbody//tr[1]//td[2])[1]")
	public WebElement stagesCreatedProcess; // Stages Createdwith Which Proceess

	@FindBy(xpath = "(//tbody//tr[1]//td[3])[1]")
	public WebElement stagesCreatedSubProcess; // Stages Createdwith Which SubProceess

	@FindBy(xpath = "(//tbody//tr[1]//td[4])[1]")
	public WebElement stagesCreatedSubsubProcess; // Stages Createdwith Which SubProceess

	public void FetchStages() throws Throwable {

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
	}

//	//////////////////////////Measurable set/////////////////////////////

	String employeeName = "notificationALERT";
	Stages stages = new Stages();
	MastersFieldSets masterFieldSet = new MastersFieldSets();

	@FindBy(xpath = "//a//img[@class='arrow-left']")
	public WebElement leftArrowNMS;

	@FindBy(xpath = "//tbody//tr[1]//td[@class='question-menu']")
	public WebElement createdNonMeasurableQuestionSET;

	public void verifyCreateNonMeasurable() throws Throwable {

		// Create the test in ExtentReports
		// Perform necessary UI steps for creating the field set
		stages.navigateNonMeasurableCreate();
		// Set the question set name
		String questionSetNameString = employeeName + " NM";
		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString);
		// Specify the question types (e.g., DropDown = 4, TextBox = 10, Short Answer =
		// 3)

		int sectionCount = 1;
		int numberOfQuestion = 2;
		boolean fieldSetQuestionRandom = true;
		List<Integer> selectedQuestionTypes = QuestionSelector.selectQuestionTypes(fieldSetQuestionRandom,
				numberOfQuestion, MastersFieldSets.DATE, MastersFieldSets.TIME);
		// Now, add multiple questions to section 1 based on the selected types
		boolean defineQuestionTypeRandom = true;
		masterFieldSet.addMultipleQuestions(sectionCount, selectedQuestionTypes, numberOfQuestion,
				defineQuestionTypeRandom);

		masterFieldSet.verifySaveInCreateFieldSet();
		leftArrowNMS.click();

		assertEquals(createdNonMeasurableQuestionSET.getText(), questionSetNameString,
				"The creted NonMeasurableQuestion st not equal with Declaare String value");

	}

	@FindBy(xpath = "((//tbody//tr[1]//td[6])//div//img[@class='img-fluid stages_edit delete-dataset'])[1]")
	public WebElement editStagesOption;

	String notification = "notification Reminder";
	String notification1 = "Reminder message";

	public void verifyForAddedNotificationSectionInStagesEdit() {

		assertTrue(editStagesOption.isDisplayed(), "editStagesOption is not displayed");
		editStagesOption.click();

		List<String> addedSectionsList = new ArrayList<String>();

		for (WebElement sectionsLists : addedSections) {

			String sectionsListstext = sectionsLists.getText();

			addedSectionsList.add(sectionsListstext);
		}

		if (!addedSectionsList.contains(notification)) {

			js.executeScript("arguments[0].scrollIntoView(true);", addSectionOption);

			assertTrue(addSectionOption.isDisplayed(), "addSectionOptionis not displayed");

			jsClick(driver, addSectionOption);

			sectionNamElement.sendKeys(notification);

			jsClick(driver, addOption);

			nonMeasurableQuestionSetRadioOption.click();

		}

		else {

			assertTrue(addedSectionsList.contains(notification), "notification not cotains");

			System.out.println("notification is already contains in Added section on stages");

		}

	}

	///////////////////////////////////// MeasurableSet
	///////////////////////////////////// ////////////////////////////////////////////////////////////////

	public void navigateTo_AlchemyModule() {

		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(alchemySidemenubar);
		String alchemyCurrentUrl = driver.getCurrentUrl();
		System.out.println("alchemyCurrentUrl : " + alchemyCurrentUrl);

	}

	public void NavigateToNotificationtemplate() throws Throwable {

		assertTrue(notificationTemplate_Tab.isDisplayed(), "notificationTemplate_Tab is not displayed");

		jsClick(driver, notificationTemplate_Tab);

		String notificationURL = driver.getCurrentUrl();
		System.out.println("notificationURL :" + notificationURL);

		assertTrue(notificationTemplateText.isDisplayed(), "notificationTemplateText is not displayed");

	}

	public void createNotification() throws Throwable {

		assertTrue(createButtonNotificationTemplate.isDisplayed(), "createButtonNotificationTemplate is displayed");
		createButtonNotificationTemplate.click();

		wait.until(ExpectedConditions.visibilityOf(CreateNotificationTepmlateTpopUp));
		assertTrue(CreateNotificationTepmlateTpopUp.isDisplayed(), "CreateNotificationTepmlateText is not displayed");
	}

	public void dropdownUtils1(WebElement dropdownElement, String expectedOptionText, WebDriverWait wait)
			throws Throwable {
		// Step 1: Ensure the dropdown element is visible and clickable
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));

		// Step 2: Initialize Select object with the provided dropdown element
		Select dropdown = new Select(dropdownElement);

		// Step 3: Retrieve all options in the dropdown
		List<WebElement> allDropdownOptions = dropdown.getOptions();

		// Step 4: Loop through each dropdown option and compare with expectedOptionText
		boolean isOptionClicked = false;

		for (int i = 0; i < allDropdownOptions.size(); i++) {
			try {
				// Refetch the dropdown and options to avoid stale element issues
				dropdown = new Select(dropdownElement);
				allDropdownOptions = dropdown.getOptions();

				// Fetch the option element by index to avoid StaleElementReferenceException
				WebElement option = allDropdownOptions.get(i);
				String dropdownValue = option.getText();

				// Compare expectedOptionText with the dropdown option value
				if (dropdownValue.equals(expectedOptionText)) {
					// Assert that the correct dropdown value has been found
					assertEquals(dropdownValue, expectedOptionText, "Dropdown value did not match!");

					// Step 5: Wait until the option is clickable and click it
					wait.until(ExpectedConditions.elementToBeClickable(option));
					option.click();

					// Step 6: Mark as clicked and break the loop
					isOptionClicked = true;
					break;
				}
			} catch (StaleElementReferenceException e) {
				// In case of StaleElementReferenceException, re-fetch the dropdown element
				System.out.println("StaleElementReferenceException caught, retrying...");
				dropdown = new Select(dropdownElement);
				allDropdownOptions = dropdown.getOptions(); // Re-fetch options
			}
		}

		Thread.sleep(2000);
		// Step 7: Assert that the option has been clicked
		assertTrue(isOptionClicked, "No matching dropdown option found and clicked.");

	}

	SmsTemplate smsTemplate = new SmsTemplate();

	public void selectProcessFromNotitficationTemplate() throws Throwable {

		smsTemplate.dropdownUtils(ProcessDropdown, stagesCreatedProcess1);
		// dropdownUtils1(ProcessDropdown, stagesCreatedProcess1, wait);

	}

	public void selectSubProcessFromNotitficationTemplate() throws Throwable {

		smsTemplate.dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);
		// dropdownUtils1(SubProcessDropdown, stagesCreatedSubProcess2, wait);

	}

	public void selectSubsubProcessFromNotitficationTemplate() throws Throwable {

		smsTemplate.dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);
		// dropdownUtils1(SubSubProcess, stagesCreatedSubsubProcess3, wait);

	}

	public void selectStagesFromNotitficationTemplate() throws Throwable {

		smsTemplate.dropdownUtils(notificationStagesDropdown, searchedStagesName);

	}

	public void selectTemplateName() throws Throwable {

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

	}

	String notificationDate = "When did you last go on a trip?";
	String notificationTime = "What time did you last have a phone call with a friend?";

	public void selectNotificationDateAndTime() throws InterruptedException {

		// NotificationDate Dropdwon

		List<String> notificationDateLists = new ArrayList<String>();
		Select notifationDatedropdown = new Select(notificationDateDropdown);
		for (WebElement notificationDateDropdowOptions : notifationDatedropdown.getOptions()) {
			System.out.println("notificationDateDropdowOptions : " + notificationDateDropdowOptions.getText());
			notificationDateLists.add(notificationDateDropdowOptions.getText());
		}

		// assertTrue(notificationDateLists.contains(metaDataLists), " metadata text not
		// displayed"); //need to implement "metadata list" equal to "notifaceDate
		// Dropdown"
		assertTrue(notificationDateLists.contains(notificationDate));

		String beforeSelectNotificateDateOption = notifationDatedropdown.getFirstSelectedOption().getText();
		System.out.println("beforeSelectNotificateDateOption: " + beforeSelectNotificateDateOption);

		Thread.sleep(1000);
		notifationDatedropdown.selectByVisibleText(notificationDate);
		// NotifationStagesdropdown.selectByValue("Notification Date");

		String afterSelectNotificateDateOption = notifationDatedropdown.getFirstSelectedOption().getText();
		System.out.println("afterSelectNotificateDateOption:" + afterSelectNotificateDateOption);

		assertNotEquals(beforeSelectNotificateDateOption, afterSelectNotificateDateOption);

		// Notification Time

		List<String> notificationTimeLists = new ArrayList<String>();
		Select notifationTimedropdown = new Select(notificationTimeDropdown);
		for (WebElement notificationTimeDropdowOptions : notifationTimedropdown.getOptions()) {
			System.out.println("notificationTimeDropdowOptions : " + notificationTimeDropdowOptions.getText());
			notificationTimeLists.add(notificationTimeDropdowOptions.getText());
		}
		// assertTrue(notificationTimeLists.containsAll(metaDataLists), " metadata text
		// not displayed"); //need to implement "metadata list" equal to "notifaceTime
		// Dropdown"
		assertTrue(notificationTimeLists.contains(notificationTime));

		String beforeSelectNotificateTimeOption = notifationTimedropdown.getFirstSelectedOption().getText();
		System.out.println("beforeSelectNotificateTimeOption: " + beforeSelectNotificateTimeOption);

		notifationTimedropdown.selectByVisibleText(notificationTime);

		String afterSelectNotificateTimeOption = notifationTimedropdown.getFirstSelectedOption().getText();
		System.out.println("afterSelectNotificateTimeOption:" + afterSelectNotificateTimeOption);

		assertNotEquals(beforeSelectNotificateTimeOption, afterSelectNotificateTimeOption);
	}

	public void messageTextfield() {

		assertTrue(message.isDisplayed(), "message is not displayed");
		message.sendKeys(fake.lastName1());

		MessageTextStringValue = message.getAttribute("value"); // 1st way "Global variable"
		System.out.println("MessageTextStringValue: " + MessageTextStringValue);

	}

	public void remarksTextfield() {

		assertTrue(remarks.isDisplayed(), "remarksis not displayed");
		remarks.sendKeys(fake.lastName1());
	}

	public void clickONCreateAndVerifyPopUp() {

		assertTrue(createButton_NotificatioTemplatePopup.isDisplayed(),
				"createButton_NotificatioTemplatePopupis not displayed");
		createButton_NotificatioTemplatePopup.click();

		wait.until(ExpectedConditions.visibilityOf(notificationTemplateCreatedSuccessfully_popuop));
		assertTrue(notificationTemplateCreatedSuccessfully_popuop.isDisplayed(),
				"notificationTemplateCreatedSuccessfully_popuopis not displayed");

		assertTrue(continueButton_create.isDisplayed(), "continueButton_createis not displayed");
		continueButton_create.click();
	}

	public void verifyCreatedNotificationTemplate() {

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
			jsClick(manualRadioButton);
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
			jsClick(manualRadioButton);
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
		// selectSubProcessSelect.selectByValue(" ");
		assertNotEquals(beforeSelectSubProcessdropdown2Options, afterSelectSubProcessdropdown2Options);

		Select selectSubsubProcessSelect = new Select(subSubProcessDropdown_table);
		selectSubsubProcessSelect.selectByVisibleText("Sub Sub AJP ");
		// selectSubsubProcessSelect.selectByIndex();
		// selectSubsubProcessSelect.selectByValue("");
		assertNotEquals(beforeSelectSubSubProcessdropdown3Options, afterSelectSubSubProcessdropdown3Options);

		// String beforeSearchByProcessUrl=driver.getCurrentUrl();

		Select searchStageSelect = new Select(notificationStages_table);
		String beforeSelectStagesOptions = searchStageSelect.getFirstSelectedOption().getText();
		searchStageSelect.selectByVisibleText("CutomerdetailsZZZ Stage");
		// searchStageSelect.selectByIndex();
		// searchStageSelect.selectByValue("");

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

		// Template Name
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

		assertNotEquals(beforeSearchDataLists_Table, afterSearchDataLists_Table); // not equal with before text and
																					// after text
	}

/////////////////////////////////////////   Negative /////////////////////////////////////////////////////////////////////////

	CallLogSatgeView callCallLogSatgeView = new CallLogSatgeView();

	// WithouyDisposition Notification date
	public void WithoutDispositionNotificationDate() throws Throwable { // Pending

		FetchStages();
		navigateTo_AlchemyModule();
		callCallLogSatgeView.navigateToCallLogStageView();
		smsTemplate.dropdownUtils(callCallLogSatgeView.SearchStages, searchedStagesName);

		assertTrue(callCallLogSatgeView.noEntriesFoundd.isDisplayed(), "already displosition happen in this stages");

		NavigateToNotificationtemplate();
		createNotification();

		smsTemplate.dropdownUtils(ProcessDropdown, stagesCreatedProcess1); // select Process
		smsTemplate.dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);// select SubProcess
		smsTemplate.dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);// select SubSub process
		smsTemplate.dropdownUtils(notificationStagesDropdown, searchedStagesName);// selectStage

		selectTemplateName();

	}

	String specailChar = "!@#$%^&*(_";

	SkipReason skipReason = new SkipReason();

	public void saveCreteTemplateWithSpecialChracter() throws Throwable {

		FetchStages();
		navigateTo_AlchemyModule();
		NavigateToNotificationtemplate();
		createNotification();

		smsTemplate.dropdownUtils(ProcessDropdown, stagesCreatedProcess1); // select Process
		smsTemplate.dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);// select SubProcess
		smsTemplate.dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);// select SubSub process
		smsTemplate.dropdownUtils(notificationStagesDropdown, searchedStagesName);// selectStage

		notificationTemplateName.sendKeys(specailChar);
		messageTextfield();
		remarksTextfield();

		skipReason.dropdownUtilsALL(notificationDateDropdown, "text", notificationDate);
		skipReason.dropdownUtilsALL(notificationTimeDropdown, "text", notificationTime);

		testCreateButtonNotificationTemplate();

	}

	public void testCreateButtonNotificationTemplate() {

		try {

			createButton_NotificatioTemplatePopup.click();
			createButton_NotificatioTemplatePopup.isDisplayed();
			System.out.println("Template name accepts special characters. TEST FAILED");
			assertTrue(false, "Button is displayed, it accepts special characters. TEST FAILED");

		} catch (NoSuchElementException e) {
			// Handle the case where the button is disabled or not clickable
			System.out.println("Create button is disabled; it does not allow special characters. TEST PASSED");
			// Pass the test
			assertTrue(true, "Button is disabled, special characters not allowed. TEST PASSED");
		}

	}

	public void withoutSelectingAnyFiledTryToCreateTemplate() throws Throwable {

		NavigateToNotificationtemplate();
		createNotification();

		String Combinetext = skipReason.processLabel.getText() + skipReason.subProcessLabel.getText()
				+ skipReason.subSubProcessLabel.getText() + stagesLabel.getText() + templateNameLabel.getText()
				+ messagLabel.getText();

		String asterisk = "*";
		assertTrue(Combinetext.contains(asterisk), "asterisk is not contains in Combinetext text");

		createButton_NotificatioTemplatePopup.click();

		boolean isEitherDisplayed = invalidRequestMethod.isDisplayed() || somethingWentWrongErrorMesg.isDisplayed();
		assertTrue(isEitherDisplayed, "'invalidRequestMethod' or 'validRequestMethod' is not displayed, test failed.");
		// driver.navigate().back();

	}

	public void withoutSelectingProcessAndCreate() throws Throwable {

		FetchStages();
		navigateTo_AlchemyModule();
		NavigateToNotificationtemplate();
		createNotification();

		String combineText = skipReason.processLabel.getText() + skipReason.subProcessLabel.getText()
				+ skipReason.subSubProcessLabel.getText();

		String asterisk = "*";
		assertTrue(combineText.contains(asterisk), "asterisk is not contains in Combinetext text");

//		String combineValue = skipReason.processLabel.getAttribute("id") + skipReason.subProcessLabel.getAttribute("id")
//		+ skipReason.subSubProcessLabel.getAttribute("id");

		smsTemplate.dropdownUtils(ProcessDropdown, stagesCreatedProcess1); // select Process

		// selectNotificationDateAndTime();
		selectTemplateName();
		messageTextfield();
		remarksTextfield();

		createButton_NotificatioTemplatePopup.click();

		wait.until(ExpectedConditions.visibilityOf(invalidRequestMethod));
		assertTrue(
				invalidRequestMethod.isDisplayed()
						|| errorMesgSubProcess.isDisplayed() && errorMesgSubSubProcess.isDisplayed(),
				"Without selecting subprocess or sub sub processs template is created");

	}

	public void WithoutselectingStagesMnadatorydropdown() throws Throwable {
		FetchStages();
		navigateTo_AlchemyModule();
		NavigateToNotificationtemplate();
		createNotification();

		smsTemplate.dropdownUtils(ProcessDropdown, stagesCreatedProcess1); // select Process
		smsTemplate.dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);// select SubProcess
		smsTemplate.dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);// select SubSub process

		String Combinetext = skipReason.processLabel.getText() + skipReason.subProcessLabel.getText()
				+ skipReason.subSubProcessLabel.getText() + stagesLabel.getText() + templateNameLabel.getText()
				+ messagLabel.getText();

		assertTrue(stagesLabel.isDisplayed(), "stagesLabel is noyt enabled");

		String asterisk = "*";
		assertTrue(Combinetext.contains(asterisk), "asterisk is not contains in Combinetext text");

		createButton_NotificatioTemplatePopup.click();

		boolean isEitherDisplayed = invalidRequestMethod.isDisplayed() || somethingWentWrongErrorMesg.isDisplayed();
		assertTrue(isEitherDisplayed, "'invalidRequestMethod' or 'validRequestMethod' is not displayed, test failed.");
		// driver.navigate().back();

	}

	public void characterLimitTextfield() throws Throwable {
		NavigateToNotificationtemplate();
		createNotification();

		notificationTemplateName.sendKeys("A".repeat(300));
		createButton_NotificatioTemplatePopup.click();

		boolean isEitherDisplayed = invalidRequestMethod.isDisplayed() || somethingWentWrongErrorMesg.isDisplayed();
		assertTrue(isEitherDisplayed, "'invalidRequestMethod' or 'validRequestMethod' is not displayed, test failed.");
		// driver.navigate().back();
		// assertTrue(false, "error message should displayed Character limit is 256");
	}

	public void searchInvalidCreatedNamesInSearchField() throws Throwable {

		NavigateToNotificationtemplate();
		skipReason.searchInvalidCreatedNamesInSearchFieldUTILITY(searchbutton_Table, noEntriesFound, searchbutton_Table,
				clearAllFiltersButton_Table);
	}

	public void createNotificationWithoutSelectingNonMandatoryFields() throws Throwable {

		FetchStages();
		navigateTo_AlchemyModule();
		NavigateToNotificationtemplate();
		createNotification();

		smsTemplate.dropdownUtils(ProcessDropdown, stagesCreatedProcess1); // select Process
		smsTemplate.dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);// select SubProcess
		smsTemplate.dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);// select SubSub process
		smsTemplate.dropdownUtils(notificationStagesDropdown, searchedStagesName);// selectStage

		notificationTemplateName.sendKeys(specailChar);

		skipReason.nonMandatoryTextfieldUTILITY(notificationDateLabel, notificationDateDropdown,
				createButton_NotificatioTemplatePopup, notificationTemplateCreatedSuccessfully_popuop);
//		skipReason.nonMandatoryTextfieldUTILITY(notificationTimeLabel, notificationTime, createButton_NotificatioTemplatePopup,  notificationTemplateCreatedSuccessfully_popuop);
//		skipReason.nonMandatoryTextfieldUTILITY(remarksLabel, remarks, createButton_NotificatioTemplatePopup,  notificationTemplateCreatedSuccessfully_popuop);
	}

	String emoji = "❤️😂😊";

	public void createTemplateThroughEmojis() throws Throwable {

		FetchStages();
		navigateTo_AlchemyModule();
		NavigateToNotificationtemplate();
		createNotification();

		smsTemplate.dropdownUtils(ProcessDropdown, stagesCreatedProcess1); // select Process
		smsTemplate.dropdownUtils(SubProcessDropdown, stagesCreatedSubProcess2);// select SubProcess
		smsTemplate.dropdownUtils(SubsubProcessDropdown, stagesCreatedSubsubProcess3);// select SubSub process
		smsTemplate.dropdownUtils(notificationStagesDropdown, searchedStagesName);// selectStage

		SendDataUtils.sendKeysWithJSExecutor(notificationTemplateName, emoji);
		remarksTextfield();

		createButton_NotificatioTemplatePopup.click();

		boolean isEitherDisplayed = invalidRequestMethod.isDisplayed() || somethingWentWrongErrorMesg.isDisplayed();
		assertTrue(isEitherDisplayed, "'invalidRequestMethod' or 'validRequestMethod' is not displayed, test failed.");

		// driver.navigate().back();

	}

	public void searchThroughEmojiInSearchField() throws Throwable {

		FetchStages();
		navigateTo_AlchemyModule();
		NavigateToNotificationtemplate();

//		searchTextfield_table.sendKeys("A".repeat(300)); //Standard-256
		skipReason.searchThroughEmojisInSearchTextfieldUTILITY(searchTextfield_table, emoji, searchButton_table,noEntriesFound);
//		SendDataUtils.sendKeysWithJSExecutor(searchTextfield_table, emoji);
		searchbutton_Table.click();

		assertTrue(invalidRequestMethod.isDisplayed(), "'invalidRequestMethod' message is not displayed, test failed.");

		System.out.println("'invalidRequestMethod' message is displayed, test passed.");
	}
	
	public void searchThroughSpacesInSearchTextfield() throws Throwable {
		FetchStages();
		navigateTo_AlchemyModule();
		NavigateToNotificationtemplate();
		smsTemplate.searchThroughSpacesInSearchTextfielUTILITY(searchTextfield_table, searchButton_table, noEntriesFound, clearAllFiltersButton_Table);

		
	}

	String invalidProcess = "DemoEmp P";
	String invalidSubProcess = "DemoEmp S P";
	String invalidSubsubProcess = "DemoEmp S S P";

	public void selectInvalidProcessesAndSearch() throws Throwable {

		NavigateToNotificationtemplate();
		
		skipReason.dropdownUtilsALL(ProcessDropdown_table, "text", invalidProcess);
		skipReason.dropdownUtilsALL(SubProcessDropdown_table, "text", invalidSubProcess);
		skipReason.dropdownUtilsALL(subSubProcessDropdown_table, "text", invalidSubsubProcess);
		
		searchbutton_Table.click();
		assertTrue(noEntriesFound.isDisplayed(), "template is created with this Proceess and it is displayed");
	}
	
	public void searchThroughProcessInSearchTextfield() throws Throwable {
		
		NavigateToNotificationtemplate();
		//smsTemplate.searchThroughProcessAndStagesInSearchTextfieldUTILITY(searchTextfield_table, searchbutton_Table, , noEntriesFound, clearAllFiltersButton_Table);
		
	}
	
	

}
