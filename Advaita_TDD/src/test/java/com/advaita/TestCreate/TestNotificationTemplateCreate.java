package com.advaita.TestCreate;

import java.security.PublicKey;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.alchemyPageObject.CallLogSatgeView;
import com.advaita.alchemyPageObject.NotificationTemplate;
import com.advaita.alchemyPageObject.WhatsAppTemplate;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestNotificationTemplateCreate extends TestBase
{
	Faker faker = new Faker();
	FakeData fake=new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;
	
//	 NotificationTemplate notificationtemplate;
		private NotificationTemplate notificationTemplate;

		public TestNotificationTemplateCreate()
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
			
			notificationTemplate=new NotificationTemplate();
		}	
		
		@Test(priority = 1)
		public void NotificationTemplateCreate() throws Throwable 
		{
			notificationTemplate.NavigateToProcess();  //fetch process
			notificationTemplate.FetchMetaData();
			notificationTemplate.FetchStages();
			notificationTemplate.navigateTo_AlchemyModule();
			notificationTemplate.NavigateToNotificationtemplate();
			notificationTemplate.CreateNotificationTemplate();
			notificationTemplate.logoutFromAdmin();
			notificationTemplate.loginAsUserCrediantials();
			notificationTemplate.sendNotifcation();
			notificationTemplate.TimeSelection();
			notificationTemplate.DateSelection();
			notificationTemplate.DispostionManualOutsideProcess();
		//	notificationTemplate.DispostionManualWithinProcess();
			
			
			
//			//Table
//			notificationTemplate.SearchThroughProcesses();
//			notificationTemplate.ClearllFilters();
//			notificationTemplate.searchThroughSearchfield();
//			notificationTemplate.SearchThroughSatges();
//			
//			EDIT
//			notificationTemplate.EditNotificationTemplate();
			
//			Delete
//			notificationTemplate.DeleteNotificationTemplate();
			
		}
		//@Test(priority = 2)
		public void notificationTemplateTable() 
		{
			notificationTemplate.SearchThroughProcesses();
			notificationTemplate.ClearllFilters();
			notificationTemplate.searchThroughSearchfield();
			notificationTemplate.SearchThroughSatges();
		
		}
		
		//@Test(priority = 3)
		public void notificationTemplateEdit() 
		{
			notificationTemplate.EditNotificationTemplate();
		}
		
		//@Test(priority = 4)
		public void NotificationTemplateDelete() 
		{
			notificationTemplate.EditNotificationTemplate();
		}
		
		
		
		
		
//		@AfterTest
//		public void tearDown() 
//		{		
//			driver.manage().window().minimize();
//			driver.quit();
//			reports.flush();
//		}
}
