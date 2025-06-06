package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advaita.BaseClass.TestBase;
import com.advaita.DataSetUp.PageObject.ProcessPage;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.CommonUtils;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.UploadFile;

import Advaita_TDD.Advaita_TDD.DynamicXpath;
import Advaita_TDD.Advaita_TDD.FakeData;

public class MasterFormPage extends TestBase {

	public static final String masterURL = mainURl+"en/masters/masters_question_sets/";

	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	public String createPageUrl = mainURl + "en/masters/create_master_forms/";
	public String processName = "P " + FakeData.lastName2();
	public String processDesc = "P Desc";
	public String subProcessName = "SP" + FakeData.lastName2();
	public String subProcessDesc = "SP Desc";
	public String subSubProcessName = "SSP " + FakeData.lastName2();
	public String subSubProcessDesc = "SSP Desc";

	public String metaDataName = "Test " + FakeData.lastName2();

	public final static String formName = "FN " + FakeData.lastName2();
	public final static String FieldName1 = "FN " + FakeData.lastName2();
	public final static String FieldName2 = "FN " + FakeData.lastName2();

	public static String fetchProcessRecord;
	public static String fetchSubProcessRecord;
	public static String fetchSubSubProcessRecord;
	public static String fetchMetaDataRecord;

	public static String fetchFieldSetRecord;
	public static String fetchFieldSetRecord2;

	@FindBy(xpath = "//span[normalize-space()='Data Setup']")
	public static WebElement DataSetUpButton;

	@FindBy(id = "pills-dataset-tab")
	public static WebElement dataSetTabButton;

	@FindBy(id = "pills-metadata-tab")
	public static WebElement metaDataTabButton;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td//div[contains(@class, 'content')]//span[contains(@class, 'first_tree')]")
	public static WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td//div[contains(@class, 'content')]//span[contains(@class, 'second_tree')]")
	public static WebElement dropDown2;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td//div[contains(@class, 'content')]//span[contains(@class, 'first_tree')]")
	public static WebElement fetchProcess;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td//div[contains(@class, 'content')]//span[contains(@class, 'second_tree')]")
	public static WebElement fetchsubProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[3]")
	public static WebElement fetchsubSubProcess;

	@FindBy(xpath = "(//button[normalize-space()='Masters'])[1]")
	public static WebElement masterTabElement;

	@FindBy(id = "pills-MasterForms-tab")
	public static WebElement masterFormTabElement;

	@FindBy(id = "pills-MasterQuestionSet-tab")
	public static WebElement fieldSetTabElement;

	@FindBy(linkText = "+ Add Field Set")
	public static WebElement addFieldSetButton;

	@FindBy(xpath = "//h2[normalize-space()='Create Master Field Set']")
	public static WebElement createMasterFieldSetPage;

	@FindBy(id = "questionSet_name")
	public static WebElement questionSetNameFieldElement;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[5]/div/img[last()])")
	public static WebElement fieldSetEditButton2;

	@FindBy(xpath = "(//table/tbody/tr[2]/td[5]/div/img[last()])")
	public static WebElement fieldSetEditButton1;

	@FindBy(xpath = "//div[@data-info='section-1']//h5[contains(text(), 'Question ')]/..//input[@type='text']")
	public static List<WebElement> section1QuesElements;

	@FindBy(xpath = "//div[@data-info='section-2']//h5[contains(text(), 'Question ')]/..//input[@type='text']")
	public static List<WebElement> section2QuesElements;

	@FindBy(xpath = "//div[@data-info='section-3']//div[@class='row select_question_row']//label")
	public static List<WebElement> section3TableQuesElements;

	@FindBy(xpath = "//div[@class='row'][1]//div//div//label[1]")
	public static List<WebElement> section1QuesElementsInMasterForm;

	@FindBy(xpath = "(//label[@class='form-check-label ']/../..//div[@class='row'][1]//div//div//label[1])")
	public static List<WebElement> section1QuesElementsAddSec2InMasterForm;

	@FindBy(xpath = "//div[@class='row'][2]//div/label")
	public static List<WebElement> section2QuesElementsInMasterForm;

	@FindBy(xpath = "//div[@class='table-responsive column_second_scroll tablular_different_datatype']//div//div[@class='d-flex align-items-center justify-content-between table-viewleft']//label")
	public static List<WebElement> section3TableQuesElementsInMasterForm;

	@FindBy(xpath = "//img[@alt='arrow-left']")
	public static WebElement leftArrowToGoBackTablePage;

	@FindBy(id = "pills-MasterForms-tab")
	public static WebElement masterFormsTab;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/div/img[@alt='delete-icon '][@class='img-fluid delete-dataset delete_stages'][1]")
	public static WebElement masterFormsFirstRecoredDelete;

	@FindBy(xpath = "//button[text()='Delete']")
	public static WebElement deleteButton;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Masters Form has been Deleted successfully']")
	public static WebElement afterDeleteConfirmationPopUp;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Masters Form has been Deleted successfully']/..//button[text()='Continue']")
	public static WebElement afterDeleteConfirmationPopUpContinueButton;

	@FindBy(xpath = "//a[@class='btn-primary'][text()='+ Create']")
	public static WebElement masterFormCreateButton;

	@FindBy(id = "stage_name")
	public static WebElement formNameField;

	@FindBy(xpath = "//select[@id='process']")
	public static WebElement processDropDown;

	@FindBy(xpath = "//select[@id='sub_process']")
	public static WebElement subProcessDropDown;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public static WebElement subSubProcessDropDown;

	@FindBy(xpath = "(//h6[text()='Please Add Some Section']/following-sibling::a[text()='Add'][1])[1]")
	public static WebElement primarySectioAddButton;

	@FindBy(xpath = "(//h6[text()='Please Add Some Section']/following-sibling::a[text()='Add'][1])[2]")
	public static WebElement sectio2AddButton;

	@FindBy(xpath = "//h1[text()='Add Section']")
	public static WebElement primarySectioAddPopUp;

	@FindBy(xpath = "//label[text()='Section Name*']/..//input[@name='section_name']")
	public static WebElement addSectionFieldName;

	@FindBy(xpath = "//h1[text()='Add Section']/..//span[@aria-label='Close']")
	public static WebElement closePopUp;

	@FindBy(xpath = "//input[@name='master_section_type']/..//a[text()='Add ']")
	public static WebElement addSectionAddButton;

	@FindBy(xpath = "//li[@role='treeitem']")
	public static List<WebElement> checkOptions;

	@FindBy(xpath = "//div[@class='last-section-button']//button[@class='btn-primary'][normalize-space()='Save']")
	public static WebElement saveButton;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Master Form has been created successfully']")
	public static WebElement successPopUp;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Master Form has been created successfully']/..//button[text()='Continue']")
	public static WebElement successPopUpContinueButton;

	@FindBy(xpath = "//h2[normalize-space()='Edit Master Form']")
	public static WebElement afterClickContinueButton;

	@FindBy(xpath = "//img[@class='arrow-left']")
	public static WebElement leftArrowButton;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/div/img[2]")
	public static WebElement masterFormEditButton;

	@FindBy(xpath = "//button[@id='finalize_btn'][normalize-space()='Finalize']")
	public static WebElement finalizeButtton;

	@FindBy(xpath = "//div//form[@action='/en/masters/finalize_masters_form/']/input/..//div/h5")
	public static WebElement finalizePopUpText1;

	@FindBy(xpath = "//button[@id='finalizesubmit'][normalize-space()='Finalize']")
	public static WebElement finalizeButttonInPopUp;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Masters Form has been Finalized successfully']")
	public static WebElement finalizeSuccessPopUp;

	@FindBy(xpath = "//span[normalize-space()='Masters Form has been Finalized successfully']/..//button[text()='Continue']")
	public static WebElement finalizeSuccessPopUpContinueButton;

	@FindBy(xpath = "//div[@class='dataset_table']//table[@class='w-100']/tbody/tr[1]/td[1]")
	public static WebElement dataSetFirstRecord;

	@FindBy(xpath = "//div[@class='table-responsive data-view-name']//table/tbody/tr/td[2]")
	public static List<WebElement> dataSetQustions;

	@FindBy(xpath = "(//h2[contains(@class, 'page_heading')]/..//span[text()='×'])[1]")
	public static WebElement closeButtonInDataSetPopUp;

	@FindBy(xpath = "//div[@class='dataset_table']//table/tbody/tr[1]/td[1]")
	public static WebElement clickOnFirstMetadata;

	@FindBy(xpath = "(//table[@class='metadata_subtable skyblue-border dataset_subtable ']/tbody/tr/td[4]//input[@type='checkbox'])[1]")
	public static WebElement firstCheckBox;

	@FindBy(xpath = "(//table[@class='metadata_subtable skyblue-border dataset_subtable ']/tbody/tr/td[4]//input[@type='checkbox'])[last()-3 > 0 and position()=last()-3]")
	public static WebElement uniqueIdCheckBox;

	@FindBy(xpath = "//table[@class='metadata_subtable skyblue-border dataset_subtable ']/tbody/tr[1]/td[5]/select")
	public static WebElement roleSelectDropDown1;

	@FindBy(xpath = "//button[@class='btn-primary'][normalize-space()='Save']")
	public static WebElement saveButtonInMetaDataPopUp;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Metadata unique fields updated Successfully']")
	public static WebElement metaDataSuccessPopUp;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Metadata unique fields updated Successfully']/..//button[text()='Continue']")
	public static WebElement metaDataSuccessPopUpContinue;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/div/a/img[@title='Master Filter']")
	public static WebElement masterFilterButton;

	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/div/a/img[@title='Master Fields']")
	public static WebElement masterFieldsButton;

	@FindBy(xpath = "//button[@id='multiselect_rightSelected']")
	public static WebElement singleRightSelectedButtonDropDown;

	@FindBy(xpath = "//button[@id='unique_multiselect_rightSelected']")
	public static WebElement singleRightSelectedButtonDatePicker;

	@FindBy(xpath = "//button[@id='muti_unique_multiselect_rightSelected']")
	public static WebElement singleRightSelectedButtonMultiSelect;

	@FindBy(xpath = "//button[@id='multiselect_rightSelected']//img[@class='doubleright-arrow']")
	public static WebElement singleRightSelectedButtonTextBox;

	@FindBy(xpath = "//button[@id='textbox_multiselect_rightSelected']")
	public static WebElement singleRightSelectedButtonInMasterFillter;

	@FindBy(xpath = "//input[@placeholder='Search...']/..//select[@id='multiselect']")
	public static WebElement multiselectMasterField;

	@FindBy(xpath = "//label[normalize-space()='Text Box']/..//select[@id='textbox_multiselect']")
	public static WebElement multiselectMasterFilter;

	@FindBy(xpath = "//button[text()='Save']")
	public static WebElement saveButtonInMasterFilter;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Masters Filter has been created successfully']")
	public static WebElement afterSaveButtonInMasterFilterSuccessPopup;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Master Field has been created successfully']")
	public static WebElement afterSaveButtonInMasterFieldSuccessPopup;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Masters Filter has been created successfully']/..//button[text()='Continue']")
	public static WebElement afterSaveButtonInMasterFilterSuccessPopupContinueButton;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Master Field has been created successfully']/..//button[text()='Continue']")
	public static WebElement afterSaveButtonInMasterFieldSuccessPopupContinueButton;

	public MasterFormPage() {

		PageFactory.initElements(driver, this);
		loadStoredQuestions();
	}

	HomePage hp = new HomePage();

	public void commonNaviagationToMasterForm() throws Throwable {

		click(driver, hp.workflowDesign);
		click(driver, masterTabElement);
		click(driver, masterFormsTab);
	}

	ProcessPage process = new ProcessPage();

	public void createProcess() throws Throwable {

		click(driver, DataSetUpButton);

		process.createProcess(processName, processDesc, processName, subProcessName, subProcessDesc, subProcessName,
				subSubProcessName, subSubProcessDesc);

		Thread.sleep(2000);

		driver.navigate().refresh();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(dropDown1));
		dropDown1.isDisplayed();
		dropDown1.click();
		Thread.sleep(500);
		dropDown2.isDisplayed();
		dropDown2.click();
		Thread.sleep(500);
	}

	public void navigationToProcessAndFetch() throws Throwable {

//		driver.navigate().to("https://test.capture.autosherpas.com/en/data_management/process/");

		click(driver, DataSetUpButton);

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

		Thread.sleep(500);
		fetchSubProcessRecord = fetchsubProcess.getText();
		assertNotNull(fetchSubProcessRecord, "fetchSubProcessRecord is null.");

		Thread.sleep(500);
		fetchSubSubProcessRecord = fetchsubSubProcess.getText();
		assertNotNull(fetchSubSubProcessRecord, "fetchSubSubProcessRecord is null.");
	}

	public void navigationToFieldSet2() throws Throwable {

		click(driver, hp.workflowDesign);
		assertTrue(hp.masterParameterPage.isDisplayed(), "masterParameterPage is not displayed.");

		assertTrue(masterTabElement.isDisplayed(), "masterTabElement is not displayed.");

		click(driver, masterTabElement);

		System.out.println(driver.getCurrentUrl());

		assertEquals(driver.getCurrentUrl(), MastersFieldSets.masterURL, "masterURL mismatch.");

		assertTrue(fieldSetTabElement.isDisplayed(), "fieldSetTabElement is not displayed.");

//		assertTrue(createMasterFieldSetPage.isDisplayed(), "createMasterFieldSetPage is not displayed.");
	}

	final static List<String> section1fieldSetSectionQues1 = new ArrayList<>();

	int a = 0;

	// Method to retrieve values from the input fields
	public void getFieldSetSection1QuestionsForComparision() throws Throwable {

		Thread.sleep(2000);
		ClickUtilities.click(driver, fieldSetEditButton2);

		fetchFieldSetRecord = questionSetNameFieldElement.getAttribute("value");

		for (WebElement element : section1QuesElements) {
			section1fieldSetSectionQues1.add(element.getAttribute("value"));

			a++;

//			System.out.println("Values stored in 'values': " + element.getAttribute("value"));
		}
	}

	final static List<String> section2fieldSetSectionQues2 = new ArrayList<>();

	int b = 0;

	// Method to retrieve values from the input fields
	public void getFieldSetSection2QuestionsForComparision() throws Throwable {

		for (WebElement element : section2QuesElements) {
			section2fieldSetSectionQues2.add(element.getAttribute("value"));

			b++;
//			System.out.println("Values stored in 'section2Values': " + element.getAttribute("value"));
		}
	}

	final static List<String> section3fieldSetSectionQues3 = new ArrayList<>();

	int c = 0;

	// Method to retrieve values from the input fields
	public void getFieldSetSection3TableQuestionsForComparision() throws Throwable {

		for (WebElement element : section3TableQuesElements) {
			section3fieldSetSectionQues3.add(element.getText());

			c++;
//			System.out.println("Values stored in 'section3Values': " + element.getText());
		}
	}

	List<String> selectedTypesFieldSetSec1 = new ArrayList<>();

	public void getFieldSetSection1QuestionsType() throws Throwable {

		int section = 1;
		for (int i = 1; i <= a; i++) {

			String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_" + section
					+ "_" + i + "']/following-sibling::div//h6";

			List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

//				ClickUtilities.click(driver, DynamicXpath.questionField(i, 1, i));
			ClickUtilities.clickWithRetry(DynamicXpath.questionField(i, section, i), 2);

			String selectedType = null;
			for (WebElement type : checkQuestionTypes) {
				// Check the parent div for a class or style indicating selection
				WebElement parentDiv = type.findElement(By.xpath("./.."));
				String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

				// Assuming the selected item has a green background
				// You may need to adjust this condition based on the actual CSS

				if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
					selectedType = type.getText();

					assertNotNull(selectedType);
//						System.out.println("selectedType" + i + " : " + selectedType);
					break;
				}
			}
			selectedTypesFieldSetSec1.add(selectedType);

//			*****************************************************

//***********************************************************************************************
		}

		System.out.println("selectedTypesFieldSetSec1 : " + selectedTypesFieldSetSec1);

	}

	List<String> selectedTypesFieldSetSec2 = new ArrayList<>();

	public void getFieldSetSection2QuestionsType() throws Throwable {

		int section = 2;
		for (int i = 1; i <= b; i++) {

			if (i == 1) {

				String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
						+ section + "_" + i + "']/following-sibling::div//h6";

				List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

				ClickUtilities.clickWithRetry(DynamicXpath.questionField(i, section, i), 2);

				String selectedType = null;
				for (WebElement type : checkQuestionTypes) {
					// Check the parent div for a class or style indicating selection
					WebElement parentDiv = type.findElement(By.xpath("./.."));
					String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

					// Assuming the selected item has a green background
					// You may need to adjust this condition based on the actual CSS

					if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
						selectedType = type.getText();

						assertNotNull(selectedType);
//						System.out.println("selectedType" + i + " : " + selectedType);
						break;
					}
				}
				selectedTypesFieldSetSec2.add(selectedType);
			}
//			*****************************************************

			if (i == 2) {

				String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
						+ section + "_" + i + "']/following-sibling::div//h6";

				List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

				ClickUtilities.clickWithRetry(DynamicXpath.questionField(i, section, i), 2);

				String selectedType = null;
				for (WebElement type : checkQuestionTypes) {
					// Check the parent div for a class or style indicating selection
					WebElement parentDiv = type.findElement(By.xpath("./.."));
					String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

					// Assuming the selected item has a green background
					// You may need to adjust this condition based on the actual CSS

					if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
						selectedType = type.getText();

						assertNotNull(selectedType);
						System.out.println("selectedType" + i + " : " + selectedType);
						break;
					}
				}
				selectedTypesFieldSetSec2.add(selectedType);
			}
//			***********************************************************************************

			if (i == 3) {

				String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
						+ section + "_" + i + "']/following-sibling::div//h6";

				List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

				ClickUtilities.clickWithRetry(DynamicXpath.questionField(i, section, i), 2);

				String selectedType = null;

//				wait.until(ExpectedConditions.visibilityOfAllElements(checkQuestionTypes));
				for (WebElement type : checkQuestionTypes) {
					// Check the parent div for a class or style indicating selection
					WebElement parentDiv = type.findElement(By.xpath("./.."));
					String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

					// Assuming the selected item has a green background
					// You may need to adjust this condition based on the actual CSS

					if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
						selectedType = type.getText();

						assertNotNull(selectedType);
//						System.out.println("selectedType" + i + " : " + selectedType);
						break;
					}
				}
				selectedTypesFieldSetSec2.add(selectedType);
			}
//			################################################################################################################3
		}

		System.out.println("selectedTypesFieldSetSec2 : " + selectedTypesFieldSetSec2);

	}

	List<String> selectedTypesFieldSetSec3 = new ArrayList<>();

	public void getFieldSetSection3QuestionsType() throws Throwable {

		int section = 3;
		for (int i = 1; i <= c; i++) {

			if (i == 1) {

				String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
						+ section + "_" + i + "']/following-sibling::div//h6";

				List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

				WebElement tableQuesField = driver
						.findElement(By.xpath("//input[@name='question_" + section + "_" + i + "']"));

				ClickUtilities.clickWithRetry(tableQuesField, 2);

				String selectedType = null;
				for (WebElement type : checkQuestionTypes) {
					// Check the parent div for a class or style indicating selection
					WebElement parentDiv = type.findElement(By.xpath("./.."));
					String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

					// Assuming the selected item has a green background
					// You may need to adjust this condition based on the actual CSS

					if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
						selectedType = type.getText();

						assertNotNull(selectedType);
						System.out.println("selectedType" + i + " : " + selectedType);
						break;
					}
				}
				selectedTypesFieldSetSec3.add(selectedType);
			}
//			*****************************************************

			if (i == 2) {

				String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
						+ section + "_" + i + "']/following-sibling::div//h6";

				List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

				WebElement tableQuesField = driver
						.findElement(By.xpath("//input[@name='question_" + section + "_" + i + "']"));

				ClickUtilities.clickWithRetry(tableQuesField, 2);

				String selectedType = null;
				for (WebElement type : checkQuestionTypes) {
					// Check the parent div for a class or style indicating selection
					WebElement parentDiv = type.findElement(By.xpath("./.."));
					String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

					// Assuming the selected item has a green background
					// You may need to adjust this condition based on the actual CSS

					if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
						selectedType = type.getText();

						assertNotNull(selectedType);
						System.out.println("selectedType" + i + " : " + selectedType);
						break;
					}
				}
				selectedTypesFieldSetSec3.add(selectedType);
			}
//			***********************************************************************************

			if (i == 3) {

				String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
						+ section + "_" + i + "']/following-sibling::div//h6";

				List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

				WebElement tableQuesField = driver
						.findElement(By.xpath("//input[@name='question_" + section + "_" + i + "']"));

				ClickUtilities.clickWithRetry(tableQuesField, 2);

				String selectedType = null;
				for (WebElement type : checkQuestionTypes) {
					// Check the parent div for a class or style indicating selection
					WebElement parentDiv = type.findElement(By.xpath("./.."));
					String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

					// Assuming the selected item has a green background
					// You may need to adjust this condition based on the actual CSS

					if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
						selectedType = type.getText();

						assertNotNull(selectedType);
						System.out.println("selectedType" + i + " : " + selectedType);
						break;
					}
				}
				selectedTypesFieldSetSec3.add(selectedType);
			}
//			################################################################################################################3

			if (i == 4) {

				String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
						+ section + "_" + i + "']/following-sibling::div//h6";

				List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

				WebElement tableQuesField = driver
						.findElement(By.xpath("//input[@name='question_" + section + "_" + i + "']"));

				ClickUtilities.clickWithRetry(tableQuesField, 2);

				String selectedType = null;
				for (WebElement type : checkQuestionTypes) {
					// Check the parent div for a class or style indicating selection
					WebElement parentDiv = type.findElement(By.xpath("./.."));
					String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

					// Assuming the selected item has a green background
					// You may need to adjust this condition based on the actual CSS

					if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
						selectedType = type.getText();

						assertNotNull(selectedType);
						System.out.println("selectedType" + i + " : " + selectedType);
						break;
					}
				}
				selectedTypesFieldSetSec3.add(selectedType);
			}
//			#########################################################################

		}
		System.out.println("selectedTypesFieldSetSec3 : " + selectedTypesFieldSetSec3);
	}

	// ###############################################################################################################################################

	public void masterFormsFirstRecoredDelete() throws Throwable {

		click(driver, masterFormsFirstRecoredDelete);
		click(driver, deleteButton);
		wait.until(ExpectedConditions.visibilityOf(afterDeleteConfirmationPopUp));
		assertTrue(afterDeleteConfirmationPopUp.isDisplayed(), "afterDeleteConfirmationPopUp is not displayed.");
		click(driver, afterDeleteConfirmationPopUpContinueButton);

	}

	public void navigateToMasterForm() throws Throwable {

		click(driver, leftArrowToGoBackTablePage);
		click(driver, masterFormsTab);
	}

	public void navigateToMasterForm2() throws Throwable {
		click(driver, hp.workflowDesign);

		assertTrue(masterTabElement.isDisplayed(), "masterTabElement is not displayed.");
		click(driver, masterTabElement);

		System.out.println(driver.getCurrentUrl());

		assertEquals(driver.getCurrentUrl(), masterURL, "masterURL mismatch.");

		click(driver, masterFormTabElement);
	}

//	##############################################################################################################################

	final static List<String> section1fieldSetSectionQues2 = new ArrayList<>();
	List<String> selectedTypesFieldSetSec12 = new ArrayList<>();

	int n1 = 0;

	public void fieldSet2QuestionAndFetchQuestionType() throws Throwable {

		click(driver, leftArrowToGoBackTablePage);

		ClickUtilities.click(driver, fieldSetEditButton2);

		fetchFieldSetRecord2 = questionSetNameFieldElement.getAttribute("value");

		for (WebElement element : section1QuesElements) {
			section1fieldSetSectionQues2.add(element.getAttribute("value"));

			n1++;

			System.out.println("section1fieldSetSectionQues2 : " + element.getAttribute("value"));

		}

		int section = 1;
		for (int i = 1; i <= n1; i++) {

			String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_" + section
					+ "_" + i + "']/following-sibling::div//h6";

			List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

			ClickUtilities.clickWithRetry(DynamicXpath.questionField(i, 1, i), 2);

			String selectedType = null;
			for (WebElement type : checkQuestionTypes) {
				// Check the parent div for a class or style indicating selection
				WebElement parentDiv = type.findElement(By.xpath("./.."));
				String backgroundColor = parentDiv.getCssValue("background-color");

//					System.out.println("backgroundColor : "+backgroundColor);

				// Assuming the selected item has a green background
				// You may need to adjust this condition based on the actual CSS

				if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
					selectedType = type.getText();

					assertNotNull(selectedType);
//						System.out.println("selectedType" + i + " : " + selectedType);
					break;
				}
			}
			selectedTypesFieldSetSec12.add(selectedType);

		}

		ClickUtilities.clickWithRetry(DynamicXpath.questionTypeOptions(1, 1, 1), 2);

		Select valueTypeDropDown = new Select(DynamicXpath.valueTypeDropDown(1, 1));

//		Check default selected value
		WebElement defaultSelectedOption = valueTypeDropDown.getFirstSelectedOption();
		String expectedDefaultOption = "Only Number"; // Replace with expected default value
		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption, "Default selected option is incorrect.");

		System.out.println("defaultSelectedOption MasterForm 2 : " + defaultSelectedOption.getText());

	}

	public MasterFormPage createButtonMasterForm() throws Throwable {

		assertTrue(masterFormCreateButton.isDisplayed() && masterFormCreateButton.isEnabled(),
				"masterFormCreateButton is not displayed and enabled.");
		click(driver, masterFormCreateButton);

//		assertTrue(stagesCreateFormElement.isDisplayed(), "stagesCreateFormElement is not displayed.");
		assertEquals(driver.getCurrentUrl(), createPageUrl);

		return this;
	}

	public MasterFormPage formNameField() throws Throwable {

		// Check if the label ends with an asterisk
		String text = driver.findElement(By.xpath("//h3[@class='process'][normalize-space()='Form Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*', "formNameField label does not end with '*'.");

		// Ensure the role field is enabled
		assertTrue(formNameField.isEnabled(), "formNameField is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = formNameField.getAttribute("value");
		assertTrue(existingText.isEmpty(), "formNameField is not empty before entering text.");

		// Validate the role name (example: not empty and no special characters)
		assertNotNull(formName, "formName is null.");
		assertFalse(formName.trim().isEmpty(), "Role name is empty.");
		assertTrue(formName.matches("^[a-zA-Z0-9 ]+$"), "Role name contains special characters.");

		// Optionally, check if the role name already exists (pseudo-code, depends on
		// the application)
		// boolean roleExists = checkRoleExists(roleName);
		// assertFalse(roleExists, "Role name already exists.");

		// Enter the role name into the role field
		formNameField.sendKeys(formName);

		// Verify if the role name is correctly entered (optional)
		String enteredText = formNameField.getAttribute("value");
		assertEquals(enteredText, formName, "Role name is not correctly entered in the field.");

		return this;
	}

	public MasterFormPage formNameField(String formName) throws Throwable {

		// Check if the label ends with an asterisk
		String text = driver.findElement(By.xpath("//h3[@class='process'][normalize-space()='Form Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*', "formNameField label does not end with '*'.");

		// Ensure the role field is enabled
		assertTrue(formNameField.isEnabled(), "formNameField is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = formNameField.getAttribute("value");
		assertTrue(existingText.isEmpty(), "formNameField is not empty before entering text.");

		// Validate the role name (example: not empty and no special characters)
		assertNotNull(formName, "formName is null.");
		assertFalse(formName.trim().isEmpty(), "Role name is empty.");
		assertTrue(formName.matches("^[a-zA-Z0-9 ]+$"), "Role name contains special characters.");

		// Optionally, check if the role name already exists (pseudo-code, depends on
		// the application)
		// boolean roleExists = checkRoleExists(roleName);
		// assertFalse(roleExists, "Role name already exists.");

		// Enter the role name into the role field
		formNameField.sendKeys(formName);

		// Verify if the role name is correctly entered (optional)
		String enteredText = formNameField.getAttribute("value");
		assertEquals(enteredText, formName, "Role name is not correctly entered in the field.");

		return this;
	}

	public void procesDropdown() throws Throwable {

		Select process = new Select(processDropDown);

		assertFalse(process.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = process.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

//		Check default selected value
//		WebElement defaultSelectedOption = process.getFirstSelectedOption();
//		String expectedDefaultOption = "MB"; // Replace with expected default value
//		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
//				"Default selected option is incorrect.");

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < Math.min(10, options.size()); k++) {
			process.selectByIndex(k);
			WebElement selectedOption = process.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

//		select.selectByVisibleText("Only Text");

		process.selectByVisibleText(fetchProcessRecord);

	}

	public void subProcesDropdown() throws Throwable {

		actions.moveToElement(driverIninteractable).perform();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(subProcessDropDown));
		Select subProcess = new Select(subProcessDropDown);

		assertFalse(subProcess.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = subProcess.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

//		Check default selected value
//		WebElement defaultSelectedOption = process.getFirstSelectedOption();
//		String expectedDefaultOption = "MB"; // Replace with expected default value
//		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
//				"Default selected option is incorrect.");

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < options.size(); k++) {
			subProcess.selectByIndex(k);
			WebElement selectedOption = subProcess.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

		System.out.println("fetchSubProcessRecord : " + fetchSubProcessRecord);
//		DropDown.selectWithRetry(subProcessDropDown, fetchSubProcessRecord);
		subProcess.selectByVisibleText(fetchSubProcessRecord);

	}

	public void subSubProcesDropdown() throws Throwable {

		actions.moveToElement(driverIninteractable).perform();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(subSubProcessDropDown));
		Select subSubProcess = new Select(subSubProcessDropDown);

		assertFalse(subSubProcess.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = subSubProcess.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < options.size(); k++) {
			subSubProcess.selectByIndex(k);
			WebElement selectedOption = subSubProcess.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

		System.out.println("fetchSubSubProcessRecord : " + fetchSubSubProcessRecord);
//		select.selectByVisibleText("Only Text");
//		DropDown.selectWithRetry(subSubProcessDropDown, fetchSubSubProcessRecord);
		subSubProcess.selectByVisibleText(fetchSubSubProcessRecord);

//		Check selected value
		WebElement defaultSelectedOption = subSubProcess.getFirstSelectedOption();
		String expectedDefaultOption = fetchSubSubProcessRecord; // Replace with expected default value
		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption, "Default selected option is incorrect.");

	}

	public static void primarySectionAddSectionNameField() throws Throwable {

		// Check if the label ends with an asterisk
		String text = driver.findElement(By.xpath("//label[text()='Section Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*', "AddSectionNameField label does not end with '*'.");

		// Ensure the role field is enabled
		assertTrue(addSectionFieldName.isEnabled(), "addSectionFieldName is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = addSectionFieldName.getAttribute("value");
		assertTrue(existingText.isEmpty(), "addSectionFieldName is not empty before entering text.");

		// Validate the role name (example: not empty and no special characters)
		assertNotNull(FieldName1, "sectionFieldName is null.");
		assertFalse(FieldName1.trim().isEmpty(), "sectionFieldName is empty.");
		assertTrue(FieldName1.matches("^[a-zA-Z0-9 ]+$"), "sectionFieldName contains special characters.");

		// Optionally, check if the role name already exists (pseudo-code, depends on
		// the application)
		// boolean roleExists = checkRoleExists(roleName);
		// assertFalse(roleExists, "Role name already exists.");

		// Enter the role name into the role field
		addSectionFieldName.sendKeys(FieldName1);

		// Verify if the role name is correctly entered (optional)
		String enteredText = addSectionFieldName.getAttribute("value");
		assertEquals(enteredText, FieldName1, "sectionFieldName is not correctly entered in the field.");

	}

	public static void primarySectionAddSectionNameField(String fieldName) throws Throwable {

		// Check if the label ends with an asterisk
//		String text = driver.findElement(By.xpath("//label[text()='Section Name*']")).getText();
//		char lastChar = text.charAt(text.length() - 1);
//		assertEquals(lastChar, '*', "AddSectionNameField label does not end with '*'.");

		// Ensure the role field is enabled
		assertTrue(addSectionFieldName.isEnabled(), "addSectionFieldName is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = addSectionFieldName.getAttribute("value");
		assertTrue(existingText.isEmpty(), "addSectionFieldName is not empty before entering text.");

		// Validate the role name (example: not empty and no special characters)
		assertNotNull(fieldName, "sectionFieldName is null.");
		assertFalse(fieldName.trim().isEmpty(), "sectionFieldName is empty.");
		assertTrue(fieldName.matches("^[a-zA-Z0-9 ]+$"), "sectionFieldName contains special characters.");

		// Optionally, check if the role name already exists (pseudo-code, depends on
		// the application)
		// boolean roleExists = checkRoleExists(roleName);
		// assertFalse(roleExists, "Role name already exists.");

		// Enter the role name into the role field
		addSectionFieldName.sendKeys(fieldName);

		// Verify if the role name is correctly entered (optional)
		String enteredText = addSectionFieldName.getAttribute("value");
		assertEquals(enteredText, fieldName, "sectionFieldName is not correctly entered in the field.");

	}

	public static void selectQuestionSetInDropdown() throws Throwable {

		String name = "sectionval_Mesaurable_value_" + FieldName1.replaceAll("\\s", "");
		WebElement selectQuestionSet = driver.findElement(By.name(name));

		Select selectQuestionSetDropDown = new Select(selectQuestionSet);

		assertFalse(selectQuestionSetDropDown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = selectQuestionSetDropDown.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			softAssert.assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < Math.min(10, options.size()); k++) {
			selectQuestionSetDropDown.selectByIndex(k);
			WebElement selectedOption = selectQuestionSetDropDown.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

//		select.selectByVisibleText("Only Text");
		Thread.sleep(1000);
		selectQuestionSetDropDown.selectByVisibleText(fetchFieldSetRecord);
		Thread.sleep(2000);

	}

	public static void selectQuestionSetInDropdown(String fieldName, String fieldSetName) throws Throwable {

		String name = "sectionval_Mesaurable_value_" + fieldName.replaceAll("\\s", "");
		WebElement selectQuestionSet = driver.findElement(By.name(name));

		Select selectQuestionSetDropDown = new Select(selectQuestionSet);

		assertFalse(selectQuestionSetDropDown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = selectQuestionSetDropDown.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			softAssert.assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < Math.min(10, options.size()); k++) {
			selectQuestionSetDropDown.selectByIndex(k);
			WebElement selectedOption = selectQuestionSetDropDown.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

		// Wait for a short time before making the final selection
		Thread.sleep(1000);

		// If fieldSetName is provided, select it by visible text
		if (fieldSetName != null && !fieldSetName.isEmpty()) {
			selectQuestionSetDropDown.selectByVisibleText(fieldSetName);
			System.out.println("Option '" + fieldSetName + "' selected from dropdown.");
		} else {
			// If no fieldSetName provided, select a random option
			Random rand = new Random();
			int randomIndex = rand.nextInt(options.size());
			selectQuestionSetDropDown.selectByIndex(randomIndex);
			System.out.println("Random option selected: " + options.get(randomIndex).getText());
		}

		// Wait a bit for the dropdown to update after selection
		Thread.sleep(2000);
	}

	final static List<String> MasterFormQues1 = new ArrayList<>();

	// Method to retrieve values from the input fields
	public static void getFieldSetSection1QuestionsInMasterForm() throws Throwable {

		for (WebElement element : section1QuesElementsInMasterForm) {
			MasterFormQues1.add(element.getText());
			System.out.println("Values stored in 'values' InMasterForm : " + element.getText());
		}
	}

	static List<String> MasterFormQues2 = new ArrayList<>();

	public static void getFieldSetSection2QuestionsInMasterForm() throws Throwable {
		// Create a list to store question texts
		// Iterate through each WebElement and add its text to the list, skipping the
		// second element
		for (int i = 0; i < section2QuesElementsInMasterForm.size(); i++) {
			if (i != 1) { // Skip the second element (index 1)
				MasterFormQues2.add(section2QuesElementsInMasterForm.get(i).getText());
			}
		}

	}

	static List<String> MasterFormQues3 = new ArrayList<>();

	public static void getFieldSetSection3QuestionsInMasterForm() throws Throwable {
		// Create a list to store question texts
		for (WebElement element : section3TableQuesElementsInMasterForm) {
			MasterFormQues3.add(element.getText());
			System.out.println("Values stored in 'values' InMasterForm : " + element.getText());
		}

	}

	final static List<String> MasterFormQuesAddSect2 = new ArrayList<>();

	// Method to retrieve values from the input fields
	public static void getFieldAddSect2SetSection1QuestionsInMasterForm() throws Throwable {

		for (WebElement element : section1QuesElementsAddSec2InMasterForm) {
			MasterFormQuesAddSect2.add(element.getText());
			System.out.println("Values stored in 'values' InMasterForm section1QuesElementsAddSec2InMasterForm : "
					+ element.getText());

		}
	}

	static List<String> allQuestions = new ArrayList<>();

	public static void getFieldSetAllSectionQuestionsInMasterForm() throws Throwable {

		// Add all elements from each ArrayList
		allQuestions.addAll(MasterFormQues1);
		allQuestions.addAll(MasterFormQues2);
		allQuestions.addAll(MasterFormQues3);
		allQuestions.add("Trans Unique Id");
		allQuestions.add("Trans Uploaded On");
		allQuestions.add("Trans Uploaded By");
		allQuestions.add("Trans Uploaded Id");

		for (String question : allQuestions) {
			System.out.println("allQuestions : " + question);
		}

	}

	public void primarySection() throws Throwable {

		click(driver, primarySectioAddButton);

		wait.until(ExpectedConditions.visibilityOf(primarySectioAddPopUp));
		assertTrue(primarySectioAddPopUp.isDisplayed(), "primarySectioAddPopUp is not displayed.");

		primarySectionAddSectionNameField();

		click(driver, addSectionAddButton);

		String xpath = "(//button[normalize-space()='" + FieldName1 + "'])[1]";

		WebElement addedSectionInPrimarySection = driver.findElement(By.xpath(xpath));
		click(driver, addedSectionInPrimarySection);

		selectQuestionSetInDropdown();

		getFieldSetSection1QuestionsInMasterForm();
		getFieldSetSection2QuestionsInMasterForm();
		getFieldSetSection3QuestionsInMasterForm();

		System.out.println(section3fieldSetSectionQues3 + "\n" + MasterFormQues3);
		assertEquals(section1fieldSetSectionQues1, MasterFormQues1, "section1Values, values1 The lists do not match!");
		assertEquals(section2fieldSetSectionQues2, MasterFormQues2, "section2Values, values2 The lists do not match!");
		assertEquals(section3fieldSetSectionQues3, MasterFormQues3, "section3Values, values3 The lists do not match!");

		System.out.println("Validation successful: Both lists match.");

	}

	public void primarySectionFormFill() throws Throwable {

		// Example usage for Section 1
		for (int i = 0; i < selectedTypesFieldSetSec1.size(); i++) {
			String selectedType = selectedTypesFieldSetSec1.get(i);

			// Perform actions based on selectedType
			switch (selectedType) {
			case "Text Box":
				// Example: Find input field and sendKeys
				WebElement textBoxInput = driver.findElement(By.xpath(
						"//div[@class='row'][1]//input[@type='text' and contains(@class, 'answer_option') and not(contains(@class, 'date_pick')) and not(contains(@class, 'time_pick'))]"));
				textBoxInput.sendKeys("Text input");
				break;

			case "Short Answer":
				// Example: Find input field and sendKeys
				WebElement shortAnswerInput = driver.findElement(By.xpath("//div[@class='row'][1]//textarea"));
				shortAnswerInput.sendKeys("Short Answer");
				break;

			case "Radio Button":
				// Example: Find radio button and click
				String xpath = "//div[@class='row'][1]//label//input[@type='radio']";
				List<WebElement> radioButtonOptions = driver.findElements(By.xpath(xpath));

				Random random = new Random();
				int randomIndex = random.nextInt(radioButtonOptions.size());
				// Click the radio button at the random index
				ClickUtilities.clickWithRetry(radioButtonOptions.get(randomIndex), 2);

				break;

			case "Drop Down":
				// Example: Find radio button and click
				String xpath1 = "//div[@class='row'][1]//select";
				WebElement dropDown = driver.findElement(By.xpath(xpath1));

				Select select = new Select(dropDown);

				// Get all options
				List<WebElement> options = select.getOptions();
				// Get the number of options
				int size = options.size();
				// Create a Random object
				Random randomDropDown = new Random();
				// Generate a random index
				int randomIndexDropDown = 1 + randomDropDown.nextInt(size - 1);
				// Select the option at the random index
				select.selectByIndex(randomIndexDropDown);

				break;

			case "Date":
				// Example: Find date input and sendKeys
				WebElement dateInput = driver
						.findElement(By.xpath("//div[@class='row'][1]//input[@placeholder='DD-MM-YYYY']"));
				dateInput.sendKeys("2024-07-05"); // Adjust date format as needed
				break;

			case "Time":
				// Example: Find date input and sendKeys
				String[] times = { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
						"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00",
						"19:00", "20:00", "21:00", "22:00", "23:00" };

				// Random object
				Random randomTime = new Random();

				// Select a random index
				int randomIndexTime = randomTime.nextInt(times.length);

				// Selected time
				String selectedTime = times[randomIndexTime];

				// Locate the input element and send keys
				WebElement timeInput = driver
						.findElement(By.xpath("//div[@class='row'][1]//input[@placeholder='HH:MM']"));
				timeInput.sendKeys(selectedTime);
				break;

			case "File Upload":
				// Example: Find file upload input and sendKeys with file path
				WebElement fileInput = driver.findElement(By.xpath("//input[@id='file" + (i + 1) + "']"));
				fileInput.sendKeys("/path/to/file.txt"); // Replace with actual file path
				break;
			default:
				// Handle any other types or exceptions
				break;
			}
		}
	}

	public void primarySection2FormFill() throws Throwable {

		// Example usage for Section 1
		for (int i = 0; i < selectedTypesFieldSetSec2.size(); i++) {
			String selectedType = selectedTypesFieldSetSec2.get(i);

			// Perform actions based on selectedType
			switch (selectedType) {
			case "Text Box":

				try {
					// Example: Find input field and sendKeys
					WebElement textBoxInput = driver.findElement(By.xpath(
							"//div[@class='row'][2]//input[@type='text' and contains(@class, 'answer_option') and not(contains(@class, 'date_pick')) and not(contains(@class, 'time_pick'))]"));
					textBoxInput.sendKeys("Text input");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Exception : " + e);
				}

				break;

			case "Short Answer":
				// Example: Find input field and sendKeys
				WebElement shortAnswerInput = driver.findElement(By.xpath("//div[@class='row'][2]//textarea"));
				shortAnswerInput.sendKeys("Short Answer");
				break;

			case "Radio Button":
				// Example: Find radio button and click
				String xpath = "//div[@class='row'][2]//label//input[@type='radio']";
				List<WebElement> radioButtonOptions = driver.findElements(By.xpath(xpath));

				Random random = new Random();
				int randomIndex = random.nextInt(radioButtonOptions.size());
				// Click the radio button at the random index
				ClickUtilities.clickWithRetry(radioButtonOptions.get(randomIndex), 2);

				break;

			case "Drop Down":
				// Example: Find radio button and click
				String xpath1 = "//div[@class='row'][2]//select";
				WebElement dropDown = driver.findElement(By.xpath(xpath1));

				Select select = new Select(dropDown);

				// Get all options
				List<WebElement> options = select.getOptions();
				// Get the number of options
				int size = options.size();
				// Create a Random object
				Random randomDropDown = new Random();
				// Generate a random index
				int randomIndexDropDown = randomDropDown.nextInt(size);
				// Select the option at the random index
				select.selectByIndex(randomIndexDropDown);

				break;

			case "Date":
				// Example: Find date input and sendKeys
				WebElement dateInput = driver
						.findElement(By.xpath("//div[@class='row'][2]//input[@placeholder='DD-MM-YYYY']"));
				dateInput.sendKeys("2024-07-05"); // Adjust date format as needed
				break;

			case "Time":
				// Example: Find date input and sendKeys
				String[] times = { "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00",
						"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
						"20:00", "21:00", "22:00", "23:00" };

				// Random object
				Random randomTime = new Random();

				// Select a random index
				int randomIndexTime = randomTime.nextInt(times.length);

				// Selected time
				String selectedTime = times[randomIndexTime];

				// Locate the input element and send keys
				WebElement timeInput = driver
						.findElement(By.xpath("//div[@class='row'][2]//input[@placeholder='HH:MM']"));
				timeInput.sendKeys(selectedTime);
				break;

			case "File Upload":
				// Example: Find file upload input and sendKeys with file path
				WebElement fileInput = driver.findElement(By.xpath("//div[@class='row'][2]//input[@id='Browse']"));
				UploadFile.uploadFilewithType(driver, fileInput, "docx");

				break;

			case "Relative Dropdown":
				// Example: Find file upload input and sendKeys with file path

				try {

					WebElement relativeDropdown = driver
							.findElement(By.xpath("//div[@class='row'][2]//select[@id='current_Sec_id']"));
					assertTrue(relativeDropdown.isDisplayed(), "relativeDropdown is not displayed");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Exception : " + e);
				}

				break;

			case "Multiple Choice":

				// Example: Find file upload input and sendKeys with file path
				WebElement multipleChoice = driver
						.findElement(By.xpath("//div[@class='row'][2]//input[@type='search']"));
//				ClickUtilities.clickAndHighlightElement(multipleChoice, driver);
				ClickUtilities.clickWithRetry(multipleChoice, 2);

				for (int j = 1; j < checkOptions.size(); j++) {
					try {
						WebElement option = wait.until(ExpectedConditions
								.refreshed(ExpectedConditions.elementToBeClickable(checkOptions.get(j))));

						ClickUtilities.clickWithRetry(option, 2);
						System.out.println("Selected option: " + option.getText());

						Thread.sleep(500);

						WebElement multipleChoice1 = wait.until(ExpectedConditions.presenceOfElementLocated(
								By.xpath("//div[@class='row'][2]//span[contains(@class, 'select2-selection--multiple')]"
										+ "//ul[contains(@class, 'select2-selection__rendered')]"
										+ "//li[contains(@class, 'select2-search--inline')]"
										+ "/input[@class='select2-search__field']")));

						ClickUtilities.jsClick(driver, multipleChoice1);

					} catch (StaleElementReferenceException e) {
						System.out.println("Encountered stale element. Retrying...");
						j--; // Retry this iteration
						continue;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Thread.sleep(1000);
				String xpathMC = "(//button[normalize-space()='" + FieldName1 + "'])[1]";

				WebElement addedSectionInPrimarySection = driver.findElement(By.xpath(xpathMC));
				click(driver, addedSectionInPrimarySection);

				break;

			default:
				// Handle any other types or exceptions
				break;
			}
		}
	}

	public void primarySection3FormFill() throws Throwable {

		// Example usage for Section 1
		for (int i = 0; i < selectedTypesFieldSetSec3.size(); i++) {
			String selectedType = selectedTypesFieldSetSec3.get(i);

			// Perform actions based on selectedType
			switch (selectedType) {
			case "Text Box":
				// Example: Find input field and sendKeys
				WebElement textBoxInput = driver.findElement(By.xpath(
						"//div[@class='table-responsive column_second_scroll tablular_different_datatype']//input[@type='text' and contains(@class, 'answer_option') and not(contains(@class, 'date_pick')) and not(contains(@id, 'Browse'))]"));
				textBoxInput.sendKeys("Text input");
				break;

			case "Short Answer":
				// Example: Find input field and sendKeys
				WebElement shortAnswerInput = driver.findElement(By.xpath(
						"//div[@class='table-responsive column_second_scroll tablular_different_datatype']//textarea"));
				shortAnswerInput.sendKeys("Short Answer");
				break;

			case "Radio Button":
				// Example: Find radio button and click
				String xpath = "//div[@class='table-responsive column_second_scroll tablular_different_datatype']//label//input[@type='radio']";
				List<WebElement> radioButtonOptions = driver.findElements(By.xpath(xpath));

				Random random = new Random();
				int randomIndex = random.nextInt(radioButtonOptions.size());
				// Click the radio button at the random index
				ClickUtilities.clickWithRetry(radioButtonOptions.get(randomIndex), 2);

				break;

			case "Drop Down":
				// Example: Find radio button and click
				String xpath1 = "//div[@class='table-responsive column_second_scroll tablular_different_datatype']//select";
				WebElement dropDown = driver.findElement(By.xpath(xpath1));

				Select select = new Select(dropDown);

				// Get all options
				List<WebElement> options = select.getOptions();
				// Get the number of options
				int size = options.size();
				// Create a Random object
				Random randomDropDown = new Random();
				// Generate a random index
				int randomIndexDropDown = randomDropDown.nextInt(size);
				// Select the option at the random index
				select.selectByIndex(randomIndexDropDown);

				break;

			case "Date":
				// Example: Find date input and sendKeys
				WebElement dateInput = driver.findElement(By.xpath(
						"//div[@class='table-responsive column_second_scroll tablular_different_datatype']//input[@placeholder='YYYY-MM-DD']"));
				dateInput.sendKeys("2024-07-05"); // Adjust date format as needed
				break;

			case "Time":
				// Example: Find date input and sendKeys
				String[] times = { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
						"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00",
						"19:00", "20:00", "21:00", "22:00", "23:00" };

				// Random object
				Random randomTime = new Random();

				// Select a random index
				int randomIndexTime = randomTime.nextInt(times.length);

				// Selected time
				String selectedTime = times[randomIndexTime];

				// Locate the input element and send keys
				WebElement timeInput = driver.findElement(By.xpath(
						"//div[@class='table-responsive column_second_scroll tablular_different_datatype']//input[@placeholder='HH:MM']"));
				timeInput.sendKeys(selectedTime);
				break;

			case "File Upload":
				// Example: Find file upload input and sendKeys with file path
				WebElement fileInput = driver.findElement(By.xpath(
						"//div[@class='table-responsive column_second_scroll tablular_different_datatype']//input[@type='file']"));
				UploadFile.uploadFilewithType(driver, fileInput, "excel");

				break;

			case "Relative Dropdown":
				// Example: Find file upload input and sendKeys with file path
				WebElement relativeDropdown = driver.findElement(By.xpath(
						"//div[@class='table-responsive column_second_scroll tablular_different_datatype']//select[@id='current_Sec_id']"));
				assertTrue(relativeDropdown.isDisplayed(), "relativeDropdown is not displayed");

				break;

			case "Multiple Choice":
				// Example: Find file upload input and sendKeys with file path
				WebElement multipleChoice = driver.findElement(By.xpath(
						"//div[@class='table-responsive column_second_scroll tablular_different_datatype']//input[@placeholder='select']"));
				ClickUtilities.clickAndHighlightElement(multipleChoice, driver);

				for (WebElement a : checkOptions) {

					click(driver, a);
					System.out.println("Check box options : " + a.getText());
				}

				break;

			default:
				// Handle any other types or exceptions
				break;
			}
		}
	}

	public void addSection2InMasterForm() throws Throwable {

		Thread.sleep(2000);

		ClickUtilities.clickWithRetry(sectio2AddButton, 2);

		wait.until(ExpectedConditions.visibilityOf(primarySectioAddPopUp));
		assertTrue(primarySectioAddPopUp.isDisplayed(), "primarySectioAddPopUp is not displayed.");

		// Check if the label ends with an asterisk
		String text = driver.findElement(By.xpath("//label[text()='Section Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*', "AddSectionNameField label does not end with '*'.");

		// Ensure the role field is enabled
		assertTrue(addSectionFieldName.isEnabled(), "addSectionFieldName is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = addSectionFieldName.getAttribute("value");
		assertTrue(existingText.isEmpty(), "addSectionFieldName is not empty before entering text.");

		// Validate the role name (example: not empty and no special characters)
		assertNotNull(FieldName2, "sectionFieldName is null.");
		assertFalse(FieldName2.trim().isEmpty(), "sectionFieldName is empty.");
		assertTrue(FieldName2.matches("^[a-zA-Z0-9 ]+$"), "sectionFieldName contains special characters.");

		// Enter the role name into the role field
		addSectionFieldName.sendKeys(FieldName2);

		// Verify if the role name is correctly entered (optional)
		String enteredText = addSectionFieldName.getAttribute("value");
		assertEquals(enteredText, FieldName2, "sectionFieldName is not correctly entered in the field.");

		getFieldAddSect2SetSection1QuestionsInMasterForm();

		click(driver, addSectionAddButton);

		String xpath = "(//button[normalize-space()='" + FieldName2 + "'])[1]";

		WebElement addedSectionInPrimarySection = driver.findElement(By.xpath(xpath));
		ClickUtilities.clickWithRetry(addedSectionInPrimarySection, 2);
//		click(driver, addedSectionInPrimarySection);

		ClickUtilities.clickWithRetry(driverIninteractable
				.findElement(By.xpath("//input[@class='is_condtional_checkbx']/..//span[@class='slider round ']")), 2);

//		###################################################

		String name = "sectionval_Mesaurable_value_" + FieldName2.replaceAll("\\s", "");
		WebElement selectQuestionSet = driver.findElement(By.name(name));

		Select selectQuestionSetDropDown = new Select(selectQuestionSet);

		assertFalse(selectQuestionSetDropDown.isMultiple(), "Dropdown allows multiple selections.");

		// Check for empty drop down
		List<WebElement> options = selectQuestionSetDropDown.getOptions();
		assertTrue(options.size() > 0, "Dropdown has no options.");
		System.out.println("Number of options in the dropdown: " + options.size());

//		Check default selected value
//		WebElement defaultSelectedOption = process.getFirstSelectedOption();
//		String expectedDefaultOption = "MB"; // Replace with expected default value
//		assertEquals(defaultSelectedOption.getText(), expectedDefaultOption,
//				"Default selected option is incorrect.");

		// Print all options and check for duplicates
		Set<String> uniqueOptions = new HashSet<>();
		System.out.println("Dropdown options:");
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			softAssert.assertTrue(uniqueOptions.add(optionText), "Duplicate option found: " + optionText);
		}

		// Select each option by index and verify the selection
		for (int k = 0; k < Math.min(10, options.size()); k++) {
			selectQuestionSetDropDown.selectByIndex(k);
			WebElement selectedOption = selectQuestionSetDropDown.getFirstSelectedOption();
			assertEquals(selectedOption.getText(), options.get(k).getText(),
					"Failed to select the option by index " + k);
			System.out
					.println("Option '" + options.get(k).getText() + "' was successfully selected by index " + k + ".");
		}

//		select.selectByVisibleText("Only Text");
		Thread.sleep(1000);
		selectQuestionSetDropDown.selectByVisibleText(fetchFieldSetRecord2);

//		###################################################

	}

	public MasterFormPage saveButton(boolean clickLeftArrow) throws Throwable {

		assertTrue(saveButton.isDisplayed() && saveButton.isEnabled(), "saveButton is not displayed and enabled.");
		click(driver, saveButton);

		confirmationAfterClickOnSaveButton(clickLeftArrow);

		return this;
	}

	public static void confirmationAfterClickOnSaveButton(boolean clickLeftArrow) throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(successPopUp));
		assertTrue(successPopUp.isDisplayed(), "successPopUp is not displayed.");
		click(driver, successPopUpContinueButton);

		wait.until(ExpectedConditions.visibilityOf(afterClickContinueButton));
		assertTrue(afterClickContinueButton.isDisplayed(), "afterClickContinueButton is not displayed.");

		// Conditionally click the left arrow button based on the parameter
		if (clickLeftArrow) {
			click(driver, leftArrowButton);
		} else {
			System.out.println("Left arrow button not clicked as per the provided condition.");
		}
	}

//	##########################################################################################################################

	public void finalizeMasterFormInEditPage() throws Throwable {

		click(driver, masterFormEditButton);

		// Ensure the role field is enabled
		assertTrue(formNameField.isEnabled(), "formNameField is not enabled.");

		// Check if the role field is empty before entering the role name
		String existingText = formNameField.getAttribute("value");
		assertFalse(existingText.isEmpty(), "formNameField is not empty before entering text.");

		assertEquals(existingText, formName);

		click(driver, finalizeButtton);

		wait.until(ExpectedConditions.visibilityOf(finalizePopUpText1));
		String finalizePopupText = "Are you sure you want to finalize ?";

		assertEquals(finalizePopupText, finalizePopUpText1.getText());

		click(driver, finalizeButttonInPopUp);

		wait.until(ExpectedConditions.visibilityOf(finalizeSuccessPopUp));
		assertTrue(finalizeSuccessPopUp.isDisplayed(), "finalizeSuccessPopUp is not displayed.");

		click(driver, finalizeSuccessPopUpContinueButton);

	}

	List<String> dataSetQuestions = new ArrayList<>();

	public void dataSetValidationAfterCreationOfMasterForm() throws Throwable {

//		commonNaviagationToMasterForm();
//
//		String createdMasterForm = "(//a[@class='View_Stages_id'])[1]";
//		WebElement clickOnCreatedMasterForm = driverIninteractable.findElement(By.xpath(createdMasterForm));
//		click(driver, clickOnCreatedMasterForm);
//
//		String createdAddSection = "(//h6[text()='Primary Section']/../../../..//ul[@id='pills-tab']//button)[1]";
//		WebElement clickOnCreatedAddSection = driverIninteractable.findElement(By.xpath(createdAddSection));
//		click(driver, clickOnCreatedAddSection);
//		
//
//		getFieldSetSection1QuestionsInMasterForm();
//		getFieldSetSection2QuestionsInMasterForm();
//		getFieldSetSection3QuestionsInMasterForm();
//
//		getFieldSetAllSectionQuestionsInMasterForm();
//		click(driver, leftArrowButton);
//
//		// Add all elements from each ArrayList
//		allQuestions.addAll(MasterFormQues1);
//		allQuestions.addAll(MasterFormQues2);
//		allQuestions.addAll(MasterFormQues3);

//		System.out.println("allQuestions.size() : " + allQuestions.size());
//
//		for (String question : allQuestions) {
//			System.out.println("allQuestions : " + question);
//		}
//		
//		System.out.println("allQuestions All : "+allQuestions);

		click(driver, DataSetUpButton);
		click(driver, dataSetTabButton);

		click(driver, dataSetFirstRecord);

//		getFieldSetAllSectionQuestionsInMasterForm();

		for (WebElement element : dataSetQustions) {

			Thread.sleep(100);
			dataSetQuestions.add(element.getText());
			System.out.println("Values stored in 'values' in Dataset : " + element.getText());
			Thread.sleep(100);
		}

		click(driver, closeButtonInDataSetPopUp);

	}

	public void metaDataValidationAfterCreationOfMasterForm() throws Throwable {

		click(driver, metaDataTabButton);
		Thread.sleep(1000);
		click(driver, clickOnFirstMetadata);

		Thread.sleep(1000);
		ClickUtilities.clickWithRetry(firstCheckBox, 2);

		Thread.sleep(1000);
		assertTrue(roleSelectDropDown1.isDisplayed(), "roleSelectDropDown1 is not displayed.");
		Select select = new Select(roleSelectDropDown1);
		Thread.sleep(1000);
		select.selectByVisibleText("Agent");

		ClickUtilities.clickWithRetry(uniqueIdCheckBox, 2);

		click(driver, saveButtonInMetaDataPopUp);

		wait.until(ExpectedConditions.visibilityOf(metaDataSuccessPopUp));

		assertTrue(metaDataSuccessPopUp.isDisplayed(), "metaDataSuccessPopUp is not displayed.");

		click(driver, metaDataSuccessPopUpContinue);

	}

	public void masterFieldsAfterCreationOfMasterForm() throws Throwable {

		List<Map<String, String>> questions = fieldSetMasterQuestionsAndQuestionTypes();

		navigateToMasterForm();
		Thread.sleep(2000);
		ClickUtilities.clickWithRetry(masterFieldsButton, 2);

		// Iterate through the list of questions and select the corresponding options in
		// the dropdowns
		for (Map<String, String> question : questions) {
			selectQuestionBasedOnType(question, multiselectMasterField, singleRightSelectedButtonTextBox);
		}

		ClickUtilities.clickWithRetry(saveButtonInMasterFilter, 2);

		wait.until(ExpectedConditions.visibilityOf(afterSaveButtonInMasterFieldSuccessPopup));

		assertTrue(afterSaveButtonInMasterFieldSuccessPopup.isDisplayed(),
				"afterSaveButtonInMasterFilterSuccessPopup is not displayed.");
		ClickUtilities.clickWithRetry(afterSaveButtonInMasterFieldSuccessPopupContinueButton, 2);

	}

	public void masterFilterAfterCreationOfMasterFields() throws Throwable {

		List<Map<String, String>> questions = fieldSetMasterQuestionsAndQuestionTypes();

		navigateToMasterForm();
		Thread.sleep(2000);
		ClickUtilities.clickWithRetry(masterFilterButton, 2);

		// Iterate through the list of questions and select the corresponding options in
		// the dropdowns
		for (Map<String, String> question : questions) {
			selectQuestionBasedOnType(question, multiselectMasterFilter, singleRightSelectedButtonInMasterFillter);
		}

		ClickUtilities.clickWithRetry(saveButtonInMasterFilter, 2);

		wait.until(ExpectedConditions.visibilityOf(afterSaveButtonInMasterFilterSuccessPopup));

		assertTrue(afterSaveButtonInMasterFilterSuccessPopup.isDisplayed(),
				"afterSaveButtonInMasterFilterSuccessPopup is not displayed.");
		ClickUtilities.clickWithRetry(afterSaveButtonInMasterFilterSuccessPopupContinueButton, 2);

	}

	public List<Map<String, String>> fieldSetMasterQuestionsAndQuestionTypes() throws Throwable {

		click(driver, hp.workflowDesign);
		click(driver, masterTabElement);
		click(driver, fieldSetTabElement);
		click(driver, fieldSetEditButton2);

		int a1 = 0;
		for (WebElement element : section1QuesElements) {
			System.out.println(element.getAttribute("value"));
			a1++;
		}

		int section = 1;
		List<Map<String, String>> questions = new ArrayList<>();

		for (int i = 1; i <= a1; i++) {
			String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_" + section
					+ "_" + i + "']/following-sibling::div//h6";

			List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

			ClickUtilities.clickWithRetry(DynamicXpath.questionField(i, 1, i), 2);
			WebElement element = DynamicXpath.questionField(i, 1, i);

			String elementQuestion = element.getAttribute("value");
			System.out.println("elementQuestion : " + elementQuestion);

			String selectedType = null;
			for (WebElement type : checkQuestionTypes) {
				// Check the parent div for a class or style indicating selection
				WebElement parentDiv = type.findElement(By.xpath("./.."));
				String backgroundColor = parentDiv.getCssValue("background-color");

				// Assuming the selected item has a green background
				if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
					selectedType = type.getText();
					assertNotNull(selectedType);
					break;
				}
			}

			System.out.println("selectedType : " + selectedType);

			// Add question and type to the list as a map
			Map<String, String> question = new HashMap<>();
			question.put("elementQuestion", elementQuestion);
			question.put("selectedType", selectedType);
			questions.add(question);
		}

		int a2 = 0;
		for (WebElement element : section2QuesElements) {
			System.out.println(element.getAttribute("value"));
			a2++;
		}

		int section2 = 2;

		for (int i = 1; i <= a2; i++) {
			String xpath = "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_"
					+ section2 + "_" + i + "']/following-sibling::div//h6";

			List<WebElement> checkQuestionTypes = driver.findElements(By.xpath(xpath));

			ClickUtilities.clickWithRetry(DynamicXpath.questionField(i, 2, i), 2);
			WebElement element = DynamicXpath.questionField(i, 2, i);

			String elementQuestion = element.getAttribute("value");
			System.out.println("elementQuestion : " + elementQuestion);

			String selectedType = null;
			for (WebElement type : checkQuestionTypes) {
				// Check the parent div for a class or style indicating selection
				WebElement parentDiv = type.findElement(By.xpath("./.."));
				String backgroundColor = parentDiv.getCssValue("background-color");

				// Assuming the selected item has a green background
				if (backgroundColor.equals("rgba(44, 163, 36, 1)") || backgroundColor.equals("rgb(0, 128, 0)")) {
					selectedType = type.getText();
					assertNotNull(selectedType);
					break;
				}
			}

			System.out.println("selectedType : " + selectedType);

			// Add question and type to the list as a map
			Map<String, String> question = new HashMap<>();
			question.put("elementQuestion", elementQuestion);
			question.put("selectedType", selectedType);
			questions.add(question);
		}

		return questions;
	}

	private void selectQuestionBasedOnType(Map<String, String> question, WebElement element, WebElement sideClickType)
			throws Throwable {
		// Find the dropdown corresponding to the selectedType
//		String questionXpath = null;

		switch (question.get("selectedType")) {
		case "Text Box":
//			questionXpath = "//label[normalize-space()='Text Box']/..//select[@id='textbox_multiselect']";

			// Master Fields
//			questionXpath = "//input[@placeholder='Search...']/..//select[@id='multiselect']";
//			WebElement dropdownTextBox = driver.findElement(By.xpath(questionXpath));
			selectOptionFromDropdown(element, question.get("elementQuestion"));
			ClickUtilities.jsClick(driver, sideClickType);

			break;

//		case "Date":
////			questionXpath = "//label[normalize-space()='Date Picker']/..//select[@id='unique_multiselect']";
//			questionXpath = "//input[@placeholder='Search...']/..//select[@id='multiselect']";
//			WebElement dropdownDatePicker = driver.findElement(By.xpath(questionXpath));
//			selectOptionFromDropdown(dropdownDatePicker, question.get("elementQuestion"));
//			ClickUtilities.clickWithRetry(singleRightSelectedButtonDatePicker, 2);
//			break;
//
//		case "Multiple Choice":
////			questionXpath = "//label[normalize-space()='Multi Select']/..//select[@id='muti_unique_multiselect']";
//			questionXpath = "//input[@placeholder='Search...']/..//select[@id='multiselect']";
//			WebElement dropdownMultiSelect = driver.findElement(By.xpath(questionXpath));
//			selectOptionFromDropdown(dropdownMultiSelect, question.get("elementQuestion"));
//			ClickUtilities.clickWithRetry(singleRightSelectedButtonMultiSelect, 2);
//			break;
//
//		case "Drop Down":
////			questionXpath = "//label[normalize-space()='Dropdown']/..//select[@id='multiselect']";
//			questionXpath = "//input[@placeholder='Search...']/..//select[@id='multiselect']";
//			WebElement dropDown = driver.findElement(By.xpath(questionXpath));
//			selectOptionFromDropdown(dropDown, question.get("elementQuestion"));
//			ClickUtilities.clickWithRetry(singleRightSelectedButtonDropDown, 2);
//			break;

		default:
			System.out.println("Unknown type: " + question.get("selectedType"));
			return;
		}

	}

	private void selectOptionFromDropdown(WebElement dropdown, String optionText) {
		List<WebElement> options = dropdown.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (option.getText().equals(optionText)) {
				option.click();
				break;
			}
		}
	}

	public void validationsAfterMasterFilterAndMasterFields() throws Throwable {

//		Validations after Master Filter

		commonNaviagationToMasterForm();

		ClickUtilities.clickWithRetry(masterFieldsButton, 2);

		// Locate the first dropdown element
		WebElement firstDropdown = driver.findElement(By.id("multiselect_to"));
		Select selectFirst = new Select(firstDropdown);

		// Retrieve all options from the first dropdown
		List<WebElement> firstOptions = selectFirst.getOptions();
		List<String> firstOptionsText = new ArrayList<>();
		for (WebElement option : firstOptions) {
			firstOptionsText.add(option.getText());
		}

		// Perform click actions
		ClickUtilities.clickWithRetry(leftArrowButton, 2);
		Thread.sleep(2000); // Sleep to wait for the UI to update

		ClickUtilities.clickWithRetry(masterFilterButton, 2);

		// Locate the list of dropdowns
		List<WebElement> dropdownList = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//select[contains(@id,'multiselect_to')]")));

		for (WebElement dropdownElement : dropdownList) {
			// Retrieve all options from the current dropdown using JavaScriptExecutor
			@SuppressWarnings("unchecked")
			List<String> dropdownOptionsText = (List<String>) js.executeScript(
					"return Array.from(arguments[0].options).map(option => option.text);", dropdownElement);

			if (dropdownOptionsText.isEmpty()) {
				System.out.println("Dropdown with id: " + dropdownElement.getAttribute("id") + " has no options.");
				continue; // Skip this dropdown if it has no options
			}

			// Print the options for debugging
			System.out.println("First Array: " + firstOptionsText + "\nSecond Array: " + dropdownOptionsText);

			// Assert equality of the two arrays
			assertEquals(firstOptionsText, dropdownOptionsText, "The dropdown options are not equal.");
		}

		ClickUtilities.clickWithRetry(leftArrowButton, 2);

		Thread.sleep(1000);

	}

//	####################################### Updated Code ########################################
//	####################################### Updated Code ########################################
//	####################################### Updated Code ########################################
//	####################################### Updated Code ########################################
//	####################################### Updated Code ########################################

	public MasterFormPage processSelection() throws Throwable {

		processDropDownSelect(processDropDown, PropertieFileUtil.getSingleTextFromPropertiesFile("Process"))
				.subProcessDropDownSelect(subProcessDropDown,
						PropertieFileUtil.getSingleTextFromPropertiesFile("Subprocess"))
				.subSubProcessDropDownSelect(subSubProcessDropDown,
						PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess"));
		return this;
	}

	public MasterFormPage processDropDownSelect(WebElement processDropDown, String processValue) {

		assertTrue(processDropDown.isDisplayed());
		Select select = new Select(processDropDown);
		select.selectByVisibleText(processValue);

		return this;
	}

	public MasterFormPage subProcessDropDownSelect(WebElement subProcessDropDown, String subProcessValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='sub_process']/option")));

		unWait(1);
		assertTrue(subProcessDropDown.isDisplayed());
		Select select1 = new Select(subProcessDropDown);
		select1.selectByVisibleText(subProcessValue);

		return this;
	}

	public MasterFormPage subSubProcessDropDownSelect(WebElement subSubProcessDropDown, String subSubProcessValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='s_sub_process']/option")));

		unWait(1);
		assertTrue(subSubProcessDropDown.isDisplayed());
		Select select = new Select(subSubProcessDropDown);
		select.selectByVisibleText(subSubProcessValue);

		return this;
	}

	public MasterFormPage addPrimarySectionsDynamically(String secName, String fieldSetName) throws Throwable {

		click(driver, primarySectioAddButton);

		primarySectionAddSectionNameField(secName);

		unWait(1);
		click(driver, addSectionAddButton);
		unWait(1);

		String xpath = "(//button[normalize-space()='" + secName + "'])[1]";

		WebElement addedSectionInPrimarySection = driver.findElement(By.xpath(xpath));
		click(driver, addedSectionInPrimarySection);

		selectQuestionSetInDropdown(secName, fieldSetName);

		return this;
	}

	public MasterFormPage addMultipleSectionsDynamically(List<String> sectionNames, String fieldSetName)
			throws Throwable {
		for (int i = 0; i < sectionNames.size(); i++) {
			// Click the "Add Section" button to open the pop-up on the first iteration
			WebElement addSectionButton;
			if (i == 0) {
				addSectionButton = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[contains(@class,'first-section empty_section_c_area')]//a")));
			} else {
				// For subsequent iterations, click another XPath
				addSectionButton = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[contains(@class,'tb_c')]//a[contains(@onclick,'Secondary')]")));
			}

			CommonUtils.scrollToElementByActions(addSectionButton);
			addSectionButton.click();

			// Wait for the pop-up to appear and locate the section name input field

			addSectionFieldName.clear();
			addSectionFieldName.sendKeys(sectionNames.get(i)); // Enter the section name

			unWait(1);
			// Click the "Add" button in the pop-up
			addSectionAddButton.click();

			String xpath = "(//button[normalize-space()='" + sectionNames.get(i) + "'])[1]";

			WebElement addedSectionInPrimarySection = driver.findElement(By.xpath(xpath));
			click(driver, addedSectionInPrimarySection);

			selectQuestionSetInDropdown(sectionNames.get(i), fieldSetName);

			wait.until(ExpectedConditions.invisibilityOf(addSectionAddButton));
			// Small delay to ensure the UI updates before adding the next section
			unWait(1);
		}

		return this;
	}

//	Usage : 
//	List<String> sections = Arrays.asList("Test");
//	addSectionsDynamically(sections);

	private static LinkedHashMap<String, String> storedQuestions = new LinkedHashMap<>();
	private static LinkedHashMap<String, String[]> storedOptions = new LinkedHashMap<>();

	public static void loadStoredQuestions() {

		unWait(2);
	    try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/questions.properties")) {
	        Properties properties = new Properties();
	        properties.load(fileInputStream);

	        // Store questions in insertion order
	        properties.stringPropertyNames().stream()
	            .filter(key -> !key.endsWith("_type") && !key.endsWith("_options"))
	            .sorted()
	            .forEach(key -> storedQuestions.put(key, properties.getProperty(key)));

	        // Store options separately
	        properties.stringPropertyNames().stream()
	            .filter(key -> key.endsWith("_options"))
	            .forEach(key -> storedOptions.put(key.replace("_options", ""), properties.getProperty(key).split(",")));

	        System.out.println("Properties file reloaded successfully!");

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to load stored questions from properties file.");
	    }
	}


    public void validateMasterFormQuestions() {
        List<WebElement> questionContainers = driver.findElements(By.xpath("//div[@class='row']//div[contains(@class, 'custom-select')]"));

        // Ensure the number of questions match
        assertEquals(questionContainers.size(), storedQuestions.size(), "Mismatch in the number of questions!");

        int index = 0;
        for (Map.Entry<String, String> entry : storedQuestions.entrySet()) {
            String expectedQuestion = entry.getValue();
            WebElement questionContainer = questionContainers.get(index);
            WebElement questionLabel = questionContainer.findElement(By.tagName("label"));
            String actualQuestion = questionLabel.getText().trim();

            System.out.println("Validating Question " + (index + 1) + ": " + actualQuestion);
            assertEquals(actualQuestion, expectedQuestion, "Question order mismatch at index " + index);

            // Validate options if applicable
            validateOptionsIfExist(questionContainer, entry.getKey());

            index++;
        }
    }

    private void validateOptionsIfExist(WebElement questionContainer, String questionKey) {
        if (storedOptions.containsKey(questionKey)) {
            WebElement selectElement;
            try {
                // Locate the select element inside the same container
                selectElement = questionContainer.findElement(By.tagName("select"));
            } catch (Exception e) {
                System.out.println("No dropdown found for: " + questionContainer.getText());
                return;
            }

            List<WebElement> optionElements = selectElement.findElements(By.tagName("option"));
            List<String> actualOptions = optionElements.stream()
                .map(WebElement::getText)
                .filter(option -> !option.equalsIgnoreCase("Select")) // Ignore default "Select" option
                .collect(Collectors.toList());

            List<String> expectedOptions = Arrays.asList(storedOptions.get(questionKey));

            // Print expected and actual options
            System.out.println("Validating options for: " + questionContainer.findElement(By.tagName("label")).getText());
            System.out.println("Expected Options: " + expectedOptions);
            System.out.println("Actual Options: " + actualOptions);

            assertEquals(actualOptions, expectedOptions, "Options mismatch for question: " + questionContainer.findElement(By.tagName("label")).getText());
        }
    }


	public void finalizeMasterFormPage() throws Throwable {

		click(driver, finalizeButtton);

		wait.until(ExpectedConditions.visibilityOf(finalizePopUpText1));
		String finalizePopupText = "Are you sure you want to finalize ?";

		assertEquals(finalizePopupText, finalizePopUpText1.getText());

		click(driver, finalizeButttonInPopUp);

		wait.until(ExpectedConditions.visibilityOf(finalizeSuccessPopUp));
		assertTrue(finalizeSuccessPopUp.isDisplayed(), "finalizeSuccessPopUp is not displayed.");

		click(driver, finalizeSuccessPopUpContinueButton);

	}

}
