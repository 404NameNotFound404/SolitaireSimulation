package controller;
import static org.junit.Assert.*; 
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
	public int totalTurns, averageTurns, totalMoves;
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
		
		gameboard1.setMoves(7);
		gameboard2.setMoves(8);
		gameboard3.setMoves(9);
		
		totalMoves = 9 + 7 + 8;
		
		games.add(gameboard1);
		games.add(gameboard2);
		games.add(gameboard3);

	}
	
	@Test
	public void testGetWinsNone() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(2);
		games2.add(gameboard4);
		assertTrue(SimulationController.StaticSimulationController.getWins(games2)== 0);

	}
	
	@Test
	public void testGetWinsOne() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(1);
		games2.add(gameboard4);
		assertTrue(SimulationController.StaticSimulationController.getWins(games2)== 1);
		
	}
		
	
	@Test
	public void testGetWinPercentage() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
	
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(1);
		TableTop gameboard5 = StrategyController.StaticStrategyController.playGame(2);
		
		games2.add(gameboard4);
		games2.add(gameboard5);
		
		assertTrue(SimulationController.StaticSimulationController.getWinPercentage(games2)==0.5);
		
	}
	
	@Test
	public void testGetAverageMovesWinnable() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
		
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(1);
		TableTop gameboard5 = StrategyController.StaticStrategyController.playGame(2);
		TableTop gameboard6 = StrategyController.StaticStrategyController.playGame(1);
		gameboard4.setMoves(38);
		gameboard5.setMoves(32);
		gameboard6.setMoves(32);
		
		
		games2.add(gameboard4);
		games2.add(gameboard5);
		games2.add(gameboard6);
		
		assertTrue(SimulationController.StaticSimulationController.getAverageMovesWinnable(games2) == 35);
		
	}
	
	@Test
	public void testGetTotalMoves() {
		assertTrue(SimulationController.StaticSimulationController.getTotalMoves(games)== totalMoves);
	}
	
	@Test
	public void testGetAverageMoveTime() {
		ArrayList<TableTop> games2 = new ArrayList<TableTop>();
		
		long start = System.currentTimeMillis();
		TableTop gameboard4 = StrategyController.StaticStrategyController.playGame(1);
		TableTop gameboard5 = StrategyController.StaticStrategyController.playGame(2);
		TableTop gameboard6 = StrategyController.StaticStrategyController.playGame(1);
		long end = System.currentTimeMillis();
		long timeToPlay = end - start;
		
		gameboard4.setMoves(38);
		gameboard5.setMoves(32);
		gameboard6.setMoves(32);
		
		double averageTime = (double) (38 + 32+ 32) / timeToPlay;
		
		games2.add(gameboard4);
		games2.add(gameboard5);
		games2.add(gameboard6);
		assertTrue(SimulationController.StaticSimulationController.getAverageMoveTime(games2, timeToPlay) == averageTime);
	}

	
	@Test
	public void testStandardDev()
	{
		double[] list = {11.0,11.0,11.0,11.0};
		double mean = 11.0;
		double SD = SimulationController.StaticSimulationController.standardDev(list, mean);
		assertTrue(SD ==0.0);
		
		double[] list2 = {1,2,3,4,5,6};
		mean = 3.5;
		double SD2 = SimulationController.StaticSimulationController.standardDev(list2, mean);
		assertTrue(SD2== 1.707825127659933);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testStartSimulation()
	{
		int games = 10;
		SimulationController.StaticSimulationController cn = null;
		ArrayList<TableTop> tables = cn.startSimulation(games);
		double moves = 0;
		for (TableTop tab : tables)
		{
			moves = moves + tab.getMoves();
		}
		assertNotEquals(0, moves);
			
	}
}