package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;

public class SkipReason extends TestBase {
	public SkipReason() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();
	public String FirstCreatedUserName;

	public WebElement driverIninteractable;

	public String beforeSearchCreatedSkipReasons;

	public String reasonNameTextfieldAttributeValue;

	public String lastCreatedSkipReasonText;

	String superAmdin = "Capture_Admin";
	String superAdminPass = "Qwerty@123";

	String userID = "Abhijit@trasccon";
	String userPassword = "Qwerty@123";

	String userId1 = "Abhijit_idamta";
	String password1 = "Qwerty@123";

	// process , subprocess , Subsubprocess

	@FindBy(xpath = "(//input[@data-type='process']/..//span)[1]")
	public WebElement fetchProcess;

	@FindBy(xpath = "//input[@data-type='sub_process']/..//span")
	public WebElement FethSubProcess;

	@FindBy(xpath = "(//div[@class='content']//span)[1]")
	public WebElement SubSubProcess;

	// Skip reason_ Create
	@FindBy(xpath = "//a/..//span[text()='Alchemy']") // a[@id='menulist2']
	public WebElement alchemySidemenubar;

	@FindBy(linkText = "Skip Reason")
	public WebElement skipReason_Tab;

	@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1")
	public WebElement Verify_skipReason;

	@FindBy(linkText = "+ Create")
	public WebElement createButton_SkipReasonPage;

	@FindBy(xpath = "//h2[text()='Create Skip Reason']")
	public WebElement verify_CreateSkipReason;

	@FindBy(xpath = "//select[@id='process']")
	public WebElement ProcessDropdown;

	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement SubProcessDropdown;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement SubsubProcessDropdown;

	@FindBy(id = "reason_name_id")
	public WebElement reasonName_textfield;

	@FindBy(id = "id_description")
	public WebElement description_textfield;

	@FindBy(xpath = "//h2/../..//button[@id='manual_id']")
	public WebElement createButton_createSkipReasonPopup;

	@FindBy(xpath = "//h2/../..//button[text()='Cancel']")
	public WebElement cancelButton_CreateSkipReasonPopup;

	@FindBy(xpath = "//span[text()='Skip Reason has been created successfully']")
	public WebElement successfullyCreated_popup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public WebElement continueButton_create;

	@FindBy(xpath = "//tbody/tr[last()]//td")
	public WebElement lastCreated_skipReason;

	@FindBy(xpath = "//tbody//tr//td[1]")
	public List<WebElement> CreatedSkipReasons;

	@FindBy(xpath = "//tbody/tr")
	public WebElement beforeCreatedSkipReasons_search;

	@FindBy(xpath = "//tbody/tr")
	public WebElement afterCreatedSkipReasons_search;

	// table

	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='delete-icon ']")
	public WebElement lastDleteButton_SkipReasonTable;

	@FindBy(name = "text_search")
	public WebElement seachElementTextfield;

	@FindBy(xpath = "//select[@id='process_search']")
	public WebElement processDropdown_Table;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public WebElement SubprocessDropdown_Table;

	@FindBy(id = "s_sub_process_search")
	public WebElement subSubProcessDropdown_Table;

	@FindBy(xpath = "//div[@class='row respo-filter-sub']//button")
	public WebElement searchButton_table;

	@FindBy(xpath = "//div[@class='row respo-filter-sub']//button/..//h6")
	public WebElement clearAllFilters_table;

	@FindBy(xpath = "//tbody//tr//td//img[@alt='delete-icon ']")
	public List<WebElement> DeleteButton;

	@FindBy(xpath = "(//tbody//tr//td//img[@alt='delete-icon '])[last()]")
	public WebElement deleteButtonLast;

	@FindBy(xpath = "//h6[text()='Delete ?']")
	public WebElement deletePopup;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement deleteButton_delete;

	@FindBy(xpath = "(//button[text()='Cancel'])[2]")
	public WebElement cancelButton_Delete;

	@FindBy(xpath = "//h3/..//span[text()='Deleted Successfully']")
	public WebElement deleted_SuceessfullyPopup;

	@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
	public WebElement continueButton_DeleteSuccessullyPopup;

	// edit
	@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='table-edit']")
	public WebElement lastEdit_skipReason;

	@FindBy(xpath = "//h2[text()='Create Skip Reason']")
	public WebElement verify_EditSkipReason;

	@FindBy(xpath = "//select[@id='process_search']")
	public WebElement processDropdown_Edit;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public WebElement subprocessDropdown_Edit;

	@FindBy(xpath = "//select[@id='sub_process_search']")
	public WebElement SubprocessDropdown_Edit;

	@FindBy(id = "reason_name_id")
	public WebElement reasonName_textfield_Edit;

	@FindBy(id = "id_description")
	public WebElement description_textfield_edit;

	@FindBy(xpath = "//button[text()=' Update ']")
	public WebElement UpdateButton;

	@FindBy(xpath = "(//button[text()='Cancel'])[1]")
	public WebElement cancelButton_edit;

	@FindBy(xpath = "//h3/..//span[text()='Skip Reason has been updated successfully']")
	public WebElement Update_SkipReasonSuccessfullyPopup;

	@FindBy(xpath = "//h3/..//span[text()='Skip Reason has been updated successfully']/..//button")
	public WebElement continueButon_SkipReasonSucessfullyUpdate;

	@FindBy(xpath = "//tbody//tr//td[position()=2 or position()=3 or position()=4]")
	public List<WebElement> allProcessElements;

	@FindBy(xpath = "//table/tbody//tr[1]//td[1]//img")
	public WebElement eyeIconProfileview;

	@FindBy(xpath = "//a[text()='Skip the Audit']")
	public WebElement skipAudit;

	@FindBy(xpath = "//h2[text()='Skip The Audit']")
	public WebElement verifySkipAudit;

	@FindBy(xpath = "//select[@id='reason_name']")
	public WebElement selectSkipReasonDropdown;

	// Dropdown Utils
	public void dropdownUtilsALL(WebElement dropdownElement, String selectionType, String selectionValue) {
		try {
			// Assert dropdown is displayed and enabled
			assertTrue(dropdownElement.isDisplayed(), "Dropdown is not visible.");
			assertTrue(dropdownElement.isEnabled(), "Dropdown is not enabled.");

			Select dropdown = new Select(dropdownElement);

			// Verify dropdown has options
			List<WebElement> options = dropdown.getOptions();
			assertTrue(!options.isEmpty(), "Dropdown has no options available.");

			// Perform selection based on type
			switch (selectionType.toLowerCase()) {
				case "text":
					dropdown.selectByVisibleText(selectionValue);
					break;
				case "value":
					dropdown.selectByValue(selectionValue);
					break;
				case "index":
					try {
						int index = Integer.parseInt(selectionValue);
						dropdown.selectByIndex(index);
					} catch (NumberFormatException e) {
						Assert.fail("Index should be an integer value.");
					}
					break;
				default:
					Assert.fail("Invalid selection type. Use 'text', 'value', or 'index'.");
			}

			// Verify the selected option
			WebElement selectedOption = dropdown.getFirstSelectedOption();
			switch (selectionType.toLowerCase()) {
				case "text":
					Assert.assertEquals(selectedOption.getText(), selectionValue,
							"Selected value doesn't match the expected text.");
					break;
				case "value":
					Assert.assertEquals(selectedOption.getAttribute("value"), selectionValue,
							"Selected value doesn't match the expected value.");
					break;
				case "index":
					Assert.assertEquals(options.indexOf(selectedOption), Integer.parseInt(selectionValue),
							"Selected index doesn't match the expected index.");
					break;
			}
			System.out.println("Successfully selected: " + selectedOption.getText());
		} catch (Exception e) {
			Assert.fail("An error occurred while interacting with the dropdown: " + e.getMessage());
		}
	}

	public void NavigateToFetchprocess() {
		driver.navigate().to("https://test.capture.autosherpas.com/en/data_management/process/");
		fetchProcess.getText();
		System.out.println("Fetchprocessname :" + fetchProcess.getText());

		fetchProcess.click();
		FethSubProcess.getText();
		System.out.println("FetchSubProcess name : " + FethSubProcess.getText());

		FethSubProcess.click();
		SubSubProcess.getText();
		System.out.println("Fetch SubSubProcessName : " + SubSubProcess.getText());

	}

	public void navigateTo_AlchemyModule() throws Throwable {

		// wait.until(ExpectedConditions.visibilityOf(alchemySidemenubar));
		// Thread.sleep(2000);
		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		jsClick(driver, alchemySidemenubar);

	}

	public void NavigateTo_Skipreason() {
		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/skip_reason_listing/");
		assertTrue(skipReason_Tab.isDisplayed(), "skipReason_Tabis not displayed");

		assertTrue(Verify_skipReason.isDisplayed(), "Verify_skipReason is not displayed");
		Verify_skipReason.click();

	}

	public void Crete_SkipReason() {
		assertTrue(createButton_SkipReasonPage.isDisplayed(), "createButton_SkipReasonPage");
		createButton_SkipReasonPage.click();

		wait.until(ExpectedConditions.visibilityOf(verify_CreateSkipReason));
		assertTrue(verify_CreateSkipReason.isDisplayed(), "verify_CreateSkipReason");
		verify_CreateSkipReason.getText();
		System.out.println("verify_CreateSkipReason : " + verify_CreateSkipReason.getText());

	}

	public void selectProcessDropdown() {
//			List<String>processDropdownList=new ArrayList<String>();
//
//			Select ProcessDropdown1=new Select(ProcessDropdown);
//			for (WebElement Options : ProcessDropdown1.getOptions()) 
//			{
//				wait.until(ExpectedConditions.visibilityOfAllElements(Options));
//				System.out.println(Options.getText());
//				processDropdownList.add(Options.getText());
//			}
//			assertTrue(	processDropdownList.contains("AJP")); 
//			ProcessDropdown1.selectByVisibleText("AJP");

		dropdownUtilsALL(ProcessDropdown, "text", "AJP");
	}

	public void SelectSubProcessDropdown() throws Throwable {
//		List<String> subProcessDropdownList = new ArrayList<String>();
//
//		Thread.sleep(2000);
//
//		Select subProcessDropdown2 = new Select(SubProcessDropdown);
//		for (WebElement options2 : subProcessDropdown2.getOptions()) {
//			Thread.sleep(1000);
//			System.out.println(subProcessDropdown2.getOptions());
//			subProcessDropdownList.add(options2.getText());
//		}
//
//		assertTrue(subProcessDropdownList.contains("Sub AJP"));
//		subProcessDropdown2.selectByVisibleText("Sub AJP");

		dropdownUtilsALL(SubProcessDropdown, "text", "Sub AJP");

	}

	public void selectSubSubProcess() throws Throwable {
//		List<String> subsubprocessDropdownList = new ArrayList<String>();
//		Thread.sleep(2000);
//		Select SubsubProcessDropdown3 = new Select(SubsubProcessDropdown);
//		for (WebElement options3 : SubsubProcessDropdown3.getOptions()) {
//			Thread.sleep(2000);
//			System.out.println(SubsubProcessDropdown3.getOptions());
//			subsubprocessDropdownList.add(options3.getText());
//		}
//		assertTrue(subsubprocessDropdownList.contains("Sub Sub AJP"));
//		SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
//		// actions.moveToElement(driverIninteractable).perform();

		dropdownUtilsALL(SubsubProcessDropdown, "text", "Sub Sub AJP");

	}

	public void continue_CreateSkinReason() {

		// reason textfield
		// Array of predefined Skipreasons for reasons textfield names
		String[] skipReasonNames = { "I have an urgent appointment to attend", "My internet connection is unstable",
				"I'm feeling unwell and need to rest", "I have a prior commitment that I can't miss",
				"I'm currently traveling and don't have access to my documents",
				"My computer crashed and I lost my progress", "I need more time to gather the required information",
				"There's a family emergency I need to take care of",
				"I'm experiencing technical difficulties with my device",
				"LI have a conflicting deadline that takes priority" };

		// Create a Random object
		Random random = new Random();

		// Generate a random index to select a template name
		int randomIndex = random.nextInt(skipReasonNames.length);

		// Print the selected random template name
		String randomTemplateName = skipReasonNames[randomIndex];
		System.out.println("Random SMS Template Name: " + randomTemplateName);

		assertTrue(reasonName_textfield.isDisplayed(), " reasonName_textfield is not dispalyed ");
		reasonName_textfield.sendKeys(randomTemplateName);

		reasonNameTextfieldAttributeValue = reasonName_textfield.getAttribute("value");
		System.out.println("reasonNameTextfieldAttributeValue :" + reasonNameTextfieldAttributeValue);

		// Random description
		String[] skipReasonDescription = {
				"Due to an unexpected appointment, I am unable to complete the form at this moment and must reschedule.",
				"My unreliable internet connection is preventing me from submitting the form, causing significant delays and interruptions in connectivity.",
				"My current illness necessitates immediate rest and recovery, making it impossible for me to complete the form right now.",
				"An existing engagement that I must attend leaves me unable to fill out the form at this particular time.",
				"Traveling without essential documents hinders my ability to provide the necessary information required to complete the form accurately.",
				"A computer crash resulted in the loss of all form data entered so far, necessitating a restart of the process.",
				"Gathering the required information for the form is taking longer than anticipated, and I need additional time to complete it.",
				"An urgent family emergency demands my immediate attention, making it impossible for me to focus on completing the form.",
				"Technical issues with my device are preventing me from accessing or completing the form, causing significant delays in submission.",
				"Another critical deadline conflicts with the form submission, requiring my immediate attention and postponing the form completion." };
		// Create a Random object
		Random random1 = new Random();

		// Generate a random index to select a template name
		int randomIndex1 = random.nextInt(skipReasonNames.length);

		// Print the selected random template name
		String randomTemplateName1 = skipReasonDescription[randomIndex1];
		System.out.println("Random SMS Template Name: " + randomTemplateName);

		assertTrue(description_textfield.isDisplayed(), " description_textfield is not dispalyed ");
		description_textfield.sendKeys(randomTemplateName1);

	}

//	///////////////////////////////////////////////////////////////////////////

	public void randomReasonTextField(WebElement reasonNameTextField) {
		// Array of predefined skip reasons for reason text field names
		String[] skipReasonNames = { "I have an urgent appointment to attend", "My internet connection is unstable",
				"I'm feeling unwell and need to rest", "I have a prior commitment that I can't miss",
				"I'm currently traveling and don't have access to my documents",
				"My computer crashed and I lost my progress", "I need more time to gather the required information",
				"There's a family emergency I need to take care of",
				"I'm experiencing technical difficulties with my device",
				"I have a conflicting deadline that takes priority" };

		Random random1 = new Random();

		// Generate a random index to select a reason
		int randomIndex = new Random().nextInt(skipReasonNames.length);
		String randomReason = skipReasonNames[randomIndex];
		System.out.println("Random Skip Reason: " + randomReason);

		// Assert and send the random reason to the reason text field
		assertTrue(reasonNameTextField.isDisplayed(), "Reason name text field is not displayed.");
		reasonNameTextField.sendKeys(randomReason);
	}

	// Populate description text field with a random description from predefined
	// list
	public void randomDescriptionTextField(WebElement descriptionTextField) {

		Random random1 = new Random();

		// Array of predefined descriptions for description text field
		String[] skipReasonDescriptions = {
				"Due to an unexpected appointment, I am unable to complete the form at this moment and must reschedule.",
				"My unreliable internet connection is preventing me from submitting the form, causing significant delays and interruptions in connectivity.",
				"My current illness necessitates immediate rest and recovery, making it impossible for me to complete the form right now.",
				"An existing engagement that I must attend leaves me unable to fill out the form at this particular time.",
				"Traveling without essential documents hinders my ability to provide the necessary information required to complete the form accurately.",
				"A computer crash resulted in the loss of all form data entered so far, necessitating a restart of the process.",
				"Gathering the required information for the form is taking longer than anticipated, and I need additional time to complete it.",
				"An urgent family emergency demands my immediate attention, making it impossible for me to focus on completing the form.",
				"Technical issues with my device are preventing me from accessing or completing the form, causing significant delays in submission.",
				"Another critical deadline conflicts with the form submission, requiring my immediate attention and postponing the form completion." };

		// Generate a random index to select a description
		int randomIndex = new Random().nextInt(skipReasonDescriptions.length);
		String randomDescription = skipReasonDescriptions[randomIndex];
		System.out.println("Random Skip Reason Description: " + randomDescription);

		// Assert and send the random description to the description text field
		assertTrue(descriptionTextField.isDisplayed(), "Description text field is not displayed.");
		descriptionTextField.sendKeys(randomDescription);
	}

	public void reasonTextfields() {

		randomDescriptionTextField(reasonName_textfield);
	}

	public void descriptionTextfield() {
		randomDescriptionTextField(description_textfield);

	}

	public void clickOnCreateSkipReason() {

		assertTrue(createButton_createSkipReasonPopup.isDisplayed(), "createButton_createSkipReasonPopup");
		createButton_createSkipReasonPopup.click();
	}

	public void verifyCreatedSkipReasonPopup() throws Throwable {

		// wait.until(ExpectedConditions.visibilityOf(successfullyCreated_popup));
		Thread.sleep(2000);
		assertTrue(successfullyCreated_popup.isDisplayed(), "successfullyCreated_popup");
		System.out.println("successfullyCreated_popup : " + successfullyCreated_popup.getText());

		assertTrue(continueButton_create.isDisplayed(), "continueButton_create is not displayed");
		continueButton_create.click();
	}

	public void verifyCreatedSkipReason() {
		wait.until(ExpectedConditions.visibilityOf(lastCreated_skipReason));
		assertTrue(lastCreated_skipReason.isDisplayed(), "lastCreated_skipReason is not displayed");

		lastCreatedSkipReasonText = lastCreated_skipReason.getText();
		System.out.println("lastCreatedSkipReasonText : " + lastCreatedSkipReasonText);

		assertEquals(lastCreatedSkipReasonText, reasonNameTextfieldAttributeValue,
				"reasontextvield value not equal with created skipreasons");
		jsClick(driver, lastCreated_skipReason);

	}



	public List<Object> elementTexts;  //global Variable

	// Utility method to get text from both normal elements and dropdowns
	public List<Object> getAllTextFromElements(List<WebElement> elements) {

		elementTexts = new ArrayList<>();

		// Iterate through each WebElement
		for (WebElement element : elements) {
			// Check if the element is a dropdown (<select> tag)
			if (element.getTagName().equalsIgnoreCase("select")) {
				// If it's a dropdown, handle it with Select class
				Select select = new Select(element);
				List<WebElement> options = select.getOptions(); // Get all dropdown options

				// Iterate through each option and get its text
				for (WebElement option : options) {
					String optionText = option.getText().trim();
					elementTexts.add(optionText);

					// Print each dropdown option's text for verification
					System.out.println("Dropdown Option Text: " + optionText);
				}
			} else {
				// For normal elements, just get the text
				String text = element.getText().trim();
				elementTexts.add(text);

				// Print each element's text for verification
				//System.out.println("Element Text: " + text);
			}

		}

		// Return the list of all texts
		return elementTexts;
	}

	public void captureAllCreatedSkipReasons() {


		getAllTextFromElements(CreatedSkipReasons);
		System.out.println("elementTexts:"+ elementTexts);

	}

	public void selecteSkipReason() {

		List<Object>createdSkipReasonsLists=new ArrayList<Object>();
		Select skipreasonDropdwon=new Select(selectSkipReasonDropdown);
		for (WebElement skipReasonsOptions : skipreasonDropdwon.getOptions())
		{

			createdSkipReasonsLists.add(skipReasonsOptions.getText());
			System.out.println("skipreasonDropdwon :"+ skipReasonsOptions.getText());

		}

		//	assertTrue(createdSkipReasonsLists.contains(elementTexts), "Created skip reasons are displayed in 'SkipTheAudit Dropdown'");
		System.out.println("elementTexts 1 :"+ elementTexts);

		assertTrue(createdSkipReasonsLists.contains(elementTexts), "Created skip reasons are  not displayed in 'SkipTheAudit Reasons Dropdown");

		dropdownUtilsALL(selectSkipReasonDropdown, "value", "35");
	}

	public void searchThroughReasonsName() {

		NavigateTo_Skipreason();

		assertTrue(seachElementTextfield.isDisplayed(), "seachElementTextfield is not displayed");
		// assertTrue(seachElementTextfield.isEnabled(), "seachElementTextfield element
		// is enabled");

		seachElementTextfield.sendKeys(lastCreatedSkipReasonText);

		String searchTextfieldValue = seachElementTextfield.getAttribute("value");
		System.out.println("searchTextfieldValue :" + searchTextfieldValue);

		assertEquals(lastCreatedSkipReasonText, searchTextfieldValue, "searchtextfieldvale is equal after click only");

		assertTrue(searchButton_table.isDisplayed(), "searchButton_table is not displayed");
		searchButton_table.click();

		assertEquals(searchTextfieldValue, lastCreatedSkipReasonText, "Enter vlaues is not equal with search values");

		clearAllFilters_table.click();

	}

	// process_table
	// Verify user is able to search by processes
	public void SearchThroughProcesses() throws Throwable {

		assertTrue(Verify_skipReason.isDisplayed(), "Verify_skipReason is not displayed");

//		beforeSearchCreatedSkipReasons = beforeCreatedSkipReasons_search.getText();
//		System.out.println(beforeCreatedSkipReasons_search.getText()); // optional change to
//																		// "beforeSearchCreatedSkipReasons "
//
//		List<String> processDropdownList_table = new ArrayList<String>();
//
//		Select ProcessDropdown1_table = new Select(processDropdown_Table);
//		for (WebElement Options : ProcessDropdown1_table.getOptions()) {
//			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
//			System.out.println(Options.getText());
//			processDropdownList_table.add(Options.getText());
//		}
//		assertTrue(processDropdownList_table.contains("AJP"));
//		ProcessDropdown1_table.selectByVisibleText("AJP");
//
//		// subProcess_table
//		List<String> subProcessDropdownList_table = new ArrayList<String>();
//
//		Thread.sleep(2000);
//		Select subProcessDropdown2_table = new Select(SubprocessDropdown_Table);
//		for (WebElement options2 : subProcessDropdown2_table.getOptions()) {
//			// Thread.sleep(1000);
//			System.out.println(subProcessDropdown2_table.getOptions());
//			subProcessDropdownList_table.add(options2.getText());
//		}
//
//		assertTrue(subProcessDropdownList_table.contains("Sub AJP"));
//		subProcessDropdown2_table.selectByVisibleText("Sub AJP");
////			
//
//		// Subsubprocess_table
//		List<String> subsubprocessDropdownList_table = new ArrayList<String>();
//		Thread.sleep(5000);
//		Select SubsubProcessDropdown3_table = new Select(subSubProcessDropdown_Table);
//		for (WebElement options3 : SubsubProcessDropdown3_table.getOptions()) {
//			// Thread.sleep(2000);
//			System.out.println(SubsubProcessDropdown3_table.getOptions());
//			subsubprocessDropdownList_table.add(options3.getText());
//		}
//		assertTrue(subsubprocessDropdownList_table.contains("Sub Sub AJP"));
//		SubsubProcessDropdown3_table.selectByVisibleText("Sub Sub AJP");
//		// actions.moveToElement(driverIninteractable).perform();
//
//		assertTrue(searchButton_table.isDisplayed(), "searchButton_table is not displayed");
//		searchButton_table.click();
//
////			beforeSearchCreatedSkipReasons=beforeCreatedSkipReasons_search.getText();
////			System.out.println(beforeSearchCreatedSkipReasons);
//
//		assertEquals(beforeSearchCreatedSkipReasons, afterCreatedSkipReasons_search.getText());
//		System.out.println(afterCreatedSkipReasons_search.getText()); // optional
//
//		assertTrue(clearAllFilters_table.isDisplayed(), "clearAllFilters_table is not displayed");
//		clearAllFilters_table.click();

		dropdownUtilsALL(processDropdown_Table, "text", "AJP");
		dropdownUtilsALL(SubprocessDropdown_Table, "text", "Sub AJP");
		dropdownUtilsALL(subSubProcessDropdown_Table, "text", "Sub Sub AJP");

		searchButton_table.click();
	}

	// Utility method to check for specific values in columns 2, 3, and 4
	// public void verifyAJPTitles(WebDriver driver) {
//        // Define the expected titles
//        String[] expectedTitles = { "AJP", "Sub AJP", "Sub Sub AJP" };
//        
//        // Check if the found elements match the expected titles
//        for (int i = 0; i < expectedTitles.length; i++) {
//            String actualText = allProcessElements.get(i).getText().trim();
//            String expectedText = expectedTitles[i];
//            
//            // Assert if the actual text matches the expected text
//            Assert.assertEquals(actualText, expectedText, "Mismatch found in column " + (i + 2));
//        }
	// Dynamic method to check for specific values in columns 2, 3, and 4

	// to check
	public void verifyColumnTitles(WebDriver driver, String[] expectedTitles) {

		// String[] expectedValues = { "AJP", "Sub AJP", "Sub Sub AJP" };

		// Check if the found elements match the expected titles
		for (int i = 0; i < expectedTitles.length; i++) {
			String actualText = allProcessElements.get(i).getText().trim();
			String expectedText = expectedTitles[i];

			// Assert if the actual text matches the expected text
			Assert.assertEquals(actualText, expectedText, "Mismatch found in column " + (i + 2));
		}

	}

	// Verifythe user is able to Clearall filters
	public void ClearFilters() throws Throwable {

//		List<String> processDropdownList_table = new ArrayList<String>();
//
//		Select ProcessDropdown1_table = new Select(processDropdown_Table);
//		for (WebElement Options : ProcessDropdown1_table.getOptions()) {
//			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
//			System.out.println(Options.getText());
//			processDropdownList_table.add(Options.getText());
//		}
//		assertTrue(processDropdownList_table.contains("AJP"));
//		ProcessDropdown1_table.selectByVisibleText("AJP");
//
//		List<String> subProcessDropdownList_table = new ArrayList<String>();
//
//		Thread.sleep(2000);
//		Select subProcessDropdown2_table = new Select(SubprocessDropdown_Table);
//		for (WebElement options2 : subProcessDropdown2_table.getOptions()) {
//			// Thread.sleep(1000);
//			System.out.println(subProcessDropdown2_table.getOptions());
//			subProcessDropdownList_table.add(options2.getText());
//		}
//
//		assertTrue(subProcessDropdownList_table.contains("Sub AJP"));
//		subProcessDropdown2_table.selectByVisibleText("Sub AJP");
//
//		List<String> subsubprocessDropdownList_table = new ArrayList<String>();
//		Thread.sleep(5000);
//		Select SubsubProcessDropdown3_table = new Select(subSubProcessDropdown_Table);
//		for (WebElement options3 : SubsubProcessDropdown3_table.getOptions()) {
//			// Thread.sleep(2000);
//			System.out.println(SubsubProcessDropdown3_table.getOptions());
//			subsubprocessDropdownList_table.add(options3.getText());
//		}
//		assertTrue(subsubprocessDropdownList_table.contains("Sub Sub AJP"));
//		SubsubProcessDropdown3_table.selectByVisibleText("Sub Sub AJP");
//
//		assertTrue(clearAllFilters_table.isDisplayed(), "clearAllFilters_table is not displayed");
//		clearAllFilters_table.click();
//
//		assertTrue(ProcessDropdown1_table.getFirstSelectedOption().isDisplayed(),
//				"getfirst process option is not displayed");
//		assertTrue(subProcessDropdown2_table.getFirstSelectedOption().isDisplayed(),
//				"getfrst subprocess options is not displayed");
//		assertTrue(SubsubProcessDropdown3_table.getFirstSelectedOption().isDisplayed(),
//				"get first subsubproces options not displayed");

		// SearchThroughProcesses();

		Select ProcessDropdown1_table = new Select(processDropdown_Table);
		WebElement processDropdownFirstSelectedOptions = ProcessDropdown1_table.getFirstSelectedOption();
		System.out.println("processDropdownFirstSelectedOptions :" + processDropdownFirstSelectedOptions);

		Select subProcessDropdown2_table = new Select(SubprocessDropdown_Table);
		WebElement subProcessDropdownFirstSelectedOptions = subProcessDropdown2_table.getFirstSelectedOption();
		System.out.println("SubprocessDropdownFirstSelectedOptions :" + subProcessDropdownFirstSelectedOptions);

		Select subSubProcessDropdown3_table = new Select(subSubProcessDropdown_Table);
		WebElement subSubprocessDropdownFirstSelectedOptions = subSubProcessDropdown3_table.getFirstSelectedOption();
		System.out.println("SubSubprocessDropdownFirstSelectedOptions :" + subSubprocessDropdownFirstSelectedOptions);

		clearAllFilters_table.click();

		Select afterProcessDropdown1_table = new Select(processDropdown_Table);
		WebElement processDropdownFirstSelectedOptionsAfter = afterProcessDropdown1_table.getFirstSelectedOption();
		System.out.println("processDropdownFirstSelectedOptionsAfter :" + processDropdownFirstSelectedOptionsAfter);

		Select afterubProcessDropdown2_table = new Select(SubprocessDropdown_Table);
		WebElement subProcessDropdownFirstSelectedOptionsAfter = afterubProcessDropdown2_table.getFirstSelectedOption();
		System.out
				.println("SubprocessDropdownFirstSelectedOptionsAfter :" + subProcessDropdownFirstSelectedOptionsAfter);

		Select afterSubsubProcessDropdown3_table = new Select(subSubProcessDropdown_Table);
		WebElement subSubprocessDropdownFirstSelectedOptionsAfter = afterSubsubProcessDropdown3_table
				.getFirstSelectedOption();
		System.out.println(
				"SubSubprocessDropdownFirstSelectedOptionsAfter :" + subSubprocessDropdownFirstSelectedOptionsAfter);

		assertNotEquals(processDropdownFirstSelectedOptionsAfter, processDropdownFirstSelectedOptions, "Cleae");
		assertNotEquals(subProcessDropdownFirstSelectedOptionsAfter, subProcessDropdownFirstSelectedOptions);
		assertNotEquals(subSubprocessDropdownFirstSelectedOptionsAfter, subSubprocessDropdownFirstSelectedOptions);

	}

	public void EditSKipReasons() throws Throwable {
		js.executeScript("arguments[0].scrollIntoView(true);", lastEdit_skipReason); // Use for scroll to element

		assertTrue(lastEdit_skipReason.isDisplayed(), "lastEdit_skipReason is not displayed");
		// lastEdit_skipReason.click();
		jsClick(driver, lastEdit_skipReason);

		wait.until(ExpectedConditions.visibilityOf(verify_EditSkipReason));
		assertTrue(verify_EditSkipReason.isDisplayed(), "verify_EditSkipReason is not displayed");

		List<String> processDropdownList_Edit = new ArrayList<String>();

		Select ProcessDropdown1_Edit = new Select(processDropdown_Edit);
		for (WebElement Options : ProcessDropdown1_Edit.getOptions()) {
			wait.until(ExpectedConditions.visibilityOfAllElements(Options));
			System.out.println(Options.getText());
			processDropdownList_Edit.add(Options.getText());
		}
		// assertTrue( processDropdownList_Edit.contains("AJP"));
		// assertTrue(ProcessDropdown1_Edit.getOptions().get(1).getText().contains("AJP"));
		// //1st way
		String ActualProcess = ProcessDropdown1_Edit.getOptions().get(1).getText(); // 2nd way
		assertEquals("AJP", ActualProcess);

		List<String> subProcessDropdownList_Edit = new ArrayList<String>();

		Thread.sleep(2000);
		Select subProcessDropdown2_Edit = new Select(SubprocessDropdown_Table);
		for (WebElement options2 : subProcessDropdown2_Edit.getOptions()) {
			// Thread.sleep(1000);
			System.out.println(subProcessDropdown2_Edit.getOptions());
			subProcessDropdownList_Edit.add(options2.getText());
		}

		// assertTrue(subProcessDropdownList_Edit.contains("Sub AJP"));
		// assertTrue(subProcessDropdown2_Edit.getOptions().get(1).getText().contains("Sub
		// AJP")); //1st way
		String actual_SubProcess = subProcessDropdown2_Edit.getOptions().get(1).getText(); // 2nd way
		assertEquals("Sub AJP", actual_SubProcess);

		List<String> subsubprocessDropdownList_Edit = new ArrayList<String>();
		Thread.sleep(2000);
		Select SubsubProcessDropdown3_Edit = new Select(subSubProcessDropdown_Table);
		for (WebElement options3 : SubsubProcessDropdown3_Edit.getOptions()) {
			// Thread.sleep(2000);
			System.out.println(SubsubProcessDropdown3_Edit.getOptions());
			subsubprocessDropdownList_Edit.add(options3.getText());
		}
		// assertTrue(subsubprocessDropdownList_Edit.contains("Sub Sub AJP"));
		// assertTrue(SubsubProcessDropdown3_Edit.getOptions().get(1).getText().contains("Sub
		// Sub AJP")); //1st way
		String actual_SububProcess = SubsubProcessDropdown3_Edit.getOptions().get(1).getText(); // 2nd way
		System.out.println(actual_SububProcess);
		assertEquals("Sub Sub AJP", actual_SububProcess);

		assertTrue(reasonName_textfield_Edit.isDisplayed(), "reasonName_textfield_Edit is not displayed");
		System.out.println("reasonName_textfield_Edit.getText() text : " + reasonName_textfield_Edit.getText());
		reasonName_textfield_Edit.clear();
		reasonName_textfield_Edit.sendKeys(fake.lastName1());

		assertTrue(description_textfield_edit.isDisplayed(), "description_textfield_edit is not displayed");
		System.out.println("description_textfield_edit text: " + description_textfield_edit.getText());
		description_textfield_edit.clear();
		description_textfield_edit.sendKeys(fake.lastName1());

		assertTrue(UpdateButton.isDisplayed(), "UpdateButton is not displayed");
		UpdateButton.click();

		wait.until(ExpectedConditions.visibilityOf(Update_SkipReasonSuccessfullyPopup));
		assertTrue(Update_SkipReasonSuccessfullyPopup.isDisplayed(), "Update_SkipReasonSuccessfullyPopup");
		assertTrue(continueButon_SkipReasonSucessfullyUpdate.isDisplayed(),
				"continueButon_SkipReasonSucessfullyUpdate is not displayed");
		continueButon_SkipReasonSucessfullyUpdate.click();
		assertTrue(Verify_skipReason.isDisplayed(), "Verify_skipReason is not displayed");

		Thread.sleep(2000);
	}

	public void CanceCreate_Edit() throws Throwable {

		// Verify the user is able to cancel edit page , Create page
		// Cancel Edit page
		assertTrue(lastEdit_skipReason.isDisplayed(), "lastEdit_skipReason is not displayed");
		// lastEdit_skipReason.click();
		jsClick(driver, lastEdit_skipReason);

		wait.until(ExpectedConditions.visibilityOf(verify_EditSkipReason));
		assertTrue(verify_EditSkipReason.isDisplayed(), "verify_EditSkipReason is not displayed");

		assertTrue(cancelButton_edit.isDisplayed(), "cancelButton_edit is not displayed");
		cancelButton_edit.click();
		assertTrue(Verify_skipReason.isDisplayed(), "Verify_skipReason");

		// Cancel Edit page
		assertTrue(createButton_SkipReasonPage.isDisplayed(), "createButton_SkipReasonPage is not displayed");
		createButton_SkipReasonPage.click();

		wait.until(ExpectedConditions.visibilityOf(verify_CreateSkipReason));
		assertTrue(verify_CreateSkipReason.isDisplayed(), "verify_CreateSkipReasonis not displayed");
		assertTrue(cancelButton_CreateSkipReasonPopup.isDisplayed(), "cmancelButton_create is not displayed");
		cancelButton_CreateSkipReasonPopup.click();

		// cancel deletepage

		assertTrue(lastDleteButton_SkipReasonTable.isDisplayed(), "lastDleteButton_SkipReasonTable is not displayed");
		// lastDleteButton_SkipReasonTable.click();
		jsClick(driver, lastDleteButton_SkipReasonTable);

		wait.until(ExpectedConditions.visibilityOf(deletePopup));
		assertTrue(deletePopup.isDisplayed(), "deletePopup is not displayed");
		assertTrue(cancelButton_Delete.isDisplayed(), "cancelButton_Delete");
		cancelButton_Delete.click();

		Thread.sleep(2000);
	}

	public void Delete_SkipReasons() {
		assertTrue(lastDleteButton_SkipReasonTable.isDisplayed(), "lastDleteButton_SkipReasonTable is not displayed");
		// lastDleteButton_SkipReasonTable.click();
		jsClick(driver, lastDleteButton_SkipReasonTable);

		assertTrue(deletePopup.isDisplayed(), "deletePopup is not displayed");
		assertTrue(deleteButton_delete.isDisplayed(), "deleteButton_delete i snot displayed");
		deleteButton_delete.click();

		wait.until(ExpectedConditions.visibilityOf(deleted_SuceessfullyPopup));
		assertTrue(deleted_SuceessfullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is not displayed");
		assertTrue(continueButton_DeleteSuccessullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is not displayed");
		continueButton_DeleteSuccessullyPopup.click();

	}

	// Verify the user is able to see the "created skip reasons" in Stages profile
	// when they click n skip audit
	CallLogSatgeView callLogSatgeView = new CallLogSatgeView();

@FindBy(linkText = "Call Log Stage View")
WebElement callLogStageView;

@FindBy(xpath = "//img[@alt='filter_search' and @class='img-fluid']")
WebElement searchButton;

	public void navigateToSkipAudit() {


//		callLogSatgeView.naivigateToCallLogStageView();

		navigateWithinAlchemy(callLogStageView);
		dropdownUtilsALL(callLogSatgeView.SearchStages, "text", "Booking Information Stage"); // select Stage
//		callLogSatgeView.searchButton.click();
		searchButton.click();

		wait.until(ExpectedConditions.visibilityOf(eyeIconProfileview));
		assertTrue(eyeIconProfileview.isDisplayed(), "eyeIconProfileview is not displayed");
		eyeIconProfileview.click();

		assertTrue(skipAudit.isDisplayed(), "skipAudit is not displayed");

	}

	public void clickOnSkipAuditReason() {

		skipAudit.click();
		wait.until(ExpectedConditions.visibilityOf(verifySkipAudit));
		assertTrue(verifySkipAudit.isDisplayed(), "verifySkipAudit is not displayed");



	}

}

