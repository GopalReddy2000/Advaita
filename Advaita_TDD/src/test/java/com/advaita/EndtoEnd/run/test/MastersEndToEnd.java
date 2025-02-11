package com.advaita.EndtoEnd.run.test;

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
import com.advaita.WorkFlowDesign.PageObject.MasterMenusPage;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MastersEndToEnd extends TestBase {

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MastersFieldSets masterFieldSet;
	MasterMenusPage masterMenusPage;
	MasterFormPage masterForm;
	

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
		htmlReporter.config().setDocumentTitle("Extent Report for Masters");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		
		masterForm = new MasterFormPage();
		masterMenusPage = new MasterMenusPage();
		masterFieldSet = new MastersFieldSets();
		
	}

	@Test(priority = 1)
	public void verifyFieldSetCreate() throws Throwable {
		test = reports.createTest("verifyFieldSetCreate");
		
		homePage.clickOnworkflowDesign();
		masterFieldSet.verifyTabsForFieldSetCreate();
		masterFieldSet.verifyBeforeFieldSetCreatedCount();
		masterFieldSet.verifyFieldSetCreateButton();
		masterFieldSet.verifyQuestionSetNameField();
		masterFieldSet.verifyDefaultSection1andAddingQuestion();
		masterFieldSet.verifyByAddingQuestionsTypeInSection1();
		masterFieldSet.verifyDefaultSection2();
		masterFieldSet.verifyByAddingQuestionsAndQuestionsTypeInSection2();
//		
//		
//		
		masterFieldSet.createFieldSetTabularView();
		masterFieldSet.verifySaveInCreateFieldSet();
		masterFieldSet.verifyAfterFieldSetCreatedCount();
//		
		
	}
	
	@Test(priority = 2)
	public void verifyCreateMasterForm() throws Throwable {
		test = reports.createTest("verifyCreateMasterForm");

		masterForm.createProcess();
		masterForm.navigationToProcessAndFetch();
		masterForm.navigationToFieldSet2();
		masterForm.getFieldSetSection1QuestionsForComparision();
		masterForm.getFieldSetSection2QuestionsForComparision();
		masterForm.getFieldSetSection3TableQuestionsForComparision();
		masterForm.getFieldSetSection1QuestionsType();
		masterForm.getFieldSetSection2QuestionsType();
		masterForm.getFieldSetSection3QuestionsType();
//		
		masterForm.navigateToMasterForm();
//		masterForm.masterFormsFirstRecoredDelete();
		masterForm.createButtonMasterForm();
		masterForm.formNameField();
		masterForm.procesDropdown();
		masterForm.subProcesDropdown();
		masterForm.subSubProcesDropdown();
		masterForm.primarySection();
		masterForm.primarySectionFormFill();
		masterForm.primarySection2FormFill();
		masterForm.primarySection3FormFill();
//		
		masterForm.saveButton();
		masterForm.finalizeMasterFormInEditPage();
		masterForm.dataSetValidationAfterCreationOfMasterForm();
		masterForm.metaDataValidationAfterCreationOfMasterForm();
		masterForm.masterFieldsAfterCreationOfMasterForm();
		masterForm.masterFilterAfterCreationOfMasterFields();
		masterForm.validationsAfterMasterFilterAndMasterFields();
		
	}
	
//	@Test(priority = 3)
//	public void verifyCreateMasterMenu() throws Throwable {
//		test = reports.createTest("verifyCreateMasterMenu");
//		
//		masterMenusPage.navigateToMasterMenus();
//		masterMenusPage.verifyCreateMasterMenuButton();
//		masterMenusPage.verifyMasterFormDropDown();
//		masterMenusPage.menuNameField();
//		masterMenusPage.masterMenuSaveButton();
//		
//	}
	

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