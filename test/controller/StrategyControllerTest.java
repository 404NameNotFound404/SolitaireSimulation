package controller;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import entity.TableTop;
/**
 * @author MiaLi
 *
 */

import entity.TableTop;

public class StrategyControllerTest {
	//a boolean to store the game result
	public boolean result;
	public TableTop gameBoard;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {

		//play game and get the result
		
		//System.out.println("test");
		 gameBoard =  StrategyController.StaticStrategyController.playGame();

	}

	
	
 	@Test
	public void testPlayGame() {
 		/**
 		 * get the gameBoard from StrategyController and check if it wins, 
 		 * the gameBoard result should equals to the playGame result
 		 */
 		System.out.println("play");
 		boolean gameResult = gameBoard.checkForWin();
 		assertEquals(gameResult,result);
 		
	}

	@Test
	public void testMoveTableuToFoundation() {
		/**
		 * if the result of playGame is true, which means you cannot move any cards from tableau to foundation 
		 * so the result of moveTableauToFoundation should be false
		 */
		System.out.println("move");
		if (result == true){
			assertFalse(StrategyController.StaticStrategyController.moveTableauToFoundation());
		}
	}
	
	@Test
	public void testGetTurns() {

		/**
		 * if game loses which means you use up three times to go through the deck so turns should be 3
		 * else turns < 3
		 */
		//System.out.println(StrategyController.StaticStrategyController.getTurns());
		
		if (result == false)
		{
			assertEquals(3, gameBoard.getTurns());
		}
		else
		{
			assertFalse(gameBoard.getTurns() == 3);
		}
		
	
	}
	
	@Test
	public void testGetTime() {
 		
// 		assertFalse(StrategyController.StaticStrategyController.getTime() == 0);
	}
	
}
