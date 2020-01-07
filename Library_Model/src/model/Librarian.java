package model;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
	private String librarianId;
	private String firstName;
	private String lastName;
	private String phone;
	private List<CheckoutRecord> checkoutRecords;
	
	public Librarian(String librarianId, String firstName, String lastName, String phone ) {
		this.librarianId = librarianId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		
		checkoutRecords = new ArrayList<>();
	}

	public String getLibrarianId() {
		return librarianId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}
	

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void addCheckedoutRecord(CheckoutRecord record) {
		checkoutRecords.add(record);
	}
	
	public List<CheckoutRecord> getCheckedoutRecords() {
		return checkoutRecords;
	}
	
	
	@Override
	public String toString() {
		return "Librarian [librarianId=" + librarianId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + "]";
	}
	
	

}
