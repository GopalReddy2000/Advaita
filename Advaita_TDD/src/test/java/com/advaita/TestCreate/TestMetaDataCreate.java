package com.advaita.TestCreate;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ScreenShorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import static com.advaita.DataSetUp.PageObject.ProcessPage.selectProcessDropDown;
import static com.advaita.DataSetUp.PageObject.ProcessPage.selectSubProcessDropDown;

public class TestMetaDataCreate extends TestBase {

	Faker faker = new Faker();

	public String metaDataName = "Test " + faker.name().firstName();

//	public String num = "7";
//	public String metaDataName = "Test Single MetaData" + num;

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;
	HomePage hp;
	MetaData metaData;

	public TestMetaDataCreate() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		metaData = new MetaData();

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MetaDataCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

//		hp = new HomePage();
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



	}
	


	@Test(priority = 1)
	public void verifyCreateMetaData() throws Throwable {

		test = reports.createTest("verifyCreateMetaData");
		hp.clickOnProcessManagementCreate();
		metaData.createMetaData(metaDataName);

	}

	@Test(priority = 2)
	public void verifynewCreateMetaData() throws Throwable {

		test = reports.createTest("verifynewCreateMetaData");
		hp.clickOnProcessManagementCreate();

		final String metaDataName = "Customer Details MetaData";
		metaData.navigateToMetaData().createNewMetaData(metaDataName).verifyCreateButtonAndConfirmation();

	}

	@Test
	public void testEmptyDropdown()
	{
		metaData.validateDatasetDropdown(metaData.selectProcessDropDown);

	}

	@DataProvider(name="metaDataDropdowns")
	public Object[][] dropdowns()
	{
		return new Object[][]{
				{metaData.selectProcessDropDown},
				{metaData.selectSubProcessDropDown},
				{metaData.selectSubSubProcessDropDown},
				{metaData.selectDataSetDropDown}
		};
	}

	@Test(dataProvider = "invalidRecordNameData")
	public void setMetaDataName(String metaDataName,String errorMessage)
	{
		metaData. navToMetadataTable()
		.metaDataTextBox(metaDataName,errorMessage);
	}



	@DataProvider(name = "invalidRecordNameData")
	public Object[][] invalidRecordNameData() {
		return new Object[][] {
				{"", "This field is required."},
				{"   ", "Record name cannot be just spaces."},
				{"a".repeat(258), "Record name cannot exceed 255 characters."},
				{"ƀ Ɓ Ƃ ƃ Ƅ ƅ Ɔ Ƈ ƈ Ɖ Ɗ Ƌ", "Record name cannot contain Unicode characters."},
				{"#Record$", "Record name cannot contain special characters."},
				{"123456", "Record name cannot be numeric only."},
				{"!!!@@@", "Record name cannot be only special characters."},
				{"SELECT * FROM records", "Invalid input detected."},
				{"<record>Test</record>", "Invalid input detected."},
				{"record    name", "Record name cannot contain consecutive spaces."},
				{"DemoEmpJ Details MetaData", "Metadata Name Already Exists"}
		};
	}


	/*public void getResult(ITestResult result) throws IOException, Throwable {
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
	}*/

	@AfterMethod
	public void tearDown() {
//		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}

}