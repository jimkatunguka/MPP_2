package prob7;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// set up
		Book book = new Book("test", 3);
		List<BookCopy> copies = book.getCopies();
		copies.forEach(copy -> copy.changeAvailability()); //comment out this line to test initial book availability
		
		//test
		System.out.println(book.isAvailable());

	}

}
