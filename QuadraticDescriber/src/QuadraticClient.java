import java.util.Scanner;
public class QuadraticClient {

	public static void main(String[] args) {
 
//      QuadraticClient will contain a main method and handle interactions with the 
//		user (taking input values, for example).  It will call the method quadrDescriber 
//		with the appropriate arguments.  However, it will not call any other mathematical 
//		methods. 
			boolean run = true;
			Scanner console = new Scanner(System.in);
			
			System.out.println("Welcome to Areeta's Quadratic Describer");
			
		while (run) {

			System.out.println("Provide values for coefficicent a, b, and c");
			
			System.out.println();
			
			System.out.print("a: ");
			String inputA = console.nextLine();
			double a = Double.parseDouble(inputA);
			
			System.out.print("b: ");
			String inputB = console.nextLine();
			double b = Double.parseDouble(inputB);
			
			System.out.print("c: ");
			String inputC = console.nextLine();
			double c = Double.parseDouble(inputC);
			
			System.out.println();
			
			Quadratic.quadrDescriber(a, b, c);
			
			System.out.println();

			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String keepGoing = console.nextLine();
			
			if (keepGoing.equals("quit")) {
				run = false;
			}
			
			System.out.println();

		}
	}
}
