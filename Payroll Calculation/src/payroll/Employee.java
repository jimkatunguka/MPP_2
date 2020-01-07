package payroll;

import java.time.Month;
import java.util.Random;

public abstract class Employee {
	private int empId;

	public Employee() {
		this.empId = setEmployeeID();
	}

	public int setEmployeeID() {
		Random r = new Random();
		int ID = r.nextInt(2000-1000)+1000;
		return ID;
	}
	public void print() {
		System.out.println("Employee id : " + this.empId+"\nPayslip:");
	}

	
	public Paycheck calcCompensation(Month monthOfYear, int year) {
		double grossPay = calcGrossPay(monthOfYear, year);
		return new Paycheck(grossPay);
	}

	public abstract double calcGrossPay(Month monthOfYear, int year);
}
