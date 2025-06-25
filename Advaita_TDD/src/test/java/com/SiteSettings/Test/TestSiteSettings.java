package com.SiteSettings.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SiteSetting.pageObject.SiteSettings;
import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

public class TestSiteSettings extends TestBase {

	Faker faker = new Faker();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	SiteSettings siteSettings;

	public TestSiteSettings() {
		super();
	}

	// site Setting Logo path
	String faviconconPath = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\java\\com\\SiteSetting\\pageObject\\FavilconLogo1.jpg";
	String primaryLogoPath = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\java\\com\\SiteSetting\\pageObject\\PrimaryLogo.jpg";
	String secondaryLogoPath = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\java\\com\\SiteSetting\\pageObject\\SecondaryLogo.jpg";

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		siteSettings = new SiteSettings();

	}

	@Test(priority = 1, enabled = true)
	public void verifyTheUserIsAbleToNavigateSiteSettingPage() {

		siteSettings.naviagteSiteSettings();
	}

//	@Test(priority = 2, enabled = true, dependsOnMethods = { "verifyTheUserIsAbleToNavigateSiteSettingPage" })
//	public void VerifyTheUserIsableTOverifySiteSettingPage() {
//
//	}

	@Test(priority = 3, enabled = true)
	public void verifyTheUserIsAbleToCheckSiteNameIsDisableOrNot() throws Throwable {

		siteSettings.naviagteSiteSettings();
		siteSettings.checkDisabledSiteName();
		siteSettings.validateSiteNameValue(siteSettings.siteNameTextfield);
		siteSettings.validateSendKeysAttempt(siteSettings.siteNameTextfield);

	}

	// Edit

	@Test(priority = 4, enabled = true)
	public void verifyTheUserCheckSiteNameIsEnableAfterclickONEditption() {

		siteSettings.naviagteSiteSettings();
		siteSettings.checkSiteNameEnabled();
	}

	@Test(priority = 5, enabled = true)
	public void verifyTheUserIsableToEditSiteNameTextfield() {

		siteSettings.naviagteSiteSettings();
		siteSettings.editSiteNameTextfield();
	}

	@Test(priority = 6, dependsOnMethods = "verifyTheUserIsableToEditSiteNameTextfield")
	public void verifyTheUserIsAbleToAddAndVerfySiteName() throws Throwable {

		siteSettings.addSiteName();
		siteSettings.ClickOnSaveAndVerifyConformationMesgsse();
		siteSettings.verifyTheSiteName();
	}

	int count = 3;

	public void verifyTheUserIsableToAddMultipleUrl() {

		siteSettings.addMultpleUrl(count);
	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNavigateSiteSettingPage" })
	public void addMenuNameAndMenuUrlAndVerifyInAlchemyModule() throws InterruptedException, IOException {

		siteSettings.addMenuNameAndmenuRl(3);

	}

//=================== Upto Here Pass	

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNavigateSiteSettingPage" })
	public void veifyTheUserIsableToUploadFaviconLogo() throws Throwable {

		siteSettings.uploadLogo(siteSettings.editFaviconLogo, faviconconPath);

	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNavigateSiteSettingPage" })
	public void veifyTheUserIsableToUploadPrimaryLogobyEnteringHeightandWidth() throws Throwable {

		siteSettings.verifyTheHeightAndWidthOFThePrmaryLogoAfterPreviewandUpload(siteSettings.editPrimaryElementLogo,
				primaryLogoPath);

	}

//Need To implement and ValidateF
	@Test(dependsOnMethods = { "verifyTheUserIsAbleToNavigateSiteSettingPage" })
	public void verifyTheHeightAndWidthOFTheSecondaryLogoAfterPreviewandSave() throws Throwable {

		siteSettings.verifyTheHeightAndWidthOFTheSecondaryLogoAfterPreviewAndUpload(
				siteSettings.editSecondaryElementLogo, secondaryLogoPath);

	}

	// @AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		// reports.flush();
	}
}
