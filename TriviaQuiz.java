/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neuroarcade;

/**
 *
 * @author pierre
 */
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TriviaQuiz extends Game {
    
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    
    public TriviaQuiz() {
        super("Trivia Quiz");
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        loadTriviaFromFile();
    }
    
    // This method will load the trivia questions from the file
    private void loadTriviaFromFile() {
        try {
            File file = new File("src/main/java/com/mycompany/neuroarcade/trivia.txt");
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine()) {
                String question = fileScanner.nextLine();
                if (fileScanner.hasNextLine()) {
                    String answer = fileScanner.nextLine();
                    questions.add(question);
                    answers.add(answer);
                }
            }
            
            fileScanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: trivia.txt file not found!");
            System.out.println("Please create a trivia.txt file in the same folder.");
            
            // Adding some default questions if file not found
            questions.add("What is 1 + 1?");
            answers.add("2");
            questions.add("What color is the sky?");
            answers.add("blue");
        }
    }
    
    @Override
    public int play(Scanner in) {
        if (questions.size() == 0) {
            System.out.println("No trivia questions available!");
            return 0;
        }
        
        Random rand = new Random();
        int correctAnswers = 0;
        int totalQuestions = Math.min(5, questions.size());
        
        System.out.println("\n--- Trivia Quiz ---");
        System.out.println("Answer " + totalQuestions + " trivia questions!");
        
        // keeping track of the questions that have already been asked
        ArrayList<Integer> askedQuestions = new ArrayList<>();
        
        for (int i = 1; i <= totalQuestions; i++) {
            // picking a random question that has not been asked
            int questionIndex;
            do {
                questionIndex = rand.nextInt(questions.size());
            } while (askedQuestions.contains(questionIndex));
            
            askedQuestions.add(questionIndex);
            
            String question = questions.get(questionIndex);
            String correctAnswer = answers.get(questionIndex);
            
            System.out.println("\nQuestion " + i + ": " + question);
            System.out.print("Your answer: ");
            
            String userAnswer = in.nextLine().trim();
            
            // checking if answer is correct without the case sensitivity
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Wrong! The answer was: " + correctAnswer);
            }
        }
        
        // calculating the score
        int score = correctAnswers * 20;
        System.out.println("\nYou got " + correctAnswers + " out of " + totalQuestions + " correct!");
        System.out.println("Your score: " + score);
        
        return score;
    }
}