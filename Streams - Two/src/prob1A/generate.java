package prob1A;

import java.util.stream.IntStream;

public class generate {
	
	public static void main(String[] args) {
		IntStream ones = IntStream.generate(() -> 1).limit(5);// use limit rather than distinct
		ones.forEach(System.out::println);	
}
}
