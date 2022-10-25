package statlibrary;

import java.math.BigInteger;
public class StatLibrary {
	
	public StatLibrary() {
		
	}
	
	// finds the mean in a given array
	public double mean(int[] values) {
		double mean = 0;
		
		for (int i = 0; i < values.length; i++)
		{
			mean += values[i];
		}
		
		return mean/values.length;
	}
	
	//finds the median in a given array
	public double median(int[] values) {
		
		int median = values.length/2;
		double evenCheck = 0;
		
		//calculates the median when given an even length array
		if (values.length%2 == 0)
		{
			evenCheck = values[median];
			evenCheck += values[median - 1];
			return evenCheck/2;
		}
		return values[median];
	}
	
	//finds the mode in a given array (does not currently check for no mode)
	public int mode (int[] values) {
		int mode = 0;
		int maxHit = 0;
		
		for (int i = 0; i < values.length; i++)
		{
			int tmp = 0;
			
			/*iterates through array and increments tmp count
			 * whenever match is found for current value
			 */
			for (int j = 0; j < values.length; j++)
			{
				if(values[i] == values[j])
					tmp++;
			}
			
			/* changes max number of hits and sets current value
			 * as the new mode if current tmp count is higher than maxHit
			 */
			if (tmp > maxHit)
			{
				maxHit = tmp;
				mode = values[i];
			}

		}
		
		return mode;
	}
	
	//finds the variance of given array
	public double variance(int[] values) {
		double mean = mean(values);
		double variance = 0;
		double squares = 0;
		//used to convert values[] int to double
		double tmp1, tmp2 = 0;
				
		for (int i = 0; i < values.length; i++)
		{
			tmp2 = (double)values[i] - mean;
			tmp1 = Math.pow(tmp2, 2);
			squares += tmp1;
		}
		
		variance = squares/(values.length - 1);
		
		return variance;
	}
	
	
	//finds the standard deviation of given array
	public double sDeviation(int[] values) {
		double variance = variance(values);
		double sDeviation = Math.sqrt(variance);
		
		return sDeviation;
		
	}
	
	//calculates p(B|A) using Bayes Theorem
	public double bayesTheorem(double pA, double pB, double pAGB) {
		return (pAGB * pB) / pA;
	}
	
	//calculates factorial for equations that require it using BigInteger
	public BigInteger factorial(int n) {
		if (n == 0)
			return BigInteger.ONE;
		else
			return BigInteger.valueOf(n).multiply(factorial(n - 1));
	}
	
	//calculates permutation using BigInteger
	public BigInteger permutation(int n, int r) {
		BigInteger result;
		
		result = factorial(n).divide(factorial(n - r));
		
		return result;
	}
	
	//calculates combination using BigInteger
	public BigInteger combination(int n, int r) {
		BigInteger result;
		
		result = factorial(n).divide((factorial(r).multiply(factorial(n - r))));
		
		return result;
	}
	
	//uses user given input to calculate binomial distribution
	public double binomialDistribution(int trials, int successes, double passChance) {
		double result;
		result = combination(trials, successes).doubleValue() * Math.pow(passChance, successes)
				* Math.pow((1.0 - passChance), (trials - successes));
		
		return result;
	}
	
	//calculates E(Y) formula for binomial distribution
	public double bioExpected(int trials, double passChance) {
		return trials * passChance;
	}
	
	//calculates V(Y) formula for binomial distribution
	public double bioVariance(int trials, double passChance) {
		return trials * passChance * (1 - passChance);
	}
	
	// calculates standard deviation for binomial distribution
	public double bioSD(int trials, double passChance) {
		return Math.sqrt(bioVariance(trials, passChance));
	}
	
	//calculates geometric distibution
	public double geometricDistribution(int trials, double passChance) {
		double result;
		result = Math.pow((1 - passChance), (trials - 1)) * passChance;
		
		return result;
	}
	
	// calculates E(Y) formula for geometric distribution
	public double geoExpected(double passChance) {
		return 1 / passChance;
	}
	
	//calculates V(Y) formula for geometric distribution
	public double geoVariance(double passChance) {
		return (1 - passChance) / Math.pow(passChance, 2);
	}
	
	//calculates standard deviation for geometric distribution
	public double geoSD(double passChance) {
		return Math.sqrt(geoVariance(passChance));
	}
	
	//calculates hypergeometric distribution in situations where permutation formula is needed
	public double hypergeometricDistributionP(int population, int selected, int target, int available) {
		double result;
		result = (permutation(available, target).doubleValue() * permutation((population - available), (selected - target)).doubleValue())
				/ permutation(population, selected).doubleValue();
		
		return result;
	}
	
	//calculates hypergeometric distribution in situations where combination formula is needed
	public double hypergeometricDistributionC(int population, int selected, int target, int available) {
		double result;
		result = (combination(available, target).doubleValue() * combination((population - available), (selected - target)).doubleValue())
				/ combination(population, selected).doubleValue();
		
		return result;
	}
	
	// calculates E(Y) for hypergeometric distribution
	public double hyperExpected(int population, int selected, int available) {
		double result;
		result = (selected * available) / population;
		
		return result;
	}
	
	//calculates V(Y) for hypergeometric distribution
	public double hyperVariance(int population, int selected, int available) {
		double result;
		result = selected * (available / population) * ((population - available) / population)
				* ((population - selected) / (population - 1));
		
		return result;
	}
	
	//calculates V(Y) for hypergeometric distribution
	public double hyperSD(int population, int selected, int available) {
		return Math.sqrt(hyperVariance(population, selected, available));
	}

	//calculates poisson distribution
	public double poissonDistribution(int events, double units, int y) {
		
		double lambda = (double)events / units;
		double result;
		result = (Math.pow(lambda, y) / factorial(y).doubleValue()) * Math.pow(2.718, -lambda);
		
		return result;
	}
	
	//calculates both E(Y) and V(Y) for poisson distribution since E(Y) = V(Y)
	public double poissonEV(int events, double units) {
		return (double)events / units;
	}
	
	//calculates Standard deviation for poisson distribution
	public double poissonSD(int events, double units) {
		return Math.sqrt(poissonEV(events, units));
	}
	
	public double chebyshevTheorem(int gap, double sd) {
		double k = gap / sd;
		double result;
		result = 1 - (1 / Math.pow(k, 2));
		
		return result;
	}

}
