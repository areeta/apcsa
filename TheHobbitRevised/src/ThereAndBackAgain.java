import java.util.ArrayList;

public class ThereAndBackAgain 
{

	public static void main(String[] args) {
		
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		
		// Create a traveling party called party1 by creating an array of Travelers 
		// and filling it with frodo, sam, and gimli
		
		Traveler[] party1 = {frodo, sam, gimli};
		
		// Then, use a loop to make all travelers go a distance of 50 miles 
		
		for (int traveler = 0; traveler < party1.length; traveler++) {
			party1[traveler].travel(50);
		}
		
		// Then, for each Traveler in the travelingParty, print their name and how far they've
		// traveled in miles.  (In the next piece, you'll do this in methods, but 
		// for a first pass, just do it in main and print to the console.)
		// Expected output:  Frodo has traveled 50 miles.
		//                   Sam has traveled 50 miles.
		//                   Gimli has traveled 50 miles.
		
		for (int traveler = 0; traveler < party1.length; traveler++) {
			System.out.println(party1[traveler].getName() + " has traveled " + party1[traveler].getDistanceTraveled() + " miles.");
		}
	
		System.out.println();
		System.out.println("\n\n\nPART 2:  \n");

		String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin", 
				               "Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin"};

		// Make a new ArrayList to hold a 2nd party of Travelers called party2:
		
		ArrayList<Traveler> party2 = new ArrayList<>();
		
		// Call the createParty method and pass it party2 and the dwarfNames array.
		
		createParty(party2, dwarfNames);
		
		// Finally, call the allTravel method passing it party2 and 100 (representing
		// the 100 miles that party2 has traveled together.  
		
		allTravel(party2, 100);

	}
	
	// The createParty method accepts an ArrayList of Travelers and a String[] of 
	// dwarf names. This method will always add a new Hobbit named "Bilbo" and a      
	// new Wizard named "Gandalf" whose color is "Grey" to the ArrayList.
	// Then it uses a loop to add all the dwarves from the String array to the party.
	public static void createParty(ArrayList<Traveler> party, String[] dwarfNames) {	
		
		Traveler bilbo = new Hobbit("Bilbo");
		Traveler gandalf = new Wizard("Gandalf", "Grey");
		
		party.add(bilbo);
		party.add(gandalf);
		
		for (int i = 0; i < dwarfNames.length; i++) {
			Traveler ppl = new Dwarf(dwarfNames[i]);
			party.add(ppl);
		}
		
	}
	
	// The allTravel method accepts an ArrayList of Travelers and an integer number 
	// of miles to travel, then builds and returns a String reporting how far each 
	// member of party has gone. builds a String that says how far each member of the 
	// party has traveled.
	//Ex.  Bilbo has traveled 100 miles
	//     Gandalf the grey has traveled 300 miles
	//     fili has traveled 100 miles
	//     kili has traveled 100 miles
	public static String allTravel(ArrayList<Traveler> party, int miles) {
		
		String answer = "";
		
		for (int traveler = 0; traveler < party.size(); traveler++) {
			party.get(traveler).travel(miles);
			answer += (party.get(traveler).getName() + " has traveled " + party.get(traveler).getDistanceTraveled() + " miles." + "\n");
		}
		
		System.out.println(answer);
			
		return answer;
	}
}
