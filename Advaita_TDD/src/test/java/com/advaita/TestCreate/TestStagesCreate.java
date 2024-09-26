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
import com.advaita.DataSetUp.PageObject.Process;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;
import Advaita_TDD.Advaita_TDD.Questions;

public class TestStagesCreate extends TestBase {

	FakeData fake = new FakeData();

	public String processName = "P " + FakeData.lastName1();
	public String processDesc = "P Desc";
	public String subProcessName = "SP" + FakeData.lastName1();
	public String subProcessDesc = "SP Desc";
	public String subSubProcessName = "SSP " + FakeData.lastName1();
	public String subSubProcessDesc = "SSP Desc";

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	Process process;
	DataSet dataset;
	MetaData metaData;
	ManualUpload manualUpload;
	MastersFieldSets masterFieldSet;

	Stages stages;

	public TestStagesCreate() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/StagesCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for Stages");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		// Pre-condition
		process = new Process();
		dataset = new DataSet();
		metaData = new MetaData();
		manualUpload = new ManualUpload();
		masterFieldSet = new MastersFieldSets();

		stages = new Stages();
	}

//	HomePage hp = new HomePage();

	String employeeName = "EmployeeC";

	final String metaDataName = employeeName + " Details MetaData";
	final String manualUploadName = employeeName + " Details Upload";
	final String dataSetName = employeeName + " Details";
	final String remark = "Test Manual Upload";

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
//
//	}
//
//	@Test(priority = 2)
//	public void verifynewCreateMetaData() throws Throwable {
//
//		test = reports.createTest("verifynewCreateMetaData");
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

//	@Test(priority = 5)
//	public void navigateFetchRecord() throws Throwable {
//		test = reports.createTest("clickOnworkflowDesign");
//		homePage.clickOnworkflowDesign();
//
//		test = reports.createTest("navigateFetchProcessRecord");
//		stages.navigateFetchProcessRecord(false);
//
//	}

	@Test(priority = 6)
	public void VerifyStagesTabIsDisplayed() throws Throwable {
		test = reports.createTest("VerifyStagesTabIsDisplayed");
		stages.VerifyStagesTabIsDisplayed(false, true);
	}

	@Test(priority = 7)
	public void verifyCreateStagesButton() throws Throwable {
		test = reports.createTest("verifyCreateStagesButton");
		stages.verifyCreateStagesButton();
	}

	@Test(priority = 8)
	public void verifyStageNameTextBox() throws Throwable {
		test = reports.createTest("verifyStageNameTextBox");
		stages.verifyStageNameTextBox(FakeData.firstCapString());
	}

	@Test(priority = 9)
	public void verifyStageSelectProcessDropDown() throws Throwable {
		test = reports.createTest("verifyStageSelectProcessDropDown");
		stages.verifyStageSelectProcessDropDown();
	}

	@Test(priority = 10)
	public void verifyStageSelectSubProcessDropDown() throws Throwable {
		test = reports.createTest("verifyStageSelectSubProcessDropDown");
		stages.verifyStageSelectSubProcessDropDown();
	}

	@Test(priority = 11)
	public void verifyStageSelectSubSubProcessDropDown() throws Throwable {
		test = reports.createTest("verifyStageSelectSubSubProcessDropDown");
		stages.verifyStageSelectSubSubProcessDropDown();
	}

	@Test(priority = 12)
	public void verifyStageCalculationTypeDropDown() throws Throwable {
		test = reports.createTest("verifyStageCalculationTypeDropDown");
		stages.verifyStageCalculationTypeDropDown();
	}

	@Test(priority = 13)
	public void verifyAddSectionA() throws Throwable {
		test = reports.createTest("verifyAddSectionA");
		stages.verifyAddSectionA();
	}

	@Test(priority = 14)
	public void verifySectionB_addBlock() throws Throwable {
		test = reports.createTest("verifyAddBlockInSectionB");
		stages.verifyAddBlockInSectionB(5);
	}

	@Test(priority = 15)
	public void verifySelectMetaDataInAddBlockSectionB() throws Throwable {
		test = reports.createTest("selectMetaDataInAddBlockSectionB");
		stages.selectMetaDataInAddBlockSectionB(3);
	}

	@Test(priority = 16)
	public void verifyAddSection() throws Throwable {
		test = reports.createTest("verifyAddSection");

		boolean measurableRadio = false;
		boolean nonMeasurableRadio = true;
		String viewCheckBox[] = { Stages.callLogStageView, Stages.agencyValidation };
//		String viewCheckBox[] = {"all"};
		stages.addSection(1, measurableRadio, nonMeasurableRadio, viewCheckBox);
	}

	@Test(priority = 17)
	public void verifyActionSection() throws Throwable {
		test = reports.createTest("verifyActionSection");

//		String viewCheckBox[] = { Stages.voiceCall,Stages.whatsAppCall };
		String viewCheckBox[] = {"all"};
		stages.actionSection(viewCheckBox);

	}

//	@Test(priority = 18)
//	public void verifyDispositionSection() throws Throwable {
//		test = reports.createTest("dispositionSection");
//		stages.dispositionSection();
//
//	}

//	@Test(priority = 19)
//	public void verifySaveAndConfirmation() throws Throwable {
//		test = reports.createTest("verifySaveAndConfirmation");
//		stages.saveAndConfirmation();
//
//	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException, Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Mark the test as failed in the ExtentReports
			Thread.sleep(4000);
			test.fail(result.getThrowable());
			// Add screenshot to ExtentReports
			String screenshotPath = ScreenShorts.captureScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotPath);
			Thread.sleep(4000);

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