import java.util.ArrayList;
public class Player {
    public ArrayList<Card> hand = new ArrayList<Card>();
    private int captured = 0;
    private int spades = 0;
    private boolean hasTwo = false;
    private boolean hasTen = false;
    public Player(){
        for(int i = 0; i < 4; i++){
        hand.add(Main.deck.get(0));
        Main.deck.remove(0);
        }
    }

    public int getCards(){return captured;}
    public int getSpades(){return spades;}
    public boolean getTwo(){return hasTwo;}
    public boolean getTen(){return hasTen;}
}
