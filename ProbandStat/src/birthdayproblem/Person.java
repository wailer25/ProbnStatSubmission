package birthdayproblem;

import java.util.Random;
public class Person {
	private int birthDay;
	private int birthMonth;
	private Random rng;
	
	public Person() {
		rng = new Random();
		birthMonth = rng.nextInt(1, 13);
		
		if (birthMonth == 2)
			birthDay = rng.nextInt(1, 29);
		else if (birthMonth == 4 || birthMonth == 6
				|| birthMonth == 9 || birthMonth == 11)
		{
			birthDay = rng.nextInt(1, 31);
		}
		else
			birthDay = rng.nextInt(1, 32);
	}
	
	public int getBirthMonth() {
		return birthMonth;
	}
	
	public int getBirthDay() {
		return birthDay;
	}
	
}
