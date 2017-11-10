public class Complex {
	
	//If you can say this., it's not a static variable.
	
	//Fields
	private int real;
	private int imag;
	private int quadrant;
	
	//Constructors
	public Complex(int real, int imag) {
		this.real = real;
		this.imag = imag;
		this.quadrant = quad();
	}
	public Complex() {
		this.real = 0;
		this.imag = 0;
		this.quadrant = quad();
	}
	
	//Getters
	public int getReal() {
		return real;
	}
	public int getImag() {
		return imag;
	}
	
	//Setters
	public void setReal(int newReal) {
		real = newReal;
		this.quadrant = quad();
	}
	public void setImag(int newImag) {
		imag = newImag;
		this.quadrant = quad();
	}
	
	//Quadrant method
	public int quad() {
		if (real>0 && imag>0) {
			quadrant = 1;
		} else if (real>0 && imag<0) {
			quadrant = 2;
		} else if (real<0 && imag<0) {
			quadrant = 3;
		} else if (real<0 && imag>0) {
			quadrant = 4; 
		} else {
			quadrant = 0;
		}
		return quadrant;
	}
	
	//Add method
	public Complex add(Complex second) {
		int sumReal = this.real + second.real;
		int sumImag = this.imag + second.imag;
		Complex sum = new Complex(sumReal, sumImag);
		return sum;
	}
	
	//Multiply method
	public Complex multiply(Complex second) {
		int FIRST = this.real * second.real;
		int SECOND = this.imag * second.imag * (-1);
		
		int totalReal = FIRST + SECOND;
		
		int THIRD = this.real * second.imag;
		int FOURTH = this.imag * second.real;
		
		int totalImag = THIRD + FOURTH;

		Complex product = new Complex(totalReal, totalImag);
		return product;
	}
	
	//Distance method
	public double distanceTo(Complex other) {
		int diffReal = other.real - this.real;
		int diffImag = other.imag - this.imag;
		return Math.sqrt(diffReal*diffReal + diffImag*diffImag);
	}
	
	//Print String easier method
	public String toString() {
		return real + " + " + imag + "i";
	}
}
