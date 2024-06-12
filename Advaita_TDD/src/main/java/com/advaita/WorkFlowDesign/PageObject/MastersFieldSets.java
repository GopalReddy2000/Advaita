package com.advaita.WorkFlowDesign.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;

import Advaita_TDD.Advaita_TDD.FakeData;

public class MastersFieldSets extends TestBase {

	FakeData fake = new FakeData();

	public static final String masterURL = "https://test.capture.autosherpas.com/en/masters/masters_question_sets/";
	public static String existingFieldSetRecord;

	@FindBy(xpath = "(//button[normalize-space()='Masters'])[1]")
	public static WebElement masterTabElement;

	@FindBy(id = "pills-MasterQuestionSet-tab")
	public static WebElement fieldSetTabElement;

	@FindBy(linkText = "+ Add Field Set")
	public static WebElement addFieldSetButton;

	@FindBy(xpath = "//h2[normalize-space()='Create Master Field Set']")
	public static WebElement createMasterFieldSetPage;

	@FindBy(id = "questionSet_name")
	public static WebElement questionSetNameFieldElement;

	@FindBy(id = "exampleFormControlTextarea1")
	public static WebElement remarkFieldElement;

	@FindBy(xpath = "//h5[normalize-space()='Section 1']")
	public static WebElement section1Element;

	@FindBy(xpath = "(//img[@alt='plusicon']/..//a[@class='add-text'][normalize-space()='Add Question'])[1]")
	public static WebElement addQuestionsButttonElement;

	@FindBy(xpath = "(//table/tbody/tr[1]/td[1])[1]")
	public static WebElement fetchFieldSetRecord;

	@FindBy(xpath = "//img[@class='documentimg']/..//h5")
	public static List<WebElement> previousQuestionSetElements;

	@FindBy(xpath = "//h5[@class='font_13 question_number']/..//input[@class='question_text']")
	public static List<WebElement> addedQuestionElements;

	@FindBy(xpath = "//div[@class='col-md-3 table-viewright-side right_section right_section_1_1 actv_rt_sec_1']//label[normalize-space()='SELECT QUESTION TYPE']/../div/div/a//h6")
	public static List<WebElement> questionTypes;

	public MastersFieldSets() {

		PageFactory.initElements(driver, this);
	}

	public void verifyTabsForFieldSetCreate() {

		assertTrue(masterTabElement.isDisplayed(), "masterTabElement is not displayed.");
		click(driver, masterTabElement);

		System.out.println(driver.getCurrentUrl());

		assertEquals(driver.getCurrentUrl(), masterURL, "masterURL mismatch.");

		assertTrue(fieldSetTabElement.isDisplayed(), "fieldSetTabElement is not displayed.");

	}

	public void verifyFieldSetCreateButton() {

		assertTrue(fetchFieldSetRecord.isDisplayed());
		existingFieldSetRecord = fetchFieldSetRecord.getText();
		assertNotNull(existingFieldSetRecord);

		click(driver, addFieldSetButton);

		assertTrue(createMasterFieldSetPage.isDisplayed(), "createMasterFieldSetPage is not displayed.");

	}

	public void verifyQuestionSetNameField() {

		String text = driver.findElement(By.xpath("//label[normalize-space()='QUESTION SET *']")).getText();
		char lastChar = text.charAt(text.length() - 1);
		assertEquals(lastChar, '*');

		assertTrue(questionSetNameFieldElement.isDisplayed());

		questionSetNameFieldElement.clear();
		questionSetNameFieldElement.sendKeys(fake.lastName1() + " QS");

	}

	public void verifyRemarkField() {

		assertTrue(remarkFieldElement.isDisplayed());

		remarkFieldElement.clear();
		remarkFieldElement.sendKeys("Test Remark");

	}

	public void verifyDefaultSection1() throws Throwable {

		assertTrue(section1Element.isDisplayed(), "section1Element is not displayed.");

		int sizeOfQuestion = 6;

		ClickUtilities.multiClick(driver, addQuestionsButttonElement, sizeOfQuestion);

		int sizeOfAddedQuestion = addedQuestionElements.size() - 2;

		if (sizeOfAddedQuestion == sizeOfQuestion) {
			System.out.println("All" + sizeOfQuestion + "elements are present.");
			assertTrue(true);
		} else {
			System.out.println("All" + sizeOfQuestion + "elements, but found " + sizeOfAddedQuestion);
			assertTrue(false);
		}

	}

	public void verifyByAddingQuestionsAndQuestionsType() throws Throwable {

//		All 11 elements are present.
//		questionTypes 0 : Label
//		questionTypes 1 : Multiple Choice
//		questionTypes 2 : Short Answer
//		questionTypes 3 : Drop Down
//		questionTypes 4 : Relative Drop down
//		questionTypes 5 : File Upload
//		questionTypes 6 : Radio Button
//		questionTypes 7 : Date
//		questionTypes 8 : Time
//		questionTypes 9 : Text Box
//		questionTypes 10 : Relative MultiSelect

		// Interact with the questionFields elements by index, excluding the last one

		for (int i = 1; i < 6; i++) {

			String xpathQuestionTextField = "//div[h5[contains(text(), 'Question " + i
					+ "')]]//input[@name='question_1_" + i + "']";

			WebElement questionFields = driver.findElement(By.xpath(xpathQuestionTextField));

			if (i == 1) {

				// Example interaction: setting text in the question fields
				js.executeScript("arguments[0].scrollIntoView(true);", questionFields);
				questionFields.sendKeys("Name Of The Customer ?");
				ClickUtilities.jsClick(driver, questionTypes.get(9));

			}
			if (i == 2) {

				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Adress Of The Customer ?");
				ClickUtilities.jsClick(driver, questionTypes.get(2));

			}
			if (i == 3) {

				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Date of the call ?");
				ClickUtilities.jsClick(driver, questionTypes.get(7));

			}

			if (i == 4) {

				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Time of the call ?");
				ClickUtilities.jsClick(driver, questionTypes.get(8));

			}

			if (i == 5) {

				// Example interaction: setting text in the question fields
				questionFields.sendKeys("Did you picked your call ?");
				ClickUtilities.jsClick(driver, questionTypes.get(6));

				for (int a = 1; a <= 2; a++) {

					String radioOption = xpathQuestionTextField
							+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_1_" + a
							+ "']";

					System.out.println("radioOption : " + radioOption);

					WebElement radioOptionField = driver.findElement(By.xpath(radioOption));

					if (a == 1) {

						radioOptionField.sendKeys("Yes");

					}
					if (a == 2) {

						radioOptionField.sendKeys("No");

						String xpathAdd = "(" + xpathQuestionTextField
								+ "/following::div[@class='addquestion-padding add_option_btn question_add_option']/a[contains(@class, 'add-text')])[1]";

						ClickUtilities.jsClick(driver, driver.findElement(By.xpath(xpathAdd)));

//						driver.findElement(By.xpath(xpath)).click();

					}

				}

				String radioOption1 = xpathQuestionTextField
						+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_" + i + "_"
						+ (i - 2) + "']";

				System.out.println("radioOption1 : " + radioOption1);

				WebElement radioOptionField1 = driver.findElement(By.xpath(radioOption1));

				radioOptionField1.sendKeys("NA");

			}

			if (i == 5) {

				questionFields.sendKeys("Gender Of The Customer ?");
				ClickUtilities.jsClick(driver, questionTypes.get(3));

				for (int x = 1; x <= 3; x++) {

					String xpathAdd = "(" + xpathQuestionTextField
							+ "/following::div[@class='addquestion-padding add_option_btn question_add_option']/a[contains(@class, 'add-text')])[1]";

					ClickUtilities.jsClick(driver, driver.findElement(By.xpath(xpathAdd)));

				}

				for (int y = 1; y <= 4; y++) {

					if (y == 1) {
						String xpathDropDownOption1 = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_1_1']";

						WebElement dropDownOptions1 = driver.findElement(By.xpath(xpathDropDownOption1));

						dropDownOptions1.sendKeys("Male");

					}

					if (y == 2) {

						String xpathDropDownOption = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_5_" + y
								+ "']";

						WebElement dropDownOptions = driver.findElement(By.xpath(xpathDropDownOption));

						dropDownOptions.sendKeys("Female");

					}

					if (y == 3) {

						String xpathDropDownOption = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_5_" + y
								+ "']";

						WebElement dropDownOptions = driver.findElement(By.xpath(xpathDropDownOption));

						dropDownOptions.sendKeys("Transgender");

					}

					if (y == 4) {

						String xpathDropDownOption = xpathQuestionTextField
								+ "/following::input[contains(@class, 'answer_option') and @name='ans_option_1_5_" + y
								+ "']";

						WebElement dropDownOptions = driver.findElement(By.xpath(xpathDropDownOption));

						dropDownOptions.sendKeys("Others");

					}

				}
			}

//				

		}

	}

}
