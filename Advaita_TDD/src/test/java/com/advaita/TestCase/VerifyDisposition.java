package com.advaita.TestCase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.Disposition;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class VerifyDisposition extends TestBase {

	static int createCount = 2;

//	Faker faker = new Faker();
//		public String num = "24";
//	public String questionSet = faker.name().lastName() + " TestAudit";

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	Disposition disposition;

	public VerifyDisposition() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Manu", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita DispositionPage.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for DispositionPage");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		disposition = new Disposition();

	}

	@Test(priority = 1)
	public void verifyDispositionCreatePage() throws Throwable {

		test = reports.createTest("verifyDispositionCreatePage");
		homePage.clickOnDisposition();
		disposition.dispositionCreatePage(createCount);

	}

	@Test(priority = 2)
	public void verifyDispositionEditPage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetTablePage");
		homePage.clickOnDisposition();
		disposition.dispositionEditPage();

	}

	@Test(priority = 3)
	public void verifyDispositionTablePage() throws Throwable {

		test = reports.createTest("verifyDispositionTablePage");
		homePage.clickOnDisposition();
		disposition.dispositionTablePage();
	}

	@AfterTest
	public void tearDown() {

		driver.manage().window().minimize();
		driver.quit();
		reports.flush();

	}

}
