
/**
 * General Selection Sort
 * 
 * @author Jun Kim
 * @version 10/15/2019
 *
 * General Worse case runtime O(n^2)
 * 
 *
 */
public class Selection extends Sort {
	/**
	 * this class should not be instantiated
	 */
	private Selection() {}

	/**
	 * sort the array
	 * @param a - array
	 */
	public static void sort(Comparable[] a) {

		for (int i = 0; i < a.length; i++) {
			int place = i;
			Comparable min = a[i];
			
			// Look through the i+1 to N to find min
			for (int j = i+1; j < a.length; j++) {
				if (less(a[j], min)) {
					min = a[j];
					place = j;
				}
			}
			// Switch elements at the i  and j spot 
			exch(a, i, place);
		}

	}
}
