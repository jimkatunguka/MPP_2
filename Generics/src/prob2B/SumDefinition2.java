package prob2B;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SumDefinition2 {
	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
			for(Number num : nums) s += num.doubleValue();
			return s;	
	}
	
	public static void main(String[]args) {
		List<Object> ints = new ArrayList<Object>();
		ints.add(1);
		ints.add("two");
		//List<? super Integer> ints = objs;
		ints.add(3);
		//double dbl = sum(ints);
}}
