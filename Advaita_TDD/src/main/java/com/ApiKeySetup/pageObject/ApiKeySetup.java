package com.ApiKeySetup.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;

import Advaita_TDD.Advaita_TDD.FakeData;

public class ApiKeySetup extends TestBase {

	// Global Variables
	String sms = "SMS";
	String whatsAPP = "WhatsAPP";
	String email = "Email";
	String whatsAppBusiness = "whatsApp Business";

	String keyfor = "SMS";
	String authType = "NoAuth";
	String methodType = "GET";

	String vendorName = FakeData.lastName1() + "_VN";

	String headerName = FakeData.lastName1() + "_HN";
	String headerValue = FakeData.lastName1() + "_HV";

	String fieldName = FakeData.lastName1() + "_FN";
	String fieldValue = FakeData.lastName1() + "_FV";

	String selectedFirstOptionFromDropdwon;

	private static final String PROPERTIES_FILE_ApiKey_PATH3 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\apiKey.properties";

	// <<<<<<<<<< Elements

	@FindBy(xpath = "//a//span[text()='API Key Setup']")
	public WebElement apiKeysetUpModule;

	@FindBy(xpath = "(//h1[text()=' API Key Setup '])[1]")
	public WebElement verifyApiKeySetup;

	@FindBy(linkText = "+ Create")
	public WebElement CreateOption;

	@FindBy(xpath = "//label[text()='Api Name*']")
	public WebElement apiNameLabel;

	@FindBy(id = "api_name")
	public WebElement apiNametextfield;

	@FindBy(xpath = "//label[text()='Process*']")
	public WebElement processDropdownLabel;

	@FindBy(id = "process")
	public WebElement ProcessDropdown;

	@FindBy(xpath = "//label[text()='Sub Process*']")
	public WebElement subProcessDropdownLabel;

	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement subProcessDropdown;

	@FindBy(xpath = "//label[text()='Sub Sub Process*']")
	public WebElement subSubProcessDropdownLabel;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement subSubProcessDropdown;

	@FindBy(xpath = "//label[text()='Stages*']")
	public WebElement stageLabel;

	@FindBy(id = "stage_name_id")
	public WebElement stageDropdown;

	@FindBy(xpath = "//label[text()='Keyfor *']")
	public WebElement keyForLabel;

	@FindBy(xpath = "//label[text()='Keyfor *']/..//select")
	public WebElement keyForDropdown;

	@FindBy(xpath = "//label[text()='Auth Type *']")
	public WebElement authTypeLabel;

	@FindBy(id = "auth_type_id")
	public WebElement authTpeDropdown;

	@FindBy(xpath = "//label[text()='Key']")
	public WebElement keyLabel;

	@FindBy(xpath = "//input[@name='auth_field_val_1']")
	public WebElement keyTextfield;

	@FindBy(xpath = "//label[text()='Value']")
	public WebElement valueLabel;

	@FindBy(xpath = "//input[@name='auth_field_val_2']")
	public WebElement valueTextfield;

	@FindBy(xpath = "//label[text()='AddTo']")
	public WebElement addToDrodownlabel;

	@FindBy(xpath = "//select[@name='auth_field_val_3']")
	public WebElement addToDropdown;

	@FindBy(xpath = "//label[text()='Token']")
	public WebElement tokenLabel;

	@FindBy(xpath = "//input[contains(@name, 'auth_field_val_')]")
	public WebElement token;

	@FindBy(xpath = "//label[text()='Method Type']")
	public WebElement methodTypeLabel;

	@FindBy(xpath = "//label[text()='UserName']")
	public WebElement usernameLabel;

	@FindBy(name = "auth_field_val_4")
	public WebElement userName;

	@FindBy(xpath = "//label[text()='Password']")
	public WebElement passwordLabel;

	@FindBy(name = "auth_field_val_5")
	public WebElement password;

	@FindBy(xpath = "//input[contains(@name, 'auth_field_val_7')]")
	public WebElement tokenOAuth2;

	@FindBy(xpath = "//label[text()='Header Prefix']")
	public WebElement headerPrefixLabel;

	@FindBy(name = "auth_field_val_8")
	public WebElement headerPerfix;

	@FindBy(id = "method_type_id")
	public WebElement methodTypeDropdown;

	@FindBy(xpath = "//label[text()='API URL*']")
	public WebElement apiUrlLabel;

	@FindBy(id = "api_url")
	public WebElement apiUrlTextfield;

	@FindBy(id = "vendor_name")
	public WebElement vendorNametextfield;

//	@FindBy(xpath = "//a[text()='+ Add Row']")
//	List<WebElement> addRowOptions;

	@FindBy(xpath = "(//a[text()='+ Add Row'])[1]")
	public WebElement addRowOptions1;

	@FindBy(xpath = "(//a[text()='+ Add Row'])[2]")
	public WebElement addRowOptions2;

	@FindBy(xpath = "(//a[text()='+ Add Row'])[3]")
	public WebElement addRowOptions3;

	// <<<<< Additional Header List
	@FindBy(xpath = "//input[contains(@name,'header_name')]")
	public List<WebElement> verifyadditionHeaderListSize;

	@FindBy(xpath = "//input[@name='header_name_1']")
	public WebElement headerName_AdditionalHeaderList;

	@FindBy(xpath = "//input[@name='header_val_1']")
	public WebElement headerValue_AdditionalHeaderList;

	// <<<<<<Custom Parameter List
	@FindBy(xpath = "//input[contains(@name,'field_name')]")
	public List<WebElement> verifyCustomParametrListSize;

	@FindBy(name = "field_name_1")
	public WebElement fieldNameTextfield;

	@FindBy(name = "field_val_1")
	public WebElement fieldValueTextfield;

	// Stage Parameter List
	@FindBy(xpath = "//input[contains(@name,'api_variable_name')]")
	public List<WebElement> verifyStageParametrListSize;

	@FindBy(name = "api_variable_name_1")
	public WebElement variableNameTextfield;

	@FindBy(name = "default_val_1")
	public WebElement dafaultValueTextfield;

	@FindBy(xpath = "//button[text()=' Create ']")
	public WebElement CreateButton;

	@FindBy(xpath = "(//th[1]/../../..//td[1])[1]")
	public WebElement Created_apiName;

	// Table
	@FindBy(id = "process_search")
	public WebElement searchProcess;

	@FindBy(id = "sub_process_search")
	public WebElement searchSubProcess;

	@FindBy(id = "s_sub_process_search")
	public WebElement searchSubSubProcess;

	@FindBy(id = "stage_search")
	public WebElement searchStages;

	@FindBy(xpath = "(//select[@name='auth_type'])[1]")
	public WebElement searchAuthType;

	@FindBy(xpath = "(//select[@name='keyfor'])[1]")
	public WebElement SearchKeyFor;

	// Verify Selected Process
	@FindBy(xpath = "(//thead//tr//th/../../..//td)[2]")
	public WebElement firstProcess;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[3]")
	public WebElement firstSubProcess;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[4]")
	public WebElement firstSubSubProcess;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[5]")
	public WebElement firstStage;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[6]")
	public WebElement seacrchAuthType;

	@FindBy(xpath = "(//thead//tr//th/../../..//td)[7]")
	public WebElement seacrchKeyFor;

	@FindBy(xpath = "//button[contains(@class,'filter_search_blk')]")
	public WebElement searchButton;

	@FindBy(xpath = "(//img[@alt='delete-icon '])[1]")
	public WebElement deleteOption;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public WebElement deletePopup_ApiKeysetup;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement deleteButton_delete;

	@FindBy(xpath = "//h3/..//span[text()='Deleted Successfully']")
	public WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public WebElement continueButton_DeleteSuccessullyPopup;

	public ApiKeySetup() {
		PageFactory.initElements(driver, this);
	}

	// Helper method User By the References Of this Classes
	PropertieFileUtil propertieFileUtil = new PropertieFileUtil();
	DropDown dropDown = new DropDown();
	FieldVerificationUtils fieldVerificationUtils = new FieldVerificationUtils();

	// Dropdown Utils
	public void dropdownUtils(WebElement dropdownElement, String expectedOptionText) throws Throwable {
		// Step 1: Initialize WebDriverWait to handle dynamic waits
		// Step 2: Ensure the dropdown element is visible and clickable
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));

		// Step 3: Initialize Select object with the provided dropdown element
		Select dropdown = new Select(dropdownElement);

		// Step 4: Retrieve all options in the dropdown
		List<WebElement> allDropdownOptions = dropdown.getOptions();

		// Step 5: Loop through each dropdown option and compare with expectedOptionText
		boolean isOptionClicked = false;
		for (WebElement option : allDropdownOptions) {
			try {
				String dropdownValue = option.getText();

				// Compare expectedOptionText with the dropdown option value
				if (dropdownValue.equals(expectedOptionText)) {
					// Assert that the correct dropdown value has been found
					assertEquals(dropdownValue, expectedOptionText, "Dropdown value did not match!");

					// Wait until the option is clickable and click it
					wait.until(ExpectedConditions.elementToBeClickable(option));
					option.click();

					// Step 8: Break the loop once the match is found and clicked
					isOptionClicked = true;
					break;
				}
			} catch (StaleElementReferenceException e) {
				// Re-fetch the options in case of a StaleElementReferenceException
				allDropdownOptions = dropdown.getOptions();
			}
		}

		Thread.sleep(2000);
		// Assert that the option has been clicked
		assertTrue(isOptionClicked, "No matching dropdown option found and clicked.");
	}

	public void naviagteToAPiKeySetup() {

		actions.scrollToElement(apiKeysetUpModule);
		wait.until(ExpectedConditions.visibilityOf(apiKeysetUpModule));
		assertTrue(apiKeysetUpModule.isDisplayed(), "apiKeysetUpModule is nOt dispalyed");

		jsClick(driver, apiKeysetUpModule);

	}

	public void verifyApiKeysetp() {

		assertTrue(verifyApiKeySetup.isDisplayed(), "Failed: verifyApiKeySetup is not Displayed");

	}

	public void naviagteToCreate() {

		String CurrentUrl = driver.getCurrentUrl();
		System.out.println("Captured URL: " + CurrentUrl);

		assertTrue(CreateOption.isDisplayed(), "CreateOption is nOt dispalyed");
		CreateOption.click();

		String expectedUrl = driver.getCurrentUrl();

		// assertNotEquals(expectedUrl, CurrentUrl, "Faile : Curent url and expected Url
		// are matched");

	}

	public void EnterApiName() throws IOException {

		// check For Manadatort One
		fieldVerificationUtils.checkthroughAsterisk(apiNameLabel, true);

		assertTrue(apiNametextfield.isDisplayed(), "Failed: APi name Is Not Displayed");
		apiNametextfield.isEnabled();
		apiNametextfield.sendKeys(FakeData.lastName1());
		String apiNameValue = apiNametextfield.getAttribute("value");
		System.out.println("apiNameValue :" + apiNameValue);

		PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"ApiName", apiNameValue);

	}

	// Process Select Process
	public void selectProcess(String selectProcess) throws Throwable {

//		fieldVerificationUtils.checkthroughAsterisk(processDropdownLabel, true);
//
//		// Fetch Data FDrom Prperties File
//		String process = PropertieFileUtil.getSingleTextFromPropertiesFile("process");
//
//		// select Process Dropdown
//		dropDown.dropdownUtils(ProcessDropdown, process);

		switch (selectProcess) {
		case "givenprocessname":

			fieldVerificationUtils.checkthroughAsterisk(processDropdownLabel, true);

			// Fetch Data FDrom Prperties File
			String process = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"process");

			// select Process Dropdown
			dropDown.dropdownUtils(ProcessDropdown, process);

			break;

		case "randomprocess":

			fieldVerificationUtils.checkthroughAsterisk(processDropdownLabel, true);

			// select Process Dropdown
			DropDown.selectRandomOptionFromDropdwon(ProcessDropdown);

			break;

		default:
			break;
		}

	}

	public void selectSubProcess(String selectSubProcess) throws Throwable {

//		fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);
//
//		// Fetch Data FDrom Prperties File
//		String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess");
//
//		// select Process Dropdown
//		dropDown.dropdownUtils(subProcessDropdown, subProcess);

		switch (selectSubProcess) {

		case "givenSubprocessname":

			fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);

			// Fetch Data FDrom Prperties File
			String subProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"subProcess");

			// select Process Dropdown
			dropDown.dropdownUtils(subProcessDropdown, subProcess);

			break;

		case "randomSubprocess":

			fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(subProcessDropdown);

			break;

		default:
			break;
		}

	}

	public void selectSubSubProcess(String selectSubSubProcess) throws Throwable {

//		fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);
//
//		// Fetch Data FDrom Prperties File
//		String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess");
//
//		// select Process Dropdown
//		dropDown.dropdownUtils(subSubProcessDropdown, subSubProcess);

		switch (selectSubSubProcess) {
		case "givensubsubprocessname":

			fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);

			// Fetch Data FDrom Prperties File
			String subSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"subSubProcess");

			// select Process Dropdown
			dropDown.dropdownUtils(subSubProcessDropdown, subSubProcess);

			break;

		case "randomSubSubprocess":

			fieldVerificationUtils.checkthroughAsterisk(subProcessDropdownLabel, true);

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(subSubProcessDropdown);

			break;

		default:
			break;
		}

	}

	public void selectStages(String givenStageName) throws Throwable {

//		fieldVerificationUtils.checkthroughAsterisk(stageLabel, true);
//
//		// Fetch Data FDrom Prperties File
//		String stage = PropertieFileUtil.getSingleTextFromPropertiesFile("stage");
//
//		// select Process Dropdown
//		dropDown.dropdownUtils(stageDropdown, stage);

		switch (givenStageName) {

		case "givenStageName":

			fieldVerificationUtils.checkthroughAsterisk(stageLabel, true);

			// Fetch Data FDrom Prperties File
			String stage = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"stage");

			// select Process Dropdown
			dropDown.dropdownUtils(stageDropdown, stage);

			break;

		case "randomStage":

			fieldVerificationUtils.checkthroughAsterisk(stageLabel, true);

			// select SubProcess Dropdown
			DropDown.selectRandomOptionFromDropdwon(stageDropdown);

			break;

		default:
			break;
		}

	}

	public void selectKeyFor(String selectKeyForOption) throws Throwable {

//		fieldVerificationUtils.checkthroughAsterisk(keyForLabel, true);
//
//		// extract all aoptions From Dropdown and Store In Prop file by "key name"
//		PropertieFileUtil.extractDropdownOptions(keyForDropdown, "KeyFor");
//
//		String selectKeyFor = PropertieFileUtil.getSingleTextFromPropertiesFile("KeyFor2");
//
//		// dropDown.selectFromDropdownByText(keyForDropdown, selectKeyFor);

		switch (selectKeyForOption) {

		case "givenkeyoption":

			System.out.println("You are In givenKey option");

			fieldVerificationUtils.checkthroughAsterisk(keyForLabel, true);

			// extract all aoptions From Dropdown and Store In Prop file by "key name"
			PropertieFileUtil.extractAllDropdownOptions(PROPERTIES_FILE_ApiKey_PATH3,keyForDropdown, "KeyFor");

			String selectKeyFor = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"KeyFor2");

			dropDown.selectFromDropdownByText(keyForDropdown, selectKeyFor);

			break;

		case "randomkeyoption":

			fieldVerificationUtils.checkthroughAsterisk(keyForLabel, true);

			// extract all aoptions From Dropdown and Store In Prop file by "key name"
			PropertieFileUtil.extractAllDropdownOptions(PROPERTIES_FILE_ApiKey_PATH3,keyForDropdown, "KeyFor");

			DropDown.selectRandomOptionFromDropdwon(keyForDropdown);

			break;

		default:
			System.out.println("Invalid or unsupported KeyFor: " + keyForDropdown);
			break;
		}

	}

	public void SelectAuthType() throws IOException {

		fieldVerificationUtils.checkthroughAsterisk(authTypeLabel, true);

		// extract all aoptions From Dropdown and Store In Prop file by "key name"
		PropertieFileUtil.extractAllDropdownOptions(PROPERTIES_FILE_ApiKey_PATH3,authTpeDropdown, "AuthType");

		String authType = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"AuthType6");
		System.out.println("authType :" + authType);

		dropDown.selectFromDropdownByText(authTpeDropdown, authType);

	}

	// SelectAuthType_NOAuth
	public void SelectAuthTypeNoAuth(String AuthType) throws IOException {
		SelectAuthTypeDynamically(AuthType);
	}

	// SelectAuthType_NOAuth
	public void SelectAuthTypeDynamically(String AuthType) throws IOException {

		fieldVerificationUtils.checkthroughAsterisk(authTypeLabel, true);

		// extract all aoptions From Dropdown and Store In Prop file by "key name"
		PropertieFileUtil.extractAllDropdownOptions(PROPERTIES_FILE_ApiKey_PATH3,authTpeDropdown, "AuthType");

		String authType = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,AuthType);
		System.out.println("authType :" + authType);

		dropDown.selectFromDropdownByText(authTpeDropdown, authType);
	}

	// Global variables for each auth type
	public String noAuth_Case1 = "NoAuth";
	public String apiKey_Case1 = "API Key";
	public String bearerToken_Case1 = "Bearer Token";
	public String basicAuth_Case1 = "Basic Auth";
	public String OAuth2_Case1 = "OAuth2";

	// Main handler
	public void handleAuthSelection(String authType) throws Throwable {
		handleAuthTypeSelection(authType);
	}

	// Main handler
	public void handleAuthTypeSelection(String authType) throws Throwable {
		// Prepare a list of all supported auth types
		List<String> allAuthTypes = Arrays.asList(noAuth_Case1, apiKey_Case1, bearerToken_Case1, basicAuth_Case1,
				OAuth2_Case1);

		// If authType is null or empty, select a random one
		if (authType == null || authType.trim().isEmpty()) {
			Random random = new Random();
			authType = allAuthTypes.get(random.nextInt(allAuthTypes.size()));
			System.out.println("Randomly selected Auth Type: " + authType);
		}

		switch (authType) {
		case "NoAuth":
			System.out.println("NoAuth selected: No credentials needed.");
			break;

		case "API Key":
			SelectAuthTypeDynamically("AuthType3");
			EnterKeytextfield();
			EntervalueTextfield();
			selectAddTo();
			System.out.println("API Key selected: Show API Key input field.");
			break;

		case "Bearer Token":
			SelectAuthTypeDynamically("AuthType4");
			generateSendAndStoreBearerToken(); // Taken random Bearer Token
			System.out.println("Bearer Token selected: Show Bearer Token input field.");
			break;

		case "Basic Auth":
			SelectAuthTypeDynamically("AuthType5");
			enterUserName();
			enterPassword();
			System.out.println("Basic Auth selected: Show username and password fields.");
			break;

		case "OAuth2":
			SelectAuthTypeDynamically("AuthType6");
			verifyTheUserIsabelToenterOauth();
			verifyTheUserIsabelToHeadrperfixOnOauth2();
			System.out.println("OAuth 2.0 selected: Initiate OAuth login flow.");
			break;

		default:
			System.out.println("Invalid or unsupported Auth Type: " + authType);
			break;
		}
	}

	public void SelectMethodType(String MethodType) throws Throwable {

//		fieldVerificationUtils.checkthroughAsterisk(methodTypeLabel, false);
//
//		// extract all aoptions From Dropdown and Store In Prop file by "key name"
//		PropertieFileUtil.extractDropdownOptions(methodTypeDropdown, "MethodType");
//
//		String selectMethodType = PropertieFileUtil.getSingleTextFromPropertiesFile("MethodType4");
//		dropDown.selectFromDropdownByText(methodTypeDropdown, selectMethodType);

		switch (MethodType) {

		case "givenMethodType":

			System.out.println("You are In givenmethodTpe Case");

			fieldVerificationUtils.checkthroughAsterisk(methodTypeLabel, false);

			// extract all aoptions From Dropdown and Store In Prop file by "key name"
			PropertieFileUtil.extractAllDropdownOptions(PROPERTIES_FILE_ApiKey_PATH3,methodTypeDropdown, "MethodType");

			String selectMethodType = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"MethodType4");
			dropDown.selectFromDropdownByText(methodTypeDropdown, selectMethodType);

			break;

		case "RandomMethodType":

			fieldVerificationUtils.checkthroughAsterisk(keyForLabel, true);

			// extract all aoptions From Dropdown and Store In Prop file by "key name"
			PropertieFileUtil.extractAllDropdownOptions(PROPERTIES_FILE_ApiKey_PATH3,keyForDropdown, "MethodType");

			DropDown.selectRandomOptionFromDropdwon(methodTypeDropdown);

			break;

		default:
			System.out.println("Invalid or unsupported MethodType: " + methodTypeDropdown);
			break;
		}
	}

	// Gererate Random Url
	public String generateValidCoverrApiUrl() {
		String[] baseUrls = { "https://api.coverr.co/video/", "https://coverr.io/api/v1/resource/",
				"https://media.coverr.dev/stream/" };

		java.util.Random random = new java.util.Random();
		String base = baseUrls[random.nextInt(baseUrls.length)];
		String randomPath = "id-" + java.util.UUID.randomUUID().toString().substring(0, 8);
		String queryParams = "?ref=" + random.nextInt(1000) + "&env=staging";

		String finalUrl = base + randomPath + queryParams;

		// ✅ Basic validation (format only, no network call)
		if (!finalUrl.startsWith("https://")) {
			throw new IllegalArgumentException("URL must start with 'https://'");
		}

		if (!finalUrl.contains("coverr")) {
			throw new IllegalArgumentException("URL must contain 'coverr' domain.");
		}

		return finalUrl;
	}

	public void EnertApiUrl() throws Throwable {

		fieldVerificationUtils.checkthroughAsterisk(apiUrlLabel, true);

		String Url = generateValidCoverrApiUrl();

		apiUrlTextfield.sendKeys(Url);

		PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"APIURl", Url);

	}

	public void EnertVendorName() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(vendorNametextfield));
		assertTrue(vendorNametextfield.isDisplayed(), "Failed: vendorNametextfield is not Displayed");
		vendorNametextfield.isEnabled();

		String VN_Value = vendorNametextfield.getAttribute("value").trim();

		assertTrue(VN_Value.isEmpty(), "failed: textfield Value Is notNull");

		vendorNametextfield.sendKeys(vendorName);

		String expected_VNValue = vendorNametextfield.getAttribute("value");

		assertNotNull(expected_VNValue, "failed: textfield Value Is Null");

	}

	// Addditional Header List
	public void enterHeaderName() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(headerName_AdditionalHeaderList));
		assertTrue(headerName_AdditionalHeaderList.isDisplayed(), "Failed: HeaderNametextfield is not Displayed");
		headerName_AdditionalHeaderList.isEnabled();

		String HN_Value = headerName_AdditionalHeaderList.getAttribute("value").trim();

		assertTrue(HN_Value.isEmpty(), "failed: textfield Value Is notNull");

		headerName_AdditionalHeaderList.sendKeys(headerName);

		String expected_HNValue = headerName_AdditionalHeaderList.getAttribute("value");

		assertNotNull(expected_HNValue, "failed: textfield Value Is Null");

	}

	public void enterHeaderValue() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(headerValue_AdditionalHeaderList));
		assertTrue(headerValue_AdditionalHeaderList.isDisplayed(), "Failed: Header value textfield is not Displayed");
		headerValue_AdditionalHeaderList.isEnabled();

		String HV_Value = headerValue_AdditionalHeaderList.getAttribute("value").trim();

		assertTrue(HV_Value.isEmpty(), "failed: textfield Value Is notNull");

		headerValue_AdditionalHeaderList.sendKeys(headerValue);

		String expected_HV_Value = headerValue_AdditionalHeaderList.getAttribute("value");

		assertNotNull(expected_HV_Value, "failed: textfield Value Is Null");

	}

	// Customer Paramter List
	public void enterFieldName() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(fieldNameTextfield));
		assertTrue(fieldNameTextfield.isDisplayed(), "Failed: FieldNametextfield is not Displayed");
		fieldNameTextfield.isEnabled();

		String FN_Value = fieldNameTextfield.getAttribute("value").trim();

		assertTrue(FN_Value.isEmpty(), "failed: textfield Value Is notNull");

		fieldNameTextfield.sendKeys(fieldName);

		String expected_FNValue = fieldNameTextfield.getAttribute("value");

		assertNotNull(expected_FNValue, "failed: textfield Value Is Null");

	}

	public void enterFieldValue() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(fieldValueTextfield));
		assertTrue(fieldValueTextfield.isDisplayed(), "Failed: FieldValuetextfield is not Displayed");
		fieldValueTextfield.isEnabled();

		String FV_Value = fieldValueTextfield.getAttribute("value").trim();

		assertTrue(FV_Value.isEmpty(), "failed: textfield Value Is notNull");

		fieldValueTextfield.sendKeys(fieldName);

		String expected_FNValue = fieldValueTextfield.getAttribute("value");

		assertNotNull(expected_FNValue, "failed: textfield Value Is Null");

	}

	// stage paramter List
	public void entervariableName() throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(variableNameTextfield));
		assertTrue(variableNameTextfield.isDisplayed(), "Failed: variable Name textfield is not Displayed");
		variableNameTextfield.isEnabled();

		String veriableName_Value = variableNameTextfield.getAttribute("value").trim();

		assertTrue(veriableName_Value.isEmpty(), "failed: textfield Value Is notNull");

		variableNameTextfield.sendKeys(fieldName);

		String expected_variableNameValue = variableNameTextfield.getAttribute("value");

		assertNotNull(expected_variableNameValue, "failed: textfield Value Is Null");

	}

	public void selectStageField() throws Throwable {

	}

	public void clickOnCreateAndVerify() {
		assertTrue(CreateOption.isDisplayed(), "create Button is Not Displayed");
		CreateOption.isEnabled();
		jsClick(CreateButton);

	}

	public void verifyCreatedApiName() throws IOException {

		assertTrue(Created_apiName.isDisplayed(), "Created_apiNameis nloT Displayed");

		String Captured_apiNameText = Created_apiName.getText();

		String apiName = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"Api_Name");

		assertEquals(Captured_apiNameText, apiName, "Actaul result not Match With Expected Result(ApiName");

	}

	// Added Mutile row

	public void clickAddRowOptions(WebElement addRowOptions, int count) {

	}

//	// add Row and Very Size
//	public void addRowMultipleClick(WebElement addRowOptions, int numberOfClicks) {
//		addRowMultipleRowsClick(addRowOptions, numberOfClicks);
//	}

	// add Row and Very Size
	public void addRowMultipleRowsClick(WebElement addRowOptions, int numberOfClicks,
			List<WebElement> parameterListElement) {
		for (int i = 1; i < numberOfClicks; i++) {
			addRowOptions.click();

		}
		int size = parameterListElement.size();
		System.out.println("size: " + size);

		assertEquals(numberOfClicks, size);
	}

	public void verifyAddMultipleRowsInAdditionHeaderList() {

		addRowMultipleRowsClick(addRowOptions1, 5, verifyadditionHeaderListSize);
	}

	public void verifyAddMultipleRowsInCustomParameterList() {

		addRowMultipleRowsClick(addRowOptions2, 5, verifyCustomParametrListSize);
	}

	public void verifyAddMultipleRowsInStageParameterList() {

		addRowMultipleRowsClick(addRowOptions2, 5, verifyStageParametrListSize);
	}

	// Delete Row
	public void deleteRow() {

	}

	// Search Through Process
	// For Verify Slected Option (UTILITY_Method)
	public void checkForSelectedOptionsAfterSearched(WebElement dropdownElement, WebElement firstElemetFromTable) {

		Select select = new Select(dropdownElement);

		selectedFirstOptionFromDropdwon = select.getFirstSelectedOption().getText();
		System.out.println("fetchfirstSelectedOption :" + selectedFirstOptionFromDropdwon);

		assertTrue(firstElemetFromTable.isDisplayed(), "Test Failed:firstElemetFromtable is not Displayed");

		String firstElementText = firstElemetFromTable.getText();

		assertEquals(firstElementText, selectedFirstOptionFromDropdwon,
				"Test Failed : first selected Option Not Matched with First Element Text");

	}

	public void selectProcessInApiTablePage() throws IOException {

		String selectProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"process");

		dropDown.selectFromDropdownByText(searchProcess, selectProcess);

	}

	public void selectSubProcessInApiTablePage() throws Throwable {

		String selectSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"subProcess");

		dropDown.selectFromDropdownByText(searchSubProcess, selectSubProcess);
	}

	public void selectSubSubProcessInApiTablePage() throws IOException {

		String selectSubSubProcess = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"subSubProcess");

		dropDown.selectFromDropdownByText(searchSubSubProcess, selectSubSubProcess);
	}

	public void searchThroughStages() throws IOException {

		String selectstages = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"stage");

		dropDown.selectFromDropdownByText(searchStages, selectstages);
	}

	public void clickOnSearchButton() {

		assertTrue(searchButton.isDisplayed(), "searchButton is not Displayed");
		searchButton.click();
	}

	// verify with Process
	public void verifyselectedProcessShouldMatchWithProcess() {

		checkForSelectedOptionsAfterSearched(searchProcess, firstProcess);
	}

	// verify with SubProcess
	public void verifyselectedSubProcessShouldMatchWithSubProcess() {

		checkForSelectedOptionsAfterSearched(searchSubProcess, firstSubProcess);
	}

	// verify with SubSubProcess
	public void verifyselectedSubSubProcessShouldMatchWithSubSubProcess() {

		checkForSelectedOptionsAfterSearched(searchSubSubProcess, firstSubSubProcess);
	}

	@FindBy(xpath = "//table//td[1]")
	public List<WebElement> apiNames;

	List<String> CreatedApiNameList = new ArrayList<>();

	// Delete Api name
	public void deleteApiNameAndcheckIisDeletedOrNot() throws IOException {

		assertTrue(deleteOption.isDisplayed(), "deleteOption is Not Dispalyed");

		assertTrue(Created_apiName.isDisplayed(), "Created_apiName is not Displayed");
		String firstCreatedApiName = Created_apiName.getText();
		System.out.println("firstCreatedApiName :" + firstCreatedApiName);

		deleteOption.click();
		assertTrue(deletePopup_ApiKeysetup.isDisplayed(), "deletePopup_smsTemplate is Not Dispalyed");

		assertTrue(deleteButton_delete.isDisplayed(), "deleteButton_delete is not Displayed");
		deleteButton_delete.click();

		wait.until(ExpectedConditions.visibilityOf(deleted_SuceessfullyPopup));
		assertTrue(deleted_SuceessfullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is Not Displayed");

		assertTrue(continueButton_DeleteSuccessullyPopup.isDisplayed(),
				"continueButton_DeleteSuccessullyPopup is nOo Displayed");
		continueButton_DeleteSuccessullyPopup.click();

		driver.navigate().refresh();

		selectProcessInApiTablePage();
		clickOnSearchButton();

		// fetch all Api Names
		for (WebElement ierateApiNames : apiNames) {
			String apiNametexts = ierateApiNames.getText();
			CreatedApiNameList.add(apiNametexts);
			System.out.println("CreatedApiNameList: " + CreatedApiNameList);
		}

		assertTrue(CreatedApiNameList.contains(firstCreatedApiName),
				"Failed : firstCreated Is contains After deleting also");

	}

	// Generate Random BearerToken
	public void generateSendAndStoreBearerToken() {
		try {
			// 1. Generate 64-byte Bearer token
			SecureRandom secureRandom = new SecureRandom();
			byte[] tokenBytes = new byte[64];
			secureRandom.nextBytes(tokenBytes);
			String bearerToken = "Bearer " + Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);

			// 3. Send token via sendKeys

			wait.until(ExpectedConditions.visibilityOf(token));
			token.clear();
			token.sendKeys(bearerToken);

			// 4. Get attribute 'value' (what's in the field)
			String tokenValue = token.getAttribute("value");

			// 5. Store in properties file
			PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"BearerToken", tokenValue);
		} catch (Exception e) {
			System.err.println("Error handling Bearer token: " + e.getMessage());
		}
	}

	// generate Radndom passord
	public static String generatePassword(int length) {
		if (length < 8)
			throw new IllegalArgumentException("Password length should be at least 8");

		String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String LOWER = "abcdefghijklmnopqrstuvwxyz";
		String DIGITS = "0123456789";
		String SPECIAL = "@#$%^&+=!";
		String ALL = UPPER + LOWER + DIGITS + SPECIAL;

		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder(length);

		// Ensure at least one char from each category
		password.append(UPPER.charAt(random.nextInt(UPPER.length())));
		password.append(LOWER.charAt(random.nextInt(LOWER.length())));
		password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
		password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

		// Fill remaining length with random chars
		for (int i = 4; i < length; i++) {
			password.append(ALL.charAt(random.nextInt(ALL.length())));
		}

		// Shuffle characters
		char[] pwdArray = password.toString().toCharArray();
		for (int i = pwdArray.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			char temp = pwdArray[i];
			pwdArray[i] = pwdArray[j];
			pwdArray[j] = temp;
		}

		return new String(pwdArray);
	}

	private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String ALL = UPPER + LOWER + DIGITS;
	private static final SecureRandom random = new SecureRandom();

	public String generateAccessTokenAuth2(int length) throws IOException {
		if (length < 8) {
			throw new IllegalArgumentException("Token length must be at least 8");
		}

		// Step 1: Generate token
		StringBuilder token = new StringBuilder(length);
		token.append(UPPER.charAt(random.nextInt(UPPER.length())));
		token.append(LOWER.charAt(random.nextInt(LOWER.length())));
		token.append(DIGITS.charAt(random.nextInt(DIGITS.length())));

		for (int i = 3; i < length; i++) {
			token.append(ALL.charAt(random.nextInt(ALL.length())));
		}

		// Shuffle token
		char[] tokenArray = token.toString().toCharArray();
		for (int i = tokenArray.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			char temp = tokenArray[i];
			tokenArray[i] = tokenArray[j];
			tokenArray[j] = temp;
		}

		String finalToken = new String(tokenArray);

		// Step 2: Send token to UI input element

		tokenOAuth2.clear();
		tokenOAuth2.sendKeys(finalToken);

		// Step 3: Capture value from input field
		String captured0AuthValue = tokenOAuth2.getAttribute("value");

		// Step 4: Store in properties file
		PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"OAuth2.0", captured0AuthValue);

		return captured0AuthValue;
	}

	// MethodType Api_key
	public void EnterKeytextfield() throws IOException {

		fieldVerificationUtils.checkthroughAsterisk(keyForLabel, false);
		keyTextfield.isEnabled();
		keyTextfield.sendKeys(FakeData.lastName1() + "_key");

		String key = keyTextfield.getAttribute("value");

		PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"key", key);

	}

	public void EntervalueTextfield() throws IOException {

		fieldVerificationUtils.checkthroughAsterisk(valueLabel, false);
		valueTextfield.isEnabled();
		valueTextfield.sendKeys(FakeData.lastName1() + "_value");

		String Value = valueTextfield.getAttribute("value");

		PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"Value", Value);

	}

	public void selectAddTo() throws Throwable {

		fieldVerificationUtils.checkthroughAsterisk(addToDrodownlabel, false);

		// extract all aoptions From Dropdown and Store In Prop file by "key name"
		PropertieFileUtil.extractAllDropdownOptions(PROPERTIES_FILE_ApiKey_PATH3,addToDropdown, "AddTo");

		String addTo = PropertieFileUtil.getSingleTextFromPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"AddTo3");

		dropDown.selectFromDropdownByText(addToDropdown, addTo);

	}

	public void enterBearerToken() {

		fieldVerificationUtils.checkthroughAsterisk(tokenLabel, false);
		generateSendAndStoreBearerToken();

	}

	public void enterUserName() throws Throwable {

		fieldVerificationUtils.checkthroughAsterisk(usernameLabel, false);

		assertTrue(userName.isDisplayed(), "userName is not Displayed");
		userName.isEnabled();
		userName.clear();
		userName.sendKeys(FakeData.lastName1() + "_UN");

		String userNameValue = userName.getAttribute("value");

		PropertieFileUtil.storeSingleTextInPropertiesFile(PROPERTIES_FILE_ApiKey_PATH3,"UserNameBasicAuth", userNameValue);
	}

	public void enterPassword() {

		fieldVerificationUtils.checkthroughAsterisk(passwordLabel, false);
		generatePassword(12); // Based On Give Int valuee password length Must be Created

	}

	public void verifyTheUserIsabelToenterOauth() throws Throwable {

		fieldVerificationUtils.checkthroughAsterisk(tokenLabel, false);

		generateAccessTokenAuth2(20);
	}

	public void verifyTheUserIsabelToHeadrperfixOnOauth2() {

		fieldVerificationUtils.checkthroughAsterisk(headerPrefixLabel, false);

		assertTrue(headerPerfix.isDisplayed(), "headerPerfix is nOt Dispalyed");
		assertTrue(headerPerfix.isEnabled(), "headerPerfixis noT enabled");
		headerPerfix.clear();
		headerPerfix.sendKeys(FakeData.lastName1() + "_HP");

	}

}
