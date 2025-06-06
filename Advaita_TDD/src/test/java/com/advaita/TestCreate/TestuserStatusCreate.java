package com.advaita.TestCreate;

import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.UserStatus.pageobject.userStatus;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.pageObjects.UserSetupPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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

	userStatus userStatus1;
	UserSetupPage userSetupPage;

	public TestuserStatusCreate() throws Exception {
		super();

	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		loginPage = new LoginPage();
//		homePage = loginPage.login("Capture_admin", "Qwerty@123");
		homePage = loginPage.login(userName, newPassword);
		userSetupPage = new UserSetupPage();

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MasterFormCreate.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("user", "Gopal");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report for MetaData");
		htmlReporter.config().setReportName("TEST Advaita-MetaData");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimelineEnabled(true);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		userStatus1 = new userStatus(); // object creation with referenac of class

	}

	// <=======MenusTO Hide Options And Status Names

	String[] statusNames = { "Admin ", "Meeting ", "Trainee Employee1", "Customer", };

	String menusList[] = { "API Key Setup", "Add Evaluation", "Audit the Auditor", "Auto Allocation", "Bias",
			"Edit Escalated Form", "Email Template", "Email Template", "Escalation Metrics", "Evaluation Tab View",
			"Manual Allocation", "Normal Report", "Open Escalated Form", "Open Escalated Form", "Rejected Audit Form",
			"SMS Template", "Sample Status", "Sampling Plan & Generation", "Skip Reason", "Transmon Report",
			"User Mapping", "View/Modify Evaluation", "Whatsapp Template" };

	// @Test(priority = 1)
	public void navigateToMenusSetup() throws Throwable {
		userStatus1.navigateToMenuSetup();
		userStatus1.callLogatTabViewClick();
	}

	// @Test(priority = 3)
	public void navigateTouserStatus() throws Throwable {
		userStatus1.createUserStatus();

	}

	// @Test(priority = 4)
	public void createuserStatus() {
		userStatus1.createUserStatus();
		// userStatus1.statusNameInputField();
		userStatus1.descriptionField();
	}

	// @Test(priority = 5)
	public void MultiselectDropdwon() throws Throwable {
		userStatus1.selectMenusToHideDropdwon();
		userStatus1.CreateButtonclick();
		userStatus1.verifyCreatedStatus();
		// userStatus1.CreatedStatusList();
	}

	// Create
	@Test
	public void createHideStatus() throws Throwable {
		userStatus1.navigateToMenuSetup();
		userStatus1.callLogatTabViewClick();
		userStatus1.createUserStatus();
		userStatus1.createUserStatus();
		userStatus1.statusNameInputField("Trainee Employee1");
		userStatus1.descriptionField();
		userStatus1.selectMenusToHideDropdwon();
		userStatus1.CreateButtonclick();
		userStatus1.verifyCreatedStatus();
//		userStatus1.CreatedStatusList();
		userStatus1.selectStatusHideSingleMenus(); // select "status"with Single "Hide" menus
//		userStatus1.selectStatusHideMultipleMenus(); //Select "Status" with multiple "Hide Menus"			
	}

	// Table
	@Test(priority = 6)
	public void userStatusTable() throws Throwable {
		userStatus1.navigateToMenuSetup();
		userStatus1.callLogatTabViewClick();
		userStatus1.createUserStatus();

		userStatus1.searchStatus();
		userStatus1.clearallFiltes();
		// userStatus1.DeleteStatus();
	}

	// Edit
	@Test(priority = 7)
	public void userStatusEdit() throws Throwable {

		userStatus1.navigateToMenuSetup();
		userStatus1.callLogatTabViewClick();
		userStatus1.createUserStatus();

		userStatus1.EditStatus(); // Edit mandatory field name
		userStatus1.EditDescriptnField();
		userStatus1.multiseletToMenuHide();
	}

	@Test
	public void navigateToAmdinProfile() throws Throwable {
		userStatus1.navigateToMenuSetup();
		userStatus1.callLogatTabViewClick();
		userStatus1.createUserStatus();

		// userStatus1.navigateToaAdmin();

		userStatus1.searchmenusInSearchtextfield();

	}

	// @Test(invocationCount = 3)
	public void searchmenusInSearchtextfield() throws Throwable {
		userStatus1.navigateToMenuSetup();
		userStatus1.callLogatTabViewClick();
		userStatus1.createUserStatus();

		userStatus1.searchmenusInSearchtextfield();
	}

	// <================= Negative Script for userStatus

	@Test(priority = 8)
	public void verifyWithoutSelectingAnyFieldAndCreateuserStatus() {

		userStatus1.createUserStatus();
		userStatus1.withoutSelectingAnyFieldAndCreateUserstatus();
	}

	@Test(priority = 9)
	public void verifyTheUsercreateuserStatusThroughSpecialCharacters() { // need to implemennt after fix

		userStatus1.createUserStatus();
		userStatus1.createUserStatusThroughSpecialCharacters();
	}

	@Test(priority = 10) // need to update after fixed
	public void verifyCreateuserStatusThrougByenteringNonEnglishCharacterInStatusNameField() {

		userStatus1.createUserStatus();
		userStatus1.createUserStatusThrougByenteringNonEnglishCahracterInDescriptionTextfield();

	}

	@Test(priority = 10) // need to update after fixed
	public void verifyCreateuserStatusThrougByenteringNonEnglishCahracterInDescriptionTextfield() {

		userStatus1.createUserStatus();
		userStatus1.createUserStatusThrougByenteringNonEnglishCahracterInDescriptionTextfield();

	}

	@Test(priority = 11)
	public void verifyTheUsercreateuserStatusThroughEmojis() { // need to implemennt after fix
		userStatus1.userCreateUserStatusThroughEmojis();

	}

	@Test(priority = 12)
	public void verifyCreateUserByByEnteringMoreThanCharacterLimitInStatusNameTetxfield() { // Need To update after
																							// fixed

		userStatus1.createUserStatus();
		userStatus1.createUserStatusByEnteringMoreThanCharacterLimitForStatusNameTetxfield();
	}

	@Test(priority = 13)
	public void VerifycreateuserStatusByEnteringMoreThanCharacterLimitInDescriptionTetxfield() {

		userStatus1.createUserStatus();
		userStatus1.createUserStatusByEnteringMoreThanCharacterLimitForStatusNameTetxfield();
	}

	@Test(priority = 14)
	public void verifyCreateuserStatusThroughOnlyNumericValue() { // need to Update After fix
		userStatus1.createUserStatusThroughOnlyNumericValue();

	}

	@Test(priority = 15)
	public void verifyCreateuserStatusByEnablingAndSelectingOptionstoToConsiderIsDefault() {
		userStatus1.createUserStatusByEnablingAndSelectingOptionstoToConsiderIsDefault();
	}

	@Test(priority = 16)
	public void verifyUserCreateuserStatuswithoutSelectingActiveStausAndIsDefault() { // implement in Create User status

		userStatus1.userCreateUserStatuswithoutSelectingActiveStausAndIsDefault();
	}

	@Test(priority = 17)
	public void verifySearchInvalidCharacterInSearchTextfieldInuserStatusPage() {
		userStatus1.searchInvalidCharacterInSearchTextfieldInUserStatusPage();

	}

	@Test(priority = 18)
	public void verifyTheUserTryToSearchByWithoutEnteringAnyData() {
		userStatus1.tryToSearchByWithoutEnteringAnyData();
	}

	@Test(priority = 19)
	public void verifyUserSearchthroughActiveStatus() {
		userStatus1.userSearchthroughActiveStatus();
	}

	@Test(priority = 20)
	public void verifyUserSearchthroughisDefaultStatus() {
		userStatus1.userSearchthroughisDefaultStatus();
	}

	@Test(priority = 21)
	public void verufyTheUserfilledAlldataInCreateuserStatusPageAndClickONCancel() {
		userStatus1.filledAlldataInCreateUserStatusPageAndClickONCancel();
	}

	@Test(priority = 22)
	public void verifyTeUserAfterClickOnDeleteIconInsteofClickDeleteOrcancelButtonClickOutise() {
		userStatus1.afterClickOnDeleteIconInsteofClickDeleteOrcancelButtonClickOutise();

	}

	// @Test(priority = 23)
	public void TheUserAbleTodeleteAlluserStatus() {
		userStatus1.TheUserAbleTodeleteAllUserStatus();

	}

	// END To END_User Status

	String processName = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
	String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess");
	String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess");
	String stage = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");

	String newPassword = PropertieFileUtil.getSingleTextFromPropertiesFile("Newpassword");

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
		userStatus1.logoutAmdin();
		loginToUser(userName);
		userSetupPage.userLogin(userName, commmonPassword); // need to contonitine
	}

	// ProfileOption
	// MyProfile_Emailtextfield_Negative
	@Test(priority = 24)
	public void verifyTheuserWithoutFilledAnyFieldInmandatoryFieldAndUpdate() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.userWithoutFilledAnyFieldInmandatoryFieldAndUpdate();
	}

	@Test(priority = 25)
	public void verifyTheUserFilledAllTheTextfieldAndClickONCancel() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.userFilledAllTheTextfieldAndClickONCancel(fake.lastName1(), fake.lastName2(), fake.lastName1(),
				fake.lastName2());
	}

	@Test(priority = 26)
	public void verifyTheUSerisAbleToUpdateWithoutEnterEmailId() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.emailtextfieldLabel,
				userStatus1.emailTextfield, NoDataIntextfield, userStatus1.emailTextFieldErrorMesg);
	}

	@Test(priority = 27)
	public void verifyTheUSerisAbleToUpdateByEnterOnlyCharacterOnEmailTextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.emailtextfieldLabel,
				userStatus1.emailTextfield, fake.lastName1(), userStatus1.emailTextFieldErrorMesg);
	}

	@Test(priority = 28)
	public void verifyTheUserisAbleToUpdateByEnterNumberInEmailTextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.emailtextfieldLabel,
				userStatus1.emailTextfield, numericalNumber, userStatus1.emailTextFieldErrorMesg);
	}

	@Test(priority = 29)
	public void verifyTheUSerisAbleToUpdateWithoutEnterDomainNamerInEmailTextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.emailtextfieldLabel,
				userStatus1.emailTextfield, emailWithoutDomainName, userStatus1.emailTextFieldErrorMesg);
	}

	@Test(priority = 30)
	public void verifyTheUSerisAbleToUpdateWithoutEnterSpecialCharactharacterInEmailTextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.emailtextfieldLabel,
				userStatus1.emailTextfield, emailWithoutSpecilaChar, userStatus1.emailTextFieldErrorMesg);
	}

	@Test(priority = 31)
	public void verifyTheUSerisAbleToUpdateByEnteringEmailThroughDiffLanguages() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.emailtextfieldLabel,
				userStatus1.emailTextfield, emailWithDifferntLanguage, userStatus1.emailTextFieldErrorMesg);
	}

	@Test(priority = 32)
	public void verifyTheUserIsAbleToUpdateByEntringemojisInEmailTextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.userIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY(userStatus1.emailTextfield, emoji,
				userStatus1.updateOptionAccountSettings, userStatus1.successFullyCreated_popuop);
	}

	@Test(priority = 33)
	public void UerifyTheUserIsAbleToEnterRepeatedCharacterINTextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.userIsAbleToenterRepeatedCharacterINTextfield(userStatus1.firstNameTextfield, "A".repeat(300));
	}

	// MyProfile_MobileNumber
	@Test(priority = 34)
	public void verifyTheUSerisAbleToUpdateByEnteringCharacterMobileNumberIntextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.MobileLabel,
				userStatus1.mobileTextfield, fake.lastName1(), userStatus1.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 35)
	public void verifyTheUSerisAbleToUpdateByEnteringLessThanCharacterLimitInMobiletextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.MobileLabel,
				userStatus1.mobileTextfield, lessThan10DigitNumber, userStatus1.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 36)
	public void verifyTheUSerisAbleToUpdateByEnteringMoreThanCharacterLimitInMobiletextfield() {

		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.MobileLabel,
				userStatus1.mobileTextfield, moreThan10DigitNumber, userStatus1.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 37)
	public void verifyTheUSerisAbleToUpdateByEnteringMobileNumberThroughDifferntLanguagesInIntextfield() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.verifyTheUSerisAbleToUpdateByEnteronlyCharacterIntextfield(userStatus1.MobileLabel,
				userStatus1.mobileTextfield, mobileNumberWithDiffentLanguage,
				userStatus1.mobileNumberTextFieldErrorMesg);
	}

	@Test(priority = 38)
	public void verifyTheUserIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY() {
		userStatus1.navigateToAccountSettingPage();
		userStatus1.userIsAbleToUpdateByEnteringEmojisInTextfieldUTILITY(userStatus1.mobileTextfield, emoji,
				userStatus1.updateOptionAccountSettings, userStatus1.successFullyCreated_popuop);
	}

	// <=================== My Profile Positive And Neagtive=============>
	@Test(priority = 39)
	public void myProfileAccountSettingPostiveAndNeagtiveEndToEnd() {

		userStatus1.navigateToAccountSettingPage();
		userStatus1.userIsAbleToChangeUserName(fake.lastName1(), fake.lastName2());
		userStatus1.userIsAbleTochangeEmailId(fake.lastName1() + fake.lastName2() + "@gmail.com");
		userStatus1.userIsAbleTochangeEmailMobileNumber();
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
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToChangePassword(commmonPassword, newPassword, newPassword);
	}

	@Test(priority = 41)
	public void verifyTheUserisAbleToSeeTheOldPasswordByClickEyeIcon() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userisAbleToSeeThePasswordByClickEyeIcon(userStatus1.oldPasswordTextfield, commmonPassword,
				userStatus1.oldPassEyeIcon);
	}

	@Test(priority = 42)
	public void verifyTheUserisAbleToSeeTheNewPasswordByClickEyeIcon() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userisAbleToSeeThePasswordByClickEyeIcon(userStatus1.newPasswordTextfield, commmonPassword,
				userStatus1.newPassEyeIcon);
	}

	@Test(priority = 43)
	public void verifyTheUserisAbleToSeeTheConformPasswordByClickEyeIcon() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userisAbleToSeeThePasswordByClickEyeIcon(userStatus1.conformPasswordTextfield, commmonPassword,
				userStatus1.conformPassEyeIcon);
	}
	// <================== chaange password Neagative

	@Test(priority = 44)
	public void verifyTheUserIsAbleToChangePassordWithoutEnterOldPAssword() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(emprtyPassword, newPassword,
				newPassword, userStatus1.oldPassIsRequiredErrorMesg);

	}

	@Test(priority = 45)
	public void verifyTheUserIsAbleToCahngePassordWithoutEnterNewPAssword() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, emprtyPassword,
				newPassword, userStatus1.newPasswordFieldErrorMessagElement);

	}

	@Test(priority = 46)
	public void verifyTheUserIsAbleToCahngePassordWithoutEnterConformPAssword() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, newPassword,
				emprtyPassword, userStatus1.conformPassErrorMessage);

	}

	@Test(priority = 47)
	public void verifyTheUSerIsAbleDoChangePasswordByEnteringWrongOldPAssword() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(wrongPassword, newPassword,
				newPassword, userStatus1.oldPasswordErrorMessage);
	}

	@Test(priority = 48)
	public void verifyTheUSerIsAbleDoChangePasswordByEnteringWrongNewPAssword() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, wrongPassword,
				newPassword, userStatus1.newPasswordFieldErrorMessagElement);
	}

	@Test(priority = 49)
	public void verifyTheUSerIsAbleDoChangePasswordByEnteringWrongConformPAssword() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToUpdateWithoutEnterAnyOnePasswordTextfieldUTILITY(newPassword, newPassword,
				wrongPassword, userStatus1.conformPassErrorMessage);
	}

	@Test(priority = 50)
	public void VerifyTheUserIsAbleToChangePasswordByEnterPasswwordLessThanCharacterLimitU() {
		userStatus1.navigateToChangePasswordPage();
		userStatus1.userIsAbleToChangePasswordByEnterPasswwordLessThanCharacterLimit(newPassword,
				PaswordLessThanEightCharacter, userStatus1.newPasswordFieldErrorMessagElement);
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
	

		  //Edit
		//@Test
		public void UserStatusEdit() throws Throwable {
			
			userStatus1.navigateToMenuSetup();
			userStatus1.callLogatTabViewClick();
			userStatus1.NavigateToUserStatus();
			
			userStatus1.EditStatus();  //Edit mandatory field name
			userStatus1.EditDescriptnField();  
			userStatus1.multiseletToMenuHide();
		}
		

	
	@AfterTest
	public void tearDown() {
		driver.manage().window().minimize();
		driver.quit();
		reports.flush();
	}
}
