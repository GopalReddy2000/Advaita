package com.advaita.TestClass;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.SamplingPlanAndGenerationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class SamplingPlanAndGenerationTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SamplingPlanAndGenerationPage SPAG;

    @BeforeMethod
    public void setup() throws AWTException, InterruptedException {
        initialization();
        loginPage=new LoginPage();
        homePage = loginPage.login("Capture_admin", "Qwerty@123");
        SPAG=new SamplingPlanAndGenerationPage();
    }

    @Test
    public void navToPage()
    {
        SPAG.navToCreate();
    }

    @Test
    public void createSampling()
    {
        SPAG
                .navToCreate()
                .createSampling("AJP","Sub AJP","Sub Sub AJP",
                        "college student stage","college student meta"
                ,"20-10-2024","20-10-2024","Admin","0","yes","no","no")

        ;
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


}
