package persistance.repository;

import persistance.entities.Admin;
import persistance.entities.Book;
import persistance.entities.Member;

public class AdminRepository {
	public static Admin admin = new Admin("default","grp3","Admin","911");
	
	public static void addBook(Book book)
	{
		admin.addBook(book);
	}
	
	public static void addMember(Member member)
	{
		admin.addMember(member);
	}
}
