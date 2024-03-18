public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

	public Card(int face, String suit)
	{
		this.face = face;
		this.suit = suit;
	}

	public void setFace(int face)
	{
		this.face = face;
	}

	public void setSuit(String suit)
	{
		this.suit = suit;
	}

	public int getFace()
	{
		return face;
	}

	public String getSuit()
	{
		return suit;
	}

	public abstract int getValue();

	public boolean equals(Object obj)
	{
		if(obj instanceof Card)
		{
			Card other = (Card)obj;
			return this.face == other.face && this.suit.equals(other.suit);
		}
		return false;
	}

	public String toString()
	{
		return FACES[face] + " of " + suit;
	}
}