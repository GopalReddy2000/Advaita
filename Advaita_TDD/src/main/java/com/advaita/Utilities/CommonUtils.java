package com.advaita.Utilities;

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

}
