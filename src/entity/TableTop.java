package entity;

import java.util.ArrayList;
import java.util.Stack;

public class TableTop {
	
	private CardStack[] tableaus;
	private CardStack[] foundations;
	private Deck deck;
	private CardCollection talon;
	int deckPasses = 0;
	
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
	
	public void resetDrawPile() {
		if (deck.isStackEmpty()) {
			deck.setCards(talon.getCards());
			talon.setCards(new Stack<Card>());
			this.deckPasses += 1;
		}
	}
	
	public boolean checkForWin() {
		boolean isWin = true;
		for (CardStack cards : foundations) {
			if (cards.getSize() < 13){
				isWin = false;
			}
		}
		return isWin;
	}
	
	public void setUpBoard() {
		Deck deck = new Deck();
		deck.shuffleDeck();
		
		for (int i = 0; i < 7; i++) {
			tableaus[i] = new CardStack();
		}
		for (int i = 0; i < 7; i++) {
			for (int j = i; j < 7; j++) {
				Card cardToAdd = deck.drawCard();
				if (i == j) {
					cardToAdd.flip();
				}
				tableaus[i].addToStack(cardToAdd);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			foundations[i] = new CardStack();
		}
		
		talon = new CardCollection();
			
	}
	
	public boolean moveCardTableau() {
		
		Card topCard = deck.getCards().get(0);
		
		for (int i = 0; i < 7; i++) {
			
			CardStack tableau = tableaus[i];
			Card tableauCard = tableau.getCards().get(0);
			if (topCard.getValue() - 1 == tableauCard.getValue() && topCard.isRed() != tableauCard.isRed()) {
				tableau.addToStack(deck.drawCard());
				return true;
			}
			else if(tableau.isStackEmpty() && topCard.getValue() == 13) {
				tableau.addToStack(deck.drawCard());
				return true;
			}
		}
		return false;
	}

	
	public boolean moveFoundation() {
		
		Card topCard = deck.getCards().get(0);
		
for (int i = 0; i < 4; i++) {
			
			CardStack foundation = foundations[i];
			Card foundationCard = foundation.getCards().get(0);
			if (topCard.getValue() + 1 == foundationCard.getValue() && topCard.isSameSuit(foundationCard)) {
				foundation.addToStack(deck.drawCard());
				return true;
			}
			else if(foundation.isStackEmpty() && topCard.getValue() == 0) {
				foundation.addToStack(deck.drawCard());
				return true;
			}
		}
		return false;
	}
}
