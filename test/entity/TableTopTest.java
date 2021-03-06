package entity;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;


public class TableTopTest {
	private TableTop gameBoard = new TableTop();
	
	@Before
	public void setUp() {
		gameBoard.generateBoard(3);
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
	public void testMoveTalon() {
		
		assertTrue(gameBoard.getTalon().isStackEmpty());
		
		gameBoard.moveToTalon();
		assertFalse(gameBoard.getTalon().isStackEmpty());
		assertEquals(1, gameBoard.getTalon().getSize());
		assertEquals(23,gameBoard.getDeck().getSize());

	}
	
	
	@Test
	public void testSetTableau() {
		CardStack s = new CardStack();
		Card c1 = new Card (0, 0);
		s.addToStack(c1);
		gameBoard.setTableau(0, s);
		
		CardStack f = gameBoard.getTableaus()[0];
		
		assertEquals(1, f.getSize());
		assertEquals(c1, f.getCardStack().peek());
		
	}
	
	@Test
	public void testCheckMoveTableauPassFirstTableau() {
		CardStack s = new CardStack();
		Card c1 = new Card (2, 1);
		c1.flip(true);
		
		s.addToStack(c1);
		gameBoard.setTableau(0, s);
		
		Card c2 = new Card(0, 0);
		c2.flip(true);
		CardStack s2 = new CardStack();
		s2.addToStack(c2);
		
		gameBoard.setTalon(s2);
		
		
		assertTrue(gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack()));
		assertEquals(2, gameBoard.getTableaus()[0].getSize());
		assertEquals(0, gameBoard.getTalon().getSize());
		
		
	}
	
	@Test
	public void testCheckMoveTableauPassFourthTableau() {
		CardStack s1 = new CardStack();
		CardStack s2 = new CardStack();
		CardStack s3 = new CardStack();
		CardStack s4 = new CardStack();
		CardStack s5 = new CardStack();
		CardStack s6 = new CardStack();
		CardStack s7 = new CardStack();
		
		Card c1 = new Card (1, 0);
		Card c2 = new Card (3, 5);
		Card c3 = new Card (1, 2);
		Card c4 = new Card (2, 1);
		Card c5 = new Card (1, 5);
		Card c6 = new Card (1, 5);
		Card c7 = new Card (0, 1);
		
		c1.flip(true);
		c2.flip(true);
		c3.flip(true);
		c4.flip(true);
		c5.flip(true);
		c6.flip(true);
		c7.flip(true);
		
		s1.addToStack(c1);
		s2.addToStack(c2);
		s3.addToStack(c3);
		s4.addToStack(c4);
		s5.addToStack(c5);
		s6.addToStack(c6);
		s7.addToStack(c7);
		gameBoard.setTableau(0, s1);
		gameBoard.setTableau(1, s2);
		gameBoard.setTableau(2, s3);
		gameBoard.setTableau(3, s4);
		gameBoard.setTableau(4, s5);
		gameBoard.setTableau(5, s6);
		gameBoard.setTableau(6, s7);
		
		Card cardToAdd = new Card(0, 0);
		cardToAdd.flip(true);
		
		CardStack talon = new CardStack();
		talon.addToStack(cardToAdd);
		
		gameBoard.setTalon(talon);
		
		//System.out.println(gameBoard.getTalon().getCardStack().peek());
		
		
		assertTrue(gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack()));
		//System.out.println(gameBoard.getTableaus()[0].getCardStack().peek());
		//System.out.println(gameBoard.getTableaus()[3].getCardStack().peek());
		assertEquals(2, gameBoard.getTableaus()[3].getSize());
		
	}
	
	@Test
	public void testCheckMoveTableauPassSeventhTableau() {
		CardStack s1 = new CardStack();
		CardStack s2 = new CardStack();
		CardStack s3 = new CardStack();
		CardStack s4 = new CardStack();
		CardStack s5 = new CardStack();
		CardStack s6 = new CardStack();
		CardStack s7 = new CardStack();
		Card c1 = new Card (2, 0);
		Card c2 = new Card (0, 0);
		Card c3 = new Card (1, 2);
		Card c4 = new Card (1, 1);
		Card c5 = new Card (1, 5);
		Card c6 = new Card (1, 5);
		Card c7 = new Card (2, 1);
		
		c1.flip(true);
		c2.flip(true);
		c3.flip(true);
		c4.flip(true);
		c5.flip(true);
		c6.flip(true);
		c7.flip(true);
		
		s1.addToStack(c1);
		s2.addToStack(c2);
		s3.addToStack(c3);
		s4.addToStack(c4);
		s5.addToStack(c5);
		s6.addToStack(c6);
		s7.addToStack(c7);
		
		gameBoard.setTableau(0, s1);
		gameBoard.setTableau(1, s2);
		gameBoard.setTableau(2, s3);
		gameBoard.setTableau(3, s4);
		gameBoard.setTableau(4, s5);
		gameBoard.setTableau(5, s6);
		gameBoard.setTableau(6, s7);
		
		
		
		assertTrue(gameBoard.moveCardTableau(gameBoard.getTableaus()[1].getCardStack()));
		
		assertEquals(2, gameBoard.getTableaus()[6].getSize());
	}
	
	@Test
	public void testCheckMoveTableauRightSuitWrongRank() {
		//try to move right suit wrong rank to tableau
		CardStack s1 = new CardStack();
		CardStack s2 = new CardStack();
		CardStack s3 = new CardStack();
		CardStack s4 = new CardStack();
		CardStack s5 = new CardStack();
		CardStack s6 = new CardStack();
		CardStack s7 = new CardStack();
		CardStack s8 = new CardStack();
		
		
		Card c1 = new Card (2, 0);
		s1.addToStack(c1);
		
		
		Card c2 = new Card(0, 3);
		
		s8.addToStack(c2);
		
		gameBoard.setTalon(s8);
		gameBoard.setTableau(0, s1);
		gameBoard.setTableau(1, s2);
		gameBoard.setTableau(2, s3);
		gameBoard.setTableau(3, s4);
		gameBoard.setTableau(4, s5);
		gameBoard.setTableau(5, s6);
		gameBoard.setTableau(6, s7);
		
		
//		assertFalse(gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack()));
		gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack());
		assertEquals(1, gameBoard.getTalon().getSize());
		assertEquals(1, gameBoard.getTableaus()[0].getSize());
		
	}
	
	@Test
	public void testCheckMoveTableauWrongSuitRightRank() {
		//try to move wrong suit right rank to tableau
		CardStack s1 = new CardStack();
		CardStack s2 = new CardStack();
		CardStack s3 = new CardStack();
		CardStack s4 = new CardStack();
		CardStack s5 = new CardStack();
		CardStack s6 = new CardStack();
		CardStack s7 = new CardStack();
		CardStack s8 = new CardStack();
		
		Card c1 = new Card (2, 3);
		s1.addToStack(c1);
		
		
		Card c2 = new Card(2, 2);
		s8.addToStack(c2);
		
		gameBoard.setTalon(s8);
		gameBoard.setTableau(0, s1);
		gameBoard.setTableau(1, s2);
		gameBoard.setTableau(2, s3);
		gameBoard.setTableau(3, s4);
		gameBoard.setTableau(4, s5);
		gameBoard.setTableau(5, s6);
		gameBoard.setTableau(6, s7);
		
		assertEquals(gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack()),false);
		
		assertEquals(1, gameBoard.getTableaus()[0].getSize());
	}
	
	
	@Test
	public void testMoveFoundationPass() {
		//move ace to foundation
		Card c = new Card (2, 0);
		Stack<Card> s = new Stack<Card>();
		s.add(c);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		gameBoard.moveFoundation(s);
		assertFalse(gameBoard.getFoundation()[2].isStackEmpty());
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void testMoveFoundationFailRightSuitWrongRankEmptyFoundation() {
		//try to move right suit wrong rank to empty foundation
		Card c = new Card (2, 3);
		Stack<Card> s = new Stack<Card>();
		s.add(c);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		gameBoard.moveFoundation(s);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		
	}
	
	@Test
	public void testMoveFoundationFailWrongSuitRightRankEmptyFoundation() {		
		//try to move wrong suit right rank to empty foundation
		Card c = new Card (1, 0);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		Stack<Card> s = new Stack<Card>();
		s.add(c);
		gameBoard.moveFoundation(s);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());	
	}
	
	@Test
	public void testMoveFoundationFailWrongSuitRightRankPopulatedFoundation() {		
		//try to move right suit wrong rank to foundation populated foundation
		Card c = new Card (2, 3);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		Stack<Card> s = new Stack<Card>();
		s.add(c);
		gameBoard.moveFoundation(s);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());	
	}
	
	@Test
	public void testMoveFoundationFailRightSuitWrongRankPopulatedFoundation() {				
		//try to move wrong suit right rank to foundation populated foundation
		Card c = new Card (3, 2);
		assertTrue(gameBoard.getFoundation()[2].isStackEmpty());
		Stack<Card> s = new Stack<Card>();
		s.add(c);
		gameBoard.moveFoundation(s);
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
		
		////the first three foundation pile has all 13 cards while the last foundation is empty.
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
	
	@Test
	public void testCheckWinFailWithoutSettingTheFirstFoundation() {
		//the last foundation pile has all 13 cards while the first foundation is empty.
		CardStack s;
		Card c = new Card(0, 0);
		for(int i = 1; i < 4; i ++) {
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
	

	@Test
	public void testMoveStackCardTableau() {
		//test move stack from tableau to tableau
		
		CardStack s1 = new CardStack();
		CardStack s2 = new CardStack();
		CardStack s3 = new CardStack();
		CardStack s4 = new CardStack();

		Card c1 = new Card (0, 7);
		Card c2 = new Card (2, 3);
		Card c3 = new Card (1, 2);
		Card c4 = new Card (2, 1);
		
		Card c5 = new Card (1, 3);
		Card c6 = new Card (2, 6);
		Card c7 = new Card (1, 4);
		
		c2.flip(true);
		c3.flip(true);
		c4.flip(true);
		c7.flip(true);
		
		s1.addToStack(c1);
		s1.addToStack(c2);
		s1.addToStack(c3);
		s1.addToStack(c4);

		s2.addToStack(c5);
		s2.addToStack(c6);
		s2.addToStack(c7);
		
		gameBoard.setTableau(0, s1);
		gameBoard.setTableau(1, s2);
		
		gameBoard.moveStackCardTableau(gameBoard.getTableaus()[0].getCardStack());
		
		//test the size and the first card in the move and be moved tableaus
		assertEquals(gameBoard.getTableaus()[1].getCardStack().peek(), c4);
		assertEquals(1,gameBoard.getTableaus()[0].getSize());
		assertEquals(6,gameBoard.getTableaus()[1].getSize());
		assertEquals(gameBoard.getTableaus()[0].getCardStack().peek(), c1);
		
		
		//test move stack from tableau to empty tableau
		Card c8 = new Card (3, 12);
		Card c9 = new Card (0, 11);
		Card c10 = new Card(2,4);
		
		c8.flip(true);
		c9.flip(true);
		
		s3.addToStack(c10);
		s3.addToStack(c8);
		s3.addToStack(c9);
		
		gameBoard.setTableau(2, s3);
		gameBoard.setTableau(3, s4);
		
		gameBoard.moveStackCardTableau(gameBoard.getTableaus()[2].getCardStack());
		//test the size and first card in the move and be moved tableaus
		assertEquals(gameBoard.getTableaus()[3].getCardStack().peek(), c9);
		assertEquals(1,gameBoard.getTableaus()[2].getSize());
		assertEquals(2,gameBoard.getTableaus()[3].getSize());
		assertEquals(gameBoard.getTableaus()[0].getCardStack().peek().isFaceUp(), true);
	}

	@Test
	public void testSetMoves(){
		assertEquals(gameBoard.getMoves(),0);
		
		gameBoard.setMoves(4);
		
		assertEquals(gameBoard.getMoves(),4);
	}

}
