package solution1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test() {
		List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
		        new Employee("John", "Sims", 110000),
		        new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000));
		
		String expected = "Alice Richards, Joe Stevens, John Sims, Steven Walters";
		String actual = Main.asString(emps);
		assertEquals(expected, actual);
	}

}
