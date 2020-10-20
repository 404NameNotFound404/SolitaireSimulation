package controller;

import java.util.ArrayList;

import entity.TableTop;

/**
 * 
 * @author mythanhthaonguyen
 *
 */
public class ThreadClass {

	public static int numGame;

	public static long timeToPlay;

	public static ArrayList<TableTop> allGames = new ArrayList<TableTop>();

	public static class MyRunnable implements Runnable {

		@Override
		public void run() {
			TableTop t = StrategyController.StaticStrategyController.playGame(3);
			allGames.add(t);

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
		 * Get the number of win games
		 * @param games 
		 * @return the number of win game
		 */
		public static int getWins(ArrayList<TableTop> games) {
			int w = 0;

			for(TableTop t: games) {
				if(t.checkForWin()==true) {
					w++;
				}
			}
			return w;
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
		public static double getAverageMoveTime(ArrayList<TableTop> games) {
			return  (double) getTotalMoves(games)/  timeToPlay;
		}


	}

	public static void main(String[] args) throws InterruptedException {
		

		numGame = Integer.parseInt(args[0]);
		Thread[] threads = new Thread[numGame];

		//record time in millisecond
		long start = System.currentTimeMillis();

		for (int i =0; i < numGame; i ++)
		{
			Thread thread = new Thread (new MyRunnable());
			thread.start();
			thread.join();
		}


		long end = System.currentTimeMillis();
		timeToPlay = end - start;



		System.out.println("Win Percentage: " + MyRunnable.getWinPercentage(allGames));

		System.out.println("Average turns in winnable games: " + MyRunnable.getAverageMovesWinnable(allGames));

		System.out.println("Average move time over all games: " + MyRunnable.getAverageMoveTime(allGames));
		

	}

}
