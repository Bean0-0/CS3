import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
	private ArrayList<Playerable> players;

	public BlackJack() {
		players = new ArrayList<>();
		players.add(new Dealer()); // Dealer at position 0
		// Add players to the game
		players.add(new AbstractPlayer());
		players.add(new AbstractPlayer());
		// Add more players as needed
	}

	public void playGame() {
		Scanner keyboard = new Scanner(System.in);
		String choice;

		do {
			// Dealer shuffles the deck
			Dealer dealer = (Dealer) players.get(0);
			dealer.shuffle();

			// Deal two cards to each player
			for (Playerable player : players) {
				player.addCardToHand(dealer.deal());
				player.addCardToHand(dealer.deal());
			}

			// Allow each player to hit
			for (Playerable player : players) {
				System.out.println("Current hand " + player.toString());

				while (player.getHandValue() < 21) {
					System.out.println("Do you want to hit? [Y/N]");
					choice = keyboard.next().toUpperCase();

					if (choice.equals("Y")) {
						player.addCardToHand(dealer.deal());
						System.out.println("Current hand " + player.toString());
					} else {
						break;
					}
				}
			}

			// Print each player's hand
			for (Playerable player : players) {
				System.out.println("PLAYER\n" + "Hand Value :: " + player.getHandValue() + "\nHand Size :: " + player.getHandSize() + "\nCards in Hand :: " + player.toString());
			}

			// Determine the winner and update the win total
			int dealerValue = players.get(0).getHandValue();
			for (int i = 1; i < players.size(); i++) {
				int playerValue = players.get(i).getHandValue();

				if ((playerValue > dealerValue && playerValue <= 21) || dealerValue > 21) {
					System.out.println("Player " + i + " wins!");
				} else if ((dealerValue > playerValue && dealerValue <= 21) || playerValue > 21) {
					System.out.println("Dealer wins against player " + i + "!");
				} else {
					System.out.println("Player " + i + " and dealer tie!");
				}
			}

			System.out.println("\nDo you want to play again? [Y,y,N,n] ::");
			choice = keyboard.next().toUpperCase();

			// Reset hands for the next game
			for (Playerable player : players) {
				player.resetHand();
			}

		} while (choice.equals("Y"));
	}

	public static void main(String[] args) {
		BlackJack game = new BlackJack();
		game.playGame();
	}
}