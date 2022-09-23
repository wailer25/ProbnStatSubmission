package statlibrary;

public class StatLibraryRun {
	public static void main(String[] args) {
		
		StatLibrary tst = new StatLibrary();
		
		int[] check = {1, 2, 3, 4, 5, 6};
		
		System.out.println(tst.variance(check));
		
		System.out.println(tst.permutation(50, 3));
		System.out.println(tst.combination(50, 3));
	}

}
