package com.TestApiKeySetup;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ApiKeySetup.pageObject.ApiKeySetup;
import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

public class TestApiKeySetup extends TestBase {

	Faker faker = new Faker();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	ApiKeySetup apiKeySetup;

	public TestApiKeySetup() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

//		 htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
//		 "/Reports/MetaDataCreate.html");
//		reports = new ExtentReports();
//		reports.attachReporter(htmlReporter);

		// add environment details
//		reports.setSystemInfo("Machine", "Testpc1");
//		reports.setSystemInfo("OS", "Windows 11");
//		reports.setSystemInfo("user", "Gopal");
//		reports.setSystemInfo("Browser", "Chrome");
//
//		// Configuration to change look and feel
//		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
//		// htmlReporter.config().setReportName("TEST Advaita-MetaData");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTimelineEnabled(true);
//		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		apiKeySetup = new ApiKeySetup();

	}

	// <<<<global variable
	// AuthType
	public String noAuth_Case2 = "NoAuth";
	public String apiKey_Case3 = "API Key";
	public String bearerToken_Case4 = "Bearer Token";
	public String basicAuth_Case5 = "Basic Auth";
	public String OAuth2_Case6 = "OAuth2";

	// keyFor
	public String sms_KeyFor2 = "SMS";
	public String whatsApp_KeyFor3 = "WhatsAPP";
	public String email_KeyFor4 = "Email";
	public String whatsAppBusiness_KeyFor5 = "WhatsApp Business";

	// MethodTye
	public String MethodType2_case = "GET";
	public String MethodType3 = "POST";
	public String MethodType4 = "PUT";
	public String MethodType5 = "DELETE";

	@Test(priority = 1, enabled = true)
	public void verifyTheUserIsAbleToCreateNaviagtePage() throws Throwable {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.naviagteToCreate();

		apiKeySetup.EnterApiName();
		apiKeySetup.selectProcess("givenprocessname");
		apiKeySetup.selectSubProcess("givenSubprocessname");
		apiKeySetup.selectSubSubProcess("givensubsubprocessname");
		apiKeySetup.selectStages("givenStageName");
		apiKeySetup.selectKeyFor("givenkeyoption");
		apiKeySetup.SelectAuthType();
		apiKeySetup.SelectMethodType("givenMethodType");
		apiKeySetup.EnertApiUrl();

		apiKeySetup.EnertVendorName();
		apiKeySetup.enterHeaderName();
		apiKeySetup.enterHeaderValue();

		// apiKeySetup.addRowMultipleClick(5); //Implementation Pending

		apiKeySetup.enterFieldName();
		apiKeySetup.enterFieldValue();

		apiKeySetup.entervariableName();

		apiKeySetup.clickOnCreateAndVerify();

	}

	@Test(priority = 2, enabled = true)
	public void userIsAbleTOVerifyCreatedApiName() throws IOException {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();

		apiKeySetup.verifyCreatedApiName();
	}

	@Test(priority = 3, enabled = true) // Implementation Pending
	public void verifyTheUserIsAbleToAddMultipleRows() {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.naviagteToCreate();

		// apiKeySetup.AddMutipleOption();
	}

	@Test(priority = 6, enabled = true)
	public void verifyTheUserIsAbleToSearchApiNameThroughProcess() throws IOException {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.selectProcessInApiTablePage();
		apiKeySetup.clickOnSearchButton();
		apiKeySetup.verifyselectedProcessShouldMatchWithProcess();
	}

	@Test(priority = 7, enabled = true)
	public void verifyTheUserIsAbleToSearchApiNameThroughSubProcess() throws Throwable {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.selectProcessInApiTablePage();

		apiKeySetup.selectProcessInApiTablePage();
		apiKeySetup.selectSubProcessInApiTablePage();
		apiKeySetup.selectSubSubProcessInApiTablePage();
		apiKeySetup.clickOnSearchButton();
		apiKeySetup.verifyselectedSubProcessShouldMatchWithSubProcess();
	}

	@Test(priority = 8, enabled = true)
	public void verifyTheUserIsAbleToSearchApiNameThroughSubSubProcess() throws Throwable {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.selectProcessInApiTablePage();

		apiKeySetup.selectProcessInApiTablePage();
		apiKeySetup.selectSubProcessInApiTablePage();
		apiKeySetup.selectSubSubProcessInApiTablePage();
		apiKeySetup.clickOnSearchButton();
		apiKeySetup.verifyselectedSubSubProcessShouldMatchWithSubSubProcess();

	}

	@Test(priority = 9, enabled = true)
	public void verifyTheUserIsAbleToSearchApiNameThroughStages() throws Throwable {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.selectProcessInApiTablePage();

		apiKeySetup.selectProcessInApiTablePage();
		apiKeySetup.selectSubProcessInApiTablePage();
		apiKeySetup.selectSubSubProcessInApiTablePage();
		apiKeySetup.searchThroughStages();

	}

	// Delete
	@Test
	public void verifyTheUserIsAbleToDeleteAndVerifyDeletedApiName() throws IOException {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.selectProcessInApiTablePage();

		apiKeySetup.selectProcessInApiTablePage();
		apiKeySetup.clickOnSearchButton();
		apiKeySetup.verifyselectedProcessShouldMatchWithProcess();

		apiKeySetup.deleteApiNameAndcheckIisDeletedOrNot();

	}

	// Random Select Process
	@Test(priority = 1, enabled = true)
	public void verifyTheuserisableToSelectRandomProcess() throws Throwable {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.naviagteToCreate();

		apiKeySetup.EnterApiName();
	}

	// Crate API key name Dynaically Based On Give parameter
	@Test
	public void createApiKeyDynamically() throws Throwable {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.naviagteToCreate();

		apiKeySetup.EnterApiName();
		apiKeySetup.selectProcess("givenprocessname");
		apiKeySetup.selectSubProcess("givenSubprocessname");
		apiKeySetup.selectSubSubProcess("givensubsubprocessname");
		apiKeySetup.selectStages("givenStageName");
		apiKeySetup.selectKeyFor("givenkeyoption"); // Case
		apiKeySetup.handleAuthTypeSelection(OAuth2_Case6);// case
		apiKeySetup.SelectMethodType("givenMethodType");// case
		apiKeySetup.EnertApiUrl();
		apiKeySetup.EnertVendorName();
		apiKeySetup.enterHeaderName();
		apiKeySetup.enterHeaderValue();
		apiKeySetup.entervariableName();

		apiKeySetup.clickOnCreateAndVerify();
		apiKeySetup.verifyCreatedApiName();

	}

	// Crate APIKey Randomely(Keyfor,AuthType,MethodType)
	@Test
	public void createApiKeyRandomely() throws Throwable {

		apiKeySetup.naviagteToAPiKeySetup();
		apiKeySetup.verifyApiKeysetp();
		apiKeySetup.naviagteToCreate();

		apiKeySetup.EnterApiName();
		apiKeySetup.selectProcess("randomprocess");
		apiKeySetup.selectSubProcess("randomSubprocess");
		apiKeySetup.selectSubSubProcess("randomSubSubprocess");
		apiKeySetup.selectStages("randomStage");
		apiKeySetup.selectKeyFor("randomkeyoption"); // case
		apiKeySetup.handleAuthTypeSelection(null); // Null= for pass radom Method Type
		apiKeySetup.SelectMethodType("RandomMethodType"); // case
		apiKeySetup.EnertApiUrl();
		apiKeySetup.EnertVendorName();
		apiKeySetup.enterHeaderName();
		apiKeySetup.enterHeaderValue();
		apiKeySetup.entervariableName();

		apiKeySetup.clickOnCreateAndVerify();
		apiKeySetup.verifyCreatedApiName();

	}

//	@AfterMethod
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		// reports.flush();
	}

}
