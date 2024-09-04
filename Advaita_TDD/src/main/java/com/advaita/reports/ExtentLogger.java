package com.advaita.reports;

public class ExtentLogger {
    private ExtentLogger(){}

   public static void pass(String message)
    {
        ExtentManager.getExtTest().pass(message);
    }
    public  static void fail(String message)
    {
        ExtentManager.getExtTest().fail(message);
    }
    public  static void skip(String message)
    {
        ExtentManager.getExtTest().skip(message);
    }


}
