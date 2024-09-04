package com.advaita.Utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;

public class FetchDataFromInputTagWithJS extends TestBase{
	
	// Data Print 2
		// Label-input Tag
		public  String dataPrintFromInputtag(WebElement element, String variableName)
				 {
			
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.isDisplayed(), element + " is not IsDisplayed.");
			String elementValue = (String) js.executeScript("return arguments[0].value;", element);
//			System.out.println("\n" + variableName + " : " + elementValue + "\n");
			
			return elementValue;
			
		}

}
