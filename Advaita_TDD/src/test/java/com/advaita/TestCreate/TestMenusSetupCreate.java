package com.advaita.TestCreate;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.MenuSetup.pageObject.Menusetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestMenusSetupCreate extends TestBase {

	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	Menusetup menusetup;

	public TestMenusSetupCreate() {
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

		menusetup = new Menusetup(); // object creation with referenac of class

	}

	@Test // Nedd to implement
	public void navigateTouserSetup() {
		menusetup.navigateTouserSetup();

	}

	@Test
	public void VerifyAfterEditDisplayNameItshouldReflectInSideMenu() {

		// Data Setup Workflow Design
		// User Setup
		// DashBoards
		// Masters
		// User Status
		// API Key Setup
		// Menu Setup
		// Site Settings

		// (Enter Any avalue realted to this Commneted one)

		menusetup.navigateTomenuSetup();
		menusetup.ClickOnEdit("Workflow Design");
		menusetup.enterDispalyNameInEditMenuSetup("workflowdesign");

	}

	// Table

	@Test(priority = 1)
	public void verifyTheUSerisableToSearchByFormName() {

		menusetup.navigateTomenuSetup();
		menusetup.searchByFormName();

	}

	@Test(priority = 2)
	public void verifyTheUsersearchByDefaultName() {

		menusetup.navigateTomenuSetup();
		menusetup.searchByDefaultName();

	}

	@Test(priority = 3)
	public void nverifyTheUserSearchByDisplayName() {

		menusetup.navigateTomenuSetup();
		menusetup.SearchByDisplayName();
	}

	@Test(priority = 4)
	public void verifyTheUserAbeltoClearAllFilters() {
		menusetup.navigateTomenuSetup();
		menusetup.cleatfilter();

	}

	// Edit

	@Test(priority = 5)
	public void formNameEdit() throws Throwable {

		// Edit
		menusetup.navigateTomenuSetup();
		menusetup.navigateToEditMenuSetup();
		menusetup.formNameEdit();

	}

	@Test(priority = 6)
	public void defautNameEdit() {

		// Edit
		menusetup.navigateTomenuSetup();
		menusetup.navigateToEditMenuSetup();
		menusetup.defautNameEdit();
	}

	@Test(priority = 7)
	public void displayNameEdit() {

		// Edit
		menusetup.navigateTomenuSetup();
		menusetup.navigateToEditMenuSetup();
		menusetup.displayNameEdit("dataSetup");

	}

	@Test
	public void clickOnEditBasedonDefaultName() {
		menusetup.navigateTomenuSetup();
		menusetup.ClickOnEdit("Alchemy");

	}

//////////////////////////////////////////// Negative/////////////////////////////////////////////////////////////////////

	@Test
	public void verifyTheUserwithoutEnteringMandatoryFieldandclickOnUpdate() { // Nedd to implement after Fixed
		menusetup.theUserwithoutEnteringMandatoryFieldandclickOnUpdate();

	}

	@Test
	public void verifyTheUserCanEditDisplayNameToEmojisAandUpadte() { // Nedd to implement after Fixed
		menusetup.TheUserCanEditDisplayNameToEmojisAandUpadte();
	}

	@Test
	public void verifyTheUseerCanEditDisplyenameCharctertoOnlySpecialCharacterandUpdate() throws InterruptedException { // Nedd
																														// to
																														// implement
																														// after
																														// Fixed

		menusetup.theUserCanEditDisplyenameCharcterToOnlySpecialCharacterandUpdate();

	}

	@Test
	public void VerifyUsercanEnterCharactermorethanchracterLimits() throws Throwable { // Nedd to implement after Fixed
		menusetup.usercanEnterCharactermorethanchracterLimits();
	}

	@Test
	public void searchThroughPartialNamesinSearchTextfieldUTILITY() {
		menusetup.searchThroughPartialNamesinSearchTextfieldUTILITY();

	}

	@Test
	public void verifyTheUserTryToSearchByWithoutEnteringAnyData() {
		menusetup.tryToSearchByWithoutEnteringAnyData();

	}

	@Test
	public void verifuTheUserTryToSearchThroughEmojisInsearchTextfield() { // Nedd to implement after Fixed
		menusetup.tryToSearchThroughEmojisInsearchTextfield();
	}

	@Test
	public void verifyTheUserAbleToSearchThroughInvalidCharacterInSearchTextfield() {
		menusetup.SearchThroughInvalidCharacterInSearchTextfield();
	}

	@Test
	public void verifyTheUSersearchThroughSpacesInSearchTextfield() {
		menusetup.searchThroughSpacesInSearchTextfield();

	}

	@Test
	public void verifyTheUserSearchThroughEmojiInSearchField() {
		menusetup.searchThroughEmojiInSearchField();
	}

	@Test
	public void clickOnEditIconBasedONDefaultName() {
		menusetup.navigateTomenuSetup();
		menusetup.ClickOnEdit("Alchemy");

	}

	@Test
	public void EndToEndMenuSetup() {

		// Data Setup Workflow Design
		// User Setup
		// DashBoards
		// Masters
		// User Status
		// API Key Setup
		// Menu Setup
		// Site Settings

		//==> Enter Any avalue realted to this Commneted one

		menusetup.navigateTomenuSetup();
		menusetup.ClickOnEdit("Workflow Design");
		menusetup.enterDispalyNameInEditMenuSetup("workflowdesign");

		menusetup.searchThroughPartialNamesinSearchTextfieldUTILITY();
		menusetup.searchByFormName();
		menusetup.SearchByDisplayName();
		menusetup.SearchByDisplayName();

		menusetup.cleatfilter();

	}
	
	@Test
	public void EndToEnDMenuSetupNegative() throws InterruptedException {
		
		menusetup.navigateTomenuSetup();
		
		menusetup.theUserwithoutEnteringMandatoryFieldandclickOnUpdate();
		menusetup.TheUserCanEditDisplayNameToEmojisAandUpadte();
		menusetup.theUserCanEditDisplyenameCharcterToOnlySpecialCharacterandUpdate();
		menusetup.usercanEnterCharactermorethanchracterLimits();
		menusetup.tryToSearchByWithoutEnteringAnyData();
		menusetup.tryToSearchThroughEmojisInsearchTextfield();
		menusetup.SearchThroughInvalidCharacterInSearchTextfield();
		menusetup.searchThroughSpacesInSearchTextfield();
		menusetup.searchThroughEmojiInSearchField();
	}

	// @AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
