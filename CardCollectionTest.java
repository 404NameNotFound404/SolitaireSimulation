package SolitaireSimulation;

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
		
		CardCollection c = new CardCollection(s,4);
		assertEquals(4, c.getSize());
		
	}
	
	@Test
	public void testSetCardStack() {
		Stack<Card> olds = new Stack<Card>();
		Stack<Card> news = new Stack<Card>();
		CardCollection c = new CardCollection(olds,4);
		c.setCardStack(news);
		
		assertEquals(news, c.getCardStack());
		
	}
	@Test
	public void testGetCardStack() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s,0);
		assertEquals(s, c.getCardStack());
		
	}
	@Test
	public void testFlipTopCard() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s,4);
		Card card = new Card(2,4);
		c.addToStack(card);
		c.flipTopCard();
		assertTrue(s.peek().isFaceUp());
		
	}
	@Test
	public void testIsStackEmpty() {
		CardCollection c = new CardCollection();
		assertTrue(c.isStackEmpty());
		
		Stack<Card> s1 = new Stack<Card>();
		CardCollection c1 = new CardCollection(s1,0);
		assertTrue(c1.isStackEmpty());
				
		Stack<Card> s2 = new Stack<Card>();
		CardCollection c2 = new CardCollection(s2,4);		
		assertFalse(c2.isStackEmpty());
		
	}
	@Test
	public void testGetSize() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s,0);
		CardCollection c1 = new CardCollection();
		assertTrue(c.isStackEmpty());
		assertTrue(c1.isStackEmpty());
		
	}
	
	@Test
	public void testAddToStack() {
		Stack<Card> s = new Stack<Card>();
		CardCollection c = new CardCollection(s,4);
		Card card = new Card(1,2);
		c.addToStack(card);
		assertEquals(5,c.getSize());
	
		
	}

}
