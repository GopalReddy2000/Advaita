package com.advaita.MenuSetup.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.UserStatus.pageobject.UserStatus;
import com.advaita.Utilities.SendDataUtils;
import com.advaita.alchemyPageObject.SkipReason;
import com.advaita.alchemyPageObject.SmsTemplate;
import com.advaita.pageObjects.UserSetupPage;

import Advaita_TDD.Advaita_TDD.FakeData;

public class Menusetup extends TestBase {

	public Menusetup() {

		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	UserSetupPage userSetupPage = new UserSetupPage();

	// Login UserId
	String superAmdin = "Capture_Admin";
	String superAdminPass = "Qwerty@123";

	@FindBy(xpath = "//span[text()='Menu Setup']")
	public WebElement menuSetup;

	@FindBy(xpath = "(//h1[text()=' Menu Setup '])[1]")
	public WebElement verifyMenusSetup;

	@FindBy(xpath = "//tbody//tr//td[1]")
	public List<WebElement> formNamesElements;

	@FindBy(xpath = "//tbody//tr//td[2]")
	public List<WebElement> defaultNamesElements;

	@FindBy(xpath = "//tbody//tr//td[3]")
	public List<WebElement> displayNamesElements;

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	public WebElement firstFormName;

	@FindBy(xpath = "//tbody//tr[1]//td[2]")
	public WebElement firstDefaultName;

	@FindBy(xpath = "//tbody//tr[1]//td[3]")
	public WebElement firstDisplayName;

	@FindBy(xpath = "//input[@id='text_search']")
	public WebElement searchTextfield;

	@FindBy(xpath = "//h6[text()='Clear All Filters']")
	public WebElement clearallFilters;

	@FindBy(xpath = "//button//img[@alt='filter_search']")
	public WebElement searchButton;

	// Edit
	@FindBy(xpath = "//tbody//tr[1]//td//img[@alt='table-edit']")
	public WebElement editOption;

	@FindBy(xpath = "(//h1[text()=' Edit Menu Setup '])[1]")
	public WebElement verifyEditMenusSetup;

	@FindBy(id = "form_name")
	public WebElement formNameEdit;

	@FindBy(xpath = "//input[@id='default_name']")
	public WebElement defaultNameEdit;

	@FindBy(xpath = "//input[@id='display_name']")
	public WebElement displayNameEdit;

	@FindBy(xpath = "//label[text()='Display Name']")
	public WebElement displayNameLabel;

	@FindBy(xpath = "//button[@id='submt_single']")
	public WebElement updateButton;

	@FindBy(xpath = "(//span[@id='change_msg'])[1]")
	public WebElement updateSuccessfullyPopup;

	@FindBy(xpath = "(//span[@id='change_msg'])[1]/..//button")
	public WebElement ContinueButtonEdit;

	@FindBy(xpath = "//tbody//td[not(@class='action-header')][position()<=3]")
	public List<WebElement> nameLists;

	// Neagtive

	@FindBy(xpath = "//span[@id='change_error_msg']")
	public WebElement somethingWentWrongErrorMesg;

	@FindBy(id = "display_name-error")
	public WebElement displayNameErrorMessage;

	@FindBy(xpath = "//tbody//td[text()='No Records Found']")
	public WebElement noRecordsFound;

	public void navigateTouserSetup() { // Need To implememnt
		userSetupPage.navToUserCreatePage();
		userSetupPage.userCreationFields("das", "Abhijit", "Qwerty@123");
		userSetupPage.singleGroupSelect("Admin");
		userSetupPage.clickOnGroupCreateButton();

		userSetupPage.userMappingRecord("das Abhijit");
		userSetupPage.userMappingProcess(emoji, superAmdin, superAdminPass, emoji);

	}

	public void navigateTomenuSetup() {

		assertTrue(menuSetup.isDisplayed(), "menuSetup is not displayed");
		assertTrue(menuSetup.isEnabled(), "menuSetupis not enable");
		jsClick(driver, menuSetup);

		assertTrue(verifyMenusSetup.isDisplayed(), "verifyMenusSetupis not displayed");
	}

	@FindBy(xpath = "//ul[@class='sidemenu_ul']//li")
	public List<WebElement> sideMenus;

	List<String> sideMenusLists = new ArrayList<String>();

	// Data Setup
	// Workflow Design
	// User Setup
	// DashBoards
	// Masters
	// User Status
	// API Key Setup
	// Menu Setup
	// Site Settings
	public void fetchSideMenus() {

		navigateTomenuSetup();

		for (WebElement fetchSideMenusLists : sideMenus) {
			String fetchSideMenusListsTexts = fetchSideMenusLists.getText();
			System.out.println("fetchSideMenusListsTexts: " + fetchSideMenusListsTexts);

			sideMenusLists.add(fetchSideMenusListsTexts);

		}

	}

	public void searchThroughPartialNamesinSearchTextfieldUTILITY() {
		// navigateTomenuSetup();

		for (WebElement menuNameLists : nameLists) {

			String menuNameListsText = menuNameLists.getText();
			unWait(1);
			System.out.println("Full text: " + menuNameListsText);

			// Take a substring of the menu name text (e.g., first 3 characters)
			String partialText = menuNameListsText.length() >= 3 ? menuNameListsText.substring(0, 3)
					: menuNameListsText;

			// Generate a random substring from partialText
			String randomText;
			if (partialText.length() > 1) {
				Random rand = new Random();
				int start = rand.nextInt(partialText.length() - 1);
				int end = start + 1 + rand.nextInt(partialText.length() - start);
				randomText = partialText.substring(start, end);
			} else {
				randomText = partialText; // Use full partialText if it’s just one character
			}

			System.out.println("Random text used for search: " + randomText);

			// Verify the search field is displayed
			assertTrue(searchTextfield.isDisplayed(), "searchTextfield is not displayed");

			// Clear the search field, enter the random text, and click the search button
			searchTextfield.clear();
			searchTextfield.sendKeys(randomText);

			// Click the search button
			searchButton.click();
			clearallFilters.click();
			break; // Exit the loop after clearing the filters
		}

//		for (int i = 0; i < nameLists.size(); i++) {
//		    // Re-fetch the nameLists each time to avoid stale element references
//		    List<WebElement> currentNameLists = driver.findElements(By.xpath("//tbody//td[not(@class='action-header')][position()<=3]"));
//		    WebElement menuNameLists = currentNameLists.get(i);
//		    
//		    String menuNameListsText = menuNameLists.getText();
//		    System.out.println("Full text: " + menuNameListsText);
//
//		    // Take a substring of the menu name text (e.g., first 3 characters)
//		    String partialText = menuNameListsText.length() >= 3 ? menuNameListsText.substring(0, 3) : menuNameListsText;
//
//		    // Generate a random substring from partialText
//		    String randomText;
//		    if (partialText.length() > 1) {
//		        Random rand = new Random();
//		        int start = rand.nextInt(partialText.length() - 1);
//		        int end = start + 1 + rand.nextInt(partialText.length() - start);
//		        randomText = partialText.substring(start, end);
//		    } else {
//		        randomText = partialText;
//		    }
//
//		    System.out.println("Random text used for search: " + randomText);
//
//		    // Verify the search field is displayed
//		    assertTrue(searchTextfield.isDisplayed(), "searchTextfield is not displayed");
//
//		    // Clear the search field, enter the random text, and click the search button
//		    searchTextfield.clear();
//		    searchTextfield.sendKeys(randomText);
//
//		    // Click the search button
//		    searchButton.click();
//		    clearallFilters.click();
//		    break; // Exit the loop after clearing the filters

//		}

	}

	public void searchByFormName() {

		UserStatus menuSetup = new UserStatus();

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

		menuSetup.inputFieldIsDisplayed(searchTextfield);
		assertTrue(searchTextfield.isEnabled(), "searcTextfieldi not enabled");
		menuSetup.checkthroughAsterisk(searchTextfield, false);

		searchTextfield.clear();
		searchTextfield.sendKeys(randomText);

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

		searchTextfield.clear();
		searchTextfield.sendKeys(randomText);

		// Print the randomly selected form name text
		System.out.println("Randomly selected defaultName: " + randomText);

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		assertTrue(searchButton.isEnabled(), "searchButton is not enabled");

		searchButton.click();

		String firstDefaultNameText = firstDefaultName.getText();
		System.out.println("firstDefaultNameText :" + firstDefaultNameText);

		assertEquals(firstDefaultNameText, randomText);

	}

	List<String> displayNameList = new ArrayList<String>();

	public void SearchByDisplayName() {

		// Loop through the elements and add the text to formnNameList
		for (WebElement displayName : displayNamesElements) {
			String displayText = displayName.getText(); // Get text of the element
			displayNameList.add(displayText); // Add text to the list
			System.out.println("Default Name: " + displayText); // This will print all form names
		}

		// Select a random element from the formnNameList
		Random random = new Random();
		int randomIndex = random.nextInt(displayNameList.size()); // Get random index
		String randomText = displayNameList.get(randomIndex); // Get text at the random index

		searchTextfield.clear();
		searchTextfield.sendKeys(randomText);

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
		String beforesearchtextfieldInputValue = searchTextfield.getAttribute("value");
		System.out.println("searchtextfieldInputValue :" + beforesearchtextfieldInputValue);

		assertTrue(clearallFilters.isDisplayed(), "clearallFilters is not displayed");
		assertTrue(clearallFilters.isEnabled(), "clearallFiltersis not enabled");

		clearallFilters.click();

		String afterSearchtextfieldInputValue = searchTextfield.getAttribute("value");
		System.out.println("afterSearchtextfieldInputValue :" + afterSearchtextfieldInputValue);

		assertNotEquals(afterSearchtextfieldInputValue, beforesearchtextfieldInputValue);

	}

	public void navigateToEditMenuSetup() {

		String userStatusUrl = driver.getCurrentUrl();
		System.out.println("userStatusUrl :" + userStatusUrl);

		assertTrue(editOption.isDisplayed(), "edit is not displayed");
		assertTrue(editOption.isEnabled(), "editOptions is not displayed");

		editOption.click();

		String editStatusUrl = driver.getCurrentUrl();
		System.out.println("editStatusUrl :" + editStatusUrl);

		assertNotEquals(editStatusUrl, userStatusUrl, "The Url is not changed");

	}

	public Menusetup ClickOnEdit(String DefaultName) {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : rows) {
			WebElement usernameColumn = row.findElement(By.xpath("./td[2]"));
			if (DefaultName.equals(usernameColumn.getText())) {
				WebElement button = row.findElement(By.xpath(".//img[@alt='table-edit']"));
				button.click();
				System.out.println(DefaultName + " Successfully Clicked");
				break;
			}
		}
		return this;
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
		UserStatus menusSetup = new UserStatus();
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
		UserStatus menusSetup1 = new UserStatus();

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
		UserStatus menusSetup2 = new UserStatus();

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

	public void enterDispalyNameInEditMenuSetup(String EnterDispalyNameRealedToDefaultName) {

		assertTrue(verifyEditMenusSetup.isDisplayed(), "verifyEditMenusSetup is not displayed");

		String beforeEditDisplayNameValue = displayNameEdit.getAttribute("value");
		System.out.println("beforeEditDisplayNameValue : " + beforeEditDisplayNameValue);

		displayNameEdit.clear();

		displayNameEdit.sendKeys(EnterDispalyNameRealedToDefaultName);

		String afterEditDisplayNameValue = displayNameEdit.getAttribute("value");
		System.out.println("afterEditDisplayNameValue : " + afterEditDisplayNameValue);

		assertTrue(updateButton.isDisplayed(), "updateButton is not displayed");
		updateButton.click();

		assertTrue(updateButton.isDisplayed(), "updateButton is not displayed");

		wait.until(ExpectedConditions.visibilityOf(updateSuccessfullyPopup));
		assertTrue(updateSuccessfullyPopup.isDisplayed(), "updateSuccessfullyPopup is not displayed");
		assertTrue(ContinueButtonEdit.isDisplayed(), "ContinueButtonEditis not displayed");
		ContinueButtonEdit.click();

		fetchSideMenus();

		assertTrue(sideMenusLists.contains(afterEditDisplayNameValue),
				"after edit dipalyed name is not changeand not contains in side menu");
	}

	/////////////////////////////////////////////////// Negative///////////////////////////////////////////////////////

	UserStatus userStatus = new UserStatus();
	SmsTemplate smsTemplate = new SmsTemplate();

	public void theUserwithoutEnteringMandatoryFieldandclickOnUpdate() {

		// navigateTomenuSetup();
		assertTrue(verifyMenusSetup.isDisplayed(), "navigateTomenuSetup is not displayed");

		editOption.click();
		assertTrue(verifyEditMenusSetup.isDisplayed(), "verifyEditMenusSetup");

		assertTrue(displayNameLabel.isDisplayed(), "displayNameLabel is not displayed");
		userStatus.checkthroughAsterisk(displayNameLabel, false);
		displayNameEdit.clear();
		assertTrue(updateButton.isDisplayed(), "updateButton is not displayed");
		updateButton.click();

		assertTrue(displayNameErrorMessage.isDisplayed(), "displayNameErrorMessage is not displayed");
		
		updateSuccessfullyPopup.isDisplayed();
		ContinueButtonEdit.click();

	}

	public void TheUserCanEditDisplayNameToEmojisAandUpadte() {

		//navigateTomenuSetup();
		assertTrue(verifyMenusSetup.isDisplayed(), "navigateTomenuSetup is not displayed");

		editOption.click();
		assertTrue(verifyEditMenusSetup.isDisplayed(), "verifyEditMenusSetup");

		assertTrue(displayNameLabel.isDisplayed(), "displayNameLabel is not displayed");
		userStatus.checkthroughAsterisk(displayNameLabel, false);
		displayNameEdit.clear();

		String enterEmojisString = "❤️❤️❤️❤️❤️";

		SendDataUtils.sendKeysWithJSExecutor(displayNameEdit, enterEmojisString);
		updateButton.click();

		assertTrue(somethingWentWrongErrorMesg.isDisplayed(),
				"TestFaile:Somethingwent wrong is not dispaleyd and it is Updated");
		

	}

	public void theUserCanEditDisplyenameCharcterToOnlySpecialCharacterandUpdate() throws InterruptedException {

		//navigateTomenuSetup();
		assertTrue(verifyMenusSetup.isDisplayed(), "navigateTomenuSetup is not displayed");

		editOption.click();
		assertTrue(verifyEditMenusSetup.isDisplayed(), "verifyEditMenusSetup");
		displayNameEdit.clear();

		String specialCharacter = "!@#$%^&*()";

		displayNameEdit.sendKeys(specialCharacter);

		assertTrue(updateButton.isDisplayed(), "updateButton is not displayed");
		updateButton.click();

		Thread.sleep(2000);
		System.out.println(updateSuccessfullyPopup.getText());

		Assert.assertFalse(ContinueButtonEdit.isDisplayed(), " updateSuccessfullyPopup is not displayed");

		ContinueButtonEdit.click();
	}

	public void usercanEnterCharactermorethanchracterLimits() throws InterruptedException {

		//navigateTomenuSetup();
		assertTrue(verifyMenusSetup.isDisplayed(), "navigateTomenuSetup is not displayed");

		editOption.click();
		assertTrue(verifyEditMenusSetup.isDisplayed(), "verifyEditMenusSetup");
		displayNameEdit.clear();
		displayNameEdit.sendKeys("A".repeat(300));

		assertTrue(updateButton.isDisplayed(), "updateButton is not displayed");
		updateButton.click();

		Thread.sleep(2000);
		System.out.println(updateSuccessfullyPopup.getText());

		Assert.assertFalse(ContinueButtonEdit.isDisplayed(), " updateSuccessfullyPopup is not displayed");

		ContinueButtonEdit.click();
	}

	public void tryToSearchByWithoutEnteringAnyData() {
		//navigateTomenuSetup();
		assertTrue(verifyMenusSetup.isDisplayed(), "navigateTomenuSetup is not displayed");

		assertTrue(searchTextfield.isDisplayed(), "searcTextfield not dispalyed");

		String currentUrl = driver.getCurrentUrl();

		assertTrue(searchButton.isDisplayed(), "searchButton is not displayed");
		searchButton.click();

		String afterSearchCurrentUrl = driver.getCurrentUrl();

		assertNotEquals(afterSearchCurrentUrl, currentUrl, "current url is not changed after click on search button");

		String currentSearchTextFieldValue = searchTextfield.getAttribute("value");
		assertTrue(currentSearchTextFieldValue == null || currentSearchTextFieldValue.isEmpty(),
				"Test failed: searchTextfield value is not empty after clicking search button.");

		clearallFilters.click();

	}

	String emoji = "😂😂";
	public void tryToSearchThroughEmojisInsearchTextfield() {

		//navigateTomenuSetup();
		assertTrue(verifyMenusSetup.isDisplayed(), "navigateTomenuSetup is not displayed");

		assertTrue(searchTextfield.isDisplayed(), "searcTextfield not dispalyed");
		
		SendDataUtils.sendKeysWithJSExecutor(searchTextfield, emoji);

		searchButton.click();

		assertTrue(noRecordsFound.isDisplayed(), "No Recors found is not dispalyed");

	}

	public void SearchThroughInvalidCharacterInSearchTextfield() {

		navigateTomenuSetup();
		assertTrue(verifyMenusSetup.isDisplayed(), "navigateTomenuSetup is not displayed");

		assertTrue(searchTextfield.isDisplayed(), "searcTextfield not dispalyed");
		smsTemplate.searchInvalidCreatedTemplateInSearchFieldUTILITY(searchTextfield, searchButton, noRecordsFound,
				clearallFilters);
	}

	public void searchThroughSpacesInSearchTextfield() {

		navigateTomenuSetup();
		smsTemplate.searchThroughSpacesInSearchTextfielUTILITY(searchTextfield, searchButton, noRecordsFound,
				clearallFilters);
	}

	SkipReason skipReason = new SkipReason();

	public void searchThroughEmojiInSearchField() {
		navigateTomenuSetup();
		skipReason.searchThroughEmojisInSearchTextfieldUTILITY(searchTextfield, emoji, searchButton, noRecordsFound);
		clearallFilters.click();

	}

}
