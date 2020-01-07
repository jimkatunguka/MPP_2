package payroll;

import java.time.Month;

public class Hourly extends Employee {

	private double hourlyWage;
	private int hoursPerWeek;

	public Hourly(double hourlyWage, int hoursPerWeek) {
		super();
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	
	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	@Override
	public double calcGrossPay(Month monthOfYear, int year) {
		return this.hourlyWage * this.hoursPerWeek * 4; // assume a month has 4 weeks for simplicity

	}

}
