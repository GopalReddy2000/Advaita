package Advaita_TDD.Advaita_TDD;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class FakeData {

	static Faker faker = new Faker();

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

	public static void firstName() {
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
	private static final Random random = new Random();

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
}
