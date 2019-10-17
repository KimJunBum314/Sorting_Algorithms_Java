/**
 * General Heap Sort
 * uses a Max-Heap Order Array
 * 
 * @author Jun Kim, kim2674
 * @version 10/15/2019
 *
 * General Worse case O(Nlog(N))
 * General Max-Heap Order O(N)
 *
 */
public class Heap extends Sort {
	/**
	 * this class should not be instantiated
	 */
	private Heap() {}

	/**
	 * sort the array
	 * @param a - array
	 */
	public static void sort(Comparable[] a) {
		// Max-Heap Order O(N)
		MaxHeap(a);  // If Array already Max-Heap Order, take out this function

		// Actual Heap Sort Part
		int size = a.length;
		for (int i = 1; i < a.length; i++) {
			// Switch max with last entry of A
			exch(a, 0,a.length - i);
			size--;
			swimDown(a, 0, size);
		}

	}
	public static void MaxHeap(Comparable[] a) {
		// Convert array to Max-heap order Array
		for (int i = 1; i < a.length; i++) {
			if (less(a[(i-1)/2], a[i])) {
				swimUp(a, i);
			}
		}
	}
	private static void swimUp(Comparable[] a, int index) {
		// At the root area
		if ((index - 1) / 2 == 0) {
			if (less(a[(index-1)/2], a[index])) {
				exch(a, (index-1)/2, index);
			}
			// Somewhere else in Array
		} else {
			if (less(a[(index-1)/2], a[index])) {
				exch(a, (index-1)/2, index);
				swimUp(a, (index-1)/2);
			}
		}
	}
	private static void swimDown(Comparable[] a, int index, int size) {
		if ((2* index) + 1 < size && (2*index) + 2 < size) {
			if (less(a[(2* index) + 1], a[(2* index) + 2]) && less(a[(index)], a[(2* index)+ 2])) {
				exch(a, (index) , (2* index)+2);
				swimDown(a, (2* index) + 2, size);
			} else if (less(a[(2* index)+2], a[(2* index)+1]) && less(a[(index)], a[(2* index)+1])) {
				exch(a, (index), (2* index)+1);
				swimDown(a, (2* index)+1, size);
			} else if (equal(a[(2* index)+2], a[(2* index)+1]) && less(a[(index)], a[(2* index)+1])) {
				exch(a, (index), (2* index)+1);
				swimDown(a, (2* index)+1, size);
			}
		} else if ((2* index) + 1 < size) {
			if (less(a[(index)], a[(2* index)+1])) {
				exch(a, (index), (2* index)+1);
				swimDown(a, (index)+1, size);
			}
		} else if ((2*index) + 2 < size) {
			if (less(a[(index)], a[(2* index)+ 2])) {
				exch(a, (index) , (2* index)+2);
				swimDown(a, (index) + 2, size);
			}
		}
	}
}
