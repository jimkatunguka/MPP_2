package persistance.entities;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class Librarian extends User{		
	private List<Book> checkedoutBooks = new ArrayList();
	
	public Librarian(String id,String firstName,String lastName,String phone)
	{
		setUserId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
	}
		
	public void addBook(Book book)
	{
		checkedoutBooks.add(book);
	}
	public List<Book> getBooks()
	{
		return checkedoutBooks;
	}
}
