/**
 * 
 */
package controller;

import entity.Card;
import entity.CardStack;
import entity.TableTop;

/**
 * @author AnnaNguyen
 *
 */
public class StrategyController {
	public static TableTop gameBoard;
	public static long timeToPlay;
	
	public static class StaticStrategyController{

		/**
		 * Play the game
		 */
		public static TableTop playGame() {
			int deckTurns = 0;
			long start = System.currentTimeMillis();
			gameBoard = new TableTop();
			gameBoard.generateBoard();
			
			//Print out the deck before play game
			System.out.println("Deck before play game: ");
			gameBoard.printDeck();
			
			//Print out tableaus before move
			System.out.println();
			System.out.println("Tableaus before move: ");
			gameBoard.printTableaus();

			while(gameBoard.checkForWin() == false && deckTurns < 3) {
				//Check if the Deck is empty to reset the Deck
				if (gameBoard.getDrawPile().getSize() == 0) {
					deckTurns++;
					gameBoard.resetDrawPile();
					System.out.println();
					System.out.println("RESET THE DECK OF CARDS!!");
				}
				
		
				//Move cards between tableaus 
				CardStack[] tableaus = gameBoard.getTableaus();
				for (CardStack tab: tableaus) {
					if(!tab.isStackEmpty()) {
						System.out.println("The top card in the tableau: " +tab.getCardStack().peek());
						gameBoard.moveCardTableau(tab.getCardStack());
					}
				}
				
				//Check if tableau cards can go to foundations	
				for(CardStack t: tableaus) {
					if (!t.isStackEmpty()) {
					gameBoard.moveFoundation(t.getCardStack());
					}
				}
				
				System.out.println();
				System.out.println("FOUNDATIONS AFTER GO THROUGH TABLEAUS: ");
				gameBoard.printFoundations();
				
				//Draw card from Deck Card to Talon
				gameBoard.moveToTalon();
				
				//Print out first card in Talon
				System.out.println();
				System.out.println("THE FIRST CARD IN TALON: ");
				//System.out.println(gameBoard.getTalon().getCardStack().peek().toString());
				
				//Check if the card can go into any of the foundation stacks
				if(gameBoard.moveFoundation(gameBoard.getTalon().getCardStack())) {
					continue;
				}
				
				//Check if the card can go into any of the Tableaus
				gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack());
				
				//Print out tableaus after move
				System.out.println();
				System.out.println("Tableaus after move: ");
				gameBoard.printTableaus();

			}
			
			long end = System.currentTimeMillis();
			timeToPlay = end - start;
			
			gameBoard.setTime(timeToPlay);
			
			//Print out the deck after play game
			gameBoard.printDeck();

			return gameBoard;
		}

//		/**
//		 * Check to see if any cards in the Tableaus can be moved
//		 * into the foundation
//		 * @return True if it move any card from the Tableaus to 
//		 * the Foundations
//		 */
//		public static boolean moveTableauToFoundation() {
//
//			boolean check = false;
//			
//			//get the tableaus from the foundation
//			CardStack[] tableaus = gameBoard.getTableaus();
//
//			for(CardStack s: tableaus) {
//				check = gameBoard.moveFoundation(s.getCardStack());
//			}
//
//			return check;
//		}
	



	}
}
