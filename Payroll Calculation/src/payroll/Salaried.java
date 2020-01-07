package payroll;

import java.time.Month;

public class Salaried extends Employee {

	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Salaried(double salary) {
		super();
		this.salary = salary;
	}

	@Override
	public double calcGrossPay(Month monthOfYear, int year) {
		return this.salary;
	}
	
	
	
}
