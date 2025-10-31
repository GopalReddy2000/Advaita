package com.advaita.TestTable;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.ScreenShorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.datafaker.Faker;

public class TestDataSetTable extends TestBase {

	Faker faker = new Faker();
//	public String num = "24";
//	public String dataSetName = "Test Single Data Set" + num;

	public final String dataSetName = faker.name().lastName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	DataSet dataset;

	public TestDataSetTable() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/DataSetTable.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for DataSet");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		dataset = new DataSet();

	}

	String dataset_filePath = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\DataSet.properties";

	String datset_PropFile;

	@Test
	public void navigateToDatasetPageAndVerify() {

		homePage.clickOnProcessManagementCreate();

		dataset.navigatToDatasetManagemnetPage();

	}

	@Test(dependsOnMethods = "navigateToDatasetPageAndVerify")
	public void navigateToUnarchiveDataSet() {

		navigateToDatasetPageAndVerify();

	}

	@Test(dependsOnMethods = "navigateToDatasetPageAndVerify")
	public void navigateToArchiveDataSet() {

		// navigateToDatasetPageAndVerify();
		dataset.naviateToArchiveDataset("Archived Dataset");
	}

	@Test(priority = 1, dependsOnMethods = { "navigateToDatasetPageAndVerify" })
	public void verifydataSetTablePage() throws Throwable {

		// homePage.clickOnProcessManagementCreate();
		test = reports.createTest("verifydataSetTablePage");
		dataset.dataSetTablePage();
	}

	@Test(dependsOnMethods = { "navigateToDatasetPageAndVerify" })
	public void testDeleteFunction() {
		dataset.deleteDataSet();
	}

//New Funcanality	
//=======================================================================

	// ===>Search

	@Test(description = "Verify The User is able To search Through Dataset manualley", dependsOnMethods = "navigateToDatasetPageAndVerify")
	public void searchDataSetManualley() throws Throwable {

		dataset.searchThroughDatasetName("searchManually");

	}

	@Test(description = "Verify The User is able To search Through Dataset Randomely", dependsOnMethods = "navigateToDatasetPageAndVerify")
	public void searchDataSetRandomely() throws Throwable {

		dataset.searchThroughDatasetName("randomely");

	}

	@Test(description = "Verify The User is able To search Through Dataset partailName", dependsOnMethods = "navigateToDatasetPageAndVerify")
	public void searchDataSetPartialName() throws Throwable {

		dataset.searchThroughDatasetName("partailName");

	}

	// ===>Delete //Neeed To Impleement(pending)

	@Test(description = "verify The user is able To Delete DataSet From Archive Tab", dependsOnMethods = {
			"navigateToArchiveDataSet" }, enabled = false)
	public void testDeleteDatsetFromArchiveAndUnariveTab() throws Throwable {

		datset_PropFile = PropertieFileUtil.getSingleTextFromPropertiesFile(dataset_filePath, "dataSet1");

		dataset.searchThroughDatasetName(datset_PropFile);
		dataset.deleteDatsetFromArchiveTab(datset_PropFile);
	}

	// ===>Archive & UnArchive

	// ===> Archive
	@Test(description = "Verify The User Is a Do Archive Process From UnArchive  DataSet Tab", dependsOnMethods = {
			"navigateToDatasetPageAndVerify" })
	public void archiveDataSetFromUnArchiveTab() throws Throwable {

		dataset.archiveDataset("Archived Dataset","Inactive"); //Unarchived Dataset

	}

	@Test(description = "verify the User is able to Archive Multiple Data Set", dependsOnMethods = {
			"navigateToDatasetPageAndVerify" })
	public void testArchiveMultipleDataSet() {

		dataset.archive_Unarchive_MultipleDatasets(dataset.archiveAction, 1);
	}

	// ==> Unarchive

	@Test(description = "Verify The User Is a Do unArchive Process From Archive  DataSet Tab", dependsOnMethods = {
			"navigateToDatasetPageAndVerify", "navigateToArchiveDataSet" })
	public void unArchiveDataSetFromArchiveTab() throws Throwable {

		 dataset.archiveDataset("Unarchived Dataset","Active"); // need to Implemet(tommorow

	}

	@Test(description = "verify the User is able to unArchive Multiple Data Set", dependsOnMethods = {
			"navigateToDatasetPageAndVerify", "navigateToArchiveDataSet" })
	public void testUnArchiveMultipleDataSet() {

		dataset.archive_Unarchive_MultipleDatasets(dataset.unArchiveAction, 1);

	}

//========================================================================	

//	@AfterMethod
	public void getResult(ITestResult result) throws IOException, Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Mark the test as failed in the ExtentReports
			test.fail(result.getThrowable());
			// Add screenshot to ExtentReports
			String screenshotPath = ScreenShorts.captureScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotPath);

			// Add logs
			test.log(Status.FAIL, "Test failed at " + new Date());

			// Add custom HTML block
			test.log(Status.INFO, MarkupHelper.createCodeBlock("<div>Custom HTML block</div>"));
		}
		// Close ExtentReports
		reports.flush();
	}

	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}