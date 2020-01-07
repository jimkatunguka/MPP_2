package prob1;

public class Condo extends Property{
	private double rent;
	private int numFloors;
	
	public Condo(int numFloors) {
		this.numFloors = numFloors;
	}
	
	@Override
	public double computeRent() {
		rent = (400 * numFloors);
		return rent;
	}

}
