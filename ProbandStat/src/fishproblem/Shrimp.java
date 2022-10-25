package fishproblem;

import java.util.Random;
public class Shrimp extends Seafood{
	
	Random rng;
	
	//shrimp seafood bag with low weight range and high price per pound
	public Shrimp() {
		rng = new Random();
		this.setType("Shrimp");
		this.setWeight(rng.nextDouble(1, 5));
		this.generatePrice(13);
	}
	
	//shrimp seafood bag with user chosen weight and price
	public Shrimp(double weight, double price) {
		this.setWeight(weight);
		this.setType("Shrimp");
		this.setPrice(price);
	}

}
