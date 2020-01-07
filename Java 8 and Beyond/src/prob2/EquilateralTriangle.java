package prob2;

public class EquilateralTriangle implements Polygon{
	private double side;
	public EquilateralTriangle(double side) {
		this.side = side;
	}
	
	
	public double getSide() {
		return side;
	}


	public void setSide(double side) {
		this.side = side;
	}


	//returns an array of sides of the rectangle.
	public double[] getSides() {
		double[] sides = {side, side, side};
		return sides;
	}

}
