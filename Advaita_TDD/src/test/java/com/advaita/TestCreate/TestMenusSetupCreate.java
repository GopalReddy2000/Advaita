package com.advaita.TestCreate;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.MenuSetup.pageObject.Menusetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestMenusSetupCreate extends TestBase {

	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	Menusetup menusetup;

	public TestMenusSetupCreate() {
		super();

	}

	@BeforeTest
	public void setUp() throws Throwable {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterFormCreate.html");
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

		menusetup = new Menusetup(); // object creation with referenac of class

	}

	@Test(priority = 1)
	public void menusSetupTable() {

		menusetup.navigateTomenuSetup();

		// search
		//menusetup.searchByFormName();
		menusetup.searchByDefaultName();
		menusetup.SearchByDisplayName();

		// clearallFilter
		menusetup.cleatfilter();

	}

	@Test(priority = 2)
	public void menusSetupEdit() throws Throwable {

		// Edit
		menusetup.navigateTomenuSetup();
		menusetup.navigateToEditMenuSetup();

		menusetup.formNameEdit();

	}

	@Test(priority = 3)
	public void menusSetupEdit1() {

		// Edit
		menusetup.navigateTomenuSetup();
		menusetup.navigateToEditMenuSetup();

		menusetup.defautNameEdit();
	}

	@Test(priority = 4)
	public void menusSetupEdit2() {

		// Edit
		menusetup.navigateTomenuSetup();
		menusetup.navigateToEditMenuSetup();

		menusetup.displayNameEdit("dataSetup");

	}
}
