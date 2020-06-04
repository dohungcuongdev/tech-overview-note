package search.linear_search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLinearSearch {

	@Test
	public void positiveTest() {
	    int[] arr = { 5, 1, 6, 2, 3, 4 };
	    int key = 6;
	    int foundIndex = LinearSearch.linearSearch(arr, key);
	    assertEquals(foundIndex, 2);
	}
	
	@Test
	public void positiveTest2() {
	    int[] arr = new int[10000000];
	    int expected = -1;
	    for(int i = 0; i < 10000000; i++) {
	    	arr[i] = i;
	    	if(arr[i] == 9999995) {
	    		expected = i;
	    	}
	    }
	    int key = 9999995;
	    int foundIndex = LinearSearch.linearSearch(arr, key);
	    assertEquals(foundIndex, expected);
	}
	
	@Test
	public void positiveTest3() {
	    int[] arr = new int[10000000];
	    for(int i = 0; i < 10000000; i++) {
	    	arr[i] = i;
	    }
	    int key = 100000001;
	    int foundIndex = LinearSearch.linearSearch(arr, key);
	    assertEquals(foundIndex, -1);
	}

}
