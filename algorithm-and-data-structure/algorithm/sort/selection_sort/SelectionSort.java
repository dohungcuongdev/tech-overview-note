package sort.selection_sort;

/**
 * Selection Sort: Complexity : O(n^2)
 * 
 * Worst-case performance	О(n^2) comparisons, О(n) swaps
 * Best-case performance	О(n^2) comparisons, О(n) swaps
 * Average performance	О(n^2) comparisons, О(n) swaps
 * Worst-case space complexity	O(1)

selection sort almost always outperforms bubble sort and gnome sort, 
but is generally outperformed by insertion sort

Selection sort performs a smaller number of swaps compared to bubble sort; 
therefore, even though both sorting methods are of O(N^2), 
selection sort performs faster and more efficiently!

 * Example
 * Given array: a = [5, 1, 6, 2, 3, 4]

set min = a[index]
Then find the minimum value in the array and swap to a[index]
increase the index by 1 and do the same for the remaining elements until array is sorted

 * a = [5, 1, 6, 2, 3, 4]
 * a = [1, 5, 6, 2, 3, 4] swap 5 and 1
 * a = [1, 2, 6, 5, 3, 4] swap 5 and 2
 * a = [1, 2, 3, 5, 6, 4] swap 6 and 3
 * a = [1, 2, 3, 4, 6, 5] swap 5 and 4
 * a = [1, 2, 3, 4, 5, 6] swap 6 and 5

*/

public class SelectionSort {

	public static void selectionSort(int[] a) {
		// One by one move boundary of unsorted subarray
		for(int i = 0; i < a.length - 1; i++) {
			
			// Find the minimum element in unsorted array
			int newMinIndex = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[newMinIndex]) {
					newMinIndex = j;
				}
			}
			
			// Swap the found minimum element with the current element
			int newMin = a[newMinIndex];
			a[newMinIndex] = a[i];
			a[i] = newMin;
		}
	}

	public static void main(String args[]) {
		int[] actual = { 5, 1, 6, 2, 3, 4 };

		selectionSort(actual);
		for (int i = 0; i < actual.length; i++)
			System.out.print(actual[i] + " ");
	}
}
