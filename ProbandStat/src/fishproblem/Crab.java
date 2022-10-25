package fishproblem;

import java.util.Random;
public class Crab extends Seafood{
	
	private Random rng;
	
	//crab seafood type with average weight range and average price per pound
	public Crab() {
		rng = new Random();
		this.setType("Crab");
		this.setWeight(rng.nextDouble(2, 9));
		this.generatePrice(5.23);
	}
	
	//crab seafood type with user chosen price and weight
	public Crab(double weight, double price) {
		this.setWeight(weight);
		this.setType("Crab");
		this.setPrice(price);
	}

}
