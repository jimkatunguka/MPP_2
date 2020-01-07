package generics;

import java.util.stream.Stream;

//imperative - generic
public class CountOccurence {
	public static <T> int countOccurencies(T[] words, T t ) {
		int count = 0;
		if(t== null) {
			for(T i:words) {
				if(i==null) count++;
			}
		}
		else {
		for(T i: words) {
			if(t.equals(i)) count++;
			
		}
		}
		return count;
	}
	
	//imperative
	public static int countOccurencies1(String[] words, String s) {
		int count = 0;
		for(String i: words) {
			if(i.equalsIgnoreCase(s)) count++;
		}
		return count;
	}
	
	// declarative - generic
	public static <T> int countOccurencies2(T[] words, T m) {
		return (int)Stream.of(words)
				.filter(x -> {
					if (m == null) return (x == null);
					return m.equals(x);
				})
				.count();
	}
	
	public static void main(String[]args) {
		String[] cars = {"nissan","", null, "ford", "toyota","", "nissan"};
		Integer[]nums = {1, 6, 7, 1, 5, 6, 9, 1, 0,8};
		System.out.println (countOccurencies(cars, ""));
		System.out.println (countOccurencies(nums, 1));
		
		System.out.println (countOccurencies2(cars, ""));
		System.out.println (countOccurencies2(nums, 1));
	}

}
