package prob4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class Better {
	final Function<String, Predicate<String>> containsLetter 
   		= letter -> word -> word.contains(letter);
 
   	final Function<String, Predicate<String>> omitsLetter
   		= letter -> word -> !word.contains(letter);
	
	final Function<Integer, Predicate<String>> wordLength
		= length -> word -> word.length() == length;

	public int countWords(List<String> words, char c, char d, int len) {
		
	    return (int)(words.stream()
	    				  .filter(containsLetter.apply(""+c))
	    				  .filter(omitsLetter.apply(""+d))
	    				  .filter(wordLength.apply(len))
	    				  .count());


	}

	public static void main(String[] args) {
		Better wcf = new Better();
		List<String> words = Arrays.asList("Bob", "Alice", "Tim",
				"Joe", "Anthony", "Caleb", "Tom", "Bee", "Bot", 
				"Tea", "ATT");
				
		//should output number of words in the list that are of length 3, 
		//that include 'T' and exclude 'B'
		//Those are: ""Tim", "Tea", "ATT" and "Tom", so output is 4
		System.out.println(wcf.countWords(words, 'T', 'B', 3));
	}
}
