package poker;

public class Card {

	private String type;
	private String suite;
	
	public Card(String type, String suite) {
		this.type = type;
		this.suite = suite;
	}
	
	public int getRank() {
		
		int rank = 0;
		switch (type)
		{
			case "2":
				rank = 1;
				break;
			case "3":
				rank = 2;
				break;
			case "4":
				rank = 3;
				break;
			case "5":
				rank = 4;
				break;
			case "6":
				rank = 5;
				break;
			case "7":
				rank = 6;
				break;
			case "8":
				rank = 7;
				break;
			case "9":
				rank = 8;
				break;
			case "10":
				rank = 9;
				break;
			case "Jack":
				rank = 10;
				break;
			case "Queen":
				rank = 11;
				break;
			case "King":
				rank = 12;
				break;
			default:
				rank = 13;
		}
		
		return rank;
	}
	
	public String getType() {
		return type;
	}
	
	public String getSuite() {
		return suite;
	}
	
	@Override
	public String toString() {
		return type + " of " + suite;
	}
}
