package com.advaita.TestCreate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import Advaita_TDD.Advaita_TDD.Questions;
import net.datafaker.Faker;

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
	
	HomePage hp = new HomePage();

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
	public void verifyManualCreateNewDataset() throws Throwable {
		HomePage hp = new HomePage();
		test = reports.createTest("verifyCreateNewDataset");
		hp.clickOnProcessManagementCreate();

		final String dataSetName = "Emplyee DetailsABCDEFGHIJ";
		// Data for multiple rows
		List<Map<String, String>> fieldData = List.of(
			    Map.of("FieldName", "How do you handle work stress", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"),
			    Map.of("FieldName", "What skills do you want to learn", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"),
			    
			    // 20 Additional Questions (All Text Area Type)
			    Map.of("FieldName", "What motivates you at work?", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"),
			    Map.of("FieldName", "How do you define success?", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"),
			    Map.of("FieldName", "What challenges do you face?", "Type", "Text Area", "MaxLength", "300", "IsMandatory", "Yes"),
			    Map.of("FieldName", "How do you stay productive?", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"),
			    Map.of("FieldName", "What makes a great workplace?", "Type", "Text Area", "MaxLength", "400", "IsMandatory", "Yes"),
			    Map.of("FieldName", "How do you handle feedback?", "Type", "Text Area", "MaxLength", "300", "IsMandatory", "Yes"),
			    Map.of("FieldName", "What inspires you daily?", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"),
			    Map.of("FieldName", "How do you manage tight deadlines?", "Type", "Text Area", "MaxLength", "350", "IsMandatory", "Yes"),
			    Map.of("FieldName", "What leadership qualities do you admire?", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No")
	
			);

		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(fieldData)
				.createDataSetButtonAndConfirmation();

	}

	@Test(priority = 3)
	public void verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType() throws Throwable {
		HomePage hp = new HomePage();
		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithSpecifyingType");
		hp.clickOnProcessManagementCreate();

		final String dataSetName = "Employee Details";
		// Get all questions
		List<Map<String, String>> allQuestions = Questions.generateEmployeeQuestions();
		// Define the types and order of questions you want to select
		// Character,Text Area,Date Time,Date,Number,Boolean,HyperLink
		List<String> types = Arrays.asList("Character", "Date Time", "Boolean", "Date");
		// Select questions based on types and order
		List<Map<String, String>> selectedQuestions = QuestionSelector.selectQuestions(allQuestions, types, 8, true);
		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(selectedQuestions)
				.createDataSetButtonAndConfirmation();

	}

	@Test(priority = 4)
	public void verifyAutoGenerateQuestionCreateNewDatasetWithOutSpecifyingType() throws Throwable {
		test = reports.createTest("verifyAutoGenerateQuestionCreateNewDatasetWithOutSpecifyingType");
		hp.clickOnProcessManagementCreate();

		final String dataSetName = "Customer Details";
		// Get all questions
		List<Map<String, String>> allQuestions = Questions.generateCustomerQuestions();

//	    Without specifying the Type (new ArrayList<>())
		List<Map<String, String>> selectedQuestions = QuestionSelector.selectQuestions(allQuestions, new ArrayList<>(),
				5, true);

		dataset.navigateToDataSetup().createNewDataSet(dataSetName).enterFieldNameAndValidations(selectedQuestions)
				.createDataSetButtonAndConfirmation();
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