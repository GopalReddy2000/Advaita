package com.advaita.TestClass;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;
import com.advaita.Login.Home.HomePage;
import com.advaita.Login.Home.LoginPage;
import com.advaita.pageObjects.EmailTemplatePage;

public class EmailTemplateTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	EmailTemplatePage emailTemplatePage;

	EmailTemplateTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
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

		emailTemplatePage = new EmailTemplatePage();
	}

	// File Path
	private static final String emailTemplate_Path8 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\email.Properties";

	@Test
	public void navigationTest() {
		emailTemplatePage.navigation();
	}

	@Test(dataProvider = "InvalidEmails")
	public void EmailTest(WebElement element, String InvalidEmail) {

		emailTemplatePage.navigation().validateEmail(element, InvalidEmail);
	}

	@DataProvider(name = "InvalidEmails")
	public Object[] emailData() {
		return new Object[][] { { emailTemplatePage.inputFromMail, "James.paul.com" },
				{ emailTemplatePage.inputBCCMail, "James.paul.com" },
				{ emailTemplatePage.inputCCMail, "James.paul.com" }, };
	}

	@Test
	public void validateDropdownTest() {
		emailTemplatePage.validateDropdowns();
	}

	@Test
	public void smsTemplate() {
		emailTemplatePage.smsTemplate();
	}

	@Test(dataProvider = "Email Template")
	public void emailTempalteCreateTest(String TemplateName, String fromMail, String toMail, String CCMail, String BCC,
			String Subject, String Message) {
		emailTemplatePage
				.createEmailTemplate("AJP", "Sub AJP", "Sub Sub AJP", "Insurance Stage", TemplateName, fromMail,
						"Email ID", CCMail, BCC, Subject, Message)
				.navigateToCustomerProfile("Agent")
				.verifyTemplate(TemplateName, fromMail, CCMail, BCC, Subject, Message);
		emailTemplatePage.loginToUser("Capture_admin");
		emailTemplatePage.actionRecord(TemplateName, "Delete");

	}

	@DataProvider(name = "Email Template")
	public Object[] emailData1() {
		return new Object[][] {

				{ "Template1", "sender1@example.com", "recipient1@example.com", "cc1@example.com", "bcc1@example.com",
						"Subject 1", "Message body for template 1." },
//	            {"Template2", "sender2@example.com", "recipient2@example.com", "cc2@example.com", "bcc2@example.com", "Subject 2", "Message body for template 2."},
//	            {"Template3", "sender3@example.com", "recipient3@example.com", "cc3@example.com", "bcc3@example.com", "Subject 3", "Message body for template 3."},
//	            {"Template4", "sender4@example.com", "recipient4@example.com", "cc4@example.com", "bcc4@example.com", "Subject 4", "Message body for template 4."},
//	            {"Template5", "sender5@example.com", "recipient5@example.com", "cc5@example.com", "bcc5@example.com", "Subject 5", "Message body for template 5."},
//	            {"Template6", "sender6@example.com", "recipient6@example.com", "cc6@example.com", "bcc6@example.com", "Subject 6", "Message body for template 6."},
//	            {"Template7", "sender7@example.com", "recipient7@example.com", "cc7@example.com", "bcc7@example.com", "Subject 7", "Message body for template 7."},
//	            {"Template8", "sender8@example.com", "recipient8@example.com", "cc8@example.com", "bcc8@example.com", "Subject 8", "Message body for template 8."},
//	            {"Template9", "sender9@example.com", "recipient9@example.com", "cc9@example.com", "bcc9@example.com", "Subject 9", "Message body for template 9."},
//	            {"Template10", "sender10@example.com", "recipient10@example.com", "cc10@example.com", "bcc10@example.com", "Subject 10", "Message body for template 10."}

		};

	}

	@Test
	public void deleteTest() {
		emailTemplatePage.navigation().actionRecord("Welcome Email", "Delete");
	}

	@Test(dataProvider = "Edit Email Template")
	public void editTemplateTest(String ToEdit, String editFromMail, String editToMail, String editBCCMail,
			String editCCMail, String EditSubject) {
		emailTemplatePage.navigation().actionRecord("Welcome Email", "Edit")
				.editTemplate(ToEdit, editFromMail, editToMail, editBCCMail, editCCMail, EditSubject)
				.navigateToCustomerProfile("Agent").validateEditedTemplate("Welcome Email", ToEdit, editFromMail,
						editToMail, editBCCMail, editCCMail, EditSubject);

	}

	@DataProvider(name = "Edit Email Template")
	public Object[] editEmailTemplate() {
		return new Object[][] {

				{ "From", "EditedFrom@example.com", "", "", "", "" },
//			  {"To", "", "EditedTo@example.com", "", "", ""},
				{ "BCC", "", "", "EditedBCC@example.com", "", "" }, { "CC", "", "", "", "EditedCC@example.com", "" },
				{ "Subject", "", "", "", "", "EditedSubject" },

		};
	}

	@Test
	public void subjectTest() {

		emailTemplatePage
//		.navigation()
//		.variables("Stage", "Testing Variables {{Name}} {{Phone}} ", "Name", "Phone","Name Of the Customer","Phone Number", "Customer", "100")
				.navigateToCustomerProfile("Agent").verifyVaribles();
	}

//===========================================================================================================================	

	String caseValue1_GivenProcess = "givenprocessname";
	String caseValue1_GivenSubProcess = "givenSubprocessname";
	String caseValue1_GivenSubSubProcess = "givensubsubprocessname";

	String caseValue2_randomProcess = "randomprocess";
	String caseValue2_randomSubProcess = "randomSubprocess";
	String caseValue2_randomSubSubProcess = "randomSubSubprocess";

	String caseValue_givenStage = "givenStageName";
	String caseValue_randomStage = "randomStage";

	@Test(priority = 1)
	public void verifyTheUserIsAbleToNavigateEmailTemplate() {
		emailTemplatePage.navigation();
	}

	@Test(priority = 2, dependsOnMethods = { "verifyTheUserIsAbleToNavigateEmailTemplate" })
	public void verifyTheUserIsAbleToNaviagteCreateEmailtemplatePages() {

		emailTemplatePage.navigatetoCreateAndVerify();
	}

	@Test(priority = 3, dependsOnMethods = { "verifyTheUserIsAbleToNaviagteCreateEmailtemplatePages" })

	// Random Select

	public void verfiyTheUserIsabletoCreateEmailtemplateRandomely() throws Throwable {

		emailTemplatePage.selectProcess(caseValue2_randomProcess);

		emailTemplatePage.selectSubProcess(caseValue2_randomSubProcess);

		emailTemplatePage.selectSubSubProcess(caseValue2_randomSubSubProcess);

		emailTemplatePage.selectStages(caseValue_randomStage);

		emailTemplatePage.selectApiKyeName();

		emailTemplatePage.enterTemplateName();

		emailTemplatePage.EnterFromMailID();

		emailTemplatePage.toEmailSource("random");

		emailTemplatePage.toMmail();

		emailTemplatePage.enterCC();

		emailTemplatePage.enterbcc();

		emailTemplatePage.enterbcc();

		emailTemplatePage.remarksTextfield();

		emailTemplatePage.disposition();
	}

	// Manually Create
	@Test(priority = 4, dependsOnMethods = { "verifyTheUserIsAbleToNaviagteCreateEmailtemplatePages" })
	public void verfiyTheUserIsabletoCreateEmailtemplateManuaally() throws Throwable {

		emailTemplatePage.selectProcess(caseValue1_GivenProcess);

		emailTemplatePage.selectSubProcess(caseValue2_randomSubProcess);

		emailTemplatePage.selectSubSubProcess(caseValue1_GivenSubSubProcess);

		emailTemplatePage.selectStages(caseValue_givenStage);

		emailTemplatePage.selectApiKyeName();

		emailTemplatePage.enterTemplateName();

		emailTemplatePage.EnterFromMailID();

		emailTemplatePage.toEmailSource("SelectmanuallyToNumberSource");

		emailTemplatePage.toMmail();

		emailTemplatePage.enterCC();

		emailTemplatePage.enterbcc();

		emailTemplatePage.enterbcc();

		emailTemplatePage.remarksTextfield();

		emailTemplatePage.disposition();

		emailTemplatePage.selectEmailForDropdown("SelectmanuallyEmailFor");

		emailTemplatePage.subject();

		emailTemplatePage.handleSelect2RolesDropdown("manual", "1", "5");
		//emailTemplatePage.handleSelect2RolesDropdown("random");

	}

	// @AfterTest
	public void tearDown() {
		driver.quit();
	}

}
