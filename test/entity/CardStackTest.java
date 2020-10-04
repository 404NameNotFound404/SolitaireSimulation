package entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardStackTest 
{

	@Test
	void testCheckOrder() 
	{
		CardStack inOrder = new CardStack();
		Card one = new Card(0,0);
		Card two = new Card(1,1);
		Card three = new Card(2,2);
		Card four = new Card(3,3);
		one.flip();
		two.flip();
		three.flip();
		four.flip();
		inOrder.addToStack(four);
		inOrder.addToStack(three);
		inOrder.addToStack(two);
		inOrder.addToStack(one);
		assertTrue(inOrder.checkOrder());
	}
	@Test
	void testCheckOrderFail() 
	{
		CardStack inOrder = new CardStack();
		CardStack outOfOrder = new CardStack();
		Card one = new Card(0,0);
		Card two = new Card(1,1);
		Card three = new Card(2,2);
		Card four = new Card(3,3);
		one.flip();
		two.flip();
		three.flip();
		four.flip();
		outOfOrder.addToStack(two);
		outOfOrder.addToStack(three);
		outOfOrder.addToStack(one);
		outOfOrder.addToStack(four);
		inOrder.addToStack(four);
		inOrder.addToStack(three);
		inOrder.addToStack(two);
		inOrder.addToStack(one);
		assertFalse(outOfOrder.checkOrder());
		CardStack faceDown = new CardStack();
		one.setFaceUp(false);
		two.setFaceUp(false);
		three.setFaceUp(false);
		four.setFaceUp(false);
		faceDown.addToStack(one);
		faceDown.addToStack(two);
		faceDown.addToStack(three);
		faceDown.addToStack(four);
		assertFalse(faceDown.checkOrder());
	}
	@Test
	void testremoveTopCard() 
	{
		CardStack inOrder = new CardStack();
		Card one = new Card(0,0);
		Card two = new Card(1,1);
		Card three = new Card(2,2);
		Card four = new Card(3,3);
		one.flip();
		two.flip();
		three.flip();
		four.flip();
		inOrder.addToStack(four);
		inOrder.addToStack(three);
		inOrder.addToStack(two);
		inOrder.addToStack(one);
		assertEquals(4, inOrder.getSize());
		inOrder.removeTopCard();
		assertEquals(3, inOrder.getSize());
	}
}