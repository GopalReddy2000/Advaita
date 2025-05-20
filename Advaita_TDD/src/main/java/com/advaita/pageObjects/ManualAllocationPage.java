package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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

	public ManualAllocationPage() throws IOException {
		PageFactory.initElements(driver, this);
		this.usersList = loadUsers();
	}

	public ManualAllocationPage navigateToAlchemyManualAllocation() {

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

	private final String userPropPath = "src/test/resources/DynamicUsers.properties";
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

//	    🔹 1. Allocate to 1 specific user
//	    List<String> user = List.of("rob.funk2");
//	    allocator.allocateSamplesToUsers("one", user, 0, 3);
//	    ✔ Allocates 3 samples to rob.funk2.
//
//	    🔹 2. Allocate to multiple specific users
//	    List<String> users = List.of("rob.funk2", "chi.gulgowski1");
//	    allocator.allocateSamplesToUsers("multiple", users, 0, 2);
//	    ✔ Allocates 2 samples to each of the users.
//
//	    🔹 3. Allocate to N random users
//	    allocator.allocateSamplesToUsers("random", null, 2, 3);
//	    ✔ Randomly selects 2 users and allocates 3 samples to each.
//
//	    🔹 4. Allocate to all users in properties
//	    allocator.allocateSamplesToUsers("all", null, 0, 1);
//	    ✔ Allocates 1 sample to every user in the properties file.
//
//	    🔸 Invalid Example (will throw validation error)
//	    allocator.allocateSamplesToUsers("one", null, 0, 1); // ❌ Missing selected username

	public void allocateSamplesToUsers(String mode, List<String> selectedNames, int numberOfUsers, int samplesPerUser)
			throws Throwable {

		// Filter users based on the mode
		List<Map<String, String>> selectedUsers = new ArrayList<>();
		switch (mode.toLowerCase()) {
		case "one":
			selectedUsers = usersList.stream().filter(u -> u.get("username").equalsIgnoreCase(selectedNames.get(0)))
					.collect(Collectors.toList());
			break;
		case "multiple":
			selectedUsers = usersList.stream().filter(u -> selectedNames.contains(u.get("username")))
					.collect(Collectors.toList());
			break;
		case "random":
			Collections.shuffle(usersList);
			selectedUsers = usersList.subList(0, Math.min(numberOfUsers, usersList.size()));
			break;
		case "all":
			selectedUsers = new ArrayList<>(usersList);
			break;
		default:
			throw new IllegalArgumentException("Invalid mode: " + mode);
		}

		if (selectedUsers.isEmpty()) {
			throw new RuntimeException("No users selected for allocation.");
		}

		// Extract distinct groups from selected users
		Set<String> groups = selectedUsers.stream().map(u -> u.get("group")).filter(Objects::nonNull)
				.collect(Collectors.toSet());

		if (groups.size() > 1) {
			throw new RuntimeException("Selected users belong to different groups: " + groups);
		}

		// Only one group is allowed
		String selectGroup = groups.iterator().next();
		if (selectGroup == null || selectGroup.isEmpty()) {
			throw new RuntimeException("Group not found for selected user(s).");
		}

		// Select group-based dropdowns
		List<String> multipleLabelTexts = Arrays.asList("Allocation Type *", "Role");
		List<String> multipleDropdownIds = Arrays.asList("id_allocation_type", "to_role");
		List<String> multipleDefaultOptions = Arrays.asList("Select", "All");
		List<String> multipleOptionsToSelect = Arrays.asList("Call Wise", selectGroup);

		DropDown.validateStarMarkAndHandleDropdowns(multipleLabelTexts, multipleDropdownIds, multipleDefaultOptions,
				multipleOptionsToSelect, false);

		List<WebElement> sampleRows = driver.findElements(By.cssSelector("tr.col_rowval"));
		int totalSamplesNeeded = selectedUsers.size() * samplesPerUser;

		if (totalSamplesNeeded > sampleRows.size()) {
			throw new RuntimeException("Not enough sample rows available for allocation. Required: "
					+ totalSamplesNeeded + ", Available: " + sampleRows.size());
		}

		Properties outputProps = new Properties();
		int rowIndex = 0;

		for (Map<String, String> user : selectedUsers) {
			String username = user.get("username");
			System.out.println("Allocating to user: " + username);

			for (int i = 0; i < samplesPerUser; i++) {
				WebElement row = sampleRows.get(rowIndex++);

				unWait(1);

			
				WebElement selectField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
						By.xpath("//table[contains(@class,'stage_sampling_table')]/tbody/tr[@class='col_rowval']["
								+ (rowIndex) + "]/td[2]/div[@class='form_group']"))));

				// Locate the vertical scrollbar
		        WebElement verticalScrollBar = driver.findElement(By.xpath("//div[@class='zl-scrollBar zl-verticalBar']"));

		   
//	            CommonUtils.scrollToElementByActions(selectField);
//	            unWaitInMilli(30);
//	            CommonUtils.scrollToElementByActions(selectField);
				selectField.click();
				
				Thread.sleep(1000);
				 // Perform drag and drop to scroll
		        actions.clickAndHold(verticalScrollBar)
		               .moveByOffset(0, 20) // Adjust Y offset for scroll distance
		               .release()
		               .perform();
		        Thread.sleep(1000);

				String userOptionXPath = String.format(
						"//span[contains(@class, 'select2-dropdown')]//ul[@class='select2-results__options']/li[text()='%s']",
						username);
				WebElement userOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));
				userOption.click();

//	            driver.findElement(By.xpath("//p[contains(text(),'Total Samples')]"));
//	            jsClick(driver.findElement(By.xpath("//p[contains(text(),'Total Samples')]")));
				Thread.sleep(1000);
				// Simulate pressing the Escape key
		        actions.sendKeys(Keys.ESCAPE).perform();
		        Thread.sleep(500);

				List<WebElement> columns = row.findElements(By.tagName("td"));
				StringBuilder rowData = new StringBuilder();
				for (int j = 2; j < columns.size(); j++) {
					rowData.append(columns.get(j).getText()).append(",");
				}

				String rowValue = rowData.toString().replaceAll(",$", "");
				outputProps.setProperty(username + ".sample" + (i + 1), rowValue);
			}
		}

		try (FileOutputStream fos = new FileOutputStream("src/test/resources/allocated_samples.properties")) {
			outputProps.store(fos, "Sample allocation for users");
		}
	}
	
	
	



}