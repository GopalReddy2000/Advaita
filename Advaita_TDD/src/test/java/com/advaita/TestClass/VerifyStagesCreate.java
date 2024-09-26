package com.advaita.TestClass;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.DataSetUp.PageObject.Process;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ScreenShorts;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;

public class VerifyStagesCreate extends TestBase {

	FakeData fake = new FakeData();

	public String processName = "P " + fake.lastName1();
	public String processDesc = "P Desc";
	public String subProcessName = "SP" + fake.lastName1();
	public String subProcessDesc = "SP Desc";
	public String subSubProcessName = "SSP " + fake.lastName1();
	public String subSubProcessDesc = "SSP Desc";

	public String metaDataName = "Test " + fake.lastName1();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	Process process;
	DataSet dataset;
	MetaData metaData;

	Stages stages;

	public VerifyStagesCreate() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/Stages extentReport.html");
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

		process = new Process();
		dataset = new DataSet();
		metaData = new MetaData();

		stages = new Stages();
	}

//    @Test(priority = 1)
//    public void verifyProcessCreate() throws Throwable {
//        test = reports.createTest("verifyProcessCreate");
//        homePage.clickOnProcessManagementCreate();
//        process.createProcess(processName, processDesc, processName, subProcessName, subProcessDesc, subProcessName,
//                subSubProcessName, subSubProcessDesc);
//    }
//
//    @Test(priority = 2)
//    public void verifyCreateDataset() throws Throwable {
//        test = reports.createTest("verifyCreateDataset");
//        homePage.clickOnProcessManagementCreate();
//        dataset.createDataSet("Test Field Name", "Test Label Name", "100", "Text Area");
//    }
//
//    @Test(priority = 3)
//    public void verifyCreateMetaData() throws Throwable {
//        test = reports.createTest("verifyCreateMetaData");
//        homePage.clickOnProcessManagementCreate();
//        metaData.createMetaData(metaDataName);
//    }

	@Test(priority = 4)
	public void navigateFetchRecord() throws Throwable {
		test = reports.createTest("clickOnworkflowDesign");
		homePage.clickOnworkflowDesign();

		test = reports.createTest("navigateFetchProcessRecord");
		stages.navigateFetchProcessRecord(true);
	}

	@Test(priority = 5)
	public void VerifyStagesTabIsDisplayed() throws Throwable {
		test = reports.createTest("VerifyStagesTabIsDisplayed");
		stages.VerifyStagesTabIsDisplayed(false,true);
	}

	@Test(priority = 6)
	public void verifyCreateStagesButton() throws Throwable {
		test = reports.createTest("verifyCreateStagesButton");
		stages.verifyCreateStagesButton();
	}

	@Test(priority = 7)
	public void verifyStageNameTextBox() throws Throwable {
		test = reports.createTest("verifyStageNameTextBox");
		stages.verifyStageNameTextBox(fake.firstCapString());
	}

	@Test(priority = 8)
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
		stages.verifyAddSectionA();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException, Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Mark the test as failed in the ExtentReports
			test.fail(result.getThrowable());
			// Add screenshot to ExtentReports
			String screenshotPath = ScreenShorts.captureScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotPath);
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
