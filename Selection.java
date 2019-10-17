
/**
 * General Selection Sort
 * 
 *
 * 
 * @author Jun Kim, kim2674
 * @version 10/15/2019
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

			for (int j = i+1; j < a.length; j++) {
				if (less(a[j], min)) {
					min = a[j];
					place = j;
				}
			}
			exch(a, i, place);
		}

	}
}
