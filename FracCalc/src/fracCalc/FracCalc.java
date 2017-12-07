package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	
    	//Checkpoint 2
    	boolean run = true;
    		while (run) {
    			try {
	    			//Checkpoint 1
	    			Scanner console = new Scanner(System.in);
	    			System.out.println("What something that you want to calculate?");
	    			String input = console.nextLine();
	    		
	    			//Checkpoint 2
	    			if (input.equals("quit")) {
	    				run = false;
	    			} else {
	    				System.out.println(produceAnswer(input));
	    			}
    			}
    			catch(Exception e) {
    				System.out.println("ERROR:");
    			}
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input) {
		
		//Checkpoint 3
//		•	produceAnswer must now evaluate the formula it is given (performing addition, subtraction, multiplication,
//			and division, based on the operator specified), and return the actual answer of that calculation (instead 
// 			of just returning the second operand). 
//		•	The answer need not be reduced, and need not be a mixed fraction.  But it must be correct.
//		•	All kinds of input values the user might enter must be accepted, including simple fractions, improper 
//  		fractions, mixed fractions, and integers.
    	
    	String[] arr = input.split(" ");
    	
    	Fraction answer = new Fraction("-9999999");
    	
    	if (arr.length == 1) {
    		answer = new Fraction(arr[0]);
    	} else { 
	    	String ans1 = arr[0];
	    	String ans2 = arr[2];
	    	    	
	    	String operator = arr[1]; 	
	    	
	    	Fraction frac1 = new Fraction(ans1);
			Fraction frac2 = new Fraction(ans2);
	
	    	// GIANT IF STATEMENT
			
			if (operator.equals("+")) {
				answer = frac1.add(frac2);
			} else if(operator.equals("-")) {
				answer = frac1.subtract(frac2);
			} else if(operator.equals("*")) {
				answer = frac1.multiply(frac2);
			} else if(operator.equals("/")) {
				answer = frac1.divide(frac2);
			}
    	}
    	return answer.toString();
    }	
    
    //    public static String commonDenominator()

    // TODO: Fill in the space below with any helper methods that you think you will need

}