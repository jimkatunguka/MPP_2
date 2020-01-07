package prob1B;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
		System.out.print(stringStream.collect(Collectors.joining(",")));
	}
}
