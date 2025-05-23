package com.advaita.TestClass;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;

public class VerifyProcess extends TestBase {

	FakeData fake = new FakeData();

	public String processName = "Test " + fake.lastName1();
	public String processDesc = "Test Desc " + fake.lastName1();
	public String subProcessName = "Test " + fake.lastName1();
	public String subProcessDesc = "Test Desc" + fake.lastName1();
	public String subSubProcessName = "Test " + fake.lastName1();
	public String subSubProcessDesc = "Test Desc" + fake.lastName1();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	ProcessPage process;

	public VerifyProcess() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita Process.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for Process");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	
		process = new ProcessPage();
	
	}

	@Test(priority = 1)
	public void verifyProcessCreate() throws Throwable {

		test = reports.createTest("verifyProcessCreate");
		homePage.clickOnProcessManagementCreate();
		process.createProcess1(processName, processDesc);
		process.createSubProcess(subProcessDesc, processDesc);
		process.createSubSubProcess(subSubProcessName, subSubProcessDesc);
		
		

//		process.createProcess(processName, 
//				processDesc, 
//				processName, 
//				subProcessName, 
//				subProcessDesc, 
//				subProcessName, 
//				subSubProcessName, 
//				subSubProcessDesc);
	}

	@Test(priority = 2)
	public void verifyProcessEdit() throws Throwable {
		homePage.clickOnProcessManagementCreate();
		test = reports.createTest("verifyProcessEdit");
//		process.editCreatedProcess("Edit processDesc", "Edit subProcessDesc", "Edit subSubProcessDesc");
//		process.EditProcess(processName);
//		process.EditSubProcess(subProcessName, subProcessDesc);
//		process.EditSubsubProcess(subSubProcessName, subSubProcessDesc);

	}

	@Test(priority = 3)
	public void verifyProcessTable() throws Throwable {

		
		test = reports.createTest("verifyProcessTable");
		homePage.clickOnProcessManagementCreate();           //clickOnProcessManagementCreate change to datasetup
//	process.tablePage(3);
//		process.TablePage1();
//		process.clearfilter_tablePage();
//		process.clickonProcessDropDownToacessSubList_Tablepage();
//		process.clickonProcessDropDownAgainSubprocessDropdownToacessSubSubList_Tablepage();
//		process.createdprocessNotificatedByclickingBellIcon();
//	    process.HowmuchCreatedprocess();	
//		process.SearchCreatedProcesbySelctingStatus_Active();
//		process.SearchCreatedProcesbySelctingStatus_InAnctive();
//		process.NavigateToNextTablePageClick_Rightarrow();
//		process.NavigateToNextTablePageClick_leftarrow();

		test = reports.createTest("verifyProcessTable");
		process.tablePage();
		

	}

	
	
	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}
