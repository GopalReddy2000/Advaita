package com.advaita.TestCase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

public class VerifyDataSet extends TestBase {
	
	Faker faker = new Faker();
//	public String num = "24";
//	public String dataSetName = "Test Single Data Set" + num;
	
	public final String dataSetName = faker.name().lastName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	DataSet dataset;

	public VerifyDataSet() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita DataSet.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for DataSet");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		dataset = new DataSet();

	}

//	@Test(priority = 1)
//	public void verifyCreateDataset() throws Throwable {
//
//		test = reports.createTest("verifyCreateDataset");
//		homePage.clickOnProcessManagementCreate();
//		dataset.createDataSet("Test Field Name", "Test Label Name", "100", "Text Area");
//
//	}
//
//	@Test(priority = 2)
//	public void verifyEditDataset() throws Throwable {
//
//		test = reports.createTest("verifyEditDataset");
////		homePage.clickOnProcessManagementCreate();
//		dataset.editDataSet("Edit dataSetName");
//	}

	@Test(priority = 3)
	public void verifydataSetTablePage() throws Throwable {

		test = reports.createTest("verifydataSetTablePage");
//		homePage.clickOnProcessManagementCreate();
		dataset.dataSetTablePage();
	}
	@Test()
	public void delDataset()
	{
		homePage.clickOnProcessManagementCreate();
		dataset.deleteDataSet();
	}

	@AfterTest
	public void tearDown() {
		
		driver.manage().window().minimize();                                       
		driver.quit();
		reports.flush();
		
	}

}
