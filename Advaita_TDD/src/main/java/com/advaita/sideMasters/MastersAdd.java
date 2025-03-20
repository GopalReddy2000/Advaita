package com.advaita.sideMasters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advaita.BaseClass.TestBase;
import com.advaita.Utilities.CommonUtils;

public class MastersAdd extends TestBase {

	@FindBy(xpath = "//span[contains(@class,'text')][normalize-space()='Masters']")
	public WebElement mastersSideBar;

	public MastersAdd() {

		PageFactory.initElements(driver, this);
	}

	public MastersAdd navigateToMastersAdd(String masterMenu) {

		CommonUtils.scrollToElementByActions(mastersSideBar);
		click(driver, mastersSideBar);
		String addMasters = String.format("//a[@data-action='add'][normalize-space()='Add %s']", masterMenu);
		WebElement addMasterOption = driver.findElement(By.xpath(addMasters));
		click(driver, addMasterOption);

		return this;
	}

}
