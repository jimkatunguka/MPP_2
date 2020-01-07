package main;

import controller.*;
import entity.*;
import dataaccess.*;

public class Main {

	public static void main(String[] args) {
		MemberController controller = MemberController.getInstance();
		
		Address address = new Address("1000 N 4th Street", "Fairfield", "Iowa", "52557");
		
		Member member = new Member();
		member.setId("123456789");
		member.setFirstName("John");
		member.setLastName("Doe");
		member.setAddress(address);
		member.setPhoneNumber("123-456-7890");
		
		controller.addNewMember(member);
		
		System.out.println(controller.getMemberById("123456789"));

	}

}