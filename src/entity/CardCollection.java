package entity;

/**
 * 
 * @author katmendy 
 *
 */
import java.util.*;

public class CardCollection {

	protected Stack<Card> cards;

    public CardCollection(){
        setCards(new Stack<Card>());
    }

    public CardCollection(Stack<Card> s){
        setCards(s);
    
    }
	
    /**
	 * @return the card removed from the top of the collection
	 */
    public Card removeTopCard(){
    	return cards.pop();
    }

    
    /**
	 * @return collection of cards
	 */
    public Stack<Card> getCardStack(){
        return cards;
    }

    /**
	 * Flip the top card in the stack
	 */
    public void flipTopCard(){
        cards.peek().flip(true);
    }

    /**
	 * Check to see if there are any cards in the collection
     * @return true if the stack is empty
	 */
    public boolean isStackEmpty(){
        return cards.isEmpty();
    }

    /**
     * @return size of the collection
	 */
    public int getSize(){
        return cards.size();
    }

    public void addToStack(Card c) {
        cards.push(c);
    }


	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}

}
