import java.util.ArrayList;
public class Player {
    public ArrayList<Card> hand = new ArrayList<Card>();
    public int captured = 0;
    public int spades = 0;
    private boolean hasTwo = false;
    private boolean hasTen = false;
    public Player(){
        deal();
    }
    public void deal(){for(int i = 0; i < 4; i++){
        hand.add(Main.deck.get(0));
        Main.deck.remove(0);
        }}
    public int getCards(){return captured;}
    public int getSpades(){return spades;}
    public boolean getTwo(){return hasTwo;}
    public boolean getTen(){return hasTen;}
}
