import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeBook {

	public static void main(String[] args) throws FileNotFoundException{

		File f = new File("gradebook.txt");
		boolean doesExist = f.exists();
		boolean hasNextLine = true;

		Scanner input_file = new Scanner(f);
		
		while (hasNextLine) {
			String name = input_file.nextLine();
			
			if (input_file.hasNextLine() == false) {
				break;
			}
		
			String hw = input_file.nextLine();
			String amountOfHW = input_file.nextLine();
		
			// HW GRADES
			double yourHWScore = 0;
			String hwScore = "";
			String hwTotal = "";


			for (int i = 0; i < Integer.parseInt(amountOfHW); i++)
			{
				hwScore = input_file.nextLine();
				hwTotal = input_file.nextLine();
		
				yourHWScore += Double.parseDouble(hwScore) / Double.parseDouble(hwTotal);
			}
			
			yourHWScore = yourHWScore / Integer.parseInt(amountOfHW);
		
			// MIDTERM SCORE
			String midtermScoress = input_file.nextLine();
			String midtermScore = input_file.nextLine();
			String midtermTotal = input_file.nextLine();
		
			double yourMidtermScore = (Double.parseDouble(midtermScore) / Double.parseDouble(midtermTotal));
		
			// FINAL SCORE
			String finalsScoress = input_file.nextLine();
			String finalScore = input_file.nextLine();
			String finalTotal = input_file.nextLine();
		
			double yourFinalScore = (Double.parseDouble(finalScore) / Double.parseDouble(finalTotal));

			// GRADE
		
			double grade = ((.5 * yourHWScore) + (.2 * yourMidtermScore) + (.3 * yourFinalScore)) * 100;
				
			if (grade >= 90.0) {
				System.out.println(name + ": " + round2(grade) + "% A");
			} else if (grade >= 80.0) {
				System.out.println(name + ": " + round2(grade) + "% B");
			} else if (grade >= 70.0) {
				System.out.println(name + ": " + round2(grade) + "% C");
			} else if (grade >= 60.0) {
				System.out.println(name + ": " + round2(grade) + "% D");
			} else {
				System.out.println(name + ": " + round2(grade) + "% F");
			}
		
			System.out.println("\t HW %: " + (round2(yourHWScore*100)));
			System.out.println("\t Midterm %: " + (round2(yourMidtermScore*100)));
			System.out.println("\t Final %: " + (round2(yourFinalScore*100)));
			
		}

		input_file.close();
	}
	
	public static double round2(double x)
	{	
		double x_hundred = x*100; 
		double hundredth = x_hundred % 1; 
		double rounded_hundred = (x_hundred - hundredth); 
			
		if (hundredth >= 0.5){               //rounds up if needed
			rounded_hundred += 1;
		} else if (hundredth <= -0.5) {
			rounded_hundred -= 1;
		}	
		
		double rounded = rounded_hundred/100;  // rounded to 2 decimal places
		return rounded;
	}
	
}
