/**
 * 
 * @author katmendy
 *
 */
public class CardCollection {

	private Stack<Card> cards;

    public CardCollection(){
        s = new Stack<Card>();
    }

    public CardCollection(int size){
        s = new Stack<Card>(size);
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
    public boolean getSize(){
        return cards.size();
    }

}
