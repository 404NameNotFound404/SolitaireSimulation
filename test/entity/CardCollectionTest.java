package entity;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class CardCollectionTest {

	@Test
	public void testDefaultConstructor() {
		
		CardCollection c = new CardCollection();
		assertEquals(0, c.getSize());
		
	}

	@Test
	public void testOverloadConstructor() {
		Stack<Card> s = new Stack<Card>();
		
		CardCollection c = new CardCollection(s);
		assertEquals(0, c.getSize());
		
	}
	
	@Test
	public void testSetCardStack() {
		Stack<Card> olds = new Stack<Card>();
		Stack<Card> news = new Stack<Card>();
		CardCollection c = new CardCollection(olds);
		c.setCardStack(news);
		
		assertEquals(news, c.getCardStack());
		
	}
	@Test
	public void testGetCardStack() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s);
		assertEquals(s, c.getCardStack());
		
	}
	@Test
	public void testFlipTopCard() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s);
		Card card = new Card(2,4);
		c.addToStack(card);
		c.flipTopCard();
		assertTrue(s.peek().isFaceUp());
		
	}
	@Test
	public void testIsStackEmpty() {
		CardCollection c1 = new CardCollection();
		assertTrue(c1.isStackEmpty());
				
		Stack<Card> s2 = new Stack<Card>();
		CardCollection c2 = new CardCollection(s2);		
		assertTrue(c2.isStackEmpty());
		
	}
	@Test
	public void testGetSize() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s);
		CardCollection c1 = new CardCollection();
		assertTrue(c.isStackEmpty());
		assertTrue(c1.isStackEmpty());
		
	}
	
	@Test
	public void testAddToStack() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s);
		Card card = new Card(1,2);
		c.addToStack(card);
		assertEquals(1,c.getSize());
	
		
	}

}
