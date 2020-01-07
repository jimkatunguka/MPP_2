package prob2;

public interface Polygon extends ClosedCurve {
	abstract double[] getSides();
	
	//@Override
	default double computePerimeter() {
		double[] sides = getSides();
		double perimeter = 0.0;
		for(double side: sides) {
			perimeter += side;
		}
		return perimeter;
	}

}
