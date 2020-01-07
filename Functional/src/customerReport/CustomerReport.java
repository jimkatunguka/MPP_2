package customerReport;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerReport {		
		//Returns a list, in sorted order, of the names of the Customers in the input list who live in Fairfield
		public static List<String> getAllFairfieldCustomers(List<Customer> list) {
			return list.stream()
					.filter(c -> c.getCity().equals("Fairfield"))
					.map(c -> c.getName())
					.sorted()
					.collect(Collectors.toList());
		}
		
		
		//test methods
		public static void main(String[] args) {
			
			testCustMethod();
		}
		
		private static void testCustMethod() {
			Customer cust1 = new Customer("Bob", "11 Adams", "Fairfield", "52556");
			Customer cust2 = new Customer("Laurence Lebihans",	"12, rue des Bouchers",	"Marseille","13008");
			Customer cust3 = new Customer("Andy", "1000 Channing Ave", "Palo Alto", "94301");
			Customer cust4 = new Customer("Zeke", "212 Wilkshire Blvd", "Chicago", "57532");
			Customer cust5 = new Customer("Blauer Delikatessen", "Forsterstr. 57","Mannheim", "68306");
			Customer cust6 = new Customer("Anna", "1000 N 4th", "Fairfield", "52557");
			List<Customer> list = Arrays.asList(cust1, cust2, cust3, cust4, cust5, cust6);
			System.out.println("Names of Customers who live in Fairfield: " + getAllFairfieldCustomers(list));
		}
	}
