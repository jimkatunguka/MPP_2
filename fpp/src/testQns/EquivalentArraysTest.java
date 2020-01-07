package testQns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquivalentArraysTest {

	@Test
	void test() {
		  	int[]a1 = {0, 1, 2};	            int[]a2 = {2, 0, 1}	;           //1 (because both arrays contain the values 0, 1, 2)
	        int[]b1 = {0, 1, 2, 1}; 	        int[]b2 = {2, 0, 1};	        //1 (because both arrays contain the values 0, 1, 2)
	        int[]c1 = {2, 0, 1};	            int[]c2 = {0, 1, 2, 1};	        //1 (because both arrays contain the values 0, 1, 2)
	        int[]d1 = {0, 5, 5, 5, 1, 2, 1};	int[]d2 = {5, 2, 0, 1};	        //1 (because both arrays contain the values 0, 1, 2, 5)
	        int[]e1= {5, 2, 0, 1};	            int[]e2 = {0, 5, 5, 5, 1, 2, 1};//1 (because both arrays contain the values 0, 1, 2, 5)
	        int[]f1= {0, 2, 1, 2};	            int[]f2 ={3, 1, 2, 0};	        //0 (the value 3 is not in the first array)
	        int[]g1 = {3, 1, 2, 0};	            int[]g2 = {0, 2, 1, 0};	        //0 (the value 3 is not in the second array)
	        int[]h1 = {1, 1, 1, 1, 1, 1};	    int[]h2 = {1, 1, 1, 1, 1, 2};	//0 (the value 2 is not in the first array)
	        int[]i1 = {};	                    int[]i2 = {3, 1, 1, 1, 1, 2};	//0 (3 is not in the first array.)
	        int[]j1 = {};                       int[]j2 = {};	                //1 (not possible to find a counterexample)

	        assertEquals(1, EquivalentArrays.equivalentArrays(a1,a2));
	        assertEquals(1, EquivalentArrays.equivalentArrays(b1,b2));
	        assertEquals(1, EquivalentArrays.equivalentArrays(c1,c2));
	        assertEquals(1, EquivalentArrays.equivalentArrays(d1,d2));

	        assertEquals(0, EquivalentArrays.equivalentArrays(f1,f2));
	        assertEquals(0, EquivalentArrays.equivalentArrays(g1,g2));
	        assertEquals(0, EquivalentArrays.equivalentArrays(h1,h2));
	        assertEquals(0, EquivalentArrays.equivalentArrays(i1,i2));

	        assertEquals(1, EquivalentArrays.equivalentArrays(j1,j2));
	    }
	}

