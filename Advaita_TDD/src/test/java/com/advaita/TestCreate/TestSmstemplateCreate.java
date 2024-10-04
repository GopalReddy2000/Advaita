package com.advaita.TestCreate;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.WorkFlowDesign.PageObject.Disposition;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.alchemyPageObject.SmsTemplate;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestSmstemplateCreate extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;
	MastersFieldSets masterFieldSet;
	SmsTemplate smstemplate;
	Disposition disposition;

	public TestSmstemplateCreate() {
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

		smstemplate = new SmsTemplate();
		masterFieldSet = new MastersFieldSets();
		disposition = new Disposition();

	}

	@Test
	public void CreateSmsTemplate() throws Throwable {
		smstemplate.NavigateToFetchprocess();

		smstemplate.navigatetoStage_verifySMS();
		// smstemplate.navigateTo_AlchemyModule(); //"DontOpen"
		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.CreateSmstemplate();
		smstemplate.selectProcessDropdown();
		smstemplate.SelectSubProcessDropdown();
		smstemplate.selectSubSubProcess();
		smstemplate.selectStages();
		smstemplate.SmsTemplateName();
		smstemplate.disposition();
		smstemplate.fromNumber();
		smstemplate.selectToNumberSource();
		smstemplate.toNumber();
		smstemplate.enterMessage();
		smstemplate.remarksField();
		smstemplate.variables();
		smstemplate.createButton();
		// smstemplate.verifyCreatedMessage();
		// smstemplate.userManagement_create("wyzmindz_solutions", "wyzmindz", "solutions"); //old one
//		smstemplate.userManagement_create();
//		smstemplate.userMapping();
//		smstemplate.logoutAmdin();
		// smstemplate.loginas_UserCredentials();

		// table
//		smstemplate.searchThrough_processes();
//		smstemplate.ClearFilters();
//		smstemplate.SearchThroughSearchField();
//		//smstemplate.Delete_createdSmsTemplate();
//		

		// edit
		// smstemplate.Edit_smsTemplated();

	}

	public void endToEndSMSThroughStageField() throws Throwable {

		smstemplate.navigatetoStage_verifySMS();
		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.userManagement_create();
		smstemplate.userMapping();

	}

	@Test(priority = 2)
	public void endToEndSMSThroughSystemName() throws Throwable {
		// smstemplate.SystemName_create();

		smstemplate.NavigateToFetchprocess();
		smstemplate.navigatetoStage_verifySMS();
		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.CreateSmstemplate();
		smstemplate.selectProcessDropdown();
		smstemplate.SelectSubProcessDropdown();
		smstemplate.selectSubSubProcess();
		smstemplate.selectStages();
		smstemplate.SmsTemplateName();
		smstemplate.disposition();
		smstemplate.fromNumber();
		smstemplate.toNumberSourceSystemNames();
		smstemplate.toNumberSystemNames();
		smstemplate.enterMessage();
		smstemplate.remarksField();
		smstemplate.createButton();

	}
//Auto Sms 
	@Test
	public void Disposition() throws Throwable {
		verifyAddFormFieldSetInCreateFieldSet(); //CreateDisposition
		smstemplate.verifyCreatedDispositionQuestionset();
		smstemplate.navigatetoStage_verifySMS();
		smstemplate.stagesDispositionClick();
		smstemplate.selectSearchProcesses();
		smstemplate.selectStagesDisposition();
		smstemplate.selectDispositionQuestionSet();
		
		smstemplate.saveStagesDisposition();
		smstemplate.VeriftTheUserIsAbleToDoAutoSMSMapping();
		smstemplate.addAutoSmsMapping();
	}

	public void verifyAddFormFieldSetInCreateFieldSet() throws Throwable {

		homePage.clickOnDisposition();

		String questionSetNameString = "Employee Status";
		masterFieldSet.verifyEnterQuestionSetName(questionSetNameString);

		// Drop Down
		List<String> sector = Arrays.asList("Pending", "complete", "under process");
		masterFieldSet.addQuestions(0).addDropDownRelatedQuestions("What is the current status of the employee ?", 1, // Section
				1, // Question
				MastersFieldSets.DROP_DOWN, sector);

		disposition.saveRecord();
			
	}
	
	public void autoSMSMapping() throws Throwable {
		smstemplate.VeriftTheUserIsAbleToDoAutoSMSMapping();
		smstemplate.addAutoSmsMapping();
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
	


}