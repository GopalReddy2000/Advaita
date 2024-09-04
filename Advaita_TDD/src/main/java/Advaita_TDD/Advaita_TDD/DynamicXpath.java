package Advaita_TDD.Advaita_TDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class DynamicXpath extends TestBase {

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement uploadMultipleFilesToggleButton(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h6[normalize-space()='Upload Multiple File']/..//input[@name='fileupload_settings_multifile_%d_%d']/following-sibling::span",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement allowDeleteToggleButton(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h6[normalize-space()='Allow Delete']/..//input[@name='fileupload_settings_allowdelete_%d_%d']/following-sibling::span",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement maxsizeField(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h5[normalize-space()='Max Size']/following-sibling::div/div/div/input[@name='fileupload_settings_maxsize_%d_%d']",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement maxsizeDropDown(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h5[normalize-space()='Max Size']/following-sibling::select[@name='fileupload_settings_sizeunit_%d_%d']",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement addConditionDropDown(int sectionNumber, int subSectionNumber, int subSubSectionNumbe) {
		String xpath = String.format(
				"//label[normalize-space()='ADD CONDITION']/..//select[@name='next_condition_%d_%d_%d']", sectionNumber,
				subSectionNumber, subSubSectionNumbe);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement tableView(int index) {
		String xpath = String.format(
				"(//h5[text()='VIEW']/ancestor::div//a[@data-info2='Table View']/span/..//h5[normalize-space()='Table View'])[%d]",
				index);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement textBox(int sectionNumber, int subSectionNumber) {
		String xpath = String.format("//input[@name='question_%d_%d']", sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement shortAnswerQuestionOpt(int sectionNumber, int questionNumber, int questionOptionNumber) {
		String xpath = String.format("//textarea[@name='ans_option_%d_%d_%d']", sectionNumber, questionNumber,
				questionOptionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement questionType(int sectionNumber, int questionNumber, int questionType) {
		String xpath = String.format(
				"//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_%d_%d']/following-sibling::div[%d]//h6",
				sectionNumber, questionNumber, questionType);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement questionTypeOptions(int sectionNumber, int questionNumber, int questionOptionNumber) {
		String xpath = String.format("//input[@name='ans_option_%d_%d_%d']", sectionNumber, questionNumber,
				questionOptionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement addOptions(int sectionNumber, int subSectionNumber) {
		String xpath = String.format("//div[@data-info='%d_%d']//a[text()='Add Option']", sectionNumber,
				subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement maxLength(int sectionNumber, int subSectionNumber) {
		String xpath = String.format("(//input[@name='textbox_settings_max_length_%d_%d'])[1]", sectionNumber,
				subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement shortMaxLength(int sectionNumber, int subSectionNumber) {
		String xpath = String.format("(//input[@name='shortans_settings_max_length_%d_%d'])[1]", sectionNumber,
				subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement minLength(int sectionNumber, int subSectionNumber) {
		String xpath = String.format("(//input[@name='textbox_settings_min_length_%d_%d'])[1]", sectionNumber,
				subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement shortMinLength(int sectionNumber, int subSectionNumber) {
		String xpath = String.format("(//input[@name='shortans_settings_min_length_%d_%d'])[1]", sectionNumber,
				subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement valueTypeDropDown(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h6[normalize-space()='Value-Type']/following::select[@name='textbox_settings_value_type_%d_%d']",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}
	
	public static WebElement shortValueTypeDropDown(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h6[normalize-space()='Value-Type']/following::select[@name='shortans_settings_value_type_%d_%d']",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}
	
	public static WebElement allowSpCharToggle(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h6[normalize-space()='Allow-Sp-Char']/following::label/input[@name='textbox_settings_allow_sp_char_%d_%d']/../span",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}
	
	public static WebElement shortAllowSpCharToggle(int sectionNumber, int subSectionNumber) {
		String xpath = String.format(
				"//h6[normalize-space()='Allow-Sp-Char']/following::label/input[@name='shortans_settings_allow_sp_char_%d_%d']/../span",
				sectionNumber, subSectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement fileTypeSetting(int sectionNumber) {
		String xpath = String.format(
				"(//div[@class='upload-cloud']/ancestor::div//img[@class='trashimg answer_option fileupload'])[%d]",
				sectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement fileUploadFormatDropDown(int sectionNumber) {
		String xpath = String.format(
				"(//div[@class='upload-cloud']/ancestor::div//img[@class='trashimg answer_option fileupload'])[%d]",
				sectionNumber);
		return driver.findElement(By.xpath(xpath));
	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
//	public static List<WebElement> checkQuestionTypes(int sectionNumber, int question) {
//	    String xpath = String.format(
//	        "//label[normalize-space()='SELECT QUESTION TYPE']/..//input[@name='question_type_%d_%d']/following-sibling::div//h6",
//	        sectionNumber, question);
//	    return driver.findElements(By.xpath(xpath));
//	}

	// Method to generate the dynamic XPath and return the WebElement %d-section or
	// sub section number
	public static WebElement questionField(int questionNum, int sectionNumber, int questionFieldNum) {
		String xpath = String.format("//div[h5[contains(text(), 'Question %d')]]//input[@name='question_%d_%d']",
				questionNum, sectionNumber, questionFieldNum);
		return driver.findElement(By.xpath(xpath));
	}

}
