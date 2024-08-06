package com.advaita.TestCase;

import java.awt.AWTException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.EscalationMatrixPage;

public class EscalationMatrixTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	EscalationMatrixPage escalationMatrixPage;
	
	EscalationMatrixTest()
	{
		super();
	}
	@BeforeTest
	public void setUp()
	{
		try {
			initialization();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage = new LoginPage();
		try {
			homePage = loginPage.login("Capture_admin", "Qwerty@123");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		escalationMatrixPage =new EscalationMatrixPage();
	}
	
	
	@Test
	public void tableCheck()
	{
		escalationMatrixPage.navigationToTablePage()
		.table("Insurance Stage")
		.dropdownValidations()
		
		;
	}
	
	String managerDecision="";
	
	@Test
	public void escalationMatrixCreateTest()
	{
		escalationMatrixPage.navigationToTablePage()
		.table("Stage Test")
		.escalationCreation();
		loginToUser("Agent");
		escalationMatrixPage.escalateRecord("");
		loginToUser("Team Lead");
		escalationMatrixPage.agencyValidation(managerDecision);
		
		switch(managerDecision) {
		case "Accept": 
			escalationMatrixPage.validationStatusReport();
			
		}
	}
	
	
	@Test
	public void agencyTest()
	{
		loginToUser("Team Lead");
		escalationMatrixPage.agencyValidation("Accept");
	}
	
	@Test
	public void escalateRecordTest()
	{
		loginToUser("Agent");
		escalationMatrixPage.escalateRecord("");
	}
	
	
	
	
	@AfterTest
	public void tearDown()
	{
//		driver.quit();
	}
	
}
