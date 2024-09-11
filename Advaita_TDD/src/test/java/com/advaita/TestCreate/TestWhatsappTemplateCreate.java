package com.advaita.TestCreate;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.alchemyPageObject.WhatsAppTemplate;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestWhatsappTemplateCreate extends TestBase 
{	
	Faker faker = new Faker();
	FakeData fake=new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	 WhatsAppTemplate whatsAppTemplate;
	private WhatsAppTemplate whatsapptemplate;

	public TestWhatsappTemplateCreate() 
	{
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
		
		whatsapptemplate=new WhatsAppTemplate();
		
	}
	
	
	
	
	@Test
	public void whatsAppTemplateCreate() throws Throwable 
	{
		//create WhatsApp
//		whatsapptemplate.NavigateToFetchprocess();
//		whatsapptemplate.navigatetoStage_verifyWhatsApp();
//		whatsapptemplate.navigateTo_AlchemyModule();
//		whatsapptemplate.navigateto_WhatsAppTemplateTab();
//		whatsapptemplate.CreateWhatsApptemplate();
//		whatsapptemplate.SelectProcessDropdown();
//		whatsapptemplate.SelectSubProcessDropdown();
//		whatsapptemplate.selectSubSubProcessDropdown();
//		whatsapptemplate.selectStages();
//		whatsapptemplate.CreateWhatsappTemplateContinue();
//		whatsapptemplate.userManagement();
//		whatsapptemplate.userMapping();
//		whatsapptemplate.SystemName_create();
//		whatsapptemplate.loginas_UserCredentials();
		
		//whatsapptemplate.SendSmsThroughBusinessWhatsapp();           //WhatsApp Busineess
		
		//table
		whatsapptemplate.searchThroughProcesses();
		whatsapptemplate.ClearFilters();
		whatsapptemplate.SearchThroughSearchField();
		whatsapptemplate.SelectItemPerPAge();
	
		//Edit
		
	}
	
	@AfterTest
	public void tearDown() 
	{		
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}	
	