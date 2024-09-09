package Advaita_TDD.Advaita_TDD;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v127.emulation.Emulation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAutomation {

	private WebDriver driver;
	private DevTools devTools;

	@BeforeTest
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void testLoginAndLogoutOnDifferentDevices() {
		String[][] devices = { { "iPhone X", "375", "812" }, { "iPad", "768", "1024" }, { "Nexus 10", "800", "1280" },
				{ "Desktop", "1920", "1080" } };

		String loginUrl = "https://ltfs-test.transmonqa.in/"; // Replace with your actual login URL
		String username = "capture_admin";
		String password = "8433@Taas";

		for (String[] device : devices) {
			String deviceName = device[0];
			int width = Integer.parseInt(device[1]);
			int height = Integer.parseInt(device[2]);

			System.out.println("Testing on " + deviceName);

			// Set device metrics
			devTools.send(Emulation.setDeviceMetricsOverride(width, height, 100, !deviceName.equals("Desktop"),
					Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
					Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

			// Navigate to the login page
			driver.get(loginUrl);

			// Find and interact with login elements
			WebElement usernameField = driver.findElement(By.name("username"));
			WebElement passwordField = driver.findElement(By.name("password"));
			WebElement loginButton = driver.findElement(By.xpath("//button[text()='Sign In']"));

			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			loginButton.click();

			// Wait for login to complete and verify successful login
			WebElement profileButton = driver.findElement(By.xpath("//a[normalize-space()='My Profile']"));
			WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));

			// Check if the profile button is displayed, indicating login success
			if (profileButton.isDisplayed()) {
				System.out.println("Login successful on " + deviceName);

				// Click profile button and then logout
				profileButton.click();

				// Wait for logout button to be clickable and click it
				logoutButton.click();

				// Verify successful logout
				WebElement loginPage = driver.findElement(By.name("username")); // Adjust as needed to verify logout
				if (loginPage.isDisplayed()) {
					System.out.println("Logout successful on " + deviceName);
				} else {
					System.out.println("Logout failed on " + deviceName);
				}
			} else {
				System.out.println("Login failed on " + deviceName);
			}

			// Clear DevTools settings for the next iteration
			devTools.send(Emulation.clearDeviceMetricsOverride());
		}
	}
}
