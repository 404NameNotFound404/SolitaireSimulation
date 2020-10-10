package controller;

/**
 * @author AnnaNguyen
 *
 */
public class SimulationController {
	public static int wins;
	public static int totalTurns;
	public static int games;
	public static double totalTimeToPlay;
	
	public static class StaticStrategyController{
		
		/**
		 * 
		 */
		public static void startSimulation(int games) {
			for (int i = 0; i < games; i ++) {
				if(StrategyController.StaticStrategyController.playGame()) {
					wins++;
				}
				
				totalTurns += StrategyController.StaticStrategyController.getTurns();
			}
			
			
		}

		/**
		 * 
		 */
		public static double getWinPercentage() {		
			return wins/games;
		}
		
		/**
		 * 
		 */
		public static double getAverageTurns() {		
			return totalTurns/games;
		}
		
		/**
		 * 
		 */
		public static void getAverageTime() {		
			
		}
		
		public static void main(String[] args) {
			startSimulation(Integer.parseInt(args[0]));
			
			System.out.println("Win Percentage: " + getWinPercentage());
			
			System.out.println("Average Turns: " + getAverageTurns());
		
		}
		
		
	}
}