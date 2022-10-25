package fishproblem;

public class Seafood {
	//seafood superclass with getters and setters for weight price and type
	// with the intention of being inherited by specific seafood
	
	private double weightLbs;
	private double price;
	private String type;
	
	public Seafood() {

	}
	
	public double getWeight() {
		return weightLbs;
	}
	
	public void setWeight(double input) {
		weightLbs = input;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String input) {
		type = input;
	}
	
	//generates price using price per pound
	public void generatePrice(double ppp) {
		price = weightLbs*ppp;
	}
	
	public void setPrice(double input) {
		price = input;
	}
	
	public double getPrice() {
		return price;
	}
	

}
