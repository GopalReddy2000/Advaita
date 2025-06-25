package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;

import Advaita_TDD.Advaita_TDD.FakeData;

public class MastersMastersforms extends TestBase // Create_Class and extend base class
{
	FakeData fake = new FakeData();

	public static final String masterURL = "https://test.capture.autosherpas.com/en/masters/masters_question_sets/";

	public static String fetchProcessRecord;
	public static String fetchSubProcessRecord;
	public static String fetchSubSubProcessRecord;
	public static String fetchMetaDataRecord;

	public static String nameOfCustomerValue;
	public static String NameofCustomerOptionTagname_fieldset;
	public static String AddressofCustomerValue_fieldset;
	public static String addessofCustomerTagName_fieldset;
	public static String questionSetDatainfo_fieldset;
	public static String dateofCallValue_fielset;
	public static String dateofcall_Id_Fieldset;
	public static String timeofCallElementValue_fieldset;
	public static String timeofcall_id_Fieldset;
//	public static String singleTimeofcall_Masterform;
	public static String DidYouPickYourCallValue_fieldset;
	public static String genderOfTheCustomerValue_fieldset;
	List<String>dropdownValueList;
	
	public static String customerDetailFileValue_fieldset;
	public static String fileUplaod_ID_fieldset;
	public static String CustomerwantedOrnamentsValue_fieldset;
	public static String CustomerRequirementValue_fieldset;
	
	public static String customerNameValue_Column1_fieldset;
	public static String question1_nameValue_column1_fieldset;
	public static String textTypeTagname_column1_Fieldset;
	public static String callDateValue_Column1_fieldset;
	public static String PersonPickCallText_column3_fieldset;
	public static String DatepickerTypeID_column3_Fieldset_;
	public static String customerDetailFileName_column4_fieldset;
	public static String Question4FileValue_S3_column4_fieldset;
	
	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;
	
	// process

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]")
	public static WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td[1]//img[@alt='table_drop_down']")
	public static WebElement dropDown2;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td[1]//span")
	public static WebElement fetchProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[1]")
	public static WebElement fetchsubProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[3]")
	public static WebElement fetchsubSubProcess;

	@FindBy(xpath = "//body")
	public static WebElement entireBody;
	
	
	

	// FieldSets

	@FindBy(xpath = "//a//img[@class='arrow-left']")
	public static WebElement BackBotton_fieldset;

	@FindBy(xpath = "//input[@id='questionSet_name']")
	public static WebElement questionsetTextField_fieldset;

	@FindBy(xpath = "//input[@name='question_1_1']")
	public static WebElement NameOFTheCustomerTextfield_Question1;

	@FindBy(xpath = "//input[@type='text' and @class='answer_option text_box_input' and @name='ans_option_1_1_1' ]")
	public static WebElement Textbox_Type_question1;

	@FindBy(xpath = "//div[@class='add-items']//h5[text()='Question 2']/..//input[@name='question_1_2']")
	public static WebElement AddressOftheCustomer_Question2;

	@FindBy(xpath = "//div[@class='choice_option_div_append']//input/..//textarea[@class='answer_option short_answer_input']")
	public static WebElement Shortanswer_TypeElement;

	@FindBy(xpath = "//div[@data-info='section-1']//div[@class='add-items']//h5[text()='Question 3']/..//input[@class='question_text']")
	public static WebElement DateOfCall_Question3;

	@FindBy(xpath = "//div[@class='choice_option_div_append']//input[@class='answer_option time_pick']")
	public static WebElement DatePicker_TypElement;

	@FindBy(xpath = "//div[@data-info='section-1']//div[@class='add-items']//h5[text()='Question 4']/..//input[@class='question_text']")
	public static WebElement TimeOfCall_Question4;

	@FindBy(xpath = "//div[@class='choice_option_div_append']//input[@class='answer_option time_pick']")
	public static WebElement Timepicker_typElement;
	
	@FindBy (xpath = "(//input[@id='startDate'])[1]")
	public static WebElement timepickerTypElement;

	@FindBy(xpath = "//input[@name='question_1_5']")
	public static WebElement DidYouPickYourCall_Question5;
	
	@FindBy(xpath = "//input[@name='question_1_6']")
	public static WebElement genderOfTheCustomer_Question6;
	
	@FindBy(xpath = "//input[contains(@name, 'anser_id_1_6_')]")
	public static List<WebElement> DropDownTypeEelement_fieldset;

	// S2

	@FindBy(xpath = "//div[@data-info='question-2-1']//input[@name='question_2_1']") // //input[@name='question_2_1']
	public static WebElement CustomerDetailFile_S2_question1_fieldset;

	@FindBy(xpath = "//label[@class='drag-drop']/..//input")                     // //label[@class='drag-drop']//span
	public static WebElement Fileupload_typElement_Fieldset;					//  label[@class='drag-drop']

	@FindBy(xpath = "//div[@data-info='question-2-2']//input[@name='question_2_2']")
	public static WebElement customerElementWantedOrnamenets_question2_S2;
	
	@FindBy(xpath = "//input[@name='anser_id_2_2_1']/following-sibling::div//input")
	public static List<WebElement> relativeDropdownTypeListsElements_fieldset;
	
	@FindBy(xpath = "//div[@data-info='question-2-3']//input[@name='question_2_3']")
	public static WebElement customerRequirement_S2_Question3_Fieldset;
	
	@FindBy(xpath = "//input[@name='anser_id_2_3_1']/following-sibling::div//input")
	public static List<WebElement> MultipleChoiceTypeLists_fieldset; 
	
	// s3
	@FindBy(xpath = "//input[@name='col_name_3_1']") 				  // //label[@class='column-name1'])[1]
	public static WebElement customerName_S3_column1_Fieldset;
	
	@FindBy(xpath = "//input[@name='question_3_1']")
	public static WebElement question1_name_column1_fieldset;
	
	@FindBy (xpath = "//input[@name='ans_option_3_1_1']")
	public static WebElement textType_column1_Fieldset;
	
	@FindBy(xpath = "//input[@name='col_name_3_3']")
	public static WebElement calldate_S3_column3_Fieldset;
	
	@FindBy(xpath = "//input[@name='question_3_3']")
	public static WebElement question2Date_S3_Column3_fieldset;
	
	@FindBy(xpath="//input[@name='ans_option_3_3_1']")
	public static WebElement datepickerType_Column3_fieldset;
	
	@FindBy(xpath="//label[text()='Person Who Pick the Call']")
	public static WebElement personPickCall_s3_column3_fieldset;
	
	
	
	@FindBy(xpath = "//input[@name='question_col_no_3_4']")
	public static WebElement customerDetailFile_S3_Column4_fieldset;
	
	@FindBy(xpath = "//input[@name='question_3_4']")
	public static WebElement Question4File_S3_column4_fieldset;
	
	
	
	
	

	
	// Masterforms

	@FindBy(xpath = "//div[@class='stage1-workflow page_body']")
	public static WebElement entireBody_MasterFormsElement;
	
	@FindBy(xpath = "(//button[normalize-space()='Masters'])[1]")
	public static WebElement mastersTabElement;

	@FindBy(id = "pills-MasterForms-tab")
	public static WebElement mastersFormsTabElement;

	@FindBy(xpath = "//a[normalize-space()='+ Create']")
	public static WebElement createMastersFormBottom;

	@FindBy(xpath = "//h2[text()='Create Master Form']")
	public static WebElement createMasterFormNameTextBoxElement;

	@FindBy(xpath = "//input[@id='stage_name']")
	public static WebElement formNamElement;

	@FindBy(xpath = "//h3[text()='Process*']/..//select[@id='process']")
	public static WebElement processDropdownElement;

	@FindBy(xpath = "//h3[text()='Sub Process*']/..//select[@id='sub_process']")
	public static WebElement subProcessDropdownElement;

	@FindBy(xpath = "//h3[text()='Sub Sub Process*']/..//select[@id='s_sub_process']")
	public static WebElement subSubProcessDropdownElement;

	@FindBy(xpath = "//div[@id='SectionA']//h2//h6[text()='Primary Section']")
	public static WebElement primarySectionExpansionPanelText;

	@FindBy(xpath = "(//a[@class='btn-primary add-button section_c_add_popup'])[1]")
	public static WebElement primarySection_AddButton;

	@FindBy(xpath = "(//a[@class='btn-primary add-button section_c_add_popup'])[2]") // 2nd Add button
	public static WebElement secondaryPrimarySection_addButton;

	@FindBy(xpath = "//h1[text()='Add Section']")
	public static WebElement addSectionPopUpElement;

	@FindBy(xpath = "//input[@class='form-control section_name']")
	public static WebElement sectionNameTextfieldElement;

	@FindBy(xpath = "//a[@class='side-addbutton btn-primary add_section_c section_common_addcls']")
	public static WebElement AddButton_addsectionPopup;

	@FindBy(xpath = "(//a[@class='btn-primary addcolor-cancel'])[3]")
	public static WebElement CancelButton_addSectionPopup;

	@FindBy(xpath = "(//li[contains(@class,'nav-item')])[1]")
	public static WebElement addedPrimarySectionButtonElement;
	
	@FindBy(xpath = "(//li[@class='nav-item nav-abc']//button)[1]")
	public static WebElement AddedSecondary_PrimarySectionButtonElement;          //2nd added Secondary primary section 

	@FindBy(xpath = "//select[@name='sectionval_Mesaurable_value_primaryDetails']")
	public static WebElement selectQuestionSetDropdownElement;

	@FindBy(xpath = "//a[text()='Edit Section']")
	public static WebElement editSection_PrimarySectionExpansionPanel;

	@FindBy(xpath = "(//a[text()='Delete Section'])[1]")
	public static WebElement deleteSection_PrimarySectionExpanionPanel;

	@FindBy(xpath = "(//div[@class='custom-select']//label)[1]")
	public static WebElement namefcustomerElement_masterform;
	
	@FindBy(xpath = "(//div[@class='custom-select']//label/..//input[@type='text'])[1]")
	public static WebElement textboxTypElement_masterformsElement;

	@FindBy(xpath = "(//div[@class='custom-select']//label)[2]")
	public static WebElement addressOfTheCustomerTextfieldElement;

	@FindBy(xpath = "//div[@class='custom-select']//label/..//textarea")
	public static WebElement shortanswerTypElement_masterformsElement;

	@FindBy(xpath = "//div[@class='custom-select time-place']//label")
	public static WebElement dateofTheCallElement;

	@FindBy(xpath = "(//button[@class='xdsoft_today_button'])[1]")
	public static WebElement datePickerHomeButton_masterforms;
	
	@FindBy(xpath = "//div[@class='custom-select time-place']//label/..//input[@placeholder='DD-MM-YYYY']")
	public static WebElement datePickerType_mastersFormsElement;

	@FindBy(xpath = "//div[@class='custom-select time-place ']//label")
	public static WebElement timeofCallElement;

	@FindBy(xpath = "//div[@class='custom-select time-place ']//label/..//input[@placeholder='HH:MM']")
	public static WebElement timepickerType_masterformsElement;
	
	@FindBy(xpath = "(//input[@id='startDate'])[1]")
	public static WebElement timepickerType_MasterformsElement;
	
	@FindBy(xpath = "//div[@class='xdsoft_time_variant']")
	public static WebElement timepickerContainer_masterForms;
	
	@FindBy(xpath = "//div[@class='xdsoft_time_variant']")
	public static List<WebElement> timeElements;

	@FindBy(xpath = "(//div[@class='form-group']//label)[1]") // div[@class='form-group']//label
	public static WebElement didyouPickCallElement;

	@FindBy(xpath = "//div[@class='form-group']//label//input")                 
	public static List<WebElement> radioButtonType_masterFormsElements;

	@FindBy(xpath = "(//div[@class='custom-select']//label)[3]")
	public static WebElement genderOfTheCustomerElement;
	
	@FindBy(xpath = "(//select[contains(@class,'rule-select new-')])[1]//option[not(@value=0)]")
	public static List<WebElement> dropdownTypeTypeElements;

	@FindBy(xpath = "//label[text()='Customer Detail File ?']")
	public static WebElement CustomerDetailFile_masterform;
	
	@FindBy(xpath = "(//div[@class='upload-cloud']//label/..//input[@id='Browse'])[1]")
	public static WebElement fileuploadType_masterFormsElement;

	@FindBy(xpath="(//div[@class='custom-select']//label)[4]")
	public static WebElement CustomerWantedOrnaments_masterForms;
	
	@FindBy(xpath = "(//select[@id='current_Sec_id'])[2]")
	public static WebElement relativeDropdownType_masterForms;

	@FindBy(xpath = "(//div[@class='custom-select']//label)[5]")
	public static WebElement CustomerRequirementElement;
	
	@FindBy(xpath = "//ul[@class='select2-results__options']//li[not(@aria-disabled='true')]")
	public static List<WebElement> MultiplechoiceTypeListsElements_masterforms;

//	@FindBy(xpath = "(//div[@class='custom-select']//label)[5]/..//select[@data-type='multiple_choice']")
//	public static WebElement multipleChoiceType_mastersFormsElement;

	
	
	@FindBy(xpath = "(//label[@class='column-name1'])[1]")
	public static WebElement CustomerName_column1_masterFormsElement;

	@FindBy(xpath = "//label[text()='Name']")								// (//div[@class='custom-select']//label)[6]
	public static WebElement Question1_name_column1_MasterformElement;		

	@FindBy(xpath = "//input[@name='ans_option_3_1_1']	")  			   //(//div[@class='custom-select']//label)[6]/..//input
	public static WebElement textType_column1_MasterFormElement;

	@FindBy(xpath = "//label[text()='Person Who Pick the Call']")
	public static WebElement personWhoPickTheCall_coulmn2_masterformElement;

	@FindBy(xpath = "//div[@class='d-flex align-items-center']//input")
	public static WebElement radioButtonType_column2_masterFormsElement;

	@FindBy(xpath = "//input[@name='col_name_3_3']")
	public static WebElement calldate_column3_mastersformElement;

	@FindBy(xpath = "(//div[@class='custom-select time-place']//label)[2]")
	public static WebElement date_column3_masterformElement;

	@FindBy(xpath = "//input[@placeholder='YYYY-MM-DD']")
	public static WebElement datepickerType_column3_masterFormElement;

	@FindBy(xpath = "//input[@name='question_col_no_3_4'] ") 					//(//div[@class='d-flex align-items-center justify-content-between table-viewleft']//label)[4]
	public static WebElement customerDetailFile_Column4_mastersFormsElement;

	@FindBy(xpath = "(//div//div[@class='col-md-12 position-relative']//label)[1]")
	public static WebElement file_Column4_masterforms;

	@FindBy(xpath = "(//div[@class='upload-cloud']//label/..//input[@id='Browse'])[2]")
	public static WebElement fileuploadType_column4_masterFormsElement;

	public MastersMastersforms() // Create _ Constructor
	{

		PageFactory.initElements(driver, this); // Driver (driver.findElement) this=current invoation
	}

	// Fetch process , SubProcess ,SubSubProcess
	public void navigateFetchProcessRecord() throws Throwable {

		driver.navigate().to("https://test.capture.autosherpas.com/en/data_management/process/");
		
		wait.until(ExpectedConditions.urlToBe("https://test.capture.autosherpas.com/en/data_management/process/"));

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOf(dropDown1));
		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(500);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(500);

		fetchProcessRecord = fetchProcess.getText();
		assertNotNull(fetchProcessRecord, "fetchProcessRecord is null.");

		System.out.println("fetchProcessRecord : " + fetchProcessRecord);

	}

	public void navigateFetchSubProcessRecord() throws Throwable {

		fetchSubProcessRecord = fetchsubProcess.getText();
		assertNotNull(fetchSubProcessRecord, "fetchSubProcessRecord is null.");
		System.out.println("fetchSubProcessRecord : " + fetchSubProcessRecord);
	}

	public void navigateFetchSubSubProcessRecord() throws Throwable {

		fetchSubSubProcessRecord = fetchsubSubProcess.getText();
		Thread.sleep(1000);
		assertNotNull(fetchSubSubProcessRecord, "fetchSubSubProcessRecord is null.");

		System.out.println("fetchSubSubProcessRecord : " + fetchSubSubProcessRecord);

		Thread.sleep(1000);

		driver.navigate().to("https://test.capture.autosherpas.com/en/masters/masters_list/");

	}

	// Create
	public void ClickOnMasterTab() {
		
		wait.until(ExpectedConditions.visibilityOf(mastersTabElement));
		assertTrue(mastersTabElement.isDisplayed(), "mastersTabElement is not dispalyed");
		mastersTabElement.click();
	}

	public void verifyMasterFormsTab() {
		assertTrue(mastersFormsTabElement.isDisplayed(), "mastersFormsTabElement is not displayed");
		mastersFormsTabElement.click();
	}

	public void Fetch_FieldSets() {
		driver.navigate().to("https://test.capture.autosherpas.com/en/masters/masters_question_sets/");
		WebElement EditButton_fieldSet = driver
				.findElement(By.xpath("(//div[@class='d-flex align-items-center']//img)[2]"));
		EditButton_fieldSet.click();

	}

	public void FetchQuestions_fieldsets() {
		
		//questionSet
//		questionSetDatainfo_fieldset = questionsetTextField_fieldset.getAttribute("data-info");
//		System.out.println("questionSetDatainfo_fieldset :" + questionSetDatainfo_fieldset );
		
		// question1
		nameOfCustomerValue = NameOFTheCustomerTextfield_Question1.getAttribute("value");
		System.out.println("nameOfCustomerValue :"+ nameOfCustomerValue);

		//options
		NameofCustomerOptionTagname_fieldset = Textbox_Type_question1.getTagName();
		System.out.println("NameofCustomerOptionTagname_fieldset :" + NameofCustomerOptionTagname_fieldset);

		// question2
		 AddressofCustomerValue_fieldset = AddressOftheCustomer_Question2.getAttribute("value");
		System.out.println("AddressofCustomerValue_fieldset :" + AddressofCustomerValue_fieldset);

		//options
		addessofCustomerTagName_fieldset = Shortanswer_TypeElement.getTagName();
		System.out.println("addessofCustomerTagName_fieldset :" + addessofCustomerTagName_fieldset);



		// question3
		js.executeScript("arguments[0].scrollIntoView(true);", DateOfCall_Question3); // Scroll the webpage
		dateofCallValue_fielset=DateOfCall_Question3.getAttribute("value");
		System.out.println("dateofCallValue_fielset :"+ dateofCallValue_fielset);
		
		//option
		dateofcall_Id_Fieldset=DatePicker_TypElement.getAttribute("id");
		System.out.println("Date of call id_fieldset : " + dateofcall_Id_Fieldset);
		
		//Question4
		timeofCallElementValue_fieldset = TimeOfCall_Question4.getAttribute("value");
		System.out.println(timeofCallElementValue_fieldset);
		
		//option
		timeofcall_id_Fieldset = Timepicker_typElement.getAttribute("id");
		System.out.println(timeofcall_id_Fieldset);
		
		//question5
		DidYouPickYourCallValue_fieldset=DidYouPickYourCall_Question5.getAttribute("value");
		System.out.println(DidYouPickYourCallValue_fieldset);
		
		//options
		
		//question6
		genderOfTheCustomerValue_fieldset=genderOfTheCustomer_Question6.getAttribute("value");
		System.out.println(genderOfTheCustomerValue_fieldset);
		
		//options
		dropdownValueList=new ArrayList<>();                                      // creating global variable from here 'pending'
		for (WebElement dropdownValuesElements : DropDownTypeEelement_fieldset) 
		{
			dropdownValueList.add(dropdownValuesElements.getAttribute("value"));
			System.out.println("dropdownValuesElements :" + dropdownValuesElements.getAttribute("value"));
		}
		
		
		//S2_Question1
		customerDetailFileValue_fieldset = CustomerDetailFile_S2_question1_fieldset.getAttribute("value");
		System.out.println(CustomerDetailFile_S2_question1_fieldset.getAttribute("value"));
		
		//option
		js.executeScript("arguments[0].scrollIntoView(true);", Fileupload_typElement_Fieldset);
		fileUplaod_ID_fieldset=Fileupload_typElement_Fieldset.getAttribute("id");
		System.out.println(fileUplaod_ID_fieldset);
		
		
		
		//S2_question2
		CustomerwantedOrnamentsValue_fieldset = customerElementWantedOrnamenets_question2_S2.getAttribute("value");
		System.out.println(CustomerwantedOrnamentsValue_fieldset);
		
		//option
		
		
		//S2_Question3
		CustomerRequirementValue_fieldset=customerRequirement_S2_Question3_Fieldset.getAttribute("value");
		System.out.println(CustomerRequirementValue_fieldset);
		
		//options
		List<String>relativeDropdownListsELements_fieldset=new ArrayList<String>();
		for (WebElement relativedropdowntyistsType : MultipleChoiceTypeLists_fieldset) 
		{
			relativeDropdownListsELements_fieldset.add(relativedropdowntyistsType.getAttribute("value"));
			System.out.println("realtive dropdown lists fieldset :" + relativedropdowntyistsType.getAttribute("value"));
		}
		
		//S3_Column1
		js.executeScript("arguments[0].scrollIntoView(true);", customerName_S3_column1_Fieldset);
		customerNameValue_Column1_fieldset=customerName_S3_column1_Fieldset.getAttribute("value");
		System.out.println(customerNameValue_Column1_fieldset);
		
		question1_nameValue_column1_fieldset=question1_name_column1_fieldset.getAttribute("value");
		System.out.println(question1_name_column1_fieldset);
		
		//options
		textTypeTagname_column1_Fieldset=textType_column1_Fieldset.getTagName();
		System.out.println(textTypeTagname_column1_Fieldset);
		
		//S2_column2
		PersonPickCallText_column3_fieldset=personPickCall_s3_column3_fieldset.getText();
		System.out.println(PersonPickCallText_column3_fieldset);
		
		//S3_Column3
		callDateValue_Column1_fieldset=calldate_S3_column3_Fieldset.getAttribute("value");
		System.out.println(callDateValue_Column1_fieldset);
		
		//option
		DatepickerTypeID_column3_Fieldset_=datepickerType_Column3_fieldset.getAttribute("id");
		System.out.println(DatepickerTypeID_column3_Fieldset_);
		
		//S3_column4
		customerDetailFileName_column4_fieldset=customerDetailFile_S3_Column4_fieldset.getAttribute("name");
		System.out.println(customerDetailFileName_column4_fieldset);
	
		Question4FileValue_S3_column4_fieldset=Question4File_S3_column4_fieldset.getAttribute("value");
		System.out.println(Question4FileValue_S3_column4_fieldset);
		
		
		
		
		
		
		BackBotton_fieldset.click();
		
	}

	public void VerifyTheUSerIsableToCreateMasterForms(String details, String PrimaryDetails, String Abhijit , String btm )
			throws Throwable 
	{
		wait.until(ExpectedConditions.visibilityOf(createMastersFormBottom));
		assertTrue(createMastersFormBottom.isDisplayed(), "createMastersFormBottom is not displyed");
		createMastersFormBottom.click();

		assertTrue(createMasterFormNameTextBoxElement.isDisplayed(),
				"createMasterFormNameTextBoxElement is not displayed");
		System.out.println(createMasterFormNameTextBoxElement.getText());

		assertTrue(formNamElement.isDisplayed(), "formNamElement is not displayed");
		formNamElement.click();
		formNamElement.sendKeys(details);

		Select processDropdown = new Select(processDropdownElement);
		processDropdown.selectByVisibleText(fetchProcessRecord);
		//entireBody.click();
		actions.moveToElement(driverIninteractable).perform();
		
		
		
		Select subProcessDropdown = new Select(subProcessDropdownElement);
		subProcessDropdown.selectByVisibleText(fetchSubProcessRecord);
		//entireBody.click();
		actions.moveToElement(driverIninteractable).perform();

		Select subSubProcessDropdownSelect = new Select(subSubProcessDropdownElement);
		subSubProcessDropdownSelect.selectByVisibleText(fetchSubSubProcessRecord);
		//entireBody.click();
		actions.moveToElement(driverIninteractable).perform();
		
		
		assertTrue(primarySectionExpansionPanelText.isDisplayed(), "primarySectionExpansionPanelText is not displayed");
		primarySectionExpansionPanelText.getText();

		assertTrue(primarySection_AddButton.isDisplayed(), "primarySection_AddButton is not displayed");
		primarySection_AddButton.click();

		wait.until(ExpectedConditions.visibilityOf(addSectionPopUpElement));
		assertTrue(addSectionPopUpElement.isDisplayed(), "addSectionPopUpElement is not displayed");

		assertTrue(sectionNameTextfieldElement.isDisplayed(), "sectionNameTextfieldElement is not displayed");
		sectionNameTextfieldElement.click();
		sectionNameTextfieldElement.sendKeys(PrimaryDetails);

		assertTrue(CancelButton_addSectionPopup.isDisplayed(), "CancelButton_addSectionPopup is not displayed");

		assertTrue(AddButton_addsectionPopup.isDisplayed(), "AddButton_addsectionPopup is not displayed");
		AddButton_addsectionPopup.click();

//		wait.until(ExpectedConditions.visibilityOf(addedPrimarySectionButtonElement));
		assertTrue(addedPrimarySectionButtonElement.isDisplayed(), "addedPrimarySectionButtonElement is not displayed");
		addedPrimarySectionButtonElement.click();

		wait.until(ExpectedConditions.visibilityOf(editSection_PrimarySectionExpansionPanel));
		assertTrue(editSection_PrimarySectionExpansionPanel.isDisplayed(),
				"editSection_PrimarySectionExpansionPanel is not displayed");

		wait.until(ExpectedConditions.visibilityOf(deleteSection_PrimarySectionExpanionPanel));
		assertTrue(deleteSection_PrimarySectionExpanionPanel.isDisplayed(),
				"deleteSection_PrimarySectionExpanionPanel is not displayed");

		// questionSet
//		selectQuestionSetDropdownElement.getAttribute("data-type");
//		System.out.println("questset Dropdwown_masterforms :" + selectQuestionSetDropdownElement.getAttribute("data-type"));
//		assertEquals(selectQuestionSetDropdownElement.getAttribute("data-type"), questionSetDatainfo_fieldset);
		
		//wait.until(ExpectedConditions.visibilityOf(selectQuestionSetDropdownElement));
		assertTrue(selectQuestionSetDropdownElement.isDisplayed(), "selectQuestionSetDropdownElement is not displayed");
		Select slectQuestionSetDropdown = new Select(selectQuestionSetDropdownElement);
		slectQuestionSetDropdown.selectByVisibleText("Oberbrunner QS");

		// question1_ Name of the customer

		namefcustomerElement_masterform.getText();
		System.out.println("namofcustomerElement_masterform : "+ namefcustomerElement_masterform .getText()+"\n"+nameOfCustomerValue);
		assertEquals(namefcustomerElement_masterform .getText(), nameOfCustomerValue);

		//options
		textboxTypElement_masterformsElement.getTagName();
		System.out.println("NameofcustomerOptionTagname_masterform :" + textboxTypElement_masterformsElement.getTagName() + "\n"+NameofCustomerOptionTagname_fieldset);
		assertEquals(textboxTypElement_masterformsElement.getTagName(), NameofCustomerOptionTagname_fieldset);
		
		ClickUtilities.click(driver, textboxTypElement_masterformsElement);
		textboxTypElement_masterformsElement.click();
		textboxTypElement_masterformsElement.sendKeys("Abhijit");
		
		//Question2_Address of the customer
		addressOfTheCustomerTextfieldElement.getText();
		System.out.println("AddressofthecustomerValue "+ addressOfTheCustomerTextfieldElement.getText()  );
		assertEquals(addressOfTheCustomerTextfieldElement.getText(), AddressofCustomerValue_fieldset);
		
		//option
		shortanswerTypElement_masterformsElement.getTagName();
		System.out.println("Address of customer tagname_masterform :" + shortanswerTypElement_masterformsElement.getTagName());
		assertEquals(shortanswerTypElement_masterformsElement.getTagName(), addessofCustomerTagName_fieldset);
		shortanswerTypElement_masterformsElement.click();
		shortanswerTypElement_masterformsElement.sendKeys(btm);
		
		//Question3_Date of the call
		dateofTheCallElement.getText();
		System.out.println("dateofTheCall tagtext masterform : " + dateofTheCallElement.getText());
		assertEquals(dateofTheCallElement.getText(), dateofCallValue_fielset);
		
		//option
		datePickerType_mastersFormsElement.getAttribute("id");
		System.out.println("dateofcall id_masterform :" + datePickerType_mastersFormsElement.getAttribute("id"));
		assertEquals(datePickerType_mastersFormsElement.getAttribute("id"), dateofcall_Id_Fieldset);
		ClickUtilities.doubleClickElement(datePickerType_mastersFormsElement, driver);
		datePickerType_mastersFormsElement.click();
		//ClickUtilities.doubleClickElement(datePickerType_mastersFormsElement, driver);
		//assertTrue(datePickerHomeButton_masterforms.isDisplayed(), "Date Picker is not Displayed.");
		datePickerType_mastersFormsElement.sendKeys("26-05-2024");
		//actions.moveToElement(driverIninteractable).perform();
		entireBody_MasterFormsElement.click();
		
		//question4 time of call
		timeofCallElement.getText();
		System.out.println("Time of call tagtext_masterForm :" + timeofCallElement.getText());
		js.executeScript("arguments[0].scrollIntoView(true);", timeofCallElement);     // Scroll the webpage_masterform
		assertEquals( timeofCallElement.getText(), timeofCallElementValue_fieldset);
		
		//options
		timepickerType_masterformsElement.getAttribute("id");
		System.out.println(timepickerType_masterformsElement.getAttribute("id"));
		assertEquals(timepickerType_masterformsElement.getAttribute("id"), timeofcall_id_Fieldset);
		//timepickerType_masterformsElement.click();
		actions.moveToElement(driverIninteractable).perform();
		timepickerType_masterformsElement.sendKeys("12.00");
		
		//question5 Did you pick your call
		didyouPickCallElement.getTagName();
		System.out.println(didyouPickCallElement.getText());
		assertEquals(didyouPickCallElement.getText(), DidYouPickYourCallValue_fieldset);
		
		//options
		
		//String expectedRadioButtonTex;
		
		List<String> radioButtonValue=new ArrayList<>();
		for (WebElement radioButtonValuesElement  : radioButtonType_masterFormsElements) 
		{
			radioButtonValue.add(radioButtonValuesElement.getAttribute("id"));
//			System.out.println(radioButtonValue);
			System.out.println(radioButtonValuesElement.getAttribute("id"));
			
			//expectedRadioButtonTex=radioButtonValuesElement.getAttribute("id");
			
			
		}
//		assertTrue(radioButtonValue.contains(radioButtonValue));     // Need To impliment
//		System.out.println();
		
		
		for (WebElement radioButtonType : radioButtonType_masterFormsElements)       //Radiobuttontype =variable
		{
			radioButtonType.click();
		}																				
		
		//question6 Gender of the customer
		genderOfTheCustomerElement.getText();
		System.out.println(genderOfTheCustomerElement.getText());
		assertEquals(genderOfTheCustomerElement.getText(), genderOfTheCustomerValue_fieldset);
		
		//options
		List<String>dropdownValues_masterformStrings=new ArrayList<>();
		for (WebElement dropdownValuesElements_masterforms : dropdownTypeTypeElements) 
		{
			dropdownValues_masterformStrings.add(dropdownValuesElements_masterforms.getAttribute("value"));
			System.out.println("dropdownValuesElements_masterforms :" + dropdownValuesElements_masterforms.getAttribute("value"));
		}
			
		//S2_Q1_Customer Detail FIle
		CustomerDetailFile_masterform.getText();
		System.out.println(CustomerDetailFile_masterform.getText());
		assertEquals(CustomerDetailFile_masterform.getText(), customerDetailFileValue_fieldset);
		
		//option
		fileuploadType_masterFormsElement.getAttribute("id");
		System.out.println(fileuploadType_masterFormsElement.getAttribute("id"));
		assertEquals(fileuploadType_masterFormsElement.getAttribute("id"), fileUplaod_ID_fieldset);
		
		
		
		
		//S2_Q2_Customer Wanted Ornaments
		CustomerWantedOrnaments_masterForms.getText();
		System.out.println(CustomerWantedOrnaments_masterForms.getText());
		assertEquals(CustomerWantedOrnaments_masterForms.getText(), CustomerwantedOrnamentsValue_fieldset);
		
		//option
		
		//S3_3_CustomerRequirement
		CustomerRequirementElement.getText();
		System.out.println(CustomerRequirementElement.getText());
		assertEquals(CustomerRequirementElement.getText(), CustomerRequirementValue_fieldset);
		
		//options
		List<String> multiplechoicesLists_masterForms=new ArrayList<>();
		for (WebElement multiplechoicelists : MultiplechoiceTypeListsElements_masterforms) 
		{
			multiplechoicesLists_masterForms.add(multiplechoicelists.getText());
			System.out.println("MultipleChoicesLists texts :" + multiplechoicelists.getText());
		}
		
		//S3_C1_Customer Name
		CustomerName_column1_masterFormsElement.getText();
		System.out.println(CustomerName_column1_masterFormsElement.getText());
		assertEquals(CustomerName_column1_masterFormsElement.getText(), customerNameValue_Column1_fieldset);
		
		Question1_name_column1_MasterformElement.getText();
		System.out.println(Question1_name_column1_MasterformElement.getText());
		assertEquals(Question1_name_column1_MasterformElement.getText(), question1_nameValue_column1_fieldset);
		
		//options
		textType_column1_MasterFormElement.getTagName();
		System.out.println(textType_column1_MasterFormElement.getTagName());
		assertEquals(textType_column1_MasterFormElement.getTagName(), textTypeTagname_column1_Fieldset);
		
		//S3_Column2_Person Who PickCall
		personWhoPickTheCall_coulmn2_masterformElement.getText();
		System.out.println(personWhoPickTheCall_coulmn2_masterformElement.getText());
		assertEquals(personWhoPickTheCall_coulmn2_masterformElement.getText(), PersonPickCallText_column3_fieldset);
		//options
		
		//S3_column3_CallDate
		calldate_column3_mastersformElement.getAttribute("value");
		System.out.println(calldate_column3_mastersformElement.getAttribute("value"));
		assertEquals(calldate_column3_mastersformElement.getAttribute("value"), callDateValue_Column1_fieldset);
		
		//options
		datepickerType_column3_masterFormElement.getAttribute("id");
		System.out.println(datepickerType_column3_masterFormElement.getAttribute("id"));
		assertEquals(datepickerType_column3_masterFormElement.getAttribute("id"), DatepickerTypeID_column3_Fieldset_);
		datepickerType_column3_masterFormElement.sendKeys("2024-10-24");
		
		//S4_Column_Customer_DetailFile
		customerDetailFile_Column4_mastersFormsElement.getAttribute("name");
		System.out.println(customerDetailFile_Column4_mastersFormsElement.getAttribute("name"));
		assertEquals(customerDetailFile_Column4_mastersFormsElement.getAttribute("name"), customerDetailFileName_column4_fieldset);
		
		file_Column4_masterforms.getText();
		System.out.println(file_Column4_masterforms.getText());
		assertEquals(file_Column4_masterforms.getText(), Question4FileValue_S3_column4_fieldset);
		
		
		
		secondaryPrimarySection_addButton.click();
		wait.until(ExpectedConditions.visibilityOf(addSectionPopUpElement));
		assertTrue(addSectionPopUpElement.isDisplayed(), "addSectionPopUpElement is not displayed");
		
		assertTrue(sectionNameTextfieldElement.isDisplayed(), "sectionNameTextfieldElement is not displayed ");
		sectionNameTextfieldElement.sendKeys("SectionName");
		
		assertTrue(addSectionPopUpElement.isDisplayed(), "addSectionPopUpElement is not displayed");
		addSectionPopUpElement.click();
		
//		assertTrue(AddedSecondary_PrimarySectionButtonElement.isDisplayed(), "AddedSecondary_PrimarySectionButtonElement is not displayed");
//		AddedSecondary_PrimarySectionButtonElement.click();
		
		
		
	}
	
	
	
	public void TextfieldValaidation() 
	{
		assertTrue(formNamElement.isDisplayed(), "formNamElement is not displayed"); //1st Validation
		
		assertTrue(formNamElement.isEnabled(), AddressofCustomerValue_fieldset);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
