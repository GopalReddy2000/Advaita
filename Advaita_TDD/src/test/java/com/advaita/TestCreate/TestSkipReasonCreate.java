package com.advaita.TestCreate;

import java.sql.Driver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.alchemyPageObject.SkipReason;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestSkipReasonCreate extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	SkipReason skipReason;

	public TestSkipReasonCreate() {
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

		skipReason = new SkipReason();

	}

	@Test(priority = 1)
	public void CreateSkipreason() throws Throwable {
		skipReason.NavigateToFetchprocess();
		skipReason.navigateTo_AlchemyModule();
		skipReason.NavigateTo_Skipreason();
		skipReason.Crete_SkipReason();
		skipReason.selectProcessDropdown();
		skipReason.SelectSubProcessDropdown();
		skipReason.selectSubSubProcess();
		skipReason.continue_CreateSkinReason();
//		skipReason.reasonTextfields();
//		skipReason.descriptionTextfield();
		skipReason.clickOnCreateSkipReason();
		skipReason.verifyCreatedSkipReasonPopup();
		skipReason.verifyCreatedSkipReason();
		skipReason.captureAllCreatedSkipReasons();
		skipReason.navigateToSkipAudit();
		skipReason.clickOnSkipAuditReason();
		skipReason.selecteSkipReason();
		skipReason.saveAudit();

// SearchBy Reasons Name
		skipReason.searchThroughReasonsName();

//Edit SkipReasons		
		// skipReason.EditSKipReasons();

		// skipReason.CanceCreate_Edit();
		// skipReason.Delete_SkipReasons();
	}

	@Test(priority = 2)
	public void searchByProcesses() throws Throwable {
		skipReason.navigateTo_AlchemyModule();
		skipReason.NavigateTo_Skipreason();

		skipReason.SearchThroughProcesses();

		String[] expectedValues = { "AJP", "Sub AJP", "Sub Sub AJP" };
		skipReason.verifyColumnTitles(driver, expectedValues);

	}

	@Test(priority = 3)
	public void verifyTheUSerIsAbleToclearAllFilter() throws Throwable {

		skipReason.navigateTo_AlchemyModule();
		skipReason.NavigateTo_Skipreason();
		skipReason.SearchThroughProcesses();
		skipReason.ClearFilters();

	}

	@Test(priority = 4)
	public void VerifydeleteReason() throws Throwable {

		skipReason.navigateTo_AlchemyModule();
		skipReason.NavigateTo_Skipreason();
		skipReason.deleteReason();

	}

//#########################################################################################################################
//Negative Testing

	@Test
	public void withoutSelectingReasonTextfield() throws Throwable {

		skipReason.navigateTo_AlchemyModule();
		skipReason.NavigateTo_Skipreason();

		// skipReason.withoutSelectingReasonsTextfield(); //passs

		// skipReason.withoutSelectingProcess(); //pass

		// skipReason.enterAllAndsaveWithoutnonEnterInMandatoryTextfield(); //pass

		// skipReason.saveWithSpecialCharacter(); //Fail_ Error

		// skipReason.selectanInvalidOptionFromDropdown();// ???

		// skipReason.searchinvalidCreatedNamesInSearchField();

		// skipReason.searchThroughEmojisInSearchTextfield();

		// skipReason.verifyAfterDeleteCreatedSkipReasonsDisplayedInSkipTheAudit();

	}

	@Test
	public void searchThroughProcessesInSearchTextfield() throws Throwable {

		skipReason.searchThroughProcessesInSearchTextfield();

	}

	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}
