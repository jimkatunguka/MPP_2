package prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ForEachExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//System.out.println(MyFunction.apply(list));
		
		//parseint
		
		String x = "one";
		int n = Integer.parseInt(x);
		System.out.println(n);

	}
	
	/*static class MyConsumer implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	}
	*/
	
	static Function<List<String>, List<String>> MyFunction = list->
	list.stream()
	.map(l->l.toUpperCase())
	.collect(Collectors.toList());
	
	
	
}
