package com.TestApiKeySetup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ApiKeySetup.pageObject.ApiKeySetup;
import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

public class TestApiKeySetup extends TestBase {

	Faker faker = new Faker();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	ApiKeySetup apiKeySetup;

	public TestApiKeySetup() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		// htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
		// "/Reports/MetaDataCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

//		hp = new HomePage();
		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
		// htmlReporter.config().setReportName("TEST Advaita-MetaData");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		apiKeySetup = new ApiKeySetup();

	}

	@Test
	public void verifyTheUserIsAbleToCreateNaviagtePage() {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.naviagteToCreate();

	}

	@AfterMethod
	public void tearDown() {
//		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}
