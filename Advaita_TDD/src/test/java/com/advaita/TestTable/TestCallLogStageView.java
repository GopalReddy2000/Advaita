package com.advaita.TestTable;

import javax.swing.text.Utilities;

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
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

public class TestCallLogStageView extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	public CallLogSatgeView CallLogStageView;

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

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
		htmlReporter.config().setReportName("TEST Advaita-MetaData");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		CallLogStageView = new CallLogSatgeView();

		// Extract from Propery File
		String stage = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");

	}

	@Test(priority = 1)
	public void SearchStages_table() {

		CallLogStageView.navigatetoStage();
		CallLogStageView.fetchStageNameList();
		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.navigateToCallLogStageView();

		CallLogStageView.verifyTheUserAbleselectAllOptionFromDropdown();

		CallLogStageView.ClearAllFilter(); // Clear all filter

		CallLogStageView.SelectStagesFromCallLogStagesViewDropdown(); // Needto implememnt in This Method (itemperpage)
																		// after fixed

//		CallLogStageView.logout();
//		CallLogStageView.userLogin();		
		CallLogStageView.itemperpage();
	}

	// ################################## Negative ########################

	@Test
	public void selectInvalidOptionFromDropdownByVisibleText() {

		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.selectInvalidValueFromDropdown();

	}

	@Test
	public void selectInvalidValueFromDropdownInCLSV() {
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.selectInvalidValueFromDropdown();

	}

	@Test
	public void verifysearchStageisSingleSingleSelectOrMultiselect() throws Throwable {

		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.singleSlectOrMultiSelect();

	}

	@Test
	public void VerifytheuserDeselectinsearchStagesDropdowninCSLV() {
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.VerifytheuserDeselectinsearchStagesDropdowninCSLV();
	}

	@Test
	public void VerifyWithoutSelectProcessClickOnSearch() {

		CallLogStageView.VerifyWithoutSelectingStageClickOnSearch();

	}

	@Test
	public void EndToEndCallLogStageView() {
		CallLogStageView.navigatetoStage();
		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.verifyTheUserAbleselectAllOptionFromDropdown();
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
	@Test
	public void verifyTheUserIsAbleToDeleteTheDeleteTheSatgesAndCheckItIsnOtDispalyedInCSVSearchStagesDrodpown() {
		CallLogStageView.navigatetoStage();
		CallLogStageView.deleteStage();

	}

	// Dulpicate Stage
	@Test
	public void VerifyuserisAbleTOCreateDulicateStageAndThisStageShouldShouldbeDisplayedInCallLogStageView() {

		CallLogStageView.navigatetoStage();
		CallLogStageView.userisAbleTOCreateDulicateStageAndThisStageShouldShouldbeDisplayedInCallLogStageView();
	}

	// Edit Stages
	@Test
	public void verifyUserCanEditStageNameAndSeeItInCSVSearchDropdown() {

		CallLogStageView.navigatetoStage();
		CallLogStageView.userCanEditStageNameAndSeeInCSVSearchDropdown();
		CallLogStageView.searchStage("Student Information Stages");

	}

	// Evaluation Field
	@Test
	public void verifyTheUserIsAbleToAddEvaluationFireldsAndViewdInCallLogStageViewPage() {
		// CallLogStageView.userIsAbleToAddStageEvaluationFieldsAndViewdInCallLogStageViewPage();
		CallLogStageView.navigatetoStage();
		CallLogStageView.searchStage("Student Information Stages");
		CallLogStageView.CaptureSearchedStageText();

		CallLogStageView.SelectValuesFromDropdowns(CallLogStageView.evaluationFieldOptions,
				CallLogStageView.verifyStagesEvaluationElement, CallLogStageView.leftAllButton,
				CallLogStageView.stagesEvaluationFieldDropdown, CallLogStageView.RightSelectedButton,
				"Trans Unique Id");

		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.fetchSearchDropdownValues();
		CallLogStageView.selectStagesAndChecAddedkEvaluationFieldInCallLogStageView("Trans Unique Id");

	}

	@Test
	public void verifyTheUserIsAbleToAddStaticEvaluationFireldsAndViewdInCallLogStageViewPage() { // need ti update
																									// after fixed
		CallLogStageView.navigatetoStage();
		CallLogStageView.searchStage("Student Information Stages");
		CallLogStageView.CaptureSearchedStageText();

		CallLogStageView.SelectValuesFromDropdowns(CallLogStageView.evaluationFieldOptions,
				CallLogStageView.verifyStaticEvaluationElement,
				CallLogStageView.leftAllButtonStaticEvaluationStageField,
				CallLogStageView.staticEvaluationFieldDropdown,
				CallLogStageView.rightSelectedButtonStaticEvaluationStageField, "TicketId");

		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.fetchSearchDropdownValues();
		CallLogStageView.selectStagesAndChecAddedkEvaluationFieldInCallLogStageView("TicketId");

	}

	// Filter
	@Test
	public void verifyTheUserIsAddFiltersAndViewdInCallLogStageViewPage() {

		CallLogStageView.navigatetoStage();
		CallLogStageView.searchStage("Student Information Stages");
		CallLogStageView.CaptureSearchedStageText();

		CallLogStageView.SelectValuesFromDropdowns(CallLogStageView.evaluationFilterActionsOptions,
				CallLogStageView.dropdwonLabelElement, CallLogStageView.leftAllButton, CallLogStageView.dropdownElement,
				CallLogStageView.RightSelectedButton, "Trans Unique Id");
		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.selectStagesAndCheckAddedkFiltersAreDisplayedInCallLogStageView("Trans Unique Id");
	}

	// Stage History Field
	@Test
	public void verifyTheUserIsAddStageHistoryFiledsAndViewdInAuditPage() {

		CallLogStageView.navigatetoStage();
		CallLogStageView.searchStage("Student Information Stages");
		CallLogStageView.CaptureSearchedStageText();

		CallLogStageView.SelectValuesFromDropdowns(CallLogStageView.stagesHistoryFieldsOptions,
				CallLogStageView.verifyHistoryFileds, CallLogStageView.leftAllButton,
				CallLogStageView.historyFieldsDropdwon, CallLogStageView.RightSelectedButton, "Trans Unique Id");
		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.selectStagesAndCheckAddedkstageHistoryFieldAreDisplayedInCallLogStageView("Trans Unique Id");
	}

	@Test
	public void verifyTheUserIsAddStageuniqueFiledsAndViewdInAuditPage() { // need to Update after Fixed

		CallLogStageView.navigatetoStage();
		CallLogStageView.searchStage("Student Information Stages");
		CallLogStageView.CaptureSearchedStageText();

		CallLogStageView.SelectValuesFromDropdowns(CallLogStageView.stagesHistoryFieldsOptions,
				CallLogStageView.verifyUniuqeFields, CallLogStageView.leftAllButtonForUniqueFileds,
				CallLogStageView.uniqueFieldsDropdwon, CallLogStageView.RightSelectedButtonForUniqueFileds,
				"Trans Unique Id");
		CallLogStageView.navigateTo_AlchemyModule();
		CallLogStageView.navigateToCallLogStageView();
		CallLogStageView.selectStagesAndCheckAddedkstageHistoryFieldAreDisplayedInCallLogStageView("Trans Unique Id");
	}

	@Test
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
