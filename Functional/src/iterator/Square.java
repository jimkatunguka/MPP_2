package iterator;

import java.util.stream.IntStream;

public class Square {
	public static void main(String[]args) {
	
		IntStream
			.iterate(1, n->n+1)
			.map(n->n*n)
			.limit(4)
			.forEach(System.out::println);
		
	}
}
