package entity;

import java.util.Stack;

public class TableTop {

	private CardStack[] tableaus;
	private CardStack[] foundations;
	private Deck deck;

	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

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


			//reverse order of the talon
			Stack<Card> temp = new Stack<Card>();
			for (int i = talon.getSize() - 1; i >= 0; i--) {
				temp.add(talon.getCardStack().elementAt(i));
			}

			deck.setCards(temp);		}

		//Loop through the Deck to flip the cards down
		for (Card c: deck.getCardStack()) {
			c.flip(false);
		}

		//reset Talon to empty cards
		talon.setCards(new Stack<Card>());
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
			tableaus[i].getCardStack().peek().flip(true);

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
		if (!deck.isStackEmpty())
		{
			talon.addToStack(deck.drawCard());
		}
		if (!talon.isStackEmpty()) {
			talon.flipTopCard();
		}
		else {
			System.out.println("Talon is EMPTY");
		}
	}

	public void setTalon(CardStack s) {
		talon = s;
	}

	/**
	 * Move card to the Tableau
	 * @param cards the Stack of cards want to move
	 * @return True if move card successful, and 
	 * False if move card not successful
	 */
	public boolean moveCardTableau(Stack<Card> cards) {

		for(CardStack s: tableaus) {
			if(!s.isStackEmpty()) {
				Card card = s.getCardStack().peek();
				if(card.compareTo(cards.peek()) == 1 && card.isRed() != cards.peek().isRed()) {
					s.addToStack(cards.pop());
					if(!cards.isEmpty()) {
						cards.peek().flip(true);
					}
					turns++;
					return true;
				}
			}
			else if (cards.peek().getValue() == 12){
				s.addToStack(cards.pop());
				if(!cards.isEmpty()) {
					cards.peek().flip(true);
				}
				turns++;
				return true;
			}
		}
		return false;
	}

	/**
	 * Move card to foundation 
	 * @param c the card want to move
	 * @return True if move successful
	 */
	public boolean moveFoundation(Stack<Card> s) {
		if (s.isEmpty() == false) 
		{
			Card c = s.peek();

			if(foundations[c.getSuit()].getCardStack().isEmpty() && c.getValue() == 0) {
				foundations[c.getSuit()].getCardStack().add(s.pop());
				turns++;
				if(!s.isEmpty()) {
					s.peek().flip(true);
				}
				return true;
			}
			else if(foundations[c.getSuit()].getCardStack().isEmpty()) {
				return false;
			}
			else if(foundations[c.getSuit()].getCardStack().peek().compareTo(c) == -1) {
				foundations[c.getSuit()].getCardStack().add(s.pop());
				turns++;
				if(!s.isEmpty()) {
					s.peek().flip(true);
				}
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	/**
	 * Move stack of cards between tableau
	 * @param stack the stack of card in CardStack
	 * @return True if move successfully
	 */
	public void moveStackCardTableau(Stack<Card> stack) {
		
		//Find the first card that flip up in the card of stack
		boolean check = false;
		int count =0;
		while(!check && count < stack.size()) {
			if(stack.get(count).isFaceUp()) {
				check = true;
			}
			else {
				count++;
			}
		}
		Stack<Card> tempStack = new Stack<Card>();
		
		System.out.println(count);
		System.out.println("Size: " + stack.size());
		//The first flip up card in the stack 
		Card c = stack.get(count);
		System.out.println(count + " " + c.toString());

		//Check to see if the card is movable between Tableau
		for(CardStack t: tableaus) {

			if(!t.isStackEmpty()) {
				//flip the top card
//				if(t.getCardStack().peek().isFaceUp()== false) {
//					t.flipTopCard();
//				}
				Card card = t.getCardStack().peek();

				if(card.compareTo(c) == 1 && card.isRed() != c.isRed()) {
					//If card is movable, then 
					//create a new stack contains the movable stack
					
					for(int j = 0; j < stack.size() - count; j ++) {
						tempStack.push(stack.pop());
						
					}

					for (int i = 0; i < tempStack.size() ; i++) {
						t.addToStack(tempStack.pop());
					}
					//flip the card after move
					if(!stack.isEmpty())
					{
						stack.peek().flip(true);
					}
					
					turns++;
					break;
				}
			}
			else if (c.getValue() == 12){
				//If card is movable, then 
				//create a new stack contains the movable stack
				for(int j = 0; j < stack.size() - count; j ++) {
					tempStack.push(stack.pop());
					
				}
				for (int i = 0; i < tempStack.size() ; i++) {
					t.addToStack(tempStack.pop());
				}
				turns++;
			}
		}

	}

	/**
	 * Print the information of the deck
	 */
	public void printDeck() {
		System.out.println();
		System.out.println("Cards left in the deck: ");

		for(Card c: deck.getCardStack()) {
			System.out.println(c.toString());
		}

	}

	/**
	 * Print the information of the tableaus
	 */
	public void printTableaus() {
		System.out.println();
		System.out.println("THE TABLEAUS from left to right: ");
		int count = 1;
		for (CardStack s : tableaus) {
			System.out.println();
			System.out.println("Tableau: " + count);
			for (Card c: s.getCardStack()) {
				System.out.println(c.toString());
			}
			count++;
		}
	}

	/**
	 * Print the foundations 
	 */
	public void printFoundations() {
		System.out.println();
		System.out.println("Foundations: ");
		int count = 0;
		for (CardStack f: foundations) {
			System.out.println();
			System.out.println("Foundations: " + count);
			for (Card c: f.getCardStack()) {
				System.out.println(c.toString());
			}
			count ++;
		}
	}

}
