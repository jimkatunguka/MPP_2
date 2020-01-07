package testQns;

public class MaxMinEqual {
	static int maxMinEqual(int[] a) {
	    if(a.length <= 1) return 0;

	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    int maxCount = 0, minCount = 0;

	    for(int i = 0; i < a.length; i++) {
	      if(a[i] == min)
	        minCount++;
	      else if(a[i] < min) {
	        min = a[i];
	        minCount = 1;
	      }
	      if(a[i] == max)
	        maxCount++;
	      else if(a[i] > max) {
	        max = a[i];
	        maxCount = 1;
	      }
	    }
	    if(max == min || maxCount != minCount)
	      return 0;
	    return 1;
	  }
	
	public static void main(String[]args) {
		int[]a = {1,0,1,2,2,2,1,1,3,1};
		int[]b = {2,4,6,8,11};
		System.out.println(maxMinEqual(b));
	}
}
