package com.advaita.DataSetUp.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.FieldVerificationUtils;

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

	public ManualUpload() {

		PageFactory.initElements(driver, this);
	}

	String dataSetValue;

	public ArrayList<String> filteredItems = new ArrayList<>();

	String fileName;

	DataSet dataSet = new DataSet();

	MetaData metaData = new MetaData();

	public ManualUpload navigateToManualUpload() throws Throwable {

		// Assert whether dataSetTab Button is Displayed on the left Navigation Menu
		assertTrue(dataSet.dataSetTab.isDisplayed(), "dataSetTab is not Displayed");
		dataSet.dataSetTab.click();

		dataSetValue = metaData.fetchDataSet.getText();

		click(driver, metaData.fetchDataSet);

		// Iterate through the items and add them to the ArrayList
		for (WebElement item : dataSetQuestions) {

			Thread.sleep(300);
			String text = item.getText();
			if (text.equals("Trans Unique Id")) {
				break; // Stop when we reach "Trans Unique Id"
			}
			filteredItems.add(text);
		}

		click(driver, metaData.closeButton);

		for (String item : filteredItems) {
			System.out.println("Data Set Questions : " + item);
		}

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

	public ManualUpload fillOtherFildsForUploadedFile(String remark) {

		FieldVerificationUtils.verifyTextArea(uploadRemarkField, remark, true);

		String dataSetXpath = "//div[@class='dataset-box']/h5[normalize-space()='" + dataSetValue + "']";

		WebElement selectedDataSet = driver.findElement(By.xpath(dataSetXpath));

		assertTrue(selectedDataSet.isDisplayed(), "selectedDataSet is not Displayed");

		FieldVerificationUtils.verifyTextArea(fileNameField, fileName, false);

		String clickFileXpath = "//li//div[normalize-space()='" + fileName + "']";

		WebElement clickFile = driver.findElement(By.xpath(clickFileXpath));

		clickFile.click();

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

	public ManualUpload valiadtionsAfterCreationOfManualUpload(String dataSet, String uploadName, String uploadRemark)
			throws Throwable {

		String dataSetXpath = "//tbody/tr[1]//td[normalize-space()='" + dataSet + "']";
		assertTrue(driver.findElement(By.xpath(dataSetXpath)).isDisplayed(), "dataSet is not displayed.");

		String uploadNameXpath = "//tbody/tr[1]//td[normalize-space()='" + uploadName + "']";
		assertTrue(driver.findElement(By.xpath(uploadNameXpath)).isDisplayed(), "uploadName is not displayed.");

		String uploadRemarkXpath = "//tbody/tr[1]//td[normalize-space()='" + uploadRemark + "']";
		assertTrue(driver.findElement(By.xpath(uploadRemarkXpath)).isDisplayed(),
				"uploadRemarkXpath is not displayed.");

		return this;
	}

}
