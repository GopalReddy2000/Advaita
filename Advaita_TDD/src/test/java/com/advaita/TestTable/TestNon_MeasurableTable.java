package com.advaita.TestTable;

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
import com.advaita.WorkFlowDesign.PageObject.NonMeasurableSetPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestNon_MeasurableTable extends TestBase {

	static int createCount = 2;

	// Faker faker = new Faker();
	// public String num = "24";
	// public String questionSet = faker.name().lastName() + " TestAudit";

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	NonMeasurableSetPage nonMeasurableSetPage;

	public TestNon_MeasurableTable() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/NonMeasurableTable.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "W2390");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("User", "James Paul R");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for Non-MeasurableSetPage");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		nonMeasurableSetPage = new NonMeasurableSetPage();
	}

	@Test
	public void testCommonNavigation() throws InterruptedException {
		nonMeasurableSetPage.multipleChoice();
	}

	@Test
	public void testShortAnswer() {
		nonMeasurableSetPage.shortAnswer();

	}

	@Test
	public void testquestionTypeDropDown() {
		nonMeasurableSetPage.questionTypeDropDown();

	}

	@Test
	public void testQuestionTypeRelativeDropdown() {
		nonMeasurableSetPage.questionTypeRelativeDropdown();
	}

	@Test
	public void testfileUpload() {
		nonMeasurableSetPage.fileUpload();
	}

	@Test
	public void testcreateNormalView() {
		nonMeasurableSetPage.createNormalView("Software Testing "+FakeData.lastName2());
		
	}
	
	@Test
	public void testcreateColumnView() {
		nonMeasurableSetPage.createColumnView();
		
	}
	
	
	@Test
	public void testisConditional() throws Throwable {
		nonMeasurableSetPage.isConditional();
		
	}
	
	
	
	

	@Test(priority = 1)
	public void verifyNonMeasurableSetTablePage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetTablePage");
		homePage.clickOnNonMeasurableSet();
		nonMeasurableSetPage.nonMeasurableSetTablePage();

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
		// CloseExtentReports
		reports.flush();
	}
	@Test
	public void testSms()
	{
		nonMeasurableSetPage.smsTemp();
	}

	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit(); 
		reports.flush();

	}

}