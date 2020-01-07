package prob5B;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	
	public static TriFunction<List<Employee>, Integer, Character, String> getEmployee = 
			(list, salary, ch) -> {
			return
			list.stream()
			.filter(l->l.getSalary()>salary && l.getLastName().charAt(0) > ch)
			.map(l->l.getFirstName() + " " + l.getLastName())
			.sorted()
			.collect(Collectors.joining(", "));
			
			};
}
