package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.ClickUtilities;
import com.advaita.Utilities.DropDown;
import com.advaita.Utilities.PropertieFileUtil;

public class ManualAllocationPage extends TestBase {

	@FindBy(xpath = "(//span[normalize-space()='Alchemy'])[1]")
	public WebElement alchemyButton;

	@FindBy(xpath = "//a[normalize-space()='Manual Allocation']")
	public WebElement manualAllocationButton;

	@FindBy(linkText = "+ Create")
	public WebElement createManualAllocationButton;

	@FindBy(xpath = "//h2[normalize-space()='Create Manual Allocation']")
	public WebElement createManualAllocationPopUp;

	@FindBy(xpath = "//span[normalize-space()='Trainee']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement traineeToogleButton;

	@FindBy(xpath = "//span[normalize-space()='Test']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement testToogleButton;

	@FindBy(xpath = "//span[normalize-space()='Normal Audit']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement normalAuditToogleButton;

	@FindBy(xpath = "//span[normalize-space()='Calibration']/..//span[contains(@class,'sampling_toggle_round')]")
	public WebElement calibrationToogleButton;

	@FindBy(xpath = "//label[text()='Role']/..//select[@id='to_role']")
	public WebElement roleDropDown;

	@FindBy(xpath = "//label[normalize-space()='To User*']/..//input[@type='search']")
	public WebElement toUserField;

	@FindBy(xpath = "//li[@role='treeitem']")
	public List<WebElement> toUserList;

	@FindBy(id = "manual_id")
	public WebElement saveButton;

	@FindBy(xpath = "//h3[text()='Success']/..//button[normalize-space()='Continue']")
	public WebElement continueButton;

	@FindBy(xpath = "//tr[@class='col_rowval']//input[contains(@class, 'select2-search__field') and @tabindex='-1']")
	public List<WebElement> toUserFields;

	@FindBy(xpath = "(//tr[@class='col_rowval']//input[contains(@class, 'select2-search__field') and @tabindex='-1'])[1]")
	public WebElement singleToUserField;

	@FindBy(xpath = "(//a[text()='Allocate'])[1]")
	public WebElement allocateButton;

	@FindBy(id = "total_sample_count")
	public WebElement totalSample;

	@FindBy(id = "process")
	public WebElement processDropdown;

	@FindBy(id = "sub_process")
	public WebElement subProcessDropdown;

	@FindBy(id = "s_sub_process")
	public WebElement subSubProcessDropdown;

	@FindBy(id = "stage_name_id")
	public WebElement stageDropdown;

	@FindBy(id = "id_allocation_type")
	public WebElement allocationTypeDropdown;

	@FindBy(id = "to_role")
	public WebElement toRoleDropdown;

	@FindBy(id = "to_user")
	public WebElement toUserDropdown;

	@FindBy(id = "auto_allocate_btn")
	public WebElement autoAllocate;

	@FindBy(xpath = "(//a[@class='allocate_sampling'])[1]")
	public WebElement autoAllocateSample;

	@FindBy(xpath = "//span[normalize-space()='Allocated Successfully']/..//button[normalize-space()='Continue']")
	public WebElement continueAfterAllocate;

	public ManualAllocationPage() throws IOException {
		PageFactory.initElements(driver, this);
		this.usersList = loadUsers();
	}

	public ManualAllocationPage navigateToAlchemyManualAllocation() {

		jsClick(alchemyButton);
		click(driver, alchemyButton);
		click(driver, manualAllocationButton);

		return this;
	}

	public ManualAllocationPage navigateToAlchemyManualAllocationCreate() {

		jsClick(alchemyButton);
		click(driver, alchemyButton);
		click(driver, manualAllocationButton);
		click(driver, createManualAllocationButton);

		return this;
	}

	public ManualAllocationPage allocationMethodToggleButton(String toggleOption) {
		switch (toggleOption.toLowerCase()) {
		case "trainee":
			click(driver, traineeToogleButton);
			break;
		case "test":
			click(driver, testToogleButton);
			break;
		case "normalaudit":
			click(driver, normalAuditToogleButton);
			click(driver, normalAuditToogleButton);
			break;
		case "calibration":
			click(driver, calibrationToogleButton);
			break;
		default:
			throw new IllegalArgumentException("Invalid toggle option: " + toggleOption);
		}

		return this;
	}

	public ManualAllocationPage selectProcess_subProcess_SubSubProcess_StagesDropdown(String... processOptions)
			throws Throwable {

		List<String> multipleLabelTexts = Arrays.asList("Process*", "Sub Process*", "Sub Sub Process*", "Stages*");
		List<String> multipleDropdownIds = Arrays.asList("process", "sub_process", "s_sub_process", "stage_name_id");
		List<String> multipleDefaultOptions = Arrays.asList("Select Process", "Sub Process", "Sub Sub Process",
				"Select Stage");
		List<String> multipleOptionsToSelect = Arrays.asList(processOptions);

		DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts, multipleDropdownIds, multipleDefaultOptions,
				multipleOptionsToSelect, true);
		return this;
	}

	public ManualAllocationPage selectProcess_subProcess_SubSubProcess_StagesDropdown(String selectProcess,
			String subProcess, String subSubProcess, String stagesDropdown) throws Throwable {

		selectDropdown("Process*", selectProcess);
		selectDropdown("Sub Process*", subProcess);
		selectDropdown("Sub Sub Process*", subSubProcess);
		selectDropdown("Stages*", stagesDropdown);

		return this;
	}

//	public ManualAllocationPage selectStageDropdown(String stage) throws Throwable {
//
//		DropDown.validateStarMarkAndHandleDropdowns("Stages*", "stage_name_id", "Select Stage", stage, true);
//		return this;
//	}

	public static String selectGroup = "Agent";

	public ManualAllocationPage allocationTypeDropdown(String allocationType, String userName) throws Throwable {

		PropertieFileUtil.storeSingleTextInPropertiesFile("designation", selectGroup);

		switch (allocationType.toLowerCase()) {
		case "call":

			List<String> multipleLabelTexts = Arrays.asList("Allocation Type *", "Role");
			List<String> multipleDropdownIds = Arrays.asList("id_allocation_type", "to_role");
			List<String> multipleDefaultOptions = Arrays.asList("Select", "All");
			List<String> multipleOptionsToSelect = Arrays.asList("Call Wise", selectGroup);

			DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts, multipleDropdownIds, multipleDefaultOptions,
					multipleOptionsToSelect, false);

			String totalSampleCount = totalSample.getText();
			String sampleCount = totalSampleCount.contains(": ") ? totalSampleCount.split(": ")[1] : "Not found";
			int count = Integer.parseInt(sampleCount);

			System.out.println("sampleCount : " + count);

			for (int i = 1; i <= count; i++) {

				Thread.sleep(1000);

				actions.moveToElement(singleToUserField).perform();

//				jsClick(driver, item);
				ClickUtilities.clickWithRetry(singleToUserField, 4);
				Thread.sleep(1000);
				String userNameXPath = String.format("//li[@role='treeitem'][normalize-space()='%s']", userName);
				WebElement userNameCall = driver.findElement(By.xpath(userNameXPath));
				userNameCall.click();
//				driver.findElement(By.xpath(userNameXPath)).click();
				actions.moveToElement(allocateButton).perform();
				click(driver, allocateButton);
				wait.until(ExpectedConditions.visibilityOf(continueButton));
				unWait(1);
				jsClick(continueButton);
//				continueButton.click();
				unWait(1);
//				click(driver, continueButton);
//				jsClick(driver, continueButton);

				driver.findElement(By.xpath("//h2[normalize-space()='Create Manual Allocation']")).click();

			}

//			String firstInputXPath = "//tr[@class='col_rowval']//input[contains(@class, 'select2-search__field') and @tabindex='-1']";

			break;
		case "qa":

			List<String> multipleLabelTexts1 = Arrays.asList("Allocation Type *", "From User*");
			List<String> multipleDropdownIds1 = Arrays.asList("id_allocation_type", "from_user");
			List<String> multipleDefaultOptions1 = Arrays.asList("Select", "Select");
			List<String> multipleOptionsToSelect1 = Arrays.asList("QA Wise", "GopalReddy");

			DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts1, multipleDropdownIds1,
					multipleDefaultOptions1, multipleOptionsToSelect1, false);

			DropDown.isMandatory("To User*");
			click(driver, toUserField);

			for (WebElement item : toUserList) {
				click(driver, item);

			}

			driver.findElement(By.xpath("//p[contains(text(),'Total Samples')]")).click();

			break;
		case "cliqa":
			DropDown.validateStarMarkAndHandleDropdown("Allocation Type *", "id_allocation_type", "Select",
					"CliQA Wise");
			break;
		case "tl":
			DropDown.validateStarMarkAndHandleDropdown("Allocation Type *", "id_allocation_type", "Select", "TL Wise");
			break;
		case "role":
			DropDown.validateStarMarkAndHandleDropdown("Allocation Type *", "id_allocation_type", "Select",
					"Role Wise");
			break;
		default:
			throw new IllegalArgumentException("Invalid toggle option: " + allocationType);
		}

		return this;

	}

	public ManualAllocationPage saveAndConfirmation() throws Throwable {

		click(driver, saveButton);

		wait.until(ExpectedConditions.visibilityOf(continueButton));
		assertTrue(continueButton.isDisplayed(), "continueButton is not displayed.");
		click(driver, continueButton);

		return this;
	}

	public ManualAllocationPage manualAllocationData(String process, String subProcess, String subSubProcess,
			String stage, String allocationType, String role, String toUser) {
		// Navigate to Manual Allocation Page
		navigateWithinAlchemy(manualAllocationButton);
		assertTrue(isElementDisplayed(createManualAllocationButton),
				"Create Manual Allocation button is not displayed.");

		// Click on the Create Manual Allocation button
		jsClick(createManualAllocationButton);
		unWait(1);
		assertTrue(isElementDisplayed(processDropdown),
				"Process dropdown is not displayed after clicking Create Manual Allocation.");

		// Select values in the dropdowns
		selectByVisibleText(processDropdown, process);
		assertEquals(getSelectedOption(processDropdown), process, "Process dropdown selection failed.");

		selectByVisibleText(subProcessDropdown, subProcess);
		assertEquals(getSelectedOption(subProcessDropdown), subProcess, "SubProcess dropdown selection failed.");

		selectByVisibleText(subSubProcessDropdown, subSubProcess);
		assertEquals(getSelectedOption(subSubProcessDropdown), subSubProcess,
				"SubSubProcess dropdown selection failed.");

		selectByVisibleText(stageDropdown, stage);
		assertEquals(getSelectedOption(stageDropdown), stage, "Stage dropdown selection failed.");

		selectByVisibleText(allocationTypeDropdown, allocationType);
		assertEquals(getSelectedOption(allocationTypeDropdown), allocationType,
				"Allocation Type dropdown selection failed.");

		selectByVisibleText(toRoleDropdown, role);
		assertEquals(getSelectedOption(toRoleDropdown), role, "Role dropdown selection failed.");

		selectByVisibleText(toUserDropdown, toUser);
		assertEquals(getSelectedOption(toUserDropdown), toUser, "To User dropdown selection failed.");

		// Click on the Auto Allocate button
		jsClick(autoAllocate);

		unWait(1);
		continueButton.click();

		// Return the current page object
		return this;
	}

	// Helper method to get the selected option from a dropdown
	private String getSelectedOption(WebElement dropdown) {
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText().trim();
	}

	// Helper method to verify if an element is displayed
	private boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

//	#####################################################################################

	private final static String userPropPath = "src/test/resources/DynamicUsers.properties";
	private final List<Map<String, String>> usersList;

	private List<Map<String, String>> loadUsers() throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(userPropPath));

		Map<String, Map<String, String>> allUsers = new LinkedHashMap<>();
		for (String key : props.stringPropertyNames()) {
			String[] parts = key.split("\\.");
			if (parts.length == 2) {
				allUsers.computeIfAbsent(parts[0], k -> new HashMap<>()).put(parts[1], props.getProperty(key));
			}
		}
		return new ArrayList<>(allUsers.values());
	}

	public static List<Map<String, String>> loadUsersFromProperties() throws IOException {
		List<Map<String, String>> users = new ArrayList<>();
		Properties props = new Properties();

		try (FileInputStream fis = new FileInputStream(userPropPath)) {
			props.load(fis);
		}

		int userIndex = 1;
		while (true) {
			String prefix = "user" + userIndex + ".username";
			if (!props.containsKey(prefix))
				break;

			Map<String, String> user = new HashMap<>();
			user.put("username", props.getProperty("user" + userIndex + ".username"));
			user.put("password", props.getProperty("user" + userIndex + ".password"));
			user.put("group", props.getProperty("user" + userIndex + ".group"));
			user.put("permissions", props.getProperty("user" + userIndex + ".permissions"));

			users.add(user);
			userIndex++;
		}
		return users;
	}

//	public void allocateSamplesToUsers(String mode, List<String> selectedNames, int numberOfUsers, int samplesPerUser)
//			throws Throwable {
//
//		
//		// Filter users based on the mode
//		List<Map<String, String>> selectedUsers = new ArrayList<>();
//		switch (mode.toLowerCase()) {
//		case "one":
//			selectedUsers = usersList.stream().filter(u -> u.get("username").equalsIgnoreCase(selectedNames.get(0)))
//					.collect(Collectors.toList());
//			break;
//		case "multiple":
//			selectedUsers = usersList.stream().filter(u -> selectedNames.contains(u.get("username")))
//					.collect(Collectors.toList());
//			break;
//		case "random":
//			Collections.shuffle(usersList);
//			selectedUsers = usersList.subList(0, Math.min(numberOfUsers, usersList.size()));
//			break;
//		case "all":
//			selectedUsers = new ArrayList<>(usersList);
//			break;
//		default:
//			throw new IllegalArgumentException("Invalid mode: " + mode);
//		}
//
//		if (selectedUsers.isEmpty())
//			throw new RuntimeException("No users selected for allocation.");
//
//		Set<String> groups = selectedUsers.stream().map(u -> u.get("group")).filter(Objects::nonNull)
//				.collect(Collectors.toSet());
//
//		if (groups.size() > 1)
//			throw new RuntimeException("Selected users belong to different groups: " + groups);
//
//		String selectGroup = groups.iterator().next();
//		if (selectGroup == null || selectGroup.isEmpty())
//			throw new RuntimeException("Group not found for selected user(s).");
//
//		DropDown.validateStarMarkAndHandleDropdowns(List.of("Allocation Type *", "Role"),
//				List.of("id_allocation_type", "to_role"), List.of("Select", "All"), List.of("Call Wise", selectGroup),
//				false);
//
//		List<WebElement> sampleRows = driver.findElements(By.cssSelector("tr.col_rowval"));
//
//
//		if (samplesPerUser == -1) {
//			// Dynamic allocation of all samples in round-robin
//			System.out.println("Allocating all " + sampleRows.size() + " samples in round-robin to "
//					+ selectedUsers.size() + " user(s).");
//
//			for (int i = 0; i < sampleRows.size(); i++) {
//				Map<String, String> user = selectedUsers.get(i % selectedUsers.size());
//				String username = user.get("username");
//				WebElement row = sampleRows.get(i);
//
//				unWait(2);
//				clickOutSideTheDropDown(totalSample);
//
//				WebElement selectField = wait.until(ExpectedConditions.elementToBeClickable(
//						By.xpath("(//table[contains(@class,'stage_sampling_table')]/tbody/tr[@class='col_rowval']/td[2]/div[@class='form_group'])[1]")));
//
//				System.out.println("selectField : " + selectField);
//				unWait(2);
//				selectField.click();
//
////				scrollDropdownToUser(username);
//
//				String userOptionXPath = String.format(
//						"//span[contains(@class, 'select2-dropdown')]//ul[@class='select2-results__options']/li[text()='%s']",
//						username);
//				WebElement userOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));
//				userOption.click();
//
//				clickOutSideTheDropDown(totalSample);
//
//				unWait(2);
//				storeFirstRowDataToProperties(driver, username);
//
//				allocateAndConfirmation();
//				unWaitInMilli(500);
//
//			}
//
//		} else {
//			// Traditional fixed samples per user allocation
//			int totalSamplesNeeded = selectedUsers.size() * samplesPerUser;
//			
//			try {
//			if (totalSamplesNeeded > sampleRows.size()) {
//				throw new RuntimeException(
//						"Not enough samples. Required: " + totalSamplesNeeded + ", Found: " + sampleRows.size());
//			}
//			}catch(Exception e) {
//				System.out.println("Exception : "+e);
//			}
//			int rowIndex = 0;
//
//			for (Map<String, String> user : selectedUsers) {
//				String username = user.get("username");
//				System.out.println("Allocating to user: " + username);
//
//				for (int i = 0; i < samplesPerUser; i++) {
//					WebElement row = sampleRows.get(rowIndex++);
//					unWait(1);
//
//					WebElement selectField = wait.until(ExpectedConditions.elementToBeClickable(
//							By.xpath("(//table[contains(@class,'stage_sampling_table')]/tbody/tr[@class='col_rowval']/td[2]/div[@class='form_group'])[1]")));
//					selectField.click();
//
////					scrollDropdownToUser(username);
//
//					String userOptionXPath = String.format(
//							"//span[contains(@class, 'select2-dropdown')]//ul[@class='select2-results__options']/li[text()='%s']",
//							username);
//					WebElement userOption = wait
//							.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));
//					userOption.click();
//
//					clickOutSideTheDropDown(totalSample);
//
//					unWaitInMilli(1000);
//					storeFirstRowDataToProperties(driver, username);
//
//					allocateAndConfirmation();
//					unWaitInMilli(500);
//				}
//			}
//		}
//
//		
//	}

	public void allocateSamplesDynamically(WebDriver driver, int totalSamplesToAllocate, String chosenUsername)
			throws Throwable {
		// Clear previously stored data
		clearPropertiesFile(PROPERTIES_FILE_PATH);

		// Load users from properties file
		List<Map<String, String>> allUsers = loadUsersFromProperties();
		List<Map<String, String>> selectedUsers = new ArrayList<>();

		if ("random".equalsIgnoreCase(chosenUsername)) {
			selectedUsers = allUsers; // Use all users in round-robin
		} else {
			// Filter the specific user
			for (Map<String, String> user : allUsers) {
				if (user.get("username").equalsIgnoreCase(chosenUsername)) {
					selectedUsers.add(user);
					break;
				}
			}

			if (selectedUsers.isEmpty()) {
				throw new RuntimeException("Specified username not found in properties: " + chosenUsername);
			}
		}

		Map<String, Integer> userSampleCount = new HashMap<>();
		int allocatedCount = 0;
		int userIndex = 0;

		while (allocatedCount < totalSamplesToAllocate) {
			List<WebElement> rows = driver.findElements(By.cssSelector("tr.col_rowval"));
			if (rows.isEmpty()) {
				throw new RuntimeException("No sample rows found to allocate.");
			}

			Map<String, String> user = selectedUsers.get(userIndex % selectedUsers.size());
			String username = user.get("username");

			WebElement row = rows.get(0); // Always pick the first visible row
			unWait(2);

			WebElement selectField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"(//table[contains(@class,'stage_sampling_table')]/tbody/tr[@class='col_rowval']/td[2]/div[@class='form_group'])[1]")));
			selectField.click();

			String userOptionXPath = String.format(
					"//span[contains(@class, 'select2-dropdown')]//ul[@class='select2-results__options']/li[text()='%s']",
					username);
			WebElement userOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));
			userOption.click();

			selectField.click();
//			clickOutSideTheDropDown(driver,totalSample);
			unWaitInMilli(1000);

			int sampleIndex = userSampleCount.getOrDefault(username, 0) + 1;
			userSampleCount.put(username, sampleIndex);

			storeRowDataToProperties(driver, username, sampleIndex, user.get("group"), user.get("permissions"));

			allocateAndConfirmation();
			unWaitInMilli(1000);

			userIndex++;
			allocatedCount++;
		}
	}

	public void scrollDropdownToUser(String username) {
		try {
			WebElement verticalScrollBar = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@class='zl-scrollBar zl-verticalBar']")));

			// Scroll by small Y offset — tune as needed
			actions.clickAndHold(verticalScrollBar).moveByOffset(0, 30).release().perform();

			unWaitInMilli(1000);
		} catch (Exception e) {
			System.out.println("Scroll bar not found or scroll failed for user: " + username);
		}
	}



	public ManualAllocationPage allocateAndConfirmation() throws Throwable {

		unWait(1);
		click(driver, autoAllocateSample);

		wait.until(ExpectedConditions.visibilityOf(continueAfterAllocate));
		assertTrue(continueAfterAllocate.isDisplayed(), "continueAfterAllocate is not displayed.");
		click(driver, continueAfterAllocate);
		unWaitInMilli(300);

		return this;
	}

	public ManualAllocationPage manualAllocation(String toggleOption, String selectProcess, String subProcess,
			String subSubProcess, String stagesDropdown) throws Throwable {

		navigateToAlchemyManualAllocationCreate();
		allocationMethodToggleButton(toggleOption);
		selectProcess_subProcess_SubSubProcess_StagesDropdown(selectProcess, subProcess, subSubProcess, stagesDropdown);

		selectAllocationTypeAndDetails("Call Wise", "All", null);
		// Allocate all records
//		allocateUsersToRecords(7);

		return this;
	}

	public void selectDropdown(String label, String value) {
		try {
			WebElement dropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='" + label + "']/../select")));
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println("Dropdown selection failed for: " + label + "-->>" + e);
//			System.out.println("Dropdown selection failed for: " + label);
		}
	}

	public static final String PROPERTIES_FILE_PATH = "src/test/resources/allocated_samplesRedcord.properties";

	/**
	 * Stores data from the first table row in a properties file using the provided
	 * username. Clears the file before writing.
	 * 
	 * @param driver   The Selenium WebDriver instance
	 * @param username The username to use for the property key
	 * @throws IOException If there's an error handling the file
	 */

	public static void clearPropertiesFile(String filePath) throws IOException {
		Properties props = new Properties();
		try (FileOutputStream out = new FileOutputStream(filePath)) {
			props.store(out, "Cleared existing data before test run");
		}
	}

//	public static void clearPropertiesFile() throws IOException {
//	    Properties emptyProps = new Properties();
//	    try (FileOutputStream out = new FileOutputStream(PROPERTIES_FILE_PATH)) {
//	        emptyProps.store(out, "Cleared previous data");
//	    }
//	}

	public static void storeRowDataToProperties(WebDriver driver, String username, int sampleIndex, String group,
			String permissions) throws IOException {
		List<WebElement> cells = driver.findElements(By.xpath("(//tr[@class='col_rowval'])[1]/td"));
		if (cells.size() < 22) {
			throw new IllegalArgumentException("Table row does not contain enough columns");
		}

		String sampleData = String.join(",", cells.get(2).getText(), // id
				cells.get(3).getText(), // employeeName
				cells.get(4).getText(), // middleName
				cells.get(5).getText(), // linkedInProfile
				cells.get(6).getText(), // spouseName
				cells.get(7).getText(), // supervisor
				cells.get(8).getText(), // transUniqueId
				cells.get(9).getText(), // samplingType
				cells.get(10).getText(), // caseId
				cells.get(11).getText(), // samplingTo
				cells.get(12).getText(), // isActive
				cells.get(13).getText(), // sampleGroupId
				cells.get(14).getText(), // createdOn
				cells.get(15).getText(), // createdBy
				cells.get(16).getText(), // isAllocated
				cells.get(17).getText(), // isSkipped
				cells.get(18).getText(), // auditStatus
				cells.get(19).getText(), // auditedBy
				cells.get(20).getText(), // auditedOn
				cells.get(21).getText() // ticketId
		);

		Properties props = new Properties();
		File file = new File(PROPERTIES_FILE_PATH);
		if (file.exists()) {
			try (FileInputStream in = new FileInputStream(file)) {
				props.load(in);
			}
		}

		props.setProperty(username + ".sample" + sampleIndex, sampleData);
		props.setProperty(username + ".group", group);
		props.setProperty(username + ".permissions", permissions);

		try (FileOutputStream out = new FileOutputStream(file)) {
			props.store(out, "Updated allocated samples with group and permissions");
		}
	}

//	#############################################$^%ETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTY################
//	#############################################$^%ETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTY################
//	#############################################$^%ETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTY################
//	#############################################$^%ETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTY################
//	#############################################$^%ETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTY################
//	#############################################$^%ETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTY################

	public void selectAllocationTypeAndDetails(String allocationType, String roleOrFromUser, String toUser)
			throws Throwable {
		selectDropdown("Allocation Type *", allocationType);

		switch (allocationType) {
		case "Call Wise":
			Thread.sleep(1000);
			selectDropdown("Role", roleOrFromUser);
			break;
		case "QA Wise":
		case "CliQA Wise":
		case "TL Wise":
			selectDropdown("From User *", roleOrFromUser);
			selectDropdown("To User *", toUser);
			break;
		case "Role Wise":
			selectDropdown("Role", roleOrFromUser);
			selectDropdown("To User *", toUser);
			break;
		}
	}


	public void allocateAllRecords() {
		Properties usersProp = new Properties();
		Properties allocatedRecordsProp = new Properties();
		try {
			usersProp.load(new FileInputStream("src/test/resources/DynamicUsers.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<WebElement> toUserFields = driver.findElements(By.xpath(
				"//table[contains(@class,'stage_sampling_table')]/tbody/tr[@class='col_rowval']/td[2]/div[@class='form_group']"));
		List<WebElement> allocateButtons = driver.findElements(By.xpath("//td//a[@class='allocate_sampling']"));

		List<String> allocatedRecordIds = new ArrayList<>();

		for (int i = 0; i < toUserFields.size(); i++) {
			String username = getRandomUsername(usersProp);
			WebElement toUserField = toUserFields.get(i);
			toUserField.sendKeys(username);

			WebElement row = toUserField.findElement(By.xpath("./ancestor::tr"));
			String recordId = row.findElement(By.xpath("./td[3]")).getText();
			allocatedRecordIds.add(recordId);

			storeRecordDetails(row, username, allocatedRecordsProp);
			allocateButtons.get(i).click();
		}

		verifyRecordsRemoved(allocatedRecordIds);
		saveAllocatedRecordsToFile(allocatedRecordsProp);
	}

	private String getRandomUsername(Properties usersProp) {
		List<String> usernames = new ArrayList<>();
		for (Object key : usersProp.keySet()) {
			if (key.toString().endsWith(".username")) {
				usernames.add(usersProp.getProperty(key.toString()));
			}
		}
		return usernames.get(new Random().nextInt(usernames.size()));
	}

	private void storeRecordDetails(WebElement row, String username, Properties allocatedRecordsProp) {
		List<WebElement> cells = row.findElements(By.xpath("./td"));
		String[] columns = new String[] { "Allocate", "To_User", "_id", "Demoalb_EmployeeName", "Demo_MiddleName",
				"Demovza_LinkedInProfile", "SpouseName", "Demoqoj_Supervisor", "Trans_Unique_Id", "SamplingType",
				"CaseId", "SamplingTo", "IsActive", "SampleGroupId", "CreatedOn", "CreatedBy", "IsAllocated",
				"IsSkipped", "AuditStatus", "AuditedBy", "AuditedOn", "TicketId" };

		String recordId = cells.get(2).getText();
		for (int i = 0; i < cells.size(); i++) {
			allocatedRecordsProp.setProperty(recordId + "." + columns[i], cells.get(i).getText());
		}
		allocatedRecordsProp.setProperty(recordId + ".AllocatedTo", username);
	}

	private void verifyRecordsRemoved(List<String> recordIds) {
		for (String recordId : recordIds) {
			boolean isPresent = driver
					.findElements(
							By.xpath("//table[contains(@class,'stage_sampling_table')]//td[text()='" + recordId + "']"))
					.isEmpty();
			if (!isPresent) {
				System.out.println("Record " + recordId + " was not removed from the table after allocation.");
			}
		}
	}

	private void saveAllocatedRecordsToFile(Properties allocatedRecordsProp) {
		try (FileOutputStream fos = new FileOutputStream("src/test/resources/allocated_samples.properties")) {
			allocatedRecordsProp.store(fos, "Allocated Records");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}