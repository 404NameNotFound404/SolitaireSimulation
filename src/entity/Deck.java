package entity;

import java.util.Stack;
import java.util.Random;

public class Deck extends CardCollection{
	
	
	
	public Deck() {
			super(makeDeck());
		}
		
	
	/**
	 * Generate the deck of card
	 * @return Stack<Card> deck of card 
	 */
	private static Stack<Card> makeDeck(){
		Stack<Card> newDeck = new Stack<Card>();
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 0; value <= 12; value++) {
				newDeck.push(new Card(suit, value));
			}
		}
		return newDeck;	
	}
	
	/**
	 * Draw card from deck of card
	 * @return the card it removes from the Deck 
	 */
	public Card drawCard() {
		if (!this.isStackEmpty()) {
		Card c = this.getCardStack().pop();
		super.setCards(this.getCardStack());
		return c;}
		else {
			System.out.println("The deck of cards is EMPTY.");
			return null;
		}
	}
	
	/**
	 * Shuffle the deck of card 
	 */
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
	
	public void winDeck()
	{
		//spade = 3, club = 2, diamond = 1, heart = 0
		Stack<Card> deck = new Stack<Card>();
		Card s6 = new Card(3, 5);
		deck.add(s6);
		Card c6 = new Card(2, 5);
		deck.add(c6);
		Card d6 = new Card(1, 5);
		deck.add(d6);
		Card h6 = new Card(0, 5);
		deck.add(h6);
		Card s5 = new Card(3, 4);
		deck.add(s5);
		Card c5 = new Card(2, 4);
		deck.add(c5);
		Card d5 = new Card(1, 4);
		deck.add(d5);
		Card h5 = new Card(0, 4);
		deck.add(h5);
		Card s4 = new Card(3, 3);
		deck.add(s4);
		Card c4 = new Card(2, 3);
		deck.add(c4);
		Card d4 = new Card(1, 3);
		deck.add(d4);
		Card h4 = new Card(0, 3);
		deck.add(h4);
		Card s3 = new Card(3, 2);
		deck.add(s3);
		Card c3 = new Card(2, 2);
		deck.add(c3);
		Card d3 = new Card(1, 2);
		deck.add(d3);
		Card h3 = new Card(0, 2);
		deck.add(h3);
		Card s2 = new Card(3, 1);
		deck.add(s2);
		Card c2 = new Card(2, 1);
		deck.add(c2);
		Card d2 = new Card(1, 1);
		deck.add(d2);
		Card h2 = new Card(0, 1);
		deck.add(h2);
		Card sA = new Card(3, 0);
		deck.add(sA);
		Card cA = new Card(2, 0);
		deck.add(cA);
		Card dA = new Card(1, 0);
		deck.add(dA);
		Card hA = new Card(0, 0);
		deck.add(hA);
		Card s7 = new Card(3, 6);
		deck.add(s7);
		Card c7 = new Card(2, 6);
		deck.add(c7);
		Card d7 = new Card(1, 6);
		deck.add(d7);
		Card c8 = new Card(2, 7);
		deck.add(c8);
		Card s8 = new Card(3, 7);
		deck.add(s8);
		Card h7 = new Card(0, 6);
		deck.add(h7);
		Card c9 = new Card(2, 8);
		deck.add(c9);
		Card s9 = new Card(3, 8);
		deck.add(s9);
		Card h8 = new Card(0, 7);
		deck.add(h8);
		Card d1 = new Card(1, 7);
		deck.add(d1);
		Card d10 = new Card(1, 9);
		deck.add(d10);
		Card c10 = new Card(2, 9);
		deck.add(c10);
		Card s10 = new Card(3, 9);
		deck.add(s10);
		Card h9 = new Card(0, 8);
		deck.add(h9);
		Card d9 = new Card(1, 8);
		deck.add(d9);
		Card sQ = new Card(3, 11);
		deck.add(sQ);
		Card hJ = new Card(0, 10);
		deck.add(hJ);
		Card dJ = new Card(1, 10);
		deck.add(dJ);
		Card cJ = new Card(2, 10);
		deck.add(cJ);
		Card sJ = new Card(3, 10);
		deck.add(sJ);
		Card h10 = new Card(0, 9);
		deck.add(h10);
		Card hK = new Card(0, 12);
		deck.add(hK);
		Card dK = new Card(1, 12);
		deck.add(dK);
		Card cK = new Card(2, 12);
		deck.add(cK);
		Card sK = new Card(3, 12);
		deck.add(sK);
		Card hQ = new Card(0, 11);
		deck.add(hQ);
		Card dQ = new Card(1, 11);
		deck.add(dQ);
		Card cQ = new Card(2, 11);
		deck.add(cQ);
		super.setCards(deck);
	}
	
	public void impossibleDeck()
	{
		
	}
}
