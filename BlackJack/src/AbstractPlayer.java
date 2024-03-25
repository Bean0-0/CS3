import java.util.ArrayList;
import java.util.List;

public class AbstractPlayer implements Playerable {
    protected List<Card> hand;
    protected int winCount;

    public AbstractPlayer() {
        hand = new ArrayList<>();
        winCount = 0;
    }

    public void addCardToHand(Card temp) {
        hand.add(temp);
    }

    public void resetHand() {
        hand.clear();
    }

    public boolean hit() {
        // This method will be implemented by the subclasses
        return false;
    }

    public void setWinCount(int numWins) {
        winCount = numWins;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getHandSize() {
        return hand.size();
    }

    public int getHandValue() {
        int total = 0;
        for (Card card : hand) {
            total += card.getValue();
        }
        return total;
    }

    public String toString()
    {
        return "hand = " + hand.toString() + " \n- # wins " + winCount;
    }
}