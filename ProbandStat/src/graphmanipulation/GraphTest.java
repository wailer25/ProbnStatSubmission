package graphmanipulation;

public class GraphTest {
	public static void main(String[] args) throws Exception {
		
		GraphManipulator tst = new GraphManipulator();

		tst.nLogNGraph("gtst", 2.2, 100);
		tst.salter("gtst", 20);
		tst.smoother("saltedgtst", 2);
	}

}
