package com.advaita.Login.Home;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	public static WebElement usernameField;

	@FindBy(name = "password")
	public static WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	public static WebElement signInButton;

	@FindBy(xpath = "//li[text()='Invalid username or password. Please check your credentials.']")
	public static WebElement wrongUserErorrMessagElement;

	public HomePage loginloginTest;

	// initializing the Page Objects
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean ValidateDisplayed() {

		return usernameField.isDisplayed() && passwordField.isDisplayed() && signInButton.isDisplayed();
	}

	public boolean ValidateEnabled() {
		return usernameField.isEnabled() && passwordField.isEnabled() && signInButton.isEnabled();
	}

	public String getUsernameFieldPlaceholder() {
		return usernameField.getAttribute("placeholder");
	}

	public String getPasswordFieldPlaceholder() {
		return passwordField.getAttribute("placeholder");
	}

	public HomePage login(String eml, String pwd) throws InterruptedException {
		usernameField.clear();
		usernameField.sendKeys(eml);
		passwordField.clear();
		passwordField.sendKeys(pwd);
		click(driver, signInButton);
		Thread.sleep(1000);
		assertTrue(driver.getCurrentUrl().equals("https://pkt-test.transmonqa.in/en/alchemy/evaluation_tab_view/"),
				"Invalid password.");

//		List<WebElement> errorMessages = driver
//				.findElements(By.xpath("//li[text()='Invalid username or password. Please check your credentials.']"));
//		// Assert that the error message is not displayed
//		assertTrue(errorMessages.isEmpty(), "Login failed: Invalid username or password error message is displayed.");

		return new HomePage();
	}
}
