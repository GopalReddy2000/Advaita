package com.advaita.TestCreate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.ManualUpload;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.ScreenRecorderUtil;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.advaita.pageObjects.ManualAllocationPage;
import com.advaita.pageObjects.SamplingPlanAndGenerationPage;
import com.advaita.pageObjects.UserSetupPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.Questions;

public class TestManualAllocation extends TestBase {

	static String employeeName = "DemoI";

	// Run Test Based on Boolean
	final boolean processRun = false;
	final boolean dataSetRun = false;
	final boolean metaDataRun = false;
	final boolean manualUploadRun = false;
	final boolean nonMeasurableRun = false;
	final boolean stageRun = false;
	final boolean userRun = false;
	final boolean samplingPlanRun = false;
	final boolean manualAllocationRun = true;

	Faker faker = new Faker();
//	public String num = "24";
//	public String dataSetName = "Test Single Data Set" + num;

//	public final String dataSetName = faker.name().lastName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;
	ProcessPage process;
	MetaData metaData;
	DataSet dataset;
	ManualUpload manualUpload;
	MastersFieldSets masterFieldSet;
	Stages stages;
	UserSetupPage userSetUp;
	SamplingPlanAndGenerationPage SPAG;
	ManualAllocationPage manualAllocationPage;

	public TestManualAllocation() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();

//		ScreenRecorderUtil.startRecord("ManualUploadRecording");

		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ManualAllocationCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for ManualAllocation");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		process = new ProcessPage();
		metaData = new MetaData();
		dataset = new DataSet();
		manualUpload = new ManualUpload();
		masterFieldSet = new MastersFieldSets();
		stages = new Stages();
		userSetUp = new UserSetupPage();
		SPAG = new SamplingPlanAndGenerationPage();
		manualAllocationPage = new ManualAllocationPage();

	}

	final String metaDataName = employeeName + " Details MetaData";
	final String manualUploadName = employeeName + " Details Upload";
	final String dataSetName = employeeName + " Details";
	final String remark = "Test Manual Upload";

	@Test(priority = 1, enabled = processRun)
	public void verifyProcessCreate() throws Throwable {
		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType");
		homePage.clickOnProcessManagementCreate();

//		String testName = "TestAB";
//
//		process.createProcess1(testName + " P", "TestPDesc");
//
//		process.createSubProcess(testName + " Sub P", "TestSPDesc");
//
//		process.createSubSubProcess(testName + " Sub Sub P", "TestSSPDesc");

		process.createProcess1(employeeName + " P", "TestPDesc");

		process.createSubProcess(employeeName + " S P", "TestSPDesc");

		process.createSubSubProcess(employeeName + " S S P", "TestSSPDesc");

		Thread.sleep(2000);

	}

	@Test(priority = 2, enabled = dataSetRun)
	public void verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType() throws Throwable {
		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType");
		homePage.clickOnProcessManagementCreate();

		// Get all questions
		List<Map<String, String>> allQuestions = Questions.generateEmployeeQuestions();
		// Define the types and order of questions you want to select
		// Character,Text Area,Date Time,Date,Number,Boolean,HyperLink
		List<String> types = Arrays.asList("Text Area", "Character", "HyperLink");

		// Select questions based on types and order
		List<Map<String, String>> selectedQuestions = QuestionSelector.selectQuestions(allQuestions, types, 5, true);

		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(selectedQuestions)
				.createDataSetButtonAndConfirmation();
		PropertieFileUtil.storeSingleTextInPropertiesFile("dataSetName", dataSetName);

	}

	@Test(priority = 3, enabled = metaDataRun)
	public void verifynewCreateMetaData() throws Throwable {

		test = reports.createTest("verifynewCreateMetaData");

		PropertieFileUtil.storeSingleTextInPropertiesFile("metaData", metaDataName);
		homePage.clickOnProcessManagementCreate();

		metaData.navigateToMetaData().createNewMetaData(metaDataName).verifyCreateButtonAndConfirmation()
				.verifyCreatedMetaDataCheckUniqueIdAndRole(true, false)
				.verifySaveButtonAndConfirmationInUpadteMetaData().verifyExecuteUpadtedMetaData();

	}

	@Test(priority = 4, enabled = manualUploadRun)
	public void verifyCreateManualUpload() throws Throwable {

		test = reports.createTest("verifyCreateManualUpload");
//		homePage.clickOnProcessManagementCreate();

		ArrayList<String> labels = dataset.getLabelNamesFromProperties();
		int addNumberOfRecord = 30;

		PropertieFileUtil.storeSingleTextInPropertiesFile("no.OfRecord", String.valueOf(addNumberOfRecord));
		manualUpload.navigateToManualUpload().createNewManualUpload(manualUploadName)
				.formatDownloadAndUpdateAndUpload(labels, Questions.generateEmployeeQuestions(), addNumberOfRecord)
				.fillOtherFildsForUploadedFile(remark).createButtonAndConfirmation()
				.valiadtionsAfterCreationOfManualUpload(dataSetName, manualUploadName, remark, addNumberOfRecord);

	}

	@Test(priority = 5, enabled = nonMeasurableRun)
	public void verifyCreateNonMeasurable() throws Throwable {

		test = reports.createTest("verifyCreateNonMeasurable");

		// Create the test in ExtentReports
		// Perform necessary UI steps for creating the field set
		stages.navigateNonMeasurableCreate();
		// Set the question set name
		String questionSetNameString = employeeName + " NM";
		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString);
		// Specify the question types (e.g., DropDown = 4, TextBox = 10, Short Answer =
		// 3)

		int sectionCount = 1;
		int numberOfQuestion = 3;
		boolean fieldSetQuestionRandom = true;
		List<Integer> selectedQuestionTypes = QuestionSelector.selectQuestionTypes(fieldSetQuestionRandom,
				numberOfQuestion, MastersFieldSets.DROP_DOWN, MastersFieldSets.TEXT_BOX, MastersFieldSets.SHORT_ANSWER);
		// Now, add multiple questions to section 1 based on the selected types
		boolean defineQuestionTypeRandom = true;
		masterFieldSet.addMultipleQuestions(sectionCount, selectedQuestionTypes, numberOfQuestion,
				defineQuestionTypeRandom);

		masterFieldSet.verifySaveInCreateFieldSet();

	}

	@Test(priority = 6, enabled = stageRun)
	public void verifyStageCreate() throws Throwable {

		test = reports.createTest("verifyStageCreate");

		String stageName = employeeName + " Stage";

		PropertieFileUtil.storeSingleTextInPropertiesFile("stage", stageName);

		boolean measurableRadio = false;
		boolean nonMeasurableRadio = true;
//		String viewCheckBoxAddSection[] = { Stages.callLogStageView, Stages.agencyValidation };
		String viewCheckBoxAddSection[] = { "all" };

		stages.verifyStagesTabIsDisplayed(false, true).verifyCreateStagesButton().verifyStageNameTextBox(stageName)
				.verifyStageSelectAllProcessDropDown().verifyStageCalculationTypeDropDown()
				.verifyAddSectionA(false, false, true);

//		stages.verifyAddAndRemoveBlockInSectionB(4).selectMetaDataInAddBlockSectionB(2, true, false);
		stages.addSection(1, measurableRadio, nonMeasurableRadio, viewCheckBoxAddSection);

//		String viewCheckBox[] = { Stages.voiceCall,Stages.whatsAppCall };
		String viewCheckBox[] = { "all" };

		String toggleButtonOptions[] = { Stages.assignedTo, Stages.showSkipAudit, Stages.showDisposition,
				Stages.showSmsHistory, Stages.showSmsHistory, Stages.openSample };

//		String toggleButtonOptions[] = { "all" };
		stages.actionSection(viewCheckBox).actionSectionToggle(toggleButtonOptions);

		stages.dispositionSection().saveAndConfirmation();

		// delete created stage
//		stages.verifyStagesTabIsDisplayed(true, false).searchAndDeleteCreatedStage(stageName);

		stages.selectAllInEvaluationField(stageName).stageSettingListSaveAndConfirmation();

	}

	static String lastName = " QA";
	static String usernameToDoAction = employeeName + lastName;
//
//	@Test(priority = 7, enabled = userRun)
//	public void verifyUserCreateAndUserMapping() throws Throwable {
//
//		test = reports.createTest("verifyUserCreateAndUserMapping");
//		String process = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
//		String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess");
//		String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess");
//		String stages = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
//
//		userSetUp.navToUserCreatePage();
//
//		userSetUp.userCreationFields(employeeName, lastName, "Qwerty@123")
//				.singleGroupSelect(ManualAllocationPage.selectGroup).clickOnGroupCreateButton();
//
//		PropertieFileUtil.storeSingleTextInPropertiesFile("userName", usernameToDoAction);
//		userSetUp.userMappingRecord(usernameToDoAction).userMappingProcess(process, subProcess, subSubProcess, stages);
//	}

	@Test(priority = 7, enabled = userRun)
	public void verifyUserCreateAndUserMapping2() throws Throwable {

		test = reports.createTest("verifyUserCreateAndUserMapping2");
		userSetUp.navToUserSetUp("management");

		int noOfUser = 4;
		List<String> myGroups = Arrays.asList("Agent", "Agent","Agent", "Agent");
		List<String> permissionsList = Arrays.asList("Agent", "Agent","Agent", "Agent");
		boolean createButton = true;
		userSetUp.createMultipleUsers(noOfUser, myGroups, permissionsList, createButton);
		userSetUp.verifyMappingForAllUsers();
		
		

	}

	@Test(priority = 8, enabled = samplingPlanRun)
	public void verifyCreateSamplingPlan() throws Throwable {

		test = reports.createTest("verifyCreateSamplingPlan");

		SPAG.navToCreate();

		String samplingName = employeeName + " SN";

		String processValue = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
		String subProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subprocess");
		String subSubProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subsubProcess");
		String stages = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
		String metaData = PropertieFileUtil.getSingleTextFromPropertiesFile("metaData");

		SPAG.createSamplingPlan(processValue, subProcessValue, subSubProcessValue, stages, metaData)
				.generalTabSPAG(samplingName).generalTabToggleButton("allSample");
		SPAG.saveSamplingAndGetConfirmation();

//		SPAG.validationSamplingStatus(stages, processValue, subProcessValue, subSubProcessValue);

	}

	@Test(priority = 9, enabled = manualAllocationRun)
	public void verifyManualAllocationCreate() throws Throwable {

		test = reports.createTest("verifyManualAllocationCreate");

		String toogle = "normalAudit";
		String processValue = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
		String subProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subprocess");
		String subSubProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subsubProcess");
		String stages = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
//		String allocationType = "call";

		manualAllocationPage.navigateToAlchemyManualAllocation().allocationMethodToggleButton(toogle)
				.selectProcess_subProcess_SubSubProcess_StagesDropdown(processValue, subProcessValue,
						subSubProcessValue, stages);
//				.allocationTypeDropdown(allocationType, usernameToDoAction);
		manualAllocationPage.allocateSamplesToUsers("all", null, 0, 1);
//		manualAllocationPage.saveAndConfirmation();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException, Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Mark the test as failed in the ExtentReports
			test.fail(result.getThrowable());
			// Add screenshot to ExtentReports
			String screenshotPath = ScreenShorts.captureScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotPath);

			// Add logs
			test.log(Status.FAIL, "Test failed at " + new Date());

			// Add custom HTML block
			test.log(Status.INFO, MarkupHelper.createCodeBlock("<div>Custom HTML block</div>"));
		}
		// Close ExtentReports
		reports.flush();
	}

	@AfterTest
	public void tearDown() throws Throwable {
//		driver.manage().window().minimize();
//		driver.quit();
		reports.flush();
//		ScreenRecorderUtil.stopRecord();
	}

}