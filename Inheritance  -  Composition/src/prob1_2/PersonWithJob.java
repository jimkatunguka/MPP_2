package prob1_2;

public class PersonWithJob{
	
	private Person person;
	private double salary;
	public String getName() {
		return person.getName();
	}
	public double getSalary() {
		return salary;
	}
	
	PersonWithJob(String n, double s) {
		person = new Person(n);
		salary = s;
	}
	
	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}
	
}
