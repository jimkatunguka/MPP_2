package persistance.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import persistance.entities.Book;
import persistance.entities.BookCopy;
import persistance.entities.MemberCheckoutRecord;
import persistance.entities.Member;

public class MemberCheckoutRecordRepository {
	private static Map<Integer,MemberCheckoutRecord> repository = new HashMap<Integer, MemberCheckoutRecord>();
	
	public static Integer getCount()
	{
		return repository.size();
	}
	
	public static Map<Integer,MemberCheckoutRecord> getRecords()
	{
		return repository;
	}
	
	public static MemberCheckoutRecord getMemberCheckoutRecord(Integer id)
	{
		return repository.get(id);
	}
	
	public static Integer create(BookCopy bookCopy,Member member,Date checkoutDate,Date returnDate)
	{
		Integer currentSize = repository.size();
		MemberCheckoutRecord checkoutRecord = new MemberCheckoutRecord(++currentSize,bookCopy,member,checkoutDate,returnDate);
		repository.put(checkoutRecord.getId(), checkoutRecord);
		return checkoutRecord.getId();
	}
}
