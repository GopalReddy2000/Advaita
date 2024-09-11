package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;

public class SkipReason extends TestBase 
{
	public SkipReason() 
	{
		PageFactory.initElements(driver, this);
	}
	
	FakeData fake=new FakeData();
	public static String FirstCreatedUserName;
	
	public static WebElement driverIninteractable;
	
	public static String beforeSearchCreatedSkipReasons;

	//process , subprocess , Subsubprocess
	
		@FindBy(xpath = "(//input[@data-type='process']/..//span)[1]")
		public static WebElement fetchProcess;
		
		@FindBy(xpath = "//input[@data-type='sub_process']/..//span")
		public static WebElement FethSubProcess;
		
		@FindBy(xpath = "(//div[@class='content']//span)[1]")
		public static WebElement SubSubProcess;
		
		//Skip reason_ Create
		@FindBy(xpath = "//a/..//span[text()='Alchemy']")     //a[@id='menulist2']
		public static WebElement alchemySidemenubar;
		
		@FindBy(linkText = "Skip Reason")
		public static WebElement skipReason_Tab;
		
		@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1")
		public static WebElement Verify_skipReason;
		
		@FindBy(linkText = "+ Create")
		public static WebElement createButton_SkipReasonPage;
		
		@FindBy(xpath = "//h2[text()='Create Skip Reason']")
		public static WebElement verify_CreateSkipReason;
		

		@FindBy(xpath = "//select[@id='process']")
		public static WebElement ProcessDropdown;
		
		@FindBy(xpath = "//select[@id='sub_process']")
		public static WebElement SubProcessDropdown;
		
		@FindBy(xpath = "//select[@id='s_sub_process']")
		public static WebElement SubsubProcessDropdown;
		
		@FindBy(id =  "reason_name_id")
		public static WebElement reasonName_textfield;
		
		@FindBy(id= "id_description")
		public static WebElement description_textfield;
		
		@FindBy(xpath = "//h2/../..//button[@id='manual_id']")
		public static WebElement createButton_createSkipReasonPopup;
		
		@FindBy(xpath = "//h2/../..//button[text()='Cancel']")
		public static WebElement cancelButton_CreateSkipReasonPopup;
		
		@FindBy(xpath = "//span[text()='Skip Reason has been created successfully']")
		public static WebElement successfullyCreated_popup;
		
		@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
		public static WebElement continueButton_create;
		
		@FindBy(xpath = "//tbody/tr[last()]//td")
		public static WebElement lastCreated_skipReason;
		
		@FindBy(xpath = "//tbody/tr")
		public static WebElement beforeCreatedSkipReasons_search;
		
		@FindBy(xpath = "//tbody/tr")
		public static WebElement afterCreatedSkipReasons_search;
	
		
		//table 
		
		@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='delete-icon ']")
		public static WebElement lastDleteButton_SkipReasonTable;
		
		@FindBy(name = "text_search")
		public static WebElement seachElementTextfield;
		
		@FindBy(xpath = "//select[@id='process_search']")
		public static WebElement processDropdown_Table;
		
		@FindBy(xpath = "//select[@id='sub_process_search']")
		public static WebElement SubprocessDropdown_Table;
		
		@FindBy(id = "s_sub_process_search")
		public static WebElement subSubProcessDropdown_Table;
		
		@FindBy(xpath = "//div[@class='row respo-filter-sub']//button")
		public static WebElement searchButton_table;
		
		@FindBy(xpath = "//div[@class='row respo-filter-sub']//button/..//h6")
		public static WebElement clearAllFilters_table;
		
		@FindBy(xpath = "//tbody//tr//td//img[@alt='delete-icon ']")
		public static List<WebElement>DeleteButton;
		
		@FindBy(xpath = "(//tbody//tr//td//img[@alt='delete-icon '])[last()]")
		public static WebElement deleteButtonLast;
		
		@FindBy(xpath = "//h6[text()='Delete ?']")
		public static WebElement deletePopup;
		
		@FindBy(xpath = "//button[text()='Delete']")
		public static WebElement deleteButton_delete;
		
		@FindBy(xpath = "(//button[text()='Cancel'])[2]")
		public static WebElement cancelButton_Delete;
		
		@FindBy(xpath = "//h3/..//span[text()='Deleted Successfully']")
		public static WebElement deleted_SuceessfullyPopup;
		
		@FindBy(xpath = "(//h3/..//span/..//button[text()='Continue'])[1]")
		public static WebElement continueButton_DeleteSuccessullyPopup;
	
		//edit
		@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='table-edit']" )
		public static WebElement lastEdit_skipReason;
		
		@FindBy(xpath =  "//h2[text()='Create Skip Reason']")
		public static WebElement verify_EditSkipReason;
		
		@FindBy(xpath = "//select[@id='process_search']")
		public static WebElement processDropdown_Edit;
		
		@FindBy(xpath = "//select[@id='sub_process_search']")
		public static WebElement subprocessDropdown_Edit;
		
		@FindBy(xpath = "//select[@id='sub_process_search']")
		public static WebElement SubprocessDropdown_Edit;
		
		@FindBy(id =  "reason_name_id")
		public static WebElement reasonName_textfield_Edit;
		
		@FindBy(id= "id_description")
		public static WebElement description_textfield_edit;
		
		@FindBy(xpath = "//button[text()=' Update ']")
		public static WebElement UpdateButton;
		
		@FindBy(xpath = "(//button[text()='Cancel'])[1]")
		public static WebElement cancelButton_edit;
		
		@FindBy(xpath = "//h3/..//span[text()='Skip Reason has been updated successfully']")
		public static WebElement Update_SkipReasonSuccessfullyPopup;
		
		@FindBy(xpath = "//h3/..//span[text()='Skip Reason has been updated successfully']/..//button")
		public static WebElement continueButon_SkipReasonSucessfullyUpdate;
		
		
		
		
		
		
		
		
	public void NavigateToFetchprocess() 
	{
		driver.navigate().to("https://test.capture.autosherpas.com/en/data_management/process/");
		fetchProcess.getText();
		System.out.println("Fetchprocessname :" + fetchProcess.getText());
		
		fetchProcess.click();
		FethSubProcess.getText();
		System.out.println("FetchSubProcess name : "+FethSubProcess.getText());
		
		FethSubProcess.click();
		SubSubProcess.getText();
		System.out.println("Fetch SubSubProcessName : " +SubSubProcess.getText());
		
		
	}
	
	public void navigateTo_AlchemyModule() throws Throwable 
	{
		
		//wait.until(ExpectedConditions.visibilityOf(alchemySidemenubar));
		//Thread.sleep(2000);
		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		jsClick(driver, alchemySidemenubar);
		
	}
		public void NavigateTo_Skipreason() 
		{
			driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/skip_reason_listing/");
			assertTrue(skipReason_Tab.isDisplayed(), "skipReason_Tabis not displayed");
			
			
			assertTrue(Verify_skipReason.isDisplayed(), "Verify_skipReason is not displayed");
			Verify_skipReason.click();
			
		}
	
		public void Crete_SkipReason() 
		{
			assertTrue(createButton_SkipReasonPage.isDisplayed(), "createButton_SkipReasonPage");
			createButton_SkipReasonPage.click();
			
			wait.until(ExpectedConditions.visibilityOf(verify_CreateSkipReason));
			assertTrue(verify_CreateSkipReason.isDisplayed(), "verify_CreateSkipReason");
			verify_CreateSkipReason.getText();
			System.out.println("verify_CreateSkipReason : "+verify_CreateSkipReason.getText());
			
			
		}
		
		public void selectProcessDropdown() 
		{
			List<String>processDropdownList=new ArrayList<String>();

			Select ProcessDropdown1=new Select(ProcessDropdown);
			for (WebElement Options : ProcessDropdown1.getOptions()) 
			{
				wait.until(ExpectedConditions.visibilityOfAllElements(Options));
				System.out.println(Options.getText());
				processDropdownList.add(Options.getText());
			}
			assertTrue(	processDropdownList.contains("AJP")); 
			ProcessDropdown1.selectByVisibleText("AJP");
		}
		
		public void SelectSubProcessDropdown() throws Throwable 
		{
			List<String>subProcessDropdownList=new ArrayList<String>();
			
			Thread.sleep(2000);
			
			Select subProcessDropdown2=new Select(SubProcessDropdown);
			for (WebElement options2 : subProcessDropdown2.getOptions()) 
			{
				Thread.sleep(1000);
				System.out.println(subProcessDropdown2.getOptions());
				subProcessDropdownList.add(options2.getText());
			}
		
			assertTrue(subProcessDropdownList.contains("Sub AJP"));
			subProcessDropdown2.selectByVisibleText("Sub AJP");
			
		}
		
		public void selectSubSubProcess() throws Throwable 
		{
			List<String>subsubprocessDropdownList=new ArrayList<String>();
			Thread.sleep(2000);
			Select SubsubProcessDropdown3= new Select(SubsubProcessDropdown);
			for (WebElement options3 : SubsubProcessDropdown3.getOptions())
			{
				Thread.sleep(2000);
				System.out.println(SubsubProcessDropdown3.getOptions());
				subsubprocessDropdownList.add(options3.getText());
			}
			assertTrue(subsubprocessDropdownList.contains("Sub Sub AJP"));
			SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
			//actions.moveToElement(driverIninteractable).perform();
			
			
		}
		
		
		public void continue_CreateSkinReason() 
		{
			
		//reason textfield	
			// Array of predefined Skipreasons for reasons textfield names
	        String[] skipReasonNames = {
	            "I have an urgent appointment to attend",
	            "My internet connection is unstable",
	            "I'm feeling unwell and need to rest",
	            "I have a prior commitment that I can't miss",
	            "I'm currently traveling and don't have access to my documents",
	            "My computer crashed and I lost my progress",
	            "I need more time to gather the required information",
	            "There's a family emergency I need to take care of",
	            "I'm experiencing technical difficulties with my device",
	            "LI have a conflicting deadline that takes priority"
	        };
	       
	        // Create a Random object
	        Random random = new Random();

	        // Generate a random index to select a template name
	        int randomIndex = random.nextInt(skipReasonNames.length);

	        // Print the selected random template name
	        String randomTemplateName = skipReasonNames[randomIndex];
	        System.out.println("Random SMS Template Name: " + randomTemplateName);
	        
			assertTrue(reasonName_textfield.isDisplayed(), " reasonName_textfield is not dispalyed "); 
			reasonName_textfield.sendKeys(randomTemplateName);
			
	//Random description
			 String[] skipReasonDescription = {
			            "Due to an unexpected appointment, I am unable to complete the form at this moment and must reschedule.",
			            "My unreliable internet connection is preventing me from submitting the form, causing significant delays and interruptions in connectivity.",
			            "My current illness necessitates immediate rest and recovery, making it impossible for me to complete the form right now.",
			            "An existing engagement that I must attend leaves me unable to fill out the form at this particular time.",
			            "Traveling without essential documents hinders my ability to provide the necessary information required to complete the form accurately.",
			            "A computer crash resulted in the loss of all form data entered so far, necessitating a restart of the process.",
			            "Gathering the required information for the form is taking longer than anticipated, and I need additional time to complete it.",
			            "An urgent family emergency demands my immediate attention, making it impossible for me to focus on completing the form.",
			            "Technical issues with my device are preventing me from accessing or completing the form, causing significant delays in submission.",
			            "Another critical deadline conflicts with the form submission, requiring my immediate attention and postponing the form completion."
			        };
			// Create a Random object
		        Random random1 = new Random();

		        // Generate a random index to select a template name
		        int randomIndex1 = random.nextInt(skipReasonNames.length);

		        // Print the selected random template name
		        String randomTemplateName1 = skipReasonDescription[randomIndex1];
		        System.out.println("Random SMS Template Name: " + randomTemplateName);
		        
				assertTrue(description_textfield.isDisplayed(), " description_textfield is not dispalyed "); 
				description_textfield.sendKeys(randomTemplateName1);
			 
				assertTrue(createButton_createSkipReasonPopup.isDisplayed(), "createButton_createSkipReasonPopup");
				createButton_createSkipReasonPopup.click();
				
				wait.until(ExpectedConditions.visibilityOf(successfullyCreated_popup));
				assertTrue(successfullyCreated_popup.isDisplayed(), "successfullyCreated_popup");
				System.out.println("successfullyCreated_popup : "+ successfullyCreated_popup.getText());
				
				assertTrue(continueButton_create.isDisplayed(), "continueButton_create is not displayed");
				continueButton_create.click();
				
				wait.until(ExpectedConditions.visibilityOf(lastCreated_skipReason));
				assertTrue(lastCreated_skipReason.isDisplayed(), "lastCreated_skipReason is not displayed");
				lastCreated_skipReason.getText();
				System.out.println("lastCreated Skip Reasons: "+ lastCreated_skipReason.getText());
				jsClick(driver, lastCreated_skipReason);
				
				
		}
		
		//Verify user is able to search by processes
		public void SearchByProcess() throws Throwable 
		{
		//process_table	
			
			assertTrue(Verify_skipReason.isDisplayed(), "Verify_skipReason is not displayed");
			
			beforeSearchCreatedSkipReasons=beforeCreatedSkipReasons_search.getText();
			System.out.println(beforeCreatedSkipReasons_search.getText());   //optional change to "beforeSearchCreatedSkipReasons " 
				
			List<String>processDropdownList_table=new ArrayList<String>();

			Select ProcessDropdown1_table=new Select(processDropdown_Table);
			for (WebElement Options : ProcessDropdown1_table.getOptions()) 
			{
				wait.until(ExpectedConditions.visibilityOfAllElements(Options));
				System.out.println(Options.getText());
				processDropdownList_table.add(Options.getText());
			}
			assertTrue(	processDropdownList_table.contains("AJP")); 
			ProcessDropdown1_table.selectByVisibleText("AJP");
			
			
			
		//subProcess_table	
			List<String>subProcessDropdownList_table=new ArrayList<String>();
			
			Thread.sleep(2000);
			Select subProcessDropdown2_table=new Select(SubprocessDropdown_Table);
			for (WebElement options2 : subProcessDropdown2_table.getOptions()) 
			{
				//Thread.sleep(1000);
				System.out.println(subProcessDropdown2_table.getOptions());
				subProcessDropdownList_table.add(options2.getText());
			}
		
	
			assertTrue(subProcessDropdownList_table.contains("Sub AJP"));
			subProcessDropdown2_table.selectByVisibleText("Sub AJP");
//			
			
			
		//Subsubprocess_table
			List<String>subsubprocessDropdownList_table=new ArrayList<String>();
			Thread.sleep(5000);
			Select SubsubProcessDropdown3_table= new Select(subSubProcessDropdown_Table);
			for (WebElement options3 : SubsubProcessDropdown3_table.getOptions())
			{
				//Thread.sleep(2000);
				System.out.println(SubsubProcessDropdown3_table.getOptions());
				subsubprocessDropdownList_table.add(options3.getText());
			}
			assertTrue(subsubprocessDropdownList_table.contains("Sub Sub AJP"));
			SubsubProcessDropdown3_table.selectByVisibleText("Sub Sub AJP");
			//actions.moveToElement(driverIninteractable).perform();
			
			assertTrue(searchButton_table.isDisplayed(), "searchButton_table is not displayed");
			searchButton_table.click();
			
//			beforeSearchCreatedSkipReasons=beforeCreatedSkipReasons_search.getText();
//			System.out.println(beforeSearchCreatedSkipReasons);
			
			assertEquals(beforeSearchCreatedSkipReasons,afterCreatedSkipReasons_search.getText() );
			System.out.println(afterCreatedSkipReasons_search.getText());  //optional
			
			assertTrue(clearAllFilters_table.isDisplayed(), "clearAllFilters_table is not displayed");
			clearAllFilters_table.click();
			
		}
		
		//Verifythe user is able to Clearall filters
		public void ClearFilters() throws Throwable 
		{
			
			List<String>processDropdownList_table=new ArrayList<String>();

			Select ProcessDropdown1_table=new Select(processDropdown_Table);
			for (WebElement Options : ProcessDropdown1_table.getOptions()) 
			{
				wait.until(ExpectedConditions.visibilityOfAllElements(Options));
				System.out.println(Options.getText());
				processDropdownList_table.add(Options.getText());
			}
			assertTrue(	processDropdownList_table.contains("AJP")); 
			ProcessDropdown1_table.selectByVisibleText("AJP");
			
			
			List<String>subProcessDropdownList_table=new ArrayList<String>();
			
			Thread.sleep(2000);
			Select subProcessDropdown2_table=new Select(SubprocessDropdown_Table);
			for (WebElement options2 : subProcessDropdown2_table.getOptions()) 
			{
				//Thread.sleep(1000);
				System.out.println(subProcessDropdown2_table.getOptions());
				subProcessDropdownList_table.add(options2.getText());
			}
			
			assertTrue(subProcessDropdownList_table.contains("Sub AJP"));
			subProcessDropdown2_table.selectByVisibleText("Sub AJP");
	
			
			
			List<String>subsubprocessDropdownList_table=new ArrayList<String>();
			Thread.sleep(5000);
			Select SubsubProcessDropdown3_table= new Select(subSubProcessDropdown_Table);
			for (WebElement options3 : SubsubProcessDropdown3_table.getOptions())
			{
				//Thread.sleep(2000);
				System.out.println(SubsubProcessDropdown3_table.getOptions());
				subsubprocessDropdownList_table.add(options3.getText());
			}
			assertTrue(subsubprocessDropdownList_table.contains("Sub Sub AJP"));
			SubsubProcessDropdown3_table.selectByVisibleText("Sub Sub AJP");
			
			
			assertTrue(clearAllFilters_table.isDisplayed(), "clearAllFilters_table is not displayed");
			clearAllFilters_table.click();
			
			assertTrue(ProcessDropdown1_table.getFirstSelectedOption().isDisplayed(), "getfirst process option is not displayed");
			assertTrue(subProcessDropdown2_table.getFirstSelectedOption().isDisplayed(), "getfrst subprocess options is not displayed");
			assertTrue(SubsubProcessDropdown3_table.getFirstSelectedOption().isDisplayed(), "get first subsubproces options not displayed");
		}
		
		public void EditSKipReasons() throws Throwable 
		{
			js.executeScript("arguments[0].scrollIntoView(true);", lastEdit_skipReason);  // Use for scroll to element
			
			assertTrue(lastEdit_skipReason.isDisplayed(), "lastEdit_skipReason is not displayed");
			//lastEdit_skipReason.click();
			jsClick(driver, lastEdit_skipReason);
			
			wait.until(ExpectedConditions.visibilityOf(verify_EditSkipReason));
			assertTrue(verify_EditSkipReason.isDisplayed(), "verify_EditSkipReason is not displayed");
			
			
			List<String>processDropdownList_Edit=new ArrayList<String>();

			Select ProcessDropdown1_Edit=new Select(processDropdown_Edit);
			for (WebElement Options : ProcessDropdown1_Edit.getOptions()) 
			{
				wait.until(ExpectedConditions.visibilityOfAllElements(Options));
				System.out.println(Options.getText());
				processDropdownList_Edit.add(Options.getText());
			}
				//assertTrue(	processDropdownList_Edit.contains("AJP")); 
				// assertTrue(ProcessDropdown1_Edit.getOptions().get(1).getText().contains("AJP"));  //1st way
				String ActualProcess=ProcessDropdown1_Edit.getOptions().get(1).getText();            //2nd way
				assertEquals("AJP", ActualProcess);
			
				
				List<String>subProcessDropdownList_Edit=new ArrayList<String>();
				
				Thread.sleep(2000);
				Select subProcessDropdown2_Edit=new Select(SubprocessDropdown_Table);
				for (WebElement options2 : subProcessDropdown2_Edit.getOptions()) 
				{
					//Thread.sleep(1000);
					System.out.println(subProcessDropdown2_Edit.getOptions());
					subProcessDropdownList_Edit.add(options2.getText());
				}
				
				//assertTrue(subProcessDropdownList_Edit.contains("Sub AJP"));
				//assertTrue(subProcessDropdown2_Edit.getOptions().get(1).getText().contains("Sub AJP")); //1st way
				String actual_SubProcess=subProcessDropdown2_Edit.getOptions().get(1).getText();           //2nd way
				assertEquals("Sub AJP", actual_SubProcess);
				
				
				List<String>subsubprocessDropdownList_Edit=new ArrayList<String>();
				Thread.sleep(2000);
				Select SubsubProcessDropdown3_Edit= new Select(subSubProcessDropdown_Table);
				for (WebElement options3 : SubsubProcessDropdown3_Edit.getOptions())
				{
					//Thread.sleep(2000);
					System.out.println(SubsubProcessDropdown3_Edit.getOptions());
					subsubprocessDropdownList_Edit.add(options3.getText());
				}
				//assertTrue(subsubprocessDropdownList_Edit.contains("Sub Sub AJP"));
				//assertTrue(SubsubProcessDropdown3_Edit.getOptions().get(1).getText().contains("Sub Sub AJP")); //1st way
				String actual_SububProcess=SubsubProcessDropdown3_Edit.getOptions().get(1).getText();           //2nd way
				System.out.println(actual_SububProcess);
				assertEquals("Sub Sub AJP", actual_SububProcess);
				
				assertTrue(reasonName_textfield_Edit.isDisplayed(), "reasonName_textfield_Edit is not displayed");
				System.out.println("reasonName_textfield_Edit.getText() text : "+reasonName_textfield_Edit.getText());
				reasonName_textfield_Edit.clear();
				reasonName_textfield_Edit.sendKeys(fake.lastName1());
				
				assertTrue(description_textfield_edit.isDisplayed(), "description_textfield_edit is not displayed");
				System.out.println("description_textfield_edit text: "+description_textfield_edit.getText());
				description_textfield_edit.clear();
				description_textfield_edit.sendKeys(fake.lastName1());
				
				assertTrue(UpdateButton.isDisplayed(), "UpdateButton is not displayed");
				UpdateButton.click();
				
				wait.until(ExpectedConditions.visibilityOf(Update_SkipReasonSuccessfullyPopup));
				assertTrue(Update_SkipReasonSuccessfullyPopup.isDisplayed(), "Update_SkipReasonSuccessfullyPopup");
				assertTrue(continueButon_SkipReasonSucessfullyUpdate.isDisplayed(), "continueButon_SkipReasonSucessfullyUpdate is not displayed");
				continueButon_SkipReasonSucessfullyUpdate.click();
				assertTrue(Verify_skipReason.isDisplayed(),"Verify_skipReason is not displayed" );
				
						Thread.sleep(2000);
		}	
		
		public void CanceCreate_Edit() throws Throwable 
		{
			
			//Verify the user is able to cancel edit page , Create page	
		//Cancel Edit page	
				assertTrue(lastEdit_skipReason.isDisplayed(), "lastEdit_skipReason is not displayed");
				//lastEdit_skipReason.click();
				jsClick(driver, lastEdit_skipReason);
				
				wait.until(ExpectedConditions.visibilityOf(verify_EditSkipReason));
				assertTrue(verify_EditSkipReason.isDisplayed(), "verify_EditSkipReason is not displayed");
				
				assertTrue(cancelButton_edit.isDisplayed(), "cancelButton_edit is not displayed");
				cancelButton_edit.click();
				assertTrue(Verify_skipReason.isDisplayed(), "Verify_skipReason");
				
		//Cancel Edit page		
				assertTrue(createButton_SkipReasonPage.isDisplayed(), "createButton_SkipReasonPage is not displayed");
				createButton_SkipReasonPage.click();
				
				wait.until(ExpectedConditions.visibilityOf(verify_CreateSkipReason));
				assertTrue(verify_CreateSkipReason.isDisplayed(), "verify_CreateSkipReasonis not displayed");
				assertTrue(cancelButton_CreateSkipReasonPopup.isDisplayed(), "cmancelButton_create is not displayed");
				cancelButton_CreateSkipReasonPopup.click();
				
		//cancel deletepage
				
				assertTrue(lastDleteButton_SkipReasonTable.isDisplayed(), "lastDleteButton_SkipReasonTable is not displayed");
				//lastDleteButton_SkipReasonTable.click();
				jsClick(driver, lastDleteButton_SkipReasonTable);
				
				
				wait.until(ExpectedConditions.visibilityOf(deletePopup));
				assertTrue(deletePopup.isDisplayed(), "deletePopup is not displayed");
				assertTrue(cancelButton_Delete.isDisplayed(), "cancelButton_Delete");
				cancelButton_Delete.click();
				
				        Thread.sleep(2000);
		}
		
		public void Delete_SkipReasons() 
		{
			assertTrue(lastDleteButton_SkipReasonTable.isDisplayed(), "lastDleteButton_SkipReasonTable is not displayed");
			//lastDleteButton_SkipReasonTable.click();
			jsClick(driver, lastDleteButton_SkipReasonTable);
			
			assertTrue(deletePopup.isDisplayed(), "deletePopup is not displayed");
			assertTrue(deleteButton_delete.isDisplayed(), "deleteButton_delete i snot displayed");
			deleteButton_delete.click();
			
			wait.until(ExpectedConditions.visibilityOf(deleted_SuceessfullyPopup));
			assertTrue(deleted_SuceessfullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is not displayed");
			assertTrue(continueButton_DeleteSuccessullyPopup.isDisplayed(), "deleted_SuceessfullyPopup is not displayed");
			continueButton_DeleteSuccessullyPopup.click();
			
			
		}
}
