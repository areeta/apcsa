public class PastHopefuls implements Comparable<PastHopefuls> {
	
	private int year;
	private String firstName;
	private String lastName;
		
	public PastHopefuls(String lastName, String firstName, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
	}
	
	public String toString() {
		return this.year + " " + this.firstName + " " + this.lastName;
	}
	
	public int getYear() {
		return this.year;
	}

	@Override
	public int compareTo(PastHopefuls obj) {
		if (obj.getYear() > this.getYear()) { //if object passed in is larger, return negative
			return -1;
		} else if (obj.getYear() < this.getYear()) { //if object passed in is smaller, return positive
			return 1;
		} else {
			return 0;
		}
	}

}
