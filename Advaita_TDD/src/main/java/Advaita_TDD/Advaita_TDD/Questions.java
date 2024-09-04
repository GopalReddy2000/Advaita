package Advaita_TDD.Advaita_TDD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.advaita.BaseClass.TestBase;

public class Questions extends TestBase {
	
	
	public static List<Map<String, String>> generateEmployeeQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();

	    // Existing questions
	    questions.add(Map.of("FieldName", "Employee Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Employee ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Department", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Position", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Joining", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Salary", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Phone Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

	    // Additional Text Area questions
	    questions.add(Map.of("FieldName", "Office Location", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Manager", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Work Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Home Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Spouse Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Employee Status", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Work Authorization", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Salary Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    
	    // Additional HyperLink questions
	    questions.add(Map.of("FieldName", "Website", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "LinkedIn Profile", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    
	    
	    // Additional boolean type questions
	    questions.add(Map.of("FieldName", "Stock Options", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Retirement Plan", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Health Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Dental Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Vision Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Life Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Disability Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Employee Discount", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Tuition Reimbursement", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Parking Benefit", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Public Transportation Benefit", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Remote Work Eligibility", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Flex Time Eligibility", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Overtime Eligibility", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Marital Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    
	    // Additional Number type questions
	    questions.add(Map.of("FieldName", "Paid Time Off Balance", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Sick Leave Balance", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Vacation Balance", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Hourly Rate", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Annual Salary", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Bonus", "Type", "Number", "MaxLength", "7", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Children", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Work Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Home Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Mobile Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));

	    // Additional Character type questions
	    questions.add(Map.of("FieldName", "Job Title", "Type", "Character", "MaxLength", "40", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Nationality", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Language", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Supervisor", "Type", "Character", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Emergency Contact Relation", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Ethnicity", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Blood Type", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Driving License Number", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Passport Number", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact Address", "Type", "Character", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Middle Name", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Gender", "Type", "Character", "MaxLength", "40", "IsMandatory", "Yes"));
	    
	    // Adding Date Time questions
	    questions.add(Map.of("FieldName", "Hire Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Last Review Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Contract Expiration Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Last Promotion Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Last Salary Increase Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Next Salary Review Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Onboarding Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Termination Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Offer Acceptance Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Background Check Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Performance Review Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Last Salary Increase Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Next Salary Review Date", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Hire Date", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Last Promotion Date", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    
	    return questions;
	}



	public static List<Map<String, String>> generateCustomerQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();

	    // Existing questions
	    questions.add(Map.of("FieldName", "Customer Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Customer ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Registration", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Purchase History", "Type", "Text Area", "MaxLength", "300", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Loyalty Points", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));

	    // Additional questions
	    questions.add(Map.of("FieldName", "Preferred Language", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Gender", "Type", "Character", "MaxLength", "1", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Marital Status", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Contact Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Newsletter Subscription", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Website", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "LinkedIn Profile", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Facebook Profile", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Twitter Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));

	    questions.add(Map.of("FieldName", "Instagram Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Referral Source", "Type", "Character", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Spouse Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Number of Children", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Favorite Product", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Payment Method", "Type", "Character", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Preferred Contact Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "VIP Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Discount Code", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Last Purchase Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));

	    questions.add(Map.of("FieldName", "Account Balance", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Member Since", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Customer Notes", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Referral Bonus", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Promo Code Used", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Store", "Type", "Character", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Satisfaction", "Type", "Number", "MaxLength", "1", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Transaction History", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Marketing Opt-In", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Terms Accepted", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));

	    questions.add(Map.of("FieldName", "Loyalty Program", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Shipping Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Billing Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Payment Due Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Payment Status", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Preferred Shipping Method", "Type", "Character", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Last Login Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Work Authorization Expiration", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));

	    return questions;
	}

	public static List<Map<String, String>> generateVendorQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();

	    // Existing questions
	    questions.add(Map.of("FieldName", "Vendor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Vendor ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Person", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Business Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Registration Number", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Onboarding", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Payment Terms", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

	    // Additional questions
	    questions.add(Map.of("FieldName", "Bank Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Account Number", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "SWIFT Code", "Type", "Character", "MaxLength", "11", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Tax ID", "Type", "Text Area", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Vendor Category", "Type", "Character", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Payment Method", "Type", "Character", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Credit Limit", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Currency", "Type", "Character", "MaxLength", "3", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contract Start Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contract End Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));

	    questions.add(Map.of("FieldName", "Service Level Agreement", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Vendor Rating", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Last Review Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Vendor Status", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Website", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "LinkedIn Profile", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Facebook Page", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Twitter Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Instagram Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Supplier Code", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));

	    questions.add(Map.of("FieldName", "Vendor Notes", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Annual Spend", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Last Payment Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Discount Rate", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Payment Terms", "Type", "Character", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Last Order Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Order History", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Shipping Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Billing Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Payment Due Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));

	    questions.add(Map.of("FieldName", "Payment Status", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Preferred Shipping Method", "Type", "Character", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Vendor Compliance", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Terms Accepted", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Marketing Opt-In", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Loyalty Program", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Last Login Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Vendor Satisfaction", "Type", "Number", "MaxLength", "1", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Reference", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"));

	    return questions;
	}


	public static List<Map<String, String>> generateCompanyQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    questions.add(Map.of("FieldName", "Company Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Company ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Industry", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Person", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Registration Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Tax ID", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Business Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Company Website", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "CEO Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Revenue", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Employee Count", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Headquarters Location", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Founding Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Stock Symbol", "Type", "Character", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Is Publicly Traded", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Annual Report Link", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "ISO Certification", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Number of Subsidiaries", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Corporate Social Responsibility", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Mission Statement", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Vision Statement", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Company Values", "Type", "Text Area", "MaxLength", "300", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Operating Income", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Gross Profit", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Net Profit", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Debt-to-Equity Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Operating Cash Flow", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Current Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Quick Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Operating Margin", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Return on Equity", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Return on Assets", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Earnings Per Share", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Dividend Yield", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Market Capitalization", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Price-to-Earnings Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Price-to-Book Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Enterprise Value", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Operating Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Cost of Goods Sold", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Research and Development", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Marketing Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Administrative Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Depreciation and Amortization", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Interest Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Net Income", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Shareholder Equity", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Total Assets", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Total Liabilities", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Operating Income Margin", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Net Profit Margin", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    return questions;
	}

	public static List<Map<String, String>> generateStudentQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    
	    // Existing questions
	    questions.add(Map.of("FieldName", "Student Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Student ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Gender", "Type", "Character", "MaxLength", "1", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Course", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Year of Study", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

	    // Additional questions
	    questions.add(Map.of("FieldName", "Middle Name", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Parent/Guardian Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Parent/Guardian Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Admission", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Scholarship Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Previous School", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Classroom", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Emergency Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Allergies", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Medical Conditions", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Extracurricular Activities", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact Relation", "Type", "Character", "MaxLength", "1", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Special Needs", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Contact Method", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Language Spoken", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Height", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Weight", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Medical History", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Parent/Guardian Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Preferred Name", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's ID Number", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Enrollment Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Course Duration", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Tuition Fee Paid", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Total Credits", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Graduation Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Profile Picture URL", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Current Grade", "Type", "Text Area", "MaxLength", "5", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Parent/Guardian Phone Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Hobbies", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Home Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Last Medical Checkup", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Learning Style", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Allergy Details", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Special Accommodations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Blood Group", "Type", "Character", "MaxLength", "3", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Student's Health Insurance Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Medical Information", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Preferred Contact Time", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Secondary Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Dietary Restrictions", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Date of Last Vaccination", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Social Media Profile", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Previous Achievements", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	
	    return questions;
	}
	

	public static List<Map<String, String>> generateTechEduQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();
	    
	    // Existing questions
	    questions.add(Map.of("FieldName", "Student Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Student ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Course Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Enrollment Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Grade", "Type", "Text Area", "MaxLength", "5", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Instructor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Semester", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Attendance", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Assignments Completed", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Extra-Curricular Activities", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));

	    // Additional questions
	    questions.add(Map.of("FieldName", "Student Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Course Start Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Course End Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Project Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Project Completion Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Technical Skills", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Soft Skills", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Final Grade", "Type", "Number", "MaxLength", "5", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Internship Completed", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Mentor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Mentor Contact", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Certification Received", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Certification Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Course Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Course Difficulty", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Study Hours Per Week", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Preferred Learning Style", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Attendance Percentage", "Type", "Number", "MaxLength", "5", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Homework Submitted", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Additional Certifications", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Strengths", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Weaknesses", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Extra Projects Completed", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Course Completion Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Project Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Exam Scores", "Type", "Number", "MaxLength", "5", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Group Projects Participation", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Scholarship Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Personal Projects", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Learning Resources Used", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Professional Development Courses", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Job Placement Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Research Papers Published", "Type", "Number", "MaxLength", "3", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Attendance in Workshops", "Type", "Number", "MaxLength", "3", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Project Report URL", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Mentor Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Career Goals", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Achievements", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Research Interests", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Professional Network", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Learning Goals", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Online Portfolio", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Skills Development Areas", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Previous Internship Experience", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Industry Certifications", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Professional Memberships", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Student's Career Aspirations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    
	    return questions;
	}


	public static List<Map<String, String>> generateMedicalQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();

	    // Existing questions
	    questions.add(Map.of("FieldName", "Patient Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Patient ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Gender", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Blood Type", "Type", "Text Area", "MaxLength", "5", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Allergies", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Medical History", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Current Medication", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Insurance Provider", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

	    // Additional questions
	    questions.add(Map.of("FieldName", "Primary Care Physician", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Physician Contact", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Previous Surgeries", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Chronic Conditions", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Family Medical History", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Emergency Contact Relationship", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Blood Pressure", "Type", "Number", "MaxLength", "7", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Height", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Weight", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Body Temperature", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Pulse Rate", "Type", "Number", "MaxLength", "3", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Respiratory Rate", "Type", "Number", "MaxLength", "3", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Smoking Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Alcohol Consumption", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Drug Use", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Immunizations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Recent Lab Tests", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Lab Test Results", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Health Insurance Policy Number", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Insurance Coverage Details", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Hospital Visits", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Allergic Reactions", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Dietary Restrictions", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Exercise Routine", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Sleep Patterns", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Mental Health Status", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Patient's Goals", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Patient's Concerns", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Travel History", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Recent Injuries", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Medical Devices Used", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Previous Diagnoses", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Specialist Consultations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Physical Therapy", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Occupational Therapy", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Speech Therapy", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Patient's Support System", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Patient's Coping Mechanisms", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Past Hospitalizations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Dietary Habits", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Health Screening Results", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Genetic Conditions", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Personal Health Goals", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Patient Preferences", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Healthcare Provider Recommendations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));

	    return questions;
	}
	
	public static List<Map<String, String>> generateCustomerSupportQuestions() {
	    List<Map<String, String>> questions = new ArrayList<>();

	    questions.add(Map.of("FieldName", "Customer Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Customer ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Phone Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Issue Description", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Date of Issue", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Priority Level", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Product/Service Affected", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Customer Feedback", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Resolution Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));

	    // Additional questions
	    questions.add(Map.of("FieldName", "Support Ticket ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Support Agent Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Resolution Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Follow-up Required", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Resolution Comments", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Satisfaction Score", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Issue Category", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Additional Notes", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Previous Issues", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer's Preferred Contact Method", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Response Time", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Resolution Time", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Escalation Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Next Steps", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer's Preferred Language", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Attachments Provided", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Follow-up Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Feedback Received", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Issue Severity", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Product/Service Version", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Issue Reported By", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
	    questions.add(Map.of("FieldName", "Customer's Preferred Resolution Time", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Support Method", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Resolution Time Target", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Follow-up Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Feedback Category", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Issue Resolution Process", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Escalation Process", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer's Contact Preferences", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Support Hours", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Training Needs", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Onboarding Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Technical Assistance Required", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Issue Resolution Summary", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Support Strategy", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer's Support Expectations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Interaction History", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Support Team Feedback", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Experience Rating", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Resolution Effectiveness", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Support Team Training Needs", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Customer Issue Trend", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));

	    // Adding HyperLink questions
	    questions.add(Map.of("FieldName", "Support Portal Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Documentation Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Knowledge Base Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "FAQ Page Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
	    questions.add(Map.of("FieldName", "Support Ticket Status Page", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));

	    return questions;
	}
	

}
