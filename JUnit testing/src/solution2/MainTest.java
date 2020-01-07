package solution2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {
	
	@Test
	void salaryGreaterThan100000Test() {
		boolean expected = true;
		boolean actual = Main.salaryGreaterThan100000(new Employee("John", "Sims", 110000));
		assertEquals(expected, actual);

	}
	
	@Test
	void lastNameAfterMTest() {
		boolean expected = true;
		boolean actual = Main.lastNameAfterM(new Employee("John", "Sims", 110000));
	assertEquals(expected, actual);
	}
	
	@Test
	void fullNameTest() {
		String expected = "John Sims";
		String actual = Main.fullName(new Employee("John", "Sims", 110000));
	assertEquals(expected, actual);
	}
	
	//This is a good practice test especially for a complex problem since it helps to test the small units 
	//of the code. This will enable the developer to detect bugs and debug as fast as possible.

}
