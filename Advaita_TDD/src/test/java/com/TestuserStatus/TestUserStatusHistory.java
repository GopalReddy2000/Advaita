package com.TestuserStatus;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.UserStatus.pageobject.UserStatus;
import com.advaita.UserStatus.pageobject.UserStatusHistory;
import com.advaita.pageObjects.UserSetupPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestUserStatusHistory extends TestBase {

	// useRaName
	public String userName = "Capture_admin";
	public String password = "Qwerty@123";

	Faker faker = new Faker();
	FakeData fake = new FakeData();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	UserStatus userStatus;
	UserSetupPage userSetupPage;
	UserStatusHistory userStatusHistory;

	public TestUserStatusHistory() throws Exception {
		super();

	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");
//		homePage = loginPage.login(userName, password);
		userSetupPage = new UserSetupPage();

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterFormCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

//		// Configuration to change look and feel
//		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
//		htmlReporter.config().setReportName("TEST Advaita-MetaData");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTimelineEnabled(true);
//		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		userStatus = new UserStatus();
		userStatusHistory = new UserStatusHistory();

	}

	// Test Methods

	@Test
	public void verifyTheUserIsAbleToNavigateUserStatusHistory() {

		userStatusHistory.navigateToUserStatusHistoryandVerify();

	}

}
