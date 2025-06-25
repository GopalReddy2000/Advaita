package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;

public class ReferPreviousStagePage extends TestBase {
    public ReferPreviousStagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Data Setup']")
    WebElement dataSetup;

    @FindBy(xpath = "//button[text()='Data Upload']")
    WebElement dataUpload;

    @FindBy(xpath = "//button[text()='Refer Previous Stage']")
    WebElement referPreviousStage;

    @FindBy(linkText = "+ Create")
    WebElement create;

    @FindBy(id = "id_upload_name")
    WebElement uploadName;

    @FindBy(xpath = "//select[@id='id_dataset']")
    WebElement dataSet;

    @FindBy(xpath = "//select[@id='id_stage_name']")
    WebElement stage;

    @FindBy(xpath = "//input[@id='id_from_date']")
    WebElement fromDate;

    @FindBy(xpath = "//input[@id='id_to_date']")
    WebElement toDate;

    @FindBy(xpath = "//input[@id='allow_duplicates']")
    WebElement allowDuplicates;

    @FindBy(id = "formSubmit")
    WebElement createRecord;

    @FindBy(css = "button.btn-secondary.ml_12.text_black")
    WebElement cancel;

    @FindBy(id = "text_search")
    WebElement searchBox;

    @FindBy(xpath = "//img[@class='img-fluid' and @alt='filter_search']")
    WebElement searchIcon;

    @FindBy(css = "img.filter_search")
    WebElement clearAllFilter;

    @FindBy(xpath = "//img[@alt='delete-icon ']")
    List<WebElement> delete;

    @FindBy(xpath = "//img[@alt='table-edit' and contains(@class,'edit')]")
    List<WebElement> edit;

    @FindBy(xpath = "//img[@class='img-fluid cursor-pointer']")
    List<WebElement> history;


    @FindBy(xpath = "//span[text()='Workflow Design']")
    WebElement workflowDesign;

    @FindBy(xpath = "//button[text()='Stages']")
    WebElement stages;

    @FindBy(xpath = "//img[@title='Stage To Dataset Mapping']")
    WebElement stageToDatasetMapping;

    @FindBy(xpath = "//tr//td[1]")
    List<WebElement> datasetRows;

    @FindBy(xpath = "//table[contains(@class,'hard_inte_table')]//td[1]")
    List<WebElement> dataSetFields;

    @FindBy(xpath = "//table[contains(@class,'hard_inte_table')]//select")
    List<WebElement> stageFields;

    @FindBy(xpath = "//select[@id='stage_refer_mapping']")
    WebElement uploadNameDropdown;

    @FindBy(xpath = "//button[text()='Add']")
    WebElement add;

    @FindBy(linkText = "Call Log Stage View")
    WebElement callLogStageView;

    @FindBy(xpath = "//select[@id='stage_search']")
    WebElement stageDropdown;

    @FindBy(xpath = "//td[4]")
    List<WebElement> recordName;

    @FindBy(xpath = "//td//img[@alt='table-edit']")
    List<WebElement> recordEyeButton;

    @FindBy(xpath = "//button[text()='Metadata']")
    WebElement metadata;

    @FindBy(xpath = "//tbody[@class='row_fields data_rec_apnd ']//td[1]")
    List <WebElement> metadataNames;

    @FindBy(xpath = "//table[@class='w-100']//td[1]")
    List <WebElement> dataUploadNames;

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteConfirm;


    /**
     * This Method is for Navigating the User to Refer Previous Stage Page
     * @return
     */
    public ReferPreviousStagePage navToReferPreviousStage()
    {
        dataSetup.click();
        dataUpload.click();
        referPreviousStage.click();
        return this;
    }

    /**
     * @param uploadRecordName Enter a Record Name for referPreviousStage Name
     * @param datasetName Dataset to be selected for mapping with stages
     * @param StageName Stages to be selected to dispose the data to dataset
     * @param fromDateText date for the data uploaded for the previous Stage
     * @param toDateText
     * @param datasetFieldName This is a List of individual Dataset fields in the dataset to be mapped with stages dataset
     * @param stageOption Stages dataset dropdown list to be mapped with dataset.
     * @return
     */
    public ReferPreviousStagePage createRecord(String uploadRecordName,String datasetName,
                                               String StageName,String fromDateText,
                                               String toDateText,List<String> datasetFieldName,
                                               List<String> stageOption)
    {
        create.click();
        uploadName.sendKeys(uploadRecordName);//Name
        selectByVisibleText(dataSet,datasetName);//Dataset James
        selectByVisibleText(stage,StageName);//"Booking Information Stage"
        jsDateExecutor(fromDate,fromDateText);//"01-09-2024"
        jsDateExecutor(toDate,toDateText);//"25-09-2024"

        click(driver,toDate);
        allowDuplicates.click();
        unWait(1);
        selectStageForDataset(datasetFieldName,stageOption);
        createRecord.click();
        unWait(1);
        continueButton.click();
        return this;
    }

    public ReferPreviousStagePage selectStageForDataset(List<String> datasetFieldNames, List<String> stageOptions) {
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'hard_inte_table')]/tbody/tr"));

        // Create a map to store dataset field names and their corresponding rows
        Map<String, WebElement> datasetFieldToRowMap = new HashMap<>();

        // Populate the map with dataset fields and their respective rows
        for (WebElement row : rows) {
            try {
                WebElement datasetField = row.findElement(By.xpath("./td[1]"));
                datasetFieldToRowMap.put(datasetField.getText().trim(), row);
            } catch (NoSuchElementException e) {
                System.out.println("Dataset field not found in this row: " + e.getMessage());
            }
        }

        // Iterate through dataset field names and their corresponding stage options
        for (int i = 0; i < datasetFieldNames.size(); i++) {
            String datasetFieldName = datasetFieldNames.get(i);
            String stageOption = stageOptions.get(i);

            // Find the row for the dataset field name
            WebElement matchingRow = datasetFieldToRowMap.get(datasetFieldName);
            if (matchingRow != null) {
                try {
                    WebElement stageDropdown = matchingRow.findElement(By.xpath(".//td[2]//select"));
                    selectByVisibleText(stageDropdown, stageOption);
                } catch (NoSuchElementException e) {
                    System.out.println("Stage dropdown not found for " + datasetFieldName + ": " + e.getMessage());
                }
            } else {
                System.out.println("No matching dataset field found for: " + datasetFieldName);
            }
        }
        return this;
    }


    public ReferPreviousStagePage datasetMapping(String stage, String dataset)
    {
        workflowDesign.click();
        stages.click();
        searchBox.sendKeys(stage);
        searchIcon.click();
        stageToDatasetMapping.click();
        stageToDataset(dataset);
        return this;
    }

    public ReferPreviousStagePage stageToDataset(String dataset) {
        boolean isDatasetFound = false;

        try {
            // Iterate through the dataset rows to find a match
            for (WebElement row : datasetRows) {
                if (row.getText().equals(dataset)) {
                    backButton.click();
                    isDatasetFound = true;  // Set flag to true if dataset is found
                    break;  // Break out of the loop once the dataset is found
                }
            }

            // If dataset is not found, go to the else block equivalent
            if (!isDatasetFound) {
                selectByVisibleText(uploadNameDropdown, dataset);
                add.click();
                unWaitInMilli(500);  // Consider replacing with WebDriverWait for better synchronization
                continueButton.click();
                unWaitInMilli(500);
                jsClick(backButton);
            }

        } catch (NoSuchElementException e) {
            System.out.println("Dataset not found: " + e.getMessage());
        }


        // Perform final back button click
//        backButton.click();

        return this;
    }

    String expectedDataName;
    public ReferPreviousStagePage disposeData(String stageName,int number){
        navigateWithinAlchemy(callLogStageView);
        selectByVisibleText(stageDropdown,stageName);

        expectedDataName =recordName.get(number).getText();
        jsClick(recordEyeButton.get(number));
        System.out.println(expectedDataName);
        saveRecord();
        return this;
    }
    String actualDataName;
    public ReferPreviousStagePage validateData(String metadataName)
    {
        navToReferPreviousStage();
        metadata.click();
        searchBox.sendKeys(metadataName);
        searchIcon.click();
        recordEyeButton.get(0).click();
//        actualDataName = (String) js.executeScript("return arguments[0].textContent;", metadataNames.get(metadataNames.size() - 1));
//        System.out.println("Actual Data Name using JavaScript: " + actualDataName);
        unWait(1);
        actualDataName = metadataNames.get((metadataNames.size()) - 1).getText();
        System.out.println(actualDataName);
        assertEquals(expectedDataName,actualDataName);
        return this;
    }

    public ReferPreviousStagePage editRecord(String recordName)
    {
        List <WebElement> rows = driver.findElements(By.xpath("//table[@class='w-100']//tbody//tr"));
        for (WebElement row : rows)
        {
            WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));
            if(usernameColumn.getText().equals(recordName)){
                WebElement editButton= row.findElement(By.xpath(".//img[contains(@class,'edit-dataupload')]"));
                jsClick(editButton);
                break;
            }
        }
        return this;
    }

    public ReferPreviousStagePage rename(String rename)
    {

        sendKeys(uploadName,rename);
        createRecord.click();
        unWaitInMilli(500);
        continueButton.click();

        return this;
    }

    private String getFirstSelectedOption(WebElement element)
    {
        Select dropdown = new Select(element);

        WebElement firstSelectedOption = dropdown.getFirstSelectedOption();

        return firstSelectedOption.getText();
    }

    private List<String> getTextFromElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>();

        for (WebElement element : elements) {
            textList.add(element.getText().trim());  // Add element text to list, trimming whitespace
        }

        return textList;  // Return the list of element texts
    }

    public ReferPreviousStagePage editDataset()
    {
        String initialDatasetSelectedOption= getFirstSelectedOption(dataSet);
        String initialStageSelectedOption= getFirstSelectedOption(stage);

        int initialDatasetFieldSize= dataSetFields.size();

        List<String> initialDatasetList= getTextFromElements(dataSetFields);

        selectByVisibleText(dataSet,"EmployeeFive Details");

//        After Editing the Dataset

        String editedDatasetSelectedOption= getFirstSelectedOption(dataSet);
        String editedStageSelectedOption= getFirstSelectedOption(stage);

        List<String> editedDatasetList= getTextFromElements(dataSetFields);

        System.out.println("InitialDataset Options :"+initialDatasetSelectedOption);
        System.out.println("EditedDataset Options :"+editedDatasetSelectedOption);
        System.out.println("initialStageSelectedOption :"+initialStageSelectedOption);
        System.out.println("editedStageSelectedOption :"+editedStageSelectedOption);
        System.out.println("initialDatasetList :"+initialDatasetList);
        System.out.println("editedDatasetList :"+editedDatasetList);

        assertNotEquals(initialDatasetSelectedOption,editedDatasetSelectedOption);
        assertNotEquals(initialStageSelectedOption,editedStageSelectedOption);
        assertNotEquals(initialDatasetList,editedDatasetList);

        int afterDatasetFieldSize= dataSetFields.size();
        assertNotEquals(initialDatasetFieldSize,afterDatasetFieldSize);

        cancel.click();
        return this;
    }

    public ReferPreviousStagePage deleteRecords(String recordName) {
        List<String> expectedListOfRecords=getTextFromElements(dataUploadNames);
        List <WebElement> rows = driver.findElements(By.xpath("//table[@class='w-100']//tbody//tr"));
        for (WebElement row : rows)
        {
            try {

                WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));
                if(usernameColumn.getText().equals(recordName)){
                    WebElement deleteButton = row.findElement(By.xpath(".//img[@alt='delete-icon ']"));
                    jsClick(deleteButton);
                    deleteConfirm.click();
                    unWaitInMilli(500);
                    continueButton.click();
                    System.out.println(expectedListOfRecords);
                    List<String> ActualListOfRecords=getTextFromElements(dataUploadNames);
                    System.out.println(ActualListOfRecords);

                    assertNotEquals(expectedListOfRecords,ActualListOfRecords);

                    break;
                }
            } catch (Exception e) {
                System.out.println("There is No record as such :" + recordName);
            }
        }

        return this;
    }






}
