package com.advaita.sideMasters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.CommonUtils;
import com.advaita.Utilities.DatePicker;
import com.advaita.Utilities.DatePicker.DateOption;
import com.advaita.Utilities.DropDown;

import Advaita_TDD.Advaita_TDD.Questions;

public class MastersAdd extends TestBase {

	@FindBy(xpath = "//span[contains(@class,'text')][normalize-space()='Masters']")
	public WebElement mastersSideBar;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Cancel']")
	public WebElement cancelButton;

	@FindBy(xpath = "//button[@type='submit'][normalize-space()='Submit']")
	public WebElement submitButton;
	
	@FindBy(xpath = "//h3[text()='Success']/..//span[normalize-space()='Data updated successfully']")
	public WebElement confirmationPopUp;

	public MastersAdd() {

		PageFactory.initElements(driver, this);
	}

	public MastersAdd navigateToMastersAdd(String masterMenu) {

		click(driver, alchemy);
		CommonUtils.scrollToElementByActions(mastersSideBar);

		click(driver, mastersSideBar);
		String addMasters = String.format("//a[@data-action='add'][normalize-space()='Add %s']", masterMenu);
		WebElement addMasterOption = driver.findElement(By.xpath(addMasters));
		click(driver, addMasterOption);

		return this;
	}

	private static LinkedHashMap<String, String> storedQuestions = new LinkedHashMap<>();
	private static LinkedHashMap<String, String[]> storedOptions = new LinkedHashMap<>();
	private static LinkedHashMap<String, String> storedTypes = new LinkedHashMap<>();

	// Load questions (remains unchanged unless file location differs)
	public static void loadStoredQuestions() {
		unWait(2);
		try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/questions.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);

			properties.stringPropertyNames().stream().filter(key -> !key.endsWith("_type") && !key.endsWith("_options"))
					.sorted().forEach(key -> storedQuestions.put(key, properties.getProperty(key)));

			properties.stringPropertyNames().stream().filter(key -> key.endsWith("_options")).forEach(
					key -> storedOptions.put(key.replace("_options", ""), properties.getProperty(key).split(",")));

			properties.stringPropertyNames().stream().filter(key -> key.endsWith("_type"))
					.forEach(key -> storedTypes.put(key.replace("_type", ""), properties.getProperty(key)));

			System.out.println("Properties file reloaded successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load stored questions from properties file otrzymał");
		}
	}

	// Main method for Add Form
	public MastersAdd validateAndInteractAddForm() throws Throwable {
		// Update XPath based on Add Form page structure
		List<WebElement> questionContainers = driver
				.findElements(By.xpath("//div[@class='row']//div[contains(@class, 'custom-select')]")); // Example
																										// adjustment

		assertEquals(questionContainers.size(), storedQuestions.size(),
				"Mismatch in the number of questions on Add Form!");

		int index = 0;
		for (Map.Entry<String, String> entry : storedQuestions.entrySet()) {
			String questionKey = entry.getKey();
			String expectedQuestion = entry.getValue();
			WebElement questionContainer = questionContainers.get(index);
			WebElement questionLabel = questionContainer.findElement(By.tagName("label"));
			String actualQuestion = questionLabel.getText().trim();

			System.out.println("Validating Add Form Question " + (index + 1) + ": " + actualQuestion);
			assertEquals(actualQuestion, expectedQuestion, "Question order mismatch at index " + index);

			// Validate options if they exist
			validateOptionsIfExist(questionContainer, questionKey);

			// Interact with the question based on its type
			interactWithQuestion(questionContainer, questionKey);

			index++;
		}

		return this;
	}

	// Validate options (unchanged unless Add Form has different option structure)
	private void validateOptionsIfExist(WebElement questionContainer, String questionKey) {
		if (storedOptions.containsKey(questionKey)) {
			WebElement selectElement;
			try {
				selectElement = questionContainer.findElement(By.tagName("select"));
			} catch (Exception e) {
				System.out.println("No dropdown found for: " + questionContainer.getText());
				return;
			}

			List<WebElement> optionElements = selectElement.findElements(By.tagName("option"));
			List<String> actualOptions = optionElements.stream().map(WebElement::getText)
					.filter(option -> !option.equalsIgnoreCase("Select")).collect(Collectors.toList());

			List<String> expectedOptions = Arrays.asList(storedOptions.get(questionKey));

			System.out
					.println("Validating options for: " + questionContainer.findElement(By.tagName("label")).getText());
			System.out.println("Expected Options: " + expectedOptions);
			System.out.println("Actual Options: " + actualOptions);

			assertEquals(actualOptions, expectedOptions,
					"Options mismatch for question: " + questionContainer.findElement(By.tagName("label")).getText());
		}
	}

	// Interact with questions (unchanged unless specific interactions need
	// adjustment)
	private void interactWithQuestion(WebElement questionContainer, String questionKey) throws Throwable {
		String questionType = storedTypes.getOrDefault(questionKey, "UNKNOWN");
		Random random = new Random();

		switch (questionType.toUpperCase()) {
		case "DROP_DOWN":
			WebElement selectElement = questionContainer.findElement(By.tagName("select"));
			Select dropdown = new Select(selectElement);
			List<WebElement> options = dropdown.getOptions();
			int randomIndex = random.nextInt(options.size() - 1) + 1;
			dropdown.selectByIndex(randomIndex);
			System.out.println("Selected random option: " + options.get(randomIndex).getText());
			break;

		case "TEXT_BOX":
		case "SHORT_ANSWER":
			WebElement textBox = questionContainer.findElement(By.tagName("input"));
			String questionText = questionContainer.findElement(By.tagName("label")).getText().trim();

			// Find matching question from generateGenuineTextBoxQuestionAndInputs
			Map.Entry<String, String[]> questionData = null;
			String firstQuestion = null; // To detect wrap-around
			int maxIterations = 100; // Reasonable upper limit to prevent infinite loop

			for (int i = 0; i < maxIterations; i++) {
				Map.Entry<String, String[]> candidate = Questions.generateGenuineTextBoxQuestionAndInputs(i, false);

				// Store the first question to detect when the list wraps around
				if (i == 0) {
					firstQuestion = candidate.getKey();
				}

				// Check if this candidate matches the current question
				if (candidate.getKey().equals(questionText)) {
					questionData = candidate;
					break;
				}

				// If we’ve wrapped back to the first question, we’ve checked all possibilities
				if (i > 0 && candidate.getKey().equals(firstQuestion)) {
					break;
				}
			}

			// Fallback if no match found (use first question as default)
			if (questionData == null) {
				questionData = Questions.generateGenuineTextBoxQuestionAndInputs(0, false);
				System.out.println(
						"Warning: No matching question found for '" + questionText + "', using default constraints.");
			}

			int minLength = Integer.parseInt(questionData.getValue()[0]); // First element is minLength
			int maxLength = Integer.parseInt(questionData.getValue()[1]); // Second element is maxLength
			String typeOfValue = questionData.getValue()[3]; // Fourth element is typeOfValue

			System.out.println("maxLength : " + maxLength + "\n" + "minLength : " + minLength);
			// Generate random length between min and max
			int textLength = minLength + random.nextInt(maxLength - minLength + 1);
			StringBuilder generatedText = new StringBuilder();

			if (typeOfValue.equals("Only Number")) {
				for (int i = 0; i < textLength; i++) {
					generatedText.append(random.nextInt(10));
				}
			} else { // Only Text or default
				String baseText = "Test";
				generatedText.append(baseText);
				while (generatedText.length() < textLength) {
					generatedText.append((char) ('a' + random.nextInt(26)));
				}
			}

			// Ensure text is within bounds
			String finalText = generatedText.length() > maxLength ? generatedText.substring(0, maxLength)
					: generatedText.toString();

			textBox.sendKeys(finalText);
			System.out.println("Entered text: " + finalText + " (length: " + finalText.length() + ")");
			break;

		case "MULTIPLE_CHOICE":
			DropDown.selectMultipleOptionsWithCustomSelection(driver, questionContainer, random, 1);
			break;

		case "RADIO_BUTTON":
			List<WebElement> radioButtons = questionContainer.findElements(By.xpath(".//input[@type='radio']"));
			int randomRadioIndex = random.nextInt(radioButtons.size());
			radioButtons.get(randomRadioIndex).click();
			System.out.println("Selected radio: " + radioButtons.get(randomRadioIndex).getText());
			break;

		case "DATE":
			WebElement dateInput = questionContainer.findElement(By.xpath(".//input[@placeholder='DD-MM-YYYY']"));
			DatePicker.sendFormattedDateTime(driver, dateInput, DateOption.TOMORROW, null);

			break;
		case "TIME":
			WebElement timeInput = questionContainer.findElement(By.xpath(".//input[@placeholder='HH:MM']"));

			DatePicker.selectTimeByActions(driver, timeInput, null);

			// DatePicker.selectTime(driver, timeInput, null);
//			DatePicker.sendTime(timeInput, null, null, null);// current time
//			DatePicker.sendTime(timeInput, 5, 39, "PM");// custom time

			break;

		case "FILE_UPLOAD":
			WebElement fileInput = questionContainer.findElement(By.xpath(".//input[@type='file']"));
			fileInput.sendKeys("path/to/test/file.txt");
			break;

		default:
			System.out.println("No interaction defined for type: " + questionType);
			break;
		}
	}

	public MastersAdd saveAddMasters() {

		ClickUtilities.scrollToViewAndClick(submitButton);
		assertTrue(confirmationPopUp.isDisplayed(), "confirmationPopUp is not displayed.");
		

		return this;
	}

}
