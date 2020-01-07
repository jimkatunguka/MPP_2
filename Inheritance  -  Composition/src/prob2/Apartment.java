package prob2;

public class Apartment {
	private int apartmentNo;
	private double rent;
	
	public Apartment(int apartmentNo, double rent) {
		this.apartmentNo = apartmentNo;
		this.rent = rent;
	}

	public int getApartmentNo() {
		return apartmentNo;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}
}