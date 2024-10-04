package com.advaita.TestCreate;

import java.io.IOException;
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
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.advaita.pageObjects.ManualAllocationPage;
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

	Faker faker = new Faker();
//	public String num = "24";
//	public String dataSetName = "Test Single Data Set" + num;

//	public final String dataSetName = faker.name().lastName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MetaData metaData;
	DataSet dataset;
	ManualUpload manualUpload;
	MastersFieldSets masterFieldSet;
	Stages stages;
	UserSetupPage userSetUp;
	ManualAllocationPage manualAllocationPage;

	public TestManualAllocation() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
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

		metaData = new MetaData();
		dataset = new DataSet();
		manualUpload = new ManualUpload();
		masterFieldSet = new MastersFieldSets();
		stages = new Stages();
		userSetUp = new UserSetupPage();
		manualAllocationPage = new ManualAllocationPage();

	}

//	String employeeName = "EmployeeJ";
//
//	final String metaDataName = employeeName + " Details MetaData";
//	final String manualUploadName = employeeName + " Details Upload";
//	final String dataSetName = employeeName + " Details";
//	final String remark = "Test Manual Upload";
//
//	@Test(priority = 1)
//	public void verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType() throws Throwable {
//		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType");
//		homePage.clickOnProcessManagementCreate();
//
//		// Get all questions
//		List<Map<String, String>> allQuestions = Questions.generateEmployeeQuestions();
//		// Define the types and order of questions you want to select
//		// Character,Text Area,Date Time,Date,Number,Boolean,HyperLink
//		List<String> types = Arrays.asList("Character", "Text Area", "Number");
//
//		// Select questions based on types and order
//		List<Map<String, String>> selectedQuestions = QuestionSelector.selectQuestions(allQuestions, types, 4, true);
//
//		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(selectedQuestions)
//				.createDataSetButtonAndConfirmation();
//		PropertieFileUtil.storeSingleTextInPropertiesFile("dataSetName", dataSetName);
//
//	}
//
//	@Test(priority = 2)
//	public void verifynewCreateMetaData() throws Throwable {
//
//		test = reports.createTest("verifynewCreateMetaData");
//
//		PropertieFileUtil.storeSingleTextInPropertiesFile("metaData", metaDataName);
//		homePage.clickOnProcessManagementCreate();
//
//		metaData.navigateToMetaData().createNewMetaData(metaDataName).verifyCreateButtonAndConfirmation()
//				.verifyCreatedMetaDataCheckUniqueIdAndRole(true, false)
//				.verifySaveButtonAndConfirmationInUpadteMetaData().verifyExecuteUpadtedMetaData();
//
//	}
//
//	@Test(priority = 3)
//	public void verifyCreateManualUpload() throws Throwable {
//
//		test = reports.createTest("verifyCreateManualUpload");
//		homePage.clickOnProcessManagementCreate();
//
//		manualUpload.navigateToManualUpload().createNewManualUpload(manualUploadName)
//				.formatDownloadAndUpdateAndUpload(manualUpload.filteredItems, Questions.generateEmployeeQuestions(), 5)
//				.fillOtherFildsForUploadedFile(remark).createButtonAndConfirmation()
//				.valiadtionsAfterCreationOfManualUpload(dataSetName, manualUploadName, remark);
//
//	}
//
//	@Test(priority = 4)
//	public void verifyCreateNonMeasurable() throws Throwable {
//
//		test = reports.createTest("verifyCreateNonMeasurable");
//
//		// Create the test in ExtentReports
//		// Perform necessary UI steps for creating the field set
//		stages.navigateNonMeasurableCreate();
//		// Set the question set name
//		String questionSetNameString = employeeName + " NM";
//		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString);
//		// Specify the question types (e.g., DropDown = 4, TextBox = 10, Short Answer =
//		// 3)
//
//		int sectionCount = 1;
//		int numberOfQuestion = 7;
//		boolean fieldSetQuestionRandom = true;
//		List<Integer> selectedQuestionTypes = QuestionSelector.selectQuestionTypes(fieldSetQuestionRandom,
//				numberOfQuestion, MastersFieldSets.DROP_DOWN, MastersFieldSets.MULTIPLE_CHOICE,
//				MastersFieldSets.TEXT_BOX, MastersFieldSets.SHORT_ANSWER);
//		// Now, add multiple questions to section 1 based on the selected types
//		boolean defineQuestionTypeRandom = true;
//		masterFieldSet.addMultipleQuestions(sectionCount, selectedQuestionTypes, numberOfQuestion,
//				defineQuestionTypeRandom);
//
//		masterFieldSet.verifySaveInCreateFieldSet();
//
//	}
//
//	@Test(priority = 5)
//	public void verifyStageCreate() throws Throwable {
//
//		test = reports.createTest("verifyStageCreate");
//
//		String stageName = employeeName + " Stage";
//
//		PropertieFileUtil.storeSingleTextInPropertiesFile("stage", stageName);
//
//		boolean measurableRadio = false;
//		boolean nonMeasurableRadio = true;
//		String viewCheckBoxAddSection[] = { Stages.callLogStageView, Stages.agencyValidation };
////		String viewCheckBoxAddSection[] = {"all"};
//
//		stages.verifyStagesTabIsDisplayed(false, true).verifyCreateStagesButton().verifyStageNameTextBox(stageName)
//				.verifyStageSelectAllProcessDropDown().verifyStageCalculationTypeDropDown().verifyAddSectionA()
//				.verifyAddAndRemoveBlockInSectionB(4).selectMetaDataInAddBlockSectionB(2)
//				.addSection(1, measurableRadio, nonMeasurableRadio, viewCheckBoxAddSection);
//
////		String viewCheckBox[] = { Stages.voiceCall,Stages.whatsAppCall };
//		String viewCheckBox[] = { "all" };
//
////		String toggleButtonOptions[] = { Stages.assignedTo, Stages.showSkipAudit, Stages.showDisposition,
////				Stages.showSmsHistory, Stages.showSmsHistory, Stages.openSample };
//		String toggleButtonOptions[] = { "all" };
//
//		stages.actionSection(viewCheckBox).actionSectionToggle(toggleButtonOptions);
//
//		stages.dispositionSection().saveAndConfirmation();
////		stages.verifyStagesTabIsDisplayed(true, false).searchAndDeleteCreatedStage(stageName);
//
//	}
//
//	@Test(priority = 6)
//	public void verifyManualAllocationNavigation() throws Throwable {
//
//	test = reports.createTest("verifyManualAllocationNavigation");
//		String process = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
//		String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess");
//		String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess");
//		String stages = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
//
//
//		userSetUp.navToRoleAndPerCreate();
//
//		userSetUp.userCreationFields("Tester", "QA", "Qwerty@123").singleGroupSelect("Agent")
//				.clickOnGroupCreateButton();
//
//		userSetUp.userMappingRecord("Tester QA").userMappingProcess(process, subProcess, subSubProcess, stages);
//
//	}

	@Test(priority = 6)
	public void verifyManualAllocationNavigation() throws Throwable {

		test = reports.createTest("verifyManualAllocationNavigation");
		manualAllocationPage.navigateToAlchemyManualAllocation();

	}

	@Test(priority = 7)
	public void verifyAllocationMethodToogleButton() throws Throwable {

		test = reports.createTest("verifyAllocationMethodToogleButton");

		String toogle = "normalAudit";
		manualAllocationPage.allocationMethodToggleButton(toogle);

	}

	@Test(priority = 8)
	public void verifySelectProcess_subProcess_SubSubProcessDropdown() throws Throwable {

		test = reports.createTest("verifySelectProcess_subProcess_SubSubProcessDropdown");

		String processValue = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
		String subProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subprocess");
		String subSubProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subsubProcess");
		String stages = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
		String allocationType = "QA";


		manualAllocationPage
				.selectProcess_subProcess_SubSubProcess_StagesDropdown(processValue, subProcessValue, subSubProcessValue,stages)
				.allocationTypeDropdown(allocationType);
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
	public void tearDown() {
//		driver.manage().window().minimize();
//		driver.quit();
		reports.flush();
	}

}