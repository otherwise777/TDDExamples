import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test cases for search method, of class TDDForSearchMethod.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class TDDForSearchMethodTest {
    
    /** Subject Under Test.  Only static members are used. */
    private static final TDDForSearchMethod SUT = null;
    
    public TDDForSearchMethodTest() {
    }

    /**
     * Test of search method, of class TDDForSearchMethod.
     * Boundary case: empty array
     */
    @Test
    public void empty() {
        int[] a = { };
        int x = 5; // avoid 0, -1
        int result = SUT.search(a, x);
        assertTrue("result < 0", result < 0);
    }
    
    /**
     * Test of search method, of class TDDForSearchMethod.
     * Boundary case: singleton array containing searched valued.
     */
    @Test
    public void singleton() {
        int[] a = new int[1];
        int x = 5; // avoid 0, -1
        int expResult = 0;
        a[expResult] = x;
        int result = SUT.search(a, x);
        assertEquals("result", expResult, result);
    }
    
    /**
     * Test of search method, of class TDDForSearchMethod.
     * Boundary case: two different elements, a[0] == x
     */
    @Test
    public void twoDifferentElements0() {
        // array with two elements, where x occurs at index 0
        int[] a = new int[2];
        int x = 5; // avoid 0, 1, and -1
        int expResult = 0;
        a[expResult] = x;
        a[1] = x + 2; 
        int result = SUT.search(a, x);
        assertEquals("result", expResult, result);
    }
    
    /**
     * Test of search method, of class TDDForSearchMethod.
     * Boundary case: two different elements, a[1] == x
     */
    @Test
    public void twoDifferentElements1() {
        // array with two elements, where x occurs at index 1
        int[] a = new int[2];
        int x = 5; // avoid 0, 1, and -1
        int expResult = 1;
        a[0] = x - 2; 
        a[expResult] = x;
        int result = SUT.search(a, x);
        assertEquals("result", expResult, result);
    }
    
    /**
     * Test of search method, of class TDDForSearchMethod.
     * Boundary case: two equal elements, a[0] == a[1] == x
     */
    @Test
    public void twoEqualElements() {
        int[] a = new int[2];
        int x = 5; // avoid 0, 1, and -1
        int expResult = 1;
        a[0] = x - 1; 
        a[expResult] = x;
        int result = SUT.search(a, x);
        assertTrue("result is proper index", 0 <= result && result < a.length);
        assertTrue("x occurs at result", a[result] == x);
    }
    
    /**
     * Prints an integer array.
     * 
     * @param a  the array to print
     */
    private void print(int[] a) {
        if (a == null) {
            System.out.print("null");
            return;
        }
        // a != null
        System.out.print("{");
        String separator = " ";
        for (int i = 0; i != a.length; ++ i) {
            System.out.print(separator + a[i]);
            separator = ", ";
        }
        System.out.print(" }");
    }
    
    /**
     * Invokes {@code search(a, x)} and checks result.
     * 
     * @param a  sorted array to search in
     * @param x  value to search for
     * @param present  whether {@code x} occurs in {@code a}
     * @pre {@code a != null && present == (\exists i; a.has(i); a[i] == x)}
     */
    public void checkSearch(int[] a, int x, boolean present) {
        System.out.print("checkSearch(");
        print(a);
        System.out.println(", " + x + ")");
        int[] old_a = a.clone();
        int result = SUT.search(a, x);
        assertEquals("found", present, 0 <= result);
        if (0 <= result) {
            assertTrue("x occurs at result", a[result] == x);
        }
        // check that a was not modified
        assertArrayEquals("not modified", old_a, a);
    }

    /**
     * Tests search method, of class TDDForSearchMethod, with specified comb,
     * consisting of odd values 1 through 2n-1 (length n),
     * searching for all values 0 through 2n.
     * 
     * Brian W. Kernighan, Rob Pike.
     * The Practice of Programming.
     * Addison-Wesley, 1999.
     * 
     * @param n  length of comb
     * @pre {@code 0 <= n}
     */
    private void comb(int n) {
        // initialize array a with comb of length n
        int[] a = new int[n];
        for (int i = 0; i != a.length; ++ i) {
            a[i] = 2 * i + 1;
        }
        // search all values 0 through 2n
        for (int x = 0; x <= 2 * n; ++ x) {
            checkSearch(a, x, x % 2 != 0);
        }
    }
        
    /**
     * Test of search method, of class TDDForSearchMethod.
     * Uses combs of lengths 0 through 5.
     * This includes all preceding boundary cases
     * with different elements.
     */
    @Test
    public void smallCombs() {
        for (int n = 0; n <= 5; ++ n) {
            comb(n);
        }
    }
        
    /**
     * Test of search method, of class TDDForSearchMethod.
     * Uses combs of lengths 31 through 33,
     * surrounding 2^5.
     */
    @Test
    public void largerCombs() {
        for (int n = 31; n <= 33; ++ n) {
            comb(n);
        }
    }
        
    /**
     * Test of search method, of class TDDForSearchMethod.
     * Boundary case: null array.
     */
    @Test(expected = NullPointerException.class)
    public void nullArray() {
        SUT.search(null, 0);
    }
    
}
