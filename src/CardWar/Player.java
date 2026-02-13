package CardWar;
import java.util.List;
import java.util.ArrayList;

public class Player {
    public List<Card> hand = new ArrayList<Card>(); //array for the player's hand

    public Player() { //Player method
    }

    public Card flip(){ //gets the card in the first (0) array slot
        if(hand.size() != 0) { //check to have cards in hand
            return hand.get(0);
        }
        throw new RuntimeException("Ran out of cards. . .");// error exception when no cards are available
    }
    public void draw(Deck deck){ //draws from the deck to your hand
        hand.add(deck.draw());
    }

}