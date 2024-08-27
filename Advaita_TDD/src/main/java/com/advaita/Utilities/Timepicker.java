package com.advaita.Utilities;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.advaita.BaseClass.TestBase;

public class Timepicker extends TestBase
{
	public static void selectRandomTime(List<WebElement> element,WebDriver driver) 
	{
        // Locate the time picker container
        WebElement timePickerContainer = driver.findElement(By.xpath("xdsoft_time_variant"));

        // Find all time elements within the container
        List<WebElement> timeElements = (List<WebElement>) timePickerContainer.findElement((By) element);

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(timeElements.size());

        // Click the time element at the random index
        timeElements.get(randomIndex).click();

        // Optionally print the selected time for verification
        System.out.println("Selected time: " + timeElements.get(randomIndex).getText());
    }

}
