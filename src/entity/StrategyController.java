/**
 * 
 */
package entity;

/**
 * @author AnnaNguyen
 *
 */
public class StrategyController {
	public static boolean win;
	public static TableTop gameBoard;
	public static int turns;
	public static double timeToPlay;
	public static class StaticStrategyController{
		
		/**
		 * 
		 */
		public static void playGame() {		
			gameBoard = new TableTop();
				
			moveTableauToFoundation();
			
			//Draw card from Deck Card to Talon
			gameBoard.moveToTalon();
			
			//Check if the card can go into any of the foundation stacks
			gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack().peek());
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
		
		
		
		
	}
}
