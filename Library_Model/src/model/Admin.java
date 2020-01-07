package model;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	private String adminId;
	private String firstName;
	private String lastName;
	private String phone;
	private List<Book> addedBooks;
	private List<Member> createdMembers;
	
	public Admin(String adminId, String firstName, String lastName, String phone ) {
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.addedBooks = new ArrayList<>();
		this.createdMembers = new ArrayList<>();
		
	}

	public String getAdminId() {
		return adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ "]";
	}

	public List<Book> getAddedBooks() {
		return addedBooks;
	}

	public void addBooks(List<Book> addedBooks) {
		this.addedBooks.addAll(addedBooks);
	}
	
	public void addBook(Book book) {
		addedBooks.add(book);
	}

	public List<Member> getCreatedMembers() {
		return createdMembers;
	}

	public Member createMember(String memberId, String firstName, String lastName, String phone) {
		Member member = new Member(memberId, firstName, lastName, phone);
		addMember(member);
		
		return member;
	}
	// adds an already created member
	public void addMember(Member member) {
		createdMembers.add(member);
	}
	// to be tested
	public Member editMember(Member member,String firstName, String lastName, String phone) {
		if(createdMembers.contains(member)) {
			member.setFirstName(firstName);
			member.setLastName(lastName);
			member.setPhone(phone);
		}
		return member;
	}
	
	public Book deleteBook(Book book) {
		if(addedBooks.contains(book)) {
		addedBooks.remove(book);
		}
		return book;
	}
	
	
	
	
	

}
