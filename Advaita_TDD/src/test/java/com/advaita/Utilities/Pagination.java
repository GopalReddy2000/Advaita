package com.advaita.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class Pagination extends TestBase {

	public static void goToPreviousPage(WebDriver driver, int size) throws Throwable {

		// Iterate from index 2 to the end of the list
		for (int i = 1; i < size; i++) {

			String xpathExpression = "//nav[@aria-label='pagination']//ul[@class='pagination right_space']//li[@class='page-item active']/preceding-sibling::li[1]/a";
			WebElement nextPageLink = driver.findElement(By.xpath(xpathExpression));
//				
//			        js.executeScript("arguments[0].scrollIntoView(true);", nextPageLink);
			click(driver, nextPageLink);
			Thread.sleep(100);

			// Perform your actions after clicking on each delete icon
		}

	}

	public static void goToNextPage(WebDriver driver, int size) throws Throwable {
		// Iterate from index 2 to the end of the list
		for (int i = 1; i < size; i++) {

			String xpathExpression = "//nav[@aria-label='pagination']//ul[@class='pagination right_space']//li[@class='page-item active']/following-sibling::li[1]/a";
			WebElement nextPageLink = driver.findElement(By.xpath(xpathExpression));
//			
//		        js.executeScript("arguments[0].scrollIntoView(true);", nextPageLink);
			click(driver, nextPageLink);
			Thread.sleep(100);

			// Perform your actions after clicking on each delete icon
		}
	}

//	public static void lastAndFirstPagination(WebDriver driver, int pageNumber) {
//		WebElement pageLink = driver.findElement(By.cssSelector(
//				".pagination_nav .pagination .page-item:not(.disabled) a[href*='?page=" + pageNumber + "']"));
//		click(driver, pageLink);
//
//	}

	public static void paginate(WebDriver driver,WebElement rightArrowElement,WebElement leftArrowElement) {
		
//		########### For Limit the iteration ###########
		
//		// Define the maximum number of iterations
//		int maxIterations = 3;
//		// Counter to keep track of the number of iterations
//		int iterationCount = 0;
//
//		// Loop for backward pagination with a limit
//		while (iterationCount < maxIterations) {
//		    try {
//		        // Store the current URL before clicking
//		        String currentUrlBeforeClick = driver.getCurrentUrl();
//		        // Scroll the element into view and click it
//		        js.executeScript("arguments[0].scrollIntoView(true);", rightArrowElement);
//		        click(driver, rightArrowElement);
//
//		        // If the URL remains the same after clicking, break the loop
//		        if (driver.getCurrentUrl().equals(currentUrlBeforeClick)) {
//		            break;
//		        }
//		        
//		        // Increment the iteration count
//		        iterationCount++;
//		        
//		    } catch (Exception e) {
//		        // Print the exception and break the loop
//		        System.out.println(e);
//		        break;
//		    }
		
//		########### For Limit the iteration ###########
		
		
		// Loop for backward paginate
		while (true) {
			try {

				String currentUrlBeforeClick = driver.getCurrentUrl();
				// Try to click the element
				js.executeScript("arguments[0].scrollIntoView(true);", rightArrowElement);
				click(driver, rightArrowElement);

				if (driver.getCurrentUrl().equals(currentUrlBeforeClick)) {
					break;
				}
				// If click succeeds, set the flag to true
//					isClickable = true;
			} catch (Exception e) {

				System.out.println(e);
				break;
			}
		}

		// Loop for forward paginate
		while (true) {
			try {

				String currentUrlBeforeClick = driver.getCurrentUrl();
				// Try to click the element
				js.executeScript("arguments[0].scrollIntoView(true);", leftArrowElement);
				click(driver, leftArrowElement);

				if (driver.getCurrentUrl().equals(currentUrlBeforeClick)) {
					break;
				}
				// If click succeeds, set the flag to true
//							isClickable = true;
			} catch (Exception e) {

				System.out.println(e);
				break;
			}
		}
	}

}
