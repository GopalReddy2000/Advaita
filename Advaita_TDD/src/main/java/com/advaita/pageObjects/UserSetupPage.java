package com.advaita.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ExcelUtils;

import Advaita_TDD.Advaita_TDD.FakeData;

public class UserSetupPage extends TestBase {

	@FindBy(id = "menulist1")
	WebElement userSetup;

	@FindBy(linkText = "User Management")
	WebElement userManagement;

	@FindBy(linkText = "Role & Permissions")
	WebElement roleAndPermissions;

	@FindBy(linkText = "+ Create")
	WebElement roleAndPermissionsCreate;

	@FindBy(xpath = "//select[@id='multiselect']")
	WebElement rolePermissionDropdown;

	@FindBy(css = "table.w-100 tbody")
	WebElement formsTableBody;

	@FindBy(linkText = "System Names")
	WebElement systemNames;

	@FindBy(id = "exampleInputPassword1")
	WebElement searchBox;

	@FindBy(xpath = "//select[@id='selected_role']")
	WebElement roleDropdown;

	@FindBy(xpath = "//select[@id='from_user']")
	WebElement superiorDropdown;

	@FindBy(xpath = "//select[@name='status']")
	WebElement statusDropdown;

	@FindBy(xpath = "//button[contains(@class,'filter_search')]")
	WebElement searchButton;

	@FindBy(xpath = "//h6[text()='Clear All Filters']")
	WebElement clearAllFilter;

	@FindBy(linkText = "+ Create")
	WebElement userManagementCreateButton;

	@FindBy(xpath = "//a[@id='uploadBtn']")
	WebElement userManagementCreateCloudUpload;

	@FindBy(id = "downloadBtn")
	WebElement userManagementFilterDownload;

	@FindBy(xpath = "//select[@id='process_search']")
	WebElement searchProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	WebElement searchSubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process_search']")
	WebElement searchSubSubProcessDropdown;

	@FindBy(xpath = "//table[@class='w-100']")
	WebElement rolesTable;

	@FindBy(xpath = "//input[@id='user_name']")
	WebElement inputUserName;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement inputFirstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement inputLastName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement inputEmail;

	@FindBy(xpath = "//input[@id='password']")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement inputConfirmPassword;

	@FindBy(xpath = "//input[@name='user_active']")
	WebElement activeCheckBox;

	@FindBy(xpath = "(//input[@name='q'])[1]")
	WebElement groupsSearchField;

	@FindBy(xpath = "//select[@id='multiselect_group']")
	WebElement groupsMultiSelectDropdown;

	@FindBy(xpath = "//select[@id='multiselect_group_to']")
	WebElement groupsMultiSelectToDropdown;

	// ----Roles And Permissions-----------

	@FindBy(xpath = "//tbody//td[1]")
	public List<WebElement> roleTableNames;

	@FindBy(id = "group_name")
	WebElement inputGroupName;

	@FindBy(xpath = "//button[text()='Create']")
	WebElement roleCreateButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement roleCancelButton;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	WebElement roleContinueButton;

	@FindBy(xpath = "//select[@name='permission_id']")
	WebElement permissionsMultiSelectDropdown;

	@FindBy(xpath = "//select[@name='permission_select']")
	WebElement permissionsMultiSelectToDropdown;

	@FindBy(xpath = "(//input[@name='q'])[2]")
	WebElement permissionsSearchField;

	@FindBy(id = "multiselect_group_rightAll")
	WebElement groupsAllRight;

	@FindBy(id = "multiselect_group_rightSelected")
	WebElement groupsSingleRight;

	@FindBy(id = "multiselect_group_leftSelected")
	WebElement groupsSingleLeft;

	@FindBy(id = "multiselect_group_leftAll")
	WebElement groupsAllLeft;

	@FindBy(id = "multiselect_rightAll")
	WebElement permissionsAllRight;

	@FindBy(id = "multiselect_rightSelected")
	WebElement permissionsSingleRight;

	@FindBy(id = "multiselect_leftSelected")
	WebElement permissionsSingleLeft;

	@FindBy(id = "multiselect_leftAll")
	WebElement permissionsAllLeft;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	WebElement userAccountCreateButton;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement userAccountCancelButton;

	@FindBy(xpath = "//button[text()='Delete']")
	WebElement roleTableDelete;

	public int getRandomIndex(List<WebElement> element) {
		if (element.size() > 0) {
			Random rand = new Random();
			return rand.nextInt(element.size());
		} else {

			throw new IllegalArgumentException("List size must be greater than zero.");
		}

	}

	public static List<String> RolesCreated = new ArrayList<>();

	static FakeData fake = new FakeData();
	static SoftAssert softAssert = new SoftAssert();

	public UserSetupPage() {
		PageFactory.initElements(driver, this);

	}

	String firstName;
	String lastName;
	String password;
	String UserName;
	String permissionsfilePath = System.getProperty("user.dir") + "\\ExcelFiles\\PermissionsToSelect.xlsx";
	String permissionssheetName = "Sheet1";
	ExcelUtils excel = new ExcelUtils(permissionsfilePath, permissionssheetName);

	private static void assertElements(WebElement textBox) {
		softAssert.assertTrue(textBox.isEnabled());
		softAssert.assertTrue(textBox.isDisplayed());

	}

	public UserSetupPage navToUserCreatePage() {
//		userSetup.click();
		click(driver, userManagement);
		userManagementCreateButton.click();
		return this;
	}

	public void assertElements() {
		userManagementCreateButton.click();
		assertElements(inputUserName);
		assertElements(inputFirstName);
		assertElements(inputLastName);
		assertElements(inputEmail);
		assertElements(inputPassword);
		assertElements(inputConfirmPassword);

		if (activeCheckBox.isSelected()) {
			System.out.println(activeCheckBox.isSelected());
			activeCheckBox.click();
			System.out.println(activeCheckBox.isSelected());
		}

		assertElements(groupsSearchField);
		assertElements(groupsMultiSelectDropdown);
		assertElements(groupsMultiSelectToDropdown);
		assertElements(groupsAllRight);
		assertElements(groupsSingleRight);
		assertElements(groupsSingleLeft);
		assertElements(groupsAllLeft);
		assertElements(permissionsSearchField);
		assertElements(permissionsMultiSelectDropdown);
		assertElements(permissionsMultiSelectToDropdown);
		assertElements(permissionsAllRight);
		assertElements(permissionsSingleRight);
		assertElements(permissionsSingleLeft);
		assertElements(permissionsAllLeft);
		assertElements(userAccountCreateButton);
		assertElements(userAccountCancelButton);
		softAssert.assertAll();

	}

	public UserSetupPage userCreationFields(String fName, String lName, String pass) {

		firstName = fName;
		lastName = lName;
		password = pass;
		UserName = firstName + " " + lastName;
		inputUserName.sendKeys(UserName);
		inputFirstName.sendKeys(firstName);
		inputLastName.sendKeys(lastName);
		inputPassword.sendKeys(password);
		inputConfirmPassword.sendKeys(password);
		System.out.println(UserName);
		if (!activeCheckBox.isSelected()) {
			System.out.println("Active Checkbox is not selected");
			activeCheckBox.click();
			System.out.println("Active Checkbox Checked now");

		} else {
			System.out.println("Active Checkbox Checked");

		}

		return this;

	}

	public UserSetupPage singleGroupSelect(String selectGroup) {
		Select singleGroup = new Select(groupsMultiSelectDropdown);
		singleGroup.selectByVisibleText(selectGroup);
		click(driver, groupsSingleRight);
		return this;
	}

	public UserSetupPage clickOnGroupCreateButton() {
		jsClick(driver, userAccountCreateButton);
		unWait(2);
		roleContinueButton.click();
		return this;
	}

	public UserSetupPage navToRoleAndPerTable() {
		userSetup.click();
		roleAndPermissions.click();

		return this;
	}

	public UserSetupPage navToRoleAndPerCreate() {
		userSetup.click();
		roleAndPermissions.click();
		roleAndPermissionsCreate.click();
		return this;
	}

	public UserSetupPage createRoles(String inputgroupname, String getGroupNameFromExcel) {
		sendKeys(inputGroupName, inputgroupname);

		Select fromGroupsDrp = new Select(permissionsMultiSelectDropdown);

		//
		List<String> groupsToSelect = excel.getColumnDataByName(getGroupNameFromExcel);

		for (String options : groupsToSelect) {
			fromGroupsDrp.selectByVisibleText(options);
		}

		permissionsSingleRight.click();
		roleCreateButton.click();
		// roleCancelButton.click();
		unWait(2);
		roleContinueButton.click();
		RolesCreated.add(inputgroupname);
//		deleteFormByName(inputgroupname);
		System.out.println(RolesCreated);

		return this;

	}

	public UserSetupPage validateGroupNameInputField(String groupName) {

		System.out.println(groupName);
		roleAndPermissionsCreate.click();

		inputGroupName.sendKeys(groupName);
		roleCreateButton.click();

		return this;

	}

	public UserSetupPage createUserWithRoleAll(String groupName) {
		inputGroupName.sendKeys(groupName);
		permissionsAllRight.click();
		roleCreateButton.click();

		click(driver, roleContinueButton);
		unWait(2);
		click(driver, userManagement);
		userManagementCreateButton.click();

		Select groupDrop = new Select(groupsMultiSelectDropdown);
		groupDrop.selectByVisibleText(groupName);
		RolesCreated.add(groupName);
		return this;
	}

	public void str() {
		System.out.println(getRoles());
	}

	public UserSetupPage deleteFormByName(String nameToDelete) {
		// Find all rows within the table
		List<WebElement> rows = formsTableBody.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			if (row.getText().equals(nameToDelete)) {
				click(driver, row.findElement(By.cssSelector("img.delete-dataset")));
				roleTableDelete.click();
				unWait(2);
				roleContinueButton.click();
				break;
			} else {

			}

		}

		return this;
	}

	// Method to get the list of entered record names
	public static List<String> getRoles() {

		return RolesCreated;
	}

	public UserSetupPage userLogin(String UserName, String password) {

		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");
		LoginPage.usernameField.sendKeys(UserName);
		LoginPage.passwordField.sendKeys(password);
		LoginPage.signInButton.click();
		return this;

	}

}
