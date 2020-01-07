package newstring;

import java.util.function.*;

public class StringCreator {
	public static void main(String[] args) {
		// either String::new or the full lambda will work below
		Function<char[], String> myFunc =  String::new;
			//	cArray -> new String(cArray);
		char[] myCharArray = { 's', 'p', 'e', 'a', 'k', 'i', 'n', 'g', 'c', 's' };
		System.out.println(myFunc.apply(myCharArray));
	}

}
