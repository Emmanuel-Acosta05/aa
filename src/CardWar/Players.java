package CardWar;
import java.util.List;
import java.util.ArrayList;

public class Players {
    public List<Card> hand = new ArrayList<Card>();

    public Players() {
    }

    public Card flip(){
        System.out.println(hand.size());
        if(hand.size() != 0) {
            return hand.get(0);
        }
        throw new RuntimeException("L");
    }
    public void draw(Deck deck){
        hand.add(deck.draw());
    }

}