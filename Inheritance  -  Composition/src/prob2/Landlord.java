package prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
	private int ssn;
	private String name;
	private List<Building> buildings;
	
	public Landlord(int ssn, String name) {
		this.ssn = ssn;
		this.name = name;
		this.buildings = new ArrayList<>();
	}

	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}
	
	public void addBuilding(Building building) {
		buildings.add(building);
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	@Override
	public String toString() {
		return "ssn:" + ssn + " name:" + name;
	}
}
