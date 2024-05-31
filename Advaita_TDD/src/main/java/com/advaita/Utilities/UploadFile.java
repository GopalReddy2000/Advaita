package com.advaita.Utilities;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class UploadFile extends TestBase{
	
	// File Upload
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
	    
//		Usage
//		FileUploader.uploadFile(driver, element, "excel");

}
