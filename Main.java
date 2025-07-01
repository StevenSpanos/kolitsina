import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main{
    public static ArrayList<Card> deck = new ArrayList<Card>();
    public static Player player;
    public static Player ai;
    public static ArrayList<Card> table = new ArrayList<Card>(); 
    public static int round = 0;
    public static void main(String[] args){
        createDeck();
        Collections.shuffle(deck);
        for(Card c : deck){
            System.out.println(c.getCharacter());
        }
        player = new Player();
        ai = new Player();
        for(int i = 0; i < 4; i++){
            table.add(deck.get(1));
            deck.remove(0);
        }
        if((round != 0) && (player.hand.size() <= 0)){
            player.deal();
        }
        if((round != 0) && (ai.hand.size() <= 0)){
            ai.deal();
        }
        while(1 > 0){
        printTable();
        turn();
        }
    }
    
    public static void printTable(){
        System.out.println("Deck: " + deck.size());
        System.out.println("AI:");
        for(int i = 0; i < ai.hand.size(); i++){
            System.out.print("["+ai.hand.get(i).getCharacter()+"]");
        }
        System.out.println(" ");
        System.out.println("Table:");
        for(int i = 0; i < table.size(); i++){
            System.out.print("["+table.get(i).getCharacter()+"]");
        }
        System.out.println(" ");
        System.out.println("Hand:");
        for(int i = 0; i < player.hand.size(); i++){
            System.out.print("["+player.hand.get(i).getCharacter()+"]");
        }
        System.out.println();
        System.out.println("Cards: " + player.getCards());
        System.out.println("Spades: " + player.getSpades());
        System.out.println((player.getTwo() ? "S2 " : "") + (player.getTen() ? "D10" : ""));
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

    public static void turn(){
        if(round % 2 == 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the card you want to use.");
            for(int i = 0; i < player.hand.size(); i++){System.out.print(i + " ");}
            System.out.println();
            int choice = scanner.nextInt();
            String action = "";
            while(!(action.equals("capture") || action.equals("add") || action.equals("drop"))){
            System.out.println("Capture, Add, or Drop?");
            action = scanner.nextLine();
            action.toLowerCase();
            }
            if(action.equals("capture")){
                System.out.println("Which card do you want to capture?");
                for(int i = 0; i < 4; i++){System.out.print(i + " ");}
                System.out.println();
                int cap = scanner.nextInt();
                capture(cap, choice, player);
            }
            else if(action.equals("add")){

            }
            else if(action.equals("drop")){
                table.add(player.hand.remove(choice));
            }
        }
    else{
        aiTurn();
    }
    round++;
    }

    public static void capture(int cap, int choice, Player player){
        if(table.get(cap).getValue() == player.hand.get(choice).getValue()){
            System.out.println("Capture Successful.");
            player.captured += 2;
        if(table.remove(cap).getCharacter().substring(0,1).equals("S")){
            player.spades++;
        }
        if(player.hand.remove(cap).getCharacter().substring(0,1).equals("S")){
            player.spades++;
        }
        }
    }

    public static void aiTurn(){
        //checks for spades in hand
        for(int i = 0; i < ai.hand.size(); i++){
            Card x = ai.hand.get(i);
            System.out.println("Checking card " + x.getCharacter() + " in AI");
            if(x.getCharacter().substring(0,1).equals("S")){ //checks spades on table
                for(int j = 0; j < table.size(); j++){
                    Card y = table.get(j);
                    System.out.println("Checking card " + y.getCharacter() + " in Table");
                    if(y.getValue() == x.getValue()){
                        capture(i, j, ai);
                        return;
                    }
                }
            }
        }
        //checks for spades in table
        for(int i = 0; i < table.size(); i++){
            Card x = table.get(i);
            if(x.getCharacter().substring(0,1).equals("S")){
                for(int j = 0; j < ai.hand.size(); j++){
                    Card y = ai.hand.get(j);
                    if(y.getValue() == x.getValue()){
                        capture(j,i, ai);
                        return;
                    }
                }
            }
        }
    }
}