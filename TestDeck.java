// package com.hackathon.dekofcards;

public class TestDeck {
	public static void main(String[] args) {
		Game ourGame =  new Game();
		Deck ourDeck = new Deck();
		ourDeck.shuffle();
		// System.out.println(ourDeck.deckSize());

		System.out.println("Welcome to DOJO BlackJack!");
		System.out.println("How many players are at the table?");
		String numberOfPlayers = System.console().readLine();
		for (int i = 0; i < Integer.parseInt(numberOfPlayers); i++) {
			System.out.println("What is player " + (i + 1) + "'s name?");
			String nameOfPlayer = System.console().readLine();
			Player player = new Player(nameOfPlayer);
			ourGame.setPlayers(player);
		}

		System.out.println("\n");
		System.out.println("\n");

		for (int i = ourGame.getPlayers().size() - 1; i >= 0; i--) {
			Player temp = ourGame.getPlayers().get(i);
			temp.setPlayerHand(ourDeck.getCards().get(0));
			ourDeck.getCards().remove(0);
		}
		for (int i = ourGame.getPlayers().size() - 1; i >= 0; i--) {
			Player temp = ourGame.getPlayers().get(i);
			temp.setPlayerHand(ourDeck.getCards().get(0));
			ourDeck.getCards().get(0).showCard();
			ourDeck.getCards().remove(0);
		}

		System.out.println("\n");
		System.out.println("\n");

		for (int i = ourGame.getPlayers().size() - 1; i >= 0; i--) {
			Player tempP = ourGame.getPlayers().get(i);
			System.out.printf("------------------- %s --------------------\n", tempP.getPlayerName());
			for (int j = 0; j < tempP.getPlayerHand().size(); j++) {
				Card tempC = tempP.getPlayerHand().get(j);
				tempC.showCard();
			}
			boolean bust = false;
			if (tempP.isBlackJack()) {
				System.out.println("BLACKJACK... winner, winner, chicken dinner!");
				break;
			}
			while (!bust) {
				System.out.println("hit --OR-- stand: ");
				String playerAction = System.console().readLine();
				if (playerAction.equals("hit")) {
					tempP.setPlayerHand(ourDeck.getCards().get(0));
					ourDeck.getCards().get(0).showCard();
					ourDeck.getCards().remove(0);
				} else if (playerAction.equals("stand")) {
					break;
				} else {
					System.out.println("That's not a valid action");
				}
				bust = tempP.isBust();
			}
		}

		int dealerTotal = ourGame.getPlayers().get(0).cardTotal();
		for (int i = 1; i < ourGame.getPlayers().size(); i++) {
			Player tempP = ourGame.getPlayers().get(i);
			if (!tempP.getBust()) {
				if (tempP.cardTotal() < dealerTotal) {
					System.out.printf("%s -- YOU LOSE THIS HAND!\n", tempP.getPlayerName());
				} else {
					System.out.printf("%s -- YOU'VE WON A NEW CAR... or maybe just double your chips...\n", tempP.getPlayerName());
				}
			}
		}

		// System.out.println(ourDeck.deckSize());
		// System.out.println(ourGame.getPlayers().toString());
		// while (blackjack) {

		// }
		
	}
}
