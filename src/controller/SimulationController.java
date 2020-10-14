package controller;
import java.util.ArrayList;

import entity.TableTop;
/**
 * @author AnnaNguyen
 *
 */
public class SimulationController {

	
	/**
	 * Method that calculate the standard deviation of an array list
	 * @param result list
	 * @param mean 
	 * @return the standard deviation in double
	 */
	public static double standardDev (double[] result, double mean) {
		double[] mean_array = new double[result.length];
		for (int h = 0; h < result.length; h ++) {
			mean_array[h] = (result[h] - mean)*(result[h] - mean);
		}
		
		double s = 0;
		for(double o: mean_array) {
			s = s + o;
		}
		
		double mean_dev = s/result.length;
		double dev = Math.sqrt(mean_dev);
		return dev;
				
	}
	
	public static int getWins(ArrayList<TableTop> games) {
		int w = 0;
		
		for(TableTop t: games) {
			if(t.getWin()==true) {
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
			
			ArrayList<TableTop> allGames = startSimulation(1000);

			double[] turnsArray = new double[allGames.size()];
			double[] timeArray = new double[allGames.size()];
			
			for (int i = 0; i < allGames.size(); i++) {
				turnsArray[i] = allGames.get(i).getTurns();
				timeArray[i] = allGames.get(i).getTime();
			}
			System.out.println("Win Percentage: " + getWinPercentage(allGames));
			
			System.out.println("Average Turns: " + getAverageTurns(allGames));
			
			System.out.println("Standard Deviation for number of card moves per game: " 
			+ standardDev(turnsArray, getAverageTurns(allGames)));
			
			System.out.println("Average Times per Game: " + getAverageTime(allGames));
			
			System.out.println("Standard Deviation for number of time play per game: " 
					+ standardDev(timeArray, getAverageTime(allGames)));
			
			
		
		}
		
		
	}
}