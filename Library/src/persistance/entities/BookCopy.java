package persistance.entities;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class BookCopy {
	private SimpleStringProperty id = new SimpleStringProperty();
	private SimpleObjectProperty<Book> book = new SimpleObjectProperty();
	private SimpleBooleanProperty isAvailable = new SimpleBooleanProperty();
	
	public BookCopy(String id,Book book,Boolean isAvailable)
	{
		setId(id);
		setBook(book);
		setIsAvailable(isAvailable);
	}	
	public Book getBook() {
		return book.get();
	}
	
	public void setBook(Book book) {
		this.book.set(book);
	}
	
	public String getId() {
		return id.get();
	}
	
	public void setId(String id)
	{
		this.id.set(id);
	}
	
	public Boolean isAvailable()
	{
		return isAvailable.get();
	}

	public void setIsAvailable(Boolean available)
	{
		isAvailable.set(available);
	}
}
