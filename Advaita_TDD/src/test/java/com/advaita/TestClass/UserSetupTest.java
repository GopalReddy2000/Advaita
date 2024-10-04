package com.advaita.TestClass;

import Advaita_TDD.Advaita_TDD.FakeData;
import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.Process;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ExcelUserManagement;
import com.advaita.Utilities.ExcelUtils;
import com.advaita.WorkFlowDesign.PageObject.Disposition;
import com.advaita.WorkFlowDesign.PageObject.MeasurableSetPage;
import com.advaita.pageObjects.NonMeasurableSetPage;
import com.advaita.pageObjects.UserSetupPage;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class UserSetupTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	UserSetupPage userSetupPage;
	MeasurableSetPage measurableSetPage;
	NonMeasurableSetPage nonMeasurableSetPage;
	Disposition disposition;


	com.advaita.DataSetUp.PageObject.Process process;
	FakeData fake = new FakeData();
	public String processName = "P " + fake.lastName1();

	public String processDesc = "P Desc";

	public String subProcessName = "SP" + fake.lastName1();

	public String subProcessDesc = "SP Desc";

	public String subSubProcessName = "SSP " + fake.lastName1();

	public String subSubProcessDesc = "SSP Desc";

	public String metaDataName = "Test " + fake.lastName1();

	DataSet dataset;


	String roleNameForAlchemy=FakeData.lastName1()+" Alchemy";
	String roleNameForDataset=FakeData.lastName1()+" Dataset";
	String roleNameForWorkflowDesign=FakeData.lastName1()+" Workflow Design";
	String roleNameForUserSetup=FakeData.lastName1()+" User Setup";
	String roleNameForUserStatus=FakeData.lastName1()+" User Status";
	String roleNameForAPIKey=FakeData.lastName1()+" API Key";
	String roleNameForMenu=FakeData.lastName1()+" Menu";
	String roleNameForSiteSettings=FakeData.lastName1()+" Site Settings";

	String roleNameToViewLeftMenu1=FakeData.lastName1()+" ViewLeftMenu1";
	String roleNameToViewLeftMenu2=FakeData.lastName1()+" ViewLeftMenu2";
	String roleNameToViewUserSetup=FakeData.lastName1()+" ViewUserSetup";
	String roleNameToViewAlchemySubMenu1=FakeData.lastName1()+" ViewAlchemySubMenu1";
	String roleNameToViewAlchemySubMenu2=FakeData.lastName1()+" ViewAlchemySubMenu2";
	String roleNameToViewAlchemySubMenu3=FakeData.lastName1()+" ViewAlchemySubMenu3";
	String roleNameToViewAlchemySubMenu4=FakeData.lastName1()+" ViewAlchemySubMenu4";


	String FirstName=FakeData.lastName1();

	String LastName=FakeData.lastName2();
	String Password="Qwerty@123";
	ExcelUserManagement excelUserManagement;
	UserSetupTest()

	{
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception   {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");
		userSetupPage =new UserSetupPage();
		process=new Process();
		dataset=new DataSet();
		measurableSetPage=new MeasurableSetPage();
		nonMeasurableSetPage=new NonMeasurableSetPage();
		disposition= new Disposition();
		excelUserManagement= new ExcelUserManagement();
	}

	@Test
	public void navigationTest()
	{
		userSetupPage.navToUserCreatePage();
		assertEquals(driver.getTitle(), "TEST Capture");
	}


	@Test
	public void userTest()
	{
		userSetupPage.navToUserCreatePage()
				.userCreationFields(FirstName,LastName,Password);
	}



	@Test
	public void roleCreate()
	{

		userSetupPage.navToRoleAndPerCreate()
				.createRoles(roleNameForAlchemy,"Alchemy",userSetupPage.excelToUploadModulePermissions);
	}

	@Test
	public void groupNameInputField()
	{
		userSetupPage
				.navToRoleAndPerTable().
				validateGroupNameInputField(userSetupPage.roleTableNames.get(userSetupPage.getRandomIndex(userSetupPage.roleTableNames)).getText());
	}

	String roleAllGroupName=FakeData.lastName1()+" All Permission";
	@Test
	public void roleAllCreateAndDelete()
	{
		userSetupPage.navToRoleAndPerCreate()
				.createUserWithRoleAll(roleAllGroupName).deleteRoleByName(roleAllGroupName);
		//		UserSetupPage.RolesCreated.add(roleAllGroupName);
	}


	@Test
	public void deleteRole()
	{
		userSetupPage.navToRoleAndPerTable()
				.deleteRoleByName("Mosciski Buckridge");
	}

	@Test
	public void deleteUserAccount()
	{
		//		userSetupPage.fetchRecordNames();
		userSetupPage.navToUserManagement().userAccountDelete("Kilback Ratke UA");
	}


	public void verifyProcessCreate() throws Throwable {

		HomePage.clickOnProcessManagementCreate();

		process.createProcess(processName, processDesc, processName, subProcessName, subProcessDesc, subProcessName,

				subSubProcessName, subSubProcessDesc);

	}


	String QuestionSetName="Software Testing "+fake.lastName2();

	//	String selectedUser = "WorkFlow Design";
	@Test(dataProvider = "userData")
	public void createAUserAccount(String selectedUser,String roleName, String perToSelect,ExcelUtils exceltoUpload) throws Throwable
	{

		userSetupPage.navToRoleAndPerCreate()
				.createRoles(roleName, perToSelect,exceltoUpload)
				.navToUserCreatePage()
				.userCreationFields(FirstName, LastName, Password)
				.singleGroupSelect(roleName)
				.clickOnGroupCreateButton();
		excelUserManagement.addUserRole(roleName);
		String expectedUserName=FirstName+" "+LastName;
		String actualUserName=userSetupPage.roleTableNames.get(0).getText();
		assertEquals(expectedUserName, actualUserName);
		excelUserManagement.addUserAccount(expectedUserName);
		if(selectedUser.equals("WorkFlow Design")) {
//			userMapping(expectedUserName, , "John Smith");
		}

		userSetupPage.userLogin(expectedUserName, Password);

		switch (selectedUser) {

			case "Data Setup":
				verifyProcessCreate();
				dataset.createDataSet("Character");
//			dataset.deleteDataSet();
				break;

			case "WorkFlow Design":
				measurableSetPage.deleteRecordByName(QuestionSetName);
				nonMeasurableSetPage.createNormalView(QuestionSetName);
				nonMeasurableSetPage.deleteRecordByName(QuestionSetName);;
				disposition.createNormalView(QuestionSetName);
				disposition.deleteRecordByName(QuestionSetName);;
				break;

			case "User Setup":
				userSetupAssertions();
				break;

			default:break;


		}

		userSetupPage.userLogin("Capture_admin", Password);

		userSetupPage.navToUserManagement().userAccountDelete(expectedUserName);
//		excelUserManagement.removeUserAccount(expectedUserName);
		userSetupPage.deleteRoleByName(roleName);
//		excelUserManagement.removeUserRole(roleName);

		System.out.println("");
		System.out.println("Test Is Completed and Passed!!🎉🎉");

	}

	@Test
	public void delUserAccount()
	{
		userSetupPage
				.navToUserManagement()
				.userAccountDelete("OReilly Heidenreich");
	}

	@Test(dataProvider = "Roles")
	public void deleRole(String roleName)
	{
		userSetupPage
				.navToRoleAndPerTable()
				.deleteRoleByName(roleName);

	}


	public void userSetupAssertions()
	{
		userSetupPage.navToRoleAndPerCreate()
				.createRoles(roleNameForUserSetup+" UA", "User Setup",userSetupPage.excelToUploadModulePermissions)
				.navToUserCreatePage()
				.userCreationFields(FirstName, LastName+" UA", Password)
				.singleGroupSelect(roleNameForUserSetup+" UA")
				.clickOnGroupCreateButton();
		excelUserManagement.addUserRole(roleNameForUserSetup+" UA");
		String expectedUserName1=FirstName+" "+LastName+" UA";
		excelUserManagement.addUserAccount(expectedUserName1);
		String actualUserName1=userSetupPage.roleTableNames.get(0).getText();
		assertEquals(expectedUserName1, actualUserName1);
		System.out.println(expectedUserName1+" = "+actualUserName1);
		userSetupPage.userAccountDelete(expectedUserName1);
		userSetupPage.deleteRoleByName(roleNameForUserSetup+" UA");

	}


	@Test
	public void createAndAssertPermissions()
	{
		userSetupPage.userLogin("Borer Stracke", Password);
		userSetupPage.assertDataset();
		//		userSetupPage.navToRoleAndPerCreate()
		//		.createRoles(roleNameToViewLeftMenu1,"View Left Menu Set 1" ,userSetupPage.excelToUploadViewPermissions)
		//		;
	}

	@Test()
	public void userMapping(String RecordName,String SystemName, String Value)
	{
		userSetupPage
				.userMappingRecord(RecordName)
				.userMappingProcess("AJP","Sub AJP","Sub Sub AJP","Insurance Stage")
				.userMappingUserSuperior("Insurance Stage", "SuperAdmin", "Capture_admin")
				.systemMapping(SystemName,Value)
		;
	}

	@Test
	public void userDelete()
	{
		measurableSetPage.deleteRecordByName("Software Testing Ritchie");
	}

	@Test
	public void getTableRecords()
	{
		userSetupPage.getUserAccounts();
	}


	@Test(dataProvider = "fieldNames")
	public void createSystemName(String fieldNames)
	{
		userSetupPage
				.navToSysNames()
				.systemNames(fieldNames);
	}

	@Test(dataProvider = "fieldNames")
	public void deleteSystemName(String fieldNames)
	{
		userSetupPage
				.navToSysNames()
				.deleteSystemNames(fieldNames);
	}


	@Test
	public void userUploadOption()
	{
		userSetupPage.navToUserManagement().userUpload();

	}

	@Test
	public void endToEnd()
	{
		userSetupPage
				.navToUserManagement()
				.userMappingRecord("James@wyzmindz.com")
				.userMappingProcess("AJP","Sub AJP","Sub Sub AJP","Stage James")
				.userMappingUserSuperior("Stage James","QA","James@wyzmindz.com")
				.systemMapping("James","Paul");
	}

	@Test
	public void testNegative()
	{
		userSetupPage.userCreationFieldsNeg("","firstName",
				"lastName","james","password");

	}
	@Test()
	public void testUserWithoutPermission()
	{
		userSetupPage.userWithOutPermission("JamesWithoutPer","James",
				"Paul","james@gmail.com","Qwerty@123");

	}
	@Test(dataProvider = "Invalid Files")
	public void testUserUpload(String uploadFile)
	{
		userSetupPage
				.cloudUpload("Booking Information Stage", uploadFile);
	}


	@DataProvider(name="Invalid Files")
	public Object[][] getinvalidFiles()
	{
		String invalidUserName = System.getProperty("user.dir")+"\\UserCreationExcelFiles\\Invalid User Names.xlsx";
		String invalidFirstName = System.getProperty("user.dir")+"\\UserCreationExcelFiles\\Invalid LastName.xlsx";
		String invalidLastName = System.getProperty("user.dir")+"\\UserCreationExcelFiles\\Invalid FirstName.xlsx";
		String invalidEmail = System.getProperty("user.dir")+"\\UserCreationExcelFiles\\Invalid Email.xlsx";
		String invalidPassword = System.getProperty("user.dir")+"\\UserCreationExcelFiles\\Invalid Passwords.xlsx";
		String invalidDesignation = System.getProperty("user.dir")+"\\UserCreationExcelFiles\\Inavlid Designation.xlsx";


		return new Object[][] {
				{invalidUserName},
				{invalidFirstName},
				{invalidLastName},
				{invalidEmail},
				{invalidPassword},
				{invalidDesignation}
		};
	}

	@Test
	public void testInactive()
	{
		userSetupPage.Inactivate("Qwerty@123");
	}

	@Test
	public void noPermission()
	{
		userSetupPage.noPermissionEdit(commonPassword);
	}
	String commonPassword="Qwerty@123";
	@Test
	public void validateRole()
	{
		userSetupPage.negativeRole(commonPassword,"Agent");

	}

	@Test(dataProvider = "rolePermissionData")
	public void  testRoleCreate(String roleName){
		userSetupPage.roleCreate(roleName);
	}

	@DataProvider(name = "rolePermissionData")
	public Object[][] getRolePermissionTestData() {
		return new Object[][] {

				// Invalid Data - Empty or Blank Input
				{""},
				{"   "},

				// Invalid Data - Overly Long Input
				{new String(new char[256]).replace("\0", "A")},  // 256 characters long

				// Invalid Data - Special Characters
				{"Admin@123"},
				{"Role_Name#"},
				{"Sales$Manager!"},
				{"*Support_Staff"},

				// Invalid Data - SQL Injection
				{"Admin'; DROP TABLE Roles; --"},
				{"1 OR 1=1"},

				// Invalid Data - XSS Injection
				{"<script>alert('XSS')</script>"},
				{"\"><img src=x onerror=alert(1)>"},

				// Invalid Data - Numeric Values
				{"123"},
				{"456789"},

				// Valid Data - Alphanumeric Combinations
				{"Admin123"},
				{"SalesTeam2024"},

				// Valid Data - Multilingual Characters
				{"管理员"},  // Chinese
				{"מנהל"},   // Hebrew
				{"مدير"},   // Arabic
				{"Ürün Yöneticisi"},  // Turkish

				// Invalid Data - Leading or Trailing Whitespace
				{"  Admin  "},
				{"  Sales Manager"},


		};
	}
	@DataProvider(name = "invalidUserData")
	public Object[][] getInvalidUserData() {
		return new Object[][]{
				// User Name, First Name, Last Name, Email Id, Password, User Designation
				{"", "John", "Doe", "user@domain.com", "Password123"},  // Invalid Username
				{"a", "John", "Doe", "user@domain.com", "Password123"},  // Too short Username
				{"@user!", "John", "Doe", "user@domain.com", "Password123"},  // Special characters in Username
				{"12345", "John", "Doe", "user@domain.com", "Password123"},  // Only numbers in Username
				{"username_that_is_way_too_long_for_the_system_to_handle", "John", "Doe", "user@domain.com", "Password123"},  // Overly long Username

				{"username", "", "Doe", "user@domain.com", "Password123"},  // Empty First Name
				{"username", "@First!", "Doe", "user@domain.com", "Password123"},  // Special characters in First Name
				{"username", "John123", "Doe", "user@domain.com", "Password123"},  // Numbers in First Name
				{"username", "A", "Doe", "user@domain.com", "Password123"},  // Single character First Name
				{"username", "ThisFirstNameIsExceedinglyLongAndInvalid", "Doe", "user@domain.com", "Password123"},  // Overly long First Name

				{"username", "John", "", "user@domain.com", "Password123"},  // Empty Last Name
				{"username", "John", "!Smith@", "user@domain.com", "Password123"},  // Special characters in Last Name
				{"username", "John", "Smith123", "user@domain.com", "Password123"},  // Numbers in Last Name
				{"username", "John", "B", "user@domain.com", "Password123"},  // Single character Last Name
				{"username", "John", "ThisLastNameIsAlsoWayTooLongToBeValid", "user@domain.com", "Password123"},  // Overly long Last Name

				{"username", "John", "Doe", "", "Password123"},  // Empty Email
				{"username", "John", "Doe", "user@domain", "Password123"},  // Missing domain in Email
				{"username", "John", "Doe", "userdomain.com", "Password123"},  // No @ symbol in Email
				{"username", "John", "Doe", "user@domain,com", "Password123"},  // Invalid format in Email
				{"username", "John", "Doe", "user_with_an_extremely_long_email_address_that_exceeds_standard_limits@example.com", "Password123",  },  // Overly long Email

				{"username", "John", "Doe", "user@domain.com", ""},  // Empty Password
				{"username", "John", "Doe", "user@domain.com", "abc"},  // Too short Password
				{"username", "John", "Doe", "user@domain.com", "password"},  // Only letters in Password
				{"username", "John", "Doe", "user@domain.com", "12345678"},  // Only numbers in Password
				{"username", "John", "Doe", "user@domain.com", "a_very_very_very_very_long_password_that_is_unnecessary"},  // Overly long Password

				{"username", "John", "Doe", "user@domain.com", "Password123", ""},  // Empty User Designation
				{"username", "John", "Doe", "user@domain.com", "Password123", "@Manager!"},  // Special characters in Designation
				{"username", "John", "Doe", "user@domain.com", "Password123", "123Manager"},  // Numbers in Designation
				{"username", "John", "Doe", "user@domain.com", "Password123", "SuperSuperAdminAdmin"},  // Invalid role
		};
	}

	@Test(dataProvider = "rolePermissionData")
	public void deleteRoles(String roleName)
	{
		userSetupPage
				.deleteRoleByName(roleName);
	}

	@Test(dataProvider = "rolePermissionData")
	public void testSystemNamesNeg(String systemNames)
	{
		userSetupPage
				.createInvalidSystemNames(systemNames);


	}
@Test(dataProvider = "rolePermissionData")
	public void testSystemNames(String systemNames)
	{
		userSetupPage
				.editSystemNameWithInvalidInputs(systemNames,"Renamed"+systemNames);
		
	}



	@AfterMethod
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
	}


	@DataProvider(name = "userData")
	public Object[][] userData() {
		// Define a mapping or switch case to select parameters based on name
		// Change this to select different users
		return new Object[][] {
//		Object[][] userData = null;
//		{"Data Setup",roleNameForDataset, "Dataset", userSetupPage.excelToUploadModulePermissions},
				{"WorkFlow Design",roleNameForWorkflowDesign, "Workflow Design", userSetupPage.excelToUploadModulePermissions},
				{"User Setup",roleNameForUserSetup, "User Setup", userSetupPage.excelToUploadModulePermissions},

		};
//		switch (selectedUser) {
//		case "Data Setup":
//			userData = new Object[][] {
//				{roleNameForDataset, "Dataset", userSetupPage.excelToUploadModulePermissions}
//			};
//			break;
//		case "User Setup":
//			userData = new Object[][] {
//				{roleNameForUserSetup, "User Setup", userSetupPage.excelToUploadModulePermissions}
//			};
//			break;
//		case "WorkFlow Design":
//			userData = new Object[][] {
//				{roleNameForWorkflowDesign, "Workflow Design", userSetupPage.excelToUploadModulePermissions}
//			};
//			break;  
//
//		default:
//			throw new IllegalArgumentException("Invalid user selected: " + selectedUser);
//		}

//		return userData;
	}

	List<String> evaluationFileds=List.of("Name","Phone","Trans");

	@DataProvider(name = "System Names")
	public Object[][] systemNamesMapping() {
		return new Object[][] {
				{ "Manager", "John Smith"},
				{"Customer Type", "Enterprise"},
				{"Lead Source", "Website Contact Form"},
				{"Industry", "Technology"},
				{"Product Interest", "Software Solutions"},
				{"Account Status", "Active"},
				{"Payment Terms", "Net 30"},
				{"Customer Rating", "5 stars"},
				{"Preferred Contact Method", "Email"},
				{"Event Attendance", "None"},
				{"Birthday", "January 15, 1980"},
				{"Customer Lifetime Value", "$100,000"},
				{"Subscription Plan", "Premium"},
				{"Referral Source", "LinkedIn"},
				{"Marketing Campaign", "Summer Sale 2024"}
		};
	}
	@DataProvider(name = "fieldNames")
	public Object[][] fieldNames() {
		return new Object[][] {
				{ },
				{"Manager",
						"Customer Type"},
				{"Lead Source"},
				{"Industry"},
				{"Product Interest"},
				{"Account Status"},
				{"Payment Terms"},
				{"Customer Rating"},
				{"Preferred Contact Method"},
				{"Event Attendance"},
				{"Birthday"},
				{"Customer Lifetime Value"},
				{"Subscription Plan"},
				{"Referral Source"},
				{"Marketing Campaign"},
				{" "}
		};
	}


}
