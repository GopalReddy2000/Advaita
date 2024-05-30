package com.advaita.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	
	//Global Variable(Need to be Initialize)
	//It should be only within class scopes
	public static ChromeDriver driver;
	public static DevTools devTools;
//	public static FirefoxDriver driver;
	public static ChromeOptions options;
	public static WebDriverWait wait;
	public static Actions actions;
	public static JavascriptExecutor js;
	public static Robot robot;

	public static void initialization() throws AWTException {

		// Incognito Mode Execution
		options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);
		driver = new ChromeDriver(options);

		// Normal Execution
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		actions = new Actions(driver);
		robot = new Robot();
		js = (JavascriptExecutor) driver;

		

		driver.get("https://pkt-test.transmonqa.in/en/myprofile/login/");

	}
	
	
	  // Generate a random string of alphabetic characters
    public static String generateRandomAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    // Generate a random string of alphanumeric characters
    public static String generateRandomAlphanumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    // Generate a random string of numeric characters
    public static String generateRandomNumericString(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
	
	


//Click Action
	public static void click(WebDriver driver, WebElement element) {
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			if (!element.isDisplayed()) {
				throw new NoSuchElementException("Element not visible so could not click: " + element);
			}

			element.click();
		} catch (Exception e1) {
			try {
				element.sendKeys(Keys.ENTER);
			} catch (Exception e2) {
				try {
					js.executeScript("arguments[0].click();", element);
				} catch (Exception e3) {
					actions.click(element).build().perform();
				}
			}

		}

	}
	
	
	
	
	 


}
