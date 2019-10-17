
/**
 * General Merge Sort
 * 
 * @author Jun Kim
 * @version 10/15/2019
 *
 * General worst case O(Nlog(N))
 * General space O(N)
 *
 *
 */
public class Merge extends Sort {
	/**
	 * this class should not be instantiated
	 */
	private Merge() {}

	/**
	 * sort the array
	 * @param a - array
	 */
	public static void sort(Comparable[] a) {
		int mid = (a.length)/2;

		divide(a, 0, mid);
		divide(a, mid, a.length);

		merge(a, 0, mid, a.length);
	}
	// Split an array into subarrays
	private static void divide(Comparable[] A, int low, int high) {
		int mid = (high + low)/2;

		if (high - low > 1) {
			divide(A, low, mid);
			divide(A, mid, high);

			merge(A, low, mid, high);
		}
	}
	// Merge two parts of the Array together
	private static void merge(Comparable[] A, int low, int mid, int high) {
		if (high - low == 2) {
			if (!less(A[low], A[low + 1])) {
				Comparable temp  = A[low];
				A[low] = A[low+1];
				A[low+1] = temp;
			}
		} else {
			Comparable[] temp1 = new Comparable[mid -low];
			for (int i = 0; i < mid - low; i++) {
				temp1[i] = A[low + i];
			}

			Comparable[] temp2 = new Comparable[high - mid];
			for (int i = 0; i < high - mid; i++) {
				temp2[i] = A[mid + i];
			}

			int tempC1 = 0;
			int tempC2 = 0;

			for (int i = low; i < high; i++) {
				if (tempC1 == temp1.length) {
					A[i] = temp2[tempC2];
					tempC2++;
				} else if (tempC2 == temp2.length) {
					A[i] = temp1[tempC1];
					tempC1++;
				} else if (tempC1 < temp1.length && less(temp1[tempC1], temp2[tempC2])) {
					A[i] = temp1[tempC1];
					tempC1++;
				} else if (tempC2 < temp2.length && !less(temp1[tempC1], temp2[tempC2])) {
					A[i] = temp2[tempC2];
					tempC2++;
				}  else if (equal(temp1[tempC1], temp2[tempC2]) && tempC1 <= tempC2) {
					A[i] = temp1[tempC1];
					tempC1++;
				} else {
					A[i] = temp2[tempC2];
					tempC2++;
				}
			}
		}


	}
}
