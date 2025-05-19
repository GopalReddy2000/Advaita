package com.advaita.TestTable;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
	String nonEnglishLangaugesCharcterForProcess = " 过程";
	String nonEnglishLangaugesCharcterForSubProcess = " 子过程";
	String nonEnglishLangaugesCharcterForSubSubProcess = " 子子过程";
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

	@Test(priority = 1)
	public void verifyProcessTable() throws Throwable {

		homePage.clickOnProcessManagementCreate(); // clickOnProcessManagementCreate change to datasetup
//		process.tablePage(3);
//		process.TablePage1();
//		process.clearfilter_tablePage();
//		process.clickonProcessDropDownToacessSubList_Tablepage();
//		process.clickonProcessDropDownAgainSubprocessDropdownToacessSubSubList_Tablepage();
//		process.createdprocessNotificatedByclickingBellIcon();
//	    process.HowmuchCreatedprocess();	
//		process.SearchCreatedProcesbySelctingStatus_Active();
//		process.SearchCreatedProcesbySelctingStatus_InAnctive();
//		process.NavigateToNextTablePageClick_Rightarrow();
//		process.NavigateToNextTablePageClick_leftarrow();

		// ProcessSetup
		process.allActiveProcesss();
		process.fetchProcessAndStatus();
		process.SingleProcessOnly();

//		test = reports.createTest("verifyProcessTable");
//		process.tablePage();

	}

/////////////////////////////////////// Negative ///////////////////////////////////////////////////////////////////////

	

	@Test
	public void verifyUserFilledAllDataINProcessesTabANdClickOnCancel() throws Throwable {

		homePage.clickOnProcessManagementCreate();
		process.userFilledAllTheDatawithoutclickSaveandUpdateOptionInSubSubProcessTabAndclickOnCancelOption(
				fake.lastName1() + " process", fake.lastName1() + " ProcessDesc", fake.lastName1() + " Sub process",
				fake.lastName1() + " Subprocess Desc", fake.lastName1() + " SubSub process",
				fake.lastName1() + " SubSubDescriprion");

	}

	// Without Enter processes name

	@Test
	public void verifyUserIsAbleTocreateWithoutEnterMandatoryFieldInProcessnamesandSave() {
		homePage.clickOnProcessManagementCreate();

		process.UserIsAbleTocreateWithoutEnterMandatoryFieldProcesssandSaveUTILITY(process.processNameLabel, true,
				process.processNameField, fake.lastName1() + "Desc", process.saveandContinueButton);
	}

	@Test
	public void verifyUserIsAbleToEditWithoutEnterMandatoryFieldInSubProcessnamesandSave() {
		homePage.clickOnProcessManagementCreate();
		process.UserIsAbleTocreateWithoutEnterMandatoryFieldsSubProcessandSaveUTILITY(process.editOption2,
				process.subProcessNameFieldLabel, false, fake.lastName1() + "Desc",
				process.saveandContinnueButtonInSubProcess);
	}

	@Test
	public void verifyUserIsAbleToEditWithoutEnterMandatoryFieldInSubSubProcessnamesandSave() {
		homePage.clickOnProcessManagementCreate();
		process.UserIsAbleTocreateWithoutEnterMandatoryFieldsSubSubProcessandSaveUTILITY(process.editOption3,
				process.subSubProcessNameFieldLabel, false, fake.lastName1() + "Desc",
				process.save_UpdateButtonInSubsubProcess);
	}

	// Special Charcters

	@Test
	public void verifyTheUSerisAbleToEditProcessNameToSpecialCharcterAndSave() { // Need To implemment after fixed

		homePage.clickOnProcessManagementCreate();
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
		process.SpecialCharctersForProcessUTILITY(process.processNameLabel, true, nonEnglishLangaugesCharcterForProcess,
				fake.lastName1() + "Desc", process.saveButton);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubProcessNameToNonEnglishCaracterAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubProcessUTILITY(process.editOption2, process.subProcessNameFieldLabel, false,
				nonEnglishLangaugesCharcterForSubProcess, fake.lastName1() + "Desc", process.saveButtonInSubProcess);
	}

	@Test
	public void verifyTheUSerisAbleToEditSubSubProcessNameToNonEnglishCaracterAndSave() { // Need To implemment after
																							// fixed

		homePage.clickOnProcessManagementCreate();
		process.SpecialCharctersForSubSubProcessUTILITY(process.editOption3, process.subSubProcessNameFieldLabel, false,
				nonEnglishLangaugesCharcterForSubSubProcess, fake.lastName1() + "Desc",
				process.save_UpdateButtonInSubsubProcess);
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

	// Without Select Process and SubProcess Dropdown.
	@Test
	public void verifyTheUserWithoutSelectProcessDropdownAndSave() {

		homePage.clickOnProcessManagementCreate();
		process.withoutSelectProcessDropdownAndSave();
	}

	@Test
	public void verifyTheUserWithoutSelectSubProcessDropdownAndSave() throws Throwable {

		homePage.clickOnProcessManagementCreate();
		process.withoutSelectSubProcessDropdownAndSave();
	}

	// save Through Dulplicate Name
	@Test
	public void verifyTheUserIsAbleToCreateWithSameProcessName() {

		homePage.clickOnProcessManagementCreate();
		process.userIsAbleToCreateWithSameProcessName();
	}

	// Search
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

	////////////////////////////////////// Process SetUp Negative Scripts////////////////////////////////////////////////

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

		homePage.clickOnProcessManagementCreate();
		process.TheUserAfterAddingProcessAndSubProcessAndSave();
	}

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

	// @AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		// reports.flush();
	}

}
