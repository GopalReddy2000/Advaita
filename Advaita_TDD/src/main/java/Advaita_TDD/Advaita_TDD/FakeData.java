package Advaita_TDD.Advaita_TDD;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class FakeData {

	public static void main(String[] args) {

//		Faker faker = new Faker();

		FakeData fd = new FakeData();

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
		fd.firstCapString();
//        string();
//        number();
//        fd.dateNextYear();
//        
	}

	public String firstCapString() {
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
    public String lastName1() {
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

//	public String lastName1() {
//		// Create a Faker instance
//		Faker faker = new Faker();
//
//		// Generate a random last name
//		String randomLastName = faker.name().lastName();
//
//		// Remove special characters using regex
//		randomLastName = randomLastName.replaceAll("[^a-zA-Z]", "");
//
//		// Print the random last name
//		System.out.println("Random Last Name: " + randomLastName);
//
//		return randomLastName;
//	}

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
	
	private static final Set<LocalDate> generatedDates = new HashSet<>();
    public static void date() {
        Faker faker = new Faker();

        LocalDate uniqueDate;
        do {
            // Generate a random date in the future
            Date futureDate = faker.date().future(365, TimeUnit.DAYS);
            
            // Convert Date to LocalDate
            uniqueDate = futureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();	
        } while (generatedDates.contains(uniqueDate));

        // Add the unique date to the set
        generatedDates.add(uniqueDate);

        // Format LocalDate to String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = uniqueDate.format(formatter);

        // Print formatted date
        System.out.println("Random future date (within the next 10 days) in dd-MM-yyyy format: " + formattedDate);
    }

}
