//# BEGIN SKELETON

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for auxiliary methods in {@code MathStuff}.
 *
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="red"><b>Ligtenberg Wouter 0864271 15-02-2014</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MathStuffTestAuxiliary {

//# BEGIN TODO Test cases for auxiliary functions
    /**
     * Checks BinarySearchPowerize function with a result and the expected
     * output the functions checks for power result = x^power where it tries to
     * find the x, the expected result should be the same as x for the test to
     * pass
     *
     * @param powerResult the base thats being searched for
     * @param power the exponent of the function
     * @param expResult the expected result
     */
    public void checkBinarySearchPowerize(int powerResult, int power, int expResult) {
        System.out.println("lineair search result " + powerResult + " = x^"
                + power + ". x would be" + expResult);
        long result = MathStuff.binarySearchPowerize(powerResult, power);
        assertEquals("result", expResult, result);
    }

    /**
     * simple power function
     */
    @Test
    public void testBinarySearchPowerize() {
        checkBinarySearchPowerize(16, 4, 2);
    }

    /**
     * Test function with power 3
     */
    @Test
    public void BinarySearchPowerizePower3() {
        checkBinarySearchPowerize(3 * 3 * 3, 3, 3);
    }

    /**
     * Test function with a non existing base
     */
    @Test
    public void testPowerZeroResult() {
        checkBinarySearchPowerize(28, 2, -1);
    }

    /**
     * Test function with a huge result
     *
     */
    @Test
    public void testPowerHugeResult() {
        checkBinarySearchPowerize(9765625, 5, 25);
    }

    /**
     * Test function with the max integer value
     */
    @Test
    public void testPowerHugeResul1t() {
        checkBinarySearchPowerize(Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
    }

    /**
     * Test function with a huger result outside of the integer value
     *
     */
    @Test
    public void testPowerHugeResult2() {
        checkBinarySearchPowerize(Integer.MAX_VALUE, 2, -1);
    }

//# END TODO
}
//# END SKELETON
