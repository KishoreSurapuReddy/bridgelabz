package com.bridgelabz.deckofcards;
public class SortOfDeckCards extends DeckOfCards{
	
	public String[] sortOfDeck(String[] shuffel) {
		for(int index = 1 ; index < shuffel.length ; index++) {
			for(int position = index ; position > 0 ; position--) {
				if(shuffel[position-1].compareTo(shuffel[position]) > 0) {
					String temp = shuffel[position];
					shuffel[position] = shuffel[position-1];
					shuffel[position-1] = temp;
					
				}
			}
		}
		return shuffel;
		
	}
	public void printSortDeck(String[] shuffel) {
		String[] sortdeck = shuffel;
		Queue queue = new Queue();
		for(int index = 0 ; index < sortdeck.length ; index++) {
			queue.enQueue(shuffel[index]);
		}
		queue.deQueue();
	}
}
