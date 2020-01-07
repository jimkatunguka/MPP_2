package prob1A;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment {
	public static void main(String[] args) {
	List<Integer> ints = new ArrayList<Integer>();
	ints.add(1);
	ints.add(2);
	//List<Number> nums = ints; 
	//compiler error above, can not convert from integer type to number list of integers not a subtype of list of numbers
	//nums.add(3.14);
	}
	

}
