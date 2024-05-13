package Advaita_TDD.Advaita_TDD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class FakeData {

	
	public static void main(String[] args) {
		
		FakeData fd = new FakeData();
		
		
        
		firstName();
//		fd.lastName();
		fd.firstCapString();
        string();
        number();
        fd.dateNextYear();
        
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
	
	public String lastName1() {
		 // Create a Faker instance
        Faker faker = new Faker();

        // Generate a random last name
        String randomLastName = faker.name().lastName();

        // Remove special characters using regex
        randomLastName = randomLastName.replaceAll("[^a-zA-Z]", "");

        // Print the random last name
        System.out.println("Random Last Name: " + randomLastName);
        
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
	
}

