package prob1;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
	private int ssn;
	private String name;
	private List<Property> properties;
	
	public Landlord(int ssn, String name) {
		this.ssn = ssn;
		this.name = name;
		this.properties = new ArrayList<>();
	}

	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}
	
	public void addProperty(Property Property) {
		properties.add(Property);
	}

	public List<Property> getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return "ssn:" + ssn + " name:" + name;
	}
}