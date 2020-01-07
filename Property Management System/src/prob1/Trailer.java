package prob1;

public class Trailer extends Property{
	private double rent;
	
	@Override
	public double computeRent() {
		rent = 500;
		return rent;
	}

}
