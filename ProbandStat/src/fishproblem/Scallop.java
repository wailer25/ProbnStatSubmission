package fishproblem;

import java.util.Random;
public class Scallop extends Seafood{
	
	Random rng;
	
	//scallop seafood bag with low weight range and high price per pound
	public Scallop() {
		rng = new Random();
		this.setType("Scallop");
		this.setWeight(rng.nextDouble(1, 5));
		this.generatePrice(9.49);
	}
	
	//scallop seafood bag with user chosen weight and price
	public Scallop(double weight, double price) {
		this.setWeight(weight);
		this.setType("Scallop");
		this.setPrice(price);
	}

}
