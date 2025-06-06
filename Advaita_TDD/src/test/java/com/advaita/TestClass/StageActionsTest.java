package com.advaita.TestClass;

import com.advaita.BaseClass.TestBase ;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.pageObjects.StagesActions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class StageActionsTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    StagesActions stagesActions;
    StageActionsTest() throws IOException {
        super();
    }
    @BeforeTest
    public void setup() throws AWTException, InterruptedException {
        initialization();
        loginPage=new LoginPage();
        homePage = loginPage.login("Capture_admin", "Qwerty@123");
        stagesActions = new StagesActions();
    }
    String HistoryFileds ="Stage History Fields";
    String evaluationFilter ="Evulation Filter";
    String evaluationFields ="Evaluation Fields";
    String duplicate ="Duplicate Stage";
    String Disposition ="Disposition";
    String SOP ="SOP";
    String scheduler ="Schduler Filters";
    String stageProcessfield ="Stage Process Fields";
    String reportFilters ="Report Filters";
    String assignToFilter ="Assign To Filter";
    String reportFields ="Report Fields";
    @Test
    public void stagesEdit()
    {
//        stagesActions
//                .navtoStages()
//                .clickOnStageHistoryField("Insurance Stage",HistoryFileds)  ;
        stagesActions.stageHistoryFields();
    }
  List<String> sectionBCheckBoxes= List.of("Name of the Customer","Phone Number","Email","Location");

    String stageName= PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
    @Test
    public void evaluationFilterTest()
    {
        stagesActions
                .navtoStages()
                .clickOnStageHistoryField(stageName,evaluationFilter)  ;
        stagesActions.evaluationFilter(sectionBCheckBoxes,stageName);
    }


    @Test
    public void SOPTest()
    {
        stagesActions
                .navtoStages()
                .clickOnStageHistoryField("Insurance Stage",SOP)
                .Sop()
        ;
    }
    @Test
    public void SOPDeleteTest()
    {
        stagesActions
                .navtoStages()
                .clickOnStageHistoryField("Insurance Stage",SOP)
                .SOPDelete("Newsletter_AKpfiCE.pdf")
                ;
    }

    @Test
    public void reportFields(){
        stagesActions
                .navtoStages()
                .clickOnStageHistoryField("Insurance Stage",reportFields)
                .reportFields()
        ;
    }

    @Test
    public void stageProcessFieldTest()
    {
        stagesActions
//                .navtoStages()
//                .clickOnStageHistoryField("Insurance Stage",stageProcessfield)
                .stageProcessFields()
        ;
    }
    @Test
    public void reportFiltersTest()
    {
        stagesActions
                .navtoStages()
                .clickOnStageHistoryField("Insurance Stage",reportFilters)
                .reportFilters()
        ;

    }

    @Test
    public void dispositionTest()
    {
        stagesActions
                .navtoStages()
                .clickOnStageHistoryField("Insurance Stage",Disposition)
                .disposition()
        ;
    }


    @AfterTest
    public void tearDown(){
//        driver.quit();
    }




}
