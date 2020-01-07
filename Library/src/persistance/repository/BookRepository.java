package persistance.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import persistance.entities.Book;

public class BookRepository {
	private static Map<String,Book> repository = new HashMap<String, Book>();
	
	static {
		Book book = new Book("book1","Oxford Dictionary","Andrew","Walugembe");
		book.addBookCopy("bk1Cpy1", true);
		book.addBookCopy("bk1Cpy2", true);
		repository.put(book.getIsbn(), book);
		AdminRepository.addBook(book);
		book = new Book("book2","Luganda Dictionay","Jim","Katugunka");
		book.addBookCopy("bk2Cpy1", true);
		book.addBookCopy("bk2Cpy2", true);
		repository.put(book.getIsbn(), book);
		AdminRepository.addBook(book);
		book = new Book("book3","Java in 21 Days","Jirom","Mebrhatu");
		book.addBookCopy("bk3Cpy1", true);
		book.addBookCopy("bk3Cpy2", true);
		repository.put(book.getIsbn(), book);
		AdminRepository.addBook(book);
		book = new Book("book4","Luganda in 21 Days","James","Igaba");
		book.addBookCopy("bk4Cpy1", true);
		book.addBookCopy("bk4Cpy2", true);
		repository.put(book.getIsbn(), book);
		AdminRepository.addBook(book);
		book = new Book("book5","Learn Java in Luganda","Daniel","Muyinza");
		book.addBookCopy("bk5Cpy1", true);
		book.addBookCopy("bk5Cpy2", true);
		repository.put(book.getIsbn(), book);
		AdminRepository.addBook(book);
	}
	
	public static Map<String,Book> getRepository()
	{
		return repository;
	}
	
	public static Book get(String id)
	{
		return repository.get(id);
	}
	
	public static void update(Book book)
	{
		repository.put(book.getIsbn(), book);
	}
	
	public static void createBook(String isbn, String title,String authorFirstName,String authorLastName)
	{
		Book newBook = new Book(isbn,title,authorFirstName,authorLastName);
		repository.put(newBook.getIsbn(), newBook);		
	}
	
	public static void createBook(Book book)
	{
		repository.put(book.getIsbn(), book);	
	}
}
