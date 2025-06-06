package com.advaita.EndToEnd;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.advaita.BaseClass.TestBase;
import com.advaita.WorkFlowDesign.PageObject.Stages;

public class FieldsToMastersPage extends TestBase {

    @FindBy(xpath = "//span[normalize-space()='Workflow Design']")
    public WebElement workFlowStagesTab;

    @FindBy(xpath = "//button[text()='Masters']")
    public WebElement mastersTab;

    @FindBy(xpath = "//button[normalize-space()='Field Sets']")
    public WebElement fieldSets;

    @FindBy(linkText = "+ Add Field Set")
    public WebElement addFieldSets;

    @FindBy(id = "questionSet_name")
    public WebElement questionSet;

    @FindBy(xpath = "//button[text()='Master Forms']")
    public WebElement masterForms;

    @FindBy(linkText = "+ Create")
    public WebElement create;

    @FindBy(xpath = "//input[@id='stage_name']")
    public WebElement formName;

    @FindBy(xpath = "//select[@id='process']")
    public WebElement processDropdown;

    @FindBy(xpath = "//select[@id='sub_process']")
    public WebElement subProcessDropdown;

    @FindBy(xpath = "//select[@id='s_sub_process']")
    public WebElement subSubProcessDropdown;

    @FindBy(xpath = "//div[@id='collapseOne']//a[not(contains(@class,'mr')) and text()='Add']")
    public WebElement primarySectionAdd;

    @FindBy(xpath = "//div[(@class='w-100 p-0')]//a[not(contains(@class,'mr')) and text()='Add']")
    public WebElement sectionCAdd;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement formSave;

    @FindBy(xpath = "(//button[text()='Save'])[2]")
    public WebElement menuSave;

    @FindBy(xpath = "//button[@id='finalize_btn']")
    public WebElement formFinalize;

    @FindBy(xpath = "//button[@id='finalizesubmit']")
    public WebElement finalizeSubmit;


    @FindBy(xpath = "//input[@name='section_name']")
    public WebElement sectionNameInput;

    @FindBy(xpath = "//a[contains(@class,'add_section_c') and text()='Add ']")
    public WebElement sectionAdd;


    @FindBy(xpath = "//div[@id='param_ContactSection']//select")
    public WebElement primarySectionQuestionSetDropdown;

    @FindBy(xpath = "//button[text()='Master Menus']")
    public WebElement masterMenus;

    @FindBy(xpath = "//select[@id='master_form']")
    public WebElement masterFormDropdown;

    @FindBy(xpath = "//div[@class='col-md-6']//input")
    public WebElement menuName;




    @FindBy(xpath = "//img[@alt='table-edit' and contains(@title,'View')]")
    public WebElement viewDetails;

    @FindBy(xpath = "//img[@alt='ticket-history']")
    public WebElement ticketHistory;

    @FindBy(xpath = "//img[@alt='assignmnet-history']")
    public WebElement assignmentHistory;

    @FindBy(xpath = "//img[@alt='table-edit' and contains(@title,'Delete')]")
    public WebElement delete;

    @FindBy(xpath = "//img[@alt='table-edit' and contains(@title,'Edit')]")
    public WebElement edit;

    @FindBy(xpath = "//table[@class='table table-striped']//tr/td[1] | //table[@class='table table-striped']//tr/td[3]")
    List<WebElement> viewDetailsDataNames;

    @FindBy(xpath = "//button[@id='closemodalcustomerDetailsPopup']")
    WebElement viewDetailsClose;

    @FindBy(xpath = "//h6[text()='Assign/Reassign']//parent::div")
    WebElement assignReAssign;

    @FindBy(xpath = "//label[normalize-space()='Assign']//span")
    WebElement assignRadioBtn;

    @FindBy(xpath = "//label[normalize-space()='Re assign']//span")
    WebElement reAssignRadioBtn;

    @FindBy(xpath = "//button[@id='dispose_data_from_master_assign_btn']")
    WebElement disposeData;

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteButton;

    @FindBy(id = "question_name_primary_Name")
    WebElement nameInputField;

    @FindBy(id = "question_name_primary_Phone_Number")
    WebElement phoneNumberInput;

    @FindBy(id = "question_name_primary_Address")
    WebElement addressInput;

    @FindBy(name = "question_name_primary_Name")
    WebElement nameField;

    @FindBy(name = "question_name_primary_Phone_Number")
    WebElement phoneNumber;

    @FindBy(name = "question_name_primary_Address")
    WebElement address;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancel;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submit;





    public FieldsToMastersPage()
    {
        PageFactory.initElements(driver,this);
    }


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

    private static WebElement sectionCDropdown(String sectionName) {
        String xpath = "//select[@name='sectionval_Mesaurable_value_"+sectionName+"']";
        return driver.findElement(By.xpath(xpath));
    }
    private static WebElement primarySectionDropdown(String sectionName) {
        String xpath = "//div[@id='param_"+sectionName+"']//select";
        return driver.findElement(By.xpath(xpath));
    }

    private static WebElement singleOrMultiple(String sectionName) {
        String xpath = "//input[contains(@id,'sectionkeytype_"+sectionName+"')]//following-sibling::span";
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

    private WebElement nonMeasurableDropdowns(String name) {
        String xpath = "//label[text()='"+name+"']/following-sibling::select";

        return driver.findElement(By.xpath(xpath));
    }

    private WebElement nonMeasurableRadioButton(String name) {
        String xpath = "//div[@id='pills-"+name+"']//label[normalize-space()='Non Measurable Set']//span";

        return driver.findElement(By.xpath(xpath));
    }

    private WebElement nonMeasurableDropdownQuestionDropdown(String name) {
        String xpath = "//div[@id='pills-"+name+"']//select[contains(@name,'NonMesaurable')]";

        return driver.findElement(By.xpath(xpath));
    }

    private WebElement nonMeasurableDropdownQuestions(String sectionName,String QuestionName) {
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

    private WebElement maxDateDropdown(int section,int Question) {
        String xpath = "//select[@name='date_settings_maxdate_"+section+"_"+Question+"']";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement minDateDropdown(int section,int Question) {
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

    private WebElement maxTimeInput(int section,int Question) {
        String xpath = "//input[contains(@name,'maxtime_input_"+section+"_"+Question+"')]";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement minTimeInput(int section,int Question) {
        String xpath = "//input[contains(@name,'mintime_input_"+section+"_"+Question+"')]";
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


    private WebElement maxDateError(int section,int Question) {
        String xpath = "//div[@class='max_date_error_"+section+"_"+Question+"']";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement minDateError(int section,int Question) {
        String xpath = "//div[@class='min_date_error_"+section+"_"+Question+"']";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement selectStageTabs(String stageName) {
        String xpath = "//button[contains(text(),'"+stageName+"')]";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement datasetMaxLength(int section,int question) {
        String xpath = "//input[contains(@name,'section_max_length_"+section+"_"+question+"')]";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement datasetIsMandatory(int section,int question) {
        String xpath = "//input[contains(@name,'mandatory_"+section+"_"+question+"')]/following-sibling::span";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement sectionTab(String sectionName) {
        String xpath = "//button[text()='"+sectionName+"']";
        return driver.findElement(By.xpath(xpath));
    }




    public void ToggleButton( WebElement toggleButton,String Action) {
        if(Action.equals("yes")) {
            jsClick(toggleButton);
        }
    }

    public FieldsToMastersPage addQuestion(int section)
    {
        String xpath= "//div[@data-info='question-"+section+"-1']//following-sibling::div//a[not(text()='Add Option')]";
        jsClick(driver.findElement(By.xpath(xpath)));
        return this;
    }
    public FieldsToMastersPage addSection()
    {
//        jsClick(driver,addSectionButton);
        return this;
    }

    private FieldsToMastersPage datasetIsMandatory(int section,int question,String isMandatory)
    {
        if(isMandatory.equals("no")){
            jsClick(datasetIsMandatory(section,question));
        }
        return this;
    }

    public FieldsToMastersPage navToFieldTable()
    {
        workFlowStagesTab.click();
        mastersTab.click();
        fieldSets.click();
        return this;
    }
    public FieldsToMastersPage setQuestionName(String questionSetName)
    {
        addFieldSets.click();
        questionSet.sendKeys(questionSetName);
        return this;
    }

    // This Method can be Used for Dropdown,Multiple Choice, Relative Dropdown and Relative MultiSelect.
    public FieldsToMastersPage dropdownAndMultiSelect(int questionType, int section, int question, String questionName,String maxLength, List<String> options, String requiredStatus, String EscalatedStatus, String uploadStatus ) {
        // Enter the question name in the corresponding field
        sendKeys(SetSectionQuestionName(section, question), questionName);

        // Set the question type to dropdown
        setQuestionTypes(section, question, questionType).click();

        sendKeys(datasetMaxLength(section,question),maxLength);

        datasetIsMandatory(section,question,requiredStatus);

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

    public FieldsToMastersPage textBox(int questionType,int section,int question,String questionName,String requiredStatus,String EscalatedStatus,String minLength,String maxLength,String valueType,String allowSpecialChar)
    {
        // Enter the question name in the corresponding field
        sendKeys(SetSectionQuestionName(section, question), questionName);

        // Set the question type to dropdown
        setQuestionTypes(section, question, questionType).click();

        sendKeys(datasetMaxLength(section,question),maxLength);

        datasetIsMandatory(section,question,requiredStatus);

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

    public FieldsToMastersPage shortAnswer(int questionType,
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

    public FieldsToMastersPage fileUpload(int questionType,
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

    public FieldsToMastersPage radioButton(int questionType,
                                           int section,
                                           int question,
                                           String questionName,
                                           String maxLength,
                                           String requiredStatus,
                                           String EscalatedStatus,
                                           List<String>options
    )
    {
        // Enter the question name in the corresponding field
        sendKeys(SetSectionQuestionName(section, question), questionName);

        // Set the question type to dropdown
        setQuestionTypes(section, question, questionType).click();

        sendKeys(datasetMaxLength(section,question),maxLength);

        datasetIsMandatory(section,question,requiredStatus);

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

    public FieldsToMastersPage date(int questionType,
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

        selectByVisibleText(maxDateDropdown(section,question),maxDate);
        sendKeys( maxDateInput(section,question),maxdateinput);
        selectByVisibleText(minDateDropdown(section,question),minDate);
        sendKeys( minDateInput(section,question),mindateinput);
        if(defaultDate==1)
        {
            defaultDate(section,question).click();
        }

        return this;
    }

    public FieldsToMastersPage time(int questionType,
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

    public FieldsToMastersPage navToMasterFormsTable()
    {
        workFlowStagesTab.click();
        mastersTab.click();
        masterForms.click();
        return this;
    }


    public FieldsToMastersPage createMasterForms(String formNames,String process,String subProcess,
                                                 String subSubProcess,
                                                 String primarySectionName,String primarySectionDropdown)
    {

        create.click();
        formName.sendKeys(formNames);
        selectByVisibleText(processDropdown,process);
        unWaitInMilli(500);
        selectByVisibleText(subProcessDropdown,subProcess);
        unWaitInMilli(500);
        selectByVisibleText(subSubProcessDropdown,subSubProcess);
        unWaitInMilli(500);


        primarySectionAdd.click();

        sectionNameInput.sendKeys(primarySectionName);
        unWaitInMilli(500);
        sectionAdd.click();
        sectionTab(primarySectionName).click();
        selectByVisibleText(primarySectionDropdown(primarySectionName), primarySectionDropdown);


        return this;
    }

    public FieldsToMastersPage addSectionC(String SectionCName,String sectionCDropdownValue)
    {
        unWaitInMilli(500); // Adjust the timing as needed
        js.executeScript("window.scrollBy(0, 500);");


        jsClick(sectionCAdd);
        sectionNameInput.sendKeys(SectionCName);
        unWaitInMilli(300);
        sectionAdd.click();
        sectionTab(SectionCName).click();
        singleOrMultiple(SectionCName).click();
        selectByVisibleText(sectionCDropdown(SectionCName),sectionCDropdownValue);

        return this;
    }

    public FieldsToMastersPage formSaveAndFinalize()
    {
        unWaitInMilli(500);
        jsClick(formSave);
        jsClick(formFinalize);

        unWaitInMilli(300);
        finalizeSubmit.click();
        unWaitInMilli(300);
        continueButton.click();

        return this;
    }

    Stages stages=new Stages();

    // List of inputs to select the corresponding checkboxes
    List<String> checkboxInputs = Arrays.asList("Name of the Student (Student Information)", "Roll Number of the Student (Student Information)", "Date Of Birth (Student Information)");  // Replace with actual values
    List<String> actionCheckBox = Arrays.asList("Voice Call", "Recording", "Email");  // Replace with actual values
    String viewCheckBox[] = { "all" };


    public FieldsToMastersPage stagesSetup(String stageName, String processValue,String subProcess,
                                           String subSubProcess, String sectionBDropdownValue,List<String> inputs,
                                           String... optionNames)
    {

        stages.navToCreatePage()
                .stageNameAndProcess(stageName,processValue,subProcess,subSubProcess)
                .selectCheckBoxSectionB(sectionBDropdownValue,inputs)
                .actionSection(optionNames)
                .clickOnManual()

        ;
        saveRecord();
        unWaitInMilli(300);
        backButton.click();

        return this;
    }



    @FindBy(xpath="//button[@id='create_master_menu_btn']")
    WebElement mastersCreate;

    private WebElement addMasters(String masterName)
    {
        String xpath="//a[text()='Add "+masterName+"']";
        return driver.findElement(By.xpath(xpath));

    }

    private WebElement viewModifyMasters(String masterName)
    {
        String xpath="//a[text()='View/Modify "+masterName+"']";
        return driver.findElement(By.xpath(xpath));

    }

    public FieldsToMastersPage masterMenuSetup()
    {
        workFlowStagesTab.click();
        mastersTab.click();
        masterMenus.click();

        jsClick(mastersCreate);
        selectByVisibleText(masterFormDropdown,"Form Test");
        menuName.sendKeys("TestMasters");
        menuSave.click();

        return this;
    }



    public FieldsToMastersPage assertViewModifyPageElements()
    {
        navigateWithinMasters(viewModifyMasters("Bhuvana Qset"));
        assert edit.isDisplayed();
        assert delete.isDisplayed();
        assert assignmentHistory.isDisplayed();
        assert viewDetails.isDisplayed();
        assert ticketHistory.isDisplayed();


        return this;
    }

    public FieldsToMastersPage addMasters(String Name,String PhoneNumber,String Address)
    {
        navigateWithinMasters(addMasters("Bhuvana Qset"));
        sendKeys(nameField,Name);
        sendKeys(phoneNumber,PhoneNumber);
        sendKeys(address,Address);
        assert cancel.isDisplayed();
        assert submit.isDisplayed();

        submit.click();

        unWaitInMilli(300);
        assert continueButton.isDisplayed();
        continueButton.click();

        return this;
    }



    public FieldsToMastersPage deleteMasterRecord(String usernameToDoAction )
    {
        navigateWithinMasters(viewModifyMasters("Bhuvana Qset"));

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rows) {

            WebElement usernameColumn = row.findElement(By.xpath("./td[2]"));
            try {
                if (usernameToDoAction.equals(usernameColumn.getText())) {

                    WebElement delete = row.findElement(By.xpath(".//img[@alt='table-edit' and contains(@title,'Delete')]"));
                    delete.click();
                    deleteButton.click();
                    unWait(1);
                    Assert.assertTrue(continueButton.isDisplayed());
                    continueButton.click();
                    System.out.println(usernameToDoAction + " Successfully Deleted");
                    break;

                }else {
                    System.out.println(usernameToDoAction+" Is not Found");
                }
            }catch (NoSuchElementException e)
            {
                System.out.println(e.getMessage());
            }
        }

        return this;
    }


    public FieldsToMastersPage editMasterRecord(String usernameToDoAction, String editName,String editPhoneNumber,String editAddress )
    {
        navigateWithinMasters(viewModifyMasters("Bhuvana Qset"));

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rows) {

            WebElement usernameColumn = row.findElement(By.xpath("./td[2]"));
            try {
                if (usernameToDoAction.equals(usernameColumn.getText())) {

                    WebElement edit = row.findElement(By.xpath(".//img[@alt='table-edit' and contains(@title,'Edit')]"));
                    edit.click();

                    System.out.println(usernameToDoAction + " Successfully Deleted");
                    break;

                }else {
                    System.out.println(usernameToDoAction+" Is not Found");
                }
            }catch (NoSuchElementException e)
            {
                System.out.println(e.getMessage());
            }
        }
        sendKeys(nameInputField,editName);
        sendKeys(phoneNumberInput,editPhoneNumber);
        sendKeys(addressInput,editAddress);
        assert submit.isDisplayed();
        assert cancel.isDisplayed();

        submit.click();

        return this;
    }

    public FieldsToMastersPage validateRecordsPerPage() {

        navigateWithinMasters(viewModifyMasters("Bhuvana Qset"));

        // Define options to test (10, 20, 50 records per page)
        int[] optionsToTest = {10, 20, 50};

        for (int option : optionsToTest) {
            // Re-fetch the dropdown each time before interacting
            WebElement dropdown = driver.findElement(By.xpath("//select[@id='page-size-select']"));
            Select select = new Select(dropdown);

            // Scroll the dropdown into view
            jsWindowsScrollIntoView(dropdown);

            // Select the dropdown value
            select.selectByVisibleText(String.valueOf(option));

            // Wait for the page to load/refresh after selection (use explicit wait instead of sleep)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='show_entries m-0 font_13']")));

            // Fetch the "Showing X to Y of Z" text
            WebElement showingTextElement = driver.findElement(By.xpath("//p[@class='show_entries m-0 font_13']"));
            String showingText = showingTextElement.getText();

            // Extract the 'Showing 1 to X of Y' parts
            String[] showingParts = showingText.split(" ");
            int firstRecord = Integer.parseInt(showingParts[1]);
            int lastRecord = Integer.parseInt(showingParts[3]);
            int totalRecords = Integer.parseInt(showingParts[5]);

            System.out.println("Records Displayed: From " + firstRecord + " to " + lastRecord + " of " + totalRecords);

            // Fetch the list of records currently displayed
            List<WebElement> records = driver.findElements(By.xpath("//td[2]"));
            System.out.println("Number of records displayed on the page: " + records.size());

            // Validate the number of records displayed on the current page
            if (records.size() <= option) {
                System.out.println("Validation passed: Number of records per page is correct.");
            } else {
                System.out.println("Validation failed: Number of records per page is incorrect.");
            }

            // Validate if the last page has fewer records
            if (lastRecord == totalRecords && records.size() == lastRecord - firstRecord + 1) {
                System.out.println("Validation passed for the last page: Fewer records as expected.");
            }

        }
        return this;
    }


    final int label=1;
    final int multipleChoice=2;
    final int shortAnswer=3;
    final int dropDown=4;
    final int relativeDropdown=5;
    final int fileUpload=6;
    final int radioButton=7;
    final int date=8;
    final int time=9;
    final int textBox=10;
    final int relativeMultiselect=11;



    public FieldsToMastersPage fromFieldsToMasters()
    {
        navToFieldTable()
            .setQuestionName("")
            .textBox(textBox,1,1,"Name of the Customer","no","no","1","100","All","yes")
            .addQuestion(1)
            .textBox(textBox,1,2,"Location","no","no","1","100","All","yes")

            .saveRecord1()
            .back();

    ;


        return this;
    }



    public FieldsToMastersPage saveRecord1()
    {
        saveRecord();
        return this;
    }
    public FieldsToMastersPage back()
    {
        jsClick(backButton);
        return this;
    }




}
