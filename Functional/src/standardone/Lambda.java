package standardone;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Lambda {
	static TriFunction<List<Student>,String,Double, List<Student>> DEPT_GPAHONORVALUE = (list, major, gpa) ->
	list.stream()
	.filter(l-> l.getGpa() > gpa)
	.filter(l->l.getMajor().equals(major))
	.collect(Collectors.toList());
	
	static TriFunction<List<Student>,String,Double, List<Student>> DEPT_GPAHONORVALUE_SORTED = (list, major, gpa) ->
	list.stream()
	.filter(l-> l.getGpa() > gpa)
	.filter(l->l.getMajor().equals(major))
	.sorted(Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName))
	.collect(Collectors.toList());

}
