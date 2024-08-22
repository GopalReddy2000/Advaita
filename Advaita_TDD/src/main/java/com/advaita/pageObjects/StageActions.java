package com.advaita.pageObjects;

import com.advaita.BaseClass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StageActions extends TestBase {
    public StageActions()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText ="Workflow Design")
    WebElement workFlowDesign;

    @FindBy(xpath ="//button[text()='Stages']")
    WebElement stagesTab;

    @FindBy(xpath ="//img[@alt='delete-icon ']")
    WebElement stageDelete;

    @FindBy(xpath ="//img[@class='img-fluid stages_edit delete-dataset']")
    WebElement stageEdit;

    @FindBy(xpath ="//img[@title='Evaluation Fields']")
    WebElement stageEvaluationFields;

    @FindBy(xpath ="//img[@title='Stage History Fields']")
    WebElement stageHistoryFields;

    @FindBy(xpath ="//img[@title='Evulation Filter']")
    WebElement stageEvaluationFilters;


    public StageActions navigationToStage()
    {
        workFlowDesign.click();
        stagesTab.click();
        return this;
    }




}
