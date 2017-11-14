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
			
			//MAKING AN IMPROPER FRACTION
			this.numeratorNum = (denominatorNum * wholeNum) + numeratorNum;
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
	
	//Print String easier method
		public String toString() {
			
			//change something like 11 / 6  (stored in your 2 fields) into 1_5/6  (using math)
            //return "whole: 1, numerator: 5, denominator: 6"  (to pass checkpoint 2 tests)
			this.wholeNum = this.numeratorNum / this.denominatorNum;
		    int numerNum = (this.numeratorNum % this.denominatorNum);
			
			return "whole:" + this.wholeNum + " numerator:" + numerNum + " denominator:" + this.denominatorNum;
		}
}
