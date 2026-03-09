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

public class MathQuiz extends Game {
    
    public MathQuiz() {
        super("Math Quiz");
    }
    
    @Override
    public int play(Scanner in) {
        Random rand = new Random();
        int correctAnswers = 0;
        int totalQuestions = 5;
        
        System.out.println("\n--- Math Quiz ---");
        System.out.println("Solve 5 math problems!");
        
        for (int i = 1; i <= totalQuestions; i++) {
            // generating two random numbers
            int num1 = rand.nextInt(20) + 1;  // Random number from 1 to 20
            int num2 = rand.nextInt(20) + 1;  // Random number from 1 to 20
            int operation = rand.nextInt(3);  // This will give us what operation to use in the math question
            
            int correctAnswer = 0;
            String operatorSymbol = "";
            
            // determine operation
            switch (operation) {
                case 0:  // this will make an addition
                    correctAnswer = num1 + num2;
                    operatorSymbol = "+";
                    break;
                case 1:  // this will make a subtraction
                    correctAnswer = num1 - num2;
                    operatorSymbol = "-";
                    break;
                case 2:  // and this will nake a multiplication
                    correctAnswer = num1 * num2;
                    operatorSymbol = "*";
                    break;
            }
            
            // dispülay the question to ask
            System.out.println("\nQuestion " + i + ":");
            System.out.print(num1 + " " + operatorSymbol + " " + num2 + " = ");
            
            try {
                int userAnswer = Integer.parseInt(in.nextLine());
                
                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("Wrong! The answer was " + correctAnswer);
                }
                
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Question skipped.");
            }
        }
        
        // calculating the score
        int score = correctAnswers * 20;  // 20 points for every correct answer
        System.out.println("\nYou got " + correctAnswers + " out of " + totalQuestions + " correct!");
        System.out.println("Your score: " + score);
        
        return score;
    }
}