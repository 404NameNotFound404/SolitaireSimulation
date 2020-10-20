package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ReportController {

	
	
	public void writeToFile(String fileName, String contents) {
		String newFileContents = processFile(fileName, contents);
		
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("strategyReports/" + fileName));
			file.append(newFileContents);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private String processFile(String fileName, String contentsToAdd) {
		
		String fileContents = "";
		String entryDelimiter = "";
		double numEnteries = 1.0;
		double winPercent = 0.0;
		double aveTurns = 0.0;
		double aveMoveTime = 0.0;
		try {
			Scanner scanner = new Scanner(new File("strategyReports/" +fileName));
			while(scanner.hasNext()) {
				numEnteries += 1.0;
				String winPercentage = scanner.nextLine();
				winPercent += getNumFromLine(winPercentage);
				String averageTurns = scanner.nextLine();
				aveTurns += getNumFromLine(averageTurns);
				String averageMoveTime = scanner.nextLine();
				aveMoveTime += getNumFromLine(averageMoveTime);
				entryDelimiter = scanner.nextLine();
				fileContents += winPercentage + "\n" + averageTurns + "\n" + averageMoveTime + "\n" + 
						"--------------------------------------------\n";
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			new File("strategyReports/" +fileName);
		}
		
		String[] newEntery = contentsToAdd.split("\n");
		
		winPercent += getNumFromLine(newEntery[0]);
		aveTurns += getNumFromLine(newEntery[1]);
		aveMoveTime += getNumFromLine(newEntery[2]);
		
		fileContents += contentsToAdd + "======================================\n";
		
		System.out.println("Number of Enteries: " + numEnteries);
		System.out.println("Win Percentage: " + (winPercent / numEnteries));
		System.out.println("Average turns in winnable games: " + (aveTurns / numEnteries));
		System.out.println("Average move time over all games: " + (aveMoveTime / numEnteries));
		
		return fileContents;
	}
	
	private double getNumFromLine(String line) {
		String[] splitLine = line.split(": ");
		double numFromLine = Double.parseDouble(splitLine[1]);
		return numFromLine;
	}
	
	
	
}