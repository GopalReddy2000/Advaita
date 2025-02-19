package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.CommonUtils;
import com.advaita.Utilities.DropDown;

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

	@FindBy(xpath = "//h3[text()='Success']/..//span[contains(normalize-space(),'Masters Menu has been Created successfully')]")
	public static WebElement successPopUp;

	@FindBy(xpath = "//h3[text()='Success']/..//span[contains(normalize-space(),'Masters Menu has been Created successfully')]/..//button[text()='Continue']")
	public static WebElement successPopUpContinueButton;

	public MasterMenusPage() {

		PageFactory.initElements(driver, this);
	}

	HomePage hp = new HomePage();

	public void navigateToMasterMenus() throws Throwable {

		String expectURL = mainURl + "en/masters/masters_menu_list/";

		hp.clickOnworkflowDesign();
		ClickUtilities.clickWithRetry(masterTabElement, 2);

		ClickUtilities.clickWithRetry(masterFormTabElement, 2);

		fetchMasterFormRecord = firstRecordOfFieldSet.getText();

		assertNotNull(fetchMasterFormRecord, "fetchMasterFormRecord is null");

		ClickUtilities.clickWithRetry(masterMenusTab, 2);

		assertEquals(driver.getCurrentUrl(), expectURL);
	}

	public MasterMenusPage verifyCreateMasterMenuButton() {

		assertTrue(masterMenuCreateButton.isDisplayed() && masterMenuCreateButton.isEnabled(),
				"masterMenuCreateButton is not displayed and enabled.");
		click(driver, masterMenuCreateButton);

		wait.until(ExpectedConditions.visibilityOf(masterMenuCreatePopUp));
		assertTrue(masterMenuCreatePopUp.isDisplayed(), "masterMenuCreatePopUp is not displayed.");

		return this;
	}

	public MasterMenusPage verifyMasterFormDropDown(String selectMasterForm,String menuName) throws Throwable {

		CommonUtils.validateLastCharIsStar(driver, "//div[@class='form_group']/label");
		DropDown.validateDropdownWithOutOrder(masterFormDropDown, "Select Master Form", selectMasterForm);
		menuNameField(menuName);

		return this;
	}

	public MasterMenusPage menuNameField(String menuName) {

		// Ensure the role field is enabled
		assertTrue(menuNameField.isEnabled(), "formNameField is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = menuNameField.getAttribute("value");
		assertTrue(existingText.isEmpty(), "formNameField is not empty before entering text.");

		// Validate the role name (example: not empty and no special characters)
		assertNotNull(menuName, "menuName is null.");
		assertFalse(menuName.trim().isEmpty(), "Role name is empty.");
		assertTrue(menuName.matches("^[a-zA-Z0-9 ]+$"), "menuName contains special characters.");

		// Enter the role name into the role field
		menuNameField.sendKeys(menuName);

		// Verify if the role name is correctly entered (optional)
		String enteredText = menuNameField.getAttribute("value");
		assertEquals(enteredText, menuName, "menuName is not correctly entered in the field.");

		return this;
	}

	public MasterMenusPage masterMenuSaveButton() {

		assertTrue(saveButton.isDisplayed() && saveButton.isEnabled(), "saveButton is not displayed and enabled.");
		click(driver, saveButton);

		assertFalse(masterMenuCreatePopUp.isDisplayed(), "masterMenuCreatePopUp is displayed.");

		confirmationAfterClickOnSaveButton();

		return this;

	}

	public void confirmationAfterClickOnSaveButton() {

		wait.until(ExpectedConditions.visibilityOf(successPopUp));
		assertTrue(successPopUp.isDisplayed(), "successPopUp is not displayed.");
		click(driver, successPopUpContinueButton);
	}
}
