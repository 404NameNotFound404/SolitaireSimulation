package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Before;

public class StrategyControllerTest {
	
	public boolean result;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		result =  StrategyController.StaticStrategyController.playGame();
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
		assertEquals(0,StrategyController.StaticStrategyController.getTurns());
		
		if (result == false)
		{
			assertEquals(3, StrategyController.StaticStrategyController.getTurns());
		
		}
		else
		{
			assertFalse(StrategyController.StaticStrategyController.getTurns() == 3);
		}
		
	}
	
	@Test
	public void testGetTime() {
 		
 		assertFalse(StrategyController.StaticStrategyController.getTime() == 0);
	}
	
}
