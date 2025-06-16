import java.util.ArrayList;
import java.util.Collections;
public class Main{
    public static ArrayList<Card> deck = new ArrayList<Card>();

    public static void main(String[] args){
        createDeck();
        Collections.shuffle(deck);
        for(Card c : deck){
            System.out.println(c.getCharacter());
        }
    }
    
    public static void createDeck(){
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 14; j++){
                String suit;
                if(i == 0){
                    suit = "S";
                }
                else if(i == 1){
                    suit = "C";
                }
                else if(i == 2){
                    suit = "D";
                }
                else{
                    suit = "H";
                }
                deck.add(new Card(j,suit+j,suit));
            }
        }
    }
}