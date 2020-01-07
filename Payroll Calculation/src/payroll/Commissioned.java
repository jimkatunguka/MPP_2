package payroll;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Commissioned extends Employee {

	private double commission;
	private double baseSalary;
	private List<Order> orders;

	public Commissioned(double commission, double baseSalary, List<Order> orders) {
		super();
		this.commission = commission;
		this.baseSalary = baseSalary;
		this.orders = orders;
	}

	public double getCommission() {
		return commission;
	}
	

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public double calcGrossPay(Month monthOfYear, int year) {
		LocalDate firstOfCurrentMonth = LocalDate.of(year, monthOfYear, 1);
		int totalOrders = 0;
		for(Order o: orders) {
			if(isPreviousMonth(firstOfCurrentMonth, o.getOrderDate())) {
				totalOrders += o.getOrderAmount();
			}
		}
		return baseSalary + commission * totalOrders;
	}
	
	private boolean isPreviousMonth(LocalDate current, LocalDate prev) {
		int currMonth = current.getMonthValue();
		int prevMonth = prev.getMonthValue();
		int currYear = current.getYear();
		int prevYear = prev.getYear();
		if((currMonth - prevMonth == 1 && currYear == prevYear) ||
				(currMonth == 1 && prevMonth == 12 && currYear - prevYear == 1)) {
			return true;
		}
		return false;
	}
}
