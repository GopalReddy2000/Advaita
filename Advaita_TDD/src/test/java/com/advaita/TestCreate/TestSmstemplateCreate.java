package com.advaita.TestCreate;

import java.security.PublicKey;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.MastersMastersforms;
import com.advaita.alchemyPageObject.SmsTemplate;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class TestSmstemplateCreate extends TestBase
{
	Faker faker = new Faker();
	FakeData fake=new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	 SmsTemplate smstemplate;

	public TestSmstemplateCreate() {
		super();
		
	}
	

	@BeforeTest
	public void setUp() throws Throwable 
	{
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
		
		smstemplate=new SmsTemplate();
		
		
}
	@Test
	public void CreateSmsTemplate() throws Throwable 
	{
		smstemplate.NavigateToFetchprocess();
		
		smstemplate.navigatetoStage_verifySMS();
		smstemplate.navigateTo_AlchemyModule(); //"DontOpen"
		smstemplate.navigateto_SmsTemplateTab();
//		smstemplate.CreateSmstemplate();
//		smstemplate.selectProcessDropdown();
//		smstemplate.SelectSubProcessDropdown();
//		smstemplate.selectSubSubProcess();
//		smstemplate.selectStages();
//		smstemplate.CreateSmsTemplateContinue();
//		smstemplate.userManagement_create("wyzmindz_solutions", "wyzmindz", "solutions");
//		smstemplate.userMapping();
//		smstemplate.SystemName_create();
//		smstemplate.loginas_UserCredentials();
		
//		//table
//		smstemplate.searchThrough_processes();
//		smstemplate.ClearFilters();
//		smstemplate.SearchThroughSearchField();
//		//smstemplate.Delete_createdSmsTemplate();
//		
//		//edit
		//smstemplate.Edit_smsTemplated();
		
		
	}
	
}