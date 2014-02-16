//# BEGIN SKELETON

import java.util.ArrayList;
import java.util.List;

/**
 * Library with static mathematical functions.
 *
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="red"><b>Ligtenberg Wouter 0864271 15-02-2014</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public abstract class MathStuff {

    /**
     * Returns exponentiation, taking care of overflow.
     *
     * @param a the base
     * @param b the exponent
     * @pre {@code 0 <= a && 0 <= b}
     * @return {@code a ^ b} if {@code a ^ b <= Integer.MAX_VALUE} else
     * {@code Long.MAX_VALUE}
     * @throws IllegalArgumentException if precondition violated
     */
    public static long power(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("power: negative argument");
        }
        // 0 <= a && 0 <= b
        long x = a; // see invariant
        int k = b; // see invariant
        long result = 1L; // see invariant

        // invariant: 0 <= k <= b && result * x^k == a^b
        while (k != 0) {
            if (k % 2 == 0) { // even exponent
                if (x <= Integer.MAX_VALUE) {
                    x *= x;
                } else {
                    x = Long.MAX_VALUE;
                }
                k /= 2;
            } else { // odd exponent
                if (result <= Integer.MAX_VALUE && x <= Integer.MAX_VALUE) {
                    result *= x;
                } else {
                    result = Long.MAX_VALUE;
                }
                k -= 1;
            }
            // invariant holds again, k has decreased
        }
        // k == 0, hence result == a^b

        if (result > Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return result;
    }

    /**
     * Record containing a base and an exponent.
     *
     * @inv {@code 0 <= base && 0 <= exponent}
     */
    public static class Power { // BEGIN RECORD TYPE

        /**
         * The base.
         */
        public int base;

        /**
         * The exponent.
         */
        public int exponent;

        /**
         * Constructs a Power with given base and exponent.
         *
         * @param base the base
         * @param exponent the exponent
         * @pre {@code 0 <= base && 0 <= exponent}
         * @post {@code \result.base == base && \result.exponent == exponent}
         */
        public Power(int base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }

    } // END RECORD TYPE

    /**
     * Returns exponentiation.
     *
     * @param p the base and exponent
     * @pre {@code p != null}
     *
     * @return {@code power(p.base, p.exponent)}
     * @throws IllegalArgumentException if precondition violated
     */
    public static long power(Power p) throws IllegalArgumentException {
        return power(p.base, p.exponent);
    }

    /**
     * Writes a number as a power with maximal exponent.
     *
     * @param n the number to 'powerize'
     * @return power decomposition of {@code n} with maximal exponent
     * @throws IllegalArgumentException if precondition violated
     * @pre {@code 2 <= n}
     * @post {@code n == power(\result) &&
     *     (\forall int b, int e;
     *      2 <= b && 1 <= e && n == b ^ e;
     *      e <= \result.exponent)}
     */
    public static Power powerize(int n) throws IllegalArgumentException {
//# BEGIN TODO Implementation of powerize
        //class result = Power
        if (n < 2) {
            //throw an IllegalArgumentException because it does not require the
            //pre conditions
            throw new IllegalArgumentException("powerize: input smaller then 2");
        }
        Power result = new Power(0, 0); //initialize variable
        //loops through all the exponents to find the base
        for (int i = 1; i <= 30; i++) {
            int expresult = binarySearchPowerize(n, i); //sets exponentresult
            if (expresult > 0) {
                //if the expresult is larger then zero it means it found a base
                result = new Power(expresult, i); //sets reult to the new 
                //exponent and base
            }
        }
        return result;
//# END TODO

    }

//# BEGIN TODO Contracts and implementations of auxiliary functions.
    /**
     * tries to find an x so that x^i == n it does this by a binary search
     * method
     *
     * @pre {@code result > 0 && exponent > 0}
     * @param n the expected result of {@code power(x,exponent) }
     * @param exponent the exponent used in the search
     * @return the base of exponent {@code exponent} and result {@code n} if no
     * such result exists returns -1
     * @modifies None
     * @post {@code result == (/while low <= high, mid = (high - low)/2,
     * powerresult = power(mid,exponent), when powerresult == n, return mid,
     * else if powerresult > n high = mid - 1, else if powerresult < n low = mid + 1
     */
    public static int binarySearchPowerize(int n, int exponent) {
        long powerResult; //initialize variable
        int low = 0; //initialize variable
        int high = n; //initialize variable
        while (low <= high) {
            int mid = low + (high - low) / 2; //sets the mid value of high and low
            powerResult = power(mid, exponent); //sets powerresult to mid^exponent
            if (powerResult == n) {
                return mid; //returns mid because it is valid
            } else if (powerResult > n) {
                high = mid - 1; //lower the highest bound of binary search
            } else if (powerResult < n) {
                low = mid + 1; //ups the lower bound of binary search
            }
        } //end of while
        return -1; //returns -1 because no valid integer was found
    }
//# END TODO
}
//# END SKELETON
