package com.advaita.Utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class LogoutUtils extends TestBase {

	
	
	public void LogoutFromAdmin(String timePickerContainer,String logOutElement) {
		
		
		 WebElement profileDropdwonEleement = driver.findElement(By.xpath("xdsoft_time_variant"));
		 profileDropdwonEleement.click();
		 
		 WebElement logOutElement1 = driver.findElement(By.linkText("Logout"));
		 logOutElement1.click();
		 
		 
	}
	
	 


}
