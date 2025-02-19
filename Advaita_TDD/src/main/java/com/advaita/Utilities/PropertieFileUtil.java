package com.advaita.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertieFileUtil {

	static Properties properties = new Properties();
	private static final String PROPERTIES_FILE_PATH = "src/main/resources/ProcessText.properties";
	private static final String PROPERTIES_FILE_PATH2 = "src/main/resources/SingleTextExtract.properties";

	// Method to store a single key-value pair in a properties file
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
		try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE_PATH)) {
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
	        saveToFile();  // Save immediately to prevent data loss
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
	            new Properties().store(output, "Cleared File");  // Overwrites with empty properties
	            properties1.clear();  // Also clear the in-memory properties
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
	    


}
