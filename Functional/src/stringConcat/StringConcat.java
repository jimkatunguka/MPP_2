package stringConcat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringConcat {
	//Returns a list of those strings which belong to just one of the two lists
		//using concat
		public static List<String> elementsInJustOne(List<String> list1, List<String> list2) {
			//implement
			return Stream.concat(
					list1.stream().filter(l -> !list2.contains(l)),
					list2.stream().filter(l->!list1.contains(l)))
					.collect(Collectors.toList());
		}
		
		//test methods
		public static void main(String[] args) {
			testFirstMethod();
		}
		private static void testFirstMethod() {
			List<String> list1 = Arrays.asList(new String[]{"friend", "tree", "bike", "bat"});
			List<String> list2 = Arrays.asList(new String[]{"tree", "strong", "bike", "weak"});
			System.out.println("Strings occurring in just one of the two lists: " + elementsInJustOne(list1, list2));
		}
	

}
