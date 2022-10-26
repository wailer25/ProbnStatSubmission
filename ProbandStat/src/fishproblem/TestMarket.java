package fishproblem;

public class TestMarket {
	public static void main(String[] args) throws Exception{
		FishMarket tst = new FishMarket();
		
		//tst.csvToArray("Test");
		tst.generateMarket(300);
		tst.printMarket();
		tst.toCSV("Test");
	}	
}
