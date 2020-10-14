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
	
	
	/**
	 * A deck designed to always win
	 */
	public void winDeck()
	{
		//spade = 3, club = 2, diamond = 1, heart = 0
		Stack<Card> deck = new Stack<Card>();
		
		Card s6 = new Card(3, 5);
		Card c6 = new Card(2, 5);
		Card d6 = new Card(1, 5);
		Card h6 = new Card(0, 5);
		Card s5 = new Card(3, 4);
		Card c5 = new Card(2, 4);
		Card d5 = new Card(1, 4);
		Card h5 = new Card(0, 4);
		Card s4 = new Card(3, 3);
		Card c4 = new Card(2, 3);
		Card d4 = new Card(1, 3);
		Card h4 = new Card(0, 3);
		Card s3 = new Card(3, 2);
		Card c3 = new Card(2, 2);
		Card d3 = new Card(1, 2);
		Card h3 = new Card(0, 2);
		Card s2 = new Card(3, 1);
		Card c2 = new Card(2, 1);
		Card d2 = new Card(1, 1);
		Card h2 = new Card(0, 1);
		Card sA = new Card(3, 0);
		Card cA = new Card(2, 0);
		Card dA = new Card(1, 0);
		Card hA = new Card(0, 0);	
		Card s7 = new Card(3, 6);
		Card c7 = new Card(2, 6);
		Card d7 = new Card(1, 6);
		Card c8 = new Card(2, 7);
		Card s8 = new Card(3, 7);
		Card h7 = new Card(0, 6);
		Card c9 = new Card(2, 8);
		Card s9 = new Card(3, 8);
		Card h8 = new Card(0, 7);
		Card d8 = new Card(1, 7);
		Card d10 = new Card(1, 9);
		Card c10 = new Card(2, 9);
		Card s10 = new Card(3, 9);
		Card h9 = new Card(0, 8);
		Card d9 = new Card(1, 8);
		Card sQ = new Card(3, 11);
		Card hJ = new Card(0, 10);
		Card dJ = new Card(1, 10);
		Card cJ = new Card(2, 10);
		Card sJ = new Card(3, 10);
		Card h10 = new Card(0, 9);
		Card hK = new Card(0, 12);
		Card dK = new Card(1, 12);
		Card cK = new Card(2, 12);
		Card sK = new Card(3, 12);
		Card hQ = new Card(0, 11);
		Card dQ = new Card(1, 11);
		Card cQ = new Card(2, 11);		
		
		deck.add(s6);
		deck.add(c6);
		deck.add(d6);
		deck.add(h6);
		deck.add(s5);
		deck.add(c5);
		deck.add(d5);
		deck.add(h5);
		deck.add(s4);
		deck.add(c4);
		deck.add(d4);
		deck.add(h4);
		deck.add(s3);
		deck.add(c3);
		deck.add(d3);
		deck.add(h3);
		deck.add(s2);
		deck.add(c2);
		deck.add(d2);
		deck.add(h2);
		deck.add(sA);
		deck.add(cA);
		deck.add(dA);
		deck.add(hA);		
		deck.add(s7);
		deck.add(d7);
		deck.add(c8);
		deck.add(c9);
		deck.add(d10);
		deck.add(sQ);
		deck.add(hK);
		deck.add(c7);
		deck.add(s8);
		deck.add(s9);
		deck.add(c10);
		deck.add(hJ);
		deck.add(dK);
		deck.add(h7);
		deck.add(h8);
		deck.add(s10);
		deck.add(dJ);
		deck.add(cK);
		deck.add(d8);
		deck.add(h9);
		deck.add(cJ);
		deck.add(sK);
		deck.add(d9);
		deck.add(sJ);
		deck.add(hQ);
		deck.add(h10);
		deck.add(dQ);
		deck.add(cQ);
		
		super.setCards(deck);
	}
	
	
	/**
	 * A deck designed to always lose
	 */
	public void impossibleDeck()
	{
		//spade = 3, club = 2, diamond = 1, heart = 0
		Stack<Card> deck = new Stack<Card>();
		
		Card s6 = new Card(3, 5);
		Card c6 = new Card(2, 5);
		Card d6 = new Card(1, 5);
		Card h6 = new Card(0, 5);
		Card s5 = new Card(3, 4);
		Card c5 = new Card(2, 4);
		Card d5 = new Card(1, 4);
		Card h5 = new Card(0, 4);
		Card s4 = new Card(3, 3);
		Card c4 = new Card(2, 3);
		Card d4 = new Card(1, 3);
		Card h4 = new Card(0, 3);
		Card s3 = new Card(3, 2);
		Card c3 = new Card(2, 2);
		Card d3 = new Card(1, 2);
		Card h3 = new Card(0, 2);
		Card s2 = new Card(3, 1);
		Card c2 = new Card(2, 1);
		Card d2 = new Card(1, 1);
		Card h2 = new Card(0, 1);
		Card sA = new Card(3, 0);
		Card cA = new Card(2, 0);
		Card dA = new Card(1, 0);
		Card hA = new Card(0, 0);	
		Card s7 = new Card(3, 6);
		Card c7 = new Card(2, 6);
		Card d7 = new Card(1, 6);
		Card c8 = new Card(2, 7);
		Card s8 = new Card(3, 7);
		Card h7 = new Card(0, 6);
		Card c9 = new Card(2, 8);
		Card s9 = new Card(3, 8);
		Card h8 = new Card(0, 7);
		Card d8 = new Card(1, 7);
		Card d10 = new Card(1, 9);
		Card c10 = new Card(2, 9);
		Card s10 = new Card(3, 9);
		Card h9 = new Card(0, 8);
		Card d9 = new Card(1, 8);
		Card sQ = new Card(3, 11);
		Card hJ = new Card(0, 10);
		Card dJ = new Card(1, 10);
		Card cJ = new Card(2, 10);
		Card sJ = new Card(3, 10);
		Card h10 = new Card(0, 9);
		Card hK = new Card(0, 12);
		Card dK = new Card(1, 12);
		Card cK = new Card(2, 12);
		Card sK = new Card(3, 12);
		Card hQ = new Card(0, 11);
		Card dQ = new Card(1, 11);
		Card cQ = new Card(2, 11);
		
		deck.add(s6);
		deck.add(s5);
		deck.add(s4);
		deck.add(s3);
		deck.add(s2);
		deck.add(cK);
		deck.add(sK);
		deck.add(d10);
		deck.add(d9);
		deck.add(d8);
		deck.add(d7);
		deck.add(d6);
		deck.add(d5);
		deck.add(d4);
		deck.add(d3);
		deck.add(d2);
		deck.add(h9);
		deck.add(h8);
		deck.add(h7);
		deck.add(h6);
		deck.add(h5);
		deck.add(h4);
		deck.add(h3);
		deck.add(h2);
		deck.add(s7);
		deck.add(s8);
		deck.add(hA);
		deck.add(c2);
		deck.add(c6);
		deck.add(s10);
		deck.add(h10);
		deck.add(dA);
		deck.add(sA);
		deck.add(c3);
		deck.add(c7);
		deck.add(c10);
		deck.add(dJ);
		deck.add(cA);
		deck.add(c4);
		deck.add(c8);
		deck.add(cJ);
		deck.add(hJ);
		deck.add(c5);
		deck.add(s9);
		deck.add(sJ);
		deck.add(dQ);
		deck.add(c9);
		deck.add(sQ);
		deck.add(hQ);
		deck.add(cQ);
		deck.add(dK);
		deck.add(hK);
		
		super.setCards(deck);
	}
}
