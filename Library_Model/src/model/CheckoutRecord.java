package model;

import java.time.LocalDate;

public class CheckoutRecord {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private Book book;
	private Member member;
	private Librarian librarian;
	
	public CheckoutRecord(LocalDate checkoutDate, LocalDate dueDate,Book book, Member member, Librarian lib) {
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.book = book;
		this.member = member;
		this.librarian = lib;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public Book getBook() {
		return book;
	}

	public Member getMember() {
		return member;
	}
	
	

	public Librarian getLibrarian() {
		return librarian;
	}

	@Override
	public String toString() {
		return "Date: " + checkoutDate + " Due on: " + dueDate + " Book: " + book.getTitle()
				+ " Member: " + member.getFirstName() + " " + member.getLastName() + "\n";
	}
	
	

}
