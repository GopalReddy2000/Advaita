package com.advaita.pageObjects;

import com.advaita.BaseClass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.*;

public class SamplingPlanAndGenerationPage extends TestBase {

    public SamplingPlanAndGenerationPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Sampling Plan & Generation")
    WebElement samplingPlanAndGeneration;

    @FindBy(linkText = "+ Create")
    WebElement create;

    @FindBy(id = "process")
    WebElement processDropdown;

    @FindBy(id = "sub_process")
    WebElement subProcessDropdown;

    @FindBy(id = "s_sub_process")
    WebElement subSubProcessDropdown;

    @FindBy(id = "stage_name_id")
    WebElement stagesDropdown;

    @FindBy(id = "meta_dataset_id")
    WebElement metadataDropdown;

    @FindBy(name = "sampling_plan_name")
    WebElement samplingPlanName;

    @FindBy(xpath = "//input[@id='sampling_from_date']")
    WebElement samplingPlanFromDate;

    @FindBy(xpath = "//input[@id='sampling_to_date']")
    WebElement samplingPlanToDate;

    @FindBy(xpath = "//select[@name='sampling_to']")
    WebElement samplingToDropdown;

    @FindBy(name = "total_call_data_req")
    WebElement totalDataCalls;

    @FindBy(xpath = "//label[@for='consider_allocated']//span")
    WebElement considerAllocatedData;

    @FindBy(xpath = "//label[@for='consider_audited']//span")
    WebElement considerAuditedData;

    @FindBy(xpath = "//label[@for='is_all_sample']//span")
    WebElement allSample;

    @FindBy(xpath = "//button[text()='Next' and @data-info='conditional']")
    WebElement nextForConditional;

    @FindBy(xpath = "//select[contains(@id,'metadata_field')]")
    List<WebElement> fieldDropdown;

    @FindBy(xpath = "//select[contains(@name,'condition_type')]")
    List<WebElement> conditionDropdown;

    @FindBy(xpath = "//input[contains(@id,'select_val')]//parent::div[not(contains(@style,'display'))]//input")
    List<WebElement> conditionTextInputFields;

    @FindBy(xpath = "//select[contains(@id,'equal_and_not_equal')]")
    List<WebElement> equalAndNoEqualDropdown;

    @FindBy(xpath = "//div[@style='display:block !important']//select[contains(@id,'dropdown_val')]")
    WebElement dropdownInputs;

    @FindBy(xpath = "//img[@alt='arrow-left']")
    List<WebElement> deleteButton;

    @FindBy(xpath = "//h2[text()='Add Row']")
    WebElement addRow;

    @FindBy(xpath = "//button[text()='Next' and @data-info='Scheduling']")
    WebElement nextForScheduling;

    @FindBy(xpath = "//button[text()='Previous' and @data-info='conditional']")
    WebElement conditionalPrevious;

    @FindBy(xpath = "//select[@name='schedule_type']")
    WebElement ScheduleTypeDropdown;

    @FindBy(xpath = "//input[@name='schedule_time']")
    WebElement ScheduleTimeInput;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement save;

    @FindBy(xpath = "//button[text()='Previous' and @data-info='Scheduling']")
    WebElement schedulingPrevious;

    @FindBy(xpath = "(//button[text()='Cancel'])[1]")
    WebElement cancel;

    public SamplingPlanAndGenerationPage navToCreate()
    {
        navigateWithinAlchemy(samplingPlanAndGeneration);
        create.click();
        return this;
    }

    public SamplingPlanAndGenerationPage createSampling(String process,String subProcess,String subSubprocess,
                                                        String Stages,String samplingPlaneName,
                                                        String fromDate,String toDate,String samplingTo,
                                                        String totalDataCall,String allSampleCondition,
                                                        String needCondition,String needScheduling)
    {
        selectByVisibleText(processDropdown,process);
        selectByVisibleText(subProcessDropdown,subProcess);
        selectByVisibleText(subSubProcessDropdown,subSubprocess);
        selectByVisibleText(stagesDropdown,Stages);

        samplingPlanName.sendKeys(samplingPlaneName);
        js.executeScript("arguments[0].value = arguments[1];", samplingPlanFromDate, fromDate);
        js.executeScript("arguments[0].value = arguments[1];", samplingPlanToDate, toDate);
//        samplingPlanFromDate.sendKeys(fromDate);
//        samplingPlanToDate.sendKeys(toDate);

        selectByVisibleText(samplingToDropdown,samplingTo);

        totalDataCalls.sendKeys(totalDataCall);
        try {
            if (allSampleCondition.equals("yes")) {
                considerAllocatedData.click();
                considerAuditedData.click();
                allSample.click();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if(needCondition.equalsIgnoreCase("yes"))
        {
//            createSamplingConditions("") ;
//            Xpath are not working proper
        } else if (needScheduling.equalsIgnoreCase("yes")) {
            //            Xpath are not working proper

        }
        else {
            nextForConditional.click();
            nextForScheduling.click();
            save.click();
        }
        try
        {
            unWait(1);
            assertTrue (continueButton.isDisplayed(),"Continue Button is not visible");
            System.out.println("Sample is Generated Successfully");

            continueButton.click();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }




        return this;
    }

    public SamplingPlanAndGenerationPage equalsAndNotEquals(String fieldSelect,String conditionSelect)
    {
        selectByVisibleText(fieldDropdown.get(0),fieldSelect);
        selectByVisibleText(conditionDropdown.get(0),conditionSelect);

        return this;
    }


    public SamplingPlanAndGenerationPage createSamplingConditions(String conditionDropdowns,String equalsOrNotEqualsCondition)
    {
        nextForConditional.click();
        selectByVisibleText(fieldDropdown.get(0),"");
        selectByVisibleText(conditionDropdown.get(0),"");
        switch (conditionDropdowns)
        {
            case "equals":
            case "not equals":
                selectByVisibleText(equalAndNoEqualDropdown.get(0),equalsOrNotEqualsCondition);
                if (equalsOrNotEqualsCondition.equals("textBox")){
                    conditionTextInputFields.get(0).sendKeys();
                }
                if (equalsOrNotEqualsCondition.equals("dropdown"))
                {

                }
                break;
            case "greater than":
            case "greater than equal to":
            case "lesser than":
            case "lesser tha or equal to":
            case "date":
            case"date between":
                conditionTextInputFields.get(0).sendKeys(); break;
            case "dropdown":
                conditionDropdown.get(0).sendKeys();
            case"multiselect":




        }




        return this;
    }
    public SamplingPlanAndGenerationPage createSamplingScheduling()
    {

        return this;
    }

}
