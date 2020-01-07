package payroll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Hourly(10.0, 40);
		Paycheck paycheck = emp1.calcCompensation(LocalDate.now().getMonth(), LocalDate.now().getYear());
		emp1.print();
		paycheck.print();	
		
		Employee emp2 = new Salaried(2999);
		Paycheck paycheck2 = emp2.calcCompensation(LocalDate.now().getMonth(), LocalDate.now().getYear());
		emp2.print();
		paycheck2. print();
		
		List<Order> listOrder = new ArrayList<>();
		listOrder.add(new Order(1, LocalDate.now(), 1));
		listOrder.add(new Order(1, LocalDate.of(2019, 9, 18), 2));
		listOrder.add(new Order(1, LocalDate.of(2019, 9, 14), 3));
		listOrder.add(new Order(1, LocalDate.of(2019, 10, 3), 1));		
		
		Employee emp3 = new Commissioned(10, 1000,listOrder);
		emp3.print();
		Paycheck paycheck3 = emp3.calcCompensation(LocalDate.now().getMonth(), LocalDate.now().getYear());
		paycheck3.print();			
	}

}

/***Sample Output****
 * 
 * 	Employee id : 1424
 *	Payslip:
 * 	 Gross Pay: 1600.0
 *   Fica: 0.23
 * 	 State: 0.05
 *   Local: 0.01
 *	 Medicare: 0.03
 *	 SocialSecurity: 0.075
 *	 NET PAY: 968.0
 *
 *	Employee id : 1923
 *    Payslip:
 *	  Gross Pay: 2999.0
 * 	  Fica: 0.23
 * 	  State: 0.05
 * 	  Local: 0.01
 * 	  Medicare: 0.03
 * 	  SocialSecurity: 0.075
 * 	  NET PAY: 1814.3950000000004
 *
 *	Employee id : 1387
 *	  Payslip:
 * 	  Gross Pay: 1050.0
 * 	  Fica: 0.23
 * 	  State: 0.05
 *	  Local: 0.01
 *	  Medicare: 0.03
 *	  SocialSecurity: 0.075
 *	  NET PAY: 635.25
 * */

