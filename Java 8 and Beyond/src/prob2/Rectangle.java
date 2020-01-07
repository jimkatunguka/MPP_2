package prob2;

public class Rectangle implements Polygon {
	private double length, width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	/*@Override
	public double computePerimeter() {
		return 0.0;
	}*/
	
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	//returns an array of sides of the rectangle.
	@Override
	public double[] getSides() {
		double[] sides = {length, width, length, width};
		return sides;
	}
}
