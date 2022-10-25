package fishproblem;

import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.util.Scanner;

/**
 * FishMarket Javadoc.
 * @author Andrew
 * 
 * @version 1.00
 * 
 *
 */
public class FishMarket {
	
	private ArrayList<Seafood> market;
	private FileWriter fileout;
	private FileReader filein;
	
	public FishMarket() {
		market = new ArrayList<>();
	}
	
	//generates a market of random seafood based on user given size
	public void generateMarket(int size) {
		Random rng = new Random();
		
		for (int i = 0; i < size; i++)
		{
			int x = rng.nextInt(100);
			
			if (x < 25)
				market.add(new Fish());
			else if (24 < x && x < 50)
				market.add(new Shrimp());
			else if (49 < x && x < 75)
				market.add(new Scallop());
			else
				market.add(new Crab());
			
		}
	}
	
	//generates a fish market allowing user to alter the chance of certain seafood appearing 
	public void weightedGeneration(int fish, int shrimp, int scallop, int crab, int size) {
		Random rng = new Random();
		
		for (int i = 0; i < size; i++)
		{
			int x = rng.nextInt(100);
			
			if (x < fish)
				market.add(new Fish());
			else if (fish < x && x < (fish + shrimp))
				market.add(new Shrimp());
			else if ((fish + shrimp) < x && x < (fish + shrimp + scallop))
				market.add(new Scallop());
			else
				market.add(new Crab());	
		}
		
	}
	
	//prints out all the seafood held within market arraylist
	public void printMarket() {
		System.out.println("Index, Type, Weight, Price");
		DecimalFormat fm = new DecimalFormat("#.00");
		
		for (int i = 0; i < market.size(); i++)
		{
			System.out.println((i + 1) + ", " + market.get(i).getType()
					+ ", " + fm.format(market.get(i).getWeight()) + ", " 
					+ fm.format(market.get(i).getPrice()));
		}
	}
	
	/**
	 * Writes an arraylist to a .csv file
	 * @param String
	 * @throws Exception
	 */
	public void toCSV(String filename) throws Exception {
		fileout = new FileWriter(filename + ".csv");
		BufferedWriter bf = new BufferedWriter(fileout);
		DecimalFormat fm = new DecimalFormat("#.00");

		bf.write("Index, Type, Weight, Price");
		bf.newLine();
		
		for (int i = 0; i < market.size(); i++)
		{
			bf.write((i + 1) + ", " + market.get(i).getType()
					+ ", " + fm.format(market.get(i).getWeight()) + ", " 
					+ fm.format(market.get(i).getPrice()));
			bf.newLine();
		}
		
		bf.flush();
		bf.close();
		
	}
	
	/**
	 * Loads a .csv file into an arraylist
	 * @param String
	 * @throws Exception
	 */
	public void csvToArray(String filename) throws Exception {
		filein = new FileReader(filename + ".csv");
		Scanner sc = new Scanner(filein);
		
		sc.nextLine();
		
		while(sc.hasNextLine())
		{
			String[] tmp = sc.nextLine().split(", ");
			
			if (tmp[1].equals("Fish"))
				market.add(new Fish(Double.parseDouble(tmp[2]), Double.parseDouble(tmp[3])));
			else if (tmp[1].equals("Shrimp"))
				market.add(new Shrimp(Double.parseDouble(tmp[2]), Double.parseDouble(tmp[3])));
			else if (tmp[1].equals("Scallop"))
				market.add(new Scallop(Double.parseDouble(tmp[2]), Double.parseDouble(tmp[3])));
			else
				market.add(new Crab(Double.parseDouble(tmp[2]), Double.parseDouble(tmp[3])));
		}
		
	}

}
