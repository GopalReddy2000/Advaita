package com.SiteSetting.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Utilities.PropertieFileUtil;
import com.github.javafaker.Faker;

import Advaita_TDD.Advaita_TDD.FakeData;

public class SiteSettings extends TestBase {

	// Global Variables
	public String expectedValue = "Advaitha";
	public String extractSiteNameValue = "Advaitha";

	// Elements

	@FindBy(xpath = "//img[@class='img-fluid icon_before_heading']")
	public WebElement lineBarIcon;

	@FindBy(xpath = "//input[@id='id_site_name']")
	public WebElement siteNameTextfield;

	@FindBy(className = "edit_icon")
	public WebElement editOption;

	@FindBy(xpath = "//label[@for='id_opsguru_dashboard_url']")
	public WebElement verifyMenuUrlSetup;

	@FindBy(xpath = "//input[contains(@name, 'urls_name')]")
	public List<WebElement> menuName;

	@FindBy(xpath = "//input[contains(@name, 'urls_url')]")
	public List<WebElement> menuUrlName;

	@FindBy(xpath = "(//tbody[@class='dataset_form process-tab-pad']//tr[position() > 1]//td//div[@class='delete_div']//img)")
	public List<WebElement> deleteMenuSetup;

	@FindBy(xpath = "(//a[contains(@class,'add_more')])[1]")
	public WebElement addUrlMenuSetup;

	@FindBy(xpath = "(//a[contains(@class,'add_more')])[2]")
	public WebElement addCard;

	@FindBy(name = "new_cards_header")
	public WebElement cardHeader;

	@FindBy(name = "new_cards_desc")
	public WebElement cardHeaderDesc;

	@FindBy(id = "UniqueBrowse")
	public WebElement broswCard;

	@FindBy(xpath = "//button[@id='saveForm']")
	public WebElement saveButton;

	@FindBy(id = "change_msg")
	public WebElement siteSettingsUpdateSuccessfullyPopup;

	@FindBy(xpath = "//span[@id='change_msg']/..//button[@type='button']")
	public WebElement continueButton;

	// Site Setting Logo
	@FindBy(xpath = "//a[@id='uploadBtnLogo']")
	public WebElement editPrimaryElementLogo;

	@FindBy(xpath = "//div//input[@id='width']")
	public WebElement width;

	@FindBy(xpath = "//div//input[@id='height']")
	public WebElement height;

	@FindBy(xpath = "//a[@id='uploadBtnMiniLogo']")
	public WebElement editSecondaryElementLogo;

	@FindBy(xpath = "(//img[@id='secondary_logo'])[1]")
	public WebElement secondaryLogoImage;

	@FindBy(xpath = "//button[@id='hide_preview']")
	public WebElement previewButton;

	@FindBy(xpath = "(//img[@id='primary_logo'])[1]")
	public WebElement primaryLogoImages;

	@FindBy(xpath = "//a[@id='uploadBtnfaviconLogo']")
	public WebElement editFaviconLogo;

	@FindBy(xpath = "//h5[text()='Upload Image']")
	public WebElement uploadImagePopup;

	@FindBy(xpath = "//input[@id='Browse']")
	public WebElement browse;

	@FindBy(xpath = "//button[@id='uploadButtonName']")
	public WebElement uploadLogoButton;

	public SiteSettings() {
		PageFactory.initElements(driver, this);
	}

	Faker faker = new Faker();

	// Refrence
	HomePage homePage = new HomePage();
	PropertieFileUtil propertieFileUtil = new PropertieFileUtil();

	public void naviagteSiteSettings() {

		homePage.navigateToSiteSettings();
	}

	public void verifySiteSettingPage() {

	}

	public void checkDisbaleSiteName() {
		checkDisabledSiteName();
	}

	public void checkDisabledSiteName() {

		assertTrue(siteNameTextfield.isDisplayed(), "siteNameTextfieldi snot Displayed");

		boolean checkSiteNameIsEnabled = siteNameTextfield.isSelected();

		if (checkSiteNameIsEnabled == false) {

			System.out.println("Pass:checkSiteNameIs NotEnabled");

		}

		else {
			System.out.println("Faild : checkSiteNameIsEnabled is Enabled");
		}

	}

	public void validateValue(WebElement siteNameTextfield) throws Throwable {
		validateSiteNameValue(siteNameTextfield);
	}

	public void validateSiteNameValue(WebElement siteNameTextfield) throws Throwable {

		assertTrue(siteNameTextfield.isDisplayed(), "siteNameTextfield is not Displayed");

		String siteNameValue = siteNameTextfield.getAttribute("value");
		System.out.println("siteNameValue :" + siteNameValue);

		PropertieFileUtil.storeSingleTextInPropertiesFile("SiteName", siteNameValue);

		extractSiteNameValue = PropertieFileUtil.getSingleTextFromPropertiesFile("SiteName");

		String currentValueSiteName = siteNameTextfield.getAttribute("value");

		if (!extractSiteNameValue.equals(currentValueSiteName)) {
			throw new AssertionError("Validation Failed: siteNameTextfield value is '" + currentValueSiteName
					+ "', expected '" + expectedValue + "'.");
		}
		System.out.println("Validation Passed: siteNameTextfield value is correctly set to '" + expectedValue + "'.");
	}

	public void validateClearAttempt(WebElement siteNameTextfield) {

		try {

			siteNameTextfield.clear();
			String valueAfterClear = siteNameTextfield.getAttribute("value");
			if (!valueAfterClear.equals(expectedValue)) {
				throw new AssertionError("Validation Failed: siteNameTextfield value changed to '" + valueAfterClear
						+ "' after clear attempt.");
			}
			System.out.println(
					"Validation Passed: siteNameTextfield value remained '" + expectedValue + "' after clear attempt.");
		} catch (UnsupportedOperationException | ElementNotInteractableException e) {
			System.out.println(
					"Validation Passed: siteNameTextfield correctly rejected clear attempt due to read-only state.");
		}
	}

	public boolean validateSendKeysAttempt(WebElement siteNameTextfield) {
		String testInput = "TestInput";
		try {
			siteNameTextfield.sendKeys(testInput);
			// If sendKeys works, that's a failure for a disabled/read-only field
			System.out.println(
					"❌ Validation Failed: Element accepted input even though it should be disabled/read-only.");
			return false;
		} catch (ElementNotInteractableException | UnsupportedOperationException e) {
			System.out.println(
					"✅ Validation Passed: Element correctly rejected input attempt due to being disabled or read-only.");
			return true;
		}
	}

	// Edit

	public void checkSiteNameEnabled() {

		assertTrue(editOption.isDisplayed(), "editOption is not Displayed");
		editOption.click();

		assertTrue(siteNameTextfield.isDisplayed(), "siteNameTextfieldi snot Displayed");

		boolean checkSiteNameIsEnabled = siteNameTextfield.isEnabled();

		if (checkSiteNameIsEnabled == true) {

			System.out.println("Pass:checkSiteNameIs Enabled");

		}

		else {
			System.out.println("Faild : checkSiteNameIsEnabled is notEnabled");
			driver.quit();
		}

	}

	public void CheckIsEnabled(WebElement textfield) {

		assertTrue(textfield.isDisplayed(), "textfield snot Displayed");

		boolean textfieldIsEnabled = textfield.isEnabled();

		if (textfieldIsEnabled == true) {

			System.out.println("Pass:textfieldIsEnabled Enabled");

		}

		else {
			System.out.println("Faild : textfieldIsEnabled is notEnabled");
			// driver.quit();
		}

	}

	public void editSiteNameTextfield() {

		checkSiteNameEnabled();

		assertTrue(siteNameTextfield.isDisplayed(), "siteNameTextfield is not Displayed");

		assertTrue(editOption.isDisplayed(), "editOption is not Displayed");
		editOption.click();
		siteNameTextfield.clear();

		String siteNameValue = siteNameTextfield.getAttribute("value");

		System.out.println("siteNameValue :" + siteNameValue);

		assertTrue(siteNameValue == null || siteNameValue.isEmpty(),
				"siteNameTextfield should be empty but contains: " + siteNameValue);

	}

	public void addSiteName() throws Throwable {

		String enterSiteName = FakeData.siteName();

		siteNameTextfield.sendKeys(enterSiteName);

		String siteNameValue = siteNameTextfield.getAttribute("value");

		PropertieFileUtil.storeSingleTextInPropertiesFile("UpdatedSiteName", siteNameValue);

	}

	public void ClickOnSaveAndVerifyConformationMesgsse() {

		assertTrue(saveButton.isDisplayed(), "saveButton is not Displayed");
		saveButton.isEnabled();

		// saveButton.click();
		jsClick(saveButton);

		wait.until(ExpectedConditions.visibilityOf(siteSettingsUpdateSuccessfullyPopup));
		assertTrue(siteSettingsUpdateSuccessfullyPopup.isDisplayed(),
				"siteSettingsUpdateSuccessfullyPopup is Not Displayed");

		assertTrue(continueButton.isDisplayed(), "continueButton is Not Dispalyed ");
		continueButton.click();
	}

	public void verifyTheSiteName() throws Throwable {

		String enteredSiteName = PropertieFileUtil.getSingleTextFromPropertiesFile("UpdatedSiteName");

		String actualGetTitle = driver.getTitle();
		System.out.println("actualGetTile :" + actualGetTitle);

		assertEquals(enteredSiteName, actualGetTitle, "Failed entered SiteName Not amtched With actualGetTitile");

	}

	// menu Setup Url
//	public void addMenuNameAndUrl() {
//
//		String enterMenuName = FakeData.lastName1() + "_MN";
//		String enterMenuURLName = FakeData.siteURL();
//
//		assertTrue(verifyMenuUrlSetup.isDisplayed(), "verifyMenuUrlSetup is not displayed");
//
//		assertTrue(menuName.isDisplayed(), "menuUrlName is not Displayed");
//		menuName.sendKeys(enterMenuName);
//
//		assertTrue(menuUrlName.isDisplayed(), "menuUrlName is not Displayed");
//		menuName.sendKeys(enterMenuURLName);
//
//	}

	int addUrlCount = 3;

	public void addMultpleUrl(int count) {

		for (int i = 0; i < count; i++) {

			assertTrue(addUrlMenuSetup.isDisplayed(), "addUrlMenuSetup is not Dispalyed");
			addUrlMenuSetup.click();
		}

	}

	// Delete rows (menu Url Setup)
	public void delete(int count) {

		for (int i = 0; i < count; i++) {

			assertTrue(addUrlMenuSetup.isDisplayed(), "addUrlMenuSetup is not Dispalyed");
			addUrlMenuSetup.click();
		}

	}

	public void addMenuNameAndmenuRl(int count) throws InterruptedException, IOException {
		// Add rows
		for (int i = 0; i < count; i++) {
			assertTrue(addUrlMenuSetup.isDisplayed(), "Add URL button not visible");
			addUrlMenuSetup.click();
			Thread.sleep(400);
		}

		// Create lists to hold entered values
		List<WebElement> nameFields = new ArrayList<>();
		List<WebElement> urlFields = new ArrayList<>();

		// Fill and validate fields
		for (int i = 0; i < count; i++) {
			WebElement nameField = menuName.get(i);
			WebElement urlField = menuUrlName.get(i);

			assertTrue(nameField.isDisplayed() && nameField.isEnabled(), "Name field not ready");
			assertTrue(urlField.isDisplayed() && urlField.isEnabled(), "URL field not ready");

			nameField.clear();
			urlField.clear();

			assertEquals(nameField.getAttribute("value"), "", "Name field not cleared");
			assertEquals(urlField.getAttribute("value"), "", "URL field not cleared");

			// Generate random values
			String randomName = "App" + faker.company().name().replaceAll("[^a-zA-Z]", "").substring(0, 5);
			String randomUrl = "https://www." + faker.company().name().replaceAll("[^a-zA-Z]", "").toLowerCase()
					+ ".com";

			nameField.sendKeys(randomName);
			urlField.sendKeys(randomUrl);

			assertEquals(nameField.getAttribute("value"), randomName, "Incorrect name entered");
			assertEquals(urlField.getAttribute("value"), randomUrl, "Incorrect URL entered");

			System.out.println("Row " + (i + 1) + ": " + randomName + " | " + randomUrl + " → added successfully");

			// Add to lists for property file writing
			nameFields.add(nameField);
			urlFields.add(urlField);
		}

		// Store both lists in properties file with prefixes like MenuName1, MenuURL1,
		// etc.
		PropertieFileUtil.extractAndStoreTwoTextValueLists(nameFields, "MenuName", urlFields, "MenuURL");

//		ClickOnSaveAndVerifyConformationMesgsse(); // Save and Verify Conformation Messge
//		homePage.navigateTo_AlchemyModule();
	}

	// Upload "Site Settings Logo Utility
	public void uploadLogo(WebElement editoptionLogo, String imagePath) throws Throwable {
		// 1. Click the edit button
		assertTrue(editoptionLogo.isDisplayed(), "editoptionLogo button not visible");
		// editFaviconLogo.click();
		jsClick(editoptionLogo);
		System.out.println("🖱️ editoptionLogo");

		// 2. Verify upload popup appears
		wait.until(ExpectedConditions.visibilityOf(uploadImagePopup));
		assertTrue(uploadImagePopup.isDisplayed(), "Upload Image popup not displayed");
		System.out.println("✅ Upload popup is visible");

		// 3. Make input visible via JS if hidden
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", browse);

		// 4. Upload the file
		browse.sendKeys(imagePath);
		System.out.println("📂 Image uploaded from path: " + imagePath);

		assertTrue(uploadLogoButton.isDisplayed(), "uploadLogoButton is not Dispaleyd");
		uploadLogoButton.click();

//		saveButton.isDisplayed();
//		saveButton.click();

	}

	public static void genarateTwoDigitNumber(WebElement widthField) {
		// Create Faker instance
		Faker faker = new Faker();

		// Generate random 2-digit number (10 to 99)
		int twoDigitNumber = faker.number().numberBetween(10, 100);

		// Clear existing value (e.g., 4040)
		widthField.clear();

		// Send the 2-digit number
		widthField.sendKeys(String.valueOf(twoDigitNumber));

		System.out.println("✅ set to 2-digit number: " + twoDigitNumber);
	}

	// Upload "Site Settings Logo Utility
	public void verifyTheheihtAndWithOfTheSecondaryLogoAfterPreview(WebElement editoptionLogo, String imagePath)
			throws Throwable {
		verifyTheHeightAndWidthOFThePrmaryLogoAfterPreviewandUpload(editoptionLogo, imagePath);
	}

	// Upload "Site Settings Logo Utility
	public void verifyTheHeightAndWidthOFThePrmaryLogoAfterPreviewandSave(WebElement editoptionLogo, String imagePath)
			throws Throwable {
		verifyTheHeightAndWidthOFThePrmaryLogoAfterPreviewandUpload(editoptionLogo, imagePath);
	}

	// Upload "Site Settings Logo Utility
	public void verifyTheHeightAndWidthOFThePrmaryLogoAfterPreviewandUpload(WebElement editoptionLogo, String imagePath)
			throws Throwable {

		assertTrue(editoptionLogo.isDisplayed(), "editoptionLogo button not visible");
		jsClick(editoptionLogo);
		System.out.println("🖱️ editoptionLogo");

		wait.until(ExpectedConditions.visibilityOf(uploadImagePopup));
		assertTrue(uploadImagePopup.isDisplayed(), "Upload Image popup not displayed");
		System.out.println("✅ Upload popup is visible");

		// 3. Make input visible via JS if hidden
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", browse);

		// 4. Upload the file
		browse.sendKeys(imagePath);
		System.out.println("📂 Image uploaded from path: " + imagePath);

		// Enter Height and Width
		assertTrue(height.isDisplayed() && height.isEnabled(), "height is not displayed and Not enabled");
		genarateTwoDigitNumber(height);

		String heightValue = height.getAttribute("value");
		System.out.println("heightValue:" + heightValue);

		assertTrue(width.isDisplayed() && width.isEnabled(), "width is not Disalyed and Not enabled");
		genarateTwoDigitNumber(width);

		String widthValue = width.getAttribute("value");
		System.out.println("widthValue:" + widthValue);

		// Preview the Secondary Logo
		assertTrue(previewButton.isDisplayed(), "previewButton is not Displayed");
		previewButton.isEnabled();
		previewButton.click();

		// Get the size of the image
		assertTrue(primaryLogoImages.isDisplayed(), "primaryLogoImages is not Displayed");
		Dimension dimensions = primaryLogoImages.getSize();

		// Get width and height
		int width = dimensions.getWidth();
		int height = dimensions.getHeight();

		// Print the dimensions
		System.out.println("🖼️ Image Width: " + width);
		System.out.println("🖼️ Image Height: " + height);

		// click on Upload
		assertTrue(uploadLogoButton.isDisplayed(), "uploadLogoButton is not Dispaleyd");
		uploadLogoButton.click();

		// Check For Given hiven and With value match with Image size

		// 3. Convert String to int for safe comparison
		int widthFromInput = Integer.parseInt(widthValue); // convet string to int
		assertEquals(widthFromInput, width, "Width does not match!");

		int heightFromInput = Integer.parseInt(heightValue);
		assertEquals(heightFromInput, height, "Width does not match!");

	}

	// Secondary Logo
	public void verifyTheHeightAndWidthOFTheSecondaryLogoAfterPreviewandSave(WebElement editoptionLogo,
			String imagePath) throws Throwable {
		verifyTheHeightAndWidthOFTheSecondaryLogoAfterPreviewAndUpload(editoptionLogo, imagePath);
	}

	public void verifyTheHeightAndWidthOFTheSecondaryLogoAfterPreviewAndUpload(WebElement editoptionLogo,
			String imagePath) throws Throwable {

		assertTrue(editoptionLogo.isDisplayed(), "editoptionLogo button not visible");
		jsClick(editoptionLogo);
		System.out.println("🖱️ editoptionLogo");

		wait.until(ExpectedConditions.visibilityOf(uploadImagePopup));
		assertTrue(uploadImagePopup.isDisplayed(), "Upload Image popup not displayed");
		System.out.println("✅ Upload popup is visible");

		// 3. Make input visible via JS if hidden
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", browse);

		// 4. Upload the file
		browse.sendKeys(imagePath);
		System.out.println("📂 Image uploaded from path: " + imagePath);

		// Enter Height and Width
		assertTrue(height.isDisplayed() && height.isEnabled(), "height is not displayed and Not enabled");
		genarateTwoDigitNumber(height);

		String heightValue = height.getAttribute("value");
		System.out.println("heightValue:" + heightValue);

		assertTrue(width.isDisplayed() && width.isEnabled(), "width is not Disalyed and Not enabled");
		genarateTwoDigitNumber(width);

		String widthValue = width.getAttribute("value");
		System.out.println("widthValue:" + widthValue);

		// Preview the Secondary Logo
		assertTrue(previewButton.isDisplayed(), "previewButton is not Displayed");
		previewButton.isEnabled();
		previewButton.click();

		// click on Upload
		assertTrue(uploadLogoButton.isDisplayed(), "uploadLogoButton is not Dispaleyd");
		uploadLogoButton.click();

		// click on 3 Liner for secondary Logo View
		lineBarIcon.isDisplayed();
		jsClick(lineBarIcon);

		// Get the size of the image
		assertTrue(secondaryLogoImage.isDisplayed(), "primaryLogoImages is not Displayed");
		Dimension dimensions = secondaryLogoImage.getSize();

		// Get width and height
		int width = dimensions.getWidth();
		int height = dimensions.getHeight();

		// Print the dimensions
		System.out.println("🖼️ Image Width: " + width);
		System.out.println("🖼️ Image Height: " + height);

		// 3. Convert String to int for safe comparison
		int widthFromInput = Integer.parseInt(widthValue); // convet string to int
		assertEquals(widthFromInput, width, "Width does not match!");

		int heightFromInput = Integer.parseInt(heightValue);
		assertEquals(heightFromInput, height, "Width does not match!");

		// Use JS To captur perfect Image Size (Secondary Logo)
		Long naturalWidth = (Long) js.executeScript("return arguments[0].naturalWidth;", secondaryLogoImage);
		Long naturalHeight = (Long) js.executeScript("return arguments[0].naturalHeight;", secondaryLogoImage);

		System.out.println("Natural Width = " + naturalWidth);
		System.out.println("Natural Height = " + naturalHeight);

	}

}
