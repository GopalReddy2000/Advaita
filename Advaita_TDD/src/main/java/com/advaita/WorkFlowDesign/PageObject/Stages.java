package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.CommonUtils;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;
import com.advaita.Utilities.SendDataUtils;

public class Stages extends TestBase {

	SoftAssert softAssert = new SoftAssert();

	static private String stageListingPageUrl = mainURl+"en/stages/stages_list/";
	static private String stagesCraeteFormURL = mainURl+"en/stages/create_stages/";

	public static String fetchProcessRecord;
	public static String fetchSubProcessRecord;
	public static String fetchSubSubProcessRecord;
	public static String fetchMetaTextDataRecord;

	@FindBy(linkText = "+ Add Non Measurable Set")
	public WebElement addNonMeasurableSetButton;

	@FindBy(xpath = "//table[contains(@class,'non-measurable-table')]/tbody/tr[1]/td[1]")
	public WebElement nonMeasurableText;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td//div[contains(@class, 'content')]//span[contains(@class, 'first_tree')]")
	public WebElement dropDown1;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td//div[contains(@class, 'content')]//span[contains(@class, 'second_tree')]")
	public WebElement dropDown2;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[1]/td//div[contains(@class, 'content')]//span[contains(@class, 'first_tree')]")
	public WebElement fetchProcess;

	@FindBy(xpath = "//table[@class='process_table w-100']/tbody/tr[2]/td//div[contains(@class, 'content')]//span[contains(@class, 'second_tree')]")
	public WebElement fetchsubProcess;

	@FindBy(xpath = "(//table[@class='process_table w-100']/tbody/tr[2]/td[1]//span)[3]")
	public WebElement fetchsubSubProcess;

	@FindBy(xpath = "//span[normalize-space()='Workflow Design']")
	public WebElement workFlowStagesTab;

	@FindBy(xpath = "//button[normalize-space()='Stages']")
	public WebElement stagesTab;

	@FindBy(xpath = "//img[@alt='justify_icon']/..//h1[text()=' Stages ']")
	public WebElement stageListingPage;

	@FindBy(linkText = "+ Create")
	public WebElement stagesCreateButton;

	@FindBy(xpath = "//div[@class='stage1-workflow page_body']/..//form[@id='submit_stages']")
	public WebElement stagesCreateFormElement;

	@FindBy(xpath = "//h3[text()='Stage Name*']/..//input[@id='stage_name']")
	public WebElement stageNameTextBoxElement;

	@FindBy(xpath = "//select[@id='process']")
	public WebElement selectProcessDropDownElement;

	@FindBy(xpath = "//select[@id='sub_process']")
	public WebElement selectSubProcessDropDownElement;

	@FindBy(xpath = "//select[@id='s_sub_process']")
	public WebElement selectSubSubProcessDropDownElement;

	@FindBy(xpath = "//h3[text()='Calculation Type']/..//select[@id='calculation_type']")
	public WebElement calculationTypeDropDownElement;

	@FindBy(xpath = "(//h2[@id='headingOne']/..//h6[text()='SECTION A'])[1]")
	public WebElement sectionA_ExpantionPanel;

	@FindBy(xpath = "//img[@alt='addmeta-file']/..//h6[text()='Please Add Some Meta Data']")
	public WebElement addMetaDataMassageInSectionAElement;

	@FindBy(xpath = "//a[text()='Add']/..//a[@data-section='Section A']")
	public WebElement addButtonInSectionAElement;

	@FindBy(id = "pills-metadata-tab")
	public WebElement metaDataTab;

	@FindBy(xpath = "//div[@class='dataset_table']//table/tbody/tr[1]/td[1]")
	public WebElement fetchMetaData;

	@FindBy(xpath = "//div[@class='modal-content p-0 ']/div/h1[text()='Select Section A']")
	public WebElement addSectionAPopUp;

	@FindBy(name = "metadata_names")
	public WebElement selectMetaDatDropDownElement;

	@FindBy(id = "sectionB_metadata_id")
	public WebElement sectionBMetaDataDropdown;

	@FindBy(id = "sectionA_metadata_id")
	public WebElement sectionAMetaDataDropdown;

	@FindBy(xpath = "//input[@name='sectionA_fieldname']")
	public WebElement metaDataFieldCheckBoxesElement;

	@FindBy(xpath = "(//a[contains(@class,'sectionA_addbtn')])[1]")
	public WebElement addButtonInaddSectionAPopUp;

	@FindBy(xpath = "//a[text()='edit']/..//a[@data-section='Section A']")
	public WebElement editButtonInSectionAElement;

	@FindBy(xpath = "(//div[@class='modal-content p-0 ']/..//a[normalize-space()='Cancel'])[1]")
	public WebElement cancelButtonInaddSectionAPopUp;

	@FindBy(xpath = "(//h2[@id='headingTwo']/..//h6[text()='SECTION B'])[1]")
	public WebElement sectionB_ExpantionPanel;

	@FindBy(xpath = "//label[normalize-space()='Add Blocks']/..//div[@class='input-group']")
	public WebElement addBlocksElement;

	@FindBy(xpath = "//label[normalize-space()='Add Blocks']/..//button[@data-type='minus']")
	public WebElement removeBlocksButtonElement;

	@FindBy(xpath = "//label[normalize-space()='Add Blocks']/..//button[@data-type='plus']")
	public WebElement addBlocksButtonElement;

	@FindBy(xpath = "//select[@id='sectionB_metadata_id']")
	public WebElement blockNameMetaDataDropDown;

	@FindBy(xpath = "//label[contains(normalize-space(),'BLOCK NAME')]")
	public List<WebElement> addedBlocksElement;

	@FindBy(xpath = "//h1[normalize-space()='Select Section B']/../..//a[normalize-space()='Add']")
	public WebElement sectionBAddButton;

	@FindBy(xpath = "(//a[contains(@class,'section_c_add_popup')][normalize-space()='Add'])[1]")
	public WebElement addSomeSectionButton;

	@FindBy(xpath = "//h1[normalize-space()='Add Section']")
	public WebElement addSomeSectionPopUp;

	@FindBy(xpath = "//input[@name='section_name']")
	public WebElement sectionNameField;

	@FindBy(xpath = "//input[@name='section_weightage']")
	public WebElement sectionWeightageField;

	@FindBy(xpath = "//h1[normalize-space()='Add Section']/../..//a[normalize-space()='Add']")
	public WebElement addSomeSectionPopUpAddButton;

	@FindBy(xpath = "//ul[@id='pills-tab']/..//button")
	public List<WebElement> addedSections;

	@FindBy(xpath = "(//label[normalize-space()='Measurable Set']/input[@type='radio'])[1]")
	public WebElement measurableRadioButton;

	@FindBy(xpath = "(//label[normalize-space()='Non Measurable Set']/input[@type='radio'])[1]")
	public WebElement nonMeasurableRadioButton;

	@FindBy(xpath = "//select[@data-type='Mesaurable']")
	public WebElement measurableQuestionSet;

	@FindBy(xpath = "//select[@data-type='NonMesaurable']")
	public WebElement nonMeasurableQuestionSet;

	@FindBy(xpath = "//label[normalize-space()='Manual']/input[@type='radio']")
	public WebElement manualRadioButton;

	@FindBy(xpath = "//button[@class='btn-primary'][normalize-space()='Save']")
	public WebElement saveButton;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Stage has been created successfully']")
	public WebElement confirmationMSG;

	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Stage has been Deleted successfully']")
	public WebElement deleteConfirmationMSG;

	@FindBy(xpath = "//h3[text()='Success']/..//button[normalize-space()='Continue']")
	public WebElement continueButton;

	@FindBy(xpath = "//img[@class='arrow-left']")
	public WebElement leftArrowOrBackButton;

	@FindBy(id = "text_search")
	public WebElement searchBar;

	@FindBy(xpath = "//button[contains(@class,'filter_search')]/img")
	public WebElement searchButton;

	@FindBy(xpath = "//span[@id='change_error_msg']")
	public static WebElement errorPop;

	@FindBy(xpath = "//label[@id='stage_name-error']")
	public static WebElement stageNameError;

	@FindBy(id = "submit_single")
	public WebElement singeSubmit;

	@FindBy(xpath = "//div[contains(@class,'dynamic_data_sectionA')]//label")
	public List<WebElement> sectionMetadata;

	@FindBy(xpath = "//a[@data-section='Section A' and text()='edit']")
	public WebElement sectionAEdit;

	@FindBy(xpath = "//table/thead/tr/../..//tbody//td[normalize-space()='Evaluation Fields']/..//a/img")
	public WebElement evaluationFields;

	@FindBy(xpath = "//select[@id='multiselect']")
	public WebElement stageEvaluationDropdown;

	@FindBy(xpath = "//button[@data-type='minus']")
	public WebElement addBlockMinus;

	@FindBy(xpath = "//a[contains(@class,'section_c') and not(contains(@class,'mr_18')) and text()='Add']")
	public WebElement sectionCAdd;

	@FindBy(xpath = "//input[@name='section_name']")
	public WebElement sectionName;

	@FindBy(xpath = "//input[@name='section_weightage']")
	public WebElement sectionWeightage;

	@FindBy(xpath = "//a[contains(@class,'section_common_addcls')]")
	public WebElement sectionCAddButton;

	@FindBy(xpath = "//a[contains(@class,'section_common_addcls')]//following-sibling::a")
	public WebElement sectionCCancelButton;

	@FindBy(xpath = "//label[@id='section_name-error']")
	public static WebElement sectionNameError;

	@FindBy(xpath = "(//a/img[@title='Evaluation Fields'])[1]")
	public static WebElement evalutionFieldButton;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement saveButton2;

	@FindBy(id = "filter_date")
	public WebElement filterDate;

	@FindBy(xpath = "//button[@id='multiselect_rightAll']")
	public WebElement selectAll;

	private WebElement sectionBAddButton(int sectionNumber) {
		String xpath = "//a[@data-columncnt='" + sectionNumber + "' and text()='Add']";

		return driver.findElement(By.xpath(xpath));
	}

	public Stages() {
		PageFactory.initElements(driver, this);
	}

	HomePage hp = new HomePage();

	public Stages navigateFetchProcessRecord(boolean wantToFetchRecord) throws Throwable {

		driver.navigate().to(mainURl+"en/data_management/process/");

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

		fetchSubProcessRecord = fetchsubProcess.getText();
		assertNotNull(fetchSubProcessRecord, "fetchSubProcessRecord is null.");

		fetchSubSubProcessRecord = fetchsubSubProcess.getText();
		assertNotNull(fetchSubSubProcessRecord, "fetchSubSubProcessRecord is null.");

		click(driver, metaDataTab);

		Thread.sleep(1000);
		fetchMetaTextDataRecord = fetchMetaData.getText();
		assertNotNull(fetchMetaTextDataRecord, "fetchMetaDataRecord is null.");

		System.out.println(fetchMetaTextDataRecord);

		if (wantToFetchRecord) {
			PropertieFileUtil.storeTextInPropertiesFile(fetchProcessRecord, fetchSubProcessRecord,
					fetchSubSubProcessRecord, fetchMetaTextDataRecord, true);
		}

		navigateToStages();

		return this;
	}

	public void navigateToStages() {

		driver.navigate().to(mainURl+"en/stages/stages_list/");
	}

	public void navigateNonMeasurableCreate() throws Throwable {

		click(driver, hp.workflowDesign);
		assertTrue(hp.masterParameterPage.isDisplayed());
		click(driver, hp.nonMeasurableSetTab);
		click(driver, addNonMeasurableSetButton);
	}

	public void navigateToStagesFromMeasurable() throws Throwable {

		click(driver, hp.workflowDesign);
		assertTrue(hp.masterParameterPage.isDisplayed());
		click(driver, hp.nonMeasurableSetTab);

		PropertieFileUtil.storeSingleTextInPropertiesFile("nonMeasurable", nonMeasurableText.getText());

		click(driver, stagesTab);
	}

	public Stages verifyStagesTabIsDisplayed(boolean navigateToStages, boolean navigateToStagesFromMeasurable)
			throws Throwable {

		if (navigateToStages) {
			navigateToStages();
		}
		if (navigateToStagesFromMeasurable) {
			navigateToStagesFromMeasurable();
		}

//		String stageListingPageUrl = "https://test.capture.autosherpas.com//en/stages/stages_list/";

		assertTrue(workFlowStagesTab.isDisplayed(), "workFlowStagesTab is not displayed");
//		click(driver, workFlowStagesTab);
		assertTrue(stageListingPage.isDisplayed(), "stageListingPage is not displayed");
		assertEquals(driver.getCurrentUrl(), stageListingPageUrl);

		return this;
	}

	public Stages verifyCreateStagesButton() {

//		String stagesCraeteFormURL = "https://test.capture.autosherpas.com/en/stages/create_stages/"; 

		assertTrue(stagesCreateButton.isDisplayed() && stagesCreateButton.isEnabled(),
				"stagesCreateButton is not displayed and enabled.");
		click(driver, stagesCreateButton);

		assertTrue(stagesCreateFormElement.isDisplayed(), "stagesCreateFormElement is not displayed.");
		assertEquals(driver.getCurrentUrl(), stagesCraeteFormURL);

		return this;
	}

	public Stages navigateToStageCreate() {
		workFlowStagesTab.click();
		stagesTab.click();
		stagesCreateButton.click();

		return this;

	}

	public Stages verifyStageNameTextBox(String StageName) {

		// Check if the Stage Name field is mandatory or not.
		String text = driver.findElement(By.xpath("//h3[text()='Stage Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		// Stage field is displayed or not
		assertTrue(stageNameTextBoxElement.isDisplayed(), "stageNameTextBoxElement is displayed.");
		stageNameTextBoxElement.clear();
		stageNameTextBoxElement.sendKeys(StageName);

		return this;
	}

	public Stages verifyStageSelectAllProcessDropDown() throws Throwable {

		verifyStageSelectProcessDropDown().verifyStageSelectSubProcessDropDown()
				.verifyStageSelectSubSubProcessDropDown();
		return this;
	}

	public Stages verifyStageSelectProcessDropDown() throws Throwable {

		String text = driver.findElement(By.xpath("//h3[text()='Process*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		Thread.sleep(1000);
		assertTrue(selectProcessDropDownElement.isDisplayed(), "selectProcessDropDownElement is not displayed.");

		Select select = new Select(selectProcessDropDownElement);
		Thread.sleep(1000);
		System.out.println("process : " + PropertieFileUtil.getSingleTextFromPropertiesFile("process"));
		select.selectByVisibleText(PropertieFileUtil.getSingleTextFromPropertiesFile("process"));

		return this;
	}

	public Stages verifyStageSelectSubProcessDropDown() throws Throwable {

		String text = driver.findElement(By.xpath("//h3[text()='Sub Process*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		Thread.sleep(1000);
		assertTrue(selectSubProcessDropDownElement.isDisplayed(), "selectSubProcessDropDownElement is not displayed.");

		wait.until(ExpectedConditions.visibilityOf(selectSubProcessDropDownElement));
		Select select = new Select(selectSubProcessDropDownElement);
		Thread.sleep(1000);

		System.out.println("subProcess : " + PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess"));
		select.selectByVisibleText(PropertieFileUtil.getSingleTextFromPropertiesFile("subProcess"));

		return this;
	}

	public Stages verifyStageSelectSubSubProcessDropDown() throws Throwable {

		String text = driver.findElement(By.xpath("//h3[text()='Sub Sub Process*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		assertTrue(selectSubSubProcessDropDownElement.isDisplayed(),
				"selectSubSubProcessDropDownElement is not displayed.");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='s_sub_process']/option")));
		
		Select select = new Select(selectSubSubProcessDropDownElement);
		Thread.sleep(1000);

		System.out.println("subSubProcess : " + PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess"));
		select.selectByVisibleText(PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess"));

		wait.until(ExpectedConditions.textToBePresentInElement(selectSubSubProcessDropDownElement,
				PropertieFileUtil.getSingleTextFromPropertiesFile("subSubProcess")));

		return this;
	}

	public Stages verifyStageCalculationTypeDropDown() throws Throwable {

		assertTrue(calculationTypeDropDownElement.isDisplayed(), "calculationTypeDropDownElement is not displayed.");

		Select select = new Select(calculationTypeDropDownElement);

		// Get all options from the drop-down
		List<WebElement> options = select.getOptions();

		String list = "Question Wise" + "Parameter Wise" + "Domain Wise";

		// Iterate through the options and print the text of each option
		for (WebElement option : options) {

			assertTrue(list.contains(option.getText()));

		}

		select.selectByVisibleText("Question Wise");
//		select.selectByVisibleText("Domain Wise");
//		select.selectByVisibleText("Parameter Wise");

		return this;
	}

	public Stages verifyAddSectionA(boolean uniqueIdMataDataField, boolean allMetaDataField,
			boolean clickUpToFourthLastElement) throws Throwable {

		assertTrue(sectionA_ExpantionPanel.isDisplayed(), "WebsectionA_ExpantionPanel is not displayed.");
		assertTrue(addMetaDataMassageInSectionAElement.isDisplayed(),
				"addMetaDataMassageInSectionAElement is not displayed.");

		assertTrue(addButtonInSectionAElement.isDisplayed(), "addButtonInSectionAElement is not displayed.");

		click(driver, addButtonInSectionAElement);

		wait.until(ExpectedConditions.visibilityOf(addSectionAPopUp));
		assertTrue(addSectionAPopUp.isDisplayed(), "addSectionAPopUp is not displayed.");

		assertTrue(
				DropDown.isTextPresentInDropDown(selectMetaDatDropDownElement,
						PropertieFileUtil.getSingleTextFromPropertiesFile("metaData")),
				"fetched meta data is not present in meta data drop down.");

		Select select = new Select(selectMetaDatDropDownElement);

		select.selectByVisibleText(PropertieFileUtil.getSingleTextFromPropertiesFile("metaData"));

		if (uniqueIdMataDataField) {

			driver.findElement(By.xpath("(//input[@name='sectionA_fieldname'])[last()-3 > 0 and position()=last()-3]"))
					.click();
		}

		if (allMetaDataField) {
			List<WebElement> checkBoxElements = wait.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='sectionA_fieldname']")));

			for (int i = 0; i < checkBoxElements.size(); i++) {
				WebElement element = checkBoxElements.get(i);
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			}
		}
//		if (clickUpToFourthLastElement) {
//			// Find all matching elements
//			List<WebElement> elements = driver.findElements(By.xpath("//input[@name='sectionA_fieldname']"));
//
//			// Calculate the last index to click
//			int totalElements = elements.size();
//			int lastIndexToClick = totalElements - 3;
//
//			// Click elements up to the fourth last element
//			for (int i = 0; i < lastIndexToClick; i++) {
//				elements.get(i).click();
//			}
			if (clickUpToFourthLastElement) {
				// Find all matching elements
				List<WebElement> elements = driver.findElements(By.xpath("//input[@name='sectionA_fieldname']"));
				
				for(WebElement ele : elements) {
					System.out.println("Section A :"+ele.findElement(By.xpath("./../label")).getText());
					
				}
				
				int totalCheckboxes = elements.size();
				int clickLimit = Math.max(1, totalCheckboxes - 5); // Always click at least 1, and ignore last 4 if possible
				
				System.out.println("totalCheckboxes : "+totalCheckboxes+"\n"+"clickLimit : "+clickLimit);

				for (int i = 0; i < clickLimit; i++) {
				    WebElement checkbox = elements.get(i);
				    if (!checkbox.isSelected()) {
				        checkbox.click();
				    }
				}

		}

		assertTrue(addButtonInaddSectionAPopUp.isDisplayed(), "addButtonInaddSectionAPopUp is not displayed.");
		click(driver, addButtonInaddSectionAPopUp);

		wait.until(ExpectedConditions.visibilityOf(editButtonInSectionAElement));
		js.executeScript("arguments[0].scrollIntoView(true);", editButtonInSectionAElement);
		assertTrue(editButtonInSectionAElement.isDisplayed(), "editButtonInSectionAElement is not displayed.");

		click(driver, editButtonInSectionAElement);

		unWait(1);

		assertTrue(
				DropDown.validateSelectedDropdownOption(selectMetaDatDropDownElement,
						PropertieFileUtil.getSingleTextFromPropertiesFile("metaData")),
				"fetched meta data is not present in meta data drop down.");

		wait.until(ExpectedConditions.visibilityOf(cancelButtonInaddSectionAPopUp));
		assertTrue(cancelButtonInaddSectionAPopUp.isDisplayed(), "cancelButtonInaddSectionAPopUp is not displayed.");
		cancelButtonInaddSectionAPopUp.click();

		return this;
	}

	public void verifySectionB() {
		wait.until(ExpectedConditions.visibilityOf(sectionB_ExpantionPanel));
		assertTrue(sectionB_ExpantionPanel.isDisplayed(), "Section B panel is not displayed.");
		assertTrue(addBlocksElement.isDisplayed(), "Add blocks element is not displayed.");
	}

	public Stages verifyAddAndRemoveBlockInSectionB(int count) throws Throwable {
		verifySectionB();
		clickMultipleTimes(addBlocksButtonElement, count);
		assertEquals(addedBlocksElement.size(), count + 1, "Block count mismatch.");
		clickMultipleTimes(removeBlocksButtonElement, count);
		return this;
	}

	private void clickMultipleTimes(WebElement element, int times) throws Throwable {
		for (int i = 0; i < times; i++) {
			ClickUtilities.clickWithRetry(element, 2);
		}
	}

//	public Stages selectMetaDataInAddBlockSectionB(int count) throws Throwable {
//
//		for (int i = 1; i < count; i++) {
//
//			ClickUtilities.clickWithRetry(addBlocksButtonElement, 2);
//		}
//
//		List<WebElement> addButtonInSectionB = driver.findElements(By.xpath(
//				"//div[contains((@class),('sectionA-addfile block-name section_Bblock'))]//h6[normalize-space()='Please Add Some Meta Data']/..//a[normalize-space()='Add']"));
//
//		for (WebElement addButton : addButtonInSectionB) {
//
//			js.executeScript("arguments[0].scrollIntoView(true);", addButton);
//			ClickUtilities.clickWithRetry(addButton, 2);
//
//			Select select = new Select(blockNameMetaDataDropDown);
//
//			List<WebElement> options = select.getOptions();
//			for (WebElement option : options) {
//				String optionText = option.getText();
//				System.out.println(optionText);
//			}
//
//			select.selectByVisibleText(PropertieFileUtil.getTextFromPropertiesFile("metaDataText"));
//
//			List<WebElement> checkBoxElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//					By.xpath("//h1[normalize-space()='Select Section B']/../..//input[@name='sectionA_fieldname']")));
//
//			for (int i = 0; i < checkBoxElements.size(); i++) {
//				WebElement element = checkBoxElements.get(i);
//				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//			}
//
//			sectionBAddButton.click();
//
//		}
//
//		return this;
//
//	}

	public Stages selectMetaDataInAddBlockSectionB(int count, boolean uniqueIdMataDataField, boolean allMataDataField)
			throws Throwable {
		clickMultipleTimes(addBlocksButtonElement, count - 1);

		List<WebElement> addButtons = driver.findElements(By.xpath(
				"//div[contains(@class, 'sectionA-addfile block-name section_Bblock')]//h6[normalize-space()='Please Add Some Meta Data']"
						+ "/..//a[normalize-space()='Add']"));

		for (WebElement addButton : addButtons) {

			ClickUtilities.scrollToViewElement(addButton);
//			wait.until(ExpectedConditions.visibilityOf(addButton));
			ClickUtilities.clickWithRetry(addButton, 2);

			Select select = new Select(blockNameMetaDataDropDown);

//	        List<WebElement> options = select.getOptions();
			wait.until(ExpectedConditions.visibilityOfAllElements(select.getOptions()));

			select.selectByVisibleText(PropertieFileUtil.getSingleTextFromPropertiesFile("metaData"));

			if (uniqueIdMataDataField) {
				driver.findElement(By.xpath(
						"(//h1[normalize-space()='Select Section B']/../..//input[@name='sectionA_fieldname'])[last()-3 > 0 and position()=last()-3]"))
						.click();

				sectionBAddButton.click();
			}

			if (allMataDataField) {
				List<WebElement> checkBoxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
						.xpath("//h1[normalize-space()='Select Section B']/../..//input[@name='sectionA_fieldname']")));

				checkBoxes.forEach(box -> wait.until(ExpectedConditions.elementToBeClickable(box)).click());
				sectionBAddButton.click();
			}

		}
		return this;
	}

	public final static String callLogStageView = "Call Log Stage View";
	public final static String agencyValidation = "Agency Validation";
	public final static String rejectedAuditForm = "Rejected Audit Form";
	public final static String auditTheAuditor = "Audit the Auditor";
	public final static String validationStatusReport = "Validation Status Report";

	String[] allOptionsMeasurable = { callLogStageView, agencyValidation, rejectedAuditForm, auditTheAuditor,
			validationStatusReport };

	public Stages addSection(int count, boolean measurableRadio, boolean nonMeasurableRadio, String... optionNames)
			throws Throwable {

		for (int i = 1; i <= count; i++) {
			// Use the appropriate index for the section's "Add" button (1 for the first, 2
			// for the rest)
			String xPath = "(//a[contains(@class,'section_c_add_popup')][normalize-space()='Add'])[" + (i == 1 ? 1 : 2)
					+ "]";
			WebElement addSomeSectionButton = driver.findElement(By.xpath(xPath));
			click(driver, addSomeSectionButton);

			wait.until(ExpectedConditions.visibilityOf(addSomeSectionPopUp));
			assertTrue(addSomeSectionPopUp.isDisplayed(), "addSomeSectionPopUp is not displayed.");

			// Verify and fill the section name and weightage fields
			String sectionName = "DemoSec" + i;
			String sectionWeightage = "TestWeightage" + i;

			FieldVerificationUtils.verifyTextField(sectionNameField, "Section Name", sectionName, true, false, 1);

			FieldVerificationUtils.verifyTextField(sectionWeightageField, "Weightage", sectionWeightage, false, true,
					1);

			// Click the 'Add' button to confirm section addition
			click(driver, addSomeSectionPopUpAddButton);
		}

		int elementsToClick = Math.min(addedSections.size(), count);

		// Iterate through the first 'elementsToClick' elements using a normal for loop
		for (int i = 0; i < elementsToClick; i++) {
			// Access each section from addedSections
			WebElement section = addedSections.get(i);

			wait.until(ExpectedConditions.visibilityOf(section));

			if (section.isDisplayed() && section.isEnabled()) {

				ClickUtilities.scrollToViewElement(section);

				jsClick(section);
//				section.click();

				if (measurableRadio) {

					measurableRadioButton.click();
				}
				if (nonMeasurableRadio) {

					wait.until(ExpectedConditions.visibilityOf(nonMeasurableRadioButton));
//					ClickUtilities.clickWithRetry(nonMeasurableRadioButton, 3);
					jsClick(nonMeasurableRadioButton);

					System.out.println(
							"Non Measurable : " + PropertieFileUtil.getSingleTextFromPropertiesFile("nonMeasurable"));

				}

				clickOnCheckBoxes(allOptionsMeasurable, "all");
				clickOnCheckBoxes(allOptionsMeasurable, optionNames);

				DropDown.dropdownWithAllPosibleValidation(nonMeasurableQuestionSet, "Select",
						PropertieFileUtil.getSingleTextFromPropertiesFile("nonMeasurable"));

			} else {
				System.out.println("Element not clickable or displayed: " + section.toString());
			}
		}

		return this;
	}

	public void clickOnCheckBoxes(String[] allOptions, String... optionNames) {
		// If 'all' is specified, click all checkboxes
		if (optionNames.length == 1 && "all".equalsIgnoreCase(optionNames[0])) {
			for (String option : allOptions) {
				clickCheckBoxByLabel(option);
			}
		} else {
			// Loop through the provided options and click the corresponding checkboxes
			for (String optionName : optionNames) {
				clickCheckBoxByLabel(optionName);
			}
		}
	}

	private void clickCheckBoxByLabel(String labelText) {
		try {
			// Construct the dynamic XPath using the label text
//			String dynamicXPath = "//label[text()='Show in " + labelText
//					+ "']/preceding-sibling::input[@type='checkbox']";

			String dynamicXPath = "//label[contains(text(),'" + labelText
					+ "')]/preceding-sibling::input[@type='checkbox']";
			WebElement checkBox = driver.findElement(By.xpath(dynamicXPath));

			// Click the checkbox using the custom click method
//			click(driver, checkBox);
			checkBox.sendKeys(Keys.SPACE);
		} catch (NoSuchElementException e) {
			System.out.println("Checkbox for '" + labelText + "' not found.");
		}
	}

	private void clickCheckToggleByLabel(String labelText, boolean clickOnlyIfSelected) {
		try {
			// Construct dynamic XPath to locate the checkbox toggle button based on label
			// text
			String dynamicXPath = "//h7[contains(text(),'" + labelText + "')]/../..//input[@type='checkbox']";

			// Locate the toggle button element
			WebElement toggleButton = driver.findElement(By.xpath(dynamicXPath));

			if (clickOnlyIfSelected) {
				// Dynamic execution: Only click if the toggle button is selected
				if (toggleButton.isSelected()) {
					System.out.println("Toggle button is currently ON. Clicking to turn it OFF.");
					jsClick(toggleButton);
				} else {
					System.out.println("Toggle button is already OFF. No need to click.");
				}
			} else {
				// Normal execution: Click regardless of the current state
				System.out.println("Clicking toggle button regardless of its current state.");
				jsClick(toggleButton);
			}

		} catch (NoSuchElementException e) {
			// Handle the case when the checkbox is not found
			System.out.println("Checkbox for '" + labelText + "' not found.");
		}
	}

	public void clickOnToggleButton(boolean clickOnlyIfSelected, String[] allOptions, String... optionNames) {
		// If 'all' is specified, click all checkboxes
		if (optionNames.length == 1 && "all".equalsIgnoreCase(optionNames[0])) {

			for (String option : allOptions) {
				clickCheckToggleByLabel(option, clickOnlyIfSelected);
			}
		} else {
			// Loop through the provided options and click the corresponding checkboxes
			for (String optionName : optionNames) {
				clickCheckToggleByLabel(optionName, clickOnlyIfSelected);
			}
		}
	}

	// Actions
	public final static String voiceCall = "Voice Call";
	public final static String whatsAppCall = "WhatsApp Call";
	public final static String recording = "Recording";
	public final static String sms = "SMS";
	public final static String email = "Email";
	public final static String clickToCall = "Click to Call";
	public final static String gsmGateway = "GSM Gateway";
	public final static String audioPlayer = "Audio Player";
	public final static String cloudPhone = "Cloud Phone";

	// String array to store all variables
	public final static String[] communicationOptions = { voiceCall, whatsAppCall, recording, sms, email, clickToCall,
			gsmGateway, audioPlayer, cloudPhone };

	public Stages actionSection(String... optionNames) {

		clickOnCheckBoxes(communicationOptions, optionNames);

		return this;
	}

	public final static String recordingRequired = "Recording Required";
	public final static String evaluationRequired = "Evaluation Required";
	public final static String openSample = "Open Sample";
	public final static String showAuditScore = "Show Audit Score";
	public final static String assignedTo = "Assigned To";
	public final static String allowAutoFetch = "Allow Auto Fetch";
	public final static String allowAutoFetchWithAllocation = "Allow Auto Fetch With Allocation";
	public final static String allowQuestionMovement = "Allow Question Movement";
	public final static String allowOthersToTakeAction = "Allow Others To Take Action";
	public final static String scheduler = "Scheduler";
	public final static String enableTicketModule = "Enable Ticket Module";
	public final static String captureLocation = "Capture Location";
	public final static String showSkipAudit = "Show Skip Audit";
	public final static String showDisposition = "Show Disposition";
	public final static String showSmsHistory = "Show SMS History";
	public final static String showWhatsappHistory = "Show Whatsapp History";
	public final static String showEmailHistory = "Show Email History";
	public final static String showInteractionHistory = "Show Interaction History";
	public final static String showStageHistory = "Show Stage History";
	public final static String previewPreviousStageHistory = "Preview Previous Stage History";
	public final static String showUserDocuments = "Show User Documents";

	// String array to store all variables
	public final static String[] auditOptions = { recordingRequired, evaluationRequired, openSample, showAuditScore,
			assignedTo, allowAutoFetch, allowAutoFetchWithAllocation, allowQuestionMovement, allowOthersToTakeAction,
			scheduler, enableTicketModule, captureLocation, showSkipAudit, showDisposition, showSmsHistory,
			showWhatsappHistory, showEmailHistory, showInteractionHistory, showStageHistory,
			previewPreviousStageHistory, showUserDocuments };

	public Stages actionSectionToggle(String... optionNames) {

		clickOnToggleButton(true, auditOptions, "all");
		clickOnToggleButton(false, auditOptions, optionNames);

		return this;
	}

	public Stages dispositionSection() {

		ClickUtilities.scrollToViewElement(manualRadioButton);

		jsClick(manualRadioButton);

		return this;
	}

	public Stages saveAndConfirmation() {

		click(driver, saveButton);
		wait.until(ExpectedConditions.visibilityOf(confirmationMSG));
		assertTrue(confirmationMSG.isDisplayed(), "confirmation masg is not displayed.");
		click(driver, continueButton);
		click(driver, leftArrowOrBackButton);
		return this;
	}

	public Stages deleteAndConfirmation(String stageName) {
		String createdStageDeleteXPath = "//tr[@class='Question-set']/td/a[normalize-space()='" + stageName
				+ "']/../../td[6]//img[contains(@alt,'delete-icon')]";
		WebElement createdStageDeleteButton = driver.findElement(By.xpath(createdStageDeleteXPath));

		assertTrue(createdStageDeleteButton.isDisplayed(), "createdStageDeleteButton is not displayed.");
		click(driver, createdStageDeleteButton);
		click(driver, driver.findElement(By.xpath("//button[@type='submit'][text()='Delete']")));

		wait.until(ExpectedConditions.visibilityOf(deleteConfirmationMSG));
		assertTrue(deleteConfirmationMSG.isDisplayed(), "delete Confirmation masg is not displayed.");
		click(driver, continueButton);
		return this;
	}

	private WebElement sectionCTab(String sectionName) {
		String xpath = "//button[text()='" + sectionName + "']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement measurableSetRadioButton(String sectionName) {
		String xpath = "//label[normalize-space()='Measurable Set']//input[@data-sectionname='" + sectionName + "']";
		return driver.findElement(By.xpath(xpath));
	}

	private WebElement nonMeasurableSetRadioButton(String sectionName) {
		String xpath = "//label[normalize-space()='Non Measurable Set']//input[@data-sectionname='" + sectionName
				+ "']";
		return driver.findElement(By.xpath(xpath));
	}

	public Stages measurableDropdown(String sectionCName, String measurableSet) {

		jsClick(addSomeSectionButton);
		unWaitInMilli(400);
		sendKeys(sectionNameField, sectionCName);
		unWaitInMilli(500);
		jsClick(sectionCAddButton);

		jsClick(sectionCTab(sectionCName));

		jsClick(measurableSetRadioButton(sectionCName));

		jsWindowsScrollIntoView(measurableQuestionSet);
		unWaitInMilli(500);
		selectByVisibleText(measurableQuestionSet, measurableSet);

		return this;
	}

	public Stages nonMeasurableDropdown(String sectionCName, String nonMeasurableSet) {

		jsClick(addSomeSectionButton);
		sendKeys(sectionNameField, sectionCName);
		unWaitInMilli(500);
		jsClick(sectionCAddButton);

		jsClick(sectionCTab(sectionCName));
		unWaitInMilli(500);
		jsClick(nonMeasurableSetRadioButton(sectionCName));

//		jsWindowsScrollIntoView(nonMeasurableQuestionSet);

		selectByVisibleText(nonMeasurableQuestionSet, nonMeasurableSet);
		return this;
	}

	public Stages searchAndDeleteCreatedStage(String stageName) {

		SendDataUtils.clearAndSendKeys(searchBar, stageName);
		searchButton.click();

		deleteAndConfirmation(stageName);

		return this;
	}

	public Stages transIDInEvaluationField() {

		evalutionFieldButton.click();
		selectTransIDInEvaluationField(stageEvaluationDropdown, null);
		actions.moveToElement(saveButton2).perform();
		saveButton2.click();

		wait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();

		return this;
	}

	public Stages selectAllInEvaluationField(String optionToSelect) {

//		String stageName = "EmployeeC Stage";
		String xpath = String.format(
				"//table[@class='w-100']/thead/tr/../..//tbody//td[normalize-space()='%s']/..//a/img", optionToSelect);
		WebElement settingButton = driver.findElement(By.xpath(xpath));

		settingButton.click();
		evaluationFields.click();
		selectAll.click();

		return this;

	}

//	***********negative Scripts********************

	// List of common SQL injection payloads
	private static final String[] sqlInjectionPayloads = { "' OR 1=1 --", "' OR '1'='1' --", "' OR '1'='1' /*",
			"' OR 'a'='a'", "' OR 1=1#", "' OR '1'='1", "' OR 'x'='x", "' OR 'x'='x' --", "1; DROP TABLE users --",
			"' UNION SELECT NULL, NULL, NULL --", "' OR 1=1 LIMIT 1; --", "\" OR 1=1 --", "' OR ''='", "' OR 1=1#",
			"' OR 1=1/*", "' OR 'x'='x' /*", "'; EXEC xp_cmdshell('whoami'); --" };

	// Utility method to test SQL injection on a textbox
	public static void testSQLInjection(WebDriver driver, WebElement textBox, WebElement submitBtn,
			By errorMessageLocator) {

		// Loop through each SQL injection payload and input into the textbox
		for (String payload : sqlInjectionPayloads) {
			// Clear the text box and input the payload
			textBox.clear();
			textBox.sendKeys(payload);

		}
	}

	public Stages Negative1(String stageName, String process, String subProcess, String subSubProcess) {
		workFlowStagesTab.click();
		stagesTab.click();
		stagesCreateButton.click();
//		stageNameTextBoxElement.sendKeys("A".repeat(257));
		sendKeys(stageNameTextBoxElement, stageName);
		selectByVisibleText(selectProcessDropDownElement, process);
		unWaitInMilli(500);
		selectByVisibleText(selectSubProcessDropDownElement, subProcess);
		unWaitInMilli(500);
		selectByVisibleText(selectSubSubProcessDropDownElement, subSubProcess);
		jsClick(manualRadioButton);

		return this;
	}

	public Stages assertion() {

		assert stageNameError.isDisplayed();

		return this;

	}

	public Stages navToCreatePage() {
		workFlowStagesTab.click();
		stagesTab.click();
		stagesCreateButton.click();
		return this;
	}

	public Stages clickOnSingleSubmit() {
		jsClick(saveButton);
		return this;
	}

	public Stages navigateBack() {
		backButton.click();

		return this;
	}

	public Stages NegSectionA(String sectionAMetadata) {
		addButtonInSectionAElement.click();
		selectByVisibleText(sectionAMetaDataDropdown, sectionAMetadata);
		addButtonInaddSectionAPopUp.click();

		return this;
	}

	public Stages assertNoOptionsInMultiSelect() {

		evaluationFields.click();
		// Initialize Select class with the multi-select dropdown element
		Select multiSelect = new Select(stageEvaluationDropdown);

		// Get all the available options in the dropdown
		int numberOfOptions = multiSelect.getOptions().size();

		// Assert that there are no options in the dropdown
		assertEquals(numberOfOptions, 0, "The multi-select dropdown contains options, but it should be empty.");

		System.out.println("Assertion passed: The multi-select dropdown has no options.");

		return this;
	}

	public static boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
			return false;
		}
	}

	@FindBy(xpath = "(//button[@id='multiselect_rightSelected'])[1]")
	WebElement multiSelectRightClick;

	public Stages selectTransIDInEvaluationField(WebElement MultiSelectElement, String optionToSelect) {

//		String stageName = "EmployeeC Stage";
		String xpath = String.format(
				"//table[@class='w-100']/thead/tr/../..//tbody//td[normalize-space()='%s']/..//a/img", optionToSelect);
		WebElement settingButton = driver.findElement(By.xpath(xpath));

		settingButton.click();
		evaluationFields.click();

		Select select = new Select(MultiSelectElement);
		select.selectByVisibleText("Trans Unique Id");// Replace optionToSelect parameter if you want to Select any
														// Other Options
		multiSelectRightClick.click();

		return this;

	}

	public Stages stageSettingListSaveAndConfirmation() {

//		actions.moveToElement(saveButton2).perform();
		
		CommonUtils.scrollToPoint(driver,578,774);

//		saveButton2.click();
		click(driver, saveButton2);

		unWait(1);
		wait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();

		leftArrowOrBackButton.click();

		return this;

	}

	private int numberOfOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().size();
	}

	public Stages sectionAAndB() {
		addButtonInSectionAElement.click();

		assertEquals(numberOfOptions(sectionAMetaDataDropdown), 1);
		cancelButtonInaddSectionAPopUp.click();
//		assertFalse(addBlockMinus.isEnabled());
		jsClick(sectionBAddButton(1));
		assertEquals(numberOfOptions(sectionBMetaDataDropdown), 1);

		return this;
	}

	public Stages sectionCTextbox(String sectionName) {
		jsClick(sectionCAdd);
		sendKeys(sectionNameField, sectionName);
		sendKeys(sectionWeightage, sectionName);
		assert isDisplayed(sectionNameError);
		sectionCAddButton.click();

		navigateBack();

		return this;
	}

	private void sqlInjection(WebElement element, String sqlInjections, WebElement save) {
		element.sendKeys(sqlInjections);
		save.click();
	}

	public Stages navToStagesTable() {
		workFlowStagesTab.click();
		stagesTab.click();
		return this;
	}

	public Stages searchBox(String invalidData, String expectedBehavior) {

		searchBar.sendKeys(invalidData);
		searchButton.click();
		// Add logic based on the expected behavior
		switch (expectedBehavior) {
		case "none":
			// No data entered, ensure the page remains the same
			assertTrue(isPageSame(), "Page should remain the same with no error message.");
			break;

		case "No entries found":
			// Invalid input, expect "No entries found" message
			WebElement noEntriesMessage = driver.findElement(By.xpath("//td[normalize-space()='No Entries Found']")); // Replace
																														// with
																														// actual
																														// locator
			assertTrue(noEntriesMessage.isDisplayed(), "'No entries found' message should be displayed.");
			break;

		case "database error":
			// Unicode input, expect a database error page or relevant error
			assertTrue(isDatabaseErrorDisplayed("OperationalError"), "Database error should be displayed.");
			break;

		default:
			throw new IllegalArgumentException("Unexpected behavior: " + expectedBehavior);
		}
		return this;
	}

	private boolean isPageSame() {
		// Implement logic to check if the page remains the same after no input is given
		// This can include checking if no error message appears, or if the URL has not
		// changed.
		String currentURL = driver.getCurrentUrl();
		// Replace this with your original URL or condition to check
		return currentURL.contains("https://test.capture.autosherpas.com/en/stages/stages_list/");
	}

	private boolean isDatabaseErrorDisplayed(String exceptionType) {
		// Implement logic to check for a database error
		// Example: checking if a specific error message or error page is displayed
		return driver.getPageSource().contains(exceptionType);
	}

	public Stages testInvalidDate(String invalidDate) {
		jsDateExecutor(filterDate, invalidDate);
		searchButton.click();
		assertFalse(isDatabaseErrorDisplayed("ValidationError"));

		return this;
	}

	public Stages stageNameAndProcess(String stageName, String processValue, String subProcess, String subSubProcess) {
		stageNameTextBoxElement.sendKeys(stageName);
		selectByVisibleText(selectProcessDropDownElement, processValue);
		unWaitInMilli(300);
		selectByVisibleText(selectSubProcessDropDownElement, subProcess);
		unWaitInMilli(300);
		selectByVisibleText(selectSubSubProcessDropDownElement, subSubProcess);

		return this;

	}

	public Stages selectCheckBoxSectionA(String metaDataName, List<String> inputs) {

		addButtonInSectionAElement.click();
		selectByVisibleText(sectionAMetaDataDropdown, metaDataName);
		selectMultipleCheckboxes(metadataCheckBoxes, inputs);
		addButtonInaddSectionAPopUp.click();

		return this;
	}

	public Stages selectCheckBoxSectionB(String metaDataName, List<String> inputs) {
		sectionBAddButton(1).click();
		selectByVisibleText(sectionBMetaDataDropdown, metaDataName);
		selectMultipleCheckboxes(metadataCheckBoxes, inputs);
		sectionBAddButton.click();

		return this;
	}

	public Stages selectActionsCheckBoxes(List<String> inputs) {
		selectMultipleCheckboxes(actionsCheckboxes, inputs);

		return this;
	}

	@FindBy(xpath = "//input[contains(@name,'ActionCheckbox')]")
	List<WebElement> actionsCheckboxes;

	@FindBy(xpath = "//input[@name='sectionA_fieldname']")
	List<WebElement> metadataCheckBoxes;

	@FindBy(xpath = "//div[contains(@class,'col-md-3')]//h7")
	List<WebElement> toggleButtonNames;

	String toggleButtons = "//parent::div//following-sibling::label//span";

	String checkBoxValueXpath = "following-sibling::label";

	public static void selectMultipleCheckboxes(List<WebElement> checkboxes, List<String> inputs) {
		// Locate all checkboxes on the page
		unWaitInMilli(300);

		// Iterate over all inputs and check corresponding checkboxes
		for (String input : inputs) {
			boolean checkboxFound = false;
			for (WebElement checkbox : checkboxes) {
				// Locate the associated label for the current checkbox (relative to the
				// checkbox)
				String checkboxValue = checkbox.findElement(By.xpath("following-sibling::label")).getText();

				// Check if the value matches the input
				if (checkboxValue.contains(input)) {
					// Select the checkbox if not already selected
					if (!checkbox.isSelected()) {
						jsClick(checkbox);
					}
					checkboxFound = true;
					break;
				}
			}

			// If the checkbox was not found, you can log or handle it (optional)
			if (!checkboxFound) {
				System.out.println("Checkbox with value '" + input + "' not found.");
			}
		}
	}

	public Stages clickOnManual() {
		jsClick(manualRadioButton);
		return this;
	}

}
