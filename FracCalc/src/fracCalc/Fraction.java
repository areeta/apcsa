package fracCalc;

public class Fraction {

	private int numeratorNum;
	private int denominatorNum;
	private int wholeNum = 0;
	
	public Fraction(String frac) {
		
		int slash = frac.indexOf("/");
		int underscore = frac.indexOf("_");
		
		if (slash>0 && underscore>0) {
			String[] arr2 = frac.split("_");

			// DEALING WITH WHOLE NUMBER
			int wholeNum = Integer.parseInt(arr2[0]);
			
			// DEALING WITH FRACTION
			String fraction = arr2[1];
			String[] arr3 = fraction.split("/");
			
			int numeratorNum = Integer.parseInt(arr3[0]);
			int denominatorNum = Integer.parseInt(arr3[1]);
			
			//MAKING MIXED NUMERATOR 
			if (numeratorNum<0 && wholeNum<0) {
				this.numeratorNum = (denominatorNum * wholeNum) - numeratorNum;
			} else if(numeratorNum<0 && wholeNum>0) {
				this.numeratorNum = (denominatorNum * wholeNum) - numeratorNum;
			} else if(numeratorNum>0 && wholeNum<0) { 
				this.numeratorNum = (denominatorNum * wholeNum) - numeratorNum;
			} else if(numeratorNum>0 && wholeNum>0) {
				this.numeratorNum = (denominatorNum * wholeNum) + numeratorNum;
			}
			
			//MAKING MIXED DENOMINATOR
			this.denominatorNum = denominatorNum;
			
		} else if(frac.contains("/"))  {
			
			String[] arr4 = frac.split("/");
			
			this.numeratorNum = Integer.parseInt(arr4[0]);
			this.denominatorNum = Integer.parseInt(arr4[1]);			
			
		} else {
			
			int answer = Integer.parseInt(frac);
			
			this.numeratorNum = answer;
			this.denominatorNum = 1;
		}
	}
		
	//Add Method
	public Fraction add(Fraction other) {
		
		int origDemo = this.denominatorNum;		
		
		this.numeratorNum *= other.denominatorNum;
		this.denominatorNum *= other.denominatorNum;
		other.numeratorNum *= origDemo;
		other.denominatorNum *= origDemo;
		
		int addedNum = this.numeratorNum + other.numeratorNum;
		String answer = addedNum + "/" + other.denominatorNum;
		Fraction outcome = new Fraction(answer);
		return outcome;
	}
		
	//Subtract Method
	public Fraction subtract(Fraction other) {
		
		int origDemo = this.denominatorNum;		
	
		this.numeratorNum *= other.denominatorNum;
		this.denominatorNum *= other.denominatorNum;
		other.numeratorNum *= origDemo;
		other.denominatorNum *= origDemo;
		
		int subtractedNum = this.numeratorNum - other.numeratorNum;
		
		String answer = subtractedNum + "/" + other.denominatorNum;
		Fraction outcome = new Fraction(answer);
		return outcome;
	}
		
	//Multiply Method
	public Fraction multiply(Fraction other) {
		
		this.numeratorNum *= other.numeratorNum;
		this.denominatorNum *= other.denominatorNum;
		
		String answer = this.numeratorNum + "/" + this.denominatorNum;
		
		if (this.numeratorNum == 0 || this.denominatorNum == 0) {
			Fraction ans = new Fraction("0");
		}
		
		Fraction outcome = new Fraction(answer);
		return outcome;
	}
		
	//Divide Method
	public Fraction divide(Fraction other) {
		
		System.out.println(this.numeratorNum);
		System.out.println(this.denominatorNum);

		System.out.println(other.numeratorNum);
		System.out.println(other.denominatorNum);
		
		int a = this.numeratorNum * other.denominatorNum;
		int b = this.denominatorNum * other.numeratorNum;
		
		String answer = a + "/" + b;
		Fraction outcome = new Fraction(answer);
		return outcome;
	}
	
	//Print String easier method
	public String toString() {
				
		//change something like 11 / 6  (stored in your 2 fields) into 1_5/6  (using math)
	    //return "whole: 1, numerator: 5, denominator: 6"  (to pass checkpoint 2 tests)
		this.wholeNum = this.numeratorNum / this.denominatorNum;
		int numerNum = (this.numeratorNum % this.denominatorNum);
		int origNumer = numerNum;
		int origDenom = this.denominatorNum;
		
		if (numerNum < 0) { 
			numerNum = numerNum * (-1);
		}
		if (this.denominatorNum < 0) {
			this.denominatorNum = this.denominatorNum * (-1);
		}
				
		int greatestCommon = gcf(numerNum, this.denominatorNum);
		
		numerNum = numerNum / greatestCommon;
		this.denominatorNum = this.denominatorNum / greatestCommon;
		
		if (wholeNum == 0) {
			if (numerNum == 0) {
				return 0 + "";
			}
			if (origNumer < 0 || origDenom < 0) {
				return "-" + numerNum + "/" + this.denominatorNum;
			}
			return numerNum + "/" + this.denominatorNum;
		} else if (numerNum == 0 && (this.denominatorNum == 1 || this.denominatorNum == -1)) {
			return this.wholeNum + "";
		} else if (wholeNum != 0 && numerNum == 0) {
			return wholeNum + "";
		} else if(numerNum != 0 && this.denominatorNum == 0) {
			System.out.println("Error: Can not divide by zero");
		}
			
		return this.wholeNum + "_" + numerNum + "/" + this.denominatorNum;
	}
	
	//GCF Method
	public static int gcf(int num1, int num2) {
		int answer = 1;
		int count = 1;
		while (count <= min(num1, num2)) {
			if (isDivisibleBy(num1, count) && isDivisibleBy(num2, count)){
				answer = count;
				count += 1;
			} else {
				count += 1;		
			}
		}
		return answer;
	}
	
	//Min Method
	public static int min(int a, int b) {
		if (a < b) {
			return a;
		} else { 
			return b;
		}
	}
	
	//Is Divisble By
	public static boolean isDivisibleBy(int a, int b) {
		
		// pre: a and b >= 0
		// post: returns exponent
		if ( (a < 0) || (b < 0) ) {
			throw new IllegalArgumentException("negative number: " + a + " or " + b);
		}
		boolean answer = true;
		if ((a%b) == 0) {
			answer = true;
		} else {
			answer = false;
		}
		return answer;
	}
	
}
