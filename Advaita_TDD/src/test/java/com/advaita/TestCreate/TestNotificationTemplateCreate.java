package com.advaita.TestCreate;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.advaita.alchemyPageObject.NotificationTemplate;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.datafaker.Faker;

public class TestNotificationTemplateCreate extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

//	 NotificationTemplate notificationtemplate;
	public NotificationTemplate notificationTemplate;

	public TestNotificationTemplateCreate() {
		super();

	}

	Stages stages = new Stages();

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

		notificationTemplate = new NotificationTemplate();
	}

	@Test(priority = 1)
	public void NotificationTemplateCreate() throws Throwable {

		notificationTemplate.NavigateToProcess(); // fetch process
		notificationTemplate.FetchMetaData();
		notificationTemplate.FetchStages();
		notificationTemplate.navigateTo_AlchemyModule();
		notificationTemplate.NavigateToNotificationtemplate();
		notificationTemplate.createNotification();
		notificationTemplate.selectProcessFromNotitficationTemplate();
		notificationTemplate.selectSubProcessFromNotitficationTemplate();
		notificationTemplate.selectSubsubProcessFromNotitficationTemplate();
		notificationTemplate.selectStagesFromNotitficationTemplate();
		notificationTemplate.selectTemplateName();
		notificationTemplate.selectNotificationDateAndTime();
		notificationTemplate.messageTextfield();
		notificationTemplate.remarksTextfield();
		notificationTemplate.clickONCreateAndVerifyPopUp();
		notificationTemplate.verifyCreatedNotificationTemplate();

		notificationTemplate.logoutFromAdmin();
		notificationTemplate.loginAsUserCrediantials();
		notificationTemplate.sendNotifcation();
		notificationTemplate.TimeSelection();
		notificationTemplate.DateSelection();
		notificationTemplate.DispostionManualOutsideProcess();
		notificationTemplate.DispostionManualWithinProcess();

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

	// @Test(priority = 2)
	public void notificationTemplateTable() {
		notificationTemplate.SearchThroughProcesses();
		notificationTemplate.ClearllFilters();
		notificationTemplate.searchThroughSearchfield();
		notificationTemplate.SearchThroughSatges();

	}

	// @Test(priority = 3)
	public void notificationTemplateEdit() {
		notificationTemplate.EditNotificationTemplate();
	}

	// @Test(priority = 4)
	public void NotificationTemplateDelete() {
		notificationTemplate.EditNotificationTemplate();
	}

	@Test
	public void xyz() throws Throwable {
//		// notificationTemplate.NavigateToProcess(); // fetch process

//		notificationTemplate.FetchMetaData();
		notificationTemplate.FetchStages();

//		// notificationTemplate.verifyCreateNonMeasurable();
//		notificationTemplate.verifyForAddedNotificationSectionInStagesEdit();

		notificationTemplate.navigateTo_AlchemyModule();
		notificationTemplate.NavigateToNotificationtemplate();
		notificationTemplate.createNotification();
		notificationTemplate.selectProcessFromNotitficationTemplate();
		notificationTemplate.selectSubProcessFromNotitficationTemplate();
		notificationTemplate.selectSubsubProcessFromNotitficationTemplate();
		notificationTemplate.selectStagesFromNotitficationTemplate();
		notificationTemplate.selectTemplateName();
		notificationTemplate.selectNotificationDateAndTime();
		notificationTemplate.messageTextfield();
		notificationTemplate.remarksTextfield();
		notificationTemplate.clickONCreateAndVerifyPopUp();
		notificationTemplate.verifyCreatedNotificationTemplate();


	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//CreateDataset,Metadata,manualUpload ,Stage Creation

	@Test
	public void EntireProcess() throws Throwable {

		notificationTemplate.cretaeDataset();
		notificationTemplate.createMetadata();
		notificationTemplate.manualUpload();

		notificationTemplate.verifyCreateNonMeasurable();
	}

	@Test
	public void stagesCreation() throws Throwable {

		notificationTemplate.stagesCreation();
		notificationTemplate.VerifyAddSectionInStages();
		notificationTemplate.verifyActionSectionStages();
		notificationTemplate.selectDisplositionStages();
		notificationTemplate.saveAndContinue();

	}
/////////////////////////////////// Negative Testing /////////////////////////////////////////////////////////////////////////	


	@Test(priority = 5)
	public void VerifyWithoutDispositionNotificationDate() throws Throwable {

		notificationTemplate.WithoutDispositionNotificationDate();

	}

	@Test
	public void verifyWithoutSelectingAnyFiledTryToCreateTemplate() throws Throwable {

		notificationTemplate.withoutSelectingAnyFiledTryToCreateTemplate();

	}

	@Test
	public void VerifywithoutSelectingProcessAndCreate() throws Throwable {
		notificationTemplate.withoutSelectingProcessAndCreate();
	}

	@Test
	public void verifyWithoutselectingStagesMnadatorydropdown() throws Throwable {
		notificationTemplate.WithoutselectingStagesMnadatorydropdown();
	}

	@Test
	public void verifyCreateNotificationWithoutSelectingNonMandatoryFieldsame() throws Throwable {

		notificationTemplate.createNotificationWithoutSelectingNonMandatoryFields();

	}

	@Test
	public void verifyCreateTemplateNameWithSpecialChracter() throws Throwable {
		notificationTemplate.saveCreteTemplateWithSpecialChracter();
	}

	@Test
	public void verifyCreateTemplateThroughWithEmojis() throws Throwable {
		notificationTemplate.createTemplateThroughEmojis();
	}

	@Test
	public void verifyCharacterLimit() throws Throwable {
		notificationTemplate.characterLimitTextfield();
	}

	@Test
	public void verifySearchInvalidCreatedNamesInSearchField() throws Throwable {
		notificationTemplate.searchInvalidCreatedNamesInSearchField();
	}

	@Test
	public void VrifysearchThroughEmojiInSearchField() throws Throwable {
		notificationTemplate.searchThroughEmojiInSearchField();
	}
	
	@Test
	public void verifyTheUserSearchThroughSpacesInSearchTextfield() throws Throwable { // Nedd to implement after Fixed
		notificationTemplate.searchThroughSpacesInSearchTextfield();
	}
	
	@Test
	public void verifySelectInvalidProcessesAndSearch() throws Throwable {
		notificationTemplate.selectInvalidProcessesAndSearch();
	}
	
	@Test
	public void searchThroughProcessInSearchTextfield() throws Throwable {
		notificationTemplate.searchThroughProcessInSearchTextfield();
		
	}

	// @AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
