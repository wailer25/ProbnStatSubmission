package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class PokerTest {

	
	@Test
	public void testTwoOfAKind1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("3", "Spades"),
				new Card("Ace", "Diamonds"), new Card("7", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("2 of a Kind", tst.twoOfAKind(p));
	}
	
	@Test
	public void testTwoOfAKind2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("Ace", "Diamonds"), new Card("7", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		
		assertFalse("Too many matches", tst.twoOfAKind(p));
	}
	
	@Test
	public void testTwoOfAKind3() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("4", "Clubs"), new Card("6", "Spades"),
				new Card("Ace", "Diamonds"), new Card("7", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not enough matches", tst.twoOfAKind(p));
	}
	
	@Test
	public void testTwoOfAKind4() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("6", "Spades"),
				new Card("6", "Diamonds"), new Card("7", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Too many matches", tst.twoOfAKind(p));
	}

	
	@Test
	public void testThreeOfAKind1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("6", "Diamonds"), new Card("7", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("3 of a Kind", tst.threeOfAKind(p));
	}
	
	@Test
	public void testThreeOfAKind2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("6", "Spades"),
				new Card("6", "Diamonds"), new Card("2", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Too many matches", tst.threeOfAKind(p));
	}
	
	@Test
	public void testThreeOfAKind3() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("6", "Diamonds"), new Card("2", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Too many matches", tst.threeOfAKind(p));
	}
	
	@Test
	public void testThreeOfAKind4() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("6", "Spades"),
				new Card("6", "Diamonds"), new Card("7", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not enough matches", tst.threeOfAKind(p));
	}
	

	@Test
	public void tstFourOfAKind1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("6", "Diamonds"), new Card("2", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("4 of a Kind", tst.fourOfAKind(p));
	}
	
	@Test
	public void tstFourOfAKind2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("7", "Diamonds"), new Card("7", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not enough matches", tst.fourOfAKind(p));
	}
	
	
	@Test
	public void tstTwoPair1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("5", "Spades"),
				new Card("6", "Diamonds"), new Card("6", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("2 Pairs", tst.twoPair(p));
	}
	
	@Test
	public void tstTwoPair2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("6", "Diamonds"), new Card("2", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Two pairs of same rank", tst.twoPair(p));
	}
	
	@Test
	public void tstTwoPair3() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("6", "Diamonds"), new Card("6", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Too many matches", tst.twoPair(p));
	}
	
	
	@Test
	public void tstFullHouse1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("6", "Diamonds"), new Card("6", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("Full House", tst.fullHouse(p));
	}
	
	@Test
	public void tstFullHouse2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("2", "Diamonds"), new Card("2", "Clubs"), new Card("2", "Spades"),
				new Card("6", "Diamonds"), new Card("2", "Hearts")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not enough matches", tst.fullHouse(p));
	}
	
	
	@Test
	public void tstFlush1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("4", "Clubs"), new Card("2", "Clubs"), new Card("8", "Clubs"),
				new Card("6", "Clubs"), new Card("Jack", "Clubs")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("Flush", tst.flush(p));
	}
	
	@Test
	public void tstFlush2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("4", "Clubs"), new Card("2", "Diamonds"), new Card("8", "Clubs"),
				new Card("6", "Clubs"), new Card("Jack", "Clubs")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not enough matches", tst.flush(p));
	}
	
	
	@Test
	public void tstStraight1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("3", "Clubs"), new Card("5", "Clubs"), new Card("Ace", "Spades"),
				new Card("4", "Clubs"), new Card("2", "Diamonds")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("Straight", tst.straight(p));
	}
	
	@Test
	public void tstStraight2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("Queen", "Clubs"), new Card("King", "Clubs"), new Card("Ace", "Spades"),
				new Card("2", "Clubs"), new Card("3", "Diamonds")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not Straight", tst.straight(p));
	}
	
	
	@Test
	public void tstStraightFlush1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("3", "Clubs"), new Card("5", "Clubs"), new Card("Ace", "Clubs"),
				new Card("4", "Clubs"), new Card("2", "Clubs")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("Straight Flush", tst.straightFlush(p));
	}
	
	@Test
	public void tstStraightFlush2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("Ace", "Clubs"), new Card("2", "Clubs"), new Card("3", "Spades"),
				new Card("4", "Clubs"), new Card("5", "Diamonds")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not enough matches", tst.straightFlush(p));
	}
	
	@Test
	public void tstStraightFlush3() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("Queen", "Clubs"), new Card("King", "Clubs"), new Card("Ace", "Clubs"),
				new Card("2", "Clubs"), new Card("3", "Clubs")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not Straight", tst.straightFlush(p));
	}
	
	
	@Test
	public void tstRoyalFlush1() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("King", "Clubs"), new Card("Jack", "Clubs"), new Card("Ace", "Clubs"),
				new Card("10", "Clubs"), new Card("Queen", "Clubs")};
		Player p = new Player();
		p.setHand(hand);
		assertTrue("Royal Flush", tst.royalFlush(p));
	}
	
	@Test
	public void tstRoyalFlush2() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("10", "Clubs"), new Card("Jack", "Hearts"), new Card("Queen", "Clubs"),
				new Card("King", "Clubs"), new Card("Ace", "Clubs")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not enough matches", tst.royalFlush(p));
	}
	
	@Test
	public void tstRoyalFlush3() {
		Dealer tst = new Dealer();
		Card[] hand = {new Card("9", "Clubs"), new Card("10", "Clubs"), new Card("Jack", "Clubs"),
			new Card("Queen", "Clubs"), new Card("King", "Clubs")};
		Player p = new Player();
		p.setHand(hand);
		assertFalse("Not royal", tst.royalFlush(p));
	}
	
}
