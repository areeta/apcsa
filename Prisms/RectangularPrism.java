/* Write this concrete (non-abstract) class called RectangularPrism.  
 * It has 2 private fields (length and width).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class RectangularPrism extends Prism {
	
	private double length;
	private double width;
	
	public RectangularPrism(double length, double width, double height) {
		super(height);
		this.length = length;
		this.width = width;
	}
	
	public double calcAreaOfBase() {
		return length * width;
	}
	
	public double calcPerimeter() {
		return length + length + width + width;
	}

}

