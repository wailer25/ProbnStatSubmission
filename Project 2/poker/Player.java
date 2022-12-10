package poker;

public class Player {
	
	private Card[] hand;
	private int chips;
	private String name;
	
	public Player() {
		hand  = new Card[5];
		chips = 200;
		name = "Player";
	}
	public Player(String name) {
		hand  = new Card[5];
		chips = 200;
		this.name = name;
	}
	
	public Card[] getHand() {
		return hand;
	}
	
	public void setHand(Card[] hand) {
		this.hand = hand;
	}
	
	public int getChips() {
		return chips;
	}
	
	public void setChips(int chips) {
		this.chips = chips;
	}
	
	public int wager(int bet) {
		
		if (chips > bet)
			chips -= bet;
		else
		{
			bet = chips;
			chips = 0;
		}
		
		return bet;
	}
	
	public void payout(int winnings) {
		chips += winnings;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
