package practiceproblems;

import java.util.Random;
public class Game {
	
	String[] doors = {"Dud", "Dud", "Prize"};
	
	public Game() {
		
	}
	
	public void playRandom(int attempts) {
		Random rng = new Random();
		int winCount = 0;
		int failCount = 0;
		
		for (int i = 0; i < attempts; i++)
		{
			if (doors[rng.nextInt(3)].equals("Prize"))
				winCount++;
			else
				failCount++;
		}
		
		System.out.println("Wins: " + winCount + "Fails: " + failCount);
	}

}
