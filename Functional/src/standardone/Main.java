package standardone;

import java.util.List;
import java.util.ArrayList;

public class Main {
	 //test data
		public static void main(String[] args) {
			@SuppressWarnings("serial")
			List<Student> list = new ArrayList<Student>() {
				{
					add(new Student("Joe", 3.2, Majors.CS));
					add(new Student("Tom", 3.5, Majors.CH));
					add(new Student("HeLing", 2.9, Majors.CS));
					add(new Student("Pierre", 2.8, Majors.ENG));
					add(new Student("Ihaku", 3.9, Majors.CS));
					add(new Student("Richard", 2.8, Majors.CS));
					add(new Student("Jim", 3.2, Majors.CS));
				}
			};
			//System.out.println(Admin.obtainHonorRoll(list));
			System.out.println(Lambda.DEPT_GPAHONORVALUE_SORTED.apply(list, Majors.CS, 3.0));
			System.out.println(Lambda.DEPT_GPAHONORVALUE.apply(list, Majors.ENG, 2.5));
			

		}

}
