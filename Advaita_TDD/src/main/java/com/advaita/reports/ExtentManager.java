package com.advaita.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private ExtentManager(){}

         private static final ThreadLocal<ExtentTest> extentTest= new ThreadLocal<>();

    public static ExtentTest getExtTest() {
        return extentTest.get();
    }

    public static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

     public static void unload()
    {
        extentTest.remove();
    }
}
