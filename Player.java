import java.util.ArrayList;
public class Player {
    public ArrayList<Card> hand = new ArrayList<Card>();
    public Player(){
        for(int i = 0; i < 4; i++){
        hand.add(Main.deck.get(0));
        Main.deck.remove(0);
        }
    }
}
