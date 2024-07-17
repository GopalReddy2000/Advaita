package com.advaita.Login.Home;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[normalize-space()='Data Setup']")
	public static WebElement DataSetUpButton;

	@FindBy(xpath = "//h1[normalize-space()='Process Management']")
	public static WebElement processManagementPage;

	@FindBy(id = "pills-Process-tab")
	public static WebElement processTab;

	@FindBy(id = "pills-dataset-tab")
	public static WebElement dataSetTab;

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']")
	public static WebElement workflowDesign;

	@FindBy(xpath = "//h1[normalize-space()='Master Parameter']")
	public static WebElement masterParameterPage;

	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public static WebElement editMeasurableSetButton;

	@FindBy(id = "pills-NonMeasurableSet-tab")
	public static WebElement nonMeasurableSetTab;

	@FindBy(id = "pills-Disposition-tab")
	public static WebElement dispositionTab;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public static void clickOnProcessManagementCreate() {

		click(driver, DataSetUpButton);
		assertTrue(processManagementPage.isDisplayed(), "processManagementPage is not displayed.");
	}

	public void clickOnworkflowDesign() {

		click(driver, workflowDesign);
		assertTrue(masterParameterPage.isDisplayed(), "masterParameterPage is not displayed.");
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

	}

}
