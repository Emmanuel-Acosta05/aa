package CardWar;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

    List<Card> cardstack = new ArrayList<Card>();
    List<String> ctype = Arrays.asList("Diamonds", "Spades", "Clubs", "Hearts");

    public Deck(){
        for (int i = 2; i < 15; i++){
            for(String ctypes : ctype) {
                cardstack.add(new Card(i, ctypes));
            }
        }
    }
    public void shuffle(){
            Collections.shuffle(cardstack);
    }
    public Card draw(){
        return cardstack.remove(0);
    }
}
