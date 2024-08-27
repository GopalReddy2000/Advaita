package com.advaita.Utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	public static void validateDropdown(Select dropdown, String expectedDefaultOption, String[] expectedOrder) {
	    // Verify the dropdown is not multi-select
	    assertFalse(dropdown.isMultiple(), "Dropdown allows multiple selections.");

	    // Check for empty dropdown
	    List<WebElement> options = dropdown.getOptions();
	    assertTrue(options.size() > 0, "Dropdown has no options.");
	    System.out.println("Number of options in the dropdown: " + options.size());

	    // Check default selected value
	    WebElement defaultSelectedOption = dropdown.getFirstSelectedOption();
	    assertEquals(defaultSelectedOption.getText(), expectedDefaultOption, "Default selected option is incorrect.");

	    // Verify the order of options
	    for (int i = 0; i < expectedOrder.length; i++) {
	        assertEquals(options.get(i).getText(), expectedOrder[i], "Option order is incorrect at index " + i);
	    }

	    // Print all options and check for duplicates
	    Set<String> uniqueOptions = new HashSet<>();
	    System.out.println("Dropdown options:");
	    for (WebElement option : options) {
	        String optionText = option.getText();
	        System.out.println(optionText);
	        assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
	    }

	    // Select each option by index and verify the selection
	    for (int i = 0; i < options.size(); i++) {
	        dropdown.selectByIndex(i);
	        WebElement selectedOption = dropdown.getFirstSelectedOption();
	        assertEquals(selectedOption.getText(), options.get(i).getText(),
	                     "Failed to select the option by index " + i);
	        System.out.println("Option '" + options.get(i).getText() + "' was successfully selected by index " + i + ".");
	    }
	}


}
