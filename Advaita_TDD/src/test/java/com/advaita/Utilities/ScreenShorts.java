package com.advaita.Utilities;

import java.io.File;
import java.io.IOException;

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

}
