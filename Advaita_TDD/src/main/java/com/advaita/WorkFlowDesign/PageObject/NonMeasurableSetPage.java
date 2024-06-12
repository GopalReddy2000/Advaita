package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.Pagination;

import Advaita_TDD.Advaita_TDD.FakeData;

public class NonMeasurableSetPage extends TestBase {

	FakeData fake = new FakeData();

	static int createCount = 1;

	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']")
	public static WebElement workFlowDesign;

	@FindBy(id = "pills-MasterParameter-tab")
	public static WebElement masterParameterTab;

	@FindBy(id = "pills-NonMeasurableSet-tab")
	public static WebElement nonMeasurableTab;

	@FindBy(linkText = "+ Add Non Measurable Set")
	public static WebElement addNonMeasurableSetButton;

	@FindBy(id = "questionSet_name")
	public static WebElement questionSetNameField;

	@FindBy(xpath = "(//img[@alt='settingicon'])[1]")
	public static WebElement settingButton;

	@FindBy(xpath = "(//label[contains(text(),'SECTION')])[1]/..//input")
	public static WebElement sectionField;

	@FindBy(xpath = "(//label[contains(text(),'SECTION REMARKS')])[1]/..//input")
	public static WebElement sectionRemarkField;

	@FindBy(xpath = "(//a/span/..//h5[normalize-space()='Table View'])[1]")
	public static WebElement tableView;

	@FindBy(xpath = "(//button[@class='quantity-right-plus_addcol btn']//span)[1]")
	public static WebElement columnPlusButton;

	@FindBy(xpath = "//label[contains(@class,'column-name1')]//parent::div")
	public static List<WebElement> columnNames;

	@FindBy(xpath = "//input[contains(@name,'question_1_')]")
	public static List<WebElement> columnInputField;

	@FindBy(xpath = "//div[@class='entername-tick position-relative']//input")
	public static List<WebElement> enterYourColumn;

	@FindBy(xpath = "//tr[@class='Question-set']//td[1]")
	public static List<WebElement> nonMeasurableQuestionSet;

	@FindBy(xpath = "(//a[@data-value='Drop Down'])[1]")
	public static WebElement sec1Ques1DropDowntype;


	@FindBy(xpath = "(//a[@data-info2='Normal View'])[1]")
	public static WebElement normalView;

	@FindBy(name = "is_conditional_1")
	public static WebElement isConditional;

	//	@FindBy(xpath = "//div[@class='add-section add_section']//a")
	//	public static WebElement addSection;



	@FindBy(name = "is_relative_parent_1")
	public static WebElement isRelativeParent;

	@FindBy(xpath = "(//select[@class='rule-select edit-measurable_normal_view'])[1]")
	public static WebElement questionSetDropdown;

	@FindBy(xpath = "//input[contains(@name, 'question_1_')]")
	public static WebElement question1;

	@FindBy(xpath = "(//a[@data-value='Label'])[1]")
	public static WebElement questionTypeLabel;

	@FindBy(xpath = "(//a[@data-value='Multiple Choice'])[1]")
	public static WebElement questionTypeMultipleChoice;

	@FindBy(xpath = "//input[contains(@name,'ans_option_1_1_')]")
	public static List<WebElement>  multipleChoiceTextbox;

	@FindBy(linkText = "Add Option")
	public static WebElement addOption;

	@FindBy(xpath = "//div[@data-info='question-1-1']//a")
	public static WebElement addOptionQuestion1;



	@FindBy(xpath = "//input[contains(@name, 'ans_option_1_1_')]/following-sibling::img[@class='outlineimg']")
	public static List<WebElement> choiceDelete;

	@FindBy(xpath = "(//a[@data-value='Short Answer'])[1]")
	public static WebElement questionTypeShortAnswer;

	@FindBy(xpath = "//textarea[@class='answer_option short_answer_input']")
	public static WebElement shortAnswerTextArea;

	@FindBy(xpath = "//input[@name='shortans_settings_min_length_1_1']")
	public static WebElement shortAnswerMinLen;

	@FindBy(xpath = "//input[@name='shortans_settings_max_length_1_1']")
	public static WebElement shortAnswerMaxLen;

	@FindBy(xpath = "//select[@name='shortans_settings_value_type_1_1']")
	public static WebElement shortAnswerValTypeDropdown;

	@FindBy(xpath = "//input[@name='shortans_settings_allow_sp_char_1_1']")
	public static WebElement shortAnswerAllowSpChar;

	@FindBy(xpath = "(//a[@data-value='Drop Down'])[1]")
	public static WebElement questionTypeDropdown;

	@FindBy(name = "ans_option_1_1_1")
	public static WebElement dropdownTextArea;

	@FindBy(xpath = "(//span[@class='slider round'])[1]")
	public static WebElement dropdownSetAsDefault;

	@FindBy(xpath = "(//span[@class='slider round'])[2]")
	public static WebElement dropdownIsFatal;

	@FindBy(xpath = "//img[contains(@src,'table-edit')]")
	public static List<WebElement> NonMeasurableEditbuttons;

	@FindBy(xpath = "(//a[@data-value='Relative Dropdown'])[1]")
	public static WebElement questionTypeRelativeDropdown;

	@FindBy(xpath = "(//a[@data-value='File Upload'])[1]")
	public static WebElement questionTypeFileUpload;

	@FindBy(xpath = "//input[@id='Browse']")
	public static WebElement fileUploadBrowse;

	@FindBy(xpath = "//img[@name='ans_option_1_1_1']")
	public static WebElement fileUploadSetting;

	@FindBy(xpath = "//select[@id='allowed_format_1_1']")
	public static WebElement allowedFormatDropdown;

	@FindBy(xpath = "//img[@class='plusiconimg additional_format_settings_1_1']")
	public static WebElement fileFormatAddAdditionalFormat;

	@FindBy(name = "fileupload_settings_additionalformat_1_1")
	public static WebElement fileFormatAddAdditionalFormatInputBox;

	@FindBy(id = "additionalFormatButton_1_1")
	public static WebElement fileFormatAddFormatButton;

	@FindBy(xpath = "(//button[text()='Continue'])[2]")
	public static WebElement fileAlreadyExistsContinueButton;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public static WebElement questionSaveContinueButton;

	@FindBy(xpath = "//li[contains(@class,'select2-results__option')]")
	public static List<WebElement> fileUploadListOfAllowedFormats;

	@FindBy(xpath = "(//a[@data-value='Radio Button'])[1]")
	public static WebElement questionTypeRadioButton;

	@FindBy(xpath = "(//a[@data-value='Date'])[1]")
	public static WebElement questionTypeDate;

	@FindBy(xpath = "(//a[@data-value='Time'])[1]")
	public static WebElement questionTypeTime;

	@FindBy(xpath = "(//a[@data-value='Text Box'])[1]")
	public static WebElement questionTypeTextbox;

	@FindBy(xpath = "(//a[@data-value='Relative MultiSelect'])[1]")
	public static WebElement questionTypeRelativeMultiSeclect;

	@FindBy(name = "question_required_1_1")
	public static WebElement required;

	@FindBy(name = "question_escalated_1_1")
	public static WebElement escalatedField;


	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Text Box'])[1]")
	public static WebElement textBox;

	@FindBy(xpath = "(//h5[normalize-space()='Min Len']/..//input)[1]")
	public static WebElement textBoxLine;

	@FindBy(xpath = "(//img[@alt='feathertrash'])[1]")
	public static WebElement deleteOrTrashButton;

	@FindBy(linkText = "Add Question")
	public static WebElement addQuestionButton;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Date'])[1]")
	public static WebElement dateType;

	@FindBy(id = "startDate")
	public static WebElement dateField;

	@FindBy(xpath = "(//label[text()='ADD COLUMN']/..//span[@class='plus'])[2]")
	public static WebElement plusColumnButton;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Drop Down'])[1]")
	public static WebElement dropDownOption;

	@FindBy(xpath = "//div[@class='addquestion-padding addoption_padding add_option_btn_table_view option_btn_show_1_1']//img[@alt='plusicon']/..//a[text()='Add Option']")
	public static WebElement addDropDownOptionField;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Radio Button'])[1]")
	public static WebElement radioButtonOption;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Time'])[1]")
	public static WebElement timeOption;

	@FindBy(id = "startDate")
	public static WebElement timePicker;

	@FindBy(xpath = "//div[@class='xdsoft_time ']/..//div[contains(@data-hour,'1')]/..//div[text()='01:00']")
	public static WebElement timePickerNext;

	@FindBy(xpath = "(//button[@class='xdsoft_next'])[2]")
	public static WebElement timePickerPrevious;

	@FindBy(linkText = "Add Section")
	public static WebElement addSectionButton;

	@FindBy(xpath = "//input[@name='question_2_1']")
	public static WebElement section2Question;

	@FindBy(xpath = "(//img[@alt='settingicon'])[2]")
	public static WebElement settingButton2;

	@FindBy(xpath = "(//a/span/..//h5[normalize-space()='Table View'])[2]")
	public static WebElement tabularView2;

	@FindBy(xpath = "//button[@id='create_btn']/..//button[text()='Save']")
	public static WebElement saveButtonOfCreateQuestionSet;

	@FindBy(xpath = "(//button[contains(text(),'Continue')])[1]")
	public static WebElement successPopUpWithContinueButtonAfterCreate;

	@FindBy(xpath = "//img[@alt='arrow-left']")
	public static WebElement leftArrowToGoBackTablePage;

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

	@FindBy(id = "exampleFormControlTextarea1")
	public static WebElement remarkFieldInEditPage;

	@FindBy(id = "create_btn")
	public static WebElement saveButtonInEditPage;

	@FindBy(xpath = "//span[normalize-space(text())='Non Measurable Set has been updated successfully']")
	public static WebElement successfullyNonMeasurableUpdatedMassage;

	@FindBy(xpath = "//span[@id='change_msg']/following-sibling::button")
	public static WebElement afterNonMeasurableUpdatedContinueButton;

	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public static WebElement editNonMeasurableSetButton;


	@FindBy(xpath = "(//div[@class='form_group setsecond select-questionpad '])[1]//div//a//span")
	public static List<WebElement> selectQuestionType;

	@FindBy(xpath = "//h5/following-sibling::input[contains(@name,'question_')]")
	public static List<WebElement> questionList;

	@FindBy(id = "create_btn")
	public static WebElement questionSaveButton;

	@FindBy(xpath = "//div[contains(@class,'d-flex align-items-center')]//a")
	public static WebElement backButton;

	@FindBy(xpath = "//button[normalize-space()='Stages']")
	public WebElement stagesTab;
	
	@FindBy(xpath = "//select[@class='rule-select form-control font_14 firstselect section_c_param_dropdown']")
	public WebElement selectQuestiontypeDropdown;
	
	@FindBy(xpath = "(//button[@data-type='NonMesaurable'])[2]")
	public WebElement sectionButton;
	
	@FindBy(xpath = "//label[normalize-space()='Non Measurable Set']//span")
	public WebElement nonMeasurableRadioButton;
	
	@FindBy(xpath = "//div[@class='custom-select']//select")
	public WebElement isConditonalSection1Question1;

	@FindBy(xpath = "//img[@alt='table-edit' and @class='img-fluid stages_edit delete-dataset']")
	public List<WebElement> editButtons;
	


	public NonMeasurableSetPage() {
		PageFactory.initElements(driver, this);
	}

	public void commonNavigation()
	{
		click(driver, workFlowDesign);
		click(driver, masterParameterTab);
		click(driver, nonMeasurableTab);
		click(driver, addNonMeasurableSetButton);
		questionSetNameField.clear();
		questionSetNameField.sendKeys(fake.lastName1());

		question1.clear();
		question1.sendKeys("Question1");
	}

	public void multipleChoice()
	{
		commonNavigation();

		questionSetNameField.clear();
		questionSetNameField.sendKeys("MultipleChoice");

		click(driver, settingButton);
		sectionField.clear();
		sectionField.sendKeys("Section Testing");

		assertTrue(isConditional.isEnabled());
		assertTrue(isRelativeParent.isEnabled());

		Select select=new Select (questionSetDropdown);
		List<WebElement> options=select.getOptions();
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}



		question1.clear();
		question1.sendKeys("Question1");

		click(driver, questionTypeMultipleChoice);

		assertTrue(choiceDelete.get(0).isEnabled());
		assertTrue(addQuestionButton.isEnabled());
		assertTrue(addSectionButton.isEnabled());

		for(int q=1;q<=3;q++)
		{
			addOption.click();
		}

		int Question=multipleChoiceTextbox.size();

		for(int a=0;a<Question;a++)
		{
			multipleChoiceTextbox.get(a).sendKeys("Options "+(a+1));

		}


	}

	public void shortAnswer()
	{
		commonNavigation();

		click(driver, questionTypeShortAnswer);

		assertTrue(shortAnswerTextArea.isEnabled());

		click(driver, shortAnswerTextArea);


		assertEquals(shortAnswerMinLen.getAttribute("value"), "1");
		assertEquals(shortAnswerMaxLen.getAttribute("value"), "250");

		sendKeys(shortAnswerMinLen, "-98"); sendKeys(shortAnswerMaxLen, "-98");

		Select valType= new Select(shortAnswerValTypeDropdown);

		List<String>actualOptions=new ArrayList<>();

		for(WebElement options:valType.getOptions())
		{
			String opt= options.getText();
			//			System.out.println(opt);
			actualOptions.add(opt);
		}


		List<String> expectedOptions=Arrays.asList("All","Only Text","Only Number");


		assertEquals(actualOptions, expectedOptions,"It is Not Equal");
		assertTrue(NonMeasurableSetPage.shortAnswerAllowSpChar.isEnabled(),"Short Answer Allow Special Character is not Enabled");

		System.out.println(expectedOptions);
		System.out.println(actualOptions);
		click(driver, saveButtonOfCreateQuestionSet);
		assertFalse(!NonMeasurableSetPage.successPopUpWithContinueButtonAfterCreate.isDisplayed(),"The Negative Values in min and max len are saved,");

	}

	public void questionTypeDropDown()
	{
		commonNavigation();

		click(driver, questionTypeDropdown);

		Assert.assertTrue(addOption.isEnabled());
		Assert.assertTrue(choiceDelete.get(0).isEnabled());
		dropdownTextArea.click();
		//		Asserting Set as Default and Is Fatal toggle button is Enabled or not

		Assert.assertTrue(dropdownSetAsDefault.isEnabled());
		Assert.assertTrue(dropdownIsFatal.isEnabled());

		for(int a=1;a<3;a++) {

			dropdownSetAsDefault.click();
			System.out.println(driver.findElement(By.name("set_as_default_val_1_1_1")).getAttribute("value"));

			dropdownIsFatal.click();
			System.out.println(driver.findElement(By.name("is_fatal_val_1_1_1")).getAttribute("value"));

		}

		//		Asserting Adding and Deleting BackAndForth
		for(int a=1;a<3;a++) {
			for(int q=1;q<=3;q++)
			{
				addOption.click();
			}
			List<WebElement> deleteButton=choiceDelete;

			for(WebElement delete:deleteButton)
			{
				delete.click();
			}

		}


	}

	public void questionTypeRelativeDropdown()
	{
		commonNavigation();
		click(driver,questionTypeRelativeDropdown);

		Assert.assertTrue(addOption.isEnabled());
		Assert.assertTrue(choiceDelete.get(0).isEnabled());
		dropdownTextArea.click();
		//		Asserting Set as Default and Is Fatal toggle button is Enabled or not

		Assert.assertTrue(dropdownSetAsDefault.isEnabled());
		Assert.assertTrue(dropdownIsFatal.isEnabled());

		for(int a=1;a<3;a++) {

			dropdownSetAsDefault.click();
			System.out.println(driver.findElement(By.name("set_as_default_val_1_1_1")).getAttribute("value"));

			dropdownIsFatal.click();
			System.out.println(driver.findElement(By.name("is_fatal_val_1_1_1")).getAttribute("value"));

		}

		//		Asserting Adding and Deleting BackAndForth
		for(int a=1;a<3;a++) {
			for(int q=1;q<=3;q++)
			{
				addOption.click();
			}
			List<WebElement> deleteButton=choiceDelete;

			for(WebElement delete:deleteButton)
			{
				delete.click();
			}

		}


	}

	public void fileUpload()
	{
		click(driver, workFlowDesign);
		click(driver, masterParameterTab);
		click(driver, nonMeasurableTab);
		click(driver, NonMeasurableEditbuttons.get(0));
		click(driver, question1);
		click(driver, questionTypeFileUpload);
		assertTrue(fileUploadBrowse.isEnabled());
		click(driver, fileUploadSetting);

		Select allowedFormat=new Select(allowedFormatDropdown);

		for(WebElement allowFormat:allowedFormat.getOptions())
		{
			System.out.println(allowFormat.getText());
		}

		String[] fileFormats = {
				"TXT", "CSV",
				"DOC", "DOCX", "PDF",
				"XLS", "XLSX", "ODS",
				"PPT", "PPTX", "ODP",
				"JPG", "JPEG", "PNG", "GIF", "BMP",
				"MP3", "WAV", "FLAC",
				"MP4", "AVI", "MOV", "MKV",
				"ZIP", "RAR", "TAR", "GZIP", "BZIP2",
				"JAVA", "PY", "CPP", "HTML", "XML",
				"SQL", "SQLite"
		};

		String fileformat= getRandomString(fileFormats);

		click(driver, fileFormatAddAdditionalFormat);
		sendKeys(fileFormatAddAdditionalFormatInputBox, "."+fileformat);
		System.out.println(fileformat);
		//		click(driver, fileFormatAddFormatButton);
		try
		{
			if(fileAlreadyExistsContinueButton.isDisplayed()) {
				fileAlreadyExistsContinueButton.click();
			}

		}catch (NoSuchElementException | NullPointerException e) {

		} 
		{

		}


	}

	private static String getRandomString(String[] array) {
		// Generate a random index within the array length
		Random random = new Random();
		int randomIndex = random.nextInt(array.length);
		return array[randomIndex];
	}

	public WebElement getElementByDynamicXPath(int q) {
		String xpath = "(//input[contains(@name,'question_type_1_" + (q + 1) + "')]/following-sibling::div//a)[" + (q + 1) + "]";
		return driver.findElement(By.xpath(xpath));
	}


	public void createNormalView()
	{
		click(driver, workFlowDesign);
		click(driver, masterParameterTab);
		click(driver, nonMeasurableTab);
		click(driver, addNonMeasurableSetButton);
		String questionName= "Software Testing "+fake.lastName1();
		sendKeys(questionSetNameField,questionName );

		List<WebElement> questionTypeList =selectQuestionType;
		List<WebElement> questionsList=questionList;



		for (int q=0;q<questionTypeList.size();q++)
		{


			switch(q)
			{
			//			Label
			case(0):
				jsClick(driver, questionsList.get(q));
			jsClick(driver,getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "Advaita Testing");
			click(driver, addQuestionButton);

			break;

			//			MultipleChoice
			case(1):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "What Level of Software Testing are you doing?");

			clickElementMultipleTimes(driver, driver.findElement(By.xpath("(//a[normalize-space()='Add Option'])[2]")), 2);
			List<WebElement>options=driver.findElements(By.xpath("//div[@class='question qsn_number_2']//div[@class='input-delete d-flex']//input"));
			options.get(0).sendKeys("System Testing");
			options.get(1).sendKeys("Unit Testing");
			options.get(2).sendKeys("Integration Testing");
			jsClick(driver, addQuestionButton);

			break;

			//			ShortAnswer
			case(2):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "What is the software you're testing?");
			jsClick(driver, addQuestionButton);

			break;

			//			Dropdown
			case(3):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "What is the Operating system you're Testing on?");
			clickElementMultipleTimes(driver, driver.findElement(By.xpath("(//a[normalize-space()='Add Option'])[4]")), 3);
			List<WebElement>DropDownOption=driver.findElements(By.xpath("//div[@class='question qsn_number_4']//div[@class='input-delete d-flex']//input"));
			DropDownOption.get(0).sendKeys("Windows");
			DropDownOption.get(1).sendKeys("Mac Os");
			DropDownOption.get(2).sendKeys("Linux");
			DropDownOption.get(3).sendKeys("Unix");
			jsClick(driver, addQuestionButton);

			break;

			//			Relative Dropdown
			case(4):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "In Which Browser you're Running the Test Scripts?");
			clickElementMultipleTimes(driver, driver.findElement(By.xpath("(//a[normalize-space()='Add Option'])[5]")), 3);
			List<WebElement>relativeOption=driver.findElements(By.xpath("//div[@class='question qsn_number_5']//div[@class='input-delete d-flex']//input"));
			relativeOption.get(0).sendKeys("Chrome");
			relativeOption.get(1).sendKeys("Edge");
			relativeOption.get(2).sendKeys("Firefox");
			relativeOption.get(3).sendKeys("Opera");
			jsClick(driver, addQuestionButton);

			break;

			//			FileUpload
			case(5):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "Upload you UseCases");
			jsClick(driver, addQuestionButton);

			break;

			//			Radio Button
			case(6):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "Which Type of Testing are you doing?");
			List<WebElement>radioOption=driver.findElements(By.xpath("//div[@class='question qsn_number_7']//div[@class='input-delete d-flex']//input"));
			radioOption.get(0).sendKeys("Manual Testing");
			radioOption.get(1).sendKeys("Automation Testing");
			jsClick(driver, addQuestionButton);

			break;

			//			Date
			case(7):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "When Did you start you testing?");
			jsClick(driver, addQuestionButton);

			break;

			//			Time
			case(8):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "When will Test Execution Begin?");
			jsClick(driver, addQuestionButton);

			break;

			//			TextBox
			case(9):
				jsClick(driver, questionsList.get(q));
			jsClick(driver, getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "Test Case Written By?");
			jsClick(driver, addQuestionButton);

			break;

			//			Relative Multiselect
			case(10):
				jsClick(driver, questionsList.get(q));
			jsClick(driver,getElementByDynamicXPath(q));
			sendKeys(questionsList.get(q), "Select your Team Members");
			clickElementMultipleTimes(driver, driver.findElement(By.xpath("(//a[normalize-space()='Add Option'])[11]")), 3);
			List<WebElement>relativeMultiOption=driver.findElements(By.xpath("//div[@class='question qsn_number_11']//div[@class='input-delete d-flex']//input"));
			relativeMultiOption.get(0).sendKeys("James Paul R");
			relativeMultiOption.get(1).sendKeys("Gopal Reddy");
			relativeMultiOption.get(2).sendKeys("Abjith Das");
			relativeMultiOption.get(3).sendKeys("Boya Pavan");

			break;
			}

			click(driver, questionSaveButton);
			click(driver, questionSaveContinueButton);

			String actualQuestionSet=nonMeasurableQuestionSet.get(0).getText();
			assertEquals(questionName,actualQuestionSet);

		}


	}



	public void createColumnView()
	{
		click(driver, workFlowDesign);
		click(driver, masterParameterTab);
		click(driver, nonMeasurableTab);
		click(driver, addNonMeasurableSetButton);
		String questionName= "Software Testing "+ fake.lastName1();
		sendKeys(questionSetNameField, questionName);


		click(driver, settingButton);
		click(driver, tableView);

		clickElementMultipleTimes(driver, columnPlusButton, 7);
		List <WebElement> columns=columnNames;
		List<WebElement> columnInputs=columnInputField;
		List<WebElement> columnName= enterYourColumn;

		for(int a=0;a<columns.size();a++)
		{

			switch(a)
			{

			//			label
			case 0:
				jsClick(driver, columnInputs.get(a));
				jsClick(driver,getElementByDynamicXPath(a));
				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "Advaita Testing");
				break;

				//				Multiple Choice
			case 1:
				//				jsClick(driver, columnInputs.get(a));

				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "What Level of Software Testing are you doing?");
				jsClick(driver, columnInputs.get(a));
				jsClick(driver,getElementByDynamicXPath(a));
				clickElementMultipleTimes(driver, driver.findElement(By.xpath("(//a[normalize-space()='Add Option'])[9]")), 2);
				List<WebElement> mulOptions=driver.findElements(By.xpath("//input[contains(@name,'ans_option_1_2_')]"));
				jsClick(driver, columnInputs.get(a));
				mulOptions.get(0).sendKeys("System Testing");
				mulOptions.get(1).sendKeys("Unit Testing");
				mulOptions.get(2).sendKeys("Integration Testing");
				break;

				//				Short Answer
			case 2:
				jsClick(driver, columnInputs.get(a));
				jsClick(driver,getElementByDynamicXPath(a));
				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "What is the software you're testing?");
				break;

				//				Dropdown
			case 3:
				jsClick(driver, columnInputs.get(a));
				jsClick(driver,getElementByDynamicXPath(a));
				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "What is the Operating system you're Testing on?");
				clickElementMultipleTimes(driver, driver.findElement(By.xpath("//div[@data-info='1_4']//a")), 3);
				List<WebElement>DropDownOption=driver.findElements(By.xpath("//input[contains(@name,'ans_option_1_4_')]"));
				jsClick(driver, columnInputs.get(a));
				DropDownOption.get(0).sendKeys("Windows");
				DropDownOption.get(1).sendKeys("Mac Os");
				DropDownOption.get(2).sendKeys("Linux");
				DropDownOption.get(3).sendKeys("Unix");
				break;

				//				Relative DropDown
			case 4:
				jsClick(driver, columnInputs.get(a));
				jsClick(driver, getElementByDynamicXPath(a));
				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "In Which Browser you're Running the Test Scripts?");
				clickElementMultipleTimes(driver, driver.findElement(By.xpath("//div[@data-info='1_5']//a")), 3);
				List<WebElement>relativeOption=driver.findElements(By.xpath("//input[contains(@name,'ans_option_1_5_')]"));
				jsClick(driver, columnInputs.get(a));
				relativeOption.get(0).sendKeys("Chrome");
				relativeOption.get(1).sendKeys("Edge");
				relativeOption.get(2).sendKeys("Firefox");
				relativeOption.get(3).sendKeys("Opera");
				break;

				//				File Upload
			case 5:
				jsClick(driver, columnInputs.get(a));
				jsClick(driver, getElementByDynamicXPath(a));
				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "Upload you UseCases");
				break;

				//				Radio Button
			case 6:

				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "Which Type of Testing are you doing?");
				jsClick(driver, columnInputs.get(a));
				click(driver, getElementByDynamicXPath(a));
				click(driver, getElementByDynamicXPath(a));
				//				clickElementMultipleTimes(driver, driver.findElement(By.xpath("//div[@data-info='1_5']//a")), 3);
				List<WebElement>radioOption=driver.findElements(By.xpath("//input[contains(@name,'ans_option_1_7_')]"));
				jsClick(driver, columnInputs.get(a));		
				radioOption.get(0).sendKeys("Manual Testing");
				jsClick(driver, driver.findElement(By.xpath("//div[@data-info='1_7']//a")));
				sendKeys(driver.findElement(By.xpath("//input[@name='ans_option_1_7_2']")), "Automation Testing");


				break;

				//				Date

			case 7:
				jsClick(driver, columnInputs.get(a));
				jsClick(driver, getElementByDynamicXPath(a));
				jsClick(driver, columns.get(a));
				sendKeys(columnName.get(a), "When Did you start you testing?");
				break;

				//				Time
			case(8):
				jsClick(driver, columnInputs.get(a));
			jsClick(driver, getElementByDynamicXPath(a));
			jsClick(driver, columns.get(a));
			sendKeys(columnName.get(a), "When will Test Execution Begin?");


			break;

			//			TextBox
			case(9):
				jsClick(driver, columnInputs.get(a));
			jsClick(driver, getElementByDynamicXPath(a));
			jsClick(driver, columns.get(a));
			sendKeys(columnName.get(a), "Test Case Written By?");

			break;

			//				Relative Multiselect
			case(10):
				jsClick(driver, columnInputs.get(a));
			jsClick(driver,getElementByDynamicXPath(a));
			jsClick(driver, columns.get(a));
			sendKeys(columnName.get(a), "Select your Team Members");
			clickElementMultipleTimes(driver, driver.findElement(By.xpath("//div[@data-info='1_11']//a")), 3);
			List<WebElement>relativeMultiOption=driver.findElements(By.xpath("//input[contains(@name,'ans_option_1_11_')]"));
			jsClick(driver, columnInputs.get(a));
			relativeMultiOption.get(0).sendKeys("James Paul R");
			relativeMultiOption.get(1).sendKeys("Gopal Reddy");
			relativeMultiOption.get(2).sendKeys("Abjith Das");
			relativeMultiOption.get(3).sendKeys("Boya Pavan");

			break;
			}

			

		}
//		saveButtonInEditPage.click();
//
//		jsClick(driver, backButton);
//
//		String actualQuestionSet=nonMeasurableQuestionSet.get(0).getText();
//		assertEquals(actualQuestionSet,questionName);

	}


	public WebElement getSectionQuestion(int s,int q) {
		String xpath = "//div[@data-info='question-"+s+"-"+q+"']//input[@name='question_"+s+"_"+q+"']";

		return driver.findElement(By.xpath(xpath));
	}
	public WebElement getQuestionTypes(int s,int q,int t) {
		String xpath = "//input[@name='question_type_"+s+"_"+q+"']/following-sibling::div["+t+"]";

		return driver.findElement(By.xpath(xpath));
	}

	public WebElement sectionsSettings(int a) {
		String xpath = "(//img[@alt='settingicon'])["+a+"]";

		return driver.findElement(By.xpath(xpath));
	}


	public WebElement sectionIsConditional(int a) {
		String xpath = "is_conditional_"+a;

		return driver.findElement(By.name(xpath));
	}

	public WebElement addSectionQuestion(int s) {
		String xpath = "//div[@data-info='question-"+s+"-1']/following-sibling::div//a[normalize-space()='Add Question']";

		return driver.findElement(By.name(xpath));
	}



	public void isConditional() throws Throwable
	{


		click(driver, workFlowDesign);
		click(driver, masterParameterTab);
		click(driver, nonMeasurableTab);
		click(driver, addNonMeasurableSetButton);
		String QuestionSetName=fake.lastName1();
		questionSetNameField.clear();
		questionSetNameField.sendKeys(QuestionSetName);

		question1.clear();
		question1.sendKeys("Select Any Options from the Dropdown");

		click(driver, sec1Ques1DropDowntype);
		clickElementMultipleTimes(driver, addOptionQuestion1, 3);
		List<WebElement>DropDownOption=driver.findElements(By.xpath("//div[@data-info='question-1-1']//div[@class='input-delete d-flex']//input"));
		DropDownOption.get(0).sendKeys("Windows");
		DropDownOption.get(1).sendKeys("Mac Os");
		DropDownOption.get(2).sendKeys("Linux");
		DropDownOption.get(3).sendKeys("Unix");

		//		Section 2
		jsClick(driver, addSectionButton);
		sendKeys(section2Question, "Have you ever used Windows systems?");
		getQuestionTypes(2,1,7).click();
		List<WebElement> radioOptions=driver.findElements(By.xpath("//div[@data-info='question-2-1']//input[contains(@name,'ans_option_')]"));
		radioOptions.get(0).sendKeys("Yes");
		radioOptions.get(1).sendKeys("No");
		jsClick(driver, sectionsSettings(2));
		jsClick(driver, sectionIsConditional(2));

		saveButtonInEditPage.click();
		Thread.sleep(2000);

		assertTrue(afterNonMeasurableUpdatedContinueButton.isDisplayed());

		afterNonMeasurableUpdatedContinueButton.click();
		Thread.sleep(2000);

		for(int i=1;i<=4;i++) {

			WebElement addCon=driver.findElement(By.name("next_condition_1_1_1"));
			String optionsName = "ans_option_1_1_"+i;
			WebElement options = driver.findElement(By.name(optionsName));

			if(i==1) {

				click(driver, options);
				Select addCondition= new Select(addCon);
				addCondition.selectByVisibleText("Section 2");

			}

		}
		saveButtonInEditPage.click();
		Thread.sleep(2000);


		afterNonMeasurableUpdatedContinueButton.click();
		Thread.sleep(2000);
		jsClick(driver, backButton);

		String ActualCreateName=nonMeasurableQuestionSet.get(0).getText();
		System.out.println(ActualCreateName);
		assertEquals(QuestionSetName,ActualCreateName);
		
		stagesTab.click();
		editButtons.get(0).click();
		
		jsClick(driver, sectionButton);
		jsClick(driver, nonMeasurableRadioButton);
		
		
		Select nonMeasurSelectQuestionType=new Select(selectQuestiontypeDropdown);
		
		nonMeasurSelectQuestionType.selectByVisibleText(ActualCreateName);
		
		Select selectionAnyOptions=new Select(isConditonalSection1Question1);
		
		selectionAnyOptions.selectByVisibleText("Windows");
		
		List<WebElement> questions=driver.findElements(By.xpath("//div[contains(@class,'row section_c_tab_question_type')]//div[contains(@class,'col-md-3')]"));
		
		Assert.assertTrue(questions.size()>1);
		

	}


	










	//----------------------------------------------------------------------------------------------------------
	public void nonMeasurableSetCreatePage(int count) throws Throwable {

		for (int b = 1; b <= count; b++) {

			String beforeCreatedRecords = driver.findElement(By.xpath("(//p[@class='show_entries m-0 font_13'])[1]"))
					.getText();

			Thread.sleep(2000);
			System.out.println("beforeCreatedRecord : " + beforeCreatedRecords);

			int beforeCreateRecord = extractNumber(beforeCreatedRecords);
			int beforeNumber = extractNumber(beforeCreatedRecords) + 1;
			//		System.out.println(String.format("beforeNumber (%d + 1) : %s", beforeCreateRecord, beforeNumber));
			System.out.println("beforeNumber" + "(" + beforeCreateRecord + "+1" + ") :" + beforeNumber);

			click(driver, addNonMeasurableSetButton);

			assertTrue(questionSetNameField.isDisplayed(), "questionSetNameField is not displayed.");
			questionSetNameField.sendKeys(fake.lastName1() + " TestAudit");

			click(driver, settingButton);

			// WebDriver driver, WebElement element, int timeout, int pollingInterval
			wait.until(ExpectedConditions.visibilityOf(tableView));
			assertTrue(tableView.isDisplayed(), "tabularView is not displayed.");
			click(driver, tableView);

			for (int j = 1; j <= 7; j++) {

				String xpathForColumn1 = "//label[normalize-space()='COLUMN NAME " + j + "']";

				String xpathForColumn = "(//input[@placeholder='Enter your column Name'])[" + j + "]";

				String xpathForTextBox = "question_1_" + j;

				WebElement ClickColumn = driver.findElement(By.xpath(xpathForColumn1));
				WebElement sendDataColumn = driver.findElement(By.xpath(xpathForColumn));

				WebElement textBoxUnderColumn = driver.findElement(By.name(xpathForTextBox));

				if (j == 1) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Customer Name");
					textBoxUnderColumn.sendKeys("Enter Customer Name?");

					textBoxUnderColumn.click();
					textBox.click();

				}

				if (j == 2) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Person Who Pick the Call");
					textBoxUnderColumn.sendKeys("Enter the Employee Name?");

					//				Thread.sleep(6000);
					wait.until(ExpectedConditions.elementToBeClickable(textBoxUnderColumn));
					textBoxUnderColumn.click();
					js.executeScript("arguments[0].click();", textBox);
					//				Thread.sleep(6000);
				}

				// Date Picker
				if (j == 3) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Call Date");
					click(driver, textBoxUnderColumn);
					textBoxUnderColumn.sendKeys("Enter the Date?");
					js.executeScript("arguments[0].click();", dateType);
					dateField.click();
					actions.moveToElement(driverIninteractable).perform();
					dateField.click();
					dateField.sendKeys("06/04/2024");
					dateField.sendKeys(Keys.ENTER);

				}

				// Text Box
				if (j == 4) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Feedback");
					textBoxUnderColumn.sendKeys("Enter Your Feedback?");
					js.executeScript("arguments[0].click();", textBox);

					click(driver, settingButton);
					click(driver, plusColumnButton);
				}

				// Drop Down
				if (j == 5) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Select Customer Feedback");
					textBoxUnderColumn.sendKeys("Select Feedback Satisfied / Not Satisfied");
					textBoxUnderColumn.click();

					js.executeScript("arguments[0].click();", dropDownOption);

					for (int i = 1; i <= 2; i++) {

						String xpathOfDropDownOption = "ans_option_1_1_" + i;
						WebElement dropDownOptionField = driver.findElement(By.name(xpathOfDropDownOption));

						if (i == 1) {

							js.executeScript("arguments[0].click();", dropDownOptionField);
							dropDownOptionField.sendKeys("Satisfied");
							actions.moveToElement(driverIninteractable).perform();
							// Thread.sleep(2000);
							js.executeScript("arguments[0].click();", addDropDownOptionField);
							// click(driver, plusColumnButton);
						}

						if (i == 2) {

							js.executeScript("arguments[0].click();", dropDownOptionField);
							dropDownOptionField.sendKeys("Not Satisfied");

							settingButton.click();
							click(driver, plusColumnButton);
						}

					}

				}

				// Radio Button
				if (j == 6) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Is customer picked your call ?");
					textBoxUnderColumn.sendKeys("Select Radio button in yes or no.");
					textBoxUnderColumn.click();
					js.executeScript("arguments[0].click();", radioButtonOption);

					for (int i = 1; i <= 2; i++) {

						String xpathForRadioButtonOptions = "ans_option_1_1_" + i;

						if (i == 1) {
							WebElement option1 = driver.findElement(By.name(xpathForRadioButtonOptions));
							option1.sendKeys("Yes");
						}

						if (i == 2) {
							WebElement option2 = driver.findElement(By.name(xpathForRadioButtonOptions));
							option2.sendKeys("No");

							settingButton.click();
							click(driver, plusColumnButton);
						}

					}

				}

				// Time Picker
				if (j == 7) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("On which time call picked ?");
					textBoxUnderColumn.sendKeys("Select the time of the call.");
					textBoxUnderColumn.click();
					js.executeScript("arguments[0].click();", timeOption);

					js.executeScript("arguments[0].scrollIntoView(true);", timePicker);
					timePicker.click();
					timePicker.click();
					timePicker.sendKeys("10:10");
					timePicker.sendKeys(Keys.ENTER);

				}

			}

			click(driver, addSectionButton);

			click(driver, settingButton2);

			click(driver, tabularView2);

			for (int a = 1; a <= 4; a++) {

				String xpath = "(//label[text()='COLUMN NAME " + a + "'])[2]";
				String columnNameXpath = "//input[contains(@placeholder, 'Enter your column Name')]/..//input[@name='col_name_2_"
						+ a + "']";
				String xpathName = "//input[@name='question_2_" + a + "']";

				System.out.println("name : " + xpathName);

				WebElement xpathForColumn2 = driver.findElement(By.xpath(xpath));
				WebElement xpathForColumn2Name = driver.findElement(By.xpath(columnNameXpath));
				WebElement xpathForField2 = driver.findElement(By.xpath(xpathName));

				if (a == 1) {

					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter Customer Name?");
					xpathForField2.sendKeys("Customer Name");

				}

				if (a == 2) {

					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter Customer Phone No.?");
					xpathForField2.sendKeys("Customer Phone No.");

				}

				if (a == 3) {

					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter the time ?");
					xpathForField2.sendKeys("Enter Time");

				}

				if (a == 4) {

					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter the Customer Address ?");
					xpathForField2.sendKeys("Enter Customer Address");

				}

			}

			click(driver, saveButtonOfCreateQuestionSet);
			Thread.sleep(2000);
			assertTrue(successPopUpWithContinueButtonAfterCreate.isDisplayed(),
					"successPopUpWithContinueButtonAfterCreate is not displayed.");
			click(driver, successPopUpWithContinueButtonAfterCreate);

			click(driver, leftArrowToGoBackTablePage);

			Thread.sleep(2000);

			String afterCreateRecords = driver.findElement(By.xpath("(//p[@class='show_entries m-0 font_13'])[1]"))
					.getText();

			assertNotNull(afterCreateRecords, "afterCreateRecords is null.");
			System.out.println("afterCreateRecords : " + afterCreateRecords);

			int afterNumber = extractNumber(afterCreateRecords);
			System.out.println("afterNumber : " + afterNumber);

			assertEquals(afterNumber, beforeNumber);

		}

	}


	//#############################################################################################################################

	public void nonMeasurableSetTablePage() throws Throwable {

		String firstRecord = fetchCreatedRecord.getText();

		System.out.println("firstRecord : " + firstRecord);

		assertTrue(searchBox.isDisplayed(), "searchBox is not displayed.");
		assertNotNull(firstRecord, "firstRecord is null.");
		searchBox.sendKeys(firstRecord);

		click(driver, searchButton);

		WebElement searchRecord = driver.findElement(By.xpath("//td[text()='" + firstRecord + "']"));
		assertTrue(searchRecord.isDisplayed(), "searchRecord is not displayed.");
		//		
		//		assertTrue(createdDatePicker.isDisplayed(), "createdDatePicker is not displayed.");
		//		createdDatePicker.click();
		//		createdDatePicker.sendKeys("25-04-2024");
		//		createdDatePicker.sendKeys(Keys.ENTER);
		//		
		//		click(driver, searchButton);

		click(driver, clearFilterButton);

		Pagination.paginate(driver, rightArrow, leftArrow);

		driver.navigate().refresh();
		//		---------------------------------------------------------------------------

	}

	public void nonMeasurableSetEditPage() {

		click(driver, editNonMeasurableSetButton);

		assertTrue(remarkFieldInEditPage.isDisplayed(), "remarkFieldInEditPage is not displayed.");
		remarkFieldInEditPage.clear();
		remarkFieldInEditPage.sendKeys("Test Edit NonMeasurableSet");
		click(driver, saveButtonInEditPage);

		wait.until(ExpectedConditions.visibilityOf(successfullyNonMeasurableUpdatedMassage));
		assertTrue(successfullyNonMeasurableUpdatedMassage.isDisplayed(),
				"successfullyMeasurableUpdatedMassage is not displayed.");

		click(driver, afterNonMeasurableUpdatedContinueButton);

		click(driver, leftArrowToGoBackTablePage);

	}

	public static int extractNumber(String input) {
		StringBuilder numberAsString = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				numberAsString.append(c);
			}
		}

		return Integer.parseInt(numberAsString.toString());
	}


	//	##########################################################################################################




}
