package externalgraphmanipulation;





import org.jfree.data.xy.XYSeries;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
public class ExternalGraphManipulator {


	public XYSeries nLogN(double x, int range) {
		XYSeries nLogN = new XYSeries("nLogN");
		double y = 0;
		double tmp = x;
		
		for (int i = 0; i <= range; i++)
		{
			y = x* Math.log10(x);
			nLogN.add(x, y);
			x += tmp;
		}
		
		return nLogN;
	}
	
	
	public XYSeries salter(XYSeries data, int saltBounds) {
		RandomDataGenerator rng = new RandomDataGenerator();
		XYSeries dataSalt = new XYSeries("salt");
		
		for (int i = 0; i < data.indexOf(data.getMaxX()); i++)
		{
			
			double x = (double)data.getX(i);
			double y = (double)data.getY(i);
			
			int operand = rng.nextInt(0, 1);
			
			//saltBounds upper limit is inclusive 
			int salt = rng.nextInt(0, saltBounds);
			
			if (operand == 0)
				y -= salt;
			else
				y += salt;
			
			dataSalt.add(x, y);
		}
		
		return dataSalt;
	}
	
	public XYSeries smoother(XYSeries saltData, int range) {
		Mean avgX = new Mean();
		Mean avgY = new Mean();
		XYSeries smooth = new XYSeries("smoove");
		
		int j = 0;

		for (int i = 0; i < saltData.indexOf(saltData.getMaxX()); i++)
		{
			
			double x = (double)saltData.getX(i);
			double y = (double)saltData.getY(i);
			
			if (j == (range * 2 + 1))
			{

				smooth.add(avgX.getResult(), avgY.getResult());
				avgX.clear();
				avgY.clear();
				j = 0;
			}
			avgX.increment(x);
			avgY.increment(y);
			j++;
			
		}
		
		return smooth;
	}
	
	public void runGraphs(int x, int size, int saltBounds, int smoothBounds) {
		XYSeries tmp = new XYSeries("bruh");

		GraphHolder dip = new GraphHolder();
		tmp = nLogN(x, size);
		XYSeries tmp2 = salter(tmp, saltBounds);
		dip.addSeries(tmp);
		dip.addSeries(tmp2);
		dip.addSeries(smoother(tmp2, smoothBounds));
		
		dip.displayChart("NLogN");
	}
}
