package entity;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

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
	
	@Test
	public void testDrawCardTakesFromDeck() {
		Deck testDeck = new Deck();
		
		int randomNum = new Random().nextInt(52);
		
		for (int i = 0; i < randomNum; i++) {
			testDeck.drawCard();
		}
		
		assertTrue(testDeck.getCardStack().size() == 52 - randomNum);
	}
	
	
	
	@Test
	public void testShuffleMakesRandomDeckOneShuffle() {
		Deck testDeck = new Deck();
		Deck testDeckShuffled = new Deck();
		testDeckShuffled.shuffleDeck();
		
		int i = 0;
		boolean cardMatch = true;
		while (i < 52 && cardMatch) {
			if (!testDeck.drawCard().toString().equals(testDeckShuffled.drawCard().toString())) {
				cardMatch = false;
			}
			i++;
		}
		assertFalse(cardMatch);
	}
	
	@Test
	public void testShuffleMakesRandomDeckMatchingDecks() {
		Deck testDeck = new Deck();
		Deck testDeckMatch = new Deck();
		
		int i = 0;
		boolean cardMatch = true;
		while (i < 52 && cardMatch) {
			if (!testDeck.drawCard().toString().equals(testDeckMatch.drawCard().toString())) {
				cardMatch = false;
			}
			i++;
		}
		assertTrue(cardMatch);
	}
	
	@Test
	public void testShuffleMakesRandomDeckTwoShuffles() {
		Deck testDeckShuffled0 = new Deck();
		Deck testDeckShuffled1 = new Deck();
		testDeckShuffled0.shuffleDeck();
		testDeckShuffled1.shuffleDeck();
		
		int i = 0;
		boolean cardMatch = true;
		while (i < 52 && cardMatch) {
			if (!testDeckShuffled0.drawCard().toString().equals(testDeckShuffled1.drawCard().toString())) {
				cardMatch = false;
			}
			i++;
		}
		assertFalse(cardMatch);
	}

}
