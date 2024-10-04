package com.advaita.TestClass;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.ReferPreviousStagePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class ReferPreviousStageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ReferPreviousStagePage previousStage;
    @BeforeMethod
    public void setup() throws AWTException, InterruptedException {
        initialization();
        loginPage =new LoginPage();
        homePage=loginPage.login("Capture_Admin","Qwerty@123");
        previousStage=new ReferPreviousStagePage();

    }


    String referPreviousStageName="Test";
    String dataset="Dataset James";
    String stageName="Booking Information Stage";
    String metadata="Metadata_James";

    List<String> datasetFields = List.of(
            "Name",
            "Phone Number",
            "Age",
            "Email Id"
    );
    List<String> stageFields=List.of(
            "Name",
            "Phone Number",
            "Name",
            "Email ID"
    );
    /**
     *Above are the parameters for the below methods, change the dataset,stageName.
     *Change all the parameters according to you needs.
     */
    @Test
    public void navTest()
    {
        previousStage
                .navToReferPreviousStage()
                .createRecord(referPreviousStageName,dataset,
                        stageName,"01-09-2024","26-09-2024",
                        datasetFields,stageFields)
                .datasetMapping(stageName,referPreviousStageName)
                .disposeData(stageName,2)
                .validateData(metadata)

        ;
    }

    @Test
    public void editRecordRename()
    {
        previousStage.navToReferPreviousStage()
                .editRecord("For Page")
                .rename("Renamed For Page");
    }

    @Test
    public void editDataset()
    {
        previousStage.navToReferPreviousStage()
                .editRecord("Test")
                .editDataset();
    }
    @Test
    public void deleteRecord()
    {
        previousStage.navToReferPreviousStage()
                .deleteRecords("For Pagination 1");

    }


    @Test
    public void datasetMapping()
    {
//   previousStage.datasetMapping("Booking Information Stage","James Previous Stage");
//    previousStage.disposeData(stageName,2);
        previousStage.validateData(metadata);
    }


    @AfterMethod
    public void tearDown()
    {
//        driver.quit();
    }
}
