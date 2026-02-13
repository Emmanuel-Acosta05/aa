package CardWar;

public class Card {

        private int cardval;
        private String cname;

    public Card( int newval, String ctype){
            cardval = newval;

            switch (newval) { //All the cards
                case 2: cname = "2"; break;
                case 3: cname = "3"; break;
                case 4: cname = "4"; break;
                case 5: cname = "5"; break;
                case 6: cname = "6"; break;
                case 7: cname = "7"; break;
                case 8: cname = "8"; break;
                case 9: cname = "9"; break;
                case 10: cname = "10"; break;
                case 11: cname = "Jack"; break;
                case 12: cname = "Queen"; break;
                case 13: cname = "King"; break;
                case 14: cname = "Ace"; break;
            }
            cname += " of " + ctype + " ";
        }

        public int getval() {
            return cardval;
        }
        public String getname(){
            return  cname;
        }
    }