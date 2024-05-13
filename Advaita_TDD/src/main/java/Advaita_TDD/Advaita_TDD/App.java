package Advaita_TDD.Advaita_TDD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//        
//        for(int i=1;i<=3;i++) {
//        	
//        	String x = "(//input[@placeholder='Enter your column Name'])["+i+"]";
//        			
//        			String y = "question_1_"+i;
//        	
//        	System.out.println(x+"\n"+y);
//        }
//        
//    }
	
	 public static void main(String[] args) {
	        // Create an instance of Faker
	        Faker faker = new Faker();

	        // Get the current year
//	        int currentYear = new Date().getYear() + 3923; // Add 1900 as Date.getYear() returns the year minus 1900

	        // Generate a random date within the last year
	        Date pastDate = faker.date().past(365, TimeUnit.DAYS);

	        // Generate a random date within the next year
	        Date futureDate = faker.date().future(365, TimeUnit.DAYS);

	        // Generate a random date within the current year
//	        Date currentYearDate = faker.date().birthday(currentYear, currentYear);

	        // Format the dates for display
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	        // Print the generated dates
	        System.out.println("Random date within the last year: " + sdf.format(pastDate));
	        System.out.println("Random date within the next year: " + sdf.format(futureDate));
//	        System.out.println("Random date within the current year: " + sdf.format(currentYearDate));
	    }
	
//	 public static void main(String[] args) {
//	        Faker faker = new Faker();
//	        int currentYear = new Date().getYear() + 3923;
//	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//
//	        HashSet<String> generatedDates = new HashSet<>(); // To store generated dates
//
//	        // Generate a random date within the current year ensuring uniqueness
//	        Date currentYearDate;
//	        do {
//	            currentYearDate = faker.date().birthday(currentYear, currentYear);
//	        } while (!generatedDates.add(sdf.format(currentYearDate))); // Check and add to set
//
//	        // Print the generated date within the current year
//	        System.out.println("Random date within the current year: " + sdf.format(currentYearDate));
//	    }
}
