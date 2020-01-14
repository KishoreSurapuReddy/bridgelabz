package com.bridgelabz.deckofcards;

public class DeckOfCards {

	int[] deck = new int[52];
	static String[] shuffel = new String[52];
	String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
	String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

	static String[] player1 = new String[9];
	static String[] player2 = new String[9];
	static String[] player3 = new String[9];
	static String[] player4 = new String[9];

	public void deckOfShuffelCards() {
		// Initialize cards
		for (int index = 0; index < deck.length; index++) {
			deck[index] = index;
		}

		// Shuffle the cards
		for (int position = 0; position < deck.length; position++) {
			int index = (int) (Math.random() * deck.length);
			int temp = deck[position];
			deck[position] = deck[index];
			deck[index] = temp;
		}
		// Display the all the cards
		for (int index = 0; index < 52; index++) {
			String suit = suits[deck[index] / 13];
			String rank = ranks[deck[index] % 13];
			shuffel[index] = (rank + " of " + suit);
		}

		for (int person = 1; person < 5; person++) {
			for (int cards = 0; cards < 9; cards++) {
				if (person == 1) {
					player1[cards] = shuffel[person + cards * 4];
				} else if (person == 2) {
					player2[cards] = shuffel[person + cards * 4];
				} else if (person == 3) {
					player3[cards] = shuffel[person + cards * 4];
				} else if (person == 4) {
					player4[cards] = shuffel[person + cards * 4];
				}
			}
		}
	}

	public static void printPlayer(String[] player) {
		System.out.println("player : ");
		for (int index = 0; index < 9; index++) {
			System.out.println(player[index]);
		}
	}

	public static void main(String[] args) {
		
		DeckOfCards cards = new DeckOfCards();
		SortOfDeckCards sort =  new SortOfDeckCards();
		cards.deckOfShuffelCards();
		printPlayer(player1);
		printPlayer(player2);
		printPlayer(player3);
		printPlayer(player4);
		sort.sortOfDeck(shuffel);
		sort.printSortDeck(shuffel);
	}
}
