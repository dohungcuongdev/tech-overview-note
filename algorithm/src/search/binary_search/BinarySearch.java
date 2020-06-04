package search.binary_search;

/** Binary Search: 
 * Worst complexity: O(log n)
 * Average complexity: O(log n)
 * Best complexity: O(1)
 * Space complexity: O(1)
 * Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.

Example 

array: 1, 2, 3, 4, 5, 6, 7 
key: 3

begin=0
end=a.length-1=6
mid=(end+begin)/2=6/2=3 -> a[3] = 4 > 3 -> ignore the right from 4 to 7 -> only check from the left
continue do the same but now end=mid-1=2, begin still be 0  -> mid=(end+begin)/2=1 -> a[1] = 2 < 3 -> ignore the left from 1 to 2, only check from the right
continue do the same but now begin=mid+1=1+1=2, end still be 2 -> mid=(end+begin)/2=4/2=2 -> a[2] = 3 == key -> return mid = 2
**/
	
public class BinarySearch {

	public static int binarySearch(int a[], int key) {
		return binarySearch(a, 0, a.length - 1, key);
	}

	public static int binarySearch(int a[], int begin, int end, int key) {
		// after calling all the recursions, if end < begin means no key found
		if (end >= begin) {
			// declare middle point to know where the left and right array index start and end
			int mid = (end + begin) / 2;
			if (key < a[mid]) {
				// search key from the left array
				return binarySearch(a, begin, mid - 1, key);
			} else if (key == a[mid]) {
				 // if the array contains key then eventually index of the key will be the middle
				return mid;
			} else {
				// search key from the right array
				return binarySearch(a, mid + 1, end, key);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int key = 3;
		int foundIndex = binarySearch(arr, key);
		System.out.println(foundIndex);
	}

}
