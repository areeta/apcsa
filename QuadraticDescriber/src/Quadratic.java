import java.util.Scanner;
public class Quadratic {

	

//      Quadratic will be responsible for all the calculations.  
//		It must contain the following method whose header is provided below:
//		Feel free to copy and paste methods from your calculate class into your 
//		Quadratic class.  In some instances, you may need to alter them slightly 
//		(to handle doubles instead of ints, for example).
		

	public static void quadrDescriber (double a, double b, double c) {
		
		System.out.println("Description of the graph of: ");
		System.out.println("y = " + a + " x^2 + " + b + " x + " + c);
		
		System.out.println();
				
		if (a > 0) {
			System.out.println("Opens: Up" );
		} else {
			System.out.println("Opens: Down" );
		}
		
		System.out.println("Axis of Symmetry: " + round2(axisOfSymmetry(a, b)));
		System.out.println("Vertex: (" + round2(axisOfSymmetry(a, b)) + ", " + round2(vertex(a, b, c)) + ")");
		System.out.println("x-intercept(s): " + quadForm(a, b, c));
		System.out.println("y-intercept: " + c);
	}

	public static double vertex(double a, double b, double c) {
		double x = axisOfSymmetry(a, b);
		double answer = (a *square(x)) + (b*x) + c;
		return answer;
	}
	
	public static double axisOfSymmetry(double a, double b) {
		double answer = (-1) * (b/ (2*a));
		return answer;
	}
	
	public static double square(double x) 
	{
		double answer = (x*x);
		return answer;
	}
	
   public static double discriminant(double a, double b, double c) 	
   {
		double answer = ((b*b) - (4*a*c));
		return answer;
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
	
	public static boolean isDivisibleBy(double a, double b) {
		
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
	
	public static double absValue(double a) {
		if (a > 0) {
			return a;
		} else {
			return (a*-1);
		}
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
	
	public static double exponent(double base, int exponent) {
		// pre: exponent and base >= 0
		// post: returns exponent
		if ( (base < 0) || (exponent < 0) ) {
			throw new IllegalArgumentException("negative number: " + base + " or " + exponent);
		}
		double originalNum = base;
		for (int counter = 1; counter < exponent; counter++) {
			base *= originalNum;
		}
		return base;
	}
	
	public static double factorial(double number) {
	
		// pre: number >= 0
		// post: returns number factorial (number!)
		if ( number < 0 ) {
			throw new IllegalArgumentException("negative number: " + number);
		}
		
		double original = number;
		for (double count = original; count > 2 ; count--) {
			original = original - 1;
			number = number * original;
		}
		return number;
	}
	
	public static double sqrt(double valuePassed) {
		
		// pre: valuePassed >= 0
		// post: returns number factorial (number!)
		if ( valuePassed < 0 ) {
			throw new IllegalArgumentException("the negative number is " + valuePassed);
		} 
				
		double a = (valuePassed/2); // should be a guess
		a = 0.5 * ((valuePassed/a) + a);
		
		while (absValue(valuePassed - a*a) >= 0.005) { 
			a = 0.5 * ((valuePassed/a) + a);
		}	
		
		return round2(a);
	}
	
	public static String quadForm(double a, double b, double c) {
		
		String answer = "";
		
		if ( (discriminant( a, b, c)) > 0 ) {
			double plus = ((-b) + (sqrt((square(b))-(4*a*c)))) / (2*a);
			double minus = ((-b) - (sqrt((square(b))-(4*a*c)))) / (2*a);
			answer = round2(plus) + " and " + round2(minus);
		} else if ( (discriminant( a, b, c)) == 0 ) {
			double plus = (-b) / (2.0*a);			
			answer = round2(plus) + "";
		} else if ( (discriminant( a, b, c)) < 0 ) {
			answer = "None";
		}
		return answer;
	}	
}
