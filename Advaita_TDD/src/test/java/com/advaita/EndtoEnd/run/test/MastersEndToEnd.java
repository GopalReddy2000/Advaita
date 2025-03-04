package com.advaita.EndtoEnd.run.test;

import java.io.IOException;
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
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.WorkFlowDesign.PageObject.MasterFormPage;
import com.advaita.WorkFlowDesign.PageObject.MasterMenusPage;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.sideMasters.MastersAdd;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MastersEndToEnd extends TestBase {

	final String index = "K";
	final boolean fieldSetCreate = false;
	final boolean masterFormCreate = false;
	final boolean masterMenuCreate = false;
	final boolean createMastersAdd = true;

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MastersFieldSets masterFieldSet;
	MasterMenusPage masterMenusPage;
	MasterFormPage masterForm;
	MastersAdd mastersAdd;

	public MastersEndToEnd() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterEndToEnd.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MastersEndToEnd");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		masterForm = new MasterFormPage();
		masterMenusPage = new MasterMenusPage();
		masterFieldSet = new MastersFieldSets();
		mastersAdd = new MastersAdd();

	}

	@Test(priority = 1, enabled = fieldSetCreate)
	public void verifyAddMultipleFieldSetQuestions() throws Throwable {

		// Create the test in ExtentReports
		test = reports.createTest("verifyAddMultipleFieldSetQuestions");
		// Perform necessary UI steps for creating the field set
		masterFieldSet.verifyTabsForFieldSetCreate();
		masterFieldSet.verifyFieldSetCreateButton();
		// Set the question set name
		String questionSetNameString = "TestQueSet" + index;
		PropertieFileUtil.storeSingleTextInPropertiesFile("fieldSetName", questionSetNameString);
		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString);
		// Specify the question types (e.g., DropDown = 4, TextBox = 10, Short Answer =
		// 3)

		int sectionCount = 1;
		int numberOfQuestion = 8;
		boolean fieldSetQuestionRandom = true;
		List<Integer> selectedQuestionTypes = QuestionSelector.selectQuestionTypes(fieldSetQuestionRandom,
				numberOfQuestion, MastersFieldSets.TEXT_BOX, MastersFieldSets.DROP_DOWN, MastersFieldSets.DATE,
				MastersFieldSets.TIME, MastersFieldSets.MULTIPLE_CHOICE);
		// Now, add multiple questions to section 1 based on the selected types
		boolean defineQuestionRandom = true;
		masterFieldSet.addMultipleQuestions(sectionCount, selectedQuestionTypes, numberOfQuestion,
				defineQuestionRandom);
		masterFieldSet.verifySaveInCreateFieldSet();

	}

	@Test(priority = 2, enabled = masterFormCreate)
	public void verifyCreateMasterForm() throws Throwable {
		test = reports.createTest("verifyCreateMasterForm");

		String formName = "TestMF" + index;
		String secName = "TestSec";

		String fieldSetName = PropertieFileUtil.getSingleTextFromPropertiesFile("fieldSetName");

		masterForm.navigateToMasterForm2();
		masterForm.createButtonMasterForm();
		masterForm.formNameField(formName).processSelection().addPrimarySectionsDynamically(secName, fieldSetName)
				.validateMasterFormQuestions();
		PropertieFileUtil.storeSingleTextInPropertiesFile("formName", formName);

//		List<String> sections = Arrays.asList("TestA", "TestB");
//		masterForm.addMultipleSectionsDynamically(sections, fieldSetName); 
		masterForm.saveButton(false).finalizeMasterFormPage();

	}

	@Test(priority = 3, enabled = masterMenuCreate)
	public void verifyCreateMasterMenu() throws Throwable {
		test = reports.createTest("verifyCreateMasterMenu");

		String formMenu = "TestMM" + index;
		String formName = PropertieFileUtil.getSingleTextFromPropertiesFile("formName");

		masterMenusPage.navigateToMasterMenus();
		masterMenusPage.verifyCreateMasterMenuButton().verifyMasterFormDropDown(formName, formMenu)
				.masterMenuSaveButton();
		PropertieFileUtil.storeSingleTextInPropertiesFile("formMenu", formMenu);

	}

	@Test(priority = 4, enabled = createMastersAdd)
	public void verifyCreateMastersAdd() throws Throwable {
		test = reports.createTest("verifyCreateMastersAdd");
		MastersAdd.loadStoredQuestions();// Load the questions from the properties file
		String formMenu = PropertieFileUtil.getSingleTextFromPropertiesFile("formMenu");
		mastersAdd.navigateToMastersAdd(formMenu).validateAndInteractAddForm(); // Validate and interact with the form

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