package entity;

import java.util.Stack;

/**
 * 
 * @Author Nathan Drees
 * 
 */
public class CardStack extends CardCollection
{
	public CardStack()
	{
		super();
	}
	
	public CardStack(Stack<Card> s)
	{
		super(s);
	}
	
	/**
	 * Check the face up card order to see if they are in ascending order
	 * @return True if they are in ascending order 
	 * False if there is not in ascending order or there are not any 
	 * flip up card
	 */
	public boolean checkOrder()
	{
		boolean result = false;
		int i = 1;
		int j = 0;
		if(i <= super.getCardStack().size())
		{
			Stack<Card> cards = super.getCardStack();
			Card cardOne = cards.elementAt(i);
			Card cardTwo = cards.elementAt(j);
			if(cardOne.isFaceUp() && cardTwo.isFaceUp())
			{
				Card card1 = super.getCardStack().elementAt(i);
				Card card2 = super.getCardStack().elementAt(j);
				int value1 = card1.getValue();
				int value2 = card2.getValue();
				if (value1 < value2)
				{
					result = true;
				}
			}
			i++;
			j++;
		}
		return result;
	}
	
	/**
	 * Remove the top card from the stack
	 * @return the card it remove 
	 */
	public Card removeTopCard()
	{
		Stack<Card> cards = super.getCardStack();
		Card c = cards.pop();
		super.setCards(cards);
		return c;
		
	}
	
}