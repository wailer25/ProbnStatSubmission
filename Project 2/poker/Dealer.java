package poker;

import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
public class Dealer {
	
	
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}
	
	public void deal(Player p) {
		Random rng = new Random();
		
		for (int i = 0; i < p.getHand().length; i++)
		{
			p.getHand()[i] = deck.drawAtIndex(rng.nextInt(deck.size()));
		}
	}
	
	public void retrieveHand(Player p) {
		for (Card c: p.getHand())
			deck.add(c);
	}
	
	public void sortHand(Player p) {
		int index = 0;
		Card min = null;
		Card tmp = null;
		boolean sort;
		
		for (int i = 0; i < p.getHand().length; i++)
		{
			sort = false;
			min = p.getHand()[i];
			for (int j = i + 1; j < p.getHand().length; j++)
			{
				if ((p.getHand()[j].getRank() < min.getRank()) || (p.getHand()[j].getRank() == 13 && min.getRank() < 5))
				{
					if(!(min.getRank() == 13 && p.getHand()[j].getRank() < 5))
					{
						min = p.getHand()[j];
						index = j;
						sort = true;
					}
					
				}
			}
			if(sort)
			{
				tmp = p.getHand()[i];
				p.getHand()[i] = min;
				p.getHand()[index] = tmp;
			}
		}
	}
	
	public boolean twoOfAKind(Player p) {
		int match = 0;
		
		for (int i = 0; i < p.getHand().length; i++)
		{
			for (int j = i + 1; j < p.getHand().length; j++)
			{
				if (p.getHand()[i].getRank() == p.getHand()[j].getRank())
				{
					match++;
					break;
				}
			}
		}
		
		if (match == 1)
			return true;
		return false;
	}
	
	public boolean threeOfAKind(Player p) {
		int match = 0;
		
		for (int i = 0; i < p.getHand().length; i++)
		{
			for (int j = i + 1; j < p.getHand().length; j++)
			{
				if (p.getHand()[i].getRank() == p.getHand()[j].getRank())
				{
					match++;
					break;
				}
			}
		}
		
		//checks for two pair to prevent false positives
		if (match == 2 && !twoPair(p))
			return true;
		return false;
	}
	
	public boolean fourOfAKind(Player p) {
		int match = 0;
		
		for (int i = 0; i < p.getHand().length; i++)
		{
			for (int j = i + 1; j < p.getHand().length; j++)
			{
				if (p.getHand()[i].getRank() == p.getHand()[j].getRank())
				{
					match++;
					break;
				}
			}
		}
		
		//checks for full house to prevent false positives
		if (match == 3 && !fullHouse(p))
			return true;
		return false;
	}
	
	public boolean twoPair(Player p) {
		int match1 = 0;
		int match2 = 0;
		
		for (int i = 0; i < p.getHand().length; i++)
		{
			for (int j = i + 1; j < p.getHand().length; j++)
			{
				if ((p.getHand()[i].getRank() == p.getHand()[j].getRank()) && (i < 2))
				{
					match1++;
					break;
				}
				
				if ((p.getHand()[i].getRank() == p.getHand()[j].getRank()) && (i >= 2))
				{
					if (!(p.getHand()[0].getRank() == p.getHand()[j].getRank()) || !(p.getHand()[1].getRank() == p.getHand()[j].getRank()))
					{
						match2++;
						break;
					}				}
			}
		}
		
		if (match1 == 1 && match2 == 1)
			return true;
		return false;
	}
	
	public boolean fullHouse(Player p) {
		int match1 = 0;
		int match2 = 0;
		
		for (int i = 0; i < p.getHand().length; i++)
		{
			for (int j = i + 1; j < p.getHand().length; j++)
			{
				if ((p.getHand()[i].getRank() == p.getHand()[j].getRank()) && (i < 2))
				{
					match1++;
					break;
				}
				
				if ((p.getHand()[i].getRank() == p.getHand()[j].getRank()) && (i >= 2))
				{
					if (!(p.getHand()[0].getRank() == p.getHand()[j].getRank()) || !(p.getHand()[1].getRank() == p.getHand()[j].getRank()))
					{
						match2++;
						break;
					}
				}
			}
		}
		
		if ((match1 == 2 && match2 == 1) || (match1 == 1 && match2 == 2))
			return true;
		return false;
	}
	
	public boolean straight(Player p) {
		boolean straight = true;
		int loopCheck = 0;
		sortHand(p);
		
		if ((p.getHand()[0].getRank() == 1) || (p.getHand()[0].getRank() == 12) || (p.getHand()[0].getRank() == 13))
			loopCheck++;
		
		for (int i = 1; i < p.getHand().length; i++)
		{
			if(!((p.getHand()[i].getRank() - p.getHand()[i - 1].getRank() == 1) || (p.getHand()[i].getRank() == 1 && p.getHand()[i - 1].getRank() == 13)))
				straight = false;
			
			if ((p.getHand()[i].getRank() == 1) || (p.getHand()[i].getRank() == 12) || (p.getHand()[i].getRank() == 13))
				loopCheck++;
			
		}
		
		if(loopCheck >= 3)
			straight = false;
		
		return straight;
	}
	
	public boolean flush(Player p) {
		int match = 0;
		
		for (int i = 1; i < p.getHand().length; i++)
		{
			if (p.getHand()[0].getSuite().equalsIgnoreCase(p.getHand()[i].getSuite()))
				match++;
		}
		
		if (match == 4)
			return true;
		return false;
	}
	
	public boolean straightFlush(Player p) {
		int match = 0;
		boolean straight = true;
		int loopCheck = 0;
		sortHand(p);
		
		if ((p.getHand()[0].getRank() == 1) || (p.getHand()[0].getRank() == 12) || (p.getHand()[0].getRank() == 13))
			loopCheck++;
		
		for (int i = 1; i < p.getHand().length; i++)
		{
			if (p.getHand()[0].getSuite().equalsIgnoreCase(p.getHand()[i].getSuite()))
				match++;
			
			if ((p.getHand()[i].getRank() == 1) || (p.getHand()[i].getRank() == 12) || (p.getHand()[i].getRank() == 13))
				loopCheck++;
			
			if(!((p.getHand()[i].getRank() - p.getHand()[i - 1].getRank() == 1) || (p.getHand()[i].getRank() == 1 && p.getHand()[i - 1].getRank() == 13)))
				straight = false;
		}
		
		if(loopCheck >= 3)
			straight = false;
		
		if (match == 4 && straight)
			return true;
		return false;
	}
	
	public boolean royalFlush(Player p) {
		int match = 0;
		boolean straight = true;
		boolean royal = true;
		sortHand(p);
		
		for (int i = 1; i < p.getHand().length; i++)
		{
			if (p.getHand()[0].getSuite().equalsIgnoreCase(p.getHand()[i].getSuite()))
				match++;
			
			if(!((p.getHand()[i].getRank() - p.getHand()[i - 1].getRank() == 1) || (p.getHand()[i].getRank() == 1 && p.getHand()[i - 1].getRank() == 13)))
				straight = false;
			
			if (p.getHand()[0].getRank() < 9 || p.getHand()[i].getRank() < 9)
				royal = false;
		}

		
		if (match == 4 && straight && royal)
			return true;
		return false;
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	public HashMap<String, Integer> calculateHandStrength(int plays) {
		HashMap<String, Integer> statTrack = new HashMap<>();
		Player p = new Player();
		
		for (int i = 0; i <= plays; i++)
		{
			shuffle();
			deal(p);
			
			int tmp = evaluate(p);
			
			switch (tmp)
			{
				case 0:
					if (!statTrack.containsKey("High Card"))
						statTrack.put("High Card", 1);
					else
						statTrack.replace("High Card", statTrack.get("High Card") + 1);
					break;
				case 1:
					if (!statTrack.containsKey("Two of a Kind"))
						statTrack.put("Two of a Kind", 1);
					else
						statTrack.replace("Two of a Kind", statTrack.get("Two of a Kind") + 1);
					break;
				case 2:
					if (!statTrack.containsKey("Two Pair"))
						statTrack.put("Two Pair", 1);
					else
						statTrack.replace("Two Pair", statTrack.get("Two Pair") + 1);
					break;
				case 3:
					if (!statTrack.containsKey("Three of a Kind"))
						statTrack.put("Three of a Kind", 1);
					else
						statTrack.replace("Three of a Kind", statTrack.get("Three of a Kind") + 1);
					break;
				case 4:
					if (!statTrack.containsKey("Straight"))
						statTrack.put("Straight", 1);
					else
						statTrack.replace("Straight", statTrack.get("Straight") + 1);
					break;
				case 5:
					if (!statTrack.containsKey("Flush"))
						statTrack.put("Flush", 1);
					else
						statTrack.replace("Flush", statTrack.get("Flush") + 1);
					break;
				case 6:
					if (!statTrack.containsKey("Full House"))
						statTrack.put("Full House", 1);
					else
						statTrack.replace("Full House", statTrack.get("Full House") + 1);
					break;
				case 7:
					if (!statTrack.containsKey("Four of a Kind"))
						statTrack.put("Four of a Kind", 1);
					else
						statTrack.replace("Four of a Kind", statTrack.get("Four of a Kind") + 1);
					break;
				case 8:
					if (!statTrack.containsKey("Straight Flush"))
						statTrack.put("Straight Flush", 1);
					else
						statTrack.replace("Straight Flush", statTrack.get("Straight Flush") + 1);
					break;
				default:
					if (!statTrack.containsKey("Royal Flush"))
						statTrack.put("Royal Flush", 1);
					else
						statTrack.replace("Royal Flush", statTrack.get("Royal Flush") + 1);
					break;
			}
			
			retrieveHand(p);
		}
		
		return statTrack;
			
	}
	
	public void printHandPercentages(int plays) {
		HashMap<String, Integer> stats = calculateHandStrength(plays);
		for (String s : stats.keySet())
			System.out.println(s + ": " + (double)stats.get(s) / plays);
	}
	
	public int evaluate(Player p) {
		
		if (twoOfAKind(p))
			return 1;
		if (twoPair(p))
			return 2;
		if (threeOfAKind(p))
			return 3;
		if (straight(p))
		{
			if (straightFlush(p))
			{
				if (royalFlush(p))
					return 9;
				return 8;
			}
			return 4;
		}
		if (flush(p))
			return 5;
		if (fullHouse(p))
			return 6;
		if (fourOfAKind(p))
			return 7;
		return 0;
	}
	
	public String evaluateString(Player p)
	{
		if (twoOfAKind(p))
			return "Two of a Kind";
		if (twoPair(p))
			return "Two Pairs";
		if (threeOfAKind(p))
			return "Three of a Kind";
		if (straight(p))
		{
			if (straightFlush(p))
			{
				if (royalFlush(p))
					return "Royal Flush!!!";
				return "Straight Flush";
			}
			return "Straight";
		}
		if (flush(p))
			return "Flush";
		if (fullHouse(p))
			return "Full House";
		if (fourOfAKind(p))
			return "Four of a Kind";
		return "High Card";
	}
	
	public int evaluate(Player p1, Player p2)
	{
		if (evaluate(p1) > evaluate(p2))
			return 1;
		else if (evaluate(p1) < evaluate(p2))
			return -1;
		else
		{
			int hC1 = 0;
			int hC2 = 0;
			
			for (int i = 0; i < p1.getHand().length; i++)
			{
				if (p1.getHand()[i].getRank() > hC1)
					hC1 = p1.getHand()[i].getRank();
				if (p2.getHand()[i].getRank() > hC2)
					hC2 = p2.getHand()[i].getRank();
			}
			if (hC1 > hC2)
				return 1;
			else if (hC1 < hC2)
				return -1;
			else
				return 0;
		}
	}
	public int gamble(Player p, int wager) {
		int bet = p.wager(wager);
		int result = evaluate(p);
		int winnings = 0;
		if (result == 1)
		{
			winnings = (int)(1.5*bet);
		}
		else
			winnings = result*bet;
		p.payout(winnings);
		
		return winnings;
	}
	
	public void singlePlay()
	{
		Scanner sc = new Scanner(System.in);
		Player p = new Player();
		System.out.println("Starting poker game");
		String input = "";
		boolean end = false;
		while(!end)
		{
			boolean valid = false;
			int bet = 0;
			while(!valid)
			{
				System.out.println("Choose amount to wager: current chip count " + p.getChips());
				
				input = sc.nextLine();
				try
				{
					bet = Integer.parseInt(input);
					valid = true;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Please input a number");
				}
			}
			System.out.println("Dealing Cards");
			deal(p);
			System.out.println(evaluateString(p));
			for (Card c : p.getHand())
				System.out.print(c + " ");
			System.out.println();
			System.out.println("You have earned " + gamble(p, bet) + " chips back");
			retrieveHand(p);
			shuffle();
			if(p.getChips() == 0)
			{
				System.out.println("The house always wins");
				sc.close();
				System.exit(0);
			}
			
			System.out.println("Press y to play again");
			input = sc.nextLine();
			
			if(!input.equalsIgnoreCase("y"))
			{
				System.out.println("Goodbye");
				end = true;
				sc.close();
			}
		}
	}
	
	public void playTwo() {
		Player p2 = new Player("Player 1");
		Player p1 = new Player("Player 2");
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		String input = "";
		while (!end)
		{
			System.out.println("Dealing Cards");
			deal(p1);
			deal(p2);
			
			System.out.println(p1 + ": " + evaluateString(p1));
			for (Card c : p1.getHand())
				System.out.print(c + " ");
			System.out.println();
			
			System.out.println(p2 + ": " + evaluateString(p2));
			for (Card c : p2.getHand())
				System.out.print(c + " ");
			System.out.println();
			
			if (evaluate(p1, p2) > 0)
				System.out.println(p1 + " wins the round");
			else if (evaluate(p1, p2) < 0)
				System.out.println(p2 + " wins the round");
			else
				System.out.println("This round is a draw");
			
			retrieveHand(p1);
			retrieveHand(p2);
			shuffle();
			
			System.out.println("Press y to play again");
			input = sc.nextLine();
			
			if (!input.equalsIgnoreCase("y"))
			{
				end = true;
				sc.close();
			}
			
		}
		System.out.println("Goodbye");
		
		
	}

}
