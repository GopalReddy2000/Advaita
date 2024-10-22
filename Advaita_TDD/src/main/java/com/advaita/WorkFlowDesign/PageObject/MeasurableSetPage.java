package com.advaita.WorkFlowDesign.PageObject;

import Advaita_TDD.Advaita_TDD.FakeData;
import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.Pagination;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MeasurableSetPage extends TestBase {

	static FakeData fake = new FakeData();

	static int createCount = 1;

	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']")
	public static WebElement workFlowDesign;

	@FindBy(id = "pills-MasterParameter-tab")
	public static WebElement masterParameterTab;

	@FindBy(id = "pills-MeasurableSet-tab")
	public static WebElement measurableTab;

	@FindBy(linkText = "+ Add Measurable Set")
	public static WebElement addMeasurableSetButton;

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
	public static List<WebElement> measurableQuestionSet;

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
	public static List<WebElement>  optionTextbox;

	@FindBy(linkText = "Add Option")
	public static WebElement addOption;

	@FindBy(xpath  = "//input[contains(@name,'ans_option')]/following-sibling::img[contains(@src,'delete')]")
	public static WebElement addOptionDelete;



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
	public static List<WebElement> measurableEditbuttons;

	@FindBy(xpath = "(//a[@data-value='Relative Dropdown'])[1]")
	public static WebElement questionTypeRelativeDropdown;

	@FindBy(xpath = "(//a[@data-value='File Upload'])[1]")
	public static WebElement questionTypeFileUpload;

	@FindBy(xpath = "//input[@id='Browse']")
	public static WebElement fileUploadBrowse;

	@FindBy(xpath = "//img[@name='ans_option_1_1_1']")
	public static WebElement fileUploadSetting;

	@FindBy(xpath = "//select[@id='allowed_format']")
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

	@FindBy(xpath = "//div//span[@id='change_msg']")
	public static WebElement successfullymeasurableUpdatedMassage;

	@FindBy(xpath = "//span[@id='change_msg']/following-sibling::button")
	public static WebElement aftermeasurableUpdatedContinueButton;

	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public static WebElement editMeasurableSetButton;


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

	@FindBy(xpath = "//div[@class='ipad-repons-margin']//a[text()='Add']")
	public WebElement addNonSectionButton;

	@FindBy(xpath = "//input[@name='section_name']")
	public WebElement sectionInputField;

	@FindBy(xpath = "//a[contains(@class,'add_section_c')]")
	public WebElement sectionAddButton;


	@FindBy(xpath = "(//button[@data-type='NonMesaurable'])[2]")
	public WebElement sectionButton;

    /*@FindBy(xpath = "//label[normalize-space()='Non Measurable Set']//span")
    public WebElement measurableRadioButton;*/

	@FindBy(xpath = "//div[@class='custom-select']//select")
	public WebElement isConditonalSection1Question1;

	@FindBy(xpath = "//td//img[@alt='table-edit' and not(@title)]")
	public List<WebElement> editButtons;

	@FindBy(xpath = "//label[text()='Add Section']/following-sibling::a")
	public WebElement addSection;

	@FindBy(xpath = "//input[@name='section_name']")
	public WebElement sectionName;

	@FindBy(xpath = "//div[@id='addseconddataPopup']//a[text()='Add ']")
	public WebElement add;

	@FindBy(xpath = "//label[normalize-space()='Non Measurable Set']//span")
	public WebElement MeasurableSetRadioBtn;






	public MeasurableSetPage() {
		PageFactory.initElements(driver, this);
	}


	public static String generateQuestionSetName(String QuestionSetName) {

		return QuestionSetName+" "+ fake.lastName2();
	}



	final String sectionNameString="Section Name "+fake.lastName2();

	final int labelInt=1;
	final int multipleChoiceInt=2;
	final int shortAnswerInt=3;
	final int dropDownInt=4;
	final int relativeDropdownInt=5;
	final int fileUploadInt=6;
	final int radioButtonInt=7;
	final int dateInt=8;
	final int timeInt=9;
	final int textBoxInt=10;
	final int relativeMultiselectInt=11;

	private static String getRandomString(String[] array) {
		// Generate a random index within the array length
		Random random = new Random();
		int randomIndex = random.nextInt(array.length);
		return array[randomIndex];
	}
	private static WebElement getElementByDynamicXPath(int q) {
		String xpath = "(//input[contains(@name,'question_type_1_" + (q + 1) + "')]/following-sibling::div//a)[" + (q + 1) + "]";
		return driver.findElement(By.xpath(xpath));
	}
	private WebElement SetSectionQuestionName(int s,int q) {
		String xpath = "//div[@data-info='question-"+s+"-"+q+"']//input[@name='question_"+s+"_"+q+"']";

		return driver.findElement(By.xpath(xpath));
	}
	private WebElement setQuestionTypes(int s,int q,int t) {
		String xpath = "//input[@name='question_type_"+s+"_"+q+"']/following-sibling::div["+t+"]";

		return driver.findElement(By.xpath(xpath));
	}
	private WebElement optionsFields(int s, int q, int option) {
		String xpath = " //input[@name='ans_option_"+s+"_"+q+"_"+option+"']";

		return driver.findElement(By.xpath(xpath));
	}
	private WebElement addOptions(int s,int q) {
		String xpath = " //div[@data-info='question-"+s+"-"+q+"']//a";

		return driver.findElement(By.xpath(xpath));
	}
	private WebElement required(int s,int q) {
		String xpath = " //input[@name='question_required_"+s+"_"+q+"']";
		return driver.findElement(By.xpath(xpath));
	}
	private WebElement escalationToggle(int s,int q) {
		String xpath = " //input[@name='question_escalated_"+s+"_"+q+"']";
		return driver.findElement(By.xpath(xpath));
	}
	private WebElement deleteOptions(int s,int q) {
		String xpath = " //input[contains(@name,'ans_option_"+s+"_"+q+"')]//following-sibling::img";
		return driver.findElement(By.xpath(xpath));
	}
	private WebElement uploadOptions(int s,int q) {
		String xpath = " //div[@data-info='question-"+s+"-"+q+"']//input[@id='Browse']";
		return driver.findElement(By.xpath(xpath));
	}


	private WebElement sectionsSettings(int a) {
		String xpath = "(//img[@alt='settingicon'])["+a+"]";

		return driver.findElement(By.xpath(xpath));
	}
	private WebElement sectionIsConditional(int a) {
		String xpath = "is_conditional_"+a;

		return driver.findElement(By.name(xpath));
	}
	private WebElement addSectionQuestion(int s) {
		String xpath = "//div[@data-info='question-"+s+"-1']/following-sibling::div//a[normalize-space()='Add Question']";

		return driver.findElement(By.xpath(xpath));
	}
	private WebElement sectionCTabs(String name) {
		String xpath = "(//ul[@id='pills-tab'])[2]//button[text()='"+name+"']";

		return driver.findElement(By.xpath(xpath));
	}

	private WebElement measurableDropdowns(String name) {
		String xpath = "//label[text()='"+name+"']/following-sibling::select";

		return driver.findElement(By.xpath(xpath));
	}

	private WebElement measurableRadioButton(String name) {
		String xpath = "//div[@id='pills-"+name+"']//label[normalize-space()='Non Measurable Set']//span";

		return driver.findElement(By.xpath(xpath));
	}

	private WebElement measurableDropdownQuestionDropdown(String name) {
		String xpath = "//div[@id='pills-"+name+"']//select[contains(@name,'NonMesaurable')]";

		return driver.findElement(By.xpath(xpath));
	}

	private WebElement measurableDropdownQuestions(String sectionName,String QuestionName) {
		String xpath = "//div[@id='param_type_"+sectionName+"']/following-sibling::div//label[@text()='"+QuestionName+"]/following-sibling::select";

		return driver.findElement(By.xpath(xpath));
	}

	private WebElement textBoxAnswerField(int section,int Question) {
		String xpath = "//input[@name='ans_option_"+section+"_"+Question+"_1']";
		return driver.findElement(By.xpath(xpath));
	}
	private WebElement shortAnswerField(int section,int Question) {
		String xpath = "//textarea[@name='ans_option_"+section+"_"+Question+"_1']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement minLengthTextBox(int section,int Question) {
		String xpath = "//input[@name='textbox_settings_min_length_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement maxLengthTextBox(int section,int Question) {
		String xpath = "//input[@name='textbox_settings_max_length_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement textBoxValueType(int section,int Question) {
		String xpath = "//select[@name='textbox_settings_value_type_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement textBoxAllowSpecialChar(int section,int Question) {
		String xpath = "//input[@name='textbox_settings_allow_sp_char_"+section+"_"+Question+"']//following-sibling::span";
		return driver.findElement(By.xpath(xpath));
	}


	private WebElement minLengthShortAns(int section,int Question) {
		String xpath = "//input[@name='shortans_settings_min_length_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement maxLengthShortAns(int section,int Question) {
		String xpath = "//input[@name='shortans_settings_max_length_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement shortAnsValueType(int section,int Question) {
		String xpath = "//select[@name='shortans_settings_value_type_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement shortAnsAllowSpecialChar(int section,int Question) {
		String xpath = "//input[@name='shortans_settings_allow_sp_char_"+section+"_"+Question+"']//following-sibling::span";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement fileUploadSettings(int section,int Question) {
		String xpath = "//img[@name='ans_option_"+section+"_"+Question+"_1']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement allowedFormats(int section,int Question) {
		String xpath = "//select[@name='file_upload_format_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement addAdditionalFormats(int section,int Question) {
		String xpath = "//img[contains(@class,'format_settings_"+section+"_"+Question+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement additionalFormatInput(int section,int Question) {
		String xpath = "//input[contains(@class,'additionalformat_"+section+"_"+Question+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement addFormat(int section,int Question) {
		String xpath = "//button[@id='additionalFormatButton_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement uploadMultipleFiles(int section,int Question) {
		String xpath = "//input[contains(@name,'multifile_"+section+"_"+Question+"')]/following-sibling::span";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement allowDelete(int section,int Question) {
		String xpath = "//input[contains(@name,'allowdelete_"+section+"_"+Question+"')]/following-sibling::span";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement maxSizeInput(int section,int Question) {
		String xpath = "//input[contains(@name,'maxsize_"+section+"_"+Question+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement maxSizeDropdown(int section,int Question) {
		String xpath = "//select[contains(@name,'sizeunit_"+section+"_"+Question+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement dateOrTimeInput(int section,int Question) {
		String xpath = "//input[@name='ans_option_"+section+"_"+Question+"_1']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement dataMaxDateDropdown(int section,int Question) {
		String xpath = "//select[@name='date_settings_maxdate_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement dataMinDateDropdown(int section,int Question) {
		String xpath = "//select[@name='date_settings_mindate_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement defaultDate(int section,int Question) {
		String xpath = "//input[contains(@name,'defaultdate_"+1+"_"+1+"')]/following-sibling::span";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement maxDateInput(int section,int Question) {
		String xpath = "//input[contains(@name,'maxdate_input_"+section+"_"+Question+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement minDateInput(int section,int Question) {
		String xpath = "//input[contains(@name,'mindate_input_"+section+"_"+Question+"')]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement maxTime(int section,int Question) {
		String xpath = "//select[@name='time_settings_maxtime_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement minTime(int section,int Question) {
		String xpath = "//select[@name='time_settings_mintime_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement hoursFormat(int section,int Question) {
		String xpath = "//input[contains(@name,'time_format_"+section+"_"+Question+"')]/following-sibling::span";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement fetchFromDataset(int section,int Question) {
		String xpath = "//input[@name='fetch_database_"+section+"_"+Question+"']/following-sibling::span";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement selectDataset(int section,int Question) {
		String xpath = "(//div[@name='dropdownContainer_"+section+"_"+Question+"']//select)[1]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement selectColumnNames(int section,int Question) {
		String xpath = "(//div[@name='dropdownContainer_"+section+"_"+Question+"']//select)[2]";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement measurableParameterDrp(int section,int Question) {
		String xpath = "//select[@name='measurable_parameter_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement minLimit(int section,int Question) {
		String xpath = "//input[@name='min_limit_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement maxLimit(int section,int Question) {
		String xpath = "//input[@name='max_limit_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}


	private WebElement weightage(int section,int Question) {
		String xpath = "//input[@name='weightage_"+section+"_"+Question+"']";
		return driver.findElement(By.xpath(xpath));
	}




	public MeasurableSetPage commonNavigation(String questionSetName)
	{
		click(driver, workFlowDesign);
		click(driver, masterParameterTab);
		click(driver, measurableTab);
		click(driver, addMeasurableSetButton);
		questionSetNameField.clear();
		questionSetNameField.sendKeys(generateQuestionSetName(questionSetName));

		question1.clear();
		question1.sendKeys(generateQuestionSetName(questionSetName));
		return this;
	}
	public void multipleChoice() throws InterruptedException
	{
		commonNavigation("Multiple Choice");

		//		questionSetNameField.clear();
		//		questionSetNameField.sendKeys(generateQuestionSetName());

		click(driver, settingButton);
		sectionField.clear();
		sectionField.sendKeys(sectionNameString);


		assertTrue(isConditional.isEnabled());
		assertTrue(isRelativeParent.isEnabled());

		assertTrue(questionSetDropdown.isDisplayed());

		Select select=new Select (questionSetDropdown);

		assertFalse(select.isMultiple());
		assertNotNull(select);
		System.out.println("Default Selected QUESTIONS SET: "+select.getFirstSelectedOption().getText());

		List<WebElement> options=select.getOptions();

		assertTrue(select.getOptions().size()>2);


		for(int o=1;o<options.size();o++)
		{
			System.out.println("LOAD QUESTIONS FROM PREVIOUS RULE option "+o+":" +options.get(o).getText());
		}

		question1.clear();
		System.out.println("Selected Question Type: "+setQuestionTypes(1,1,multipleChoiceInt).getText());
		question1.sendKeys(setQuestionTypes(1,1,multipleChoiceInt).getText());

		click(driver, setQuestionTypes(1,1,multipleChoiceInt));

		assertTrue(choiceDelete.get(0).isEnabled());
		assertTrue(addQuestionButton.isEnabled());
		assertTrue(addSectionButton.isEnabled());

		clickElementMultipleTimes(driver, addOption, 3);
		clickElementMultipleTimes(driver, addOptionDelete, 3);
		clickElementMultipleTimes(driver, addOption, 3);

		sendKeys(driver.findElement(By.xpath("(//div[@class='parttwo']//div[@class='input-delete d-flex']//input)[1]")),"Options 1" );
		sendKeys(driver.findElement(By.xpath("(//div[@class='parttwo']//div[@class='input-delete d-flex']//input)[2]")),"Options 2" );
		sendKeys(driver.findElement(By.xpath("(//div[@class='parttwo']//div[@class='input-delete d-flex']//input)[3]")),"Options 3" );
		sendKeys(driver.findElement(By.xpath("(//div[@class='parttwo']//div[@class='input-delete d-flex']//input)[4]")),"Options 4" );



		//		for(int a=0;a<optionTextbox.size();a++)
		//		{
		//			optionTextbox.get(a).sendKeys("Options "+(a+1));
		//		}

		Thread.sleep(2000);

		click(driver, questionSaveButton);
		Thread.sleep(2000);
		click(driver, questionSaveContinueButton);



	}
	public void shortAnswer()
	{
		commonNavigation("Short Answer");
		click(driver, questionTypeShortAnswer);


		//		Sending Question Names
		question1.clear();
		String questionName=setQuestionTypes(1,1,shortAnswerInt).getText();
		System.out.println("Selected Question Type: "+questionName);
		question1.sendKeys(questionName);
		assertTrue(shortAnswerTextArea.isEnabled());

		click(driver, shortAnswerTextArea);

		//		Short Answer Setting panel Validation
		assertEquals(shortAnswerMinLen.getAttribute("value"), "1");
		assertEquals(shortAnswerMaxLen.getAttribute("value"), "250");

		//		sendKeys(shortAnswerMinLen, "-98"); sendKeys(shortAnswerMaxLen, "-98");

		Select valType= new Select(shortAnswerValTypeDropdown);
		assertFalse(valType.isMultiple());
		assertNotNull(valType);
		System.out.println("Default Selected QUESTIONS SET: "+valType.getFirstSelectedOption().getText());



		List<String>actualOptions=new ArrayList<>();

		for(WebElement options:valType.getOptions())
		{
			String opt= options.getText();
			//			System.out.println(opt);
			actualOptions.add(opt);
		}

		//		Question


		List<String> expectedOptions=Arrays.asList("All","Only Text","Only Number");


		assertEquals(actualOptions, expectedOptions,"It is Not Equal");

		assertTrue(shortAnswerAllowSpChar.isEnabled(),"Short Answer Allow Special Character is not Enabled");

		System.out.println(expectedOptions);
		System.out.println(actualOptions);

		saveRecord();

	}
	public void defaultAndIsFatalValidation()
	{
		assertTrue(dropdownSetAsDefault.isEnabled());
		assertTrue(dropdownIsFatal.isEnabled());

		for(int a=1;a<3;a++) {

			dropdownSetAsDefault.click();
			System.out.println(driver.findElement(By.name("set_as_default_val_1_1_1")).getAttribute("value"));

			dropdownIsFatal.click();
			System.out.println(driver.findElement(By.name("is_fatal_val_1_1_1")).getAttribute("value"));

		}
	}
	public void questionTypeDropDown()
	{
		commonNavigation("DropDown");

		click(driver, questionTypeDropdown);

		assertTrue(addOption.isEnabled());
		assertTrue(choiceDelete.get(0).isEnabled());
		dropdownTextArea.click();

		//		Asserting Set as Default and Is Fatal toggle button is Enabled or not

		defaultAndIsFatalValidation();


		for(int q=1;q<=3;q++)
		{
			addOption.click();
		}


		for(int t=0;t<optionTextbox.size();t++)
		{
			optionTextbox.get(t).sendKeys("DropDown "+(t+1));
		}

		//		Saving the record
		saveRecord();

	}
	public void saveRecord1()
	{
		//		Saving the record
		click(driver, saveButtonOfCreateQuestionSet);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		System.out.println(successfullymeasurableUpdatedMassage.getText());
		assertTrue(successfullymeasurableUpdatedMassage.getText().contains( "Non Measurable Set has been created successfully")||successfullymeasurableUpdatedMassage.getText().contains( "Non Measurable Set has been updated successfully") );
		click(driver, questionSaveContinueButton);
	}
	public void questionTypeRelativeDropdown()
	{
		commonNavigation("Relative Dropdown");
		click(driver,questionTypeRelativeDropdown);

		assertTrue(addOption.isEnabled());
		assertTrue(choiceDelete.get(0).isEnabled());
		dropdownTextArea.click();

		//		Asserting Set as Default and Is Fatal toggle button is Enabled or not
		defaultAndIsFatalValidation();

		//		Asserting Adding and Deleting BackAndForth

		/*
		 * for(int a=1;a<3;a++) { for(int q=1;q<=3;q++) { addOption.click(); }
		 * List<WebElement> deleteButton=choiceDelete;
		 *
		 * for(WebElement delete:deleteButton) { delete.click(); } }
		 */
		for(int q=1;q<=3;q++)
		{
			addOption.click();
		}
		for(int t=0;t<optionTextbox.size();t++)
		{
			optionTextbox.get(t).sendKeys("Relative Dropdown "+(t+1));
		}
		//		Saving the record
		saveRecord1();


	}
	public void fileUpload1()
	{
		click(driver, workFlowDesign);
		click(driver, masterParameterTab);
		click(driver, measurableTab);
		click(driver, measurableEditbuttons.get(0));
		click(driver, question1);

		//		commonNavigation("Relative Dropdown");

		click(driver, questionTypeFileUpload);
		assertTrue(fileUploadBrowse.isEnabled());
		click(driver, fileUploadSetting);
		jsClick(allowedFormatDropdown);


		String[] fileFormats = {
				".yml",".json",
				".TXT", ".CSV",
				".DOC",  ".PDF",
				".XLS", ".XLSX", ".ODS",".DOCX",
				".PPT", ".PPTX", ".ODP",
				".JPG", ".JPEG", ".PNG", ".GIF", ".BMP",
				".MP3", ".WAV", ".FLAC",
				"MP4", "AVI", ".MOV", ".MKV",
				".ZIP", ".RAR", ".TAR", ".GZIP", ".BZIP2",
				".JAVA", ".PY", ".CPP", ".HTML", ".XML",
				".SQL", ".SQLite"
		};

		String fileformat= getRandomString(fileFormats);

		click(driver, fileFormatAddAdditionalFormat);
		sendKeys(fileFormatAddAdditionalFormatInputBox, fileformat);
		System.out.println("Adding this file format: "+fileformat);
		click(driver, fileFormatAddFormatButton);

		try
		{ Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
			if(fileAlreadyExistsContinueButton.isDisplayed()) {
				System.out.println(fileformat+" Already Exist");
				fileAlreadyExistsContinueButton.click();
			}

		}catch (NoSuchElementException | NullPointerException e) {

		}

		saveRecord1();
		click(driver, fileUploadSetting);
		Select allowedFormat=new Select(allowedFormatDropdown);
		List<String> listOfFileFormats = new ArrayList<String>();
		for(WebElement allowFormat:allowedFormat.getOptions())
		{
			//			System.out.println(allowFormat.getText());
			listOfFileFormats.add(allowFormat.getText());
		}
		assertTrue(listOfFileFormats.contains(fileformat));

	}

	@FindBy(css="table.w-100 tbody")
	WebElement formsTableBody;

	@FindBy(xpath="//button[text()='Delete']")
	WebElement tableDelete;
	@FindBy(xpath="(//button[text()='Continue'])[1]")
	WebElement continueButton;

	public MeasurableSetPage deleteRecordByName( String nameToDelete)
	{
		workFlowDesign.click();
		click(driver, masterParameterTab);
		click(driver, measurableTab);

		// Find all rows within the table
		List<WebElement> rows = formsTableBody.findElements(By.xpath("tr"));

		for (WebElement row:rows)
		{
			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));
			if(nameToDelete.equals(usernameColumn.getText()))
			{
				System.out.println( usernameColumn.getText());
				click(driver,row.findElement(By.xpath("//img[@alt='delete-icon ']")));
				tableDelete.click();
				unWait(2);
				continueButton.click();
				break;
			}else {

			}
		}
		return this;
	}

	@FindBy(css="img.arrow-left")
	static
	WebElement measurableBackButton;
	public void isConditional() throws Throwable
	{
		click(driver, workFlowDesign);
		//		click(driver, masterParameterTab);
		//		click(driver, measurableTab);
		//		click(driver, addMeasurableSetButton);
		//		String QuestionSetName=fake.lastName2();
		//		questionSetNameField.clear();
		//		questionSetNameField.sendKeys(QuestionSetName);
		//
		//		question1.clear();
		//		question1.sendKeys("Select Any Options from the Dropdown");
		//
		//		click(driver, sec1Ques1DropDowntype);
		//		clickElementMultipleTimes(driver, addOptionQuestion1, 3);
		//		List<WebElement>DropDownOption=driver.findElements(By.xpath("//div[@data-info='question-1-1']//div[@class='input-delete d-flex']//input"));
		//		DropDownOption.get(0).sendKeys("Windows");
		//		DropDownOption.get(1).sendKeys("Mac Os");
		//		DropDownOption.get(2).sendKeys("Linux");
		//		DropDownOption.get(3).sendKeys("Unix");
		//
		//		//		Section 2
		//		jsClick(driver, addSectionButton);
		//		sendKeys(section2Question, "Have you ever used Windows systems?");
		//		setQuestionTypes(2,1,7).click();
		//		List<WebElement> radioOptions=driver.findElements(By.xpath("//div[@data-info='question-2-1']//input[contains(@name,'ans_option_')]"));
		//		radioOptions.get(0).sendKeys("Yes");
		//		radioOptions.get(1).sendKeys("No");
		//		jsClick(driver, sectionsSettings(2));
		//		jsClick(driver, sectionIsConditional(2));
		//
		//		saveButtonInEditPage.click();
		//		Thread.sleep(2000);
		//
		//		assertTrue(aftermeasurableUpdatedContinueButton.isDisplayed());
		//
		//		aftermeasurableUpdatedContinueButton.click();
		//		Thread.sleep(2000);
		//
		//		for(int i=1;i<=4;i++) {
		//
		//			WebElement addCon=driver.findElement(By.name("next_condition_1_1_1"));
		//			String optionsName = "ans_option_1_1_"+i;
		//			WebElement options = driver.findElement(By.name(optionsName));
		//
		//			if(i==1) {
		//
		//				click(driver, options);
		//				Select addCondition= new Select(addCon);
		//				addCondition.selectByVisibleText("Section 2");
		//
		//			}
		//
		//		}
		//		saveButtonInEditPage.click();
		//		Thread.sleep(2000);
		//
		//
		//		aftermeasurableUpdatedContinueButton.click();
		//		Thread.sleep(2000);
		//		jsClick(driver, backButton);
		//
		//		String ActualCreateName=measurableQuestionSet.get(0).getText();
		//		System.out.println(ActualCreateName);
		//		assertEquals(QuestionSetName,ActualCreateName);

		stagesTab.click();
		editButtons.get(0).click();
		jsClick(addNonSectionButton);
		sectionInputField.sendKeys("Test");
		unWait(2);
		jsClick(sectionAddButton);

		jsClick(sectionButton);
		jsClick(MeasurableSetRadioBtn);

		Select nonMeasurSelectQuestionType=new Select(selectQuestiontypeDropdown);

		nonMeasurSelectQuestionType.selectByVisibleText("Dare");

		Select selectionAnyOptions=new Select(isConditonalSection1Question1);

		selectionAnyOptions.selectByVisibleText("Windows");

		List<WebElement> questions=driver.findElements(By.xpath("//div[contains(@class,'row section_c_tab_question_type')]//div[contains(@class,'col-md-3')]"));

		assertTrue(questions.size()>1);

	}

	// This Method can be Used for Dropdown,Multiple Choice, Relative Dropdown and Relative MultiSelect.
	public MeasurableSetPage dropdownAndMultiSelect(int questionType,int section,int question,String questionName, List<String> options,String requiredStatus,String EscalatedStatus,String uploadStatus ) {
		// Enter the question name in the corresponding field
		sendKeys(SetSectionQuestionName(section, question), questionName);

		// Set the question type to dropdown
		setQuestionTypes(section, question, questionType).click();

		ToggleButton(required(section,question),requiredStatus);

		ToggleButton(escalationToggle(section,question),EscalatedStatus);

		switch (uploadStatus){
			case "yes":
				// Add options dynamically based on the size of the list
				clickElementMultipleTimes(driver, addOptions(section,question), (options.size())-1);

				// Iterate over the options list and send keys to each option field
				for (int i = 0; i < options.size(); i++) {
					sendKeys(optionsFields(section, question, i + 1), options.get(i));
				}
				break;
			case "no":
				jsClick(deleteOptions(section,question));
				break;

		}

		return this;
	}

	public MeasurableSetPage textBox(int questionType,int section,int question,String questionName,String requiredStatus,String EscalatedStatus,String minLength,String maxLength,String valueType,String allowSpecialChar)
	{
		// Enter the question name in the corresponding field
		sendKeys(SetSectionQuestionName(section, question), questionName);

		// Set the question type to dropdown
		setQuestionTypes(section, question, questionType).click();

		ToggleButton(required(section,question),requiredStatus);

		ToggleButton(escalationToggle(section,question),EscalatedStatus);

		textBoxAnswerField(section,question).click();
		sendKeys(minLengthTextBox(section,question),minLength);
		sendKeys(maxLengthTextBox(section,question),maxLength);

		selectByVisibleText(textBoxValueType(section,question),valueType);
		if(allowSpecialChar.equals("no"))
		{
			jsClick(textBoxAllowSpecialChar(section,question));
		}

		return this;
	}

	public MeasurableSetPage shortAnswer(int questionType,
											int section,
											int question,
											String questionName,
											String requiredStatus,
											String EscalatedStatus,
											String minLength,
											String maxLength,
											String valueType,
											String allowSpecialChar)
	{
		// Enter the question name in the corresponding field
		sendKeys(SetSectionQuestionName(section, question), questionName);

		// Set the question type to dropdown
		setQuestionTypes(section, question, questionType).click();

		ToggleButton(required(section,question),requiredStatus);

		ToggleButton(escalationToggle(section,question),EscalatedStatus);

		shortAnswerField(section,question).click();
		sendKeys(minLengthShortAns(section,question),minLength);
		sendKeys(maxLengthShortAns(section,question),maxLength);

		selectByVisibleText(shortAnsValueType(section,question),valueType);
		if(allowSpecialChar.equals("no"))
		{
			jsClick(shortAnsAllowSpecialChar(section,question));
		}

		return this;
	}

	public MeasurableSetPage fileUpload(int questionType,
										   int section,
										   int question,
										   String questionName,
										   String requiredStatus,
										   String EscalatedStatus,
										   String addFileFormats,
										   String doYouNeedMultipleUpload,
										   String allowDelete,
										   String fileSize,
										   String sizeType
	)
	{
		// Enter the question name in the corresponding field
		sendKeys(SetSectionQuestionName(section, question), questionName);

		// Set the question type to dropdown
		setQuestionTypes(section, question, questionType).click();

		ToggleButton(required(section,question),requiredStatus);

		ToggleButton(escalationToggle(section,question),EscalatedStatus);
		jsClick(fileUploadSettings(section,question));
		try {
			selectByVisibleText(allowedFormats(section, question), addFileFormats);
		}catch (Exception e)
		{
			addAdditionalFormats(section,question).click();
			sendKeys(additionalFormatInput(section,question),addFileFormats);
			jsClick(addFormat(section,question));
			unWait(1);
			continueButton.click();
			selectByVisibleText(allowedFormats(section, question), addFileFormats);
		}
		if(doYouNeedMultipleUpload.equals("no")) {
			jsClick(uploadMultipleFiles(section, question));
		}
		if(allowDelete.equals("no"))
		{
			jsClick(allowDelete(section,question));
		}
		sendKeys(maxSizeInput(section,question),fileSize);
		selectByVisibleText(maxSizeDropdown(section,question),sizeType);

		return this;
	}


	public MeasurableSetPage radioButton(int questionType,
											int section,
											int question,
											String questionName,
											String requiredStatus,
											String EscalatedStatus,
											List<String>options
	)
	{
		// Enter the question name in the corresponding field
		sendKeys(SetSectionQuestionName(section, question), questionName);

		// Set the question type to dropdown
		setQuestionTypes(section, question, questionType).click();

		ToggleButton(required(section,question),requiredStatus);

		ToggleButton(escalationToggle(section,question),EscalatedStatus);

		// Add options dynamically based on the size of the list
		clickElementMultipleTimes(driver, addOptions(section,question), (options.size())-2);

		// Iterate over the options list and send keys to each option field
		for (int i = 0; i < options.size(); i++) {
			sendKeys(optionsFields(section, question, i + 1), options.get(i));
		}

		return this;
	}

	public MeasurableSetPage date(int questionType,
									 int section,
									 int question,
									 String questionName,
									 String requiredStatus,
									 String EscalatedStatus,
									 String maxDate,
									 String maxdateinput,
									 String minDate,
									 String mindateinput,
									 int defaultDate
	)
	{
		// Enter the question name in the corresponding field
		sendKeys(SetSectionQuestionName(section, question), questionName);

		// Set the question type to dropdown
		setQuestionTypes(section, question, questionType).click();

		ToggleButton(required(section,question),requiredStatus);

		ToggleButton(escalationToggle(section,question),EscalatedStatus);

		dateOrTimeInput(section,question).click();

		selectByVisibleText(dataMaxDateDropdown(section,question),maxDate);
		sendKeys( maxDateInput(section,question),maxdateinput);
		selectByVisibleText(dataMinDateDropdown(section,question),minDate);
		sendKeys( minDateInput(section,question),mindateinput);
		if(defaultDate==1)
		{
			defaultDate(section,question).click();
		}

		return this;
	}

	public MeasurableSetPage time(int questionType,
									 int section,
									 int question,
									 String questionName,
									 String requiredStatus,
									 String EscalatedStatus,
									 String maxTime,
									 String minTime,
									 int hourFormat12)
	{
		// Enter the question name in the corresponding field
		sendKeys(SetSectionQuestionName(section, question), questionName);

		// Set the question type to dropdown
		setQuestionTypes(section, question, questionType).click();

		ToggleButton(required(section,question),requiredStatus);

		ToggleButton(escalationToggle(section,question),EscalatedStatus);

		dateOrTimeInput(section,question).click();
		selectByVisibleText(maxTime(section,question),maxTime);

		selectByVisibleText(minTime(section,question),minTime);
		if(hourFormat12==1)
		{
			hoursFormat(section,question).click();
		}

		return this;
	}


	private MeasurableSetPage measurableParameter(int section,int question,String measurableString,String minLimit,String maxLimit)
	{
		selectByVisibleText(measurableParameterDrp(section,question),measurableString);
		sendKeys(minLimit(section,question),minLimit);
		sendKeys(maxLimit(section,question),maxLimit);
		return this;
	}


	public void ToggleButton( WebElement toggleButton,String Action) {
		if(Action.equals("yes")) {
			jsClick(toggleButton);
		}
	}

	public MeasurableSetPage addQuestion(int section)
	{
		String xpath= "//div[@data-info='question-"+section+"-1']//following-sibling::div//a[not(text()='Add Option')]";
		jsClick(driver.findElement(By.xpath(xpath)));
		return this;
	}
	public MeasurableSetPage addSection()
	{
		jsClick(addSectionButton);
		return this;
	}

	public MeasurableSetPage createQuestionSetName(String questionSetFieldName) {
		jsClick(addMeasurableSetButton);
		sendKeys(questionSetNameField,questionSetFieldName);

		return this;
	}

	public MeasurableSetPage NavToMeasurableTablePage()
	{
		workFlowDesign.click();
		jsClick(masterParameterTab);
		jsClick(measurableTab);

		return this;
	}


	public MeasurableSetPage clickOnUploadButton( String nameToDelete,String uploadType)
	{

		// Find all rows within the table
		List<WebElement> rows = formsTableBody.findElements(By.xpath("tr"));

		for (WebElement row:rows)
		{
			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));
			if(nameToDelete.equals(usernameColumn.getText()))
			{
				System.out.println( usernameColumn.getText());
				switch (uploadType){
					case "1":   jsClick(row.findElement(By.xpath("./td//a[1]//img")));
						break;

					case "2":jsClick(row.findElement(By.xpath("./td//a[2]//img")));
						break;

				}
				break;
			}
		}
		return this;
	}

	private String dropdownPath(String dropdownName)
	{
		return System.getProperty("user.dir")+"\\Upload Files\\"+dropdownName+".xlsx";
	}

	public MeasurableSetPage uploadOptions()
	{
		uploadOptions(1,1).sendKeys(dropdownPath("Dropdown 1"));
		uploadOptions(1,2).sendKeys(dropdownPath("Dropdown 2"));
		uploadOptions(2,1).sendKeys(dropdownPath("Dropdown 3"));
		saveRecord();

		return this;
	}
	private void dropdownValidations(WebElement element)
	{

		Select select=new Select(element);
		for(WebElement option:select.getOptions())
		{


		}

	}

	public MeasurableSetPage validateInStages(String sectionCName,String DropdownToSelect)
	{
		stagesTab.click();
		editButtons.get(0).click();
		js.executeScript("window.scrollTo(0, 700);");
		jsClick(addSection);
		sectionName.sendKeys(sectionCName);
		unWait(1);
		jsClick(add);

		jsClick(sectionCTabs(sectionCName));;
		jsClick(measurableRadioButton(sectionCName));
		selectByVisibleText(measurableDropdownQuestionDropdown(sectionCName),DropdownToSelect);
		//Should Add Validations


		return this;
	}

	private MeasurableSetPage fetchFromDataset(int dataset,int section,
												  int question,WebElement datasetElement,
												  String datasetName,
												  WebElement columnNameElement,String columnName)
	{
		if(dataset==1)
		{
			fetchFromDataset(section,question).click();
			selectByVisibleText(datasetElement,datasetName);
			selectByVisibleText(columnNameElement,columnName);
		}

		return this;
	}
























	@FindBy(xpath ="//button[text()='Save']")
	WebElement save;

	public MeasurableSetPage saveRecord2()
	{
		jsClick(save);
		unWait(1);
		continueButton.click();
		return this;
	}





















	//----------------------------------------------------------------------------------------------------------
	//#############################################################################################################################

	public void MeasurableSetTablePage() throws Throwable {

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

	public void MeasurableSetEditPage() {

		click(driver, editMeasurableSetButton);

		assertTrue(remarkFieldInEditPage.isDisplayed(), "remarkFieldInEditPage is not displayed.");
		remarkFieldInEditPage.clear();
		remarkFieldInEditPage.sendKeys("Test Edit MeasurableSet");
		click(driver, saveButtonInEditPage);

		wait.until(ExpectedConditions.visibilityOf(successfullymeasurableUpdatedMassage));
		assertTrue(successfullymeasurableUpdatedMassage.isDisplayed(),
				"successfullyMeasurableUpdatedMassage is not displayed.");

		click(driver, aftermeasurableUpdatedContinueButton);

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

	@FindBy(linkText = "SMS Template")
	WebElement smsTemplate;
	public void smsTemp()
	{
		jsClick(smsTemplate);
	}





}




