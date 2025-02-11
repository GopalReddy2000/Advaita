package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.CommonUtils;
import com.advaita.Utilities.FieldVerificationUtils;
import com.advaita.Utilities.PropertieFileUtil;

import Advaita_TDD.Advaita_TDD.FakeData;

public class ManualUpload extends TestBase {

	@FindBy(xpath = "//table[contains(@class,'dataset_subtable')]/tbody/tr/td[2]")
	public List<WebElement> dataSetQuestions;

	@FindBy(id = "pills-dataupload-tab")
	public WebElement dataTab;

	@FindBy(id = "pills-ManualUpload-tab")
	public WebElement manualUploadTab;

	@FindBy(linkText = "+ Create")
	public WebElement createManualUploadButton;

	@FindBy(xpath = "//div[@id='datauploadPopup']//div[@class='modal-content']//form[@name='ManualUploadForm']")
	public WebElement createManualUploadPopUp;

	@FindBy(id = "id_upload_name")
	public WebElement nameField;

	@FindBy(xpath = "//label[normalize-space()='Dataset']/..//select[@id='dataset_dropdown']")
	public WebElement dataSetDropdown;

	@FindBy(xpath = "//button[normalize-space()='Export Sample Format']")
	public WebElement exportSampleFormatButton;

	@FindBy(xpath = "//input[@id='Browse']")
	public WebElement uploadElement;

	@FindBy(xpath = "//textarea[@name='upload_remarks']")
	public WebElement uploadRemarkField;

	@FindBy(xpath = "//input[@placeholder='File Name']")
	public WebElement fileNameField;

	@FindBy(xpath = "//input[@placeholder='Sheet Name']")
	public WebElement sheetNameField;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	public WebElement createButton;

	@FindBy(xpath = "//span[normalize-space()='Manual Data has been created successfully']")
	public WebElement confirmationAfterCreatedManualUpload;

	@FindBy(id = "id_upload_name-error")
	public WebElement nameFieldError;

	@FindBy(id = "change_error_msg")
	public WebElement errorMessagePop;

	@FindBy(xpath = "//h2[text()='Create Manual Upload']/following-sibling::span")
	public WebElement close;

	@FindBy(xpath = "//span[text()='Total Records :']/following-sibling::span[1]")
	public WebElement noOfUploadedRecord;

	@FindBy(xpath = "//span[text()='Data Setup']")
	public WebElement dataSetup;

	@FindBy(xpath = "//button[text()='Data Upload']")
	public WebElement dataUpload;

	@FindBy(xpath = "//h2/../..//table//thead//th[1]/../../..//tbody/tr/td[1]")
	public List<WebElement> uploadedRecord;

	@FindBy(xpath = "//ul[@id='paginationLinks']//a")
	public List<WebElement> pagination;

	@FindBy(xpath = "//h2[contains(@class,'dataset_names_show')]/..//span[@aria-label='Close'][normalize-space()='×']")
	public WebElement closeButtonOnPopUp;

	public ManualUpload() {

		PageFactory.initElements(driver, this);
	}

	String fileName;

	DataSet dataSet = new DataSet();

	MetaData metaData = new MetaData();

	public ManualUpload navigateToManualUpload() throws Throwable {

		dataSetup.click();

		// Assert whether dataSetTab Button is Displayed on the left Navigation Menu
		assertTrue(dataSet.dataSetTab.isDisplayed(), "dataSetTab is not Displayed");
		dataSet.dataSetTab.click();

		// Assert whether Datasetup Button is Displayed on the left Navigation Menu
		assertTrue(dataTab.isDisplayed(), "dataTab is not Displayed");
		dataTab.click();

		String expecteddURL = mainURl + "en/data_management/data_upload_manual/";

		String actualURL = driver.getCurrentUrl();

		assertEquals(actualURL, expecteddURL);

		return this;
	}

	public ManualUpload createNewManualUpload(String name) throws Throwable {

		click(driver, createManualUploadButton);

		wait.until(ExpectedConditions.visibilityOf(createManualUploadPopUp));
		assertTrue(createManualUploadPopUp.isDisplayed());

		FieldVerificationUtils.verifyTextField(nameField, "Name ", name, true, true, 1);

		String dataSetValue = PropertieFileUtil.getSingleTextFromPropertiesFile("dataSetName").replace(" ", "");
		metaData.selectDataSet(dataSetDropdown, dataSetValue);

		return this;
	}

	public ManualUpload formatDownloadAndUpdateAndUpload(ArrayList<String> filteredItems,
			List<Map<String, String>> generatedQuestions, int noOfQuestionsInExcel) throws Throwable {

		click(driver, exportSampleFormatButton);

		Thread.sleep(2000);

		// Step 2: Find the most recent file in the default download directory
		String downloadPath = System.getProperty("user.home") + "/Downloads";
		File downloadedFile = Files.list(Paths.get(downloadPath))
				.filter(f -> f.toString().endsWith(".xlsx") || f.toString().endsWith(".xls"))
				.max(Comparator.comparingLong(f -> f.toFile().lastModified())).get().toFile();

		fileName = downloadedFile.getName();

		System.out.println("Downloaded file name: " + downloadedFile.getName());

		// Step 3: Write to the Excel file
		FileInputStream fis = new FileInputStream(downloadedFile);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		// Get the first row to determine the number of columns
		Row firstRow = sheet.getRow(0);
		int numberOfColumns = firstRow.getLastCellNum();

		// Validate the columns in Excel with filteredItems
		List<String> excelColumns = new ArrayList<>();
		for (int colIndex = 0; colIndex < numberOfColumns; colIndex++) {
			Cell cell = firstRow.getCell(colIndex);
			if (cell != null) {
				excelColumns.add(cell.getStringCellValue().trim());
			}
		}

		System.out.println("excelColumns : " + excelColumns);

		System.out.println("filteredItems : " + filteredItems);

		assertTrue(excelColumns.equals(filteredItems), "Excel columns are mismatching.");

		// Iterate over each column and add five values below existing rows
		int lastRowNum = sheet.getLastRowNum();
		for (int colIndex = 0; colIndex < numberOfColumns; colIndex++) {
			String columnName = excelColumns.get(colIndex);

			// Find the matching question type based on the column name
			String questionType = generatedQuestions.stream()
					.filter(q -> q.get("FieldName").equalsIgnoreCase(columnName)).map(q -> q.get("Type")).findFirst()
					.orElse("");

			for (int i = 1; i <= noOfQuestionsInExcel; i++) { // Adding five values below the last row
				Row row = sheet.getRow(lastRowNum + i);
				if (row == null) {
					row = sheet.createRow(lastRowNum + i);
				}
				Cell cell = row.createCell(colIndex);

				// Generate and set the appropriate value based on the question type
				if (questionType.equalsIgnoreCase("Text Area")) {
					cell.setCellValue(FakeData.generateUniqueRandomString(6)); // Custom value with column name

				} else if (questionType.equalsIgnoreCase("Number")) {
					cell.setCellValue(FakeData.generateUniqueRandomNumber(100, 999)); // Generate random number

				} else if (questionType.equalsIgnoreCase("Date")) {
					cell.setCellValue(FakeData.getDate(1, 1)); // Generate a future date

				} else if (questionType.equalsIgnoreCase("Date Time")) {
					cell.setCellValue(FakeData.getDate(1, 1)); // Generate a future date

				} else if (questionType.equalsIgnoreCase("Character")) {
					cell.setCellValue(FakeData.generateUniqueRandomChar(7)); // Generate random string

				} else if (questionType.equalsIgnoreCase("HyperLink")) {
					cell.setCellValue(FakeData.generateRandomHyperlink()); // Generate random string

				} else if (questionType.equalsIgnoreCase("Boolean")) {
					cell.setCellValue(FakeData.generateRandomBoolean()); // Generate random string

				} else {
					cell.setCellValue(columnName + " " + i); // Default fallback value
				}
			}
		}
		fis.close();

		FileOutputStream fos = new FileOutputStream(downloadedFile);
		workbook.write(fos);
		fos.close();
		workbook.close();

		// Step 4: Upload the modified Excel file
		uploadElement.sendKeys(downloadedFile.getAbsolutePath());

		return this;
	}

	public ManualUpload fillOtherFildsForUploadedFile(String remark) throws IOException {

		String dataSetValue = PropertieFileUtil.getSingleTextFromPropertiesFile("dataSetName").replace(" ", "");

		FieldVerificationUtils.verifyTextArea(uploadRemarkField, remark, true);

		String dataSetXpath = "//div[@class='dataset-box']/h5[normalize-space()='" + dataSetValue + "']";

		WebElement selectedDataSet = driver.findElement(By.xpath(dataSetXpath));

		assertTrue(selectedDataSet.isDisplayed(), "selectedDataSet is not Displayed");

//		FieldVerificationUtils.verifyTextArea(fileNameField, fileName, false);
//
//		String clickFileXpath = "//li//div[normalize-space()='" + fileName + "']";
//
//		WebElement clickFile = driver.findElement(By.xpath(clickFileXpath));
//
//		clickFile.click();

		String fileNameValue = fileNameField.getAttribute("value");

		assertEquals(fileNameValue, fileName, "File Name Mis-Matched");

		FieldVerificationUtils.verifyTextArea(sheetNameField, "Sheet", false);

		return this;
	}

	public ManualUpload createButtonAndConfirmation() throws Throwable {

		ClickUtilities.normalClick(createButton);

		wait.until(ExpectedConditions.visibilityOf(confirmationAfterCreatedManualUpload));
		assertTrue(confirmationAfterCreatedManualUpload.isDisplayed(),
				"confirmationAfterCreatedManualUpload is not displayed.");

		click(driver, metaData.continueButton);

		return this;
	}

	public ManualUpload valiadtionsAfterCreationOfManualUpload(String dataSet, String uploadName, String uploadRemark,
			int numberOfUploadedData) throws Throwable {

		String dataSetXpath = "(//tbody//tr//td[normalize-space()='" + dataSet.replace(" ", "") + "'])[1]";
		assertTrue(driver.findElement(By.xpath(dataSetXpath)).isDisplayed(), "dataSet is not displayed.");

		String uploadNameXpath = "(//tbody//tr//td[normalize-space()='" + uploadName + "'])[1]";
		assertTrue(driver.findElement(By.xpath(uploadNameXpath)).isDisplayed(), "uploadName is not displayed.");

		String uploadRemarkXpath = "(//tbody//tr//td[normalize-space()='" + uploadRemark + "'])[1]";
		assertTrue(driver.findElement(By.xpath(uploadRemarkXpath)).isDisplayed(),
				"uploadRemarkXpath is not displayed.");

//	Records After Upload

		String uploadRecordViewButton = "//tbody//tr//td[normalize-space()='" + uploadName
				+ "']/..//a[@id='show_history']";
		driver.findElement(By.xpath(uploadRecordViewButton)).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(uploadRecordViewButton)));
		int noOfRecords = countTotalRecords(pagination, uploadedRecord);

		System.out.println("noOfRecords : " + noOfRecords);
//
//		assertEquals(numberOfUploadedData, noOfRecords, "Values are not equal!");

		click(driver, closeButtonOnPopUp);

		return this;
	}

	public int countTotalRecords(List<WebElement> elementPagination, List<WebElement> elementRecords) {
		int totalRecords1 = 0;
		int totalRecords2 = 0;
		int totalRecords3 = totalRecords1 + totalRecords2;

		wait.until(ExpectedConditions.visibilityOfAllElements(elementPagination));
		System.out.println("elementPagination size : " + elementPagination.size());

		for (int i = 0; i < elementPagination.size(); i++) {
			// Wait for table rows to be visible and count them
//			wait.until(ExpectedConditions.visibilityOfElementLocated(tableRowLocator));

			if (i == 0) {
				totalRecords1 = elementRecords.size();
			}
			if (i == 1) {
				totalRecords1 = elementRecords.size();
			}

			// Navigate to the next page if it's not the last page

//				CommonUtils.scrollToElementByActions(elementPagination.get(i));
			CommonUtils.scrollToElementByJS(elementPagination.get(i));

			jsClick(elementPagination.get(i));

			unWait(2);
		}
		return totalRecords3;
	}

	public static void sendKeysWithParams(WebElement element, String text) {
		js.executeScript("arguments[0].value = arguments[1];", element, text);
	}

	public ManualUpload manualUploadRecord(String recordName, String dataSet, String uploadFile, String remarks,
			String fileName, String sheetName) {

		dataSetup.click();
		dataUpload.click();
		manualUploadTab.click();

		createManualUploadButton.click();

		nameField.sendKeys(recordName);
		selectByVisibleText(dataSetDropdown, dataSet);

		uploadElement.sendKeys(uploadFile);
		uploadRemarkField.sendKeys(remarks);
//		fileNameField.sendKeys(fileName);
		sendKeysWithParams(fileNameField, fileName);
		sheetNameField.sendKeys(sheetName);

		createButton.click();
		unWaitInMilli(500);
		continueButton.click();

		return this;
	}

	public ManualUpload navToManualUpload() {
		dataSetup.click();
		dataUpload.click();
		manualUploadTab.click();
		return this;
	}

	public ManualUpload create() {
		createManualUploadButton.click();
		return this;
	}

	public ManualUpload name(String fileName) {
		sendKeys(nameField, fileName);
		return this;
	}

	public ManualUpload datasetDropdown(String datasetName) {
		selectByVisibleText(dataSetDropdown, datasetName);
		return this;
	}

	public ManualUpload exportSampleFormat() {
		exportSampleFormatButton.click();
		return this;
	}

	public ManualUpload uploadSheet(String uploadFile) {
		sendKeys(uploadElement, uploadFile);
		return this;
	}

	public ManualUpload remarksField(String uploadRemarks) {
		sendKeys(uploadRemarkField, uploadRemarks);
		return this;
	}

	public ManualUpload fileName(String filename) {
		sendKeysWithParams(fileNameField, filename);
		return this;
	}

	public ManualUpload sheetName(String sheetname) {
		sendKeysWithParams(sheetNameField, sheetname);
		return this;
	}

	public ManualUpload recordCreate() {
		createButton.click();
		return this;
	}

	public boolean nameError(String errorMessage) {
		try {
			return nameFieldError.isDisplayed() && nameFieldError.getText().equals(errorMessage);
		} catch (NoSuchElementException e) {
			System.out.println("No Error Message Displayed as: " + errorMessage);
			return false;
		}
	}

	public WebElement errorDialogBox() {
		return errorMessagePop;
	}

	public ManualUpload closeDialogBox() {
		jsClick(close);
		return this;
	}

}
