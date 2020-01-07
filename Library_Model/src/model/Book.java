package model;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String isbn;
	private String title;
	private String authorFirstName;
	private String authorLastName;
	private List<CheckoutRecord> checkoutRecords;
	
	public Book(String isbn, String title, String firstName, String lastName) {
		this.isbn = isbn;
		this.title = title;
		this.authorFirstName = firstName;
		this.authorLastName = lastName;
		this.checkoutRecords = new ArrayList<>();
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}
	
	public List<CheckoutRecord> getCheckoutRecords() {
		return checkoutRecords;
	}
	@Override
	public String toString() {
		return isbn + " " + title + " " + authorFirstName + " "
				+ authorLastName + "\n";
	}
	
	

}
