//# BEGIN SKELETON

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;

/**
 * Test cases for top-level methods in {@code MathStuff}.
 *
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="red"><b>Ligtenberg Wouter 0864271 15-02-2014</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MathStuffTestTopLevel {

    // Test cases for power(int, int).
    /**
     * Invokes power(a, b) and checks for expected result.
     *
     * @param a the base
     * @param b the exponent
     * @param expResult the expected result
     * @pre {@code 0 <= b && expResult = a ^ b}
     */
    private void checkPower(int a, int b, long expResult) {
        System.out.println("power(" + a + ", " + b + ")");
        long result = MathStuff.power(a, b);
        assertEquals("result", expResult, result);
    }

    /**
     * Smallest exponent.
     */
    @Test
    public void testPower0() {
        checkPower(0, 0, 1);
    }

    /**
     * Exponent 1.
     */
    @Test
    public void testPower1() {
        checkPower(2, 1, 2);
    }

    /**
     * Exponent 2.
     */
    @Test
    public void testPower2() {
        checkPower(3, 2, 9);
    }

    /**
     * Largest base and smallest exponent without overflow.
     */
    @Test(timeout = 100)
    public void testPowerSmallestNoOverflow() {
        int n = Integer.MAX_VALUE;
        checkPower(n, 1, n);
    }

    /**
     * Smallest base > 1 and largest exponent without overflow.
     */
    @Test(timeout = 100)
    public void testPowerLargestNoOverflow() {
        checkPower(2, 30, Integer.MAX_VALUE / 2 + 1);
    }

    /**
     * Largest base and smallest exponent > 1 with overflow.
     */
    @Test(timeout = 100)
    public void testPowerSmallestOverflow() {
        checkPower(46341, 2, Long.MAX_VALUE);
    }

    /**
     * Smallest base > 1 and smallest exponent with overflow.
     */
    @Test(timeout = 100)
    public void testPowerLargestOverflow() {
        checkPower(2, 31, Long.MAX_VALUE);
    }

    /**
     * Invokes {@code power(a, b)} and checks for expected exception.
     *
     * @param a base
     * @param b exponent
     * @param expected expected exception
     */
    private void checkPowerException(int a, int b, Class expected) {
        System.out.println("power(" + a + ", " + b + "), for exception");
        try {
            MathStuff.power(a, b);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Negative base, non-negative exponent.
     */
    @Test(timeout = 100)
    public void testPowerExceptionA() {
        checkPowerException(-1, 0, IllegalArgumentException.class);
    }

    /**
     * Negative exponent, non-negative base.
     */
    @Test(timeout = 100)
    public void testPowerExceptionB() {
        checkPowerException(0, -1, IllegalArgumentException.class);
    }

    // Test cases for power(Power)
    /**
     * Smoke test.
     */
    @Test
    public void testPowerPower() {
        System.out.println("power(new Power(3, 2))");
        MathStuff.Power p = new MathStuff.Power(3, 2);
        assertEquals("result", 3 * 3, MathStuff.power(p));
    }

    // Test cases for powerize(int)
    /**
     * Invokes powerize(power(expB, expE)) and checks for expected result.
     *
     *
     * @param expB expected base
     * @param expE expected exponent
     * @pre {@code expB} is not a power with exponent greater than one
     */
    private void checkPowerize(int expB, int expE) {
        long n = MathStuff.power(expB, expE);
        System.out.println("powerize(" + n + ")");
        MathStuff.Power result = MathStuff.powerize((int) n);
        assertEquals("power", n, MathStuff.power(result));
        assertEquals("base", expB, result.base);
        assertEquals("exponent", expE, result.exponent);
    }

//# BEGIN TODO Implementations of test cases for powerize(int)
    /**
     * Invokes {@code powerize(n)} and checks for expected exception.
     *
     * @pre {@code n } is smaller then 2 thus validating pre condition of powerize
     * @param n the integer with an illegal input
     * @param expected expected exception
     */
    public void checkPowerizeException(int n, Class expected) {
        System.out.println("powerize(" + n + "), for exception");
        try {
            MathStuff.powerize(n);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Tests a simple powerize function
     */
    @Test
    public void testSimpleFunction() {
        checkPowerize(2, 4);
    }

    /**
     * Tests powerize exception with input 1
     */
    @Test
    public void testPowerizeExceptionNegative() {
        checkPowerizeException(1, IllegalArgumentException.class);
    }

    /**
     * Tests function with large input on time 10 seconds
     */
    @Test(timeout = 10000)
    public void testLargeInputFunction() {
        checkPowerize(80, 2);
    }

    /**
     * Tests function with maximum integer input
     */
    @Test
    public void testPowerizeMax() {
        checkPowerize(Integer.MAX_VALUE, 1);
    }

//# END TODO
}
//# END SKELETON
