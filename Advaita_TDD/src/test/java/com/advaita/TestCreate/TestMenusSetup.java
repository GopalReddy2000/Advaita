package com.advaita.TestCreate;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.MenuSetup.pageObject.Menusetup;
import com.advaita.Utilities.PropertieFileUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestMenusSetup extends TestBase {

	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	Menusetup menusetup;
	PropertieFileUtil propertieFileUtil;

	public TestMenusSetup() {
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

//		// Configuration to change look and feel
//		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
//		htmlReporter.config().setReportName("TEST Advaita-MetaData");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTimelineEnabled(true);
//		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		menusetup = new Menusetup(); // object creation with referenac of class
		propertieFileUtil = new PropertieFileUtil();

	}

	// @Test // Nedd to implement
	public void navigateTouserSetup() {
		menusetup.navigateTouserSetup();

	}

	@Test
	public void VerifyTheUserIsAbleToNavigateMenuSetup() {

		menusetup.navigateTomenuSetup();
	}

	// Table

	@Test(priority = 1, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void verifyTheUSerisableToSearchByFormNamebyGivenName() throws Throwable {

		// menusetup.navigateTomenuSetup();
		menusetup.searchByFormName("givenValue");

	}

	@Test(priority = 2, enabled = false, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void verifyTheUSerisableToSearchByFormNameByRandom() throws Throwable {

		// menusetup.navigateTomenuSetup();
		menusetup.searchByFormName("random");

	}

	@Test(priority = 3, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void verifyTheUsersearchByDefaultNameGivenName() throws Throwable {

		// menusetup.navigateTomenuSetup();
		menusetup.searchByDefaultName("givenValue");

	}

	@Test(priority = 4, enabled = false, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void verifyTheUsersearchByDefaultNameRandom() throws Throwable {

		// menusetup.navigateTomenuSetup();
		menusetup.searchByDefaultName("random");

	}

	@Test(priority = 5, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void nverifyTheUserSearchByDisplayNameGivenName() throws Throwable {

		// menusetup.navigateTomenuSetup();
		menusetup.SearchByDisplayName("givenValue");
	}

	@Test(priority = 6, enabled = false, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void nverifyTheUserSearchByDisplayNameRandom() throws Throwable {

		// menusetup.navigateTomenuSetup();
		menusetup.SearchByDisplayName("random");
	}

	// ============= Clear Filter ==================

	@Test(priority = 7, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup",
			"verifyTheUSerisableToSearchByFormNamebyGivenName" })
	public void verifyTheUserAbeltoClearAllFilters() {

		menusetup.cleatfilter();

	}

	// Edit dispalyed name based on defualtName and verify In side side Menu
	// ========================================================================

	@Test(priority = 8, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup",
			"verifyTheUserAbeltoClearAllFilters" })
	public void VerifyAfterEditDisplayNameBasedonDefaultNameItshouldReflectInSideMenu() throws IOException {

		VerifyAfterEditDisplayNameShouldReflectInSideMenuBasedonDefaultNameIts();
	}

	@Test(priority = 9, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup",
			"verifyTheUserAbeltoClearAllFilters" })
	public void VerifyAfterEditDisplayNameShouldReflectInSideMenuBasedonDefaultNameIts() throws IOException {

		String defaultName = PropertieFileUtil.getSingleTextFromPropertiesFile("DefaultNames1");
		String fakeDisplayname = fake.lastName1();

		menusetup.ClickOnEditOptionBasedOnDefaultName(defaultName);
		menusetup.enterDispalyNameInEditMenuSetupAndVerifyinSideMenu(fakeDisplayname);// "Data Setup"

	}

	@Test(priority = 10, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void formNameEdit() throws Throwable {

//		menusetup.navigateTomenuSetup();
		menusetup.navigateToEditMenuSetup();
		menusetup.formNameEdit();

	}

	@Test(priority = 11, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void defautNameEdit() {

		menusetup.navigateToEditMenuSetup();
		menusetup.defautNameEdit();
	}

	@Test(priority = 12, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void displayNameEdit() throws IOException {

		menusetup.navigateToEditMenuSetup();

		String defaultName = PropertieFileUtil.getSingleTextFromPropertiesFile("DefaultNames1");
		String fakeDisplayname = fake.lastName1();

		menusetup.displayNameEdit(fakeDisplayname);

	}

//============================ Negative Test Methods ===========================================================

	public void verifyTheUserwithoutEnteringMandatoryFieldandclickOnUpdate() { // Nedd to implement after Fixed
		menusetup.theUserwithoutEnteringMandatoryFieldandclickOnUpdate();

	}

	public void verifyTheUserCanEditDisplayNameToEmojisAandUpadte() {
		menusetup.TheUserCanEditDisplayNameToEmojisAandUpadte();
	}

	public void verifyTheUseerCanEditDisplyenameCharctertoOnlySpecialCharacterandUpdate() throws InterruptedException {

		menusetup.theUserCanEditDisplyenameCharcterToOnlySpecialCharacterandUpdate();

	}

	public void VerifyUsercanEnterCharactermorethanchracterLimits() throws Throwable {
		menusetup.usercanEnterCharactermorethanchracterLimits();
	}

	public void searchThroughPartialNamesinSearchTextfieldUTILITY() {
		menusetup.searchThroughPartialNamesinSearchTextfieldUTILITY();

	}

	public void verifyTheUserTryToSearchByWithoutEnteringAnyData() {
		menusetup.tryToSearchByWithoutEnteringAnyData();

	}

	public void verifuTheUserTryToSearchThroughEmojisInsearchTextfield() {
		menusetup.tryToSearchThroughEmojisInsearchTextfield();
	}

	public void verifyTheUserAbleToSearchThroughInvalidCharacterInSearchTextfield() {
		menusetup.SearchThroughInvalidCharacterInSearchTextfield();
	}

	public void verifyTheUSersearchThroughSpacesInSearchTextfield() {
		menusetup.searchThroughSpacesInSearchTextfield();

	}

	public void verifyTheUserSearchThroughEmojiInSearchField() {
		menusetup.searchThroughEmojiInSearchField();
	}

	// ===============Negative End To End=============================

	@Test(priority = 14, enabled = true, dependsOnMethods = { "VerifyTheUserIsAbleToNavigateMenuSetup" })
	public void EndToEnDMenuSetupNegative() throws InterruptedException {

		// menusetup.navigateTomenuSetup();

		menusetup.theUserwithoutEnteringMandatoryFieldandclickOnUpdate();
		menusetup.TheUserCanEditDisplayNameToEmojisAandUpadte();
		menusetup.theUserCanEditDisplyenameCharcterToOnlySpecialCharacterandUpdate();
		// menusetup.usercanEnterCharactermorethanchracterLimits();
		menusetup.tryToSearchByWithoutEnteringAnyData();
		menusetup.tryToSearchThroughEmojisInsearchTextfield();
		menusetup.SearchThroughInvalidCharacterInSearchTextfield();
		menusetup.searchThroughSpacesInSearchTextfield();

	}

//	@Test
//	public void EndToEndMenuSetup() throws Throwable {
//
//		// Data Setup Workflow Design
//		// User Setup
//		// DashBoards
//		// Masters
//		// User Status
//		// API Key Setup
//		// Menu Setup
//		// Site Settings
//
//		// ==> Enter Any avalue realted to this Commneted one
//
//		menusetup.navigateTomenuSetup();
//		menusetup.ClickOnEditOptionBasedOnDefaultName("Workflow Design");
//		menusetup.enterDispalyNameInEditMenuSetupAndVerifyinSideMenu("workflowdesign");
//
//		menusetup.searchThroughPartialNamesinSearchTextfieldUTILITY();
//		menusetup.searchByFormName("givenValue");
////		menusetup.SearchByDisplayName();
////		menusetup.SearchByDisplayName();
//
//		menusetup.cleatfilter();
//
//	}

	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
