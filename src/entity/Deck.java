package entity;

import java.util.Stack;
import java.util.Collections;

public class Deck extends CardCollection{
	
	
	
	public Deck() {
			super(makeDeck());
		}
		
	
	private static Stack<Card> makeDeck(){
		Stack<Card> newDeck = new Stack<Card>();
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 0; value <= 12; value++) {
				newDeck.push(new Card(suit, value));
			}
		}
		return newDeck;	
	}
	
	public Card drawCard() {
		return this.cards.pop();
	}
	
	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
	
}
