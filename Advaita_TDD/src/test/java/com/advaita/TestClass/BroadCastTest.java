package com.advaita.TestClass;

import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.BroadCastPage;

public class BroadCastTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	BroadCastPage bc;
	BroadCastTest()
	{
		super();
	}
	@BeforeTest
	public void setup() throws Exception {
		initialization();
		lp = new LoginPage();
		hp = lp.login("Capture_admin", "Qwerty@123");
		bc = new BroadCastPage();
	}

	@Test(dataProvider ="broadcastData")
	public void navTest(String templateName,String message,String roleToSelect)
	{
		bc.navigation()
		.create(templateName, message, roleToSelect)
		;
	}


	@Test
	public void getOptions()
	{
		bc.navigation().deleteRecord("Duplicate");
	}

	@DataProvider(name = "broadcastData")
	public Object[][] createBroadcastData() {
		return new Object[][] {
			{"Quarterly Performance Review", "Don’t miss the Q2 Performance Review summary in your inbox!","Admin"},
			{"Product Launch Announcement", "Exciting news! Our new product launches tomorrow – check it out!","Admin"},
			{"Customer Satisfaction Survey", "Help us improve by completing the Customer Satisfaction Survey!","Admin"},
			{"Weekly Sales Highlights", "Catch up on this week's top sales highlights and achievements!","Admin"},
			{"Upcoming Training Session", "Reminder: Join our training session on advanced CRM features next week!","Admin"},
			{"New Feature Release", "Explore the latest CRM feature release now available in your dashboard!","Admin"},
			{"Year-End Review", "Review your year-end performance summary and set goals for next year!","Admin"},
			{"Special Discount Offer", "Don’t miss our special discount offer – available for a limited time!","Admin"},
			{"Monthly Team Achievements", "Celebrate this month’s team achievements and milestones!","Admin"},
			{"Client Feedback Request", "We value your feedback – please share your thoughts on our recent service!","Admin"}
		};
	}

	@Test
	public void templateNames()
	{
		bc.navigation();
		bc.getTemplateNames();
		
	}
	@Test(dataProvider = "TemplateNames")
	public void searchFunctionlity(String Template)
	{
		bc.navigation()
		.search(Template)
		;
	}
	
	@DataProvider(name = "TemplateNames")
    public Object[][] provideStringData() {
        return new Object[][] {
        	
        	 {"James"}
//            {"Quarterly Performance Review"},
//            {"Quarterly Performance Review"},
//            {"Product Launch Announcement"},
//            {"Customer Satisfaction Survey"},
//            {"Weekly Sales Highlights"},
//            {"New Feature Release"},
//            {"Year-End Review"},
//            {"Special Discount Offer"},
//            {"Monthly Team Achievements"}
        };
    }
	
	@Test
	public void speedTest()
	{
		bc.navigation()
		.changeSpeed("Slow");
		
	}
	
	List<Object> roles=List.of(
			"Admin",
			"Agent",
			"CE Head",
			"Complaint Desk",
			"CRC Admin",
			"Drivingschool",
			"DSE",
			"Insurance",
			"QA",
			"Sales",
			"Service",
			"Team Lead",
			"Usedcar",
			"View",
			"View 2",
			"View Alchemy"

			);

	@AfterTest
	public void tearDown() {

//		driver.manage().window().maximize();
//		driver.quit();
	}


}
