package birthdayproblem;

import java.util.ArrayList;
import statlibrary.StatLibrary;
import java.text.DecimalFormat;

public class Classroom {
	private ArrayList<Person> people;
	private ArrayList<Person> dupes;
	
	public Classroom() {
		people = new ArrayList<>();
		dupes = new ArrayList<>();
	}
	
	// method used to populate arraylist with person objects based upon user chosen size
	public void populateClass(int size) {
		for (int i = 0; i < size; i++)
			people.add(new Person());
	}
	
	
	public int getMatches() {
		//int used to store the number of matching birthdays and later return them
		int hit = 0;
		
		//makes a copy of the group size by adding all person objects to another arraylist
		ArrayList<Person> tmp = new ArrayList<>();
		for (Person p: people)
			tmp.add(p);
		
		/*uses a nested for loop to compare the birthdays in each position
		  increments hit whenever a match is found and stores the matching birthday
		  to be recalled later */
		for (int i = 0; i < tmp.size(); i++)
		{
			for (int j = 0; j < tmp.size(); j++)
			{
				if (j != i)
				{
					if (tmp.get(i).equals(tmp.get(j)))
					{
						hit++;
						//requires overloaded equals method to resolve as expected
						if(!dupes.contains(tmp.get(j)))
							dupes.add(tmp.remove(j));
					}
				}
			}
		}
		return hit;
	}
	
	//uses permutation from the StatLibrary to calculate the birthday problem
	// 1 - (nPr/n^r)
	public double checkProbability() {
		StatLibrary stats = new StatLibrary();
		DecimalFormat fm = new DecimalFormat("#.00##");
		double result = 1;
		double x = stats.permutation(365, people.size()).doubleValue();
		double y = Math.pow(365, people.size());
		
		result -= x/y;
		result = Double.parseDouble(fm.format(result));
		return result;
	}
	
	//calculates percentage of matching birthdays
	public double calculateMatches() {
		DecimalFormat fm = new DecimalFormat("#.00##");
		double result = (double)getMatches() / (double)people.size();
		
		result = Double.parseDouble(fm.format(result));
		return result;
	}
	
	//returns the birth month and day in a more traditional format
	public String birthdayFormat(Person p) {
		return p.getBirthMonth() + "/" + p.getBirthDay();
	}
	
	//prints the chance of finding a match as well as all birthdays within the people arraylist
	public void printBirth() {
		System.out.println("Probability of finding a match: " + checkProbability());
		for (Person p: people)
			System.out.println(birthdayFormat(p));
		
	}
	
	//prints the number of matches found, percentage of matching birthdays
	//as well as all matching dates (without duplicates)
	public void printMatches() {
		System.out.println("Number of matching pairs: " + getMatches());
		System.out.println("Percentage of matching birthdays: " + calculateMatches());
		for (Person p: dupes)
			System.out.println(birthdayFormat(p));
		
	}

}
