package com.advaita.TestCase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.MasterParameterMeasurableSetPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class VerifyMeasurableSet extends TestBase {

	static int createCount = 1;

//	Faker faker = new Faker();
//		public String num = "24";
//	public String questionSet = faker.name().lastName() + " TestAudit";

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MasterParameterMeasurableSetPage measurableSetPage;

	public VerifyMeasurableSet() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Manu", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita MeasurableSetPage.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MeasurableSetPage");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		measurableSetPage = new MasterParameterMeasurableSetPage();
	}

//	@Test(priority = 1)
//	public void verifyMeasurableSetCreatePage() throws Throwable {
//		
//		test = reports.createTest("verifyMeasurableSetCreatePage");
//		homePage.clickOnworkflowDesign();
//		measurableSetPage.createMeasurableSet(createCount);
//		
//	}

	@Test(priority = 2)
	public void verifyMeasurableSetTablePage() throws Throwable {

		test = reports.createTest("verifyMeasurableSetTablePage");
		homePage.clickOnworkflowDesign();
		measurableSetPage.tablePageOfMeasurableSet();

	}

	@Test(priority = 3)
	public void verifyMeasurableSetEditePage() throws Throwable {

		test = reports.createTest("verifyMeasurableSetEditPage");
		homePage.clickOnEditMeasurableSet();
		measurableSetPage.editPageOfMeasurableSet();
	}

	@AfterTest
	public void tearDown() {

//		driver.manage().window().minimize();                                       
//		driver.quit();
		reports.flush();

	}

}
