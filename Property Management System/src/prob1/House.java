package prob1;

public class House extends Property{
	private double rent;
	private double lotSize;
	
	public House(double lotSize) {
		this.lotSize = lotSize;
	}
	
	@Override
	public double computeRent() {
		rent = (0.1 * lotSize);
		return rent;
	}

}
