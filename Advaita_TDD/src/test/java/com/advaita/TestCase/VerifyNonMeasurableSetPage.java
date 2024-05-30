package com.advaita.TestCase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.NonMeasurableSetPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class VerifyNonMeasurableSetPage extends TestBase {

	static int createCount = 2;

//	Faker faker = new Faker();
//		public String num = "24";
//	public String questionSet = faker.name().lastName() + " TestAudit";

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	NonMeasurableSetPage nonMeasurableSetPage;

	public VerifyNonMeasurableSetPage() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita Non-MeasurableSetPage.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for Non-MeasurableSetPage");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		nonMeasurableSetPage = new NonMeasurableSetPage();
	}

	@Test(priority = 1)
	public void verifyNonMeasurableSetCreatePage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetCreatePage");
		homePage.clickOnNonMeasurableSet();
		nonMeasurableSetPage.nonMeasurableSetCreatePage(createCount);

	}

	@Test(priority = 2)
	public void verifyNonMeasurableSetEditePage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetEditPage");
		homePage.clickOnNonMeasurableSet();
		nonMeasurableSetPage.nonMeasurableSetEditPage();
	}
	
	@Test(priority = 3)
	public void verifyNonMeasurableSetTablePage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetTablePage");
		homePage.clickOnNonMeasurableSet();
		nonMeasurableSetPage.nonMeasurableSetTablePage();

	}



	@AfterTest
	public void tearDown() {

		driver.manage().window().minimize();
		driver.quit();
		reports.flush();

	}

}
