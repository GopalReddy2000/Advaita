package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.Pagination;
import com.advaita.Utilities.SendDataUtils;

import Advaita_TDD.Advaita_TDD.DynamicXpath;
import Advaita_TDD.Advaita_TDD.FakeData;

public class MastersFieldSets extends TestBase {

	FakeData fake = new FakeData();
	
	public static final String masterURL = "https://test.capture.autosherpas.com/en/masters/masters_question_sets/";
	public static String existingFieldSetRecord;
	public static int existingFieldSetRecordCount;

	
	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(xpath = "(//button[normalize-space()='Masters'])[1]")
	public static WebElement masterTabElement;

	@FindBy(id = "pills-MasterQuestionSet-tab")
	public static WebElement fieldSetTabElement;

	@FindBy(linkText = "+ Add Field Set")
	public static WebElement addFieldSetButton;

	@FindBy(xpath = "//h2[normalize-space()='Create Master Field Set']")
	public static WebElement createMasterFieldSetPage;

	@FindBy(id = "questionSet_name")
	public static WebElement questionSetNameFieldElement;

	@FindBy(id = "exampleFormControlTextarea1")
	public static WebElement remarkFieldElement;

	@FindBy(xpath = "//h5[normalize-space()='Section 1']")
	public static WebElement section1Element;

	@FindBy(xpath = "(//img[@alt='plusicon']/..//a[@class='add-text'][normalize-space()='Add Question'])[1]")
	public static WebElement addQuestionsButttonElement;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	public static WebElement fetchFieldSetRecord;

	@FindBy(xpath = "//img[@class='documentimg']/..//h5")
	public static List<WebElement> previousQuestionSetElements;

	@FindBy(xpath = "//h5[@class='font_13 question_number']/..//input[@class='question_text']")
	public static List<WebElement> addedQuestionElements;

	@FindBy(xpath = "(//img[@alt='delete-icon'])[position() < last()]")
	public static List<WebElement> deleteQuestionButton;

	@FindBy(xpath = "//div[@class='col-md-3 table-viewright-side right_section right_section_1_1 actv_rt_sec_1']//label[normalize-space()='SELECT QUESTION TYPE']/../div/div/a//h6")
	public static List<WebElement> questionTypes;

	@FindBy(xpath = "//h5[normalize-space()='REQUIRED']/following::label/input[@name='question_required_1_1']")
	public static WebElement requiredToggleButton;

	@FindBy(xpath = "//h5[normalize-space()='ESCALATED FIELD']/following::label/input[@name='question_escalated_1_1']")
	public static WebElement escalatedFieldToggleButton;

	@FindBy(name = "measurable_parameter_1_1")
	public static WebElement measurableParameterDropDown;

	@FindBy(xpath = "//h6[normalize-space()='Max Length']/following::input[@name='dataset_field_section_max_length_1_1']")
	public static WebElement maxLengthFieldForQuestion;

	@FindBy(xpath = "(//input[@name='textbox_settings_min_length_1_1'])[1]")
	public static WebElement minLengthField;

	@FindBy(xpath = "(//input[@name='textbox_settings_max_length_1_1'])[1]")
	public static WebElement maxLengthField;

	@FindBy(xpath = "//h6[normalize-space()='Value-Type']/following::select[@name='textbox_settings_value_type_1_1']")
	public static WebElement textFieldValueTypeDropDown;

	@FindBy(xpath = "//h6[text()='Allow-Sp-Char']/..//input[@name='textbox_settings_allow_sp_char_1_1']/..//span[@class='slider round']")
	public static WebElement allowSpCharToggleButton;

	@FindBy(xpath = "(//textarea[@class='answer_option short_answer_input'])[1]")
	public static WebElement shortAnswerTextBox;

	@FindBy(xpath = "//div[contains(@class, 'increament-input')]//input[@name='shortans_settings_min_length_1_2' and @value='1']")
	public static WebElement shortAnswerMinLengthField;

	@FindBy(xpath = "(//input[@name='shortans_settings_max_length_1_2'])[1]")
	public static WebElement shortAnswerMaxLengthField;

	@FindBy(xpath = "//h6[normalize-space()='Value-Type']/following::select[@name='shortans_settings_value_type_1_2']")
	public static WebElement shortAnswerValueTypeDropDown;

	@FindBy(xpath = "//h6[text()='Allow-Sp-Char']/..//input[@name='shortans_settings_allow_sp_char_1_1']/..//span[@class='slider round']")
	public static WebElement shortAnswerAllowSpCharToggleButton;

	@FindBy(xpath = "//a[normalize-space()='Add Section']")
	public static WebElement addSectionButton;

	@FindBy(xpath = "(//h5[@class='section-text section_header'][normalize-space()='Section 2'])[1]")
	public static WebElement section2Element;

	@FindBy(xpath = "//div[@class='upload-cloud']/ancestor::div//img[@class='trashimg answer_option fileupload']")
	public static WebElement fileUploadSettingButton;

	@FindBy(xpath = "//label[@for='allowed_format']/following-sibling::span//input[@placeholder='select']")
	public static WebElement fileUploadOptionField;

	@FindBy(xpath = "//li[@role='treeitem']")
	public static List<WebElement> checkOptions;

	@FindBy(id = "create_btn")
	public static WebElement saveButtonElement;

	@FindBy(xpath = "//button[@type='button'][text()='Cancel']")
	public static WebElement cancelButtonElement;

	@FindBy(xpath = "//h3[text()='Success']/..//span[text()='Master Field Set has been created successfully']")
	public static WebElement successConfirmationPopup;

	@FindBy(xpath = "//h3[text()='Success']/..//span[text()='Master Field Set has been created successfully']/..//button[text()='Continue']")
	public static WebElement ContinueButtonOnSuccessConfirmationPopup;

	@FindBy(xpath = "//img[@alt='arrow-left']")
	public static WebElement leftArrowToGoBackTablePage;

	@FindBy(xpath = "(//img[@alt='plusicon']/..//a[@class='add-text'][normalize-space()='Add Question'])[2]")
	public static WebElement section2AddQuestionsButton;

	@FindBy(xpath = "(//div[h5[text()='Section 2']]/..//img[@class='settingimg'])[1]")
	public static WebElement section2SettingButton;

	@FindBy(xpath = "//div[h5[text()='IS CONDITIONAL']]/..//label[@class='switch']//input[@name='is_conditional_2']")
	public static WebElement isConditionalToggleButton;

	@FindBy(xpath = "(//div[h5[text()='IS CONDITIONAL']]/..//label[@class='switch']//input[@name='is_conditional_2']/..//span[@class='slider round required_slider'])")
	public static WebElement isConditionalToggle;

	@FindBy(xpath = "(//div[h5[text()='Section 3']]/..//img[@class='settingimg'])[1]")
	public static WebElement section3SettingButton;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	public static WebElement fetchCreatedRecord;

	@FindBy(id = "text_search")
	public static WebElement searchBox;

	@FindBy(xpath = "(//img[@alt='filter_search'])[1]")
	public static WebElement searchButton;

	@FindBy(id = "filter_date")
	public static WebElement createdDatePicker;

	@FindBy(xpath = "//h6[normalize-space()='Clear All Filters']")
	public static WebElement clearFilterButton;

	@FindBy(xpath = "//li//a//img[@alt='left_arrow']")
	public static WebElement leftArrow;

	@FindBy(xpath = "//li//a//img[@alt='rgt_arrow']")
	public static WebElement rightArrow;

	public MastersFieldSets() {

		PageFactory.initElements(driver, this);

	}

	public static void commonNavigation() {

		click(driver, HomePage.workflowDesign);
		click(driver, masterTabElement);
		click(driver, masterTabElement);
		click(driver, fieldSetTabElement);

	}

	public void verifyTabsForFieldSetCreate() {

		assertTrue(masterTabElement.isDisplayed(), "masterTabElement is not displayed.");
		click(driver, masterTabElement);

		System.out.println(driver.getCurrentUrl());

		assertEquals(driver.getCurrentUrl(), masterURL, "masterURL mismatch.");

		assertTrue(fieldSetTabElement.isDisplayed(), "fieldSetTabElement is not displayed.");

	}

	public void verifyBeforeFieldSetCreatedCount() throws Throwable {

//		String beforeCreatedRecords = driver.findElement(By.xpath("(//p[@class='show_entries m-0 font_13'])[1]"))
//				.getText();
//
//		Thread.sleep(2000);
//		System.out.println("beforeCreatedRecord : " + beforeCreatedRecords);
//
//		int beforeCreateRecord = extractNumber(beforeCreatedRecords);
//		existingFieldSetRecordCount = extractNumber(beforeCreatedRecords) + 1;
//
////	System.out.println(String.format("beforeNumber (%d + 1) : %s", beforeCreateRecord, beforeNumber));
//		System.out.println("beforeNumber" + "(" + beforeCreateRecord + "+1" + ") :" + existingFieldSetRecordCount);

	}

	public void verifyFieldSetCreateButton() throws Throwable {

//		assertTrue(fetchFieldSetRecord.isDisplayed());
//		existingFieldSetRecord = fetchFieldSetRecord.getText();
//		assertNotNull(existingFieldSetRecord);

//		System.out.println("existingFieldSetRecord : " + existingFieldSetRecord);
//		click(driver, addFieldSetButton);

		ClickUtilities.clickWithRetry(addFieldSetButton, 3);

		assertTrue(createMasterFieldSetPage.isDisplayed(), "createMasterFieldSetPage is not displayed.");

	}

	public void verifyQuestionSetNameField() {

		String text = driver.findElement(By.xpath("//label[normalize-space()='QUESTION SET *']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		assertTrue(questionSetNameFieldElement.isDisplayed());

		questionSetNameFieldElement.clear();
		questionSetNameFieldElement.sendKeys(FakeData.lastName1() + " FS");

	}

	public void verifyRemarkField() {

		assertTrue(remarkFieldElement.isDisplayed());

		remarkFieldElement.clear();
		remarkFieldElement.sendKeys("Test Remark");

	}

	int sizeOfQuestion = 8;

	public void verifyDefaultSection1andAddingQuestion() throws Throwable {

		assertTrue(section1Element.isDisplayed(), "section1Element is not displayed.");

//		int sizeOfQuestion = 8;

		ClickUtilities.multiClick(driver, addQuestionsButttonElement, sizeOfQuestion);

		int sizeOfAddedQuestion = addedQuestionElements.size() - 2;

		if (sizeOfAddedQuestion == sizeOfQuestion) {
			System.out.println("All " + sizeOfQuestion + " elements are present.");
			assertTrue(true);
		} else {
			System.out.println("All " + sizeOfQuestion + " elements, but found " + sizeOfAddedQuestion);
			assertTrue(false);
		}

		for (int n = deleteQuestionButton.size() - 1; n < deleteQuestionButton.size(); n++) {

			click(driver, deleteQuestionButton.get(n));
		}

	}

//	All 11 elements are present.
//	questionTypes 1 : Label
//	questionTypes 2 : Multiple Choice
//	questionTypes 3 : Short Answer
//	questionTypes 4 : Drop Down
//	questionTypes 5 : Relative Drop down
//	questionTypes 6 : File Upload
//	questionTypes 7 : Radio Button
//	questionTypes 8 : Date
//	questionTypes 9 : Time
//	questionTypes 10 : Text Box
//	questionTypes 11 : Relative MultiSelect

	public static int LABEL = 1;
	public static int MULTIPLE_CHOICE = 2;
	public static int SHORT_ANSWER = 3;
	public static int DROP_DOWN = 4;
	public static int RELATIVE_DROP_DOWN = 5;
	public static int FILE_UPLOAD = 6;
	public static int RADIO_BUTTON = 7;
	public static int DATE = 8;
	public static int TIME = 9;
	public static int TEXT_BOX = 10;
	public static int RELATIVE_MULTISELECT = 11;

//	########################################################################################################################################################
	public void verifyByAddingQuestionsTypeInSection1() throws Throwable {

		// Interact with the questionFields elements by index, excluding the last one

		for (int i = 1; i <= sizeOfQuestion - 1; i++) {

			String xpathQuestionTextField = "//div[h5[contains(text(), 'Question " + i
					+ "')]]//input[@name='question_1_" + i + "']";

			WebElement questionFields = driver.findElement(By.xpath(xpathQuestionTextField));

			if (i == 1) {

				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_1_"
						+ i + "']/following-sibling::div[" + TEXT_BOX + "]//h6";

				System.out.println(xpathForTypeQ);
				WebElement typeElement = driver.findElement(By.xpath(xpathForTypeQ));

//				questionTypes 9 : Text Box
				// Example interaction: setting text in the question fields
				js.executeScript("arguments[0].scrollIntoView(true);", questionFields);
				questionFields.sendKeys("Name Of The Customer ?");

				assertTrue(typeElement.isDisplayed());
				ClickUtilities.jsClick(driver, typeElement);

				jsClick(driver, requiredToggleButton);

				jsClick(driver, escalatedFieldToggleButton);

				Select dropDownSelect = new Select(measurableParameterDropDown);

				assertFalse(dropDownSelect.isMultiple(), "Dropdown allows multiple selections.");
//
				// Check for empty drop down
				List<WebElement> options1 = dropDownSelect.getOptions();
				assertTrue(options1.size() > 0, "Dropdown has no options.");
				System.out.println("Number of options in the dropdown: " + options1.size());

//				Check default selected value
				WebElement defaultSelectedOption1 = dropDownSelect.getFirstSelectedOption();
				System.out.println(defaultSelectedOption1.getText());
				String expectedDefaultOption1 = "Select Parameter"; // Replace with expected default value
				assertEquals(defaultSelectedOption1.getText(), expectedDefaultOption1,
						"Default selected option is incorrect.");

				maxLengthFieldForQuestion.sendKeys("250");

//				#####################################################################################################################################

//				assertTrue(driver.findElement(By.xpath("(//input[@name='ans_option_1_1_1'])[1]")).isDisplayed());
				jsClick(driver, driver.findElement(By.xpath("(//input[@name='ans_option_1_1_1'])[1]")));

				assertTrue(minLengthField.isDisplayed(), "minLengthField is not displayed.");
				minLengthField.clear();
				minLengthField.sendKeys("1");

				assertTrue(maxLengthField.isDisplayed(), "maxLengthField is not displayed.");
				maxLengthField.clear();
				maxLengthField.sendKeys("100");

				Select valueTypeDropDown = new Select(textFieldValueTypeDropDown);

				assertFalse(valueTypeDropDown.isMultiple(), "Dropdown allows multiple selections.");

				// Check for empty drop down
				List<WebElement> options = valueTypeDropDown.getOptions();
				assertTrue(options.size() > 0, "Dropdown has no options.");
				System.out.println("Number of options in the dropdown: " + options.size());

//				Check default selected value
				WebElement defaultSelectedOption = valueTypeDropDown.getFirstSelectedOption();
				String expectedDefaultOption = "All"; // Replace with expected default value
				assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
						"Default selected option is incorrect.");

//		        Verify the order of options (if applicable)
				String[] expectedOrder = { "All", "Only Text", "Only Number" }; // Replace with the expected order
				for (int n = 0; n < expectedOrder.length; n++) {
					assertEquals(options.get(n).getText(), expectedOrder[n], "Option order is incorrect at index " + n);
				}

				// Print all options and check for duplicates
				Set<String> uniqueOptions = new HashSet<>();
				System.out.println("Dropdown options:");
				for (WebElement option : options) {
					String optionText = option.getText();
					System.out.println(optionText);
					assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
				}

				// Select each option by index and verify the selection
				for (int k = 0; k < options.size(); k++) {
					valueTypeDropDown.selectByIndex(k);
					WebElement selectedOption = valueTypeDropDown.getFirstSelectedOption();
					assertEquals(selectedOption.getText(), options.get(k).getText(),
							"Failed to select the option by index " + k);
					System.out.println(
							"Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
				}

//				select.selectByVisibleText("Only Text");
				valueTypeDropDown.selectByVisibleText("All");
//				select.selectByVisibleText("Only Number");

//				// Expected toggled background color
//		        String expectedBeforeToggledBackgroundColor = "rgba(255, 255, 255, 1)";
				Thread.sleep(1000);
				System.out.println("beforeAllowSpCharToggleButtonColor : "
						+ allowSpCharToggleButton.getCssValue("background-color"));
//				
//				 assertEquals(allowSpCharToggleButton.getCssValue("background-color"), expectedBeforeToggledBackgroundColor, "The background color did not change to the expected toggled state.");

				jsClick(driver, allowSpCharToggleButton);
//				// Expected toggled background color
//		        String expectedToggledBackgroundColor = "rgba(43, 197, 84, 1)"; // #28C554 in RGBA

				Thread.sleep(1000);

				System.out.println("afterAllowSpCharToggleButtonColor : "
						+ allowSpCharToggleButton.getCssValue("background-color"));
////		        // Verify the CSS properties have changed
//		        assertEquals(allowSpCharToggleButton.getCssValue("background-color"), expectedToggledBackgroundColor, "The background color did not change to the expected toggled state.");
////				
				jsClick(driver, allowSpCharToggleButton);

				Thread.sleep(200);
				System.out.println(
						"allowSpCharToggleButton color : " + allowSpCharToggleButton.getCssValue("background-color"));

			}
			if (i == 2) {

//				questionTypes 2 : Short Answer
				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Adress Of The Customer ?");

				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_1_"
						+ i + "']/following-sibling::div[" + SHORT_ANSWER + "]//h6";
				WebElement typeElement = driver.findElement(By.xpath(xpathForTypeQ));
				ClickUtilities.jsClick(driver, typeElement);

//				shortAnswerTextBox.click();
				click(driver, shortAnswerTextBox);

				assertTrue(shortAnswerMinLengthField.isDisplayed(), "shortAnswerMinLengthField is not displayed.");
				shortAnswerMinLengthField.clear();
				shortAnswerMinLengthField.sendKeys("1");

				assertTrue(shortAnswerMaxLengthField.isDisplayed(), "shortAnswerMaxLengthField is not displayed.");
				shortAnswerMaxLengthField.clear();
				shortAnswerMaxLengthField.sendKeys("100");

				assertTrue(shortAnswerValueTypeDropDown.isDisplayed() && shortAnswerValueTypeDropDown.isEnabled(),
						"Dropdown is not displayed and enabled.");
				Select valueTypeDropDown = new Select(shortAnswerValueTypeDropDown);

				assertFalse(valueTypeDropDown.isMultiple(), "Dropdown allows multiple selections.");

				// Check for empty drop down
				List<WebElement> options = valueTypeDropDown.getOptions();
				assertTrue(options.size() > 0, "Dropdown has no options.");
				System.out.println("Number of options in the dropdown: " + options.size());

//				Check default selected value
				WebElement defaultSelectedOption = valueTypeDropDown.getFirstSelectedOption();
				String expectedDefaultOption = "All"; // Replace with expected default value
				assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
						"Default selected option is incorrect.");

//		        Verify the order of options (if applicable)
				String[] expectedOrder = { "All", "Only Text", "Only Number" }; // Replace with the expected order
				for (int n = 0; n < expectedOrder.length; n++) {
					assertEquals(options.get(n).getText(), expectedOrder[n], "Option order is incorrect at index " + n);
				}

				// Print all options and check for duplicates
				Set<String> uniqueOptions = new HashSet<>();
				System.out.println("Dropdown options:");
				for (WebElement option : options) {
					String optionText = option.getText();
					System.out.println(optionText);
					assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
				}

				// Select each option by index and verify the selection
				for (int k = 0; k < options.size(); k++) {
					valueTypeDropDown.selectByIndex(k);
					WebElement selectedOption = valueTypeDropDown.getFirstSelectedOption();
					assertEquals(selectedOption.getText(), options.get(k).getText(),
							"Failed to select the option by index " + k);
					System.out.println(
							"Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
				}

//				valueTypeDropDown.selectByVisibleText("Only Text");
				valueTypeDropDown.selectByVisibleText("All");
//				valueTypeDropDown.selectByVisibleText("Only Number");

				jsClick(driver, shortAnswerAllowSpCharToggleButton);
				Thread.sleep(500);
				jsClick(driver, shortAnswerAllowSpCharToggleButton);

			}
			if (i == 3) {

//				questionTypes 7 : Date
				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Date of the call ?");
				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_1_"
						+ i + "']/following-sibling::div[" + DATE + "]//h6";
				WebElement typeElement = driver.findElement(By.xpath(xpathForTypeQ));
				ClickUtilities.jsClick(driver, typeElement);

				assertTrue(driver.findElement(By.id("startDate")).isDisplayed());

			}

			if (i == 4) {

//				questionTypes 8 : Time
				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Time of the call ?");
				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_1_"
						+ i + "']/following-sibling::div[" + TIME + "]//h6";
				WebElement typeElement = driver.findElement(By.xpath(xpathForTypeQ));
				ClickUtilities.jsClick(driver, typeElement);

				assertTrue(driver.findElement(By.xpath("//input[@class='answer_option time_pick']")).isDisplayed());

			}

			if (i == 5) {

//				questionTypes 6 : Radio Button
				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Did you picked your call ?");
				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_1_"
						+ i + "']/following-sibling::div[" + RADIO_BUTTON + "]//h6";
				WebElement typeElement = driver.findElement(By.xpath(xpathForTypeQ));
				ClickUtilities.jsClick(driver, typeElement);

				for (int a = 1; a <= 2; a++) {

					String radioOption = xpathQuestionTextField
							+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_" + i + "_"
							+ a + "']";

					System.out.println("radioOption : " + radioOption);

					WebElement radioOptionField = driver.findElement(By.xpath(radioOption));

					if (a == 1) {

						radioOptionField.sendKeys("Yes");

					}
					if (a == 2) {

						radioOptionField.sendKeys("No");

						String xpathAdd = "(" + xpathQuestionTextField
								+ "/following::div[@class='addquestion-padding add_option_btn question_add_option']/a[contains(@class, 'add-text')])[1]";

						ClickUtilities.jsClick(driver, driver.findElement(By.xpath(xpathAdd)));

///////////////					driver.findElement(By.xpath(xpath)).click();

					}

				}

				String radioOption1 = xpathQuestionTextField
						+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_" + i + "_"
						+ (i - 2) + "']";

				System.out.println("radioOption1 : " + radioOption1);

				WebElement radioOptionField1 = driver.findElement(By.xpath(radioOption1));

				radioOptionField1.sendKeys("NA");

			}
//			################################################

			if (i == 6) {

//				questionTypes 3 : Drop Down
				questionFields.sendKeys("Gender Of The Customer ?");
				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_1_"
						+ i + "']/following-sibling::div[" + DROP_DOWN + "]//h6";
				WebElement typeElement = driver.findElement(By.xpath(xpathForTypeQ));
				ClickUtilities.jsClick(driver, typeElement);

				for (int x = 1; x <= 3; x++) {

					String xpathAdd = "(" + xpathQuestionTextField
							+ "/following::div[@class='addquestion-padding add_option_btn question_add_option']/a[contains(@class, 'add-text')])[1]";

					ClickUtilities.jsClick(driver, driver.findElement(By.xpath(xpathAdd)));

				}

				for (int y = 1; y <= 4; y++) {

					if (y == 1) {
						String xpathDropDownOption1 = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_" + i
								+ "_" + y + "']";

						WebElement dropDownOptions1 = driver.findElement(By.xpath(xpathDropDownOption1));

						dropDownOptions1.sendKeys("Male");

					}

					if (y == 2) {

						String xpathDropDownOption = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_" + i
								+ "_" + y + "']";

						WebElement dropDownOptions = driver.findElement(By.xpath(xpathDropDownOption));

						dropDownOptions.sendKeys("Female");

					}

					if (y == 3) {

						String xpathDropDownOption = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_" + i
								+ "_" + y + "']";

						WebElement dropDownOptions = driver.findElement(By.xpath(xpathDropDownOption));

						dropDownOptions.sendKeys("Transgender");

					}

					if (y == 4) {

						String xpathDropDownOption = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_" + i
								+ "_" + y + "']";

						WebElement dropDownOptions = driver.findElement(By.xpath(xpathDropDownOption));

						dropDownOptions.sendKeys("Others");

					}

				}
			}

//	#############################################	

			if (i == 7) {

				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_1_"
						+ i + "']/following-sibling::div[" + TEXT_BOX + "]//h6";

				System.out.println(xpathForTypeQ);
				WebElement typeElement = driver.findElement(By.xpath(xpathForTypeQ));

//				questionTypes 9 : Text Box
				// Example interaction: setting text in the question fields
				js.executeScript("arguments[0].scrollIntoView(true);", questionFields);
				questionFields.sendKeys("Number Of The Customer ?");

				assertTrue(typeElement.isDisplayed());
				ClickUtilities.jsClick(driver, typeElement);

				ClickUtilities.clickWithRetry(DynamicXpath.questionTypeOptions(1, i, 1), 2);

				SendDataUtils.clearAndSendKeys(DynamicXpath.minLength(1, i), "10");

				SendDataUtils.clearAndSendKeys(DynamicXpath.maxLength(1, i), "14");

				Select valueTypeDropDown = new Select(DynamicXpath.valueTypeDropDown(1, i));

				assertFalse(valueTypeDropDown.isMultiple(), "Dropdown allows multiple selections.");

				// Check for empty drop down
				List<WebElement> options = valueTypeDropDown.getOptions();
				assertTrue(options.size() > 0, "Dropdown has no options.");
				System.out.println("Number of options in the dropdown: " + options.size());

//				Check default selected value
				WebElement defaultSelectedOption = valueTypeDropDown.getFirstSelectedOption();
				String expectedDefaultOption = "All"; // Replace with expected default value
				assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
						"Default selected option is incorrect.");

//		        Verify the order of options (if applicable)
				String[] expectedOrder = { "All", "Only Text", "Only Number" }; // Replace with the expected order
				for (int n = 0; n < expectedOrder.length; n++) {
					assertEquals(options.get(n).getText(), expectedOrder[n], "Option order is incorrect at index " + n);
				}

				// Print all options and check for duplicates
				Set<String> uniqueOptions = new HashSet<>();
				System.out.println("Dropdown options:");
				for (WebElement option : options) {
					String optionText = option.getText();
					System.out.println(optionText);
					assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
				}

				// Select each option by index and verify the selection
				for (int k = 0; k < options.size(); k++) {
					valueTypeDropDown.selectByIndex(k);
					WebElement selectedOption = valueTypeDropDown.getFirstSelectedOption();
					assertEquals(selectedOption.getText(), options.get(k).getText(),
							"Failed to select the option by index " + k);
					System.out.println(
							"Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
				}

//				valueTypeDropDown.selectByVisibleText("Only Text");
//				valueTypeDropDown.selectByVisibleText("All");
				valueTypeDropDown.selectByVisibleText("Only Number");

			}

		}

	}

	public void verifyDefaultSection2() throws Throwable {

		click(driver, addSectionButton);

		assertTrue(section2Element.isDisplayed(), "section2Element is not displayed.");

	}

	public void verifyByAddingQuestionsAndQuestionsTypeInSection2() throws Throwable {

		int count = 1;

		for (int i = 1; i <= count; i++) {

			String section2QuestionFieldNamePath = "//div[h5[text()='Section 2']]/ancestor::div/div[@class='parttwo']//div[@class='question qsn_number_"
					+ i + "']//input[@class='question_text']";

			WebElement section2QuestionField = driver.findElement(By.xpath(section2QuestionFieldNamePath));

			if (i == 1) {

//				FILE_UPLOAD
				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_2_"
						+ i + "']/following-sibling::div[" + FILE_UPLOAD + "]//h6";

				section2QuestionField.sendKeys("Customer Detail File ?");

				click(driver, driver.findElement(By.xpath(xpathForTypeQ)));

				click(driver, fileUploadSettingButton);

//				Select select = new Select(fileUploadOptionDropDown);

				// Locate the Select2 container and click to open the dropdown

				// Select options by typing into the Select2 search field and pressing Enter
//				fileUploadOptionField.click();

				ClickUtilities.clickAndHighlightElement(fileUploadOptionField, driver);

				for (WebElement a : checkOptions) {

					click(driver, a);
					System.out.println("Check box options : " + a.getText());
				}

				Thread.sleep(500);
				DynamicXpath.uploadMultipleFilesToggleButton(2, 1).click();

				Thread.sleep(300);
				DynamicXpath.allowDeleteToggleButton(2, 1).click();
				Thread.sleep(300);
				DynamicXpath.allowDeleteToggleButton(2, 1).click();

				SendDataUtils.clearAndSendKeys(DynamicXpath.maxsizeField(2, 1), "10");

				// *****************************************************************
				Select maxSize = new Select(DynamicXpath.maxsizeDropDown(2, 1));

				assertFalse(maxSize.isMultiple(), "Dropdown allows multiple selections.");

				// Check for empty drop down
				List<WebElement> options = maxSize.getOptions();
				assertTrue(options.size() > 0, "Dropdown has no options.");
				System.out.println("Number of options in the dropdown: " + options.size());

//				Check default selected value
				WebElement defaultSelectedOption = maxSize.getFirstSelectedOption();
				String expectedDefaultOption = "MB"; // Replace with expected default value
				assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
						"Default selected option is incorrect.");

//		        Verify the order of options (if applicable)
				String[] expectedOrder = { "MB", "GB" }; // Replace with the expected order
				for (int n = 0; n < expectedOrder.length; n++) {
					assertEquals(options.get(n).getText(), expectedOrder[n], "Option order is incorrect at index " + n);
				}

				// Print all options and check for duplicates
				Set<String> uniqueOptions = new HashSet<>();
				System.out.println("Dropdown options:");
				for (WebElement option : options) {
					String optionText = option.getText();
					System.out.println(optionText);
					assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
				}

				// Select each option by index and verify the selection
				for (int k = 0; k < options.size(); k++) {
					maxSize.selectByIndex(k);
					WebElement selectedOption = maxSize.getFirstSelectedOption();
					assertEquals(selectedOption.getText(), options.get(k).getText(),
							"Failed to select the option by index " + k);
					System.out.println(
							"Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
				}

//				select.selectByVisibleText("Only Text");
				maxSize.selectByVisibleText("MB");

//				************************************************************************************88

				click(driver, section2AddQuestionsButton);

				count++;
			}

			if (i == 2) {

				// RELATIVE_DROP_DOWN
				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_2_"
						+ i + "']/following-sibling::div[" + RELATIVE_DROP_DOWN + "]//h6";

				section2QuestionField.sendKeys("Customer wanted Ornaments ?");

				click(driver, driver.findElement(By.xpath(xpathForTypeQ)));

				for (int k = 1; k <= 3; k++) {

					String xpathForTypeQesOption = "//div[h5[text()='Section 2']]/ancestor::div/div/div//h5[text()='Question 2']/ancestor::div/div//input[@name='ans_option_2_2_"
							+ k + "']";

					String xpathaddOptionsButton = "(//div[h5[text()='Section 2']]/ancestor::div/div[@class='parttwo']/..//a[contains(@class, 'add-text')])[2]";

					WebElement option = driver.findElement(By.xpath(xpathForTypeQesOption));
					WebElement addOptionsButton = driver.findElement(By.xpath(xpathaddOptionsButton));

					if (k == 1) {

						option.sendKeys("Chain");

						click(driver, addOptionsButton);

					}

					if (k == 2) {

						option.sendKeys("Ring");

						click(driver, addOptionsButton);
					}

					if (k == 3) {

						option.sendKeys("Neckles");

					}

				}

				click(driver, section2AddQuestionsButton);
				count++;

			}

			if (i == 3) {

				// MULTIPLE_CHOICE
				String xpathForTypeQ = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_2_"
						+ i + "']/following-sibling::div[" + MULTIPLE_CHOICE + "]//h6";

				section2QuestionField.sendKeys("Customer Requirement ?");

				click(driver, driver.findElement(By.xpath(xpathForTypeQ)));

				int countN = 4;
				for (int k = 1; k <= countN; k++) {

					String xpathForTypeQesOption = "//div[h5[text()='Section 2']]/ancestor::div/div/div//h5[text()='Question 3']/ancestor::div/div//input[@name='ans_option_2_3_"
							+ k + "']";

					String xpathaddOptionsButton = "(//div[h5[text()='Section 2']]/ancestor::div/div[@class='parttwo']/..//a[contains(@class, 'add-text')])[3]";

					WebElement option = driver.findElement(By.xpath(xpathForTypeQesOption));
					WebElement addOptionsButton = driver.findElement(By.xpath(xpathaddOptionsButton));

					if (k == 1) {

						option.sendKeys("Price");

						click(driver, addOptionsButton);

					}

					if (k == 2) {

						option.sendKeys("Offer");

						click(driver, addOptionsButton);

					}

					if (k == 3) {

						option.sendKeys("Parts");

						click(driver, addOptionsButton);

					}

					if (k == 4) {

						option.sendKeys("Model");

					}

				}

//				click(driver, section2AddQuestionsButton);

				count++;

				break;
			}

		}

	}

	public void verifyIsConditionalandConnectTwoSections() throws Throwable {

		click(driver, section2SettingButton);

//		String beforeColorValue = isConditionalToggle.getCssValue("background-color");
//        System.out.println("CSS Color Value: " + beforeColorValue);
//		
//		 assertEquals(allowSpCharToggleButton.getCssValue("background-color"), expectedBeforeToggledBackgroundColor, "The background color did not change to the expected toggled state.");

		Thread.sleep(200);
		jsClick(driver, isConditionalToggleButton);

	}

//	####################################################################################################################################################################################

	public void verifySelectOptionAfterIsConditional() throws Throwable {

		WebElement element = driver.findElement(By.xpath("//input[@value='Male']"));

		js.executeScript("arguments[0].scrollIntoView(true);", element);

		ClickUtilities.clickWithRetry(element, 2);

//		***************** Need To Implement **********************
//		Select addCondition = new Select(DynamicXpath.addConditionDropDown(1, 1, 1));
//
//		assertFalse(addCondition.isMultiple(), "Dropdown allows multiple selections.");
//
//		// Check for empty drop down
//		List<WebElement> options = addCondition.getOptions();
//		assertTrue(options.size() > 0, "Dropdown has no options.");
//		System.out.println("Number of options in the dropdown: " + options.size());
//		
//		// Print all options and check for duplicates
//		Set<String> uniqueOptions = new HashSet<>();
//		System.out.println("Dropdown options:");
//		for (WebElement option : options) {
//			String optionText = option.getText();
//			System.out.println(optionText);
//			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
//		}

	}

	// ####################################################################################################################################################################################

	public void createFieldSetTabularView() throws Throwable {

		ClickUtilities.clickWithRetry(addSectionButton, 2);

		wait.until(ExpectedConditions.visibilityOf(section3SettingButton));
		ClickUtilities.clickWithDelay(section3SettingButton, 200);

		// WebDriver driver, WebElement element, int timeout, int pollingInterval
//		click(driver, DynamicXpath.tableView(2));
		ClickUtilities.clickAndHighlightElement(DynamicXpath.tableView(3), driver);

		for (int j = 1; j <= 4; j++) {

			String xpathForColumn1 = "//label[normalize-space()='COLUMN NAME " + j + "']";

			String xpathForColumn = "(//input[@placeholder='Enter your column Name'])[" + j + "]";

//				String xpathForTextBox = "//input[@name='question_3_1']";

			WebElement ClickColumn = driver.findElement(By.xpath(xpathForColumn1));
			WebElement sendDataColumn = driver.findElement(By.xpath(xpathForColumn));

//				WebElement textBoxUnderColumn = driver.findElement(By.name(xpathForTextBox));

			// Text Box
			if (j == 1) {

				click(driver, ClickColumn);
				sendDataColumn.sendKeys("Customer Name");

				ClickUtilities.highlightElement(DynamicXpath.textBox(3, j), driver);
				ClickUtilities.clickWithRetry(DynamicXpath.textBox(3, j), 2);

				SendDataUtils.clearAndSendKeys(DynamicXpath.textBox(3, j), "Name");

				ClickUtilities.clickAndHighlightElement(DynamicXpath.questionType(3, j, TEXT_BOX), driver);

				ClickUtilities.clickWithRetry(DynamicXpath.questionTypeOptions(3, j, 1), 2);

				SendDataUtils.clearAndSendKeys(DynamicXpath.minLength(3, j), "1");

				SendDataUtils.clearAndSendKeys(DynamicXpath.maxLength(3, j), "200");

				Select valueTypeDropDown = new Select(DynamicXpath.valueTypeDropDown(3, j));

				assertFalse(valueTypeDropDown.isMultiple(), "Dropdown allows multiple selections.");

				// Check for empty drop down
				List<WebElement> options = valueTypeDropDown.getOptions();
				assertTrue(options.size() > 0, "Dropdown has no options.");
				System.out.println("Number of options in the dropdown: " + options.size());

//				Check default selected value
				WebElement defaultSelectedOption = valueTypeDropDown.getFirstSelectedOption();
				String expectedDefaultOption = "All"; // Replace with expected default value
				assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
						"Default selected option is incorrect.");

//		        Verify the order of options (if applicable)
				String[] expectedOrder = { "All", "Only Text", "Only Number" }; // Replace with the expected order
				for (int n = 0; n < expectedOrder.length; n++) {
					assertEquals(options.get(n).getText(), expectedOrder[n], "Option order is incorrect at index " + n);
				}

				// Print all options and check for duplicates
				Set<String> uniqueOptions = new HashSet<>();
				System.out.println("Dropdown options:");
				for (WebElement option : options) {
					String optionText = option.getText();
					System.out.println(optionText);
					assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
				}

				// Select each option by index and verify the selection
				for (int k = 0; k < options.size(); k++) {
					valueTypeDropDown.selectByIndex(k);
					WebElement selectedOption = valueTypeDropDown.getFirstSelectedOption();
					assertEquals(selectedOption.getText(), options.get(k).getText(),
							"Failed to select the option by index " + k);
					System.out.println(
							"Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
				}

				valueTypeDropDown.selectByVisibleText("Only Text");
//				valueTypeDropDown.selectByVisibleText("All");
//				valueTypeDropDown.selectByVisibleText("Only Number");

			}

			if (j == 2) {

				click(driver, ClickColumn);
				sendDataColumn.sendKeys("Person Who Pick the Call");

				wait.until(ExpectedConditions.elementToBeClickable(DynamicXpath.textBox(3, j)));
//				ClickUtilities.highlightElement(DynamicXpath.textBox(3, j), driver);
				SendDataUtils.clearAndSendKeys(DynamicXpath.textBox(3, j), "Radio");
				ClickUtilities.clickWithRetry(DynamicXpath.textBox(3, j), 2);

				ClickUtilities.clickAndHighlightElement(DynamicXpath.questionType(3, j, RADIO_BUTTON), driver);

				SendDataUtils.clearAndSendKeys(DynamicXpath.questionTypeOptions(3, j, 1), "a");
				SendDataUtils.clearAndSendKeys(DynamicXpath.questionTypeOptions(3, j, 2), "b");

//				ClickUtilities.highlightElement(DynamicXpath.addOptions(3, j), driver);
				ClickUtilities.clickWithRetry(DynamicXpath.addOptions(3, j), 2);

				SendDataUtils.clearAndSendKeys(DynamicXpath.questionTypeOptions(3, j, 3), "c");

//					ClickUtilities.highlightElement(DynamicXpath.textBox(3, j), driver);
//					textBoxUnderColumn.click();
			}

			// Date Picker
			if (j == 3) {

				click(driver, ClickColumn);
				sendDataColumn.sendKeys("Call Date");
				ClickUtilities.clickAndHighlightElement(DynamicXpath.textBox(3, j), driver);
				wait.until(ExpectedConditions.elementToBeClickable(DynamicXpath.textBox(3, j)));
				SendDataUtils.clearAndSendKeys(DynamicXpath.textBox(3, j), "date");
				ClickUtilities.clickWithRetry(DynamicXpath.textBox(3, j), 2);

				ClickUtilities.clickAndHighlightElement(DynamicXpath.questionType(3, j, DATE), driver);

			}

			// File Upload
			if (j == 4) {

				click(driver, ClickColumn);
				sendDataColumn.sendKeys("Customer Detail File");
				wait.until(ExpectedConditions.elementToBeClickable(DynamicXpath.textBox(3, j)));
				SendDataUtils.clearAndSendKeys(DynamicXpath.textBox(3, j), "File");
				ClickUtilities.highlightElement(DynamicXpath.textBox(3, j), driver);
				ClickUtilities.clickWithRetry(DynamicXpath.textBox(3, j), 2);

				ClickUtilities.clickAndHighlightElement(DynamicXpath.questionType(3, j, FILE_UPLOAD), driver);
//				
				ClickUtilities.clickAndHighlightElement(DynamicXpath.fileTypeSetting((j - 2)), driver);
//
//
//				ClickUtilities.clickAndHighlightElement(fileUploadOptionField, driver);
//
//				for (WebElement a : checkOptions) {
//
//					click(driver, a);
//					System.out.println("Check box options : " + a.getText());
//				}

				/*
				 * Thread.sleep(500); DynamicXpath.uploadMultipleFilesToggleButton(3,
				 * 4).click();
				 * 
				 * Thread.sleep(300); DynamicXpath.allowDeleteToggleButton(3, 4).click();
				 * Thread.sleep(300); DynamicXpath.allowDeleteToggleButton(3, 4).click();
				 * 
				 * SendDataUtils.clearAndSendKeys(DynamicXpath.maxsizeField(3, 4), "10");
				 * 
				 * // ***************************************************************** Select
				 * maxSize = new Select(DynamicXpath.maxsizeDropDown(3, 4));
				 * 
				 * assertFalse(maxSize.isMultiple(), "Dropdown allows multiple selections.");
				 * 
				 * // Check for empty drop down List<WebElement> options = maxSize.getOptions();
				 * assertTrue(options.size() > 0, "Dropdown has no options.");
				 * System.out.println("Number of options in the dropdown: " + options.size());
				 * 
				 * // Check default selected value WebElement defaultSelectedOption =
				 * maxSize.getFirstSelectedOption(); String expectedDefaultOption = "MB"; //
				 * Replace with expected default value
				 * assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
				 * "Default selected option is incorrect.");
				 * 
				 * // Verify the order of options (if applicable) String[] expectedOrder = {
				 * "MB", "GB" }; // Replace with the expected order for (int n = 0; n <
				 * expectedOrder.length; n++) { assertEquals(options.get(n).getText(),
				 * expectedOrder[n], "Option order is incorrect at index " + n); }
				 * 
				 * // Print all options and check for duplicates Set<String> uniqueOptions = new
				 * HashSet<>(); System.out.println("Dropdown options:"); for (WebElement option
				 * : options) { String optionText = option.getText();
				 * System.out.println(optionText); assertTrue(uniqueOptions.add(optionText),
				 * "Duplicate option found: " + optionText); }
				 * 
				 * // Select each option by index and verify the selection for (int k = 0; k <
				 * options.size(); k++) { maxSize.selectByIndex(k); WebElement selectedOption =
				 * maxSize.getFirstSelectedOption(); assertEquals(selectedOption.getText(),
				 * options.get(k).getText(), "Failed to select the option by index " + k);
				 * System.out.println( "Option '" + options.get(k).getText() +
				 * "' was successfully selected by index " + k + "."); }
				 * 
				 * // select.selectByVisibleText("Only Text");
				 * maxSize.selectByVisibleText("MB");
				 */

//				************************************************************************************88

			}

		}
	}

	public void verifySaveInCreateFieldSet() throws Throwable {

		click(driver, saveButtonElement);

		wait.until(ExpectedConditions.visibilityOf(successConfirmationPopup));
		assertTrue(successConfirmationPopup.isDisplayed(), "successConfirmationPopup is not displayed.");

		click(driver, ContinueButtonOnSuccessConfirmationPopup);
	}

	public void verifyNumberFieldInCreateFieldSet() throws Throwable {

//		commonNavigation();
		verifyBeforeFieldSetCreatedCount();
		verifyFieldSetCreateButton();

		verifyQuestionSetNameField();

		verifyRemarkField();

		SendDataUtils.clearAndSendKeys(DynamicXpath.questionField(1, 1, 1), "Mobile Number");

		ClickUtilities.clickWithRetry(DynamicXpath.questionType(1, 1, TEXT_BOX), 2);

		ClickUtilities.clickWithRetry(DynamicXpath.questionTypeOptions(1, 1, 1), 2);

		SendDataUtils.clearAndSendKeys(DynamicXpath.minLength(1, 1), "1");

		SendDataUtils.clearAndSendKeys(DynamicXpath.maxLength(1, 1), "10");

		Select valueTypeDropDown = new Select(DynamicXpath.valueTypeDropDown(1, 1));

		assertFalse(valueTypeDropDown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = valueTypeDropDown.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

//		Check default selected value
		WebElement defaultSelectedOption = valueTypeDropDown.getFirstSelectedOption();
		String expectedDefaultOption = "All"; // Replace with expected default value
		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption, "Default selected option is incorrect.");

//        Verify the order of options (if applicable)
		String[] expectedOrder = { "All", "Only Text", "Only Number" }; // Replace with the expected order
		for (int n = 0; n < expectedOrder.length; n++) {
			assertEquals(options.get(n).getText(), expectedOrder[n], "Option order is incorrect at index " + n);
		}

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < options.size(); k++) {
			valueTypeDropDown.selectByIndex(k);
			WebElement selectedOption = valueTypeDropDown.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

//		valueTypeDropDown.selectByVisibleText("Only Text");
//		valueTypeDropDown.selectByVisibleText("All");
		valueTypeDropDown.selectByVisibleText("Only Number");

		verifySaveInCreateFieldSet();

		verifyAfterFieldSetCreatedCount();

	}

//	**********************************************************Create Ended**************************************************************************************************************

	public void verifyAfterFieldSetCreatedCount() throws Throwable {

		click(driver, leftArrowToGoBackTablePage);

		Thread.sleep(2000);

		String afterCreateRecords = driver.findElement(By.xpath("(//p[@class='show_entries m-0 font_13'])[1]"))
				.getText();

		assertNotNull(afterCreateRecords, "afterCreateRecords is null.");
		System.out.println("afterCreateRecords : " + afterCreateRecords);

		int afterNumber = extractNumber(afterCreateRecords);
		System.out.println("afterNumber : " + afterNumber);

		assertEquals(afterNumber, existingFieldSetRecordCount);
	}

	public static int extractNumber(String input) {
		StringBuilder numberAsString = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				numberAsString.append(c);
			}
		}

		// Check if the numberAsString has at least 3 digits
		if (numberAsString.length() > 3) {
			// Remove the first 3 digits
			numberAsString = new StringBuilder(numberAsString.substring(3));
		} else {
			// If there are fewer than 3 digits, set the numberAsString to "0" or handle
			// accordingly
			numberAsString = new StringBuilder("0");
		}

		// Parse the remaining string to an integer
		return Integer.parseInt(numberAsString.toString());
	}
//	**********************************************************Edit Started**************************************************************************************************************


	public void tablePageSearch() throws Throwable {

		String firstRecord = fetchCreatedRecord.getText();

		System.out.println("firstRecord : " + firstRecord);

		assertTrue(searchBox.isDisplayed(), "searchBox is not displayed.");
		assertNotNull(firstRecord, "firstRecord is null.");
		searchBox.sendKeys(firstRecord);

		click(driver, searchButton);

		WebElement searchRecord = driver.findElement(By.xpath("//td[text()='" + firstRecord + "']"));
		assertTrue(searchRecord.isDisplayed(), "searchRecord is not displayed.");

	}

	public void tablePageDatePicker() throws Throwable {

		assertTrue(createdDatePicker.isDisplayed(), "createdDatePicker is not displayed.");
		createdDatePicker.click();
		createdDatePicker.click();
		createdDatePicker.sendKeys("25-04-2024");
		createdDatePicker.sendKeys(Keys.ENTER);

		click(driver, searchButton);
	}

	public void tablePageClearFilter() throws Throwable {
		click(driver, clearFilterButton);

	}

	public void tablePagePagination() throws Throwable {

//		Pagination.paginate(driver, rightArrow, leftArrow);
		
		Pagination.paginateWithCount(driver, rightArrow, leftArrow,6);

		Pagination.paginateWithCount(driver, rightArrow, leftArrow, 3);

		driver.navigate().refresh();
//		---------------------------------------------------------------------------
	}

//	##################################################################################################################################
//	##################################################################################################################################
//	##################################################################################################################################
//	##################################################################################################################################
//	##################################################################################################################################
//	##################################################################################################################################

	public void verifyEnterQuestionSetName(String questionSetName) {

		String text = driver.findElement(By.xpath("//label[normalize-space()='QUESTION SET *']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		assertTrue(questionSetNameFieldElement.isDisplayed());

		questionSetNameFieldElement.clear();
		questionSetNameFieldElement.sendKeys(questionSetName);

	}

	public MastersFieldSets addDropDownRelatedQuestions(String question, int sectionIndex, int questionIndex,
			int questionType, List<String> options) throws Throwable {

		// Construct XPath for the question text field and find the element
		String baseXPath = "//div[h5[contains(text(), 'Question " + questionIndex + "')]]";
		String xpathQuestionTextField = baseXPath + "//input[@name='question_" + sectionIndex + "_" + questionIndex
				+ "']";
		WebElement questionFields = driver.findElement(By.xpath(xpathQuestionTextField));

		// Send the question to the input field
		questionFields.sendKeys(question);

		// Construct XPath for the question type and click on it
		String xpathForQuestionType = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
				+ sectionIndex + "_" + questionIndex + "']/following-sibling::div[" + questionType + "]//h6";
		
		ClickUtilities.jsClick(driver, driver.findElement(By.xpath(xpathForQuestionType)));

		// Add options and input them into the dropdown fields
		for (int i = 0; i < options.size(); i++) {

			if (i > 0) { // Add the "Add Option" button click only for options beyond the first one
				String xpathAdd = "(" + baseXPath
						+ "/following::div[@class='addquestion-padding add_option_btn question_add_option']/a[contains(@class, 'add-text')])[1]";
//				ClickUtilities.clickWithRetry(driver.findElement(By.xpath(xpathAdd)), 3);
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpathAdd)));
				jsClick(driver, driver.findElement(By.xpath(xpathAdd)));
			}

			// Input the option text
			String xpathDropDownOption = baseXPath
					+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_" + sectionIndex + "_"
					+ questionIndex + "_" + (i + 1) + "']";

			driver.findElement(By.xpath(xpathDropDownOption)).sendKeys(options.get(i));

		}

		return this;
	}

//Usage
//	List<String> options = Arrays.asList("OptionA", "OptionB", "OptionC", "OptionD");
//	addDropDownRelatedQuestions("Create Drop Down ?", 1, 6, DROP_DOWN, options);

	public MastersFieldSets addTextBoxRelatedQuestions(String question, int sectionIndex, int questionIndex,
			int questionType, String minLength, String maxLength, String expectedDefaultOption, String[] expectedOrder,
			String typeOfValue) throws Throwable {

		// Construct XPath for the question text field and find the element
		String baseXPath = "//div[h5[contains(text(), 'Question " + questionIndex + "')]]";
		String xpathQuestionTextField = baseXPath + "//input[@name='question_" + sectionIndex + "_" + questionIndex
				+ "']";

		WebElement questionFields = driver.findElement(By.xpath(xpathQuestionTextField));

		// Send the question to the input field
		questionFields.sendKeys(question);

		// Construct XPath for the question type and click on it
		String xpathForQuestionType = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
				+ sectionIndex + "_" + questionIndex + "']/following-sibling::div[" + questionType + "]//h6";

		ClickUtilities.jsClick(driver, driver.findElement(By.xpath(xpathForQuestionType)));

		click(driver, DynamicXpath.questionTypeOptions(sectionIndex, questionIndex, 1));
		
		// Set minLength and maxLength
		
//		js.executeScript("arguments[0].scrollIntoView(true);", DynamicXpath.minLength(sectionIndex, questionIndex));
		
		SendDataUtils.clearAndSendKeys(DynamicXpath.minLength(sectionIndex, questionIndex), minLength);
		SendDataUtils.clearAndSendKeys(DynamicXpath.maxLength(sectionIndex, questionIndex), maxLength);
		if (questionType == 10) {

			click(driver, DynamicXpath.questionTypeOptions(sectionIndex, questionIndex, 1));

		} else {
			// Handle default or unexpected questionType
			click(driver, DynamicXpath.shortAnswerQuestionOpt(sectionIndex, questionIndex, 1));
		}

		if (questionType == 10) {
			// Set minLength and maxLength
			SendDataUtils.clearAndSendKeys(DynamicXpath.minLength(sectionIndex, questionIndex), minLength);
			SendDataUtils.clearAndSendKeys(DynamicXpath.maxLength(sectionIndex, questionIndex), maxLength);
		} else {

			SendDataUtils.clearAndSendKeys(DynamicXpath.shortMinLength(sectionIndex, questionIndex), minLength);
			SendDataUtils.clearAndSendKeys(DynamicXpath.shortMaxLength(sectionIndex, questionIndex), maxLength);
		}

		// Create a Select object for the dropdown element
		if (questionType == 10) {
			Select valueTypeDropDown = new Select(DynamicXpath.valueTypeDropDown(sectionIndex, questionIndex));
			// Validate the dropdown options, default selection, and order
			DropDown.validateDropdown(valueTypeDropDown, expectedDefaultOption, expectedOrder);

			// Select the desired option by visible text (if needed)
			valueTypeDropDown.selectByVisibleText(typeOfValue);
		} else {
			Select valueTypeDropDown = new Select(DynamicXpath.shortValueTypeDropDown(sectionIndex, questionIndex));
			// Validate the dropdown options, default selection, and order
			DropDown.validateDropdown(valueTypeDropDown, expectedDefaultOption, expectedOrder);

		// Select the desired option by visible text (if needed)
		valueTypeDropDown.selectByVisibleText("All");
			// Select the desired option by visible text (if needed)
			valueTypeDropDown.selectByVisibleText(typeOfValue);
		}

		if (questionType == 10) {

			click(driver, DynamicXpath.allowSpCharToggle(sectionIndex, questionIndex));
			Thread.sleep(400);
			click(driver, DynamicXpath.allowSpCharToggle(sectionIndex, questionIndex));

		} else {

			click(driver, DynamicXpath.shortAllowSpCharToggle(sectionIndex, questionIndex));
			Thread.sleep(400);
			click(driver, DynamicXpath.shortAllowSpCharToggle(sectionIndex, questionIndex));
		}

		return this;
	}

//	String question = "Number Of The Customer?";
//    int sectionIndex = 1;
//    int questionIndex = 1;
//    int questionType = 9;  // Assuming 9 corresponds to 'Text Box'
//    String minLength = "10";
//    String maxLength = "14";
//    String expectedDefaultOption = "All";
//    String[] expectedOrder = { "All", "Only Text", "Only Number" };
//	  String typeOfValue = "Only Number"; //"All", "Only Text", "Only Number";
//
//    // Call the method to add and validate text box related questions
//    addTextBoxRelatedQuestions(question, sectionIndex, questionIndex, questionType, minLength, maxLength, 
//                               expectedDefaultOption, expectedOrder);

	public MastersFieldSets addQuestions(int sectionIndex) throws Throwable {

		String addQuestionXpath = "(//img[@alt='plusicon']/..//a[@class='add-text'][normalize-space()='Add Question'])["
				+ sectionIndex + "]";

		WebElement addQuestionButton = driver.findElement(By.xpath(addQuestionXpath));

		ClickUtilities.clickWithRetry(addQuestionButton, 2);

		return this;
	}

	public MastersFieldSets addSection() throws Throwable {

		js.executeScript("arguments[0].scrollIntoView(true);", addSectionButton);
		jsClick(driver, addSectionButton);

		return this;
	}

}
