package sort.insertion_sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestInsertionSort {

	@Test
	public void positiveTest() {
	    int[] actual = { 5, 1, 6, 2, 3, 4 };
	    int[] expected = { 1, 2, 3, 4, 5, 6 };
	    InsertionSort.insertionSort(actual);
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	public void positiveTest2() {
	    int[] actual = new int[10000];
	    int[] expected = new int[10000];
	    for(int i = 0; i < 10000; i++) {
	    	actual[i] = 10000-i-1;
	    	expected[i] = i;
	    }
	    InsertionSort.insertionSort(actual);
	    assertArrayEquals(expected, actual);
	}
	
	/*// this test case is running too slow
	@Test
	public void positiveTest2() {
	    int[] actual = new int[1000000];
	    int[] expected = new int[1000000];
	    for(int i = 0; i < 1000000; i++) {
	    	actual[i] = 1000000-i-1;
	    	expected[i] = i;
	    }
	    InsertionSort.insertionSort(actual);
	    assertArrayEquals(expected, actual);
	}*/

}
