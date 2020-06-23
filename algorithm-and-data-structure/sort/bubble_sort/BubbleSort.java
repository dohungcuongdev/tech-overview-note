package sort.bubble_sort;

/** Bubble Sort: О(n^2)
 * 
 * Worst-case performance О(n^2) comparisons, О(n^2) swaps
 * Best-case performance	О(n) comparisons, О(1) swaps
 * Average performance	О(n^2) comparisons, О(n^2) swaps
 * Worst-case space complexity: O(1)
 * 
 * compare all elements with their next elements
 * if the next element is smaller then swap the position
*/


public class BubbleSort {
	
	public static void bubbleSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[i]) {
					//swap elements
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	/**
	 * Worst complexity: O(N^2)
	 * Best complexity: O(N)
	 * The best case for Bubble Sort Occurs when the given array is sorted array. 
	 * Now if the array is already sorted, then swapped==false at the end of the first pass. So when this condition is met, we break out of the loop
	 */
	public static void bubbleSortForBestCase(int[] a) {
		for(int i = 0; i < a.length; i++) {
			boolean swapped = false;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[i]) {
					//swap elements
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					swapped = true;
				}
			}
			// IF no two elements were  
            // swapped by inner loop, then break 
            if (!swapped) 
                break; 
		}
	}
	
	public static void main(String args[]) {
		int[] actual = { 5, 1, 6, 2, 3, 4 };

		bubbleSort(actual);
		for (int i = 0; i < actual.length; i++)
			System.out.print(actual[i] + " ");
	}
}
