package com.advaita.Utilities;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;


public class CommonUtils extends TestBase {
	
	
	//Scroll

	public static void scrollToElementByActions(WebElement element) {

		actions.moveToElement(element).build().perform();
	}

	public static void scrollToElementByJS(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollToElementByJS2(WebElement element) {
		
		 js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	}
	

	    // Utility method to scroll to a specific point (x, y)
	    public static void scrollToPoint(WebDriver driver, int x, int y) {

	        // Get the page height and width
	        long pageHeight = (long) js.executeScript("return document.body.scrollHeight;");
	        long pageWidth = (long) js.executeScript("return document.body.scrollWidth;");

	        // Ensure x and y values are within the scrollable range
	        if (x > pageWidth) x = (int) pageWidth;
	        if (y > pageHeight) y = (int) pageHeight;

	        // Perform the scroll
	        js.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
	    }


	public static void scrollToButtomOfPage() {

		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	public static void scrollToTopOfPage() {

		js.executeScript("window.scrollTo(0, 0);");

	}
	
	public static void scrollToElementHorizontally(WebElement element) {
		
		js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", element);

		
	}
	
	// Method to validate if the last character is '*'
    public static void validateLastCharIsStar(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String text = element.getText().trim(); // Get text and trim spaces

        // Assertion using TestNG
        assertFalse(text.isEmpty(), "Validation Failed: Element text is empty!");
        assertTrue(text.endsWith("*"), "Validation Failed: Last character is not '*'. Text: " + text);

        System.out.println("Validation Passed: Last character is '*'.");
    }
	
	public static String removeSpaces1(String input, String option) {
	    if (input == null) {
	        return null; // Handle null input
	    }
	    
	    switch (option.toLowerCase()) {
	        case "start":
	            return input.replaceAll("^\\s+", ""); // Remove spaces from the start
	        case "end":
	            return input.replaceAll("\\s+$", ""); // Remove spaces from the end
	        case "middle":
	            return input.replaceAll("(?<=\\S)\\s+(?=\\S)", ""); // Remove spaces between words
	        case "all":
	            return input.replaceAll("\\s+", ""); // Remove all spaces
	        case "startend":
	            return input.trim(); // Remove spaces from both start and end
	        default:
	            return input; // If invalid option, return the original string
	    }
	}

	public static String removeSpaces2(String input, String option) {
	    if (input == null) {
	        return null; // Handle null input
	    }
	    
	    switch (option.toLowerCase()) {
	        case "start":
	            return removeSpacesFromStart(input);
	        case "end":
	            return removeSpacesFromEnd(input);
	        case "middle":
	            return removeSpacesFromMiddle(input);
	        case "all":
	            return removeAllSpaces(input);
	        case "startend":
	            return removeSpacesFromStartAndEnd(input);
	        default:
	            return input; // If invalid option, return the original string
	    }
	}

	private static String removeSpacesFromStart(String input) {
	    int startIndex = 0;
	    while (startIndex < input.length() && input.charAt(startIndex) == ' ') {
	        startIndex++; // Move the start index to the first non-space character
	    }
	    return input.substring(startIndex); // Return the substring from the first non-space character
	}

	private static String removeSpacesFromEnd(String input) {
	    int endIndex = input.length() - 1;
	    while (endIndex >= 0 && input.charAt(endIndex) == ' ') {
	        endIndex--; // Move the end index to the last non-space character
	    }
	    return input.substring(0, endIndex + 1); // Return the substring up to the last non-space character
	}

	private static String removeSpacesFromMiddle(String input) {
	    StringBuilder result = new StringBuilder();
	    boolean spaceFlag = false;
	    
	    for (int i = 0; i < input.length(); i++) {
	        char currentChar = input.charAt(i);
	        if (currentChar == ' ') {
	            if (!spaceFlag) { 
	                result.append(currentChar); // Add a single space between words
	                spaceFlag = true;
	            }
	        } else {
	            result.append(currentChar); // Add non-space characters
	            spaceFlag = false;
	        }
	    }
	    
	    return result.toString();
	}

	private static String removeAllSpaces(String input) {
	    StringBuilder result = new StringBuilder();
	    
	    for (int i = 0; i < input.length(); i++) {
	        if (input.charAt(i) != ' ') {
	            result.append(input.charAt(i)); // Add non-space characters only
	        }
	    }
	    
	    return result.toString();
	}

	private static String removeSpacesFromStartAndEnd(String input) {
	    return removeSpacesFromStart(removeSpacesFromEnd(input)); // Combine the start and end space removals
	}


}
