package Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppleAdmin {
	//1.
	public static List<Apple> redSpecials (List<Apple> inventory){
		return inventory.stream()
				.filter(i -> i.getColor().equals("red") && i.getWeight()>100)
				.collect(Collectors.toList());
	}
	
	//2.
	public static List<Apple> topTenRedSpecials(List<Apple> inventory){
		return inventory.stream()
				.filter(i -> i.getColor().equals("red") && i.getWeight()>100)
				.sorted(Comparator.comparing(Apple::getWeight).reversed())
				.limit(10)
				.collect(Collectors.toList());
	}

	/*3. To turn solution 1 into a reusable element in a Lambda Library, identify the
	parameters that are combined together in the pipeline i.e List<Apples>, color and weight,
	and consider those to be arguments for a functional interface that you will create. In this case I created and defined 
	 a function TriFunction that accepts the three parameters and returns a List<Apples>
	 The solution can now be re-written as below and implemented by overriding the apply() method*/
	
	static TriFunction<List<Apple>, String, Double ,  List<Apple>> myFunction = (inventory, color, weight) ->
	inventory.stream()
			.filter(i -> i.getColor().equals(color) && i.getWeight()> weight)
			.collect(Collectors.toList());
	
	public static void main(String[]args) {
		List<Apple> apples = Arrays.asList(
				new Apple("red", 101.0),
				new Apple("orange", 80.0),
				new Apple("green", 10.0),
				new Apple("green", 80.0),
				new Apple("red", 120.0),
				new Apple("red", 150.0)
				
				);
		//all red specials
		System.out.println(redSpecials(apples));
		
		//top 10 red specials
		System.out.println(topTenRedSpecials(apples));
		
		//4. implementation of the TriFunction
		System.out.println(myFunction.apply(apples, "red", 100.0));
		
	}
	
	
}
