package controller;
import java.util.ArrayList;

import entity.TableTop;
/**
 * @author AnnaNguyen
 *
 */
public class SimulationController {


	public static int getWins(ArrayList<TableTop> games) {
		int w = 0;
		
		for(TableTop t: games) {
			if(t.checkForWin()==true) {
				w++;
			}
		}
		return w;
	}


	public static int getTotalTurns(ArrayList<TableTop> games) {
		int turns = 0;
		for(TableTop t: games) {
			turns += t.getTurns();
		}
		return turns;
	}



	public static long getTotalTimeToPlay(ArrayList<TableTop> games) {
		long totalTimeToPlay = 0;
		for(TableTop t: games) {
			totalTimeToPlay += t.getTime();
		}
		return totalTimeToPlay;
	}


	public static class StaticStrategyController{

		
		/**
		 * Start the simulation
		 * @return an array list of game boards
		 */
		public static ArrayList<TableTop> startSimulation(int games) {
			ArrayList<TableTop> results = new ArrayList<TableTop>();
			for (int i = 0; i < games; i ++) {
				TableTop gameBoard =  StrategyController.StaticStrategyController.playGame();			
				results.add(gameBoard);
			}
			return results;
			
			
		}

		/**
		 * Get the win percentage
		 * @return the win percentage in double
		 */
		public static double getWinPercentage(ArrayList<TableTop> games) {
			int w = getWins(games);
			int g = games.size();
			return w/g;
		}
		
		/**
		 * Get the average turns
		 * @return the average turns as integer
		 */
		public static double getAverageTurns(ArrayList<TableTop> games) {
			int turns = getTotalTurns(games);
			double g = games.size();
			return turns/g;
		}
		
		/**
		 * Get the average time play each game
		 * @return the average time for game in double
		 */
		public static double getAverageTime(ArrayList<TableTop> games) {
			long totalTimeToPlay = getTotalTimeToPlay(games);
			double g = games.size();
			return totalTimeToPlay/g;
		}
		
		public static void main(String[] args) {
			
			ArrayList<TableTop> allGames = startSimulation(Integer.parseInt(args[0]));
			
			System.out.println("Win Percentage: " + getWinPercentage(allGames));
			
			System.out.println("Average Turns: " + getAverageTurns(allGames));
			
			System.out.println("Average Times per Game: " + getAverageTime(allGames));
		
		}
		
		
	}
}