package controller;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import entity.TableTop;
/**
 * @author MiaLi
 *
 */


public class SimulationControllerTest {
	
	public ArrayList<TableTop> games = new ArrayList<TableTop>();
	public int totalTurns, averageTurns;
	public long totalTime, averageTime;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {

		TableTop gameboard1 = new TableTop();
		TableTop gameboard2 = new TableTop();
		TableTop gameboard3 = new TableTop();
		
		gameboard1.setWin(false);
		
		gameboard1.setTurns(4);
		gameboard2.setTurns(5);
		gameboard3.setTurns(6);
		
		totalTurns = 4 + 5 + 6;
		averageTurns = totalTurns/3;
		
		gameboard1.setTime(7);
		gameboard2.setTime(8);
		gameboard3.setTime(9);
		
		totalTime = 9 + 7 + 8;
		averageTime = totalTime /3;
		
		games.add(gameboard1);
		games.add(gameboard2);
		games.add(gameboard3);

	}
	
	@Test
	public void testGetWins() {
		
		assertTrue(SimulationController.getWins(games)== 2);

	}
	
	@Test
	public void testGetTotalTurns() {
		
		assertEquals(SimulationController.getTotalTurns(games), totalTurns);
	}
	
	@Test
	public void testGetWinPercentage() {
		//assumer win percentage to be 2/3
		double pert = 2/3;		
		assertTrue(SimulationController.StaticStrategyController.getWinPercentage(games) == pert);
		
	}
	
	@Test
	public void testGetAverageTurns() {
		
		assertTrue(SimulationController.StaticStrategyController.getAverageTurns(games) == averageTurns);
		
	}
	
	@Test
	public void testGetTotalTimeToPlay() {
	
		assertTrue(SimulationController.getTotalTimeToPlay(games) == totalTime);
		
	}
	
	@Test
	public void testGetAverageTime() {
	
		assertTrue(SimulationController.StaticStrategyController.getAverageTime(games) == averageTime);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testStartSimulation()
	{
		int games = 10;
		SimulationController.StaticStrategyController cn = null;
		ArrayList<TableTop> tables = cn.startSimulation(games);
		double time = 0;
		double turns = 0;
		for (TableTop tab : tables)
		{
			time = time + tab.getTime();
			turns = turns + tab.getTurns();
		}
		assertNotEquals(0, time);
		assertNotEquals(0, turns);
			
	}
}