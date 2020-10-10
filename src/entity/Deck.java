package entity;

import java.util.Stack;
import java.util.Collections;
import java.util.Random;

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
		Card c = this.getCardStack().pop();
		super.setCards(this.getCardStack());
		return c;
	}
	
	public void shuffleDeck() {
		Stack<Card> deck = this.getCardStack();
        int numCards = deck.size();
        Random random = new Random();
        for (int i = 0; i < numCards; i++) {
            int randomIndex = i + random.nextInt(numCards - i);
            Card randomElement = deck.get(randomIndex);
            deck.set(randomIndex, deck.get(i));
            deck.set(i, randomElement);
        }
	}
	
}
