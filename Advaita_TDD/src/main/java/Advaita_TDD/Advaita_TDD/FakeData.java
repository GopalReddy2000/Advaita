package Advaita_TDD.Advaita_TDD;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import net.datafaker.Faker;

public class FakeData {

	private static Faker faker;
//    private final Random random;
	private final List<String> processes;
	private final Map<String, List<String>> subProcesses;
	private final Map<String, List<String>> subSubProcesses;
	private final Map<String, List<String>> datasets;
	private final Map<String, List<String>> stages;
	private final Map<String, List<String>> nonMeasurableSets;
	private final Map<String, List<String>> fieldSets;
	private final Map<String, List<String>> masterForms;
	private final Map<String, List<String>> masterMenus;
	private final Map<String, List<String>> samplingNames;
	private final Map<String, List<String>> metaData;
	private final Map<String, List<String>> manualUploadNames;

	public FakeData() {
		this.faker = new Faker();
		this.random = new Random();
		this.processes = new ArrayList<>();
		this.subProcesses = new HashMap<>();
		this.subSubProcesses = new HashMap<>();
		this.datasets = new HashMap<>();
		this.stages = new HashMap<>();
		this.nonMeasurableSets = new HashMap<>();
		this.fieldSets = new HashMap<>();
		this.masterForms = new HashMap<>();
		this.masterMenus = new HashMap<>();
		this.samplingNames = new HashMap<>();
		this.metaData = new HashMap<>();
		this.manualUploadNames = new HashMap<>();
	}

	// Helper method to capitalize the first letter of each word
	private String capitalizeWords(String input) {
		return Arrays.stream(input.split(" ")).map(
				word -> word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
				.collect(Collectors.joining(" "));
	}

	// Helper method to generate a value under maxLength (retrying if too long)
	private String generateValidValue(Supplier<String> generator, int maxLength) {
	    String value;
	    int maxTries = 10; // avoid infinite loop
	    int tries = 0;
	    do {
	        value = generator.get();
	        tries++;
	    } while (value.length() > maxLength && tries < maxTries);

	    // Optional safety: If still too long after maxTries, truncate
	    if (value.length() > maxLength) {
	        value = value.substring(0, maxLength);
	    }

	    return value;
	}
	
	// Generate or reuse a Process
	public String getProcess() {
		if (!processes.isEmpty() && random.nextBoolean()) {
			return processes.get(random.nextInt(processes.size()));
		}

		String department = generateValidValue(() -> faker.commerce().department() + " P", 30);
		String process = capitalizeWords(department);
		processes.add(process);
		return process;
	}

	// Generate or reuse a SubProcess for a given Process
	public String getSubProcess(String process) {
		if (process == null || process.isEmpty()) {
			throw new IllegalArgumentException("Process cannot be null or empty");
		}
		subProcesses.computeIfAbsent(process, k -> new ArrayList<>());
		List<String> subProcessList = subProcesses.get(process);
		if (!subProcessList.isEmpty() && random.nextBoolean()) {
			return subProcessList.get(random.nextInt(subProcessList.size()));
		}
		String product = generateValidValue(() -> faker.commerce().productName() + " S P", 30);
		String subProcess = capitalizeWords(product);
		subProcessList.add(subProcess);
		return subProcess;
	}

	// Generate or reuse a SubSubProcess for a given SubProcess
	public String getSubSubProcess(String subProcess) {
		if (subProcess == null || subProcess.isEmpty()) {
			throw new IllegalArgumentException("SubProcess cannot be null or empty");
		}
		subSubProcesses.computeIfAbsent(subProcess, k -> new ArrayList<>());
		List<String> subSubProcessList = subSubProcesses.get(subProcess);
		if (!subSubProcessList.isEmpty() && random.nextBoolean()) {
			return subSubProcessList.get(random.nextInt(subSubProcessList.size()));
		}
		String marketing = generateValidValue(() -> faker.marketing().buzzwords() + " S S P", 30);
		String subSubProcess = capitalizeWords(marketing);
		subSubProcessList.add(subSubProcess);
		return subSubProcess;
	}

	// Generate or reuse a Dataset for a given SubSubProcess
	public String getDataset(String subSubProcess) {
		if (subSubProcess == null || subSubProcess.isEmpty()) {
			throw new IllegalArgumentException("SubSubProcess cannot be null or empty");
		}
		datasets.computeIfAbsent(subSubProcess, k -> new ArrayList<>());
		List<String> datasetList = datasets.get(subSubProcess);
		if (!datasetList.isEmpty() && random.nextBoolean()) {
			return datasetList.get(random.nextInt(datasetList.size()));
		}
		String dataset1 = generateValidValue(() -> faker.company().industry() + " Dataset", 20);
		String dataset = capitalizeWords(dataset1);
		datasetList.add(dataset);
		return dataset;
	}

	// Generate or reuse a Stage for a given Dataset
	public String getStage(String dataset) {
		if (dataset == null || dataset.isEmpty()) {
			throw new IllegalArgumentException("Dataset cannot be null or empty");
		}
		stages.computeIfAbsent(dataset, k -> new ArrayList<>());
		List<String> stageList = stages.get(dataset);
		if (!stageList.isEmpty() && random.nextBoolean()) {
			return stageList.get(random.nextInt(stageList.size()));
		}
		String stage1 = generateValidValue(() -> faker.job().field() + " Stage", 20);
		String stage = capitalizeWords(stage1);
		stageList.add(stage);
		return stage;
	}

	// Generate or reuse a Non-Measurable Set for a given Stage
	public String getNonMeasurableSet(String stage) {
		if (stage == null || stage.isEmpty()) {
			throw new IllegalArgumentException("Stage cannot be null or empty");
		}
		nonMeasurableSets.computeIfAbsent(stage, k -> new ArrayList<>());
		List<String> nonMeasurableList = nonMeasurableSets.get(stage);
		if (!nonMeasurableList.isEmpty() && random.nextBoolean()) {
			return nonMeasurableList.get(random.nextInt(nonMeasurableList.size()));
		}
		String nonMeasurable = generateValidValue(() -> faker.science().element() + " Non-Measurable Set", 20);;
		String nonMeasurableSet = capitalizeWords(nonMeasurable);
		nonMeasurableList.add(nonMeasurableSet);
		return nonMeasurableSet;
	}

	// Generate or reuse a Field Set for a given Non-Measurable Set
	public String getFieldSet(String nonMeasurableSet) {
		if (nonMeasurableSet == null || nonMeasurableSet.isEmpty()) {
			throw new IllegalArgumentException("NonMeasurableSet cannot be null or empty");
		}
		fieldSets.computeIfAbsent(nonMeasurableSet, k -> new ArrayList<>());
		List<String> fieldSetList = fieldSets.get(nonMeasurableSet);
		if (!fieldSetList.isEmpty() && random.nextBoolean()) {
			return fieldSetList.get(random.nextInt(fieldSetList.size()));
		}
		String fieldSet1 = generateValidValue(() -> faker.book().genre() + " Field Set", 20);;
//		String fieldSet1 = faker.book().genre() + " Field Set";
		String fieldSet = capitalizeWords(fieldSet1);
		fieldSetList.add(fieldSet);
		return fieldSet;
	}

	// Generate or reuse a Master Form for a given Field Set
	public String getMasterForm(String fieldSet) {
		if (fieldSet == null || fieldSet.isEmpty()) {
			throw new IllegalArgumentException("FieldSet cannot be null or empty");
		}
		masterForms.computeIfAbsent(fieldSet, k -> new ArrayList<>());
		List<String> masterFormList = masterForms.get(fieldSet);
		if (!masterFormList.isEmpty() && random.nextBoolean()) {
			return masterFormList.get(random.nextInt(masterFormList.size()));
		}
		String form = generateValidValue(() -> faker.app().name() + " Master Form", 20);;
		String masterForm = capitalizeWords(form);
		masterFormList.add(masterForm);
		return masterForm;
	}

	// Generate or reuse a Master Menu for a given Master Form
	public String getMasterMenu(String masterForm) {
		if (masterForm == null || masterForm.isEmpty()) {
			throw new IllegalArgumentException("MasterForm cannot be null or empty");
		}
		masterMenus.computeIfAbsent(masterForm, k -> new ArrayList<>());
		List<String> masterMenuList = masterMenus.get(masterForm);
		if (!masterMenuList.isEmpty() && random.nextBoolean()) {
			return masterMenuList.get(random.nextInt(masterMenuList.size()));
		}
		String menu = generateValidValue(() -> faker.food().dish() + " Menu", 20);;
		String masterMenu = capitalizeWords(menu);
		masterMenuList.add(masterMenu);
		return masterMenu;
	}

	// Generate or reuse a Sampling Name for a given Master Menu
	public String getSamplingName(String masterMenu) {
		if (masterMenu == null || masterMenu.isEmpty()) {
			throw new IllegalArgumentException("MasterMenu cannot be null or empty");
		}
		samplingNames.computeIfAbsent(masterMenu, k -> new ArrayList<>());
		List<String> samplingNameList = samplingNames.get(masterMenu);
		if (!samplingNameList.isEmpty() && random.nextBoolean()) {
			return samplingNameList.get(random.nextInt(samplingNameList.size()));
		}
		String sampling = generateValidValue(() -> faker.science().unit() + " Sampling", 20);;
		String samplingName = capitalizeWords(sampling);
		samplingNameList.add(samplingName);
		return samplingName;
	}

	// Generate or reuse a Meta Data for a given Sampling Name
	public String getMetaData(String samplingName) {
		if (samplingName == null || samplingName.isEmpty()) {
			throw new IllegalArgumentException("SamplingName cannot be null or empty");
		}
		metaData.computeIfAbsent(samplingName, k -> new ArrayList<>());
		List<String> metaDataList = metaData.get(samplingName);
		if (!metaDataList.isEmpty() && random.nextBoolean()) {
			return metaDataList.get(random.nextInt(metaDataList.size()));
		}
		String meta = generateValidValue(() -> faker.lorem().word() + " Meta Data", 20);;
		String metaData = capitalizeWords(meta);
		metaDataList.add(metaData);
		return metaData;
	}

	// Generate or reuse a Manual Upload Name for a given Meta Data
	public String getManualUploadName(String metaData) {
		if (metaData == null || metaData.isEmpty()) {
			throw new IllegalArgumentException("MetaData cannot be null or empty");
		}
		manualUploadNames.computeIfAbsent(metaData, k -> new ArrayList<>());
		List<String> manualUploadNameList = manualUploadNames.get(metaData);
		if (!manualUploadNameList.isEmpty() && random.nextBoolean()) {
			return manualUploadNameList.get(random.nextInt(manualUploadNameList.size()));
		}
		String manualUpload = generateValidValue(() -> faker.file().fileName() + " Upload", 20);;
		String manualUploadName = capitalizeWords(manualUpload);
		manualUploadNameList.add(manualUploadName);
		return manualUploadName;
	}

	// Getter for all generated data (for debugging or further use)
	public Map<String, Object> getAllData() {
		Map<String, Object> allData = new HashMap<>();
		allData.put("Processes", processes);
		allData.put("SubProcesses", subProcesses);
		allData.put("SubSubProcesses", subSubProcesses);
		allData.put("Datasets", datasets);
		allData.put("Stages", stages);
		allData.put("NonMeasurableSets", nonMeasurableSets);
		allData.put("FieldSets", fieldSets);
		allData.put("MasterForms", masterForms);
		allData.put("MasterMenus", masterMenus);
		allData.put("SamplingNames", samplingNames);
		allData.put("MetaData", metaData);
		allData.put("ManualUploadNames", manualUploadNames);

		return allData;
	}

//	static Faker faker = new Faker();

	public static void main(String[] args) {

//		System.out.println(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//		System.out.println(faker.bool().bool());
		System.out.println(getDate(1, 1));

//		// Generate a fake drop-down question
//        String question = "What is your favorite " + faker.food().ingredient() + "?";
//
//        // Generate 5 fake options for the drop-down list
//        List<String> options = new ArrayList<>();
//        options.add(faker.food().ingredient());
//        options.add(faker.food().ingredient());
//        options.add(faker.food().ingredient());
//        options.add(faker.food().ingredient());
//        options.add(faker.food().ingredient());
//
//        // Print the question and the options
//        System.out.println(question);
//        System.out.println("-------------------");
//        for (String option : options) {
//            System.out.println(option);
//        }

//		FakeData fd = new FakeData();

//		System.out.println(faker.date().future(100, TimeUnit.DAYS));
//		
//		// Generate a random date between two specific dates
//        LocalDate startDate = LocalDate.now().minusMonths(1);
//        LocalDate endDate = LocalDate.now().plusMonths(1);
//        Date randomBetween = faker.date().between(
//                Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
//                Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
//        );
//        
//        System.out.println("Random date between last month and next month: " + randomBetween);
//        
//        
//     // Generate a random birthday
//        Date birthday = faker.date().birthday();
//        System.out.println("Random birthday: " + birthday);
//
//        // Format the date to a specific pattern
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        String formattedDate = localDate.format(formatter);
//        System.out.println("Formatted birthday: " + formattedDate);
//        
//        for (int i = 0; i < 30; i++) {
//        	
//        	fd.lastName1();
//        }

//		firstName();
////		fd.lastName();
//		fd.firstCapString();
//        string();
//        number();
//        fd.dateNextYear();
//        
	}

	public static String firstCapString() {
		// Create a Faker instance
		Faker faker = new Faker();

		// Generate a random five-character string containing both letters and numbers
		String randomFiveCharacterString = faker.bothify("?????");

		// Capitalize the first letter
		randomFiveCharacterString = capitalizeFirstLetter(randomFiveCharacterString);

		// Print the random five-character string
		System.out.println("Random Five-Character String: " + randomFiveCharacterString);

		return randomFiveCharacterString;
	}

	private static String capitalizeFirstLetter(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	public static void string() {
		// Create a Faker instance
		Faker faker = new Faker();

		// Generate a random five-character string containing both letters and numbers
		String randomFiveCharacterString = faker.bothify("?????");

		// Print the random five-character string
		System.out.println("Random Five-Character String: " + randomFiveCharacterString);

	}

	private static final Set<String> generatedLastNames = new HashSet<>();

	public static String lastName2() {
		// Create a Faker instance
		Faker faker = new Faker();

		String randomLastName;
		do {
			// Generate a random last name
			randomLastName = faker.name().lastName();

			// Remove special characters using regex
			randomLastName = randomLastName.replaceAll("[^a-zA-Z]", "");
		} while (generatedLastNames.contains(randomLastName));

		// Print the random last name
		System.out.println("Random Last Name: " + randomLastName);

		// Add the generated last name to the set
		generatedLastNames.add(randomLastName);

		return randomLastName;
	}

	public static String lastName1() {
		// Create a Faker instance
		Faker faker = new Faker();

		// Generate a random last name
		String randomLastName = faker.name().lastName();

		// Remove special characters using regex
		randomLastName = randomLastName.replaceAll("[^a-zA-Z]", "");

		// Print the random last name
//		System.out.println("Random Last Name: " + randomLastName);

		return randomLastName;
	}

	public void firstName() {
		// Create a Faker instance
		Faker faker = new Faker();

		// Generate a random first name
		String randomFirstName = faker.name().firstName();

		// Print the random first name
		System.out.println("Random First Name: " + randomFirstName);
	}

	public static void number() {
		// Create a Faker instance
		Faker faker = new Faker();

		// Generate a random five-digit string
		String randomFiveDigitString = faker.numerify("#####");

		// Print the random five-digit string
		System.out.println("Random Five-Digit String: " + randomFiveDigitString);
	}

	public String dateNextYear() {

		// Create an instance of Faker
		Faker faker = new Faker();

		// Generate a random date within the next year
		Date futureDate = faker.date().future(365, TimeUnit.DAYS);

		// Format the dates for display
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println("Random date within the next year: " + sdf.format(futureDate));

		String date = String.valueOf(futureDate);

		return date;
	}

//	private static final Set<LocalDate> generatedDates = new HashSet<>();
//    public static void date() {
//        Faker faker = new Faker();
//
//        LocalDate uniqueDate;
//        do {
//            // Generate a random date in the future
//            Date futureDate = faker.date().future(365, TimeUnit.DAYS);
//            
//            // Convert Date to LocalDate
//            uniqueDate = futureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();	
//        } while (generatedDates.contains(uniqueDate));
//
//        // Add the unique date to the set
//        generatedDates.add(uniqueDate);
//
//        // Format LocalDate to String
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String formattedDate = uniqueDate.format(formatter);
//
//        // Print formatted date
//        System.out.println("Random future date (within the next 10 days) in dd-MM-yyyy format: " + formattedDate);
//    }

//    ##############################################################################################################################

	private static final Set<String> generatedStrings = new HashSet<>();
	private static final Set<Integer> generatedNumbers = new HashSet<>();
	private static final Set<String> generatedPhoneNumbers = new HashSet<>();
	private static final Set<LocalDate> generatedDates = new HashSet<>();
	private static Random random = new Random();

	/**
	 * Generates a unique random string using Java Faker.
	 *
	 * @param length Length of the random string.
	 * @return A unique random string.
	 */
	public static String generateUniqueRandomString(int length) {
		String uniqueString;
		do {
			uniqueString = faker.lorem().characters(length, false, false);
		} while (generatedStrings.contains(uniqueString));
		generatedStrings.add(uniqueString);
		return capitalizeFirstLetter(uniqueString);
	}

	public static String generateUniqueRandomChar(int length) {
		String uniqueString;
		do {
			uniqueString = faker.lorem().characters(length);
		} while (generatedStrings.contains(uniqueString));
		generatedStrings.add(uniqueString);
		return uniqueString;
	}

	/**
	 * Generates a unique random number using Java Faker.
	 *
	 * @param min Minimum value of the random number.
	 * @param max Maximum value of the random number.
	 * @return A unique random number.
	 */
	public static int generateUniqueRandomNumber(int min, int max) {
		int uniqueNumber;
		do {
			uniqueNumber = random.nextInt((max - min) + 1) + min;
		} while (generatedNumbers.contains(uniqueNumber));
		generatedNumbers.add(uniqueNumber);
		return uniqueNumber;
	}

	/**
	 * Generates a unique random phone number starting with 6, 7, 8, or 9.
	 *
	 * @return A unique random phone number.
	 */
	public static String generateUniquePhoneNumber() {
		String uniquePhoneNumber;
		do {
			uniquePhoneNumber = generatePhoneNumberWithPrefix();
		} while (generatedPhoneNumbers.contains(uniquePhoneNumber));
		generatedPhoneNumbers.add(uniquePhoneNumber);
		return uniquePhoneNumber;
	}

	/**
	 * Helper method to generate a phone number starting with 6, 7, 8, or 9.
	 *
	 * @return A phone number starting with 6, 7, 8, or 9.
	 */
	private static String generatePhoneNumberWithPrefix() {
		// Randomly choose a prefix (6, 7, 8, or 9)
		int prefix = 6 + random.nextInt(4);
		// Generate the rest of the phone number (9 more digits)
		String restOfNumber = faker.numerify("#########"); // 9 digits
		return prefix + restOfNumber;
	}

	/**
	 * Generates a unique random date between the start and end dates.
	 *
	 * @param startDate The start date of the range.
	 * @param endDate   The end date of the range.
	 * @return A unique random date within the specified range.
	 */
	public static LocalDate getUniqueRandomDate(LocalDate startDate, LocalDate endDate) {
		if (ChronoUnit.DAYS.between(startDate, endDate) < generatedDates.size()) {
			throw new IllegalStateException("All possible unique dates have already been generated.");
		}

		LocalDate randomDate;
		do {
			randomDate = getRandomDate(startDate, endDate);
		} while (generatedDates.contains(randomDate));

		generatedDates.add(randomDate);
		return randomDate;
	}

	/**
	 * Generates a random date between the start and end dates.
	 *
	 * @param startDate The start date of the range.
	 * @param endDate   The end date of the range.
	 * @return A random date within the specified range.
	 */
	/*
	 * private static LocalDate getRandomDate(LocalDate startDate, LocalDate
	 * endDate) { long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
	 * long randomDay = random.nextLong(daysBetween + 1); return
	 * startDate.plusDays(randomDay); }
	 */

	private static LocalDate getRandomDate(LocalDate startDate, LocalDate endDate) {
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

		// Generate a random number between 0 (inclusive) and daysBetween (inclusive)
		long randomDay = ThreadLocalRandom.current().nextLong(0, daysBetween + 1);

		return startDate.plusDays(randomDay);
	}

	/**
	 * Formats a LocalDate object to a string in the format dd-MM-yyyy.
	 *
	 * @param date The LocalDate to format.
	 * @return The formatted date string.
	 */
	public static String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return date.format(formatter);
	}

	public static String getDate(int startYear, int endingYear) {
		// Example usage
		LocalDate startDate = LocalDate.now().minusYears(startYear); // One year ago
		LocalDate endDate = LocalDate.now().plusYears(endingYear); // One year from now

		// Generate a unique random date
		LocalDate uniqueRandomDate = getUniqueRandomDate(startDate, endDate);

		// Format the unique random date
		String formattedDate = formatDate(uniqueRandomDate);

		// Print the formatted date
		System.out.println(formattedDate);

		return formattedDate;

	}

	public static String generateRandomHyperlink() {
		String protocol = faker.internet().url();
		String domain = faker.internet().domainName();
		String path = faker.lorem().word();
		return protocol + "/" + domain + "/" + path;
	}

	public static boolean generateRandomBoolean() {
		return faker.bool().bool();
	}

//    public static String generateProcessName() {
//        return faker.company().industry();
//    }
//
//    public static String generateSubProcessName() {
//        return  faker.job().field();
//    }
//
//    public static String generateSubSubProcessName() {
//        return faker.commerce().productName();
//    }
//    
//    public static String generateDatasetName() {
//        return faker.science().element();
//    } 
}
