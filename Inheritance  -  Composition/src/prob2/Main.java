package prob2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {

		//Landlords
		Landlord L1 = new Landlord(01, "James Igaba");
		Landlord L2 = new Landlord(02, "Jim Katunguka");
		Landlord L3 = new Landlord(03, "Stevenson Bailey");
		
		//Buildings
		Building B1 = new Building(01, 100);
		Building B2 = new Building(02, 200);
		Building B3 = new Building(03, 300);
		Building B4 = new Building(04, 400);
		Building B5 = new Building(05, 500);
		Building B6 = new Building(06, 600);
		Building B7 = new Building(07, 700);
		
		//Apartments
		Apartment A1 = new Apartment(01, 100);
		Apartment A2 = new Apartment(02, 200);
		Apartment A3 = new Apartment(03, 300);
		Apartment A4 = new Apartment(04, 400);
		Apartment A5 = new Apartment(05, 500);
		Apartment A6 = new Apartment(06, 600);
		Apartment A7 = new Apartment(07, 700);
		
		//Add buildings to LandLord L1
		L1.addBuilding(B1);
		L1.addBuilding(B2);
		L1.addBuilding(B3);
		
		//Add apartments to the buildings
		B1.addApartments(A1);
		B1.addApartments(A2);
		
		B2.addApartments(A3);
		B2.addApartments(A4);
		B2.addApartments(A5);
		
		B3.addApartments(A6);
		
		System.out.println(monthlyProfit(L1));
	}
	
	//calculates monthly profit.
	public static double monthlyProfit(Landlord landlord) {
		List<Building> buildings = new ArrayList<>();
		buildings.addAll(landlord.getBuildings());
		
		double monthlyProfit = 0;
		for(Building b: buildings) {
			monthlyProfit = monthlyProfit + b.getProfit();
		}
		return monthlyProfit;
		
	}

}
