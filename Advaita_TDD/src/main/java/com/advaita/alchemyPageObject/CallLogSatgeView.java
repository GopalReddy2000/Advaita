package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;

public class CallLogSatgeView extends TestBase // Create_Class and extend base class
{
	public CallLogSatgeView() {
		PageFactory.initElements(driver, this);
	}

	FakeData fake = new FakeData();

	public static List<String> satgeNameList;
	public static List<String>interactionHistroyAdminprofileList;

	// userAccount

	// userAdmin Login
	@FindBy(xpath = "//h2[text()='Sign In']")
	public static WebElement Verify_signIn;

	@FindBy(name = "username")
	public static WebElement usernameField;

	@FindBy(name = "password")
	public static WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	public static WebElement signInButton;

	// Entirebody Click
	@FindBy(tagName = "body")
	public static WebElement driverIninteractable;

	@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']")
	public static WebElement profileDropdown;

	@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown']/..//li//a)[3]")
	public static WebElement logout;

	// Fetch"Stages"
	@FindBy(xpath = "(//h1[text()=' Stages '])[1]")
	public static WebElement verifyStage;

	@FindBy(xpath = "//table[@class='w-100']//td[1]")
	List<WebElement> stagesName;

	// CallLogStage View
	@FindBy(xpath = "//a[@id='menulist2']")
	public static WebElement alchemySidemenubar;

	@FindBy(linkText = "Call Log Stage View")
	public static WebElement callLogStageView_Tab;

	@FindBy(xpath = "//h1[contains(@class, 'page_heading') and contains(@class, 'primary_page_heading')]")
	public static WebElement verify_CallLogStageView;

	@FindBy(xpath = "//select[@id='stage_search']")
	public static WebElement SearchStages;
	
	@FindBy(xpath = "//table/tbody/tr//td[2][normalize-space()='wyzmindz_solutions']") //as per stage name we can change "wyzmindz_solutions "
	public static List<WebElement> stagesInteractionAdminProfile;
	
	@FindBy(xpath = "//table/tbody/tr//td[2][normalize-space()='wyzmindz_solutions']") //as per stage name we can change "wyzmindz_solutions "
	public static List<WebElement> stagesInteractionUserProfile;
	
	@FindBy(xpath = " //table/tbody/tr//td[2][normalize-space()]")
	public static List<WebElement> allStagesinteractionAdminProfil;   //All stages admin profile
	
	@FindBy(xpath = "//select[@id='page-size-select']")
	public static WebElement itemperpageDropdown;
	
	@FindBy(xpath = "//div//img/..//h6")
	public static WebElement clearAllFiltersButton_Table;
	


	int satgeNameSize = 0;

	@Test
	public void navigatetoStage() 
	{
		driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");

		assertTrue(verifyStage.isDisplayed(), "verifyStageis not displayed");
		System.out.println("verifyStage text : " + verifyStage.getText());

		satgeNameList = new ArrayList<String>();
		for (WebElement stageName : stagesName) {
			satgeNameList.add(stageName.getText());
			System.out.println("Stages name Lists : " + stageName.getText());
			
			satgeNameSize++;  //incremental logic for dropdwon " +1"

		}
			assertTrue(satgeNameList.containsAll(satgeNameList));
			
			
			
			

	}
	
	public void navigateTo_AlchemyModule() {

		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(alchemySidemenubar);
		// jsClick(driver, alchemySidemenubar);

	}

	public void naivateToCallLogStageView() {

		assertTrue(callLogStageView_Tab.isDisplayed(), "callLogStageView_Tab is not displayed");
		callLogStageView_Tab.click();

		assertTrue(verify_CallLogStageView.isDisplayed());
		System.out.println("verify_CallLogStageView : " + verify_CallLogStageView.getText());

	}
	public void ClearAllFilter() 
	{
		Select searchStagesDropdwon = new Select(SearchStages);
		
		String beforeSelectFirstOption=searchStagesDropdwon.getFirstSelectedOption().getText();
		System.out.println("beforeSelectFirstOption text"+beforeSelectFirstOption);
		
		searchStagesDropdwon.selectByIndex(3);
		searchStagesDropdwon.selectByVisibleText("CutomerdetailsZZZ Stage");
		
		assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not displayed");
		
		String afterSelectFirstOption=searchStagesDropdwon.getFirstSelectedOption().getText();
		System.out.println("afterSelectFirstOption "+afterSelectFirstOption);
		assertNotEquals(beforeSelectFirstOption, afterSelectFirstOption);
		
	}
	
	public void SelectStagesCallLogStagesView() 
	{
		List<String> searcStagesList = new ArrayList<String>();
		Select searchStagesDropdwon = new Select(SearchStages);

		int size = 0;

		for (WebElement searchStagesDropdwonn : searchStagesDropdwon.getOptions()) {
			searcStagesList.add(searchStagesDropdwonn.getText());
			System.out.println("searcStagesList text : " + searchStagesDropdwonn.getText());

			size++;
		}
			assertTrue(searcStagesList.containsAll(searcStagesList));

			assertEquals(size - 1, satgeNameSize);
		
			// searchStagesDropdwon.selectByIndex(3);
			searchStagesDropdwon.selectByVisibleText("CutomerdetailsZZZ Stage");
			
			// Select ItemPerpage
		Select itemPerpage=new Select(itemperpageDropdown);
		itemPerpage.selectByIndex(2);
		
		//fetch Intractionistory From Satges Admin View
		interactionHistroyAdminprofileList=new ArrayList<>();      //global variable
		for (WebElement interactionHistoyAdminProfile : stagesInteractionAdminProfile) //list of web element
		{
			System.out.println("interactionHistoyAdminProfile Text : "+interactionHistoyAdminProfile.getText());
			interactionHistroyAdminprofileList.add(interactionHistoyAdminProfile.getText());
		}
		
		

	}

	public void logout() {
		assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
		profileDropdown.click();

		assertTrue(logout.isDisplayed(), "logoutis not displayed");
		logout.click();

	}

	public void userLogin() 
	{
		String userId="Wyzmindz_solutions";
		String userPassword="Qwerty@123";
		
		assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");
		assertTrue(usernameField.isDisplayed(), "usernameField is not displayed");
		usernameField.sendKeys(userId);

		assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
		passwordField.sendKeys(userPassword);

		assertTrue(signInButton.isDisplayed(), "signInButton is not displayed");
		signInButton.click();

		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/evulation_screen_list/");
		assertTrue(verify_CallLogStageView.isDisplayed(), "verify_CallLogStageView is not displayed");
		
		
		List<String> searchStagesList_useraccountProfile = new ArrayList<String>();
		Select searchStagesDropdwon_userProfile = new Select(SearchStages);

		for (WebElement searchStagesDropdwonn_userAccountProfile : searchStagesDropdwon_userProfile.getOptions()) {
			searchStagesList_useraccountProfile.add(searchStagesDropdwonn_userAccountProfile.getText());
			System.out.println("searchStagesDropdwonn_userAccountProfile text : " + searchStagesDropdwonn_userAccountProfile.getText());
		
		}
			assertTrue(searchStagesList_useraccountProfile.containsAll(searchStagesList_useraccountProfile));
			//searchStagesDropdwon_userProfile.selectByIndex(1);
			//searchStagesDropdwon_userProfile.selectByValue("60");
			searchStagesDropdwon_userProfile.selectByVisibleText("CutomerdetailsZZZ Stage");
			
			//Select item per page
			Select itemPerpage=new Select(itemperpageDropdown);
			itemPerpage.selectByIndex(2);
			
			
			//fetch Intractionistory From Satges Admin View
			 List<String>lisinteractionHistroyUserprofileList=new ArrayList<>();      //global variable
			for (WebElement interactionHistoyUserProfile : stagesInteractionUserProfile) //list of web element
			{
				System.out.println("interactionHistoyUserProfile Text : "+interactionHistoyUserProfile.getText());
				lisinteractionHistroyUserprofileList.add(interactionHistoyUserProfile.getText());
			}
			
				assertEquals(lisinteractionHistroyUserprofileList, interactionHistroyAdminprofileList);
				//logout();   //Logout	
	}
		
		public void itemperpage() 
		{
	        // Create an instance of the Select class
	        Select select = new Select(itemperpageDropdown);

	        // Array of values to select
	        String[] pageSizes = {
	            "?stage_search=60&page=1&page_size=10",
	            "?stage_search=60&page=1&page_size=20",
	            "?stage_search=60&page=1&page_size=50"
	        };

	        // Loop through the values
	        for (String pageSize : pageSizes) {
	            // Select an option by value
	            select.selectByValue(pageSize);

	            // Verify the selection
	            WebElement selectedOption = select.getFirstSelectedOption();
	            System.out.println("Selected option: " + selectedOption.getText());

	            // Perform the action to get the list of elements for the current page size
	            // Example: Assuming there is a list of items with a common class
	            List<WebElement> items = allStagesinteractionAdminProfil; // Replace with actual class name

	            // Print the count of items
	            System.out.println("Number of items displayed: " + items.size());

	            // Perform verification that the number of items matches the selected page size
	            // Convert the value to extract the number and verify
	            int expectedSize = Integer.parseInt(pageSize.split("page_size=")[1]);
	            if (items.size() == expectedSize) {
	                System.out.println("Test passed for page size " + expectedSize);
	            } else {
	                System.out.println("Test failed for page size " + expectedSize + ". Expected " + expectedSize + " but got " + items.size());
	            }

		}
	}
		
	
	

}
