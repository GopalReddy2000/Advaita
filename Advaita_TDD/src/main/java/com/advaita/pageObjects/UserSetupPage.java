package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ExcelUtils;
import com.advaita.Utilities.ExcelWrite;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.SendDataUtils;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class UserSetupPage extends TestBase {

	@FindBy(xpath = "//select[@id='multiselect']")
	public static WebElement rolePermissionDropdown;

	@FindBy(css = "table.w-100 tbody")
	public static WebElement formsTableBody;

	@FindBy(linkText = "System Names")
	public static WebElement systemNames;

	@FindBy(xpath = "//button[text()='System mapping ']")
	public static WebElement systemMappingTab;

	@FindBy(id = "exampleInputPassword1")
	public static WebElement searchBox;

	@FindBy(xpath = "//select[@id='selected_role']")
	public static WebElement roleDropdown;

	@FindBy(xpath = "//select[@id='from_user']")
	public static WebElement superiorDropdown;

	@FindBy(xpath = "//select[@name='status']")
	public static WebElement statusDropdown;

	@FindBy(xpath = "//button[contains(@class,'filter_search')]")
	public static WebElement searchButton;

	@FindBy(xpath = "//h6[text()='Clear All Filters']")
	public static WebElement clearAllFilter;

	@FindBy(id = "stages_filter")
	public static WebElement stageDropdown;

	@FindBy(linkText = "Export")
	public static WebElement export;

	@FindBy(linkText = "+ Create User")
	public static WebElement userManagementCreateButton;

	@FindBy(xpath = "//a[@id='uploadBtn']")
	public static WebElement userManagementCreateCloudUpload;

	@FindBy(xpath = "//select[@id='stage_search']")
	public static WebElement userManagementUploadStagesDropdown;

	@FindBy(id = "downloadBtn")
	public static WebElement userManagementFilterDownload;

	@FindBy(xpath = "//select[@id='process_search']")
	public static WebElement searchProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public static WebElement searchSubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process_search']")
	public static WebElement searchSubSubProcessDropdown;

	@FindBy(xpath = "//table[@class='w-100']")
	public static WebElement rolesTable;

	@FindBy(xpath = "//input[@id='user_name']")
	public static WebElement inputUserName;

	@FindBy(xpath = "//input[@id='first_name']")
	public static WebElement inputFirstName;

	@FindBy(xpath = "//input[@id='last_name']")
	public static WebElement inputLastName;

	@FindBy(xpath = "//input[@id='email']")
	public static WebElement inputEmail;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement inputPassword;

	@FindBy(xpath = "//input[@id='confirm_password']")
	public static WebElement inputConfirmPassword;

	@FindBy(xpath = "//span[text()='Data Setup']")
	public static WebElement dataSetup;

	@FindBy(linkText = "+ Create")
	public static WebElement createButton;

	@FindBy(xpath = "//tbody//img[@alt='table-edit']")
	public static WebElement processEditButton;

	@FindBy(xpath = "//div[@class='content pl_9']")
	List<WebElement> processRecords;

	@FindBy(xpath = "//tbody//td[contains(@class,'second_tree')]//img")
	public static WebElement processSecondEditButton;

	@FindBy(id = "pills-dataset-tab")
	public static WebElement dataSetTab;

	@FindBy(linkText = "+ Create")
	public static WebElement dataSetCreateButton;
	@FindBy(xpath = "//table[@class='w-100']//tbody//td[1]")
	public static WebElement dataSetRecords;

	@FindBy(xpath = "//img[@id='id_delete']")
	public static WebElement dataSetDeleteButton;

	@FindBy(xpath = "//img[@alt='table-edit']")
	public static WebElement dataSetEditButton;

	@FindBy(id = "pills-metadata-tab")
	public static WebElement metaDataTab;

	@FindBy(xpath = "//table[@class='w-100']//tbody//td[1]")
	public static WebElement metaDataRecords;

	@FindBy(linkText = "+ Create")
	public static WebElement metaDataCreateButton;

	@FindBy(xpath = "//img[@alt='delete-icon ']")
	public static WebElement metaDataDeleteButton;

	@FindBy(xpath = "//tr//img[@alt='table-edit']")
	public static WebElement metaDataEditButton;

	@FindBy(xpath = "//span[text()='Workflow Design']")
	public static WebElement workFlowDesign;

	@FindBy(id = "pills-MasterParameter-tab")
	public static WebElement masterParameterTab;

	@FindBy(id = "pills-MeasurableSet-tab")
	public static WebElement measurableSetTab;

	@FindBy(linkText = "+ Add Measurable Set")
	public static WebElement measurableCreateButton;

	@FindBy(xpath = "//img[@alt='delete-icon ']")
	public static List<WebElement> measurableDeleteButton;

	@FindBy(xpath = "//img[@alt='table-edit' and contains(@class,'edit-measurable')]")
	public static List<WebElement> measurableEditButton;

	@FindBy(xpath = "//a//img[@alt='table-edit' and contains(@class,'delete-dataset')]")
	public static List<WebElement> measurableUpload1Button;

	@FindBy(xpath = "//img[@alt='table-edit' and not(contains(@class,'delete-dataset'))and @data-info]")
	public static List<WebElement> measurableUpload2Button;

	@FindBy(xpath = "//img[contains(@class,'copy_question')]")
	public static List<WebElement> measurableDuplicateButton;

	@FindBy(id = "pills-NonMeasurableSet-tab")
	public static WebElement nonMeasurableTab;

	@FindBy(linkText = "+ Add Non Measurable Set")
	public static WebElement nonMeasurableCreateButton;

	@FindBy(xpath = "//img[@alt='delete-icon ']")
	public static List<WebElement> nonMeasurableDeleteButton;

	@FindBy(xpath = "//img[@alt='table-edit' and contains(@class,'edit-measurable')]")
	public static List<WebElement> nonMeasurableEditButton;

	@FindBy(xpath = "//a//img[@alt='table-edit' and contains(@class,'delete-dataset')]")
	public static List<WebElement> nonMeasurableUpload1Button;

	@FindBy(xpath = "//img[@alt='table-edit' and not(contains(@class,'delete-dataset'))and @data-info]")
	public static List<WebElement> nonMeasurableUpload2Button;

	@FindBy(xpath = "//img[contains(@class,'copy_question')]")
	public static List<WebElement> nonMeasurableDuplicateButton;

	@FindBy(id = "pills-Disposition-tab")
	public static WebElement dispositionTab;

	@FindBy(linkText = "+ Add Disposition")
	public static WebElement dispositionCreateButton;

	@FindBy(xpath = "//img[@alt='delete-icon ']")
	public static List<WebElement> dispositionDeleteButton;

	@FindBy(xpath = "//img[@alt='table-edit' and contains(@class,'edit-measurable')]")
	public static List<WebElement> dispositionEditButton;

	@FindBy(id = "menulist1")
	public static WebElement userSetup;

	@FindBy(linkText = "User Management")
	public static WebElement userManagement;

	@FindBy(linkText = "Role & Permissions")
	public static WebElement roleAndPermissions;

	@FindBy(linkText = "+ Create")
	public static WebElement roleAndPermissionsCreate;

	@FindBy(xpath = "//input[@name='user_active']")
	public static WebElement activeCheckBox;

	@FindBy(xpath = "(//input[@name='q'])[1]")
	public static WebElement groupsSearchField;

	@FindBy(xpath = "//select[@id='multiselect_group']")
	public static WebElement groupsMultiSelectDropdown;

	@FindBy(xpath = "//select[@id='multiselect_group_to']")
	public static WebElement groupsMultiSelectToDropdown;

	@FindBy(xpath = "//button[normalize-space()='Update']")
	public static WebElement userUpdate;

// ----Roles And Permissions-----------

	@FindBy(xpath = "//tbody//td[1]")
	public static List<WebElement> roleTableNames;

	@FindBy(id = "group_name")
	public static WebElement inputGroupName;

	@FindBy(xpath = "//button[normalize-space()='Create'] ")
	public static WebElement roleCreateButton;

	@FindBy(id = "group_name-error")
	public static WebElement groupNameError;

	@FindBy(xpath = "//button[text()='Cancel']")
	public static WebElement roleCancelButton;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public static WebElement roleContinueButton;

	@FindBy(xpath = "//select[@name='permission_id']")
	public static WebElement permissionsMultiSelectDropdown;

	@FindBy(xpath = "//select[@name='permission_select']")
	public static WebElement permissionsMultiSelectToDropdown;

	@FindBy(xpath = "(//input[@name='q'])[2]")
	public static WebElement permissionsSearchField;

	@FindBy(id = "multiselect_group_rightAll")
	public static WebElement groupsAllRight;

	@FindBy(id = "multiselect_group_rightSelected")
	public static WebElement groupsSingleRight;

	@FindBy(id = "multiselect_group_leftSelected")
	public static WebElement groupsSingleLeft;

	@FindBy(id = "multiselect_group_leftAll")
	public static WebElement groupsAllLeft;

	@FindBy(id = "multiselect_rightAll")
	public static WebElement permissionsAllRight;

	@FindBy(id = "multiselect_rightSelected")
	public static WebElement permissionsSingleRight;

	@FindBy(id = "multiselect_leftSelected")
	public static WebElement permissionsSingleLeft;

	@FindBy(id = "multiselect_leftAll")
	public static WebElement permissionsAllLeft;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	public static WebElement userAccountCreateButton;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	public static WebElement userAccountCancelButton;

	@FindBy(xpath = "//button[text()='Delete']")
	public static WebElement roleTableDelete;

	// User Mapping
	@FindBy(css = "img[title='User Mapping']")
	public static WebElement userMappingbutton;

	@FindBy(xpath = "//button[text()='User Documents']")
	public static WebElement userDocuments;

	@FindBy(xpath = "//select[not(contains(@id,'prefix'))]")
	public static List<WebElement> userDocumentsDropdown;

	@FindBy(xpath = "//button[normalize-space()='Admin Process']")
	public static WebElement uMAdminProcessTab;

	@FindBy(xpath = "//button[normalize-space()='Process']")
	public static WebElement uMProcessTab;

	@FindBy(xpath = "//button[normalize-space()='User superior mapping']")
	public static WebElement uMUserSuperiorMappingTab;

	@FindBy(xpath = "//button[normalize-space()='System mapping']")
	public static WebElement uMUserSystemMappingTab;

	@FindBy(linkText = "+ Add Row")
	public static WebElement AddRow;

	@FindBy(xpath = "//tbody//tr//td[1]//select[not(contains(@name,'__prefix__'))]")
	public static List<WebElement> UMProcessNameDropdown;

	@FindBy(xpath = "//td[2]//select[not(contains(@id,'__prefix__'))]")
	public static List<WebElement> UMSubProcessNameDropdown;

	@FindBy(xpath = "//td[3]//select[not(contains(@id,'__prefix__'))]")
	public static List<WebElement> UMSubSubProcessNameDropdown;

	@FindBy(xpath = "//td[4]//select[not(contains(@id,'__prefix__'))]")
	public static List<WebElement> UMStageNameDropdown;

	@FindBy(xpath = "//tr[not(@id='empty_form')]//div//img")
	public static List<WebElement> UMProcessDelete;

	@FindBy(xpath = "//button[text()='Save']")
	public static WebElement UMSaveButton;

	@FindBy(xpath = "//button[text()='User superior mapping ']")
	public static WebElement UserSuperiorMappingTab;

	@FindBy(xpath = "//td[1]//select[not(contains(@name,'prefix'))]")
	public static List<WebElement> USMStagesDropdown;

	@FindBy(xpath = "//td[2]//select[not(contains(@name,'__prefix__'))]")
	public static List<WebElement> USMRoleDropdown;

	@FindBy(xpath = "//td[3]//select[not(contains(@name,'__prefix__'))]")
	public static List<WebElement> USMNameDropdown;

	@FindBy(xpath = "//td[4]//input[not(contains(@name,'__prefix__'))]")
	public static WebElement USMFromDate;

	@FindBy(xpath = "//td[5]//input[not(contains(@name,'__prefix__'))]")
	public static WebElement USMToDate;

	@FindBy(xpath = "//tr[not(@id='empty_form')]//img[not(contains(@class,'edit_delete '))]")
	public static WebElement deleteButton;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public static WebElement continueButton;

	@FindBy(xpath = "//tbody//td//select[not(contains(@name,'__prefix__'))]")
	public static WebElement SMSystemName;

	@FindBy(xpath = "//input[@type='text' and not(contains(@id,'prefix'))]")
	public static WebElement SMSystemValue;

	@FindBy(id = "group_name")
	public static WebElement systemNameInputField;

	@FindBy(xpath = "//button[text()='Create']")
	public static WebElement systemNameSaveButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	public static WebElement systemNameCancelButton;

	@FindBy(xpath = "//img[@alt='rgt_arrow']")
	public static WebElement paginationRightButton;

	@FindBy(xpath = "//a[@id='uploadBtn']")
	public static WebElement userCreateUploadButton;

	@FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
	public static WebElement uploadStagesButton;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public static List<WebElement> uploadStagesOptions;

	@FindBy(xpath = "//input[@id='newOption']")
	public static WebElement uploadNewButton;

	@FindBy(xpath = "//input[@id='updateOption']")
	public static WebElement uploadUpdateButton;

	@FindBy(xpath = "//input[@id='Browse']")
	public static WebElement uploadFileColumn;

	@FindBy(xpath = "//button[text()='Upload']")
	public static WebElement fileUploadButton;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	public static WebElement fileUploadSuccess;

	@FindBy(xpath = "//img[contains(@class,'edit_userdata')]")
	public static List<WebElement> userEdit;

	@FindBy(xpath = "//td[1]")
	public static List<WebElement> userName;

	@FindBy(xpath = "//td[5]")
	public static List<WebElement> userStatus;

	@FindBy(linkText = "Call Log Stage View")
	public static WebElement callLogStageView;

	@FindBy(xpath = "//button[text()='+ Upload System Mapping']")
	public static WebElement uploadSystemMapping;

	@FindBy(xpath = "//select[@id='sys_mapping_search']")
	public static WebElement systemMappingDropdown;

	@FindBy(xpath = "//button[text()='Upload' and @onclick='uploadSysMapFile()']")
	public static WebElement systemMappingUploadButton;

	@FindBy(id = "downloadButton")
	public static WebElement stageFilters;

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
	String userManagementSheetName = "User Management";
	List<String> userCreated = new ArrayList<String>();;

	public ExcelUtils excelToUploadModulePermissions = new ExcelUtils(permissionsfilePath, "Individual Permissions");
	public ExcelUtils excelToUploadViewPermissions = new ExcelUtils(permissionsfilePath, "View Permissions");

	private static void assertElements(WebElement textBox) {
		softAssert.assertTrue(textBox.isEnabled());
		softAssert.assertTrue(textBox.isDisplayed());

	}

	public UserSetupPage navToUserCreatePage() {
		navigateWithinUserSetup(userManagement);
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

		userCreated.add(UserName);

		ExcelWrite.updateExcelWithData(Map.of("User Accounts", userCreated), permissionsfilePath,
				userManagementSheetName);

		return this;

	}

	public UserSetupPage singleGroupSelect(String selectGroup) {
		Select singleGroup = new Select(groupsMultiSelectDropdown);
		singleGroup.selectByVisibleText(selectGroup);
		click(driver, groupsSingleRight);
		return this;
	}

	public UserSetupPage clickOnGroupCreateButton() {
		jsClick(userAccountCreateButton);
		unWait(1);
		roleContinueButton.click();
		return this;
	}

	public UserSetupPage navToRoleAndPerTable() {
		try {
			userSetup.click();
		} catch (NoSuchElementException e) {
			userSetup.click();
			userManagement.click();
		}
		return this;
	}

	public UserSetupPage navToRoleAndPerCreate() {
		navigateWithinUserSetup(roleAndPermissions);
		roleAndPermissionsCreate.click();
//		try {
//			roleAndPermissions.click();
//			roleAndPermissionsCreate.click();
//
//		} catch (NoSuchElementException e) {
//			userSetup.click();
//			roleAndPermissions.click();
//			roleAndPermissionsCreate.click();
//
//		}
		return this;
	}

	public UserSetupPage createRoles(String inputgroupname, String getGroupNameFromExcel, ExcelUtils utils) {
		sendKeys(inputGroupName, inputgroupname);

		Select fromGroupsDrp = new Select(permissionsMultiSelectDropdown);

		List<String> groupsToSelect = utils.getColumnDataByName(getGroupNameFromExcel);

		for (String options : groupsToSelect) {
			fromGroupsDrp.selectByVisibleText(options);
		}

		permissionsSingleRight.click();
		roleCreateButton.click();
		// roleCancelButton.click();
		unWait(2);
		roleContinueButton.click();
		RolesCreated.add(inputgroupname);
		ExcelWrite.updateExcelWithData(Map.of("Roles", RolesCreated), permissionsfilePath, userManagementSheetName);

		// deleteFormByName(inputgroupname);
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

	public UserSetupPage navToUserManagement() {
		actions.moveByOffset(100, 200).click().perform();
		try {
			userManagement.click();
		} catch (NoSuchElementException e) {
			userSetup.click();
			userManagement.click();
		}
		return this;
	}

	/**
	 * @param usernameToDoAction Enter the record name to do the actions, Example to
	 *                           Click on edit ot delete, below method is for Delete
	 * @return for Method Chaining
	 */
	public UserSetupPage userAccountDelete(String usernameToDoAction) {

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameToDoAction.equals(usernameColumn.getText())) {

				WebElement deleteButton = row.findElement(By.xpath("//td//div//img[@alt='delete-icon ']"));
				deleteButton.click();
				roleTableDelete.click();
				unWait(2);
				roleContinueButton.click();
				System.out.println(usernameToDoAction + " User Account Successfully Deleted");
				break;
			}
		}

		return this;
	}

	List<String> recordNames = new ArrayList<>();

	public List<String> fetchRecordNames() {

		userSetup.click();
		userManagement.click();

		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]")); // Adjust the XPath as needed

		for (WebElement row : rows) {
			recordNames.add(row.getText());
		}
		return recordNames;
	}

	public UserSetupPage print() {
		for (String str : recordNames) {
			System.out.println(str);
		}
		return this;

	}

	public UserSetupPage deleteRoleByName(String nameToDelete) {
		navigateWithinUserSetup(roleAndPermissions);

		// Find all rows within the table
		List<WebElement> rows = formsTableBody.findElements(By.tagName("tr"));

		boolean roleFound = false; // Flag to check if the role is found

		try {
			for (WebElement row : rows) {
				if (row.getText().contains(nameToDelete)) { // Use 'contains' for partial match
					// Perform the delete operation
					click(driver, row.findElement(By.cssSelector("img.delete-dataset")));
					roleTableDelete.click();
					unWait(1); // Wait if needed
					roleContinueButton.click();

					System.out.println(nameToDelete + " Role Record Successfully Deleted");
					roleFound = true; // Mark as found
					break;
				}
			}

			if (!roleFound) {
				// Role was not found in the table
				System.out.println("Role with name '" + nameToDelete + "' not found in the table.");
			}

		} catch (NoSuchElementException e) {
			// Handle case where the delete icon or element is not found
			System.out.println("No such element found for role: " + nameToDelete);
			e.printStackTrace(); // Optional: Log the exception stack trace
		}

		return this; // Return the current page object for method chaining
	}

	/*
	 * public UserSetupPage deleteRoleByName( String nameToDelete) {
	 * roleAndPermissions.click(); // Find all rows within the table
	 * List<WebElement> rows = formsTableBody.findElements(By.tagName("tr"));
	 *
	 * for (WebElement row:rows) { if(row.getText().equals(nameToDelete)) {
	 * click(driver,row.findElement(By.cssSelector("img.delete-dataset")));
	 * roleTableDelete.click(); unWait(2); roleContinueButton.click();
	 * System.out.println(nameToDelete+" Role Record Successfully Deleted"); break;
	 * } else {
	 *
	 * } } return this; }
	 */
	public void getRolesName() {
		roleAndPermissions.click();
		List<WebElement> roleNames = driver.findElements(By.xpath("//tr//td[1]"));
		for (WebElement roleName : roleNames) {
			System.out.println(roleName.getText());
		}
	}

	// Method to get the list of entered record names
	public static List<String> getRoles() {

		return RolesCreated;
	}

	public UserSetupPage userLogin(String UserName, String password) {

		driver.get(TestBase.mainURl);
		LoginPage.usernameField.sendKeys(UserName);
		LoginPage.passwordField.sendKeys(password);
		LoginPage.signInButton.click();
		return this;

	}

	public UserSetupPage assertDataset() {
		dataSetup.click();

		isElementVisible(createButton, "Process Create Button is Displayed");
		isElementVisible(processEditButton, "Process Edit Button is Displayed");

		jsClick(processRecords.get(0));
		isElementVisible(processSecondEditButton, "Process Second Process Edit Button is Displayed");

		dataSetTab.click();
		isElementVisible(dataSetCreateButton, "DataSet Create Button is Displayed and Enabled");
		isElementVisible(dataSetEditButton, "DataSet Edit Buttons is Displayed and Enabled");
		isElementVisible(dataSetDeleteButton, "DataSet Delete Buttons is Displayed and Enabled");

		metaDataTab.click();
		isElementVisible(metaDataCreateButton, "MetaData Create Button is Displayed and Enabled");
		isElementVisible(metaDataDeleteButton, "MetaData Delete Buttons is Displayed and Enabled");
		isElementVisible(metaDataEditButton, "MetaData Edit Buttons is Displayed and Enabled");

		softAssert.assertAll();
		return this;

	}

	private boolean isElementVisible(WebElement element, String ErrorMessage) {
		try {

			softAssert.assertFalse(element.isDisplayed(), ErrorMessage);
			softAssert.assertFalse(element.isEnabled(), ErrorMessage);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException | ElementNotInteractableException e) {
			return false;
		}
	}

	public void assertWorkflowDesignPositive() {
		workFlowDesign.click();
		assertTrue(masterParameterTab.isDisplayed());
		assertTrue(measurableSetTab.isDisplayed());
		assertTrue(nonMeasurableTab.isDisplayed());
		assertTrue(dispositionTab.isDisplayed());

		measurableSetTab.click();
		// MeasurableSetPage.createNormalView();
		// NonMeasurableSetPage.createNormalView();
		// Disposition.createNormalView();

	}

	public void dropdownValidation(WebElement Dropdown) {
		Select process = new Select(Dropdown);

		System.out.println("Default Selected Option: " + process.getAllSelectedOptions().get(0).getText());

		assertTrue(process.getOptions().size() > 0);

		System.out.println("Dropdown is Validated");
	}

//	public void selectByVisibleText(WebElement dropdown, String VisibleText)
//	{
//		Select process=new Select(dropdown);
//		process.selectByVisibleText(VisibleText);
//	}

	public UserSetupPage userMappingNav() {

		try {
			userManagement.click();

		} catch (org.openqa.selenium.NoSuchElementException | ElementNotInteractableException e) {
			userSetup.click();
			userManagement.click();
		}

		return this;
	}

	public UserSetupPage userMappingRecord(String usernameToDoAction) {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameToDoAction.equals(usernameColumn.getText())) {
				System.out.println(usernameColumn.getText());
				WebElement UserMappingBtn = row.findElement(By.cssSelector("img[title='User Mapping']"));
				UserMappingBtn.click();
				break;
			}

		}
		return this;
	}

	@FindBy(xpath = "//button[text()='Process ']")
	WebElement UserMappingProcess;

	public UserSetupPage userMappingProcess(String ProcessName, String SubProcessName, String SubSubProcess,
			String Stages) {
		// Adjust timeout as needed
		UserMappingProcess.click();
		jsClick(AddRow);
		selectByVisibleText(UMProcessNameDropdown.get(UMProcessNameDropdown.size() - 1), ProcessName);
		selectByVisibleText(UMSubProcessNameDropdown.get(UMSubProcessNameDropdown.size() - 1), SubProcessName);
		selectByVisibleText(UMSubSubProcessNameDropdown.get(UMSubSubProcessNameDropdown.size() - 1), SubSubProcess);
		selectByVisibleText(UMStageNameDropdown.get(UMStageNameDropdown.size() - 1), Stages);

		/*
		 * try {
		 *
		 * <<<<<<< HEAD // // try { // if(!deleteButton.get(0).isDisplayed()) { //
		 * System.out.println("Rows are already added."); // } // }catch (Exception e) {
		 * // // AddRow.click(); // } // uMProcessTab.click();
		 *
		 * wait.until(ExpectedConditions.visibilityOf(UMProcessNameDropdown)); //
		 * dropdownValidation(UMProcessNameDropdown);
		 * DropDown.dropdownWithAllPosibleValidation(UMProcessNameDropdown, "Select",
		 * ProcessName); // selectByVisibleText(UMProcessNameDropdown, ProcessName);
		 *
		 * // dropdownValidation(UMSubProcessNameDropdown);
		 * wait.until(ExpectedConditions.visibilityOf(UMSubProcessNameDropdown));
		 * Thread.sleep(1000);
		 * DropDown.dropdownWithAllPosibleValidation(UMSubProcessNameDropdown, "Select",
		 * SubProcessName); // selectByVisibleText(UMSubProcessNameDropdown,
		 * SubProcessName);
		 *
		 * // dropdownValidation(UMSubSubProcessNameDropdown); //
		 * selectByVisibleText(UMSubSubProcessNameDropdown, SubSubProcess);
		 * wait.until(ExpectedConditions.visibilityOf(UMSubSubProcessNameDropdown));
		 * Thread.sleep(1000);
		 * DropDown.dropdownWithAllPosibleValidation(UMSubSubProcessNameDropdown,
		 * "Select", SubSubProcess);
		 *
		 * // dropdownValidation(UMStageNameDropdown); //
		 * selectByVisibleText(UMStageNameDropdown, Stages);
		 * wait.until(ExpectedConditions.visibilityOf(UMStageNameDropdown));
		 * Thread.sleep(2000);
		 * DropDown.dropdownWithAllPosibleValidation(UMStageNameDropdown, "Select",
		 * Stages);
		 *
		 * UMSaveButton.click(); unWait(1); continueButton.click();
		 *
		 * return this; }
		 *
		 * public UserSetupPage userMappingUserSuperior(String Stages,String role,String
		 * name) { try { ======= >>>>>>> 113c4e248eaefbff61444a63f35824325884da76 if
		 * (!deleteButton.isDisplayed()) {
		 * System.out.println("Rows are already added."); } } catch (Exception e) {
		 *
		 * AddRow.click();// Handle other exceptions if necessary e.printStackTrace(); }
		 */

		UMSaveButton.click();

		try {
			unWait(1);
			continueButton.click();
		} catch (Exception e) {
			System.out.println("Continue button was not displayed");
		}

		return this;
	}

	@FindBy(xpath = "//button[text()='User superior mapping ']")
	WebElement userSuperiorMappingTab;

	public UserSetupPage userMappingUserSuperior(String Stages, String role, String name) {
		jsClick(userSuperiorMappingTab);
		jsClick(AddRow);

		/*
		 * try { if (!deleteButton.isDisplayed()) {
		 * System.out.println("Rows are already added."); } } catch (Exception e) {
		 *
		 * AddRow.click();// Handle other exceptions if necessary e.printStackTrace(); }
		 */

//		UserSuperiorMappingTab.click();
//		dropdownValidation(USMStagesDropdown);
		selectByVisibleText(USMStagesDropdown.get(USMStagesDropdown.size() - 1), Stages);

//		dropdownValidation(USMRoleDropdown);
		selectByVisibleText(USMRoleDropdown.get(USMRoleDropdown.size() - 1), role);

//		dropdownValidation(USMNameDropdown);
		selectByVisibleText(USMNameDropdown.get(USMNameDropdown.size() - 1), name);

//		USMFromDate.sendKeys("02-07-2024");
//		sendKeys(USMFromDate, "02-07-2024");
//		USMToDate.sendKeys("06-07-2024");
//		sendKeys(USMToDate, "06-07-2024");

		UMSaveButton.click();
		try {
			unWait(1);
			continueButton.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}

	public UserSetupPage systemMapping(String visibleText, String value) {
		systemMappingTab.click();
		selectByVisibleText(SMSystemName, visibleText);
		SMSystemValue.sendKeys(value);
		saveRecord();
		return this;
	}

	public UserSetupPage navToSysNames() {
		try {
			systemNames.click();
		} catch (NoSuchElementException e) {
			userSetup.click();
			systemNames.click();
		}
		return this;
	}

	// --------System Names-------------
	public UserSetupPage systemNames(String systemName) {
		createButton.click();
		systemNameInputField.sendKeys(systemName);
		systemNameSaveButton.click();
		unWait(1);
		continueButton.click();

		return this;

	}

	public UserSetupPage deleteSystemNames(String systemNames) {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
		for (WebElement row : rows) {
			if (row.getText().equals(systemNames)) {
				click(driver, row.findElement(By.cssSelector("img.delete-dataset")));
				roleTableDelete.click();
				unWait(2);
				roleContinueButton.click();
				System.out.println(systemNames + "  Record Successfully Deleted");

				break;
			}
		}
		return this;
	}

	// Reading WebTables And Adding in
	List<String> userAcount = new ArrayList<String>();
	List<String> role = new ArrayList<>();

	public void getUserAccounts() {
		userSetup.click();
		userManagement.click();
		do {
			List<WebElement> records = driver.findElements(By.xpath("//td[1]"));
			for (WebElement record : records) {
				userAcount.add(record.getText());

			}

			jsClick(paginationRightButton);
//		roleAndPermissions.click();
//
//		List<WebElement>roles=driver.findElements(By.xpath("//td[1]"));
//		for(WebElement record:roles)
//		{
//			role.add(record.getText());
//
//		}
//		ExcelWrite.updateExcelWithData(Map.of("Roles",role), permissionsfilePath, "Already Existing Records");
		} while (paginationRightButton.isEnabled());
		{

		}
		ExcelWrite.updateExcelWithData(Map.of("User Accounts", userAcount), permissionsfilePath,
				"Already Existing Records");

	}

	String user_data = System.getProperty("user.dir") + "\\Upload Files\\user_data.xlsx";
	public ExcelUtils uploadToCreateUser = new ExcelUtils(user_data, "Users");

	public UserSetupPage userUpload() {
		userCreateUploadButton.click();
		uploadStagesButton.click();
		uploadStagesOptions.get(0).click();

		uploadNewButton.click();
		uploadFileColumn.sendKeys(user_data);

		fileUploadButton.click();
		List<String> userNames = uploadToCreateUser.getColumnDataByName("User Name");
		for (String userName : userNames) {
			System.out.println(userName);
		}

		assertEquals(userNames.get(0), roleTableNames.get(3).getText());

		return this;
	}

	public void endToEnd() {
		navToUserManagement().userMappingRecord("James@wyzmindz.com")
				.userMappingProcess("AJP", "Sub AJP", "Sub Sub AJP", "Stage James")
				.userMappingUserSuperior("Stage James", "QA", "James@wyzmindz.com").systemMapping("James", "Paul");
	}

	public UserSetupPage cloudSystemMapping() {
		navigateWithinUserSetup(userManagement);
		uploadSystemMapping.click();
		selectByVisibleText(systemMappingDropdown, "");

		return this;
	}

//**********User Management Negative Test Script****************

	@FindBy(id = "user_name-error")
	WebElement userNameError;

	@FindBy(id = "password-error")
	WebElement passwordError;

	@FindBy(xpath = "//label[@id='confirm_password-error']")
	WebElement confirmPasswordError;

	@FindBy(id = "email-error")
	WebElement emailError;

	public void userCreationFieldsNeg(String userName, String firstName, String lastname, String email,
			String password) {

		navigateWithinUserSetup(userManagement);
		userManagementCreateButton.click();
		inputUserName.sendKeys(userName);

		inputEmail.sendKeys(email);

		inputPassword.sendKeys(password);
		inputConfirmPassword.sendKeys(password);
		inputConfirmPassword.click();
		inputConfirmPassword.sendKeys("i");
		inputFirstName.sendKeys(firstName);
		inputLastName.sendKeys(lastname);

		softAssert.assertTrue(isElementDisplayed(userNameError));
		softAssert.assertTrue(isElementDisplayed(emailError));
		softAssert.assertTrue(isElementDisplayed(passwordError));
		softAssert.assertTrue(isElementDisplayed(confirmPasswordError));
		softAssert.assertAll();

	}

	private boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + element);
			return false;
		} catch (Exception e) {
			System.out.println("An unexpected exception occurred: " + e.getMessage());
			return false;
		}

	}

	public UserSetupPage userWithOutPermission(String userName, String firstName, String lastname, String email,
			String password) {

		navigateWithinUserSetup(userManagement);
		userManagementCreateButton.click();
		inputUserName.sendKeys(userName);
		inputFirstName.sendKeys(firstName);
		inputLastName.sendKeys(lastname);
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		inputConfirmPassword.sendKeys(password);
		jsClick(roleCreateButton);
		unWaitInMilli(500);
		continueButton.click();

		driver.get(mainURl);

		userLogin(userName, password);
		assert isElementDisplayed(LoginPage.signInButton);

		return this;
	}

	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement errorMessage;

	public UserSetupPage cloudUpload(String selectStage, String uploadFile) {
		navigateWithinUserSetup(userManagement);
		userManagementCreateCloudUpload.click();
		selectByVisibleText(userManagementUploadStagesDropdown, selectStage);
		uploadNewButton.click();
		uploadFileColumn.sendKeys(uploadFile);
		fileUploadButton.click();
		unWait(1);
		assertFalse(isElementDisplayed(fileUploadSuccess));
//		Should put Validation for Error Message, the is not throwing any error message, its just Buffering

		return this;
	}

	public UserSetupPage Inactivate(String password) {
		navigateWithinUserSetup(userManagement);
		String UserName = userName.get(0).getText();
		String status = userStatus.get(0).getText();

		try {
			if (status.equals("Active")) {
				userEdit.get(0).click();
				sendKeys(inputPassword, password);
				sendKeys(inputConfirmPassword, password);
				activeCheckBox.click();
				jsClick(userUpdate);
				userLogin(UserName, password);
				assertTrue(LoginPage.signInButton.isDisplayed());
			} else {
				userLogin(UserName, password);
				assertTrue(LoginPage.signInButton.isDisplayed());
			}

		} catch (NoSuchElementException e) {

		}
		return this;
	}

	public UserSetupPage noPermissionEdit(String password) {
		navigateWithinUserSetup(userManagement);
		String UserName = userName.get(0).getText();
		String status = userStatus.get(0).getText();
		userEdit.get(0).click();

		sendKeys(inputPassword, password);
		sendKeys(inputConfirmPassword, password);

		if (status.equals("Inactive")) {
			activeCheckBox.click();
		}
		jsClick(groupsAllLeft);
		jsClick(userUpdate);

		userLogin(UserName, password);
		assert LoginPage.signInButton.isDisplayed();

		return this;
	}

	public UserSetupPage negativeRole(String password, String role) {
		navigateWithinUserSetup(userManagement);
		String UserName = userName.get(0).getText();
		String status = userStatus.get(0).getText();
		userEdit.get(0).click();

		sendKeys(inputPassword, password);
		sendKeys(inputConfirmPassword, password);

		if (status.equals("Inactive")) {
			activeCheckBox.click();
		}

		jsClick(groupsAllLeft);

		singleGroupSelect(role);
		jsClick(userUpdate);

		userLogin(UserName, password);
		assert callLogStageView.isDisplayed();
		assertFalse(validateUserSetupElements());

		return this;
	}

	private boolean validateUserSetupElements() {
		try {
			userSetup.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			System.out.println("Element not found");
			return false;
		}

	}

	public UserSetupPage roleCreate(String groupName) {
		navigateWithinUserSetup(roleAndPermissions);
		createButton.click();
		inputGroupName.sendKeys(groupName);
		jsClick(roleCreateButton);
		assert groupNameError.isDisplayed();
		return this;
	}

	public UserSetupPage createInvalidSystemNames(String SystemNames) {
		navigateWithinUserSetup(systemNames);
		createButton.click();
		systemNameInputField.sendKeys(SystemNames);
		roleCreateButton.click();
		unWait(1);
		assertFalse(continueButton.isDisplayed());
		if (continueButton.isDisplayed()) {
			jsClick(continueButton);
		}
		return this;
	}

	public UserSetupPage editSystemNames(String systemNames) {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
		for (WebElement row : rows) {
			if (row.getText().equals(systemNames)) {
				click(driver, row.findElement(By.xpath(".//img[contains(@class,'edit_systemdata')]")));

				System.out.println(systemNames + "  Record Successfully Click ");

				break;
			}
		}
		return this;
	}

	public UserSetupPage editSystemNameWithInvalidInputs(String systemNamesRecord, String editSystemNames) {
		navigateWithinUserSetup(systemNames);
		editSystemNames(systemNamesRecord);
		sendKeys(systemNameInputField, editSystemNames);
		userUpdate.click();
		unWait(1);
		assertFalse(continueButton.isDisplayed());
		if (continueButton.isDisplayed()) {
			jsClick(continueButton);
		}
		return this;
	}

	@FindBy(xpath = "//td[1]")
	WebElement stageFilterUserName;

	public UserSetupPage StagesFilter(String userName) {
		jsClick(stageFilters);
		searchBox.sendKeys(userName);
		searchButton.click();
		assert stageFilterUserName.getText().equals(userName);

		return this;
	}

	@FindBy(xpath = "//td[10]")
	List<WebElement> roles;

	public UserSetupPage searchRole(String role) {
		jsClick(stageFilters);
		selectByVisibleText(roleDropdown, role);
		searchButton.click();
		assert roles.get(0).getText().equals(role);
		return this;
	}

	@FindBy(xpath = "//td[11]")
	List<WebElement> superiorName;

	public UserSetupPage superiorName(String role) {

		selectByVisibleText(superiorDropdown, role);
		searchButton.click();
		assertEquals(role, superiorName.get(0).getText());
		return this;
	}

	@FindBy(xpath = "//td[5]")
	List<WebElement> status;

	public UserSetupPage status(String role) {
		jsClick(stageFilters);
		selectByVisibleText(statusDropdown, role);
		searchButton.click();
		assertEquals(role, status.get(0).getText());
		return this;
	}

	public UserSetupPage dropdownSearch(String role, String superiorRole, String statusRole) {
		jsClick(stageFilters);
		selectByVisibleText(roleDropdown, role);
		selectByVisibleText(superiorDropdown, superiorRole);
		selectByVisibleText(statusDropdown, statusRole);

		searchButton.click();

		softAssert.assertEquals(role, roles.get(0).getText());
		softAssert.assertEquals(superiorRole, superiorName.get(0).getText());
		softAssert.assertEquals(statusRole, status.get(0).getText());
		softAssert.assertAll();
		return this;
	}

	@FindBy(xpath = "//td[9]")
	WebElement stageName;

	@FindBy(xpath = "//td[8]")
	WebElement subSubProcess;

	@FindBy(xpath = "//td[7]")
	WebElement subProcess;

	@FindBy(xpath = "//td[6]")
	WebElement process;

	public UserSetupPage searchProcess(String processValue, String subProcessValue, String subSubProcessValue,
			String stageValue) {

		jsClick(stageFilters);

		selectByVisibleText(searchProcessDropdown, processValue);
		selectByVisibleText(searchSubProcessDropdown, subProcessValue);
		selectByVisibleText(searchSubSubProcessDropdown, subSubProcessValue);
		selectByVisibleText(stageDropdown, stageValue);

		searchButton.click();

		softAssert.assertEquals(process.getText(), processValue);
		softAssert.assertEquals(subProcess.getText(), subProcessValue);
		softAssert.assertEquals(subSubProcess.getText(), subSubProcessValue);
		softAssert.assertEquals(stageName.getText(), stageValue);

		softAssert.assertAll();
		return this;
	}

	public UserSetupPage stageWithFilters(String userName, String superiorRole, String statusRole, String processValue,
			String subProcessValue, String subSubProcessValue, String stageValue) {
		navigateWithinUserSetup(userManagement);
		jsClick(stageFilters);

		softAssert.assertEquals(userName, stageFilterUserName.getText());

		softAssert.assertEquals(superiorRole, superiorName.get(0).getText());
		softAssert.assertEquals(statusRole, status.get(0).getText());

		softAssert.assertEquals(process.getText(), processValue);
		softAssert.assertEquals(subProcess.getText(), subProcessValue);
		softAssert.assertEquals(subSubProcess.getText(), subSubProcessValue);
		softAssert.assertEquals(stageName.getText(), stageValue);

		softAssert.assertAll();

		return this;
	}

	@FindBy(xpath = "//a[text()='Export']")
	WebElement exportButton;

	public UserSetupPage testExport(String userName) {
		jsClick(stageFilters);
		searchBox.sendKeys(userName);
		searchButton.click();

		// Click the export button to download the Excel file
		exportButton.click();

		// Locate the most recent Excel file in the Downloads folder
		File downloadedFile = waitForDownloadedFile("xlsx");

		// Retrieve all records from CRM table
		List<List<String>> crmData = new ArrayList<>();
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr")); // Locate rows within table
		for (WebElement row : rows) {
			List<String> rowData = new ArrayList<>();
			List<WebElement> cells = row.findElements(By.xpath(".//td")); // Locate cells within each row
			for (WebElement cell : cells) {
				rowData.add(cell.getText());
			}
			crmData.add(rowData);
		}

		// Read Excel file and compare data
		try (FileInputStream fis = new FileInputStream(downloadedFile);
				Workbook workbook = WorkbookFactory.create(fis)) {

			Sheet sheet = workbook.getSheetAt(0);
			List<List<String>> excelData = new ArrayList<>();

			for (Row row : sheet) {
				List<String> rowData = new ArrayList<>();
				row.forEach(cell -> rowData.add(cell.toString()));
				excelData.add(rowData);
			}

			// Compare CRM data and Excel data
			assert crmData.equals(excelData) : "Data mismatch between CRM table and exported Excel file!";
			System.out.println("All records match between CRM and Excel file.");
		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file", e);
		}
		return this;
	}

	// Method to get the most recently downloaded .xlsx file in the Downloads folder
	private static File waitForDownloadedFile(String extension) {
		String downloadPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		File dir = new File(downloadPath);

		// Wait until file is downloaded
		File[] files;
		do {
			files = dir.listFiles((d, name) -> name.toLowerCase().endsWith("." + extension));
			if (files != null && files.length > 0) {
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
				return files[0]; // Return the most recently modified file
			}
			try {
				Thread.sleep(1000); // Pause to allow file to complete download
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RuntimeException("File download interrupted", e);
			}
		} while (files == null || files.length == 0);

		throw new RuntimeException("Downloaded file not found.");
	}

//##########################################################################################################################################################
//##########################################################################################################################################################
//#######################################GOPAL#####################################################################################################
//##########################################################################################################################################################
//##########################################################################################################################################################

	@FindBy(xpath = "//a[@id='menulist1']")
	WebElement userSetupModule;

	@FindBy(linkText = "User Management")
	public WebElement userManagementPageButton;

	@FindBy(linkText = "Role & Permissions")
	public WebElement rolePermissionsPageButton;

	@FindBy(linkText = "System Names")
	public WebElement systemNamesPageButton;

	@FindBy(linkText = "+ Create User")
	public WebElement createUserbutton;

	@FindBy(xpath = "//button[normalize-space()='Admin Process']")
	WebElement adminProcessSection;

	@FindBy(xpath = "//button[normalize-space()='Process']")
	WebElement processSection;

	@FindBy(xpath = "//a[text()='+ Add Row']")
	WebElement addRowOption;

	@FindBy(xpath = "//button[contains(@class,'btn-primary')][text()='Save']")
	WebElement mappingSaveButton;

	@FindBy(xpath = "(//h3/..//span['Created Successfully'])[1]")
	WebElement userSuccessPopUp;

	@FindBy(xpath = "(//h3/..//span['Created Successfully']/..//button[text()='Continue'])[1]")
	WebElement userContinueButton;

	@FindBy(id = "exampleInputPassword1")
	WebElement searchField;

	public UserSetupPage navToUserSetUp(String pageName) {
		click(driver, userSetupModule);

		switch (pageName.toLowerCase()) {
		case "management":
			click(driver, userManagementPageButton);
			break;
		case "role and permission":
			click(driver, rolePermissionsPageButton);
			break;
		case "system names":
			click(driver, systemNamesPageButton);
			break;
		default:
			throw new IllegalArgumentException("Invalid page name: " + pageName);
		}

		return this;
	}

	public UserSetupPage createNewUser() {

		click(driver, createUserbutton);

		FieldVerificationUtils.verifyTextArea(inputUserName, "Gopal1234", false);
		FieldVerificationUtils.verifyTextArea(inputFirstName, "Gopal", false);
		FieldVerificationUtils.verifyTextArea(inputLastName, "Reddy", false);
		FieldVerificationUtils.verifyTextArea(inputEmail, "gopalreddy12@gmail.com", false);
		FieldVerificationUtils.verifyTextArea(inputPassword, "Qwerty@123", false);
		FieldVerificationUtils.verifyTextArea(inputConfirmPassword, "Qwerty@123", false);

		return this;
	}

	/*
	 * 
	 * Admin
	 * 
	 * Agent
	 * 
	 * CE Head
	 * 
	 * CRC Admin
	 * 
	 * Complaint Desk
	 * 
	 * DSE
	 * 
	 * Drivingschool
	 * 
	 * Insurance
	 * 
	 * Manager
	 * 
	 * QA
	 * 
	 * QAADMIN
	 * 
	 * Sales
	 * 
	 * Service
	 * 
	 * SuperAdmin
	 * 
	 * Team Lead
	 * 
	 * Usedcar
	 * 
	 */

	public UserSetupPage selectGroup(String groupName) {
		WebElement multiSelect = driver.findElement(By.id("multiselect_group"));
		Select select = new Select(multiSelect);

		try {
			select.selectByVisibleText(groupName);
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Invalid group name: " + groupName);
		}

		return this;
	}

	// Method to load properties file
	private Properties loadProperties(String propertiesFilePath) {
		Properties properties = new Properties();
		try (FileInputStream fileInput = new FileInputStream(propertiesFilePath)) {
			properties.load(fileInput);
		} catch (IOException e) {
			throw new RuntimeException("Error loading properties file", e);
		}
		return properties;
	}

	String path = getClass().getClassLoader().getResource("permissions.properties").getPath();

//	public UserSetupPage selectPermissions(String selection) {
//		Properties properties = loadProperties(path);
//
//		// Split the input string by comma and trim spaces
//		List<String> keys = Arrays.stream(selection.split(",")).map(String::trim).filter(s -> !s.isEmpty()) // Ignore
//																											// empty
//																											// entries
//				.collect(Collectors.toList());
//
//		Set<String> allPermissions = new LinkedHashSet<>(); // Preserve order, avoid duplicates
//
//		for (String key : keys) {
//			// Check if the key is a group defined in the properties file
//			String value = properties.getProperty(key);
//			if (value != null) {
//				// Key is a group; add all associated permissions
//				List<String> perms = Arrays.stream(value.split(",")).map(String::trim).filter(s -> !s.isEmpty())
//						.collect(Collectors.toList());
//				allPermissions.addAll(perms);
//			} else {
//				// Key is not a group; treat it as an individual permission
//				allPermissions.add(key);
//			}
//		}
//
//		// Select each permission in the UI
//		for (String permission : allPermissions) {
//			try {
//				WebElement option = driver
//						.findElement(By.xpath("//select[@id='multiselect']/option[text()='" + permission + "']"));
//				if (!option.isSelected()) {
//					option.click();
//				}
//			} catch (NoSuchElementException e) {
//				throw new IllegalArgumentException("Permission not found in UI: " + permission, e);
//			}
//		}
//
//		return this;
//	}

	public UserSetupPage clickSideButton(String section, String buttonType) {
		String prefix;

		switch (section.toLowerCase()) {
		case "group":
			prefix = "multiselect_group_";
			break;
		case "permission":
			prefix = "multiselect_";
			break;
		default:
			throw new IllegalArgumentException("Invalid section: " + section);
		}

		String buttonId;

		switch (buttonType.toLowerCase()) {
		case "rightall":
			buttonId = prefix + "rightAll";
			break;
		case "rightselected":
			buttonId = prefix + "rightSelected";
			break;
		case "leftselected":
			buttonId = prefix + "leftSelected";
			break;
		case "leftall":
			buttonId = prefix + "leftAll";
			break;
		default:
			throw new IllegalArgumentException("Invalid button type: " + buttonType);
		}

		WebElement button = driver.findElement(By.id(buttonId));
		jsClick(button);

		return this;
	}

//	################################################################################

	public UserSetupPage createMultipleUsers(int numberOfUsers, List<String> customGroups, List<String> permissionsList,
			boolean create) {
		Properties userProps = new Properties(); // Fresh Properties object each time
		Faker faker = new Faker();

// Use customGroups if provided and not empty, otherwise fallback to default groups
		List<String> groups = (customGroups != null && !customGroups.isEmpty()) ? customGroups
				: Arrays.asList("Admin", "Agent", "CE Head", "CRC Admin", "Complaint Desk", "DSE", "Drivingschool",
						"Insurance", "Manager", "QA", "QAADMIN", "Sales", "Service", "SuperAdmin", "Team Lead",
						"Usedcar");

// Ensure permissionsList is not null or empty; fallback to a default if needed
		List<String> permissionsToUse = (permissionsList != null && !permissionsList.isEmpty()) ? permissionsList
				: Arrays.asList("Agent"); // Default to "Agent" permissions if none provided

		for (int i = 1; i <= numberOfUsers; i++) {
			String username = faker.name().username() + i;
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = username + "@example.com";
			String password = "Pass@" + faker.number().digits(4);
			String confirmPassword = password;

// Get group based on index (loop back using modulo if users > groups)
			String groupName = groups.get((i - 1) % groups.size());

// Get permissions for this user (cycle through permissionsList if needed)
			String permissions = permissionsToUse.get((i - 1) % permissionsToUse.size());

			click(driver, createUserbutton);

			FieldVerificationUtils.verifyTextArea(inputUserName, username, false);
			FieldVerificationUtils.verifyTextArea(inputFirstName, firstName, false);
			FieldVerificationUtils.verifyTextArea(inputLastName, lastName, false);
			FieldVerificationUtils.verifyTextArea(inputEmail, email, false);
			FieldVerificationUtils.verifyTextArea(inputPassword, password, false);
			FieldVerificationUtils.verifyTextArea(inputConfirmPassword, confirmPassword, false);

// Select the group
			selectGroup(groupName);
			clickSideButton("group", "rightselected");

// Select permissions (group name or specific permissions)
			selectPermissions(permissions);
			clickSideButton("permission", "rightselected");

			if (create) {
				clickOnGroupCreateButton();
			}

// Store user credentials and group info
			userProps.setProperty("user" + i + ".username", username);
			userProps.setProperty("user" + i + ".password", password);
			userProps.setProperty("user" + i + ".group", groupName);
			userProps.setProperty("user" + i + ".permissions", permissions);
		}

// Define the file path
		String filePath = "src/test/resources/DynamicUsers.properties";

// Optionally delete the file if it exists to ensure a fresh start
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}

// Save user data to properties file (overwrites existing file)
		try (FileOutputStream output = new FileOutputStream(filePath)) {
			userProps.store(output, "Generated Users using Faker and Group Assignment");
		} catch (IOException e) {
			throw new RuntimeException("Failed to store user properties", e);
		}

		return this;
	}

//Updated method to select permissions by group name or specific permission
	public UserSetupPage selectPermissions(String selection) {
		Properties properties = loadProperties(path);

// Split the input string by comma and trim spaces
		List<String> selections = Arrays.stream(selection.split(",")).map(String::trim).collect(Collectors.toList());

		Set<String> allPermissions = new LinkedHashSet<>(); // Preserve order and avoid duplicates

		for (String item : selections) {
// Check if the item is a group key in the properties file
			String value = properties.getProperty(item);
			if (value != null) {
// Item is a group (e.g., "Agent", "QA"); split its permissions
				List<String> perms = Arrays.asList(value.split(",\\s*"));
				allPermissions.addAll(perms);
			} else {
// Item is a specific permission (e.g., "Can Create Dataset")
				allPermissions.add(item);
			}
		}

// Select each permission in the UI
		for (String permission : allPermissions) {
			try {
				WebElement option = driver
						.findElement(By.xpath("//select[@id='multiselect']/option[text()='" + permission + "']"));
				option.click();
			} catch (NoSuchElementException e) {
				throw new IllegalArgumentException("Permission not found in UI: " + permission);
			}
		}

		return this;
	}

	/*
	 * clickUserActionIcon("lucina.mayert2", "edit"); // Clicks edit icon
	 * clickUserActionIcon("lucina.mayert2", "delete"); // Clicks delete icon
	 * clickUserActionIcon("lucina.mayert2", "map"); // Clicks mapping
	 */
	public void clickUserActionIcon(String username, String actionType) {
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr[td]")); // only rows with <td>

		for (WebElement row : rows) {
			WebElement usernameCell;
			try {
				usernameCell = row.findElement(By.xpath("./td[1]"));
			} catch (NoSuchElementException e) {
				continue; // Skip if <td[1]> not found
			}

			if (usernameCell.getText().trim().equals(username)) {
				WebElement targetElement = null;

				try {
					switch (actionType.toLowerCase()) {
					case "edit":
						targetElement = row.findElement(By.cssSelector(".edit_userdata"));
						break;
					case "delete":
						targetElement = row.findElement(By.cssSelector(".delete_groupdata"));
						break;
					case "map":
						targetElement = row.findElement(By.xpath(".//a[img[@title='User Mapping']]"));
						System.out.println(targetElement);
						break;
					default:
						throw new IllegalArgumentException("Invalid action type: " + actionType);
					}

					if (targetElement != null) {
						// Scroll only if needed (optional)
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
								targetElement);
						targetElement.click(); // use normal click first
						System.out.println(actionType + " clicked for user: " + username);
					}

				} catch (Exception e) {
					System.err.println("Failed to click " + actionType + " for user: " + username);
					e.printStackTrace();
				}

				break; // Stop after finding the match
			}
		}
	}

	public boolean isProcessSelected(String processName) {

		click(driver, adminProcessSection);

		List<WebElement> processDropdowns = driver.findElements(By.cssSelector("select[name$='-process_id']"));
		for (WebElement dropdown : processDropdowns) {
			Select select = new Select(dropdown);
			WebElement selectedOption = select.getFirstSelectedOption();
			if (selectedOption.getText().trim().equalsIgnoreCase(processName)) {
				click(driver, processSection);

				return true; // "DemoG P" is selected in at least one dropdown
			}
		}
		return false; // Not selected in any
	}

	public UserSetupPage verifyMappingForAllUsers() {

		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream("src/test/resources/DynamicUsers.properties")) {
			props.load(fis);

			// Get all property keys
			Set<Object> keys = props.keySet();

			// Loop through all usernames
			for (Object key : keys) {
				String keyStr = key.toString();

				// We only care about keys like user1.username, user2.username
				if (keyStr.endsWith(".username")) {
					String username = props.getProperty(keyStr).trim();
					searchTheUser(username);
					clickUserActionIcon(username, "map");
					String processValue = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
					assertTrue(isProcessSelected(processValue), "process is not available in admin process section.");

					String subProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subprocess");
					String subSubProcessValue = PropertieFileUtil.getSingleTextFromPropertiesFile("subsubProcess");
					String stages = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
					selectProcessHierarchy(processValue, subProcessValue, subSubProcessValue, stages);

					saveAndConfirmation();
					click(driver, userManagementPageButton);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return this;
	}

	public void searchTheUser(String userName) {

		assertTrue(searchField.isDisplayed(), "searchField is not displayed.");

		SendDataUtils.clearAndSendKeys(searchField, userName);

		String xpath = String.format("//td[normalize-space()='%s']", userName);
		WebElement searchedUserName = driver.findElement(By.xpath(xpath));
		assertTrue(searchedUserName.isDisplayed(), "searchedUserName is not displayed.");

	}

	public void selectProcessHierarchy(String process, String subProcess, String subSubProcess, String stage) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		List<WebElement> emptyFormRow = driver.findElements(By.xpath("//tr[@class='form_set empty_form_tr']"));

		if (!emptyFormRow.isEmpty() && emptyFormRow.get(0).isDisplayed()) {
			throw new IllegalStateException("Row already exists: 'form_set empty_form_tr' is visible.");
		} else {
			addRowOption.click();
		}

		String rowPrefix = "form-0";

		// Process
		Select processDropdown = new Select(driver.findElement(By.id("id_" + rowPrefix + "-process_id")));
		processDropdown.selectByVisibleText(process);
		waitUntilOptionsPopulated(By.id("id_" + rowPrefix + "-sub_process_id"), wait);

		// Sub Process
		Select subProcessDropdown = new Select(driver.findElement(By.id("id_" + rowPrefix + "-sub_process_id")));
		subProcessDropdown.selectByVisibleText(subProcess);
		waitUntilOptionsPopulated(By.id("id_" + rowPrefix + "-s_sub_process_id"), wait);

		// Sub Sub Process
		Select subSubProcessDropdown = new Select(driver.findElement(By.id("id_" + rowPrefix + "-s_sub_process_id")));
		subSubProcessDropdown.selectByVisibleText(subSubProcess);
		waitUntilOptionsPopulated(By.id("id_" + rowPrefix + "-stage_id"), wait);

		// Stage
		Select stageDropdown = new Select(driver.findElement(By.id("id_" + rowPrefix + "-stage_id")));
		stageDropdown.selectByVisibleText(stage);

		System.out.println("Process hierarchy selected successfully.");
	}

	private void waitUntilOptionsPopulated(By locator, WebDriverWait wait) {
		wait.until(driver -> {
			WebElement dropdown = driver.findElement(locator);
			Select select = new Select(dropdown);
			return select.getOptions().size() > 1; // "Select" + real options
		});
	}

	public UserSetupPage saveAndConfirmation() {

		click(driver, mappingSaveButton);
		wait.until(ExpectedConditions.visibilityOf(userSuccessPopUp));
		assertTrue(userSuccessPopUp.isDisplayed(), "userSuccessPopUp is not displayed.");
		assertTrue(userContinueButton.isDisplayed(), "userContinueButton is not displayed.");

		userContinueButton.click();

		return this;
	}

}
