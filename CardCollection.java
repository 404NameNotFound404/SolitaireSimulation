package SolitaireSimulation;

/**
 * 
 * @author katmendy
 *
 */
import java.util.*;

public class CardCollection {

	private Stack<Card> cards;

    public CardCollection(){
        cards = new Stack<Card>();
    }

    public CardCollection(Stack<Card> s){
        cards = s;
    
    }
	
    /**
	 * @param e collection of cards to put into instance variable
	 */
    public void setCardStack(Stack<Card> e){
        this.cards = e;
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
        cards.peek().flip();
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

}
