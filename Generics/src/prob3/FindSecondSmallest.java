package prob3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindSecondSmallest {
	
	public static <T extends Comparable<T>> T min(List<T> list) {
		return list.stream()
				.sorted()
				.distinct()
				.limit(2)
				.skip(1)
				.collect(Collectors.toList())
				.get(0);
	}
	
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(5, 3, 6, 7, 8);
		List<String> s = Arrays.asList("mongo", "mango",
				"mingo", "mengo", "mango", "mengo");
		List<Double> d = Arrays.asList(1.0, 3.03, 6.09, 3.45);
		
		System.out.println(min(l));
		System.out.println(min(s));
		System.out.println(min(d));
	}
}
