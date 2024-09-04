package com.advaita.TestCreate;

import org.apache.xmlbeans.impl.repackage.EditBuildScript;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.UserStatus.pageobject.userStatus;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class TestUserStatusCreate extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	userStatus userStatus;

	public TestUserStatusCreate() {
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

		userStatus = new userStatus(); // object creation with referenac of class

	}

	// @Test(priority = 1)
	public void navigateToMenusSetup() throws Throwable {
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
	}

	// @Test(priority = 3)
	public void navigateToUserStatus() throws Throwable {
		userStatus.NavigateToUserStatus();

	}

	// @Test(priority = 4)
	public void createUserStatus() {
		userStatus.createUserStatus();
		//userStatus.statusNameInputField();
		userStatus.descriptionField();
	}

	// @Test(priority = 5)
	public void MultiselectDropdwon() throws Throwable {
		userStatus.menusToHideDropdwon();
		userStatus.CreateButtonclick();
		userStatus.verifyCreatedStatus();
		// userStatus.CreatedStatusList();
	}
	
//##########################
	//Create
	@Test
	public void createHideStatus() throws Throwable {
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.NavigateToUserStatus();
		userStatus.createUserStatus();
		userStatus.statusNameInputField("Trainee Employee");
		userStatus.descriptionField();
		userStatus.menusToHideDropdwon();
		userStatus.CreateButtonclick();
		userStatus.verifyCreatedStatus();
//		userStatus.CreatedStatusList();
		userStatus.selectStatusHideSingleMenus();   //select "status"with Single "Hide" menus      
//		userStatus.selectStatusHideMultipleMenus(); //Select "Status" with multiple "Hide Menus"			
	}
	
	//Table
//	@Test
	public void userStatusTable() throws Throwable {
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.NavigateToUserStatus();
		
		userStatus.searchStatus();
		userStatus.clearallFiltes();
		userStatus.DeleteStatus();
	}
	  //Edit
	//@Test
	public void UserStatusEdit() throws Throwable {
		
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.NavigateToUserStatus();
		
		userStatus.EditStatus();  //Edit mandatory field name
		userStatus.EditDescriptnField();  
		userStatus.multiseletToMenuHide();
	}
	
	//@Test
	public void navigateToAmdinProfile() throws Throwable 
	{
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.NavigateToUserStatus();
		userStatus.createUserStatus();
		userStatus.statusNameInputField("Admin");
		userStatus.descriptionField();
	}

}
