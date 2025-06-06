package com.advaita.TestClass;

import static Advaita_TDD.Advaita_TDD.FakeData.lastName2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.datafaker.Faker;

public class VerifyDataSet extends TestBase {

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

	public VerifyDataSet() {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita DataSet.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "");
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
//		homePage.clickOnProcessManagementCreate();
//		dataset.createDataSet("Test Field Name", "Test Label Name", "100", "Text Area");
//
//	}
//
//	@Test(priority = 2)
//	public void verifyEditDataset() throws Throwable {
//
//		test = reports.createTest("verifyEditDataset");
////		homePage.clickOnProcessManagementCreate();
//		dataset.editDataSet("Edit dataSetName");
//	}

	@Test(priority = 3)
	public void verifydataSetTablePage() throws Throwable {

		test = reports.createTest("verifydataSetTablePage");
//		homePage.clickOnProcessManagementCreate();
		dataset.dataSetTablePage();
	}
	@Test()
	public void delDataset()
	{
		homePage.clickOnProcessManagementCreate();
		dataset.deleteDataSet();
	}

	@AfterMethod
	public void back(){
		dataset.close();
	}
//	Dataset Fields

	final String character="Character";
	final String textArea="Text Area";
	final String dateTime="Date Time";
	final String date="Date";
	final String number="Number";
	final String booleanV="Boolean";
	final String file="File";
	final String hyperLink="HyperLink";

	@Test(dataProvider = "negativeDatasetTestData")
	public void datasetName(String dataSetName,String datasetError){
		dataset
				.navToDataset()
				.createDatasetButton()
				.datasetNameField(dataSetName).processDropdown("AJP").subProcessDropdown("Sub AJP").subSubProcessDropdown("Sub Sub AJP")
				.recordCreateButton()
				.datasetError(datasetError)

		;
	}

	@Test
	public void emptyFieldsAndLabels(){
		dataset
				.navToDataset()
				.createDatasetButton()
				.datasetNameField(dataSetName).processDropdown("AJP").subProcessDropdown("Sub AJP").subSubProcessDropdown("Sub Sub AJP")

				.addRow().addRow()
				.datasetCreate();
// NO Error Codes to Assert Negatively
	}


	@Test(dataProvider = "fieldsNameTestData")
	public void fieldNameInput(int fieldName,String fieldNameData,String errorMessage){
		dataset
				.navToDataset()
				.createDatasetButton()
				.datasetNameField("dataSetName"+lastName2()).processDropdown("AJP").subProcessDropdown("Sub AJP").subSubProcessDropdown("Sub Sub AJP")
				.fieldNameInput(fieldName,fieldNameData)
//				NO Error Codes to Assert Negatively
				.datasetCreate()
		;

	}

	@Test(dataProvider = "fieldsNameTestData")
	public void labelNameInput(int fieldName,String fieldNameData,String errorMessage){
		dataset
				.navToDataset()
				.createDatasetButton()
				.datasetNameField("dataSetName"+lastName2()).processDropdown("AJP").subProcessDropdown("Sub AJP").subSubProcessDropdown("Sub Sub AJP")
				.labelNameInput(fieldName,fieldNameData)
//				NO Error Codes to Assert Negatively
				.datasetCreate()
		;

	}

	@Test(dataProvider = "fieldsNameTestData")
	public void maxMinInput(int fieldName,String fieldNameData,String errorMessage){
		dataset
				.navToDataset()
				.createDatasetButton()
				.datasetNameField("dataSetName"+lastName2()).processDropdown("AJP").subProcessDropdown("Sub AJP").subSubProcessDropdown("Sub Sub AJP")
				.maxLengthFields(fieldName,fieldNameData)
//				NO Error Codes to Assert Negatively
				.datasetCreate()
		;

	}

	@DataProvider(name = "fieldsNameTestData")
	public static Object[][] fieldsNameTestData() {
		return new Object[][]{
				// Only Spaces
				{1,"   ", "Input should be ignored or show an error message."},

				// Exceeding Character Limit (Assume max limit is 50)
				{1,"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", "Input exceeds max length of 50 characters."},

				// Special Characters
				{1,"@#$%^&*", "Special characters are not allowed."},

				// SQL Injection
				{1,"'; DROP TABLE users; --", "Invalid characters in input."},

				// Script Injection (XSS)
				{1,"<script>alert('XSS')</script>", "Invalid characters in input."},

				// Numeric Input (If Not Allowed)
				{1,"1234567890", "Numeric input is not valid."},

				// Non-ASCII or Unicode Characters
				{1,"你好", "Non-ASCII characters are not allowed."},
				{1,"😊", "Emojis are not allowed."},

				// Leading and Trailing Spaces
				{1,"  ValidInput", "Leading spaces should be trimmed or show an error message."},
				{1,"ValidInput  ", "Trailing spaces should be trimmed or show an error message."},

				// Single Character Input (if min length is 3)
				{1,"A", "Input must be at least 3 characters long."},

				// HTML Special Characters
				{1,"&<>'\"/", "HTML special characters are not allowed."},

				// Newline Characters
				{1,"Line1\nLine2", "Newline characters are not allowed."},

				// Extremely Long Input
				{1,"a".repeat(5000), "Input exceeds the maximum allowed length."}
		};
	}


	@DataProvider(name = "negativeDatasetTestData")
	public static Object[][] negativeTestData() {
		return new Object[][]{
				// Empty Input
				{"", "This field is required."},

				// Spaces Only
				{"   ", "Record name cannot be blank."},

				// Exceeding Character Limit (Assume max limit is 50)
				{"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", "Record name cannot exceed 50 characters."},

				// Invalid Special Characters
				{"@#$%^&*", "Special characters are not allowed in the record name."},

				// SQL Injection
				{"'; DROP TABLE users; --", "Invalid characters in record name."},

				// Script Injection (XSS)
				{"<script>alert('XSS')</script>", "Invalid characters in record name."},

				// Numeric Input (If Not Allowed)
				{"1234567890", "Record name cannot be numeric."},

				// Non-ASCII or Unicode Characters
				{"你好", "Invalid characters in record name."},
				{"😊", "Invalid characters in record name."},

				// Leading and Trailing Spaces
				{"  RecordName", "Leading and trailing spaces are not allowed."},
				{"RecordName  ", "Leading and trailing spaces are not allowed."},

				// Duplicate Record Name
				{"DataSet Ebert", "Record name already exists."},

				// Single Character Input (Assume minimum length is 3)
				{"A", "Record name must be at least 3 characters long."},

				// Newline Characters
				{"RecordName\nAnotherLine", "Newline characters are not allowed in the record name."},

				// HTML Special Characters
				{"&<>'\"/", "Invalid characters in record name."},

				// Extremely Long Input (Assume max limit is 50)
				{"a".repeat(5000), "Input exceeds the maximum allowed length."}
		};
	}


	@AfterTest
	public void tearDown() {

		driver.manage().window().minimize();
		driver.quit();
		reports.flush();

	}

}
