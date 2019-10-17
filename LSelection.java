
/**
 * Locality-Aware Selection Sort
 * 
 * @author Jun Kim, kim2674
 * @version 10/15/2019
 * @pso   P08
 */
public class LSelection extends Sort {
	/**
	 * this class should not be instantiated
	 */
	private LSelection() {}

	/**
	 * sort the array
	 * @param a - array
	 * @param d - locality
	 */
	public static void sort(Comparable[] a, int d) {
		for (int i = 0; i < a.length; i++) {
			int place = i;
			Comparable min = a[i];

			if (i + d < a.length) {
				for (int j = i+1; j <= i + d; j++) {
					if (less(a[j], min)) {
						min = a[j];
						place = j;
					}
				}
			} else {
				for (int j = i+1; j < a.length; j++) {
					if (less(a[j], min)) {
						min = a[j];
						place = j;
					}
				}
			}

			exch(a, i, place);
		}
	}
}
