package com.advaita.UserStatus.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.SendDataUtils;
import com.advaita.alchemyPageObject.SmsTemplate;

import Advaita_TDD.Advaita_TDD.FakeData;

public class userStatus extends TestBase {

	private static final String Random = null;

	public userStatus() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	String statusName1 = "Admin";
	String statusName2 = "Meeting";
	String statusName3 = " Trainee Employee";
	String statusName4 = "Customer";

	public static String defaultUrl;
	public static String userStatusUrl;
	public static String createdStatusInputvlaue; // input valie
	public static String firstStatusNameText;
	public static String inputFieldAttributeValue;
	public static String editStatusNameValue;

	@FindBy(xpath = "//img[@class='img-fluid profile_img']/..//span")
	public WebElement userProfileName;

	@FindBy(xpath = "//ul[@class='sidemenu_ul']//li//a//span[@class='text menu-text']")
	public List<WebElement> sideMenusListsElement;

	@FindBy(xpath = "(//ul[@class='sidemenu_ul']//li//a[@class='dropdown-item  menu-text'])[position() > 4]")
	public List<WebElement> subSideMenusListsElements;
	//// ul[@class='sidemenu_ul']//li//a[@class='dropdown-item menu-text']
	// Prfile options

	@FindBy(xpath = "//span[contains(@class, 'profile_name')]")
	public WebElement profileDropdown;

	@FindBy(linkText = "My Profile")
	public WebElement myProfileOption;

	@FindBy(linkText = "Change Password")
	public WebElement changePasswordOption;

	@FindBy(linkText = "Logout")
	public WebElement logout;

	@FindBy(xpath = "(//form[@action='/en/user_status/user_status_listing/'])[2]//li//a")
	List<WebElement> createdStatuses;

	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown'])[3]//span/..//img")
	public WebElement subMenuDropdwonProfile;

	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown'])[3]//span/..//img /../..//ul//li")
	List<WebElement> createdStatusListStatusDrodown;

	@FindBy(xpath = "(//a[@class='user_status_dropdown' and text()='Trainee Employee'])[3]")
	public WebElement traineeEmployee;

	@FindBy(xpath = "//table//tbody//td[2]")
	List<WebElement> defaultNamesMenuSetup;

	@FindBy(xpath = "//a//span[text()='Menu Setup']")
	public WebElement menuSetup;

	@FindBy(xpath = "//a[text()='Call Log Tab View']")
	public WebElement callLogTabView;

	@FindBy(xpath = "//a//span[text()='Alchemy']")
	public WebElement alchemyModul;

	@FindBy(xpath = "//a//span[text()='User Settings ']")
	public WebElement userStatus;

	@FindBy(xpath = "(//h1[text()=' User Status '])[1]")
	public WebElement verifyUserStatusPage;

	@FindBy(xpath = "//a[text()='+ Create']")
	public WebElement Create;

	@FindBy(xpath = "//h1[contains(@class, 'page_heading') and not(contains(@class, 'mobile_page_heading'))]")
	public WebElement verifyCreateUserStatus;

	@FindBy(xpath = "//label[text()='Status Name*']")
	public WebElement statusNameLabel;

	@FindBy(xpath = "//input[@id='status_name']")
	public WebElement statusNameInputfield;

	@FindBy(xpath = "//label[text()='Description']")
	public WebElement descriptionLabel;

	@FindBy(xpath = "//label[text()='Description']/..//textarea")
	public WebElement descriptionField;

	@FindBy(xpath = "//label[text()='Menus To Hide']")
	public WebElement menusToHideLevel;

	@FindBy(xpath = "//select[@id='multiselect']")
	public WebElement menusToHideDropdown;

	@FindBy(id = "multiselect_rightAll")
	public WebElement multiselect_RightAll;

	@FindBy(id = "multiselect_rightSelected")
	public WebElement multiselect_RightSelected;

	@FindBy(id = "multiselect_leftSelected")
	public WebElement multiselect_LeftSelected;

	@FindBy(id = "multiselect_leftAll")
	public WebElement multiSelecd_LeftAll;

	@FindBy(xpath = "//h3[@class='process']")
	public WebElement activeStatusLabel;

	@FindBy(xpath = "//h3[text()='Active Status']/..//label")
	public WebElement activeStatusToggleButton;

	@FindBy(xpath = "//label[text()='Is Default']")
	public WebElement isDefaultLabeel;

	@FindBy(xpath = "//label[text()='Is Default']/..//input[@id='is_default']")
	public WebElement isDefaultCheckBox;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	public WebElement searchTextfieldMenusToHide;

	@FindBy(xpath = "//button[@id='submt_single']")
	public WebElement createButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement CancelButton;

	@FindBy(xpath = "//span[@id='change_msg']")
	public WebElement successFullyCreated_popuop;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButton_create;

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	public WebElement firstCreatedUserStatus;

	@FindBy(xpath = "//tbody//tr//td[2]")
	List<WebElement> activeStatusLists;

	@FindBy(xpath = "//tbody//tr//td[3]")
	List<WebElement> isDefaultLists;

	// Table
	@FindBy(xpath = "//tbody//td[1]")
	public List<WebElement> statusNames;

	@FindBy(xpath = "//input[@id='text_search']")
	public WebElement searchTextfield;

	@FindBy(xpath = "//tbody//tr[1]/td[1]")
	public WebElement firstStatusName;

	@FindBy(xpath = "//div//button//img[@alt='filter_search']")
	public WebElement searchbutton_Table;

	@FindBy(xpath = "//div//img/..//h6")
	public WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "(//img[@alt='delete-icon '])[1]")
	public WebElement deleteButton;

	@FindBy(xpath = "(//img[@alt='delete-icon '])")
	List<WebElement> deleteOptions;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public WebElement deletePopup_userStatus;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement deleteButton_delete;

	@FindBy(xpath = "//h3/..//span[text()='Deleted Successfully']")
	public WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public WebElement continueButton_DeleteSuccessullyPopup;

	@FindBy(xpath = "//tbody//tr//td")
	public WebElement noEntriedFound;

	// Edit
	@FindBy(xpath = "//tbody/tr[position()=1]//td//div//img[@alt='table-edit']")
	public WebElement editButton;

	@FindBy(xpath = "multiselect_to")
	public List<WebElement> multiselectTomenuHide; // MultiseletTo menus hide

	// usersStatusHideModules
	@FindBy(xpath = "//a//span[text()='API Key Setup']")
	public WebElement apiKeySetup;

	@FindBy(xpath = "//button[@id='submt_single']")
	public WebElement updateButton;

	@FindBy(xpath = "//span[@id='change_msg']")
	public WebElement userStatusUpdatedSuccessfullyPopup;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement ContineButton_update;

	@FindBy(xpath = "//td[normalize-space(.)='No Records Found']")
	public WebElement noRecordsFound;

	// My Profile Elements
	@FindBy(xpath = "//h2[text()='Account Settings']")
	public WebElement verifyAccountSettingsPage;

	@FindBy(xpath = "//label[text()='First Name*']")
	public WebElement firstNameLabel;

	@FindBy(id = "first_name")
	public WebElement firstNameTextfield;

	@FindBy(id = "last_name")
	public WebElement lastNameTextfield;

	@FindBy(xpath = "//label[text()='Last Name']")
	public WebElement lastNameLabel;

	@FindBy(id = "email")
	public WebElement emailTextfield;

	@FindBy(xpath = "//label[text()='Email*']")
	public WebElement emailtextfieldLabel;

	@FindBy(xpath = "//label[text()='Mobile No*']")
	public WebElement MobileLabel;

	@FindBy(id = "mobile")
	public WebElement mobileTextfield;

	@FindBy(linkText = "Update")
	public WebElement updateOptionAccountSettings;

	@FindBy(linkText = "Cancel")
	public WebElement cancelOptionAccountSettings;

	@FindBy(xpath = "//label[@class='edit_profile']/../..//h1")
	public WebElement verifyuserNameInAccontSettings;

	@FindBy(xpath = "//label[@class='edit_profile']")
	public WebElement editProfileAccountSettings;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButton_MyProfile;

	@FindBy(xpath = "//label[@id='first_name-error']")
	public WebElement firstNameErrorMesg;

	@FindBy(xpath = "//label[@id='email-error']")
	public WebElement emailTextFieldErrorMesg;

	@FindBy(xpath = "//label[@id='mobile-error']")
	public WebElement mobileNumberTextFieldErrorMesg;

	// Change Password
	@FindBy(xpath = "//h2[text()='Change Password']")
	public WebElement verifychangePasswordPage;

	@FindBy(xpath = "//label[text()='Old Password']")
	public WebElement oldPasswordLabel;

	@FindBy(id = "oldpassword")
	public WebElement oldPasswordTextfield;

	@FindBy(xpath = "(//img[@class='img-fluid eye_icon'])[1]")
	public WebElement oldPassEyeIcon;

	@FindBy(xpath = "//label[text()='New Password']")
	public WebElement newPasswordLabel;

	@FindBy(id = "newpassword1")
	public WebElement newPasswordTextfield;

	@FindBy(xpath = "(//img[@class='img-fluid eye_icon'])[2]")
	public WebElement newPassEyeIcon;

	@FindBy(xpath = "//label[text()='Confirm New Password']")
	public WebElement conformPAsswordLabel;

	@FindBy(id = "newpassword2")
	public WebElement conformPasswordTextfield;

	@FindBy(xpath = "(//img[@class='img-fluid eye_icon'])[3]")
	public WebElement conformPassEyeIcon;

	@FindBy(xpath = "//button[text()='Change My Password']")
	public WebElement changeMyPasswordButton;

	@FindBy(xpath = "//ul[@class='errorlist']")
	public WebElement oldPasswordErrorMessage;

	@FindBy(id = "oldpassword-error")
	public WebElement oldPassIsRequiredErrorMesg;

	@FindBy(id = "newpassword1-error")
	public WebElement newPasswordFieldErrorMessagElement;

	@FindBy(id = "newpassword2-error")
	public WebElement conformPassErrorMessage;

	/////////// Negative///////////////////////

	@FindBy(id = "status_name-error")
	public WebElement statusNameErrorMessage;

	@FindBy(id = "is_default-error")
	public WebElement isDefaultErrorMessagElement;

	@FindBy(xpath = "//span[@id='change_error_msg']")
	public WebElement somethingWentWrongErrorMesg;

	public void navigateToMenuSetup() throws Throwable {

		assertTrue(menuSetup.isDisplayed(), "menuSetup is not displayed");
		// menuSetup.click();
		jsClick(menuSetup);

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

	public void NavigateToUserStatus() {

		defaultUrl = driver.getCurrentUrl();
		System.out.println("defaultUrlUrl : " + defaultUrl);

		assertTrue(userStatus.isDisplayed(), "userStatusis not displayed");
//		wait.until(ExpectedConditions.visibilityOf(userStatus));		
//		userStatus.click();
		jsClick(userStatus);

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

	// InputField Validations isDisplayed
	public void inputFieldIsDisplayed(WebElement element) {
		// Element is displayed
		assertTrue(element.isDisplayed(), "Inputfield is not displayed");
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
	public void checkthroughAsterisk(WebElement elementLabel, boolean isMandatoryCheck) {

		boolean hasAsterisk = elementLabel.getText().contains("*");

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

//		// Generate a random index to select a status
//		Random random = new Random();
//		int randomIndex = random.nextInt(statusNames.length);
//		String randomStatus = statusNames[randomIndex];
//		System.out.println("Random statusName:" + randomStatus);
//
//		statusNameInputfield.sendKeys(randomStatus);

		// String chosenStatus = "Trainee Employee";
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

	public void selectMenusToHideDropdwon() throws Throwable {
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
		jsClick(createButton);

		wait.until(ExpectedConditions.visibilityOf(successFullyCreated_popuop));
		assertTrue(successFullyCreated_popuop.isDisplayed(), "successFullyCreated_popuopis not displayed");

		wait.until(ExpectedConditions.visibilityOf(continueButton_create));
		assertTrue(continueButton_create.isDisplayed(), "continueButton_createis not displaed");
		continueButton_create.click();
	}

	List<String> statusNameLists = new ArrayList<String>();

	public void verifyCreatedStatus() throws Throwable {

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
				// statusText.click();
				jsClick(driver, statusText);
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
		assertTrue(userStatusUpdatedSuccessfullyPopup.isDisplayed(),
				"userStatusUpdatedSuccessfullyPopup is not displayed");

		assertTrue(ContineButton_update.isDisplayed(), "ContineButton_update is not displayed");
		ContineButton_update.click();

		assertEquals(editStatusNameValue, firstStatusName.getText());

	}

	public void navigateToaAdmin() throws Throwable {
		createUserStatus();
		statusNameInputField("Admin");
		// descriptionField();
		String[] descriptionfield = { "Admin status grants full access to all menus." };

		// String chosenStatus = "Trainee Employee";
		System.out.println("descriptionfield: " + descriptionfield);
		descriptionField.sendKeys(descriptionfield);

		multiselect_RightAll.click();
		Thread.sleep(1000);
		multiSelecd_LeftAll.click();

		assertTrue(createButton.isDisplayed(), "createButton is not displayed");
		jsClick(driver, createButton);

		wait.until(ExpectedConditions.visibilityOf(successFullyCreated_popuop));
		assertTrue(successFullyCreated_popuop.isDisplayed(), "successFullyCreated_popuop is not displayed");

		assertTrue(continueButton_create.isDisplayed(), "continueButton_create is not disaplyed");
		continueButton_create.click();

		profileDropdown.click();
		subMenuDropdwonProfile.click();

		Thread.sleep(2000);
		selectStatus(driver, "Admin");

	}

	public void activeStatusTogglebutton() {

		checkthroughAsterisk(activeStatusToggleButton, false);
		assertTrue(activeStatusToggleButton.isDisplayed(), "activeStatusToggleButton is not displayed");
		assertTrue(activeStatusToggleButton.isEnabled(), "activeStatusToggleButtonis not enabled");

	}

	public void searchmenusInSearchtextfield() {
		Create.click();
		assertTrue(verifyCreateUserStatus.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(searchTextfieldMenusToHide.isDisplayed(), "searchTextfieldMenusToHideis not displayed");
		assertTrue(searchTextfieldMenusToHide.isEnabled(), "searchTextfieldMenusToHide is not enabled");

		List<String> menuItems = Arrays.asList("Data Setup", "Workflow Design", "User Setup", "User Management",
				"Role & Permissions", "Alchemy", "User Mapping", "Bias", "Manual Allocation", "Auto Allocation",
				"Re Allocation", "Sampling Plan & Generation", "Escalation Metrics", "Add Evaluation",
				"View/Modify Evaluation", "Evaluation Tab View", "Open Escalated Form", "Edit Escalated Form",
				"Audit the Auditor", "Skip Reason", "Email Template", "SMS Template", "Whatsapp Template",
				"Sample Status", "Transmon Report", "Normal Report", "Rejected Audit Form", "User Status",
				"API Key Setup", "Menu Setup", "Masters", "Notification", "Transaction Report", "System Names",
				"Site Settings");

		// Choose a random name from the list
		Random random = new Random();
		String randomName = menuItems.get(random.nextInt(menuItems.size()));

		// Enter the random name into the search field
		searchTextfieldMenusToHide.clear(); // Clear the field before entering new text
		searchTextfieldMenusToHide.sendKeys(randomName);

		assertTrue(CancelButton.isDisplayed(), "CancelButton is  not displayed");
		assertTrue(CancelButton.isEnabled(), "CancelButton is not enabled");
		jsClick(driver, CancelButton);
		// CancelButton.click();

	}

//////////////////////////////////////UserStatus_Negative  ////////////////////////////////////////////////////////////////////////

//	public void withoutSelectingAnyFieldAndCreteUtility(WebElement smsCreateButton,
//			WebElement fieldRequiredErrorMEssage) {
//
//		String Combinetext = processLabel.getText() + subProcessLabel.getText() + subSubProcessLabel.getText()
//				+ stagesLabel.getText() + templateNameLabel.getText() + messagLabel.getText();
//		System.out.println("Combinetext" + Combinetext);
//
//		String asterisk = "*";
//		assertTrue(Combinetext.contains(asterisk), "asterisk is not contains in Combinetext text");
//
//		smsCreateButton.click();
//
//		boolean isEitherDisplayed = fieldRequiredErrorMEssage.isDisplayed();
//		assertTrue(isEitherDisplayed,
//				"'thisFieldisRequiredErrorMessage' is not displayed for Mandatory fields, test failed.");
//
//	}

	public boolean withoutSelectingAnyFieldAndCreateUserstatus() {

		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();
		assertTrue(verifyCreateUserStatus.isDisplayed(), "verifyCreateUserStatus is not dispalyed");
		checkthroughAsterisk(statusNameLabel, true);
		String statusNameFieldValue = statusNameInputfield.getAttribute("value");

		checkthroughAsterisk(descriptionLabel, false);
		assertTrue(descriptionField.isDisplayed(), "descriptionFieldis not dispalyed");
		String descriptionNameFieldValue = statusNameInputfield.getAttribute("value");

		// createButton.click();
		jsClick(driver, createButton);
		// Check if the value is null or empty
		return statusNameFieldValue == null || statusNameFieldValue.isEmpty() && descriptionNameFieldValue == null
				&& statusNameErrorMessage.isDisplayed();

	}

	SmsTemplate smsTemplate = new SmsTemplate();

	public void createUserStatusThroughSpecialCharacters() {

		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(fake.lastName1());
		assertTrue(menusToHideDropdown.isDisplayed(), "menusToHideDropdown is not dispalyed");

		smsTemplate.createTemplateThroughSpecialCharacterUTILITY(statusNameLabel, statusNameInputfield, createButton,
				successFullyCreated_popuop, somethingWentWrongErrorMesg);
	}
	
	public void createUserStatusThrougByenteringNonEnglishCahracterInStatusNameTextfield() {

		String nonEnglishCahracter="கூட்டம் "; //(Meeting)
		
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		checkthroughAsterisk(statusNameLabel, true);
		statusNameInputfield.sendKeys(nonEnglishCahracter);
		assertTrue(menusToHideDropdown.isDisplayed(), "menusToHideDropdown is not dispalyed");

		smsTemplate.createTemplateThroughSpecialCharacterUTILITY(statusNameLabel, statusNameInputfield, createButton,
				successFullyCreated_popuop, somethingWentWrongErrorMesg);
	}
	
	public void createUserStatusThrougByenteringNonEnglishCahracterInDescriptionTextfield() {
		
		String nonEnglishCahracter="கூட்டம் "; //(Meeting)
		
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		checkthroughAsterisk(statusNameLabel, true);
		statusNameInputfield.sendKeys(fake.lastName1());
		
		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(nonEnglishCahracter);
		assertTrue(menusToHideDropdown.isDisplayed(), "menusToHideDropdown is not dispalyed");

		smsTemplate.createTemplateThroughSpecialCharacterUTILITY(descriptionLabel, descriptionField, createButton,
				successFullyCreated_popuop, somethingWentWrongErrorMesg);
	}

	public void userCreateUserStatusThroughEmojis() {

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();
		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(fake.lastName1());

		smsTemplate.createTemplateForMandatoryFieldThroughEmojisUTILITY(statusNameLabel, statusNameInputfield,
				createButton, successFullyCreated_popuop, somethingWentWrongErrorMesg);

	}

	public void createUserStatusByEnteringMoreThanCharacterLimitForStatusNameTetxfield() {

		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(fake.lastName1());
		smsTemplate.characterLimitTextfieldUtility(statusNameInputfield, createButton, successFullyCreated_popuop,
				somethingWentWrongErrorMesg);
	}
	
	public void createUserStatusByEnteringMoreThanCharacterLimitInDescriptionTetxfield() {

		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();
		
		statusNameInputfield.sendKeys(fake.lastName1());
		smsTemplate.characterLimitTextfieldUtility(descriptionField, createButton, successFullyCreated_popuop,
				somethingWentWrongErrorMesg);
	}
	
	public void createUserStatusByEnteringNonEnglishCahracterInTextfield() {

		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();
		
		statusNameInputfield.sendKeys(fake.lastName1());
		smsTemplate.characterLimitTextfieldUtility(descriptionField, createButton, successFullyCreated_popuop,
				somethingWentWrongErrorMesg);
	}

	public void createUserStatusThroughOnlyNumericValue() {

		String numericValue = "1234568900000000";

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		checkthroughAsterisk(statusNameLabel, true);
		statusNameInputfield.sendKeys(numericValue);

		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(fake.lastName1());

		jsClick(driver, createButton);

		if (successFullyCreated_popuop.isDisplayed()) {
			// Assert.fail("Test failed because successFullyCreated_popuop is displayed.");
			assertFalse(true, "Test failed because successFullyCreated_popuop is displayed.");
		} else if (somethingWentWrongErrorMesg.isDisplayed()) {
			Assert.assertTrue(true, "Test passed because somethingWentWrongErrorMesg is displayed.");
		}

	}

	ArrayList<String> activeStatusist = new ArrayList<String>();
	ArrayList<String> isDefaultStatusLists = new ArrayList<String>();

	public void createUserStatusByEnablingAndSelectingOptionstoToConsiderIsDefault() {

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		// ActiveStatus
		for (WebElement activeStatusListvalues : activeStatusLists) {
			String activeStatusListvaluesText = activeStatusListvalues.getText();
			System.out.println("activeStatusistvaluesText:" + activeStatusListvaluesText);

			activeStatusist.add(activeStatusListvaluesText);
		}

		// isDefault
		for (WebElement isDefaultvalues : isDefaultLists) {
			String isDefaultListsText = isDefaultvalues.getText();
			System.out.println("isDefaultListsText:" + isDefaultListsText);

			isDefaultStatusLists.add(isDefaultListsText);
		}

		assertTrue(activeStatusist.contains("True") && isDefaultStatusLists.contains("True"),
				"No user status is created with default one");

		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		checkthroughAsterisk(isDefaultLabeel, false);
		isDefaultCheckBox.click();

		checkthroughAsterisk(statusNameLabel, true);
		statusNameLabel.sendKeys(fake.lastName1());

		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(fake.lastName1());

		assertTrue(menusToHideDropdown.isDisplayed(), "menusToHideDropdown is not displayed");

		jsClick(driver, createButton);
		assertTrue(isDefaultErrorMessagElement.isDisplayed(),
				"isDefaultErrorMessagElement is not dispalyed it can appect to create multiple Default users");

	}

	List<String> statusNameList = new ArrayList<>();
	List<String> createdStatusLists = new ArrayList<>();

	public void userCreateUserStatuswithoutSelectingActiveStausAndIsDefault() {

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		checkthroughAsterisk(statusNameLabel, true);
		statusNameInputfield.sendKeys(fake.lastName1());

		String createdStatusNameInputfieldValue = statusNameInputfield.getAttribute("value");
		System.out.println("createdStatusNameInputfieldValue :" + createdStatusNameInputfieldValue);

		checkthroughAsterisk(activeStatusLabel, false);
		activeStatusToggleButton.click();

		checkthroughAsterisk(isDefaultLabeel, false);

		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(fake.lastName1());

		assertTrue(menusToHideDropdown.isDisplayed(), "menusToHideDropdown is not displayed");

		// createButton.click();
		jsClick(driver, createButton);

		wait.until(ExpectedConditions.visibilityOf(successFullyCreated_popuop));
		assertTrue(successFullyCreated_popuop.isDisplayed(), "successFullyCreated_popuop is not dispalyed ");
		continueButton_create.click();

//		for (WebElement statusName : statusNames) {
//			String statusNameTexts = statusName.getText();
//
//			statusNameList.add(statusNameTexts);
//		}
//
//		assertTrue(statusNameList.contains(createdStatusNameInputfieldValue),
//				"createdStatusNameInputfieldValue not contains");
////		assertTrue(statusNameList.contains(createdStatusNameInputfieldValue) && activeStatusist.contains("False")
////				&& isDefaultStatusist.contains("False"), " after disabling only activeStatus and check box ststaus are not changed");
//		profileDropdown.click();
//		subMenuDropdwonProfile.click();
//
//		for (WebElement createdStatusLists : createdStatusListStatusDrodown) {
//			String createdStatusListsTexts = createdStatusLists.getText();
//			System.out.println("createdStatusListsTexts :" + createdStatusListsTexts);
//
//		}
//		createdStatusLists.add(createdStatusNameInputfieldValue);
//		assertTrue(createdStatusLists.contains(createdStatusNameInputfieldValue),
//				"Cretaed userStatus is not contains in UsersatatusDropdown");
//			

		// Adding status names to the list
		for (WebElement statusName : statusNames) {
			String statusNameText = statusName.getText();
			statusNameList.add(statusNameText);
		}

		// Assert that the created status name is in the status name list
		Assert.assertTrue(statusNameList.contains(createdStatusNameInputfieldValue),
				"createdStatusNameInputfieldValue not contained in statusNameList");

		// Open profile dropdown menu
		profileDropdown.click();
		subMenuDropdwonProfile.click();

		boolean statusFoundAndClicked = false;

		// Check if createdStatusNameInputfieldValue is in the dropdown, and click it if
		// found
		for (WebElement createdStatus : createdStatusListStatusDrodown) {
			String createdStatusText = createdStatus.getText();
			System.out.println("createdStatusText :" + createdStatusText);

			if (createdStatusText.equals(createdStatusNameInputfieldValue)) {
				createdStatus.click();
				statusFoundAndClicked = true;
				break;
			}
		}

		// Assert to ensure the created status was found and clicked
		Assert.assertTrue(statusFoundAndClicked,
				"Created user status is not present or could not be clicked in UserStatusDropdown");
	}

	public void searchInvalidCharacterInSearchTextfieldInUserStatusPage() {

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");
		smsTemplate.searchInvalidCreatedTemplateInSearchFieldUTILITY(searchTextfield, searchbutton_Table,
				noRecordsFound, clearAllFiltersButton_Table);

	}

	public void tryToSearchByWithoutEnteringAnyData() {

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		assertTrue(searchTextfield.isDisplayed(), "searchTextfieldis not dispalyed");

		String currentUrl = driver.getCurrentUrl();

		assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
		searchbutton_Table.click();

		String afterSearchCurrentUrl = driver.getCurrentUrl();

		assertNotEquals(afterSearchCurrentUrl, currentUrl, "current url is not changed after click on search button");

		String currentSearchTextFieldValue = searchTextfield.getAttribute("value");
		assertTrue(currentSearchTextFieldValue == null || currentSearchTextFieldValue.isEmpty(),
				"Test failed: searchTextfield value is not empty after clicking search button.");
		clearAllFiltersButton_Table.click();

	}

	String activeStatus = "True";

	public void userSearchthroughActiveStatus() {
		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		assertTrue(searchTextfield.isDisplayed(), "searchTextfieldis not dispalyed");
		searchTextfield.sendKeys(activeStatus);
		searchTextfield.click();

		searchbutton_Table.click();

		boolean ErrorMessage = noEntriedFound.isDisplayed();

		assertTrue(ErrorMessage, "ErrorMessage is not displayed");
		clearAllFiltersButton_Table.click();

	}

	String isDefaultStatus = "False";

	public void userSearchthroughisDefaultStatus() {
		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		assertTrue(searchTextfield.isDisplayed(), "searchTextfieldis not dispalyed");
		searchTextfield.sendKeys(isDefaultStatus);
		searchTextfield.click();

		searchbutton_Table.click();

		boolean ErrorMessage = noEntriedFound.isDisplayed();

		assertTrue(ErrorMessage, "ErrorMessage is not displayed");
		clearAllFiltersButton_Table.click();

	}

	public void filledAlldataInCreateUserStatusPageAndClickONCancel() {

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		assertTrue(Create.isDisplayed(), "Create is not displayed");
		Create.click();

		assertTrue(verifyCreateUserStatus.isDisplayed(), "verifyCreateUserStatusis not dispaleyd");

		checkthroughAsterisk(statusNameLabel, true);
		statusNameInputfield.sendKeys(fake.lastName1());

		String createdStatusNameInputfieldValue = statusNameInputfield.getAttribute("value");
		System.out.println("createdStatusNameInputfieldValue :" + createdStatusNameInputfieldValue);

		checkthroughAsterisk(isDefaultLabeel, false);

		checkthroughAsterisk(descriptionLabel, false);
		descriptionField.sendKeys(fake.lastName1());

		assertTrue(menusToHideDropdown.isDisplayed(), "menusToHideDropdown is not displayed");

		assertTrue(CancelButton.isDisplayed(), "CancelButton is not displayed");
		// CancelButton.click();
		jsClick(driver, CancelButton);

		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		assertTrue(!statusNameLists.contains(createdStatusNameInputfieldValue),
				"After cancely only user status is created");
	}

	// Delete
	public void afterClickOnDeleteIconInsteofClickDeleteOrcancelButtonClickOutise() {

		NavigateToUserStatus();
		assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

		String firstCreatedUserStatusText = firstCreatedUserStatus.getText();
		System.out.println("firstCreatedUserStatusText :" + firstCreatedUserStatusText);

		assertTrue(deleteButton.isDisplayed(), "deleteButton is not displayed");
		deleteButton.click();

		assertTrue(deletePopup_userStatus.isDisplayed(), "deletePopup_userStatus is not displayed");

		actions.moveByOffset(0, 0).click().perform();

//		assertTrue(!deleted_SuceessfullyPopup.isDisplayed(), "delete successfult popup is displayed");
//		driver.navigate().refresh();

		if (verifyUserStatusPage.isDisplayed()) {
			Assert.assertTrue(true, "Test passed: 'userStatus' page is displayed.");
		} else if (deleted_SuceessfullyPopup.isDisplayed()) {

			Assert.fail("Test failed: 'Deleted Successfully' popup is displayed.");
		} else {
			Assert.fail("Test failed: Neither popup nor status page is displayed.");

		}

	}

	public void TheUserAbleTodeleteAllUserStatus() {
		try {

			NavigateToUserStatus();
			assertTrue(verifyUserStatusPage.isDisplayed(), "verifyUserStatusPage is not displayed");

			for (WebElement deleteButton : deleteOptions) {
				deleteButton.click();

				deleteButton_delete.click();

				wait.until(ExpectedConditions.visibilityOf(deleted_SuceessfullyPopup));
				assertTrue(deleted_SuceessfullyPopup.isDisplayed(), "deleted_SuceessfullyPopupis not displayed");
				deleted_SuceessfullyPopup.isDisplayed();
				continueButton_DeleteSuccessullyPopup.isDisplayed();
				continueButton_DeleteSuccessullyPopup.click();

				Thread.sleep(1000);
			}

			System.out.println("All items deleted successfully.");

		} catch (

		Exception e) {
			e.printStackTrace();

		}
	}

	public void logoutAmdin() {
		// Logout
		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
		profileDropdown.click();

		assertTrue(logout.isDisplayed(), "logout is not displayed");
		logout.click();
	}

	// <!================
	// Profile_MyProfile_Positive======================================================================

	public void navigateToAccountSettingPage() {

		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
		profileDropdown.click();

		assertTrue(myProfileOption.isDisplayed(), "myProfileOption is not displayed");
		myProfileOption.click();

		assertTrue(verifyAccountSettingsPage.isDisplayed(), "verifyAccountSettingsPage is not dispalyed");

	}

	public void UpdateAndContinue() {

		updateOptionAccountSettings.click();

		wait.until(ExpectedConditions.visibilityOf(successFullyCreated_popuop));
		assertTrue(successFullyCreated_popuop.isDisplayed(),
				"Test Failed:successFullyCreated_popuop is not displayed  first name last name Not changed ");
		wait.until(ExpectedConditions.elementToBeClickable(continueButton_MyProfile));
		continueButton_MyProfile.click();

	}

	// <=========== Profile_ChangePassword_Positive=============

	public void navigateToChangePasswordPage() {

		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
		profileDropdown.click();

		assertTrue(changePasswordOption.isDisplayed(), "changePasswordOption is not displayed");
		changePasswordOption.click();

		assertTrue(verifychangePasswordPage.isDisplayed(), "verifychangePasswordPage is not displayed");
	}

	public void userIsAbleToChangeUserName(String EnterFirstName, String EnterLastName) {
		// First Name

		verifyuserNameInAccontSettings.isDisplayed();
		String userNameInAccontSettingsText = verifyuserNameInAccontSettings.getText();

		assertTrue(firstNameLabel.isDisplayed(), "firstNameLabel is not displayed");
		checkthroughAsterisk(firstNameLabel, true);
		assertTrue(firstNameTextfield.isDisplayed(), "firstNameTextfield is not displayed");

		String firstNameTextfieldvalue = firstNameTextfield.getAttribute("value");

		firstNameTextfield.clear();
		firstNameTextfield.sendKeys(EnterFirstName);

		String afterUpdatefirstNameValue = firstNameTextfield.getAttribute("value");

		// LastName
		assertTrue(lastNameLabel.isDisplayed(), "lastNameLabel is not displayed");
		checkthroughAsterisk(lastNameLabel, false);
		assertTrue(lastNameTextfield.isDisplayed(), "lastNameTextfield is not displayed");

		String lastNameTextfieldText = lastNameTextfield.getAttribute("value");

		lastNameTextfield.clear();
		lastNameTextfield.sendKeys(EnterLastName);

		String afterUpdateLastNameValue = lastNameTextfield.getAttribute("value");

		UpdateAndContinue();

		String afterChangeduserNameInAccontSettingsText = verifyuserNameInAccontSettings.getText();

		assertNotEquals(afterChangeduserNameInAccontSettingsText, userNameInAccontSettingsText);

	}

	public void userIsAbleTochangeEmailId(String EnterNewEmailID) {

		assertTrue(emailtextfieldLabel.isDisplayed(), "emailTextfieldLabelis not displayed");
		checkthroughAsterisk(emailtextfieldLabel, true);
		assertTrue(emailTextfield.isDisplayed(), "emailTextfieldis not displayed");

		String emailtextfieldInAccontSettingsvalue = emailTextfield.getAttribute("value");

		emailTextfield.clear();
		emailTextfield.sendKeys(EnterNewEmailID);

		UpdateAndContinue();

		String afterUpdateEmailTextfieldValue = emailTextfield.getAttribute("value");
		;

		assertNotEquals(emailtextfieldInAccontSettingsvalue, afterUpdateEmailTextfieldValue);

	}

	public void userIsAbleTochangeEmailMobileNumber() {
		// Generate a random 10-digit number
		Random random = new Random();
		long randomNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L); // Ensures 10-digit number

		System.out.println("Generated 10-digit number: " + randomNumber);

		// Ensure the random number is converted to a String
		String randomNumberString = String.valueOf(randomNumber);

		assertTrue(MobileLabel.isDisplayed(), "MobileLabel not displayed");
		checkthroughAsterisk(MobileLabel, true);
		assertTrue(mobileTextfield.isDisplayed(), "mobileTextfield not displayed");

		String mobileNumberFieldValueInAccontSettings = mobileTextfield.getAttribute("value");

		mobileTextfield.clear();
		mobileTextfield.sendKeys(randomNumberString); // Pass random number as String

		UpdateAndContinue();

		String afterUpdatemobileNumberValue = mobileTextfield.getText();

		assertNotEquals(mobileNumberFieldValueInAccontSettings, afterUpdatemobileNumberValue);
	}

	public void userIsAbleToeditProflePicture() {

		try {

			// Profile WebElement
			WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and @id='profile_pic']"));

			assertTrue(editProfileAccountSettings.isDisplayed(), "editProfileAccountSettings is not displayed");
			editProfileAccountSettings.click();

			// Images Path
			String imagePath = "D:\\Wyzmindz\\ADVAITA Project\\wyzmindz-solutions-pvt.-ltd.-600px-logo.png";
			fileInput.sendKeys(imagePath);

			unWait(1000);

			// Upload the image using sendKeys
			fileInput.sendKeys(imagePath);

			updateOptionAccountSettings.click();

			// Simulate file dialog cancel action by pressing Escape
			robot.delay(2000); // Wait for the dialog to appear
			robot.keyPress(KeyEvent.VK_ESCAPE); // Press ESC
			robot.keyRelease(KeyEvent.VK_ESCAPE); // Release ESC

			System.out.println("Image uploaded successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// <========== MyProfile Neagtive

	public void userWithoutFilledAnyFieldInmandatoryFieldAndUpdate() {

		checkthroughAsterisk(firstNameLabel, true);
		checkthroughAsterisk(lastNameLabel, false);
		checkthroughAsterisk(emailtextfieldLabel, true);
		checkthroughAsterisk(MobileLabel, true);
		assertTrue(firstNameTextfield.isDisplayed() && lastNameTextfield.isDisplayed() && emailTextfield.isDisplayed()
				&& mobileTextfield.isDisplayed());

		firstNameTextfield.clear();
		lastNameTextfield.clear();
		emailTextfield.clear();
		mobileTextfield.clear();

		updateOptionAccountSettings.click();

		assertTrue(firstNameErrorMesg.isDisplayed() && emailTextFieldErrorMesg.isDisplayed()
				&& mobileNumberTextFieldErrorMesg.isDisplayed(), "Error message is not dispalyed ");

		wait.until(ExpectedConditions.elementToBeClickable(cancelOptionAccountSettings));
		cancelOptionAccountSettings.click();

	}

	public void userFilledAllTheTextfieldAndClickONCancel(String EnterFirstName, String EnterLastName,
			String EnterEmailId, String EnterMobilenumber) {

		assertTrue(firstNameTextfield.isDisplayed() && lastNameTextfield.isDisplayed() && emailTextfield.isDisplayed()
				&& mobileTextfield.isDisplayed());

		firstNameTextfield.clear();
		lastNameTextfield.clear();
		emailTextfield.clear();
		mobileTextfield.clear();

		firstNameTextfield.sendKeys(EnterFirstName);
		lastNameTextfield.sendKeys(EnterLastName);
		emailTextfield.sendKeys(EnterEmailId);
		mobileTextfield.sendKeys(EnterMobilenumber);

		cancelOptionAccountSettings.click();

		assertTrue(!successFullyCreated_popuop.isDisplayed(), "Test Failed: successFullyCreated_popuop is displayed");
	}

	// EmailTextfield
//	public void verifyTheUSerisAbleToUpdateByEnteronlyCharactersIntextfield(String EnterCharacter) {
//
//		checkthroughAsterisk(emailTextfieldLabel, true);
//		assertTrue(emailTextfield.isDisplayed(), "emailTextfield is not displayed");
//		emailTextfield.sendKeys("EnterCharacter");
//		updateOptionAccountSettings.click();
//
//		assertTrue(emailTextFieldErrorMesg.isDisplayed(), "Test Failed : error messgae is not dispalyed");
//		cancelOptionAccountSettings.click();
//
//	}

	public void verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(WebElement TextfieldLabelElement,
			WebElement TextfieldElement, String EnterCharacter, WebElement TextfieldErrorMesgElement) {

		wait.until(ExpectedConditions.visibilityOfAllElements(TextfieldLabelElement));
		checkthroughAsterisk(TextfieldLabelElement, true);
		assertTrue(TextfieldElement.isDisplayed(), "emailTextfield is not displayed");
		TextfieldElement.clear();
		TextfieldElement.sendKeys(EnterCharacter);
		updateOptionAccountSettings.click();

		assertTrue(TextfieldErrorMesgElement.isDisplayed(), "Test Failed : error messgae is not dispalyed");
		cancelOptionAccountSettings.click();

	}

	public void userIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY(WebElement textfieldElement, String emoji,
			WebElement UpdateOptionAccountSettings, WebElement successfullyPopup) {

		assertTrue(textfieldElement.isDisplayed(), "textfieldElement is not displayed");
		textfieldElement.clear();
		SendDataUtils.sendKeysWithJSExecutor(textfieldElement, emoji); // use for send "emojis"

		assertTrue(UpdateOptionAccountSettings.isDisplayed(), "UpdateOptionAccountSettings is not displayed");
		UpdateOptionAccountSettings.click();
		assertTrue(!successfullyPopup.isDisplayed(), "Test Fail : successfullyPopup is displayed");
		cancelOptionAccountSettings.click();

	}

	// Repeated Character
	public void userIsAbleToenterRepeatedCharacterINTextfield(WebElement textfieldElement,
			String invalidCreatedProcess) {

		try {
			assertTrue(textfieldElement.isDisplayed(), "textfieldElement is not displayed");

			textfieldElement.clear();
			textfieldElement.sendKeys(invalidCreatedProcess);
			updateOptionAccountSettings.click();
			unWait(2000);
			assertTrue(!successFullyCreated_popuop.isDisplayed(),
					"TestCase Failed: successFullyCreated_popuop is  displayed");

		} catch (NoSuchElementException e) {
			System.out.println(" Test Case Pass: successFullyCreated_popuop is not Displayed");
		}

	}

	// <============================== Change Password

	String userName = "das " + "Abhijit@wyzminz.com";
	String commmonPassword = "Qwerty@123";

	public void userIsAbleToChangePassword(String enterOldPassword, String enterNewPassword,
			String enterConfirmPassword) {

		// Assert that all required fields are displayed
		assertTrue(oldPasswordTextfield.isDisplayed(), "Old password text field is not displayed.");
		assertTrue(newPasswordTextfield.isDisplayed(), "New password text field is not displayed.");
		assertTrue(conformPasswordTextfield.isDisplayed(), "Confirm password text field is not displayed.");

		// Clear and enter the old password
		oldPasswordTextfield.clear();
		oldPasswordTextfield.sendKeys(enterOldPassword);

		// Clear and enter the new password
		newPasswordTextfield.clear();
		newPasswordTextfield.sendKeys(enterNewPassword);

		// Enter the confirm password
		conformPasswordTextfield.clear();
		conformPasswordTextfield.sendKeys(enterConfirmPassword);

		// Validate the new password
		boolean hasUpperCase = enterNewPassword.matches(".*[A-Z].*");
		boolean hasNumber = enterNewPassword.matches(".*[0-9].*");
		boolean hasSpecialCharacter = enterNewPassword.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

		// Assert checks for password complexity requirements
		assertTrue(hasUpperCase, "New password does not contain an uppercase letter.");
		assertTrue(hasNumber, "New password does not contain a numerical value.");
		assertTrue(hasSpecialCharacter, "New password does not contain a special character.");

		// Validate if confirm password matches the new password
		assertTrue(enterNewPassword.equals(enterConfirmPassword), "Confirm password does not match the new password.");

		// Perform the password change action
		changeMyPasswordButton.click();

		// Confirmation message or validation (if applicable)
		System.out.println("Password changed successfully.");
	}

	public void userIsAbleGetErrorMessage(String enterWrongPassWordonOldPassword, String enterNewPassword,
			String enterConfirmPassword, WebElement oldPasswordErrorMessageElement) {

		// Assert that all required fields are displayed
		assertTrue(oldPasswordTextfield.isDisplayed(), "Old password text field is not displayed.");
		assertTrue(newPasswordTextfield.isDisplayed(), "New password text field is not displayed.");
		assertTrue(conformPasswordTextfield.isDisplayed(), "Confirm password text field is not displayed.");

		// Clear and enter the old password
		oldPasswordTextfield.clear();
		oldPasswordTextfield.sendKeys(enterWrongPassWordonOldPassword);

		// Clear and enter the new password
		newPasswordTextfield.clear();
		newPasswordTextfield.sendKeys(enterNewPassword);

		// Enter the confirm password
		conformPasswordTextfield.clear();
		conformPasswordTextfield.sendKeys(enterConfirmPassword);

		// Validate the new password
		boolean hasUpperCase = enterNewPassword.matches(".*[A-Z].*");
		boolean hasNumber = enterNewPassword.matches(".*[0-9].*");
		boolean hasSpecialCharacter = enterNewPassword.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

		// Assert checks for password complexity requirements
		assertTrue(hasUpperCase, "New password does not contain an uppercase letter.");
		assertTrue(hasNumber, "New password does not contain a numerical value.");
		assertTrue(hasSpecialCharacter, "New password does not contain a special character.");

		// Validate if confirm password matches the new password
		assertTrue(enterNewPassword.equals(enterConfirmPassword), "Confirm password does not match the new password.");

		// Perform the password change action
		changeMyPasswordButton.click();

		assertTrue(oldPasswordErrorMessageElement.isDisplayed(), "Test Fail: oldPasswordErrorMessage is not dispalyed");
	}

	public void userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(String EnterOldPassword,
			String EnterNewPassword, String EnterConformPassword, WebElement errorMesssageElement) {

		checkthroughAsterisk(oldPasswordLabel, false);
		checkthroughAsterisk(newPasswordLabel, false);
		checkthroughAsterisk(conformPAsswordLabel, false);

		oldPasswordTextfield.isDisplayed();
		oldPasswordTextfield.sendKeys(EnterOldPassword);

		newPasswordTextfield.isDisplayed();
		newPasswordTextfield.sendKeys(EnterNewPassword);

		conformPasswordTextfield.isDisplayed();
		conformPasswordTextfield.sendKeys(EnterConformPassword);

		changeMyPasswordButton.click();

		assertTrue(errorMesssageElement.isDisplayed(), "Test Failed : errorMesssageElement is not displayed");
	}

	public void userIsAbleToChangePasswordByEnterPasswwordLessThanCharacterLimit(String enterOldPassword,
			String enterNewPassword, WebElement ErrorMessageElement) {

		checkthroughAsterisk(oldPasswordLabel, false);
		checkthroughAsterisk(newPasswordLabel, false);
		checkthroughAsterisk(conformPAsswordLabel, false);

		// Validate that the new password contains more than 8 characters
		assertTrue(enterNewPassword.length() < 8, "New password must contain more than 8 characters.");

		// Clear and enter the old password
		oldPasswordTextfield.clear();
		oldPasswordTextfield.sendKeys(enterOldPassword);

		// Clear and enter the new password
		newPasswordTextfield.clear();
		newPasswordTextfield.sendKeys(enterNewPassword);

		// Validate the new password
		boolean hasUpperCase = enterNewPassword.matches(".*[A-Z].*");
		boolean hasNumber = enterNewPassword.matches(".*[0-9].*");
		boolean hasSpecialCharacter = enterNewPassword.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

		// Assert checks for password complexity requirements
		assertTrue(hasUpperCase, "New password does not contain an uppercase letter.");
		assertTrue(hasNumber, "New password does not contain a numerical value.");
		assertTrue(hasSpecialCharacter, "New password does not contain a special character.");

		// Perform the password change action
		changeMyPasswordButton.click();

		assertTrue(ErrorMessageElement.isDisplayed(), "Test Fail: oldPasswordErrorMessage is not dispalyed");

	}

	public void userisAbleToSeeThePasswordByClickEyeIcon(WebElement PasswordTextfieldElement, String EnterPassword,
			WebElement eyeIconElement) {

		PasswordTextfieldElement.isDisplayed();
		PasswordTextfieldElement.sendKeys(EnterPassword);
		String beforeClickOnEyeIconAttributeTypeValue = PasswordTextfieldElement.getAttribute("type");

		assertTrue(beforeClickOnEyeIconAttributeTypeValue.equals("password"),
				"Test Failed: beforeClickOnEyeIconAttributeTypeValue is not equal with Password ");
		System.out.println("beforeClickOnEyeIconAttributeTypeValue :" + beforeClickOnEyeIconAttributeTypeValue);

		eyeIconElement.click();

		String afterClickOnEyeIconAttributeTypeValue = PasswordTextfieldElement.getAttribute("type");

		assertTrue(afterClickOnEyeIconAttributeTypeValue.equals("text"),
				"Test Failed: afterClickOnEyeIconAttributeTypeValue is not equal with Text ");

	}

}