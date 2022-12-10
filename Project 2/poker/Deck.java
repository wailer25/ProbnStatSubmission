package poker;

import java.util.Random;
public class Deck {

	private Card[] deck;
	private int size;
	public Deck() {
		deck = new Card[52];
		size = 0;
		generateDeck();
	}
	
	private void generateDeck() {
		
		int num = 2;
		for (int i = 1; i < deck.length + 1; i++) 
		{
			if (i%13 == 1)
			{
				if (i <= 13)
					deck[i - 1] = new Card("Ace", "Spades");
				else if (i > 13 && i <= 26)
					deck[i - 1] = new Card("Ace", "Clubs");
				else if (i > 26 && i <= 39)
					deck[i - 1] = new Card("Ace", "Diamonds");
				else
					deck[i - 1] = new Card("Ace", "Hearts");
				
				size++;
			}
			else
			{
				if (i%13 == 11)
				{
					if (i <= 13)
						deck[i - 1] = new Card("Jack", "Spades");
					else if (i > 13 && i <= 26)
						deck[i - 1] = new Card("Jack", "Clubs");
					else if (i > 26 && i <= 39)
						deck[i - 1] = new Card("Jack", "Diamonds");
					else
						deck[i - 1] = new Card("Jack", "Hearts");
					
					size++;
				}
				else if (i%13 == 12)
				{
					if (i <= 13)
						deck[i - 1] = new Card("Queen", "Spades");
					else if (i > 13 && i <= 26)
						deck[i - 1] = new Card("Queen", "Clubs");
					else if (i > 26 && i <= 39)
						deck[i - 1] = new Card("Queen", "Diamonds");
					else
						deck[i - 1] = new Card("Queen", "Hearts");
					
					size++;
				}
				else if (i%13 == 0)
				{
					if (i <= 13)
						deck[i - 1] = new Card("King", "Spades");
					else if (i > 13 && i <= 26)
						deck[i - 1] = new Card("King", "Clubs");
					else if (i > 26 && i <= 39)
						deck[i - 1] = new Card("King", "Diamonds");
					else
						deck[i - 1] = new Card("King", "Hearts");
					
					size++;
				}
				else
				{
					if (num > 10)
						num = 2;
					
					if (i <= 13)
						deck[i - 1] = new Card("" + num, "Spades");
					else if (i > 13 && i <= 26)
						deck[i - 1] = new Card("" + num, "Clubs");
					else if (i > 26 && i <= 39)
						deck[i - 1] = new Card("" + num, "Diamonds");
					else
						deck[i - 1] = new Card("" + num, "Hearts");
					
					num++;
					size++;
				}
			}
			
		}
	}
	
	public Card drawAtIndex(int index) {
		Card tmp = deck[index];
		
		for (int i = index; i < size - 1; i++)
		{
			deck[i] = deck[i + 1];
		}
		size--;
		
		return tmp;
	}
	
	public void shuffle() {
		Random rng = new Random();
		for (int i = 0; i < size - 1; i++)
		{
			int rand = rng.nextInt(size);
			Card tmp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = tmp;
		}
	}
	
	public void add(Card card) {
		if (size < deck.length)
			deck[size] = card;
		size++;
	}
	
	public Card[] getDeck() {
		return deck;
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		for(Card c : deck)
			System.out.println(c);
	}
}
