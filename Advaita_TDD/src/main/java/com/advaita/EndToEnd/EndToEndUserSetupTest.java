package com.advaita.EndToEnd;

import static com.advaita.Utilities.PropertieFileUtil.getSingleTextFromPropertiesFile;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ExcelUserManagement;
import com.advaita.Utilities.ExcelUtils;
import com.advaita.WorkFlowDesign.PageObject.Disposition;
import com.advaita.WorkFlowDesign.PageObject.MeasurableSetPage;
import com.advaita.pageObjects.NonMeasurableSetPage;
import com.advaita.pageObjects.UserSetupPage;

import Advaita_TDD.Advaita_TDD.FakeData;

public class EndToEndUserSetupTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UserSetupPage userSetupPage;
    ExcelUserManagement excelUserManagement;
    MeasurableSetPage measurableSetPage;
    NonMeasurableSetPage nonMeasurableSetPage;
    Disposition disposition;
    ProcessPage processPage;
    DataSet dataset;


    public String processName = "";

    public String processDesc = "";

    public String subProcessName = "";

    public String subProcessDesc = "";

    public String subSubProcessName = "";

    public String subSubProcessDesc = "";

    public String metaDataName = "";


    EndToEndUserSetupTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setUp() throws Exception   {

        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login("Capture_admin", "Qwerty@123");
        userSetupPage =new UserSetupPage();
        processPage=new ProcessPage();
        dataset=new DataSet();
        measurableSetPage=new MeasurableSetPage();
        nonMeasurableSetPage=new NonMeasurableSetPage();
        disposition= new Disposition();
        excelUserManagement= new ExcelUserManagement();

    }

    @Test
    public void endToEndCreateUser(){

        userSetupPage.navToRoleAndPerCreate()
                .createRoles(FirstName+"ForAlchemy","Alchemy",userSetupPage.excelToUploadModulePermissions);
        
    }
    String FirstName= FakeData.lastName1();

    String LastName=FakeData.lastName2();
    String Password="Qwerty@123";
    String QuestionSetName=FakeData.lastName2()+"question";

    String process=getSingleTextFromPropertiesFile("process");
    String subProcess=getSingleTextFromPropertiesFile("subProcess");
    String subSubProcess=getSingleTextFromPropertiesFile("subSubProcess");
    String stage=getSingleTextFromPropertiesFile("stage");

    String superiorRole="James Admin";

    //	String selectedUser = "WorkFlow Design";
    @Test(dataProvider = "userData")
    public void createAUserAccount1(String selectedUser, String roleName, String perToSelect, ExcelUtils exceltoUpload) throws Throwable
    {

        userSetupPage.navToRoleAndPerCreate()
                .createRoles(roleName, perToSelect,exceltoUpload);
        userSetupPage .navToUserCreatePage();
        userSetupPage    .userCreationFields(FirstName, LastName, Password)
                .singleGroupSelect(roleName)
                .clickOnGroupCreateButton();
        excelUserManagement.addUserRole(roleName);
        String expectedUserName=FirstName+" "+LastName;
        String actualUserName= UserSetupPage.roleTableNames.get(0).getText();
        assertEquals(expectedUserName, actualUserName);
        excelUserManagement.addUserAccount(expectedUserName);

        userSetupPage.userMappingRecord(expectedUserName)
                .userMappingProcess(process,subProcess,subSubProcess,stage)
                .userMappingUserSuperior(stage,"Admin",superiorRole)

        ;
        userSetupPage.stageWithFilters(expectedUserName,superiorRole,"Active",process,subProcess,subSubProcess,stage);

//        if(selectedUser.equals("WorkFlow Design")) {
////			userMapping(expectedUserName, , "John Smith");
//        }
//
//        userSetupPage.userLogin(expectedUserName, Password);
//
//        switch (selectedUser) {
//
//            case "Data Setup":
//                verifyProcessCreate();
//                dataset.createDataSet("Character");
////			dataset.deleteDataSet();
//                break;
//
//            case "WorkFlow Design":
//                measurableSetPage.deleteRecordByName(QuestionSetName);
//                nonMeasurableSetPage.createNormalView(QuestionSetName);
//                nonMeasurableSetPage.deleteRecordByName(QuestionSetName);;
//                disposition.createNormalView(QuestionSetName);
//                disposition.deleteRecordByName(QuestionSetName);;
//                break;
//
//            case "User Setup":
//                userSetupAssertions();
//                break;
//
//            default:break;
//
//
//        }
//
//        userSetupPage.userLogin("Capture_admin", Password);
//
//        userSetupPage.navToUserManagement().userAccountDelete(expectedUserName);
////		excelUserManagement.removeUserAccount(expectedUserName);
//        userSetupPage.deleteRoleByName(roleName);
////		excelUserManagement.removeUserRole(roleName);

        System.out.println("Test Is Completed and Passed!!🎉🎉");
    }

    @DataProvider(name = "userData")
    public Object[][] userData() {
        // Define a mapping or switch case to select parameters based on name
        // Change this to select different users
        return new Object[][] {
//		Object[][] userData = null;
//		{"Data Setup",roleNameForDataset, "Dataset", userSetupPage.excelToUploadModulePermissions},
                {"WorkFlow Design",roleNameForWorkflowDesign, "Workflow Design", userSetupPage.excelToUploadModulePermissions},
//                {"User Setup",roleNameForUserSetup, "User Setup", userSetupPage.excelToUploadModulePermissions},

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

    
    HomePage hp = new HomePage();
    public void verifyProcessCreate() throws Throwable {

        hp.clickOnProcessManagementCreate();

        processPage
                .createProcess(processName, processDesc, processName,
                        subProcessName, subProcessDesc, subProcessName,
                        subSubProcessName, subSubProcessDesc);

    }
    String roleNameForUserSetup=FakeData.lastName1()+" User Setup";
    String roleNameForWorkflowDesign=FakeData.lastName1()+" Workflow Design";

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
        String actualUserName1= UserSetupPage.roleTableNames.get(0).getText();
        assertEquals(expectedUserName1, actualUserName1);
        System.out.println(expectedUserName1+" = "+actualUserName1);
        userSetupPage.userAccountDelete(expectedUserName1);
        userSetupPage.deleteRoleByName(roleNameForUserSetup+" UA");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
