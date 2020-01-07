package testQns;

import java.util.HashSet;
import java.util.Set;

public class EquivalentArrays {
	public static int equivalentArrays(int[] a1, int[] a2) {
		/*
		 The solution
		 1. Create two sets, add each of the array elements of a1 and a2 into sets 1 and 2 respectively.
		 2. The above step removes any duplicates
		 3. Test if any of the contents in set1 is contained in set2 by attempting to add elements of set1 into set2
		 4. Test if any of the contents in set2 is contained in set1 by attempting to add elements of set2 into set1
		 
		 Note that a set does not accept duplicate elements.
		 */
// 1.
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
//2.
        for (int element : a1) {
            set1.add(element);
        }

        for (int element : a2) {
            set2.add(element);
        }
//3. returns 0 if there are values of set1 not in set 2
        for (Integer value : set1) {
            if (set2.add(value)) return 0;
        }
        
//4. returns 0 if there are values of set2 not in set 1
        for (Integer value : set2) {
            if (set1.add(value)) return 0;
        }

        return 1;
    }

}
