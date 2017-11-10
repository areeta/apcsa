package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	//Checkpoint 2
    	boolean run = true;
    	while (run) {
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
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
    	//Checkpoint 1
//    	String[] arr = input.split(" ");
//        return arr[arr.length-1];
        
        //Checkpoint 2
    	int wholeNum = 0;
    	int numeratorNum = 0;
    	int denominatorNum = 0;
    	
    	String[] arr = input.split(" ");
    	String ans = arr[arr.length-1];
    	
    	int slash = ans.indexOf("/");
    	int underscore = ans.indexOf("_");
    	
    	if (slash>0 && underscore>0) {
    		
    		String[] arr2 = ans.split("_");
    		wholeNum = Integer.parseInt(arr2[0]);
    		
    		String frac = arr2[1];
    		String[] arr3 = frac.split("/");
    		
    		numeratorNum = Integer.parseInt(arr3[0]);
    		denominatorNum = Integer.parseInt(arr3[1]);
    		    		
    	} else if(slash>0)  {
    		
    		String[] arr4 = ans.split("/");
    		
    		numeratorNum = Integer.parseInt(arr4[0]);
    		denominatorNum = Integer.parseInt(arr4[1]);
    		
    	} else {
    		
    		wholeNum = Integer.parseInt(ans);
    		denominatorNum = 1;
    		
    	}
        return "whole:" + wholeNum + " numerator:" + numeratorNum + " denominator:" + denominatorNum;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
}
