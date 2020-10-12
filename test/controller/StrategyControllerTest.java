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
	public TableTop gameBoard;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {

		//play game and get the gameBoard
		
		 gameBoard =  StrategyController.StaticStrategyController.playGame();

	}

	
	
 	@Test
	public void testPlayGame() {
 		//if the game is played the turns will not be 0
 		assertFalse(gameBoard.getTurns() == 0);
 		
	}

	@Test
	public void testMoveTableuToFoundation() {
		/**
		 * if the result of gameBoard is true, which means you cannot move any cards from tableau to foundation 
		 * so the result of moveTableauToFoundation should be false
		 */
		
		if (gameBoard.checkForWin() == true){
			assertFalse(StrategyController.StaticStrategyController.moveTableauToFoundation());
		}
	}
	
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
