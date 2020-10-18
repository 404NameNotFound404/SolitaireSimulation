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
	//public static TableTop gameBoard;
	//public static long timeToPlay;

	public static class StaticStrategyController{

		/**
		 * Play the game
		 */
		public static TableTop playGame(int n) {
			int deckTurns = 0;
			int moves = 0;
			boolean stop = false;

			TableTop gameBoard = new TableTop();
			gameBoard.generateBoard(n);

			//Print out the deck before play game
//			System.out.println("Deck before play game: ");
//			gameBoard.printDeck();

			//Print out tableaus before move
//			System.out.println();
//			System.out.println("Tableaus before move: ");
//			gameBoard.printTableaus();


			while(gameBoard.checkForWin() == false && stop == false) {
				int turns = gameBoard.getTurns();
				//System.out.println("TURNS: " + turns);
				if (deckTurns < 3) {
					//Check if the Deck is empty to reset the Deck
					if (gameBoard.getDrawPile().getSize() == 0) {
						deckTurns++;
						gameBoard.resetDrawPile();
//						System.out.println();
//						System.out.println("RESET THE DECK OF CARDS!!");
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
				boolean check = true;
				while(check) {

					int turns_2 = gameBoard.getTurns();
					//Check if tableau cards can go to foundations	
					for(CardStack t: tableaus) {
						if (!t.isStackEmpty()) {
							gameBoard.moveFoundation(t.getCardStack());

						}
					}

					for (CardStack tabl: tableaus) {

						if(!tabl.isStackEmpty()) {

							//Move stack of cards between tableaus
							gameBoard.moveStackCardTableau(tabl.getCardStack());
						}
					}

					if (turns_2 == gameBoard.getTurns()) {
						check = false;
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

					check = true;
					while (check) {
						int turns_3 = gameBoard.getTurns();
						if (!gameBoard.getTalon().getCardStack().isEmpty()) {
							//Print out first card in Talon
//							System.out.println();
//							System.out.println("THE FIRST CARD IN TALON: ");
//							System.out.println(gameBoard.getTalon().getCardStack().peek().toString());

							//Check if the card can go into any of the foundation stacks
							if(gameBoard.moveFoundation(gameBoard.getTalon().getCardStack())) {
								moves++;
								continue;
							}

							//Check if the card can go into any of the Tableaus
							if(gameBoard.moveCardTableau(gameBoard.getTalon().getCardStack())){
								moves++;
							}

						}


						for (CardStack tabl: tableaus) {

							if(!tabl.isStackEmpty()) {

								//Move card between tableaus
								//gameBoard.moveCardTableau(tabl.getCardStack());

								//Move stack of cards between tableaus
								gameBoard.moveStackCardTableau(tabl.getCardStack());

							}
						}

						if (turns_3 == gameBoard.getTurns()) {
							check = false;
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



			//Print out the deck after play game
//			gameBoard.printDeck();

			gameBoard.setMoves(moves);
			return gameBoard;
		}





	}
}
