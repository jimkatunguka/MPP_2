package prob4;

import java.util.Arrays;
import java.util.List;

public class Advanced {
	final static QuadFunction<List<String>, String, String, Integer, Long> counter
    = (list, let1, let2, length) 
        -> list.stream()
               .filter(word -> word.contains(let1) &&
            			 !word.contains(let2) && word.length() == length)
               .count();
    
    public static void main(String[] args) {
    	List<String> words = Arrays.asList("Bob", "Alice", "Tim",
				"Joe", "Anthony", "Caleb", "Tom", "Bee", "Bot", 
				"Tea", "ATT");
    	System.out.println(counter.apply(words, "T", "B", 3));
    }
    
}
