package CardWar;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class TheGame {

    public static void  main(String[] args) throws IOException {

        Writer gamewrite = new Writer("GameResults.txt");

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
            gamewrite.addLine("You: ");
            gamewrite.addLine(p1card.getname());

            gamewrite.addLine("\nThe Dealer: ");
            Card npccard = npc.flip();
            gamewrite.addLine(npccard.getname());
            System.out.println();

            p1card = p1.hand.remove(0);
            npccard = npc.hand.remove(0);

            gamewrite.addLine("");

            if(p1card.getval() > npccard.getval()){
                p1.hand.add(p1card);
                p1.hand.add(npccard);

                p1.hand.addAll(pile);
                pile.clear();

                gamewrite.addLine("You won the round! \n==============");
            }
            else if (npccard.getval() > p1card.getval()) {
                npc.hand.add(p1card);
                npc.hand.add(npccard);

                npc.hand.addAll(pile);
                pile.clear();

                gamewrite.addLine("Dealer has won the round. \n==============" );
            }
            else{
                gamewrite.addLine("THIS IS WAR!");
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
                gamewrite.addLine("============================" +
                        "\n     YOU WON THE GAME!" +
                        "\n============================");
                gamewrite.addLine(Integer.toString(p1.hand.size()));
                gamewrite.save();
                break;
            } else if (npc.hand.size() == 52 || p1.hand.size() == 0) {
                gamewrite.addLine("============================" +
                        "\nThe Dealer has won the game." +
                        "\n============================");
                gamewrite.addLine(Integer.toString(npc.hand.size()));
                gamewrite.save();
                break;
            }
        }
    }
}