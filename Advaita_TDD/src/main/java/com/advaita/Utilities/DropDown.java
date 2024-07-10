package com.advaita.Utilities;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;

public class DropDown extends TestBase{
	
	public static void selectWithRetry(WebElement processElement, String fetchProcessRecord) {
//	    WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
	    int maxAttempts = 3;
	    int attempts = 0;
	    
	    while (attempts < maxAttempts) {
	        try {
	            wait.until(ExpectedConditions.refreshed(
	                ExpectedConditions.elementToBeClickable(processElement)
	            ));
	            
	            Select process = new Select(processElement);
	            process.selectByVisibleText(fetchProcessRecord);
	            
	            // If successful, break out of the loop
	            System.out.println("Successfully selected: " + fetchProcessRecord);
	            break;
	        } catch (StaleElementReferenceException e) {
	            attempts++;
	            if (attempts == maxAttempts) {
	                System.out.println("Failed to select after " + maxAttempts + " attempts.");
	                throw e; // Re-throw the exception if all attempts fail
	            }
	            System.out.println("Encountered a stale element. Retrying... (Attempt " + attempts + ")");
	        }
	    }
	    
	}
//	###############################################################
	

	public static void selectAndVerifyOptionsByIndex(WebElement selectElement, List<WebElement> options) {
	    int maxAttempts = 3;

	    for (int k = 0; k < options.size(); k++) {
	        int attempts = 0;
	        while (attempts < maxAttempts) {
	            try {
	                wait.until(ExpectedConditions.refreshed(
	                    ExpectedConditions.elementToBeClickable(selectElement)
	                ));

	                Select subSubProcess = new Select(selectElement);
	                subSubProcess.selectByIndex(k);

	                WebElement selectedOption = wait.until(ExpectedConditions.refreshed(
	                    ExpectedConditions.elementToBeClickable(subSubProcess.getFirstSelectedOption())
	                ));

	                String expectedText = options.get(k).getText();
	                String actualText = selectedOption.getText();

	                Assert.assertEquals(actualText, expectedText,
	                    "Failed to select the option by index " + k);

	                System.out.println("Option '" + expectedText + "' was successfully selected by index " + k + ".");
	                
	                // If successful, break out of the retry loop
	                break;
	            } catch (StaleElementReferenceException e) {
	                attempts++;
	                if (attempts == maxAttempts) {
	                    System.out.println("Failed to select option at index " + k + " after " + maxAttempts + " attempts.");
	                    throw e; // Re-throw the exception if all attempts fail
	                }
	                System.out.println("Encountered a stale element. Retrying... (Attempt " + attempts + " for index " + k + ")");
	            }
	        }
	    }
	}

}
