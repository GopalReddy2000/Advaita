package com.advaita.TestClass;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.DocumentNamePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

public class DocumentNamesTest extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;
    DocumentNamePage documentNamePage;

    @BeforeMethod
    public void setup() throws AWTException, InterruptedException {
        initialization();
        loginPage=new LoginPage();
        homePage = loginPage.login("Capture_admin", "Qwerty@123");
        documentNamePage= new DocumentNamePage();
    }

    @Test(dataProvider = "DocumentNames")
    public void createDocuments(String documents)
    {
        documentNamePage
                .navToDocumentNames()
                .createDocument(documents)
                .validateInUserSetupPage(documents)
                ;
        assertEquals(documents,documentNamePage.actualRecord);
    }

    @Test
    public void ValidateInUserManagement()
    {
        documentNamePage.validateInUserSetupPage("PAN Card");

    }

    @Test(dataProvider = "DocumentNames")
    public void delete(String recordName)
    {
        documentNamePage.navToDocumentNames()
                .tableActions(recordName)

                ;
    }
    @DataProvider(name="DocumentNames")
    public Object[][] forDocumentName()
    {
        return new Object[][]{
                {"User Onboarding Guide"},
//                {"User Manual"},
//                {"Feature-Specific Guides"},
//                {"FAQs and Troubleshooting"},
//                {"Admin Guide"},
//                {"Reporting and Analytics Guide"},
//                {"Mobile App Guide"},
//                {"Data Migration Guide"},
//                {"Integration Guide"},
//                {"Custom Workflow Setup Guide"},
//                {"Role-Based Access Control (RBAC) Guide"},
//                {"System Configuration Guide"},
//                {"Third-Party API Integration Guide"},
//                {"User Permissions Guide"},
//                {"Data Privacy and Compliance Guide"},
//                {"Product Release Notes"},
//                {"Advanced Search and Filtering Guide"},
//                {"Notifications and Alerts Guide"},
//                {"Template Customization Guide"},
//                {"Performance Optimization Guide"},
//                {"Backup and Restore Guide"},
//                {"Change Management Guide"},
//                {"Client Portal Setup Guide"},
//                {"Gamification Features Guide"},
//                {"Audit Trail Guide"}
        };
    }

    @Test
    public void edit()
    {
        documentNamePage.navToDocumentNames()
                .editAndVerify("Product Release Notes Edited","Product Release Notes")
                ;
    }

    @Test
    public void search()
    {
        documentNamePage.navToDocumentNames()
                .search("User Permissions Guide")
                ;
        assertEquals(documentNamePage.tableRecords.get(0).getText(),"User Permissions Guide");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
