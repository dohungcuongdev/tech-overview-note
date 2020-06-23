package search.linear_search;

/** Linear Search: 
 * Worst complexity: O(n)
 * Average complexity: O(n)
 * Space complexity: O(1)
 * Worst-case space complexity: O(1) iterative
 * 
 * Can search array unordered
 * check all elements if key value return index else return -1
 * 
*/


public class LinearSearch {
	
	public static int linearSearch(int a[], int key) {
		// compare key with all elements
		for(int i = 0; i < a.length; i++) {
			if(a[i] == key)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[]) {
	    int[] arr = { 5, 1, 6, 2, 3, 4 };
	    int key = 6;
	    int foundIndex = linearSearch(arr, key);
	    System.out.println(foundIndex);
	}
	
	
}
