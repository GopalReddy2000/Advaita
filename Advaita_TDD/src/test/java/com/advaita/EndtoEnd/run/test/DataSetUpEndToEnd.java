package com.advaita.EndtoEnd.run.test;

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
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.ScreenShorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.Questions;

public class DataSetUpEndToEnd extends TestBase {

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MetaData metaData;
	DataSet dataset;
	ManualUpload manualUpload;

	public DataSetUpEndToEnd() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/DataSetUpEndToEnd.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for DataSetUp");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		metaData = new MetaData();
		dataset = new DataSet();
		manualUpload = new ManualUpload();

	}

	String employeeName = "EmployeeSeven";
	

	final String metaDataName = employeeName + " Details MetaData";
	final String manualUploadName = employeeName + " Details Upload";
	final String dataSetName = employeeName + " Details";
	final String remark = "Test Manual Upload";

//	@Test(priority = 1)
//	public void verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType() throws Throwable {
//		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType");
////		HomePage.clickOnProcessManagementCreate();
//
//		// Get all questions
//		List<Map<String, String>> allQuestions = Questions.generateEmployeeQuestions();
//		// Define the types and order of questions you want to select
//		// Character,Text Area,Date Time,Date,Number,Boolean,HyperLink
//		List<String> types = Arrays.asList("Character", "Text Area", "Number", "HyperLink");
//		// Select questions based on types and order
//		List<Map<String, String>> selectedQuestions = QuestionSelector.selectQuestions(allQuestions, types, 7, true);
//		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(selectedQuestions)
//				.createDataSetButtonAndConfirmation();
//
//	}
	
//	####################################################
	
	@Test(priority = 1)
	public void verifyManualCreateNewDataset() throws Throwable {
		test = reports.createTest("verifyCreateNewDataset");
		HomePage.clickOnProcessManagementCreate();

		//final String dataSetName = "Emplyee Details";
		// Data for multiple rows
		List<Map<String, String>> fieldData = List.of(
				Map.of("FieldName", "Employee Name ?", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"),
				Map.of("FieldName", "Employee ID ?", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"),
				Map.of("FieldName", " Emp Phone Number ?", "Type", "Number", "MaxLength", "14", "IsMandatory", "No"));
		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(fieldData)
				.createDataSetButtonAndConfirmation();

	}

	@Test(priority = 2)
	public void verifynewCreateMetaData() throws Throwable {

		test = reports.createTest("verifynewCreateMetaData");
		HomePage.clickOnProcessManagementCreate();

		metaData.navigateToMetaData().createNewMetaData(metaDataName).verifyCreateButtonAndConfirmation()
				.verifyCreatedMetaDataCheckUniqueIdAndRole(true, false)
				.verifySaveButtonAndConfirmationInUpadteMetaData().verifyExecuteUpadtedMetaData();

	}

	@Test(priority = 3)
	public void verifyCreateManualUpload() throws Throwable {

		test = reports.createTest("verifyCreateManualUpload");
		HomePage.clickOnProcessManagementCreate();

		manualUpload.navigateToManualUpload().createNewManualUpload(manualUploadName)
				.formatDownloadAndUpdateAndUpload(manualUpload.filteredItems, Questions.generateEmployeeQuestions(), 5)
				.fillOtherFildsForUploadedFile(remark).createButtonAndConfirmation()
				.valiadtionsAfterCreationOfManualUpload(dataSetName, manualUploadName, remark);

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