package com.advaita.pageObjects;

import com.advaita.BaseClass.TestBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CallLogTabView extends TestBase {
    public CallLogTabView()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Call Log Tab View")
    WebElement callLogTabView;

    @FindBy(id="menulist2")
    WebElement alchemy;

    @FindBy(xpath ="//button[contains(normalize-space(), 'Insurance Stage')]")
    WebElement insuranceStage;

    @FindBy(xpath  ="//td//img[@alt='table-edit']")
    List<WebElement> recordEyeButton;

    @FindBy(css  ="img.arrow-left")
    WebElement backButton;

    EscalationMatrixPage escalationMatrixPage=new EscalationMatrixPage();



    public CallLogTabView navigation(){
        navigateWithinAlchemy(callLogTabView);
        insuranceStage.click();

        try{
            jsClick(recordEyeButton.get(recordEyeButton.size() -1));
            backButton.click();

        }catch (NoSuchElementException e)
        {
            escalationMatrixPage.assignRecord();
        }

        return this;
    }



}
