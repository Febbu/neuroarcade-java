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

public class NumberGuesser extends Game {
    
    public NumberGuesser() {
        super("Number Guesser");
    }
    
    @Override
    public int play(Scanner in) {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;  // random number from 1 to a 100
        int attempts = 0;
        
        System.out.println("\n--- Number Guesser ---");
        System.out.println("Guess a number between 1 and 100!");
        
        while (true) {
            System.out.print("Enter your guess: ");
            
            try {
                int guess = Integer.parseInt(in.nextLine());
                attempts++;
                
                if (guess == number) {
                    System.out.println("Correct! You got it in " + attempts + " tries!");
                    break;
                } else if (guess < number) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Try again!");
            }
        }
        
        // score is based on the number of attemps
        int score = 100 - attempts;
        if (score < 0) score = 0;
        
        System.out.println("Your score: " + score);
        return score;
    }
}