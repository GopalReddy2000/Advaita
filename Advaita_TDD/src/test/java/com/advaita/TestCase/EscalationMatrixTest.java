package com.advaita.TestCase;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.EscalationMatrixPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

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

	String managerDecision="Reject";
	String escalatedMessage="Escalated";
	String reEscalatedMessage="Re-Escalated";

	@Test
	public void escalationMatrixCreateTest()
	{
		escalationMatrixPage.navigationToTablePage()
				.table("Insurance Stage")
				.escalationCreation();
		loginToUser("Agent");
		escalationMatrixPage.escalateRecord(escalatedMessage);
		loginToUser("Team Lead");
		escalationMatrixPage.agencyValidation(managerDecision,escalatedMessage,"Escalation");

		switch(managerDecision) {
			case "Accept":
				escalationMatrixPage.validationStatusReport();
			case "Reject":
				loginToUser("Agent");
				escalationMatrixPage.rejectAuditForm(reEscalatedMessage);
				loginToUser("Team Lead");
				escalationMatrixPage.agencyValidation(managerDecision,reEscalatedMessage,"reEscalation");

		}
	}


	@Test
	public void agencyTest()
	{
		loginToUser("Team Lead");
		escalationMatrixPage.validationStatusReport();
	}

	@Test
	public void escalateRecordTest()
	{
		loginToUser("Agent");
		escalationMatrixPage.assignRecord();
	}

	@Test
	public void rejectAuditForm()
	{
		loginToUser("Agent");
		escalationMatrixPage.rejectAuditForm(reEscalatedMessage);
	}






	@AfterTest
	public void tearDown()
	{
//		driver.quit();
	}

}
