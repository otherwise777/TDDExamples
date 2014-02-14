//# BEGIN SKELETON

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for functional decomposition in {@code KeyCollectionDecomposed}.
 * test cases for the KeyCollectionDecomposed
 *
 * @author Wouter Ligtenberg
 * @since 07-02-2014
 * <!--//# BEGIN TODO: Name, id, and date-->
 * <p>
 * <font color="red"><b>Ligtenberg Wouter 0864271 07-02-2014</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KeyCollectionDecomposedTest extends AbstractKeyCollectionTestCases {

    public KeyCollectionDecomposedTest() {
    }

    private KeyCollectionDecomposed instance;

    @Before
    public void setUp() {
        instance = new KeyCollectionDecomposed();
    }

    /**
     * Invokes isSecure(keys) and checks result against expResult. Prints a line
     * to console with the test message.
     *
     * @param msg message
     * @param expResult expected result
     */
    private void checkKeys(String msg, boolean expResult) {
        System.out.println(msg);
        boolean result = instance.isSecure(keys);
        assertEquals(msg, expResult, result);
    }

    // 2 the same keys = false
    @Test
    public void wrongKeysLow() {
        // inputs a set of keys with a key that crosses the lower bound of the key
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1, 0}},
            new int[][]{new int[]{1}, new int[]{1, 1}}
        };
        checkKeys("one key out of border lower bound", false);
    }

    @Test
    public void wrongKeysSameKeys() {
        // inputs a set of keys where both keys are the same
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1, 1}},
            new int[][]{new int[]{1}, new int[]{1, 1}}
        };
        checkKeys("2 identical keys", false);
    }

    @Test
    public void wrongKeysOneRow() {
        // inputs a set of keys with a key that has one row
        keys = new int[][][]{
            new int[][]{new int[]{1}},
            new int[][]{new int[]{1}, new int[]{1, 1}}
        };
        checkKeys("one key with 1 row", false);
    }

    @Test
    public void wrongKeysThreeRows() {
        // inputs a set of keys where one of the keys has 3 rows
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1, 6}, new int[]{1, 6}},
            new int[][]{new int[]{1}, new int[]{1, 1}}
        };
        checkKeys("one key with 3 rows", false);
    }

    @Test
    public void wrongKeysUp() {
        // inputs a set of keys with key that crosses the upper bound of the key
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1, 6}},
            new int[][]{new int[]{1}, new int[]{1, 1}}
        };
        checkKeys("One key out of border upper bound", false);
    }

    @Test
    public void oneWrongKeys() {
        // inputs 3 keys where one of them is insecure
        keys = new int[][][]{
            new int[][]{new int[]{1, 7, 8}, new int[]{1, 3}},
            new int[][]{new int[]{1, 7, 8}, new int[]{2, 1}},
            new int[][]{new int[]{1, 7, 8}, new int[]{1, 1}}
        };
        checkKeys("One invalid key", false);
    }

    @Test
    @Override
    public void noKeys() {
        // Secure boundary case: no keys
        keys = new int[][][]{};
        checkKeys("No keys", true);
    }

    @Test
    @Override
    public void singletonKeys() {
        // Secure boundary case: one minimal key
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1}}};
        checkKeys("One minimal key", true);
    }

    @Test
    @Override
    public void twoInconvertibleKeysRow0() {
        // Secure boundary case: two inconvertable keys, due to 1st row lengths
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1}},
            new int[][]{new int[]{1, 1}, new int[]{1}}
        };
        checkKeys("Two inconvertable keys, first row lengths differ", true);
    }

    @Test
    @Override
    public void twoInconvertibleKeysRow1() {
        // Secure boundary case: two inconvertable keys, due to 2nd row lengths
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1}},
            new int[][]{new int[]{1}, new int[]{1, 1}}
        };
        checkKeys("Two inconvertable keys, second row lengths differ", true);
    }

    @Test
    @Override
    public void twoInconvertibleKeysSameRowLengths() {
        // Secure boundary case: two inconvertable keys, same row lengths
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{2}},
            new int[][]{new int[]{2}, new int[]{1}}
        };
        checkKeys("Two inconvertable keys, same row lengths", true);
    }

    @Test
    @Override
    public void twoConvertibleKeysRow0() {
        // Insecure boundary case: two convertable keys, diff in first row
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1}},
            new int[][]{new int[]{2}, new int[]{1}}
        };
        checkKeys("Two convertable keys, first row", false);
    }

    @Test
    @Override
    public void twoConvertibleKeysRow1() {
        // Insecure boundary case: two convertable keys, diff in second row
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{1}},
            new int[][]{new int[]{1}, new int[]{2}}
        };
        checkKeys("Two convertable keys, second row", false);
    }

    @Test
    @Override
    public void twoConvertibleKeysRow0Rev() {
        // Insecure boundary case: two convertable keys, diff in first row
        // reversed order
        keys = new int[][][]{
            new int[][]{new int[]{2}, new int[]{1}},
            new int[][]{new int[]{1}, new int[]{1}}
        };
        checkKeys("Two convertable keys, reversed order, first row", false);
    }

    @Test
    @Override
    public void twoConvertibleKeysRow1Rev() {
        // Insecure boundary case: two convertable keys, diff in second row
        // reversed order
        keys = new int[][][]{
            new int[][]{new int[]{1}, new int[]{2}},
            new int[][]{new int[]{1}, new int[]{1}}
        };
        checkKeys("Two convertable keys, reversed order, second row", false);
    }
//# BEGIN TODO: Test cases for auxiliary methods
    protected int[][] key1;
    protected int[][] key2;

    protected int[] row1;
    protected int[] row2;

    private void checkRowsConvertible(String msg, boolean expResult) {
        System.out.println(msg);
        boolean result = instance.isRowKeyConvertable(row1, row2);
        assertEquals(msg, expResult, result);
    }

    private void checkKeysConvertible(String msg, boolean expResult) {
        System.out.println(msg);
        boolean result = instance.isKeyConvertable(key1, key2);
        assertEquals(msg, expResult, result);
    }

    @Test
    public void twoconvertablerows() {
        key1 = new int[][]{new int[]{1}, new int[]{2}};
        key2 = new int[][]{new int[]{1}, new int[]{1}};
        checkKeysConvertible("key1 can not be converted into key2", true);
    }

    @Test
    public void twoNotConvertableRows() {
        key1 = new int[][]{new int[]{1}, new int[]{1}};
        key2 = new int[][]{new int[]{1}, new int[]{2}};
        checkKeysConvertible("key1 can be converted into key2", false);
    }

    @Test
    public void twoDifferentLengthRows() {
        key1 = new int[][]{new int[]{1}, new int[]{1}};
        key2 = new int[][]{new int[]{1}, new int[]{1, 1}};
        checkKeysConvertible("key1 is shorter key2", false);
    }

    @Test
    public void twoEmptyRows() {
        key1 = new int[][]{new int[]{}, new int[]{}};
        key2 = new int[][]{new int[]{}, new int[]{}};
        checkKeysConvertible("key1 and key2 are empty", true);
    }

    @Test
    public void inconvertibleRows0() {
        row1 = new int[]{1};
        row2 = new int[]{1, 1};
        checkRowsConvertible("Two inconvertable rows, lengths differ",
                false);
    }

    @Test
    public void inconvertibleRows1() {
        row1 = new int[]{2};
        row2 = new int[]{1};
        checkRowsConvertible("Two inconvertable rows, indent depth differs",
                true);
    }

    @Test
    public void convertibleRows0() {
        row1 = new int[]{};
        row2 = new int[]{};
        checkRowsConvertible("Two convertable rows, empty rows",
                true);
    }

    @Test
    public void convertibleRows1() {
        row1 = new int[]{1};
        row2 = new int[]{1};
        checkRowsConvertible("Two convertable rows, non-empty rows, same values",
                true);
    }
//# END TODO
}
//# END SKELETON
