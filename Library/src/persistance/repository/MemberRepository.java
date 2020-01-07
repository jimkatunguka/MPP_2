package persistance.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import persistance.entities.Member;

public class MemberRepository {
	private static Map<String,Member> repository = new HashMap<String, Member>();
	
	static {
		Member m = new Member("member1","Andrew","Walugembe","911");
		repository.put(m.getId(),m);
		AdminRepository.addMember(m);
		m = new Member("member2","Jim","Katugunka","911");
		repository.put(m.getId(),m);
		AdminRepository.addMember(m);
		m = new Member("member3","Jirom","Mebrhatu","911");
		repository.put(m.getId(),m);
		AdminRepository.addMember(m);
		m = new Member("member4","James","Igaba","911");
		repository.put(m.getId(),m);
		AdminRepository.addMember(m);
		m = new Member("member5","Daniel","Muyinza","911");
		repository.put(m.getId(),m);
		AdminRepository.addMember(m);
	}
	
	public static Map<String,Member> getRepository()
	{
		return repository;
	}
	
	public static Member get(String id)
	{
		return repository.get(id);
	}
	
	public static void update(Member member)
	{
		repository.put(member.getId(), member);
	}
	
	public static String create(String firstName,String lastName,String phone)
	{
		Member newMember = new Member(UUID.randomUUID().toString(),firstName,lastName,phone);
		repository.put(newMember.getId(), newMember);
		return newMember.getId();
	}

}
