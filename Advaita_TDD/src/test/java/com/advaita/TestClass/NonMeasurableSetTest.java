package com.advaita.TestClass;

import Advaita_TDD.Advaita_TDD.FakeData;
import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.NonMeasurableSetPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class NonMeasurableSetTest extends TestBase {

	static int createCount = 2;

//	Faker faker = new Faker();
//		public String num = "24";
//	public String questionSet = faker.name().lastName() + " TestAudit";

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	NonMeasurableSetPage nonMeasurableSetPage;

	public NonMeasurableSetTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Throwable {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");

		htmlReporter = new ExtentSparkReporter("extentreport Advaita Non-MeasurableSetPage.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for Non-MeasurableSetPage");
		htmlReporter.config().setReportName("TEST Advaita");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		nonMeasurableSetPage = new NonMeasurableSetPage();
	}

	@Test(priority = 1)
	public void verifyNonMeasurableSetCreatePage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetCreatePage");
		homePage.clickOnNonMeasurableSet();
//		nonMeasurableSetPage.nonMeasurableSetCreatePage(createCount);

	}

	@Test(priority = 2)
	public void verifyNonMeasurableSetEditePage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetEditPage");
		homePage.clickOnNonMeasurableSet();
		nonMeasurableSetPage.nonMeasurableSetEditPage();
	}

	@Test(priority = 3)
	public void verifyNonMeasurableSetTablePage() throws Throwable {

		test = reports.createTest("verifyNonMeasurableSetTablePage");
		homePage.clickOnNonMeasurableSet();
		nonMeasurableSetPage.nonMeasurableSetTablePage();

	}


	@Test
	public void dropdown()
	{
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName("Dropdown")
				.dropdownAndMultiSelect(dropDown,1,1,"Dropdown1",dropdownOptions,"no","yes","yes")
				.addQuestion(1)
				.dropdownAndMultiSelect(multipleChoice,1,2,"Dropdown2",dropdownOptions,"yes","no","yes")
				.addSection()
				.dropdownAndMultiSelect(relativeDropdown,2,1,"Dropdown3",dropdownOptions,"yes","no","no")
				.saveRecord2()

		;

	}

	List<String> dropdownOptions = List.of(
			"Option 1",
			"Option 2",
			"Option 3",
			"Option 4",
			"Option 5"
	);

	@Test
	public void cloudUpload(){
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.clickOnUploadButton("Dropdown","1")

		;
	}

	@Test
	public void textBox() {
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName("TextBox")
				.textBox(textBox,
						1,
						1,
						"TextBox",
						"no",
						"yes",
						"1",
						"250",
						"Is Email",
						"no")

		;
	}

	@Test
	public void shortAnswer() {
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName("ShortAnswer")
				.shortAnswer(shortAnswer,
						1,
						1,
						"shortAnswer",
						"no",
						"yes",
						"1",
						"250",
						"All",
						"no")

		;
	}

	@Test
	public void fileUpload()
	{
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName("fileUpload")
				.fileUpload(fileUpload,1,1,
						"FileUpload","yes",
						"no",".yml",
						"no","no",
						"10","GB")

		;
	}

	@Test
	public void radioButton()
	{
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName("radioButton")
				.radioButton(radioButton, 1,1,"RadioButton","yes","no",radioBtnOptions)

		;
	}

	List<String> radioBtnOptions=List.of(
			"Yes","No"
	);

	@Test
	public void date()
	{
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName("date")
				.date(date,1,1,"Date","yes","no","Current Date +","20","Current Date -","20",1)

		;
	}




	final int label=1;
	final int multipleChoice=2;
	final int shortAnswer=3;
	final int dropDown=4;
	final int relativeDropdown=5;
	final int fileUpload=6;
	final int radioButton=7;
	final int date=8;
	final int time=9;
	final int textBox=10;
	final int relativeMultiselect=11;


//	Negative Scenarios

	@Test(dataProvider = "forQuestionSet")
	public void QuestionSetName(String inputs)
	{
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName(inputs)
				.inputAssertionsForQuestionSetName("Question1");

	}
	@Test(dataProvider = "forQuestions")
	public void QuestionName(String questionName,String inputs)
	{
		nonMeasurableSetPage.NavToNonMeasurableTablePage()
				.createQuestionSetName(questionName)
				.inputAssertionsForQuestions(inputs);

	}

	@DataProvider(name = "forQuestions")
	public Object[][] provideStrings() {
		return new Object[][]{
				{"Question 1",""}, // Empty input
				{"Question 2","    "}, // Whitespace only
				{"Question 3","A".repeat(256)},
				{"Question 4","  Jane  "},
				{"Question 5","9876543210"},
				{"Question 6","!@#$%^&*()_+-={}|[]\\:\";'<>?,./"},
				{"Question 7","こんにちは"},
				{"Question 8","😊🚀"},

		};

	}
	@DataProvider(name = "forQuestionSet")
	public Object[][] forQuestions() {
		return new Object[][]{
				{""}, // Empty input
				{"    "}, // Whitespace only
				{"A".repeat(256)},
				{"  Jane  "},
				{"9876543210"},
				{"!@#$%^&*()_+-={}|[]\\:\";'<>?,./"},
				{"こんにちは"},
				{"😊🚀"},

		};

	}
	FakeData fakeData= new FakeData();
	@Test
	public void shortAndText()
	{
		nonMeasurableSetPage.NavToNonMeasurableTablePage()
				.createQuestionSetName("ShortAns"+FakeData.lastName1())
				.shortAnswer(shortAnswer,
						1,
						1,
						"shortAnswer",
						"no",
						"yes",
						"1500",
						"-250",
						"All",
						"yes")
				.validateMinAndMaxLen(1,1)
		;
	}

	@Test
	public void fileformat()
	{
		nonMeasurableSetPage.NavToNonMeasurableTablePage()
				.createQuestionSetName("ShortAns"+FakeData.lastName1())
				.negativeFileUpload("FileUpload",fileUpload,1,1)

		;
	}
	@Test
	public void maxMinDate()
	{
		nonMeasurableSetPage.NavToNonMeasurableTablePage()
				.createQuestionSetName("ShortAns"+FakeData.lastName1())
				.maxAndMinDate("Date",date,1,1,"Current Date -","Current Date","1","1","min");

	}

	@Test(dataProvider = "forShortAnswer")
	public void shortAnsValuType(String questionSetName,String ValueType,String InputInStagesRecord,int allowSpChar)
	{
		nonMeasurableSetPage.NavToNonMeasurableTablePage()
				.createQuestionSetName(questionSetName)
				.shortAnswerValType("ShortAnswer",shortAnswer,1,1,"1","10",ValueType,allowSpChar)
				.stagesAdd("Section 1",questionSetName)
				.ValueTypeValidate(InputInStagesRecord)
		;
	}

	@DataProvider(name="forShortAnswer")
	private Object[][] forShortAnswer()
	{
		return new Object[][]{
				{"ShortAnsValueType"+FakeData.lastName1(),"Only Text","4211111",1},
				{"ShortAnsValueType"+FakeData.lastName1(),"Only Number","Non Numerics",1},
				{"ShortAnsValueType"+FakeData.lastName1(),"Only Text","More Than ten texts",1},
				{"ShortAnsValueType"+FakeData.lastName1(),"Only Number","1234567890987654321",1},
				{"ShortAnsValueType"+FakeData.lastName1(),"Only Number","+91@$ 2345678909",0},
				{"ShortAnsValueType"+FakeData.lastName1(),"Only Text","+:{-+><?/}{",0}
		};


	}
//	String questionSetName="FileUpload "+FakeData.lastName1();
	@Test(dataProvider = "forFileUpload")
	public void negFileUpload(String questionSetName,List<String> fileExe,int uploadMultiple,int delete,String MaxSize,String fileUnit,String singleFileUpload)
	{
		nonMeasurableSetPage
				.NavToNonMeasurableTablePage()
				.createQuestionSetName(questionSetName)
				.negativeFileUpload("FILE Upload",fileUpload,1,1,fileExe,uploadMultiple,delete,MaxSize,fileUnit)
				.stagesAdd("section F",questionSetName)
				.validateFileUpload(uploadMultiple,UploadFile1,UploadFile2,UploadFile3,singleFileUpload,delete)
		;

	}

	List<String> fileExe=List.of(".pdf",".csv",".xlsx");

	@DataProvider(name="forFileUpload")
	public Object[][] forFileUploads()
	{
		return new Object[][]{
//				{"FileUpload "+FakeData.lastName1(),fileExe,1,0,"1","MB",txtFile},
				{"FileUpload "+FakeData.lastName1(),fileExe,1,0,"1","MB",moreThan1MBPDF},
//				{"FileUpload "+FakeData.lastName1(),fileExe,0,0,"1","MB",moreThan1MBPDF},
//				{"FileUpload "+FakeData.lastName1(),fileExe,0,0,"1","MB",0},
		};
	}
	String txtFile="E:/NotePads/NewDefects.txt";
	String moreThan1MBPDF="E:/Books/Cem Kaner. - Lessons Learned in Software Testing_ A Context-Driven Approach.pdf";
	String UploadFile1="C:/Users/W2390/IdeaProjects/Advaita/Advaita_TDD/Upload Files/Dropdown 1.xlsx";
	String UploadFile2="C:/Users/W2390/IdeaProjects/Advaita/Advaita_TDD/Upload Files/Dropdown 2.xlsx";
	String UploadFile3="C:/Users/W2390/IdeaProjects/Advaita/Advaita_TDD/Upload Files/Dropdown 3.xlsx";




	@AfterMethod
	public void tearDown() {

//		driver.manage().window().minimize();
//		driver.quit();
//		ExtentManager.unload();
//		reports.flush();
	}


}
