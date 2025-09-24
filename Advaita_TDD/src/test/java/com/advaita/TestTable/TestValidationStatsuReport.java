package com.advaita.TestTable;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.alchemyPageObject.ValidationStatusReport;
import com.advaita.pageObjects.StagesActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.datafaker.Faker;

public class TestValidationStatsuReport extends TestBase {

	Faker faker = new Faker();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;
	ValidationStatusReport validationStatusReport;
	StagesActions stagesActions;

	public TestValidationStatsuReport() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

//		 htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
//		 "/Reports/MetaDataCreate.html");
//		reports = new ExtentReports();
//		reports.attachReporter(htmlReporter);

		// add environment details
//		reports.setSystemInfo("Machine", "Testpc1");
//		reports.setSystemInfo("OS", "Windows 11");
//		reports.setSystemInfo("user", "Gopal");
//		reports.setSystemInfo("Browser", "Chrome");
//
//		// Configuration to change look and feel
//		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
//		// htmlReporter.config().setReportName("TEST Advaita-MetaData");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTimelineEnabled(true);
//		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		validationStatusReport = new ValidationStatusReport();
		stagesActions = new StagesActions();

	}

	// Test Methods

	@Test
	public void verifyTheUserIsAbleToNavigte() {

		validationStatusReport.navigateToValidationStatusReportAndVerify();

	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNavigte" })
	public void verifyTheUserIsAbleToSearchManuallySelectingProcesandStages() throws Throwable {

		validationStatusReport.selectProcess("givenprocessname");
		validationStatusReport.selectSubProcess("givenSubprocessname");
		validationStatusReport.selectSubSubProcess("givensubsubprocessname");
		validationStatusReport.selectStages("givenStageName");
		validationStatusReport.fromDate("manual", validationStatusReport.fromDate);
		validationStatusReport.toDate("manual", validationStatusReport.toDate);
		validationStatusReport.clickOnSearchButtonAndVefiy();

	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNavigte",
			"verifyTheUserIsAbleToSearchManuallySelectingProcesandStages" })
	public void verifyTheUserIsABleToviewTheAuditedDate() throws IOException {

		validationStatusReport.viewValidationStatusReport();

	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNavigte" })
	public void verifyTheUserIsAbleToSearchRandomely() throws Throwable {

		validationStatusReport.selectProcess("randomprocess");
		validationStatusReport.selectSubProcess("randomSubprocess");
		validationStatusReport.selectSubSubProcess("randomSubSubprocess");
		validationStatusReport.selectStages("randomStage");
		validationStatusReport.fromDate("getRandomDate", validationStatusReport.fromDate);
		validationStatusReport.toDate("getRandomDate", validationStatusReport.fromDate);
		validationStatusReport.clickOnSearchButtonAndVefiy();

	}

	@Test(dependsOnMethods = "verifyTheUserIsAbleToSearchManuallySelectingProcesandStages")
	public void verifyTheUSerIsAbleToExportRport() {

		validationStatusReport.exportReport();
	}

	// @AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		// reports.flush();
	}
}
