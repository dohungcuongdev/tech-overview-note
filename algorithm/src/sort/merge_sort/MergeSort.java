package sort.merge_sort;

/** Merge Sort: 
 * Worst complexity: n*log(n)
 * Average complexity: n*log(n)
 * Best complexity: n*log(n)
 * Space complexity: n
 * 
This looks a reversed binary tree.

 a1,a2,         a3,a4,         a5,a6,          a7,a8     .... an-3,an-2,     an-1, an ] 
   \ /            \  /           \ /             \  /            \  /            \  /    
    a1'            a3'            a5'             a7'            an-3'           an-1'    
      \            /                \             /                 \             /
            a1''                          a5''                       an-3''
             \                             /                         /
                          a1'''                                     /
                           \
                                              a1''''
 
Let the input size be n.
Each a_n represents a list of elements. First line's a_n have only one element.
At each level, the sum of the merge cost on average is n (there exists corner cases which the cost is lower[1]). 
And the tree's height is log_2(n).
So, the time complexity of merge sort is O(n*log_2(n))
 * 
 * 
 * 
 * separate array into 2 arrays: left and right
 * then continue to separate until the sub arrays cannot be separated any more
 * merge left array and right of the arrays in ascending order
 * 
 * Example
 * Given array: a = [5, 1, 6, 2, 3, 4]

-> Array Left  = [5,1,6]
		-> Array Left  = [5]
		   Array Right = [1,6] 
				   -> Array Left  = [1] 
					  Array Right = [6]    
				   -> Merge Left and Right -> a = [1,6]
		-> Merge Left and Right -> a = [1, 5, 6]
						   
-> Array Right = [2,3,4]
		-> Array Left  = [2]
		   Array Right = [3,4] 
				   -> Array Left  = [3] 
					  Array Right = [4]    
				   -> Merge Left and Right -> a = [3,4]
	   -> Merge Left and Right -> a = [2, 3, 4]
			   
-> Merge Left and Right -> a = [1, 2, 3, 4, 5, 6]
*/


public class MergeSort {

	public static void mergeSort(int[] a) {
		/** separate array into 2 arrays: left and right
		 * the sub arrays then will also be separated into 2 smaller arrays
		 * until the number of element is 1
		 */
		if (a.length < 2)
			return;
		int mid = a.length / 2;
		
		/*initialize arrLeft and arrRight*/
		int[] arrLeft = new int[mid];
		int[] arrRight = new int[a.length - mid];
		for (int i = 0; i < arrLeft.length; i++) {
			arrLeft[i] = a[i];
		}
		for (int i = 0; i < arrRight.length; i++) {
			arrRight[i] = a[i + mid];
		}
		
		/*call recursive to merge sort 2 sub arrays*/
		mergeSort(arrLeft);
		mergeSort(arrRight);
		
		/*merge array left with array right in ascending order*/
		mergeArrLeftAndRight(a, arrLeft, arrRight);
	}

	public static void mergeArrLeftAndRight(int a[], int[] arrLeft, int[] arrRight) {
		/* before calling this function
		a = [1, 5, 6, 2, 3, 4] */
		int i = 0, j = 0, k = 0;
		while (i < arrLeft.length && j < arrRight.length) {
			if (arrLeft[i] <= arrRight[j]) {
				a[k++] = arrLeft[i++];
			} else {
				a[k++] = arrRight[j++];
			}
		}
		/*after the fist while
	 	a = [1, 2, 3, 4, 3, 4] 
	 	i = 1, j = 3, k = 4 */
		
		while (i < arrLeft.length) {
			a[k++] = arrLeft[i++];
		}

		while (j < arrRight.length) {
			a[k++] = arrRight[j++];
		}
		/*after calling this function
	 	a = [1, 2, 3, 4, 5, 6] */
	}

	public static void main(String[] args) {
		int[] actual = { 5, 1, 6, 2, 3, 4 };

		mergeSort(actual);
		for (int i = 0; i < actual.length; i++)
			System.out.print(actual[i] + " ");
	}

}
