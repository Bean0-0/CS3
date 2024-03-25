import java.util.ArrayList;

public class Dealer extends AbstractPlayer {
    private Deck deck;

    public Dealer() {
        super();
        deck = new Deck();
    }

    public void shuffle() {
        deck.shuffle();
    }

    public Card deal() {
        return deck.nextCard();
    }

    @Override
    public boolean hit() {
        return getHandValue() <= 16;
    }
}