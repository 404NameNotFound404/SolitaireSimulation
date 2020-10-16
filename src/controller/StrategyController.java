/**
 * 
 */
package controller;

import java.util.ArrayList;

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
		public static TableTop playGame(int n) {
			int deckTurns = 0;
			boolean stop = false;
			
			gameBoard = new TableTop();
			gameBoard.generateBoard(n);

//			//Print out the deck before play game
//			System.out.println("Deck before play game: ");
//			gameBoard.printDeck();
//
//			//Print out tableaus before move
//			System.out.println();
//			System.out.println("Tableaus before move: ");
//			gameBoard.printTableaus();
			
			//record time in millisecond
			long start = System.currentTimeMillis();
			
			while(gameBoard.checkForWin() == false && stop == false) {
				int turns = gameBoard.getTurns();
				//System.out.println("TURNS: " + turns);
				if (deckTurns < 3) {
					//Check if the Deck is empty to reset the Deck
					if (gameBoard.getDrawPile().getSize() == 0) {
						deckTurns++;
						gameBoard.resetDrawPile();
						//System.out.println();
						//System.out.println("RESET THE DECK OF CARDS!!");
						//gameBoard.printDeck();
					}
				}



				CardStack[] tableaus = gameBoard.getTableaus();
//				System.out.println();
//				for (CardStack tab: tableaus) {
//					if(!tab.isStackEmpty()) {
//
//						System.out.println("The top card in the tableau: " +tab.getCardStack().peek());
//
//					}
//
//				}
				
				//Check if tableau cards can go to foundations	
				for(CardStack t: tableaus) {
					if (!t.isStackEmpty()) {
						gameBoard.moveFoundation(t.getCardStack());

					}
				}

//				System.out.println();
//				System.out.println("FOUNDATIONS AFTER GO THROUGH TABLEAUS: ");
//				gameBoard.printFoundations();
			
				
				
				if (deckTurns < 3) {
					if (!gameBoard.getDrawPile().getCardStack().isEmpty()) {
						//Draw card from Deck Card to Talon
						gameBoard.moveToTalon();
					}

					if (!gameBoard.getTalon().getCardStack().isEmpty()) {
						//Print out first card in Talon
//						System.out.println();
//						System.out.println("THE FIRST CARD IN TALON: ");
//						System.out.println(gameBoard.getTalon().getCardStack().peek().toString());

						//Check if the card can go into any of the foundation stacks
						if(gameBoard.moveFoundation(gameBoard.getTalon().getCardStack())) {
							continue;
						}

						//Check if the card can go into any of the Tableaus
						gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack());

					}
					
					for (CardStack tabl: tableaus) {
						
						if(!tabl.isStackEmpty()) {

							//Move card between tableaus
							//gameBoard.moveCardTableau(tabl.getCardStack());

							//Move stack of cards between tableaus
							gameBoard.moveStackCardTableau(tabl.getCardStack());

						}
					}
				}
				else if(deckTurns == 3 && turns == gameBoard.getTurns()) {
					stop = true;
				}
				else if(turns > 1000) {
					stop = true;
				}
			
				//Print out tableaus after move
//				System.out.println();
//				System.out.println("Tableaus after move: ");
//				gameBoard.printTableaus();

			}

			long end = System.currentTimeMillis();
			timeToPlay = end - start;

			gameBoard.setTime(timeToPlay);

			//Print out the deck after play game
			//gameBoard.printDeck();

			return gameBoard;
		}





	}
}
