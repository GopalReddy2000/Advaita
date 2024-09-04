package com.advaita.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {
    private  ExtentReport(){}
   private static ExtentReports extent;
    private static String fileName;
    public static void initReports(String testName)
    {
        if(Objects.isNull(extent)) {

            extent = new ExtentReports();
            fileName = System.getProperty("user.dir") + "/ExtentReports/" + testName + ".html";
            ExtentSparkReporter spark = new ExtentSparkReporter(fileName);


            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Advaita Reports");
        }
    }
    public static void flushReports() throws IOException {
        if(!Objects.isNull(extent)) {
            extent.flush();
            Desktop.getDesktop().browse(new File(fileName).toURI());

        }
    }
    public static void createTest(String testName)
    {
        ExtentManager.setExtentTest(extent.createTest(testName));
    }
    public static String getTestName(ITestResult result) {
        return result.getMethod().getMethodName();
    }


}
