package Advaita_TDD.Advaita_TDD;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.advaita.BaseClass.TestBase;

public class Questions extends TestBase {

	public static List<Map<String, String>> generateEmployeeQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();

		// Existing questions
		questions.add(
				Map.of("FieldName", "Employee Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Employee ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Department", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Position", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Date of Joining", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Salary", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Phone Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

		// Additional Text Area questions
		questions.add(
				Map.of("FieldName", "Office Location", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Manager", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Work Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Home Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Spouse Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Contact Name", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Employee Status", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Work Authorization", "Type", "Text Area", "MaxLength", "50", "IsMandatory",
				"Yes"));
		questions.add(Map.of("FieldName", "Salary Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));

		// Additional HyperLink questions
		questions.add(Map.of("FieldName", "Website", "Type", "HyperLink", "MaxLength", "400", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "LinkedIn Profile", "Type", "HyperLink", "MaxLength", "400", "IsMandatory", "No"));

		// Additional boolean type questions
		questions.add(Map.of("FieldName", "Stock Options", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Retirement Plan", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Health Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Dental Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Vision Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Life Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Disability Insurance", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Employee Discount", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Tuition Reimbursement", "Type", "Boolean", "MaxLength", "10", "IsMandatory",
				"No"));
		questions
				.add(Map.of("FieldName", "Parking Benefit", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Public Transportation Benefit", "Type", "Boolean", "MaxLength", "10",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Remote Work Eligibility", "Type", "Boolean", "MaxLength", "10",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Flex Time Eligibility", "Type", "Boolean", "MaxLength", "10", "IsMandatory",
				"Yes"));
		questions.add(
				Map.of("FieldName", "Overtime Eligibility", "Type", "Boolean", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Marital Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));

		// Additional Number type questions
		questions.add(Map.of("FieldName", "Paid Time Off Balance", "Type", "Number", "MaxLength", "20", "IsMandatory",
				"Yes"));
		questions.add(
				Map.of("FieldName", "Sick Leave Balance", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Vacation Balance", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Hourly Rate", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Annual Salary", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Bonus", "Type", "Number", "MaxLength", "7", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Contact Phone", "Type", "Number", "MaxLength", "15", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Children", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Work Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Home Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Mobile Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));

		// Additional Character type questions
		questions.add(Map.of("FieldName", "Job Title", "Type", "Character", "MaxLength", "40", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Nationality", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Preferred Language", "Type", "Character", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Supervisor", "Type", "Character", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Emergency Contact Relation", "Type", "Character", "MaxLength", "40",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Ethnicity", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Blood Type", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Driving License Number", "Type", "Character", "MaxLength", "40",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Passport Number", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Contact Address", "Type", "Character", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Middle Name", "Type", "Character", "MaxLength", "40", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Gender", "Type", "Character", "MaxLength", "40", "IsMandatory", "Yes"));

		// Adding Date Time questions
		questions.add(
				Map.of("FieldName", "Hire Date and Time", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Last Review Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Contract Expiration Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Last Promotion Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Last Salary Increase Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Next Salary Review Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Onboarding Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Termination Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Offer Acceptance Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Background Check Date and Time", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Performance Review Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Last Salary Increase Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Next Salary Review Date", "Type", "Date Time", "MaxLength", "",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Hire Date", "Type", "Date Time", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Last Promotion Date", "Type", "Date Time", "MaxLength", "", "IsMandatory", "No"));

		return questions;
	}

	public static List<Map<String, String>> generateCustomerQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();

		// Existing questions
		questions.add(
				Map.of("FieldName", "Customer Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Customer ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Date of Registration", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Purchase History", "Type", "Text Area", "MaxLength", "300", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Loyalty Points", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));

		// Additional questions
		questions.add(Map.of("FieldName", "Preferred Language", "Type", "Text Area", "MaxLength", "50", "IsMandatory",
				"Yes"));
		questions.add(Map.of("FieldName", "Gender", "Type", "Character", "MaxLength", "1", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Marital Status", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Preferred Contact Time", "Type", "Date Time", "MaxLength", "", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Newsletter Subscription", "Type", "Boolean", "MaxLength", "", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Website", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "LinkedIn Profile", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Facebook Profile", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Twitter Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));

		questions.add(
				Map.of("FieldName", "Instagram Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Referral Source", "Type", "Character", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Spouse Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Number of Children", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Favorite Product", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Preferred Payment Method", "Type", "Character", "MaxLength", "30",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Preferred Contact Time", "Type", "Date Time", "MaxLength", "", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "VIP Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Discount Code", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Last Purchase Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));

		questions
				.add(Map.of("FieldName", "Account Balance", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Member Since", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Customer Notes", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Referral Bonus", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Promo Code Used", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Preferred Store", "Type", "Character", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Customer Satisfaction", "Type", "Number", "MaxLength", "1", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Transaction History", "Type", "Text Area", "MaxLength", "500", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Marketing Opt-In", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Terms Accepted", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));

		questions.add(Map.of("FieldName", "Loyalty Program", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Shipping Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Billing Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Payment Due Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Payment Status", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Preferred Shipping Method", "Type", "Character", "MaxLength", "30",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Last Login Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Work Authorization Expiration", "Type", "Date", "MaxLength", "",
				"IsMandatory", "Yes"));

		return questions;
	}

	public static List<Map<String, String>> generateVendorQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();

		// Existing questions
		questions.add(Map.of("FieldName", "Vendor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Vendor ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Contact Person", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Business Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Registration Number", "Type", "Text Area", "MaxLength", "20", "IsMandatory",
				"Yes"));
		questions.add(Map.of("FieldName", "Date of Onboarding", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions
				.add(Map.of("FieldName", "Payment Terms", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

		// Additional questions
		questions.add(Map.of("FieldName", "Bank Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Account Number", "Type", "Number", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "SWIFT Code", "Type", "Character", "MaxLength", "11", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Tax ID", "Type", "Text Area", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Vendor Category", "Type", "Character", "MaxLength", "30", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Payment Method", "Type", "Character", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Credit Limit", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Preferred Currency", "Type", "Character", "MaxLength", "3", "IsMandatory", "Yes"));
		questions
				.add(Map.of("FieldName", "Contract Start Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Contract End Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));

		questions.add(Map.of("FieldName", "Service Level Agreement", "Type", "Text Area", "MaxLength", "200",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Vendor Rating", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Last Review Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Vendor Status", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Website", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "LinkedIn Profile", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Facebook Page", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Twitter Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Instagram Handle", "Type", "Character", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Supplier Code", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));

		questions
				.add(Map.of("FieldName", "Vendor Notes", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Annual Spend", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Last Payment Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Discount Rate", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Preferred Payment Terms", "Type", "Character", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Last Order Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Order History", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Shipping Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Billing Address", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Payment Due Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));

		questions.add(
				Map.of("FieldName", "Payment Status", "Type", "Character", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Preferred Shipping Method", "Type", "Character", "MaxLength", "30",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Vendor Compliance", "Type", "Text Area", "MaxLength", "250", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Terms Accepted", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Marketing Opt-In", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Loyalty Program", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Last Login Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Vendor Satisfaction", "Type", "Number", "MaxLength", "1", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Reference", "Type", "Text Area", "MaxLength", "250", "IsMandatory",
				"No"));

		return questions;
	}

	public static List<Map<String, String>> generateCompanyQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();
		questions
				.add(Map.of("FieldName", "Company Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Company ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Industry", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Contact Person", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Registration Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Tax ID", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Business Type", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Company Website", "Type", "HyperLink", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "CEO Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Revenue", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Employee Count", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Headquarters Location", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Founding Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Stock Symbol", "Type", "Character", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Is Publicly Traded", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Annual Report Link", "Type", "HyperLink", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "ISO Certification", "Type", "Character", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Number of Subsidiaries", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Corporate Social Responsibility", "Type", "Text Area", "MaxLength", "200",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Mission Statement", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Vision Statement", "Type", "Text Area", "MaxLength", "500", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Company Values", "Type", "Text Area", "MaxLength", "300", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Operating Income", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Gross Profit", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Net Profit", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Debt-to-Equity Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Operating Cash Flow", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Current Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Quick Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Operating Margin", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Return on Equity", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Return on Assets", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Earnings Per Share", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Dividend Yield", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Market Capitalization", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Price-to-Earnings Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "Price-to-Book Ratio", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Enterprise Value", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Operating Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Cost of Goods Sold", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Research and Development", "Type", "Number", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Marketing Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Administrative Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Depreciation and Amortization", "Type", "Number", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Interest Expenses", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Net Income", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Shareholder Equity", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Total Assets", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Total Liabilities", "Type", "Number", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Operating Income Margin", "Type", "Number", "MaxLength", "10", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "Net Profit Margin", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		return questions;
	}

	public static List<Map<String, String>> generateStudentQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();

		// Existing questions
		questions
				.add(Map.of("FieldName", "Student Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Student ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Gender", "Type", "Character", "MaxLength", "1", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Course", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Year of Study", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Contact Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

		// Additional questions
		questions.add(Map.of("FieldName", "Middle Name", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Parent/Guardian Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory",
				"Yes"));
		questions.add(Map.of("FieldName", "Parent/Guardian Contact Number", "Type", "Number", "MaxLength", "15",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Date of Admission", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Scholarship Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Previous School", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Classroom", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Emergency Contact Number", "Type", "Number", "MaxLength", "15",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Allergies", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Medical Conditions", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Extracurricular Activities", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Contact Relation", "Type", "Character", "MaxLength", "1",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Special Needs", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Preferred Contact Method", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Language Spoken", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Height", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Weight", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Medical History", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Contact Address", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Parent/Guardian Email", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Preferred Name", "Type", "Text Area", "MaxLength", "30",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Student's ID Number", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Enrollment Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Course Duration", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Tuition Fee Paid", "Type", "Number", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Total Credits", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Graduation Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Profile Picture URL", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Contact Phone", "Type", "Number", "MaxLength", "15", "IsMandatory",
				"No"));
		questions
				.add(Map.of("FieldName", "Current Grade", "Type", "Text Area", "MaxLength", "5", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Parent/Guardian Phone Number", "Type", "Number", "MaxLength", "15",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Hobbies", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Home Address", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Date of Last Medical Checkup", "Type", "Date", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Preferred Learning Style", "Type", "Text Area", "MaxLength", "30",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Emergency Contact", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Allergy Details", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Special Accommodations", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Blood Group", "Type", "Character", "MaxLength", "3", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Student's Health Insurance Number", "Type", "Number", "MaxLength", "15",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Medical Information", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Preferred Contact Time", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Secondary Email", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Dietary Restrictions", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Date of Last Vaccination", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Social Media Profile", "Type", "HyperLink", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Previous Achievements", "Type", "Text Area", "MaxLength", "200",
				"IsMandatory", "No"));

		return questions;
	}

	public static List<Map<String, String>> generateTechEduQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();

		// Existing questions
		questions
				.add(Map.of("FieldName", "Student Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Student ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Course Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Enrollment Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Grade", "Type", "Text Area", "MaxLength", "5", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Instructor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Semester", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Attendance", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Assignments Completed", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Extra-Curricular Activities", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));

		// Additional questions
		questions
				.add(Map.of("FieldName", "Student Email", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student Phone", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Course Start Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Course End Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Project Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Project Completion Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Technical Skills", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Soft Skills", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Final Grade", "Type", "Number", "MaxLength", "5", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Internship Completed", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Mentor Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Mentor Contact", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Certification Received", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Certification Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Course Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Course Difficulty", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Study Hours Per Week", "Type", "Number", "MaxLength", "2", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Preferred Learning Style", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Attendance Percentage", "Type", "Number", "MaxLength", "5", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Homework Submitted", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Additional Certifications", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Strengths", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Student's Weaknesses", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Extra Projects Completed", "Type", "Number", "MaxLength", "5", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "Course Completion Date", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Project Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Exam Scores", "Type", "Number", "MaxLength", "5", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Group Projects Participation", "Type", "Boolean", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Scholarship Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Personal Projects", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Learning Resources Used", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Professional Development Courses", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Job Placement Status", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Research Papers Published", "Type", "Number", "MaxLength", "3",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Attendance in Workshops", "Type", "Number", "MaxLength", "3", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "Project Report URL", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Mentor Feedback", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Career Goals", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Achievements", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Research Interests", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Professional Network", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Learning Goals", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Online Portfolio", "Type", "HyperLink", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Skills Development Areas", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Previous Internship Experience", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Industry Certifications", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Professional Memberships", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Student's Career Aspirations", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));

		return questions;
	}

	public static List<Map<String, String>> generateMedicalQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();

		// Existing questions
		questions
				.add(Map.of("FieldName", "Patient Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Patient ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Date of Birth", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Gender", "Type", "Text Area", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Blood Type", "Type", "Text Area", "MaxLength", "5", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Allergies", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Medical History", "Type", "Text Area", "MaxLength", "200", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Current Medication", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "Emergency Contact", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Insurance Provider", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));

		// Additional questions
		questions.add(Map.of("FieldName", "Primary Care Physician", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Physician Contact", "Type", "Number", "MaxLength", "15", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Previous Surgeries", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Chronic Conditions", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Family Medical History", "Type", "Text Area", "MaxLength", "200",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Emergency Contact Relationship", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Blood Pressure", "Type", "Number", "MaxLength", "7", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Height", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Weight", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Body Temperature", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Pulse Rate", "Type", "Number", "MaxLength", "3", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Respiratory Rate", "Type", "Number", "MaxLength", "3", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Smoking Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Alcohol Consumption", "Type", "Text Area", "MaxLength", "20", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Drug Use", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Immunizations", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Recent Lab Tests", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Lab Test Results", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Health Insurance Policy Number", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Insurance Coverage Details", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Hospital Visits", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Allergic Reactions", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Dietary Restrictions", "Type", "Text Area", "MaxLength", "50", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "Exercise Routine", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Sleep Patterns", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Mental Health Status", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Patient's Goals", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Patient's Concerns", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(
				Map.of("FieldName", "Travel History", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Recent Injuries", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Medical Devices Used", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Previous Diagnoses", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Specialist Consultations", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Physical Therapy", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Occupational Therapy", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Speech Therapy", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Patient's Support System", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Patient's Coping Mechanisms", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Past Hospitalizations", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Dietary Habits", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Health Screening Results", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Genetic Conditions", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Personal Health Goals", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Patient Preferences", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Healthcare Provider Recommendations", "Type", "Text Area", "MaxLength",
				"100", "IsMandatory", "No"));

		return questions;
	}

	public static List<Map<String, String>> generateCustomerSupportQuestions() {
		List<Map<String, String>> questions = new ArrayList<>();

		questions.add(
				Map.of("FieldName", "Customer Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Customer ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Email Address", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Phone Number", "Type", "Number", "MaxLength", "15", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Issue Description", "Type", "Text Area", "MaxLength", "200", "IsMandatory",
				"Yes"));
		questions.add(Map.of("FieldName", "Date of Issue", "Type", "Date", "MaxLength", "", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Priority Level", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Product/Service Affected", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Customer Feedback", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Resolution Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));

		// Additional questions
		questions.add(
				Map.of("FieldName", "Support Ticket ID", "Type", "Number", "MaxLength", "10", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Support Agent Name", "Type", "Text Area", "MaxLength", "50", "IsMandatory",
				"Yes"));
		questions.add(
				Map.of("FieldName", "Resolution Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Follow-up Required", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Resolution Comments", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Customer Satisfaction Score", "Type", "Number", "MaxLength", "5",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Issue Category", "Type", "Text Area", "MaxLength", "30", "IsMandatory", "Yes"));
		questions.add(
				Map.of("FieldName", "Additional Notes", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Previous Issues", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer's Preferred Contact Method", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Response Time", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Resolution Time", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Escalation Status", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Next Steps", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer's Preferred Language", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Attachments Provided", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Follow-up Date", "Type", "Date", "MaxLength", "", "IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Feedback Received", "Type", "Boolean", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Issue Severity", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Product/Service Version", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Issue Reported By", "Type", "Text Area", "MaxLength", "50", "IsMandatory", "Yes"));
		questions.add(Map.of("FieldName", "Customer's Preferred Resolution Time", "Type", "Text Area", "MaxLength",
				"20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Support Method", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Resolution Time Target", "Type", "Number", "MaxLength", "5", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Follow-up Status", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Feedback Category", "Type", "Text Area", "MaxLength", "30",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Issue Resolution Process", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Escalation Process", "Type", "Text Area", "MaxLength", "100", "IsMandatory",
				"No"));
		questions.add(Map.of("FieldName", "Customer's Contact Preferences", "Type", "Text Area", "MaxLength", "50",
				"IsMandatory", "No"));
		questions
				.add(Map.of("FieldName", "Support Hours", "Type", "Text Area", "MaxLength", "20", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Training Needs", "Type", "Text Area", "MaxLength", "100", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Onboarding Status", "Type", "Text Area", "MaxLength", "20",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Technical Assistance Required", "Type", "Boolean", "MaxLength", "",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Issue Resolution Summary", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Support Strategy", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer's Support Expectations", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Interaction History", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Support Team Feedback", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Experience Rating", "Type", "Number", "MaxLength", "5",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Resolution Effectiveness", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Support Team Training Needs", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Customer Issue Trend", "Type", "Text Area", "MaxLength", "100",
				"IsMandatory", "No"));

		// Adding HyperLink questions
		questions.add(
				Map.of("FieldName", "Support Portal Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Documentation Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
		questions.add(
				Map.of("FieldName", "Knowledge Base Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "FAQ Page Link", "Type", "HyperLink", "MaxLength", "", "IsMandatory", "No"));
		questions.add(Map.of("FieldName", "Support Ticket Status Page", "Type", "HyperLink", "MaxLength", "",
				"IsMandatory", "No"));

		return questions;
	}

//	$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	public static Map.Entry<String, List<String>> generateGenuineQuestionAndOptionsForRadioButton(int questionIndex,
	        boolean randomizeOrder) {
	    // Define a map of genuine questions with corresponding options for radio buttons
	    Map<String, List<String>> questionsAndOptions = new LinkedHashMap<>();

	    // Define questions with corresponding radio button options
	    questionsAndOptions.put("What is your favorite color?",
	            Arrays.asList("Red", "Blue", "Green", "Yellow", "Pink"));
	    questionsAndOptions.put("Select your country of residence?",
	            Arrays.asList("United States", "Canada", "India", "Australia"));
	    questionsAndOptions.put("Choose your preferred contact method?",
	            Arrays.asList("Email", "Phone", "Text Message", "In-Person"));
	    questionsAndOptions.put("Select your highest level of education?",
	            Arrays.asList("High School", "Bachelor's", "Master's", "PhD"));
	    questionsAndOptions.put("What type of vehicle do you own?",
	            Arrays.asList("Car", "Motorcycle", "Bicycle", "None"));
	    questionsAndOptions.put("Which language do you speak fluently?",
	            Arrays.asList("English", "Spanish", "Mandarin", "French"));
	    questionsAndOptions.put("What is your favorite season?",
	            Arrays.asList("Spring", "Summer", "Autumn", "Winter"));
	    questionsAndOptions.put("Choose your preferred social media platform?",
	            Arrays.asList("Facebook", "Instagram", "Twitter", "LinkedIn"));
	    questionsAndOptions.put("Select your favorite genre of music?",
	            Arrays.asList("Pop", "Rock", "Classical", "Jazz", "Hip-Hop"));
	    questionsAndOptions.put("What type of smartphone do you use?",
	            Arrays.asList("iPhone", "Android", "Other", "None"));
	    questionsAndOptions.put("What is your primary mode of transportation?",
	            Arrays.asList("Car", "Bus", "Bicycle", "Walking"));
	    questionsAndOptions.put("Which continent have you traveled to the most?",
	            Arrays.asList("Asia", "Europe", "North America", "Africa"));
	    questionsAndOptions.put("What is your preferred beverage?",
	            Arrays.asList("Tea", "Coffee", "Juice", "Water", "Soda"));
	    questionsAndOptions.put("Which pet do you own?",
	            Arrays.asList("Dog", "Cat", "Bird", "Fish", "None"));
	    questionsAndOptions.put("What is your preferred type of cuisine?",
	            Arrays.asList("Italian", "Chinese", "Indian", "Mexican", "Japanese"));
	    questionsAndOptions.put("Which sport do you enjoy watching?",
	            Arrays.asList("Football", "Basketball", "Tennis", "Cricket", "Soccer"));
	    questionsAndOptions.put("What is your favorite type of movie?",
	            Arrays.asList("Action", "Comedy", "Drama", "Horror", "Romantic"));
	    questionsAndOptions.put("Choose your preferred method of exercise?",
	            Arrays.asList("Running", "Cycling", "Swimming", "Yoga", "Weightlifting"));
	    questionsAndOptions.put("What is your preferred type of holiday?",
	            Arrays.asList("Beach", "Mountain", "City", "Countryside"));
	    questionsAndOptions.put("Which time of day are you most productive?",
	            Arrays.asList("Morning", "Afternoon", "Evening", "Night"));
	    questionsAndOptions.put("Which subject did you enjoy the most in school?",
	            Arrays.asList("Math", "Science", "History", "Literature"));
	    questionsAndOptions.put("What is your preferred mode of learning?",
	            Arrays.asList("Online", "In-person", "Hybrid"));
	    questionsAndOptions.put("What type of books do you like to read?",
	            Arrays.asList("Fiction", "Non-fiction", "Mystery", "Biography", "Science Fiction"));
	    questionsAndOptions.put("Which musical instrument do you play?",
	            Arrays.asList("Guitar", "Piano", "Drums", "Violin", "None"));
	    questionsAndOptions.put("What is your favorite type of weather?",
	            Arrays.asList("Sunny", "Rainy", "Snowy", "Windy"));
	    questionsAndOptions.put("What type of accommodation do you prefer while traveling?",
	            Arrays.asList("Hotel", "Hostel", "Airbnb", "Camping"));
	    questionsAndOptions.put("What type of art do you enjoy the most?",
	            Arrays.asList("Painting", "Sculpture", "Photography", "Digital Art"));
	    questionsAndOptions.put("Which gaming platform do you use?",
	            Arrays.asList("PC", "PlayStation", "Xbox", "Nintendo Switch", "Mobile"));
	    questionsAndOptions.put("What is your preferred way to spend a weekend?",
	            Arrays.asList("Traveling", "Relaxing at home", "Going out with friends", "Engaging in a hobby"));
	    questionsAndOptions.put("Which genre of TV shows do you watch the most?",
	            Arrays.asList("Drama", "Comedy", "Thriller", "Documentary", "Reality TV"));
	    questionsAndOptions.put("What is your favorite animal?",
	            Arrays.asList("Dog", "Cat", "Horse", "Elephant", "Lion"));
	    questionsAndOptions.put("What type of computer do you use?",
	            Arrays.asList("Desktop", "Laptop", "Tablet", "None"));
	    questionsAndOptions.put("What is your favorite form of entertainment?",
	            Arrays.asList("Movies", "Music", "Video Games", "Books"));
	    questionsAndOptions.put("Which of these careers would you choose?",
	            Arrays.asList("Doctor", "Engineer", "Teacher", "Artist", "Scientist"));
	    questionsAndOptions.put("What is your preferred working environment?",
	            Arrays.asList("Office", "Remote", "Hybrid"));
	    questionsAndOptions.put("Which type of restaurant do you frequent?",
	            Arrays.asList("Fast Food", "Fine Dining", "Casual Dining", "Street Food"));
	    questionsAndOptions.put("What type of TV do you own?",
	            Arrays.asList("LED", "OLED", "QLED", "None"));
	    questionsAndOptions.put("Which type of home do you live in?",
	            Arrays.asList("Apartment", "House", "Condo", "Townhouse"));
	    questionsAndOptions.put("What is your preferred way to spend your free time?",
	            Arrays.asList("Reading", "Watching TV", "Outdoor activities", "Socializing"));
	    questionsAndOptions.put("Which is your favorite fruit?",
	            Arrays.asList("Apple", "Banana", "Grapes", "Orange", "Mango"));
	    questionsAndOptions.put("What type of exercise do you prefer?",
	            Arrays.asList("Cardio", "Strength Training", "Yoga", "Pilates"));
	    questionsAndOptions.put("Which genre of podcasts do you listen to?",
	            Arrays.asList("True Crime", "Comedy", "Education", "News", "Health"));
	    questionsAndOptions.put("What is your favorite dessert?",
	            Arrays.asList("Ice Cream", "Cake", "Cookies", "Brownies", "Pie"));
	    questionsAndOptions.put("What type of work schedule do you prefer?",
	            Arrays.asList("Full-time", "Part-time", "Freelance", "Contract"));
	    questionsAndOptions.put("Which type of vacation do you prefer?",
	            Arrays.asList("Solo", "Family", "Adventure", "Relaxation"));
	    questionsAndOptions.put("Which kind of computer software do you use the most?",
	            Arrays.asList("Productivity", "Entertainment", "Development", "Design"));
	    questionsAndOptions.put("What type of games do you prefer?",
	            Arrays.asList("Board Games", "Card Games", "Video Games", "Sports"));

	    // If the question index is larger than the available questions, loop around
	    List<String> keys = new ArrayList<>(questionsAndOptions.keySet());

	    if (randomizeOrder) {
	        Collections.shuffle(keys);
	    }

	    String question = keys.get(questionIndex % keys.size());
	    List<String> options = questionsAndOptions.get(question);

	    return new AbstractMap.SimpleEntry<>(question, options);
	}

	
	public static Map.Entry<String, List<String>> generateGenuineQuestionAndOptionsForDropDown(int questionIndex,
			boolean randomizeOrder) {
		// Define a map of genuine questions with corresponding options
		Map<String, List<String>> questionsAndOptions = new LinkedHashMap<>();

		questionsAndOptions.put("What is your favorite color?",
				Arrays.asList("Red", "Blue", "Green", "Yellow", "Pink"));
		questionsAndOptions.put("Select your country of residence?",
				Arrays.asList("United States", "Canada", "India", "Australia"));
		questionsAndOptions.put("Choose your preferred contact method?",
				Arrays.asList("Email", "Phone", "Text Message", "In-Person"));
		questionsAndOptions.put("Select your highest level of education?",
				Arrays.asList("High School", "Bachelor's", "Master's", "PhD"));
		questionsAndOptions.put("What type of vehicle do you own?",
				Arrays.asList("Car", "Motorcycle", "Bicycle", "None"));
		questionsAndOptions.put("Which language do you speak fluently?",
				Arrays.asList("English", "Spanish", "Mandarin", "French"));
		questionsAndOptions.put("What is your favorite season?", Arrays.asList("Spring", "Summer", "Autumn", "Winter"));
		questionsAndOptions.put("Choose your preferred social media platform?",
				Arrays.asList("Facebook", "Instagram", "Twitter", "LinkedIn"));
		questionsAndOptions.put("Select your favorite genre of music?",
				Arrays.asList("Pop", "Rock", "Classical", "Jazz", "Hip-Hop"));
		questionsAndOptions.put("What type of smartphone do you use?",
				Arrays.asList("iPhone", "Android", "Other", "None"));
		questionsAndOptions.put("What is your primary mode of transportation?",
				Arrays.asList("Car", "Bus", "Bicycle", "Walking"));
		questionsAndOptions.put("Which continent have you traveled to the most?",
				Arrays.asList("Asia", "Europe", "North America", "Africa"));
		questionsAndOptions.put("What is your preferred beverage?",
				Arrays.asList("Tea", "Coffee", "Juice", "Water", "Soda"));
		questionsAndOptions.put("Which pet do you own?", Arrays.asList("Dog", "Cat", "Bird", "Fish", "None"));
		questionsAndOptions.put("What is your preferred type of cuisine?",
				Arrays.asList("Italian", "Chinese", "Indian", "Mexican", "Japanese"));
		questionsAndOptions.put("Which sport do you enjoy watching?",
				Arrays.asList("Football", "Basketball", "Tennis", "Cricket", "Soccer"));
		questionsAndOptions.put("What is your favorite type of movie?",
				Arrays.asList("Action", "Comedy", "Drama", "Horror", "Romantic"));
		questionsAndOptions.put("Choose your preferred method of exercise?",
				Arrays.asList("Running", "Cycling", "Swimming", "Yoga", "Weightlifting"));
		questionsAndOptions.put("What is your preferred type of holiday?",
				Arrays.asList("Beach", "Mountain", "City", "Countryside"));
		questionsAndOptions.put("Which time of day are you most productive?",
				Arrays.asList("Morning", "Afternoon", "Evening", "Night"));
		questionsAndOptions.put("Which subject did you enjoy the most in school?",
				Arrays.asList("Math", "Science", "History", "Literature"));
		questionsAndOptions.put("What is your preferred mode of learning?",
				Arrays.asList("Online", "In-person", "Hybrid"));
		questionsAndOptions.put("What type of books do you like to read?",
				Arrays.asList("Fiction", "Non-fiction", "Mystery", "Biography", "Science Fiction"));
		questionsAndOptions.put("Which musical instrument do you play?",
				Arrays.asList("Guitar", "Piano", "Drums", "Violin", "None"));
		questionsAndOptions.put("What is your favorite type of weather?",
				Arrays.asList("Sunny", "Rainy", "Snowy", "Windy"));
		questionsAndOptions.put("What type of accommodation do you prefer while traveling?",
				Arrays.asList("Hotel", "Hostel", "Airbnb", "Camping"));
		questionsAndOptions.put("What type of art do you enjoy the most?",
				Arrays.asList("Painting", "Sculpture", "Photography", "Digital Art"));
		questionsAndOptions.put("Which gaming platform do you use?",
				Arrays.asList("PC", "PlayStation", "Xbox", "Nintendo Switch", "Mobile"));
		questionsAndOptions.put("What is your preferred way to spend a weekend?",
				Arrays.asList("Traveling", "Relaxing at home", "Going out with friends", "Engaging in a hobby"));
		questionsAndOptions.put("Which genre of TV shows do you watch the most?",
				Arrays.asList("Drama", "Comedy", "Thriller", "Documentary", "Reality TV"));
		questionsAndOptions.put("What is your favorite animal?",
				Arrays.asList("Dog", "Cat", "Horse", "Elephant", "Lion"));
		questionsAndOptions.put("What type of computer do you use?",
				Arrays.asList("Desktop", "Laptop", "Tablet", "None"));
		questionsAndOptions.put("What is your favorite form of entertainment?",
				Arrays.asList("Movies", "Music", "Video Games", "Books"));
		questionsAndOptions.put("Which of these careers would you choose?",
				Arrays.asList("Doctor", "Engineer", "Teacher", "Artist", "Scientist"));
		questionsAndOptions.put("What is your preferred working environment?",
				Arrays.asList("Office", "Remote", "Hybrid"));
		questionsAndOptions.put("Which type of restaurant do you frequent?",
				Arrays.asList("Fast Food", "Fine Dining", "Casual Dining", "Street Food"));
		questionsAndOptions.put("What type of TV do you own?", Arrays.asList("LED", "OLED", "QLED", "None"));
		questionsAndOptions.put("Which type of home do you live in?",
				Arrays.asList("Apartment", "House", "Condo", "Townhouse"));
		questionsAndOptions.put("What is your preferred way to spend your free time?",
				Arrays.asList("Reading", "Watching TV", "Outdoor activities", "Socializing"));
		questionsAndOptions.put("Which is your favorite fruit?",
				Arrays.asList("Apple", "Banana", "Grapes", "Orange", "Mango"));
		questionsAndOptions.put("What type of exercise do you prefer?",
				Arrays.asList("Cardio", "Strength Training", "Yoga", "Pilates"));
		questionsAndOptions.put("Which genre of podcasts do you listen to?",
				Arrays.asList("True Crime", "Comedy", "Education", "News", "Health"));
		questionsAndOptions.put("What is your favorite dessert?",
				Arrays.asList("Ice Cream", "Cake", "Cookies", "Brownies", "Pie"));
		questionsAndOptions.put("What type of work schedule do you prefer?",
				Arrays.asList("Full-time", "Part-time", "Freelance", "Contract"));
		questionsAndOptions.put("Which type of vacation do you prefer?",
				Arrays.asList("Solo", "Family", "Adventure", "Relaxation"));
		questionsAndOptions.put("Which kind of computer software do you use the most?",
				Arrays.asList("Productivity", "Entertainment", "Development", "Design"));
		questionsAndOptions.put("What type of games do you prefer?",
				Arrays.asList("Board Games", "Card Games", "Video Games", "Sports"));

		// If the question index is larger than the available questions, loop around
		List<String> keys = new ArrayList<>(questionsAndOptions.keySet());

		if (randomizeOrder) {
			Collections.shuffle(keys);
		}

		String question = keys.get(questionIndex % keys.size());
		List<String> options = questionsAndOptions.get(question);

		return new AbstractMap.SimpleEntry<>(question, options);
	}

	// Method to generate genuine Text Box questions and inputs
	public static Map.Entry<String, String[]> generateGenuineTextBoxQuestionAndInputs(int questionIndex,
			boolean randomizeOrder) {
		// Define a map of genuine text box questions with corresponding input
		// configurations
		Map<String, String[]> textBoxQuestionsAndInputs = new LinkedHashMap<>();

		// Define questions and corresponding input attributes (minLength, maxLength,
		// expectedDefaultOption, typeOfValue)
		textBoxQuestionsAndInputs.put("What is your full name?", new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your email address", new String[] { "5", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your phone number", new String[] { "10", "14", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("Enter your address", new String[] { "5", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your postal code", new String[] { "5", "10", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("Enter your date of birth (DD/MM/YYYY)",
				new String[] { "10", "10", "All", "All" });
		textBoxQuestionsAndInputs.put("What is your job title?", new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your company name?", new String[] { "3", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your highest level of education?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your passport number", new String[] { "9", "9", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your driving license number",
				new String[] { "8", "15", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your employee ID", new String[] { "5", "10", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your mother's maiden name?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your emergency contact name",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your emergency contact phone number",
				new String[] { "10", "14", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("Enter your emergency contact email",
				new String[] { "5", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your relationship with the emergency contact?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your marital status?", new String[] { "3", "15", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your spouse's name", new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your number of dependents",
				new String[] { "1", "2", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("What is your nationality?", new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your tax identification number",
				new String[] { "10", "15", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your health insurance number",
				new String[] { "10", "15", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your car registration number",
				new String[] { "6", "12", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your bank account number",
				new String[] { "5", "20", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("Enter your credit card number",
				new String[] { "16", "16", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("What is your favorite color?", new String[] { "3", "20", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your favorite hobby?", new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your favorite book?", new String[] { "3", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your favorite movie?", new String[] { "3", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your favorite sports team?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your favorite food?", new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your social security number",
				new String[] { "9", "9", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("What is your current salary?", new String[] { "4", "10", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("What is your expected salary?",
				new String[] { "4", "10", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("What is your preferred working location?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your LinkedIn profile URL",
				new String[] { "10", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your GitHub profile URL",
				new String[] { "10", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What languages do you speak?", new String[] { "3", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your preferred method of communication?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter the number of years of experience you have",
				new String[] { "1", "2", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("Enter the number of years you have worked at your current company",
				new String[] { "1", "2", "All", "Only Number" });
		textBoxQuestionsAndInputs.put("What is your department at the company?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your supervisor's name?",
				new String[] { "3", "50", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("Enter your employee start date", new String[] { "10", "10", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your primary job responsibility?",
				new String[] { "5", "100", "All", "Only Text" });
		textBoxQuestionsAndInputs.put("What is your secondary job responsibility?",
				new String[] { "5", "100", "All", "Only Text" });

		// If the question index is larger than the available questions, loop around
		List<String> keys = new ArrayList<>(textBoxQuestionsAndInputs.keySet());

		if (randomizeOrder) {
			Collections.shuffle(keys);
		}

		String question = keys.get(questionIndex % keys.size());
		String[] inputs = textBoxQuestionsAndInputs.get(question);

		return new AbstractMap.SimpleEntry<>(question, inputs);
	}

	// Method to generate genuine Short Answer questions and inputs
	public static Map.Entry<String, String[]> generateGenuineShortAnswerQuestionAndInputs(int questionIndex,
			boolean randomizeOrder) {
		// Define a map of genuine short answer questions with corresponding input
		// configurations
		Map<String, String[]> shortAnswerQuestionsAndInputs = new LinkedHashMap<>();

		// Define questions and corresponding input attributes (minLength, maxLength,
		// expectedDefaultOption, typeOfValue)
		shortAnswerQuestionsAndInputs.put("What is your nickname?", new String[] { "2", "15", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your country code", new String[] { "2", "5", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your favorite color", new String[] { "3", "15", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your birth year?", new String[] { "4", "4", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("What is your preferred username?",
				new String[] { "5", "20", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your postal code?",
				new String[] { "5", "10", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("What is your middle name?", new String[] { "1", "20", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your age", new String[] { "1", "3", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("What is your favorite fruit?",
				new String[] { "3", "15", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your employee ID?", new String[] { "5", "10", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your department code",
				new String[] { "2", "5", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter the current month number",
				new String[] { "1", "2", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your building number",
				new String[] { "1", "5", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your office extension",
				new String[] { "3", "5", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("What is your favorite pet's name?",
				new String[] { "2", "15", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your street number", new String[] { "1", "6", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your driving license number",
				new String[] { "5", "12", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your preferred currency symbol",
				new String[] { "1", "3", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your current year of study?",
				new String[] { "1", "2", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your apartment number",
				new String[] { "1", "5", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("What is your vehicle registration number?",
				new String[] { "6", "10", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your tax identification number",
				new String[] { "8", "15", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("What is your bank account number?",
				new String[] { "10", "20", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your student ID", new String[] { "5", "10", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your library card number?",
				new String[] { "5", "15", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your insurance policy number?",
				new String[] { "6", "20", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your blood group", new String[] { "2", "3", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your height (in cm)?",
				new String[] { "2", "3", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("What is your favorite movie?",
				new String[] { "3", "30", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your favorite book title",
				new String[] { "5", "50", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your Twitter handle", new String[] { "3", "15", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your Github username?",
				new String[] { "3", "15", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your favorite sport", new String[] { "3", "20", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your shoe size?", new String[] { "1", "2", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter the last 4 digits of your phone number",
				new String[] { "4", "4", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your gym membership number",
				new String[] { "5", "10", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your favorite TV show?",
				new String[] { "3", "30", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your favorite food?",
				new String[] { "3", "20", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your favorite hobby", new String[] { "3", "25", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your favorite vacation destination?",
				new String[] { "3", "50", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter your preferred airline",
				new String[] { "3", "20", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("Enter the make of your car", new String[] { "3", "20", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your zip code?", new String[] { "5", "10", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your membership level",
				new String[] { "3", "10", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your social security number?",
				new String[] { "9", "9", "All", "Only Number" });
		shortAnswerQuestionsAndInputs.put("Enter your emergency contact's name",
				new String[] { "2", "30", "All", "Only Text" });
		shortAnswerQuestionsAndInputs.put("What is your mother's maiden name?",
				new String[] { "2", "30", "All", "Only Text" });

		// If the question index is larger than the available questions, loop around
		List<String> keys = new ArrayList<>(shortAnswerQuestionsAndInputs.keySet());

		if (randomizeOrder) {
			Collections.shuffle(keys);
		}

		String question = keys.get(questionIndex % keys.size());
		String[] inputs = shortAnswerQuestionsAndInputs.get(question);

		return new AbstractMap.SimpleEntry<>(question, inputs);
	}
	
	public static Map.Entry<String, String[]> generateGenuineLabelQuestion(int questionIndex, boolean randomizeOrder) {
	    // Define a map of genuine label questions
	    Map<String, String[]> labelQuestions = new LinkedHashMap<>();

	    // Define label-related questions (no input configurations needed)
	    labelQuestions.put("What label do you use for your work files?", new String[]{});
	    labelQuestions.put("What is the label of your favorite folder?", new String[]{});
	    labelQuestions.put("Enter the label for your recent project?", new String[]{});
	    labelQuestions.put("What label do you give your personal documents?", new String[]{});
	    labelQuestions.put("What label do you use for your family photos?", new String[]{});
	    labelQuestions.put("What label do you use for your financial documents?", new String[]{});
	    labelQuestions.put("What label did you use for your last purchase order?", new String[]{});
	    labelQuestions.put("What label do you assign to your urgent tasks?", new String[]{});
	    labelQuestions.put("What is the label for your travel documents?", new String[]{});
	    labelQuestions.put("What label do you give to your archived files?", new String[]{});
	    labelQuestions.put("Enter the label for your household expenses folder?", new String[]{});
	    labelQuestions.put("What label do you give your workout plans?", new String[]{});
	    labelQuestions.put("What label did you use for your holiday planning?", new String[]{});
	    labelQuestions.put("What label do you give to your research notes?", new String[]{});
	    labelQuestions.put("Enter the label for your client reports?", new String[]{});
	    labelQuestions.put("What label do you give your recent presentations?", new String[]{});
	    labelQuestions.put("What label do you use for your meeting notes?", new String[]{});
	    labelQuestions.put("Enter the label for your completed tasks?", new String[]{});
	    labelQuestions.put("What label do you use for your reading list?", new String[]{});
	    labelQuestions.put("What label did you use for your study materials?", new String[]{});
	    labelQuestions.put("What label do you give your important emails?", new String[]{});
	    labelQuestions.put("What label do you give to your favorite music playlist?", new String[]{});
	    labelQuestions.put("What label do you assign to your recipes collection?", new String[]{});
	    labelQuestions.put("Enter the label for your recent invoices?", new String[]{});
	    labelQuestions.put("What label do you give to your insurance documents?", new String[]{});
	    labelQuestions.put("What label do you assign to your creative projects?", new String[]{});
	    labelQuestions.put("What label do you use for your tax-related documents?", new String[]{});
	    labelQuestions.put("What label do you give to your job applications?", new String[]{});
	    labelQuestions.put("What label do you use for your ongoing work tasks?", new String[]{});
	    labelQuestions.put("What label did you use for your latest budget sheet?", new String[]{});
	    labelQuestions.put("Enter the label for your product inventory?", new String[]{});
	    labelQuestions.put("What label do you assign to your completed assignments?", new String[]{});
	    labelQuestions.put("What label do you give to your current projects?", new String[]{});
	    labelQuestions.put("What label do you assign to your shopping list?", new String[]{});
	    labelQuestions.put("What label do you give your social media posts?", new String[]{});
	    labelQuestions.put("What label do you use for your marketing materials?", new String[]{});
	    labelQuestions.put("Enter the label for your expense reports?", new String[]{});
	    labelQuestions.put("What label do you assign to your monthly goals?", new String[]{});
	    labelQuestions.put("What label do you give your subscription details?", new String[]{});
	    labelQuestions.put("What label do you give to your payment receipts?", new String[]{});
	    labelQuestions.put("Enter the label for your ongoing projects?", new String[]{});
	    labelQuestions.put("What label do you use for your research data?", new String[]{});
	    labelQuestions.put("What label do you give to your recent tasks?", new String[]{});
	    labelQuestions.put("What label do you use for your workout schedule?", new String[]{});
	    labelQuestions.put("What label do you give to your travel itinerary?", new String[]{});
	    labelQuestions.put("What label did you use for your last grocery list?", new String[]{});
	    labelQuestions.put("Enter the label for your health records?", new String[]{});
	    labelQuestions.put("What label do you give to your feedback forms?", new String[]{});
	    labelQuestions.put("What label do you assign to your hobbies collection?", new String[]{});

	    // If the question index is larger than the available questions, loop around
	    List<String> keys = new ArrayList<>(labelQuestions.keySet());

	    if (randomizeOrder) {
	        Collections.shuffle(keys);
	    }

	    String question = keys.get(questionIndex % keys.size());
	    String[] inputs = labelQuestions.get(question);

	    return new AbstractMap.SimpleEntry<>(question, inputs);
	}

	
	public static Map.Entry<String, String[]> generateGenuineTimeQuestion(int questionIndex, boolean randomizeOrder) {
	    // Define a map of genuine time questions
	    Map<String, String[]> timeQuestions = new LinkedHashMap<>();

	    // Define time-related questions (no input configurations needed)
	    timeQuestions.put("What time did you wake up today?", new String[]{});
	    timeQuestions.put("What time did you go to bed last night?", new String[]{});
	    timeQuestions.put("What time was your last meal?", new String[]{});
	    timeQuestions.put("What time do you usually start work?", new String[]{});
	    timeQuestions.put("What time do you usually finish work?", new String[]{});
	    timeQuestions.put("At what time do you usually exercise?", new String[]{});
	    timeQuestions.put("What time did you last go to the gym?", new String[]{});
	    timeQuestions.put("At what time do you normally take your coffee break?", new String[]{});
	    timeQuestions.put("What time did you last visit a friend?", new String[]{});
	    timeQuestions.put("What time do you usually have dinner?", new String[]{});
	    timeQuestions.put("At what time do you usually go to sleep on weekends?", new String[]{});
	    timeQuestions.put("What time did you last attend a meeting?", new String[]{});
	    timeQuestions.put("At what time do you usually start your day on weekends?", new String[]{});
	    timeQuestions.put("What time did you last have an appointment?", new String[]{});
	    timeQuestions.put("What time do you usually take your lunch break?", new String[]{});
	    timeQuestions.put("What time did you last check your email?", new String[]{});
	    timeQuestions.put("At what time do you usually get home from work?", new String[]{});
	    timeQuestions.put("What time did you last watch a movie?", new String[]{});
	    timeQuestions.put("At what time do you usually read before bed?", new String[]{});
	    timeQuestions.put("What time did you last visit a restaurant?", new String[]{});
	    timeQuestions.put("What time do you usually wake up on holidays?", new String[]{});
	    timeQuestions.put("What time did you last call a family member?", new String[]{});
	    timeQuestions.put("At what time do you usually start your weekend activities?", new String[]{});
	    timeQuestions.put("What time did you last go to a social event?", new String[]{});
	    timeQuestions.put("What time do you usually have your first meal of the day?", new String[]{});
	    timeQuestions.put("At what time did you last attend a conference or seminar?", new String[]{});
	    timeQuestions.put("What time did you last have a phone call with a friend?", new String[]{});
	    timeQuestions.put("What time do you usually have your morning coffee?", new String[]{});
	    timeQuestions.put("At what time do you usually end your day?", new String[]{});
	    timeQuestions.put("What time did you last visit a new place?", new String[]{});
	    timeQuestions.put("What time do you usually go for a walk?", new String[]{});
	    timeQuestions.put("At what time did you last have a significant meeting?", new String[]{});
	    timeQuestions.put("What time do you usually prepare for bed?", new String[]{});
	    timeQuestions.put("What time did you last participate in a webinar?", new String[]{});
	    timeQuestions.put("At what time did you last have a family gathering?", new String[]{});
	    timeQuestions.put("What time do you usually plan your day?", new String[]{});
	    timeQuestions.put("What time did you last attend a personal event?", new String[]{});
	    timeQuestions.put("At what time did you last complete a significant task?", new String[]{});
	    timeQuestions.put("What time do you usually unwind before bed?", new String[]{});
	    timeQuestions.put("What time did you last have a work-related call?", new String[]{});
	    timeQuestions.put("At what time did you last finish a major project?", new String[]{});
	    timeQuestions.put("What time do you usually start preparing for the next day?", new String[]{});
	    timeQuestions.put("What time did you last experience a major event?", new String[]{});
	    timeQuestions.put("At what time do you usually take breaks during work?", new String[]{});
	    timeQuestions.put("What time did you last have a meal out?", new String[]{});
	    timeQuestions.put("What time do you usually have your evening snack?", new String[]{});
	    timeQuestions.put("At what time did you last go shopping?", new String[]{});
	    timeQuestions.put("What time do you usually spend on a hobby?", new String[]{});
	    timeQuestions.put("What time did you last have a leisure activity?", new String[]{});
	    timeQuestions.put("At what time do you usually organize your tasks for the day?", new String[]{});

	    // If the question index is larger than the available questions, loop around
	    List<String> keys = new ArrayList<>(timeQuestions.keySet());

	    if (randomizeOrder) {
	        Collections.shuffle(keys);
	    }

	    String question = keys.get(questionIndex % keys.size());
	    String[] inputs = timeQuestions.get(question);

	    return new AbstractMap.SimpleEntry<>(question, inputs);
	}
	
	public static Map.Entry<String, String[]> generateFileUploadQuestion(int questionIndex, boolean randomizeOrder) {
	    // Define a map of file upload-related questions with associated configurations
	    Map<String, String[]> fileUploadQuestions = new LinkedHashMap<>();

	    // Define file upload-related questions with input configurations (e.g., allowed file types, max size)
	    fileUploadQuestions.put("Please upload your resume.", new String[]{});
	    fileUploadQuestions.put("Upload your profile picture.", new String[]{});
	    fileUploadQuestions.put("Please upload your identification document.", new String[]{});
//	    fileUploadQuestions.put("Upload your bank statement.", new String[]{"PDF, XLSX", "Max size: 5MB"});
//	    fileUploadQuestions.put("Upload your previous employment certificate.", new String[]{"PDF, DOC", "Max size: 3MB"});
//	    fileUploadQuestions.put("Upload your educational certificates.", new String[]{"PDF", "Max size: 10MB"});
//	    fileUploadQuestions.put("Upload your tax documents.", new String[]{"PDF", "Max size: 5MB"});
//	    fileUploadQuestions.put("Please upload your driver's license.", new String[]{"PDF, JPG", "Max size: 2MB"});
//	    fileUploadQuestions.put("Upload your signed agreement.", new String[]{"PDF, DOCX", "Max size: 10MB"});
//	    fileUploadQuestions.put("Upload your insurance documents.", new String[]{"PDF", "Max size: 5MB"});
//	    fileUploadQuestions.put("Upload the medical report.", new String[]{"PDF, DOCX", "Max size: 10MB"});
//	    fileUploadQuestions.put("Please upload any additional documentation.", new String[]{"Any format", "Max size: 15MB"});
//	    fileUploadQuestions.put("Upload a scanned copy of your passport.", new String[]{"PDF, JPG", "Max size: 5MB"});
//	    fileUploadQuestions.put("Upload your business registration document.", new String[]{"PDF", "Max size: 8MB"});
//	    fileUploadQuestions.put("Please upload your portfolio.", new String[]{"PDF, JPG, PNG", "Max size: 10MB"});
//	    fileUploadQuestions.put("Upload your utility bill.", new String[]{"PDF, JPG", "Max size: 5MB"});

	    // If the question index is larger than the available questions, loop around
	    List<String> keys = new ArrayList<>(fileUploadQuestions.keySet());

	    if (randomizeOrder) {
	        Collections.shuffle(keys);
	    }

	    String question = keys.get(questionIndex % keys.size());
	    String[] configurations = fileUploadQuestions.get(question);

	    return new AbstractMap.SimpleEntry<>(question, configurations);
	}


	
	public static Map.Entry<String, String[]> generateGenuineDateQuestion(int questionIndex, boolean randomizeOrder) {
        // Define a map of genuine date questions
        Map<String, String[]> dateQuestions = new LinkedHashMap<>();

        // Define 50 date-related questions (no input configurations needed)
        dateQuestions.put("What is your birth date?", new String[]{});
        dateQuestions.put("Enter the date of your last visit", new String[]{});
        dateQuestions.put("When did you start your current job?", new String[]{});
        dateQuestions.put("What is the date of your anniversary?", new String[]{});
        dateQuestions.put("When did you move to your current residence?", new String[]{});
        dateQuestions.put("What is the date of your first car purchase?", new String[]{});
        dateQuestions.put("Enter the date of your graduation", new String[]{});
        dateQuestions.put("When did you get married?", new String[]{});
        dateQuestions.put("What is the date of your first job?", new String[]{});
        dateQuestions.put("When did you adopt your pet?", new String[]{});
        dateQuestions.put("What is the date of your last vacation?", new String[]{});
        dateQuestions.put("When did you last visit your hometown?", new String[]{});
        dateQuestions.put("What is the date of your last major purchase?", new String[]{});
        dateQuestions.put("When did you last see your best friend?", new String[]{});
        dateQuestions.put("What is the date of your last family gathering?", new String[]{});
        dateQuestions.put("When did you start your current hobby?", new String[]{});
        dateQuestions.put("What is the date of your most recent medical checkup?", new String[]{});
        dateQuestions.put("When did you last participate in a major event?", new String[]{});
        dateQuestions.put("What is the date of your most recent home renovation?", new String[]{});
        dateQuestions.put("When did you last attend a wedding?", new String[]{});
        dateQuestions.put("What is the date of your last community service?", new String[]{});
        dateQuestions.put("When did you last host a party?", new String[]{});
        dateQuestions.put("What is the date of your most recent holiday celebration?", new String[]{});
        dateQuestions.put("When did you last go on a trip?", new String[]{});
        dateQuestions.put("What is the date of your last big achievement?", new String[]{});
        dateQuestions.put("When did you last receive a significant award?", new String[]{});
        dateQuestions.put("What is the date of your most recent project completion?", new String[]{});
        dateQuestions.put("When did you last take a significant course or training?", new String[]{});
        dateQuestions.put("What is the date of your latest purchase from an online store?", new String[]{});
        dateQuestions.put("When did you last participate in a charity event?", new String[]{});
        dateQuestions.put("What is the date of your most recent family event?", new String[]{});
        dateQuestions.put("When did you last celebrate a personal milestone?", new String[]{});
        dateQuestions.put("What is the date of your last significant health event?", new String[]{});
        dateQuestions.put("When did you last experience a major life change?", new String[]{});
        dateQuestions.put("What is the date of your last big family vacation?", new String[]{});
        dateQuestions.put("When did you last take a break from work?", new String[]{});
        dateQuestions.put("What is the date of your last significant work project?", new String[]{});
        dateQuestions.put("When did you last visit a new city?", new String[]{});
        dateQuestions.put("What is the date of your last major family gathering?", new String[]{});
        dateQuestions.put("When did you last have a significant personal achievement?", new String[]{});
        dateQuestions.put("What is the date of your most recent professional development?", new String[]{});
        dateQuestions.put("When did you last attend a major conference?", new String[]{});
        dateQuestions.put("What is the date of your last significant investment?", new String[]{});
        dateQuestions.put("When did you last experience a major change in your career?", new String[]{});
        dateQuestions.put("What is the date of your most recent successful venture?", new String[]{});
        dateQuestions.put("When did you last participate in a significant community event?", new String[]{});
        dateQuestions.put("What is the date of your latest significant purchase?", new String[]{});
        dateQuestions.put("When did you last go on a family outing?", new String[]{});
        dateQuestions.put("What is the date of your most recent personal goal achievement?", new String[]{});
        dateQuestions.put("When did you last take a major step towards personal growth?", new String[]{});
        dateQuestions.put("What is the date of your most recent career milestone?", new String[]{});
        dateQuestions.put("When did you last celebrate a significant life event?", new String[]{});
        dateQuestions.put("What is the date of your last major financial decision?", new String[]{});
        dateQuestions.put("When did you last participate in a major project?", new String[]{});
        dateQuestions.put("What is the date of your most recent personal milestone?", new String[]{});
        dateQuestions.put("When did you last make a significant life change?", new String[]{});
        dateQuestions.put("What is the date of your most recent professional accomplishment?", new String[]{});
        dateQuestions.put("When did you last achieve a major personal goal?", new String[]{});
        dateQuestions.put("What is the date of your most recent milestone in personal development?", new String[]{});

        // If the question index is larger than the available questions, loop around
        List<String> keys = new ArrayList<>(dateQuestions.keySet());

        if (randomizeOrder) {
            Collections.shuffle(keys);
        }

        String question = keys.get(questionIndex % keys.size());
        String[] inputs = dateQuestions.get(question);

        return new AbstractMap.SimpleEntry<>(question, inputs);
    }

//	#$&%&%*&%&**%^*&$*&%&^%&*^&^*^*^*^*^^&^&*^*&^*&&(*&^*(&*^*(*^(*&^&*&*^&*(^&*%$^#%^@%^#$^&%&^#%^$&(%&$#$
//	#$&%&%*&%&**%^*&$*&%&^%&*^&^*^*^*^*^^&^&*^*&^*&&(*&^*(&*^*(*^(*&^&*&*^&*(^&*%$^#%^@%^#$^&%&^#%^$&(%&$#$
//	#$&%&%*&%&**%^*&$*&%&^%&*^&^*^*^*^*^^&^&*^*&^*&&(*&^*(&*^*(*^(*&^&*&*^&*(^&*%$^#%^@%^#$^&%&^#%^$&(%&$#$
//	#$&%&%*&%&**%^*&$*&%&^%&*^&^*^*^*^*^^&^&*^*&^*&&(*&^*(&*^*(*^(*&^&*&*^&*(^&*%$^#%^@%^#$^&%&^#%^$&(%&$#$
	
	// Define constants for question types
	public static final int LABEL = 1;
	public static final int MULTIPLE_CHOICE = 2;
	public static final int SHORT_ANSWER = 3;
	public static final int DROP_DOWN = 4;
	public static final int FILE_UPLOAD = 6;
	public static final int RADIO_BUTTON = 7;
	public static final int DATE = 8;
	public static final int TIME = 9;
	public static final int TEXT_BOX = 10;

	// Method to dynamically select question types and optionally shuffle the order
	public static List<Integer> selectQuestionTypes(boolean randomizeOrder, Integer... questionTypes) {
		List<Integer> selectedTypes = new ArrayList<>(Arrays.asList(questionTypes));

		if (randomizeOrder) {
			Collections.shuffle(selectedTypes);
		}

		return selectedTypes;
	}

	// Method to generate questions based on the index and question type
	public static Map.Entry<String, Object> generateGenuineQuestionAndInputs(int questionIndex, int questionType,
			boolean randomizeOrder) {
		// Define a map of questions and their corresponding options or input
		// configurations
		Map<String, Object> questionsAndInputs = new LinkedHashMap<>();

		questionsAndInputs.put("Label: Personal Information", LABEL);
		questionsAndInputs.put("Label: Contact Details", LABEL);

		questionsAndInputs.put("Choose your favorite season?", Arrays.asList("Spring", "Summer", "Fall", "Winter"));
		questionsAndInputs.put("Select your preferred programming language?",
				Arrays.asList("Java", "Python", "C++", "JavaScript"));

		questionsAndInputs.put("What is your nickname?", new String[] { "2", "15", "All", "Only Text" });
		questionsAndInputs.put("Enter your country code", new String[] { "2", "5", "All", "Only Number" });

		questionsAndInputs.put("What is your favorite color?", Arrays.asList("Red", "Blue", "Green", "Yellow", "Pink"));
		questionsAndInputs.put("Select your country of residence?",
				Arrays.asList("United States", "Canada", "India", "Australia"));

		questionsAndInputs.put("Upload your profile picture", FILE_UPLOAD);

		questionsAndInputs.put("Are you a student?", Arrays.asList("Yes", "No"));
		questionsAndInputs.put("Do you have any pets?", Arrays.asList("Yes", "No"));

		questionsAndInputs.put("Enter your birth date", DATE);
		questionsAndInputs.put("Select the event date", DATE);

		questionsAndInputs.put("Select a time for the meeting", TIME);
		questionsAndInputs.put("Enter your preferred time", TIME);

		questionsAndInputs.put("Enter your full name", new String[] { "3", "50", "All", "Only Text" });
		questionsAndInputs.put("Enter your email address", new String[] { "5", "100", "All", "Only Text" });

		// Get the list of questions (keys)
		List<String> keys = new ArrayList<>(questionsAndInputs.keySet());

		// Shuffle if randomizeOrder is true
		if (randomizeOrder) {
			Collections.shuffle(keys);
		}

		// Select the question based on the index
		String question = keys.get(questionIndex % keys.size());
		Object inputsOrOptions = questionsAndInputs.get(question);

		// Return the selected question and its corresponding inputs/options based on
		// the question type
		switch (questionType) {
		case LABEL:
			if (inputsOrOptions.equals(LABEL)) {
				return new SimpleEntry<>(question, LABEL);
			}
			break;
		case MULTIPLE_CHOICE:
		case DROP_DOWN:
		case RADIO_BUTTON:
			if (inputsOrOptions instanceof List) {
				return new SimpleEntry<>(question, inputsOrOptions);
			}
			break;
		case SHORT_ANSWER:
		case TEXT_BOX:
			if (inputsOrOptions instanceof String[]) {
				return new SimpleEntry<>(question, inputsOrOptions);
			}
			break;
		case FILE_UPLOAD:
		case DATE:
		case TIME:
			if (inputsOrOptions instanceof String) {
				return new SimpleEntry<>(question, inputsOrOptions);
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid question type: " + questionType);
		}

		throw new IllegalStateException("No matching question found for the given type.");
	}

}