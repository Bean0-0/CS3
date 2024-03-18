public class BlackJackCard extends Card
{
	public BlackJackCard()
	{
		super(1, "HEARTS");
	}

	public BlackJackCard(int face, String suit)
	{
		super(face, suit);
	}

	public int getValue()
	{
		if(getFace() > 10)
		{
			return 10;
		}
		else if(getFace() == 1)
		{
			return 11;
		}
		else
		{
			return getFace();
		}
	}
}