package com.advaita.pageObjects;

import Advaita_TDD.Advaita_TDD.FakeData;
import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.LoginPage;
import com.advaita.Utilities.ExcelUtils;
import com.advaita.Utilities.ExcelWrite;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserSetupPage extends TestBase {


	@FindBy(xpath  = "//span[text()='Data Setup']")
	WebElement dataSetup;

	@FindBy(linkText  = "+ Create")
	WebElement createButton;

	@FindBy(xpath  = "//tbody//img[@alt='table-edit']")
	WebElement processEditButton;

	@FindBy(xpath  = "//div[@class='content pl_9']")
	List<WebElement> processRecords;

	@FindBy(xpath  = "//tbody//td[contains(@class,'second_tree')]//img")
	WebElement processSecondEditButton;

	@FindBy(id  = "pills-dataset-tab")
	WebElement dataSetTab;

	@FindBy(linkText  = "+ Create")
	WebElement dataSetCreateButton;

	@FindBy(xpath  = "//table[@class='w-100']//tbody//td[1]")
	WebElement dataSetRecords;

	@FindBy(xpath  = "//img[@id='id_delete']")
	WebElement dataSetDeleteButton;

	@FindBy(xpath  = "//img[@alt='table-edit']")
	WebElement dataSetEditButton;

	@FindBy(id  = "pills-metadata-tab")
	WebElement metaDataTab;

	@FindBy(xpath  = "//table[@class='w-100']//tbody//td[1]")
	WebElement metaDataRecords;

	@FindBy(linkText  = "+ Create")
	WebElement metaDataCreateButton;

	@FindBy(xpath  = "//img[@alt='delete-icon ']")
	WebElement metaDataDeleteButton;

	@FindBy(xpath  = "//tr//img[@alt='table-edit']")
	WebElement metaDataEditButton;

	@FindBy(xpath  = "//span[text()='Workflow Design']")
	WebElement workFlowDesign;


	@FindBy(id  = "pills-MasterParameter-tab")
	WebElement masterParameterTab;

	@FindBy(id  = "pills-MeasurableSet-tab")
	WebElement measurableSetTab;

	@FindBy(linkText  = "+ Add Measurable Set")
	WebElement measurableCreateButton;

	@FindBy(xpath  = "//img[@alt='delete-icon ']")
	List<WebElement> measurableDeleteButton;

	@FindBy(xpath  = "//img[@alt='table-edit' and contains(@class,'edit-measurable')]")
	List<WebElement> measurableEditButton;

	@FindBy(xpath  = "//a//img[@alt='table-edit' and contains(@class,'delete-dataset')]")
	List <WebElement> measurableUpload1Button;

	@FindBy(xpath  = "//img[@alt='table-edit' and not(contains(@class,'delete-dataset'))and @data-info]")
	List <WebElement> measurableUpload2Button;

	@FindBy(xpath  = "//img[contains(@class,'copy_question')]")
	List <WebElement> measurableDuplicateButton;

	@FindBy(id  = "pills-NonMeasurableSet-tab")
	WebElement nonMeasurableTab;

	@FindBy(linkText  = "+ Add Non Measurable Set")
	WebElement nonMeasurableCreateButton;

	@FindBy(xpath  = "//img[@alt='delete-icon ']")
	List<WebElement> nonMeasurableDeleteButton;

	@FindBy(xpath  = "//img[@alt='table-edit' and contains(@class,'edit-measurable')]")
	List<WebElement> nonMeasurableEditButton;

	@FindBy(xpath  = "//a//img[@alt='table-edit' and contains(@class,'delete-dataset')]")
	List <WebElement> nonMeasurableUpload1Button;

	@FindBy(xpath  = "//img[@alt='table-edit' and not(contains(@class,'delete-dataset'))and @data-info]")
	List <WebElement> nonMeasurableUpload2Button;

	@FindBy(xpath  = "//img[contains(@class,'copy_question')]")
	List <WebElement> nonMeasurableDuplicateButton;

	@FindBy(id  = "pills-Disposition-tab")
	WebElement dispositionTab;

	@FindBy(linkText  = "+ Add Disposition")
	WebElement dispositionCreateButton;

	@FindBy(xpath  = "//img[@alt='delete-icon ']")
	List<WebElement> dispositionDeleteButton;

	@FindBy(xpath  = "//img[@alt='table-edit' and contains(@class,'edit-measurable')]")
	List<WebElement> dispositionEditButton;



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

	@FindBy(linkText = "+ Create User")
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


	// User Mapping
	@FindBy(css="img[title='User Mapping']")
	WebElement userMappingbutton;

	@FindBy(xpath="//button[normalize-space()='Admin Process']")
	WebElement uMAdminProcessTab;

	@FindBy(xpath="//button[normalize-space()='Process']")
	WebElement uMProcessTab;

	@FindBy(xpath="//button[normalize-space()='User superior mapping']")
	WebElement uMUserSuperiorMappingTab;

	@FindBy(xpath="//button[normalize-space()='System mapping']")
	WebElement uMUserSystemMappingTab;

	@FindBy(linkText = "+ Add Row")
	WebElement AddRow;

	@FindBy(xpath = "//tbody//tr//td[1]//select[not(contains(@name,'__prefix__'))]")
	WebElement UMProcessNameDropdown;

	@FindBy(id = "id_form-0-sub_process_id")
	WebElement UMSubProcessNameDropdown;

	@FindBy(id = "id_form-0-s_sub_process_id")
	WebElement UMSubSubProcessNameDropdown;

	@FindBy(id = "id_form-0-stage_id")
	WebElement UMStageNameDropdown;

	@FindBy(xpath = "//tr[not(@id='empty_form')]//div//img")
	List<WebElement> UMProcessDelete;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement UMSaveButton;

	@FindBy(xpath =  "//button[text()='User superior mapping ']")
	WebElement UserSuperiorMappingTab;

	@FindBy(xpath =  "//td[1]//select[not(contains(@name,'prefix'))]")
	WebElement USMStagesDropdown;

	@FindBy(xpath =  "//td[2]//select[not(contains(@name,'__prefix__'))]")
	WebElement USMRoleDropdown;

	@FindBy(xpath =  "//td[3]//select[not(contains(@name,'__prefix__'))]")
	WebElement USMNameDropdown;

	@FindBy(xpath =  "//td[4]//input[not(contains(@name,'__prefix__'))]")
	WebElement USMFromDate;

	@FindBy(xpath =  "//td[5]//input[not(contains(@name,'__prefix__'))]")
	WebElement USMToDate;

	@FindBy(xpath =  "//tr[not(@id='empty_form')]//img[not(contains(@class,'edit_delete '))]")
	WebElement deleteButton;

	@FindBy(xpath =  "(//button[text()='Continue'])[1]")
	WebElement continueButton;

	@FindBy(xpath =  "//tbody//td//select[not(contains(@name,'__prefix__'))]")
	WebElement SMSystemName;

	@FindBy(xpath =  "//input[@type='text' and not(contains(@id,'prefix'))]")
	WebElement SMSystemValue;

	@FindBy(id =  "group_name")
	WebElement systemNameInputField;

	@FindBy(xpath =  "//button[text()='Create']")
	WebElement systemNameSaveButton;

	@FindBy(xpath =  "//button[text()='Cancel']")
	WebElement systemNameCancelButton;


	@FindBy(xpath =  "//img[@alt='rgt_arrow']")
	WebElement paginationRightButton;


	@FindBy(xpath =  "//a[@id='uploadBtn']")
	WebElement userCreateUploadButton;

	@FindBy(xpath =  "(//input[@class='select2-search__field'])[1]")
	WebElement uploadStagesButton;

	@FindBy(xpath =  "//li[@class='select2-results__option']")
	List<WebElement> uploadStagesOptions;

	@FindBy(xpath =  "//input[@id='newOption']")
	WebElement uploadNewButton;

	@FindBy(xpath =  "//input[@id='updateOption']")
	WebElement uploadUpdateButton;

	@FindBy(xpath =  "//input[@id='Browse']")
	WebElement uploadFileColumn;

	@FindBy(xpath =  "//button[text()='Upload']")
	WebElement fileUploadButton;




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
	String permissionsfilePath= System.getProperty("user.dir")+"\\ExcelFiles\\PermissionsToSelect.xlsx";
	String userManagementSheetName="User Management";
	List<String> userCreated=new ArrayList<String>();;

	public ExcelUtils excelToUploadModulePermissions = new ExcelUtils(permissionsfilePath, "Individual Permissions");
	public ExcelUtils excelToUploadViewPermissions = new ExcelUtils(permissionsfilePath, "View Permissions");

	private static void assertElements(WebElement textBox) {
		softAssert.assertTrue(textBox.isEnabled());
		softAssert.assertTrue(textBox.isDisplayed());

	}
	public UserSetupPage navToUserCreatePage()
	{
		//		userSetup.click();
		click(driver,userManagement);
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

	public  UserSetupPage userCreationFields(String fName, String lName, String pass)
	{

		firstName=fName;
		lastName=lName;
		password=pass;
		UserName= firstName+" "+lastName;
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

		ExcelWrite.updateExcelWithData(Map.of("User Accounts", userCreated), permissionsfilePath, userManagementSheetName);


		return this;

	}
	@FindBy(xpath="//input[@name='user_name']/following-sibling::label")
	WebElement dupUserNameError;

	public void userCreationNeg()
	{
		userSetup.click();
		userManagement.click();
		userManagementCreateButton.click();
		inputUserName.sendKeys(" ");
		inputPassword.sendKeys("Qwerty@123");
		inputConfirmPassword.sendKeys("Qwerty@123");
		jsClick(driver, userAccountCreateButton);
		System.out.println(dupUserNameError.getAttribute("id"));
		assertTrue(dupUserNameError.getAttribute("id").equals("user_name-error"));

	}

	public UserSetupPage singleGroupSelect(String selectGroup)
	{
		Select singleGroup=new Select(groupsMultiSelectDropdown);
		singleGroup.selectByVisibleText(selectGroup);
		click(driver, groupsSingleRight);
		return this;
	}

	public UserSetupPage clickOnGroupCreateButton()
	{
		jsClick(driver,userAccountCreateButton);
		unWait(2);
		roleContinueButton.click();
		return this;
	}

	public UserSetupPage navToRoleAndPerTable()
	{

		if(!userSetup.getAttribute("aria-expanded").equals("true")) {
			userSetup.click();
		}

		userManagement.click();

		return this;
	}

	public UserSetupPage navToRoleAndPerCreate()
	{
		userSetup.click();
		roleAndPermissions.click();
		roleAndPermissionsCreate.click();
		return this;
	}

	public UserSetupPage createRoles(String inputgroupname, String getGroupNameFromExcel, ExcelUtils utils)
	{
		sendKeys(inputGroupName,inputgroupname);

		Select fromGroupsDrp = new Select(permissionsMultiSelectDropdown);


		List<String> groupsToSelect= utils.getColumnDataByName(getGroupNameFromExcel);

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

	public UserSetupPage navToUserManagement()
	{
		if(userSetup.getAttribute("aria-expanded").equals("true")) {
			userManagement.click();
		}else{
			userSetup.click();
			userManagement.click();
		}

		return this;
	}

	public  UserSetupPage userAccountTableActions(String usernameToDoAction)
	{

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameToDoAction.equals(usernameColumn.getText()) ) {

				WebElement deleteButton = row.findElement(By.xpath("//td//div//img[@alt='delete-icon ']"));
				deleteButton.click();
				roleTableDelete.click();
				unWait(2);
				roleContinueButton.click();
				System.out.println(usernameToDoAction+" User Account Successfully Deleted");
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

	public UserSetupPage print()
	{
		for(String str:recordNames)
		{
			System.out.println(str);
		}
		return this;

	}

	public UserSetupPage deleteRoleByName( String nameToDelete)
	{
		roleAndPermissions.click();
		// Find all rows within the table
		List<WebElement> rows = formsTableBody.findElements(By.tagName("tr"));

		for (WebElement row:rows)
		{
			if(row.getText().equals(nameToDelete))
			{
				click(driver,row.findElement(By.cssSelector("img.delete-dataset")));
				roleTableDelete.click();
				unWait(2);
				roleContinueButton.click();
				System.out.println(nameToDelete+" Role Record Successfully Deleted");
				break;
			} else {

			}

		}
		userSetup.click();
		return this;
	}

	public void getRolesName()
	{
		roleAndPermissions.click();
		List <WebElement> roleNames=driver.findElements(By.xpath("//tr//td[1]"));
		for(WebElement roleName:roleNames)
		{
			System.out.println(roleName.getText());
		}
	}

	// Method to get the list of entered record names
	public static  List<String> getRoles() {

		return RolesCreated;
	}

	public UserSetupPage userLogin(String UserName,String password)
	{

		driver.get("https://test.capture.autosherpas.com/en/myprofile/login/");
		LoginPage.usernameField.sendKeys(UserName);
		LoginPage.passwordField.sendKeys(password);
		LoginPage.signInButton.click();
		return this;

	}

	public UserSetupPage assertDataset()
	{
		dataSetup.click();

		isElementVisible(createButton,"Process Create Button is Displayed");
		isElementVisible(processEditButton,"Process Edit Button is Displayed");

		jsClick(driver, processRecords.get(0));
		isElementVisible(processSecondEditButton,"Process Second Process Edit Button is Displayed");

		dataSetTab.click();
		isElementVisible(dataSetCreateButton,"DataSet Create Button is Displayed and Enabled");
		isElementVisible(dataSetEditButton,"DataSet Edit Buttons is Displayed and Enabled");
		isElementVisible(dataSetDeleteButton,"DataSet Delete Buttons is Displayed and Enabled");

		metaDataTab.click();
		isElementVisible(metaDataCreateButton,"MetaData Create Button is Displayed and Enabled");
		isElementVisible(metaDataDeleteButton,"MetaData Delete Buttons is Displayed and Enabled");
		isElementVisible(metaDataEditButton,"MetaData Edit Buttons is Displayed and Enabled");

		softAssert.assertAll();
		return this;

	}

	private boolean isElementVisible(WebElement element,String ErrorMessage) {
		try {

			softAssert.assertFalse(element.isDisplayed(),ErrorMessage);
			softAssert.assertFalse(element.isEnabled(),ErrorMessage);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException | ElementNotInteractableException e) {
			return false;
		}
	}

	public void assertWorkflowDesignPositive()
	{
		workFlowDesign.click();
		assertTrue(masterParameterTab.isDisplayed());
		assertTrue(measurableSetTab.isDisplayed());
		assertTrue(nonMeasurableTab.isDisplayed());
		assertTrue(dispositionTab.isDisplayed());

		measurableSetTab.click();
		//		MeasurableSetPage.createNormalView();
		//		NonMeasurableSetPage.createNormalView();
		//		Disposition.createNormalView();

	}

	public void dropdownValidation(WebElement Dropdown)
	{
		Select process=new Select(Dropdown);

		System.out.println("Default Selected Option: "+process.getAllSelectedOptions().get(0).getText());

		assertTrue(process.getOptions().size()>0);

		System.out.println("Dropdown is Validated");
	}

	public void selectByVisibleText(WebElement dropdown, String VisibleText)
	{
		Select process=new Select(dropdown);
		process.selectByVisibleText(VisibleText);
	}

	public UserSetupPage userMappingNav()
	{
		userSetup.click();
		userManagement.click();

//		try {
//			userManagement.click();
//			
//		} catch (org.openqa.selenium.NoSuchElementException | ElementNotInteractableException e) {
//			userSetup.click();
//			userManagement.click();
//		}


		return this;
	}
	public UserSetupPage userMappingRecord(String usernameToDoAction)
	{
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameToDoAction.equals(usernameColumn.getText()) ) {
				System.out.println( usernameColumn.getText());
				WebElement UserMappingBtn= row.findElement(By.cssSelector("img[title='User Mapping']"));
				UserMappingBtn.click();
				break;
			}

		}
		return this;
	}

	public UserSetupPage userMappingProcess(String ProcessName, String SubProcessName,String SubSubProcess,String Stages)
	{
		// Adjust timeout as needed
		try {
			if (!deleteButton.isDisplayed()) {
				System.out.println("Rows are already added.");
			}
		} catch (Exception e) {

			AddRow.click();// Handle other exceptions if necessary
			e.printStackTrace();
		}

//		
//		try {
//			if(!deleteButton.get(0).isDisplayed()) {
//			System.out.println("Rows are already added.");
//			}
//			}catch (Exception e) {
//				
//				AddRow.click();
//			}
//				uMProcessTab.click();

		dropdownValidation(UMProcessNameDropdown);
		selectByVisibleText(UMProcessNameDropdown, ProcessName);

		dropdownValidation(UMSubProcessNameDropdown);
		selectByVisibleText(UMSubProcessNameDropdown, SubProcessName);

		dropdownValidation(UMSubSubProcessNameDropdown);
		selectByVisibleText(UMSubSubProcessNameDropdown, SubSubProcess);

		dropdownValidation(UMStageNameDropdown);
		selectByVisibleText(UMStageNameDropdown, Stages);

		UMSaveButton.click();
		unWait(1);
		continueButton.click();

		return this;
	}

	public UserSetupPage userMappingUserSuperior(String Stages,String role,String name)
	{
		try {
			if (!deleteButton.isDisplayed()) {
				System.out.println("Rows are already added.");
			}
		} catch (Exception e) {

			AddRow.click();// Handle other exceptions if necessary
			e.printStackTrace();
		}
//		UserSuperiorMappingTab.click();
//		dropdownValidation(USMStagesDropdown);
		selectByVisibleText(USMStagesDropdown,Stages);

//		dropdownValidation(USMRoleDropdown);
		selectByVisibleText(USMRoleDropdown,role);

//		dropdownValidation(USMNameDropdown);
		selectByVisibleText(USMNameDropdown,name);

//		USMFromDate.sendKeys("02-07-2024");
//		sendKeys(USMFromDate, "02-07-2024");
//		USMToDate.sendKeys("06-07-2024");
//		sendKeys(USMToDate, "06-07-2024");

		UMSaveButton.click();
		unWait(1);
		continueButton.click();
		return this;
	}

	public UserSetupPage systemMapping(String visibleText,String value)
	{
		selectByVisibleText(SMSystemName,visibleText);
		SMSystemValue.sendKeys(value);
		return this;
	}

	public UserSetupPage navToSysNames()
	{
		userSetup.click();
		systemNames.click();
		return this;
	}

	//	--------System Names-------------
	public UserSetupPage systemNames(String systemName)
	{

		createButton.click();
		systemNameInputField.sendKeys(systemName);
		systemNameSaveButton.click();
		unWait(1);
		continueButton.click();
		userSetup.click();
		return this;

	}
	public UserSetupPage deleteSystemNames(String systemNames)
	{
		List<WebElement> rows=driver.findElements(By.xpath("//tbody//tr"));
		for(WebElement row:rows)
		{
			if(row.getText().equals(systemNames))
			{
				click(driver,row.findElement(By.cssSelector("img.delete-dataset")));
				roleTableDelete.click();
				unWait(2);
				roleContinueButton.click();
				System.out.println(systemNames+"  Record Successfully Deleted");

				break;
			}
		}
		userSetup.click();
		return this;
	}

	//	Reading WebTables And Adding in 
	List<String> userAcount=new ArrayList<String>();
	List<String> role=new ArrayList<>();
	public void getUserAccounts()
	{
		userSetup.click();
		userManagement.click();
		do {
			List<WebElement>records=driver.findElements(By.xpath("//td[1]"));
			for(WebElement record:records)
			{
				userAcount.add(record.getText());

			}

			jsClick(driver,paginationRightButton);
//		roleAndPermissions.click();
//
//		List<WebElement>roles=driver.findElements(By.xpath("//td[1]"));
//		for(WebElement record:roles)
//		{
//			role.add(record.getText());
//
//		}
//		ExcelWrite.updateExcelWithData(Map.of("Roles",role), permissionsfilePath, "Already Existing Records");
		}
		while(paginationRightButton.isEnabled());
		{

		}
		ExcelWrite.updateExcelWithData(Map.of("User Accounts",userAcount), permissionsfilePath, "Already Existing Records");

	}

	String user_data=System.getProperty("user.dir")+"\\Upload Files\\user_data.xlsx";
	public ExcelUtils uploadToCreateUser=new ExcelUtils(user_data, "Users");
	public UserSetupPage userUpload()
	{
		userCreateUploadButton.click();
		uploadStagesButton.click();
		uploadStagesOptions.get(0).click();

		uploadNewButton.click();
		uploadFileColumn.sendKeys(user_data);

		fileUploadButton.click();
		List<String> userNames=uploadToCreateUser.getColumnDataByName("User Name");
		for(String userName:userNames) {
			System.out.println(userName);
		}

		assertEquals(userNames.get(0), roleTableNames.get(3).getText());

		return this;
	}





}
