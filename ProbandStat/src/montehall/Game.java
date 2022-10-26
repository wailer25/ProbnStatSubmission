package montehall;

import java.util.Random;
public class Game {
	
	String[] doors = {"Dud", "Dud", "Prize"};
	
	public Game() {
		
	}
	
	
	public void playDoorChange(int attempts) {
		Random rng = new Random();
		int winCount = 0;
		int failCount = 0;
		
		/* Picks a random door from an array of three doors and removes a door from play
		 	allowing for a second chance if the first one fails acting as if you were given
		 	a choice to change once a door is revealed*/
		//increments wins if it hits the prize door otherwise increments fail
		for (int i = 0; i < attempts; i++)
		{
			if (doors[rng.nextInt(3)].equals("Dud"))
			{
				String[] newDoors = {"Dud", "Prize"};
				
				if(newDoors[rng.nextInt(2)].equals("Prize"))
					winCount++;
				else
					failCount++;
			}
			else
				winCount++;
		}
		
		//calculates win percent
		double winPercent = (double)winCount / (double)attempts;
		
		//prints number of wins and losses as well as win percentage
		System.out.println("Wins: " + winCount + " Fails: " + failCount);
		System.out.println("Win Percentage: " + winPercent);
	}
	
	public void play(int attempts) {
		Random rng = new Random();
		int winCount = 0;
		int failCount = 0;
		
		// Picks a random door from an array of three doors
		// a door is revealed however the choice does not change
		//increments wins if it hits the prize door otherwise increments fail
		for (int i = 0; i < attempts; i++)
		{
			int x = rng.nextInt(3);
			if (doors[x].equals("Dud"))
			{
				if (doors[x].equals("Prize"))
					winCount++;
				else
					failCount++;
			}
			else winCount++;
		}
		
		//calculates win percent
		double winPercent = (double)winCount / (double)attempts;

		//prints number of wins and losses as well as win percentage
		System.out.println("Wins: " + winCount + " Fails: " + failCount);
		System.out.println("Win Percentage: " + winPercent);
	}

}
