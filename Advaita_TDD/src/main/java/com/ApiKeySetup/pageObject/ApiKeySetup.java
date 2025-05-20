package com.ApiKeySetup.pageObject;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;

public class ApiKeySetup extends TestBase {

//<<<<<<<<<< Elements

	@FindBy(xpath = "//a//span[text()='API Key Setup']")
	public WebElement apiKeysetUpModule;

	@FindBy(linkText = "+ Create")
	public WebElement CreateOption;

	@FindBy(id = "api_name")
	public WebElement apiNametextfield;

	@FindBy(id = "process")
	public WebElement ProcessDropdown;

	@FindBy(id = "sub_process")
	public WebElement subProcessDropdown;

	@FindBy(id = "s_sub_process")
	public WebElement subSubProcessDropdown;

	@FindBy(id = "stage_name_id")
	public WebElement stageDropdown;

	@FindBy(xpath = "(//select[@name='keyfor'])[1]")
	public WebElement keyForDropdown;

	@FindBy(id = "auth_type_id")
	public WebElement authTpeDropdown;

	@FindBy(xpath = "//input[@name='auth_field_val_1']")
	public WebElement keyTextfield;

	@FindBy(xpath = "//input[@name='auth_field_val_2']")
	public WebElement valueTextfield;

	@FindBy(xpath = "//select[@name='auth_field_val_3']")
	public WebElement addToDropdown;

	@FindBy(id = "method_type")
	public WebElement methodTypeDropdown;

	@FindBy(id = "vendor_name")
	public WebElement vendorNametextfield;

	// <<<<< Additional Header List
	@FindBy(xpath = "//input[@name='header_name_1']")
	public WebElement hedaderName_AdditionalHeaderList;

	@FindBy(xpath = "//input[@name='header_val_1']")
	public WebElement valueName_AdditionalHeaderList;

	@FindBy(xpath = "//a[text()='+ Add Row']")
	List<WebElement> addRowOptions;

	// <<<<<<Custom Parameter List
	@FindBy(name = "field_name_1")
	public WebElement fieldNameTextfield;

	@FindBy(name = "field_val_1")
	public WebElement fieldValueTextfield;

	// Stage Parameter List
	@FindBy(name = "api_variable_name_1")
	public WebElement variableNameTextfield;

	@FindBy(name = "default_val_1")
	public WebElement dafaultValueTextfield;

	public void naviagteToAPiKeySetup() {

		assertTrue(apiKeysetUpModule.isDisplayed(), "apiKeysetUpModule is nOt dispalyed");
		apiKeysetUpModule.click();

	}

	public void naviagteToCreate() {

		String CurrentUrl = driver.getCurrentUrl();
		System.out.println("Captured URL: " + CurrentUrl);

		assertTrue(CreateOption.isDisplayed(), "CreateOption is nOt dispalyed");
		CreateOption.click();

		String expectedUrl = driver.getCurrentUrl();

		assertNotEquals(CurrentUrl, expectedUrl, "Faile : Curent url and expected Url are matched");

	}

	public ApiKeySetup() {
		PageFactory.initElements(driver, this);
	}

}
