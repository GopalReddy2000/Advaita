package com.advaita.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class TestBase {

	// Global Variable(Need to be Initialize)
	// It should be only within class scopes
	public static ChromeDriver driver;
	public static DevTools devTools;
	//	public static FirefoxDriver driver;
	public static ChromeOptions options;
	public static WebDriverWait wait;
	public static Actions actions;
	public static JavascriptExecutor js;
	public static Robot robot;
	
	protected static SoftAssert softAssert;

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
		softAssert = new SoftAssert();

		// For Get the Error Status
		//		devTools = ((ChromeDriver) driver).getDevTools();
		//		devTools.createSession();
		//		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//
		//		devTools.addListener(Network.requestWillBeSent(), requestConsumer -> {
		//			Request req = requestConsumer.getRequest();
		//
		//			// System.out.println("Send URL :- "+req.getUrl()+"\n"+"\n");
		//		});
		//
		//		devTools.addListener(Network.responseReceived(), response -> {
		//			Response res = response.getResponse();
		//
		//			// System.err.println(res.getStatus() + " :- "+res.getStatusText()+"\n"+"\n");
		//			if (res.getStatus().toString().startsWith("3") || res.getStatus().toString().startsWith("4")
		//					|| res.getStatus().toString().startsWith("5")) {
		//				String errorMessage = "Error status received: " + res.getStatus() + " - " + res.getStatusText()
		//						+ "\nError URL: " + res.getUrl();
		//
		//				System.out.println(errorMessage);
		//				// Hard assertion
		//				Assert.fail(errorMessage);
		//			}
		//		});

		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");

	}


//	SendKeys
	
	public void sendKeys(WebElement webelement,String str)
	{
		jsClick(driver, webelement);
		webelement.clear();
		webelement.sendKeys(str);
	}
	
	public static void clickElementMultipleTimes(WebDriver driver, WebElement element, int clickCount) {
        for (int i = 0; i < clickCount; i++) {
        	jsClick(driver, element);
        }
    }

	public static void jsClick(WebDriver driver, WebElement element)
	{
		js.executeScript("arguments[0].click();", element);
	}
	
	
	//Click Action
	public static void click(WebDriver driver, WebElement element) {
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
