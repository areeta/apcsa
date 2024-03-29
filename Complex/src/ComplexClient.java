
public class ComplexClient {

	public static void main(String[] args) {
		
		//make new Complex objects: c1 and c2
		Complex c1 = new Complex(4, -3);
		Complex c2 = new Complex(1, 2);
		
		//add c1 and c2 and store the result
		//in a new complex #, c3
		Complex c3 = c1.add(c2);
		
		//print c3 in the form "_+_i"
		System.out.println(c3.toString());
		
		//multiply c1 by c2 and store the result
		//in a new complex #, c4
		Complex c4 = c1.multiply(c2);
		
		//print c4 in the form "_+_i"
		System.out.println(c4.toString());
		
		//find the distance
		double c5 = c1.distanceTo(c2);
		System.out.println(c5);
		
		//Number #6 on the Complex Lab
		System.out.println(c1);		
		
		System.out.println(distanceBetween(c4, c4));
		
	}

	//Number #7
	public static double distanceBetween(Complex c1, Complex c2) {
		int diffReal = c1.getReal() - c2.getReal();
		int diffImag = c1.getImag() - c2.getImag();
		double answer = Math.sqrt(diffReal*diffReal + diffImag*diffImag);
		return answer;
	}

}
