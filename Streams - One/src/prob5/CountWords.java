package prob5;

import java.util.Arrays;
import java.util.List;

public class CountWords {
	public static void main(String[] args) {

		// public int countWords(List<String> words, char c, char d, int len)

		List<String> words = Arrays.asList("cccc", "abcc", "uycr", "cdff", "ccc");

		FunctionX5<List<String>, Character, Character, Integer, Long> f = 
				(list, c, d, len) -> {

					return words.stream()
							.filter(w -> w.length() == len)
							.filter(w -> w.contains(c + ""))
							.filter(w -> !w.contains(d + ""))
							.count();
					};
					
		System.out.println(f.apply(words, 'c','d',4));
	}

}
