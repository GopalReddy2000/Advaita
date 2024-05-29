package com.advaita.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.advaita.BaseClass.TestBase;

public class ScreenShorts extends TestBase{
	
	// Screen Shot
		public void takeScreenShot(String fileName) throws IOException {

			String filePath = ".//Advaita_Transmmon//ScreenShot//" + fileName + ".png";

			// Check if the previous screenshot file exists
			File previousScreenshot = new File(filePath);
			if (previousScreenshot.exists()) {
				// Delete the previous screenshot file
				FileUtils.forceDelete(previousScreenshot);
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(filePath));

		}
		
		// Method to capture screenshot
	    public static String captureScreenshot(String methodName) {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        // After execution, you could see a folder "Screenshots" under project directory
	        String destination = System.getProperty("user.dir") + "/TSFailedScreenshots/" + methodName + dateName + ".png";
	        File finalDestination = new File(destination);
	        try {
	            FileUtils.copyFile(source, finalDestination);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return destination;
	    }

}
