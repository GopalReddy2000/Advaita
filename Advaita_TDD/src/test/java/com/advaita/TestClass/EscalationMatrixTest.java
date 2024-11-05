package com.advaita.TestClass;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.EscalationMatrixPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
		escalationMatrixPage.navigationToEscalationTablePage()
				.table("Insurance Stage")
				.dropdownValidations()

		;
	}

	String managerDecision="Reject";
	String escalatedMessage="Escalated";
	String reEscalatedMessage="Re-Escalated";

	@Test
	public void escalationMatrixCreateTest(String stageName)
	{
		escalationMatrixPage.navigationToEscalationTablePage()
				.table("Insurance Stage")
				.escalationCreation();
		loginToUser("Agent");
		escalationMatrixPage.escalateRecord(escalatedMessage);
		loginToUser("Team Lead");
//		escalationMatrixPage.agencyValidation(managerDecision,escalatedMessage,"Escalation");

		switch(managerDecision) {
			case "Accept":
				escalationMatrixPage.validationStatusReportFilter(stageName,"1-10-2024","24-10-2024");
			case "Reject":
				loginToUser("Agent");
				escalationMatrixPage.rejectAuditForm(reEscalatedMessage);
				loginToUser("Team Lead");
//				escalationMatrixPage.agencyValidation(managerDecision,reEscalatedMessage,"reEscalation");

		}
	}
	String stageName="FreshFieldSet Stages";
	String agent="JamesAgent";
	String lead="JamesLead";
	String admin="James Admin";
	String accept="Accept";
	String reject="Reject";
	String fromDate="01-10-2024";
	String toDate="30-11-2024";

	@Test
	public void agencyValidation()
	{

		escalationMatrixPage.agentAssignment(stageName,agent);
		loginToUser(lead);
		escalationMatrixPage.agencyValidation(stageName,accept,agent,accept);


	}
	@Test
	public void agencyStageDropdown()
	{
		loginToUser(lead);
		navigateWithinAlchemy(escalationMatrixPage.agencyValidaion);
		escalationMatrixPage.stageDropdown(stageName);
	}

	@Test
	public void validateItemsPerPage()
	{
		loginToUser(lead);
		escalationMatrixPage
				.agencyValItemsPerPageDropdown(stageName);
	}

	@Test
	public void validateValidationStatusReport(){

		loginToUser(lead);
		escalationMatrixPage
				.validationStatusReportFilter(stageName,"01-10-2024","25-10-2024");
	}
	@Test
	public void validateValidationPagination(){

		loginToUser(lead);
		escalationMatrixPage
				.validationStatusReportFilter(stageName,"01-10-2024","25-10-2024")
				.validateRecordsPerPage()
		;
	}

	@Test
	public void validationLocalFilter()
	{
		escalationMatrixPage.assignReportFilters(stageName);
		escalationMatrixPage.validationStatusReportFilter(stageName,"01-10-2024","25-10-2024")
				.validationStatusLocalFilterWithDropdown();
	}


	@Test
	public void agencyTest()
	{
		loginToUser("Team Lead");
		escalationMatrixPage.validationStatusReportFilter(stageName,"01-10-2024","01-10-2024");
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

	@Test(invocationCount = 10)
	public void disposeDatas(){

		escalationMatrixPage.disposeData(stageName,agent);
	}

	@Test(invocationCount = 10)
	public void endToEndAccept(){


		escalationMatrixPage
//				.escalateRecordEndToEnd(stageName)
				.agentAssignment(stageName,agent);
//		loginToUser(lead);
//		escalationMatrixPage
//				.agencyValidation(stageName,accept,agent,agent);
//		loginToUser(admin);
//		escalationMatrixPage
//				.agencyValidation(stageName,accept,agent,lead);
//		escalationMatrixPage
//				.validationStatusReportFilter(stageName,fromDate,toDate);

//		Bug on the order of storing the record.


	}

	@Test
	public void endToEndLeadReject(){
		escalationMatrixPage
				.escalateRecordEndToEnd(stageName)
				.agentAssignment(stageName,agent);
		loginToUser(lead);
		escalationMatrixPage
				.agencyValidation(stageName,reject,agent,agent)

		;
		loginToUser(agent);
		escalationMatrixPage.rejectedAuditForm(stageName,agent,lead);

	}


	@Test
	public void endToEndAdminReject(){

		escalationMatrixPage
				.escalateRecordEndToEnd(stageName)
				.agentAssignment(stageName,agent);
		loginToUser(lead);
		escalationMatrixPage
				.agencyValidation(stageName,accept,agent,agent);
		loginToUser(admin);
		escalationMatrixPage
				.agencyValidation(stageName,reject,agent,lead);
		loginToUser(lead);
		escalationMatrixPage.rejectedAuditForm(stageName,agent,admin);
		loginToUser(agent);
		escalationMatrixPage.rejectedAuditForm(stageName,agent,admin);




	}


//	Negative Test

	@Test(dataProvider = "invalidSearchInputData")
	public void searchBox(String invalidData)
	{
		escalationMatrixPage.
				navigationToEscalationTablePage()

				.searchValidations(invalidData);
	}

	@DataProvider(name = "invalidSearchInputData")
	public Object[][] invalidSearchInputData() {

		return new Object[][]{

				{""},                              // Empty Input
				{" "},                             // Whitespace Input
				{"@#$%^&*()_+[]{}|;:'\",.<>?/\\ "}, // Special Characters
				{"'; DROP TABLE users; --"},       // SQL Injection
				{"<script>alert('Hacked!')</script>"}, // XSS/HTML Injection
				{"a".repeat(5000)},                // Extremely Long String
				{"12345"},                         // Numbers Only
				{"abc123xyz"},                     // Alphanumeric Input
				{"你好"},                           // Unicode Characters
				{"\\n\\t\\0"},                     // Escape Sequences
				{"plainaddress"},                  // Invalid Email Format
				{"😊"},                            // Emoji Characters
				{"a"},                             // Single Character
				{"testtesttest"},                  // Duplicate Input
				{"   test   "},                    // Whitespace with Characters

				{"\u0000"},                        // Control Character: null
				{"\u0008"}                         // Control Character: backspace

		};
	}

	@Test
	public void testEscalation1()
	{
		escalationMatrixPage
//				.navigationToEscalationTablePage()
//				.escalateRecordEndToEnd()
				.navigateToValidationStatusReport("JamesAgent","Bhuvana Qset Stage","Reviewed","James@gmail.com")
		;
	}



	@AfterTest
	public void tearDown()
	{
//		driver.quit();
	}

}
