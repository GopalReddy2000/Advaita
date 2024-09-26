package com.advaita.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertieFileUtil {

	private static final String PROPERTIES_FILE_PATH = "src/main/resources/ProcessText.properties";
	private static final String PROPERTIES_FILE_PATH2 = "src/main/resources/SingleTextExtract.properties";

	// Method to store a single key-value pair in a properties file
	public static void storeSingleTextInPropertiesFile(String key, String value) throws IOException {
		Properties properties = new Properties();

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
			System.out.println("Text stored in properties file successfully.");
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
		Properties properties = new Properties();

		// Load the properties file
		try (InputStream input = PropertieFileUtil.class.getClassLoader()
				.getResourceAsStream("ProcessText.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find properties file.");
				return null; // Return null if the file is not found
			}
			properties.load(input);
		}

		// Retrieve the specific tag value based on the provided key
		String tagText = properties.getProperty(tagKey);
		if (tagText != null) {
			return tagText; // Return the value if found
		} else {
			System.out.println("Process with key '" + tagKey + "' not found in properties file.");
			return null; // Return null if the key is not found
		}
	}

	public static String getSingleTextFromPropertiesFile(String tagKey) throws IOException {
		Properties properties = new Properties();

		// Load the properties file
		try (InputStream input = PropertieFileUtil.class.getClassLoader()
				.getResourceAsStream("SingleTextExtract.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find properties file.");
				return null; // Return null if the file is not found
			}
			properties.load(input);
		}

		// Retrieve the specific tag value based on the provided key
		String tagText = properties.getProperty(tagKey);
		if (tagText != null) {
			return tagText; // Return the value if found
		} else {
			System.out.println("SingleText with key '" + tagKey + "' not found in properties file.");
			return null; // Return null if the key is not found
		}
	}

}
