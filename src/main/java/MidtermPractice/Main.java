package MidtermPractice;

import java.util.ArrayList;
import java.util.Random;

public class Main { {}
    public static void main(String[] args) {
        Random myRand = new Random();

        String[] suites = {
                "Clubs",
                "Diamonds",
                "Hearts",
                "Spades"
        };

        String[] values = {
                "A", "2", "3", "4", "5", "6", "7", "8", "9"," 10", "J", "Q", "K"
        };

        final ArrayList<PlayingCard> deck = new ArrayList<>();

        for (String suite : suites) {
            for (String value : values) {
                deck.add(new PlayingCard(suite, value));
            }
        }

        final ArrayList<PlayingCard> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // loops until we find a card that isn't a duplicate
            boolean findCard = true;
            while (findCard) {
                int pos = myRand.nextInt(51);
                PlayingCard card = deck.get(pos);
                if (!hand.contains(card)) {
                    hand.add(card);
                    findCard = false;
                }
            }
        }

        for (PlayingCard card : hand) {
            System.out.println(card);
        }
    }
}
