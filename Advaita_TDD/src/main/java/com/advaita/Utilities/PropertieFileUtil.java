package com.advaita.Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertieFileUtil {

	private static final String PROPERTIES_FILE_PATH = "src/main/resources/ProcessText.properties";

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
		try (InputStream input = PropertieFileUtil.class.getClassLoader().getResourceAsStream("ProcessText.properties")) {
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

}
