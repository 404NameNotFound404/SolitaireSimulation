package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void testCard() {
		Card c = new Card(0,1);
		assertEquals(0, c.getSuit());
		assertEquals(1, c.getValue());
		
	}
	@Test
	public void testCompareTo() {
		Card c1 = new Card(0,2);
		Card c2 = new Card(1,2);
		Card c3 = new Card(0,1);
		Card c4 = new Card(1,3);
		Card c5 = new Card(0,2);
		Card c6 = new Card(0,1);
		
		assertEquals(-1, c1.compareTo(c2));
		assertEquals(1,  c1.compareTo(c6));
		assertEquals(-1, c1.compareTo(c1));
		assertEquals(-1, c1.compareTo(c5));
		assertEquals(-1, c1.compareTo(c6));
	}
	
	@Test
	public void testIsRed() {
		Card testCard0 = new Card(0,1);
		Card testCard1 = new Card(1,1);
		Card testCard2 = new Card(2,1);
		Card testCard3 = new Card(3,1);
		
		assertTrue(testCard0.isRed());
		assertTrue(testCard1.isRed());
		assertFalse(testCard2.isRed());
		assertFalse(testCard3.isRed());
	}
	
	@Test
	public void testFlip() {
		Card c = new Card(0,2);
		c.flip();
		assertTrue(c.isFaceUp());
				
	}
	@Test
	public void testGetSuit() {
		Card c = new Card(0,2);
		assertEquals(0, c.getSuit());
				
	}
	@Test
	public void testSetSuit() {
		Card c = new Card(0,2);
		c.setSuit(3);
		assertEquals(3, c.getSuit());
				
	}
	@Test
	public void testGetValue() {
		Card c = new Card(0,2);
		assertEquals(2, c.getValue());
				
	}
	@Test
	public void testSetValue() {
		Card c = new Card(0,2);
		c.setValue(3);
		assertEquals(3, c.getValue());
				
	}
	
	@Test
	public void testIsFaceUp() {
		Card c = new Card(0,2);
		assertEquals(false, c.isFaceUp());
				
	}
	
	@Test
	public void testSetFaceUp() {
		Card c = new Card(0,2);
		c.setFaceUp(true);
		assertEquals(true, c.isFaceUp());
				
	}
	@Test
	public void testToString() {
		Card c = new Card(0,2);
		assertEquals("heart 3", c.toString());
				
	}
}
