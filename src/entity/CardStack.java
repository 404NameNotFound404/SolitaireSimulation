package entity;

import java.util.Stack;

/*
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
	
	public boolean checkOrder()
	{
		boolean result = true;
		int i = 1;
		int j = 0;
		while((super.getCards().elementAt(i)).isFaceUp() && (super.getCards().elementAt(j).isFaceUp()))
		{
			Card card1 = super.getCards().elementAt(i);
			Card card2 = super.getCards().elementAt(j);
			int value1 = card1.getValue();
			int value2 = card2.getValue();
			if (value1 < value2)
			{
				result = false;
				i++;
				j++;
			}
		}
		return result;
	}

/*
	public void addToStack(Card c)
	{
		super.getCards().push(c);
	}
*/
	
	
	public void removeTopCard()
	{
		super.getCards().pop();
	}
	
}