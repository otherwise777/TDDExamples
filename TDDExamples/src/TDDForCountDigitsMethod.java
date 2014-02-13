/**
 * Illustrates Test-Driven Development of a single method.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class TDDForCountDigitsMethod {

    /** Development phase. */
    private static final int PHASE = 4;

    /**
     * Counts the decimal digits of a number.
     * This concerns a non-negative integer, assumed to be
     * written in decimal notation without leading zeroes.
     *
     * @param n  the number whose digits are counted
     * @return  the number of decimal digits in {@code n}
     * @pre {@code 0 <= n}
     * @post {@code \result = (\min int k; 1 <= k; n < 10 ^ k)}
     */
    public static int countDigits(long n) {
if (PHASE == 1) {
        return 0; // to make it compile
} else if (PHASE == 2) { // easy to verify, but with risk of overflow
        // Linear Search for smallest k >= 1 with n < 10 ^ k
        int k = 1;
        long p = 10L;
        // invariant: 1 <= k && p == 10 ^ k
        while (! (n < p)) {
            p *= 10;
            ++ k;
        }
        // n < p == 10 ^ k
        return k;
} else if (PHASE == 3) { // attempt to avoid overflow; defective
        int result = 1;
        while (n != 0) {
            n /= 10;
            ++ result;
        }
        return result;
} else { // if (PHASE == 4) { // attempt to avoid overflow; fixed
        int result = 1;
        while (10 <= n) {
            n /= 10;
            ++ result;
        }
        return result;
}
    }

}
