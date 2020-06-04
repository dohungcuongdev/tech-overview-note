package sort.insertion_sort;

/**
 * Insertion Sort: О(n^2)
 * 
 * Worst-case performance О(n^2) comparisons, О(n^2) swaps
 * Best-case performance	О(n) comparisons, О(1) swaps
 * Average performance	О(n^2) comparisons, О(n^2) swaps
 * Worst-case space complexity: O(1)
 * 
 * 
Insertion sort works by looking at each element in the array and moving it towards the beginning of the array until it's smaller than everything seen so far.

Insertion Sort and Bubble sort both have Worst Case O(N^2).

But if the array is mostly sorted Insertion Sort will perform better.

Insertion sort is often used with Quick sort: In Quick Sort after some level of recursion (When array is mostly sorted) Insertion sort is used.

Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.

 * Example
 * Given array: a = [5, 1, 6, 2, 3, 4]

step     array              condition     index      action                       swap index       array after action
0        5 1 6 2 3 4                      0
1        1 5 6 2 3 4        1 < 5: true   1          not swap anything            				   1 5 6 2 3 4
2        1 5 6 2 3 4        5 < 6: true   2          not swap anything            				   1 5 6 2 3 4
3        1 5 6 2 3 4        6 < 2: false  3          swap index 3 with index 2    2				   1 5 2 6 3 4
4        1 5 2 6 3 4        5 < 2: false  3          swap index 2 with index 1    1                1 2 5 6 3 4
5        1 2 5 6 3 4        1 < 2: true   3          not swap anything                             1 2 5 6 3 4
6        1 2 5 6 3 4        6 < 3: false  4          swap index 4 with index 3    3                1 2 5 3 6 4
7        1 2 5 3 6 4        5 < 3: false  4          swap index 3 with index 2    2                1 2 3 5 6 4
8        1 2 3 5 6 4        2 < 3: true   4          not swap anything                             1 2 3 5 6 4
9        1 2 3 5 6 4        6 < 4: false  5          swap index 5 with index 4    4                1 2 3 5 4 6
10       1 2 3 5 4 6        5 < 4: false  4          swap index 4 with index 3    3                1 2 3 4 5 6
11       1 2 3 4 5 6        3 < 4: true   4          not swap anything                             1 2 3 4 5 6
 
*/

public class InsertionSort {

	public static void insertionSort(int[] a) {
		
		// j is the key position, we need to move the elements from the left of the key to fit this position
		for (int j = 1; j < a.length; j++) {
			int key = a[j];
			int i = j - 1;
			
			/*all the elements in the sorted area will be move to the right one step if key is smaller than their values*/
			while((i > -1) && (key < a[i])) {
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;
		}
	}

	public static void main(String args[]) {
		int[] actual = { 5, 1, 6, 2, 3, 4 };

		insertionSort(actual);
		for (int i = 0; i < actual.length; i++)
			System.out.print(actual[i] + " ");
	}
}
