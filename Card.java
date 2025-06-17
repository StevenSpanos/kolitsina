public class Card{
    private int value;
    private String suit;
    private String character;
    public Card(){
        value = -1;
        character = " ";
        suit = "PP";
    }
    public Card(int v, String c, String s){
        value = v;
        character = c;
        if(v == 11){
            character = s + "J";
        }
        if(v == 12){
            character = s + "Q";
        }
        if(v == 13){
            character = s + "K";
        }
        suit = s;
    }
    
    public int getValue(){return value;}
    public String getCharacter(){return character;}
}