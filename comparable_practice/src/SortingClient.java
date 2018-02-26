/* The goal of this lab is for you to get some exposure to an interface that's used 
 * all the time: Comparable.  Java's Arrays class has a sort method that will work 
 * on any array so long as each object inside the array can be compared to any other 
 * object and be identified as coming before or after (or being the same).     
 * 
 * This client sets up an array of "past hopefuls" each comprised of a first name, 
 * last name, and year.  All you need to do is sort the array by year.  Easy.  ;)  
 * The final output should look something like this:
 * 1936 Al Landon
 * 1940 Wendall Wilkie
 * 1948 Thomas Dewey
 * 1956 Adlai Stevenson...
 * 
 * Create a new class called PastHopefuls that implements the Comparable interface. 
 * (Java already knows about Comparable - you do NOT need to make this interface or
 * add it to your project.)  For reference, Comparable looks like this:
 * 
 *    public interface Comparable<ObjectType>
 *    {
 *    	  public int compareTo(ObjectType varName)
 *    }
 *  
 *  You do NOT need to change any code in this client.  You will work entirely in your
 *  PastHopefuls class.  Look online to find the details about what goes into the 
 *  compareTo method.  One final note, when you implement Comparable, you don't just 
 *  write:
 *    public class ClassName implements Comparable
 *  You need to include the type of the objects that you'll be comparing.  For example:
 *    public class ClassName implements Comparable<Student>
 */

import java.util.Arrays;

public class SortingClient {

	public static void main(String[] args) {
		
		PastHopefuls[] hopefuls = { new PastHopefuls("Landon", "Al", 1936), 
							   		new PastHopefuls("Wilkie", "Wendall", 1940),
							   		new PastHopefuls("Mondale", "Walter", 1984),
							   		new PastHopefuls("Humphrey", "Hubert", 1968),
							   		new PastHopefuls("Goldwater", "Barry", 1964),
							   		new PastHopefuls("Kerry", "John", 2004),
							   		new PastHopefuls("McGovern", "George", 1972),
							   		new PastHopefuls("Stevenson", "Adlai", 1956),
							   		new PastHopefuls("Dewey", "Thomas", 1948),
							   		new PastHopefuls("Gore", "Al", 2000),
							   		new PastHopefuls("Dole", "Bob", 1996),
							   		new PastHopefuls("Dukakis", "Michael", 1988)
								};
		
		Arrays.sort(hopefuls);
		
		for (PastHopefuls h: hopefuls)
			System.out.println(h);
	}

}
