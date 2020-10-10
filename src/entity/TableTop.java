package entity;

import java.util.Stack;

public class TableTop {
	
	private CardStack[] tableaus;
	private CardStack[] foundations;
	private Deck deck;
	private CardCollection talon;
	int deckPasses = 0;
	
	public TableTop() {
		tableaus = new CardStack[7];
		foundations = new CardStack[4];
		deck = new Deck();
		talon = new CardCollection();
	}
	
	public CardStack[] getTableaus() {
		return this.tableaus;
	}
	
	public CardStack[] getFoundation() {
		return this.foundations;
		}
	
	public Deck getDrawPile() {
		return deck;
	}
	
	public CardCollection getTalon() {
		return talon;
	}
	
	public void setTableau(int index, CardStack c) {
		tableaus[index] = c;
	}
	
	/**
	 * Reset the deck of card 
	 */
	public void resetDrawPile() { 
		if (deck.isStackEmpty()) {
			deck.setCards(talon.getCardStack());
			
			//Loop through the Deck to flip the cards down
			for (Card c: deck.getCardStack()) {
				c.flip();
			}
			
			//reset Talon to empty cards
			talon.setCards(new Stack<Card>());
			this.deckPasses += 1;
		}
	}
	
	/**
	 * Check to see if the game win
	 * @return True if it wins
	 * False if it lose. 
	 */
	public boolean checkForWin() {
		boolean isWin = true;
		for (CardStack cards : foundations) {
			if (cards.getSize() < 13){
				isWin = false;
			}
		}
		return isWin;
	}
	
	public void setFoundation(int index, CardStack c) {
		foundations[index] = c;
	}
	
	public void generateBoard() {
		deck.shuffleDeck();
		int count = 0;
		
		for (int i = 0; i < 7; i++) {
			tableaus[i] = new CardStack();
		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j <= i; j++) {
				
				Card cardToAdd = deck.drawCard();
								
				tableaus[i].addToStack(cardToAdd);
				count++;
			}
			tableaus[i].getCardStack().peek().flip();
			
			//System.out.println(i);
		}
		
		for (int i = 0; i < 4; i++) {
			foundations[i] = new CardStack();
		}
		
		talon = new CardCollection();
			
	}
	
//	public boolean moveCardTableau() {
//		
//		Card topCard = deck.getCardStack().get(0);
//		
//		for (int i = 0; i < 7; i++) {
//			
//			CardStack tableau = tableaus[i];
//			Card tableauCard = tableau.getCardStack().get(0);
//			if (topCard.getValue() - 1 == tableauCard.getValue() && topCard.isRed() != tableauCard.isRed()) {
//				tableau.addToStack(deck.drawCard());
//				return true;
//			}
//			else if(tableau.isStackEmpty() && topCard.getValue() == 13) {
//				tableau.addToStack(deck.drawCard());
//				return true;
//			}
//		}
//		return false;
//	}
	
	public void moveToTalon() {
		talon.addToStack(deck.drawCard());
		talon.flipTopCard();
		
	}
	
	public void setTalon(CardStack s) {
		talon = s;
	}
	
	public boolean moveCardTableau(Card c) {
		//check moves in tableau
		for(CardStack s: tableaus) {
			if(!s.isStackEmpty()) {
				Card card = s.getCardStack().peek();
				if(card.compareTo(c) == -1 && card.isRed() != c.isRed()) {
					s.addToStack(talon.removeTopCard());
					return true;
				}
			}
			else {
				System.out.println("STACK EMPTY");
			}
		}

		return false;
	}
	

	
//	public boolean moveFoundation() {
//		
//		Card topCard = deck.getCardStack().get(0);
//		
//		for (int i = 0; i < 4; i++) {
//			
//			CardStack foundation = foundations[i];
//			Card foundationCard = foundation.getCardStack().get(0);
//			if (topCard.getValue() + 1 == foundationCard.getValue() && topCard.isSameSuit(foundationCard)) {
//				foundation.addToStack(deck.drawCard());
//				return true;
//			}
//			else if(foundation.isStackEmpty() && topCard.getValue() == 0) {
//				foundation.addToStack(deck.drawCard());
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean moveFoundation(Card c) {
		//check moves in tableau
		
		if(foundations[c.getSuit()].getCardStack().isEmpty() && c.getValue() == 0) {
			foundations[c.getSuit()].getCardStack().add(c);
			return true;
		}
		else if(foundations[c.getSuit()].getCardStack().isEmpty()) {
			return false;
		}
		else if(foundations[c.getSuit()].getCardStack().peek().compareTo(c) == 1) {
			foundations[c.getSuit()].getCardStack().add(c);
			return true;
		}
		else {
			return false;
		}
	}
	
}
