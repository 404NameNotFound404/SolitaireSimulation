package entity;

/**
 * 
 * @author katmendy 
 *
 */
import java.util.*;

public class CardCollection {

	private Stack<Card> cards;

    public CardCollection(){
        setCards(new Stack<Card>());
    }

    public CardCollection(Stack<Card> s){
        setCards(s);
    
    }
	
    /**
	 * @param e collection of cards to put into instance variable
	 */
    public void setCardStack(Stack<Card> e){
        this.setCards(e);
    }

    /**
	 * @return collection of cards
	 */
    public Stack<Card> getCardStack(){
        return getCards();
    }

    /**
	 * Flip the top card in the stack
	 */
    public void flipTopCard(){
        getCards().peek().flip();
    }

    /**
	 * Check to see if there are any cards in the collection
     * @return true if the stack is empty
	 */
    public boolean isStackEmpty(){
        return getCards().isEmpty();
    }

    /**
     * @return size of the collection
	 */
    public int getSize(){
        return getCards().size();
    }

    public void addToStack(Card c) {
        getCards().push(c);
    }

	public Stack<Card> getCards() {
		return cards;
	}

	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}

}
