package com.advaita.TestCreate;

import static Advaita_TDD.Advaita_TDD.FakeData.lastName2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.ManualUpload;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ScreenShorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.App;
import Advaita_TDD.Advaita_TDD.Questions;

public class TestManualUpload extends TestBase {

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	DataSet dataset;
	ManualUpload manualUpload;

	App app;

	public TestManualUpload() {

		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ManualUpload Test.html");
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

		dataset = new DataSet();
		manualUpload = new ManualUpload();

		app = new App();

	}

	HomePage hp = new HomePage();

	@Test(priority = 1)
	public void verifyCreateManualUpload() throws Throwable {

		test = reports.createTest("verifyCreateManualUpload");
		homePage.clickOnProcessManagementCreate();
		
		ArrayList<String> labels = dataset.getLabelNamesFromProperties();

		final String manualUploadName = "EmployeeOne Details Upload";
		manualUpload.navigateToManualUpload().createNewManualUpload(manualUploadName)
				.formatDownloadAndUpdateAndUpload(labels, Questions.generateEmployeeQuestions(), 5)
				.fillOtherFildsForUploadedFile("Test Manual Upload");

	}

	@Test(priority = 2)
	public void setLtfs() {

		app.navToRecordToAuditForm("TW -Customer Visit Feedback form").auditForm("Lan", "James", "24", "Employed", "2",
				"1111");

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

	@Test(dataProvider = "invalidRecordNameData")
	public void name(String recordName,String errorMessage){
		manualUpload
				.navToManualUpload()
				.create().name(recordName).recordCreate()
				.nameError(errorMessage)
		;
	}

	@DataProvider(name = "invalidRecordNameData")
	public Object[][] invalidRecordNameData() {
		return new Object[][] {
				{"", "This field is required."},
				{"   ", "Record name cannot be just spaces."},
				{"a".repeat(258), "Record name cannot exceed 255 characters."},
				{"ƀ Ɓ Ƃ ƃ Ƅ ƅ Ɔ Ƈ ƈ Ɖ Ɗ Ƌ", "Record name cannot contain Unicode characters."},
				{"#Record$", "Record name cannot contain special characters."},
				{"123456", "Record name cannot be numeric only."},
				{"!!!@@@", "Record name cannot be only special characters."},
				{"SELECT * FROM records", "Invalid input detected."},
				{"<record>Test</record>", "Invalid input detected."},
				{"record    name", "Record name cannot contain consecutive spaces."},
				{"DemoEmpJ Details MetaData", "Metadata Name Already Exists"}
		};
	}

	String uploadSheet=System.getProperty("user.dir")+"/ExcelFiles/Synthetic_Test_Data.xlsx";
	String fileName="Synthetic_Test_Data.xlsx";

	@Test(dataProvider = "invalidRemarksTestData")
	public void invalidRemarks(String remarks,String error){
		manualUpload
				.navToManualUpload()
				.create().name(lastName2()+" ManualUpload")
				.datasetDropdown("Dataset AJP").uploadSheet(uploadSheet).remarksField(remarks).fileName(fileName)
				.create()
		;
//		No Error for Remarks Field
	}

	@Test
	public void invalidFileName(String fileName){
		manualUpload
				.navToManualUpload()
				.create().name(lastName2()+" ManualUpload")
				.datasetDropdown("Dataset AJP").uploadSheet(uploadSheet).remarksField("remarks").fileName(fileName)
				.create()
				;
//		No Proper Error Code for invalid FileName
	}

	@DataProvider(name = "invalidRemarksTestData")
	public static Object[][] negativeTestData() {
		return new Object[][]{
				// Only Spaces
				{"   ", "Input should be ignored or show an error message."},

				// Exceeding Character Limit (Assume max limit is 50)
				{"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", "Input exceeds max length of 50 characters."},

				// Special Characters
				{"@#$%^&*", "Special characters are not allowed."},

				// SQL Injection
				{"'; DROP TABLE users; --", "Invalid characters in input."},

				// Script Injection (XSS)
				{"<script>alert('XSS')</script>", "Invalid characters in input."},

				// Numeric Input (If Not Allowed)
				{"1234567890", "Numeric input is not valid."},

				// Non-ASCII or Unicode Characters
				{"你好", "Non-ASCII characters are not allowed."},
				{"😊", "Emojis are not allowed."},

				// Leading and Trailing Spaces
				{"  ValidInput", "Leading spaces should be trimmed or show an error message."},
				{"ValidInput  ", "Trailing spaces should be trimmed or show an error message."},

				// Single Character Input (if min length is 3)
				{"A", "Input must be at least 3 characters long."},

				// HTML Special Characters
				{"&<>'\"/", "HTML special characters are not allowed."},

				// Newline Characters
				{"Line1\nLine2", "Newline characters are not allowed."},

				// Extremely Long Input
				{"a".repeat(5000), "Input exceeds the maximum allowed length."}
		};
	}

	@AfterMethod
	public void close(){
		manualUpload.closeDialogBox();
	}

	@AfterTest
	public void tearDown() {

//		driver.manage().window().minimize();
//		driver.quit();
		reports.flush();
	}

}