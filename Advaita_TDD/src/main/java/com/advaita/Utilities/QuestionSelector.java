package com.advaita.Utilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QuestionSelector {

	  /**
     * Select a specific number of questions from a list.
     *
     * @param questions List of all available questions.
     * @param numberOfQuestions Number of questions to select.
     * @param randomSelection Whether to select questions randomly or not.
     * @return List of selected questions.
     */
    public static List<Map<String, String>> selectQuestions(List<Map<String, String>> questions, int numberOfQuestions, boolean randomSelection) {
        List<Map<String, String>> selectedQuestions = new ArrayList<>();

        if (randomSelection) {
            Collections.shuffle(questions); // Shuffle the list to ensure randomness
            for (int i = 0; i < Math.min(numberOfQuestions, questions.size()); i++) {
                selectedQuestions.add(questions.get(i));
            }
        } else {
            for (int i = 0; i < Math.min(numberOfQuestions, questions.size()); i++) {
                selectedQuestions.add(questions.get(i));
            }
        }

        return selectedQuestions;
    }
}
