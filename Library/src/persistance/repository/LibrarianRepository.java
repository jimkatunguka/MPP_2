package persistance.repository;

import java.util.HashMap;
import java.util.Map;

import persistance.entities.Book;
import persistance.entities.Librarian;

public class LibrarianRepository {
	public static Librarian librarian = new Librarian("default","grp3","librarian","911");
	
	public static void addBooks(Book book)
	{
		librarian.addBook(book);
	}
}
