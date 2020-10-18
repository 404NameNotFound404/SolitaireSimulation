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

		public static double getWinPercentage(ArrayList<TableTop> games) {
			int w = getWins(games);
			int g = games.size();
			return (double) w/(double) g;
		}

		/**
		 * Get the average turns
		 * @return the average turns as integer
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


		public static int getWins(ArrayList<TableTop> games) {
			int w = 0;

			for(TableTop t: games) {
				if(t.checkForWin()==true) {
					w++;
				}
			}
			return w;
		}


		public static int getTotalMoves(ArrayList<TableTop> games) {
			int turns = 0;
			for(TableTop t: games) {

				turns += t.getMoves();

			}
			return turns;
		}

		public static double getAverageMoveTime(ArrayList<TableTop> games) {
			return (double) timeToPlay/ getTotalMoves(games);
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
			System.out.println("Thread : " + i + " is running");
			thread.join();
		}


		long end = System.currentTimeMillis();
		timeToPlay = end - start;



		System.out.println("Win Percentage: " + MyRunnable.getWinPercentage(allGames));

		System.out.println("Average turns in winnable games: " + MyRunnable.getAverageMovesWinnable(allGames));

		System.out.println("Average move time over all games: " + MyRunnable.getAverageMoveTime(allGames));

	}

}
