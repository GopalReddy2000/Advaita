package com.advaita.TestCreate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

public class TestMasterFieldsSetCreate extends TestBase {

	Faker faker = new Faker();

	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MastersFieldSets masterFieldSet;

	public TestMasterFieldsSetCreate() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterFieldSetCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
		htmlReporter.config().setReportName("TEST Advaita-MetaData");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

//		*******************************************************************************************************************
		masterFieldSet = new MastersFieldSets();

	}

	HomePage hp = new HomePage();

	@Test(priority = 1)
	public void verifyTabsForFieldSetCreate() throws Throwable {

		homePage.clickOnworkflowDesign();

		test = reports.createTest("verifyTabsForFieldSetCreate");
		masterFieldSet.verifyTabsForFieldSetCreate();

	}

	@Test(priority = 2)
	public void verifyBeforeFieldSetCount() throws Throwable {

		test = reports.createTest("verifyBeforeFieldSetCreatedCount");
		masterFieldSet.verifyBeforeFieldSetCreatedCount();

	}

	@Test(priority = 3)
	public void verifyFieldSetCreateButton() throws Throwable {

		test = reports.createTest("verifyFieldSetCreateButton");
		masterFieldSet.verifyFieldSetCreateButton();

	}

	@Test(priority = 4)
	public void verifyQuestionSetNameField() throws Throwable {

		test = reports.createTest("verifyQuestionSetNameField");
		masterFieldSet.verifyQuestionSetNameField();

	}

	@Test(priority = 5)
	public void verifyDefaultSection1() throws Throwable {

		test = reports.createTest("verifyDefaultSection1");
		masterFieldSet.verifyDefaultSection1andAddingQuestion();

	}

	@Test(priority = 6)
	public void verifyByAddingQuestionsAndQuestionsType() throws Throwable {

		test = reports.createTest("verifyByAddingQuestionsAndQuestionsType");
		masterFieldSet.verifyByAddingQuestionsTypeInSection1();

	}

	@Test(priority = 7)
	public void verifyAddedSection2() throws Throwable {

		test = reports.createTest("verifyDefaultSection2s");
		masterFieldSet.verifyDefaultSection2();

	}

	@Test(priority = 8)
	public void verifyByAddingQuestionsAndQuestionsTypeInSection2() throws Throwable {

		test = reports.createTest("verifyByAddingQuestionsAndQuestionsTypeInSection2");
		masterFieldSet.verifyByAddingQuestionsAndQuestionsTypeInSection2();
	}

//	@Test(priority = 9)
//	public void verifyIsConditionalandConnectTwoSections() throws Throwable {
//
//		test = reports.createTest("verifyIsConditionalandConnectTwoSections");
//		masterFieldSet.verifyIsConditionalandConnectTwoSections();
//
//	}
//
//	@Test(priority = 10)
//	public void verifySaveInCreateFieldSet() throws Throwable {
//
//		test = reports.createTest("verifySaveInCreateFieldSet");
//		masterFieldSet.verifySaveInCreateFieldSet();
//
//	}
//
//	@Test(priority = 11)
//	public void verifySelectOptionAfterIsConditional() throws Throwable {
//
//		test = reports.createTest("verifySelectOptionAfterIsConditional");
//		masterFieldSet.verifySelectOptionAfterIsConditional();
//
//	}

	@Test(priority = 12)
	public void verifyCreateFieldSetTabularView() throws Throwable {

		test = reports.createTest("verifyCreateFieldSetTabularView");
		masterFieldSet.createFieldSetTabularView();

	}

	@Test(priority = 13)
	public void verifySaveInCreateFieldSet() throws Throwable {

		test = reports.createTest("verifySaveInCreateFieldSet");
		masterFieldSet.verifySaveInCreateFieldSet();

	}

	@Test(priority = 14)
	public void verifyafterFieldSetCount() throws Throwable {

		test = reports.createTest("verifyAfterFieldSetCreatedCount");
		masterFieldSet.verifyAfterFieldSetCreatedCount();

	}

//	@Test(priority = 15)
//	public void verifyNumberFieldInCreateFieldSet() throws Throwable {
//		
//		test = reports.createTest("verifyNumberFieldInCreateFieldSet");
//		
////		MastersFieldSets.commonNavigation();
//		masterFieldSet.verifyNumberFieldInCreateFieldSet();
//		
//	}

	@Test(priority = 16)
	public void verifyAddFormFieldSetInCreateFieldSet() throws Throwable {

		test = reports.createTest("verifyAddFormFieldSetInCreateFieldSet");

		masterFieldSet.commonNavigation();
		masterFieldSet.verifyTabsForFieldSetCreate();
		masterFieldSet.verifyFieldSetCreateButton();

		String questionSetNameString = "DropDown Ques";
		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString);

		String minLength = "10";
		String maxLength = "14";
		String expectedDefaultOption = "All";
		String[] expectedOrder = { "All", "Only Text", "Only Number" };

		String typeOfValue = "Only Number"; // "All", "Only Text", "Only Number";

		// Text Box
		masterFieldSet.addTextBoxRelatedQuestions("Number Of The Customer?", 1, // Section
				1, // Question
				MastersFieldSets.TEXT_BOX, minLength, maxLength, expectedDefaultOption, expectedOrder, typeOfValue);

		// Drop Down
		List<String> sector = Arrays.asList("core", "it", "electronics");
		masterFieldSet.addQuestions(1).addDropDownRelatedQuestions("Create Drop Down ?", 1, // Section
				2, // Question
				MastersFieldSets.RELATIVE_DROP_DOWN, sector);

		// Short Answer
		masterFieldSet.addSection().addTextBoxRelatedQuestions("Details Of The Customer?", 2, // Section
				1, // Question
				MastersFieldSets.SHORT_ANSWER, minLength, maxLength, expectedDefaultOption, expectedOrder, typeOfValue);

	}

	@Test(priority = 17)
	public void verifyAddMultipleFieldSetQuestions() throws Throwable {

		// Create the test in ExtentReports
		test = reports.createTest("verifyAddMultipleFieldSetQuestions");
		// Perform necessary UI steps for creating the field set
		masterFieldSet.verifyTabsForFieldSetCreate();
		masterFieldSet.verifyFieldSetCreateButton();
		// Set the question set name
		String questionSetNameString = "Test Question";
		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString);
		// Specify the question types (e.g., DropDown = 4, TextBox = 10, Short Answer =
		// 3)

		int sectionCount = 3;
		int numberOfQuestion = 4;
		boolean fieldSetQuestionRandom = true;
		List<Integer> selectedQuestionTypes = QuestionSelector.selectQuestionTypes(fieldSetQuestionRandom,
				numberOfQuestion, MastersFieldSets.RELATIVE_DROP_DOWN, MastersFieldSets.TIME);
		// Now, add multiple questions to section 1 based on the selected types
		boolean defineQuestionRandom = true;
		masterFieldSet.addMultipleQuestions(sectionCount, selectedQuestionTypes, numberOfQuestion,
				defineQuestionRandom);
	}

//	############################## Negative Scripts ###################################

	@Test(priority = 18)
	public void verifyquestionSetFieldFieldSetQuestions() throws Throwable {

		// Create the test in ExtentReports
		test = reports.createTest("verifyAddMultipleFieldSetQuestions");

		verifyTabsForFieldSetCreate();
		verifyFieldSetCreateButton();
		masterFieldSet.checkCancelButton();
		verifyFieldSetCreateButton();
		masterFieldSet.questionSetFieldTest(" ");

	}

	@Test(priority = 19)
	public void verifyQuestionField() throws Throwable {

		// Create the test in ExtentReports
		test = reports.createTest("verifyQuestionField");

		verifyTabsForFieldSetCreate();
		verifyFieldSetCreateButton();
		masterFieldSet.questionSetFieldTest(" ");
		masterFieldSet.questionField("1", "1", "Test Question", "10").saveMasterFieldSet();

	}
	@Test(priority = 20)
	public void verifySections() throws Throwable {
		
		// Create the test in ExtentReports
		test = reports.createTest("verifySections");
		
		verifyTabsForFieldSetCreate();
		verifyFieldSetCreateButton();
		masterFieldSet.questionSetFieldTest(" ");
		
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
