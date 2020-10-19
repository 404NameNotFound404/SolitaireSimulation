package controller;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import entity.Deck;
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
		
		gameboard1.generateBoard(1);
		gameboard2.generateBoard(2);
		gameboard3.generateBoard(2);
		
		gameboard1.setTurns(4);
		gameboard2.setTurns(5);
		gameboard3.setTurns(6);
				
		totalTurns = 4 + 5 + 6;
		averageTurns = totalTurns/3;
		
//		gameboard1.setTime(7);
//		gameboard2.setTime(8);
//		gameboard3.setTime(9);
		
		totalTime = 9 + 7 + 8;
		averageTime = totalTime /3;
		
		games.add(gameboard1);
		games.add(gameboard2);
		games.add(gameboard3);

	}
	
	@Test
	public void testGetWinsNone() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(2);
		System.out.println(gameboard4.checkForWin());
		games2.add(gameboard4);
		assertTrue(SimulationController.StaticStrategyController.getWins(games2)== 0);

	}
	
	@Test
	public void testGetWinsOne() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(1);
		games2.add(gameboard4);
		assertTrue(SimulationController.StaticStrategyController.getWins(games2)== 1);
		
	}
		
	
	@Test
	public void testGetWinPercentage() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
	
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(1);
		TableTop gameboard5 = StrategyController.StaticStrategyController.playGame(2);
		
		games2.add(gameboard4);
		games2.add(gameboard5);
		
		assertEquals(SimulationController.StaticStrategyController.getWinPercentage(games2), 0.5);
		
	}
	
	@Test
	public void testGetAverageMovesWinnable() {
		//TODO
	}
	
	@Test
	public void testGetTotalMoves() {
		//TODO
	}
	
	@Test
	public void testGetAverageMoveTime() {
		//TODO
	}

	
	@Test
	public void testStandardDev()
	{
		double[] list = {11.0,11.0,11.0,11.0};
		double mean = 11.0;
		double SD = SimulationController.StaticStrategyController.standardDev(list, mean);
		assertEquals(SD, 0.0);
		
		double[] list2 = {1,2,3,4,5,6};
		mean = 3.5;
		double SD2 = SimulationController.StaticStrategyController.standardDev(list2, mean);
		assertEquals(SD2, 1.707825127659933);
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
			turns = turns + tab.getTurns();
		}
		assertNotEquals(0, turns);
			
	}
}