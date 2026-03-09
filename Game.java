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
