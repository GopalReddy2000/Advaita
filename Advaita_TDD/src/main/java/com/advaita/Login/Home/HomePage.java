package com.advaita.Login.Home;

import com.advaita.BaseClass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class HomePage extends TestBase {


	@FindBy(xpath = "//a[normalize-space()='Data Setup']")
	public WebElement DataSetUpButton;

	@FindBy(xpath = "//h1[normalize-space()='Process Management']")
	public WebElement processManagementPage;

	@FindBy(id = "pills-Process-tab")
	public WebElement processTab;

	@FindBy(id = "pills-dataset-tab")
	public WebElement dataSetTab;

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']")
	public WebElement workflowDesign;

	@FindBy(xpath = "//h1[normalize-space()='Master Parameter']")
	public WebElement masterParameterPage;

	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public WebElement editMeasurableSetButton;

	@FindBy(id = "pills-NonMeasurableSet-tab")
	public WebElement nonMeasurableSetTab;

	@FindBy(id = "pills-Disposition-tab")
	public WebElement dispositionTab;
	
	@FindBy(xpath = "(//button[normalize-space()='Masters'])[1]")
	public WebElement mastersTabElement;
	
	@FindBy(xpath = "//a[text()='+ Add Disposition']")
	public WebElement dispositionCreateButton;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnProcessManagementCreate() {

		click(driver, DataSetUpButton);
//		DataSetUpButton.click();
		assertTrue(processManagementPage.isDisplayed(), "processManagementPage is not displayed.");
	}

	public void clickOnworkflowDesign() {

		click(driver, workflowDesign);
		assertTrue(masterParameterPage.isDisplayed(), "masterParameterPage is not displayed.");
	}
	public void clickOnMaster() {
		
		click(driver, workflowDesign);
		assertTrue(masterParameterPage.isDisplayed(), "masterParameterPage is not displayed.");
		click(driver, mastersTabElement);
		
	}

	public void clickOnEditMeasurableSet() {

		click(driver, workflowDesign);
		assertTrue(masterParameterPage.isDisplayed(), "masterParameterPage is not displayed.");
		click(driver, editMeasurableSetButton);
	}

	public void clickOnNonMeasurableSet() {

		click(driver, workflowDesign);
		assertTrue(masterParameterPage.isDisplayed(), "masterParameterPage is not displayed.");
		click(driver, nonMeasurableSetTab);

	}

	public void clickOnDisposition() {

		click(driver, workflowDesign);
		assertTrue(masterParameterPage.isDisplayed(), "masterParameterPage is not displayed.");
		click(driver, dispositionTab);
		click(driver, dispositionCreateButton);

	}

}
