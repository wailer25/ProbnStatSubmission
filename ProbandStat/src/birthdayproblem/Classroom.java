package birthdayproblem;

import java.util.ArrayList;
public class Classroom {
	private ArrayList<Person> people;
	
	public Classroom() {
		people = new ArrayList<>();
	}
	
	public void populateClass(int size) {
		for (int i = 0; i < size; i++)
			people.add(new Person());
	}
	
	public void printBirth() {
		for (Person p: people)
			System.out.println(p.getBirthMonth() + "/" + p.getBirthDay());
	}

}
