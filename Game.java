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

public abstract class Game {
    protected String name;
    
    public Game(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // every game will have to have a play method
    public abstract int play(Scanner in);
}