package com.advaita.listeners;

import static com.advaita.BaseClass.TestBase.driver;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.advaita.reports.ConsoleCapture;
import com.advaita.reports.ExtentLogger;
import com.advaita.reports.ExtentManager;
import com.advaita.reports.ExtentReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ListenerClass implements ITestListener, ISuiteListener {
    ExtentTest test;
    private ConsoleCapture consoleCapture = new ConsoleCapture();
    @Override
    public void onStart(ISuite suite) {
//        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
            ExtentManager.unload();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        consoleCapture.startCapture();
        String className = result.getTestClass().getName();
        String simpleClassName = className.substring(className.lastIndexOf('.') + 1);
        ExtentReport.initReports(simpleClassName);
       ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed");
        try {
            ExtentManager.getExtTest().pass("Passed",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShotAsBase64()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logConsoleErrors();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed");
        try {
            ExtentManager.getExtTest().fail("Failed",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShotAsBase64()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logConsoleErrors();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+" is Skipped");
        logConsoleErrors();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.unload();

    }

    public String getScreenShotAsBase64() throws IOException {
//        File source=
        return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);


    }
    private void logConsoleErrors() {
        String consoleErrors = consoleCapture.stopCapture();  // Stop capturing console errors
        if (!consoleErrors.isEmpty()) {
            ExtentManager.getExtTest().info("Console Errors:\n" + consoleErrors);  // Log errors to Extent Report
        }
    }

}
