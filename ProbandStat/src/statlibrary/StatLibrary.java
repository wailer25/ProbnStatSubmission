package statlibrary;

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
	
	//calculates factorial for equations that require it
	public double factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n*factorial(n - 1);
	}
	
	public double permutation(int n, int r) {
		double result = 0;
		
		result = factorial(n) / factorial(n - r);
		
		return result;
	}
	
	public double combination(int n, int r) {
		double result = 0;
		
		result = factorial(n) / (factorial(r) * factorial(n - r));
		
		return result;
	}
	
	
	//finds the standard deviation of given array
	public double sDeviation(int[] values) {
		double variance = variance(values);
		double sDeviation = Math.sqrt(variance);
		
		return sDeviation;
		
	}

}
