package com.advaita.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class PropertieFileUtil {

	static Properties properties = new Properties();
	private static final String PROPERTIES_FILE_PATH = "src/main/resources/ProcessText.properties";
	private static final String PROPERTIES_FILE_PATH2 = "src/main/resources/SingleTextExtract.properties";


	private static final String PROPERTIES_FILE_ApiKey_PATH3 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\apiKey.properties";

	private static final String PROPERTIES_FILE_SiteSettings_PATH4 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\SiteSettings.properties";

	private static final String callLogStageView_Path5 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\callLogStageView.properties";

	private static final String menuSetup_Path6 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\menuSetup.properties";

	private static final String userStatus_Path7 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\userStatus.Properties";
	
	private static final String siteSetting_Path9 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\SiteSettings.properties";

	private static final String emailTemplate_Path8 = "C:\\Users\\W2378\\git\\Advaita\\Advaita_TDD\\src\\main\\resources\\email.Properties";

	// Method to store a single key-value pair in a properties file
	public static void storeSingleTextInPropertiesFile(String FilePath, String key, String value) throws IOException {

		// Load existing properties if they exist
		try (InputStream input = new FileInputStream(FilePath)) {
			properties.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found. Creating a new one.");
		}

		// Add the key-value pair to the properties object
		properties.setProperty(key, value);

		// Store the updated properties in a file
		try (FileOutputStream output = new FileOutputStream(FilePath)) {
			properties.store(output, "Updated Properties");

			// Print the key and its stored value
			System.out.println("Key: '" + key + "' Value: '" + value + "' stored in properties file successfully.");
		}
	}

	// Method to refresh and retrieve text from the properties file (case
	// insensitive)
	public static String getSingleTextFromPropertiesFile(String FilePath, String tagKey) throws IOException {

		Properties properties = new Properties();
		Map<String, String> lowerCaseProperties = new HashMap<>();

		// Refresh: Load the properties file to ensure it's the latest version
		try (InputStream input = new FileInputStream(FilePath)) {
			// Load the properties from file
			properties.load(input);

			// Store properties in a Map with lowercase keys for case-insensitive lookup
			for (String key : properties.stringPropertyNames()) {
				lowerCaseProperties.put(key.toLowerCase(), properties.getProperty(key));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found. Please ensure the file path is correct.");
			return null; // Return null if the file doesn't exist
		} catch (IOException e) {
			System.out.println("An error occurred while reading the properties file.");
			throw e; // Re-throw the exception if reading fails
		}

		// Retrieve the specific tag value based on the provided key (case insensitive)
		String tagText = lowerCaseProperties.get(tagKey.toLowerCase());
		if (tagText != null) {
			System.out.println("Retrieved value: " + tagText);
			return tagText; // Return the value if found
		} else {
			System.out.println("SingleText with key '" + tagKey + "' not found in properties file.");
			return null; // Return null if the key is not found
		}
	}

	// Method to store text in a properties file
	public static void storeTextInPropertiesFile(String process, String subProcess, String subSubProcess,
			String metaDataText, boolean fetchMetadata) throws IOException {
		Properties properties = new Properties();
		// Add the tag texts to the properties object
		properties.setProperty("process", process);
		properties.setProperty("subProcess", subProcess);
		properties.setProperty("subSubProcess", subSubProcess);

		if (fetchMetadata) {
			properties.setProperty("metaDataText", metaDataText);
		}

		// Store the properties in a file
		try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE_ApiKey_PATH3)) {
			properties.store(output, "Tag Texts from the Web Page");
			System.out.println("Text stored in properties file successfully.");
		}
	}

	public static String getTextFromPropertiesFile(String tagKey) throws IOException {

		// Load the properties file
		try (InputStream input = PropertieFileUtil.class.getClassLoader()
				.getResourceAsStream("ProcessText.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find properties file.");
				return null; // Return null if the file is not found
			}
			properties.load(input);
		}

		// Retrieve the specific tag value based on the provided key (case-insensitive)
		for (String key : properties.stringPropertyNames()) {
			if (key.equalsIgnoreCase(tagKey)) {
				return properties.getProperty(key); // Return the value if found
			}
		}

		System.out.println("Process with key '" + tagKey + "' not found in properties file.");
		return null; // Return null if the key is not found
	}

//===================================================================================	

	// Extract all the text and store in properties file with dynamic key prefix
	public static void extractAllAndStore(String FilePath, List<WebElement> elements, String keyPrefix)
			throws IOException {
		Properties properties = new Properties();

		// Load existing properties if the file exists
		try (InputStream input = new FileInputStream(FilePath)) {
			properties.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found. Creating a new one.");
		}

		// Loop through all elements and store with dynamic keys like prefix_data1,
		// prefix_data2, ...
		for (int i = 0; i < elements.size(); i++) {
			String key = keyPrefix + (i + 1);
			String value = elements.get(i).getText().trim(); // Optional: trim to clean up extra spaces
			properties.setProperty(key, value);
			System.out.println("Stored key: " + key + " with value: " + value);
		}

		// Save all to properties file
		try (FileOutputStream output = new FileOutputStream(FilePath)) {
			properties.store(output, "Stored all extracted data with prefix: " + keyPrefix);
			System.out.println("All data stored successfully in file: " + FilePath);
		}
	}

	// Extract all Store all Options From DropdownOption

	public static void extractDropdownOptions(String FilePath, WebElement dropdownElement, String keyPrefix)
			throws IOException {
		extractAllDropdownOptions(FilePath, dropdownElement, keyPrefix);
	}

	public static void extractAllDropdownOptions(String FilePath, WebElement dropdownElement, String keyPrefix)
			throws IOException {
		Properties properties = new Properties();

		// Load existing properties if they exist
		try (InputStream input = new FileInputStream(FilePath)) {
			properties.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found. Creating a new one.");
		}

		// Use Select class to get dropdown options
		Select dropdown = new Select(dropdownElement);
		List<WebElement> options = dropdown.getOptions();

		int count = 1;
		for (WebElement option : options) {
			String text = option.getText().trim();
			if (!text.isEmpty()) {
				String key = keyPrefix + count;
				properties.setProperty(key, text);
				System.out.println("Stored: " + key + " = " + text);
				count++;
			}
		}

		// Store updated properties
		try (FileOutputStream output = new FileOutputStream(FilePath)) {
			properties.store(output, "Dropdown Options Extracted with key prefix: " + keyPrefix);
			System.out.println("Dropdown data stored successfully in: " + PROPERTIES_FILE_ApiKey_PATH3);
		}
	}

	// Extract all Store all Options From DropdownOption
	public static void extractAndStoreTwoTextValueLists(String FilePath, List<WebElement> elements1, String prefix1,
			List<WebElement> elements2, String prefix2) throws IOException {

		Properties properties = new Properties();

		// Load existing properties if the file exists
		try (InputStream input = new FileInputStream(FilePath)) {
			properties.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found. A new one will be created.");
		}

		// Handle first list
		int count1 = 1;
		for (WebElement element : elements1) {
			String value = element.getAttribute("value");
			if (value != null && !value.trim().isEmpty()) {
				String key = prefix1 + count1;
				properties.setProperty(key, value.trim());
				System.out.println("Stored: " + key + " = " + value.trim());
				count1++;
			}
		}

		// Handle second list
		int count2 = 1;
		for (WebElement element : elements2) {
			String value = element.getAttribute("value");
			if (value != null && !value.trim().isEmpty()) {
				String key = prefix2 + count2;
				properties.setProperty(key, value.trim());
				System.out.println("Stored: " + key + " = " + value.trim());
				count2++;
			}
		}

		// Save to properties file
		try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE_ApiKey_PATH3)) {
			properties.store(output, "Stored from two text field lists with prefixes");
			System.out.println("✅ Data stored in: " + PROPERTIES_FILE_ApiKey_PATH3);
		}
	}

//	#################################################################################################

	static Properties properties1 = new Properties();
	private static final String FILE_PATH = "src/test/resources/questions.properties";

//	    public static void saveQuestion(String key, String value) {
//	    	properties1.setProperty(key, value);
//	    }
//
//	    public static void saveToFile() {
//	        try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
//	        	properties1.store(output, "Stored Questions for Validation");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    
//	    public static void clearFile() {
//	        try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
//	            new Properties().store(output, "Cleared File");  // Overwrites with empty properties
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    
//	    public static Properties loadQuestions() throws IOException {
//	        Properties properties = new Properties();
//	        try (FileInputStream input = new FileInputStream(FILE_PATH)) {
//	            properties.load(input);
//	        }
//	        return properties;
//	    }
//	    

	// Save a question to the properties file (key-value pair)
	public static void saveQuestion(String key, String value) {
		properties1.setProperty(key, value);
		saveToFile(); // Save immediately to prevent data loss
	}

	// Save all stored properties to the file
	public static void saveToFile() {
		try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
			properties1.store(output, "Stored Questions for Validation");
		} catch (IOException e) {
			System.err.println("Error saving questions to file: " + e.getMessage());
		}
	}

	// Clears the properties file
	public static void clearFile() {
		try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
			new Properties().store(output, "Cleared File"); // Overwrites with empty properties
			properties1.clear(); // Also clear the in-memory properties
		} catch (IOException e) {
			System.err.println("Error clearing file: " + e.getMessage());
		}
	}

	// Load all questions from the properties file
	public static Properties loadQuestions() {
		Properties properties = new Properties();
		try (FileInputStream input = new FileInputStream(FILE_PATH)) {
			properties.load(input);
		} catch (IOException e) {
			System.err.println("Error loading questions from file: " + e.getMessage());
		}
		return properties;
	}

	// Get all stored questions as a Map
	public static java.util.Map<String, String> getAllQuestions() {
		Properties properties = loadQuestions();
		java.util.Map<String, String> questionsMap = new java.util.HashMap<>();
		for (String key : properties.stringPropertyNames()) {
			questionsMap.put(key, properties.getProperty(key));
		}
		return questionsMap;
	}
	
	
	
	//New 
	public static void storeSingleTextInPropertiesFile(String key, String value) throws IOException {

		// Load existing properties if they exist

		try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH2)) {

		properties.load(input);

		} catch (FileNotFoundException e) {

		System.out.println("Properties file not found. Creating a new one.");

		}

		// Add the key-value pair to the properties object

		properties.setProperty(key, value);

		// Store the updated properties in a file

		try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE_PATH2)) {

		properties.store(output, "Updated Properties");

		// Print the key and its stored value

		System.out.println("Key: '" + key + "' Value: '" + value + "' stored in properties file successfully.");

		}

		}

		// Method to refresh and retrieve text from the properties file (case insensitive)

		public static String getSingleTextFromPropertiesFile(String tagKey) throws IOException {

		Properties properties = new Properties();

		Map<String, String> lowerCaseProperties = new HashMap<>();

		// Refresh: Load the properties file to ensure it's the latest version

		try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH2)) {

		// Load the properties from file

		properties.load(input);

		// Store properties in a Map with lowercase keys for case-insensitive lookup

		for (String key : properties.stringPropertyNames()) {

		lowerCaseProperties.put(key.toLowerCase(), properties.getProperty(key));

		}

		} catch (FileNotFoundException e) {

		System.out.println("Properties file not found. Please ensure the file path is correct.");

		return null; // Return null if the file doesn't exist

		} catch (IOException e) {

		System.out.println("An error occurred while reading the properties file.");

		throw e; // Re-throw the exception if reading fails

		}

		// Retrieve the specific tag value based on the provided key (case insensitive)

		String tagText = lowerCaseProperties.get(tagKey.toLowerCase());

		if (tagText != null) {

		System.out.println("Retrieved value: " + tagText);

		return tagText; // Return the value if found

		} else {

		System.out.println("SingleText with key '" + tagKey + "' not found in properties file.");

		return null; // Return null if the key is not found

		}

		}
	

}
