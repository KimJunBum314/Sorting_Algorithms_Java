/**
 * General Quick Sort
 *
 * 
 * @author Jun Kim, kim2674
 * @version 10/15/2019
 * @pso   P08
 *
 */
public class Quick extends Sort {
	/**
	 * this class should not be instantiated
	 */
	private Quick() {}

	/**
	 * sort the array
	 * @param a - array
	 */
	public static void sort(Comparable[] a) {
		divide(a, 0, a.length);
	}
	private static void divide(Comparable[] A, int low, int high) {
		// initialize variables
		Comparable X = A[high-1];
		int switchNum = low -1;


		for (int j = low; j < high; j++) {
			if (less(A[j], X)) {
				switchNum++;

				Comparable swapTemp = A[switchNum];
				A[switchNum] = A[j];
				A[j] = swapTemp;
			} else {
				// Do nothing
			}
		}
		int midpoint = switchNum +1;

		Comparable swapTemp = A[midpoint];
		A[midpoint] = A[high-1];
		A[high-1] = swapTemp;


		if (high-1 - (midpoint) > 1) {
			divide(A, midpoint + 1, high);
		}
		if (switchNum +1 - low > 1) {
			divide(A, low, midpoint);
		}

	}
}