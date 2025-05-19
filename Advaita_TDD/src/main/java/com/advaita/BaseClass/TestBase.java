package com.advaita.BaseClass;

import static org.testng.Assert.assertFalse;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.RequestId;
import org.openqa.selenium.devtools.v129.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.advaita.Login.Home.LoginPage;
import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	// Global Variable(Need to be Initialize)
	// It should be only within class scopes
	public static WebDriver driver;
	public static DevTools devTools;
	// public static FirefoxDriver driver;
	public static ChromeOptions options;
	public static WebDriverWait wait;
	public static Actions actions;
	public static JavascriptExecutor js;
	public static Robot robot;
	public static Properties properties;

  
	protected static SoftAssert softAssert;
	public static String mainURl = "https://test.capture.autosherpas.com/";
//	public static String mainURl = "https://fkart.transmonqa.in/";
//	public static String mainURl1 = "https://ltfs-test.transmonqa.in/";
	

	public static void initialization() throws AWTException {
		WebDriverManager.chromedriver().setup();
		// Incognito Mode Execution
//		options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		options.addArguments("use-fake-ui-for-media-stream");
//		options.addArguments("use-fake-ui-for-media-stream");
//		options.addArguments("--incognito");
//
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(ChromeOptions.CAPABILITY, options);
//		cap.setCapability("applicationCacheEnabled", false);
//		// Setting the default behavior to block the microphone
//		options.merge(cap);
//
		options = new ChromeOptions();
		
//        options.addArguments("--headless=new"); // Use new headless mode (recommended for Chrome)
//        options.addArguments("--disable-gpu"); // Optional, but recommended for headless
//        options.addArguments("--window-size=1920,1080"); // Set window size for consistent rendering
//        options.addArguments("--no-sandbox"); // For CI/CD environments
//        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
		
        Map<String, Object> prefs = new HashMap<>();
		// Set Chrome preferences to block microphone and camera

		prefs.put("profile.default_content_setting_values.media_stream_mic", 2); // 1: Allow, 2: Block
		prefs.put("profile.default_content_setting_values.media_stream_camera", 2); // Block camera as well
		prefs.put("profile.default_content_setting_values.geolocation", 2); // Block geolocation access just in case
		options.setExperimentalOption("prefs", prefs);
		// Normal Execution
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		actions = new Actions(driver);
		robot = new Robot();
		properties = new Properties();
		js = (JavascriptExecutor) driver;
		softAssert = new SoftAssert();

		// Set up DevTools
//		DevTools devTools = ((ChromeDriver) driver).getDevTools();
//		devTools.createSession();
//
//		// Enable network tracking
//		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//		// Add a listener to capture response details
//		devTools.addListener(Network.responseReceived(), response -> {
//			RequestId requestId = response.getRequestId();
//			Response responseDetails = response.getResponse();
//
//			// Get the status code and status text
//			int statusCode = responseDetails.getStatus();
//			String statusText = responseDetails.getStatusText();
//
//			// Print details only if the status code starts with 3, 4, or 5
//			if (statusCode >= 300 && statusCode < 600) { // Status codes 3xx, 4xx, 5xx
//				System.out.println("\n"+"URL: " + responseDetails.getUrl());
//				System.out.println("Status Code: " + statusCode);
//				System.out.println("Status Text: " + statusText + "\n");
//			}
//		});

		driver.get(mainURl);

	}
	

 // Helper method to delete existing files in the folder
    public static void deleteExistingFiles(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    boolean deleted = file.delete();
                    if (deleted) {
                        System.out.println("Deleted existing file: " + file.getName());
                    } else {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                }
            }
        }
    }

	// SendKeys

	public static void sendKeys(WebElement webelement, String str) {
		jsClick(webelement);
		webelement.clear();
		webelement.sendKeys(str);
	}

	volatile String a = "James";

	@FindBy(xpath = "(//button[text()='Continue'])[2]")
	public WebElement continueButton;
	
	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement continueButton2;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;
	@FindBy(css = "img.arrow-left")
	protected WebElement backButton;

	public void saveRecord() {
		jsClick(save);
		unWait(1);
		continueButton.click();
	}

	protected void jsDateExecutor(WebElement dateField, String date) {
		js.executeScript("arguments[0].value = arguments[1];", dateField, date);
	}

	public static void clickElementMultipleTimes(WebDriver driver, WebElement element, int clickCount) {
		for (int i = 0; i < clickCount; i++) {
			jsClick(element);
		}
	}

	public void jsWindowsScroll(int toScroll) {
		js.executeScript("window.scrollTo(0, " + toScroll + ");");
	}

	// Method to scroll to a specific percentage of the page
	public void scrollToPercentage(int percentage) {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight * " + (percentage / 100.0) + ");");
	}

	public void jsWindowsScrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void jsClick(WebElement element) {

		js.executeScript("arguments[0].click();", element);
	}
	
	public static void jsClick(WebDriver driver, WebElement element) {
		
		js.executeScript("arguments[0].click();", element);
	}

	public static int extractNumber(String input) {
		StringBuilder numberAsString = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				numberAsString.append(c);
			}
		}

		return Integer.parseInt(numberAsString.toString());
	}

	protected void selectByVisibleText(WebElement dropdownElement, String optionText) {

		wait.until(ExpectedConditions.visibilityOf(dropdownElement));
		// Create a Select object for the dropdown
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByVisibleText(optionText);
	}

	protected static void selectByVisibleText(WebElement dropdownElement, List<String> optionText) {
		// Create a Select object for the dropdown
		Select dropdown = new Select(dropdownElement);
		for (int a = 0; a < optionText.size(); a++) {
			dropdown.selectByVisibleText(optionText.get(a));
		}
	}

	public static void unWait(int seconds) {
		Uninterruptibles.sleepUninterruptibly(seconds, TimeUnit.SECONDS);
	}

	public static void unWaitInMilli(int milliSeconds) {
		Uninterruptibles.sleepUninterruptibly(milliSeconds, TimeUnit.MILLISECONDS);
	}

	// Random Index

	public static WebElement getRandomElement(List<WebElement> elements) {
		int randomIndex = 0;
		try {
			randomIndex = ThreadLocalRandom.current().nextInt(elements.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elements.get(randomIndex);
	}

	@FindBy(id = "menulist2")
	public
	WebElement alchemy;

	public void navigateWithinAlchemy(WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
			
			jsClick(element);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			unWait(1);
			jsClick(alchemy);
			jsClick(element);
		}

	}

	@FindBy(xpath = "(//a[@id='menulist3'])[2]")
	WebElement masters;

	public void navigateWithinMasters(WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
			jsClick(element);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			jsClick(masters);
			jsClick(element);
		}

	}

	@FindBy(xpath = "//a[@id='menulist1']")
	WebElement userSetup;

	public void navigateWithinUserSetup(WebElement element) {
		try {
			jsClick(element);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			jsClick(userSetup);
			jsClick(element);
		}

	}

	public void loginToUser(String UserName) {
		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");

		LoginPage.usernameField.sendKeys(UserName);
		LoginPage.passwordField.sendKeys("Qwerty@123");
		LoginPage.signInButton.click();
//		driver.navigate().to("https://test.capture.autosherpas.com/en/master_parameters/measurable_set/");
	}

	public String jsInnerText(WebElement element) {
		Object monthObject = js.executeScript("return arguments[0].innerText;", element);
		return (String) monthObject;
	}

	// Click Action

	// Click Action
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
	

	public void dropdownUtil(WebElement dropdownElement, String expectedOption) {
		Select dropdown = new Select(dropdownElement);
		assertFalse(dropdown.isMultiple());
		try {
			List<WebElement> options = dropdown.getOptions();

			// Check if options list is empty or contains only one placeholder option
			if (options.isEmpty() || (options.size() == 1 && options.get(0).getText().isEmpty())) {
				throw new AssertionError("Dropdown is empty or contains only a placeholder option.");
			} else {
				System.out.println("Dropdown contains options.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Error validating dropdown options.", e);
		}

		// Verify the dropdown contains the expected options.

		try {
			// Get all options from the dropdown
			List<WebElement> options = dropdown.getOptions();

			// Create a list to hold the actual options text
			List<String> actualOptions = new ArrayList<>();
			for (WebElement option : options) {
				actualOptions.add(option.getText());
			}

			// Check if each expected option is present in the actual options

			if (!actualOptions.contains(expectedOption)) {
				throw new AssertionError("Dropdown does not contain expected option: " + expectedOption);
			}

			System.out.println("Dropdown contains all expected options.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Error validating dropdown options.", e);
		}

	}

	public static void click1(WebDriver driver, WebElement element) {
		try {
			if (!element.isDisplayed()) {
				throw new NoSuchElementException("Element not visible so could not click: " + element);
			}

			element.click();
		} catch (Exception e1) {

			element.click();

		}
	}
}
