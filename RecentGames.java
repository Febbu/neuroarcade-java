/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neuroarcade;

/**
 *
 * @author pierre
 */
public class RecentGames {
    private GameNode headNode;
    private int count;
    private final int MAX_GAMES = 10;
    
    public RecentGames() {
        this.headNode = null;
        this.count = 0;
    }
    
    // adding a game to the front of the list. The list will have the most recent first
    public void addGame(String gameName) {
        GameNode newNode = new GameNode(gameName);
        
        if (headNode == null) {
            headNode = newNode;
        } else {
            newNode.setNext(headNode);
            headNode = newNode;
        }
        
        count++;
        
        // delete the oldest if we have too much elements in the list
        if (count > MAX_GAMES) {
            removeOldest();
        }
    }
    
    // the method that will remove the oldest game played
    private void removeOldest() {
        if (headNode == null) return;
        
        if (headNode.getNext() == null) {
            headNode = null;
            count = 0;
            return;
        }
        
        GameNode current = headNode;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        count--;
    }
    
    // method that displays all recent games played
    public void displayRecentGames() {
        if (headNode == null) {
            System.out.println("No games played yet!");
            return;
        }
        
        System.out.println("\n=== Recent Games Played ===");
        GameNode current = headNode;
        int i = 1;
        
        while (current != null) {
            System.out.println(i + ". " + current.getGameName());
            current = current.getNext();
            i++;
        }
    }
    
    // method that clears the list of all the recent games played
    public void clearRecentGames() {
        headNode = null;
        count = 0;
        System.out.println("Recent games cleared!");
    }
}