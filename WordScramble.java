/**
 *
 * @author pierre
 */
import java.util.Scanner;
import java.util.Random;

public class WordScramble extends Game {
    
    // an array of words to scramble
    private String[] words = {
        "java", "computer", "programming", "keyboard", "mouse",
        "screen", "internet", "software", "hardware", "developer",
        "algorithm", "database", "network", "function", "variable"
    };
    
    public WordScramble() {
        super("Word Scramble");
    }
    
    @Override
    public int play(Scanner in) {
        Random rand = new Random();
        int correctAnswers = 0;
        int totalWords = 5;
        
        System.out.println("\n--- Word Scramble ---");
        System.out.println("Unscramble 5 words!");
        
        for (int i = 1; i <= totalWords; i++) {
            // picking out a random word
            String originalWord = words[rand.nextInt(words.length)];
            String scrambledWord = scrambleWord(originalWord);
            
            // making sure the word is really scrambled
            while (scrambledWord.equals(originalWord)) {
                scrambledWord = scrambleWord(originalWord);
            }
            
            System.out.println("\nWord " + i + ": " + scrambledWord);
            System.out.print("Your answer: ");
            
            String userAnswer = in.nextLine().trim().toLowerCase();
            
            if (userAnswer.equals(originalWord)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Wrong! The word was: " + originalWord);
            }
        }
        
        // calculating the score
        int score = correctAnswers * 20;
        System.out.println("\nYou got " + correctAnswers + " out of " + totalWords + " correct!");
        System.out.println("Your score: " + score);
        
        return score;
    }
    
    // this is the method that will scramble the words
    private String scrambleWord(String word) {
        char[] letters = word.toCharArray();
        Random rand = new Random();
        
        // shuffling the letters
        for (int i = 0; i < letters.length; i++) {
            int randomIndex = rand.nextInt(letters.length);
            
            // swapping letters around
            char temp = letters[i];
            letters[i] = letters[randomIndex];
            letters[randomIndex] = temp;
        }
        
        return new String(letters);
    }
}
