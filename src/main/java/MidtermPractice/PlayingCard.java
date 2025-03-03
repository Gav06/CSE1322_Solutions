package MidtermPractice;

public class PlayingCard {

    private String suit;
    private String value;

    public PlayingCard(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }

}
