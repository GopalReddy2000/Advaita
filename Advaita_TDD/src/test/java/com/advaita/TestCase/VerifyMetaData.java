package com.advaita.TestCase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

public class VerifyMetaData extends TestBase {
	
	Faker faker = new Faker();
	
	public String metaDataName = "Test "+faker.name().firstName();

//	public String num = "7";
//	public String metaDataName = "Test Single MetaData" + num;

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MetaData metaData;

	public VerifyMetaData() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita MetaData.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
		htmlReporter.config().setReportName("TEST Advaita-MetaData");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		
		metaData = new MetaData();

	}

	@Test(priority = 1)
	public void verifyCreateMetaData() throws Throwable {

		test = reports.createTest("verifyCreateMetaData");
		homePage.clickOnProcessManagementCreate();
		metaData.createMetaData(metaDataName);

	}
	
	@Test(priority = 2)
	public void verifyEditMetaData() throws Throwable {

		test = reports.createTest("verifyEditMetaData");
		homePage.clickOnProcessManagementCreate();
		metaData.editMetaData();

	}

	@AfterTest
	public void tearDown() {
//		driver.manage().window().minimize();
//		driver.quit();
//		reports.flush();
	}

}
