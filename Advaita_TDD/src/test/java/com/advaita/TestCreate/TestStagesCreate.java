package com.advaita.TestCreate;

import static com.advaita.WorkFlowDesign.PageObject.Stages.isDisplayed;
import static com.advaita.WorkFlowDesign.PageObject.Stages.stageNameError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.ManualUpload;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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

	ProcessPage process;
	DataSet dataset;
	MetaData metaData;
	ManualUpload manualUpload;
	MastersFieldSets masterFieldSet;

	Stages stages;

	public TestStagesCreate() {
		super();
	}

	@BeforeMethod
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
		process = new ProcessPage();
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

	@Test(priority = 1)
	public void verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType() throws Throwable {
		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType");
		homePage.clickOnProcessManagementCreate();

		// Get all questions
		List<Map<String, String>> allQuestions = Questions.generateEmployeeQuestions();
		// Define the types and order of questions you want to select
		// Character,Text Area,Date Time,Date,Number,Boolean,HyperLink
		List<String> types = Arrays.asList("Character", "Text Area", "Number");

		// Select questions based on types and order
		List<Map<String, String>> selectedQuestions = QuestionSelector.selectQuestions(allQuestions, types, 4, true);

		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(selectedQuestions)
				.createDataSetButtonAndConfirmation();

	}

	@Test(priority = 2)
	public void verifynewCreateMetaData() throws Throwable {

		test = reports.createTest("verifynewCreateMetaData");
		homePage.clickOnProcessManagementCreate();

		metaData.navigateToMetaData().createNewMetaData(metaDataName).verifyCreateButtonAndConfirmation()
				.verifyCreatedMetaDataCheckUniqueIdAndRole(true, false)
				.verifySaveButtonAndConfirmationInUpadteMetaData().verifyExecuteUpadtedMetaData();

	}

	@Test(priority = 3)
	public void verifyCreateManualUpload() throws Throwable {

		test = reports.createTest("verifyCreateManualUpload");
		homePage.clickOnProcessManagementCreate();

		ArrayList<String> labels = dataset.getLabelNamesFromProperties();
		int noOfRecords = 5;

		manualUpload.navigateToManualUpload().createNewManualUpload(manualUploadName)
				.formatDownloadAndUpdateAndUpload(labels, Questions.generateEmployeeQuestions(),
						noOfRecords)
				.fillOtherFildsForUploadedFile(remark).createButtonAndConfirmation()
				.valiadtionsAfterCreationOfManualUpload(dataSetName, manualUploadName, remark, noOfRecords);

	}

	@Test(priority = 4)
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
		int numberOfQuestion = 7;
		boolean fieldSetQuestionRandom = true;
		List<Integer> selectedQuestionTypes = QuestionSelector.selectQuestionTypes(fieldSetQuestionRandom,
				numberOfQuestion, MastersFieldSets.DROP_DOWN, MastersFieldSets.MULTIPLE_CHOICE,
				MastersFieldSets.TEXT_BOX, MastersFieldSets.SHORT_ANSWER);
		// Now, add multiple questions to section 1 based on the selected types
		boolean defineQuestionTypeRandom = true;
		masterFieldSet.addMultipleQuestions(sectionCount, selectedQuestionTypes, numberOfQuestion,
				defineQuestionTypeRandom);

		masterFieldSet.verifySaveInCreateFieldSet();

	}

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
		stages.verifyStagesTabIsDisplayed(false, true);
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
		stages.verifyAddSectionA(false, false, true);
	}

	@Test(priority = 14)
	public void verifySectionB_addBlock() throws Throwable {
		test = reports.createTest("verifyAddBlockInSectionB");
		stages.verifyAddAndRemoveBlockInSectionB(5);
	}

	@Test(priority = 15)
	public void verifySelectMetaDataInAddBlockSectionB() throws Throwable {
		test = reports.createTest("selectMetaDataInAddBlockSectionB");
		stages.selectMetaDataInAddBlockSectionB(3, true, false);
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
		String viewCheckBox[] = { "all" };
		String toggleButtonOptions[] = { Stages.assignedTo, Stages.showSkipAudit, Stages.showDisposition,
				Stages.showSmsHistory, Stages.showSmsHistory, Stages.openSample };
//		String toggleButtonOptions[] = {"all"};
		stages.actionSection(viewCheckBox).actionSectionToggle(toggleButtonOptions);

	}

//	@Test(priority = 18)
//	public void verifyDispositionSection() throws Throwable {
//		test = reports.createTest("dispositionSection");
//		stages.dispositionSection();
//
//	}

	@Test(priority = 19)
	public void verifyStageCreate() throws Throwable { 	

		String stageName = "Test Emp Stage";

		boolean measurableRadio = false;
		boolean nonMeasurableRadio = true;
		String viewCheckBoxAddSection[] = { Stages.callLogStageView, Stages.agencyValidation };
//		String viewCheckBoxAddSection[] = {"all"};

		test = reports.createTest("verifyStageCreate");
		stages.verifyStagesTabIsDisplayed(false, true).verifyCreateStagesButton().verifyStageNameTextBox(stageName)
				.verifyStageSelectAllProcessDropDown().verifyStageCalculationTypeDropDown()
				.verifyAddSectionA(false, false, true).verifyAddAndRemoveBlockInSectionB(4)
				.selectMetaDataInAddBlockSectionB(2, true, false)
				.addSection(1, measurableRadio, nonMeasurableRadio, viewCheckBoxAddSection);

//		String viewCheckBox[] = { Stages.voiceCall,Stages.whatsAppCall };
		String viewCheckBox[] = { "all" };

//		String toggleButtonOptions[] = { Stages.assignedTo, Stages.showSkipAudit, Stages.showDisposition,
//				Stages.showSmsHistory, Stages.showSmsHistory, Stages.openSample };
		String toggleButtonOptions[] = { "all" };

		stages.actionSection(viewCheckBox).actionSectionToggle(toggleButtonOptions);

		stages.dispositionSection().saveAndConfirmation();
//		stages.verifyStagesTabIsDisplayed(true, false).searchAndDeleteCreatedStage(stageName);

	}

	@Test(dataProvider = "invalidStageNameProvider")
	public void testStageName(String stageName) {
		stages.Negative1(stageName, "AJP", "Sub AJP", "Sub Sub AJP").clickOnSingleSubmit();
		unWaitInMilli(500);
		assert isDisplayed(stageNameError);
		continueButton.click();
		stages.navigateBack();
	}

	@Test
	public void NegTest1() {

		stages.Negative1("Test 2", "AJP", "Sub AJP", "Sub Sub AJP").NegSectionA("Form Test_metadata").saveRecord();
		stages.navigateBack();
		stages.assertNoOptionsInMultiSelect()

		;
	}

	@Test
	public void sectionAandB() {
		stages.navToCreatePage().sectionAAndB();
	}

	@DataProvider(name = "invalidStageNameProvider")
	public Object[][] invalidStageNameData() {
		return new Object[][] {
				// Invalid due to special characters (assuming only alphanumeric allowed)
				{ "Stage@123" }, // Contains '@'
				{ "Stage#123" }, // Contains '#'
				{ "Stage!Name" }, // Contains '!'
				{ "Stage$Name" }, // Contains '$'
				{ "Stage%Name" }, // Contains '%'
				{ "Stage^Name" }, // Contains '^'
				{ "Stage&Name" }, // Contains '&'
				{ "Stage*Name" }, // Contains '*'
				{ "Stage(Name)" }, // Contains parentheses
				{ "Stage+Name" }, // Contains '+'
				{ "Stage/Name" }, // Contains '/'
				{ "Stage\\Name" }, // Contains backslash
				{ "Stage|Name" }, // Contains '|'
				{ "Stage=Name" }, // Contains '='
				{ "Stage<Name>" }, // Contains '<' and '>'
				{ "Stage~Name" }, // Contains '~'
				{ "TestNeg1" },
				// Invalid due to SQL Injection
				{ "DROP TABLE stage;" }, // SQL Injection attempt
				{ "' OR 1=1 --" }, // SQL Injection attempt
				{ "' OR '1'='1'" }, // SQL Injection attempt
				{ "1; DROP TABLE users --" }, // SQL Injection attempt

				// Invalid due to script injection
				{ "<script>alert('test')</script>" }, // Script injection

				// Invalid due to whitespaces
				{ "   " }, // Whitespace only
				{ " Stage" }, // Leading whitespace
				{ "Stage " }, // Trailing whitespace
				{ " Stage " }, // Leading and trailing whitespace
				{ "Stage\tName" }, // Contains tab
				{ "Stage\nName" }, // Contains new line

				// Invalid due to length
				{ "A".repeat(257) }, // Over maximum length (assuming max length is 100)

				// Invalid due to empty input
				{ "" } // Empty string
		};
	}

	@Test(dataProvider = "invalidTextInput")
	public void testSectionCTextBox(String invalidData) {
		stages.navToCreatePage().sectionCTextbox(invalidData);

	}

	@Test(dataProvider = "invalidSearchData")
	public void testSearchBox(String invalidData, String expectedBehavior) {
		stages.navToStagesTable().searchBox(invalidData, expectedBehavior);
	}

	@DataProvider(name = "invalidSearchData")
	public Object[][] invalidSearchData() {
		return new Object[][] {
				// Empty input, expect no error message and page remains the same
				{ "", "none" },

				// Invalid Data, expect "No entries found" message
				{ "!@#$%^&*()_+=-`~", "No entries found" },

				// SQL Injection Strings, expect "No entries found"
				{ "' OR 1=1;--", "No entries found" }, { "' DROP TABLE users;--", "No entries found" },
				// Unicode Characters, expect database error or error page
				{ "Ā ā Ă ă Ą ą Ć ć Ĉ ĉ Ċ ċ Č č Ď ď ", "database error" } };
	}

	@DataProvider(name = "sqlInjectionTestData")
	public Object[][] sqlInjectionTestData() {
		return new Object[][] { { "' OR '1'='1" }, { "' OR '1'='1' --" }, { "'; DROP TABLE users --" },
				{ "' UNION SELECT NULL, NULL --" }, { "' UNION SELECT username, password FROM users --" },
				{ "'; WAITFOR DELAY '00:00:10' --" }, { "1 OR 1=1" }, { "' HAVING 1=1" }, { "' AND 'x'='x" },
				{ "'; EXEC xp_cmdshell('whoami') --" }, { "' ; DELETE FROM users WHERE username = 'admin'; --" },
				{ "' ; INSERT INTO users (username, password) VALUES ('admin', 'password'); --" },
				{ "'; IF (1=1) WAITFOR DELAY '00:00:10'; --" }, { "%27%20OR%201%3D1--" }, { "0x50 || 0x45 || 0x54" },
				{ "1 UNION SELECT @@version, NULL, NULL --" }, };
	}

	@Test(dataProvider = "invalidDates")
	public void testDatePicker(String invalidDate) {
		stages.navToStagesTable().testInvalidDate(invalidDate);
	}

	@DataProvider(name = "invalidDates")
	public Object[][] getInvalidDates() {
		return new Object[][] { { "00-12-2024" }, { "32-01-2024" }, { "31-04-2024" }, { "29-02-2023" },
				{ "31-02-2024" }, { "31-06-2024" }, { "25-00-2024" }, { "10-13-2024" }, { "15-15-2024" },
				{ "15-10-99999" }, { "15-10-0000" }, { "15-10--2024" }, { "15-10-23" }, { "15/10/2024" },
				{ "15.10.2024" }, { "15_10_2024" }, { "ab-cd-efgh" }, { "12-12-abcd" }, { "@@-##-!!!!" }, { "--2024" },
				{ "12--2024" }, { "--" }, { "2024-12-15" }, { "31-12-0001" }, { "01-01-3000" }, { "00-00-2024" },
				{ "00-13-2024" }, { "40-02-2024" } };
	}

//	@AfterMethod
//	public void getResult(ITestResult result) throws IOException, Throwable {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			// Mark the test as failed in the ExtentReports
//			Thread.sleep(4000);
//			test.fail(result.getThrowable());
//			// Add screenshot to ExtentReports
//			String screenshotPath = ScreenShorts.captureScreenshot(result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath(screenshotPath);
//			Thread.sleep(4000);
//
//			// Add logs
//			test.log(Status.FAIL, "Test failed at " + new Date());
//
//			// Add custom HTML block
//			test.log(Status.INFO, MarkupHelper.createCodeBlock("<div>Custom HTML block</div>"));
//		}
//		// Close ExtentReports
//		reports.flush();
//	}

	@AfterMethod
	public void tearDown() {

		driver.manage().window().minimize();
		driver.quit();
		reports.flush();

	}
}