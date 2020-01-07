package persistance.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	private SimpleStringProperty title = new SimpleStringProperty("");
	private SimpleStringProperty authorFirstName = new SimpleStringProperty("");
	private SimpleStringProperty authorLastName = new SimpleStringProperty("");
	private SimpleStringProperty isbn = new SimpleStringProperty("");
	private SimpleIntegerProperty numberOfCopies = new SimpleIntegerProperty();
	private SimpleIntegerProperty numberOfAvailableCopies = new SimpleIntegerProperty();
	private SimpleIntegerProperty numberOfBorrowedCopies = new SimpleIntegerProperty();
	private List<MemberCheckoutRecord> checkoutRecords = new ArrayList<>();
	private Map<String,BookCopy> bookCopies = new HashMap();
	
	public Book(String isbn,String title,String authorFirstName,String authorLastName)
	{
		setIsbn(isbn);
		setAuthorFirstName(authorFirstName);
		setAuthorLastName(authorLastName);
		setTitle(title);
	}
	
	public String getTitle() {
		return title.get();
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	public String getAuthorFirstName() {
		return authorFirstName.get();
	}
	public void setAuthorFirstName(String author) {
		this.authorFirstName.set(author);
	}
	public String getAuthorLastName() {
		return authorLastName.get();
	}
	public void setAuthorLastName(String author) {
		this.authorLastName.set(author);
	}
	public String getIsbn() {
		return isbn.get();
	}
	public void setIsbn(String isbn) {
		this.isbn.set(isbn);
	}
	public void addCheckoutRecord(MemberCheckoutRecord record)
	{
		checkoutRecords.add(record);
	}
	public List<MemberCheckoutRecord> getCheckoutRecords()
	{
		return checkoutRecords;
	}
	public Map<String,BookCopy> getCopies()
	{
		return bookCopies;
	}
	public void addBookCopy(String copyId,Boolean availability)
	{
		bookCopies.putIfAbsent(copyId, new BookCopy(copyId,this,availability));
	}
	public void updateBookCopy(BookCopy bookCopy)
	{
		bookCopies.put(bookCopy.getId(), bookCopy);
	}
	public Integer getNumberOfAvailableCopies()
	{
		return (int)bookCopies.values().stream().filter(BookCopy::isAvailable).count();
	}
	public Integer getTotalNumberOfTotalCopies()
	{
		return bookCopies.size();
	}
	public Integer getNumberOfBorrowedCopies()
	{
		return (int)bookCopies.values().stream().filter(copy -> !copy.isAvailable()).count();
	}
}
