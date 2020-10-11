package controller;
import java.util.ArrayList;

import entity.TableTop;
/**
 * @author AnnaNguyen
 *
 */
public class SimulationController {
	public static int wins;
	public static int totalTurns;
	public static int games;
	public static double totalTimeToPlay;
	/**
	 * 
	 */
	private static TableTop gameBoard;
	
	public static TableTop getGameBoard() {
		return gameBoard;
	}

	public static void setGameBoard(TableTop gameBoard) {
		SimulationController.gameBoard = gameBoard;
	}

	public static int getWins() {
		return wins;
	}

	public static void setWins(int wins) {
		SimulationController.wins = wins;
	}

	public static int getTotalTurns() {
		return totalTurns;
	}

	public static void setTotalTurns(int totalTurns) {
		SimulationController.totalTurns = totalTurns;
	}

	public static int getGames() {
		return games;
	}

	public static void setGames(int games) {
		SimulationController.games = games;
	}

	public static double getTotalTimeToPlay() {
		return totalTimeToPlay;
	}

	public static void setTotalTimeToPlay(double totalTimeToPlay) {
		SimulationController.totalTimeToPlay = totalTimeToPlay;
	}

	public static class StaticStrategyController{

		

		/**
		 * 
		 */
		public static ArrayList<TableTop> startSimulation(int games) {
			ArrayList<TableTop> results = new ArrayList<TableTop>();
			for (int i = 0; i < games; i ++) {
				gameBoard =  StrategyController.StaticStrategyController.playGame();
				if(gameBoard.checkForWin()) {
					wins++;	
				}
				
				totalTimeToPlay += gameBoard.getTime();
				totalTurns += gameBoard.getTurns();
				
				results.add(gameBoard);
			}
			return results;
			
			
		}

		/**
		 * 
		 */
		public static double getWinPercentage() {
			double w = wins;
			double g = games;
			return w/g;
		}
		
		/**
		 * 
		 */
		public static double getAverageTurns() {
			double turns = totalTurns;
			double g = games;
			return turns/g;
		}
		
		/**
		 * 
		 */
		public static double getAverageTime() {
			double g = games;
			return totalTimeToPlay/g;
		}
		
		public static void main(String[] args) {
			startSimulation(Integer.parseInt(args[0]));
			
			System.out.println("Win Percentage: " + getWinPercentage());
			
			System.out.println("Average Turns: " + getAverageTurns());
		
		}
		
		
	}
}