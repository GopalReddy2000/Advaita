package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.ClickUtilities;

import Advaita_TDD.Advaita_TDD.FakeData;

public class MasterMenusPage extends TestBase {

	String fetchMasterFormRecord;

	String menuName = FakeData.firstCapString() + " MasterMenus";

	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(xpath = "(//button[normalize-space()='Masters'])[1]")
	public static WebElement masterTabElement;

	@FindBy(id = "pills-MasterForms-tab")
	public static WebElement masterFormTabElement;

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[1]/td[1]")
	public static WebElement firstRecordOfFieldSet;

	@FindBy(id = "pills-MasterMenus-tab")
	public static WebElement masterMenusTab;

	@FindBy(xpath = "//button[@id='create_master_menu_btn']")
	public static WebElement masterMenuCreateButton;

	@FindBy(xpath = "//div[@class='modal-content']//form[@id='create_master_menu_form']")
	public static WebElement masterMenuCreatePopUp;

	@FindBy(xpath = "//select[@id='master_form']")
	public static WebElement masterFormDropDown;

	@FindBy(xpath = "//label[contains(text(),'Menu Name')]/..//input")
	public static WebElement menuNameField;

	@FindBy(xpath = "//button[@class='btn-primary'][normalize-space()='Save']")
	public static WebElement saveButton;

	public MasterMenusPage() {

		PageFactory.initElements(driver, this);
	}

	HomePage hp = new HomePage();

	public void navigateToMasterMenus() {

		String expectURL = "mainURl" + "en/masters/masters_menu_list/";

		hp.clickOnworkflowDesign();
		ClickUtilities.clickWithRetry(masterTabElement, 2);

		ClickUtilities.clickWithRetry(masterFormTabElement, 2);

		fetchMasterFormRecord = firstRecordOfFieldSet.getText();

		assertNotNull(fetchMasterFormRecord, "fetchMasterFormRecord is null");

		ClickUtilities.clickWithRetry(masterMenusTab, 2);

		assertEquals(driver.getCurrentUrl(), expectURL);
	}

	public void verifyCreateMasterMenuButton() {

		assertTrue(masterMenuCreateButton.isDisplayed() && masterMenuCreateButton.isEnabled(),
				"masterMenuCreateButton is not displayed and enabled.");
		click(driver, masterMenuCreateButton);

		wait.until(ExpectedConditions.visibilityOf(masterMenuCreatePopUp));
		assertTrue(masterMenuCreatePopUp.isDisplayed(), "masterMenuCreatePopUp is not displayed.");
	}

	public void verifyMasterFormDropDown() {

		Select masterForm = new Select(masterFormDropDown);

		assertFalse(masterForm.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = masterForm.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

//		Check default selected value
		WebElement defaultSelectedOption = masterForm.getFirstSelectedOption();
		String expectedDefaultOption = "Select Master Form"; // Replace with expected default value
		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption, "Default selected option is incorrect.");

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < Math.min(10, options.size()); k++) {
			masterForm.selectByIndex(k);
			WebElement selectedOption = masterForm.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

		System.out.println("fetchMasterFormRecord : " + fetchMasterFormRecord);
		masterForm.selectByVisibleText(fetchMasterFormRecord);

	}

	public void menuNameField() throws Throwable {

		// Check if the label ends with an asterisk
//		String text = driver.findElement(By.xpath("//h3[@class='process'][normalize-space()='Form Name*']")).getText();
//		char lastChar = text.charAt(text.length() - 1);
//		assertEquals(lastChar, '*', "formNameField label does not end with '*'.");

		// Ensure the role field is enabled
		assertTrue(menuNameField.isEnabled(), "formNameField is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = menuNameField.getAttribute("value");
		assertTrue(existingText.isEmpty(), "formNameField is not empty before entering text.");

		// Validate the role name (example: not empty and no special characters)
		assertNotNull(menuName, "menuName is null.");
		assertFalse(menuName.trim().isEmpty(), "Role name is empty.");
		assertTrue(menuName.matches("^[a-zA-Z0-9 ]+$"), "menuName contains special characters.");

		// Optionally, check if the role name already exists (pseudo-code, depends on
		// the application)
		// boolean roleExists = checkRoleExists(roleName);
		// assertFalse(roleExists, "Role name already exists.");

		// Enter the role name into the role field
		menuNameField.sendKeys(menuName);

		// Verify if the role name is correctly entered (optional)
		String enteredText = menuNameField.getAttribute("value");
		assertEquals(enteredText, menuName, "menuName is not correctly entered in the field.");

	}

	public void masterMenuSaveButton() {

		assertTrue(masterMenuCreateButton.isDisplayed() && masterMenuCreateButton.isEnabled(),
				"masterMenuCreateButton is not displayed and enabled.");
		click(driver, masterMenuCreateButton);

		assertFalse(masterMenuCreatePopUp.isDisplayed(), "masterMenuCreatePopUp is not displayed.");

	}
}
