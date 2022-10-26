package graphmanipulation;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;
public class GraphManipulator {
	
	private FileWriter fileOut;
	private FileReader fileIn;
	
	public GraphManipulator() {
		
	}
	
	/**
	 * writes the coordinates to an nLog(n) graph to a .csv file
	 * using a user given x value and range
	 * @param fileName
	 * @param x
	 * @param range
	 * @throws Exception
	 */
	public void nLogNGraph(String fileName, double x, int range) throws Exception {
		
		fileOut = new FileWriter(fileName + ".csv");
		BufferedWriter bf = new BufferedWriter(fileOut);
		
		bf.write("X, Y");
		bf.newLine();
		
		double y = 0;
		double tmp = x;
		
		for (int i = 0; i <= range; i++)
		{
			y = x * Math.log10(x);
			bf.write(x + ", " + y);
			bf.newLine();
			x += tmp;
		}
		
		bf.flush();
		bf.close();
	}
	
	/**
	 * reads in a graph from a .csv file and randomizes the data within
	 * a bound determined by the user
	 * @param fileName
	 * @param saltBounds
	 * @throws Exception
	 */
	public void salter(String fileName, int saltBounds) throws Exception {
		
		fileIn = new FileReader(fileName + ".csv");
		Scanner sc = new Scanner(fileIn);
		
		fileOut = new FileWriter("salted" + fileName + ".csv");
		BufferedWriter bf = new BufferedWriter(fileOut);
		
		Random rng = new Random();
		
		sc.nextLine();
		bf.write("X, Y");
		bf.newLine();
		
		while(sc.hasNextLine())
		{
			String[] tmp = sc.nextLine().split(",| ");
			double x = Double.parseDouble(tmp[0]);
			double y = Double.parseDouble(tmp[1]);
			
			int operand = rng.nextInt(2);
			int salt = rng.nextInt(saltBounds);
			
			if (operand == 0)
				y -= salt;
			else
				y += salt;
			
			bf.write(x + ", " + y);
			bf.newLine();
		}
		
		bf.flush();
		bf.close();
		
	}
	
	/**
	 * reads in a salted graph and smoothens it out in an attempt to recreate the original 
	 * by averaging out the values within a user determined range
	 * @param filename
	 * @param range
	 * @throws Exception
	 */
	public void smoother(String filename, int range) throws Exception {
		
		fileIn = new FileReader(filename + ".csv");
		Scanner sc = new Scanner(fileIn);
		
		fileOut = new FileWriter("smoothed" + filename + ".csv");
		BufferedWriter bf = new BufferedWriter(fileOut);
		
		sc.nextLine();
		bf.write("X, Y");
		bf.newLine();
		int i = 0;
		double avgX = 0; 
		double avgY = 0;
		
		while (sc.hasNextLine())
		{
			String[] tmp = sc.nextLine().split(",| ");
			double x = Double.parseDouble(tmp[0]);
			double y = Double.parseDouble(tmp[1]);
			
			if (i == range * 2 + 1)
			{
				avgX = avgX / (range * 2 + 1); 
				avgY = avgY / (range * 2 + 1); 

				
				bf.write(avgX + ", " + avgY);
				bf.newLine();
				avgX = 0;
				avgY = 0;
				i = 0;
			}
			i++;
			avgX += x;
			avgY += y;
		}
		
		bf.flush();
		bf.close();
	}

}
