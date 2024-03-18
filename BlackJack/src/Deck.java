import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		stackOfCards = new ArrayList<Card>();
		for (int suit = 0; suit < NUMSUITS; suit++)
		{
			for (int face = 1; face <= NUMFACES; face++)
			{
				stackOfCards.add(new BlackJackCard(face, SUITS[suit]));
			}
		}
		topCardIndex = stackOfCards.size() - 1;
	}

	public int size()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
		return topCardIndex + 1;
	}

	public void shuffle()
	{
		Collections.shuffle(stackOfCards);
		topCardIndex = stackOfCards.size() - 1;
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	}
}