package persistance.entities;

import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class MemberCheckoutRecord {
	private SimpleObjectProperty<BookCopy> bookCopy = new SimpleObjectProperty();
	private SimpleObjectProperty<Member> member = new SimpleObjectProperty();
	private SimpleObjectProperty<Date> returnDate = new SimpleObjectProperty();
	private SimpleObjectProperty<Date> checkoutDate = new SimpleObjectProperty();
	private SimpleIntegerProperty id = new SimpleIntegerProperty();	
	
	public MemberCheckoutRecord(Integer id,BookCopy bookCopy,Member member,Date checkoutDate,Date returnDate)
	{
		setId(id);
		setBookCopy(bookCopy);
		setMember(member);
		setCheckoutDate(checkoutDate);
		setReturnDate(returnDate);
	}
	
	public Boolean isDue()
	{
		return returnDate.get().before(new Date());
	}
	public String getBookIsbn()
	{
		return bookCopy.get().getBook().getIsbn();
	}
	public BookCopy getBookCopy()
	{
		return bookCopy.get();
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy.setValue(bookCopy);
	}
	public String getMemberId()
	{
		return member.get().getId();
	}
	public String getMemberName() {
		Member m = member.get(); 
		return m.getFirstName()+" "+m.getLastName();
	}
	public void setMember(Member member) {
		this.member.setValue(member);
	}
	public Date getReturnDate() {
		return returnDate.getValue();
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate.setValue(returnDate);
	}
	public Date getCheckoutDate() {
		return checkoutDate.getValue();
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate.setValue(checkoutDate);
	}
	public Integer getId() {
		return id.get();
	}
	public void setId(Integer id) {
		this.id.setValue(id);
	}	
}
