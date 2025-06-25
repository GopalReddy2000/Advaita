package com.advaita.TestCreate;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.Disposition;
import com.advaita.WorkFlowDesign.PageObject.MastersFieldSets;
import com.advaita.alchemyPageObject.SmsTemplate;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.datafaker.Faker;

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

	@Test(priority = 1, enabled = true)
	public void CreateSmsTemplate() throws Throwable {
		// smstemplate.NavigateToFetchprocess();
		// smstemplate.navigatetoStage_verifySMS();
//		// smstemplate.navigateTo_AlchemyModule(); //"DontOpen"
		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.CreateSmstemplate();
		smstemplate.selectProcess();
		smstemplate.SelectSubProcess();
		smstemplate.selectSubSubProcess();
		smstemplate.selectStages();
		smstemplate.selectApiName();
		smstemplate.SmsTemplateName();
		smstemplate.disposition();
		smstemplate.fromNumber();
		smstemplate.selectToNumberSource();
		smstemplate.toNumber();
		smstemplate.message();
		smstemplate.remarksField();
		smstemplate.variables();
		smstemplate.selectStageField();
		smstemplate.EnterDefaultValue();

		verifyTheUserIsAbleTOaddMutipleRows();
		verifyTheUserIsableTOdeleteRows();

		// smstemplate.createButtonAndVerifySuccessPopupAndContinue();

		// smstemplate.userManagement_create("wyzmindz_solutions", "wyzmindz",
		// "solutions"); //old one
//		smstemplate.userManagement_create();
//		smstemplate.userMapping();
//		smstemplate.logoutAmdin();
		// smstemplate.loginas_UserCredentials();

	}

	@Test(priority = 3, enabled = true)
	public void verifyTheUserIsAbleTOaddMutipleRows() {

		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.CreateSmstemplate();
		smstemplate.addMultipleRows(5);

	}

	@Test(priority = 4, enabled = true)
	public void verifyTheUserIsableTOdeleteRows() {
		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.CreateSmstemplate();
		smstemplate.addMultipleRows(5);
		smstemplate.deleteMultipleRows(4);

	}

	@Test(priority = 2, enabled = true)
	public void verifyTheCreatedSmsTemplate() throws Throwable {

		CreateSmsTemplate();
		smstemplate.verifyCreatedSmsTemplate();
	}

	// Edit
	@Test(priority = 5, enabled = true)
	public void verifyTheUserisAbletoeditSmsTemplate() throws Throwable {

		smstemplate.Edit_smsTemplated();
	}

	// Table
	@Test(priority = 6, enabled = true)
	public void verifyTheUSerIsableTosearchThroughProcss() throws Throwable {

		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.searchThroughProcess();
		smstemplate.clickOnSearchButton();

		smstemplate.verifyselectedProcessShouldMatchWithProcess();

	}

	@Test(priority = 7, enabled = true)
	public void verifyTheUSerIsableTosearchThroughSubProcss() throws Throwable {

		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.searchThroughProcess();
		smstemplate.searchThroughSubProcess();
		smstemplate.clickOnSearchButton();

		smstemplate.verifyselectedSubProcessShouldMatchWithSubProcess();

	}

	@Test(priority = 8, enabled = true)
	public void verifyTheUSerIsableTosearchThroughSubSubProcss() throws Throwable {

		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.searchThroughProcess();
		smstemplate.searchThroughSubProcess();
		smstemplate.searchThroughSubSubProcess();
		smstemplate.clickOnSearchButton();

		smstemplate.verifyselectedSubSubProcessShouldMatchWithSubSubProcess();

	}

	@Test(priority = 9, enabled = true)
	public void verifyTheUSerIsableTosearchThroughStages() throws Throwable {

		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.searchThroughProcess();
		smstemplate.searchThroughSubProcess();
		smstemplate.searchThroughSubSubProcess();
		smstemplate.clickOnSearchButton();
		smstemplate.searchThroughStages();

		smstemplate.verifyselectedSubSubProcessShouldMatchWithStages();

	}

	@Test(priority = 10, enabled = true)
	public void searchTroughTemplatenameOnSearchTextfield() throws Throwable {

		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.searchThroughSeachTextfield();
	}

	@Test(priority = 11, enabled = true)
	public void verifyTheUSerisAbleToClearFilters() {

		smstemplate.ClearFilters();
	}

	@Test(priority = 12, enabled = true)
	public void DeleteSmsTempaleAndVerifyTheDeletedOne() {

		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.Delete_createdSmsTemplate();
	}

	public void endToEndSMSThroughStageField() throws Throwable {

		smstemplate.navigatetoStage_verifySMS();
		smstemplate.navigateto_SmsTemplateTab();
		smstemplate.userManagement_create();
		smstemplate.userMapping();

	}

	// Auto Sms_Mapping
	@Test
	public void Disposition() throws Throwable {

		smstemplate.createDispositionQuestionSet();// Create Disposition
		smstemplate.verifyDispositionQuestionSet(); // verify Created Question Set_Disposition

		// smstemplate.navigatetoStage_verifySMS();

		smstemplate.stagesDispositionClick(); // Search stages and Do Disposition Mapping
		smstemplate.selectProcesses();
		smstemplate.selectStagesDisposition();
		smstemplate.selectDispositionQuestionSet();
		smstemplate.selectFormName();
		smstemplate.clickAndsaveOnDispositionMapingPage();

		// smstemplate.VeriftTheUserIsAbleToDoAutoSMSMapping();
		smstemplate.naviagteToAutoSmsMappingAndAddSmstemplate();
		// smstemplate.selectSmsTemplateAndClickOnAddForAutoSMSMapping();
	}

	@Test
	public void autoSMSMapping() throws Throwable {
		verifyTheUserIsAbalToDoAutoSMSMapping();
	}

	// Auto SMS Mapping
	@Test
	public void verifyTheUserIsAbalToDoAutoSMSMapping() throws Throwable {

		smstemplate.naviagteToAutoSmsMappingAndAddSmstemplate();
	}

//------------------------- Negative Testing--------------------------------- (Pending)

	@Test
	public void verifyWithoutSelectingAnyFieldAndCrete() {
		smstemplate.withoutSelectingAnyFieldAndCrete();
	}

	@Test
	public void verifyWithoutSelectingStagesAndCreate() throws Throwable {

		smstemplate.withoutSelectingStagesAndCreate();
	}

	@Test
	public void verifyWithoutEnterTemplateNameAndCreate() throws Throwable {
		smstemplate.withoutEnterTemplateNameAndCreate();

	}

	@Test
	public void verifyWithoutEnterFromNumberOtionAndCreate() throws Throwable {
		smstemplate.withoutEnterFromNumberOtionAndCreate();
	}

	@Test
	public void verifWithoutSelectToNumberOtionAndCreate() throws Throwable {
		smstemplate.withoutSelectToNumberOtionAndCreate();
	}

	@Test
	public void verifyEnterCharacterInNumberFielTextfielddAndCreate() throws Throwable {
		smstemplate.enterCharacterInNumberFielTextfielddAndCreate();
	}

	@Test
	public void verifyWithoutEnterMessageNameAndCreate() throws Throwable {
		smstemplate.withoutEnterMessageNameAndCreate();
	}

	@Test
	public void verifyCreateTemplateNameWithSpecialChracter() throws Throwable { // Need To implement
		smstemplate.createTemplteThroughSpecialCharacter();
	}

	@Test
	public void verifyEnterEmojisInTemplateNameAndCreate() throws Throwable {
		smstemplate.enterEmojisInTemplateNameAndCreate();
	}

	@Test
	public void VerifyEnterEmojisInDispositionAndCreate() throws Throwable {
		smstemplate.enterEmojisInDispositionAndCreate();
	}

	@Test
	public void verifyEnterEmojisInMessageTextfieldAndCreate() throws Throwable {
		smstemplate.enterEmojisInMessageTextfieldAndCreate();
	}

	@Test
	public void verifyEnterLessThanDigitLimitAndCreate() throws Throwable {
		smstemplate.enterLessThanDigitLimitAndCreate();
	}

	@Test
	public void verifyAndChecktheCharcterLimitForTemplateNameAndCreate() throws Throwable { // Need to implement
		smstemplate.checktheCharcterLimitForTemplateNameAndCreate();
	}

	@Test
	public void verifyChecktheCharcterLimitForDispositionTExtfieldAndCreate() throws Throwable { // Need to implement
		smstemplate.checktheCharcterLimitForDispositionTextfieldAndCreate();
	}

	@Test
	public void searchThroughSpacesInSearchTextfield() throws Throwable { // Need to implement
		smstemplate.searchThroughSpacesInSearchTextfield();

	}

	@Test
	public void verifySearchThroughEmojisInSearchTextfield() throws Throwable {

		smstemplate.searchThroughEmojisInSearchTextfield();

	}

	@Test
	public void verifySearchInvalidCreatedTemplatesInSearchField() throws Throwable {
		smstemplate.searchInvalidCreatedTemplatesInSearchField();
	}

	@Test
	public void verifyTheUserSearchThroughProcessInSearchTextfield() throws Throwable {
		smstemplate.searchThroughProcessInSearchTextfield();

	}

	@Test
	public void verifyTheuserSearchThroughSubprocessInSearchTextfield() throws Throwable {
		smstemplate.searchThroughSubprocessInSearchTextfield();
	}

	@Test
	public void verifyTheuserSearchThroughSubsubprocessInSearchTextfield() throws Throwable {
		smstemplate.searchThroughSubsubprocessInSearchTextfield();

	}

	@Test
	public void verifyTheuserSearchThroughStagesInSearchTextfield() throws Throwable {
		smstemplate.searchThroughStagesInSearchTextfield();
	}

	@Test
	public void withoutSelectingAnyOptionsIAndsearch() throws Throwable {
		smstemplate.withoutSelectingAnyOptionsIAndsearch();
	}

	@Test
	public void verifySelectinginvalidProcessandStagesWhichDoesnotHaveAnyCreatedTemplate() throws Throwable { // need to
																												// implement
		smstemplate.selectinginvalidProcessandStagesWhichDoesnotHaveAnyCreatedTemplate();
	}

	@Test
	public void verifyDisableShowSmshistoryAndCheckItIsVisibleOrNot() throws InterruptedException {
		smstemplate.disableShowSmshistoryAndCheckVisibleOrNot();

	}

	@Test
	public void disableSmsActionsAndCheckItIsVisibleOrNot() throws InterruptedException {
		smstemplate.disableSmsActionsAndCheckItIsVisibleOrNot();
	}

//	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}