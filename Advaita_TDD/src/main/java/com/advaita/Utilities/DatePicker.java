package com.advaita.Utilities;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advaita.BaseClass.TestBase;

public class DatePicker extends TestBase {

	// Date Picker 1
	public static void nextDatePicker(WebDriver driver, WebElement element, int numberOfClicks)
			throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		assertTrue(element.isDisplayed(), "Date Picker is not Displayed.");
		Thread.sleep(2000);
		click(driver, element);

		for (int i = 0; i < numberOfClicks; i++) {
			element.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(500); // Add a small delay if needed
		}

		element.sendKeys(Keys.ARROW_RIGHT);
		element.sendKeys(Keys.ENTER);
	}

	// Date Picker 2
	public static void selectPreviousDate(WebDriver driver, WebElement element, int numberOfClicks)
			throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		assertTrue(element.isDisplayed(), "Date Picker is not Displayed.");
		Thread.sleep(2000);
		click(driver, element);

		for (int i = 0; i < numberOfClicks; i++) {
			element.sendKeys(Keys.ARROW_UP);
			Thread.sleep(500); // Add a small delay if needed
		}

		element.sendKeys(Keys.ARROW_LEFT);
		element.sendKeys(Keys.ENTER);
	}

	/**
	 * Selects a date in the xdsoft_datetimepicker dynamically for any date.
	 * 
	 * @param driver       The WebDriver instance.
	 * @param dateInput    The WebElement that triggers the date picker (e.g., the
	 *                     input field).
	 * @param dateToSelect The date to select (e.g., "2025-02-21" for a specific
	 *                     date, or null for today).
	 */
	public static void selectDate(WebDriver driver, WebElement dateInput, String dateToSelect) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver; // Ensure js is defined

		// Step 1: Click the input to open the date picker and ensure only its picker is
		// active
		try {
			// Clear any existing pickers by clicking outside (optional, adjust XPath as
			// needed)
			driver.findElement(By.xpath("//body")).click(); // Reset focus
			unWaitInMilli(500);
			dateInput.click();
			unWaitInMilli(500); // Brief wait for picker to initialize
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", dateInput); // Fallback to JS click
			unWaitInMilli(500);
		}

		// Step 2: Locate the date picker specific to this dateInput
		WebElement datePicker;
		try {
			// Use a relative XPath from the dateInput to find its associated picker
			datePicker = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath(".//following::div[contains(@class, 'xdsoft_datetimepicker')][1]")));
			// Ensure the picker is active
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					".//following::div[contains(@class, 'xdsoft_datetimepicker')][1]//div[@class='xdsoft_datepicker active']")));
		} catch (Exception e) {
			// Fallback: Find all pickers and select the closest one to this dateInput
			List<WebElement> pickers = driver
					.findElements(By.xpath("//div[contains(@class, 'xdsoft_datetimepicker')]"));
			datePicker = pickers.stream()
					.filter(p -> p.isDisplayed() && Math.abs(p.getLocation().y - dateInput.getLocation().y) < 300) // Proximity
																													// check
					.findFirst().orElseThrow(() -> new RuntimeException("No visible date picker found for this input"));
		}

		// Step 3: Hide other pickers to avoid interference (optional)
		List<WebElement> allPickers = driver.findElements(By.xpath("//div[contains(@class, 'xdsoft_datetimepicker')]"));
		for (WebElement picker : allPickers) {
			if (!picker.equals(datePicker)) {
				js.executeScript("arguments[0].style.display = 'none';", picker);
			}
		}

		// Step 4: Center the target date picker on the page
		js.executeScript("arguments[0].style.position = 'fixed';" + "arguments[0].style.left = '50%';"
				+ "arguments[0].style.top = '50%';" + "arguments[0].style.transform = 'translate(-50%, -50%)';"
				+ "arguments[0].style.zIndex = '9999';" + "arguments[0].style.display = 'block';", datePicker);

		// Step 5: Verify visibility and size
		wait.until(ExpectedConditions.visibilityOf(datePicker));
		Dimension size = datePicker.getSize();
		if (size.getWidth() <= 0 || size.getHeight() <= 0) {
			throw new RuntimeException("Date picker has no size: " + size);
		}
		System.out.println("Date picker size: " + size + ", location: " + datePicker.getLocation());

		// Step 6: Determine the target date
		LocalDate targetDate = (dateToSelect == null) ? LocalDate.now()
				: LocalDate.parse(dateToSelect, DateTimeFormatter.ISO_LOCAL_DATE);
		int targetYear = targetDate.getYear();
		int targetMonth = targetDate.getMonthValue() - 1; // 0-based for xdsoft
		int targetDay = targetDate.getDayOfMonth();

		// Step 7: Navigate to year and month
		WebElement monthLabel = wait.until(ExpectedConditions
				.visibilityOf(datePicker.findElement(By.className("xdsoft_month")).findElement(By.tagName("span"))));
		WebElement yearLabel = wait.until(ExpectedConditions
				.visibilityOf(datePicker.findElement(By.className("xdsoft_year")).findElement(By.tagName("span"))));

		int currentYear = Integer.parseInt(yearLabel.getText());
		int currentMonth = getMonthIndex(monthLabel.getText());

		while (currentYear != targetYear) {
			WebElement yearNavButton = (currentYear < targetYear) ? datePicker.findElement(By.className("xdsoft_next"))
					: datePicker.findElement(By.className("xdsoft_prev"));
			js.executeScript("arguments[0].click();", yearNavButton);
			wait.until(ExpectedConditions.stalenessOf(yearLabel));
			yearLabel = wait.until(ExpectedConditions
					.visibilityOf(datePicker.findElement(By.className("xdsoft_year")).findElement(By.tagName("span"))));
			currentYear = Integer.parseInt(yearLabel.getText());
		}

		while (currentMonth != targetMonth) {
			WebElement monthNavButton = (currentMonth < targetMonth)
					? datePicker.findElement(By.className("xdsoft_next"))
					: datePicker.findElement(By.className("xdsoft_prev"));
			js.executeScript("arguments[0].click();", monthNavButton);
			wait.until(ExpectedConditions.stalenessOf(monthLabel));
			monthLabel = wait.until(ExpectedConditions.visibilityOf(
					datePicker.findElement(By.className("xdsoft_month")).findElement(By.tagName("span"))));
			currentMonth = getMonthIndex(monthLabel.getText());
		}

		// Step 8: Select the day
		String dayXPath = String.format(".//td[@data-date='%d' and @data-month='%d' and @data-year='%d']", targetDay,
				targetMonth, targetYear);
		WebElement dayElement = wait
				.until(ExpectedConditions.elementToBeClickable(datePicker.findElement(By.xpath(dayXPath))));
		System.out.println("Day element: " + dayElement.getAttribute("outerHTML"));
		js.executeScript("arguments[0].click();", dayElement);
		unWaitInMilli(500); // Allow UI to update

		// Step 9: Verify the selection
		String selectedValue = dateInput.getAttribute("value");
		System.out.println("Input value after selection: " + selectedValue);
		String expectedDate = targetDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); // Match DD-MM-YYYY
																							// placeholder
		if (!selectedValue.equals(expectedDate)) {
			System.out.println("Date not selected correctly. Expected: " + expectedDate + ", Found: " + selectedValue);
		} else {
			System.out.println("Date selected successfully: " + expectedDate);
		}
	}

	// Helper method (unchanged)
	private static int getMonthIndex(String monthName) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		for (int i = 0; i < months.length; i++) {
			if (months[i].equalsIgnoreCase(monthName)) {
				return i;
			}
		}
		throw new IllegalArgumentException("Invalid month name: " + monthName);
	}

	/**
	 * Selects a time in the xdsoft_timepicker.
	 * 
	 * @param driver       The WebDriver instance.
	 * @param timeInput    The WebElement that triggers the time picker (e.g., the
	 *                     input field).
	 * @param timeToSelect The time to select (e.g., "14:30" for 2:30 PM, or null
	 *                     for current time).
	 */
	public static void selectTime(WebDriver driver, WebElement timeInput, String timeToSelect) {
		// Use WebDriverWait to handle dynamic loading
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Click the input to open the time picker
//		timeInput.click();
		jsClick(timeInput);
		// Wait for the time picker to be visible
		WebElement timePicker = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("xdsoft_timepicker")));

		// Determine the time to select (current time if null)
		LocalTime targetTime = (timeToSelect == null) ? LocalTime.now() // Current time (e.g., 14:35 on Feb 20, 2025)
				: LocalTime.parse(timeToSelect, DateTimeFormatter.ofPattern("HH:mm"));

		// Round to the nearest hour if minutes are not in 00 increments (since this
		// picker only shows :00)
		int targetHour = targetTime.getHour();
		int targetMinute = 0; // This picker only supports :00, adjust if your picker supports other intervals

		// Locate the target time element
		WebElement timeElement;
		try {
			timeElement = timePicker.findElement(
					By.xpath(String.format(".//div[@data-hour='%d' and @data-minute='%d']", targetHour, targetMinute)));
		} catch (Exception e) {
			System.out.println("Target time " + targetHour + ":" + String.format("%02d", targetMinute)
					+ " not found directly, attempting to scroll.");
			scrollToTime(driver, timePicker, targetHour, targetMinute);
			timeElement = timePicker.findElement(
					By.xpath(String.format(".//div[@data-hour='%d' and @data-minute='%d']", targetHour, targetMinute)));
		}

		// Ensure the element is clickable and select it
		actions.moveToElement(timeElement).click().perform();

		System.out.println("Selected time: " + targetHour + ":" + String.format("%02d", targetMinute));
	}

	// Helper method to scroll to the target time if it’s not visible
	private static void scrollToTime(WebDriver driver, WebElement timePicker, int targetHour, int targetMinute) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement timeBox = timePicker.findElement(By.className("xdsoft_time_box"));
		WebElement currentVisibleTime = timeBox.findElement(By.className("xdsoft_current"));

		int currentHour = Integer.parseInt(currentVisibleTime.getAttribute("data-hour"));

		// Determine scroll direction
		while (currentHour != targetHour) {
			if (currentHour < targetHour) {
				timePicker.findElement(By.className("xdsoft_next")).click();
			} else {
				timePicker.findElement(By.className("xdsoft_prev")).click();
			}
			// Wait for the scroll to update and re-fetch the current visible time
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("xdsoft_current")));
			currentVisibleTime = timeBox.findElement(By.className("xdsoft_current"));
			currentHour = Integer.parseInt(currentVisibleTime.getAttribute("data-hour"));
		}
	}

	public enum DateOption {
		CURRENT, YESTERDAY, TOMORROW, CUSTOM
	}

	/**
	 * Sends formatted date-time to a specified web element
	 * 
	 * @param driver         WebDriver instance
	 * @param element        WebElement to send the date-time to
	 * @param option         DateOption enum to select current, yesterday, tomorrow,
	 *                       or custom
	 * @param customDateTime Optional custom date-time string in "yyyy-MM-dd HH:mm"
	 *                       format (required if option is CUSTOM)
	 */
	public static void sendFormattedDateTime(WebDriver driver, WebElement element, DateOption option,
			String customDateTime) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime;

			switch (option) {
			case YESTERDAY:
				dateTime = LocalDateTime.now().minusDays(1);
				break;
			case TOMORROW:
				dateTime = LocalDateTime.now().plusDays(1);
				break;
			case CUSTOM:
				if (customDateTime == null) {
					throw new IllegalArgumentException("Custom date-time cannot be null when using CUSTOM option");
				}
				dateTime = LocalDateTime.parse(customDateTime, formatter);
				break;
			case CURRENT:
			default:
				dateTime = LocalDateTime.now();
				break;
			}

			String dateTimeToSend = dateTime.format(formatter);
			SendDataUtils.sendKeysWithJSExecutor(element, dateTimeToSend);

		} catch (Exception e) {
			throw new RuntimeException("Failed to send date-time: " + e.getMessage());
		}
	}

	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("hh:mm a");

	// Method to get the current time or a custom time in the specified format
	public static String getTime(Integer hour, Integer minute, String amPm) {
		if (hour == null || minute == null || amPm == null) {
			return LocalTime.now().format(TIME_FORMATTER);
		}
		if (amPm.equalsIgnoreCase("PM") && hour < 12) {
			hour += 12;
		} else if (amPm.equalsIgnoreCase("AM") && hour == 12) {
			hour = 0;
		}
		LocalTime time = LocalTime.of(hour, minute);
		return time.format(TIME_FORMATTER);
	}

	// Method to get the current time or a custom time in the specified format
	public static void sendTime(WebElement element, Integer hour, Integer minute, String amPm) {

		SendDataUtils.sendKeysWithJSExecutor(element, getTime(hour, minute, amPm));

		System.out.println("Selected Time : " + getTime(hour, minute, amPm));
	}

	public static void selectTimeByActions(WebDriver driver, WebElement timeField, String timeString) {

		// Determine the time to set: Use provided time or current time
		LocalTime time;
		if (timeString == null || timeString.isEmpty()) {
			time = LocalTime.now(); // Use current system time
		} else {
			// Parse the given time string
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
			time = LocalTime.parse(timeString, formatter);
		}

		// Format time into hour, minutes, and AM/PM
		DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("hh");
		DateTimeFormatter minuteFormatter = DateTimeFormatter.ofPattern("mm");
		DateTimeFormatter amPmFormatter = DateTimeFormatter.ofPattern("a");

		String hour = time.format(hourFormatter);
		String minutes = time.format(minuteFormatter);
		String amPm = time.format(amPmFormatter);

		// Click on the time field
		actions.click(timeField).perform();

		// Enter hour
		actions.sendKeys(hour).perform();

		// Enter minutes
		actions.sendKeys(minutes).perform();

		// Press Right Arrow Key
		actions.sendKeys(Keys.ARROW_RIGHT).perform();

		// Enter AM/PM
		actions.sendKeys(amPm).perform();

		System.out.println("Entered Time : " + hour + ":" + minutes + " " + amPm);

		// Convert Entered Time to 24-hour format
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm");
		String enteredTime24Hour = LocalTime.parse(hour + ":" + minutes + " " + amPm, inputFormatter)
				.format(outputFormatter);

		String actualTime = timeField.getAttribute("value");

		// Assert that entered time and actual time match
		if (!actualTime.equals(enteredTime24Hour)) {
			throw new AssertionError("Time mismatch! Expected: " + enteredTime24Hour + " but found: " + actualTime);
		}
	}

}
