package com.advaita.TestCreate;

import org.openqa.selenium.logging.NeedsLocalLogs;
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

public class TestWhatsappTemplateCreate extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	//WhatsAppTemplate whatsAppTemplate;
	 WhatsAppTemplate whatsapptemplate;

	public TestWhatsappTemplateCreate() {
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

		whatsapptemplate = new WhatsAppTemplate();

	}

	@Test
	public void whatsAppTemplateCreateEndToEnd() throws Throwable {
		// create WhatsApp
		whatsapptemplate.NavigateToFetchprocess();
		whatsapptemplate.navigatetoStage_verifyWhatsApp();
		whatsapptemplate.navigateTo_AlchemyModule();
		whatsapptemplate.navigateto_WhatsAppTemplateTab();
		whatsapptemplate.CreateWhatsApptemplate();
		whatsapptemplate.SelectProcessDropdown();
		whatsapptemplate.SelectSubProcessDropdown();
		whatsapptemplate.selectSubSubProcessDropdown();
		whatsapptemplate.selectStages();
//		whatsapptemplate.CreateWhatsappTemplateContinue();
//		// whatsapptemplate.userManagement();
//		// whatsapptemplate.userMapping();
//		// whatsapptemplate.SystemName_create();
//		whatsapptemplate.loginas_UserCredentials();

		// whatsapptemplate.SendSmsThroughBusinessWhatsapp(); //WhatsApp Busineess

		// table
		whatsapptemplate.searchThroughProcesses();
		whatsapptemplate.ClearFilters();
		whatsapptemplate.SearchThroughSearchField();
		whatsapptemplate.SelectItemPerPAge();

	}

	@Test
	public void createWhatsAppTemplate() throws Throwable {

		whatsapptemplate.NavigateToFetchprocess();
		whatsapptemplate.navigatetoStage_verifyWhatsApp();
		whatsapptemplate.navigateTo_AlchemyModule();
		whatsapptemplate.navigateto_WhatsAppTemplateTab();
		whatsapptemplate.CreateWhatsApptemplate();
		whatsapptemplate.SelectProcessDropdown();
		whatsapptemplate.SelectSubProcessDropdown();
		whatsapptemplate.selectSubSubProcessDropdown();
		whatsapptemplate.selectStages();
		whatsapptemplate.templateName();
		whatsapptemplate.disposition();
		whatsapptemplate.fromNumber();
		whatsapptemplate.toNumber();
		whatsapptemplate.messageTextfield();
		whatsapptemplate.remarksTextfield();
		whatsapptemplate.createConformation();
		whatsapptemplate.verifyCreatedWhatsAppTemplate();
	}

////////////////////////////////////////////NEGATIVE TESTING ///////////////////////////////////////////////////////////////////

	@Test
	public void verifyWithoutSelectingAnyFieldAndCrete() {
		whatsapptemplate.withoutSelectingAnyFieldAndCrete();
	}

	@Test
	public void verifyWithoutSelectingStagesAndCreate() {
		whatsapptemplate.withoutSelectingAnyFieldAndCrete();

	}

	@Test
	public void verifyWithoutEnterTemplateNameAndCreate() throws Throwable {
		whatsapptemplate.withoutEnterTemplateNameAndCreate();
	}

	@Test
	public void withoutEnterFromNumberOtionAndCreate() throws Throwable {
		whatsapptemplate.withoutEnterFromNumberOtionAndCreate();
	}

	@Test
	public void verifyWithoutSelectToNumberOtionAndCreate() throws Throwable {
		whatsapptemplate.withoutSelectToNumberOtionAndCreate();
	}

	@Test
	public void verifyWithoutEnterMessageNameAndCreate() throws Throwable {
		whatsapptemplate.withoutEnterMessageNameAndCreate();
	}

	@Test
	public void enterCharacterInNumberFielTextfielddAndCreate() throws Throwable {
		whatsapptemplate.enterCharacterInNumberFielTextfielddAndCreate();
	}

	@Test
	public void createTemplteThroughSpecialCharacter() throws Throwable { // Need to implement after fix
		whatsapptemplate.createTemplteThroughSpecialCharacter();
	}

	@Test
	public void verifyCreateTemplateThroughEmojis() throws Throwable {
		whatsapptemplate.enterEmojisInTemplateNameAndCreate();
	}

	@Test
	public void verifyEnterEmojisInDispositionAndCreate() throws Throwable {
		whatsapptemplate.enterEmojisInDispositionAndCreate();
	}

	@Test
	public void enterEmojisInMessageTextfieldAndCreate() throws Throwable {
		whatsapptemplate.enterEmojisInMessageTextfieldAndCreate();
	}

	@Test
	public void verifyEnterLessThanDigitLimitAndCreate() throws Throwable {
		whatsapptemplate.enterLessThanDigitLimitAndCreate();
	}

	@Test
	public void checktheCharcterLimitForTemplateNameAndCreate() throws Throwable { // Need to implement after fix
		whatsapptemplate.checktheCharcterLimitForTemplateNameAndCreate();
	}

	@Test
	public void verifyChecktheCharcterLimitForDispositionTextfieldAndCreate() throws Throwable {
		whatsapptemplate.checktheCharcterLimitForDispositionTextfieldAndCreate();

	}

	@Test
	public void verifyTheUsersearchThroughSpacesInSearchTextfield() {

		whatsapptemplate.searchThroughSpacesInSearchTextfield();

	}

	@Test
	public void searchThroughEmojisInSearchTextfield() throws Throwable {
		whatsapptemplate.searchThroughEmojisInSearchTextfield();
	}

	@Test
	public void searchInvalidCreatedTemplatesInSearchField() {
		whatsapptemplate.searchInvalidCreatedTemplatesInSearchField();

	}

	@Test
	public void withoutSelectingAnyOptionsIAndsearch() {
		whatsapptemplate.withoutSelectingAnyOptionsIAndsearch();
	}
	
	@Test
	public void searchThroughProcessesInSearchTextfield() throws Throwable {
		whatsapptemplate.searchThroughProcessesInSearchTextfield();
		
	}
	
	@Test
	public void searchThroughStagesInSearchTextfield() {
		whatsapptemplate.searchThroughStagesInSearchTextfield();
		
	}

	@Test
	public void verifySelectinginvalidProcessandStagesWhichDoesnotHaveAnyCreatedTemplateUTILITY() { // need to implement
		whatsapptemplate.selectinginvalidProcessandStagesWhichDoesnotHaveAnyCreatedTemplate();
	}

	@Test
	public void verifyDisableShowWhatsApphistoryAndCheckVisibleOrNot() throws InterruptedException {

		whatsapptemplate.disableShowWhatsApphistoryAndCheckVisibleOrNot();
	}

	@Test
	public void verifyDisableWhatsAppActionsAndCheckItIsVisibleOrNot() throws InterruptedException {
		whatsapptemplate.disableWhatsAppActionsAndCheckItIsVisibleOrNot();
		driver.navigate().back();
	}

	// @AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
