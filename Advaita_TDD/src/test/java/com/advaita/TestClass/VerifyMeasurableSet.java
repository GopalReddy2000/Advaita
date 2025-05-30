package com.advaita.TestClass;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.MeasurableSetPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

	MeasurableSetPage measurableSetPage;

	public VerifyMeasurableSet() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita MeasurableSetPage.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "James Paul R");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MeasurableSetPage");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		measurableSetPage = new MeasurableSetPage();
	}

	@Test(priority = 1)
	public void verifyMeasurableSetCreatePage() throws Throwable {
		
		test = reports.createTest("verifyMeasurableSetCreatePage");
		homePage.clickOnworkflowDesign();

	}
	@Test
	public void measurable()
	{
		measurableSetPage
				.NavToMeasurableTablePage()
				.createQuestionSetName("ShortAnswer")
				.shortAnswer(shortAnswer,
						1,
						1,
						"shortAnswer",
						"no",
						"yes",
						"1",
						"250",
						"All",
						"no")

		;
	}
	final int label=1;
	final int multipleChoice=2;
	final int shortAnswer=3;
	final int dropDown=4;
	final int relativeDropdown=5;
	final int fileUpload=6;
	final int radioButton=7;
	final int date=8;
	final int time=9;
	final int textBox=10;
	final int relativeMultiselect=11;



	@AfterTest
	public void tearDown() {

		driver.manage().window().minimize();                                       
		driver.quit();
		reports.flush();

	}

}
