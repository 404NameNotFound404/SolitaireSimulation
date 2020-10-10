/**
 * 
 */
package controller;

import entity.CardStack;
import entity.TableTop;

/**
 * @author AnnaNguyen
 *
 */
public class StrategyController {
	public static TableTop gameBoard;
	public static int turns;
	public static long timeToPlay;
	
	public static class StaticStrategyController{

		/**
		 * Play the game
		 */
		public static boolean playGame() {
			int turns = 0;
			long start = System.currentTimeMillis();
			gameBoard = new TableTop();

			while(gameBoard.checkForWin()== false || turns == 3) {
				
				//Check if the Deck is empty to reset the Deck
				if (gameBoard.getDrawPile().getSize() != 0) {
					moveTableauToFoundation();
				}
				else {
					turns++;
					gameBoard.resetDrawPile();
				}
				
				//Draw card from Deck Card to Talon
				gameBoard.moveToTalon();
				//Check if the card can go into any of the foundation stacks
				if(gameBoard.moveFoundation(gameBoard.getTalon().getCardStack().peek())) {
					continue;
				}
				//Check if the card can go into any of the Tableaus
				gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack().peek());


			}
			
			long end = System.currentTimeMillis();
			timeToPlay = end - start;
			
			return gameBoard.checkForWin();
		}

		/**
		 * Check to see if any cards in the Tableaus can be moved
		 * into the foundation
		 * @return True if it move any card from the Tableaus to 
		 * the Foundations
		 */
		public static boolean moveTableauToFoundation() {

			boolean check = false;
			//get the tableaus from the foundation
			CardStack[] tableaus = gameBoard.getTableaus();

			for(CardStack s: tableaus) {
				check = gameBoard.moveFoundation(s.getCardStack().peek());
			}

			return check;
		}
		
		/**
		 * Getter for turns 
		 * @return the number of turns
		 */
		public static int getTurns(){
			return turns;
		}
		
		/**
		 * Getter for time to play
		 * @return the time of the game
		 */
		public static long getTime() {
			return timeToPlay;
		}
		




	}
}
