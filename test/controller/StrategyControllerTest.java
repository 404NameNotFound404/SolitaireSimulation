package controller;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import entity.TableTop;

public class StrategyControllerTest {
	
	public boolean result;
	public TableTop gameBoard;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		 gameBoard =  StrategyController.StaticStrategyController.playGame();
	}

	
	
 	@Test
	public void testPlayGame() {
 		
 		fail("Not yet implemented");
	}

	@Test
	public void testMoveTableuToFoundation() {
		
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetTurns() {
//		assertEquals(0,StrategyController.StaticStrategyController.getTurns());
		
		if (result == false)
		{
			assertEquals(3, gameBoard.getTurns());
		
		}
		else
		{
//			assertFalse(StrategyController.StaticStrategyController.getTurns() == 3);
		}
		
	}
	
	@Test
	public void testGetTime() {
 		
// 		assertFalse(StrategyController.StaticStrategyController.getTime() == 0);
	}
	
}
