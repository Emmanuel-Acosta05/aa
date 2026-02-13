package CardWar;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

    List<Card> cardstack = new ArrayList<Card>(); //array for the card deck before shuffling
    List<String> ctype = Arrays.asList("Diamonds", "Spades", "Clubs", "Hearts"); //array for all the card suits

    public Deck(){
        for (int i = 2; i < 15; i++){ //for loop for card creation
            for(String ctypes : ctype) {
                cardstack.add(new Card(i, ctypes));
            }
        }
    }
    public void shuffle(){ //Shuffles the card deck
            Collections.shuffle(cardstack);
    }
    public Card draw(){ //Draws a card from the deck
        return cardstack.remove(0);
    }
}
