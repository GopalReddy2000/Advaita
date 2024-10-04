package com.advaita.TestTable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.alchemyPageObject.CallLogSatgeView;
import com.advaita.alchemyPageObject.WhatsAppTemplate;
import com.advaita.pageObjects.CallLogTabView;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestCallLogStageView extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	public CallLogSatgeView CallLogStageView;

	public TestCallLogStageView() // constructor
	{
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

		CallLogStageView = new CallLogSatgeView();

	}

	@Test(priority = 1)
	public void SearchStages_table() {
		// search

		CallLogStageView.navigatetoStage();
		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.naivigateToCallLogStageView();
		
		CallLogStageView.verifyTheUserAbleselectAllOptionFromDropdown();
		
		CallLogStageView.ClearAllFilter(); //Clear all filter
		
		CallLogStageView.SelectStagesFromCallLogStagesViewDropdown();

//		CallLogStageView.logout();
//		CallLogStageView.userLogin();		
		CallLogStageView.itemperpage();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void selectInvalidOptionFromDropdownByVisibleText() {

		CallLogStageView.naivigateToCallLogStageView();
		CallLogStageView.selectInvalidValueFromDropdown();

	}

	@Test
	public void selectInvalidValueFromDropdownInCLSV() {
		CallLogStageView.naivigateToCallLogStageView();
		CallLogStageView.selectInvalidValueFromDropdown();

	}
	
	@Test
	public void verifysearchStageisSingleSingleSelectOrMultiselect() throws Throwable {
		
		
		CallLogStageView.naivigateToCallLogStageView();
		CallLogStageView.singleSlectOrMultiSelect();
		
	}
	@Test
	public void VerifytheuserDeselectinsearchStagesDropdowninCSLV() {
		CallLogStageView.naivigateToCallLogStageView();
		CallLogStageView.VerifytheuserDeselectinsearchStagesDropdowninCSLV();
	}
	
	
	@Test
	public void VerifyWithoutSelectProcessClickOnSearch() {
		
		CallLogStageView.VerifyWithoutSelectingStageClickOnSearch();
		
	}
	

	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}
