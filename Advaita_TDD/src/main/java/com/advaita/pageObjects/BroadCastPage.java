package com.advaita.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;

public class BroadCastPage extends TestBase{

	@FindBy(linkText = "Broadcast Template")
	public WebElement BroadcastTemplate;

	@FindBy(linkText = "+ Create")
	public WebElement Create;

	@FindBy(xpath = "//input[@name='broadcast_template']")
	public WebElement inputTemplateName;

	@FindBy(xpath = "//textarea[@name='broadcast_msg']")
	public WebElement inputMessage;

	@FindBy(xpath = "//select[@name='filter_group_name']")
	public WebElement roleSelect;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	public WebElement createButton;

	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	public WebElement cancelButton;

	@FindBy(xpath = "//marquee[not(@id)]")
	public WebElement broadcastField;

	@FindBy(id = "text_search")
	public WebElement searchInputField;

	@FindBy(xpath = "//img[@alt='filter_search']/parent::button")
	public WebElement searchButton;

	@FindBy(xpath = "//h6[text()='Clear All Filters']")
	public WebElement clearAllFilter;

	@FindBy(linkText = "Change Speed")
	public WebElement changeSpeed;

	@FindBy(xpath = "//select[@id='speed']")
	public WebElement speedDropdown;

	@FindBy(xpath = "//marquee[@id='previewMarquee']")
	public WebElement speedPreview;

	@FindBy(id = "update_button")
	public WebElement update;

	@FindBy(id = "menulist2")
	public WebElement alchemy;

	@FindBy(xpath = "//button[text()='Update']/following-sibling::button")
	public WebElement speedCancel;

	@FindBy(xpath = "//tbody//tr//td[1]")
	public List<WebElement>tableRows;

	@FindBy(css = "img.delete_bias")
	public WebElement deleteButton;

	@FindBy(css = "img.edit_manual")
	public WebElement editButton;

	@FindBy(xpath = "//td//span")
	public WebElement status;

	@FindBy(xpath = "(//button[text()='Continue'])[1]")
	public WebElement continueButton;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement confirmDeleteButton;





	public BroadCastPage(){	
		PageFactory.initElements(driver, this);
	}

	public BroadCastPage navigation()
	{
		try {
			if (!BroadcastTemplate.isDisplayed()) {
				alchemy.click();
			}
			jsClick(BroadcastTemplate);
		} catch (NoSuchElementException e) {
			// Handle the case where the element is not found
			System.out.println("Element not found: " + e.getMessage());
			// Optionally, attempt to click the BroadcastTemplate again if needed
			alchemy.click();
			jsClick(BroadcastTemplate);
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.out.println("An unexpected error occurred: " + e.getMessage());
			// Optionally, handle the exception or log it
		}

		return this;
	}

	public BroadCastPage create(String templateName,String message,String roleToSelect) {

		Create.click();
		inputTemplateName.sendKeys(templateName);
		inputMessage.sendKeys(message);
		Select role=new Select(roleSelect);
		role.selectByVisibleText(roleToSelect);
		createButton.click();
		unWait(1);
		continueButton.click();

		String newBroadCast=broadcastField.getText();
		System.out.println(newBroadCast);
		assertTrue(newBroadCast.contains(message));


		return this;
	}

	@FindBy(css = "table.w-100 tbody")
	WebElement formsTableBody;
	public BroadCastPage deleteRecord(String nameToDelete)
	{


		//		List<WebElement> rows = formsTableBody.findElements(By.tagName("tr"));
		//
		//		for (WebElement row:rows)
		//		{
		//			if(row.getText().equals(nameToDelete))
		//			{
		//				click(driver,row.findElement(By.cssSelector("img.delete-dataset")));
		//				confirmDeleteButton.click();
		//				unWait(2);
		//				continueButton.click();
		//				System.out.println(nameToDelete+" Role Record Successfully Deleted");
		//				break;
		//			}
		//
		//		}

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		for (WebElement row : rows) {

			WebElement usernameColumn = row.findElement(By.xpath("./td[1]"));

			if (usernameColumn.getText().contains(nameToDelete) ) {

				WebElement deleteButton = row.findElement(By.xpath(".//td//div//img[@alt='delete-icon ']"));
				deleteButton.click();
				confirmDeleteButton.click();
				unWait(2);
				continueButton.click();
				System.out.println(nameToDelete+" User Account Successfully Deleted");
				break;
			}
		}


		return this;
	}

	public BroadCastPage roleOptions()
	{
		Create.click();
		Select role=new Select(roleSelect);
		for(WebElement roles:role.getOptions())
		{
			System.out.println(roles.getText());
		}

		return this;
	}

	public BroadCastPage search(String templateName)
	{
		searchInputField.sendKeys(templateName);
		searchButton.click();
		try {
			if(tableRows.get(0).getText().contains(templateName))
			{
				assertTrue(true);
			}
		}
		catch (NoSuchElementException e) {

			System.out.println(templateName+" Not Found");
			assertTrue(false);
		}

		return this;
	}

	public void getTemplateNames()
	{
		for(WebElement names:tableRows)
		{
			System.out.println(names.getText());
		}
	}

	public void selectByVisibleText(WebElement dropdownElement, String optionText) {
		// Create a Select object for the dropdown
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByVisibleText(optionText);
	}


	public BroadCastPage changeSpeed(String visibleText)
	{
		changeSpeed.click();
		selectByVisibleText(speedDropdown,visibleText);
		update.click();
		unWait(1);
		continueButton.click();
		String speed=broadcastField.getAttribute("scrollamount");
		switch (visibleText) {
		case "Super Slow":
			System.out.println(speed);
			assertEquals(speed,"2");
			break;

		case "Slow":
			System.out.println(speed);
			assertEquals(speed,"4");
			break;
			
		case "Normal":
			System.out.println(speed);
			assertEquals(speed,"6");
			break;
			
		case "Fast":
			System.out.println(speed);
			assertEquals(speed,"8");
			break;

		case "Super Fast":
			System.out.println(speed);
			assertEquals(speed,"10");
			break;

		default:

			break;
		}

		return this;
	}


}
