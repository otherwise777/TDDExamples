/**
 * Illustrates Test-Driven Development of a single method.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class TDDForSearchMethod {

    /** Development phase. */
    private static final int PHASE = 6;

    /**
     * Searches for an occurrence of an integer in an array,
     * given that the array is sorted in ascending order.
     * Returns an occurrence index, if the integer is present;
     * otherwise, returns a negative integer.
     *
     * @param a  sorted array to search in
     * @param x  value to search for
     * @return index where {@code x} occurs in {@code a},
     *   if {@code x} is present; otherwise, a negative integer
     * @pre {@code a != null
     *     && (\forall int i, j; 0 <= i < j < a.length; a[i] <= a[j])}
     * @modifies None
     * @post {@code (0 <= \result < a.length && a[\result] == x)
     *     || (\result < 0 && (\forall i; a.has(i); a[i] != x))}
     */
    public static int search(int[] a, int x) {
if (PHASE == 1) {
        return -1; // to make it compile
} else if (PHASE == 2) {
        return a.length - 1; // empty and singleton test cases pass
} else if (PHASE == 3) {
        if (a.length == 0) {
            return -1; // to make empty test case pass
        } else {
            a[0] = x;
            return 0; // attempt to make non-empty test cases pass
        }
} else if (PHASE == 4) {
        // Linear Search
        int result = 0;
        while (a[result] != x) {
            ++ result;
        }
        return result;
} else if (PHASE == 5) {
        // Bounded Linear Search
        for (int result = 0; result != a.length; ++ result) {
            if (a[result] == x) {
                return result;
            }
        }
        return -1;
} else { // if (PHASE == 6) {
        // Binary Search
        int result = -1;
        int high = a.length;
        while (result + 1 != high) {
            int mid = (result + high) / 2;
            if (a[mid] <= x) {
                result = mid;
            } else { // x < a[mid]
                high = mid;
            }
        }
        if (0 <= result && a[result] == x) {
            return result;
        } else {
            return -1;
        }
}
    }

}
