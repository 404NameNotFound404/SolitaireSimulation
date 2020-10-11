package entity;

import java.util.Stack;

public class TableTop {
	
	private CardStack[] tableaus;
	private CardStack[] foundations;
	private Deck deck;
	private CardCollection talon;
	public long time;
	
	//the number of times the cards move
	public int turns;
	
	//the result of the game, true means win
	public boolean isWin = true;

	//needed for testing SimulationController
	public int getTurns() {
		return turns;
	}
	//needed for testing SimulationController
	public void setTurns(int turns) {
		this.turns = turns;
	}
	//needed for testing SimulationController
	public boolean getWin()
	{
		return isWin;
	}
	//needed for testing SimulationController	
	public void setWin(boolean status)
	{
		this.isWin = status;
	}

	int deckPasses = 0;
	
	public TableTop() {
		//set turns equal 0
		turns = 0;
		tableaus = new CardStack[7];
		foundations = new CardStack[4];
		deck = new Deck();
		talon = new CardCollection();
	}
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
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
	
	/**
	 * Generate the game board
	 */
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
			
		}
		
		for (int i = 0; i < 4; i++) {
			foundations[i] = new CardStack();
		}
		
		talon = new CardCollection();
			
	}
	
	
	/**
	 * Move card to the talon
	 */
	public void moveToTalon() {
		talon.addToStack(deck.drawCard());
		talon.flipTopCard();
		
	}
	
	public void setTalon(CardStack s) {
		talon = s;
	}
	
	/**
	 * Move card to the Tableau
	 * @param c the card want to move
	 * @return True if move card successful, and 
	 * False if move card not successful
	 */
	public boolean moveCardTableau(Card c) {
		//check moves in tableau
		for(CardStack s: tableaus) {
			if(!s.isStackEmpty()) {
				Card card = s.getCardStack().peek();
				if(card.compareTo(c) == -1 && card.isRed() != c.isRed()) {
					s.addToStack(talon.removeTopCard());
					turns++;
					return true;
				}
			}
			else {
				System.out.println("STACK EMPTY");
			}
		}

		return false;
	}
	
	/**
	 * Move card to foundation 
	 * @param c the card want to move
	 * @return True if move successful
	 */
	public boolean moveFoundation(Card c) {
		//check moves in tableau
		
		if(foundations[c.getSuit()].getCardStack().isEmpty() && c.getValue() == 0) {
			foundations[c.getSuit()].getCardStack().add(c);
			turns++;
			return true;
		}
		else if(foundations[c.getSuit()].getCardStack().isEmpty()) {
			return false;
		}
		else if(foundations[c.getSuit()].getCardStack().peek().compareTo(c) == 1) {
			foundations[c.getSuit()].getCardStack().add(c);
			turns++;
			return true;
		}
		else {
			return false;
		}
	}
	
}
