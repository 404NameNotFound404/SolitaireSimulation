package controller;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import entity.TableTop;
/**
 * @author MiaLi
 *
 */

public class StrategyControllerTest {
	//a boolean to store the game result
	public boolean result;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		//play game and get the result
		result =  StrategyController.StaticStrategyController.playGame();
		//System.out.println("test");
	}

	
	
 	@Test
	public void testPlayGame() {
 		/**
 		 * get the gameBoard from StrategyController and check if it wins, 
 		 * the gameBoard result should equals to the playGame result
 		 */
 		System.out.println("play");
 		TableTop gameBoard = StrategyController.StaticStrategyController.getGameBoard();
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
			System.out.println(StrategyController.StaticStrategyController.getTurns());
			assertEquals(3, StrategyController.StaticStrategyController.getTurns());
			
		}
		
		else
		{
			System.out.println("else");
			assertFalse(StrategyController.StaticStrategyController.getTurns() == 3);		
		}
		
	}
	
	@Test
	public void testGetTime() {
 		
 		assertFalse(StrategyController.StaticStrategyController.getTime() == 0);
	}
	
}
