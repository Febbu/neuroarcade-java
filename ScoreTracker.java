/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neuroarcade;

/**
 *
 * @author pierre
 */
public class ScoreTracker {
    private int[] scores;
    private int count;  // counts the scores we have added in array
    private final int MAX_SCORES = 5;
    
    public ScoreTracker() {
        scores = new int[MAX_SCORES];
        count = 0;
    }
    
    // adding a new score to array
    public void addScore(int score) {
        if (count < MAX_SCORES) {
            scores[count] = score;
            count++;
        } else {
            // shifting all the scores to the left and adding a new one at the end
            for (int i = 0; i < MAX_SCORES - 1; i++) {
                scores[i] = scores[i + 1];
            }
            scores[MAX_SCORES - 1] = score;
        }
    }
    
    // getting the highest score to be displayed
    public int getHighScore() {
        if (count == 0) return 0;
        
        int highest = scores[0];
        for (int i = 1; i < count; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }
        return highest;
    }
    
    // getting the average score to be displayed
    public double getAverage() {
        if (count == 0) return 0.0;
        
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += scores[i];
        }
        return (double) sum / count;
    }
    
    // display all the scores
    public void displayScores() {
        if (count == 0) {
            System.out.println("No scores yet!");
            return;
        }
        
        System.out.print("Recent scores: ");
        for (int i = 0; i < count; i++) {
            System.out.print(scores[i]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    public int getCount() {
        return count;
    }
}