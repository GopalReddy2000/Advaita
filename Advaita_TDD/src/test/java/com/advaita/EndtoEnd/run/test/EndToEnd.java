package com.advaita.EndtoEnd.run.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;

public class EndToEnd extends TestBase{
	EndToEnd()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="")
	WebElement dataSetUp;
	
	

}
