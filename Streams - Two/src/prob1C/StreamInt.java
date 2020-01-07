package prob1C;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInt {
	public static void main(String[]args) {
	Stream<Integer> intStream = Stream.of(7, 2, 3, 4, 5);
	
IntSummaryStatistics summ = intStream.collect(Collectors.summarizingInt(Integer::intValue));
	System.out.println("Max: " + summ.getMax() + " Min: " + summ.getMin());
}
}
