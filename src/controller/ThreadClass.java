package controller;

import entity.TableTop;

/**
 * 
 * @author mythanhthaonguyen
 *
 */
public class ThreadClass {
	private int wins = 0;
	private long time = 0;
	
	public static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			System.out.println("MyRunnable running");
			TableTop t = StrategyController.StaticStrategyController.playGame(3);
			
			System.out.println("MyRunnable finished");
			
			
		}
	}
	
	public static void main(String[] args) {
		
		for (int i =0; i < 10; i ++)
		{
			Thread thread = new Thread (new MyRunnable());
			thread.start();
			System.out.println("Thread : " + i + " is running");
		}
	}

}
