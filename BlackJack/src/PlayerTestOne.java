import static java.lang.System.*;
import java.awt.Color;

public class PlayerTestOne
{
	public static void main( String args[] )
	{
		AbstractPlayer player = new AbstractPlayer();
		
		Deck deck = new Deck();
		deck.shuffle();
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		out.println("\n\ntoString");
		out.println(player);	
		
		out.println("\n\nhandValue");
		out.println(player.getHandValue());					
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		out.println("\n\ntoString");
		out.println(player);	
		
		out.println("\n\nhandValue");
		out.println(player.getHandValue());									
	}
}