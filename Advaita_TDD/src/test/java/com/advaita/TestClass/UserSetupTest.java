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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	@BeforeTest
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
		userSetupPage.navToUserManagement().userAccountTableActions("Kilback Ratke UA");
	}

	HomePage hp = new HomePage();
	public void verifyProcessCreate() throws Throwable {

		hp.clickOnProcessManagementCreate();

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
//			userMapping(expectedUserName,"Manager", "John Smith");
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

		userSetupPage.navToUserManagement().userAccountTableActions(expectedUserName);
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
				.userAccountTableActions("OReilly Heidenreich");
	}

	@Test(dataProvider = "Roles")
	public void deleRole(String roleName)
	{
		userSetupPage
				.navToRoleAndPerTable()
				.deleteRoleByName(roleName);

	}

	@Test
	public void userCreationNegative()
	{
		userSetupPage.userCreationNeg();
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
		userSetupPage.userAccountTableActions(expectedUserName1);
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

//	@Test()
//	public void userMapping(String RecordName,String SystemName, String Value)
//	{
//		userSetupPage
//				.userMappingRecord(RecordName)
//				.userMappingProcess("AJP","Sub AJP","Sub Sub AJP","Insurance Stage")
//				.userMappingUserSuperior("Insurance Stage", "SuperAdmin", "Capture_admin")
//				.systemMapping(SystemName,Value)
//		;
//	}

	@Test
	public void userDel()
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



//	@AfterTest
//	public void tearDown() {
//		driver.manage().window().minimize();
//		driver.quit();
//
//	}

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


	@DataProvider(name = "System Names")
	public Object[][] systemNamesMapping() {
		return new Object[][] {
				{"Manager", "John Smith"},
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
				{"Manager"},
				{"Customer Type"},
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
