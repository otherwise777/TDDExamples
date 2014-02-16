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
 * <font color="red"><b>Replace this line</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MathStuffTestAuxiliary {

//# BEGIN TODO Test cases for auxiliary functions
    public void checkLineairSearchPowerize(int powerResult, int power, int expResult) {
        System.out.println("lineair search result " + powerResult + " = x^"
                + power + ". x would be" + expResult);
        long result = MathStuff.lineairSearchPowerize(powerResult, power);
        assertEquals("result", expResult, result);
    }

    /**
     * simple power.
     */
    @Test
    public void testPower() {
        checkLineairSearchPowerize(16, 4, 2);
    }

    @Test
    public void testPower2() {
        checkLineairSearchPowerize(3 * 3 * 3, 3, 3);
    }

    @Test
    public void testPowerZeroResult() {
        checkLineairSearchPowerize(28, 2, -1);
    }

    @Test
    public void testPowerHugeResult() {
        checkLineairSearchPowerize(9765625, 5, 25);
    }

    @Test
    public void testPowerHugeResul1t() {
        checkLineairSearchPowerize(Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
    }

    @Test
    public void testPowerHugeResult2() {
        checkLineairSearchPowerize(Integer.MAX_VALUE, 2, -1);
    }

    @Test
    public void testPowerHugeResult3() {
        checkLineairSearchPowerize(1024, 10, 2);
    }

    @Test
    public void testPowerHugeResultzero() {
        checkLineairSearchPowerize(1024, 10, 2);
    }

    @Test
    public void testPowerHugeResult4() {
        checkLineairSearchPowerize(1024, 10, 2);
    }

    @Test
    public void testPowerHugeResult5() {
        checkLineairSearchPowerize(1024, 10, 2);
    }
//# END TODO

}
//# END SKELETON
