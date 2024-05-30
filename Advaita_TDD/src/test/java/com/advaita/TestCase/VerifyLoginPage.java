package com.advaita.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.Process;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class VerifyLoginPage extends TestBase {

    public ExtentReports reports;
    public ExtentSparkReporter htmlReporter;
    public ExtentTest test;

    LoginPage loginPage;
    HomePage homePage;

    Process process;

    public VerifyLoginPage() {
        super();
    }

    @BeforeMethod
    public void setUp() throws Throwable {
        initialization();

        htmlReporter = new ExtentSparkReporter("extentreport Advaita Process.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // add environment details
        reports.setSystemInfo("Machine", "Testpc1");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("user", "Gopal");
        reports.setSystemInfo("Browser", "Chrome");

        // Configuration to change look and feel
        htmlReporter.config().setDocumentTitle("Extent Report for Process");
        htmlReporter.config().setReportName("TEST Advaita");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimelineEnabled(true);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][] {
            {"Capture_admin", "Qwerty@123"},
            {"Capture_user1", "Password1"},
            {"Capture_user2", "Password2"}
            // Add more username-password pairs as needed
        };
    }

    @Test(dataProvider = "loginDataProvider", priority = 1)
    public void verifyLoginPage(String username, String password) throws Throwable {
        loginPage = new LoginPage();

        test = reports.createTest("verifyLoginPage for user: " + username);
        homePage = loginPage.login(username, password);

        
    }
        

    @AfterMethod
    public void tearDown() {
        driver.manage().window().minimize();
        driver.quit();
        reports.flush();
    }
}
