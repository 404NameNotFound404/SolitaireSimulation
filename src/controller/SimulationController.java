package controller;
import java.util.ArrayList;

import controller.ThreadClass.MyRunnable;
import entity.TableTop;
/**
 * @author AnnaNguyen
 *
 */
public class SimulationController {

	
	public static class StaticSimulationController{
		
		
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

		/**
		 * Get the number of win games
		 * @param games 
		 * @return the number of win game
		 */
		public static int getWins(ArrayList<TableTop> games) {
			int w = 0;

			for(TableTop t: games) {
				if(t.checkForWin()) {
					w++;
				}
			}
			return w;
		}


		/**
		 * Get the average moves for winnable games
		 * @return the average moves for winnable games
		 */
		public static double getAverageMovesWinnable(ArrayList<TableTop> games) {
			int moves = 0;
			for(TableTop t: games) {
				if(t.checkForWin()) {
					moves += t.getMoves();
				}

			}
			return (double) moves/getWins(games);
		}

		/**
		 * Get the total moves for all the games
		 * @param games
		 * @return the number of moves for all the game
		 */
		public static int getTotalMoves(ArrayList<TableTop> games) {
			int moves = 0;
			for(TableTop t: games) {

				moves += t.getMoves();

			}
			return moves;
		}

		/**
		 * Get the average move time over all games played
		 * @param games
		 * @return the average move time in double
		 */
		public static double getAverageMoveTime(ArrayList<TableTop> games, double timeToPlay) {
			
			return (double) getTotalMoves(games)/  timeToPlay;
		}
		/**
		 * Start the simulation
		 * @return an array list of game boards
		 */
		public static ArrayList<TableTop> startSimulation(int games) {
			ArrayList<TableTop> results = new ArrayList<TableTop>();
			
			for (int i = 0; i < games; i ++) {
				TableTop gameBoard =  StrategyController.StaticStrategyController.playGame(3);			
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
			return (double) w/(double) g;
		}
		
		public static double getTimePerGame(ArrayList<TableTop> games, double timeToPlay) {
			return (double) timeToPlay/games.size(); 
		}





		public static void main(String[] args) {

			long start = System.currentTimeMillis();
			ArrayList<TableTop> allGames = startSimulation(Integer.parseInt(args[0]));
			long end = System.currentTimeMillis();
			double timeToPlay = (double) (end - start) / 1000;
			
			String report = "Number of games: " + Integer.parseInt(args[0]) + "\n"
					+ "Win Percentage: " + getWinPercentage(allGames) + "\n"
					+ "Average turns in winnable games: " + getAverageMovesWinnable(allGames) + "\n"
					+ "Average move time over all games (moves/second): " + getAverageMoveTime(allGames, timeToPlay) + "\n";
			
			System.out.println("Time per game: " + getTimePerGame(allGames, timeToPlay));

			System.out.println(report);

			new ReportController().writeToFile("Linear simulation statistics", report);




		}


	}
}