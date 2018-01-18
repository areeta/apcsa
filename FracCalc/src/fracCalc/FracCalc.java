package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	
    	boolean run = true;
    		while (run) {
    			try {
	    			Scanner console = new Scanner(System.in);
	    			System.out.println("What something that you want to calculate?");
	    			String input = console.nextLine();
	    		
	    			if (input.equals("quit")) {
	    				run = false;
	    			} else {
	    				System.out.println(produceAnswer(input));
	    			}
    			}
    			catch(Exception e) {
    				System.out.println("ERROR: Invalid format!");
    			}
    	}
    }
    
    public static String produceAnswer(String input) {
    	
    	String[] arr = input.split(" ");
    	int len = arr.length;
    	Fraction answer = new Fraction("-9999999");
    	
    	if (len == 1) {
    		answer = new Fraction(arr[0]);
    	} else if (len == 3) { 	    	    	
	    	String operator = arr[1]; 	
	    	Fraction frac1 = new Fraction(arr[0]);
			Fraction frac2 = new Fraction(arr[2]);
				
			if (operator.equals("+")) {
				answer = frac1.add(frac2);
			} else if(operator.equals("-")) {
				answer = frac1.subtract(frac2);
			} else if(operator.equals("*")) {
				answer = frac1.multiply(frac2);
			} else if(operator.equals("/")) {
				answer = frac1.divide(frac2);
			}
    	} else if (len > 3) { 
    		
    		for (int i = 0; i < len-1; i+=2) {
    			String operator = arr[i+1];	
    			Fraction frac1 = new Fraction(arr[i]);
    			Fraction frac2 = new Fraction(arr[i+2]);

    			if (operator.equals("+")) {
    				frac1.add(frac2);
    				answer = frac1;
    				
    				System.out.println(answer.toString());
    				
    			} else if(operator.equals("-")) {
    				frac1.subtract(frac2);
    				answer = frac1;
    				
    				System.out.println(answer.toString());

    				
    			} else if(operator.equals("*")) {
    				frac1.multiply(frac2);
    				answer = frac1;
    			} else if(operator.equals("/")) {
    				frac1.divide(frac2);
    				answer = frac1;
    			}
    		}
    	} 
    	return answer.toString();
    }	
}
