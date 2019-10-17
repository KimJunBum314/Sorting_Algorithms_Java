/**
 * Provides library functions for sorting, and
 * contains the main method to drive all the code using CLI arguments
 * 
 * @version 2019-10-10
 */

public class Sort {

	public static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
	
	/**
	 * 
	 * @param v
	 * @param w
	 * @return true if v is equal to w
	 */
	public static boolean equal(Comparable v, Comparable w) {
        return (v.compareTo(w) == 0);
    }
	
	/**
	 * 
	 * @param a
	 * @return true if array a is in sorted order
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length-1; i++) {
			if (less(a[i+1],a[i]))
				return false;
		}
		return true;
	}
	
	/**
	 * print array to standard output<br>
	 * identify out of order elements
	 * @param a
	 */
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
        	if (i > 0 && less(a[i],a[i-1]))
        		StdOut.println(a[i] + " <-- X");
        	else if (i < a.length-1 && less(a[i+1],a[i]))
        		StdOut.println(a[i] + " <-- X");
        	else
        		StdOut.println(a[i]);
        }
    }
	
	/**
	 * swap a[i] with a[j]
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(Object[] a, int i, int j) {
		Object tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	

}
