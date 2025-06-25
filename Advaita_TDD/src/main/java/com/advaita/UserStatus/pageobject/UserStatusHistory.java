package com.advaita.UserStatus.pageobject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;

public class UserStatusHistory extends TestBase {

	public UserStatusHistory() {

		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	@FindBy(xpath = "(//a[@id='menulist3'])[2]")
	public WebElement userStausExpansionPanel;

	@FindBy(xpath = "//a[text()='User Status History']")
	public WebElement userStatusHistory;

	@FindBy(xpath = "(//h1[text()=' User Status History '])[1]")
	public WebElement VerifyUserStatusHistory;

	@FindBy(xpath = "//select[@id='role']")
	public WebElement designationDropdown;

	@FindBy(id = "from_date")
	public WebElement fromDatePicker;

	@FindBy(id = "to_date")
	public WebElement toDatePicker;

	@FindBy(id = "current_status")
	public WebElement currentStatus;

	@FindBy(xpath = "//div[contains(@class,'clear-filter')]")
	public WebElement clearAllFilter;

	@FindBy(id = "showdata")
	public WebElement generateButton;

	@FindBy(id = "Download_data")
	public WebElement downloadButton;

	// Refrences Clsasses

	UserStatus userStatus = new UserStatus();

	// Methods
	public void navigateToUserStatusHistory() {
		navigateToUserStatusHistoryandVerify();
	}

	// Methods
	public void navigateToUserStatusHistoryandVerify() {

		// userStatus.NavigateToUserStatus();

		assertTrue(userStausExpansionPanel.isDisplayed(), "userStausExpansionPanel is not Displayed");
//		userStausExpansionPanel.click();
		jsClick(userStausExpansionPanel);

		assertTrue(userStatusHistory.isDisplayed(), "userStatusHistory is not Dispalyed");
//		userStatusHistory.click();
		jsClick(userStatusHistory);

		assertTrue(VerifyUserStatusHistory.isDisplayed(), "VerifyUserStatusHistory is Not Dispalyed");
	}

}
