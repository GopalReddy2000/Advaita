package com.advaita.TestTable;

import org.apache.commons.compress.harmony.pack200.Archive;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testdata.DataProviders;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestProcessTable extends TestBase {

	FakeData fake = new FakeData();

	// Propery File data
	public String processName = "Test " + fake.lastName1();
	public String processDesc = "Test Desc " + fake.lastName1();
	public String subProcessName = "Test " + fake.lastName1();
	public String subProcessDesc = "Test Desc" + fake.lastName1();
	public String subSubProcessName = "Test " + fake.lastName1();
	public String subSubProcessDesc = "Test Desc" + fake.lastName1();

	// Use varaible For Negative Testing
	String emojis = "(*/ω＼*)";
	String SpecialCharcters = "!@#$%^&*";
	String NumericValue = "1234456";
	String nonEnglishLangaugesChar_Process = " 过程";
	String nonEnglishLangaugesChar_SP = " 子过程";
	String nonEnglishLangaugesChar_SSP = " 子子过程";
	String invaliCreatedProcess = "ddsds";
	String spaces = "   ";

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	ProcessPage process;

	public TestProcessTable() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("capture_admin", "Qwerty@123");

//		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ProcessTable.html");
//		reports = new ExtentReports();
//		reports.attachReporter(htmlReporter);
//
//		// add environment details
//		reports.setSystemInfo("Machine", "Testpc1");
//		reports.setSystemInfo("OS", "Windows 11");
//		reports.setSystemInfo("user", "Gopal");
//		reports.setSystemInfo("Browser", "Chrome");
//
//		// Configuration to change look and feel
//		htmlReporter.config().setDocumentTitle("Extent Report for Process");
//		htmlReporter.config().setReportName("TEST Advaita");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTimelineEnabled(true);
//		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		process = new ProcessPage();

	}

	@Test
	public void NaviageToProcessManagementPage() {

		homePage.clickOnProcessManagementCreate();

	}

	// @Test(dependsOnMethods = {"clickOnProcessManagementCreate"})
	@Test
	public void verifyProcessTable() throws Throwable {

		homePage.clickOnProcessManagementCreate(); // clickOnProcessManagementCreate change to datasetup
		// process.tablePage(3);
		// process.TablePage1();
		process.clearFliter();
		process.clickonProcessDropDownToacessSubList_Tablepage();
		process.clickonProcessDropDownAgainSubprocessDropdownToacessSubSubList_Tablepage();
		process.createdprocessNotificatedByclickingBellIcon();
		process.HowmuchCreatedprocess();
		process.searchedThroughStatus();
		process.SearchCreatedProcesbySelctingStatus_InAnctive();
		process.NavigateToNextTablePageClick_Rightarrow();
		process.NavigateToNextTablePageClick_leftarrow();

		// ProcessSetup
		process.allActiveProcesss();
		process.fetchProcessAndStatus();
		// process.SingleProcessOnly();

//		test = reports.createTest("verifyProcessTable");
//		process.tablePage();

	}

	// ================ Table Page ================================

	@Test(description = "Search Manualley", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void veifyTheUserIsableTosearchThroughCraetedProcessManually() throws Throwable {

		process.searchThroughProcess("searchManually");
	}

	@Test(description = "Search Randomely", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void veifyTheUserIsableTosearchThroughCraetedProcessRandomely() throws Throwable {

		process.searchThroughProcess("randomely");
	}

	@Test(description = "Search Partial Name", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void veifyTheUserIsableTosearchThroughCraetedProcessPartailName() throws Throwable {

		process.searchThroughProcess("partailName");
	}

	@Test(description = "Cleared Manual Filtered Searched", dependsOnMethods = {
			"veifyTheUserIsableTosearchThroughCraetedProcessManually" })
	public void clearFilterManualellySearched() {

		process.clearFliter();

	}

	@Test(description = "Cleared Randomely Filtered Searched", dependsOnMethods = {
			"veifyTheUserIsableTosearchThroughCraetedProcessPartailName" })
	public void clearFilterRandomelySearched() {

		process.clearFliter();

	}

	@Test(description = "Cleared PartialName Filtered Searched", dependsOnMethods = {
			"veifyTheUserIsableTosearchThroughCraetedProcessByPartialNames" })
	public void clearFilterPartialNameSearched() {

		process.clearFliter();

	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNaviagteUnArchiveProcess" })
	public void veifyTheUserIsableTosearchprocessInArchiveTab() throws Throwable {

		// process.searchThroughProcess("searchManually");
	}

	// Process Setup
	@Test(dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserisDoProcessSetupManualley() throws Throwable {

		process.naviagteToProcessSetupaAndVerifyPage();

//			process.allActiveProcesss();
//			process.fetchProcessAndStatus();
		process.SingleProcessOnly("selectManualley");

	}

	@Test(dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserisDoProcessSetupRandomely() throws Throwable {

		process.naviagteToProcessSetupaAndVerifyPage();

//		process.allActiveProcesss();
//		process.fetchProcessAndStatus();
		process.SingleProcessOnly("randomely");

	}
	// 28.7.25
	// ====== New Funcanaltity ==========
	// =========== Archive and UnArchive Process ============

	@Test(description = "navaigate To Archive Process", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbleToNaviagteArchiveProcess() {

		process.navigateToArchiveProcess();
	}

	@Test(description = " navaigate To UnArchive Process", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbleToNaviagteUnArchiveProcess() {

		process.navigateToUnArchiveProcess();
	}

	@Test(description = "Archive Process", dependsOnMethods = {
			"veifyTheUserIsableTosearchThroughCraetedProcessManually" })
	public void verifyTheUserIsAbelToDoArchiveProcess() throws Throwable {
		verifyTheUserIsAbelToDoArchiveProcessAndVerifyInArchiveTab();
	}

	// Archive

	@Test(description = "Archive Process and Verify In Archive Tab", dependsOnMethods = {
			"veifyTheUserIsableTosearchThroughCraetedProcessManually" })
	public void verifyTheUserIsAbelToDoArchiveProcessAndVerifyInArchiveTab() throws Throwable {

		process.archiveAction();
		process.verifyArchivePopupAndClick();
		process.clickOnArchiveOptionAndVerifyInArchiveTab();

	}

	@Test(description = "Archive Muttiple Process", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbleToArchivemutipleProcess() {

		process.navigateToUnArchiveProcess();
		process.archiveMultipleProcesses(1);
	}

	// <<<<<< ========= Unarchive Process ============== >>>>>>

	@Test(description = "UnArchive Process And Verify in UnArchive Tab", dependsOnMethods = {
			"NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbelToUnArchiveProcessAndVerifyInUnArchiveTab() throws Throwable {

		process.navigateToArchiveProcess();

		process.unArchiveAction();
		process.verifyUnArchivePopupAfterClickAndContinue();
		// process.clickOnUnArchiveOptionAndVerifyInUnArchiveTab();

	}

	@Test(description = "UnArchive Muttiple Process", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbleTotoUnArchivemutipleProcess() {

		process.navigateToArchiveProcess();
		process.unarchiveMultipleProcesses(1);
	}

	// Delete process In Archive Tab
	@Test(description = "Delete Archive Process Manualley", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbleTotoDeleteArchiveProcessManualley() {

		process.navigateToArchiveProcess();
		process.deleteProcessByNameFromArchive("Beauty & Tools P");

	}

	@Test(description = "Delete Archive Process Randomely", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbleTotoDeleteArchiveProcessRandomely() {

		process.navigateToArchiveProcess();
		process.deleteRandomProcessFromArchive();
	}

	@Test(description = "Delete Multiple Process", dependsOnMethods = { "NaviageToProcessManagementPage" })
	public void verifyTheUserIsAbleTotoDeletemutipleProcess() {

		process.navigateToArchiveProcess();
		process.deleteProcessesFromArchive(1);
	}

	@Test(description = "Delete all Archived Processes", dependsOnMethods = {
			"NaviageToProcessManagementPage" }, enabled = false)
	public void verifyTheUserIsAbleTotoDeleteall() {

		process.navigateToArchiveProcess();
		process.deleteAllArchivedProcesses();
	}

	// Based On Selected Process Archive SubProcess & Sub Sub Process

	@Test(description = "Archive subProcess and Verify In Archive Tab", dependsOnMethods = {
			"veifyTheUserIsableTosearchThroughCraetedProcessManually" })
	public void archiveSubProcess() throws Throwable {

		process.archiveSubProcessRelatedToProcess();
	}

	@Test(description = "Archive Sub_SubProcess and Verify In Archive Tab", dependsOnMethods = {
			"veifyTheUserIsableTosearchThroughCraetedProcessManually" })
	public void archiveSubSubProcess() throws Throwable {

		process.archiveSubSubProcessRelatedToProcess();
	}

	// ========================== Negative Test Script ==========================

	@Test(description = "verify The User Is able to create Process Without Sub sub process", dependsOnMethods = {
			"NaviageToProcessManagementPage" })
	public void withourFilledSubSubProcesClickOnCance() throws Throwable {
		withoutFilledSubSubProcesClickOnCance();
	}

	@Test(description = "verify The User Is able to create Process Without Sub sub process", dependsOnMethods = {
			"NaviageToProcessManagementPage" })
	public void withoutFilledSubSubProcesClickOnCance() throws Throwable {

		// homePage.clickOnProcessManagementCreate();
		process.withoutFilledSubSubProcesClickOnCancelOption(fake.lastName1() + " process",
				fake.lastName1() + " ProcessDesc", fake.lastName1() + " Sub process",
				fake.lastName1() + " Subprocess Desc", fake.lastName1() + " SubSub process",
				fake.lastName1() + " SubSubDescriprion");

	}

	@Test(description = "Verify The User Is able To Edit Process Without Enter ProcessName", dependsOnMethods = "NaviageToProcessManagementPage")
	public void createProcessWithoutmandatoryFiledProceessName() {
		homePage.clickOnProcessManagementCreate();

		process.UserIsAbleTocreateWithoutEnterMandatoryFieldProcesssandSaveUTILITY(process.processNameLabel, true,
				process.processNameField, FakeData.lastName1() + "Desc", process.saveandContinueButton);
	}

	@Test(description = "Veify The user Able To Edit Process without sub processName_Mandatory Field", dependsOnMethods = "NaviageToProcessManagementPage")
	public void verifyUserIsAbleToEditWithoutEnterMandatoryFieldInSubProcessnamesandSave() {
		homePage.clickOnProcessManagementCreate();
		process.UserIsAbleTocreateWithoutEnterMandatoryFieldsSubProcessandSaveUTILITY(process.editOption2,
				process.subProcessNameFieldLabel, false, fake.lastName1() + "Desc",
				process.saveandContinnueButtonInSubProcess);
	}

	@Test(description = "Veify The user Able To Edit Process without sub sub processName_Mandatory Field", dependsOnMethods = "NaviageToProcessManagementPage")
	public void verifyUserIsAbleToEditWithoutEnterMandatoryFieldInSubSubProcessnamesandSave() {
		// homePage.clickOnProcessManagementCreate();
		process.UserIsAbleTocreateWithoutEnterMandatoryFieldsSubSubProcessandSaveUTILITY(process.editOption3,
				process.subSubProcessNameFieldLabel, false, fake.lastName1() + "Desc",
				process.save_UpdateButtonInSubsubProcess);
	}

	// Special Charcters

	// 🔹 Tell TestNG which DataProvider to use ,// 🔹 Where to find it
	@Test(dependsOnMethods = "NaviageToProcessManagementPage")
	public void verifyTheUSerisAbleToEditProcessNameToSpecialCharcterAndSave() { // Need To implemment after fixed

		// homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForProcessUTILITY(process.processNameLabel, true, SpecialCharcters,
				fake.lastName1() + "Desc", process.saveButton);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubProcessNameToSpecialCharcterAndSave() { // Need To implemment after fixed

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubProcessUTILITY(process.editOption2, process.subProcessNameFieldLabel, false,
				SpecialCharcters, fake.lastName1() + "Desc", process.saveButtonInSubProcess);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubSubProcessNameToSpecialCharcterAndSave() { // Need To implemment after fixed

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubSubProcessUTILITY(process.editOption3, process.subSubProcessNameFieldLabel, false,
				SpecialCharcters, fake.lastName1() + "Desc", process.save_UpdateButtonInSubsubProcess);
	}

	// Emojis

	@Test
	public void verifyTheUSerisAbleToEditProcessNameToEmojisAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForProcessUTILITY(process.processNameLabel, true, emojis, fake.lastName1() + "Desc",
				process.saveButton);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubProcessNameToEmojisAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubProcessUTILITY(process.editOption2, process.subProcessNameFieldLabel, false,
				emojis, fake.lastName1() + "Desc", process.saveButtonInSubProcess);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubSubProcessNameToEmojisAndSave() { // Need To implemment after fixed

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubSubProcessUTILITY(process.editOption3, process.subSubProcessNameFieldLabel, false,
				emojis, fake.lastName1() + "Desc", process.save_UpdateButtonInSubsubProcess);
	}

	// NoN English Character

	@Test
	public void verifyTheUSerisAbleToEditProcessNameToNonEnglishCaracterAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForProcessUTILITY(process.processNameLabel, true, nonEnglishLangaugesChar_Process,
				fake.lastName1() + "Desc", process.saveButton);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubProcessNameToNonEnglishCaracterAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubProcessUTILITY(process.editOption2, process.subProcessNameFieldLabel, false,
				nonEnglishLangaugesChar_SP, fake.lastName1() + "Desc", process.saveButtonInSubProcess);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubSubProcessNameToNonEnglishCaracterAndSave() { // Need To implemment after
																							// fixed

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubSubProcessUTILITY(process.editOption3, process.subSubProcessNameFieldLabel, false,
				nonEnglishLangaugesChar_SSP, fake.lastName1() + "Desc", process.save_UpdateButtonInSubsubProcess);
	}

	@Test
	public void verifyTheUSerisAbleToEditProcessNameToNumericValueAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForProcessUTILITY(process.processNameLabel, true, NumericValue,
				fake.lastName1() + "Desc", process.saveButton);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubProcessNameToNumericValueAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubProcessUTILITY(process.editOption2, process.subProcessNameFieldLabel, false,
				NumericValue, fake.lastName1() + "Desc", process.saveButtonInSubProcess);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubSubProcessNameToNumericValueAndSave() { // Need To implemment after fixed

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubSubProcessUTILITY(process.editOption3, process.subSubProcessNameFieldLabel, false,
				NumericValue, fake.lastName1() + "Desc", process.save_UpdateButtonInSubsubProcess);
	}

	// RepeatedChracter or Check CharacterLimit
	@Test
	public void verifyTheUserisAbleToEnterMoreThanCharcterLimitInProcessNameTextfieldAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.userIsAbleToCheckCharacterForProcessByMoreThanCharacterLimitUTILITY(process.editOption1,
				process.processNameField);

	}

	// ==== Without Select Process and SubProcess Dropdown====

	@Test(description = " save Without Select Process")
	public void verifyTheUserWithoutSelectProcessDropdownAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.withoutSelectProcessDropdownAndSave();
	}

	@Test(description = " save Without Select SubProcess")
	public void verifyTheUserWithoutSelectSubProcessDropdownAndSave() throws Throwable {

		homePage.clickOnProcessManagementCreate();
		process.withoutSelectSubProcessDropdownAndSave();
	}

	@Test(description = "save Through Dulplicate Name")
	public void verifyTheUserIsAbleToCreateWithSameProcessName() {

		homePage.clickOnProcessManagementCreate();
		process.userIsAbleToCreateWithSameProcessName();
	}

	// ========= Search_Negative
	@Test
	public void verifyTheUserIsAbleToSearchThroughInvalidProcessNames() {
		homePage.clickOnProcessManagementCreate();
		process.userIsAbleToSearchThroughInvalidProcessNames(invaliCreatedProcess);
	}

	@Test
	public void verifyTheUserIsAbleToSearchspacesProcessNames() {
		homePage.clickOnProcessManagementCreate();
		process.userIsAbleToSearchThroughInvalidProcessNames(spaces);
	}

	@Test
	public void verifyTheUserIsAbleToSearchThroughRepeatedCarcterMoreThanCharcterLimitinSearchTextfield() {
		homePage.clickOnProcessManagementCreate();
		process.userIsAbleToSearchThroughInvalidProcessNames("A".repeat(300));

	}

	// ======= Process Setup Negative Scripts===========

	@Test
	public void verifyTheUserwithoutSelectingProcesseAndcLickOnSave() {
		homePage.clickOnProcessManagementCreate();
		process.withoutSelectingProcesseAndcLickOnSave();
	}

	@Test
	public void verifyTheUserSelectingAllTheProcessandWithoutSaveClickOnCancel() {
		homePage.clickOnProcessManagementCreate();
		process.userSelectingAllTheProcessandWithoutSaveClickOnCancel();
	}

	@Test
	public void verifyTheUserAfterAddingProcessClickOnCancel() {
		homePage.clickOnProcessManagementCreate();
		process.TheUserAfterAddingProcessClickOnSave();

	}

	@Test
	public void verifyTheTheUserAfterAddingProcessAndSubProcessAndSave() {
		verifyTheUserAfterAddingProcessAndSubProcessAndSave();
	}

	@Test
	public void verifyTheUserAfterAddingProcessAndSubProcessAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.TheUserAfterAddingProcessAndSubProcessAndSave();
	}

//28.10.25	
//============= Data Provider_Implemenetation

	@Test(dependsOnMethods = "NaviageToProcessManagementPage", dataProvider = "processNameData", dataProviderClass = DataProviders.class)
	public void testDataProvider(String invalidProcessName) {
		System.out.println("Running test for process name: " + invalidProcessName);
		process.dataProvideTeest(invalidProcessName);
	}

	@Test(description = "Verify The Process name Accepts Invalids Inputs on ProcessName Field", dependsOnMethods = "NaviageToProcessManagementPage", dataProvider = "processNameData", dataProviderClass = DataProviders.class)
	public void testCreateThroughInvalidInputs(String invalidInput) {
		processNameAcceptsInvalidInputsOnProcessNameTextfield(invalidInput);
	}

	@Test(description = "Verify The Process name Accepts Invalids Inputs on ProcessName Field", dependsOnMethods = "NaviageToProcessManagementPage", dataProvider = "processNameData", dataProviderClass = DataProviders.class)
	public void processNameAcceptsInvalidInputsOnProcessNameTextfield(String invalidInput) {
		System.out.println("Running test for process name: " + invalidInput);
		process.checkTextfieldshouldNotAcceptInvalidInput(process.processNameLabel, true, process.processNameField,
				invalidInput, fake.lastName1() + "Desc", alchemy);
	}

	@Test(description = "Verify search Bar accepts Invalida Inputs", dependsOnMethods = "NaviageToProcessManagementPage", dataProvider = "processNameData", dataProviderClass = DataProviders.class)
	public void testSearchBarAcceptInput(String invlaidInput) {

		process.checkInvalidInpusShouldONSearchField(invlaidInput);
	}

//	process.SpecialCharctersForProcessUTILITY(process.processNameLabel, true, SpecialCharcters,
//	fake.lastName1() + "Desc", process.saveButton);

//	@AfterMethod
//	public void getResult(ITestResult result) throws IOException, Throwable {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			// Mark the test as failed in the ExtentReports
//			test.fail(result.getThrowable());
//			// Add screenshot to ExtentReports
//			String screenshotPath = ScreenShorts.captureScreenshot(result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath(screenshotPath);
//			
//			// Add logs
//	        test.log(Status.FAIL, "Test failed at " + new Date());
//
//	        // Add custom HTML block
//	        test.log(Status.INFO, MarkupHelper.createCodeBlock("<div>Custom HTML block</div>"));
//		}
//		// Close ExtentReports
//		reports.flush();
//	}

	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		// reports.flush();
	}

}
