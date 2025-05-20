package com.advaita.EndtoEnd.run.test;

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
import com.advaita.Utilities.ScreenShorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.Questions;

public class DataSetUpEndToEnd extends TestBase {

	final static boolean processRun = true;
	final static boolean dataSetRun = true;
	final static boolean metaDataRun = true;
	final static boolean manualUploadRun = true;
	
	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MetaData metaData;
	DataSet dataset;
	ManualUpload manualUpload;

	ProcessPage process;

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

		process = new ProcessPage();
		metaData = new MetaData();
		dataset = new DataSet();
		manualUpload = new ManualUpload();

	}

	String employeeName = "EmployeeB";

	final String metaDataName = employeeName + " Details MetaData";
	final String manualUploadName = employeeName + " Details Upload";
	final String dataSetName = employeeName + " Details";
	final String remark = "Test Manual Upload";

	HomePage hp = new HomePage();

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

	@Test(priority = 2,enabled = dataSetRun)
	public void verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType() throws Throwable {
		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType");
//		HomePage.clickOnProcessManagementCreate();

		final String dataSetName = "Emplyee Details";
		// Data for multiple rows
		List<Map<String, String>> fieldData = List.of(
				Map.of("FieldName", "Employee Name ?", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"),
				Map.of("FieldName", "Employee ID ?", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"),
				Map.of("FieldName", " Emp Phone Number ?", "Type", "Number", "MaxLength", "14", "IsMandatory", "No"));
		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(fieldData)
				.createDataSetButtonAndConfirmation();

	}

	@Test(priority = 3,enabled = metaDataRun)
	public void verifynewCreateMetaData() throws Throwable {

		test = reports.createTest("verifynewCreateMetaData");
//		HomePage.clickOnProcessManagementCreate();

		PropertieFileUtil.storeSingleTextInPropertiesFile("metaData", metaDataName);
		metaData.navigateToMetaData().createNewMetaData(metaDataName).verifyCreateButtonAndConfirmation()
				.verifyCreatedMetaDataCheckUniqueIdAndRole(true, false)
				.verifySaveButtonAndConfirmationInUpadteMetaData().verifyExecuteUpadtedMetaData();

	}

	@Test(priority = 4,enabled = manualUploadRun)
	public void verifyCreateManualUpload() throws Throwable {

		test = reports.createTest("verifyCreateManualUpload");
		homePage.clickOnProcessManagementCreate();

		ArrayList<String> labels = dataset.getLabelNamesFromProperties();
		int addNumberOfRecord = 15;

		PropertieFileUtil.storeSingleTextInPropertiesFile("no.OfRecord", String.valueOf(addNumberOfRecord));
		manualUpload.navigateToManualUpload().createNewManualUpload(manualUploadName)
				.formatDownloadAndUpdateAndUpload(labels, Questions.generateEmployeeQuestions(), addNumberOfRecord)
				.fillOtherFildsForUploadedFile(remark).createButtonAndConfirmation()
				.valiadtionsAfterCreationOfManualUpload(dataSetName, manualUploadName, remark, addNumberOfRecord);

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
