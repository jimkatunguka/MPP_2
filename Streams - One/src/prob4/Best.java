package prob4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Best {
	final TriFunction<String, String, Integer, Predicate<String>> properties
	    = (let1, let2, length) -> (word -> word.contains(let1) &&
			 !word.contains(let2) && word.length() == length);

	public int countWords(List<String> words, char c, char d, int len) {	
	    return (int)(words.stream()
	    				  .filter(properties.apply("" + c, "" + d, len))	    				
	    				  .count());
	}

	public static void main(String[] args) {
		Best wcf = new Best();
		List<String> words = Arrays.asList("Bob", "Alice", "Tim",
				"Joe", "Anthony", "Caleb", "Tom", "Bee", "Bot", 
				"Tea", "ATT");
				
		//should output number of words in the list that are of length 3, 
		//that include 'T' and exclude 'B'
		//Those are: ""Tim", "Tea", "ATT" and "Tom", so output is 4
		System.out.println(wcf.countWords(words, 'T', 'B', 3));
	}
}
