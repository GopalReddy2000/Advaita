package com.advaita.EndToEnd;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.DataSet;
import com.advaita.DataSetUp.PageObject.ManualUpload;
import com.advaita.DataSetUp.PageObject.MetaData;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ExcelUserManagement;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.WorkFlowDesign.PageObject.Disposition;
import com.advaita.WorkFlowDesign.PageObject.MeasurableSetPage;
import com.advaita.WorkFlowDesign.PageObject.Stages;
import com.advaita.pageObjects.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static Advaita_TDD.Advaita_TDD.FakeData.lastName1;

public class ProcessToStagesTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UserSetupPage userSetupPage;
    ExcelUserManagement excelUserManagement;
    MeasurableSetPage measurableSetPage;
    NonMeasurableSetPage nonMeasurableSetPage;
    Disposition disposition;
    ProcessPage processPage;
    DataSet dataset;
    MetaData metaData;
    Stages stages;
    StagesActions stagesActions;
    ManualUpload manualUpload;
    SamplingPlanAndGenerationPage samplingPlanAndGenerationPage;

    ManualAllocationPage manualAllocationPage;

    ProcessToStagesTest() throws IOException {
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
        metaData=new MetaData();
        manualUpload=new ManualUpload();
        stages=new Stages();
        stagesActions=new StagesActions();
        samplingPlanAndGenerationPage=new SamplingPlanAndGenerationPage();
        manualAllocationPage=new ManualAllocationPage();

    }

    final String character="Character";
    final String textArea="Text Area";
    final String dateTime="Date Time";
    final String date="Date";
    final String number="Number";
    final String booleanV="Boolean";
    final String file="File";
    final String hyperLink="HyperLink";


    final int label=1;
    final int multipleChoice=2;
    final int shortAnswer=3;
    final int dropDown=4;
    final int relativeDropdown=5;
    final int fileUpload=6;
    final int radioButton=7;
    final int dateInt=8;
    final int time=9;
    final int textBox=10;
    final int relativeMultiselect=11;


    String process= PropertieFileUtil.getSingleTextFromPropertiesFile("process")+lastName1();
    String subProcess= PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess")+lastName1();
    String subSubProcess= PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess")+lastName1();
    String stageName= PropertieFileUtil.getSingleTextFromPropertiesFile("stage")+lastName1();


    String datasetName="DataSet "+lastName1();
    String metaDataName="metaData "+lastName1();
    String manualUploadName="manual "+lastName1();
    String uploadFileName=System.getProperty("user.dir")+"/ExcelFiles/Synthetic_Test_Data.xlsx";
    String fileName="Synthetic_Test_Data.xlsx";
    String nonMeasurableSetName1 ="Manager Review Question "+lastName1();
    String measurableSetName1 ="questions "+lastName1();


    List<String> reviewDropdownOptions=List.of("Accept","Reject");
    List<String> radioButtonOptions=List.of("Male","Female","Trans");
    List<String> sectionACheckBoxes=List.of("Trans Unique Id");
    List<String> sectionBCheckBoxes=List.of("Name of the Customer","Phone Number","Email","Location");
    List<String> sectionBCheckBoxesAJP=List.of("Name","Phone number","Email ID ");

    String HistoryFileds ="Stage History Fields";
    String evaluationFilter ="Evulation Filter";
    String evaluationFields ="Evaluation Fields";
    String duplicate ="Duplicate Stage";
    String Disposition ="Disposition";
    String SOP ="SOP";
    String scheduler ="Schduler Filters";
    String stageProcessField ="Stage Process Fields";
    String reportFilters ="Report Filters";
    String assignToFilter ="Assign To Filter";
    String reportFields ="Report Fields";


    @Test
    public void processToStage() throws Throwable {

        processPage.navToProcess().createProcess(process,"",process,subProcess,"",subProcess,subSubProcess,"");
        dataset.createDataset(datasetName,process,subProcess,subSubProcess)
                .addFieldNames(0,"Name of the Customer",character,"100","1")
                .addRow()
                .addFieldNames(1,"Phone Number",number,"14","1")
                .addRow()
                .addFieldNames(2,"Email",character,"100","1")
                .addRow()
                .addFieldNames(3,"Location",character,"100","1")
                .datasetCreate()
        ;
        metaData.metaDataCreate(metaDataName,process,subProcess,subSubProcess,datasetName)
                .execute(metaDataName)
        ;
        manualUpload.manualUploadRecord(manualUploadName,datasetName,uploadFileName,"uploaded",fileName,"Sheet1");
        nonMeasurableSetPage
                .NavToNonMeasurableTablePage()
                .createQuestionSetName(nonMeasurableSetName1)
                .dropdownAndMultiSelect(dropDown,1,1,"Review Status",reviewDropdownOptions,"yes","yes","yes")
                .addQuestion(1)
                .textBox(textBox,1,2,"Remarks","yes","yes","5","200","All","yes")
                .saveRecordAndBack();

        measurableSetPage
        .NavToMeasurableTablePage()
                .createQuestionSetName(measurableSetName1)

                .textBox(textBox,1,1,"Name","yes","no","2","100","All","yes")
                .addQuestion(1)
                .textBox(textBox,1,2,"Email ID","yes","no","2","100","Is Email","yes")
                .addQuestion(1)
                .radioButton(radioButton,1,3,"Gender","yes","no",radioButtonOptions)
                .saveRecordAndBack()
        ;

        stages
                .navigateToStageCreate()
                .stageNameAndProcess(stageName,process,subProcess,subSubProcess)
                .selectCheckBoxSectionA(metaDataName,sectionACheckBoxes)
                .selectCheckBoxSectionB(metaDataName,sectionBCheckBoxes)
                .measurableDropdown("Section C",measurableSetName1)
                .nonMeasurableDropdown("Section D",nonMeasurableSetName1)
                .actionSection("all")
//                .actionSectionToggle("all")
                .dispositionSection()
                .saveAndConfirmation()
        ;
        stagesActions
                .navtoStages()
                .clickOnStageHistoryField(stageName,evaluationFields)
                .escalationFields(sectionBCheckBoxes);
        ;
        samplingPlanAndGenerationPage.navToCreate()
                .createSampling(process,subProcess,subSubProcess,stageName,samplingName,samplingTo,totalCall,allSampleCondition,needCondition,needSampling);

       manualAllocationPage.manualAllocationData(process,subProcess,subSubProcess,stageName,"Role Wise","All","Capture_admin");

        stagesActions.evaluationFilter(sectionBCheckBoxes,stageName);

    }

    String samplingName=stageName+" Sampling";
    String samplingTo="Admin";
    String totalCall="0";
    String allSampleCondition="yes";
    String needCondition="no";
    String needSampling="no";




    @Test(dataProvider = "userCreation")
    public void userCreation(String firstName,String lastName,String roleName) {

        userSetupPage.navToUserCreatePage();
        userSetupPage.userCreationFields(firstName, lastName, "Qwerty@123")
                .singleGroupSelect(roleName)
                .clickOnGroupCreateButton()
        ;
    }

    @DataProvider(name = "userCreation")
    public Object[][] userCreation(){

        return new Object[][]{{"James","Agent","Agent"},
                {"James","Team Lead","Team Lead"},
                {"James","Admin","Admin"}
        };
    }

    @AfterTest
    public void tearDown(){
//        driver.quit();

    }


}
