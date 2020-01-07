package persistance.entities;

import javafx.beans.property.SimpleStringProperty;

public class Person {

	protected SimpleStringProperty firstName = new SimpleStringProperty("");
	protected SimpleStringProperty lastName = new SimpleStringProperty("");
	private SimpleStringProperty phone = new SimpleStringProperty("");
	
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	public String getLastName() {
		return lastName.get();
	}
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String id) {
		this.phone.set(id);
	}
}
