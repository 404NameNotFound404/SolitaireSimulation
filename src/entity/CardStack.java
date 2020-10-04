package entity;

/*
 * 
 * @Author Nathan Drees
 * 
 */
public class CardStack extends CardCollection
{
	super();
	super(Stack<Card> s);
	
	public boolean CheckOrder()
	{
		boolean result = true;
		int i = 1;
		int j = 0;
		while((super.cards.elementAt(i)).isFaceUp())
		{
			if ((super.cards.elementAt(i)).getValue() < (super.cards.elementAt(j)).getValue())
			{
				results = false;
				i++;
				j++;
			}
		}
		return reslut;
	}

	/*
	public void addToStack(Card c)
	{
		super.cards.push(c);
	}
	*/
	
	
	public void removeTopCard()
	{
		super.cards.pop();
	}
	
}