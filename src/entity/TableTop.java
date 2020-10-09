package entity;

import java.util.ArrayList;
import java.util.Stack;

public class TableTop {
	
	private ArrayList<CardStack> tableaus; 
	private ArrayList<CardStack> foundation;
	private Deck deck;
	private CardCollection talon;
	int deckPasses = 0;
	
	public void resetDrawPile() {
		if (deck.isStackEmpty()) {
			deck.setCards(talon.getCards());
			talon.setCards(new Stack<Card>());
		}
	}
	
	public boolean checkForWin() {
		boolean isWin = true;
		for (CardStack cards : foundation) {
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
			tableaus.add(new CardStack());
		}
		for (int i = 0; i < 7; i++) {
			for (int j = i; j < 7; j++) {
				Card cardToAdd = deck.drawCard();
				if (i == j) {
					cardToAdd.flip();
				}
				tableaus.get(i).addToStack(cardToAdd);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			foundation.add(new CardStack());
		}
		
		talon = new CardCollection();
			
	}
	
	
	
//	public boolean moveCardTableau(CardStack beginingStack, CardStack destinationStack) {
//		
//		if (beginingStack.isStackEmpty()) {
//			return false;
//		}
//		
//		Card topDestinationCard;
//		if (destinationStack.isStackEmpty()) {
//			topDestinationCard = new Card(-1,-1);
//		}
//		else
//		{
//			topDestinationCard = destinationStack.getCards().get(0);
//		}
//		
//		Card cardToMove = beginingStack.getCards().get(0);
//		
//		if (cardToMove.isFaceUp()) {
//			//check for alternating card colors
//			if (cardToMove.isRed() != topDestinationCard.isRed() || topDestinationCard.getValue() == -1) {
//				//check for order of stack after card is added or if a king may be added to empty stack
//				if ((cardToMove.getValue() - 1) == topDestinationCard.getValue() ||
//						(topDestinationCard.getValue() == -1 && cardToMove.getValue() == 13)) {
//					
//					
//				}
//			}
//		}
//		
//		
//		return false;
//	}

}
