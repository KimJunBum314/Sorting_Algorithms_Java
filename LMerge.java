
/**
 * Locality-Aware Merge Sort
 * 
 * @author Jun Kim, kim2674
 * @version 10/15/2019
 * @pso   P08
 *
 */
public class LMerge extends Sort {
	/**
	 * this class should not be instantiated
	 */
	private LMerge() {}

	/**
	 * sort the array
	 * @param a - array
	 * @param d - locality
	 */
	public static void sort(Comparable[] a, int d) {
		int mid = (a.length)/2;

		divide(a, 0, mid, d);
		divide(a, mid, a.length, d);

		merge(a, 0, mid, a.length, d);
	}
	private static void divide(Comparable[] A, int low, int high, int d) {
		int mid = (high + low)/2;

		if (high - low > 1) {
			divide(A, low, mid, d);
			divide(A, mid, high, d);

			merge(A, low, mid, high, d);
		}
	}
	private static void merge(Comparable[] A, int low, int mid, int high, int d) {
		if (high - low == 2) {
			if (!less(A[low], A[low + 1])) {
				Comparable temp  = A[low];
				A[low] = A[low+1];
				A[low+1] = temp;
			}
		} else {
			if (2* d > high - 1 - low) {
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
			} else {
				Comparable[] temp1 = new Comparable[d];
				for (int i = 0; i < d; i++) {
					temp1[i] = A[mid - d + i];
				}

				Comparable[] temp2 = new Comparable[d];
				for (int i = 0; i < d; i++) {
					temp2[i] = A[mid + i];
				}

				int tempC1 = 0;
				int tempC2 = 0;

				for (int i = mid - d; i < mid + d; i++) {
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
					} else if (equal(temp1[tempC1], temp2[tempC2]) && tempC1 <= tempC2) {
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
}
