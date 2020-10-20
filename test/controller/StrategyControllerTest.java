package controller;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import entity.TableTop;
import java.util.*;
/**
 * @author MiaLi
 *
 */


public class StrategyControllerTest {
	//a boolean to store the game result
	public boolean result;
	public TableTop gameBoard1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {

		//play game and get the gameBoard
		
		 gameBoard1 =  StrategyController.StaticStrategyController.playGame(3);

	}

	
	
 	@Test
	public void testPlayGameWithRandomDeck() {
 		//if the game is played the turns will not be 0
 		assertFalse(gameBoard1.getTurns() == 0);
 		
	}
 	@SuppressWarnings("deprecation")
	@Test
	public void testPlayGameWithWinDeck() {
 		TableTop gameBoard2 = StrategyController.StaticStrategyController.playGame(1);
 		ArrayList<TableTop> games = new ArrayList<TableTop>();
 		games.add(gameBoard2);
 		assertTrue(SimulationController.StaticSimulationController.getWinPercentage(games)== 1.0);
 		
	}
 	
 	@Test
	public void testPlayGameWithImpossibleDeck() {
 		TableTop gameBoard2 = StrategyController.StaticStrategyController.playGame(2);
 		ArrayList<TableTop> games = new ArrayList<TableTop>();
 		games.add(gameBoard2);
 		assertTrue(SimulationController.StaticSimulationController.getWinPercentage(games)==0.0);
	}
 	
 	

//	@Test
//	public void testMoveTableuToFoundation() {
//		/**
//		 * if the result of gameBoard is true, which means you cannot move any cards from tableau to foundation 
//		 * so the result of moveTableauToFoundation should be false
//		 */
//		
//		if (gameBoard.checkForWin() == true){
//			assertFalse(StrategyController.StaticStrategyController.moveTableauToFoundation());
//		}
//	}
	
//	@Test
//	public void testGetTurns() {
//
//		/**
//		 * if game loses which means you use up three times to go through the deck so turns should be 3
//		 * else turns < 3
//		 */
//		
//		if (gameBoard.checkForWin() == false)
//		{
//			assertEquals(3, gameBoard.getTurns());
//		}
//		else
//		{
//			assertFalse(gameBoard.getTurns() == 3);
//		}
//		
//	}
	
//	@Test
//	public void testGetTime() {
// 		
//// 		assertFalse(StrategyController.StaticStrategyController.getTime() == 0);
//	}
	
}
