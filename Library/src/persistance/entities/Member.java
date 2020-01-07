package persistance.entities;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Member extends Person{
	private SimpleStringProperty firstName = new SimpleStringProperty("");
	private SimpleStringProperty lastName = new SimpleStringProperty("");
	private SimpleStringProperty id = new SimpleStringProperty();
	private SimpleStringProperty phone = new SimpleStringProperty("");
	private List<MemberCheckoutRecord> checkoutRecords = new ArrayList<>();
	
	public Member(String id,String firstName,String lastName,String phone)
	{
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
	}
		
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}	
	public void addCheckoutRecord(MemberCheckoutRecord record)
	{
		checkoutRecords.add(record);
	}
	public List<MemberCheckoutRecord> getCheckoutRecords()
	{
		return checkoutRecords;
	}
}
