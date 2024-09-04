package com.advaita.UserStatus.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;

public class userStatus extends TestBase {

	private static final String Random = null;

	public userStatus() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	public static String defaultUrl;
	public static String userStatusUrl;
	public static String createdStatusInputvlaue; // input valie
	public static String firstStatusNameText;
	public static String inputFieldAttributeValue;
	public static String editStatusNameValue;
	

	@FindBy(xpath = "//ul[@class='sidemenu_ul']//li//a//span[@class='text menu-text']")
	public static List<WebElement> sideMenusListsElement;

	@FindBy(xpath = "(//ul[@class='sidemenu_ul']//li//a[@class='dropdown-item  menu-text'])[position() > 4]")
	public static List<WebElement> subSideMenusListsElements;
	//// ul[@class='sidemenu_ul']//li//a[@class='dropdown-item menu-text']
	// Prfile options
	@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']//span[text()='Admin Super Admin']")
	public static WebElement profileDropdown;

	@FindBy(xpath = "(//form[@action='/en/user_status/user_status_listing/'])[2]//li//a")
	List<WebElement> createdStatuses;

	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown'])[3]//span/..//img")
	public static WebElement subMenuDropdwonProfile;

	@FindBy(xpath = "(//a[@class='user_status_dropdown' and text()='Trainee Employee'])[3]")
	public static WebElement traineeEmployee;

	@FindBy(xpath = "//table//tbody//td[2]")
	List<WebElement> defaultNamesMenuSetup;

	@FindBy(xpath = "//a//span[text()='Menu Setup']")
	public static WebElement menuSetup;

	@FindBy(xpath = "//a[text()='Call Log Tab View']")
	public static WebElement callLogTabView;

	@FindBy(xpath = "//a//span[text()='Alchemy']")
	public static WebElement alchemyModul;

	@FindBy(xpath = "//a//span[text()='User Status']")
	public static WebElement userStatus;

	@FindBy(xpath = "(//h1[text()=' User Status '])[1]")
	public static WebElement verifyUserStatusPage;

	@FindBy(xpath = "//a[text()='+ Create']")
	public static WebElement Create;

	@FindBy(xpath = "//h1[contains(@class, 'page_heading') and not(contains(@class, 'mobile_page_heading'))]")
	public static WebElement verifyCreateUserStatus;

	@FindBy(xpath = "//label[text()='Status Name*']")
	public static WebElement statusNameLabel;

	@FindBy(xpath = "//input[@id='status_name']")
	public static WebElement statusNameInputfield;

	@FindBy(xpath = "//label[text()='Description']")
	public static WebElement descriptionLabel;

	@FindBy(xpath = "//label[text()='Description']/..//textarea")
	public static WebElement descriptionField;

	@FindBy(xpath = "//label[text()='Menus To Hide']")
	public static WebElement menusToHideLevel;

	@FindBy(xpath = "//select[@id='multiselect']")
	public static WebElement menusToHideDropdown;

	@FindBy(id = "multiselect_rightAll")
	public static WebElement multiselect_RightAll;

	@FindBy(id = "multiselect_rightSelected")
	public static WebElement multiselect_RightSelected;

	@FindBy(id = "multiselect_leftSelected")
	public static WebElement multiselect_LeftSelected;

	@FindBy(id = "multiselect_leftAll")
	public static WebElement multiSelecd_LeftAll;

	@FindBy(xpath = "//button[@id='submt_single']")
	public static WebElement createButton;

	@FindBy(xpath = "//span[@id='change_msg']")
	public static WebElement successFullyCreated_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public static WebElement continueButton_create;

	// Table
	@FindBy(xpath = "//tbody//td[1]")
	public static List<WebElement> statusNames;

	@FindBy(xpath = "//input[@id='text_search']")
	public static WebElement searchTextfield;

	@FindBy(xpath = "//tbody//tr[1]/td[1]")
	public static WebElement firstStatusName;

	@FindBy(xpath = "//div//button//img[@alt='filter_search']")
	public static WebElement searchbutton_Table;

	@FindBy(xpath = "//div//img/..//h6")
	public static WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "(//img[@alt='delete-icon '])[1]")
	public static WebElement deleteButton;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public static WebElement deletePopup_userStatus;

	@FindBy(xpath = "//button[text()='Delete']")
	public static WebElement deleteButton_delete;

	@FindBy(xpath = "//h3/..//span[text()='Deleted Successfully']")
	public static WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public static WebElement continueButton_DeleteSuccessullyPopup;

	@FindBy(xpath = "//tbody//tr//td")
	public static WebElement noEntriedFound;

	// Edit
	@FindBy(xpath = "//tbody/tr[position()=1]//td//div//img[@alt='table-edit']")
	public static WebElement editButton;

	@FindBy(xpath = "multiselect_to")
	public static List<WebElement> multiselectTomenuHide; // MultiseletTo menus hide

	// usersStatusHideModules
	@FindBy(xpath = "//a//span[text()='API Key Setup']")
	public static WebElement apiKeySetup;

	@FindBy(xpath = "//button[@id='submt_single']")
	public static WebElement updateButton;

	@FindBy(xpath = "//span[@id='change_msg']")
	public static WebElement userStatusUpdatedSuccessfullyPopup;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public static WebElement ContineButton_update;

	public void navigateToMenuSetup() throws Throwable {

		assertTrue(menuSetup.isDisplayed(), "menuSetup is not displayed");
		// menuSetup.click();
		jsClick(driver, menuSetup);

		List<String> defaultNameMenuSetupLists = new ArrayList<String>();
		for (WebElement defaultNames : defaultNamesMenuSetup) {
			defaultNameMenuSetupLists.add(defaultNames.getText());
			System.out.println("defaultNameMenuSetupLists :" + defaultNames.getText());

		}

	}

	public void callLogatTabViewClick() // use this metod only for alchemy module
	{
		boolean isCallLogTabViewDisplayed = callLogTabView.isDisplayed();

		// Assert that "Call Log Tab View" is displayed
		if (isCallLogTabViewDisplayed) {
			System.out.println("Call Log Tab View is displayed, no need to click on Alchemy.");
			callLogTabView.click();
		} else {
			System.out.println("Call Log Tab View is not displayed, clicking on Alchemy.");
			// If not displayed, click on Alchemy
		}
		alchemyModul.click();
		callLogTabView.click(); // as per required we can change "element"

	}

	public void NavigateToUserStatus() throws Throwable {

		defaultUrl = driver.getCurrentUrl();
		System.out.println("defaultUrlUrl : " + defaultUrl);

		assertTrue(userStatus.isDisplayed(), "userStatusis not displayed");
//		wait.until(ExpectedConditions.visibilityOf(userStatus));		
//		userStatus.click();
		jsClick(driver, userStatus);

		userStatusUrl = driver.getCurrentUrl();
		System.out.println("userStatusUrl: " + userStatusUrl);

		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		assertNotEquals(defaultUrl, userStatusUrl + "Url is not changed");
	}

	public void createUserStatus() {
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		String crateUserStatusURL = driver.getCurrentUrl();
		System.out.println("crateUserStatusURL :" + crateUserStatusURL);

		assertNotEquals(userStatusUrl, crateUserStatusURL + " url is not changed");

		assertTrue(verifyCreateUserStatus.isDisplayed(), "verifyCreateUserStatus is not displayed");

	}

	// InputField Validations
	// isDisplayed
	public void inputFieldIsDisplayed(WebElement element) {
		// Element is displayed
		assertTrue(element.isDisplayed(), "statusNameInputfield is not displayed");
	}

	// Element IsEnabled
	public void inputFieldIsEnable(WebElement element) {
		assertTrue(element.isEnabled(), "input field is not enabled");
		statusNameInputfield.click();
	}

	// Check if the element is empty
	public void inputFieldIsEmpty(WebElement element) {
		inputFieldAttributeValue = element.getAttribute("value");
		assertTrue(inputFieldAttributeValue.isEmpty(), "inputFieldAttributeValue is not empty");
		System.out.println("inputFieldAttributeValue" + inputFieldAttributeValue);

	}

	// Check for placeholder text
	public void placeholderText(WebElement element) {
		String placeholder = element.getAttribute("placeholder");
		assertNotNull(placeholder, "Placeholder attribute is not set.");
//		assertFalse(placeholder.isEmpty(), "Placeholder text is empty.");
		System.out.println("Placeholder text is: " + placeholder);
	}

	// input field " Required Filed" or isMandatory
	public void inputfieldIsRequired(WebElement element) {
		boolean inputfieldisRequired = element.getAttribute("required") != null;
		System.out.println("inputfieldisRequired :" + inputfieldisRequired);
	}

	// Alternatively, you could also check for an asterisk (*) in the label or other
	// visual cues
	public void checkthroughAsterisk(WebElement element, boolean isMandatoryCheck) {

		boolean hasAsterisk = element.getText().contains("*");

		if (isMandatoryCheck) {
			assertTrue(hasAsterisk, "The 'status_name' field label does not indicate it is mandatory.");
			System.out.println("The 'status_name' field is mandatory.");
		} else {
			System.out.println("Field is not mandatory.");
		}
	}

	// Status Name
	public void statusNameInputField(String chosenStatus) {

		inputFieldIsDisplayed(statusNameInputfield);
		inputFieldIsEnable(statusNameInputfield);
		inputFieldIsEmpty(statusNameInputfield);
		placeholderText(statusNameInputfield);
		inputfieldIsRequired(statusNameInputfield);
		checkthroughAsterisk(statusNameLabel, true);

		String[] statusNames = { "Admin ", "Meeting ", "Trainee Employee", "Customer", };
//		// Generate a random index to select a status
//		Random random = new Random();
//		int randomIndex = random.nextInt(statusNames.length);
//		String randomStatus = statusNames[randomIndex];
//		System.out.println("Random statusName:" + randomStatus);
//
//		statusNameInputfield.sendKeys(randomStatus);

		//String chosenStatus = "Trainee Employee";
		System.out.println("Chosen statusName: " + chosenStatus);
		statusNameInputfield.sendKeys(chosenStatus);

		createdStatusInputvlaue = statusNameInputfield.getAttribute("value"); // Created status Input Vaue
		System.out.println("createdInputvlaueEmploee :" + createdStatusInputvlaue);

	}

	// Descriptions Validations
	public void descriptionField() {

		inputFieldIsDisplayed(descriptionField);
		inputFieldIsEnable(descriptionField);
		inputFieldIsEmpty(descriptionField);
		placeholderText(descriptionField);
		inputfieldIsRequired(descriptionField);
		checkthroughAsterisk(descriptionLabel, false);

		descriptionField.sendKeys(fake.lastName1());

	}

	public void menusToHideDropdwon() throws Throwable {
		checkthroughAsterisk(menusToHideLevel, false);

		assertTrue(menusToHideDropdown.isDisplayed(), "menus To Hide multi select dropdwon is not displayed");

		assertTrue(menusToHideDropdown.isEnabled(), " menus To Hide multi select dropdwon is not Enabled");

		List<String> multipleselectOptionsList = new ArrayList<String>();

		// Verify that it is a multi-select dropdown
		Select multiSelect = new Select(menusToHideDropdown);
		assertTrue(multiSelect.isMultiple(), " dropdodown shoul not allow multiple selections");

		for (WebElement multiselectsLists : multiSelect.getOptions()) {
			multipleselectOptionsList.add(multiselectsLists.getText());
			System.out.println("multipleselectOptionsList :" + multiselectsLists.getText());
		}

		multiselect_RightAll.click();
		Thread.sleep(1000);
		multiSelecd_LeftAll.click();

		// Select by visibleText
		multiSelect.selectByVisibleText("API Key Setup");
		multiSelect.selectByVisibleText("Audit the Auditor");
		multiSelect.selectByVisibleText("Bias");

		// DESelect by visible Text
		multiSelect.deselectByVisibleText("API Key Setup");
		multiSelect.deselectByVisibleText("Audit the Auditor");
		multiSelect.deselectByVisibleText("Bias");

		// verify the user is Hide one user
		multiSelect.selectByVisibleText("API Key Setup");
		assertTrue(multiselect_RightSelected.isDisplayed(), "multiselect_RightSelectedis not displayed");
		multiselect_RightSelected.click();

	}

	public void CreateButtonclick() {
		assertTrue(createButton.isDisplayed(), "createButtonis not displayed");
		// createButton.click();
		jsClick(driver, createButton);

		wait.until(ExpectedConditions.visibilityOf(successFullyCreated_popuop));
		assertTrue(successFullyCreated_popuop.isDisplayed(), "successFullyCreated_popuopis not displayed");

		wait.until(ExpectedConditions.visibilityOf(continueButton_create));
		assertTrue(continueButton_create.isDisplayed(), "continueButton_createis not displaed");
		continueButton_create.click();
	}

	public void verifyCreatedStatus() throws Throwable {
		List<String> statusNameLists = new ArrayList<String>();
		for (WebElement statusNameList : statusNames) {
			statusNameLists.add(statusNameList.getText());
			System.out.println("statusNameLists :" + statusNameList.getText());
		}

		assertTrue(statusNameLists.contains("Trainee Employee"), " statusNames is not contains");

		assertTrue(profileDropdown.isDisplayed(), "profileDropdownis not displayed");
		profileDropdown.click();

	}

//	public void CreatedStatusList() throws Throwable {
//	
//		subMenuDropdwonProfile.click();
//		Thread.sleep(1000);
//		List<String> createdStatusList = new ArrayList<String>();
//		for (WebElement statusTexts : createdStatuses) {
//			createdStatusList.add(statusTexts.getText());
//			System.out.println("createdStatusList :" + statusTexts.getText());
//		}
//		
//		assertTrue(createdStatusList.contains("Trainee Employee"), "Trainee Employee is not contains");
//		List<String> createdStatusList = new ArrayList<>();
//
//		// Iterate over the list of created statuses (WebElement)
//		for (WebElement statusText : createdStatuses) {
//		    // Add each status text to the list
//		    String status = statusText.getText();
//		    createdStatusList.add(status);
//		    System.out.println("createdStatusList: " + status);
//
//		    // Check if the status is "Trainee Employee"
//		    if (status.equals("Trainee Employee")) {
//		        // Click on the "Trainee Employee" WebElement
//		        statusText.click();
//		        System.out.println("Clicked on 'Trainee Employee'");
//		        break; // Exit the loop after clicking on "Trainee Employee"
//		    }
//		}  

	public void selectStatus(WebDriver driver, String desiredStatus) // as per hide menus select " status"
	{
		subMenuDropdwonProfile.click();
		

		List<String> createdStatusList = new ArrayList<>();

		// Iterate over all created statuses (WebElements)
		for (WebElement statusText : createdStatuses) {
			String status = statusText.getText();
			createdStatusList.add(status);
			System.out.println("createdStatusList: " + status);

			// Check for exact or partial match based on desiredStatus format
			if (desiredStatus.equalsIgnoreCase(status) || desiredStatus.contains(status)) {
				statusText.click();
				System.out.println("Clicked on '" + status + "'");
				break; // Exit the loop after clicking on the matching status
			}
		}
	}

	// "Hide" Single Menus" for "SideModules"

	public void selectStatusHideSingleMenus() throws Throwable // as per hide menus select " status" from sub menu
	// dopdown and pass
	{

		selectStatus(driver, "Trainee Employee"); // change 'status" parametr
		verifyMenusAreHideSideMenusModule("API Key Setup");
	}

	// "Hide" Single Menus" for "SideModules"

	public void verifyMenusAreHideSideMenusModule(String menuName) throws Throwable {
		
		List<String> sideMenuList = new ArrayList<String>();

		for (WebElement menusLists : sideMenusListsElement) {
			Thread.sleep(1000);
			sideMenuList.add(menusLists.getText());
			Thread.sleep(1000);
			System.out.println("sideMenuList:" + menusLists.getText());
		}

		if (!sideMenuList.contains(menuName)) {
			// Pass the test if "API Key Setup" is not found
			System.out.println("The MENUS is hide from SelectedStatus");
		} else if (sideMenuList.contains(menuName)) {
			// Fail the test if "API Key Setup" is found
			assertTrue(false, "The MENUS is not hiding for CreatedStatus");
		}

	}

	// Method to verify that "Hide" Multiple Menus for "Side SubMenus Modules"
	public void selectStatusHideMultipleMenus() throws Throwable {
		selectStatus(driver, "Meeting"); // change 'desired status" parametr
		driver.findElement(By.xpath("//a[@id='menulist2']//span//span[text()='Alchemy']")).click();
		Thread.sleep(2000);
		verifyMenusAreHideSideMenusModule("Auto Allocation"); // pass "multiple menus" name in parameters

		driver.navigate().refresh();
	}

	// Method to verify that "Hide" Multiple Menus for "Side SubMenus Modules
	public void verifyMenusAreHideSubSideMenusModules(String... menuNames) throws Throwable {
		List<String> subSideMenuList = new ArrayList<>();

		driver.findElement(By.xpath("//a[@id='menulist2']//span//span[text()='Alchemy']")).click();

		// Collect all side menu texts
		for (WebElement menusLists : subSideMenusListsElements) {
			Thread.sleep(1000);
			subSideMenuList.add(menusLists.getText());
			Thread.sleep(1000);
			System.out.println("SubsideMenuList: " + menusLists.getText());
		}

		// Iterate over each menu name passed as a parameter
		for (String menuName : menuNames) {
			if (!subSideMenuList.contains(menuName)) {
				// Pass the test if the menuName is not found
				System.out.println("The menu '" + menuName + "' is hidden for the selected status");
			} else {
				// Fail the test if the menuName is found
				assertTrue(false, "The menu '" + menuName + "' is not hidden for the selected status");

			}
		}
	}

	// Table
	// SearchStatusName
	public void searchStatus() {

		assertTrue(firstStatusName.isDisplayed(), "firstStatusName is not displayed");

		firstStatusNameText = firstStatusName.getText();
		System.out.println("firstStatusNameText :" + firstStatusNameText);

		inputFieldIsDisplayed(searchTextfield);
		searchTextfield.isEnabled();
		inputFieldIsEmpty(searchTextfield);
		placeholderText(searchTextfield);

		searchTextfield.sendKeys(firstStatusNameText);

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		searchbutton_Table.click();

		assertTrue(firstStatusName.isDisplayed(), "firstStatusName is not displeyd ");

	}

	public void clearallFiltes() {

		String beforeSearchFieldVlaue = searchTextfield.getAttribute("value");
		System.out.println("beforeSearchFieldVlaue:" + beforeSearchFieldVlaue);

//		String afterSearchFieldVlaue=searchTextfield.getAttribute("value");
//		System.out.println("afterplaceholderVlaue:"+ afterSearchFieldVlaue);

		assertTrue(clearAllFiltersButton_Table.isEnabled(), "clearAllFiltersButton_Table is not enabled");
		assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not displayed");

		clearAllFiltersButton_Table.click();

		String afterSearchFieldVlaue = searchTextfield.getAttribute("value");
		System.out.println("afterplaceholderVlaue:" + afterSearchFieldVlaue);

		assertNotEquals(beforeSearchFieldVlaue, afterSearchFieldVlaue);

	}

	public void DeleteStatus() {

		assertTrue(deleteButton.isEnabled(), "deleteButtonis not enabled");
		assertTrue(deleteButton.isDisplayed(), "deleteButton is not displayed");
		deleteButton.click();

		assertTrue(deletePopup_userStatus.isDisplayed(), "deletePopup_userStatus is not displayed");
		assertTrue(deleteButton_delete.isDisplayed(), "deleteButton_delete is not diplayed");
		deleteButton_delete.click();

		wait.until(ExpectedConditions.visibilityOf(deleted_SuceessfullyPopup));
		assertTrue(deleted_SuceessfullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is not displayed");
		assertTrue(continueButton_DeleteSuccessullyPopup.isDisplayed(),
				"continueButton_DeleteSuccessullyPopup is not displayed");
		continueButton_DeleteSuccessullyPopup.click();

		assertTrue(searchTextfield.isEnabled(), "Search textfield is not enabled");
		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		inputFieldIsEmpty(searchTextfield);
		searchTextfield.sendKeys(firstStatusNameText);

		searchbutton_Table.click();

		// assertTrue(noEntriedFound.isDisplayed(), "noEntriedFound isn not displayed");
		if (noEntriedFound.isDisplayed()) {
			assertTrue(noEntriedFound.isDisplayed(), "The status is deleted as 'No entries found' is displayed.");
		} else {

			assertTrue(false, "The status is not deleted as 'No entries found' is not displayed.");
		}
		clearAllFiltersButton_Table.click();

	}

	// Edit
	public void EditStatus() {

		assertTrue(editButton.isDisplayed(), "editButton is not displayed");
		editButton.isEnabled();

		editButton.click();

		String EditStatusUrl = driver.getCurrentUrl();
		System.out.println("EditStatusUrl :" + EditStatusUrl);
		assertNotEquals(EditStatusUrl, userStatusUrl);

		assertTrue(verifyCreateUserStatus.isDisplayed(), "verifyCreateUserStatus is not displayed");

		assertTrue(statusNameInputfield.isDisplayed(), "statusNameInputfield is not displayed");

		String statusNameValue = statusNameInputfield.getAttribute("value");
		assertTrue(!statusNameValue.isEmpty(), "status value is displayed");

		statusNameInputfield.clear();

		String chosenEditStatus = "TeamLead";
		System.out.println("Chosen statusName: " + chosenEditStatus);

		statusNameInputfield.sendKeys(chosenEditStatus);

		 editStatusNameValue = statusNameInputfield.getAttribute("value");
		// assertEquals(editStatusNameValue,firstStatusNameText );

	}

	public void EditDescriptnField() {
		assertTrue(descriptionField.isEnabled(), "descriptionField is not enabled");
		assertTrue(descriptionField.isDisplayed(), "descriptionFieldis not displayed");

		String EditDescriptionFieldValue = descriptionField.getAttribute("value");
		if (!EditDescriptionFieldValue.isEmpty()) {
			descriptionField.clear();
		} else {
			System.out.println("the Description Textfield is Empty");
		}
		descriptionField.sendKeys(fake.lastName1());
	}

	public void multiseletToMenuHide() throws Throwable {

		multiselect_RightAll.click();
		Thread.sleep(1000);
		multiSelecd_LeftAll.click();

		Select multiSelect = new Select(menusToHideDropdown);
		assertTrue(multiSelect.isMultiple(), " dropdodown shoul not allow multiple selections");

		multiSelect.selectByVisibleText("Audit the Auditor");
		multiSelect.selectByVisibleText("Bias");

		multiSelect.deselectByVisibleText("Audit the Auditor");
		multiSelect.deselectByValue("Bias");

		multiSelect.selectByValue("Email Template");
		multiselect_RightSelected.click();
		
		assertTrue(updateButton.isEnabled(), "updateButton is not enabled");
		assertTrue(updateButton.isDisplayed(), "updateButtonis not displayed");
		
		jsClick(driver, updateButton);
		
		wait.until(ExpectedConditions.visibilityOf(userStatusUpdatedSuccessfullyPopup));
		assertTrue(userStatusUpdatedSuccessfullyPopup.isDisplayed(), "userStatusUpdatedSuccessfullyPopup is not displayed");
		
		assertTrue(ContineButton_update.isDisplayed(), "ContineButton_update is not displayed");
		ContineButton_update.click();
		
		assertEquals(editStatusNameValue,firstStatusName.getText());
		
	}
	
	public void navigateToaAdmin() 
	{
		
	}
	
	

}
