
/**
 * Locality-Aware Heap Sort
 *
 * @author Jun Kim, kim2674
 * @version 10/15/2019
 * @pso   P08
 *
 */
public class LHeap extends Sort {
	/**
	 * this class should not be instantiated
	 */
	private LHeap() {}

	/**
	 * sort the array
	 * @param a - array
	 * @param d - locality
	 */
	public static void sort(Comparable[] a, int d) {
		// Max-Heap Order O(N)
		MaxHeap(a, d);

		// Actual Heap Sort Part
		int size = a.length;
		for (int i = 1; i < a.length; i++) {
			// Switch max with last entry of A
			exch(a, 0,a.length - i);
			size--;
			swimDown(a, 0, size);
		}

	}
	private static void MaxHeap(Comparable[] a, int d) {
		// Convert array to Max-heap order Array
		for (int i = 1; i < a.length; i++) {
			if (less(a[(i-1)/2], a[i])) {
				int count = 1;
				swimUp(a, i, count, d);
			}
		}
	}
	private static void swimUp(Comparable[] a, int index, int count, int d) {
		// At the root area
		if ((index - 1) / 2 == 0) {
			if (less(a[(index-1)/2], a[index])) {
				exch(a, (index-1)/2, index);
			}
			// Somewhere else in Array
		} else {
			if (less(a[(index-1)/2], a[index]) && count < d+1) {
				exch(a, (index-1)/2, index);
				count++;
				swimUp(a, (index-1)/2, count, d);
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