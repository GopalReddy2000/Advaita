package com.advaita.TestClass;

import Advaita_TDD.Advaita_TDD.FakeData;
import com.advaita.BaseClass.TestBase;
import com.advaita.EndToEnd.FieldsToMastersPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static Advaita_TDD.Advaita_TDD.FakeData.lastName2;


public class FieldToMasterTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    FieldsToMastersPage fieldsToMasters;
    @BeforeMethod
    public void setUp() throws AWTException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login("Capture_admin", "Qwerty@123");
        fieldsToMasters=new FieldsToMastersPage();
    }

    @Test
    public void basicInformation()
    {
        fieldsToMasters
                .navToFieldTable()
                .setQuestionName(question1)
                .textBox(textBox,1,1,"Name of the Customer","no","no","1","100","All","yes")
                .addQuestion(1)
                .textBox(textBox,1,2,"Location","no","no","1","100","All","yes")

                .saveRecord1()
                .back()
        ;


    }


    @Test
    public void  contactInformation()
    {
        fieldsToMasters
                .navToFieldTable()
                .setQuestionName(question2)
                .textBox(textBox,1,1,"Email ID","yes","no","1","100","All","yes")
                .addQuestion(1)
                .textBox(textBox,1,2,"Phone Number","yes","no","1","100","All","yes")
                .addQuestion(1)
                .radioButton(radioButton,1,3,"Is Primary","100","yes","no",radioButtonOptions)
                .saveRecord1()
                .back()
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
    public void testMasters()
    {
        basicInformation();
        contactInformation();
        fieldsToMasters.navToMasterFormsTable()
                .createMasterForms("testForm"+lastName2(),"AJP","Sub AJP","Sub Sub AJP","primarySection",question1)
                .addSectionC("section2"+lastName2(),question2)
                .formSaveAndFinalize()
        ;

    }


    @Test
    public void fromFieldToMasters()
    {
        fieldsToMasters
                .navToFieldTable()
                .setQuestionName(question1)
                .textBox(textBox,1,1,"Name of the Customer",
                        "no","no","1","100",
                        "All", "yes")
                .addQuestion(1)
                .textBox(textBox,1,2,"Location",
                        "no","no","1","100",
                        "All","yes")
                .saveRecord1()
                .back()
        ;
        fieldsToMasters
                .navToFieldTable()
                .setQuestionName(question2)
                .textBox(textBox,1,1,"Email ID",
                        "yes","no","1","100",
                        "All","yes")
                .addQuestion(1)
                .textBox(textBox,1,2,"Phone Number",
                        "yes","no","1","100",
                        "All","yes")
                .addQuestion(1)
                .radioButton(radioButton,1,3,"Is Primary",
                        "100","yes","no",radioButtonOptions)
                .saveRecord1()
                .back()
        ;

        fieldsToMasters.navToMasterFormsTable()
                .createMasterForms("testForm"+lastName2(),process,subProcess,subSubProcess,"primarySection",question1)
                .addSectionC("section2"+lastName2(),question2)
                .formSaveAndFinalize()
        ;
        fieldsToMasters.stagesSetup(stageName,process,subProcess,subSubProcess,sectionMetadata,checkboxInputs,"all");




    }

    String question1="Basic"+lastName2();
    String question2="Contact"+lastName2();
    String stageName="";
    String sectionMetadata="Student Information_metadata";
    List<String> checkboxInputs = Arrays.asList("Name of the Student (Student Information)", "Roll Number of the Student (Student Information)", "Date Of Birth (Student Information)");  // Replace with actual values

    String process="AJP";
    String subProcess="Sub AJP";
    String subSubProcess="Sub Sub AJP";


    List<String> radioButtonOptions = List.of(
            "Yes",
            "No"
    );


    @Test
    public void testStagesSetup(){
        fieldsToMasters.stagesSetup(stageName,process,subProcess,subSubProcess,sectionMetadata,checkboxInputs,"all");

    }

    @Test
    public void testMasterMenuSetup(){
        fieldsToMasters.masterMenuSetup();

    }
    @Test
    public void testMaster(){
//        fieldsToMasters.masters();

    }

    @Test
    public void deleteMastersRecord(){
        fieldsToMasters.deleteMasterRecord("To Delete");

    }

    @Test
    public void testAddMasters(){
        fieldsToMasters.addMasters("James "+lastName2(),"9876432675","Address "+lastName2());

    }

    @Test
    public void editMastersRecord(){
        fieldsToMasters.editMasterRecord("To Delete 2","Edited Name","9876432675","Edited Address");

    }

    @Test
    public void validatePage(){
        fieldsToMasters.validateRecordsPerPage();

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

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
