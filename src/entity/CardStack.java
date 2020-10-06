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
		boolean result = false;
		int i = 1;
		int j = 0;
		if(i <= super.getCards().size())
		{
			Stack<Card> cards = super.getCards();
			Card cardOne = cards.elementAt(i);
			Card cardTwo = cards.elementAt(j);
			if(cardOne.isFaceUp() && cardTwo.isFaceUp())
			{
				Card card1 = super.getCards().elementAt(i);
				Card card2 = super.getCards().elementAt(j);
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
	
	public void removeTopCard()
	{
		Stack<Card> cards = super.getCards();
		cards.pop();
		super.setCards(cards);	
	}
	
}