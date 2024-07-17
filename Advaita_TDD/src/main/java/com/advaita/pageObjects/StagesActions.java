package com.advaita.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;

public class StagesActions extends TestBase{
	public StagesActions()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[text()='Workflow Design']")
	WebElement workFlowDesign;
	
	@FindBy(xpath="//button[text()='Stages']")
	WebElement stagesTab;
	
	@FindBy(xpath="//img[@title='Evaluation Fields']")
	WebElement evaluationFields;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement evaluationMultiSearch;
	
	@FindBy(xpath="//select[@id='multiselect']")
	WebElement evaluationFromMultiSelectDropdown;
	
	@FindBy(xpath="//select[@id='multiselect_to']")
	WebElement evaluationToMultiSelectDropdown;
	
	@FindBy(xpath="//button[@id='multiselect_rightAll']")
	WebElement allRightButton;
	
	@FindBy(xpath="//button[@id='multiselect_rightSelected']")
	WebElement singleRightButton;
	
	@FindBy(xpath="//button[@id='multiselect_leftSelected']")
	WebElement singleLeftButton;
	
	@FindBy(xpath="//button[@id='multiselect_leftAll']")
	WebElement allLeftButton;
	
	@FindBy(xpath="//button[@id='moveUp']")
	WebElement moveUp;
	
	@FindBy(id="moveDown")
	WebElement moveDown;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancel;
	
	
	
	
	
	@FindBy(xpath="//img[@title='Stage History Fields']")
	WebElement stageFields;
	
	@FindBy(xpath="//img[@title='Evulation Filter']")
	WebElement evaluationFilter;
	
	@FindBy(xpath="//img[@title='Disposition']")
	WebElement dispositionAction;
	
	@FindBy(xpath="//img[@title='SOP']")
	WebElement sop;
	
	@FindBy(xpath="//img[@title='Report Fields']")
	WebElement reportsFields;
	
	@FindBy(xpath="//img[@title='Schduler Filters']")
	WebElement schedulerFilters;
	
	@FindBy(xpath="//img[@title='Stage Process Fields']")
	WebElement stageProcesFields;
	
	@FindBy(xpath="//img[@title='Report Filters']")
	WebElement reportFilters;
	
	@FindBy(xpath="//img[@title='Assign To Filter']")
	WebElement assignToFilters;
	
	
	public StagesActions navtoStages()
	{
		workFlowDesign.click();
		stagesTab.click();
		return this;
	}
	
	
	public void clickOnByRecord(String recordName,WebElement element)
	{
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (recordName.equals(usernameColumn.getText()) ) {

				WebElement button = row.findElement((By) element);
				button.click();
//				roleTableDelete.click();
//				unWait(2);
//				roleContinueButton.click();
				System.out.println(recordName+" Successfully Clicked");
				break;
			}
		}
	}
	
	
	
	
	
}
