package persistance.entities;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Admin extends User {	
	private List<Book> addedBooks = new ArrayList();
	private List<Member> createdMembers = new ArrayList();
	
	public Admin(String id,String firstName,String lastName,String phone)
	{
		setUserId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
	}
	public void addBook(Book book)
	{
		addedBooks.add(book);
	}	
	public void addMember(Member member)
	{
		createdMembers.add(member);
	}
}
