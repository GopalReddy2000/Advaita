package com.advaita.EndtoEnd.run.test;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ScreenShorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TEST_Advaita extends TestBase {

	FakeData fake = new FakeData();

	public String processName = "P " + fake.lastName1();
	public String processDesc = "S P " + fake.lastName1();
	public String subProcessName = "S S P " + fake.lastName1();
	public String subProcessDesc = "Edit P Desc";
	public String subSubProcessName = "Edit S P Desc";
	public String subSubProcessDesc = "Edit S S P Desc";

	public String dataSetName = fake.lastName1();

	public String metaDataName = "Test " + fake.lastName1();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	ProcessPage process;
	DataSet dataset;
	MetaData metaData;

	public TEST_Advaita() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Manu", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for Advaita");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		process = new ProcessPage();
		dataset = new DataSet();
		metaData = new MetaData();

	}

	@Test(priority = 1)
	public void verifyProcessCreate() throws Throwable {

		test = reports.createTest("verifyProcessCreate");
		homePage.clickOnProcessManagementCreate();
		process.createProcess(processName, processDesc, processName, subProcessName, subProcessDesc, subProcessName,
				subSubProcessName, subSubProcessDesc);
	}

	@Test(priority = 2)
	public void verifyProcessEdit() throws Throwable {

		test = reports.createTest("verifyProcessEdit");
		process.editCreatedProcess("Edit processDesc", "Edit subProcessDesc", "Edit subSubProcessDesc");

	}

	@Test(priority = 3)
	public void verifyProcessTable() throws Throwable {

		test = reports.createTest("verifyProcessTable");
		process.tablePage();

	}

	@Test(priority = 4)
	public void verifyCreateDataset() throws Throwable {

		test = reports.createTest("verifyCreateDataset");
		homePage.clickOnProcessManagementCreate();
		dataset.createDataSet("Text Area");

	}

	@Test(priority = 5)
	public void verifyEditDataset() throws Throwable {

		test = reports.createTest("verifyEditDataset");
//		homePage.clickOnProcessManagementCreate();
		dataset.editDataSet("Edit dataSetName");

	}

	@Test(priority = 6)
	public void verifydataSetTablePage() throws Throwable {

		test = reports.createTest("verifydataSetTablePage");
//		homePage.clickOnProcessManagementCreate();
		dataset.dataSetTablePage();
	}

	@Test(priority = 7)
	public void verifyCreateMetaData() throws Throwable {

		test = reports.createTest("verifyCreateMetaData");
		homePage.clickOnProcessManagementCreate();
		metaData.createMetaData(metaDataName);

	}

	@Test(priority = 8)
	public void verifyEditMetaData() throws Throwable {

		test = reports.createTest("verifyEditMetaData");
		homePage.clickOnProcessManagementCreate();
		metaData.editMetaData();

	}

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

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test passed successfully");

			// Add logs
			test.log(Status.INFO, "Execution time: " + (result.getEndMillis() - result.getStartMillis()) + "ms");
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