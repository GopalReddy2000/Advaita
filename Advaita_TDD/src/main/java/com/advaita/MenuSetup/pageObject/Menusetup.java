package com.advaita.MenuSetup.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.UserStatus.pageobject.userStatus;

import Advaita_TDD.Advaita_TDD.FakeData;

public class Menusetup extends TestBase {

	private static final String Random = null;

	private static final boolean True = false;

	public Menusetup() {

		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	@FindBy(xpath = "//span[text()='Menu Setup']")
	public static WebElement menuSetup;

	@FindBy(xpath = "(//h1[text()=' Menu Setup '])[1]")
	public static WebElement verifyMenusSetup;

	@FindBy(xpath = "//tbody//tr//td[1]")
	public static List<WebElement> formNamesElements;

	@FindBy(xpath = "//tbody//tr//td[2]")
	public static List<WebElement> defaultNamesElements;

	@FindBy(xpath = "//tbody//tr//td[3]")
	public static List<WebElement> displayeNamesElements;

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	public static WebElement firstFormName;

	@FindBy(xpath = "//tbody//tr[1]//td[2]")
	public static WebElement firstDefaultName;

	@FindBy(xpath = "//tbody//tr[1]//td[3]")
	public static WebElement firstDisplayName;

	@FindBy(xpath = "//input[@id='text_search']")
	public static WebElement searcTextfield;

	@FindBy(xpath = "//h6[text()='Clear All Filters']")
	public static WebElement clearallFilters;

	@FindBy(xpath = "//button//img[@alt='filter_search']")
	public static WebElement searchButton;

	// Edit
	@FindBy(xpath = "//tbody//tr[1]//td//img[@alt='table-edit']")
	public static WebElement editOptions;

	@FindBy(xpath = "(//h1[text()=' Edit Menu Setup '])[1]")
	public static WebElement verifyEditMenusSetup;

	@FindBy(id = "form_name")
	public static WebElement formNameEdit;

	@FindBy(xpath = "//input[@id='default_name']")
	public static WebElement defaultNameEdit;

	@FindBy(xpath = "//input[@id='display_name']")
	public static WebElement displayNameEdit;

	@FindBy(xpath = "//button[@id='submt_single']")
	public static WebElement updateButton;

	@FindBy(xpath = "(//span[@id='change_msg'])[1]")
	public static WebElement updateSuccessfullyPopup;

	@FindBy(xpath = "(//span[@id='change_msg'])[1]/..//button")
	public static WebElement ContinueButtonEdit;

	public void navigateTomenuSetup() {

		assertTrue(menuSetup.isDisplayed(), "menuSetup is not displayed");
		assertTrue(menuSetup.isEnabled(), "menuSetupis not enable");
		jsClick(driver, menuSetup);

		assertTrue(verifyMenusSetup.isDisplayed(), "verifyMenusSetupis not displayed");
	}

	public void searchByFormName() {

		userStatus menuSetup = new userStatus();

		List<String> formnNameList = new ArrayList<String>();

		// Loop through the elements and add the text to formnNameList
		for (WebElement formName : formNamesElements) {
			String formText = formName.getText(); // Get text of the element
			formnNameList.add(formText); // Add text to the list
			System.out.println("Form Name: " + formText); // This will print all form names
		}

		// Select a random element from the formnNameList
		Random random = new Random();
		int randomIndex = random.nextInt(formnNameList.size()); // Get random index
		String randomText = formnNameList.get(randomIndex); // Get text at the random index

		menuSetup.inputFieldIsDisplayed(searcTextfield);
		assertTrue(searcTextfield.isEnabled(), "searcTextfieldi not enabled");
		menuSetup.checkthroughAsterisk(searcTextfield, false);

		searcTextfield.clear();
		searcTextfield.sendKeys(randomText);

		// Print the randomly selected form name text
		System.out.println("Randomly selected formName: " + randomText);

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		assertTrue(searchButton.isEnabled(), "searchButton is not enabled");

		searchButton.click();

		String firstFormNameText = firstFormName.getText();
		System.out.println("firstFormNameText :" + firstFormNameText);

		assertEquals(firstFormNameText, randomText);

	}

	public void searchByDefaultName() {

		List<String> defaultNameList = new ArrayList<String>();

		// Loop through the elements and add the text to formnNameList
		for (WebElement defaultName : defaultNamesElements) {
			String defaultText = defaultName.getText(); // Get text of the element
			defaultNameList.add(defaultText); // Add text to the list
			System.out.println("Default Name: " + defaultText); // This will print all form names
		}

		// Select a random element from the formnNameList
		Random random = new Random();
		int randomIndex = random.nextInt(defaultNameList.size()); // Get random index
		String randomText = defaultNameList.get(randomIndex); // Get text at the random index

		searcTextfield.clear();
		searcTextfield.sendKeys(randomText);

		// Print the randomly selected form name text
		System.out.println("Randomly selected defaultName: " + randomText);

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		assertTrue(searchButton.isEnabled(), "searchButton is not enabled");

		searchButton.click();

		String firstDefaultNameText = firstDefaultName.getText();
		System.out.println("firstDefaultNameText :" + firstDefaultNameText);

		assertEquals(firstDefaultNameText, randomText);

	}

	public void SearchByDisplayName() {

		List<String> displayNameList = new ArrayList<String>();

		// Loop through the elements and add the text to formnNameList
		for (WebElement displayName : displayeNamesElements) {
			String displayText = displayName.getText(); // Get text of the element
			displayNameList.add(displayText); // Add text to the list
			System.out.println("Default Name: " + displayText); // This will print all form names
		}

		// Select a random element from the formnNameList
		Random random = new Random();
		int randomIndex = random.nextInt(displayNameList.size()); // Get random index
		String randomText = displayNameList.get(randomIndex); // Get text at the random index

		searcTextfield.clear();
		searcTextfield.sendKeys(randomText);

		// Print the randomly selected form name text
		System.out.println("Randomly selected displayName: " + randomText);

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		assertTrue(searchButton.isEnabled(), "searchButton is not enabled");

		searchButton.click();

		String firstDisplayNameText = firstDefaultName.getText();
		System.out.println("firstDisplayNameText :" + firstDisplayNameText);

		assertEquals(firstDisplayNameText, randomText);

	}

	public void cleatfilter() {
		String beforesearchtextfieldInputValue = searcTextfield.getAttribute("value");
		System.out.println("searchtextfieldInputValue :" + beforesearchtextfieldInputValue);

		assertTrue(clearallFilters.isDisplayed(), "clearallFilters is not displayed");
		assertTrue(clearallFilters.isEnabled(), "clearallFiltersis not enabled");

		clearallFilters.click();

		String afterSearchtextfieldInputValue = searcTextfield.getAttribute("value");
		System.out.println("afterSearchtextfieldInputValue :" + afterSearchtextfieldInputValue);

		assertNotEquals(afterSearchtextfieldInputValue, beforesearchtextfieldInputValue);

	}

	public void navigateToEditMenuSetup() {

		String userStatusUrl = driver.getCurrentUrl();
		System.out.println("userStatusUrl :" + userStatusUrl);

		assertTrue(editOptions.isDisplayed(), "edit is not displayed");
		assertTrue(editOptions.isEnabled(), "editOptions is not displayed");

		editOptions.click();

		String editStatusUrl = driver.getCurrentUrl();
		System.out.println("editStatusUrl :" + editStatusUrl);

		assertNotEquals(editStatusUrl, userStatusUrl, "The Url is not changed");

	}

//	public boolean menusSetupEdit() {
//
//		userStatus menusSetup = new userStatus();
//		menusSetup.inputFieldIsDisplayed(formNameEdit);
//
//		// Check if the element is enabled
//		if (formNameEdit.isEnabled()) {
//			System.out.println("The form_name element is enabled.");
//			assertTrue(formNameEdit.isEnabled(), "Element is enabled.");
//			return false; // Return false if enabled
//
//		}
//		return True; // Return true if displayed but not enabled
//
//	}

//	public boolean menusSetupEdit() {
//
//		// Form name
//		// Check if the formNameEdit element is displayed
//		userStatus menusSetup = new userStatus();
//		menusSetup.inputFieldIsDisplayed(formNameEdit);
//		menusSetup.checkthroughAsterisk(formNameEdit, false);
//
//		formNameEdit.getAttribute(Random);
//		
//		// Check if the element is enabled
//		if (formNameEdit.isEnabled()) {
//			System.out.println(formNameEdit.isEnabled());
//			System.out.println("The form_name element is enabled.");
//
//			return false; // Return false if the element is enabled
//		} else {
//			System.out.println("The form_name element is not enabled.");
//			return true; // Return true if the element is not enabled
//		}
//		
//
//	}

	public void formNameEdit() {

		// Form name
		// Check if the formNameEdit element is displayed
		userStatus menusSetup = new userStatus();
		menusSetup.inputFieldIsDisplayed(formNameEdit);
		menusSetup.checkthroughAsterisk(formNameEdit, false);

		// Check if the element is enabled
		if (formNameEdit.isEnabled()) {
			System.out.println("The form_name element is enabled.");

			// Assert that the formNameEdit is enabled
			assertTrue(formNameEdit.isEnabled(), "The form_name element should be enabled but is not.");

		} else {
			System.out.println("The form_name element is not enabled.");

			// Assert that the formNameEdit is not enabl
			assertFalse(formNameEdit.isEnabled(), "The form_name element should not be enabled but it is.");
		}
		String attributeValue = formNameEdit.getAttribute("value");
		System.out.println("Attribute Value: " + attributeValue);

		driver.navigate().back();
		assertEquals(attributeValue, firstFormName.getText());

	}

	public void defautNameEdit() {
		// Default name
		// Check if the DefaultEdit element is displayed
		userStatus menusSetup1 = new userStatus();

		menusSetup1.inputFieldIsDisplayed(defaultNameEdit);
		menusSetup1.checkthroughAsterisk(defaultNameEdit, false);

		// Check if the element is enabled
		if (defaultNameEdit.isEnabled()) {
			System.out.println("The default_name element is enabled.");

			// Assert that the formNameEdit is enabled
			assertTrue(defaultNameEdit.isEnabled(), "The default_name element should be enabled but is not.");

		} else {
			System.out.println("The default_name element is not enabled.");

			// Assert that the formNameEdit is not enabl
			assertFalse(defaultNameEdit.isEnabled(), "The default_name element should not be enabled but it is.");
		}
		String attributeValue = defaultNameEdit.getAttribute("value");
		System.out.println("Attribute Value: " + attributeValue);

		driver.navigate().back();
		assertEquals(attributeValue, firstDefaultName.getText());

	}

	public void displayNameEdit(String textToEnter) {
		// Dislay name
		// Check if the displayEdit element is displayed
		userStatus menusSetup2 = new userStatus();

		menusSetup2.inputFieldIsDisplayed(displayNameEdit);
		menusSetup2.checkthroughAsterisk(displayNameEdit, false);

		// Check if the element is enabled
		if (displayNameEdit.isEnabled()) {
			System.out.println("The display_name element is enabled.");

			// Assert that the formNameEdit is enabled
			assertTrue(displayNameEdit.isEnabled(), "The display_name element should be enabled but is not.");

		} else {
			System.out.println("The display_name element is not enabled.");

			// Assert that the formNameEdit is not enabl
			assertFalse(displayNameEdit.isEnabled(), "The display_name element should not be enabled but it is.");
		}
//		String attributeValue = displayNameEdit.getAttribute("value");
//		System.out.println("Attribute Value: " + attributeValue);
//
//		driver.navigate().back();
//		assertEquals(attributeValue, firstDisplayName.getText());

		String attributeValue = displayNameEdit.getAttribute("value");
		System.out.println("Attribute Value: " + attributeValue);

		displayNameEdit.clear();

		displayNameEdit.sendKeys(textToEnter);

		String afterDisplayNameattributeValue = displayNameEdit.getAttribute("value");
		System.out.println("afterDisplayNameattributeValue : " + afterDisplayNameattributeValue);

		assertNotEquals(attributeValue, afterDisplayNameattributeValue);

		assertTrue(updateButton.isDisplayed(), "updateButtoni is not displayed");
		updateButton.click();

		assertTrue(updateButton.isDisplayed(), "updateButton is not displayed");

		wait.until(ExpectedConditions.visibilityOf(updateSuccessfullyPopup));
		assertTrue(updateSuccessfullyPopup.isDisplayed(), "updateSuccessfullyPopup is not displayed");
		assertTrue(ContinueButtonEdit.isDisplayed(), "ContinueButtonEditis not displayed");
		ContinueButtonEdit.click();

		assertEquals(afterDisplayNameattributeValue, firstDisplayName.getText());
		driver.navigate().refresh();

	}
}
