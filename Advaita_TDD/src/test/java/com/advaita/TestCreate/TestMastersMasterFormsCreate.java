package com.advaita.TestCreate;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.MastersMastersforms;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.datafaker.Faker;

public class TestMastersMasterFormsCreate extends TestBase {

	Faker faker = new Faker();
	
	FakeData fakeData = new FakeData(); 

	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	MastersMastersforms mastersforms;

	public TestMastersMasterFormsCreate() {
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

		mastersforms = new MastersMastersforms();

	}

//	######################################################################################

	@Test
	public void CreateMasterforms(  ) throws Throwable 
	{	
	
		mastersforms.navigateFetchProcessRecord();
		mastersforms.navigateFetchSubProcessRecord();
		mastersforms.navigateFetchSubSubProcessRecord();
		mastersforms.Fetch_FieldSets();
		mastersforms.FetchQuestions_fieldsets();
		
		homePage.clickOnworkflowDesign();
		mastersforms.ClickOnMasterTab();
		mastersforms.verifyMasterFormsTab();
		mastersforms.VerifyTheUSerIsableToCreateMasterForms(fakeData.lastName1(),"primaryDetails","abhijit","btm");
		
		
	}

	
	
	
	
	
	@AfterTest
	public void tearDown() 
	{		
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
