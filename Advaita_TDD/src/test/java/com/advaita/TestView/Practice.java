package com.advaita.TestView;

import net.datafaker.Faker;

public class Practice {
	
	   public static void main(String[] args) {
	        // Create a Faker instance
	        Faker faker = new Faker();

	        // Generate random questions
	        for (int i = 0; i < 10; i++) {
	            String question = faker.lorem().sentence(5, 10);
	            System.out.println("Question " + (i + 1) + ": " + question + "?");
	        }
	    }

}
