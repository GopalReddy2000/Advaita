package com.advaita.TestCreate;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.UserSetupPage;

import Advaita_TDD.Advaita_TDD.FakeData;

public class UserSetupTest extends TestBase {
 
	LoginPage loginPage;
	HomePage homePage;
	UserSetupPage userSetupPage;
	
	String roleNameForAlchemy=FakeData.lastName1()+" Alchemy";
	String roleNameForDataset=FakeData.lastName1()+" Dataset";
	String roleNameForWorkflowDesign=FakeData.lastName1()+" Workflow Design";
	String roleNameForUserSetup=FakeData.lastName1()+" User Setup";
	String roleNameForUserStatus=FakeData.lastName1()+" User Status";
	String roleNameForAPIKey=FakeData.lastName1()+" API Key";
	String roleNameForMenu=FakeData.lastName1()+" Menu";
	String roleNameForSiteSettings=FakeData.lastName1()+" Site Settings";
	
	String FirstName=FakeData.lastName1();
	
	String LastName=FakeData.lastName2();
	String Password="Qwerty@123";
	
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
		.createRoles(roleNameForAlchemy,"Alchemy");
	}
	
	@Test
	public void excelTest()
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
		.createUserWithRoleAll(roleAllGroupName);
		UserSetupPage.RolesCreated.add(roleAllGroupName);
	}
	
	
	
	
	@Test
	public void roleDeleteTest()
	{
		
		userSetupPage.navToRoleAndPerTable()
		.deleteFormByName("Pfeffer All Permission");
	}
	
	@Test
	public void Test()
	{
		
		userSetupPage.str();
	}
	
	@Test
	public void createAUserAccount()
	{
//		userSetupPage.navToRoleAndPerCreate()
//		.createRoles(roleNameForDataset, "Dataset")
//		.navToUserCreatePage()
//		.userCreationFields(FirstName, LastName, Password)
//		.singleGroupSelect(roleNameForDataset)
//		.clickOnGroupCreateButton();
//		
		String expectedUserName=FirstName+" "+LastName;
//		
//		String actualUserName=userSetupPage.roleTableNames.get(0).getText();
//		assertEquals(expectedUserName, actualUserName);
		userSetupPage.userLogin(expectedUserName, Password);
		
	}
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();

	}
	
	
	
}
