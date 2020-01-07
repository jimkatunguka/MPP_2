package prob2A;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	/*@Override
	public int compare(Employee e1, Employee e2) {
		return e1.name.compareTo(e2.name);
	}*/
	
	@Override
	public int compare(Employee e1, Employee e2) {
		if ((e1.salary == e2.salary) && (e1.name.compareTo(e2.name) == 0))
			return 0;
		else if ((e1.salary < e2.salary) && (e1.name.compareTo(e2.name) < 1))
			return -1;
		else
			return 1;
	}
}
