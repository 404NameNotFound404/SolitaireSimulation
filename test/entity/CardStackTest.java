package entity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import entity.Card;

class CardStackTest {
	
	CardStack inOrder = new CardStack();
	CardStack outOfOrder = new CardStack();
	Card one = new Card(0,0);
	Card two = new Card(1,1);
	Card three = new Card(2,2);
	Card four = new Card(3,3);
	
	@Before
	public void setUp()
	{
		one.flip();
		two.flip();
		three.flip();
		four.flip();
		outOfOrder.addToStack(one);
		outOfOrder.addToStack(two);
		outOfOrder.addToStack(three);
		outOfOrder.addToStack(four);
		inOrder.addToStack(four);
		inOrder.addToStack(three);
		inOrder.addToStack(two);
		inOrder.addToStack(one);
	}
	@Test
	void testCheckOrder() {
		assertTrue(inOrder.checkOrder());
	}
	@Test
	void testCheckOrderFail() {
		assertFalse(outOfOrder.checkOrder());
		Card five = new Card(0,2);
		inOrder.addToStack(five);
		assertFalse(inOrder.checkOrder());
	}
	@Test
	void testremoveTopCard() {
		assertEquals(4, inOrder.getSize());
		inOrder.removeTopCard();
		assertEquals(3, inOrder.getSize());
	}
}
