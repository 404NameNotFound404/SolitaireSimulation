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
				turns += t.getMoves();
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

	}

	public static void main(String[] args) throws InterruptedException {
		
		numGame = Integer.parseInt(args[0]);
		Thread[] threads = new Thread[numGame];
		for (int i =0; i < numGame; i ++)
		{
			Thread thread = new Thread (new MyRunnable());
			thread.start();
			System.out.println("Thread : " + i + " is running");
			thread.join();
		}

		
		
		System.out.println("Win Percentage: " + MyRunnable.getWinPercentage(allGames));

		System.out.println("Average Turns: " + MyRunnable.getAverageTurns(allGames));

		System.out.println("Average Times per Game: " + MyRunnable.getAverageTime(allGames));
	}

}
