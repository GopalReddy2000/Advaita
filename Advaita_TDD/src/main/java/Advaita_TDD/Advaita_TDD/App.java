package Advaita_TDD.Advaita_TDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.advaita.BaseClass.TestBase;

public class App extends TestBase {

	public App() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Audit Form")
	WebElement auditForm;

	@FindBy(id = "stage_search")
	WebElement stageSearch;

	@FindBy(xpath = "//td[1]//img")
	WebElement recordEyeButton;

	@FindBy(xpath = "//label[text()='LAN *']//following-sibling::input")
	WebElement lanInput;

	@FindBy(xpath = "//label[text()='Customer Name *']//following-sibling::input")
	WebElement customerName;

	@FindBy(xpath = "//span[contains(@id,'id-container')]")
	WebElement customerAvailableAtTheRegisteredAddress;

	@FindBy(xpath = "(//ul[@id='select2-current_Sec_id-results']//li[@id])[1]")
	WebElement yesCustomerAvailableAtTheRegisteredAddress;

	@FindBy(xpath = "//span[@id='select2-16303858-container']")
	WebElement vehicleAvailableAtTheRegisteredAddress;

	@FindBy(xpath = "(//ul[@id='select2-16303858-results']//li[@id])[1]")
	WebElement yesVehicleAvailableAtTheRegisteredAddress;

	@FindBy(xpath = "//label[text()='Age *']//following-sibling::input[@class]")
	WebElement Age;

	@FindBy(xpath = "//span[@id='select2-16323862-container']")
	WebElement employmentTypeDropdown;

	WebElement employmentType(String employmentType) {
		String xpath = "//li[text()='" + employmentType + "']";
		return driver.findElement(By.xpath(xpath));

	}

	@FindBy(xpath = "//label[text()='Employment Details *']//following-sibling::input[@class]")
	WebElement EmploymentDetailsInput;

	@FindBy(xpath = "//label[text()='Work Experience (In Years) *']//following-sibling::input[@class]")
	WebElement workExperienceInput;

	@FindBy(xpath = "//label[text()='Monthly Income *']//following-sibling::input[@class]")
	WebElement monthlyIncomeInput;

	@FindBy(xpath = "//span[@id='select2-16443883-container']")
	WebElement typeResidenceDropdown;

	WebElement typeofResidence(String typeOfResidence) {
		String xpath = "//li[text()='" + typeOfResidence + "']";
		return driver.findElement(By.xpath(xpath));

	}

	@FindBy(xpath = "//span[@id='select2-16443884-container']")
	WebElement getEMIPaidDetails;

	WebElement emiPaidByCustomerOrThirdParty(String typeOfResidence) {
		String xpath = "//li[text()='" + typeOfResidence + "']";
		return driver.findElement(By.xpath(xpath));

	}

	@FindBy(xpath = "//span[@id='select2-16413875-container']")
	WebElement feedbackCodeDropdown;

	WebElement feedBackCode(String feedBackCode) {
		String xpath = "//li[text()='" + feedBackCode + "']";
		return driver.findElement(By.xpath(xpath));

	}

	@FindBy(xpath = "//span[@id='select2-16353866-container']")
	WebElement customerFuturePlanForLoanRepayment;

	WebElement loadRepayment(String loadRepayment) {
		String xpath = "//li[text()='" + loadRepayment + "']";
		return driver.findElement(By.xpath(xpath));

	}

	@FindBy(xpath = "//label[contains(text(),' repayment details *')]//following-sibling::input[@class]")
	WebElement otherRepaymentDetails;

	@FindBy(xpath = "//span[@id='select2-16363868-container']")
	WebElement educationProvidedToCustomerOntheImpactOfNonPaymentOther;

	@FindBy(xpath = "//span[@id='select2-16373869-container']")
	WebElement educationProvidedToCustomerOntheImpactOfNonPayment;

	WebElement impactOfNonPayment(String impactOfNonPayment) {
		String xpath = "//li[text()='" + impactOfNonPayment + "']";
		return driver.findElement(By.xpath(xpath));

	}

	@FindBy(xpath = "//label[contains(text(),'Impact of Non-Payment')]//following-sibling::input[@class]")
	WebElement impactOfNonPaymentInput;

	@FindBy(xpath = "//span[@id='select2-16383871-container']")
	WebElement recommendationIfAny2;

	@FindBy(xpath = "//span[@id='select2-16393872-container']")
	WebElement recommendationIfAny;

	WebElement recommendationIfAny(String recommendationIfAny) {
		String xpath = "//li[text()='" + recommendationIfAny + "']";
		return driver.findElement(By.xpath(xpath));
	}

	@FindBy(xpath = "//label[contains(text(),'Recommendation Details')]//following-sibling::input[@class]")
	WebElement recommendationIfAnyOtherInput;

	@FindBy(xpath = "//label[contains(text(),'Final Remarks  *')]//following-sibling::input[@class]")
	WebElement finalRemarksInput;

	@FindBy(xpath = "//input[@id='File_Browse_3955']")
	WebElement supportingDocument;

	@FindBy(xpath = "//div[@class='zl-scrollBarBox']")
	WebElement verticalScroll;

	@FindBy(xpath = "(//ul[@id='select2-16303858-results']//li[@id])[2]")
	WebElement noVehicleAvailableAtTheRegisteredAddress;

	@FindBy(xpath = "(//ul[@id='select2-current_Sec_id-results']//li[@id])[2]")
	WebElement noCustomerAvailableAtTheRegisteredAddress;

	@FindBy(xpath = "//label[text()='Phone Number ']//following-sibling::input")
	WebElement phoneNumberInput;

	@FindBy(xpath = "//label[text()='Address ']//following-sibling::textarea")
	WebElement addressInput;

	@FindBy(xpath = "(//button[text()='Save'])[1]")
	WebElement save;

	String homeMaker = "Home Maker";
	String others = "Others";
	String retired = "Retired";
	String salaried = "Salaried";
	String selfEmployed = "Self Employed";
	String student = "Student";
	String unemployed = "Unemployed";

	String ownHouse = "Own House";
	String rentedHouse = "Rented House";

	String customer = "Customer";
	String thirdParty = "Third Party";

	String customerIsNotUsingTheVehicle = "Customer is not using the vehicle";
	String customerDeceased = "Customer Deceased";
	String dealerDispute = "Dealer Dispute";
	String financialDefaulter = "Financial Defaulter (Medical and Job loss Issue)";
	String requestClosure = "Request for Closure";
	String requestedCashPickup = "Requested for cash pickup";

	// Loan Repayment
	String foreclosure = "Foreclosure";
	// String others="Others";
	String payTheEMI = "Pay the EMI";
	String settlement = "Settlement ";
	String surrender = "Surrender";

	// Education Provided to Customer on the Impact of Non-Payment?
	String yes = "Yes";
	String no = "No";

	// Recommandation
	String creditDecisionToBeReviewed = "Credit Decision to be Reviewed";
	String flagToRCUTeam = "Flag to RCU Team";
	String intentionalDefaulter = "Intentional Defaulter";

	public App navToRecordToAuditForm(String stageSelect) {
		navigateWithinAlchemy(auditForm);
		selectByVisibleText(stageSearch, stageSelect);
		jsClick(driver, recordEyeButton);
		return this;
	}

	public App auditForm(String lan, String CustName, String age, String employmentDetails, String workExperience,
			String monthlyIncome) {

		sendKeys(lanInput, lan);
		sendKeys(customerName, CustName);
//        jsClick(driver,customerAvailableAtTheRegisteredAddress);
		customerAvailableAtTheRegisteredAddress.click();
//        jsClick(driver,yesCustomerAvailableAtTheRegisteredAddress);
		yesCustomerAvailableAtTheRegisteredAddress.click();
		vehicleAvailableAtTheRegisteredAddress.click();
		yesVehicleAvailableAtTheRegisteredAddress.click();
		sendKeys(Age, age);

		employmentTypeDropdown.click();
		employmentType(retired).click();
		jsWindowsScroll(200);
		sendKeys(EmploymentDetailsInput, employmentDetails);
		sendKeys(workExperienceInput, workExperience);
		sendKeys(monthlyIncomeInput, monthlyIncome);

		typeResidenceDropdown.click();
		typeofResidence(ownHouse).click();
		getEMIPaidDetails.click();

		emiPaidByCustomerOrThirdParty(customer).click();
		unWaitInMilli(500);
		feedbackCodeDropdown.click();
		feedBackCode(customerIsNotUsingTheVehicle).click();
		unWaitInMilli(500);
		customerFuturePlanForLoanRepayment.click();
		loadRepayment(foreclosure).click();
		educationProvidedToCustomerOntheImpactOfNonPayment.click();
		impactOfNonPayment(yes).click();
		recommendationIfAny.click();
		recommendationIfAny(creditDecisionToBeReviewed).click();
//jsWindowsScrollIntoView(finalRemarksInput);
//        js.executeScript("arguments[0].scrollBy(0, 100);", verticalScroll);
//        js.executeScript("arguments[0].scrollTop += 300;", verticalScroll);

		String textToSend1 = "Hello World!";
		js.executeScript("arguments[0].value='" + textToSend1 + "';", finalRemarksInput);
//        sendKeys(finalRemarksInput,"final remarks");

		sendKeys(supportingDocument, System.getProperty("user.dir") + "/SOPDocs/Newsletter.pdf");

		return this;
	}

	
	
	
	@Test
	public void setLtfs() {

		navToRecordToAuditForm("TW -Customer Visit Feedback form").auditForm("Lan", "James", "24", "Employed", "2",
				"1111");
	}

}