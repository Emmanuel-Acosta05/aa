package CardWar;
import java.util.List;
import java.util.ArrayList;

public class Player {
    public List<Card> hand = new ArrayList<Card>(); //array for the player's hand

    public Player() {
    }

    public Card flip(){
        if(hand.size() != 0) {
            return hand.get(0);
        }
        throw new RuntimeException("L");
    }
    public void draw(Deck deck){
        hand.add(deck.draw());
    }

}