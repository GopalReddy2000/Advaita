package com.advaita.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QuestionSelector {

	/**
	 * Select a specific number of questions from a list.
	 *
	 * @param questions         List of all available questions.
	 * @param numberOfQuestions Number of questions to select.
	 * @param randomSelection   Whether to select questions randomly or not.
	 * @return List of selected questions.
	 */

	public static List<Map<String, String>> selectQuestions(List<Map<String, String>> questions, List<String> types,
			int numberOfQuestions, boolean randomSelection) {
		
		List<Map<String, String>> selectedQuestions = new ArrayList<>();

		if (types.isEmpty()) {
			// If no types are specified, select questions normally in the order they appear
			for (int i = 0; i < numberOfQuestions && i < questions.size(); i++) {
				selectedQuestions.add(questions.get(i));
			}
		} else {
			// Filter questions based on the specified types
			List<Map<String, String>> filteredQuestions = new ArrayList<>();
			for (Map<String, String> question : questions) {
				if (types.contains(question.get("Type"))) {
					filteredQuestions.add(question);
				}
			}

			if (randomSelection) {
				Collections.shuffle(filteredQuestions); // Shuffle for random selection
			}

			// Select questions based on the order of types provided
			int index = 0;
			while (selectedQuestions.size() < numberOfQuestions && index < types.size()) {
				String type = types.get(index);
				for (Map<String, String> question : filteredQuestions) {
					if (selectedQuestions.size() >= numberOfQuestions) {
						break;
					}
					if (question.get("Type").equals(type)) {
						selectedQuestions.add(question);
						filteredQuestions.remove(question); // Remove to avoid duplicate selection
						break; // Move to the next type after selecting one question of the current type
					}
				}
				index = (index + 1) % types.size(); // Cycle through types in order
			}
		}

		return selectedQuestions;
	}

//	public static List<Map<String, String>> selectQuestions(List<Map<String, String>> questions, List<String> types, int numberOfQuestions, boolean randomSelection) {
//	    List<Map<String, String>> selectedQuestions = new ArrayList<>();
//	    List<Map<String, String>> filteredQuestions = new ArrayList<>();
//
//	    // Filter questions based on the specified types
//	    for (Map<String, String> question : questions) {
//	        if (types.contains(question.get("Type"))) {
//	            filteredQuestions.add(question);
//	        }
//	    }
//
//	    if (randomSelection) {
//	        Collections.shuffle(filteredQuestions); // Shuffle for random selection
//	    }
//
//	    // Create a map to track the count of questions added for each type
//	    Map<String, Integer> typeCounts = new HashMap<>();
//	    for (String type : types) {
//	        typeCounts.put(type, 0);
//	    }
//
//	    // Select questions based on the order of types provided
//	    for (String type : types) {
//	        for (Map<String, String> question : filteredQuestions) {
//	            if (selectedQuestions.size() >= numberOfQuestions) {
//	                return selectedQuestions; // Return if we've selected enough questions
//	            }
//	            if (question.get("Type").equals(type) && typeCounts.get(type) < numberOfQuestions / types.size()) {
//	                selectedQuestions.add(question);
//	                typeCounts.put(type, typeCounts.get(type) + 1);
//	                // Move to the next type after selecting one question of the current type
//	                if (typeCounts.get(type) >= numberOfQuestions / types.size()) {
//	                    break;
//	                }
//	            }
//	        }
//	    }
//
//	    // If we haven't reached the required number of questions, attempt to add more from remaining questions
//	    if (selectedQuestions.size() < numberOfQuestions) {
//	        for (Map<String, String> question : filteredQuestions) {
//	            if (selectedQuestions.size() >= numberOfQuestions) {
//	                break;
//	            }
//	            if (!selectedQuestions.contains(question)) {
//	                selectedQuestions.add(question);
//	            }
//	        }
//	    }
//
//	    return selectedQuestions;
//	}
	
	
	
	public static List<Integer> selectQuestionTypes(boolean randomizeOrder, int totalQuestions, Integer... questionTypes) {
	    // Convert the variable arguments into a List
	    List<Integer> selectedTypes = new ArrayList<>(Arrays.asList(questionTypes));

	    // Create a list for the final sequence of question types
	    List<Integer> finalQuestionTypes = new ArrayList<>();

	    // Ensure we generate the correct number of questions
	    for (int i = 0; i < totalQuestions; i++) {
	        // Cycle through the provided question types using modulo
	        int questionType = selectedTypes.get(i % selectedTypes.size());
	        finalQuestionTypes.add(questionType);
	    }

	    // Shuffle the list if randomizeOrder is true
	    if (randomizeOrder) {
	        Collections.shuffle(finalQuestionTypes);
	    }

	    return finalQuestionTypes;
	}

}
