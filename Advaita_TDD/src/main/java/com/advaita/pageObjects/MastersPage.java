package com.advaita.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;

public class MastersPage extends TestBase
{
    MastersPage(){
        PageFactory.initElements(driver,this);
    }


    private WebElement addMaster(String masterName)
    {
        String xpath="//a[text()='Add "+masterName+"']";
        return driver.findElement(By.xpath(xpath));
    }





}