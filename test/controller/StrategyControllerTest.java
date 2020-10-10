package controller;

import static org.junit.jupiter.api.Assertions.*;

import controller.StrategyController;

import org.junit.jupiter.api.Test;

public class StrategyControllerTest {
	
 	@Test
	public void testPlayGame() {
 		
 		boolean result = StrategyController.StaticStrategyController.playGame();
 		System.out.print(result);
 		fail("Not yet implemented");
	}

	@Test
	public void testMoveTableuToFoundation() {
//		StrategyController.StaticStrategyController.moveTableauToFoundation();
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetTurns() {
		assertEquals(0,StrategyController.StaticStrategyController.getTurns());
		
		boolean result = StrategyController.StaticStrategyController.playGame();
		if (result == false);
			assertEquals(3, StrategyController.StaticStrategyController.getTurns());
		
		
	}
	
}
