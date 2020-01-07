package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String memberId;
	private String firstName;
	private String lastName;
	private String phone;
	private List<CheckoutRecord> checkoutRecords;
	
	public Member(String memberId, String firstName, String lastName, String phone ) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.checkoutRecords = new ArrayList<>();
	}

	public String getMemberId() {
		return memberId;
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
		return "Member [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + "]";
	}
	
	

}
