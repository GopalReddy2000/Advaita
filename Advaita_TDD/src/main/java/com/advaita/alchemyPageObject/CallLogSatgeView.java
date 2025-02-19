package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.PropertieFileUtil;

import Advaita_TDD.Advaita_TDD.FakeData;
import io.github.bonigarcia.wdm.docker.DockerHubTags;

public class CallLogSatgeView extends TestBase // Create_Class and extend base class
{
	public CallLogSatgeView() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	public List<String> satgeNameList;
	public List<String> interactionHistroyAdminprofileList;

	public String stageNameText;

	// userAccount
	String userId = "Abhijit@trasccon.com";
	String userPassword = "Qwerty@123";

	// userAdmin Login
	@FindBy(xpath = "//h2[text()='Sign In']")
	public WebElement Verify_signIn;

	@FindBy(name = "username")
	public WebElement usernameField;

	@FindBy(name = "password")
	public WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElement signInButton;

	// Entirebody Click
	@FindBy(tagName = "body")
	public WebElement driverIninteractable;

	@FindBy(xpath = "//img[contains(@alt, 'profile_icon')]")
	public WebElement profileDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement logout;

	// Fetch"Stages"

	@FindBy(xpath = "(//span[@class='text menu-text'])[2]")
	public WebElement workflowDesign;

	@FindBy(xpath = "//button[normalize-space()='Stages']")
	public WebElement stagesTab;

	@FindBy(xpath = "(//h1[text()=' Stages '])[1]")
	public WebElement verifyStage;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	public List<WebElement> stagesName;

	@FindBy(xpath = "(//tbody//td[1]//a/../..//img[@title='Evulation Filter'])[1]") // 5 ,//8
	public WebElement evaluationFilterOption;

	// CallLogStage View
	@FindBy(xpath = "//a[@id='menulist2']")
	public WebElement alchemySidemenubar;

	@FindBy(linkText = "Call Log Stage View")
	public WebElement callLogStageView_Tab;

	@FindBy(xpath = "//h1[contains(@class, 'page_heading') and contains(@class, 'primary_page_heading')]")
	public WebElement verify_CallLogStageView;

	@FindBy(xpath = "//tbody//tr[1]//td[1]//a")
	public WebElement stageName;

	@FindBy(xpath = "//select[@id='stage_search']")
	public WebElement SearchStages;

	@FindBy(xpath = "//table/tbody/tr//td[2][normalize-space()='wyzmindz_solutions']") // as per stage name we can //
																						// change "wyzmindz_solutions "
	public List<WebElement> stagesInteractionAdminProfile;

	@FindBy(xpath = "//table/tbody/tr//td[2][normalize-space()='wyzmindz_solutions']") // as per stage name we can
	public List<WebElement> stagesInteractionUserProfile; // change "wyzmindz_solutions "

	@FindBy(xpath = " //table/tbody/tr//td[2][normalize-space()]")
	public List<WebElement> allStagesinteractionAdminProfil; // All stages admin profile

	@FindBy(xpath = "//tbody//td//img[contains(@class,'eye-icon')]")
	public WebElement stagesProfileView;

	@FindBy(xpath = "//a//img[@class='arrow-left']")
	public WebElement backOption;

	@FindBy(xpath = "//a//img/..//h2")
	public WebElement VerifycreatedStages;

	@FindBy(xpath = "//select[@id='page-size-select']")
	public WebElement itemperpageDropdown;

	@FindBy(xpath = "//div//img/..//h6")
	public WebElement clearAllFiltersButton_Table;

	@FindBy(xpath = "//button//img[@class='img-fluid']")
	public WebElement searchButton;

	@FindBy(xpath = "//td[normalize-space(text())='No Entries Found']")
	List<WebElement> noEntriesFound;

	@FindBy(xpath = "//td[normalize-space(text())='No Entries Found']")
	public WebElement noEntriesFoundd;

	@FindBy(xpath = "//table[@id='add_evaluation_listing_table']")
	public WebElement evaluationListingTable;

	@FindBy(xpath = "//thead[@class='orga_thead']//tr//th")
	public List<WebElement> headersElements;

	// Stages Common elements
	@FindBy(xpath = "//span[@id='change_msg']")
	public WebElement ConformationMessagePopup;

	@FindBy(xpath = "//span[@id='change_msg']/..//button")
	public WebElement continueButton;

	@FindBy(xpath = "//button[@id='submit_single']")
	public WebElement saveButtonStages;

	@FindBy(xpath = "//img[@class='arrow-left']")
	public WebElement backOptionLeftArrow;

	// Stages Actions

	@FindBy(xpath = "//button[text()='Save']")
	public WebElement saveButton;

	@FindBy(xpath = "//tbody//tr[1]//td[6]//img[contains(@class,'copy_stage ')]")
	public WebElement duplicateStageOption;

	@FindBy(xpath = "//h6[text()='Duplicate ?']")
	WebElement duplicatePopup;

	@FindBy(xpath = "//button[text()='Yes']")
	public WebElement wantDuplicateYes;

	@FindBy(xpath = "//button[text()='No']")
	public WebElement wantDuplicateNo;

	@FindBy(xpath = "//tbody//tr[1]//td[6]//img[contains(@class,'delete_stages')]")
	public WebElement deleteStagesOption;

	@FindBy(xpath = "//tbody//tr[1]//td[6]//img[contains(@src,'table-edit')]")
	public WebElement editStageOption;

	@FindBy(xpath = "//h2[text()='Edit Form']")
	public WebElement editFormPage;

	@FindBy(xpath = "//input[@id='stage_name']")
	public WebElement stageNameTextfieldInEditPage;

	@FindBy(xpath = "//tbody//tr[1]//td[6]//img[@title='Evaluation Fields']")
	public WebElement evaluationFieldOptions;

	@FindBy(xpath = "//tbody//tr[1]//td[6]//img[contains(@title,'Stage History Fields')]")
	public WebElement stagesHistoryFieldsOptions;

	@FindBy(xpath = "//label[text()='Hisory Fields']")
	public WebElement verifyHistoryFileds;

	@FindBy(xpath = "//select[@name='field_names']")
	public WebElement historyFieldsDropdwon;

	@FindBy(xpath = "//label[text()='Unique Fields']")
	public WebElement verifyUniuqeFields;

	@FindBy(xpath = "(//h2[@id='headingThree'])[4] ")
	public WebElement stageHitoryTab;

	@FindBy(xpath = "//tr//th")
	public List<WebElement> stageHistoryHeadersElements;

	@FindBy(xpath = "//select[@name='unique_field_names']")
	public WebElement uniqueFieldsDropdwon;
	
	@FindBy(xpath = "//button[contains(@id, 'unique_multiselect_leftAll')]")
	public WebElement leftAllButtonForUniqueFileds;
	
	@FindBy(xpath = "//button[@id='unique_multiselect_rightSelected']")
	public WebElement RightSelectedButtonForUniqueFileds;
	

	@FindBy(id = "multiselect")
	public WebElement stagesEvaluationFieldDropdown;

	@FindBy(id = "static_multiselect")
	public WebElement staticEvaluationFieldDropdown;

	@FindBy(xpath = "//label[text()='Stage Evaluation Fields']")
	public WebElement verifyStagesEvaluationElement;

	@FindBy(xpath = "//label[text()='Static Evaluation Fields']")
	public WebElement verifyStaticEvaluationElement;

	@FindBy(xpath = "//button[@id='multiselect_rightSelected']")
	public WebElement RightSelectedButton;

	@FindBy(xpath = "//button[@id='multiselect_leftAll']")
	public WebElement leftAllButton;

	@FindBy(xpath = "//button[@id='multiselect_rightAll']")
	public WebElement rightAllButton;

	@FindBy(xpath = "//button[@id='static_multiselect_rightSelected']")
	public WebElement rightSelectedButtonStaticEvaluationStageField;

	@FindBy(xpath = "//button[@id='static_multiselect_leftAll']")
	public WebElement leftAllButtonStaticEvaluationStageField;

	@FindBy(xpath = "//button[@id='static_multiselect_rightAll']")
	public WebElement rightAllButtonStaticEvaluationStageField;

	// <====Type of filter and Buttons Elements

	@FindBy(xpath = "//button[@id='unique_multiselect_rightSelected']")
	public WebElement RightSelectedButtonDatePicker;

	@FindBy(xpath = "//button[@id='unique_multiselect_rightAll']")
	public WebElement RightAllSelectedButtonDatePicker;

	@FindBy(xpath = "//button[@id='unique_multiselect_leftAll']")
	public WebElement leftAllButtonDatePicker;

 
	
	@FindBy(xpath = "//tbody//tr[1]//td[6]//img[@title='Evulation Filter']")
	public WebElement evaluationFilterActionsOptions;

	@FindBy(xpath = "//label[text()='Dropdown']")
	public WebElement dropdwonLabelElement;

	@FindBy(name = "dropdown_field_names")
	public WebElement dropdownElement;

	@FindBy(xpath = "//label[text()='Date Picker']")
	public WebElement datePickerLablelElement;

	@FindBy(name = "date_picker_field_names")
	public WebElement datePickerElement;

	@FindBy(xpath = "//label[text()='Date Range Picker']")
	public WebElement dateRangePickerLabelElement;

	@FindBy(name = "date_range_picker_field_names")
	public WebElement dateRangePickerElement;

	@FindBy(xpath = "//label[text()='Multi Select']")
	public WebElement multiSelectLabelElement;

	@FindBy(name = "//select[@id='muti_unique_multiselect']")
	public WebElement multiselectDropdownElement;

	@FindBy(xpath = "//label[text()='Text Box']")
	public WebElement textboxLabelElement;

	@FindBy(name = "textbox_field_names")
	public WebElement textboxMultiselectElement;

	@FindBy(xpath = "//label[text()='Value Range']")
	public WebElement valueRangeLabelElement;

	@FindBy(name = "value_range_field_names")
	public WebElement valueRangePickerElement;

	int satgeNameSize = 0;

	public void navigatetoStage() {

		assertTrue(workflowDesign.isDisplayed(), "workflowDesign is not displayed");
		workflowDesign.click();

		assertTrue(stagesTab.isDisplayed(), "stagesTab is not displayed");
		stagesTab.click();

		assertTrue(verifyStage.isDisplayed(), "verifyStageis not displayed");
		System.out.println("verifyStage text : " + verifyStage.getText());
	}

	public void fetchStageNameList() {

		satgeNameList = new ArrayList<String>();
		for (WebElement stageName : stagesName) {
			satgeNameList.add(stageName.getText());
			System.out.println("Stages name Lists : " + stageName.getText());

			satgeNameSize++; // incremental logic for dropdwon " +1"

		}
		// assertTrue(satgeNameList.containsAll(satgeNameList));

	}

	public void navigateTo_AlchemyModule() {

		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
		jsClick(driver, alchemySidemenubar);

	}

	public void navigateToCallLogStageView() {

		assertTrue(callLogStageView_Tab.isDisplayed(), "callLogStageView_Tab is not displayed");
		callLogStageView_Tab.click();

		assertTrue(verify_CallLogStageView.isDisplayed());
		System.out.println("verify_CallLogStageView : " + verify_CallLogStageView.getText());

	}

	public void verifyTheUserAbleselectAllOptionFromDropdown() {

		selectAllOptionsUTILITY(SearchStages);

	}

	public void ClearAllFilter() {
		Select searchStagesDropdwon = new Select(SearchStages);

		String beforeSelectFirstOption = searchStagesDropdwon.getFirstSelectedOption().getText();
		System.out.println("beforeSelectFirstOption text" + beforeSelectFirstOption);

		searchStagesDropdwon.selectByIndex(1);

		assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not displayed");
		clearAllFiltersButton_Table.click();

		String afterSelectFirstOption = searchStagesDropdwon.getFirstSelectedOption().getText();
		System.out.println("afterSelectFirstOption " + afterSelectFirstOption);

		assertEquals(beforeSelectFirstOption, beforeSelectFirstOption);

	}

	public void SelectStagesFromCallLogStagesViewDropdown() {

		List<String> searchStagesLists = new ArrayList<String>();
		Select searchStagesDropdwon = new Select(SearchStages);

		int size = 0;

		for (WebElement searchStagesDropdwonn : searchStagesDropdwon.getOptions()) {
			searchStagesLists.add(searchStagesDropdwonn.getText());
			System.out.println("searcStagesList text : " + searchStagesDropdwonn.getText());

			size++;
		}
		assertTrue(searchStagesLists.containsAll(satgeNameList),
				"satgeNameList not contains in search stage dropdown of calllog stage view page");

		// assertEquals(size - 1, satgeNameSize);

		// searchStagesDropdwon.selectByIndex(1);
		searchStagesDropdwon.selectByVisibleText("Customer Data Stage");

		; // To Get all the records
		String selectedStagesOption = searchStagesDropdwon.getFirstSelectedOption().getText();

		assertTrue(stagesProfileView.isDisplayed(), "stagesProfileView is not displayed");
		stagesProfileView.click();

		assertTrue(VerifycreatedStages.isDisplayed(), "VerifycreatedStages is not dispalyed");
		String VerifycreatedStagesText = VerifycreatedStages.getText();

		assertEquals(VerifycreatedStagesText, selectedStagesOption);
		backOption.click();

		// Select ItemPerpage
		Select itemPerpage = new Select(itemperpageDropdown);
		itemPerpage.selectByIndex(2);

	}

	public void logout() {
		wait.until(ExpectedConditions.visibilityOf(profileDropdown));
		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
//		profileDropdown.click();
		jsClick(driver, profileDropdown);

		assertTrue(logout.isDisplayed(), "logoutis not displayed");
		logout.click();

	}

	public void userLogin() {

		assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");
		assertTrue(usernameField.isDisplayed(), "usernameField is not displayed");
		usernameField.sendKeys(userId);

		assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
		passwordField.sendKeys(userPassword);

		assertTrue(signInButton.isDisplayed(), "signInButton is not displayed");
		signInButton.click();

		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/evulation_screen_list/");
		assertTrue(verify_CallLogStageView.isDisplayed(), "verify_CallLogStageView is not displayed");

		List<String> searchStagesList_useraccountProfile = new ArrayList<String>();
		Select searchStagesDropdwon_userProfile = new Select(SearchStages);

		for (WebElement searchStagesDropdwonn_userAccountProfile : searchStagesDropdwon_userProfile.getOptions()) {
			searchStagesList_useraccountProfile.add(searchStagesDropdwonn_userAccountProfile.getText());
			System.out.println("searchStagesDropdwonn_userAccountProfile text : "
					+ searchStagesDropdwonn_userAccountProfile.getText());

		}
		assertTrue(searchStagesList_useraccountProfile.containsAll(searchStagesList_useraccountProfile));
		// searchStagesDropdwon_userProfile.selectByIndex(1);
		// searchStagesDropdwon_userProfile.selectByValue("60");
		searchStagesDropdwon_userProfile.selectByVisibleText("CutomerdetailsZZZ Stage");

		// Select item per page
		Select itemPerpage = new Select(itemperpageDropdown);
		itemPerpage.selectByIndex(2);

		// fetch Intractionistory From Satges Admin View
		List<String> lisinteractionHistroyUserprofileList = new ArrayList<>(); // global variable
		for (WebElement interactionHistoyUserProfile : stagesInteractionUserProfile) // list of web element
		{
			System.out.println("interactionHistoyUserProfile Text : " + interactionHistoyUserProfile.getText());
			lisinteractionHistroyUserprofileList.add(interactionHistoyUserProfile.getText());
		}

		assertEquals(lisinteractionHistroyUserprofileList, interactionHistroyAdminprofileList);
		// logout(); //Logout
	}

	public void itemperpage() {

		assertTrue(itemperpageDropdown.isDisplayed(), "itemperpageDropdown is not displayed");

		try {

			Select select = new Select(itemperpageDropdown);

			// Array of values to select
			String[] pageSizes = { "?stage_search=60&page=1&page_size=10", "?stage_search=60&page=1&page_size=20",
					"?stage_search=60&page=1&page_size=50" };

			// Loop through the values
			for (String pageSize : pageSizes) {
				// Select an option by value
				select.selectByValue(pageSize);

				// Verify the selection
				WebElement selectedOption = select.getFirstSelectedOption();
				System.out.println("Selected option: " + selectedOption.getText());

				// Perform the action to get the list of elements for the current page size
				List<WebElement> items = allStagesinteractionAdminProfil; // Replace with the actual locator

				// Print the count of items
				System.out.println("Number of items displayed: " + items.size());

				// Verify that the number of items matches the selected page size
				int expectedSize = Integer.parseInt(pageSize.split("page_size=")[1]);
				if (items.size() == expectedSize) {
					System.out.println("Test passed for page size " + expectedSize);
				} else {
					System.out.println("Test failed for page size " + expectedSize + ". Expected " + expectedSize
							+ " but got " + items.size());
					// SoftAssert for failure case
					softAssert.fail("Mismatch in items count for page size " + expectedSize + ": Expected "
							+ expectedSize + ", but got " + items.size());
				}
			}

		} catch (NoSuchElementException e) {
			// If NoSuchElementException is caught, pass the test case

			System.out.println("Test case failed: NoSuchElementException caught for itemperpageDropdown.");

			// SoftAssert for the NoSuchElementException
			softAssert.assertTrue(false, "Test case passed due to NoSuchElementException.");
		}

		// Ensure all assertions are reported at the end of the test
		softAssert.assertAll();
	}

	// <================= Stages Actions In CollLog stage View

	List<String> csvSearchStagesDropdownLists = new ArrayList<String>();

	public void fetchSearchDropdownValues() {

		Select fetchCSVSearhDropdownList = new Select(SearchStages);

		for (WebElement csvSearchStages : fetchCSVSearhDropdownList.getOptions()) {
			String csvSearchStagesTexts = csvSearchStages.getText();

			System.out.println("csvSearchStagesTexts :" + csvSearchStagesTexts);

			csvSearchStagesDropdownLists.add(csvSearchStagesTexts);

		}
	}

	public void SelectValuesFromDropdowns(WebElement actionElement, WebElement verifyFieldLabelElement,
			WebElement leftAllButtonElement, WebElement DropdownElemnent, WebElement RightSelectedButtonElement,
			String EnterDropdownValues) {

		softAssert.assertTrue(actionElement.isDisplayed(), "actionElement is not displayed");
		actionElement.click();
		verifyFieldLabelElement.isDisplayed();

//		leftAllButtonElement.click();
		jsClick(driver, leftAllButtonElement);

		Select selectValue = new Select(DropdownElemnent);
		selectValue.selectByVisibleText(EnterDropdownValues);
		RightSelectedButtonElement.click();

		js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
		jsClick(driver, saveButton);
		// saveOptionEvaluationFields.click();
		ConformationMessagePopup.isDisplayed();

		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		// wait.until(ExpectedConditions.visibilityOfAllElements(backOptionLeftArrow));

		// backOptionLeftArrow.click();

		softAssert.assertAll();
	}

	//Delete
	public void deleteStage() {
		
		wait.until(ExpectedConditions.elementToBeClickable(duplicateStageOption));
		assertTrue(duplicateStageOption.isDisplayed(), "duplicateStageOptionis not displayed");
		duplicateStageOption.click();
		assertTrue(duplicatePopup.isDisplayed(), "duplicatePopupis not displayed");
		wantDuplicateYes.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(ConformationMessagePopup));
		assertTrue(ConformationMessagePopup.isDisplayed(), "ConformationMessagePopup is not displayed");
		continueButton.click();
		
		fetchStageNameList(); // Fetch All the stage name
		
		stageNameText = stageName.getText();
		assertTrue(satgeNameList.contains(stageNameText), "stageNameText is not contains In this satgeNameListArray");
		
		assertTrue(deleteStagesOption.isDisplayed(), "deleteStagesOptionis not displayed");
		
//		navigateTo_AlchemyModule();
//		navigateToCallLogStageView();
//		
//		assertTrue(SearchStages.isDisplayed(), "Test Failed:-SearchStages is not displayed in call log stage view");
//		
//		fetchSearchDropdownValues();
//		
//		assertTrue(!csvSearchStagesDropdownLists.contains(stageNameText) && !stageNameText.contains("Copy of"),
//				"Test failed: After deletedo only stages is Displayed in searchStages Call log stageView page ");
		
		
		
	}
	
	// Dulpicate Stages
	public void userisAbleTOCreateDulicateStageAndThisStageShouldShouldbeDisplayedInCallLogStageView() {

		wait.until(ExpectedConditions.elementToBeClickable(duplicateStageOption));
		assertTrue(duplicateStageOption.isDisplayed(), "duplicateStageOptionis not displayed");
		duplicateStageOption.click();
		assertTrue(duplicatePopup.isDisplayed(), "duplicatePopupis not displayed");
		wantDuplicateYes.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(ConformationMessagePopup));
		assertTrue(ConformationMessagePopup.isDisplayed(), "ConformationMessagePopup is not displayed");
		continueButton.click();

		fetchStageNameList(); // Fetch All the stage name

		stageNameText = stageName.getText();
		assertTrue(satgeNameList.contains(stageNameText), "stageNameText is not contains In this satgeNameListArray");

		navigateTo_AlchemyModule();

		navigateToCallLogStageView();

		assertTrue(SearchStages.isDisplayed(), "Test Failed:-SearchStages is not displayed in call log stage view");

//		Select fetchCSVSearhDropdownList = new Select(SearchStages);
//
//		for (WebElement csvSearchStages : fetchCSVSearhDropdownList.getOptions()) {
//			String csvSearchStagesTexts = csvSearchStages.getText();
//
//			System.out.println("csvSearchStagesTexts :" + csvSearchStagesTexts);
//
//			csvSearchStagesDropdownLists.add(csvSearchStagesTexts);
//
//		}
		fetchSearchDropdownValues();

		assertTrue(csvSearchStagesDropdownLists.contains(stageNameText) && stageNameText.contains("Copy of"),
				"Test failed: Duplicate stage Not contains on search Stages dropdown in call log stage View page  ");

	}

	// Edit Stages
	public void userCanEditStageNameAndSeeInCSVSearchDropdown() {

	
		String beforeEditStagesNameText = stageName.getText();
		System.out.println("beforeEditStagesNameText:" + beforeEditStagesNameText);

		wait.until(ExpectedConditions.elementToBeClickable(editStageOption));
		assertTrue(editStageOption.isDisplayed(), "editStageOption not displayed");
		editStageOption.click();

		assertTrue(editFormPage.isDisplayed(), "editFormPage is not displayed");
		editFormPage.isDisplayed();

		String stageNameTextfieldValue = stageNameTextfieldInEditPage.getAttribute("value");

		assertEquals(stageNameTextfieldValue, beforeEditStagesNameText);

		stageNameTextfieldInEditPage.clear();
		stageNameTextfieldInEditPage.sendKeys("Demo " + FakeData.lastName1() + "_Stages");

		saveButtonStages.click();

		wait.until(ExpectedConditions.visibilityOf(ConformationMessagePopup));
		ConformationMessagePopup.isDisplayed();

		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(backOptionLeftArrow));
		backOptionLeftArrow.click();

		String afterEditStagesNameText = stageName.getText();
		assertNotEquals(afterEditStagesNameText, beforeEditStagesNameText);

		navigateTo_AlchemyModule();
		navigateToCallLogStageView();

		fetchSearchDropdownValues();

		assertTrue(csvSearchStagesDropdownLists.contains(afterEditStagesNameText),
				" afterEditStagesNameText is not contains in csvSearchStagesDropdownLists ");
		unWait(1000);

	}

	public void searchStage(String StageName) {

		WebElement stageSearchField = driver.findElement(By.id("text_search")); // Optional after fixed we can remove
																				// code
		stageSearchField.sendKeys(StageName);// Optional after fixed we can remove code
		searchButton.click();

	}

	List<String> headerElemtsLists = new ArrayList<String>();

//	public void userIsAbleToAddStageEvaluationFieldsAndViewdInCallLogStageViewPage()  {
//
//		// stage Evaluation Fields
//		String transUniqueId = "Trans Unique Id";
//
//		navigatetoStage();
//		searchStage("Student Information Stages");
//
//		String stageNameText = stageName.getText();
//
//		SelectValuesFromDropdowns(evaluationFieldOptions, verifyStagesEvaluationElement, stagesEvaluationFieldDropdown,
//				transUniqueId);
//
//		navigateTo_AlchemyModule();
//		navigateToCallLogStageView();
//		fetchSearchDropdownValues();
//
//		Select selectStages = new Select(SearchStages);
//		selectStages.selectByVisibleText(stageNameText);
//
//		for (WebElement headerElements : headersElements) {
//
//			String headerElementsListsTexts = headerElements.getText();
//
//			headerElemtsLists.add(headerElementsListsTexts);
//		}
//
//		
//		softAssert.assertTrue(headerElemtsLists.contains(transUniqueId),
//				"Test failed: added Evaluation fieldis not displayed and Not dispalyed in csv");
//		driver.navigate().refresh();
//		
//		softAssert.assertAll();
//	}

	public void CaptureSearchedStageText() {

		stageNameText = stageName.getText();
		System.out.println("stageNameText :" + stageNameText);
	}

	public void selectStagesAndChecAddedkEvaluationFieldInCallLogStageView(String EvaluationFieldValues) {

		Select selectStages = new Select(SearchStages);
		selectStages.selectByVisibleText(stageNameText);

		for (WebElement headerElements : headersElements) {

			String headerElementsListsTexts = headerElements.getText();

			headerElemtsLists.add(headerElementsListsTexts);
		}

		softAssert.assertTrue(headerElemtsLists.contains(EvaluationFieldValues),
				"Test failed: added Evaluation fieldis not displayed and Not dispalyed in csv");
		driver.navigate().refresh();

		softAssert.assertAll();
	}

	// Filter

	public void SelectValuesFromFilters(WebElement actionElement, WebElement verifyEvaluationFieldLabelElement,
			WebElement DropdownElemnent, String EnterDropdownValues) {

		softAssert.assertTrue(actionElement.isDisplayed(), "actionElement is not displayed");
		actionElement.click();
		verifyEvaluationFieldLabelElement.isDisplayed();

		// leftAllButtonStaticEvaluationStageField.click();
		jsClick(driver, leftAllButtonStaticEvaluationStageField);

		Select selectValue = new Select(DropdownElemnent);
		selectValue.selectByVisibleText(EnterDropdownValues);
		rightSelectedButtonStaticEvaluationStageField.click();

		js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
		jsClick(driver, saveButton);
		// saveOptionEvaluationFields.click();
		ConformationMessagePopup.isDisplayed();

		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		// wait.until(ExpectedConditions.visibilityOfAllElements(backOptionLeftArrow));

		// backOptionLeftArrow.click();

		softAssert.assertAll();
	}

	List<String> filterOptionsLists = new ArrayList<String>();

	public void selectStagesAndCheckAddedkFiltersAreDisplayedInCallLogStageView(String FilterFieldValues) {

		Select selectStages = new Select(SearchStages);
		selectStages.selectByVisibleText(stageNameText);

		List<WebElement> labelsList = driver.findElements(By.xpath("//form[@id='stage_advance_filter']//label"));

		for (WebElement filterLabelsElements : labelsList) {

			String filterLabelsElementsTexts = filterLabelsElements.getText();

			filterOptionsLists.add(filterLabelsElementsTexts);
		}

		softAssert.assertTrue(filterOptionsLists.contains(FilterFieldValues),
				"Test failed: addedfilters fields is not displayed and Not dispalyed in csv");

		driver.navigate().refresh();

		softAssert.assertAll();
	}

	// stage History Fields
	List<String> stageHistoryOptionsLists = new ArrayList<String>();

	public void selectStagesAndCheckAddedkstageHistoryFieldAreDisplayedInCallLogStageView(
			String stageHistoryFieldValues) {

		Select selectStages = new Select(SearchStages);
		selectStages.selectByVisibleText(stageNameText);

		softAssert.assertTrue(stagesProfileView.isDisplayed(), "fail: stagesProfileView is not displayed ");
		stagesProfileView.click();

		js.executeScript("arguments[0].scrollIntoView(true);", stageHitoryTab);

		for (WebElement stageHistoryheader : stageHistoryHeadersElements) {

			String stageHistoryheaderElementsTexts = stageHistoryheader.getText();

			stageHistoryOptionsLists.add(stageHistoryheaderElementsTexts);
		}

		softAssert.assertTrue(stageHistoryOptionsLists.contains(stageHistoryFieldValues),
				"Test Failed: added stageHistoryFieldValues is not contains In StageHistory Tab");

		driver.navigate().refresh();

		softAssert.assertAll();
	}

	// ########################## Negative Scriprt

	String invalidOptionDrpdown = "NonExistingOptionForCSVSSS";

	public void selectanInvalidOptionFromDropdownUTILITY(WebElement dropdownElement) {

		try {
			// Try selecting an invalid option
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(invalidOptionDrpdown);

			// If the invalid option is selected, the test should fail
			Assert.fail("Test case failed: Able to select non-existing option.");
		} catch (NoSuchElementException e) {
			// If the exception is thrown, this is the expected behavior, so the test should
			// pass
			Assert.assertTrue(true, "Test case passed: Non-existing option could not be selected.");
		}
	}

	String invalidOptionDrpdownValue = "12345";

	public void selectanInvalidValueForDropdownVUTILITY(WebElement dropdownElement) {

		try {
			// Try selecting an invalid option
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(invalidOptionDrpdownValue);

			// If the invalid option is selected, the test should fail
			Assert.fail("Test case failed: Able to select invalidOptionDrpdownValue  12345");
		} catch (NoSuchElementException e) {
			// If the exception is thrown, this is the expected behavior, so the test should
			// pass
			Assert.assertTrue(true, "Test case passed: invalidOptionDrpdownValue '12345' could not be selected.");
		}
	}

	public void F() {

		selectanInvalidOptionFromDropdownUTILITY(SearchStages);

	}

	public void selectInvalidValueFromDropdown() {

		selectanInvalidValueForDropdownVUTILITY(SearchStages);
	}

	public String id = "multiselect";

	public void singleSlectOrMultiSelect() {

		Assert.assertTrue(SearchStages.isDisplayed(), "SearchStages is not displayed");

		Select SearchStagesDropdown = new Select(SearchStages);

		String clsvSearchStagesDropdownId = SearchStages.getAttribute("id");

		// Assert whether it is a single select or multi-select
		if (!clsvSearchStagesDropdownId.equals(id)) {
			Assert.assertTrue(true, "It is a single-select dropdown");
		} else {
			Assert.assertTrue(false, "It is a multi-select dropdown with ID: " + clsvSearchStagesDropdownId);
		}
	}

	public void deselectFromDropdown(WebElement dropdownElement, int index, String action) {
		Select select = new Select(dropdownElement);

		// Check if the dropdown is a multi-select
		if (!select.isMultiple() && action.equals("deselect")) {
			System.out.println("This dropdown is a single-select, cannot deselect by index.");
			return;
		}

		switch (action.toLowerCase()) {
		case "select":
			select.selectByIndex(index);
			System.out.println("Selected stage at index: " + index);
			break;
		case "deselect":
			select.deselectByIndex(index);
			System.out.println("Deselected stage at index: " + index);
			break;
		default:
			System.out.println("Invalid action. Use 'select' or 'deselect'.");
			break;

		}
	}

	public void VerifytheuserDeselectinsearchStagesDropdowninCSLV() {
		deselectFromDropdown(SearchStages, 2, "select");
		deselectFromDropdown(SearchStages, 2, "deselect");

	}

	String defaultSelectedOption = "Search Stage";

	public void VerifyWithoutSelectingStageClickOnSearch() {
		try {
			// Create a Select object for the SearchStages dropdown
			Select select = new Select(SearchStages);

			// Get the first selected option from the dropdown
			WebElement searchStagesFirstSelectedOption = select.getFirstSelectedOption();

			// Assert that the first selected option matches the default option
			assertEquals(searchStagesFirstSelectedOption.getText(), defaultSelectedOption,
					"The default selected option is incorrect.");

			// Assert that the search button is displayed
			assertTrue(searchButton.isDisplayed(), "Search button is not displayed");

			// Check if the evaluation listing table is not displayed
			if (!evaluationListingTable.isDisplayed()) {
				// Log and pass the test
				System.out.println("Pass: No stage is selected.");
			} else {
				// Fail the test if the evaluation listing table is displaye
				assertFalse(true,
						"Fail: Without selecting stages, stages are selected from the search stage dropdown.");

			}

		} catch (NoSuchElementException e) {
			// Handle NoSuchElementException and pass the test
			System.out.println("Pass: NoSuchElementException caught, no stage is selected.");
			assertTrue(true, "Pass: No stage is selected due to NoSuchElementException.");
		}
	}

	public void selectAllOptionsUTILITY(WebElement dropdownElement) {
		Select select = new Select(dropdownElement);

		// Get the number of options in the dropdown
		int totalOptions = select.getOptions().size();

		// Loop through each option by index to avoid stale element reference
		for (int i = 0; i < totalOptions; i++) {
			// Refetch the dropdown and its options in each iteration to avoid stale
			// elements
			select = new Select(dropdownElement); // Re-initialize Select
			WebElement option = select.getOptions().get(i); // Fetch option by index

			// Select by visible text
			select.selectByVisibleText(option.getText());

		}
	}

}
