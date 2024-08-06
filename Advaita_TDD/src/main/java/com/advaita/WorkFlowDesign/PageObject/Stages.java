package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;

public class Stages extends TestBase {

	SoftAssert softAssert = new SoftAssert();

	static private String stageListingPageUrl = "https://test.capture.autosherpas.com/en/stages/stages_list/";
	static private String stagesCraeteFormURL = "https://test.capture.autosherpas.com/en/stages/create_stages/";

	public static String fetchProcessRecord;
	public static String fetchSubProcessRecord;
	public static String fetchSubSubProcessRecord;
	public static String fetchMetaDataRecord;

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

	@FindBy(id = "pills-workflowstages-tab")
	public static WebElement workFlowStagesTab;

	@FindBy(xpath = "//img[@alt='justify_icon']/..//h1[text()=' Stages ']")
	public static WebElement stageListingPage;

	@FindBy(linkText = "+ Create")
	public static WebElement stagesCreateButton;

	@FindBy(xpath = "//div[@class='stage1-workflow page_body']/..//form[@id='submit_stages']")
	public static WebElement stagesCreateFormElement;

	@FindBy(xpath = "//h3[text()='Stage Name*']/..//input[@id='stage_name']")
	public static WebElement stageNameTextBoxElement;

	@FindBy(xpath = "//h3[text()='Process*']/..//select[@id='process']")
	public static WebElement selectProcessDropDownElement;

	@FindBy(xpath = "//h3[text()='Sub Process*']/..//select[@id='sub_process']")
	public static WebElement selectSubProcessDropDownElement;

	@FindBy(xpath = "//h3[text()='Sub Sub Process*']/..//select[@id='s_sub_process']")
	public static WebElement selectSubSubProcessDropDownElement;

	@FindBy(xpath = "//h3[text()='Calculation Type']/..//select[@id='calculation_type']")
	public static WebElement calculationTypeDropDownElement;

	@FindBy(xpath = "(//h2[@id='headingOne']/..//h6[text()='SECTION A'])[1]")
	public static WebElement sectionA_ExpantionPanel;

	@FindBy(xpath = "//img[@alt='addmeta-file']/..//h6[text()='Please Add Some Meta Data']")
	public static WebElement addMetaDataMassageInSectionAElement;

	@FindBy(xpath = "//a[text()='Add']/..//a[@data-section='Section A']")
	public static WebElement addButtonInSectionAElement;

	@FindBy(id = "pills-metadata-tab")
	public static WebElement metaDataTab;

	@FindBy(xpath = "//div[@class='dataset_table']//table/tbody/tr[1]/td[1]")
	public static WebElement fetchMetaData;

	@FindBy(xpath = "//div[@class='modal-content p-0 ']/div/h1[text()='Select Section A']")
	public static WebElement addSectionAPopUp;

	@FindBy(name = "metadata_names")
	public static WebElement selectMetaDatDropDownElement;

	@FindBy(xpath = "//input[@name='sectionA_fieldname']")
	public static WebElement metaDataFieldCheckBoxesElement;

	@FindBy(xpath = "(//div[@class='modal-content p-0 ']/..//a[normalize-space()='Add'])[1]")
	public static WebElement addButtonInaddSectionAPopUp;

	@FindBy(xpath = "//a[text()='edit']/..//a[@data-section='Section A']")
	public static WebElement editButtonInSectionAElement;

	@FindBy(xpath = "(//div[@class='modal-content p-0 ']/..//a[normalize-space()='Cancel'])[1]")
	public static WebElement cancelButtonInaddSectionAPopUp;

	@FindBy(xpath = "(//h2[@id='headingTwo']/..//h6[text()='SECTION B'])[1]")
	public static WebElement sectionB_ExpantionPanel;

	@FindBy(xpath = "//label[normalize-space()='Add Blocks']/..//div[@class='input-group']")
	public static WebElement addBlocksElement;

	@FindBy(xpath = "//label[normalize-space()='Add Blocks']/..//button[@data-type='minus']")
	public static WebElement removeBlocksButtonElement;

	@FindBy(xpath = "//label[normalize-space()='Add Blocks']/..//button[@data-type='plus']")
	public static WebElement addBlocksButtonElement;

	@FindBy(xpath = "//select[@id='sectionB_metadata_id']")
	public static WebElement blockNameMetaDataDropDown;

	@FindBy(xpath = "//label[contains(normalize-space(),'BLOCK NAME')]")
	public static List<WebElement> addedBlocksElement;

	public Stages() {
		PageFactory.initElements(driver, this);
	}

	public void navigateFetchProcessRecord() throws Throwable {

		driver.navigate().to("https://test.capture.autosherpas.com/en/data_management/process/");

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

	}

	public void navigateFetchSubProcessRecord() throws Throwable {

		fetchSubProcessRecord = fetchsubProcess.getText();
		assertNotNull(fetchSubProcessRecord, "fetchSubProcessRecord is null.");
	}

	public void navigateFetchSubSubProcessRecord() throws Throwable {

		fetchSubSubProcessRecord = fetchsubSubProcess.getText();
		assertNotNull(fetchSubSubProcessRecord, "fetchSubSubProcessRecord is null.");

	}

	public void navigateFetchMetaDataRecord() throws Throwable {
		click(driver, metaDataTab);

		Thread.sleep(1000);
		fetchMetaDataRecord = fetchMetaData.getText();
		assertNotNull(fetchMetaDataRecord, "fetchMetaDataRecord is null.");

		System.out.println(fetchMetaDataRecord);

		driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");
	}

	public void VerifyStagesTabIsDisplayed() {

//		String stageListingPageUrl = "https://test.capture.autosherpas.com//en/stages/stages_list/";

		assertTrue(workFlowStagesTab.isDisplayed(), "workFlowStagesTab is not displayed");
//		click(driver, workFlowStagesTab);
		assertTrue(stageListingPage.isDisplayed(), "stageListingPage is not displayed");
		assertEquals(driver.getCurrentUrl(), stageListingPageUrl);

	}

	public void verifyCreateStagesButton() {

//		String stagesCraeteFormURL = "https://test.capture.autosherpas.com/en/stages/create_stages/"; 

		assertTrue(stagesCreateButton.isDisplayed() && stagesCreateButton.isEnabled(),
				"stagesCreateButton is not displayed and enabled.");
		click(driver, stagesCreateButton);

		assertTrue(stagesCreateFormElement.isDisplayed(), "stagesCreateFormElement is not displayed.");
		assertEquals(driver.getCurrentUrl(), stagesCraeteFormURL);
	}

	public void verifyStageNameTextBox(String StageName) {

		// Check if the Stage Name field is mandatory or not.
		String text = driver.findElement(By.xpath("//h3[text()='Stage Name*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		// Stage field is displayed or not
		assertTrue(stageNameTextBoxElement.isDisplayed(), "stageNameTextBoxElement is displayed.");
		stageNameTextBoxElement.clear();
		stageNameTextBoxElement.sendKeys(StageName);

	}

	public void verifyStageSelectProcessDropDown() throws Throwable {

		String text = driver.findElement(By.xpath("//h3[text()='Process*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		assertTrue(selectProcessDropDownElement.isDisplayed(), "selectProcessDropDownElement is not displayed.");

		Select select = new Select(selectProcessDropDownElement);
		Thread.sleep(1000);
		select.selectByVisibleText(fetchProcessRecord);

	}

	public void verifyStageSelectSubProcessDropDown() throws Throwable {

		String text = driver.findElement(By.xpath("//h3[text()='Sub Process*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		assertTrue(selectSubProcessDropDownElement.isDisplayed(), "selectSubProcessDropDownElement is not displayed.");

		wait.until(ExpectedConditions.visibilityOf(selectSubProcessDropDownElement));
		Select select = new Select(selectSubProcessDropDownElement);
		Thread.sleep(1000);
		select.selectByVisibleText(fetchSubProcessRecord);

	}

	public void verifyStageSelectSubSubProcessDropDown() throws Throwable {

		String text = driver.findElement(By.xpath("//h3[text()='Sub Sub Process*']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		assertTrue(selectSubSubProcessDropDownElement.isDisplayed(),
				"selectSubSubProcessDropDownElement is not displayed.");

		Select select = new Select(selectSubSubProcessDropDownElement);
		Thread.sleep(1000);
		select.selectByVisibleText(fetchSubSubProcessRecord);

	}

	public void verifyStageCalculationTypeDropDown() throws Throwable {

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

	}

	public void verifyAddSectionA() throws Throwable {

		assertTrue(sectionA_ExpantionPanel.isDisplayed(), "WebsectionA_ExpantionPanel is not displayed.");
		assertTrue(addMetaDataMassageInSectionAElement.isDisplayed(),
				"addMetaDataMassageInSectionAElement is not displayed.");

		assertTrue(addButtonInSectionAElement.isDisplayed(), "addButtonInSectionAElement is not displayed.");

		click(driver, addButtonInSectionAElement);

		wait.until(ExpectedConditions.visibilityOf(addSectionAPopUp));
		assertTrue(addSectionAPopUp.isDisplayed(), "addSectionAPopUp is not displayed.");

		Select select = new Select(selectMetaDatDropDownElement);

//		WebElement options = select.getOptions().get(1);

//		assertEquals(options.getText(), fetchMetaDataRecord);

		select.selectByVisibleText(fetchMetaDataRecord);

		List<WebElement> checkBoxElements = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='sectionA_fieldname']")));

		for (int i = 0; i < checkBoxElements.size(); i++) {
			WebElement element = checkBoxElements.get(i);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}

		assertTrue(addButtonInaddSectionAPopUp.isDisplayed(), "addButtonInaddSectionAPopUp is not displayed.");
		click(driver, addButtonInaddSectionAPopUp);

		wait.until(ExpectedConditions.visibilityOf(editButtonInSectionAElement));
		assertTrue(editButtonInSectionAElement.isDisplayed(), "editButtonInSectionAElement is not displayed.");
		click(driver, editButtonInSectionAElement);

//		List<WebElement> options1 = select.getOptions();
//
//		String list = fetchMetaDataRecord;
//
//		// Iterate through the options and print the text of each option
//		for (WebElement option : options1) {
//
//			System.out.println("fetchMetaDataRecord after add Metadata popup : " + option.getText());
//
//			assertNotNull(option, "fetchMetaDataRecord after add Metadata popup is null.");
//
//			assertTrue(list.contains(option.getText()));
//
////			assertTrue(option.getText().contains(list));
//
//		}

		wait.until(ExpectedConditions.visibilityOf(cancelButtonInaddSectionAPopUp));
		assertTrue(cancelButtonInaddSectionAPopUp.isDisplayed(), "cancelButtonInaddSectionAPopUp is not displayed.");
		cancelButtonInaddSectionAPopUp.click();

	}

	public void verifySectionB() {

		assertTrue(sectionB_ExpantionPanel.isDisplayed(), "sectionB_ExpantionPanel is not displayed.");
		assertTrue(addBlocksElement.isDisplayed(), "addBlocksElement is not displayed.");

	}

	public void verifyAddBlockInSectionB(int count) {

		verifySectionB();

		for (int i = 1; i <= count; i++) {

			ClickUtilities.clickWithRetry(addBlocksButtonElement, 2);
		}

		int n = 0;
		for (WebElement a : addedBlocksElement) {

			System.out.println(a.getText());
			n++;
		}
		assertEquals(n, count + 1);

		for (int i = 1; i <= count; i++) {

			ClickUtilities.clickWithRetry(removeBlocksButtonElement, 2);
		}

	}

	public void selectMetaDataInAddBlockSectionB(int count) {

		for (int i = 1; i <= count; i++) {

			ClickUtilities.clickWithRetry(addBlocksButtonElement, 2);
		}

		List<WebElement> addButtonInSectionB = driver.findElements(By.xpath(
				"//div[contains((@class),('sectionA-addfile block-name section_Bblock'))]//h6[normalize-space()='Please Add Some Meta Data']/..//a[normalize-space()='Add']"));

		for (WebElement addButton : addButtonInSectionB) {

			ClickUtilities.clickWithRetry(addButton, 2);

			Select select = new Select(blockNameMetaDataDropDown);
			
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				String optionText = option.getText();
				System.out.println(optionText);
			}
			
			select.selectByVisibleText(fetchMetaDataRecord);
			
			List<WebElement> checkBoxElements = wait.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='sectionA_fieldname']")));

			for (int i = 0; i < checkBoxElements.size(); i++) {
				WebElement element = checkBoxElements.get(i);
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			}

		}

	}

//	#################################################################################################

}
