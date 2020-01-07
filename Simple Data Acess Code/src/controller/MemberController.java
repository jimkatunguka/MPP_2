package controller;

import dataaccess.DataAccess;
import dataaccess.DataAccessImpl;
import entity.Member;

public class MemberController {
	private static MemberController instance = new MemberController();
	
	private DataAccess<String, Member> dataAccess = new DataAccessImpl<String, Member>();
	
	private MemberController() {}
	
	public static MemberController getInstance() {return instance;}
	
	public Member addNewMember(Member member) {
		return dataAccess.add(member.getId(), member);
	}
	
	public Member getMemberById(String id) {
		return dataAccess.get(id);
	}

}
