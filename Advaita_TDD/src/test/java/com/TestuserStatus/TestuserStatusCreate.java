package com.TestuserStatus;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.UserStatus.pageobject.UserStatus;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.pageObjects.UserSetupPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.datafaker.Faker;

public class TestuserStatusCreate extends TestBase {
	Faker faker = new Faker();
	FakeData fake = new FakeData();
	public String metaDataName = "Test " + faker.name().firstName();

	public ExtentReports reports;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest test;

	LoginPage loginPage;
	HomePage homePage;

	UserStatus userStatus;
	UserSetupPage userSetupPage;
	PropertieFileUtil propertieFileUtil;

	private static final String userStatus_Path7 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\userStatus.Properties";

	public TestuserStatusCreate() throws Exception {
		super();

	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("Capture_admin", "Qwerty@123");
//		homePage = loginPage.login(userName, newPassword);
		userSetupPage = new UserSetupPage();

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterFormCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

//		// Configuration to change look and feel
//		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
//		htmlReporter.config().setReportName("TEST Advaita-MetaData");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTimelineEnabled(true);
//		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		userStatus = new UserStatus(); // object creation with referenac of class
		propertieFileUtil = new PropertieFileUtil(); // object creation with referenac of class

	}

	// <=======MenusTO Hide Options And Status Names

	String menusList_Dropdown[] = { "Data Setup", "workflowdesign", "User Setup", "Alchemy", "Masters", "User Status",
			"API Key Setup", "Menu Setup", "Site Settings", "Discount and Scheme", "Accessories" };

	String alchemy_menusList[] = { "Manual Allocation", "Re Allocation", "Sampling Plan & Generation",
			"Escalation Metrics", "Call Log Stage View", "Call Log Tab View", "Agency Validation", "Email Template",
			"SMS Template", "Whatsapp Template", "Notification Template", "Broadcast Template", "Sample Status",
			"Transmon Report", "Validation Status Report", "Transaction Report", "Reject Audit Form" };

	@Test(priority = 1, enabled = true)
	public void navigateToMenusSetup() throws Throwable {
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
	}

	@Test(priority = 3, enabled = true)
	public void navigateTouserStatus() throws Throwable {
		userStatus.naviagteToCreateUserStatus();

	}

	@Test(priority = 4, enabled = true)
	public void createuserStatus() throws IOException {
		userStatus.naviagteToCreateUserStatus();
		// userStatus1.statusNameInputField();
		userStatus.descriptionField();
	}

	@Test(priority = 5, enabled = true)
	public void MultiselectDropdwon() throws Throwable {
		userStatus.selectMenusToHideDropdwon();
		userStatus.clickOnCreateButton();
		userStatus.verifyCreatedStatus();
		// userStatus1.CreatedStatusList();
	}

	// Create
	@Test
	public void createHideStatus() throws Throwable {
//		userStatus.navigateToMenuSetup();
//		userStatus.callLogatTabViewClick();
		userStatus.NavigateToUserStatus();
		userStatus.naviagteToCreateUserStatus();
		userStatus.statusNameInputField();
		userStatus.descriptionField();
		userStatus.selectMenusToHideDropdwon();
		userStatus.clickOnCreateButton();
		userStatus.verifyCreatedStatus();
//		userStatus1.CreatedStatusList();
		userStatus.selectMenuToHide("GivenOptionsAlchemyOptions", "Manual Allocation");
//		userStatus1.selectStatusHideMultipleMenus(); //Select "Status" with multiple "Hide Menus"			
	}

	// Table
	@Test(priority = 6)
	public void userStatusTable() throws Throwable {
//		userStatus.navigateToMenuSetup();
//		userStatus.callLogatTabViewClick();
//		userStatus.createUserStatus();

		userStatus.searchStatus();
		// userStatus.clearallFiltes();
		// userStatus.DeleteStatus();
	}

	// Edit
	@Test(priority = 7)
	public void userStatusEdit() throws Throwable {

		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.naviagteToCreateUserStatus();

		userStatus.EditStatus(); // Edit mandatory field name
		userStatus.EditDescriptnField();
		userStatus.multiseletToMenuHide();
	}

	@Test
	public void navigateToAmdinProfile() throws Throwable {
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.naviagteToCreateUserStatus();

		// userStatus1.navigateToaAdmin();

		userStatus.searchmenusInSearchtextfield();

	}

	// @Test(invocationCount = 3)
	public void searchmenusInSearchtextfield() throws Throwable {
		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.naviagteToCreateUserStatus();

		userStatus.searchmenusInSearchtextfield();
	}

//===========================================================================================
	// New Implemenetation
	@Test
	public void VerifyTheUserIsableToNaviagteUserStatus() throws Throwable {

		userStatus.NavigateToUserStatus();

	}

	@Test(dependsOnMethods = { "VerifyTheUserIsableToNaviagteUserStatus" })
	public void verifyTheUserIsAbleToSearchThroughStatusName() throws Throwable {

		userStatus.searchStatus();

	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToSearchThroughStatusName" })
	public void verifyTheUserIsAbleToClearAllFilter() {

		userStatus.clearallFiltes();
	}

	@Test(dependsOnMethods = { "verifyTheUserIsAbleToClearAllFilter" })
	public void veriffyTheUserIsAbleToDeleteUserStatus() throws Throwable {

		String statusName = PropertieFileUtil.getSingleTextFromPropertiesFile(userStatus_Path7,"StatusNameSearch1");
		userStatus.DeleteStatus(statusName);

	}

	@Test(enabled = false, dependsOnMethods = { "VerifyTheUserIsableToNaviagteUserStatus" })
	public void VerifyTheUserAbeleToDeleteAsPerCount() {

		userStatus.deleteUserStatuses(2);

		// userStatus.deleteUserStatuses(userStatus.deleteOptions.size()); //
		// Dynamically deletes all
	}

	@Test(dependsOnMethods = { "VerifyTheUserIsableToNaviagteUserStatus" })
	public void CreateUserStatusAndVerfiy() throws Throwable {
		CreateUserStatusAndVerfiyHideMenu();
	}

	@Test(enabled = false, dependsOnMethods = { "VerifyTheUserIsableToNaviagteUserStatus" })
	public void CreateUserStatusAndVerfiyHideMenu() throws Throwable {

		userStatus.naviagteToCreateUserStatus();
		userStatus.statusNameInputField();
		userStatus.descriptionField();

		userStatus.selectMenuToHide("GivenOptionsAlchemyOptions", "Manual Allocation");
	}

	@Test(enabled = true, dependsOnMethods = { "VerifyTheUserIsableToNaviagteUserStatus" })
	public void CreateUserStatusAndVerfiyHideMenuForALchemy() throws Throwable {

		userStatus.naviagteToCreateUserStatus();
		userStatus.statusNameInputField();
		userStatus.descriptionField();

		userStatus.selectMenuToHide("GivenOptionsAlchemyOptions", "Manual Allocation");

	}

	public void createUserStausdynamciallyRandomly() {

	}

	// ========================================================================================

	// <================= Negative Script for userStatus

	@Test(priority = 8)
	public void verifyWithoutSelectingAnyFieldAndCreateuserStatus() {

		userStatus.naviagteToCreateUserStatus();
		userStatus.withoutSelectingAnyFieldAndCreateUserstatus();
	}

	@Test(priority = 9)
	public void verifyTheUsercreateuserStatusThroughSpecialCharacters() { // need to implemennt after fix

		userStatus.naviagteToCreateUserStatus();
		userStatus.createUserStatusThroughSpecialCharacters();
	}

	@Test(priority = 10) // need to update after fixed
	public void verifyCreateuserStatusThrougByenteringNonEnglishCharacterInStatusNameField() {

		userStatus.naviagteToCreateUserStatus();
		userStatus.createUserStatusThrougByenteringNonEnglishCahracterInDescriptionTextfield();

	}

	@Test(priority = 10) // need to update after fixed
	public void verifyCreateuserStatusThrougByenteringNonEnglishCahracterInDescriptionTextfield() {

		userStatus.naviagteToCreateUserStatus();
		userStatus.createUserStatusThrougByenteringNonEnglishCahracterInDescriptionTextfield();

	}

	@Test(priority = 11)
	public void verifyTheUsercreateuserStatusThroughEmojis() { // need to implemennt after fix
		userStatus.userCreateUserStatusThroughEmojis();

	}

	@Test(priority = 12)
	public void verifyCreateUserByByEnteringMoreThanCharacterLimitInStatusNameTetxfield() { // Need To update after
																							// fixed

		userStatus.naviagteToCreateUserStatus();
		userStatus.createUserStatusByEnteringMoreThanCharacterLimitForStatusNameTetxfield();
	}

	@Test(priority = 13)
	public void VerifycreateuserStatusByEnteringMoreThanCharacterLimitInDescriptionTetxfield() {

		userStatus.naviagteToCreateUserStatus();
		userStatus.createUserStatusByEnteringMoreThanCharacterLimitForStatusNameTetxfield();
	}

	@Test(priority = 14)
	public void verifyCreateuserStatusThroughOnlyNumericValue() { // need to Update After fix
		userStatus.createUserStatusThroughOnlyNumericValue();

	}

	@Test(priority = 15)
	public void verifyCreateuserStatusByEnablingAndSelectingOptionstoToConsiderIsDefault() {
		userStatus.createUserStatusByEnablingAndSelectingOptionstoToConsiderIsDefault();
	}

	@Test(priority = 16)
	public void verifyUserCreateuserStatuswithoutSelectingActiveStausAndIsDefault() { // implement in Create User status

		userStatus.userCreateUserStatuswithoutSelectingActiveStausAndIsDefault();
	}

	@Test(priority = 17)
	public void verifySearchInvalidCharacterInSearchTextfieldInuserStatusPage() {
		userStatus.searchInvalidCharacterInSearchTextfieldInUserStatusPage();

	}

	@Test(priority = 18)
	public void verifyTheUserTryToSearchByWithoutEnteringAnyData() {
		userStatus.tryToSearchByWithoutEnteringAnyData();
	}

	@Test(priority = 19)
	public void verifyUserSearchthroughActiveStatus() {
		userStatus.userSearchthroughActiveStatus();
	}

	@Test(priority = 20)
	public void verifyUserSearchthroughisDefaultStatus() {
		userStatus.userSearchthroughisDefaultStatus();
	}

	@Test(priority = 21)
	public void verufyTheUserfilledAlldataInCreateuserStatusPageAndClickONCancel() {
		userStatus.filledAlldataInCreateUserStatusPageAndClickONCancel();
	}

	@Test(priority = 22)
	public void verifyTeUserAfterClickOnDeleteIconInsteofClickDeleteOrcancelButtonClickOutise() {
		userStatus.afterClickOnDeleteIconInsteofClickDeleteOrcancelButtonClickOutise();

	}

	@Test(priority = 23)
	public void TheUserAbleTodeleteAlluserStatus() {
		userStatus.TheUserAbleTodeleteAllUserStatus();

	}
//====================================================================================================================	

	// END To END_User Status

	String processName = PropertieFileUtil.getSingleTextFromPropertiesFile(userStatus_Path7,"process");
	String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(userStatus_Path7,"subProcess");
	String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(userStatus_Path7,"subSubProcess");
	String stage = PropertieFileUtil.getSingleTextFromPropertiesFile(userStatus_Path7,"stage");

	String newPassword = PropertieFileUtil.getSingleTextFromPropertiesFile(userStatus_Path7,"Newpassword");

	String userName = "das " + "Abhijit@wyzminz.com";
	String commmonPassword = "Qwerty@123";

	String NoDataIntextfield = "";
	String emailWithoutDomainName = "Abhijit@wyzminz";
	String emailWithoutSpecilaChar = "Abhijitwyzminz.com";
	String emailWithDifferntLanguage = "アビジット@ワイズミンズ.com";
	String emoji = "❤️😂😊";

	String numericalNumber = "1234567890";
	String lessThan10DigitNumber = "12345678";
	String moreThan10DigitNumber = "12345678900";
	String mobileNumberWithDiffentLanguage = "一二三四五六七八九〇";

	String wrongPassword = "Password123";
	String passwordWithNoUpperCase = "password@1234";
	String emprtyPassword = "";
	String PaswordLessThanEightCharacter = "Pass@12";

	// Create Method For Random Number
	public void randomNumber() {

		// Generate a random 10-digit number
		Random random = new Random();
		long randomNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L); // Ensures 10-digit number

		System.out.println("Generated 10-digit number: " + randomNumber);

	}

	@Test
	public void endToEnduserStatus() {

		userSetupPage.navToUserCreatePage();
		userSetupPage.userCreationFields("das", "Abhijit@wyzminz.com", "Qwerty@123"); // need to change as per
																						// requiremenet

		userSetupPage.singleGroupSelect("Admin");
		userSetupPage.clickOnGroupCreateButton();
		userSetupPage.userMappingRecord(userName);
		userSetupPage.userMappingProcess(processName, subProcess, subSubProcess, stage);
		userStatus.logoutAmdin();
		loginToUser(userName);
		userSetupPage.userLogin(userName, commmonPassword); // need to contonitine
	}

	// ProfileOption
	// MyProfile_Emailtextfield_Negative
	@Test(priority = 24)
	public void verifyTheuserWithoutFilledAnyFieldInmandatoryFieldAndUpdate() {
		userStatus.navigateToAccountSettingPage();
		userStatus.userWithoutFilledAnyFieldInmandatoryFieldAndUpdate();
	}

	@Test(priority = 25)
	public void verifyTheUserFilledAllTheTextfieldAndClickONCancel() {
		userStatus.navigateToAccountSettingPage();
		userStatus.userFilledAllTheTextfieldAndClickONCancel(fake.lastName1(), fake.lastName2(), fake.lastName1(),
				fake.lastName2());
	}

	@Test(priority = 26)
	public void verifyTheUSerisAbleToUpdateWithoutEnterEmailId() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.emailtextfieldLabel,
				userStatus.emailTextfield, NoDataIntextfield, userStatus.emailTextFieldErrorMesg);
	}

	@Test(priority = 27)
	public void verifyTheUSerisAbleToUpdateByEnterOnlyCharacterOnEmailTextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.emailtextfieldLabel,
				userStatus.emailTextfield, fake.lastName1(), userStatus.emailTextFieldErrorMesg);
	}

	@Test(priority = 28)
	public void verifyTheUserisAbleToUpdateByEnterNumberInEmailTextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.emailtextfieldLabel,
				userStatus.emailTextfield, numericalNumber, userStatus.emailTextFieldErrorMesg);
	}

	@Test(priority = 29)
	public void verifyTheUSerisAbleToUpdateWithoutEnterDomainNamerInEmailTextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.emailtextfieldLabel,
				userStatus.emailTextfield, emailWithoutDomainName, userStatus.emailTextFieldErrorMesg);
	}

	@Test(priority = 30)
	public void verifyTheUSerisAbleToUpdateWithoutEnterSpecialCharactharacterInEmailTextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.emailtextfieldLabel,
				userStatus.emailTextfield, emailWithoutSpecilaChar, userStatus.emailTextFieldErrorMesg);
	}

	@Test(priority = 31)
	public void verifyTheUSerisAbleToUpdateByEnteringEmailThroughDiffLanguages() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.emailtextfieldLabel,
				userStatus.emailTextfield, emailWithDifferntLanguage, userStatus.emailTextFieldErrorMesg);
	}

	@Test(priority = 32)
	public void verifyTheUserIsAbleToUpdateByEntringemojisInEmailTextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.userIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY(userStatus.emailTextfield, emoji,
				userStatus.updateOptionAccountSettings, userStatus.successFully_popuop);
	}

	@Test(priority = 33)
	public void UerifyTheUserIsAbleToEnterRepeatedCharacterINTextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.userIsAbleToenterRepeatedCharacterINTextfield(userStatus.firstNameTextfield, "A".repeat(300));
	}

	// MyProfile_MobileNumber
	@Test(priority = 34)
	public void verifyTheUSerisAbleToUpdateByEnteringCharacterMobileNumberIntextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.MobileLabel,
				userStatus.mobileTextfield, fake.lastName1(), userStatus.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 35)
	public void verifyTheUSerisAbleToUpdateByEnteringLessThanCharacterLimitInMobiletextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.MobileLabel,
				userStatus.mobileTextfield, lessThan10DigitNumber, userStatus.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 36)
	public void verifyTheUSerisAbleToUpdateByEnteringMoreThanCharacterLimitInMobiletextfield() {

		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.MobileLabel,
				userStatus.mobileTextfield, moreThan10DigitNumber, userStatus.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 37)
	public void verifyTheUSerisAbleToUpdateByEnteringMobileNumberThroughDifferntLanguagesInIntextfield() {
		userStatus.navigateToAccountSettingPage();
		userStatus.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus.MobileLabel,
				userStatus.mobileTextfield, mobileNumberWithDiffentLanguage, userStatus.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 38)
	public void verifyTheUserIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY() {
		userStatus.navigateToAccountSettingPage();
		userStatus.userIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY(userStatus.mobileTextfield, emoji,
				userStatus.updateOptionAccountSettings, userStatus.successFully_popuop);
	}

	// <=================== My Profile Positive And Neagtive=============>
	@Test(priority = 39)
	public void myProfileAccountSettingPostiveAndNeagtiveEndToEnd() {

		userStatus.navigateToAccountSettingPage();
		userStatus.userIsAbleToChangeUserName(fake.lastName1(), fake.lastName2());
		userStatus.userIsAbleTochangeEmailId(fake.lastName1() + fake.lastName2() + "@gmail.com");
		userStatus.userIsAbleTochangeEmailMobileNumber();
		// userStatus1.userIsAbleToeditProflePicture();

		verifyTheuserWithoutFilledAnyFieldInmandatoryFieldAndUpdate();
		verifyTheUserFilledAllTheTextfieldAndClickONCancel();
		verifyTheUSerisAbleToUpdateWithoutEnterEmailId();
		verifyTheUSerisAbleToUpdateByEnterOnlyCharacterOnEmailTextfield();
		verifyTheUserisAbleToUpdateByEnterNumberInEmailTextfield();
		verifyTheUSerisAbleToUpdateWithoutEnterDomainNamerInEmailTextfield();
		verifyTheUSerisAbleToUpdateWithoutEnterSpecialCharactharacterInEmailTextfield();
		verifyTheUSerisAbleToUpdateByEnteringEmailThroughDiffLanguages();
		verifyTheUserIsAbleToUpdateByEntringemojisInEmailTextfield();
		// UerifyTheUserIsAbleToenterRepeatedCharacterINTextfield(); //Nedd To update
		// After fixed ??

		verifyTheUSerisAbleToUpdateByEnteringCharacterMobileNumberIntextfield();
		verifyTheUSerisAbleToUpdateByEnteringLessThanCharacterLimitInMobiletextfield();
		verifyTheUSerisAbleToUpdateByEnteringMoreThanCharacterLimitInMobiletextfield();
		verifyTheUSerisAbleToUpdateByEnteringMobileNumberThroughDifferntLanguagesInIntextfield();
		verifyTheUserIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY();

	}

	// ChangePassword_Positive
	@Test(priority = 40)
	public void verifyTheUserIsAbleToChangePassword() {

//		At least 1 upper case letter (A to Z), At least 1 number (0-9), At least 1 special character , At least 8 chracters		
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToChangePassword(commmonPassword, newPassword, newPassword);
	}

	@Test(priority = 41)
	public void verifyTheUserisAbleToSeeTheOldPasswordByClickEyeIcon() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userisAbleToSeeThePasswordByClickEyeIcon(userStatus.oldPasswordTextfield, commmonPassword,
				userStatus.oldPassEyeIcon);
	}

	@Test(priority = 42)
	public void verifyTheUserisAbleToSeeTheNewPasswordByClickEyeIcon() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userisAbleToSeeThePasswordByClickEyeIcon(userStatus.newPasswordTextfield, commmonPassword,
				userStatus.newPassEyeIcon);
	}

	@Test(priority = 43)
	public void verifyTheUserisAbleToSeeTheConformPasswordByClickEyeIcon() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userisAbleToSeeThePasswordByClickEyeIcon(userStatus.conformPasswordTextfield, commmonPassword,
				userStatus.conformPassEyeIcon);
	}
	// <================== chaange password Neagative

	@Test(priority = 44)
	public void verifyTheUserIsAbleToChangePassordWithoutEnterOldPAssword() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(emprtyPassword, newPassword,
				newPassword, userStatus.oldPassIsRequiredErrorMesg);

	}

	@Test(priority = 45)
	public void verifyTheUserIsAbleToCahngePassordWithoutEnterNewPAssword() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, emprtyPassword,
				newPassword, userStatus.newPasswordFieldErrorMessagElement);

	}

	@Test(priority = 46)
	public void verifyTheUserIsAbleToCahngePassordWithoutEnterConformPAssword() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, newPassword,
				emprtyPassword, userStatus.conformPassErrorMessage);

	}

	@Test(priority = 47)
	public void verifyTheUSerIsAbleDoChangePasswordByEnteringWrongOldPAssword() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(wrongPassword, newPassword, newPassword,
				userStatus.oldPasswordErrorMessage);
	}

	@Test(priority = 48)
	public void verifyTheUSerIsAbleDoChangePasswordByEnteringWrongNewPAssword() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, wrongPassword, newPassword,
				userStatus.newPasswordFieldErrorMessagElement);
	}

	@Test(priority = 49)
	public void verifyTheUSerIsAbleDoChangePasswordByEnteringWrongConformPAssword() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, newPassword, wrongPassword,
				userStatus.conformPassErrorMessage);
	}

	@Test(priority = 50)
	public void VerifyTheUserIsAbleToChangePasswordByEnterPasswwordLessThanCharacterLimitU() {
		userStatus.navigateToChangePasswordPage();
		userStatus.userIsAbleToChangePasswordByEnterPasswwordLessThanCharacterLimit(newPassword,
				PaswordLessThanEightCharacter, userStatus.newPasswordFieldErrorMessagElement);
	}

	// <=================== Change Password Positive/Neagtive Test=============>
	@Test
	public void changePasswordPositiveAndNegativeEndToEnd() {

		// verifyTheUserIsAbleToChangePassword();
		verifyTheUserisAbleToSeeTheOldPasswordByClickEyeIcon();
		verifyTheUserisAbleToSeeTheNewPasswordByClickEyeIcon();
		verifyTheUserisAbleToSeeTheConformPasswordByClickEyeIcon();

		verifyTheUserIsAbleToChangePassordWithoutEnterOldPAssword();
		verifyTheUserIsAbleToCahngePassordWithoutEnterNewPAssword();
		verifyTheUserIsAbleToCahngePassordWithoutEnterConformPAssword();
		verifyTheUSerIsAbleDoChangePasswordByEnteringWrongOldPAssword();
		verifyTheUSerIsAbleDoChangePasswordByEnteringWrongNewPAssword();
		verifyTheUSerIsAbleDoChangePasswordByEnteringWrongConformPAssword();
		VerifyTheUserIsAbleToChangePasswordByEnterPasswwordLessThanCharacterLimitU();
	}

	// Edit
	// @Test
	public void UserStatusEdit() throws Throwable {

		userStatus.navigateToMenuSetup();
		userStatus.callLogatTabViewClick();
		userStatus.NavigateToUserStatus();

		userStatus.EditStatus(); // Edit mandatory field name
		userStatus.EditDescriptnField();
		userStatus.multiseletToMenuHide();
	}

	// @AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
