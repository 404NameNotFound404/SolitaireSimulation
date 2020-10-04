package entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest {
	
	
	
	@Test
	public void testDeckSize() {
		Deck testDeck = new Deck();
		assertTrue(testDeck.getCardStack().size() == 52);
	}
	
	@Test
	public void testCardsAreUnique() {
		Deck testDeck = new Deck();
		boolean match = false;
		for (int i = 0; i <= 51; i++) {
			for (int j = 0; j <= 51; j++) {
				if (testDeck.cards.get(i).equals(testDeck.cards.get(j)) && !(j == i)) {
					match = true;
				}
			}
		}
		assertFalse(match);
	}
	
	

}
