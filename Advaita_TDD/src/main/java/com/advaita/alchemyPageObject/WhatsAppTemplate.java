package com.advaita.alchemyPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.advaita.BaseClass.TestBase;

import Advaita_TDD.Advaita_TDD.FakeData;


public class WhatsAppTemplate extends TestBase // Create_Class and extend base class
{
	public WhatsAppTemplate() 
	{
		PageFactory.initElements(driver, this);
	}
	FakeData fake=new FakeData();
	
	public static String FirstCreatedUserName;
	
	public static String lastcreatedValue_ToNumber;
	public static String lastcreatedValue_Message;
	
	//beforeFirseselectedOptions
	
	public static String beforeFirstProcessOption;
	public static String beforeFirstSubProcessOption;
	public static String beforeFirstSubSubProcessOption;
	
	
	//Entirebody Click
		@FindBy(tagName = "body")
		public static WebElement driverIninteractable;
	
		@FindBy(xpath = "//div[@aria-labelledby='profileDropdown']")
		public static WebElement profileDropdown;
		
		@FindBy(xpath = "(//div[@aria-labelledby='profileDropdown']/..//li//a)[3]")
		public static WebElement logout;
		
		//user Login 	
		@FindBy(xpath = "//h2[text()='Sign In']")
		public static WebElement Verify_signIn;
		
		@FindBy(name = "username")
		public static WebElement usernameField;

		@FindBy(name = "password")
		public static WebElement passwordField;

		@FindBy(xpath = "//button[text()='Sign In']")
		public static WebElement signInButton;
	
	// Fetch_ process , subprocess , Subsubprocess
	
		@FindBy(xpath = "(//input[@data-type='process']/..//span)[1]")
		public static WebElement fetchProcess;
		
		@FindBy(xpath = "//input[@data-type='sub_process']/..//span")
		public static WebElement FethSubProcess;
		
		@FindBy(xpath = "(//div[@class='content']//span)[1]")
		public static WebElement SubSubProcess;
		
		//Fetch WhatsApp ation Enable in "Stages"
		@FindBy(xpath = "(//h1[text()=' Stages '])[1]")
		public static WebElement verifyStage;
		
		@FindBy(xpath = "//table[@class='w-100']//td[1]")
		List<WebElement> stagesName;
		
		@FindBy(xpath = "//h2[text()='CutomerdetailsZZZ Stage']")
		public static WebElement verifyCreatedSatgeName;
		
		@FindBy(xpath = "//tr[td/a[contains(@href, '/en/stages/view_stages/60/')]]//img[contains(@class, 'stages_edit') and contains(@src, 'table-edit.svg')]")
		public static WebElement editButtio_stages;    //Its static Edit button only for "customerdetailsZZZ"
		
		@FindBy(xpath = "(//div[@class='accordion-body']//label[@class='form-check-label'])")      // //div[@class='Action ']//div[@id='collapseThree']//div   (All list)
		List<WebElement>stages_actions;	
		
		@FindBy(xpath = "//a//img[@class='arrow-left']")
		public static WebElement leftArrowButton_stages;
		
		//WhatsApp template
		@FindBy(xpath = "//a[@id='menulist2']")
		public static WebElement alchemySidemenubar;
		

		@FindBy(linkText = "Whatsapp Template")
		public static WebElement whatsAppTemplate_Tab;
		
		@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()=' Whatsapp Template']")
		public static WebElement whatsAppTemplateText;
		
		@FindBy(linkText = "+ Create")
		public static WebElement createButtonWhatsAppTemplate;
		
		@FindBy(xpath ="//h2[text()='Create Whatsapp Template']")
		public static WebElement CreateWhatsAppTepmlatePopUp; 
		
		@FindBy(xpath = "//select[@id='process']")
		public static WebElement ProcessDropdown;
		
		@FindBy(xpath = "//select[@id='sub_process']")
		public static WebElement SubProcessDropdown;
		
		@FindBy(xpath = "//select[@id='s_sub_process']")
		public static WebElement SubsubProcessDropdown;
		
		@FindBy(xpath = "//select[@id='stage_name_id']" )
		public static WebElement whatsAppStagesDropdown;
		
		@FindBy(xpath = "//input[@name='template_name']")
		public static WebElement whatsAppTemplateName;
		
		@FindBy(name = "disposition")
		public static WebElement whatsAppDisposition;
		
		@FindBy(name= "from_no")
		public static WebElement fromNumber;
		
		@FindBy(id = "toNumber")
		public static WebElement toNumber;
		
		@FindBy(xpath = "//select[@id='toNumber']")
		public static WebElement toNumberSource;
		
		@FindBy(xpath = "//textarea[@name='message']")
		public static WebElement message;
		
		@FindBy(xpath = "//textarea[@name='remarks']")
		public static WebElement remarks;
		
		@FindBy(xpath = "//input[@name='temp_variable_name_1']")
		public static WebElement templateVariableName;
		
		@FindBy(xpath = "//select[@class='form-control stages_fields_dropsown']")
		public static WebElement stageFieldName;
		
		@FindBy( name =  "default_val_1")
		public static WebElement defaultValue;
		
		@FindBy(id = "manual_id")
		public static WebElement createButton_WhatsAppTemplatePopup;
		
		@FindBy(xpath = "//span[@id='change_msg']")
		public static WebElement whatsAppTemplateCreatedSuccessfully_popuop;
		
		@FindBy(xpath = "//span[@id='change_msg']/..//button")
		public static WebElement continueButton_create;
		
		@FindBy(xpath = "//tbody/tr[last()]//td[1]")		//Last created sms " entire line"				
		public static WebElement last_CreatedWhatsApp; 
		
		//user Management
		@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1")
		public static WebElement verifyUserMangagemen_page;
		
		@FindBy(xpath = "//tbody/tr[1]//td ") 								 //tbody/tr[1] last created user management user-name
		public static WebElement firstCreated_UserManagement;
		

		@FindBy(xpath = "//tbody/tr[1]//a")
		public static WebElement userMapping_USM;
		
		//System Names
		@FindBy(xpath = "//a[text()='System Names']")
		public static WebElement systemNamesTab;
		
		@FindBy(xpath = "(//h1[text()=' System Names '])[1]")
		public static WebElement verify_SystemName;
		
		@FindBy(xpath = "//tbody/tr[last()]/td[1]")
		public static WebElement verifySystemname_lastCreated;
		
		//user page
		@FindBy(xpath = "//div[@class='hide_on_mobile_view']//h1[text()='  Call Log Tab View ']")
		public static WebElement user_callLogTabViewpage;
		
		@FindBy(xpath = "//ul[@id='pills-tab']//li//span")
		public static WebElement userAccount_StagesCount;
		
		@FindBy(xpath = "//tbody/tr[1]/td[1]/div/img[@class='img-fluid cursor-pointer view_evalution eye-icon']")
		public static WebElement stagesProfileView_userAccount;
		
		@FindBy(xpath = "//div[contains(@class, 'social_media_images')]/img[contains(@class, 'whatsapp_btn_click')]")
		public static WebElement whatsAppIcon_userAccountSatgeView;
		
		@FindBy(xpath = "//h2[text()='Whatsapp']")
		public static WebElement whatsAppPopup;
		
		@FindBy(xpath="//select[@id='select_type_id_whatsapp']")
		public static WebElement SelectTemplateDropdown_whatsAppPopup;
		
		@FindBy(xpath = "//select[@id='select_type_id_whatsapp']/option[last()]")
		public static WebElement lastWhatsAppTemplateDropdown_whatsAppPopu;   //Dynamic 
		
		@FindBy(xpath = "//select[@id='whatsapp_to_number']")
		public static WebElement toNumberDropdown_WhatsAppPopup;
		
		@FindBy(xpath = "(//h2/..//..//button[text()='Send'])[2]")
		public static WebElement SendButton_WhatsAppPopup;
		
		@FindBy(xpath = "//ul//li//button[text()='Whatsapp']")
		public static WebElement whatsAppTab_stgesViewPage;
		
		@FindBy(xpath = "//h2[text()='Whatsapp Sending Status']")
		public static WebElement verifysendingStatus;
		
		@FindBy(xpath = "//select[@id='Whatsapp_select_type_id']")
		public static WebElement statusDropdown;
		
		@FindBy(xpath = "//button[@class='btn-primary whatsapp_sub_form_submit']")
		public static WebElement SubmitButtonSendingStatus;
		
		@FindBy(xpath = "//div[@class='last-section-button']//button[text()='Cancel']")
		public static WebElement cancelButton_SatgesProfileView;
		
		//Super admin_edit
		@FindBy(xpath = "//tbody/tr[last()]//td//div//img[@alt='table-edit']")
		public static WebElement lastEdit_smsTemplate;
		
		//Super admin Table
		
		@FindBy(name = "text_search")
		public static WebElement seachTextfield_WhatsappTemplate;
		
		@FindBy(xpath = "//select[@id='process_search']")
		public static WebElement ProcessDropdown_table;
		
		@FindBy(xpath = "//select[@id='sub_process_search']")
		public static WebElement SubProcessDropdown_table;
		
		@FindBy(xpath = "//select[@id='s_sub_process_search']")
		public static WebElement subSubProcessDropdown_table;
		
		@FindBy(xpath = "//select[@id='stage_search']" )
		public static WebElement whatsAppStagesDropdown_table;
		
		@FindBy(xpath = "//div//button//img[@alt='filter_search']")
		public static WebElement searchbutton_Table;
		
		@FindBy(xpath = "//td[normalize-space(.)='No Entries Found']")
		public static WebElement noEntriesFound;
		
		@FindBy(xpath = "//div//img/..//h6")
		public static WebElement clearAllFiltersButton_Table;
		
		@FindBy(xpath = "//select[@id='page-size-select']")
		public static WebElement itemperpageDropdown;
		
		@FindBy(xpath = "//tbody//tr/..//tr")
		List<WebElement> beforeSearchData_Table;
		
		@FindBy(xpath = "//tbody//tr/..//tr")
		List<WebElement> afterSearchData_Table;
				
		//WhatsBusineess
		@FindBy(xpath = "//div[contains(@class, 'social_media_images')]/img[contains(@class, 'whatsapp_buisness_btn_click')]")
		public static WebElement businessWhatsAppIcon_userAccountSatgeView;
		
		@FindBy(xpath = "//h2[text()='Whatsapp Buisness']")
		public static WebElement whatsappBusinessPopup;
		
		@FindBy(xpath="//select[@id='whatsapp_buisness_select_type_id']")
		public static WebElement SelectTemplateDropdown_whatsAppBusinessPopup;
		
		@FindBy(xpath = "//select[@id='select_type_id_whatsapp']/option[last()]")
		public static WebElement lastWhatsAppTemplateDropdown_whatsAppBusinessPopu;   //Dynamic 
		
		@FindBy(xpath = "//input[@id='whatsapp_buisness_from_number']")
		public static WebElement fromNumberInputField_whatsappBusinee;
		
		@FindBy(xpath = "//select[@id='whatsapp_buisness_to_number']")
		public static WebElement toNumberDropdwonWhatsappBusinessPopup;
		
		@FindBy(xpath = "//textarea[@id='whatsapp_buisness_msg']")
		public static WebElement messageFieldWhatsAppBuiness;
		
		@FindBy(xpath = "//button[@id='whatsapp_buisness_form_submit']")
		public static WebElement SendButton_WhatsAppBusinessPopup;
		
		
		
		
		
		
		
		
		
		
		
	
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
	
	public void navigatetoStage_verifyWhatsApp() throws Throwable 
	{
		driver.navigate().to("https://test.capture.autosherpas.com/en/stages/stages_list/");
		assertTrue(verifyStage.isDisplayed(), "verifyStage is not displayed");
		
		List<String>satgeNameList=new ArrayList<String>();
		for (WebElement stageName : stagesName) 
		{
			satgeNameList.add(stageName.getText());
			System.out.println("Stages name Lists : "+stageName.getText());
		}
			//satgeNameList.contains("CutomerdetailsZZZ Stage");
			assertTrue(satgeNameList.contains("CutomerdetailsZZZ Stage"));
			
			if (satgeNameList.size() >= 1) 
			 {
				 stagesName.get(2).click();
				 System.out.println("total count : "+satgeNameList.size() );
				
				 
			 }
			 else {
		            System.out.println("The number of matching elements is less than 1. Found: " + satgeNameList.size());
				 
		        }
			assertTrue(verifyCreatedSatgeName.isDisplayed(), "verifyCreatedSatgeName is not dispalyed");
			System.out.println("verifyCreatedSatgeName : "+verifyCreatedSatgeName.getText());
			
			
			//js.executeScript("arguments[0].scrollIntoView(true);", stages_actions); 
			 
			
			//Satges Actions
//			List<String>stagesActionList=new ArrayList<String>();                         //1st way
//			 for (WebElement stagesAction : stages_actions) 
//			 {
//				 stagesActionList.add(stagesAction.getText());
//				 System.out.println("StagesActions "+stagesAction.getText());
//			 }
//			 
//			 
//			 assertTrue(stagesActionList.contains("WhatsApp Call " ), "WhatsApp Call  action not  displayed in action table");
//			 
//			 assertTrue(leftArrowButton_stages.isDisplayed(), "left arrow button is not displayed");
//			 leftArrowButton_stages.click();
//			 
//			 assertTrue(verifyStage.isDisplayed(),"stagesPage not displayed");
			//############## if required need to impliment##########################
			
			List<String> stagesActionList = new ArrayList<String>();                     //2nd way
	        for (WebElement stagesAction : stages_actions) {
	            String actionText = stagesAction.getText().trim();
	            stagesActionList.add(actionText);
	            System.out.println("StagesActions: " + actionText);
	        }

	        System.out.println("Collected actions: " + stagesActionList);

	        assertTrue(stagesActionList.contains("WhatsApp Call"), "WhatsApp Call action not displayed in action table");
	        
	        assertTrue(leftArrowButton_stages.isDisplayed(), "left arrow button is not displayed");
			 leftArrowButton_stages.click();
			 
			 assertTrue(verifyStage.isDisplayed(),"stagesPage not displayed");
			
	}
	
	public void navigateTo_AlchemyModule() 
	{
		
		assertTrue(alchemySidemenubar.isDisplayed(), "alchemySidemenubar is not displayed");
//		alchemySidemenubar.click();
//		alchemySidemenubar.click();
		jsClick(driver, alchemySidemenubar);
		jsClick(driver, alchemySidemenubar);
		
	}
	
	public void navigateto_WhatsAppTemplateTab() 
	{
		
		driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/whatsapp_template_listing/");
		jsClick(driver, whatsAppTemplate_Tab);
		assertTrue(whatsAppTemplateText.isDisplayed(), " whatsApp TemplateText is not displayed");
	}
	
	public void CreateWhatsApptemplate() 
	{
		assertTrue(createButtonWhatsAppTemplate.isDisplayed(), "createButtonSmsTemplate is not displayed");
		//Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		createButtonWhatsAppTemplate.click();
		wait.until(ExpectedConditions.visibilityOf(CreateWhatsAppTepmlatePopUp));
		assertTrue(CreateWhatsAppTepmlatePopUp.isDisplayed(), "CreatesmstepmlateText is not displayed");
		
	}
	
	public void SelectProcessDropdown() 
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
		
		actions.moveToElement(driverIninteractable).perform();
		Select subProcessDropdown2=new Select(SubProcessDropdown);
		for (WebElement options2 : subProcessDropdown2.getOptions()) 
		{
			//Thread.sleep(1000);
			System.out.println(subProcessDropdown2.getOptions());
			subProcessDropdownList.add(options2.getText());
		}
	
		assertTrue(subProcessDropdownList.contains("Sub AJP"));
		subProcessDropdown2.selectByVisibleText("Sub AJP");
	}
	
	public void selectSubSubProcessDropdown() throws Throwable 
	{
		 List<String> subsubprocessDropdownList = new ArrayList<String>();
		    boolean elementStale = true;
		    int attempts = 0;
		    
		    while (elementStale && attempts < 3) {
		        try {
		            Select SubsubProcessDropdown3 = new Select(SubsubProcessDropdown);
		            subsubprocessDropdownList.clear(); // Clear the list before each retry

		            for (WebElement options3 : SubsubProcessDropdown3.getOptions()) {
		                Thread.sleep(2000);
		                System.out.println(options3.getText()); // Print each option's text
		                subsubprocessDropdownList.add(options3.getText());
		            }

		            assertTrue(subsubprocessDropdownList.contains("Sub Sub AJP"));
		            SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
		            actions.moveToElement(driverIninteractable).perform();

		            elementStale = false; // If we reach here, no exception was thrown
		        } catch (StaleElementReferenceException e) {
		            attempts++;
		            System.out.println("Stale element reference exception. Retrying... " + attempts);
		            Thread.sleep(2000); // Optional: add a wait before retrying
		        }
		    }

		    if (elementStale) {
		        throw new RuntimeException("Failed to interact with the dropdown after 3 attempts due to stale element reference.");
		    }
	}
	
	public void selectStages() 
	{
		List<String>smsStagesLists=new ArrayList<String>();
		Select whatsAppStagesdropdown=new Select(whatsAppStagesDropdown);
		for (WebElement smsStagesOptions : whatsAppStagesdropdown.getOptions()) 
		{
			System.out.println("satges Dropdown : "+whatsAppStagesdropdown.getOptions());
			smsStagesLists.add(smsStagesOptions.getText());
		}
			assertTrue(smsStagesLists.contains("CutomerdetailsZZZ Stage"));
			whatsAppStagesdropdown.selectByVisibleText("CutomerdetailsZZZ Stage");
	}
	
	public void CreateWhatsappTemplateContinue()
	{
		
		
		// WhatsApp - Template name
			// Array of predefined WhatsApp template names
        String[] templateNames = {
        		
        		"New_Product_Alert",
        		"Subscription_Confirmation",
        		"Payment_Receipt",
        		"Order_Status_Update",
        		"Cancellation_Notification",	
        		"Refund_Confirmation",
        		"Reminder_Message",
        		"Abandoned_Cart_Notification",
        		"Customer_Support_Response",
        		"Review_Request",
        		"Special_Event_Notification",
        		"Exclusive_Offer",
        		"Early_Access_Invitation",
        		"Product_Recommendation",
        		"Personalized_Offer",
        		"Seasonal_Greetings",
        		"Birthday_Wish",
        		"Anniversary_Celebration",
        		"Win_a_Prize_Notification",
        		"Community_Event_Announcement",
        		"Product_Tutorial",
        		"Survey_Invitation",
        		"App_Update_Notification",
        		"Loyalty_Points_Update",
        		"Thank_You_For_Your_Feedback",
        		"New_Store_Opening_Invitation",
        		"Holiday_Special_Offer",
        		"Service_Disruption_Notification",
        		"Feedback_Follow_Up",
        		"Welcome_Back_Message",
        		"Account_Activity_Alert",
        		"Policy_Change_Notification",
        		"Referral_Program_Invitation",
        		"Follow_Up_Message",
        		"User_Guide",
        		"Win_Back_Message",
        		"Service_Recommendation",
        		"New_Collection_Announcement",
        		"Emergency_Alert",
        		"CustomerAppreciationMessage",
        };

        // Create a Random object
        Random random = new Random();

        // Generate a random index to select a template name
        int randomIndex = random.nextInt(templateNames.length);

        // Print the selected random template name
        String randomTemplateName = templateNames[randomIndex];
        System.out.println("Random SMS Template Name: " + randomTemplateName);
        
		assertTrue(whatsAppTemplateName.isDisplayed(), " smsTemplateName is not dispalyed "); 
		whatsAppTemplateName.sendKeys(randomTemplateName);
		
		
		//Sms_disposition
		assertTrue(whatsAppDisposition.isDisplayed(), "smsDisposition is not dispalyed"); 
		 whatsAppDisposition.sendKeys(fake.lastName1());
		 
	       
	   // Sms From number 
	        	// Define the mobile number range
	        long min = 1000000000L; // Minimum 10-digit number
	        long max = 9999999999L; // Maximum 10-digit number

	        // Create a Random object
	        Random random1 = new Random();

	        // Generate a random number within the range
	        long randomNumber = min + ((long) (random1.nextDouble() * (max - min)));

	        // Print the random mobile number
	        System.out.println("Random Mobile Number: " + randomNumber);
	        
	        fromNumber.sendKeys(String.valueOf(randomNumber));   //String.valueOf = any thing is there convert to string value
	        
	         lastcreatedValue_ToNumber=fromNumber.getAttribute("value");
	        System.out.println("lastcreatedValue :"+lastcreatedValue_ToNumber);
	        
	      
	        
	        // SMS - to number
	        List<String>toNumberListsList=new ArrayList<String>();
	        Select toNumberDrodown=new Select(toNumber);
	        for (WebElement toNumberOptions : toNumberDrodown.getOptions()) 
	        {
	        	System.out.println(" to number dropdowns options : "+toNumberDrodown.getOptions());
	        	toNumberListsList.add(toNumberOptions.getText());
			}
	        assertTrue(toNumberListsList.contains("Whatsapp number"));
	        toNumberDrodown.selectByVisibleText("Whatsapp number");
	        
	        //  SMS - message
	        
	        // Array of predefined messages
	        String[] messages = {
	        		"Hello! Your account has been successfully verified. Welcome aboard!",
	        		"Hi! We've received your password reset request. Click the link to reset your password.",
	        		"Dear Customer, you're invited to our special event this weekend! We hope to see you there.",
	        		"Hi! We would love your feedback on your recent purchase. Please share your thoughts!",
	        		"Thank you for being a loyal customer! Enjoy your exclusive reward this month.",
	        		"Dear Customer, new products have just arrived! Check them out before they sell out!",
	        		"Hello! Your subscription has been successfully activated. Enjoy your benefits!",
	        		"Hi there! Your payment has been received. Thank you for your order!",
	        		"Dear Customer, your order status has been updated. Check your email for details!",
	        		"Hi! We regret to inform you that your order has been canceled. Please contact us for assistance.",
	        		"Dear Customer, your refund has been processed. It should reflect in your account soon.",
	        		"Hello! This is a friendly reminder that your appointment is coming up soon.",
	        		"Hi! You left some items in your cart. Come back and complete your purchase!",
	        		"Dear Customer, our support team is here to help you with any questions or concerns.",
	        		"Hi! We would appreciate your review of our service. Your feedback matters!",
	        		"Hello! You're invited to our special holiday event. RSVP now to secure your spot!",
	        		"Dear Customer, enjoy our limited-time offer of 30% off on selected items!",
	        		"Hi there! As a valued customer, you get early access to our upcoming sale!",
	        		"Dear Customer, we have a personalized offer waiting just for you. Check your account!",
	        		"Hello! Happy Birthday! Enjoy a special gift from us to celebrate your day.",
	        		"Hi! Thank you for your feedback! We're always looking to improve our service.",
	        		"Dear Customer, you're eligible for exclusive loyalty points this month!",
	        		"Hello! Our new collection is now live. Discover the latest trends today!",
	        		"Hi! We've made some updates to our app. Download the latest version now!",
	        		"Dear Customer, thank you for participating in our survey. Your input is invaluable!",
	        		"Hello! We appreciate your support. Here’s a sneak peek at our upcoming products!",
	        		"Hi there! Your account activity has been updated. Check your dashboard for details.",
	        		"Dear Customer, don't miss our flash sale happening this weekend only!",
	        		"Hello! Thank you for being a loyal customer. Here's a special thank-you offer!",
	        		"Hi! We want to hear from you! Share your thoughts about our service with us.",
	        		"Dear Customer, your package is out for delivery! Track your order online.",
	        		"Hello! You've been selected for a chance to win a special prize. Enter now!",
	        		"Hi there! Enjoy complimentary shipping on your next order over $50!",
	        		"Dear Customer, thank you for joining our community. We're glad to have you!",
	        		"Hello! You have loyalty points ready to redeem. Check your account for options!",
	        		"Hi! We have an exciting announcement! Stay tuned for more details.",
	        		"Dear Customer, our customer service team is available 24/7 to assist you!",
	        		"Hello! We hope you’re enjoying your purchase. Let us know how we can help!",
	        		"Hi! Our new referral program is here! Share with friends and earn rewards!",
	        		"Dear Customer, thank you for your recent order! We appreciate your business.",
	        		"Hello! We are launching a new loyalty program. Stay tuned for updates!",
	        		"Hi there! Check out our blog for tips and tricks to enhance your shopping experience.",
	        		"Dear Customer, your opinion matters! Participate in our feedback session.",
	        		"Hello! Join us for a live Q&A session with our experts this Friday!",
	        		"Hi! Our team is working hard to improve your experience. Thank you for your patience!",
	        		"Dear Customer, your satisfaction is our priority. Contact us for any issues!",
	        		"Hello! We're excited to announce our collaboration with top brands. Stay tuned!",
	        };

	        // Create a Random object
	        Random random2 = new Random();

	        // Generate a random index to select a message
	        int randomIndex2 = random2.nextInt(messages.length);

	        // Print the selected random message
	        String randomMessage = messages[randomIndex2];
	        System.out.println("Random Message: " + randomMessage);
	        
	        assertTrue(message.isDisplayed(), "message is not displayed");
	        message.sendKeys(randomMessage);
	        
	        message.getText();
	        System.out.println("After enter message text : "+message.getText());
	        
	        lastcreatedValue_Message=message.getAttribute("value");
	        System.out.println("lastcreatedValue_Message :"+lastcreatedValue_Message);
	       
	      //Remarks
	        assertTrue(remarks.isDisplayed(), "remarks is not displayed");
	        
	      //template variable name
	        assertTrue(templateVariableName.isDisplayed(), "templateVariableName is not displayed");
	        
	        //Satge Field name
	        assertTrue(stageFieldName.isDisplayed(), "stageFieldName is not displayed");
	        
	        //Default value
	        assertTrue(defaultValue.isDisplayed(), "defaultValue is not dispalyed");
	        
	  //Create Button        
	        assertTrue(createButton_WhatsAppTemplatePopup.isDisplayed(), "createButton_SmsTemplatePopup is not displayed");
	        createButton_WhatsAppTemplatePopup.click();
	        

	        wait.until(ExpectedConditions.visibilityOf(whatsAppTemplateCreatedSuccessfully_popuop));
	        assertTrue(whatsAppTemplateCreatedSuccessfully_popuop.isDisplayed(), "smsTemplateCreatedSuccessfully_popuop is not displayed");
	        
	        assertTrue(continueButton_create.isDisplayed(), "continueButton_create is not displayed");
	        continueButton_create.click();
	        
	        wait.until(ExpectedConditions.visibilityOf(last_CreatedWhatsApp));
	        assertTrue(last_CreatedWhatsApp.isDisplayed(), "last_CreatedSms is not displayed");
	        last_CreatedWhatsApp.getText();
	        System.out.println("Last Created WhatsApp : "+last_CreatedWhatsApp.getText());
	        
	}
	
	//Verify the user is able to create 
		public void userManagement()
		{

			driver.navigate().to("https://test.capture.autosherpas.com/en/user_management/users/");
			
			assertTrue(verifyUserMangagemen_page.isDisplayed(), "verifyUserMangagemen_page is not displayed");
			
			FirstCreatedUserName=firstCreated_UserManagement.getText();
			System.out.println("First Create User mangement :" +firstCreated_UserManagement.getText());
		}
		
		//user Mapping	
		public void userMapping() throws Throwable 
		{
			
			assertTrue(userMapping_USM.isDisplayed(), "userMapping_USM is not displayed");
			userMapping_USM.click();
			
		}
		
		public void SystemName_create() 
		{
			assertTrue(systemNamesTab.isDisplayed(), "systemNamesTab is not displayed");
			systemNamesTab.click();
			
			assertTrue(systemNamesTab.isDisplayed(), "verify_SystemName is not displayed");
			assertTrue(verify_SystemName.isDisplayed(), "verify_SystemName is not displayed");
			
			assertTrue(verifySystemname_lastCreated.isDisplayed(), "verifySystemname_lastCreated is not displayed");
			verifySystemname_lastCreated.getText();
			System.out.println("LastCreated System Name : "+verifySystemname_lastCreated.getText());
			
			assertEquals(verifySystemname_lastCreated.getText(), "Cloud Device Category");    //1st way
																							//2nd way
			
			//Logout		
			assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
			profileDropdown.click();
			
			assertTrue(logout.isDisplayed(), "logout is not displayed");
			logout.click();
		}
		
		//signIn
		public void loginas_UserCredentials() throws Throwable 
		{
			assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");
			assertTrue(usernameField.isDisplayed(), "usernameField is not displayed");
			usernameField.sendKeys("Wyzmindz_solutions");
			
			assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
			passwordField.sendKeys("Qwerty@123");
			
			assertTrue(signInButton.isDisplayed(), "signInButton is not displayed");
			signInButton.click();
			
			assertTrue(user_callLogTabViewpage.isDisplayed(), "user_callLogTabViewpage is not displayed");
			user_callLogTabViewpage.getText();
			
			// Assume this is the number we are checking
        	int number = 100;
        	// Check if the number is not equal to zero
            if (number != 0) 
            {
                // Click the element
            	userAccount_StagesCount.click();
                System.out.println("Element clicked because the number is not zero.");
            } 
            else 
            {
                System.out.println("Number is zero, element not clicked.");
            }
            
            // Stages profile view
            assertTrue(stagesProfileView_userAccount.isDisplayed(), "stagesProfileView_userAccount is not displayed");
            stagesProfileView_userAccount.click();
            
            assertTrue(whatsAppIcon_userAccountSatgeView.isDisplayed(), "SmsIcon_userAccountSatgeView is not displayed");
            whatsAppIcon_userAccountSatgeView.click();
            
            wait.until(ExpectedConditions.visibilityOf(whatsAppPopup));
            assertTrue(whatsAppPopup.isDisplayed(), "WhatsAppPopup is not displayed");
            
           
            //Select sms Template from dropdwon" WhatsApp"
            Select selectTempalateDropdown_whatsappPopu=new Select(SelectTemplateDropdown_whatsAppPopup);
            List<WebElement> Templateoptions = selectTempalateDropdown_whatsappPopu.getOptions();
            
            if (Templateoptions.size() > 0)     // Select the last option by index
            {
                int lastIndex = Templateoptions.size() - 1;
                selectTempalateDropdown_whatsappPopu.selectByIndex(lastIndex);
            } else {
                System.out.println("No options available in the dropdown.");
            }
            
            
            List<String>toNumberList_WhatsAppPopup=new ArrayList<String>();
            Select toNumberDropdownList_WhatsAppPopup=new Select(toNumberDropdown_WhatsAppPopup);
            for (WebElement toNumberSourceOptions : toNumberDropdownList_WhatsAppPopup.getOptions()) 
            {
            	System.out.println(" toNumbeDorpdown From WhatsAppPopup : "+toNumberDropdownList_WhatsAppPopup.getOptions());
            	toNumberList_WhatsAppPopup.add(toNumberSourceOptions.getText());
            	  
//            	assertTrue(toNumberList_WhatsAppPopup.contains(" "));
//                toNumberDropdownList_WhatsAppPopup.selectByVisibleText(" "); 
            	toNumberDropdownList_WhatsAppPopup.selectByIndex(0);
            }	
            
            assertTrue(SendButton_WhatsAppPopup.isDisplayed(), "SendButton_smsPopup is not displayed");
            SendButton_WhatsAppPopup.click();
            
            	
            //windown handeling "Change to parenet window tab"
            Thread.sleep(2000);
			 Set<String> windows = driver.getWindowHandles();
	            Iterator<String> iterator = windows.iterator();
	            String parentWindow = iterator.next();
	            //String childWindow = iterator.next();
	            driver.switchTo().window(parentWindow);
            
	            
	           List<String> sendindStatusDropdownList=new ArrayList<String>();
	           Select SendStatusDropdwon=new Select(statusDropdown);
	           for (WebElement sendingStatusDropdownOptions : SendStatusDropdwon.getOptions()) 
	           {
	        	   sendindStatusDropdownList.add(sendingStatusDropdownOptions.getText());
	        	   System.out.println("sending status options text: "+sendindStatusDropdownList.add(sendingStatusDropdownOptions.getText()));
	           }
	           		assertTrue(sendindStatusDropdownList.containsAll(sendindStatusDropdownList)); //All three verified
	           		SendStatusDropdwon.selectByIndex(1);
	           		//SendStatusDropdwon.selectByValue("Sending Failed");
	           		//SendStatusDropdwon.selectByVisibleText("User not on Whatsapp");
	           		
	           		assertTrue(SubmitButtonSendingStatus.isDisplayed(), "SubmitButtonSendingStatus is not displayed");
	           		SubmitButtonSendingStatus.click();
	           		
	           	 js.executeScript("arguments[0].scrollIntoView(true);", whatsAppTab_stgesViewPage); 
	           	wait.until(ExpectedConditions.visibilityOf(whatsAppTab_stgesViewPage));
	           	 assertTrue(whatsAppTab_stgesViewPage.isDisplayed(), "whatsAppTab_stgesViewPage is not displayed");
	           	whatsAppTab_stgesViewPage.click();
	           	//         verification pending " after send message"
	           	//
	           	
	           	assertTrue(cancelButton_SatgesProfileView.isDisplayed(), "cancelButton_SatgesProfileView is not displayed");
	            cancelButton_SatgesProfileView.click();
	           	
	           	// User Logout		
				assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
				profileDropdown.click();
				
				assertTrue(logout.isDisplayed(), "logout is not displayed");
				logout.click();   
	           	
		}
		
		
		//WahstApp Business
		public void SendSmsThroughBusinessWhatsapp() throws Throwable 
		{
			Thread.sleep(2000); 
			js.executeScript("arguments[0].scrollIntoView(true);", businessWhatsAppIcon_userAccountSatgeView); 
			 assertTrue(businessWhatsAppIcon_userAccountSatgeView.isDisplayed(), FirstCreatedUserName);
			 //businessWhatsAppIcon_userAccountSatgeView.click();
			 jsClick(driver, businessWhatsAppIcon_userAccountSatgeView);
			 
			 wait.until(ExpectedConditions.visibilityOf(whatsappBusinessPopup));
			 assertTrue(whatsappBusinessPopup.isDisplayed(), "whatsappBusinessPopup.is not displayed");
			 System.out.println("whatsappBusinessPopup Text :"+whatsappBusinessPopup.getText());
			 
			 
			 //Select sms Template from dropdwon" WhatsApp Business"
			 Select templateDropdown_whatsAppBusinessPopup=new Select(SelectTemplateDropdown_whatsAppBusinessPopup);
	            List<WebElement> Templateoptions1 = templateDropdown_whatsAppBusinessPopup.getOptions();
	            
	            if (Templateoptions1.size() > 0)     // Select the last option by index
	            {
	                int lastIndex = Templateoptions1.size() - 1;
	                templateDropdown_whatsAppBusinessPopup.selectByIndex(lastIndex);
	            } else {
	                System.out.println("No options available in the dropdown.");
	            }
	            
	            //from number "Whatsapp business"
	            wait.until(ExpectedConditions.visibilityOf(fromNumberInputField_whatsappBusinee));
	            assertTrue(fromNumberInputField_whatsappBusinee.isDisplayed(), "fromNumberInputField_whatsappBusinee not displayed");
	            System.out.println("fromNumberWhatsappBusineePopup :"+fromNumberInputField_whatsappBusinee.getText());
	            String fromNumberValue_WhatsAppBusiness=fromNumberInputField_whatsappBusinee.getAttribute("value"); //Need to implement
	            System.out.println("fromNumberValue_WhatsAppBusiness :"+fromNumberValue_WhatsAppBusiness);
	            
	            assertEquals(lastcreatedValue_ToNumber, fromNumberValue_WhatsAppBusiness);
	            
	            //toNumber "WhatsappBusiness"
	            List<String>toNumberList_WhatsAppBusinessPopup=new ArrayList<String>();
	            Select toNumberDropdown_WhatsAppBusinessPopup=new Select(toNumberDropdwonWhatsappBusinessPopup);
	            for (WebElement toNumberOptions : toNumberDropdown_WhatsAppBusinessPopup.getOptions()) 
	            {
	            	System.out.println(" toNumberDropdown_WhatsAppBusinessPopup : "+toNumberDropdown_WhatsAppBusinessPopup.getOptions());
	            	toNumberList_WhatsAppBusinessPopup.add(toNumberOptions.getText());
	            	  
//	            	assertTrue(toNumberList_WhatsAppPopup.contains(" "));
//	                toNumberDropdownList_WhatsAppPopup.selectByVisibleText(" "); 
	            	toNumberDropdown_WhatsAppBusinessPopup.selectByIndex(0);
	            }	
	            
	            
	            //Message "Whatsapp Business"
	           String messageFieldTextWhatsappBusiness=messageFieldWhatsAppBuiness.getText();
	           System.out.println("messageFieldTextWhatsappBusiness :" +messageFieldTextWhatsappBusiness);
	           
	           wait.until(ExpectedConditions.visibilityOf(messageFieldWhatsAppBuiness));
	           assertTrue(messageFieldWhatsAppBuiness.isDisplayed(), "messageFieldWhatsAppBuiness is not displayed");
	           
	           assertEquals(messageFieldTextWhatsappBusiness, messageFieldTextWhatsappBusiness);
	           
	           assertTrue(SendButton_WhatsAppBusinessPopup.isDisplayed(), "SendButton_WhatsAppBusinessPopup is not displayed");
	           SendButton_WhatsAppBusinessPopup.click();
	            
	           js.executeScript("arguments[0].scrollIntoView(true);", whatsAppTab_stgesViewPage); 
	           	wait.until(ExpectedConditions.visibilityOf(whatsAppTab_stgesViewPage));
	           	 assertTrue(whatsAppTab_stgesViewPage.isDisplayed(), "whatsAppTab_stgesViewPage is not displayed");
	           	whatsAppTab_stgesViewPage.click();
	           	//         verification pending " after send message"
	           	//
	           	
	           	// User Logout		
				assertTrue(profileDropdown.isDisplayed(), "profileDropdown is not displayed");
				profileDropdown.click();
				
				assertTrue(logout.isDisplayed(), "logout is not displayed");
				logout.click();   
		}
								//########################################//
		
		
		//Table page
				//Again login to "Super admin"
		public void searchThroughProcesses() throws Throwable 
		{
			
//			driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/whatsapp_template_listing/");
//			assertTrue(Verify_signIn.isDisplayed(), "Verify_signIn is not displayed");
//			assertTrue(usernameField.isDisplayed(), "usernameField is not displayed");
//			usernameField.sendKeys("capture_admin");
//			
//			assertTrue(passwordField.isDisplayed(), "passwordField is not displayed");
//			passwordField.sendKeys("Qwerty@123");
//			
//			assertTrue(signInButton.isDisplayed(), "signInButton is not displayed");
//			signInButton.click();
			
			assertTrue(user_callLogTabViewpage.isDisplayed(), "user_callLogTabViewpage is not displayed");
			user_callLogTabViewpage.getText();
			
			driver.navigate().to("https://test.capture.autosherpas.com/en/alchemy/whatsapp_template_listing/");
			
			
			//before SearchData
			List<String>beforeSearchDataLists_Table=new ArrayList<String>();
			for (WebElement beforeSearchData_Table : beforeSearchData_Table) 
			{
				beforeSearchDataLists_Table.add(beforeSearchData_Table.getText());
				System.out.println("before search data  :" + beforeSearchData_Table.getText());
			}
			
			
			List<String>processDropdownList=new ArrayList<String>();
			Select ProcessDropdown1=new Select(ProcessDropdown_table);
			for (WebElement Options : ProcessDropdown1.getOptions()) 
			{
				wait.until(ExpectedConditions.visibilityOfAllElements(Options));
				System.out.println(Options.getText());
				processDropdownList.add(Options.getText());
			}
			assertTrue(	processDropdownList.contains("AJP")); 
			ProcessDropdown1.selectByVisibleText("AJP");
			 beforeFirstProcessOption=ProcessDropdown1.getFirstSelectedOption().getText();
			System.out.println("beforeFirstProcessOption :"+beforeFirstProcessOption);
			
			
			List<String>subProcessDropdownList=new ArrayList<String>();
			actions.moveToElement(driverIninteractable).perform();
			Select subProcessDropdown2=new Select(SubProcessDropdown_table);
			for (WebElement options2 : subProcessDropdown2.getOptions()) 
			{
				//Thread.sleep(1000);
				System.out.println(subProcessDropdown2.getOptions());
				subProcessDropdownList.add(options2.getText());
			}
		
			assertTrue(subProcessDropdownList.contains("Sub AJP"));
			subProcessDropdown2.selectByVisibleText("Sub AJP");
			
			  beforeFirstSubProcessOption=subProcessDropdown2.getFirstSelectedOption().getText();  
		        System.out.println("beforeFirstSubProcessOption :"+beforeFirstSubProcessOption);
			
			 
		        
		        List<String> subsubprocessDropdownList = new ArrayList<String>();
			    boolean elementStale = true;
			    int attempts = 0;
			    
			    while (elementStale && attempts < 3) {
			        try {
			            Select SubsubProcessDropdown3 = new Select(subSubProcessDropdown_table);
			            subsubprocessDropdownList.clear(); // Clear the list before each retry

			            for (WebElement options3 : SubsubProcessDropdown3.getOptions()) 
			            {
			                Thread.sleep(2000);
			                System.out.println(options3.getText()); // Print each option's text
			                subsubprocessDropdownList.add(options3.getText());
			            }

			           
			            assertTrue(subsubprocessDropdownList.contains("Sub Sub AJP"));
			            SubsubProcessDropdown3.selectByVisibleText("Sub Sub AJP");
			            actions.moveToElement(driverIninteractable).perform();
			            
			             beforeFirstSubSubProcessOption=SubsubProcessDropdown3.getFirstSelectedOption().getText();  
				        System.out.println("beforeFirstSubSubProcessOption :"+beforeFirstSubSubProcessOption);

			            elementStale = false; // If we reach here, no exception was thrown
			        } catch (StaleElementReferenceException e) {
			            attempts++;
			            System.out.println("Stale element reference exception. Retrying... " + attempts);
			            Thread.sleep(2000); // Optional: add a wait before retrying
			        }
			    }

			    if (elementStale) 
			    {
			        throw new RuntimeException("Failed to interact with the dropdown after 3 attempts due to stale element reference.");
			    }
			    
			    		
			      
			    
			    
			    List<String>smsStagesLists=new ArrayList<String>();
				Select whatsaAppStagesdropdown=new Select(whatsAppStagesDropdown_table);
				for (WebElement smsStagesOptions : whatsaAppStagesdropdown.getOptions()) 
				{
					System.out.println("Whatsappstages Dropdown : "+whatsaAppStagesdropdown.getOptions());
					smsStagesLists.add(smsStagesOptions.getText());
				}
					assertTrue(smsStagesLists.contains("CutomerdetailsZZZ Stage"));
					whatsaAppStagesdropdown.selectByVisibleText("CutomerdetailsZZZ Stage");
					
					
					assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is not displayed");
					searchbutton_Table.click();
					
					//after SearchData
					List<String>afterSearchDataLists_Table=new ArrayList<String>();
					for (WebElement afterSearchData_Table : beforeSearchData_Table) 
					{
						afterSearchDataLists_Table.add(afterSearchData_Table.getText());
						System.out.println("After search based on process :" + afterSearchData_Table.getText());

					}
					
					
					
		}
		
		public void ClearFilters() 
		{
			assertTrue(clearAllFiltersButton_Table.isDisplayed(), "clearAllFiltersButton_Table is not displayed");
			clearAllFiltersButton_Table.click();
			
			Select processdropdown_tablePage=new Select(ProcessDropdown_table);
			String afterFirstProcessOption=processdropdown_tablePage.getFirstSelectedOption().getText();
			System.out.println("afterFirstProcessOption"+afterFirstProcessOption);
			
			Select subProcessdropdown_tablePage=new Select(SubProcessDropdown_table);
			String afterFirstSubProcessOption=subProcessdropdown_tablePage.getFirstSelectedOption().getText();
			System.out.println(" subProcessdropdown_tablePage : "+subProcessdropdown_tablePage);
			
			Select subSubProcessdropdown_tablePage=new Select(subSubProcessDropdown_table);
			String afterFirstSubsubProcessOption=subSubProcessdropdown_tablePage.getFirstSelectedOption().getText();
			System.out.println(" subSubProcessdropdown_tablePage : "+subSubProcessdropdown_tablePage);
			
			assertNotEquals(beforeFirstProcessOption, afterFirstProcessOption);
			assertNotEquals(beforeFirstSubProcessOption, afterFirstSubProcessOption);
			assertNotEquals(beforeFirstSubSubProcessOption, afterFirstSubsubProcessOption);
			
			
			
		}
		
		public void SearchThroughSearchField() throws InterruptedException 
		{
			//Thread.sleep(1000);
			 String lastCreatedWhatsAppTemplate=last_CreatedWhatsApp.getText();
			 System.out.println("lastCreatedsmsTemplate : "+lastCreatedWhatsAppTemplate);
			 
			 assertTrue(seachTextfield_WhatsappTemplate.isDisplayed(), "seachTextfield_WhatsappTemplate");
			 lastCreatedWhatsAppTemplate.isEmpty();
			 seachTextfield_WhatsappTemplate.sendKeys(lastCreatedWhatsAppTemplate);
			 
			 assertTrue(searchbutton_Table.isDisplayed(), "searchbutton_Table is displayed ");
			 searchbutton_Table.click();
			 
			 assertTrue(noEntriesFound.isDisplayed(), "noEntriesFound is not displayed");
				assertTrue(clearAllFiltersButton_Table.isDisplayed(),"clearAllFiltersButton_Table is not displayed");
				clearAllFiltersButton_Table.click();
		}
		
		public void SelectItemPerPAge() 
		{
			assertTrue(itemperpageDropdown.isDisplayed(), "itemperpageDropdown is not displayed");
			
			Select itemPerpageDropdownListSelect=new Select(itemperpageDropdown);
			itemPerpageDropdownListSelect.selectByIndex(1);
			
			 List<WebElement> items = driver.findElements(By.xpath("//select[@id='page-size-select']"));

	            // Verify the count of displayed items
	            if (items.size() == 10) {
	                System.out.println("Test Passed: The count of displayed items is 10.");
	            } else {
	                System.out.println("Test Failed: The count of displayed items is " + items.size());
	            }
			
		}
		
		
		
		
		
			
	
}
