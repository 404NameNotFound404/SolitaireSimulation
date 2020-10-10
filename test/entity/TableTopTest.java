package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TableTopTest {
	private TableTop gameBoard = new TableTop();
	
	@Before
	public void setUp() {
		gameBoard.generateBoard();
	}
	
	@Test 
	public void testGenerateBoardNumberOfCards() {
		//test foundation and tableau length
		assertEquals(7, gameBoard.getTableaus().length);
		assertEquals(4, gameBoard.getFoundation().length);
		
		//test number of cards in foundation stacks
		for(CardStack c: gameBoard.getFoundation()) {
			assertTrue(c.isStackEmpty());
		}
		
		//test number of cards in the tableau stack
		for(int i = 0; i < 7; i++) {
			 CardStack[] tabs = gameBoard.getTableaus();
			 assertEquals(i+1, tabs[i].getCardStack().size()); 
		}
		
		//test number of cards in the draw pile
		assertFalse(gameBoard.getDrawPile().isStackEmpty());
		assertEquals(24, gameBoard.getDrawPile().getSize());
		
		//test number of cards in the talon
		assertTrue(gameBoard.getTalon().isStackEmpty());
	}
	
	@Test
	public void testGenerateBoardCorrectCardsFlippedinTableau() {
		CardStack[] tabs = gameBoard.getTableaus();
		
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < tabs[i].getCardStack().size(); j++) {
				if (i == tabs[i].getCardStack().size()-1) {
					//System.out.println("up: " + tabs[i].getCardStack().get(i).isFaceUp());

					assertTrue(tabs[i].getCardStack().get(i).isFaceUp());
				}
				else {
					//System.out.println("down" + tabs[i].getCardStack().get(i).isFaceUp());
					assertFalse(tabs[i].getCardStack().get(i).isFaceUp());
				}
			}
		}
		
	}

	
	@Test
	public void moveTalon() {
		assertTrue(gameBoard.getTalon().isStackEmpty());
		
		gameBoard.moveToTalon();
		assertFalse(gameBoard.getTalon().isStackEmpty());
		assertEquals(1, gameBoard.getTalon().getSize());

	}
	
	@Test
	public void setTableau() {
		CardStack s = new CardStack();
		Card c1 = new Card (0, 0);
		s.addToStack(c1);
		gameBoard.setTableau(0, s);
		
		CardStack f = gameBoard.getTableaus()[0];
		
		assertEquals(1, f.getSize());
		assertEquals(c1, f.getCardStack().peek());
		
	}
	
	@Test
	public void testCheckMoveTableauPass() {
		CardStack s = new CardStack();
		Card c1 = new Card (0, 0);
		s.addToStack(c1);
		gameBoard.setTableau(0, s);
		
		Card c2 = new Card(2, 1);
		
		CardStack s2 = new CardStack();
		s2.addToStack(c2);
		
		gameBoard.setTalon(s2);
		
		assertTrue(gameBoard.moveCardTableau(c2));
		
		assertEquals(2, gameBoard.getTableaus()[0].getSize());
	}
	
	@Test
	public void testCheckMoveTableauRightSuitWrongRank() {
		//try to move right suit wrong rank to tableau
		CardStack s1 = new CardStack();
		Card c1 = new Card (0, 0);
		s1.addToStack(c1);
		gameBoard.setTableau(0, s1);
		
		Card c2 = new Card(2, 3);
		CardStack s2 = new CardStack();
		s2.addToStack(c2);
		
		gameBoard.setTalon(s2);
		
		assertFalse(gameBoard.moveCardTableau(c2));
		
		assertEquals(1, gameBoard.getTableaus()[0].getSize());
		
	}
	
	@Test
	public void testCheckMoveTableauWrongSuitRightRank() {
		//try to move wrong suit right rank to tableau
		Card c2 = new Card(1, 1);
		
		CardStack s2 = new CardStack();
		s2.addToStack(c2);
		gameBoard.setTalon(s2);
		
		//assertFalse(gameBoard.moveCardTableau(c2));
		
		assertEquals(1, gameBoard.getTableaus()[0].getSize());
	}
	
	
	@Test
	public void testMoveFoundationPass() {
		//move ace to foundation
		Card c = new Card (2, 0);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		gameBoard.moveFoundation(c);
		assertFalse(gameBoard.getFoundation()[2].isStackEmpty());
	}
	
	@Test
	public void testMoveFoundationFailRightSuitWrongRankEmptyFoundation() {
		//try to move right suit wrong rank to empty foundation
		Card c = new Card (2, 3);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		gameBoard.moveFoundation(c);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		
	}
	
	@Test
	public void testMoveFoundationFailWrongSuitRightRankEmptyFoundation() {		
		//try to move wrong suit right rank to empty foundation
		Card c = new Card (1, 0);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		gameBoard.moveFoundation(c);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());	
	}
	
	@Test
	public void testMoveFoundationFailWrongSuitRightRankPopulatedFoundation() {		
		//try to move right suit wrong rank to foundation populated foundation
		Card c = new Card (2, 3);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		gameBoard.moveFoundation(c);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());	
	}
	
	@Test
	public void testMoveFoundationFailRightSuitWrongRankPopulatedFoundation() {				
		//try to move wrong suit right rank to foundation populated foundation
		Card c = new Card (3, 2);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		gameBoard.moveFoundation(c);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		
	}

	@Test
	public void testResetDeck() {
		assertFalse(gameBoard.getDrawPile().isStackEmpty());
		assertEquals(24, gameBoard.getDrawPile().getSize());
		for (int i = 0; i < 24; i++) {
			gameBoard.moveToTalon();
		}
		assertTrue(gameBoard.getDrawPile().isStackEmpty());
		gameBoard.resetDrawPile();
		assertFalse(gameBoard.getDrawPile().isStackEmpty());
	}
	
	@Test
	public void testCheckWinPass() {
		CardStack s;
		Card c = new Card(0, 0);
		for(int i = 0; i < 4; i ++) {
			s = new CardStack();
			for (int j = 0; j < 13; j++) {
				c.setSuit(i);
				c.setValue(j);
				s.addToStack(c);
			}
			gameBoard.setFoundation(i, s);
		}
		
		assertTrue(gameBoard.checkForWin());
	}
	
	@Test
	public void testCheckWinFail() {
		// with no cards
		assertFalse(gameBoard.checkForWin());
		
		//with some cards
		CardStack s;
		Card c = new Card(0, 0);
		for(int i = 0; i < 3; i ++) {
			s = new CardStack();
			for (int j = 0; j < 13; j++) {
				c.setSuit(i);
				c.setValue(j);
				s.addToStack(c);
			}
			gameBoard.setFoundation(i, s);
		}
		assertFalse(gameBoard.checkForWin());
	}



}
