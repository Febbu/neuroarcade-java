/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.neuroarcade;

/**
 *
 * @author pierre
 */

import java.util.Scanner;
import java.util.ArrayList;

public class NeuroArcade {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Game> games = new ArrayList<>();
        ArrayList<ScoreTracker> scoreTrackers = new ArrayList<>();
        RecentGames recentGames = new RecentGames();
        
        // adding the games and the score trackers of the games
        games.add(new NumberGuesser());
        scoreTrackers.add(new ScoreTracker());
        
        games.add(new MathQuiz());
        scoreTrackers.add(new ScoreTracker());
        
        games.add(new WordScramble());
        scoreTrackers.add(new ScoreTracker());
        
        games.add(new TriviaQuiz());
        scoreTrackers.add(new ScoreTracker());
        
        System.out.println("Welcome to NeuroArcade!");
        System.out.println("Take a break and play a quick game.\n");
        
        while (true) {
            System.out.println("\n=== Main Menu ===");
            
            // show all the games games in the main menu
            for (int i = 0; i < games.size(); i++) {
                System.out.println((i + 1) + ". " + games.get(i).getName());
            }
            System.out.println((games.size() + 1) + ". View All High Scores");
            System.out.println((games.size() + 2) + ". View Recent Games");
            System.out.println((games.size() + 3) + ". Exit");
            
            System.out.print("\nEnter your choice: ");
            String input = scanner.nextLine();
            
            // checking for the admin menu as input and calling it
            if (input.equalsIgnoreCase("admin")) {
                adminMenu(scanner, games, scoreTrackers, recentGames);
                continue;
            }
            
            // trying to convert to a number
            try {
                int choice = Integer.parseInt(input);
                
                // checkin if player wants to view the high scores
                if (choice == games.size() + 1) {
                    displayAllHighScores(games, scoreTrackers);
                    continue;
                }
                
                // checking if user wants to view recent games
                if (choice == games.size() + 2) {
                    recentGames.displayRecentGames();
                    continue;
                }
                
                // checking if user wants to exit
                if (choice == games.size() + 3) {
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                }
                
                // checking if the game choice is valid
                if (choice >= 1 && choice <= games.size()) {
                    Game selectedGame = games.get(choice - 1);
                    ScoreTracker tracker = scoreTrackers.get(choice - 1);
                    
                    int score = selectedGame.play(scanner);
                    tracker.addScore(score);
                    recentGames.addGame(selectedGame.getName());
                    
                    // show all the stats for this game
                    System.out.println("\n--- Your Stats for " + selectedGame.getName() + " ---");
                    tracker.displayScores();
                    System.out.println("High Score: " + tracker.getHighScore());
                    System.out.printf("Average: %.1f\n", tracker.getAverage());
                    
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    
    // this meethod will display all high scores
    public static void displayAllHighScores(ArrayList<Game> games, ArrayList<ScoreTracker> trackers) {
        System.out.println("\n=== High Scores ===");
        for (int i = 0; i < games.size(); i++) {
            System.out.print(games.get(i).getName() + ": ");
            if (trackers.get(i).getCount() > 0) {
                System.out.println(trackers.get(i).getHighScore());
            } else {
                System.out.println("No scores yet");
            }
        }
    }
    
    // admin menu method
    public static void adminMenu(Scanner scanner, ArrayList<Game> games, 
                                 ArrayList<ScoreTracker> scoreTrackers, RecentGames recentGames) {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. View All High Scores");
            System.out.println("2. Reset All Scores");
            System.out.println("3. Clear Recent Games");
            System.out.println("4. Back to Main Menu");
            
            System.out.print("\nEnter choice: ");
            String input = scanner.nextLine();
            
            try {
                int choice = Integer.parseInt(input);
                
                if (choice == 1) {
                    // view all high scores
                    System.out.println("\n=== All High Scores ===");
                    for (int i = 0; i < games.size(); i++) {
                        System.out.print(games.get(i).getName() + ": ");
                        if (scoreTrackers.get(i).getCount() > 0) {
                            System.out.println(scoreTrackers.get(i).getHighScore());
                        } else {
                            System.out.println("No scores yet");
                        }
                    }
                    
                } else if (choice == 2) {
                    // reseting all the scores scores with confirmation of user
                    System.out.print("Are you sure? (yes/no): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        for (int i = 0; i < scoreTrackers.size(); i++) {
                            scoreTrackers.set(i, new ScoreTracker());
                        }
                        System.out.println("All scores reset!");
                    } else {
                        System.out.println("Reset cancelled.");
                    }
                    
                } else if (choice == 3) {
                    // clearing last played games
                    recentGames.clearRecentGames();
                    
                } else if (choice == 4) {
                    // go back
                    System.out.println("Returning to main menu...");
                    break;
                    
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}