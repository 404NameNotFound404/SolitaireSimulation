package controller;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import entity.*;

class SimulationControllerTest {

	@Test
	void testGetGameBoard() {
		TableTop table = new TableTop();
		TableTop fakeTable = new TableTop();
		SimulationController.setGameBoard(table);
		assertEquals(SimulationController.getGameBoard(), table);
		assertNotEquals(SimulationController.getGameBoard(), fakeTable);;
	}

	@Test
	void testSetGameBoard() {
		TableTop table = new TableTop();
		TableTop fakeTable = new TableTop();
		SimulationController.setGameBoard(table);
		assertEquals(SimulationController.getGameBoard(), table);
		assertNotEquals(SimulationController.getGameBoard(), fakeTable);
	}
	
	@Test
	void testGetWins() {
		int wins = 7;
		int notWins = 8;
		SimulationController.setWins(wins);
		assertEquals(SimulationController.getWins(), wins);
		assertNotEquals(SimulationController.getWins(), notWins);
	}
	
	@Test
	void testSetWins() {
		int wins = 7;
		int notWins = 8;
		SimulationController.setWins(wins);
		assertEquals(SimulationController.getWins(), wins);
		assertNotEquals(SimulationController.getWins(), notWins);
	}
	
	@Test
	void testGetTotalTurns() {
		int turns = 50;
		int fakeTurns = 52;
		SimulationController.setTotalTurns(turns);
		assertEquals(SimulationController.getTotalTurns(), turns);
		assertNotEquals(SimulationController.getTotalTurns(), fakeTurns);
	}
	
	@Test
	void testSetTotalTurns() {
		int turns = 50;
		int fakeTurns = 52;
		SimulationController.setTotalTurns(turns);
		assertEquals(SimulationController.getTotalTurns(), turns);
		assertNotEquals(SimulationController.getTotalTurns(), fakeTurns);
	}
	
	@Test
	void testGetGames() {
		int games = 1000;
		int fakeGames = 1001;
		SimulationController.setGames(games);
		assertEquals(SimulationController.getGames(), games);
		assertNotEquals(SimulationController.getGames(), fakeGames);
	}
	
	@Test
	void testSetGames() {
		int games = 1000;
		int fakeGames = 1001;
		SimulationController.setGames(games);
		assertEquals(SimulationController.getGames(), games);
		assertNotEquals(SimulationController.getGames(), fakeGames);
	}
	
	@Test
	void testGetTotalTimeToPlay() {
		double time = 90.0;
		double badTime = 180.0;
		SimulationController.setTotalTimeToPlay(time);
		assertEquals(SimulationController.getTotalTimeToPlay(), time);
		assertNotEquals(SimulationController.getTotalTimeToPlay(), badTime);
	}
	
	@Test
	void testSetTotalTimeToPlay() {
		double time = 90.0;
		double badTime = 180.0;
		SimulationController.setTotalTimeToPlay(time);
		assertEquals(SimulationController.getTotalTimeToPlay(), time);
		assertNotEquals(SimulationController.getTotalTimeToPlay(), badTime);
	}
	
	@Test
	void testGetWinPercentage() {
		int game = 10;
		int wins = 4;
		double pert = 4.0/10.0;
		SimulationController.setGames(game);
		SimulationController.setWins(wins);
		assertEquals(SimulationController.StaticStrategyController.getWinPercentage(), pert);
		
	}
	
	@Test
	void testGetAverageTurns() {
		int game = 10;
		int turns = 40;
		double av = 40.0/10.0;
		SimulationController.setGames(game);
		SimulationController.setTotalTurns(turns);;
		assertEquals(SimulationController.StaticStrategyController.getAverageTurns(), av);
	}
	
	@Test
	void testGetAverageTime() {
		int game = 10;
		double time = 100.3454;
		double av = time/10.0;
		SimulationController.setGames(game);
		SimulationController.setTotalTimeToPlay(time);
		assertEquals(SimulationController.StaticStrategyController.getAverageTime(), av);
	}
}
