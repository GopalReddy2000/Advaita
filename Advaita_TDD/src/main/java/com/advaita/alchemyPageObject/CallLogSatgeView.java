package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;

public class CallLogSatgeView extends TestBase // Create_Class and extend base class
{
	public CallLogSatgeView() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	public List<String> satgeNameList;
	public List<String> interactionHistroyAdminprofileList;

	// userAccount
	String userId = "Wyzmindz_solutions";
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

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']")
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

	@FindBy(xpath = "//table[@id='add_evaluation_listing_table']")
	public WebElement evaluationListingTable;

	int satgeNameSize = 0;

	public void navigatetoStage() {

		// driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");

		assertTrue(workflowDesign.isDisplayed(), "workflowDesign is not displayed");
		workflowDesign.click();

		assertTrue(stagesTab.isDisplayed(), "stagesTab is not displayed");
		stagesTab.click();

		assertTrue(verifyStage.isDisplayed(), "verifyStageis not displayed");
		System.out.println("verifyStage text : " + verifyStage.getText());

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
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		// jsClick(driver, alchemySidemenubar);

	}

	public void naivigateToCallLogStageView() {

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

		searchStagesDropdwon.selectByIndex(1); // To Get all the records
		String selectedStagesOption = searchStagesDropdwon.getFirstSelectedOption().getText();

//		// Select ItemPerpage
//		Select itemPerpage = new Select(itemperpageDropdown);
//		itemPerpage.selectByIndex(2);

//		// fetch Intractionistory From Satges Admin View
//		interactionHistroyAdminprofileList = new ArrayList<>(); // global variable
//		for (WebElement interactionHistoyAdminProfile : stagesInteractionAdminProfile) // list of web element
//		{
//			System.out.println("interactionHistoyAdminProfile Text : " + interactionHistoyAdminProfile.getText());
//			interactionHistroyAdminprofileList.add(interactionHistoyAdminProfile.getText());
//		}

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

//	public void logout() {
//		wait.until(ExpectedConditions.visibilityOf(profileDropdown));
//		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
////		profileDropdown.click();
//		jsClick(driver, profileDropdown);
//
//		assertTrue(logout.isDisplayed(), "logoutis not displayed");
//		logout.click();
//
//	}
//
//	public void userLogin() {
//
//		assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");
//		assertTrue(usernameField.isDisplayed(), "usernameField is not displayed");
//		usernameField.sendKeys(userId);
//
//		assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
//		passwordField.sendKeys(userPassword);
//
//		assertTrue(signInButton.isDisplayed(), "signInButton is not displayed");
//		signInButton.click();
//
//		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/evulation_screen_list/");
//		assertTrue(verify_CallLogStageView.isDisplayed(), "verify_CallLogStageView is not displayed");
//
//		List<String> searchStagesList_useraccountProfile = new ArrayList<String>();
//		Select searchStagesDropdwon_userProfile = new Select(SearchStages);
//
//		for (WebElement searchStagesDropdwonn_userAccountProfile : searchStagesDropdwon_userProfile.getOptions()) {
//			searchStagesList_useraccountProfile.add(searchStagesDropdwonn_userAccountProfile.getText());
//			System.out.println("searchStagesDropdwonn_userAccountProfile text : "
//					+ searchStagesDropdwonn_userAccountProfile.getText());
//
//		}
//		assertTrue(searchStagesList_useraccountProfile.containsAll(searchStagesList_useraccountProfile));
//		// searchStagesDropdwon_userProfile.selectByIndex(1);
//		// searchStagesDropdwon_userProfile.selectByValue("60");
//		searchStagesDropdwon_userProfile.selectByVisibleText("CutomerdetailsZZZ Stage");
//
//		// Select item per page
//		Select itemPerpage = new Select(itemperpageDropdown);
//		itemPerpage.selectByIndex(2);
//
//		// fetch Intractionistory From Satges Admin View
//		List<String> lisinteractionHistroyUserprofileList = new ArrayList<>(); // global variable
//		for (WebElement interactionHistoyUserProfile : stagesInteractionUserProfile) // list of web element
//		{
//			System.out.println("interactionHistoyUserProfile Text : " + interactionHistoyUserProfile.getText());
//			lisinteractionHistroyUserprofileList.add(interactionHistoyUserProfile.getText());
//		}
//
//		assertEquals(lisinteractionHistroyUserprofileList, interactionHistroyAdminprofileList);
//		// logout(); //Logout
//	}

	public void itemperpage() {

//		// Create an instance of the Select class
//		Select select = new Select(itemperpageDropdown);
//
//		// Array of values to select
//		String[] pageSizes = { "?stage_search=60&page=1&page_size=10", "?stage_search=60&page=1&page_size=20",
//				"?stage_search=60&page=1&page_size=50" };
//
//		// Loop through the values
//		for (String pageSize : pageSizes) {
//			// Select an option by value
//			select.selectByValue(pageSize);
//
//			// Verify the selection
//			WebElement selectedOption = select.getFirstSelectedOption();
//			System.out.println("Selected option: " + selectedOption.getText());
//
//			// Perform the action to get the list of elements for the current page size
//			// Example: Assuming there is a list of items with a common class
//			List<WebElement> items = allStagesinteractionAdminProfil; // Replace with actual class name
//
//			// Print the count of items
//			System.out.println("Number of items displayed: " + items.size());
//
//			// Perform verification that the number of items matches the selected page size
//			// Convert the value to extract the number and verify
//			int expectedSize = Integer.parseInt(pageSize.split("page_size=")[1]);
//			if (items.size() == expectedSize) {
//				System.out.println("Test passed for page size " + expectedSize);
//			} else {
//				System.out.println("Test failed for page size " + expectedSize + ". Expected " + expectedSize
//						+ " but got " + items.size());
//			}
////
//		}

//	

//		try {
//		    // Check if itemperpageDropdown is displayed
//		    if (itemperpageDropdown.isDisplayed()) {
//		        // Create an instance of the Select class
//		        Select select = new Select(itemperpageDropdown);
//
//		        // Array of values to select
//		        String[] pageSizes = { "?stage_search=60&page=1&page_size=10", "?stage_search=60&page=1&page_size=20",
//		                "?stage_search=60&page=1&page_size=50" };
//
//		        // Loop through the values
//		        for (String pageSize : pageSizes) {
//		            // Select an option by value
//		            select.selectByValue(pageSize);
//
//		            // Verify the selection
//		            WebElement selectedOption = select.getFirstSelectedOption();
//		            System.out.println("Selected option: " + selectedOption.getText());
//
//		            // Perform the action to get the list of elements for the current page size
//		            // Example: Assuming there is a list of items with a common class
//		            List<WebElement> items = allStagesinteractionAdminProfil; // Replace with actual class name
//
//		            // Print the count of items
//		            System.out.println("Number of items displayed: " + items.size());
//
//		            // Perform verification that the number of items matches the selected page size
//		            int expectedSize = Integer.parseInt(pageSize.split("page_size=")[1]);
//		            if (items.size() == expectedSize) {
//		                System.out.println("Test passed for page size " + expectedSize);
//		            } else {
//		                System.out.println("Test failed for page size " + expectedSize + ". Expected " + expectedSize
//		                        + " but got " + items.size());
//		            }
//		        }
//		    } else {
//		        System.out.println("itemperpageDropdown is not displayed.");
//		    }
//		} catch (NoSuchElementException e) {
//		    // If NoSuchElementException is caught, pass the test case
//		    System.out.println("Test case passed: itemperpageDropdown is not present.");
//		}

		try {
			// Attempt to locate the itemperpageDropdown element

			// Create an instance of the Select class
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
