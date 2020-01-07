package prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
	int buildingNo;
	private double maintenaceCost;
	private List<Apartment> apartments;
	
	public Building(int buildingNo, double maintenanceCost) {
		this.buildingNo = buildingNo;
		this.apartments = new ArrayList<>();
		this.maintenaceCost = maintenanceCost;
	}

	public double getMaintenaceCost() {
		return maintenaceCost;
	}

	public void setMaintenaceCost(double maintenaceCost) {
		this.maintenaceCost = maintenaceCost;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void addApartments(Apartment apartment) {
		apartments.add(apartment) ;
	}
	
	public double getProfit() {
		double profit = 0;
		double totalRent = 0;
		for(Apartment a: apartments) {
			totalRent = totalRent + a.getRent();
		}
		profit = totalRent - (this.maintenaceCost);
		return profit;
	}
}
