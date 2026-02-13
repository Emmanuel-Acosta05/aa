package CardWar;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;


public class TheGame {

    public static void  main(String[] args) throws IOException {

    public class{
            public void FileWriter gamewrite = new FileWriter("GameResult.txt");
            try{
            public void filelogger(String msg){
                    System.out.println(msg);
                    gamewrite.write(msg);
                } catch (IOException e){
                System
                }
            }
        }
        Deck deck = new Deck();
        Players p1 = new Players();
        Players npc = new Players();
        deck.shuffle();

        ArrayList<Card> pile = new ArrayList<Card>();

        for(int i = 0; i < 52; i++){
            if(i % 2 == 0 ) {
                p1.draw(deck);
            }else{
                npc.draw(deck);
            }
        }
        while(p1.hand.size() != 0 && npc.hand.size() != 0) {
            Card p1card = p1.flip();
            System.out.println("You: ");
            p1card.cdata();

            System.out.println("\n=========");

            System.out.println("\nThe Dealer: ");
            Card npccard = npc.flip();
            npccard.cdata();
            System.out.println();

            p1card = p1.hand.remove(0);
            npccard = npc.hand.remove(0);

            if(p1card.getval() > npccard.getval()){
                p1.hand.add(p1card);
                p1.hand.add(npccard);

                p1.hand.addAll(pile);
                pile.clear();

                System.out.println("You won the round!");
            }
            else if (npccard.getval() > p1card.getval()) {
                npc.hand.add(p1card);
                npc.hand.add(npccard);

                npc.hand.addAll(pile);
                pile.clear();

                System.out.println("Dealer has won the round." );
            }
            else{
                System.out.println("THIS IS WAR!");
                if(p1.hand.size() > 3 && npc.hand.size() > 3) {
                    for (int i = 0; i < 3; i++) {

                        pile.add(p1.flip());
                        p1.hand.remove(0);

                        pile.add(npc.flip());
                        npc.hand.remove(0);
                    }
                }
                pile.add(p1card);
                pile.add(npccard);
            }
            if(p1.hand.size() >= 52 || npc.hand.size() == 0 ){
                System.out.println("===============================\nYOU WON THE GAME!\n===============================");
                break;
            } else if (npc.hand.size() == 52 || p1.hand.size() == 0) {
                System.out.println("===============================\nThe Dealer has won the game.\n===============================");
                break;
            }
        }
    }
}