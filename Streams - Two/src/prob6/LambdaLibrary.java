package prob6;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	
	static TriFunction<List<Employee>, Integer, Character, Long> getEmployee = 
			(list, salary, ch) -> {
			return
			list.stream()
			.filter(l->l.getSalary()>salary && l.getLastName().charAt(0) > ch)
			.map(l->l.getFirstName() + " " + l.getLastName())
			.sorted()
			.count();
			
			};

	static TriFunction<List<Employee>, Integer, Character, String> getEmployee2 = 
			(list, salary, ch) -> {
			return
			list.stream()
			.filter(l->l.getSalary()>salary && l.getFirstName().charAt(0) < ch)
			.map(l->l.getFirstName().toUpperCase() + " " + l.getLastName().toUpperCase())
			.sorted()
			.collect(Collectors.joining(", "));
			};
}
