package com.advaita.Utilities;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class UploadFile extends TestBase {

	// File Upload
//	Usage
//	UploadFile.uploadFile(driver, element, "excel");
	private static final Map<String, String> fileTypeToFileName = new HashMap<>();
	static {
		fileTypeToFileName.put("image", "D:\\c drive\\Desktop\\Picture1.png");
		fileTypeToFileName.put("excel", "D:\\c drive\\Desktop\\Avision Table Pages.xlsx");
		fileTypeToFileName.put("docx", "D:\\c drive\\Desktop\\Sales Order Create.docx");
		fileTypeToFileName.put("text", "D:\\c drive\\Desktop\\Utility Methods.txt");
	}

	public static void uploadFilewithType(WebDriver driver, WebElement element, String fileType) throws Exception {
		js.executeScript("arguments[0].click();", element);

		String file = fileTypeToFileName.get(fileType);

		if (file == null) {
			throw new IllegalArgumentException("File type " + fileType + " not supported.");
		}

		StringSelection stringSelection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

//########################################################################################################################################################

	// Multiple file
//	    Usage
//	    List<String> fileTypes = Arrays.asList("image", "docx", "text");
//	    UploadFile.uploadFilesWithTypes(driver, fileInputElement, fileTypes);
	public static void uploadFilesWithTypes(WebDriver driver, WebElement element, List<String> fileTypes)
			throws Exception {
		// Concatenate file paths for all selected file types
		StringBuilder files = new StringBuilder();
		for (String fileType : fileTypes) {
			String file = fileTypeToFileName.get(fileType);
			if (file == null) {
				throw new IllegalArgumentException("File type " + fileType + " not supported.");
			}
			if (files.length() > 0) {
				files.append(" "); // Use space as separator for multiple files
			}
			files.append(file);
		}

		// Click on the element to open the file dialog
		js.executeScript("arguments[0].click();", element);

		// Copy the file paths to the clipboard
		StringSelection stringSelection = new StringSelection(files.toString());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		// Use Robot to paste the file paths and submit
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

//#######################################################################################################################################################

	// File Upload
	public static void uploadFile(WebDriver driver, WebElement element, int fileIndex) throws Exception {

		js.executeScript("arguments[0].click();", element);

		String[] files = new String[] { "D:\\c drive\\Desktop\\Picture1.png", // imgae
				"D:\\c drive\\Desktop\\Avision Table Pages.xlsx", // excel
				"D:\\c drive\\Desktop\\Sales Order Create.docx", // docx
				"D:\\c drive\\Desktop\\Utility Methods.txt" }; // Text

		String file = files[fileIndex];

		StringSelection stringSelection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);

//			try {
//				click(driver, closeButton);
//			} catch (Exception e) {
//				System.out.println("Close button is not displayed");
//			}

	}
	
//####################################################################################################################################################
	
	private static final Map<String, List<String>> fileTypeToFileNames = new HashMap<>();

	static {

		fileTypeToFileNames.put("image",
				List.of("D:\\c drive\\Desktop\\Picture1.png", "D:\\c drive\\Desktop\\Picture2.jpg"));
		fileTypeToFileNames.put("excel", List.of("D:\\c drive\\Desktop\\Avision Table Pages.xlsx",
				"D:\\c drive\\Desktop\\Another Spreadsheet.xlsx"));
		fileTypeToFileNames.put("docx", List.of("D:\\c drive\\Desktop\\Sales Order Create.docx",
				"D:\\c drive\\Desktop\\Another Document.docx"));
		fileTypeToFileNames.put("text",
				List.of("D:\\c drive\\Desktop\\Utility Methods.txt", "D:\\c drive\\Desktop\\Another Text File.txt"));
	}

	public static void uploadMultipleFiles(WebDriver driver, WebElement element, String fileType) throws Exception {
		element.click();

		List<String> files = fileTypeToFileNames.get(fileType);

		if (files == null || files.isEmpty()) {
			throw new IllegalArgumentException("File type " + fileType + " not supported or no files available.");
		}

		// Join file paths with newline character for multi-select
		String allFilePaths = String.join("\n", files);

		StringSelection stringSelection = new StringSelection(allFilePaths);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

//	Usage
//	UploadFile.uploadMultipleFiles(driver, element, "image");
	
}
