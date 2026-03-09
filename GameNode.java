/**
 *
 * @author pierre
 */

//setup for linkedList for the recent games played
public class GameNode {
    private String gameName;
    private GameNode nextNode;
    
    public GameNode(String gameName) {
        this.gameName = gameName;
        this.nextNode = null;
    }
    
    public void setNext(GameNode next) {
        this.nextNode = next;
    }
    
    public GameNode getNext() {
        return this.nextNode;
    }
    
    public String getGameName() {
        return this.gameName;
    }
}
