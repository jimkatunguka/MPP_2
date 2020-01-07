package classExercise;

import java.util.function.BiFunction;

public class Maths {
	
	static BiFunction<Integer, Integer, Integer> f = (x, y) ->  x+(2*x*y);
	
	static TriFunction<Integer, Integer, Integer, Integer> k = (x,y,z) -> x+y+z;
	


public static void main(String[]args) {
	System.out.println(f.apply(2, 4));
	System.out.println(k.apply(1, 2, 3));
}

}