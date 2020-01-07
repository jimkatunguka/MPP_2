package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	private static List<Book> libBooks = new LinkedList<>();
	
	public static void main(String[]args) {
	Admin admin1 = new Admin("01", "Jim", "Katunguka", "2560");
	Admin admin2 = new Admin("02", "Eric", "Nkuri", "2561");
	Admin admin3 = new Admin("03", "Elias", "Mugenzi", "2562");
	
	//List of admins
	List<Admin> admins = Arrays.asList(admin1, admin2, admin3);
	
	Book book1 = new Book("01", "mybook1", "S", "K");
	Book book2 = new Book("02", "mybook2", "P", "M");
	Book book3 = new Book("03", "mybook3", "K", "Z");
	Book book4 = new Book("04", "mybook4", "O", "D");
	Book book5 = new Book("05", "mybook5", "J", "K");
	Book book6 = new Book("06", "mybook6", "X", "H");
	
	Librarian lib1 = new Librarian("01", "Andy", "Moses", "3560");
	Librarian lib2 = new Librarian("02", "Boyd", "Kean", "3561");
	Librarian lib3 = new Librarian("03", "Carl", "Penya", "3562");
	
	List<Librarian> Librarians = Arrays.asList(lib1, lib2, lib3);
	//admin create members
	Member member1 = admin1.createMember("001", "John", "de lape", "+154656978");
	Member member2 = admin1.createMember("002", "Marcus", "BrownLee", "+255785969784");
	Member member3 = admin1.createMember("003", "Super", "Car Blondie", "+254968754704");
	
		
	//Admin adds book
	admin1.addBook(book1);
	admin1.addBook(book2);
	
	admin2.addBook(book3);
	admin2.addBook(book4);
	
	admin3.addBook(book5);
	admin3.addBook(book6);
	
	//get list of added books.
	//System.out.println("-----Added Books-----");
	//System.out.println(getAddedBooksList(admins));
	
	//System.out.println("-----uppon deletion-----");// an admin removes a book that they added.
	//System.out.println(admin3.deleteBook(book5));
	
	//System.out.println("-----new list of Added Books-----");
	//System.out.println(getAddedBooksList(admins));
	
	
	
	System.out.println("-----new list of All Books-----");
	System.out.println(libBooks);
	
	updateLibBooks(admins);
	System.out.println();
	
	System.out.println("-----updated list of All Books-----");
	System.out.println(libBooks);
	
	checkoutBook (lib1, book6, member1, LocalDate.now(), LocalDate.of(2019, 12, 25));
	System.out.println("-----after 1st checkout-----");
	System.out.println(libBooks);
	
	System.out.println("-----Member checkout Record-----");
	System.out.println(member1.getCheckedoutRecords());
	
	System.out.println("-----checking out an overdue book-----");
	checkoutBook (lib3, book1, member2, LocalDate.of(2019, 10, 25), LocalDate.of(2019, 11, 28));
	System.out.println("-----after checkout-----");
	System.out.println(libBooks);
	
	System.out.println("-----Member checkout Record-----");
	System.out.println(member2.getCheckedoutRecords());
	
	System.out.println("-----Overdue Books-----");
	System.out.println(overdueBook(Librarians));
		
	}
	//get list of all added books
	static List<Book> getAddedBooksList(List<Admin> admins){
		List<Book> books = new ArrayList<>();
		for(Admin a: admins) {
			books.addAll(a.getAddedBooks());
		}
		return books;
	}
	static void updateLibBooks(List<Admin> admins){
		List<Book> books = new ArrayList<>();
		for(Admin a: admins) {
			books.addAll(a.getAddedBooks());
		}
		
		libBooks.addAll(books);
		
	}
	
	static void checkoutBook (Librarian lib, Book book, Member member, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecord cr = new CheckoutRecord(checkoutDate, dueDate, book,  member, lib);

		if(libBooks.contains(book)) {
			lib.addCheckedoutRecord(cr);
			member.addCheckedoutRecord(cr);
			libBooks.remove(book);
		}
		}
	
	static List<Book> overdueBook(List<Librarian> libs) {
		List<Book> overdueBooks = new ArrayList<>();
		List<CheckoutRecord> checkoutRecords = new ArrayList<>();
		
		for(Librarian l: libs) {
			checkoutRecords.addAll(l.getCheckedoutRecords());
		}
		
		for(CheckoutRecord cr: checkoutRecords) {
			if((cr.getDueDate().compareTo(LocalDate.now()) == -1 ) && !libBooks.contains(cr.getBook())){
				overdueBooks.add(cr.getBook());
			}	
		}
		return overdueBooks;
		
	}
	
	

}
