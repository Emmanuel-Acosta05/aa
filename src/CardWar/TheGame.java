package CardWar;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class TheGame {

    public static void  main(String[] args) throws IOException {

        Writer gamewrite = new Writer("GameResults.txt"); //File writer

        Deck deck = new Deck(); // game deck declaration
        Player p1 = new Player(); // player declaration
        Player npc = new Player(); // Dealer declaration
        deck.shuffle(); // shuffle the deck

        ArrayList<Card> pile = new ArrayList<Card>(); //card pile in the case of war

        for(int i = 0; i < 52; i++){ //each player draws a card one after the other
            if(i % 2 == 0 ) {
                p1.draw(deck);
            }else{
                npc.draw(deck);
            }
        }
        while(p1.hand.size() != 0 && npc.hand.size() != 0) { //The game runs as players are not at 0 cards
            Card p1card = p1.flip(); // player flips the card
            gamewrite.addLine("You: "); //Displays you
            gamewrite.addLine(p1card.getname());// The card you drew

            gamewrite.addLine("\nThe Dealer: "); //Dealer's turn
            Card npccard = npc.flip(); // Dealer's card is flipped
            gamewrite.addLine(npccard.getname()); //gets the dealer's card
            System.out.println();

            //removes the first card in both player's hand
            p1card = p1.hand.remove(0);
            npccard = npc.hand.remove(0);

            gamewrite.addLine("");

            if(p1card.getval() > npccard.getval()){ //If the player's hand is greater
                p1.hand.add(p1card);// adds the card drawn back
                p1.hand.add(npccard);// adds the dealer's card back to your hand

                p1.hand.addAll(pile);// in the case of war, adds the pile from the war
                pile.clear();

                gamewrite.addLine("You won the round! \n=============="); //player win message
            }
            else if (npccard.getval() > p1card.getval()) {
                npc.hand.add(p1card); // adds the card back
                npc.hand.add(npccard); //adds the dealer's card back to their pile

                npc.hand.addAll(pile);// in the case of war, adds the pile from the war
                pile.clear();

                gamewrite.addLine("Dealer has won the round. \n==============" ); //Dealer win message
            }
            else{
                gamewrite.addLine("THIS IS WAR!"); //War begins
                if(p1.hand.size() > 3 && npc.hand.size() > 3) { // check for the hand size before war begins
                    for (int i = 0; i < 3; i++) {
                        //flips 3 cards from both players and adds them to the pile array
                        pile.add(p1.flip());
                        p1.hand.remove(0);

                        pile.add(npc.flip());
                        npc.hand.remove(0);
                    }
                }
                pile.add(p1card); //the 4th card that is used for evaluation is added to the pile
                pile.add(npccard);
            }
            if(p1.hand.size() >= 52 || npc.hand.size() == 0 ){ //win condition for the player
                gamewrite.addLine("============================" +
                        "\n     YOU WON THE GAME!" +
                        "\n============================");
                gamewrite.addLine(Integer.toString(p1.hand.size()));// displays hand size when winning
                gamewrite.save();
                break;
            } else if (npc.hand.size() == 52 || p1.hand.size() == 0) {// win condition for the dealer
                gamewrite.addLine("============================" +
                        "\nThe Dealer has won the game." +
                        "\n============================");
                gamewrite.addLine(Integer.toString(npc.hand.size())); // displays hand size
                gamewrite.save();
                break;
            }
        }
    }
}