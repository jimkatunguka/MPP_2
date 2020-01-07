package prob1h;

import java.io.PrintStream;
import java.util.function.*;

/**
 * out is a static variable in System that is initialized
when java starts up with a call to initializeSystemClass 
(which calls setOut to initialize out and 
connect it to standard output) -- therefore, System.out::println
is an implementation of Consumer<String> and
the following are equivalent 
Consumer<String> print = x -> System.out.println(x);
Consumer<String> print = System.out::println
and this is of type obj::instanceMethod
 *
 */
public class Out {
	/**
	 * Code from the System class:
	 *     public final static PrintStream out = null;
	 *     ...
	 *     public static void setOut(PrintStream out) {
        		checkIO();
        		setOut0(out);
    	   }
    	   ...
    	   private static native void setOut0(PrintStream out);
	 */
	public static void main(String[] args) {
		Consumer<String> print1 = x -> System.out.println(x);
		
		//object::instanceMethod
		Consumer<String> print2 = System.out::println;
		
		print2.accept("hello");

	}

}
