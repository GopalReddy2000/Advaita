package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.Pagination;

import Advaita_TDD.Advaita_TDD.FakeData;

public class Disposition extends TestBase {

	FakeData fake = new FakeData();

	static int createCount = 1;

	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(linkText = "+ Add Disposition")
	public static WebElement addDispositionButton;

	@FindBy(id = "questionSet_name")
	public static WebElement questionSetNameField;

	@FindBy(xpath = "(//img[@alt='settingicon'])[1]")
	public static WebElement settingButton;

	@FindBy(xpath = "(//label[contains(text(),'SECTION')])[1]/..//input")
	public static WebElement sectionField;

	@FindBy(xpath = "(//label[contains(text(),'SECTION REMARKS')])[1]/..//input")
	public static WebElement sectionNameField;

	@FindBy(xpath = "(//a/span/..//h5[normalize-space()='Table View'])[1]")
	public static WebElement tabularView;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Text Box'])[1]")
	public static WebElement textBox;
	@FindBy(xpath = "(//h5[normalize-space()='Min Len']/..//input)[1]")
	public static WebElement textBoxLine;

	@FindBy(xpath = "(//img[@alt='feathertrash'])[1]")
	public static WebElement deleteOrTrashButton;

	@FindBy(linkText = "Add Question")
	public static WebElement addQuestionButton;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Date'])[1]")
	public static WebElement dateType;

	@FindBy(id = "startDate")
	public static WebElement dateField;

	@FindBy(xpath = "(//label[text()='ADD COLUMN']/..//span[@class='plus'])[2]")
	public static WebElement plusColumnButton;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Drop Down'])[1]")
	public static WebElement dropDownOption;

	@FindBy(xpath = "//div[@class='addquestion-padding addoption_padding add_option_btn_table_view option_btn_show_1_1']//img[@alt='plusicon']/..//a[text()='Add Option']")
	public static WebElement addDropDownOptionField;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Radio Button'])[1]")
	public static WebElement radioButtonOption;

	@FindBy(xpath = "(//a/span/..//h6[normalize-space()='Time'])[1]")
	public static WebElement timeOption;

	@FindBy(id = "startDate")
	public static WebElement timePicker;

	@FindBy(xpath = "//div[@class='xdsoft_time ']/..//div[contains(@data-hour,'1')]/..//div[text()='01:00']")
	public static WebElement timePickerNext;

	@FindBy(xpath = "(//button[@class='xdsoft_next'])[2]")
	public static WebElement timePickerPrevious;

	@FindBy(linkText = "Add Section")
	public static WebElement addSectionButton;

	@FindBy(xpath = "(//img[@alt='settingicon'])[2]")
	public static WebElement settingButton2;

	@FindBy(xpath = "(//a/span/..//h5[normalize-space()='Table View'])[2]")
	public static WebElement tabularView2;

	@FindBy(xpath = "//button[@id='create_btn']/..//button[text()='Save']")
	public static WebElement saveButtonOfCreateQuestionSet;

	@FindBy(xpath = "//span[contains(text(),'Disposition has been created successfully')]/..//button[contains(text(),'Continue')]")
	public static WebElement successPopUpWithContinueButtonAfterCreate;

	@FindBy(xpath = "//img[@alt='arrow-left']")
	public static WebElement leftArrowToGoBackTablePage;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	public static WebElement fetchCreatedRecord;

	@FindBy(id = "text_search")
	public static WebElement searchBox;

	@FindBy(xpath = "(//img[@alt='filter_search'])[1]")
	public static WebElement searchButton;

	@FindBy(id = "filter_date")
	public static WebElement createdDatePicker;

	@FindBy(xpath = "//h6[normalize-space()='Clear All Filters']")
	public static WebElement clearFilterButton;

	@FindBy(xpath = "//li//a//img[@alt='left_arrow']")
	public static WebElement leftArrow;

	@FindBy(xpath = "//li//a//img[@alt='rgt_arrow']")
	public static WebElement rightArrow;

	@FindBy(id = "exampleFormControlTextarea1")
	public static WebElement remarkFieldInEditPage;

	@FindBy(id = "create_btn")
	public static WebElement saveButtonInEditPage;

	@FindBy(xpath = "//span[normalize-space(text())='Disposition has been updated successfully']")
	public static WebElement successfullyDispositionUpdatedMassage;

	@FindBy(xpath = "//span[normalize-space(text())='Disposition has been updated successfully']/..//button[normalize-space(text())='Continue']")
	public static WebElement afterDispositionUpdatedContinueButton;
	
	@FindBy(xpath = "(//img[@alt='table-edit'])[1]")
	public static WebElement editDispositionButton;

	public Disposition() {
		PageFactory.initElements(driver, this);
	}

	public void dispositionCreatePage(int count) throws Throwable {

		for (int b = 1; b <= count; b++) {

//			String beforeCreatedRecords = driver.findElement(By.xpath("(//p[@class='show_entries m-0 font_13'])[1]"))
//					.getText();
//
//			Thread.sleep(2000);
//			System.out.println("beforeCreatedRecord : " + beforeCreatedRecords);
//
//			int beforeCreateRecord = extractNumber(beforeCreatedRecords);
//			int beforeNumber = extractNumber(beforeCreatedRecords) + 1;
////		System.out.println(String.format("beforeNumber (%d + 1) : %s", beforeCreateRecord, beforeNumber));
//			System.out.println("beforeNumber" + "(" + beforeCreateRecord + "+1" + ") :" + beforeNumber);

			click(driver, addDispositionButton);

			assertTrue(questionSetNameField.isDisplayed(), "questionSetNameField is not displayed.");
			questionSetNameField.sendKeys(fake.lastName1() + " TestAudit");

			click(driver, settingButton);

			// WebDriver driver, WebElement element, int timeout, int pollingInterval
			wait.until(ExpectedConditions.visibilityOf(tabularView));
			assertTrue(tabularView.isDisplayed(), "tabularView is not displayed.");
			click(driver, tabularView);

			for (int j = 1; j <= 7; j++) {

				String xpathForColumn1 = "//label[normalize-space()='COLUMN NAME " + j + "']";

				String xpathForColumn = "(//input[@placeholder='Enter your column Name'])[" + j + "]";

				String xpathForTextBox = "question_1_" + j;

				WebElement ClickColumn = driver.findElement(By.xpath(xpathForColumn1));
				WebElement sendDataColumn = driver.findElement(By.xpath(xpathForColumn));

				WebElement textBoxUnderColumn = driver.findElement(By.name(xpathForTextBox));

				if (j == 1) {

					Thread.sleep(2000);
					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Customer Name");
					textBoxUnderColumn.sendKeys("Enter Customer Name?");
					textBoxUnderColumn.click();
					textBox.click();
				}

				if (j == 2) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Person Who Pick the Call");
					textBoxUnderColumn.sendKeys("Enter the Employee Name?");

//				Thread.sleep(6000);
					wait.until(ExpectedConditions.elementToBeClickable(textBoxUnderColumn));
					textBoxUnderColumn.click();
					js.executeScript("arguments[0].click();", textBox);
//				Thread.sleep(6000);
				}

				// Date Picker
				if (j == 3) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Call Date");
					click(driver, textBoxUnderColumn);
					textBoxUnderColumn.sendKeys("Enter the Date?");
					js.executeScript("arguments[0].click();", dateType);
					dateField.click();
					actions.moveToElement(driverIninteractable).perform();
					dateField.click();
					dateField.sendKeys("06/04/2024");
					dateField.sendKeys(Keys.ENTER);

				}

				// Text Box
				if (j == 4) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Feedback");
					textBoxUnderColumn.sendKeys("Enter Your Feedback?");
					js.executeScript("arguments[0].click();", textBox);

					click(driver, settingButton);
					click(driver, plusColumnButton);
				}

				// Drop Down
				if (j == 5) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Select Customer Feedback");
					textBoxUnderColumn.sendKeys("Select Feedback Satisfied / Not Satisfied");
					textBoxUnderColumn.click();

					js.executeScript("arguments[0].click();", dropDownOption);

					for (int i = 1; i <= 2; i++) {

						String xpathOfDropDownOption = "ans_option_1_1_" + i;
						WebElement dropDownOptionField = driver.findElement(By.name(xpathOfDropDownOption));

						if (i == 1) {

							js.executeScript("arguments[0].click();", dropDownOptionField);
							dropDownOptionField.sendKeys("Satisfied");
							actions.moveToElement(driverIninteractable).perform();
							// Thread.sleep(2000);
							js.executeScript("arguments[0].click();", addDropDownOptionField);
							// click(driver, plusColumnButton);
						}

						if (i == 2) {

							js.executeScript("arguments[0].click();", dropDownOptionField);
							dropDownOptionField.sendKeys("Not Satisfied");

							settingButton.click();
							click(driver, plusColumnButton);
						}

					}

				}

				// Radio Button
				if (j == 6) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("Is customer picked your call ?");
					textBoxUnderColumn.sendKeys("Select Radio button in yes or no.");
					textBoxUnderColumn.click();
					js.executeScript("arguments[0].click();", radioButtonOption);

					for (int i = 1; i <= 2; i++) {

						String xpathForRadioButtonOptions = "ans_option_1_1_" + i;

						if (i == 1) {
							WebElement option1 = driver.findElement(By.name(xpathForRadioButtonOptions));
							option1.sendKeys("Yes");
						}

						if (i == 2) {
							WebElement option2 = driver.findElement(By.name(xpathForRadioButtonOptions));
							option2.sendKeys("No");

							settingButton.click();
							click(driver, plusColumnButton);
						}

					}

				}

				// Time Picker
				if (j == 7) {

					click(driver, ClickColumn);
					sendDataColumn.sendKeys("On which time call picked ?");
					textBoxUnderColumn.sendKeys("Select the time of the call.");
					textBoxUnderColumn.click();
					js.executeScript("arguments[0].click();", timeOption);

					js.executeScript("arguments[0].scrollIntoView(true);", timePicker);
					timePicker.click();
					timePicker.click();
					timePicker.sendKeys("10:10");
					timePicker.sendKeys(Keys.ENTER);

				}

			}

			click(driver, addSectionButton);

			click(driver, settingButton2);

			click(driver, tabularView2);

			for (int a = 1; a <= 4; a++) {

				String xpath = "(//label[text()='COLUMN NAME " + a + "'])[2]";
				String columnNameXpath = "//input[contains(@placeholder, 'Enter your column Name')]/..//input[@name='col_name_2_"
						+ a + "']";
				String xpathName = "//input[@name='question_2_" + a + "']";

				System.out.println("name : " + xpathName);

				WebElement xpathForColumn2 = driver.findElement(By.xpath(xpath));
				WebElement xpathForColumn2Name = driver.findElement(By.xpath(columnNameXpath));
				WebElement xpathForField2 = driver.findElement(By.xpath(xpathName));

				if (a == 1) {
					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter Customer Name?");
					xpathForField2.sendKeys("Customer Name");
				}

				if (a == 2) {

					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter Customer Phone No.?");
					xpathForField2.sendKeys("Customer Phone No.");

				}

				if (a == 3) {

					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter the time ?");
					xpathForField2.sendKeys("Enter Time");

				}

				if (a == 4) {

					click(driver, xpathForColumn2);
					xpathForColumn2Name.sendKeys("Enter the Customer Address ?");
					xpathForField2.sendKeys("Enter Customer Address");

				}

			}

			click(driver, saveButtonOfCreateQuestionSet);
			Thread.sleep(2000);
			assertTrue(successPopUpWithContinueButtonAfterCreate.isDisplayed(),
					"successPopUpWithContinueButtonAfterCreate is not displayed.");
			click(driver, successPopUpWithContinueButtonAfterCreate);

			click(driver, leftArrowToGoBackTablePage);

//			Thread.sleep(2000);
//
//			String afterCreateRecords = driver.findElement(By.xpath("(//p[@class='show_entries m-0 font_13'])[1]"))
//					.getText();
//
//			assertNotNull(afterCreateRecords, "afterCreateRecords is null.");
//			System.out.println("afterCreateRecords : " + afterCreateRecords);
//
//			int afterNumber = extractNumber(afterCreateRecords);
//			System.out.println("afterNumber : " + afterNumber);
//
//			assertEquals(afterNumber, beforeNumber);

		}

	}

	public void dispositionTablePage() throws Throwable {

		String firstRecord = fetchCreatedRecord.getText();

		System.out.println("firstRecord : " + firstRecord);

		assertTrue(searchBox.isDisplayed(), "searchBox is not displayed.");
		assertNotNull(firstRecord, "firstRecord is null.");
		searchBox.sendKeys(firstRecord);

		click(driver, searchButton);

		WebElement searchRecord = driver.findElement(By.xpath("//td[text()='" + firstRecord + "']"));
		assertTrue(searchRecord.isDisplayed(), "searchRecord is not displayed.");
//		
//		assertTrue(createdDatePicker.isDisplayed(), "createdDatePicker is not displayed.");
//		createdDatePicker.click();
//		createdDatePicker.sendKeys("25-04-2024");
//		createdDatePicker.sendKeys(Keys.ENTER);
//		
//		click(driver, searchButton);

		click(driver, clearFilterButton);

		Pagination.paginate(driver, rightArrow, leftArrow);

		driver.navigate().refresh();
//		---------------------------------------------------------------------------

	}
	
	public void dispositionEditPage() {
		
		click(driver, editDispositionButton);

		assertTrue(remarkFieldInEditPage.isDisplayed(), "remarkFieldInEditPage is not displayed.");
		remarkFieldInEditPage.clear();
		remarkFieldInEditPage.sendKeys("Test Edit NonMeasurableSet");
		click(driver, saveButtonInEditPage);

		wait.until(ExpectedConditions.visibilityOf(successfullyDispositionUpdatedMassage));
		assertTrue(successfullyDispositionUpdatedMassage.isDisplayed(),
				"successfullyMeasurableUpdatedMassage is not displayed.");
		
		click(driver, afterDispositionUpdatedContinueButton);
		
		click(driver, leftArrowToGoBackTablePage);

	}

	public static int extractNumber(String input) {
		StringBuilder numberAsString = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				numberAsString.append(c);
			}
		}

		return Integer.parseInt(numberAsString.toString());
	}
}
