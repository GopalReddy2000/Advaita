package com.advaita.TestCreate;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.WorkFlowDesign.PageObject.MasterFormPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestMasterFormsCreate extends TestBase {

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MasterFormPage masterForm;

	public TestMasterFormsCreate() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterFormCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for Masters");
		htmlReporter.config().setReportName("TEST Advaita-MetaData");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

//		*******************************************************************************************************************
		masterForm = new MasterFormPage();

	}

//	@Test(priority = 1)
//	public void verifycreateProcess() throws Throwable {
//		
//		test = reports.createTest("createProcess");
//		masterForm.createProcess();
//	}

	@Test(priority = 2)
	public void verifyNavigationToProcessAndFetch() throws Throwable {

		test = reports.createTest("navigationToProcessAndFetch");
		masterForm.navigationToProcessAndFetch();
	}

	@Test(priority = 3)
	public void verifyNavigationToFieldSet2() throws Throwable {

		test = reports.createTest("verifyNavigationToFieldSet2");
		masterForm.navigationToFieldSet2();
	}

	@Test(priority = 4)
	public void verifyGetFieldSetSection1QuestionsForComparision() throws Throwable {

		test = reports.createTest("getFieldSetSection1QuestionsForComparision");
		masterForm.getFieldSetSection1QuestionsForComparision();
	}

	@Test(priority = 5)
	public void verifyGetFieldSetSection2QuestionsForComparision() throws Throwable {

		test = reports.createTest("getFieldSetSection2QuestionsForComparision");
		masterForm.getFieldSetSection2QuestionsForComparision();
	}

	@Test(priority = 6)
	public void verifyGetFieldSetSection3TableQuestionsForComparision() throws Throwable {

		test = reports.createTest("getFieldSetSection3TableQuestionsForComparision");
		masterForm.getFieldSetSection3TableQuestionsForComparision();
	}

	@Test(priority = 7)
	public void verifyGetFieldSetSection1QuestionsType() throws Throwable {

		test = reports.createTest("getFieldSetSection1QuestionsType");
		masterForm.getFieldSetSection1QuestionsType();
	}

	@Test(priority = 8)
	public void verifyGetFieldSetSection2QuestionsType() throws Throwable {

		test = reports.createTest("getFieldSetSection2QuestionsType");
		masterForm.getFieldSetSection2QuestionsType();
	}

	@Test(priority = 9)
	public void verifyGetFieldSetSection3QuestionsType() throws Throwable {

		test = reports.createTest("getFieldSetSection3QuestionsType");
		masterForm.getFieldSetSection3QuestionsType();
	}

//	@Test(priority = 10)
//	public void verifyfieldSet2QuestionAndFetchQuestionType() throws Throwable {
//
//		test = reports.createTest("fieldSet2QuestionAndFetchQuestionType");
//		masterForm.fieldSet2QuestionAndFetchQuestionType();
//	}

	@Test(priority = 11)
	public void verifyNavigateToMasterForm() throws Throwable {

		test = reports.createTest("navigateToMasterForm");
		masterForm.navigateToMasterForm();
//		masterForm.masterFormsFirstRecoredDelete();
	}

	@Test(priority = 12)
	public void verifyCreateButtonMasterForm() throws Throwable {

		test = reports.createTest("createButtonMasterForm");
		masterForm.createButtonMasterForm();
	}

	@Test(priority = 13)
	public void verifyFormNameField() throws Throwable {

		test = reports.createTest("formNameField");
		masterForm.formNameField();
	}

	@Test(priority = 14)
	public void verifyProcessDropdown() throws Throwable {

		test = reports.createTest("procesDropdown");
		masterForm.procesDropdown();
	}

	@Test(priority = 15)
	public void verifySubProcessDropdown() throws Throwable {

		test = reports.createTest("subProcesDropdown");
		masterForm.subProcesDropdown();
	}

	@Test(priority = 16)
	public void verifySubSubProcessDropdown() throws Throwable {

		test = reports.createTest("subSubProcesDropdown");
		masterForm.subSubProcesDropdown();
	}

	@Test(priority = 17)
	public void verifyprimarySection() throws Throwable {

		test = reports.createTest("primarySection");
		masterForm.primarySection();
	}

	@Test(priority = 18)
	public void verifyPrimarySectionFormFill() throws Throwable {

		test = reports.createTest("primarySectionFormFill");
		masterForm.primarySectionFormFill();
	}

	@Test(priority = 19)
	public void verifyPrimarySection2FormFill() throws Throwable {

		test = reports.createTest("primarySection2FormFill");
		masterForm.primarySection2FormFill();
	}

	@Test(priority = 20)
	public void verifyPrimarySection3FormFill() throws Throwable {

		test = reports.createTest("primarySection3FormFill");
		masterForm.primarySection3FormFill();
	}

//	@Test(priority = 21)
//	public void verifyaddSection2InMasterForml() throws Throwable {
//		
//		test = reports.createTest("addSection2InMasterForm");
//		masterForm.addSection2InMasterForm();
//	}

	@Test(priority = 22)
	public void verifySaveButton() throws Throwable {

		test = reports.createTest("saveButton");
		masterForm.saveButton();
	}

	@Test(priority = 23)
	public void verifyFinalizeMasterFormInEditPage() throws Throwable {

		test = reports.createTest("finalizeMasterFormInEditPage");
		masterForm.finalizeMasterFormInEditPage();
	}

	@Test(priority = 24)
	public void verifyDataSetValidationAfterCreationOfMasterForm() throws Throwable {

		test = reports.createTest("dataSetValidationAfterCreationOfMasterForm");
		masterForm.dataSetValidationAfterCreationOfMasterForm();
	}

	@Test(priority = 25)
	public void verifyMetaDataValidationAfterCreationOfMasterForm() throws Throwable {

		test = reports.createTest("metaDataValidationAfterCreationOfMasterForm");
		masterForm.metaDataValidationAfterCreationOfMasterForm();
	}
	
	@Test(priority = 26)
	public void verifyMasterFieldsAfterCreationOfMasterForm() throws Throwable {
		
		test = reports.createTest("masterFieldsAfterCreationOfMasterForm");
		masterForm.masterFieldsAfterCreationOfMasterForm();
	}
	
	@Test(priority = 27)
	public void verifyMasterFillterAfterCreationOfMasterFields() throws Throwable {
		
		test = reports.createTest("masterFillterAfterCreationOfMasterFields");
		masterForm.masterFilterAfterCreationOfMasterFields();
	}
	
	@Test(priority = 28)
	public void validationsAfterMasterFilterAndMasterFields() throws Throwable {
		
		test = reports.createTest("validationsAfterMasterFilterAndMasterFields");
		masterForm.validationsAfterMasterFilterAndMasterFields();
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
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
