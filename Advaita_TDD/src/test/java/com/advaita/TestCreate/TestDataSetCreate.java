package com.advaita.TestCreate;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.QuestionSelector;
import com.advaita.Utilities.ScreenShorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

public class TestDataSetCreate extends TestBase {

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

	public TestDataSetCreate() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/DataSetCreate.html");
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

//	@Test(priority = 1)
//	public void verifyCreateDataset() throws Throwable {
//
//		test = reports.createTest("verifyCreateDataset");
//		HomePage.clickOnProcessManagementCreate();
//		dataset.createDataSet("Text Area");
//
//	}
//	

	@Test(priority = 2)
	public void verifyCreateNewDataset() throws Throwable {
		test = reports.createTest("verifyCreateNewDataset");
		HomePage.clickOnProcessManagementCreate();
		
//		final String dataSetName = "Emplyee Details";
//		 // Data for multiple rows
//	    List<Map<String, String>> fieldData = List.of(
//	        Map.of("FieldName", "Employee Name ?", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"),
//	        Map.of("FieldName", "Employee ID ?", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"),
//	        Map.of("FieldName", "Employee Status ?", "Type", "Boolean", "MaxLength", "20", "IsMandatory", "No"),
//	        Map.of("FieldName", "Employee Status ?", "Type", "Boolean", "MaxLength", "20", "IsMandatory", "No")
//	    );
//		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(fieldData);

		    final String dataSetName = "Employee Details";

		    // Get all questions
		    List<Map<String, String>> allQuestions = DataSet.generateEmployeeQuestions();
		    // Select 5 random questions (or sequentially, set randomSelection to false)
    		// all questions, NumberOfQuestions, boolean randomSelection
		    /**
		     * Select a specific number of questions from a list.
		     *
		     * @param questions List of all available questions.
		     * @param numberOfQuestions Number of questions to select.
		     * @param randomSelection Whether to select questions randomly or not.
		     * @return List of selected questions.
		     */
		    List<Map<String, String>> selectedQuestions = QuestionSelector.selectQuestions(allQuestions, 5, false);

		    dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(selectedQuestions);
		}


	@AfterMethod
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
//		driver.manage().window().minimize();
//		driver.quit();
		reports.flush();
	}

}