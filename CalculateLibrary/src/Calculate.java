public class Calculate 
{
	public static int square(int x) 
	{
		int answer = (x*x);
		return answer;
	}
	
	public static int cube(int x) 
	{
		int answer = (x*x*x);
		return answer;
	}
	
	public static double average(double x, double y) 
	{
		double answer = ((x+x)/2);
		return answer;
	}
	
	public static double average(double x, double y, double z) 
	{
		double answer = ((x+y+z)/3);
		return answer;
	}
	
	public static double toDegrees(double x) 
	{
		double answer = (x*(180/3.14159));
		return answer;
	}
	
	public static double toRadians(double x) 
	{
		double answer = (x*(3.14159/180));
		return answer;
	}
	
   public static double discriminant(double a, double b, double c) 	
   {
		double answer = ((b*b) - (4*a*c));
		return answer;
	}
	
	public static String toImproperFrac(int wholeNumber, int numerator, int denominator) 
	{
		int ab = (wholeNumber*denominator + numerator);
	    String answer = ab + "/" + denominator;
		return answer;
	}

	public static String toMixedNum(int x, int y) 
	{
		int answer1 = x/y;
		int answer2 = (x % y);
		String answer3 = answer1 + "_" + answer2 + "/" + y;
		return answer3;
	}
	
	public static String foil(int a, int b, int c, int d, String x) 
	{
		int ac = (a*c);
		int ad = (a*d);
		int bc = (b*c);
		int bd = (b*d);
		String x1 = x + "^2";
		String answer1 = ac + x1 + " + " + (ad+bc) + x + " " + bd;
		String answer2= answer1.toString();
		return answer2;
	}
	
	public static boolean isDivisibleBy(int a, int b) {
		boolean answer = true;
		if ((a%b) == 0) {
			answer = true;
		} else {
			answer = false;
		}
		return answer;
	}
	
	public static double absValue(double a) {
		if (a > 0) {
			return a;
		} else {
			return (a*-1);
		}
	}
	
	public static double max(double a, double b) {
		if (a > b) {
			return a;
		} else { 
			return b;
		}
	}
	
	public static double max(double a, double b, double c) {
		if (a > b) {
			return a;
		} else if (a > c) {
			return a;
		} else if (b > a) {
			return b;
		} else if (b > c) {
			return b;
		} else if (c > b) {
			return c;
		} else if (c > a ) {
			return c;
		} else {
			return c; 
		}
	}

	public static int min(int a, int b) {
		if (a < b) {
			return a;
		} else { 
			return b;
		}
	}
	
	public static double round2(double a) {
		double answer = a;
		if ( a > 0) { 
			answer = a * 1000;
			if ((answer % 10) > 5) {
				double minusTen = 10 - (answer % 10);
				answer = answer + minusTen;
				answer = answer / 1000;
			} else  {
				answer = a * 100;
				answer = (int) answer;
				answer = answer / 100;
			}
			return answer;
		}
		else {
			answer = -a * 1000;
			if ((answer % 10) > 5) {
				double minusTen = 10 - (answer % 10);
				answer = answer + minusTen;
				answer = answer / 1000;
			} else {
				answer = a * 100;
				answer = (int) answer;
				answer = answer / 100;
			}
			return (answer*-1);
		}
				
	}
	
	public static double exponent(double base, int exponent) {
		for (int counter = 1; counter < exponent; counter++) {
			base *= base;
		}
		return base;
	}
	
	public static int factorial(int number) {
		int originalNumber = number;
		for (int count = 1; count <= originalNumber; count++) {
			originalNumber -= 1;
			number *= originalNumber;
		}
		return number;
	}
	
	public static boolean isPrime(int num1) {
		int count = 2;
		boolean answer = false;

		if (num1 == 2) {
			answer = true;
			return answer;
		}
		while ((isDivisibleBy(num1, count) == false)) {
			count += 1;	
			answer = true;
		}
		return answer;
	}
	
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
	
	public static double sqrt(double valuePassed) {
		
		double a = (valuePassed/2); // should be a guess
		a = 0.5 * ((valuePassed/a) + a);
		
		while (absValue(valuePassed - a*a) >= 0.005) { 
			a = 0.5 * ((valuePassed/a) + a);
		}	
		
		return round2(a);
	}
	
	public static int rangeOfNumbers(int start, int end) {
		
		if (start<end) {
			for (int i = 0;i < (end-start); i--) { 
				start -= 1;
				System.out.println(start);
			}
			
		}return start;
	}
			
	
}
