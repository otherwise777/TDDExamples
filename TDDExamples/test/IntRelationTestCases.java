import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test cases for IntRelation, to be extended to obtain
 * concrete test cases for an extension of IntRelation.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public abstract class IntRelationTestCases {
    
    /** Test fixture. */
    protected IntRelation instance;
    
    /**
     * Sets instance to a newly constructed relation of given extent.
     * 
     * @param n   extent
     */
    protected abstract void setInstance(final int n);
    
    /** Tests the constructor with small values. */
    @Test
    public void testConstructor() {
        System.out.println("constructor(int)");
        for (int n = 0; n <= 3; ++ n) {
            setInstance(n);
            assertTrue("isRepOk()", instance.isRepOk());
        }
    }
    
    /** Tests the extent method with small relations. */
    @Test
    public void testExtent() {
        System.out.println("extent");
        for (int n = 0; n <= 3; ++ n) {
            setInstance(n);
            assertEquals("size", n, instance.extent());
            assertTrue("isRepOk()", instance.isRepOk());
        }
    }
    
    /**
     * Invokes areRelated(a, b) and checks the result.
     * 
     * @param a  first element in pair
     * @param b  second element in pair
     * @param expResult  expected result
     */
    private void checkAreRelated(int a, int b, boolean expResult) {
        boolean result = instance.areRelated(a, b);
        assertEquals("areRelated(" + a + ", " + b + ")", expResult, result);
        assertTrue("isRepOk()", instance.isRepOk());
    }
    
    /** Tests the areRelated method on empty relation. */
    @Test
    public void testAreRelated() {
        System.out.println("areRelated");
        setInstance(1);
        checkAreRelated(0, 0, false);
        setInstance(2);
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }
    
    /** Tests the add method. */
    @Test
    public void testAdd() {
        System.out.println("add");
        setInstance(2);
        instance.add(0, 1); // N.B. not a pair of equals
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        checkAreRelated(0, 0, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
        instance.add(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        checkAreRelated(0, 0, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }
    
    /** Tests the remove method. */
    @Test
    public void testRemove() {
        System.out.println("remove");
        setInstance(2);
        instance.remove(0, 1); // N.B. not a pair of equals
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
        instance.add(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        instance.remove(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }
    
}
