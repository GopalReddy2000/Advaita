package com.advaita.TestTable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.alchemyPageObject.CallLogSatgeView;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.datafaker.Faker;

public class TestCallLogStageView extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	public CallLogSatgeView callLogStageView;

	public TestCallLogStageView() // constructor
	{
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		// homePage = loginPage.login("Capture_admin", "Qwerty@123");
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterFormCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

//		// Configuration to change look and feel
//		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
//		htmlReporter.config().setReportName("TEST Advaita-MetaData");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTimelineEnabled(true);
//		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		callLogStageView = new CallLogSatgeView();

		// Extract from Propery File
		String stage = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");

	}

	@Test(priority = 1, enabled = true)
	public void SearchStages_table() throws Throwable {

		callLogStageView.navigatetoStage();
		callLogStageView.fetchStageNameList();
		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();

		// CallLogStageView.SelectStagesFromCallLogStagesViewDropdown(); // Needto
		// implememnt in This Method (itemperpage)
		// after fixed

//		callLogStageView.logout();
//		callLogStageView.userLogin();
//		callLogStageView.itemperpage();
	}

	@Test(priority = 2, enabled = true, dependsOnMethods = { "SearchStages_table" })
	public void verifyTheUserIsableToSelectStageFromCallLogStageViewPage() throws Throwable {

		callLogStageView.verifyTheUserIsAbleToselectOptionsFromStageDropdownAndVerify();
	}

	@Test(priority = 3, enabled = true, dependsOnMethods = "SearchStages_table")
	public void verifyTheUSerIsABleTOselectRandomValueFromSearchStageDropdown() {

		callLogStageView.selectRandomValueFromSearchStageDropdown();
	}

	@Test(priority = 4, enabled = true, dependsOnMethods = { "SearchStages_table" })
	public void verifyTheUserIsAbleToclearFilter() {

		callLogStageView.ClearAllFilter(); // Clear all filter
	}

	@Test(priority = 5, enabled = true, dependsOnMethods = "SearchStages_table")
	public void verifyTheUserIsAbleToSelectAllTheOptionsFromSearchStageDropdown() {

		callLogStageView.verifyTheUserAbleselectAllOptionFromDropdown();
	}

	@Test(priority = 6, enabled = true, dependsOnMethods = "SearchStages_table")
	public void verifyTheUserIsAbleTocheckAnyDispositionHappenInThatparticularSatges() throws Throwable {

		callLogStageView.verifyAnyDisposityHappenenINThatSelectedSelectedStage();
	}

	// ################################## Negative ########################

	@Test(enabled = true, dependsOnMethods = "verifyTheUserIsAbleToclearFilter")
	public void selectInvalidOptionFromDropdownByVisibleText() {

		callLogStageView.selectInvalidOptionFromSearchStageDropdown();

	}

	@Test(enabled = true)
	public void selectInvalidValueFromDropdownInCLSV() {
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.selectInvalidOptionFromSearchStageDropdown();

	}

	@Test(enabled = true)
	public void verifysearchStageisSingleSingleSelectOrMultiselect() throws Throwable {

		callLogStageView.navigateToCallLogStageView();
		callLogStageView.singleSlectOrMultiSelect();

	}

	@Test(enabled = true)
	public void VerifytheuserDeselectinsearchStagesDropdowninCSLV() {
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.VerifytheuserDeselectinsearchStagesDropdowninCSLV();
	}

	@Test(enabled = true)
	public void VerifyWithoutSelectProcessClickOnSearch() {

		callLogStageView.VerifyWithoutSelectingStageClickOnSearch();

	}

	@Test(enabled = true)
	public void EndToEndCallLogStageView() {
		callLogStageView.navigatetoStage();
		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.verifyTheUserAbleselectAllOptionFromDropdown();
	}

	// <============== Stages Actions

	// <======= stage Evaluation Fields
	String transUniqueId = "Trans Unique Id";

	// <========static Evaluation Fields / Filters
	String staticEvlauationFields[] = { "ToPerson", "AllocatedBy", "TicketId", "CreatedOn", "AllocationMethod",
			"AllocatedOn", "AllocationId", "IsAllocated", "CreatedBy", "SampleGroupId", "SamplingTo", "IsActive",
			"CaseId", "SamplingType", "StageId", "CaseId", "IsSkipped", "AuditStatus", "AuditedBy", "AuditedOn" };

	String stageHistoryFiels[] = { "ansUniqueId", "stageName", "submittedBy", "submittedDateTime", "Trans Unique Id",
			"block_name", "Review,dispositionType", "AssignTo,Ticket_Status", "To Stage Name", "Name",
			"Audit_Started_On", "AllocationMethod", "ScheduleTo", "ScheduleDate", "ScheduleStartTime",
			"ScheduleEndTime", "ScheduleReason", "Latitude", "Longitude", "TicketId", "Fatal_Status", "ScorableValue",
			"ScoredValue", "AuditScore", "submittedrolid", "Audit_Created_By", "DeletedStatus,Deleted_By", "Deleted_On",
			"level1_submittedBy", "level1_submittedRole", "isEscalationCycleComplete", "isEscalationDone",
			"dispositionBy,dispositionByRole", "escalatedLevel", "escalationDispositionAnswerId",
			"escalationDisposition", "stageTransactionId", "dataTableID", "recording_id", "_id", "evaluationID",
			"stageID", "processID", "subProcessID", "subSubProcess" };

	// Delete
	@Test(enabled = true)
	public void verifyTheUserIsAbleToDeleteTheDeleteTheSatgesAndCheckItIsnOtDispalyedInCSVSearchStagesDrodpown() {
		callLogStageView.navigatetoStage();
		callLogStageView.deleteStage();

	}

	// Dulpicate Stage
	@Test(enabled = true)
	public void VerifyuserisAbleTOCreateDulicateStageAndThisStageShouldShouldbeDisplayedInCallLogStageView() {

		callLogStageView.navigatetoStage();
		callLogStageView.userisAbleTOCreateDulicateStageAndThisStageShouldShouldbeDisplayedInCallLogStageView();
	}

	// Edit Stages
	@Test(enabled = true)
	public void verifyUserCanEditStageNameAndSeeItInCSVSearchDropdown() {

		callLogStageView.navigatetoStage();
		callLogStageView.userCanEditStageNameAndSeeInCSVSearchDropdown();
		callLogStageView.searchStage("Student Information Stages");

	}

	// Evaluation Field
	@Test(enabled = true)
	public void verifyTheUserIsAbleToAddEvaluationFireldsAndViewdInCallLogStageViewPage() {
		// CallLogStageView.userIsAbleToAddStageEvaluationFieldsAndViewdInCallLogStageViewPage();
		callLogStageView.navigatetoStage();
		callLogStageView.searchStage("Student Information Stages");
		callLogStageView.CaptureSearchedStageText();

		callLogStageView.SelectValuesFromDropdowns(callLogStageView.evaluationFieldOptions,
				callLogStageView.verifyStagesEvaluationElement, callLogStageView.leftAllButton,
				callLogStageView.stagesEvaluationFieldDropdown, callLogStageView.RightSelectedButton,
				"Trans Unique Id");

		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.fetchSearchDropdownValues();
		callLogStageView.selectStagesAndChecAddedkEvaluationFieldInCallLogStageView("Trans Unique Id");

	}

	@Test(enabled = true)
	public void verifyTheUserIsAbleToAddStaticEvaluationFireldsAndViewdInCallLogStageViewPage() { // need ti update
																									// after fixed
		callLogStageView.navigatetoStage();
		callLogStageView.searchStage("Student Information Stages");
		callLogStageView.CaptureSearchedStageText();

		callLogStageView.SelectValuesFromDropdowns(callLogStageView.evaluationFieldOptions,
				callLogStageView.verifyStaticEvaluationElement,
				callLogStageView.leftAllButtonStaticEvaluationStageField,
				callLogStageView.staticEvaluationFieldDropdown,
				callLogStageView.rightSelectedButtonStaticEvaluationStageField, "TicketId");

		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.fetchSearchDropdownValues();
		callLogStageView.selectStagesAndChecAddedkEvaluationFieldInCallLogStageView("TicketId");

	}

	// Filter
	@Test(enabled = true)
	public void verifyTheUserIsAddFiltersAndViewdInCallLogStageViewPage() {

		callLogStageView.navigatetoStage();
		callLogStageView.searchStage("Student Information Stages");
		callLogStageView.CaptureSearchedStageText();

		callLogStageView.SelectValuesFromDropdowns(callLogStageView.evaluationFilterActionsOptions,
				callLogStageView.dropdwonLabelElement, callLogStageView.leftAllButton, callLogStageView.dropdownElement,
				callLogStageView.RightSelectedButton, "Trans Unique Id");
		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.selectStagesAndCheckAddedkFiltersAreDisplayedInCallLogStageView("Trans Unique Id");
	}

	// Stage History Field
	@Test(enabled = true)
	public void verifyTheUserIsAddStageHistoryFiledsAndViewdInAuditPage() {

		callLogStageView.navigatetoStage();
		callLogStageView.searchStage("Student Information Stages");
		callLogStageView.CaptureSearchedStageText();

		callLogStageView.SelectValuesFromDropdowns(callLogStageView.stagesHistoryFieldsOptions,
				callLogStageView.verifyHistoryFileds, callLogStageView.leftAllButton,
				callLogStageView.historyFieldsDropdwon, callLogStageView.RightSelectedButton, "Trans Unique Id");
		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.selectStagesAndCheckAddedkstageHistoryFieldAreDisplayedInCallLogStageView("Trans Unique Id");
	}

	@Test(enabled = true)
	public void verifyTheUserIsAddStageuniqueFiledsAndViewdInAuditPage() { // need to Update after Fixed

		callLogStageView.navigatetoStage();
		callLogStageView.searchStage("Student Information Stages");
		callLogStageView.CaptureSearchedStageText();

		callLogStageView.SelectValuesFromDropdowns(callLogStageView.stagesHistoryFieldsOptions,
				callLogStageView.verifyUniuqeFields, callLogStageView.leftAllButtonForUniqueFileds,
				callLogStageView.uniqueFieldsDropdwon, callLogStageView.RightSelectedButtonForUniqueFileds,
				"Trans Unique Id");
		callLogStageView.navigateTo_AlchemyModule();
		callLogStageView.navigateToCallLogStageView();
		callLogStageView.selectStagesAndCheckAddedkstageHistoryFieldAreDisplayedInCallLogStageView("Trans Unique Id");
	}

	@Test(enabled = true)
	public void verifyTheUserIsAbleToDoActionsAndCheckInCSVEndToEnd() {

		VerifyuserisAbleTOCreateDulicateStageAndThisStageShouldShouldbeDisplayedInCallLogStageView();
		verifyUserCanEditStageNameAndSeeItInCSVSearchDropdown();
		verifyTheUserIsAbleToAddEvaluationFireldsAndViewdInCallLogStageViewPage();
		// verifyTheUserIsAbleToAddStaticEvaluationFireldsAndViewdInCallLogStageViewPage();
		verifyTheUserIsAddFiltersAndViewdInCallLogStageViewPage();
		verifyTheUserIsAddStageHistoryFiledsAndViewdInAuditPage();
		// verifyTheUserIsAddStageuniqueFiledsAndViewdInAuditPage();

	}

	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}
