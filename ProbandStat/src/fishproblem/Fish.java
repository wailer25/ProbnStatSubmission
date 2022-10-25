package fishproblem;

import java.util.Random;
public class Fish extends Seafood{
	
	private Random rng;
	
	// fish seafood type with high weight range and low price per pound
	public Fish() {
		rng = new Random();
		this.setWeight(rng.nextDouble(4, 33));
		this.setType("Fish");
		this.generatePrice(1.58);
	}
	
	// fish seafood type with user chosen price and weight
	public Fish(double weight, double price) {
		this.setWeight(weight);
		this.setType("Fish");
		this.setPrice(price);
	}

}
