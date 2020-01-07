package standardone;

import java.util.List;
import java.util.stream.Collectors;
public class Admin {
		public static List<Student> obtainHonorRoll(List<Student> list) {
			//implement
			return
			list.stream()
			.filter(l->l.getGpa() > 3.0)
			.filter(l->l.getMajor().equals(Majors.CS))
			.collect(Collectors.toList());
		}
		
}
