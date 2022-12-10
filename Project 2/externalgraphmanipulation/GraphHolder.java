package externalgraphmanipulation;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFrame;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.plot.SeriesRenderingOrder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.SamplingXYLineRenderer;


public class GraphHolder {

	private XYSeriesCollection graphs = new XYSeriesCollection();
	private JFreeChart jf;	
	
	public void addSeries(XYSeries data) {
		graphs.addSeries(data);
	}
	
	public void displayChart(String title) {
		configureChart(title);
		ChartFrame frame = new ChartFrame("XY Line Chart", jf);

		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	public void configureChart(String title) {
		jf = ChartFactory.createXYLineChart(title, "X", "Y", graphs);
		SamplingXYLineRenderer xy = new SamplingXYLineRenderer();
		
		for (int i = 0; i < graphs.getSeriesCount(); i++)
			xy.setSeriesStroke(i, new BasicStroke(2.5f));
			

		xy.setLegendTextPaint(0, Color.RED);
		xy.setLegendTextPaint(1, Color.BLUE);
		xy.setLegendTextPaint(2, Color.CYAN);
		xy.setSeriesPaint(2, Color.CYAN);
		xy.setSeriesStroke(2, new BasicStroke(3.0f));
		XYPlot plot = jf.getXYPlot();
		plot.setRenderer(xy);
		plot.setSeriesRenderingOrder(SeriesRenderingOrder.FORWARD);
	}
}
